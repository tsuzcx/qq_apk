package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.ui.post.c;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCompositionInfo", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCompositionInfo", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "container", "Landroid/view/View;", "coverQuality", "", "coverUrl", "", "cropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getCropInfoList", "()Ljava/util/ArrayList;", "setCropInfoList", "(Ljava/util/ArrayList;)V", "extraMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "halfRect", "Landroid/graphics/Rect;", "halfThumbUrl", "longVideoCropInfo", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Landroid/widget/ImageView;", "thumbLocalUrl", "videoFileList", "getVideoFileList", "setVideoFileList", "videoPathBeforeCut", "adjustMargin", "", "width", "height", "checkData", "", "checkFileExist", "delMedia", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "getVideoLen", "", "inflateView", "initCropInfo", "initFakeVideoLogic", "initLongVideoCropInfo", "initNormalVideoLogic", "jumpSelectCoverUI", "jumpToPreviewLongVideo", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "setLocalThumbUrl", "thumbUrl", "showThumb", "thumb", "Landroid/graphics/Bitmap;", "Companion", "plugin-finder_release"})
public final class f
  extends a
{
  private static final int BtX = 1001;
  private static final String BtY = "RESULT_COVER_PATH";
  private static final String BtZ = "RESULT_COVER_QUALITY";
  private static final String Bua = "RESULT_CROP_INFO";
  public static final a Bub;
  private static final String TAG = "Finder.PostVideoWidget";
  private String ABe;
  private String BsR;
  ArrayList<String> BtQ;
  ArrayList<css> BtR;
  public acu BtS;
  private int BtT;
  private String BtU;
  private Rect BtV;
  private css BtW;
  private ImageView Bth;
  private View Bti;
  ArrayList<String> Btl;
  private cum Btm;
  private String coverUrl;
  private View fyN;
  private bfg musicInfo;
  private View oFW;
  
  static
  {
    AppMethodBeat.i(168626);
    Bub = new a((byte)0);
    BtX = 1001;
    BtY = "RESULT_COVER_PATH";
    BtZ = "RESULT_COVER_QUALITY";
    Bua = "RESULT_CROP_INFO";
    TAG = "Finder.PostVideoWidget";
    AppMethodBeat.o(168626);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168625);
    this.Btl = new ArrayList();
    this.BtR = new ArrayList();
    this.BsR = "";
    this.coverUrl = "";
    this.BtU = "";
    this.ABe = "";
    AppMethodBeat.o(168625);
  }
  
  private final void aGI(String paramString)
  {
    AppMethodBeat.i(282595);
    if (!Util.isNullOrNil(this.coverUrl)) {
      paramString = this.coverUrl;
    }
    this.BsR = paramString;
    AppMethodBeat.o(282595);
  }
  
  private final boolean emF()
  {
    AppMethodBeat.i(282591);
    Object localObject1 = getData();
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getByteArray("video_composition");
      if (localObject1 != null)
      {
        Object localObject3;
        try
        {
          Log.i(TAG, "initFakeVideoLogic");
          localObject3 = this.fyN;
          if (localObject3 == null) {
            p.bGy("container");
          }
          ((View)localObject3).setVisibility(0);
          localObject1 = new acu().parseFrom((byte[])localObject1);
          if (localObject1 != null) {
            break label117;
          }
          localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CompositionInfo");
          AppMethodBeat.o(282591);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localIOException, "parse error", new Object[0]);
        }
        AppMethodBeat.o(282591);
        return true;
        label117:
        this.BtS = ((acu)localIOException);
        if (this.BtV != null)
        {
          localObject2 = this.BtV;
          if ((localObject2 == null) || (((Rect)localObject2).isEmpty() != true)) {}
        }
        else
        {
          this.BtV = new Rect();
          localObject2 = this.BtS;
          if (localObject2 != null)
          {
            localObject2 = ((acu)localObject2).NkX.SoK.Sro;
            p.j(localObject2, "info.outputConfig.cropConfig.cropRect");
            localObject3 = this.BtV;
            if (localObject3 == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.vlog.model.i.a((duz)localObject2, (Rect)localObject3);
          }
        }
        Object localObject2 = getData();
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("VIDEO_THUMB_LIST");
          label221:
          localObject3 = new aa.f();
          ((aa.f)localObject3).aaBC = "";
          if (localObject2 != null) {
            if (((Collection)localObject2).isEmpty()) {
              break label385;
            }
          }
        }
        label385:
        for (int i = 1;; i = 0)
        {
          if (i == 1)
          {
            localObject2 = j.lo((List)localObject2);
            p.j(localObject2, "mediaThumbList.first()");
            ((aa.f)localObject3).aaBC = ((String)localObject2);
          }
          aGI((String)((aa.f)localObject3).aaBC);
          com.tencent.mm.ae.d.b("PostVideoWidget_initFakeVideoLogic", (kotlin.g.a.a)new b((aa.f)localObject3, this));
          localObject2 = this.Bth;
          if (localObject2 == null) {
            p.bGy("thumbIv");
          }
          ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new c((aa.f)localObject3, this));
          localObject2 = this.oFW;
          if (localObject2 == null) {
            p.bGy("rootView");
          }
          ((View)localObject2).findViewById(b.f.select_cover_btn).setOnClickListener((View.OnClickListener)new d((aa.f)localObject3, this));
          break;
          localObject2 = null;
          break label221;
        }
      }
    }
    AppMethodBeat.o(282591);
    return false;
  }
  
  private final void emH()
  {
    AppMethodBeat.i(282596);
    Bundle localBundle = getData();
    if (localBundle != null)
    {
      Object localObject2 = localBundle.getString("video_before_cut_path");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.ABe = ((String)localObject1);
      localObject1 = localBundle.getParcelableArrayList("VIDEO_CROP_LIST");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        this.BtR.clear();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof LocalVideoCropInfoParcelable))) {
            this.BtR.add(((LocalVideoCropInfoParcelable)localObject2).zBo);
          } else {
            this.BtR.add(null);
          }
        }
      }
      AppMethodBeat.o(282596);
      return;
    }
    AppMethodBeat.o(282596);
  }
  
  private final void hr(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(282590);
    Object localObject1 = this.oFW;
    if (localObject1 == null) {
      p.bGy("rootView");
    }
    Object localObject2 = ((View)localObject1).getParent();
    localObject1 = localObject2;
    if (!(localObject2 instanceof LinearLayout)) {
      localObject1 = null;
    }
    LinearLayout localLinearLayout = (LinearLayout)localObject1;
    FrameLayout.LayoutParams localLayoutParams;
    if (localLinearLayout != null)
    {
      localObject1 = localLinearLayout.getLayoutParams();
      localObject2 = localObject1;
      if (!(localObject1 instanceof FrameLayout.LayoutParams)) {
        localObject2 = null;
      }
      localLayoutParams = (FrameLayout.LayoutParams)localObject2;
      if (localLinearLayout == null) {
        break label250;
      }
      localObject1 = localLinearLayout.getRootView();
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.post_nickname);
      label106:
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label255;
      }
      localObject2 = aj.AGc;
      if (!aj.bj(paramInt2 / paramInt1)) {
        break label255;
      }
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.White));
      }
      localObject1 = this.oFW;
      if (localObject1 == null) {
        p.bGy("rootView");
      }
      localObject1 = ((View)localObject1).findViewById(b.f.header_mask_view);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        localObject2 = ((View)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = paramInt1;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    for (;;)
    {
      if (localLinearLayout == null) {
        break label385;
      }
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(282590);
      return;
      localObject1 = null;
      break;
      label250:
      localObject1 = null;
      break label106;
      label255:
      if (localLayoutParams != null)
      {
        localObject2 = this.oFW;
        if (localObject2 == null) {
          p.bGy("rootView");
        }
        Resources localResources = ((View)localObject2).getResources();
        localObject2 = localObject3;
        if (localResources != null) {
          localObject2 = Integer.valueOf((int)localResources.getDimension(b.d.Edge_4_5_A));
        }
        localLayoutParams.topMargin = ((Integer)localObject2).intValue();
      }
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.normal_text_color));
      }
      localObject1 = this.oFW;
      if (localObject1 == null) {
        p.bGy("rootView");
      }
      localObject1 = ((View)localObject1).findViewById(b.f.header_mask_view);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    label385:
    AppMethodBeat.o(282590);
  }
  
  public final void bfU()
  {
    Object localObject4 = null;
    AppMethodBeat.i(168624);
    super.bfU();
    Object localObject1 = getData();
    if (localObject1 != null)
    {
      localObject5 = ((Bundle)localObject1).getByteArray("MEDIA_EXTRA_MUSIC");
      if (localObject5 != null) {
        localObject1 = (com.tencent.mm.cd.a)new cum();
      }
    }
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject5);
      this.Btm = ((cum)localObject1);
      localObject5 = TAG;
      localObject6 = new StringBuilder("post video with music: ");
      localObject1 = this.Btm;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((cum)localObject1).TCc);
        Log.i((String)localObject5, localObject1);
        localObject1 = com.tencent.mm.plugin.finder.upload.i.AAy;
        this.musicInfo = com.tencent.mm.plugin.finder.upload.i.a(this.Btm);
        localObject1 = getData();
        if (localObject1 != null)
        {
          localObject5 = ((Bundle)localObject1).getByteArray("ORIGIN_MUSIC_INFO");
          if (localObject5 != null) {
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
          ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject5);
          this.musicInfo = ((bfg)localObject1);
          localObject1 = getData();
          if (localObject1 != null)
          {
            localObject5 = ((Bundle)localObject1).getString("VIDEO_COVER_URL");
            localObject1 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          this.coverUrl = ((String)localObject1);
          localObject1 = getData();
          if (localObject1 == null) {
            break;
          }
          i = ((Bundle)localObject1).getInt("VIDEO_COVER_QUALITY", 0);
          this.BtT = i;
          localObject1 = getData();
          if (localObject1 == null) {
            break label376;
          }
          localObject1 = ((Bundle)localObject1).getParcelableArrayList("HALF_RECT_LIST");
          if (localObject1 == null) {
            break label376;
          }
          localObject1 = (Rect)j.M((List)localObject1, 0);
          this.BtV = ((Rect)localObject1);
          if (!com.tencent.mm.vfs.u.agG(this.coverUrl))
          {
            this.coverUrl = "";
            this.BtT = 0;
          }
          localObject1 = getData();
          if (localObject1 == null) {
            break label381;
          }
          localObject1 = ((Bundle)localObject1).getByteArray("video_composition");
          if (localObject1 == null) {
            break label386;
          }
          emF();
          AppMethodBeat.o(168624);
          return;
          localException1 = localException1;
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          localObject2 = null;
        }
        Object localObject2 = null;
      }
      catch (Exception localException2)
      {
        Object localObject6;
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException2 });
          localObject3 = null;
          continue;
          i = 0;
          continue;
          label376:
          localObject3 = null;
          continue;
          label381:
          localObject3 = null;
        }
        label386:
        if (emo() != null)
        {
          localObject3 = emo();
          if (localObject3 == null) {
            p.iCn();
          }
          if (!Util.isNullOrNil((List)((csf)localObject3).mediaList))
          {
            localObject3 = this.fyN;
            if (localObject3 == null) {
              p.bGy("container");
            }
            ((View)localObject3).setVisibility(0);
            localObject3 = this.Bti;
            if (localObject3 == null) {
              p.bGy("reprintIv");
            }
            ((View)localObject3).setVisibility(0);
            localObject3 = emo();
            if (localObject3 == null) {
              p.iCn();
            }
            localObject3 = ((csf)localObject3).mediaList;
            p.j(localObject3, "refFeedContent!!.mediaList");
            localObject3 = (csg)((LinkedList)localObject3).getFirst();
            localObject4 = aj.AGc;
            localObject4 = aj.ha((int)((csg)localObject3).width, (int)((csg)localObject3).height);
            localObject5 = this.Bth;
            if (localObject5 == null) {
              p.bGy("thumbIv");
            }
            ((ImageView)localObject5).getLayoutParams().width = ((Number)((kotlin.r)localObject4).My).intValue();
            localObject5 = this.Bth;
            if (localObject5 == null) {
              p.bGy("thumbIv");
            }
            ((ImageView)localObject5).getLayoutParams().height = ((Number)((kotlin.r)localObject4).aazK).intValue();
            localObject5 = this.Bth;
            if (localObject5 == null) {
              p.bGy("thumbIv");
            }
            i = ((ImageView)localObject5).getLayoutParams().width;
            localObject5 = this.Bth;
            if (localObject5 == null) {
              p.bGy("thumbIv");
            }
            hr(i, ((ImageView)localObject5).getLayoutParams().height);
            localObject5 = this.Bth;
            if (localObject5 == null) {
              p.bGy("thumbIv");
            }
            ((ImageView)localObject5).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject4.Mx).intValue()]);
            localObject4 = this.Bth;
            if (localObject4 == null) {
              p.bGy("thumbIv");
            }
            ((ImageView)localObject4).requestLayout();
            p.j(localObject3, "mediaObj");
            localObject3 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject3, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12);
            localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
            localObject4 = com.tencent.mm.plugin.finder.loader.t.dJe();
            localObject5 = this.Bth;
            if (localObject5 == null) {
              p.bGy("thumbIv");
            }
            localObject6 = com.tencent.mm.plugin.finder.loader.t.ztT;
            ((com.tencent.mm.loader.d)localObject4).a(localObject3, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
            localObject3 = this.Bth;
            if (localObject3 == null) {
              p.bGy("thumbIv");
            }
            ((ImageView)localObject3).setOnClickListener((View.OnClickListener)new g(this));
            AppMethodBeat.o(168624);
            return;
          }
        }
        localObject3 = getData();
        if (localObject3 == null) {
          break label997;
        }
      }
    }
    Object localObject3 = ((Bundle)localObject3).getStringArrayList("video_file_list");
    this.BtQ = ((ArrayList)localObject3);
    Object localObject5 = getData();
    localObject3 = localObject4;
    if (localObject5 != null) {
      localObject3 = ((Bundle)localObject5).getStringArrayList("VIDEO_THUMB_LIST");
    }
    localObject4 = getData();
    if (localObject4 != null)
    {
      localObject5 = ((Bundle)localObject4).getString("VIDEO_COVER_URL");
      localObject4 = localObject5;
      if (localObject5 != null) {}
    }
    else
    {
      localObject4 = "";
    }
    this.coverUrl = ((String)localObject4);
    localObject4 = getData();
    if (localObject4 != null)
    {
      i = ((Bundle)localObject4).getInt("VIDEO_COVER_QUALITY", 0);
      label880:
      this.BtT = i;
      emH();
      localObject4 = (Collection)this.BtQ;
      if ((localObject4 != null) && (!((Collection)localObject4).isEmpty())) {
        break label1007;
      }
    }
    label997:
    label1007:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject4 = this.oFW;
        if (localObject4 == null) {
          p.bGy("rootView");
        }
        ((View)localObject4).findViewById(b.f.select_cover_btn).setOnClickListener((View.OnClickListener)new e(this));
        localObject4 = this.fyN;
        if (localObject4 == null) {
          p.bGy("container");
        }
        ((View)localObject4).setVisibility(0);
        com.tencent.mm.ae.d.c("Finder_Post_Create_Video_Thumb", (kotlin.g.a.a)new f(this, (ArrayList)localObject3));
      }
      AppMethodBeat.o(168624);
      return;
      localObject3 = null;
      break;
      i = 0;
      break label880;
    }
  }
  
  public final boolean cMI()
  {
    AppMethodBeat.i(282597);
    Object localObject2;
    if (this.BtS != null)
    {
      localObject1 = this.BtS;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = ((acu)localObject1).Sou;
      p.j(localObject1, "compositionInfo!!.tracks");
      localObject1 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (eth)((Iterator)localObject1).next();
      } while (com.tencent.mm.vfs.u.agG(((eth)localObject2).path));
      Log.i(TAG, "[compositionInfo]video widget file:" + ((eth)localObject2).path + " lost!");
      AppMethodBeat.o(282597);
      return false;
    }
    Object localObject1 = this.BtQ;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!com.tencent.mm.vfs.u.agG((String)localObject2))
        {
          Log.i(TAG, "[videoFileList]video widget file:" + (String)localObject2 + " lost!");
          AppMethodBeat.o(282597);
          return false;
        }
      }
    }
    AppMethodBeat.o(282597);
    return true;
  }
  
  public final void emG()
  {
    AppMethodBeat.i(282594);
    Object localObject1 = new csf();
    Object localObject4;
    if (this.BtW == null)
    {
      localObject2 = this.BtQ;
      if (localObject2 != null)
      {
        localObject4 = (String)j.lo((List)localObject2);
        if (localObject4 != null) {
          break label153;
        }
      }
    }
    Object localObject3;
    Object localObject5;
    label153:
    do
    {
      localObject2 = x.aazN;
      localObject2 = this.BtQ;
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          j.iBO();
        }
        localObject3 = (String)localObject3;
        localObject4 = ((csf)localObject1).mediaList;
        localObject5 = com.tencent.mm.plugin.finder.upload.i.AAy;
        ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.i.a((String)localObject3, "", this.BtW));
        i += 1;
      }
      localObject2 = new css();
      localObject3 = MultiMediaVideoChecker.NmA.bfs((String)localObject4);
    } while (localObject3 == null);
    int j = ((MultiMediaVideoChecker.a)localObject3).width;
    int i = ((MultiMediaVideoChecker.a)localObject3).height;
    int k = SightVideoJNI.getMp4RotateVFS((String)localObject4);
    if ((k == 90) || (k == 270))
    {
      j = ((MultiMediaVideoChecker.a)localObject3).height;
      i = ((MultiMediaVideoChecker.a)localObject3).width;
    }
    k = ax.au(this.context).x;
    float f = j / i;
    if ((f >= 0.5625F) && (f <= 1.777778F))
    {
      localObject4 = new fbq();
      ((fbq)localObject4).left = 0;
      ((fbq)localObject4).top = i;
      ((fbq)localObject4).right = j;
      ((fbq)localObject4).bottom = 0;
      ((css)localObject2).TAv = ((fbq)localObject4);
      ((css)localObject2).TAx = ((fbq)localObject4);
      localObject4 = j.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
      localObject5 = new blk();
      ((blk)localObject5).SWx.addAll((Collection)j.p((Iterable)localObject4));
      ((css)localObject2).TAw = ((blk)localObject5);
    }
    for (;;)
    {
      ((css)localObject2).fod = 0;
      ((css)localObject2).endTime = ((int)((MultiMediaVideoChecker.a)localObject3).duration);
      ((css)localObject2).width = j;
      ((css)localObject2).height = i;
      ((css)localObject2).retryCount = 0;
      this.BtW = ((css)localObject2);
      break;
      float[] arrayOfFloat;
      if (f > 1.777778F)
      {
        k = (int)(i * 16.0F / 9.0F);
        localObject5 = new fbq();
        ((fbq)localObject5).left = ((j - k) / 2);
        ((fbq)localObject5).top = i;
        ((fbq)localObject5).right = (j - ((fbq)localObject5).left);
        ((fbq)localObject5).bottom = 0;
        ((css)localObject2).TAv = ((fbq)localObject5);
        ((css)localObject2).TAx = ((fbq)localObject5);
        localObject4 = new Matrix();
        ((Matrix)localObject4).postTranslate(-((fbq)localObject5).left, 0.0F);
        localObject5 = new blk();
        arrayOfFloat = new float[9];
        ((Matrix)localObject4).getValues(arrayOfFloat);
        ((blk)localObject5).SWx.addAll((Collection)e.t(arrayOfFloat));
        ((css)localObject2).TAw = ((blk)localObject5);
        j = k;
      }
      else
      {
        k = (int)(j * 16.0F / 9.0F);
        localObject5 = new fbq();
        ((fbq)localObject5).left = 0;
        ((fbq)localObject5).bottom = ((i - k) / 2);
        ((fbq)localObject5).right = j;
        ((fbq)localObject5).top = (i - ((fbq)localObject5).bottom);
        ((css)localObject2).TAv = ((fbq)localObject5);
        ((css)localObject2).TAx = ((fbq)localObject5);
        localObject4 = new Matrix();
        ((Matrix)localObject4).postTranslate(0.0F, -((fbq)localObject5).bottom);
        localObject5 = new blk();
        arrayOfFloat = new float[9];
        ((Matrix)localObject4).getValues(arrayOfFloat);
        ((blk)localObject5).SWx.addAll((Collection)e.t(arrayOfFloat));
        ((css)localObject2).TAw = ((blk)localObject5);
        i = k;
      }
    }
    Object localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
    localObject2 = this.context;
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(282594);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject2, null, (csf)localObject1, null, true, true, 8);
    AppMethodBeat.o(282594);
  }
  
  public final void emp()
  {
    AppMethodBeat.i(282598);
    this.BtQ = null;
    this.Btl.clear();
    this.BtR.clear();
    this.BtS = null;
    this.Btm = null;
    this.musicInfo = null;
    this.BsR = null;
    this.coverUrl = "";
    this.BtT = 0;
    this.BtU = "";
    this.BtV = null;
    AppMethodBeat.o(282598);
  }
  
  public final View emx()
  {
    AppMethodBeat.i(168622);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168622);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getLayoutInflater().inflate(b.g.finder_post_video_widget, null);
    p.j(localObject, "(context as Activity).la…_post_video_widget, null)");
    this.oFW = ((View)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    localObject = ((View)localObject).findViewById(b.f.video_container);
    p.j(localObject, "rootView.findViewById(R.id.video_container)");
    this.fyN = ((View)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    localObject = ((View)localObject).findViewById(b.f.thumb_view);
    p.j(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.Bth = ((ImageView)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    localObject = ((View)localObject).findViewById(b.f.reprint_iv);
    p.j(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.Bti = ((View)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    AppMethodBeat.o(168622);
    return localObject;
  }
  
  public final g emy()
  {
    AppMethodBeat.i(282587);
    csf localcsf = new csf();
    Object localObject1 = getData();
    label55:
    label78:
    boolean bool;
    label102:
    label126:
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_ID");
      localcsf.AtP = ((String)localObject1);
      localObject1 = getData();
      if (localObject1 == null) {
        break label412;
      }
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_PATH");
      localcsf.AtN = ((String)localObject1);
      localObject1 = getData();
      if (localObject1 == null) {
        break label417;
      }
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_BGM_URL");
      localcsf.TzQ = ((String)localObject1);
      localObject1 = getData();
      if (localObject1 == null) {
        break label422;
      }
      bool = ((Bundle)localObject1).getBoolean("MEDIA_IS_MUTE", false);
      localcsf.Btc = bool;
      localObject1 = getData();
      if (localObject1 == null) {
        break label427;
      }
      bool = ((Bundle)localObject1).getBoolean("MUSIC_IS_MUTE", false);
      localcsf.Btd = bool;
      localObject1 = getData();
      if (localObject1 == null) {
        break label432;
      }
      i = ((Bundle)localObject1).getInt("SOUND_TRACK_TYPE", 0);
      label150:
      localcsf.soundTrackType = i;
      localObject1 = getData();
      if (localObject1 == null) {
        break label437;
      }
    }
    Object localObject2;
    label280:
    Object localObject3;
    label412:
    label417:
    label422:
    label427:
    label432:
    label437:
    for (localObject1 = ((Bundle)localObject1).getString("MUSIC_FEED_ID");; localObject1 = null)
    {
      localcsf.musicFeedId = ((String)localObject1);
      localcsf.TzP = this.musicInfo;
      Log.i(TAG, "getUploadData: " + localcsf.AtP + ", " + localcsf.Btd);
      if (this.BtS == null) {
        break label442;
      }
      localObject1 = getData();
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getStringArrayList("VIDEO_THUMB_LIST");
        if (localObject1 != null)
        {
          localObject2 = (String)j.lo((List)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label280;
          }
        }
      }
      localObject1 = "";
      localObject2 = localcsf.mediaList;
      localObject3 = com.tencent.mm.plugin.finder.upload.i.AAy;
      localObject3 = this.BtS;
      if (localObject3 == null) {
        p.iCn();
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.i.a((acu)localObject3, this.BtU, (String)localObject1, this.coverUrl, this.BtV);
      localObject3 = new bea();
      ((bea)localObject3).SPg = this.BtT;
      ((csg)localObject1).codec_info = ((bea)localObject3);
      Log.i(TAG, "codec_info video_cover_score:" + this.BtT);
      ((LinkedList)localObject2).add(localObject1);
      localObject1 = new g(true, 4, localcsf, this.ABe);
      AppMethodBeat.o(282587);
      return localObject1;
      localObject1 = null;
      break;
      localObject1 = null;
      break label55;
      localObject1 = null;
      break label78;
      bool = false;
      break label102;
      bool = false;
      break label126;
      i = 0;
      break label150;
    }
    label442:
    if ((this.ABc != null) && (emo() != null))
    {
      localObject1 = new g(true, 4, emo());
      AppMethodBeat.o(282587);
      return localObject1;
    }
    localObject1 = (Collection)this.BtQ;
    label596:
    label625:
    Object localObject4;
    String str;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label805;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("video list ");
      localObject3 = this.BtQ;
      if (localObject3 == null) {
        p.iCn();
      }
      Log.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.Btl.size());
      localObject1 = this.BtQ;
      if (localObject1 == null) {
        p.iCn();
      }
      if (((ArrayList)localObject1).size() != this.Btl.size()) {
        break label800;
      }
      i = 1;
      if (i == 0) {
        break label856;
      }
      localObject1 = this.BtQ;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject2 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject2).hasNext()) {
        break label824;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (i < 0) {
        j.iBO();
      }
      localObject4 = (String)localObject1;
      localObject3 = localcsf.mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.i.AAy;
      str = Util.nullAsNil((String)j.M((List)this.Btl, i));
      p.j(str, "Util.nullAsNil(thumbFileList.getOrNull(index))");
      if (this.BtR.size() <= i) {
        break label819;
      }
    }
    label800:
    label805:
    label819:
    for (localObject1 = (css)this.BtR.get(i);; localObject1 = null)
    {
      localObject1 = com.tencent.mm.plugin.finder.upload.i.a((String)localObject4, str, (css)localObject1, this.coverUrl);
      localObject4 = new bea();
      ((bea)localObject4).SPg = this.BtT;
      ((csg)localObject1).codec_info = ((bea)localObject4);
      Log.i(TAG, "codec_info video_cover_score:" + this.BtT);
      ((LinkedList)localObject3).add(localObject1);
      i += 1;
      break label625;
      i = 0;
      break;
      i = 0;
      break label596;
      Log.i(TAG, "video list null");
      i = 0;
      break label596;
    }
    label824:
    localObject1 = aj.AGc;
    localObject1 = new g(true, aj.a(localcsf), localcsf, this.ABe);
    AppMethodBeat.o(282587);
    return localObject1;
    label856:
    localObject1 = new g(false, 0, null);
    AppMethodBeat.o(282587);
    return localObject1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget$Companion;", "", "()V", "REQUEST_SELECT_COVER", "", "getREQUEST_SELECT_COVER", "()I", "RESULT_COVER_PATH", "", "getRESULT_COVER_PATH", "()Ljava/lang/String;", "RESULT_COVER_QUALITY", "getRESULT_COVER_QUALITY", "RESULT_CROP_INFO", "getRESULT_CROP_INFO", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$2"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(aa.f paramf, f paramf1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$3"})
  static final class c
    implements View.OnClickListener
  {
    c(aa.f paramf, f paramf1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291117);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      paramView = aj.AGc;
      if (aj.isAnyEnableFullScreenEnjoy())
      {
        paramView = com.tencent.mm.ui.component.g.Xox;
        ((c)com.tencent.mm.ui.component.g.lm(jdField_this.context).i(c.class)).dEm();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291117);
        return;
        paramView = new csf();
        localObject1 = paramView.mediaList;
        Object localObject2 = com.tencent.mm.plugin.finder.upload.i.AAy;
        localObject2 = jdField_this.BtS;
        if (localObject2 == null) {
          p.iCn();
        }
        ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.a((acu)localObject2, f.c(jdField_this), (String)this.Buc.aaBC, f.a(jdField_this), f.b(jdField_this)));
        localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject1 = jdField_this.context;
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(291117);
          throw paramView;
        }
        localObject1 = (Activity)localObject1;
        localObject2 = (View)f.d(jdField_this);
        Object localObject3 = jdField_this.context;
        if (localObject3 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(291117);
          throw paramView;
        }
        localObject3 = ((MMActivity)localObject3).getWindow();
        p.j(localObject3, "(context as MMActivity).window");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, ViewAnimHelper.q((View)localObject2, ((Window)localObject3).getDecorView()), paramView, jdField_this.ABc, false, false, 48);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$4"})
  static final class d
    implements View.OnClickListener
  {
    d(aa.f paramf, f paramf1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269441);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      paramView = new csf();
      localObject1 = paramView.mediaList;
      Object localObject2 = com.tencent.mm.plugin.finder.upload.i.AAy;
      localObject2 = jdField_this.BtS;
      if (localObject2 == null) {
        p.iCn();
      }
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.a((acu)localObject2, f.c(jdField_this), (String)this.Buc.aaBC, f.a(jdField_this), f.b(jdField_this)));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = jdField_this.context;
      if (localObject1 == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(269441);
        throw paramView;
      }
      localObject1 = (Activity)localObject1;
      localObject2 = (View)f.d(jdField_this);
      Object localObject3 = jdField_this.context;
      if (localObject3 == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(269441);
        throw paramView;
      }
      localObject3 = ((MMActivity)localObject3).getWindow();
      p.j(localObject3, "(context as MMActivity).window");
      localObject2 = ViewAnimHelper.q((View)localObject2, ((Window)localObject3).getDecorView());
      p.j(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
      localObject3 = f.Bub;
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, f.emI());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269441);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274951);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      f.e(this.Bud);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274951);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(f paramf, ArrayList paramArrayList)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap, aa.a parama, f.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(290269);
        f.a locala = f.Bub;
        Log.i(f.access$getTAG$cp(), "set coverUrl");
        f.a(this.Bui.Bud, this.Bug);
        f.d(this.Bui.Bud).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(290309);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            this.Buj.Bui.Bud.emG();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(290309);
          }
        });
        AppMethodBeat.o(290269);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$2$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$2"})
    static final class b
      implements Runnable
    {
      b(String paramString, int paramInt, aa.a parama, Bitmap paramBitmap, f.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(285566);
        if (this.Buh.aaBx)
        {
          f.a(this.Bui.Bud, this.BtO);
          f.d(this.Bui.Bud).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(288715);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              this.Buk.Bui.Bud.emG();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(288715);
            }
          });
        }
        AppMethodBeat.o(285566);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265068);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Bud.emG();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265068);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.f
 * JD-Core Version:    0.7.0.1
 */