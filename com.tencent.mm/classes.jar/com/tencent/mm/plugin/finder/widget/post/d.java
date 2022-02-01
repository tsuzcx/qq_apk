package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.ui.post.PostMainUIC;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.r;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "postType", "", "(Landroid/content/Context;I)V", "extraMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "halfImgFileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "halfRectList", "Landroid/graphics/Rect;", "halfThumbFileList", "imgFileList", "imgQualityList", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "reprintIv", "Landroid/view/View;", "rootView", "thumbFileList", "thumbIv", "Landroid/widget/ImageView;", "checkData", "", "checkFileExist", "delMedia", "", "getPicCount", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  private static final String TAG = "Finder.PostImageWidget";
  private static final String wCI = "image_file_list";
  private static final String wCJ = "image_quality_list";
  private static final String wCK = "image_thumb_list";
  private static final String wCL = "half_image_file_list";
  public static final a wCM;
  private View lJI;
  private azk musicInfo;
  private View wCA;
  public ArrayList<String> wCB;
  private ArrayList<Integer> wCC;
  private ArrayList<String> wCD;
  private clp wCE;
  private ArrayList<String> wCF;
  private ArrayList<String> wCG;
  private int wCH;
  private ArrayList<Rect> wCy;
  private ImageView wCz;
  
  static
  {
    AppMethodBeat.i(168598);
    wCM = new a((byte)0);
    wCI = "image_file_list";
    wCJ = "image_quality_list";
    wCK = "image_thumb_list";
    wCL = "half_image_file_list";
    TAG = "Finder.PostImageWidget";
    AppMethodBeat.o(168598);
  }
  
  private d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168597);
    this.wCH = 2;
    this.wCD = new ArrayList();
    this.wCG = new ArrayList();
    AppMethodBeat.o(168597);
  }
  
  public final boolean cyn()
  {
    AppMethodBeat.i(256119);
    Object localObject1 = this.wCB;
    if (localObject1 != null)
    {
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!s.YS((String)localObject1)))
        {
          localObject2 = f.wDt;
          Log.i(f.access$getTAG$cp(), "image widget file:" + (String)localObject1 + " lost!");
          AppMethodBeat.o(256119);
          return false;
        }
      }
    }
    AppMethodBeat.o(256119);
    return true;
  }
  
  public final void dIX()
  {
    AppMethodBeat.i(256120);
    this.wCB = null;
    this.wCC = null;
    this.wCD.clear();
    this.wCE = null;
    this.musicInfo = null;
    this.wCF = null;
    this.wCG.clear();
    this.wCy = null;
    AppMethodBeat.o(256120);
  }
  
  public final View dJg()
  {
    AppMethodBeat.i(168594);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168594);
      throw ((Throwable)localObject);
    }
    this.lJI = ((Activity)localObject).getLayoutInflater().inflate(2131494572, null);
    localObject = this.lJI;
    if (localObject == null) {
      p.hyc();
    }
    this.wCz = ((ImageView)((View)localObject).findViewById(2131309076));
    localObject = this.lJI;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((View)localObject).findViewById(2131306958);
    p.g(localObject, "rootView!!.findViewById(R.id.reprint_iv)");
    this.wCA = ((View)localObject);
    localObject = this.lJI;
    AppMethodBeat.o(168594);
    return localObject;
  }
  
  public final g dJh()
  {
    Object localObject3 = null;
    int j = 0;
    AppMethodBeat.i(256118);
    if ((this.vTz != null) && (this.wCb != null))
    {
      localObject1 = new g(true, 2, this.wCb);
      AppMethodBeat.o(256118);
      return localObject1;
    }
    Object localObject1 = (Collection)this.wCB;
    int i;
    Object localObject2;
    Object localObject4;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label321;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("img list ");
      localObject4 = this.wCB;
      if (localObject4 == null) {
        p.hyc();
      }
      Log.i((String)localObject1, ((ArrayList)localObject4).size() + ", thumb list " + this.wCD.size());
      localObject1 = this.wCB;
      if (localObject1 == null) {
        p.hyc();
      }
      if (((ArrayList)localObject1).size() != this.wCD.size()) {
        break label316;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject4 = new cjk();
        Object localObject6;
        if (this.wCH == 7)
        {
          localObject1 = this.wCB;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = ((Iterable)localObject1).iterator();
          i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              j.hxH();
            }
            localObject2 = (String)localObject2;
            localObject5 = ((cjk)localObject4).mediaList;
            localObject6 = com.tencent.mm.plugin.finder.upload.i.vSX;
            localObject6 = this.wCD.get(i);
            p.g(localObject6, "thumbFileList[index]");
            ((LinkedList)localObject5).add(com.tencent.mm.plugin.finder.upload.i.hc((String)localObject2, (String)localObject6));
            i += 1;
          }
          i = 0;
          break;
          label316:
          i = 0;
          continue;
          label321:
          Log.i(TAG, "img list null");
          i = 0;
          continue;
        }
        localObject1 = this.wCB;
        if (localObject1 == null) {
          p.hyc();
        }
        Object localObject5 = ((Iterable)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = ((Iterator)localObject5).next();
          if (i < 0) {
            j.hxH();
          }
          localObject1 = (String)localObject1;
          localObject6 = ((cjk)localObject4).mediaList;
          localObject2 = com.tencent.mm.plugin.finder.upload.i.vSX;
          localObject2 = this.wCD.get(i);
          p.g(localObject2, "thumbFileList[index]");
          cjl localcjl = com.tencent.mm.plugin.finder.upload.i.hb((String)localObject1, (String)localObject2);
          localObject1 = new ayg();
          localObject2 = this.wCC;
          if (localObject2 != null)
          {
            localObject2 = (Integer)j.L((List)localObject2, i);
            if (localObject2 != null)
            {
              int k = ((Number)localObject2).intValue();
              ((ayg)localObject1).LIx = k;
              Log.i(TAG, "codec_info hdimg_score:".concat(String.valueOf(k)));
            }
          }
          localcjl.codec_info = ((ayg)localObject1);
          localObject1 = this.wCF;
          label541:
          String str;
          if (localObject1 != null)
          {
            localObject1 = (String)j.L((List)localObject1, i);
            str = (String)j.L((List)this.wCG, i);
            localObject2 = this.wCy;
            if (localObject2 == null) {
              break label749;
            }
          }
          label749:
          for (localObject2 = (Rect)j.L((List)localObject2, i);; localObject2 = null)
          {
            if ((localObject1 != null) && (str != null) && (localObject2 != null))
            {
              car localcar = new car();
              localcar.xve = ((String)localObject1);
              y localy = y.vXH;
              localObject1 = y.awm((String)localObject1);
              localcar.width = ((Point)localObject1).x;
              localcar.height = ((Point)localObject1).y;
              localcar.thumbUrl = str;
              localcjl.MoX = localcar;
              localcjl.thumbUrl = str;
              localObject1 = new aty();
              ((aty)localObject1).left = ((Rect)localObject2).left;
              ((aty)localObject1).top = ((Rect)localObject2).top;
              ((aty)localObject1).right = ((Rect)localObject2).right;
              ((aty)localObject1).bottom = ((Rect)localObject2).bottom;
              localcjl.MoU = ((aty)localObject1);
            }
            ((LinkedList)localObject6).add(localcjl);
            i += 1;
            break;
            localObject1 = null;
            break label541;
          }
        }
        localObject1 = this.dQL;
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_ID");
          ((cjk)localObject4).vMX = ((String)localObject1);
          localObject1 = this.dQL;
          if (localObject1 == null) {
            break label977;
          }
          localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_PATH");
          label804:
          ((cjk)localObject4).vMV = ((String)localObject1);
          localObject2 = this.dQL;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((Bundle)localObject2).getString("ORIGIN_BGM_URL");
          }
          ((cjk)localObject4).MoK = ((String)localObject1);
          localObject1 = this.dQL;
          if (localObject1 == null) {
            break label983;
          }
          bool = ((Bundle)localObject1).getBoolean("MEDIA_IS_MUTE", false);
          label865:
          ((cjk)localObject4).wCu = bool;
          localObject1 = this.dQL;
          if (localObject1 == null) {
            break label989;
          }
        }
        label977:
        label983:
        label989:
        for (boolean bool = ((Bundle)localObject1).getBoolean("MUSIC_IS_MUTE", false);; bool = false)
        {
          ((cjk)localObject4).wCv = bool;
          localObject1 = this.dQL;
          i = j;
          if (localObject1 != null) {
            i = ((Bundle)localObject1).getInt("SOUND_TRACK_TYPE", 0);
          }
          ((cjk)localObject4).soundTrackType = i;
          ((cjk)localObject4).MoJ = this.musicInfo;
          if (this.wCH != 7) {
            break label995;
          }
          localObject1 = new g(true, 7, (cjk)localObject4);
          AppMethodBeat.o(256118);
          return localObject1;
          localObject1 = null;
          break;
          localObject1 = null;
          break label804;
          bool = false;
          break label865;
        }
        label995:
        localObject1 = new g(true, 2, (cjk)localObject4);
        AppMethodBeat.o(256118);
        return localObject1;
      }
    }
    localObject1 = new g(false, 0, null);
    AppMethodBeat.o(256118);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject5 = null;
    AppMethodBeat.i(168596);
    super.refresh();
    Object localObject4;
    Object localObject6;
    if (this.wCb != null)
    {
      localObject1 = this.wCb;
      if (localObject1 == null) {
        p.hyc();
      }
      if (!Util.isNullOrNil((List)((cjk)localObject1).mediaList))
      {
        localObject1 = this.wCA;
        if (localObject1 == null) {
          p.btv("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.wCb;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((cjk)localObject1).mediaList;
        p.g(localObject1, "refFeedContent!!.mediaList");
        localObject4 = (cjl)((LinkedList)localObject1).getFirst();
        localObject1 = y.vXH;
        localObject1 = y.go((int)((cjl)localObject4).width, (int)((cjl)localObject4).height);
        localObject5 = this.wCz;
        if (localObject5 == null) {
          p.hyc();
        }
        ((ImageView)localObject5).getLayoutParams().width = ((Number)((r)localObject1).second).intValue();
        localObject5 = this.wCz;
        if (localObject5 == null) {
          p.hyc();
        }
        ((ImageView)localObject5).getLayoutParams().height = ((Number)((r)localObject1).SWY).intValue();
        localObject5 = this.wCz;
        if (localObject5 == null) {
          p.hyc();
        }
        ((ImageView)localObject5).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject1.first).intValue()]);
        localObject1 = this.wCz;
        if (localObject1 == null) {
          p.hyc();
        }
        ((ImageView)localObject1).requestLayout();
        localObject5 = TAG;
        localObject6 = new StringBuilder("refresh mediaObj?.thumbUrl: ");
        if (localObject4 != null) {}
        for (localObject1 = ((cjl)localObject4).thumbUrl;; localObject1 = null)
        {
          Log.i((String)localObject5, (String)localObject1);
          p.g(localObject4, "mediaObj");
          localObject1 = new k((cjl)localObject4, com.tencent.mm.plugin.finder.storage.x.vEo, null, null, 12);
          localObject4 = m.uJa;
          localObject4 = m.djY();
          localObject5 = this.wCz;
          if (localObject5 == null) {
            p.hyc();
          }
          localObject6 = m.uJa;
          ((com.tencent.mm.loader.d)localObject4).a(localObject1, (ImageView)localObject5, m.a(m.a.uJb));
          localObject1 = this.wCz;
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = this.wCz;
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
          AppMethodBeat.o(168596);
          return;
        }
      }
    }
    Object localObject1 = this.dQL;
    if (localObject1 != null) {
      localObject1 = ((Bundle)localObject1).getStringArrayList(wCI);
    }
    for (;;)
    {
      this.wCB = ((ArrayList)localObject1);
      localObject1 = this.dQL;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getIntegerArrayList(wCJ);
        label426:
        this.wCC = ((ArrayList)localObject1);
        localObject1 = this.dQL;
        if (localObject1 != null)
        {
          localObject4 = ((Bundle)localObject1).getByteArray("MEDIA_EXTRA_MUSIC");
          if (localObject4 != null) {
            localObject1 = (com.tencent.mm.bw.a)new clp();
          }
        }
      }
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
        this.wCE = ((clp)localObject1);
        localObject4 = TAG;
        localObject6 = new StringBuilder("post image with music: ");
        localObject1 = this.wCE;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((clp)localObject1).MqO);
          Log.i((String)localObject4, localObject1);
          localObject1 = com.tencent.mm.plugin.finder.upload.i.vSX;
          this.musicInfo = com.tencent.mm.plugin.finder.upload.i.a(this.wCE);
          localObject1 = this.dQL;
          if (localObject1 != null)
          {
            localObject4 = ((Bundle)localObject1).getByteArray("ORIGIN_MUSIC_INFO");
            if (localObject4 != null) {
              localObject1 = (com.tencent.mm.bw.a)new azk();
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
            this.musicInfo = ((azk)localObject1);
            localObject1 = this.dQL;
            if (localObject1 == null) {
              break label1005;
            }
            localObject1 = ((Bundle)localObject1).getStringArrayList(wCL);
            this.wCF = ((ArrayList)localObject1);
            localObject1 = this.dQL;
            if (localObject1 == null) {
              break label1010;
            }
            localObject1 = ((Bundle)localObject1).getParcelableArrayList("HALF_RECT_LIST");
            this.wCy = ((ArrayList)localObject1);
            if (this.musicInfo == null)
            {
              localObject1 = this.dQL;
              if (localObject1 == null) {
                break label1015;
              }
              localObject1 = ((Bundle)localObject1).getString("ORIGIN_BGM_URL");
              localObject4 = this.dQL;
              if (localObject4 == null) {
                break label1020;
              }
              localObject4 = ((Bundle)localObject4).getString("ORIGIN_MUSIC_PATH");
              localObject6 = (CharSequence)localObject1;
              if ((localObject6 != null) && (((CharSequence)localObject6).length() != 0)) {
                break label1025;
              }
              i = 1;
              if (i != 0) {
                localObject1 = q.k((String)localObject4, true);
              }
              localObject4 = (CharSequence)localObject1;
              if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
                break label1030;
              }
              i = 1;
              if (i == 0)
              {
                localObject4 = new azk();
                ((azk)localObject4).LJi = ((String)localObject1);
                this.musicInfo = ((azk)localObject4);
              }
            }
            localObject1 = this.wCB;
            if (localObject1 == null) {
              break label1035;
            }
            localObject1 = (String)j.kt((List)localObject1);
            a.wCj = (String)localObject1;
            localObject1 = this.dQL;
            if (localObject1 == null) {
              break label1040;
            }
            localObject1 = ((Bundle)localObject1).getStringArrayList(wCK);
            if (this.wCB != null)
            {
              localObject4 = this.wCB;
              if (localObject4 == null) {
                p.hyc();
              }
              if (((ArrayList)localObject4).size() > 0) {
                h.RTc.b((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Image_Thumb");
              }
            }
            localObject1 = this.lJI;
            if (localObject1 == null) {
              p.hyc();
            }
            localObject6 = (ImageIndicatorView)((View)localObject1).findViewById(2131302571);
            if (localObject6 != null) {
              ((ImageIndicatorView)localObject6).setVisibility(0);
            }
            localObject1 = this.wCB;
            if (localObject1 != null)
            {
              if (((ArrayList)localObject1).size() <= 0) {
                break label1045;
              }
              i = 1;
              if (i == 0) {
                break label1050;
              }
              if (localObject1 != null)
              {
                localObject4 = localObject5;
                if (localObject6 != null)
                {
                  ((ImageIndicatorView)localObject6).aan(((ArrayList)localObject1).size());
                  localObject4 = kotlin.x.SXb;
                }
                if (localObject4 != null) {
                  break label937;
                }
              }
            }
            if (localObject6 != null) {
              ((ImageIndicatorView)localObject6).setVisibility(8);
            }
            localObject1 = kotlin.x.SXb;
            label937:
            AppMethodBeat.o(168596);
            return;
            localObject1 = null;
            break;
            localObject1 = null;
            break label426;
            localException1 = localException1;
            Log.printDebugStack("safeParser", "", new Object[] { localException1 });
            localObject2 = null;
          }
          Object localObject2 = null;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException2 });
            Object localObject3 = null;
            continue;
            label1005:
            localObject3 = null;
            continue;
            label1010:
            localObject3 = null;
            continue;
            label1015:
            localObject3 = null;
            continue;
            label1020:
            localObject4 = null;
            continue;
            label1025:
            int i = 0;
            continue;
            label1030:
            i = 0;
            continue;
            label1035:
            localObject3 = null;
            continue;
            label1040:
            localObject3 = null;
            continue;
            label1045:
            i = 0;
            continue;
            label1050:
            localObject3 = null;
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget$Companion;", "", "()V", "HALF_IMAGE_FILE_LIST", "", "getHALF_IMAGE_FILE_LIST", "()Ljava/lang/String;", "IMAGE_FILE_LIST", "getIMAGE_FILE_LIST", "IMAGE_QUALITY_LIST", "getIMAGE_QUALITY_LIST", "IMAGE_THUMB_LIST", "getIMAGE_THUMB_LIST", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168590);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      d.a(this.wCN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168590);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(256117);
      Object localObject1 = d.b(this.wCN);
      if (localObject1 == null) {
        p.hyc();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      final int i = 0;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (i < 0) {
          j.hxH();
        }
        localObject1 = (String)localObject1;
        final boolean bool;
        if (i == 0)
        {
          bool = true;
          label69:
          if ((this.wCO == null) || (this.wCO.size() <= i) || (Util.isNullOrNil((String)this.wCO.get(i)))) {
            break label263;
          }
        }
        for (localObject1 = (String)this.wCO.get(i);; localObject1 = com.tencent.mm.plugin.finder.upload.f.avU((String)localObject1))
        {
          Object localObject2 = new z.f();
          ((z.f)localObject2).SYG = null;
          Object localObject3 = d.c(this.wCN);
          Object localObject4;
          if (localObject3 != null)
          {
            localObject3 = (String)j.L((List)localObject3, i);
            if (localObject3 != null)
            {
              localObject4 = com.tencent.mm.plugin.finder.upload.f.vSz;
              ((z.f)localObject2).SYG = com.tencent.mm.plugin.finder.upload.f.avU((String)localObject3);
            }
          }
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject3 = new z.f();
            ((z.f)localObject3).SYG = BitmapUtil.decodeFile((String)localObject1);
            localObject4 = BitmapUtil.decodeFile((String)((z.f)localObject2).SYG);
            if ((Bitmap)((z.f)localObject3).SYG != null) {
              MMHandlerThread.postToMainThread((Runnable)new a((String)localObject1, (z.f)localObject2, (Bitmap)localObject4, (z.f)localObject3, i, bool, this));
            }
          }
          i += 1;
          break;
          bool = false;
          break label69;
          label263:
          localObject2 = com.tencent.mm.plugin.finder.upload.f.vSz;
        }
      }
      AppMethodBeat.o(256117);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$5$1$2$1", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$5$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(String paramString, z.f paramf1, Bitmap paramBitmap, z.f paramf2, int paramInt, boolean paramBoolean, d.c paramc) {}
      
      public final void run()
      {
        Object localObject4 = null;
        AppMethodBeat.i(256116);
        d.d(jdField_this.wCN).add(this.wCP);
        Object localObject2;
        if (((String)this.wCQ.SYG != null) && (this.wCR != null))
        {
          localObject1 = d.e(jdField_this.wCN);
          localObject2 = (String)this.wCQ.SYG;
          if (localObject2 == null) {
            p.hyc();
          }
          ((ArrayList)localObject1).add(localObject2);
          this.wCS.SYG = this.wCR;
        }
        Object localObject1 = d.wCM;
        Log.i(d.access$getTAG$cp(), "add thumb file, index:" + i);
        r localr;
        LinearLayout localLinearLayout;
        label399:
        label411:
        Object localObject3;
        if (bool)
        {
          localObject1 = y.vXH;
          localObject1 = (Bitmap)this.wCS.SYG;
          p.g(localObject1, "thumb");
          int i = ((Bitmap)localObject1).getWidth();
          localObject1 = (Bitmap)this.wCS.SYG;
          p.g(localObject1, "thumb");
          localr = y.go(i, ((Bitmap)localObject1).getHeight());
          i = ((Number)localr.second).intValue();
          int j = ((Number)localr.SWY).intValue();
          localObject1 = d.f(jdField_this.wCN);
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).getLayoutParams().width = i;
          localObject1 = d.f(jdField_this.wCN);
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).getLayoutParams().height = j;
          localObject1 = d.g(jdField_this.wCN);
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = ((View)localObject1).findViewById(2131302571);
          p.g(localObject1, "rootView!!.findViewById<…ew>(R.id.image_indicator)");
          ((ImageIndicatorView)localObject1).getLayoutParams().width = i;
          localObject1 = d.g(jdField_this.wCN);
          if (localObject1 == null) {
            break label834;
          }
          localObject1 = ((View)localObject1).getParent();
          localObject2 = localObject1;
          if (!(localObject1 instanceof LinearLayout)) {
            localObject2 = null;
          }
          localLinearLayout = (LinearLayout)localObject2;
          if (localLinearLayout == null) {
            break label840;
          }
          localObject1 = localLinearLayout.getRootView();
          if (localObject1 == null) {
            break label840;
          }
          localObject2 = (TextView)((View)localObject1).findViewById(2131306075);
          if (localLinearLayout == null) {
            break label846;
          }
          localObject1 = localLinearLayout.getLayoutParams();
          localObject3 = localObject1;
          if (!(localObject1 instanceof FrameLayout.LayoutParams)) {
            localObject3 = null;
          }
          localObject3 = (FrameLayout.LayoutParams)localObject3;
          localObject1 = (Bitmap)this.wCS.SYG;
          p.g(localObject1, "thumb");
          if (((Bitmap)localObject1).getWidth() <= 0) {
            break label852;
          }
          localObject1 = (Bitmap)this.wCS.SYG;
          p.g(localObject1, "thumb");
          if (((Bitmap)localObject1).getHeight() <= 0) {
            break label852;
          }
          localObject1 = y.vXH;
          localObject1 = (Bitmap)this.wCS.SYG;
          p.g(localObject1, "thumb");
          float f = ((Bitmap)localObject1).getHeight();
          localObject1 = (Bitmap)this.wCS.SYG;
          p.g(localObject1, "thumb");
          if (!y.bk(f / ((Bitmap)localObject1).getWidth())) {
            break label852;
          }
          if (localObject3 != null) {
            ((FrameLayout.LayoutParams)localObject3).topMargin = 0;
          }
          if (localObject2 != null)
          {
            localObject1 = MMApplicationContext.getContext();
            p.g(localObject1, "MMApplicationContext.getContext()");
            ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131099844));
          }
          localObject1 = d.g(jdField_this.wCN);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).findViewById(2131302298);
            if (localObject1 != null)
            {
              ((View)localObject1).setVisibility(0);
              localObject2 = ((View)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = i;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
        }
        for (;;)
        {
          if (localLinearLayout != null) {
            localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          }
          localObject1 = d.f(jdField_this.wCN);
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localr.first).intValue()]);
          localObject1 = d.f(jdField_this.wCN);
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).requestLayout();
          localObject1 = d.f(jdField_this.wCN);
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).setImageBitmap((Bitmap)this.wCS.SYG);
          localObject1 = d.f(jdField_this.wCN);
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = d.f(jdField_this.wCN);
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(256115);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$5$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              paramAnonymousView = y.vXH;
              if (y.isAnyEnableFullScreenEnjoy())
              {
                paramAnonymousView = com.tencent.mm.ui.component.a.PRN;
                ((PostMainUIC)com.tencent.mm.ui.component.a.ko(this.wCV.wCU.wCN.context).get(PostMainUIC.class)).dAN();
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$5$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(256115);
                return;
                d.a(this.wCV.wCU.wCN);
              }
            }
          });
          AppMethodBeat.o(256116);
          return;
          label834:
          localObject1 = null;
          break;
          label840:
          localObject2 = null;
          break label399;
          label846:
          localObject1 = null;
          break label411;
          label852:
          if (localObject2 != null)
          {
            localObject1 = MMApplicationContext.getContext();
            p.g(localObject1, "MMApplicationContext.getContext()");
            ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131100904));
          }
          if (localObject3 != null)
          {
            localObject2 = d.g(jdField_this.wCN);
            localObject1 = localObject4;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getResources();
              localObject1 = localObject4;
              if (localObject2 != null) {
                localObject1 = Integer.valueOf((int)((Resources)localObject2).getDimension(2131165304));
              }
            }
            ((FrameLayout.LayoutParams)localObject3).topMargin = ((Integer)localObject1).intValue();
          }
          localObject1 = d.g(jdField_this.wCN);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).findViewById(2131302298);
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(8);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.d
 * JD-Core Version:    0.7.0.1
 */