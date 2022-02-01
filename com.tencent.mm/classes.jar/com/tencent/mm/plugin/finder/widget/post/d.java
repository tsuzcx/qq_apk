package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
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
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.ui.post.c;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "postType", "", "(Landroid/content/Context;I)V", "extraMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "halfImgFileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "halfRectList", "Landroid/graphics/Rect;", "halfThumbFileList", "imgFileList", "imgQualityList", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "reprintIv", "Landroid/view/View;", "rootView", "thumbFileList", "thumbIv", "Landroid/widget/ImageView;", "checkData", "", "checkFileExist", "delMedia", "", "getPicCount", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  private static final String Btq = "image_file_list";
  private static final String Btr = "image_quality_list";
  private static final String Bts = "image_thumb_list";
  private static final String Btt = "half_image_file_list";
  public static final a Btu;
  private static final String TAG = "Finder.PostImageWidget";
  private ArrayList<Rect> Btg;
  private ImageView Bth;
  private View Bti;
  public ArrayList<String> Btj;
  private ArrayList<Integer> Btk;
  private ArrayList<String> Btl;
  private cum Btm;
  private ArrayList<String> Btn;
  private ArrayList<String> Bto;
  private int Btp;
  private bfg musicInfo;
  private View oFW;
  
  static
  {
    AppMethodBeat.i(168598);
    Btu = new a((byte)0);
    Btq = "image_file_list";
    Btr = "image_quality_list";
    Bts = "image_thumb_list";
    Btt = "half_image_file_list";
    TAG = "Finder.PostImageWidget";
    AppMethodBeat.o(168598);
  }
  
  private d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168597);
    this.Btp = 2;
    this.Btl = new ArrayList();
    this.Bto = new ArrayList();
    AppMethodBeat.o(168597);
  }
  
  public final void bfU()
  {
    Object localObject5 = null;
    AppMethodBeat.i(168596);
    super.bfU();
    Object localObject4;
    Object localObject6;
    if (emo() != null)
    {
      localObject1 = emo();
      if (localObject1 == null) {
        p.iCn();
      }
      if (!Util.isNullOrNil((List)((csf)localObject1).mediaList))
      {
        localObject1 = this.Bti;
        if (localObject1 == null) {
          p.bGy("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = emo();
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((csf)localObject1).mediaList;
        p.j(localObject1, "refFeedContent!!.mediaList");
        localObject4 = (csg)((LinkedList)localObject1).getFirst();
        localObject1 = aj.AGc;
        localObject1 = aj.ha((int)((csg)localObject4).width, (int)((csg)localObject4).height);
        localObject5 = this.Bth;
        if (localObject5 == null) {
          p.iCn();
        }
        ((ImageView)localObject5).getLayoutParams().width = ((Number)((kotlin.r)localObject1).My).intValue();
        localObject5 = this.Bth;
        if (localObject5 == null) {
          p.iCn();
        }
        ((ImageView)localObject5).getLayoutParams().height = ((Number)((kotlin.r)localObject1).aazK).intValue();
        localObject5 = this.Bth;
        if (localObject5 == null) {
          p.iCn();
        }
        ((ImageView)localObject5).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject1.Mx).intValue()]);
        localObject1 = this.Bth;
        if (localObject1 == null) {
          p.iCn();
        }
        ((ImageView)localObject1).requestLayout();
        localObject5 = TAG;
        localObject6 = new StringBuilder("refresh mediaObj?.thumbUrl: ");
        if (localObject4 != null) {}
        for (localObject1 = ((csg)localObject4).thumbUrl;; localObject1 = null)
        {
          Log.i((String)localObject5, (String)localObject1);
          p.j(localObject4, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject4, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12);
          localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject4 = com.tencent.mm.plugin.finder.loader.t.dJe();
          localObject5 = this.Bth;
          if (localObject5 == null) {
            p.iCn();
          }
          localObject6 = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject4).a(localObject1, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
          localObject1 = this.Bth;
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = this.Bth;
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
          AppMethodBeat.o(168596);
          return;
        }
      }
    }
    Object localObject1 = getData();
    if (localObject1 != null) {
      localObject1 = ((Bundle)localObject1).getStringArrayList(Btq);
    }
    for (;;)
    {
      this.Btj = ((ArrayList)localObject1);
      localObject1 = getData();
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getIntegerArrayList(Btr);
        label426:
        this.Btk = ((ArrayList)localObject1);
        localObject1 = getData();
        if (localObject1 != null)
        {
          localObject4 = ((Bundle)localObject1).getByteArray("MEDIA_EXTRA_MUSIC");
          if (localObject4 != null) {
            localObject1 = (com.tencent.mm.cd.a)new cum();
          }
        }
      }
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject4);
        this.Btm = ((cum)localObject1);
        localObject4 = TAG;
        localObject6 = new StringBuilder("post image with music: ");
        localObject1 = this.Btm;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((cum)localObject1).TCc);
          Log.i((String)localObject4, localObject1);
          localObject1 = com.tencent.mm.plugin.finder.upload.i.AAy;
          this.musicInfo = com.tencent.mm.plugin.finder.upload.i.a(this.Btm);
          localObject1 = getData();
          if (localObject1 != null)
          {
            localObject4 = ((Bundle)localObject1).getByteArray("ORIGIN_MUSIC_INFO");
            if (localObject4 != null) {
              localObject1 = (com.tencent.mm.cd.a)new bfg();
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
            ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject4);
            this.musicInfo = ((bfg)localObject1);
            localObject1 = getData();
            if (localObject1 == null) {
              break label1005;
            }
            localObject1 = ((Bundle)localObject1).getStringArrayList(Btt);
            this.Btn = ((ArrayList)localObject1);
            localObject1 = getData();
            if (localObject1 == null) {
              break label1010;
            }
            localObject1 = ((Bundle)localObject1).getParcelableArrayList("HALF_RECT_LIST");
            this.Btg = ((ArrayList)localObject1);
            if (this.musicInfo == null)
            {
              localObject1 = getData();
              if (localObject1 == null) {
                break label1015;
              }
              localObject1 = ((Bundle)localObject1).getString("ORIGIN_BGM_URL");
              localObject4 = getData();
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
                localObject1 = q.n((String)localObject4, true);
              }
              localObject4 = (CharSequence)localObject1;
              if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
                break label1030;
              }
              i = 1;
              if (i == 0)
              {
                localObject4 = new bfg();
                ((bfg)localObject4).SPV = ((String)localObject1);
                this.musicInfo = ((bfg)localObject4);
              }
            }
            localObject1 = this.Btj;
            if (localObject1 == null) {
              break label1035;
            }
            localObject1 = (String)j.lp((List)localObject1);
            a.aGH((String)localObject1);
            localObject1 = getData();
            if (localObject1 == null) {
              break label1040;
            }
            localObject1 = ((Bundle)localObject1).getStringArrayList(Bts);
            if (this.Btj != null)
            {
              localObject4 = this.Btj;
              if (localObject4 == null) {
                p.iCn();
              }
              if (((ArrayList)localObject4).size() > 0) {
                h.ZvG.d((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Image_Thumb");
              }
            }
            localObject1 = this.oFW;
            if (localObject1 == null) {
              p.iCn();
            }
            localObject6 = (ImageIndicatorView)((View)localObject1).findViewById(b.f.image_indicator);
            if (localObject6 != null) {
              ((ImageIndicatorView)localObject6).setVisibility(0);
            }
            localObject1 = this.Btj;
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
                  ((ImageIndicatorView)localObject6).ahH(((ArrayList)localObject1).size());
                  localObject4 = x.aazN;
                }
                if (localObject4 != null) {
                  break label937;
                }
              }
            }
            if (localObject6 != null) {
              ((ImageIndicatorView)localObject6).setVisibility(8);
            }
            localObject1 = x.aazN;
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
  
  public final boolean cMI()
  {
    AppMethodBeat.i(291098);
    Object localObject1 = this.Btj;
    if (localObject1 != null)
    {
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!com.tencent.mm.vfs.u.agG((String)localObject1)))
        {
          localObject2 = f.Bub;
          Log.i(f.access$getTAG$cp(), "image widget file:" + (String)localObject1 + " lost!");
          AppMethodBeat.o(291098);
          return false;
        }
      }
    }
    AppMethodBeat.o(291098);
    return true;
  }
  
  public final void emp()
  {
    AppMethodBeat.i(291101);
    this.Btj = null;
    this.Btk = null;
    this.Btl.clear();
    this.Btm = null;
    this.musicInfo = null;
    this.Btn = null;
    this.Bto.clear();
    this.Btg = null;
    AppMethodBeat.o(291101);
  }
  
  public final View emx()
  {
    AppMethodBeat.i(168594);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168594);
      throw ((Throwable)localObject);
    }
    this.oFW = ((Activity)localObject).getLayoutInflater().inflate(b.g.finder_post_image_widget, null);
    localObject = this.oFW;
    if (localObject == null) {
      p.iCn();
    }
    this.Bth = ((ImageView)((View)localObject).findViewById(b.f.thumb_view));
    localObject = this.oFW;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((View)localObject).findViewById(b.f.reprint_iv);
    p.j(localObject, "rootView!!.findViewById(R.id.reprint_iv)");
    this.Bti = ((View)localObject);
    localObject = this.oFW;
    AppMethodBeat.o(168594);
    return localObject;
  }
  
  public final g emy()
  {
    Object localObject3 = null;
    int j = 0;
    AppMethodBeat.i(291094);
    if ((this.ABc != null) && (emo() != null))
    {
      localObject1 = new g(true, 2, emo());
      AppMethodBeat.o(291094);
      return localObject1;
    }
    Object localObject1 = (Collection)this.Btj;
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
      localObject4 = this.Btj;
      if (localObject4 == null) {
        p.iCn();
      }
      Log.i((String)localObject1, ((ArrayList)localObject4).size() + ", thumb list " + this.Btl.size());
      localObject1 = this.Btj;
      if (localObject1 == null) {
        p.iCn();
      }
      if (((ArrayList)localObject1).size() != this.Btl.size()) {
        break label316;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject4 = new csf();
        Object localObject6;
        if (this.Btp == 7)
        {
          localObject1 = this.Btj;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((Iterable)localObject1).iterator();
          i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              j.iBO();
            }
            localObject2 = (String)localObject2;
            localObject5 = ((csf)localObject4).mediaList;
            localObject6 = com.tencent.mm.plugin.finder.upload.i.AAy;
            localObject6 = this.Btl.get(i);
            p.j(localObject6, "thumbFileList[index]");
            ((LinkedList)localObject5).add(com.tencent.mm.plugin.finder.upload.i.hr((String)localObject2, (String)localObject6));
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
        localObject1 = this.Btj;
        if (localObject1 == null) {
          p.iCn();
        }
        Object localObject5 = ((Iterable)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = ((Iterator)localObject5).next();
          if (i < 0) {
            j.iBO();
          }
          localObject1 = (String)localObject1;
          localObject6 = ((csf)localObject4).mediaList;
          localObject2 = com.tencent.mm.plugin.finder.upload.i.AAy;
          localObject2 = this.Btl.get(i);
          p.j(localObject2, "thumbFileList[index]");
          csg localcsg = com.tencent.mm.plugin.finder.upload.i.hq((String)localObject1, (String)localObject2);
          localObject1 = new bea();
          localObject2 = this.Btk;
          if (localObject2 != null)
          {
            localObject2 = (Integer)j.M((List)localObject2, i);
            if (localObject2 != null)
            {
              int k = ((Number)localObject2).intValue();
              ((bea)localObject1).SPj = k;
              Log.i(TAG, "codec_info hdimg_score:".concat(String.valueOf(k)));
            }
          }
          localcsg.codec_info = ((bea)localObject1);
          localObject1 = this.Btn;
          label541:
          String str;
          if (localObject1 != null)
          {
            localObject1 = (String)j.M((List)localObject1, i);
            str = (String)j.M((List)this.Bto, i);
            localObject2 = this.Btg;
            if (localObject2 == null) {
              break label749;
            }
          }
          label749:
          for (localObject2 = (Rect)j.M((List)localObject2, i);; localObject2 = null)
          {
            if ((localObject1 != null) && (str != null) && (localObject2 != null))
            {
              cis localcis = new cis();
              localcis.Crx = ((String)localObject1);
              aj localaj = aj.AGc;
              localObject1 = aj.aFH((String)localObject1);
              localcis.width = ((Point)localObject1).x;
              localcis.height = ((Point)localObject1).y;
              localcis.thumbUrl = str;
              localcsg.TAd = localcis;
              localcsg.thumbUrl = str;
              localObject1 = new awc();
              ((awc)localObject1).left = ((Rect)localObject2).left;
              ((awc)localObject1).top = ((Rect)localObject2).top;
              ((awc)localObject1).right = ((Rect)localObject2).right;
              ((awc)localObject1).bottom = ((Rect)localObject2).bottom;
              localcsg.TAa = ((awc)localObject1);
            }
            ((LinkedList)localObject6).add(localcsg);
            i += 1;
            break;
            localObject1 = null;
            break label541;
          }
        }
        localObject1 = getData();
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_ID");
          ((csf)localObject4).AtP = ((String)localObject1);
          localObject1 = getData();
          if (localObject1 == null) {
            break label1005;
          }
          localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_PATH");
          label804:
          ((csf)localObject4).AtN = ((String)localObject1);
          localObject1 = getData();
          if (localObject1 == null) {
            break label1011;
          }
          localObject1 = ((Bundle)localObject1).getString("ORIGIN_BGM_URL");
          label832:
          ((csf)localObject4).TzQ = ((String)localObject1);
          localObject1 = getData();
          if (localObject1 == null) {
            break label1017;
          }
          bool = ((Bundle)localObject1).getBoolean("MEDIA_IS_MUTE", false);
          label861:
          ((csf)localObject4).Btc = bool;
          localObject1 = getData();
          if (localObject1 == null) {
            break label1023;
          }
        }
        label1005:
        label1011:
        label1017:
        label1023:
        for (boolean bool = ((Bundle)localObject1).getBoolean("MUSIC_IS_MUTE", false);; bool = false)
        {
          ((csf)localObject4).Btd = bool;
          localObject1 = getData();
          i = j;
          if (localObject1 != null) {
            i = ((Bundle)localObject1).getInt("SOUND_TRACK_TYPE", 0);
          }
          ((csf)localObject4).soundTrackType = i;
          localObject2 = getData();
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((Bundle)localObject2).getString("MUSIC_FEED_ID");
          }
          ((csf)localObject4).musicFeedId = ((String)localObject1);
          ((csf)localObject4).TzP = this.musicInfo;
          if (this.Btp != 7) {
            break label1029;
          }
          localObject1 = new g(true, 7, (csf)localObject4);
          AppMethodBeat.o(291094);
          return localObject1;
          localObject1 = null;
          break;
          localObject1 = null;
          break label804;
          localObject1 = null;
          break label832;
          bool = false;
          break label861;
        }
        label1029:
        localObject1 = new g(true, 2, (csf)localObject4);
        AppMethodBeat.o(291094);
        return localObject1;
      }
    }
    localObject1 = new g(false, 0, null);
    AppMethodBeat.o(291094);
    return localObject1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget$Companion;", "", "()V", "HALF_IMAGE_FILE_LIST", "", "getHALF_IMAGE_FILE_LIST", "()Ljava/lang/String;", "IMAGE_FILE_LIST", "getIMAGE_FILE_LIST", "IMAGE_QUALITY_LIST", "getIMAGE_QUALITY_LIST", "IMAGE_THUMB_LIST", "getIMAGE_THUMB_LIST", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168590);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      d.a(this.Btv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168590);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(290840);
      Object localObject1 = d.b(this.Btv);
      if (localObject1 == null) {
        p.iCn();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      final int i = 0;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (i < 0) {
          j.iBO();
        }
        localObject1 = (String)localObject1;
        final boolean bool;
        if (i == 0)
        {
          bool = true;
          label69:
          if ((this.Btw == null) || (this.Btw.size() <= i) || (Util.isNullOrNil((String)this.Btw.get(i)))) {
            break label263;
          }
        }
        for (localObject1 = (String)this.Btw.get(i);; localObject1 = com.tencent.mm.plugin.finder.upload.f.aFk((String)localObject1))
        {
          Object localObject2 = new aa.f();
          ((aa.f)localObject2).aaBC = null;
          Object localObject3 = d.c(this.Btv);
          Object localObject4;
          if (localObject3 != null)
          {
            localObject3 = (String)j.M((List)localObject3, i);
            if (localObject3 != null)
            {
              localObject4 = com.tencent.mm.plugin.finder.upload.f.AzZ;
              ((aa.f)localObject2).aaBC = com.tencent.mm.plugin.finder.upload.f.aFk((String)localObject3);
            }
          }
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject3 = new aa.f();
            ((aa.f)localObject3).aaBC = BitmapUtil.decodeFile((String)localObject1);
            localObject4 = BitmapUtil.decodeFile((String)((aa.f)localObject2).aaBC);
            if ((Bitmap)((aa.f)localObject3).aaBC != null) {
              MMHandlerThread.postToMainThread((Runnable)new a((String)localObject1, (aa.f)localObject2, (Bitmap)localObject4, (aa.f)localObject3, i, bool, this));
            }
          }
          i += 1;
          break;
          bool = false;
          break label69;
          label263:
          localObject2 = com.tencent.mm.plugin.finder.upload.f.AzZ;
        }
      }
      AppMethodBeat.o(290840);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$5$1$2$1", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$5$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(String paramString, aa.f paramf1, Bitmap paramBitmap, aa.f paramf2, int paramInt, boolean paramBoolean, d.c paramc) {}
      
      public final void run()
      {
        Object localObject4 = null;
        AppMethodBeat.i(278398);
        d.d(jdField_this.Btv).add(this.Btx);
        Object localObject2;
        if (((String)this.Bty.aaBC != null) && (this.Btz != null))
        {
          localObject1 = d.e(jdField_this.Btv);
          localObject2 = (String)this.Bty.aaBC;
          if (localObject2 == null) {
            p.iCn();
          }
          ((ArrayList)localObject1).add(localObject2);
          this.BtA.aaBC = this.Btz;
        }
        Object localObject1 = d.Btu;
        Log.i(d.access$getTAG$cp(), "add thumb file, index:" + i);
        kotlin.r localr;
        LinearLayout localLinearLayout;
        label401:
        label413:
        Object localObject3;
        if (bool)
        {
          localObject1 = aj.AGc;
          localObject1 = (Bitmap)this.BtA.aaBC;
          p.j(localObject1, "thumb");
          int i = ((Bitmap)localObject1).getWidth();
          localObject1 = (Bitmap)this.BtA.aaBC;
          p.j(localObject1, "thumb");
          localr = aj.ha(i, ((Bitmap)localObject1).getHeight());
          i = ((Number)localr.My).intValue();
          int j = ((Number)localr.aazK).intValue();
          localObject1 = d.f(jdField_this.Btv);
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).getLayoutParams().width = i;
          localObject1 = d.f(jdField_this.Btv);
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).getLayoutParams().height = j;
          localObject1 = d.g(jdField_this.Btv);
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((View)localObject1).findViewById(b.f.image_indicator);
          p.j(localObject1, "rootView!!.findViewById<…ew>(R.id.image_indicator)");
          ((ImageIndicatorView)localObject1).getLayoutParams().width = i;
          localObject1 = d.g(jdField_this.Btv);
          if (localObject1 == null) {
            break label838;
          }
          localObject1 = ((View)localObject1).getParent();
          localObject2 = localObject1;
          if (!(localObject1 instanceof LinearLayout)) {
            localObject2 = null;
          }
          localLinearLayout = (LinearLayout)localObject2;
          if (localLinearLayout == null) {
            break label844;
          }
          localObject1 = localLinearLayout.getRootView();
          if (localObject1 == null) {
            break label844;
          }
          localObject2 = (TextView)((View)localObject1).findViewById(b.f.post_nickname);
          if (localLinearLayout == null) {
            break label850;
          }
          localObject1 = localLinearLayout.getLayoutParams();
          localObject3 = localObject1;
          if (!(localObject1 instanceof FrameLayout.LayoutParams)) {
            localObject3 = null;
          }
          localObject3 = (FrameLayout.LayoutParams)localObject3;
          localObject1 = (Bitmap)this.BtA.aaBC;
          p.j(localObject1, "thumb");
          if (((Bitmap)localObject1).getWidth() <= 0) {
            break label856;
          }
          localObject1 = (Bitmap)this.BtA.aaBC;
          p.j(localObject1, "thumb");
          if (((Bitmap)localObject1).getHeight() <= 0) {
            break label856;
          }
          localObject1 = aj.AGc;
          localObject1 = (Bitmap)this.BtA.aaBC;
          p.j(localObject1, "thumb");
          float f = ((Bitmap)localObject1).getHeight();
          localObject1 = (Bitmap)this.BtA.aaBC;
          p.j(localObject1, "thumb");
          if (!aj.bj(f / ((Bitmap)localObject1).getWidth())) {
            break label856;
          }
          if (localObject3 != null) {
            ((FrameLayout.LayoutParams)localObject3).topMargin = 0;
          }
          if (localObject2 != null)
          {
            localObject1 = MMApplicationContext.getContext();
            p.j(localObject1, "MMApplicationContext.getContext()");
            ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(b.c.White));
          }
          localObject1 = d.g(jdField_this.Btv);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).findViewById(b.f.header_mask_view);
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
          localObject1 = d.f(jdField_this.Btv);
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localr.Mx).intValue()]);
          localObject1 = d.f(jdField_this.Btv);
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).requestLayout();
          localObject1 = d.f(jdField_this.Btv);
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).setImageBitmap((Bitmap)this.BtA.aaBC);
          localObject1 = d.f(jdField_this.Btv);
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = d.f(jdField_this.Btv);
          if (localObject1 == null) {
            p.iCn();
          }
          ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(286919);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$5$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              paramAnonymousView = aj.AGc;
              if (aj.isAnyEnableFullScreenEnjoy())
              {
                paramAnonymousView = com.tencent.mm.ui.component.g.Xox;
                ((c)com.tencent.mm.ui.component.g.lm(this.BtD.BtC.Btv.context).i(c.class)).dEm();
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$5$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(286919);
                return;
                d.a(this.BtD.BtC.Btv);
              }
            }
          });
          AppMethodBeat.o(278398);
          return;
          label838:
          localObject1 = null;
          break;
          label844:
          localObject2 = null;
          break label401;
          label850:
          localObject1 = null;
          break label413;
          label856:
          if (localObject2 != null)
          {
            localObject1 = MMApplicationContext.getContext();
            p.j(localObject1, "MMApplicationContext.getContext()");
            ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(b.c.normal_text_color));
          }
          if (localObject3 != null)
          {
            localObject2 = d.g(jdField_this.Btv);
            localObject1 = localObject4;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getResources();
              localObject1 = localObject4;
              if (localObject2 != null) {
                localObject1 = Integer.valueOf((int)((Resources)localObject2).getDimension(b.d.Edge_4_5_A));
              }
            }
            ((FrameLayout.LayoutParams)localObject3).topMargin = ((Integer)localObject1).intValue();
          }
          localObject1 = d.g(jdField_this.Btv);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).findViewById(b.f.header_mask_view);
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(8);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.d
 * JD-Core Version:    0.7.0.1
 */