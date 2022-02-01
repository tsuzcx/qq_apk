package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.post.f;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.fos;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCompositionInfo", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCompositionInfo", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "container", "Landroid/view/View;", "coverQuality", "", "coverUrl", "", "cropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getCropInfoList", "()Ljava/util/ArrayList;", "setCropInfoList", "(Ljava/util/ArrayList;)V", "extraMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "fullCoverUrl", "halfRect", "Landroid/graphics/Rect;", "halfThumbUrl", "longVideoCropInfo", "maskView", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Landroid/widget/ImageView;", "thumbLocalUrl", "videoFileList", "getVideoFileList", "setVideoFileList", "videoPathBeforeCut", "adjustMargin", "", "width", "height", "checkData", "", "checkFileExist", "delMedia", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "getVideoLen", "", "inflateView", "initCropInfo", "initFakeVideoLogic", "initLongVideoCropInfo", "initNormalVideoLogic", "jumpSelectCoverUI", "jumpToPreviewLongVideo", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "refreshByIntent", "setLocalThumbUrl", "thumbUrl", "showThumb", "thumb", "Landroid/graphics/Bitmap;", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  public static final a HaE;
  private static final int HaN;
  private static final String HaO;
  private static final String HaP;
  private static final String HaQ;
  private static final String HaR;
  private static final String TAG;
  private String GZE;
  private String Gcs;
  ArrayList<String> HaF;
  ArrayList<dju> HaG;
  public afb HaH;
  private String HaI;
  private int HaJ;
  private String HaK;
  private Rect HaL;
  private dju HaM;
  private ImageView Hai;
  private View Haj;
  ArrayList<String> Ham;
  private dls Han;
  private String coverUrl;
  private View hDw;
  private View maskView;
  private bqj musicInfo;
  private View rootView;
  
  static
  {
    AppMethodBeat.i(168626);
    HaE = new a((byte)0);
    HaN = 1001;
    HaO = "RESULT_COVER_FULL_PATH";
    HaP = "RESULT_COVER_PATH";
    HaQ = "RESULT_COVER_QUALITY";
    HaR = "RESULT_CROP_INFO";
    TAG = "Finder.PostVideoWidget";
    AppMethodBeat.o(168626);
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168625);
    this.Ham = new ArrayList();
    this.HaG = new ArrayList();
    this.GZE = "";
    this.coverUrl = "";
    this.HaI = "";
    this.HaK = "";
    this.Gcs = "";
    AppMethodBeat.o(168625);
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(330834);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramView = com.tencent.mm.ui.component.k.aeZF;
    ((f)com.tencent.mm.ui.component.k.nq(paramg.getContext()).q(f.class)).eHz();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330834);
  }
  
  private static final void a(g paramg, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg1, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(330820);
    s.u(paramg, "this$0");
    if (paramBitmap != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramg, paramBitmap));
    }
    AppMethodBeat.o(330820);
  }
  
  private static final void a(g paramg, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(330866);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramg);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramg, "this$0");
    s.u(paramf, "$thumbUrl");
    localObject1 = new djh();
    paramView = ((djh)localObject1).mediaList;
    localObject2 = com.tencent.mm.plugin.finder.upload.i.Gcb;
    localObject2 = paramg.HaH;
    s.checkNotNull(localObject2);
    paramView.add(com.tencent.mm.plugin.finder.upload.i.a((afb)localObject2, paramg.HaK, (String)paramf.aqH, paramg.coverUrl, paramg.HaI, paramg.HaL));
    paramf = com.tencent.mm.plugin.finder.utils.a.GfO;
    localObject2 = (Activity)paramg.getContext();
    paramView = paramg.Hai;
    paramf = paramView;
    if (paramView == null)
    {
      s.bIx("thumbIv");
      paramf = null;
    }
    paramg = ViewAnimHelper.z((View)paramf, ((MMActivity)paramg.getContext()).getWindow().getDecorView());
    s.s(paramg, "getViewInfo(thumbIv, (co…tivity).window.decorView)");
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject2, paramg, (djh)localObject1, HaN);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330866);
  }
  
  private static final void a(LinkedList paramLinkedList, g paramg, View paramView)
  {
    AppMethodBeat.i(330843);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramLinkedList);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramg);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramg, "this$0");
    localObject1 = new djh();
    paramView = ((djh)localObject1).mediaList;
    if (paramLinkedList == null) {}
    for (paramLinkedList = (Collection)new LinkedList();; paramLinkedList = (Collection)paramLinkedList)
    {
      paramView.addAll(paramLinkedList);
      paramLinkedList = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject2 = (Activity)paramg.getContext();
      paramView = paramg.Hai;
      paramLinkedList = paramView;
      if (paramView == null)
      {
        s.bIx("thumbIv");
        paramLinkedList = null;
      }
      paramLinkedList = ViewAnimHelper.z((View)paramLinkedList, ((MMActivity)paramg.getContext()).getWindow().getDecorView());
      s.s(paramLinkedList, "getViewInfo(thumbIv, (co…tivity).window.decorView)");
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject2, paramLinkedList, (djh)localObject1, HaN);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(330843);
      return;
    }
  }
  
  private final void aCX(String paramString)
  {
    AppMethodBeat.i(330795);
    if (!Util.isNullOrNil(this.coverUrl)) {
      paramString = this.coverUrl;
    }
    this.GZE = paramString;
    AppMethodBeat.o(330795);
  }
  
  private static final void b(g paramg, View paramView)
  {
    AppMethodBeat.i(330852);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramView = com.tencent.mm.ui.component.k.aeZF;
    ((f)com.tencent.mm.ui.component.k.nq(paramg.getContext()).q(f.class)).eHz();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330852);
  }
  
  private static final void c(g paramg, View paramView)
  {
    AppMethodBeat.i(330874);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramg.fqN();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330874);
  }
  
  private final boolean fqM()
  {
    AppMethodBeat.i(330756);
    Object localObject1 = fqx();
    Object localObject4;
    Object localObject3;
    label124:
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject4 = ((Bundle)localObject1).getByteArray("video_composition");
      if (localObject4 != null)
      {
        try
        {
          Log.i(TAG, "initFakeVideoLogic");
          localObject3 = this.hDw;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("container");
            localObject1 = null;
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = new afb().parseFrom((byte[])localObject4);
          if (localObject1 != null) {
            break label124;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CompositionInfo");
          AppMethodBeat.o(330756);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localIOException, "parse error", new Object[0]);
        }
        AppMethodBeat.o(330756);
        return true;
        this.HaH = ((afb)localIOException);
        if (this.HaL != null)
        {
          localObject2 = this.HaL;
          if ((localObject2 == null) || (((Rect)localObject2).isEmpty() != true)) {
            break label451;
          }
          i = 1;
          break label434;
        }
        this.HaL = new Rect();
        localObject2 = this.HaH;
        if (localObject2 != null)
        {
          localObject2 = ((afb)localObject2).TYB;
          if (localObject2 != null) {
            break label383;
          }
          localObject2 = null;
          label192:
          localObject3 = this.HaL;
          s.checkNotNull(localObject3);
          com.tencent.mm.plugin.vlog.model.h.a((enx)localObject2, (Rect)localObject3);
        }
      }
    }
    label416:
    label421:
    label434:
    label441:
    label451:
    label454:
    for (;;)
    {
      localObject2 = fqx();
      if (localObject2 == null)
      {
        localObject2 = null;
        label217:
        localObject4 = new ah.f();
        ((ah.f)localObject4).aqH = "";
        if (localObject2 == null) {
          break label421;
        }
        if (((Collection)localObject2).isEmpty()) {
          break label416;
        }
        i = 1;
        break label441;
      }
      for (;;)
      {
        label254:
        if (i != 0)
        {
          localObject2 = kotlin.a.p.oK((List)localObject2);
          s.s(localObject2, "mediaThumbList.first()");
          ((ah.f)localObject4).aqH = localObject2;
        }
        aCX((String)((ah.f)localObject4).aqH);
        com.tencent.mm.ae.d.d("PostVideoWidget_initFakeVideoLogic", (kotlin.g.a.a)new b(this, (ah.f)localObject4));
        localObject3 = this.Hai;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("thumbIv");
          localObject2 = null;
        }
        ((ImageView)localObject2).setOnClickListener(new g..ExternalSyntheticLambda0(this));
        localObject3 = this.rootView;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("rootView");
          localObject2 = null;
        }
        ((View)localObject2).findViewById(l.e.select_cover_btn_container).setOnClickListener(new g..ExternalSyntheticLambda3(this, (ah.f)localObject4));
        break;
        label383:
        localObject2 = ((afc)localObject2).Znw;
        if (localObject2 == null)
        {
          localObject2 = null;
          break label192;
        }
        localObject2 = ((dzm)localObject2).Zqq;
        break label192;
        localObject2 = ((Bundle)localObject2).getStringArrayList("VIDEO_THUMB_LIST");
        break label217;
        i = 0;
        break label441;
        i = 0;
      }
      AppMethodBeat.o(330756);
      return false;
      for (;;)
      {
        if (i == 0) {
          break label454;
        }
        break;
        if (i != 1) {
          break label421;
        }
        i = 1;
        break label254;
        i = 0;
      }
    }
  }
  
  private final void fqN()
  {
    boolean bool = false;
    AppMethodBeat.i(330777);
    djh localdjh = new djh();
    Object localObject1 = this.HaF;
    s.checkNotNull(localObject1);
    Object localObject2 = ((Iterable)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject3 = (String)localObject1;
      LinkedList localLinkedList = localdjh.mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.i.Gcb;
      String str = Util.nullAsNil((String)kotlin.a.p.ae((List)this.Ham, i));
      s.s(str, "nullAsNil(thumbFileList.getOrNull(index))");
      if (this.HaG.size() > i) {}
      for (localObject1 = (dju)this.HaG.get(i);; localObject1 = null)
      {
        localLinkedList.add(com.tencent.mm.plugin.finder.upload.i.a((String)localObject3, str, (dju)localObject1, this.coverUrl, this.HaI));
        i += 1;
        break;
      }
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
    Object localObject3 = (Activity)getContext();
    localObject2 = this.Hai;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("thumbIv");
      localObject1 = null;
    }
    localObject1 = ViewAnimHelper.z((View)localObject1, ((MMActivity)getContext()).getWindow().getDecorView());
    s.s(localObject1, "getViewInfo(thumbIv, (co…tivity).window.decorView)");
    i = HaN;
    localObject2 = fqx();
    if (localObject2 == null) {}
    for (;;)
    {
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (ViewAnimHelper.ViewInfo)localObject1, localdjh, i, bool);
      AppMethodBeat.o(330777);
      return;
      bool = ((Bundle)localObject2).getBoolean("post_long_video", false);
    }
  }
  
  private final void fqP()
  {
    AppMethodBeat.i(330809);
    Bundle localBundle = fqx();
    if (localBundle != null)
    {
      Object localObject2 = localBundle.getString("video_before_cut_path");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.Gcs = ((String)localObject1);
      localObject1 = localBundle.getParcelableArrayList("VIDEO_CROP_LIST");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        this.HaG.clear();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof LocalVideoCropInfoParcelable))) {
            this.HaG.add(((LocalVideoCropInfoParcelable)localObject2).EDC);
          } else {
            this.HaG.add(null);
          }
        }
      }
    }
    AppMethodBeat.o(330809);
  }
  
  public final void bDL()
  {
    int j = 1;
    Object localObject5 = null;
    Object localObject4 = null;
    AppMethodBeat.i(168624);
    super.bDL();
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.nq(getContext()).q(com.tencent.mm.plugin.finder.post.i.class);
    s.s(localObject1, "UICProvider.of(context).…(SdkShareUIC::class.java)");
    com.tencent.mm.plugin.finder.post.i locali = (com.tencent.mm.plugin.finder.post.i)localObject1;
    boolean bool1;
    boolean bool2;
    label100:
    Object localObject3;
    label156:
    label220:
    Object localObject6;
    int i;
    if ((eHl().Gcx != null) && (!Util.isNullOrNil((List)eHl().GZZ)))
    {
      bool1 = true;
      if (((Collection)locali.EUo).isEmpty()) {
        break label411;
      }
      bool2 = true;
      Log.i(TAG, "refresh existDraft:" + bool1 + ", existRemote:" + bool2);
      if ((!bool1) && (!bool2)) {
        break label471;
      }
      if (!bool1) {
        break label417;
      }
      localObject3 = eHl().GZZ;
      if (localObject3 != null)
      {
        localObject1 = (dji)kotlin.a.p.oL((List)localObject3);
        if (localObject1 != null)
        {
          if (((dji)localObject1).mediaType != 4) {
            break label447;
          }
          if (!Util.isNullOrNil(((dji)localObject1).coverUrl)) {
            break label427;
          }
          localObject1 = (r)new n((dji)localObject1, v.FKZ, null, null, 12);
          localObject6 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl().dk(localObject1);
          localObject6 = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).a(new g..ExternalSyntheticLambda5(this)).blg();
        }
      }
      localObject6 = this.Hai;
      localObject1 = localObject6;
      if (localObject6 == null)
      {
        s.bIx("thumbIv");
        localObject1 = null;
      }
      ((ImageView)localObject1).setOnClickListener(new g..ExternalSyntheticLambda1(this));
      localObject6 = this.rootView;
      localObject1 = localObject6;
      if (localObject6 == null)
      {
        s.bIx("rootView");
        localObject1 = null;
      }
      ((View)localObject1).findViewById(l.e.select_cover_btn_container).setOnClickListener(new g..ExternalSyntheticLambda4((LinkedList)localObject3, this));
      if (locali.EUm != null) {
        break label1299;
      }
      i = j;
      label361:
      if (i != 0) {
        break label1307;
      }
      localObject1 = this.rootView;
      if (localObject1 != null) {
        break label1304;
      }
      s.bIx("rootView");
      localObject1 = localObject4;
    }
    label902:
    label915:
    label1304:
    for (;;)
    {
      for (;;)
      {
        ((View)localObject1).findViewById(l.e.select_cover_btn_container).setVisibility(8);
        AppMethodBeat.o(168624);
        return;
        bool1 = false;
        break;
        label411:
        bool2 = false;
        break label100;
        label417:
        localObject3 = locali.EUo;
        break label156;
        label427:
        localObject1 = (r)new t((dji)localObject1, v.FKY);
        break label220;
        label447:
        localObject1 = (r)new n((dji)localObject1, v.FKZ, null, null, 12);
        break label220;
        label471:
        localObject1 = fqx();
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getByteArray("MEDIA_EXTRA_MUSIC");
          if (localObject3 != null) {
            localObject1 = (com.tencent.mm.bx.a)new dls();
          }
        }
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
          this.Han = ((dls)localObject1);
          localObject3 = TAG;
          localObject1 = this.Han;
          if (localObject1 == null)
          {
            localObject1 = null;
            Log.i((String)localObject3, s.X("post video with music: ", localObject1));
            localObject1 = com.tencent.mm.plugin.finder.upload.i.Gcb;
            this.musicInfo = com.tencent.mm.plugin.finder.upload.i.a(this.Han);
            localObject1 = fqx();
            if (localObject1 != null)
            {
              localObject3 = ((Bundle)localObject1).getByteArray("ORIGIN_MUSIC_INFO");
              if (localObject3 != null) {
                localObject1 = (com.tencent.mm.bx.a)new bqj();
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
              ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
              this.musicInfo = ((bqj)localObject1);
              localObject1 = fqx();
              if (localObject1 != null) {
                break label850;
              }
              localObject1 = "";
              this.HaI = ((String)localObject1);
              localObject1 = fqx();
              if (localObject1 != null) {
                break label876;
              }
              localObject1 = "";
              this.coverUrl = ((String)localObject1);
              localObject1 = fqx();
              if (localObject1 != null) {
                break label902;
              }
              i = 0;
              this.HaJ = i;
              localObject1 = fqx();
              if (localObject1 != null) {
                break label915;
              }
              localObject1 = null;
              this.HaL = ((Rect)localObject1);
              if (!y.ZC(this.coverUrl))
              {
                this.coverUrl = "";
                this.HaJ = 0;
              }
              if (!y.ZC(this.HaI)) {
                this.HaI = "";
              }
              localObject1 = fqx();
              if (localObject1 != null) {
                break label953;
              }
              localObject1 = null;
              if (localObject1 == null) {
                break label966;
              }
              fqM();
              com.tencent.mm.ae.d.B((kotlin.g.a.a)new e(this));
              break;
              localException1 = localException1;
              Log.printDebugStack("safeParser", "", new Object[] { localException1 });
              localInteger = null;
            }
            Integer localInteger = Integer.valueOf(localInteger.aaRI);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { localException2 });
              localObject2 = null;
              continue;
              label850:
              localObject3 = ((Bundle)localObject2).getString("VIDEO_FULL_COVER_URL");
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = "";
                continue;
                label876:
                localObject3 = ((Bundle)localObject2).getString("VIDEO_COVER_URL");
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  localObject2 = "";
                  continue;
                  i = ((Bundle)localObject2).getInt("VIDEO_COVER_QUALITY", 0);
                  continue;
                  localObject2 = ((Bundle)localObject2).getParcelableArrayList("HALF_RECT_LIST");
                  if (localObject2 == null)
                  {
                    localObject2 = null;
                  }
                  else
                  {
                    localObject2 = (Rect)kotlin.a.p.ae((List)localObject2, 0);
                    continue;
                    label953:
                    localObject2 = ((Bundle)localObject2).getByteArray("video_composition");
                  }
                }
              }
            }
            label966:
            localObject2 = fqx();
            if (localObject2 != null) {
              break label1203;
            }
          }
        }
      }
      localObject2 = null;
      label980:
      this.HaF = ((ArrayList)localObject2);
      localObject2 = fqx();
      if (localObject2 == null)
      {
        localObject3 = null;
        label1000:
        localObject2 = fqx();
        if (localObject2 != null) {
          break label1229;
        }
        localObject2 = "";
        label1015:
        this.coverUrl = ((String)localObject2);
        localObject2 = fqx();
        if (localObject2 != null) {
          break label1255;
        }
        localObject2 = "";
        this.HaI = ((String)localObject2);
        localObject2 = fqx();
        if (localObject2 != null) {
          break label1281;
        }
        i = 0;
        label1055:
        this.HaJ = i;
        fqP();
        localObject2 = (Collection)this.HaF;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label1294;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject6 = this.rootView;
          localObject2 = localObject6;
          if (localObject6 == null)
          {
            s.bIx("rootView");
            localObject2 = null;
          }
          ((View)localObject2).findViewById(l.e.select_cover_btn_container).setOnClickListener(new g..ExternalSyntheticLambda2(this));
          localObject6 = this.hDw;
          localObject2 = localObject6;
          if (localObject6 == null)
          {
            s.bIx("container");
            localObject2 = null;
          }
          ((View)localObject2).setVisibility(0);
          com.tencent.mm.ae.d.e("Finder_Post_Create_Video_Thumb", (kotlin.g.a.a)new c(this, (ArrayList)localObject3));
        }
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new f(this));
        break;
        label1203:
        localObject2 = ((Bundle)localObject2).getStringArrayList("video_file_list");
        break label980;
        localObject3 = ((Bundle)localObject2).getStringArrayList("VIDEO_THUMB_LIST");
        break label1000;
        label1229:
        localObject6 = ((Bundle)localObject2).getString("VIDEO_COVER_URL");
        localObject2 = localObject6;
        if (localObject6 != null) {
          break label1015;
        }
        localObject2 = "";
        break label1015;
        label1255:
        localObject6 = ((Bundle)localObject2).getString("VIDEO_FULL_COVER_URL");
        localObject2 = localObject6;
        if (localObject6 != null) {
          break label1036;
        }
        localObject2 = "";
        break label1036;
        i = ((Bundle)localObject2).getInt("VIDEO_COVER_QUALITY", 0);
        break label1055;
      }
      i = 0;
      break label361;
    }
    label1036:
    label1294:
    label1299:
    label1307:
    Object localObject2 = this.rootView;
    label1281:
    if (localObject2 == null)
    {
      s.bIx("rootView");
      localObject2 = localObject5;
    }
    for (;;)
    {
      ((View)localObject2).findViewById(l.e.select_cover_btn_container).setVisibility(0);
      AppMethodBeat.o(168624);
      return;
    }
  }
  
  public final boolean dqm()
  {
    AppMethodBeat.i(331214);
    Object localObject2;
    if (this.HaH != null)
    {
      localObject1 = this.HaH;
      s.checkNotNull(localObject1);
      localObject1 = ((afb)localObject1).Zng;
      s.s(localObject1, "compositionInfo!!.tracks");
      localObject1 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (fos)((Iterator)localObject1).next();
      } while (y.ZC(((fos)localObject2).path));
      Log.i(TAG, "[compositionInfo]video widget file:" + ((fos)localObject2).path + " lost!");
      AppMethodBeat.o(331214);
      return false;
    }
    Object localObject1 = this.HaF;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!y.ZC((String)localObject2))
        {
          Log.i(TAG, "[videoFileList]video widget file:" + (String)localObject2 + " lost!");
          AppMethodBeat.o(331214);
          return false;
        }
      }
    }
    AppMethodBeat.o(331214);
    return true;
  }
  
  public final void fqA()
  {
    AppMethodBeat.i(331229);
    this.HaF = null;
    this.Ham.clear();
    this.HaG.clear();
    this.HaH = null;
    this.Han = null;
    this.musicInfo = null;
    this.GZE = null;
    this.HaI = "";
    this.coverUrl = "";
    this.HaJ = 0;
    this.HaK = "";
    this.HaL = null;
    AppMethodBeat.o(331229);
  }
  
  public final View fqB()
  {
    AppMethodBeat.i(168622);
    Object localObject = ((Activity)getContext()).getLayoutInflater().inflate(l.f.finder_post_video_widget, null);
    s.s(localObject, "context as Activity).lay…_post_video_widget, null)");
    this.rootView = ((View)localObject);
    View localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    localObject = ((View)localObject).findViewById(l.e.video_container);
    s.s(localObject, "rootView.findViewById(R.id.video_container)");
    this.hDw = ((View)localObject);
    localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    localObject = ((View)localObject).findViewById(l.e.thumb_view);
    s.s(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.Hai = ((ImageView)localObject);
    localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    this.maskView = ((View)localObject).findViewById(l.e.video_bottom_mask);
    localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    localObject = ((View)localObject).findViewById(l.e.reprint_iv);
    s.s(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.Haj = ((View)localObject);
    localObject = this.rootView;
    if (localObject == null)
    {
      s.bIx("rootView");
      AppMethodBeat.o(168622);
      return null;
    }
    AppMethodBeat.o(168622);
    return localObject;
  }
  
  public final h fqC()
  {
    int j = 0;
    AppMethodBeat.i(331113);
    Object localObject2 = eHl().Gcx;
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.nq(getContext()).q(com.tencent.mm.plugin.finder.post.i.class);
    s.s(localObject1, "UICProvider.of(context).…(SdkShareUIC::class.java)");
    localObject1 = (com.tencent.mm.plugin.finder.post.i)localObject1;
    if ((localObject2 != null) && (!Util.isNullOrNil((List)eHl().GZZ)))
    {
      localObject1 = new h(true, ((FinderItem)localObject2).getMediaType(), null, this.Gcs);
      AppMethodBeat.o(331113);
      return localObject1;
    }
    if (!((Collection)((com.tencent.mm.plugin.finder.post.i)localObject1).EUo).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      localdjh = new djh();
      localdjh.mediaList.addAll((Collection)((com.tencent.mm.plugin.finder.post.i)localObject1).EUo);
      localdjh.aaPb = true;
      localObject1 = new h(true, 4, localdjh, "");
      AppMethodBeat.o(331113);
      return localObject1;
    }
    djh localdjh = new djh();
    localObject1 = fqx();
    label229:
    label250:
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = null;
      localdjh.FSW = ((String)localObject1);
      localObject1 = fqx();
      if (localObject1 != null) {
        break label557;
      }
      localObject1 = null;
      localdjh.FSU = ((String)localObject1);
      localObject1 = fqx();
      if (localObject1 != null) {
        break label570;
      }
      localObject1 = null;
      localdjh.aaPa = ((String)localObject1);
      localObject1 = fqx();
      if (localObject1 != null) {
        break label583;
      }
      bool = false;
      label270:
      localdjh.GZQ = bool;
      localObject1 = fqx();
      if (localObject1 != null) {
        break label596;
      }
      bool = false;
      label289:
      localdjh.GZR = bool;
      localObject1 = fqx();
      if (localObject1 != null) {
        break label609;
      }
      i = 0;
      label308:
      localdjh.soundTrackType = i;
      localObject1 = fqx();
      if (localObject1 != null) {
        break label622;
      }
      localObject1 = null;
      label328:
      localdjh.musicFeedId = ((String)localObject1);
      localdjh.aaOZ = this.musicInfo;
      Log.i(TAG, "getUploadData: " + localdjh.FSW + ", " + localdjh.GZR);
      if (this.HaH == null) {
        break label685;
      }
      localObject1 = fqx();
      if (localObject1 != null) {
        break label635;
      }
      localObject1 = "";
    }
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      localObject2 = localdjh.mediaList;
      localObject3 = com.tencent.mm.plugin.finder.upload.i.Gcb;
      localObject3 = this.HaH;
      s.checkNotNull(localObject3);
      localObject1 = com.tencent.mm.plugin.finder.upload.i.a((afb)localObject3, this.HaK, (String)localObject1, this.coverUrl, this.HaI, this.HaL);
      localObject3 = new boy();
      ((boy)localObject3).ZXr = this.HaJ;
      localObject4 = ah.aiuX;
      ((dji)localObject1).codec_info = ((boy)localObject3);
      Log.i(TAG, s.X("codec_info video_cover_score:", Integer.valueOf(this.HaJ)));
      localObject3 = ah.aiuX;
      ((LinkedList)localObject2).add(localObject1);
      localObject1 = new h(true, 4, localdjh, this.Gcs);
      AppMethodBeat.o(331113);
      return localObject1;
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_ID");
      break;
      label557:
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_PATH");
      break label229;
      label570:
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_BGM_URL");
      break label250;
      label583:
      bool = ((Bundle)localObject1).getBoolean("MEDIA_IS_MUTE", false);
      break label270;
      label596:
      bool = ((Bundle)localObject1).getBoolean("MUSIC_IS_MUTE", false);
      break label289;
      label609:
      i = ((Bundle)localObject1).getInt("SOUND_TRACK_TYPE", 0);
      break label308;
      label622:
      localObject1 = ((Bundle)localObject1).getString("MUSIC_FEED_ID");
      break label328;
      label635:
      localObject1 = ((Bundle)localObject1).getStringArrayList("VIDEO_THUMB_LIST");
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = (String)kotlin.a.p.oK((List)localObject1);
        if (localObject1 == null) {
          localObject1 = "";
        }
      }
    }
    label685:
    localObject1 = (Collection)this.HaF;
    label805:
    label834:
    Object localObject5;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label1029;
      }
      localObject1 = TAG;
      localObject3 = new StringBuilder("video list ");
      localObject4 = this.HaF;
      s.checkNotNull(localObject4);
      Log.i((String)localObject1, ((ArrayList)localObject4).size() + ", thumb list " + this.Ham.size());
      localObject1 = this.HaF;
      s.checkNotNull(localObject1);
      if (((ArrayList)localObject1).size() != this.Ham.size()) {
        break label1024;
      }
      i = 1;
      if (i == 0) {
        break label1084;
      }
      localObject1 = this.HaF;
      s.checkNotNull(localObject1);
      localObject2 = ((Iterable)localObject1).iterator();
      i = j;
      if (!((Iterator)localObject2).hasNext()) {
        break label1049;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject4 = (String)localObject1;
      localObject3 = localdjh.mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.i.Gcb;
      localObject5 = Util.nullAsNil((String)kotlin.a.p.ae((List)this.Ham, i));
      s.s(localObject5, "nullAsNil(thumbFileList.getOrNull(index))");
      if (this.HaG.size() <= i) {
        break label1043;
      }
    }
    label1024:
    label1029:
    label1043:
    for (localObject1 = (dju)this.HaG.get(i);; localObject1 = null)
    {
      localObject1 = com.tencent.mm.plugin.finder.upload.i.a((String)localObject4, (String)localObject5, (dju)localObject1, this.coverUrl, this.HaI);
      localObject4 = new boy();
      ((boy)localObject4).ZXr = this.HaJ;
      localObject5 = ah.aiuX;
      ((dji)localObject1).codec_info = ((boy)localObject4);
      Log.i(TAG, s.X("codec_info video_cover_score:", Integer.valueOf(this.HaJ)));
      localObject4 = ah.aiuX;
      ((LinkedList)localObject3).add(localObject1);
      i += 1;
      break label834;
      i = 0;
      break;
      i = 0;
      break label805;
      Log.i(TAG, "video list null");
      i = 0;
      break label805;
    }
    label1049:
    localObject1 = av.GiL;
    localObject1 = new h(true, av.a(localdjh), localdjh, this.Gcs);
    AppMethodBeat.o(331113);
    return localObject1;
    label1084:
    if (localObject2 == null) {}
    for (i = 0;; i = ((FinderItem)localObject2).getMediaType())
    {
      localObject1 = new h(false, i, null);
      AppMethodBeat.o(331113);
      return localObject1;
    }
  }
  
  public final void fqO()
  {
    AppMethodBeat.i(331194);
    djh localdjh = new djh();
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    label108:
    int k;
    float f;
    label145:
    Object localObject4;
    if (this.HaM == null)
    {
      localObject1 = this.HaF;
      if (localObject1 != null) {
        break label454;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = new dju();
        localObject3 = MultiMediaVideoChecker.ObB.aTG((String)localObject1);
        if (localObject3 != null)
        {
          j = ((MultiMediaVideoChecker.a)localObject3).width;
          i = ((MultiMediaVideoChecker.a)localObject3).height;
          switch (SightVideoJNI.getMp4RotateVFS((String)localObject1))
          {
          default: 
            k = bf.bf(getContext()).x;
            f = j / i;
            if (f <= 1.777778F) {
              if (0.5625F <= f)
              {
                k = 1;
                if (k == 0) {
                  break label497;
                }
                localObject1 = new fyb();
                ((fyb)localObject1).left = 0;
                ((fyb)localObject1).top = i;
                ((fyb)localObject1).right = j;
                ((fyb)localObject1).bottom = 0;
                ((dju)localObject2).aaPJ = ((fyb)localObject1);
                ((dju)localObject2).aaPL = ((fyb)localObject1);
                localObject4 = kotlin.a.p.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
                localObject1 = new byz();
                ((byz)localObject1).aaib.addAll((Collection)kotlin.a.p.p((Iterable)localObject4));
                localObject4 = ah.aiuX;
                ((dju)localObject2).aaPK = ((byz)localObject1);
              }
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      ((dju)localObject2).startTime = 0;
      ((dju)localObject2).endTime = ((int)((MultiMediaVideoChecker.a)localObject3).duration);
      ((dju)localObject2).width = j;
      ((dju)localObject2).height = i;
      ((dju)localObject2).retryCount = 0;
      localObject1 = ah.aiuX;
      this.HaM = ((dju)localObject2);
      localObject1 = this.HaF;
      s.checkNotNull(localObject1);
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject2 = (String)localObject2;
        localObject3 = localdjh.mediaList;
        localObject4 = com.tencent.mm.plugin.finder.upload.i.Gcb;
        ((LinkedList)localObject3).add(com.tencent.mm.plugin.finder.upload.i.a((String)localObject2, "", this.HaM));
        i += 1;
      }
      label454:
      localObject1 = (String)kotlin.a.p.oK((List)localObject1);
      break;
      j = ((MultiMediaVideoChecker.a)localObject3).height;
      i = ((MultiMediaVideoChecker.a)localObject3).width;
      break label108;
      k = 0;
      break label145;
      k = 0;
      break label145;
      label497:
      float[] arrayOfFloat;
      if (f > 1.777778F)
      {
        k = (int)(i * 16.0F / 9.0F);
        localObject4 = new fyb();
        ((fyb)localObject4).left = ((j - k) / 2);
        ((fyb)localObject4).top = i;
        ((fyb)localObject4).right = (j - ((fyb)localObject4).left);
        ((fyb)localObject4).bottom = 0;
        ((dju)localObject2).aaPJ = ((fyb)localObject4);
        ((dju)localObject2).aaPL = ((fyb)localObject4);
        localObject1 = new Matrix();
        ((Matrix)localObject1).postTranslate(-((fyb)localObject4).left, 0.0F);
        localObject4 = new byz();
        arrayOfFloat = new float[9];
        ((Matrix)localObject1).getValues(arrayOfFloat);
        ((byz)localObject4).aaib.addAll((Collection)kotlin.a.k.D(arrayOfFloat));
        localObject1 = ah.aiuX;
        ((dju)localObject2).aaPK = ((byz)localObject4);
        j = k;
      }
      else
      {
        k = (int)(j * 16.0F / 9.0F);
        localObject4 = new fyb();
        ((fyb)localObject4).left = 0;
        ((fyb)localObject4).bottom = ((i - k) / 2);
        ((fyb)localObject4).right = j;
        ((fyb)localObject4).top = (i - ((fyb)localObject4).bottom);
        ((dju)localObject2).aaPJ = ((fyb)localObject4);
        ((dju)localObject2).aaPL = ((fyb)localObject4);
        localObject1 = new Matrix();
        ((Matrix)localObject1).postTranslate(0.0F, -((fyb)localObject4).bottom);
        localObject4 = new byz();
        arrayOfFloat = new float[9];
        ((Matrix)localObject1).getValues(arrayOfFloat);
        ((byz)localObject4).aaib.addAll((Collection)kotlin.a.k.D(arrayOfFloat));
        localObject1 = ah.aiuX;
        ((dju)localObject2).aaPK = ((byz)localObject4);
        i = k;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.a((Activity)getContext(), null, localdjh, null, true, true, 8);
    AppMethodBeat.o(331194);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget$Companion;", "", "()V", "REQUEST_SELECT_COVER", "", "getREQUEST_SELECT_COVER", "()I", "RESULT_COVER_FULL_PATH", "", "getRESULT_COVER_FULL_PATH", "()Ljava/lang/String;", "RESULT_COVER_PATH", "getRESULT_COVER_PATH", "RESULT_COVER_QUALITY", "getRESULT_COVER_QUALITY", "RESULT_CROP_INFO", "getRESULT_CROP_INFO", "TAG", "getTAG", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(g paramg, ah.f<String> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(g paramg, ArrayList<String> paramArrayList)
    {
      super();
    }
    
    private static final void a(ah.a parama, g paramg, Bitmap paramBitmap)
    {
      AppMethodBeat.i(330758);
      s.u(parama, "$showThumb");
      s.u(paramg, "this$0");
      if (parama.aiwY)
      {
        s.s(paramBitmap, "thumb");
        g.a(paramg, paramBitmap);
        paramBitmap = g.a(paramg);
        parama = paramBitmap;
        if (paramBitmap == null)
        {
          s.bIx("thumbIv");
          parama = null;
        }
        parama.setOnClickListener(new g.c..ExternalSyntheticLambda1(paramg));
      }
      AppMethodBeat.o(330758);
    }
    
    private static final void b(g paramg, Bitmap paramBitmap)
    {
      AppMethodBeat.i(330747);
      s.u(paramg, "this$0");
      Object localObject = g.HaE;
      Log.i(g.access$getTAG$cp(), "set coverUrl");
      s.s(paramBitmap, "cover");
      g.a(paramg, paramBitmap);
      localObject = g.a(paramg);
      paramBitmap = (Bitmap)localObject;
      if (localObject == null)
      {
        s.bIx("thumbIv");
        paramBitmap = null;
      }
      paramBitmap.setOnClickListener(new g.c..ExternalSyntheticLambda0(paramg));
      AppMethodBeat.o(330747);
    }
    
    private static final void d(g paramg, View paramView)
    {
      AppMethodBeat.i(330742);
      s.u(paramg, "this$0");
      paramg.fqO();
      AppMethodBeat.o(330742);
    }
    
    private static final void e(g paramg, View paramView)
    {
      AppMethodBeat.i(330751);
      s.u(paramg, "this$0");
      paramg.fqO();
      AppMethodBeat.o(330751);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(g paramg, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g
 * JD-Core Version:    0.7.0.1
 */