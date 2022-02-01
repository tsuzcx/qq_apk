package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.ui.post.PostMainUIC;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.r;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCompositionInfo", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCompositionInfo", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "container", "Landroid/view/View;", "coverQuality", "", "coverUrl", "", "cropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getCropInfoList", "()Ljava/util/ArrayList;", "setCropInfoList", "(Ljava/util/ArrayList;)V", "extraMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "halfRect", "Landroid/graphics/Rect;", "halfThumbUrl", "longVideoCropInfo", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Landroid/widget/ImageView;", "thumbLocalUrl", "videoFileList", "getVideoFileList", "setVideoFileList", "videoPathBeforeCut", "adjustMargin", "", "width", "height", "checkData", "", "checkFileExist", "delMedia", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "getVideoLen", "", "inflateView", "initCropInfo", "initFakeVideoLogic", "initLongVideoCropInfo", "initNormalVideoLogic", "jumpSelectCoverUI", "jumpToPreviewLongVideo", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "setLocalThumbUrl", "thumbUrl", "showThumb", "thumb", "Landroid/graphics/Bitmap;", "Companion", "plugin-finder_release"})
public final class f
  extends a
{
  private static final String TAG = "Finder.PostVideoWidget";
  private static final int wDp = 1001;
  private static final String wDq = "RESULT_COVER_PATH";
  private static final String wDr = "RESULT_COVER_QUALITY";
  private static final String wDs = "RESULT_CROP_INFO";
  public static final a wDt;
  private String coverUrl;
  private View jxm;
  private View lJI;
  private azk musicInfo;
  private String vTB;
  private View wCA;
  ArrayList<String> wCD;
  private clp wCE;
  private String wCj;
  private ImageView wCz;
  public ArrayList<String> wDi;
  ArrayList<cjx> wDj;
  public acn wDk;
  private int wDl;
  private String wDm;
  private Rect wDn;
  public cjx wDo;
  
  static
  {
    AppMethodBeat.i(168626);
    wDt = new a((byte)0);
    wDp = 1001;
    wDq = "RESULT_COVER_PATH";
    wDr = "RESULT_COVER_QUALITY";
    wDs = "RESULT_CROP_INFO";
    TAG = "Finder.PostVideoWidget";
    AppMethodBeat.o(168626);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168625);
    this.wCD = new ArrayList();
    this.wDj = new ArrayList();
    this.wCj = "";
    this.coverUrl = "";
    this.wDm = "";
    this.vTB = "";
    AppMethodBeat.o(168625);
  }
  
  private final void awX(String paramString)
  {
    AppMethodBeat.i(256143);
    if (!Util.isNullOrNil(this.coverUrl)) {
      paramString = this.coverUrl;
    }
    this.wCj = paramString;
    AppMethodBeat.o(256143);
  }
  
  private final boolean dJo()
  {
    AppMethodBeat.i(256142);
    Object localObject1 = this.dQL;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getByteArray("video_composition");
      if (localObject1 != null)
      {
        Object localObject3;
        try
        {
          Log.i(TAG, "initFakeVideoLogic");
          localObject3 = this.jxm;
          if (localObject3 == null) {
            p.btv("container");
          }
          ((View)localObject3).setVisibility(0);
          localObject1 = new acn().parseFrom((byte[])localObject1);
          if (localObject1 != null) {
            break label117;
          }
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CompositionInfo");
          AppMethodBeat.o(256142);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localIOException, "parse error", new Object[0]);
        }
        AppMethodBeat.o(256142);
        return true;
        label117:
        this.wDk = ((acn)localIOException);
        Object localObject2 = this.dQL;
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("VIDEO_THUMB_LIST");
          label142:
          localObject3 = new z.f();
          ((z.f)localObject3).SYG = "";
          if (localObject2 != null) {
            if (((Collection)localObject2).isEmpty()) {
              break label307;
            }
          }
        }
        label307:
        for (int i = 1;; i = 0)
        {
          if (i == 1)
          {
            localObject2 = j.ks((List)localObject2);
            p.g(localObject2, "mediaThumbList.first()");
            ((z.f)localObject3).SYG = ((String)localObject2);
          }
          awX((String)((z.f)localObject3).SYG);
          com.tencent.mm.ac.d.b("PostVideoWidget_initFakeVideoLogic", (kotlin.g.a.a)new b((z.f)localObject3, this));
          localObject2 = this.wCz;
          if (localObject2 == null) {
            p.btv("thumbIv");
          }
          ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new c((z.f)localObject3, this));
          localObject2 = this.lJI;
          if (localObject2 == null) {
            p.btv("rootView");
          }
          ((View)localObject2).findViewById(2131307520).setOnClickListener((View.OnClickListener)new d((z.f)localObject3, this));
          break;
          localObject2 = null;
          break label142;
        }
      }
    }
    AppMethodBeat.o(256142);
    return false;
  }
  
  private final void dJp()
  {
    AppMethodBeat.i(256144);
    Bundle localBundle = this.dQL;
    if (localBundle != null)
    {
      Object localObject2 = localBundle.getString("video_before_cut_path");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.vTB = ((String)localObject1);
      localObject1 = localBundle.getParcelableArrayList("VIDEO_CROP_LIST");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        this.wDj.clear();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof LocalVideoCropInfoParcelable))) {
            this.wDj.add(((LocalVideoCropInfoParcelable)localObject2).uOR);
          } else {
            this.wDj.add(null);
          }
        }
      }
      AppMethodBeat.o(256144);
      return;
    }
    AppMethodBeat.o(256144);
  }
  
  private final void gy(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(256141);
    Object localObject1 = this.lJI;
    if (localObject1 == null) {
      p.btv("rootView");
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
      localObject1 = (TextView)((View)localObject1).findViewById(2131306075);
      label106:
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label255;
      }
      localObject2 = y.vXH;
      if (!y.bk(paramInt2 / paramInt1)) {
        break label255;
      }
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099844));
      }
      localObject1 = this.lJI;
      if (localObject1 == null) {
        p.btv("rootView");
      }
      localObject1 = ((View)localObject1).findViewById(2131302298);
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
      AppMethodBeat.o(256141);
      return;
      localObject1 = null;
      break;
      label250:
      localObject1 = null;
      break label106;
      label255:
      if (localLayoutParams != null)
      {
        localObject2 = this.lJI;
        if (localObject2 == null) {
          p.btv("rootView");
        }
        Resources localResources = ((View)localObject2).getResources();
        localObject2 = localObject3;
        if (localResources != null) {
          localObject2 = Integer.valueOf((int)localResources.getDimension(2131165304));
        }
        localLayoutParams.topMargin = ((Integer)localObject2).intValue();
      }
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100904));
      }
      localObject1 = this.lJI;
      if (localObject1 == null) {
        p.btv("rootView");
      }
      localObject1 = ((View)localObject1).findViewById(2131302298);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    label385:
    AppMethodBeat.o(256141);
  }
  
  public final boolean cyn()
  {
    AppMethodBeat.i(256145);
    Object localObject2;
    if (this.wDk != null)
    {
      localObject1 = this.wDk;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((acn)localObject1).Lnd;
      p.g(localObject1, "compositionInfo!!.tracks");
      localObject1 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ejf)((Iterator)localObject1).next();
      } while (s.YS(((ejf)localObject2).path));
      Log.i(TAG, "[compositionInfo]video widget file:" + ((ejf)localObject2).path + " lost!");
      AppMethodBeat.o(256145);
      return false;
    }
    Object localObject1 = this.wDi;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!s.YS((String)localObject2))
        {
          Log.i(TAG, "[videoFileList]video widget file:" + (String)localObject2 + " lost!");
          AppMethodBeat.o(256145);
          return false;
        }
      }
    }
    AppMethodBeat.o(256145);
    return true;
  }
  
  public final void dIX()
  {
    AppMethodBeat.i(256146);
    this.wDi = null;
    this.wCD.clear();
    this.wDj.clear();
    this.wDk = null;
    this.wCE = null;
    this.musicInfo = null;
    this.wCj = null;
    this.coverUrl = "";
    this.wDl = 0;
    this.wDm = "";
    this.wDn = null;
    AppMethodBeat.o(256146);
  }
  
  public final View dJg()
  {
    AppMethodBeat.i(168622);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168622);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getLayoutInflater().inflate(2131494579, null);
    p.g(localObject, "(context as Activity).la…_post_video_widget, null)");
    this.lJI = ((View)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    localObject = ((View)localObject).findViewById(2131309736);
    p.g(localObject, "rootView.findViewById(R.id.video_container)");
    this.jxm = ((View)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    localObject = ((View)localObject).findViewById(2131309076);
    p.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.wCz = ((ImageView)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306958);
    p.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.wCA = ((View)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    AppMethodBeat.o(168622);
    return localObject;
  }
  
  public final g dJh()
  {
    AppMethodBeat.i(256140);
    cjk localcjk = new cjk();
    Object localObject1 = this.dQL;
    label55:
    label78:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_ID");
      localcjk.vMX = ((String)localObject1);
      localObject1 = this.dQL;
      if (localObject1 == null) {
        break label389;
      }
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_PATH");
      localcjk.vMV = ((String)localObject1);
      localObject1 = this.dQL;
      if (localObject1 == null) {
        break label394;
      }
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_BGM_URL");
      localcjk.MoK = ((String)localObject1);
      localObject1 = this.dQL;
      if (localObject1 == null) {
        break label399;
      }
      bool = ((Bundle)localObject1).getBoolean("MEDIA_IS_MUTE", false);
      label102:
      localcjk.wCu = bool;
      localObject1 = this.dQL;
      if (localObject1 == null) {
        break label404;
      }
      bool = ((Bundle)localObject1).getBoolean("MUSIC_IS_MUTE", false);
      label126:
      localcjk.wCv = bool;
      localObject1 = this.dQL;
      if (localObject1 == null) {
        break label409;
      }
    }
    Object localObject2;
    label257:
    Object localObject3;
    label389:
    label394:
    label399:
    label404:
    label409:
    for (int i = ((Bundle)localObject1).getInt("SOUND_TRACK_TYPE", 0);; i = 0)
    {
      localcjk.soundTrackType = i;
      localcjk.MoJ = this.musicInfo;
      Log.i(TAG, "getUploadData: " + localcjk.vMX + ", " + localcjk.wCv);
      if (this.wDk == null) {
        break label414;
      }
      localObject1 = this.dQL;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getStringArrayList("VIDEO_THUMB_LIST");
        if (localObject1 != null)
        {
          localObject2 = (String)j.ks((List)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label257;
          }
        }
      }
      localObject1 = "";
      localObject2 = localcjk.mediaList;
      localObject3 = i.vSX;
      localObject3 = this.wDk;
      if (localObject3 == null) {
        p.hyc();
      }
      localObject1 = i.a((acn)localObject3, this.wDm, (String)localObject1, this.coverUrl, this.wDn);
      localObject3 = new ayg();
      ((ayg)localObject3).LIu = this.wDl;
      ((cjl)localObject1).codec_info = ((ayg)localObject3);
      Log.i(TAG, "codec_info video_cover_score:" + this.wDl);
      ((LinkedList)localObject2).add(localObject1);
      localObject1 = new g(true, 4, localcjk, this.vTB);
      AppMethodBeat.o(256140);
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
    }
    label414:
    if ((this.vTz != null) && (this.wCb != null))
    {
      localObject1 = new g(true, 4, this.wCb);
      AppMethodBeat.o(256140);
      return localObject1;
    }
    localObject1 = (Collection)this.wDi;
    label568:
    label597:
    Object localObject4;
    String str;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label777;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("video list ");
      localObject3 = this.wDi;
      if (localObject3 == null) {
        p.hyc();
      }
      Log.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.wCD.size());
      localObject1 = this.wDi;
      if (localObject1 == null) {
        p.hyc();
      }
      if (((ArrayList)localObject1).size() != this.wCD.size()) {
        break label772;
      }
      i = 1;
      if (i == 0) {
        break label828;
      }
      localObject1 = this.wDi;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject2 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject2).hasNext()) {
        break label796;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (i < 0) {
        j.hxH();
      }
      localObject4 = (String)localObject1;
      localObject3 = localcjk.mediaList;
      localObject1 = i.vSX;
      str = Util.nullAsNil((String)j.L((List)this.wCD, i));
      p.g(str, "Util.nullAsNil(thumbFileList.getOrNull(index))");
      if (this.wDj.size() <= i) {
        break label791;
      }
    }
    label772:
    label777:
    label791:
    for (localObject1 = (cjx)this.wDj.get(i);; localObject1 = null)
    {
      localObject1 = i.a((String)localObject4, str, (cjx)localObject1, this.coverUrl);
      localObject4 = new ayg();
      ((ayg)localObject4).LIu = this.wDl;
      ((cjl)localObject1).codec_info = ((ayg)localObject4);
      Log.i(TAG, "codec_info video_cover_score:" + this.wDl);
      ((LinkedList)localObject3).add(localObject1);
      i += 1;
      break label597;
      i = 0;
      break;
      i = 0;
      break label568;
      Log.i(TAG, "video list null");
      i = 0;
      break label568;
    }
    label796:
    localObject1 = y.vXH;
    localObject1 = new g(true, y.a(localcjk), localcjk, this.vTB);
    AppMethodBeat.o(256140);
    return localObject1;
    label828:
    localObject1 = new g(false, 0, null);
    AppMethodBeat.o(256140);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject4 = null;
    AppMethodBeat.i(168624);
    super.refresh();
    Object localObject1 = this.dQL;
    if (localObject1 != null)
    {
      localObject5 = ((Bundle)localObject1).getByteArray("MEDIA_EXTRA_MUSIC");
      if (localObject5 != null) {
        localObject1 = (com.tencent.mm.bw.a)new clp();
      }
    }
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject5);
      this.wCE = ((clp)localObject1);
      localObject5 = TAG;
      localObject6 = new StringBuilder("post video with music: ");
      localObject1 = this.wCE;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((clp)localObject1).MqO);
        Log.i((String)localObject5, localObject1);
        localObject1 = i.vSX;
        this.musicInfo = i.a(this.wCE);
        localObject1 = this.dQL;
        if (localObject1 != null)
        {
          localObject5 = ((Bundle)localObject1).getByteArray("ORIGIN_MUSIC_INFO");
          if (localObject5 != null) {
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
          ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject5);
          this.musicInfo = ((azk)localObject1);
          localObject1 = this.dQL;
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
          localObject1 = this.dQL;
          if (localObject1 == null) {
            break;
          }
          i = ((Bundle)localObject1).getInt("VIDEO_COVER_QUALITY", 0);
          this.wDl = i;
          localObject1 = this.dQL;
          if (localObject1 == null) {
            break label376;
          }
          localObject1 = ((Bundle)localObject1).getParcelableArrayList("HALF_RECT_LIST");
          if (localObject1 == null) {
            break label376;
          }
          localObject1 = (Rect)j.L((List)localObject1, 0);
          this.wDn = ((Rect)localObject1);
          if (!s.YS(this.coverUrl))
          {
            this.coverUrl = "";
            this.wDl = 0;
          }
          localObject1 = this.dQL;
          if (localObject1 == null) {
            break label381;
          }
          localObject1 = ((Bundle)localObject1).getByteArray("video_composition");
          if (localObject1 == null) {
            break label386;
          }
          dJo();
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
        if (this.wCb != null)
        {
          localObject3 = this.wCb;
          if (localObject3 == null) {
            p.hyc();
          }
          if (!Util.isNullOrNil((List)((cjk)localObject3).mediaList))
          {
            localObject3 = this.jxm;
            if (localObject3 == null) {
              p.btv("container");
            }
            ((View)localObject3).setVisibility(0);
            localObject3 = this.wCA;
            if (localObject3 == null) {
              p.btv("reprintIv");
            }
            ((View)localObject3).setVisibility(0);
            localObject3 = this.wCb;
            if (localObject3 == null) {
              p.hyc();
            }
            localObject3 = ((cjk)localObject3).mediaList;
            p.g(localObject3, "refFeedContent!!.mediaList");
            localObject3 = (cjl)((LinkedList)localObject3).getFirst();
            localObject4 = y.vXH;
            localObject4 = y.go((int)((cjl)localObject3).width, (int)((cjl)localObject3).height);
            localObject5 = this.wCz;
            if (localObject5 == null) {
              p.btv("thumbIv");
            }
            ((ImageView)localObject5).getLayoutParams().width = ((Number)((r)localObject4).second).intValue();
            localObject5 = this.wCz;
            if (localObject5 == null) {
              p.btv("thumbIv");
            }
            ((ImageView)localObject5).getLayoutParams().height = ((Number)((r)localObject4).SWY).intValue();
            localObject5 = this.wCz;
            if (localObject5 == null) {
              p.btv("thumbIv");
            }
            i = ((ImageView)localObject5).getLayoutParams().width;
            localObject5 = this.wCz;
            if (localObject5 == null) {
              p.btv("thumbIv");
            }
            gy(i, ((ImageView)localObject5).getLayoutParams().height);
            localObject5 = this.wCz;
            if (localObject5 == null) {
              p.btv("thumbIv");
            }
            ((ImageView)localObject5).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject4.first).intValue()]);
            localObject4 = this.wCz;
            if (localObject4 == null) {
              p.btv("thumbIv");
            }
            ((ImageView)localObject4).requestLayout();
            p.g(localObject3, "mediaObj");
            localObject3 = new k((cjl)localObject3, com.tencent.mm.plugin.finder.storage.x.vEo, null, null, 12);
            localObject4 = m.uJa;
            localObject4 = m.djY();
            localObject5 = this.wCz;
            if (localObject5 == null) {
              p.btv("thumbIv");
            }
            localObject6 = m.uJa;
            ((com.tencent.mm.loader.d)localObject4).a(localObject3, (ImageView)localObject5, m.a(m.a.uJb));
            localObject3 = this.wCz;
            if (localObject3 == null) {
              p.btv("thumbIv");
            }
            ((ImageView)localObject3).setOnClickListener((View.OnClickListener)new g(this));
            AppMethodBeat.o(168624);
            return;
          }
        }
        localObject3 = this.dQL;
        if (localObject3 == null) {
          break label1005;
        }
      }
    }
    Object localObject3 = ((Bundle)localObject3).getStringArrayList("video_file_list");
    this.wDi = ((ArrayList)localObject3);
    Object localObject5 = this.dQL;
    localObject3 = localObject4;
    if (localObject5 != null) {
      localObject3 = ((Bundle)localObject5).getStringArrayList("VIDEO_THUMB_LIST");
    }
    localObject4 = this.dQL;
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
    localObject4 = this.dQL;
    if (localObject4 != null)
    {
      i = ((Bundle)localObject4).getInt("VIDEO_COVER_QUALITY", 0);
      label888:
      this.wDl = i;
      dJp();
      localObject4 = (Collection)this.wDi;
      if ((localObject4 != null) && (!((Collection)localObject4).isEmpty())) {
        break label1015;
      }
    }
    label1005:
    label1015:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject4 = this.lJI;
        if (localObject4 == null) {
          p.btv("rootView");
        }
        ((View)localObject4).findViewById(2131307520).setOnClickListener((View.OnClickListener)new e(this));
        localObject4 = this.jxm;
        if (localObject4 == null) {
          p.btv("container");
        }
        ((View)localObject4).setVisibility(0);
        com.tencent.mm.ac.d.c("Finder_Post_Create_Video_Thumb", (kotlin.g.a.a)new f(this, (ArrayList)localObject3));
      }
      AppMethodBeat.o(168624);
      return;
      localObject3 = null;
      break;
      i = 0;
      break label888;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget$Companion;", "", "()V", "REQUEST_SELECT_COVER", "", "getREQUEST_SELECT_COVER", "()I", "RESULT_COVER_PATH", "", "getRESULT_COVER_PATH", "()Ljava/lang/String;", "RESULT_COVER_QUALITY", "getRESULT_COVER_QUALITY", "RESULT_CROP_INFO", "getRESULT_CROP_INFO", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    b(z.f paramf, f paramf1)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$2"})
  static final class c
    implements View.OnClickListener
  {
    c(z.f paramf, f paramf1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256131);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      paramView = y.vXH;
      if (y.isAnyEnableFullScreenEnjoy())
      {
        paramView = com.tencent.mm.ui.component.a.PRN;
        ((PostMainUIC)com.tencent.mm.ui.component.a.ko(jdField_this.context).get(PostMainUIC.class)).dAN();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256131);
        return;
        paramView = new cjk();
        localObject1 = paramView.mediaList;
        Object localObject2 = i.vSX;
        localObject2 = jdField_this.wDk;
        if (localObject2 == null) {
          p.hyc();
        }
        ((LinkedList)localObject1).add(i.a((acn)localObject2, f.d(jdField_this), (String)this.wDu.SYG, f.b(jdField_this), f.c(jdField_this)));
        localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject1 = jdField_this.context;
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(256131);
          throw paramView;
        }
        localObject1 = (Activity)localObject1;
        localObject2 = (View)f.e(jdField_this);
        Object localObject3 = jdField_this.context;
        if (localObject3 == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(256131);
          throw paramView;
        }
        localObject3 = ((MMActivity)localObject3).getWindow();
        p.g(localObject3, "(context as MMActivity).window");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, ViewAnimHelper.q((View)localObject2, ((Window)localObject3).getDecorView()), paramView, jdField_this.vTz, false, 16);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$3"})
  static final class d
    implements View.OnClickListener
  {
    d(z.f paramf, f paramf1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256132);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      paramView = new cjk();
      localObject1 = paramView.mediaList;
      Object localObject2 = i.vSX;
      localObject2 = jdField_this.wDk;
      if (localObject2 == null) {
        p.hyc();
      }
      ((LinkedList)localObject1).add(i.a((acn)localObject2, f.d(jdField_this), (String)this.wDu.SYG, f.b(jdField_this), f.c(jdField_this)));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject1 = jdField_this.context;
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(256132);
        throw paramView;
      }
      localObject1 = (Activity)localObject1;
      localObject2 = (View)f.e(jdField_this);
      Object localObject3 = jdField_this.context;
      if (localObject3 == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(256132);
        throw paramView;
      }
      localObject3 = ((MMActivity)localObject3).getWindow();
      p.g(localObject3, "(context as MMActivity).window");
      localObject2 = ViewAnimHelper.q((View)localObject2, ((Window)localObject3).getDecorView());
      p.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
      localObject3 = f.wDt;
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, f.dJq());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256132);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256133);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      f.f(this.wDv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256133);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    f(f paramf, ArrayList paramArrayList)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap, z.a parama, f.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(256135);
        f.a locala = f.wDt;
        Log.i(f.access$getTAG$cp(), "set coverUrl");
        f.a(this.wDA.wDv, this.wDy);
        f.e(this.wDA.wDv).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(256134);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            f.a(this.wDB.wDA.wDv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256134);
          }
        });
        AppMethodBeat.o(256135);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$2$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$2"})
    static final class b
      implements Runnable
    {
      b(String paramString, int paramInt, z.a parama, Bitmap paramBitmap, f.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(256137);
        if (this.wDz.SYB)
        {
          f.a(this.wDA.wDv, this.wDg);
          f.e(this.wDA.wDv).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(256136);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              f.a(this.wDC.wDA.wDv);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(256136);
            }
          });
        }
        AppMethodBeat.o(256137);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256139);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      f.a(this.wDv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256139);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.f
 * JD-Core Version:    0.7.0.1
 */