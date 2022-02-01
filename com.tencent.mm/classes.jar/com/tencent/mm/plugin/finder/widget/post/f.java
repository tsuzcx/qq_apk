package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.upload.e;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.a.j;
import d.g.b.k;
import d.g.b.v.a;
import d.g.b.v.e;
import d.v;
import d.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCompositionInfo", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCompositionInfo", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "container", "Landroid/view/View;", "coverUrl", "", "cropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getCropInfoList", "()Ljava/util/ArrayList;", "setCropInfoList", "(Ljava/util/ArrayList;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Landroid/widget/ImageView;", "videoFileList", "getVideoFileList", "setVideoFileList", "videoPathBeforeCut", "checkData", "", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "initFakeVideoLogic", "initNormalVideoLogic", "jumpSelectCoverUI", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showThumb", "thumb", "Landroid/graphics/Bitmap;", "Companion", "plugin-finder_release"})
public final class f
  extends a
{
  private static final int LlX = 1001;
  private static final String LlY = "RESULT_COVER_PATH";
  private static final String TAG = "Finder.PostVideoWidget";
  public static final a raH;
  dxw LlW;
  private String coverUrl;
  private View hFi;
  private View jGG;
  ArrayList<String> raE;
  ArrayList<bmm> raF;
  private String raG;
  private ImageView raa;
  private View rac;
  ArrayList<String> rae;
  
  static
  {
    AppMethodBeat.i(168626);
    raH = new a((byte)0);
    LlX = 1001;
    LlY = "RESULT_COVER_PATH";
    TAG = "Finder.PostVideoWidget";
    AppMethodBeat.o(168626);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168625);
    this.rae = new ArrayList();
    this.raF = new ArrayList();
    this.coverUrl = "";
    this.raG = "";
    AppMethodBeat.o(168625);
  }
  
  private final boolean fXL()
  {
    AppMethodBeat.i(200762);
    Object localObject1 = this.dow;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getByteArray("video_composition");
      if (localObject1 != null)
      {
        Object localObject3;
        try
        {
          ad.i(TAG, "initFakeVideoLogic");
          localObject3 = this.hFi;
          if (localObject3 == null) {
            k.aPZ("container");
          }
          ((View)localObject3).setVisibility(0);
          localObject1 = new dxw().parseFrom((byte[])localObject1);
          if (localObject1 != null) {
            break label117;
          }
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CompositionInfo");
          AppMethodBeat.o(200762);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace(TAG, (Throwable)localIOException, "parse error", new Object[0]);
        }
        AppMethodBeat.o(200762);
        return true;
        label117:
        this.LlW = ((dxw)localIOException);
        Object localObject2 = this.dow;
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("VIDEO_THUMB_LIST");
          label142:
          localObject3 = new v.e();
          ((v.e)localObject3).Jhw = "";
          if (localObject2 != null) {
            if (((Collection)localObject2).isEmpty()) {
              break label296;
            }
          }
        }
        label296:
        for (int i = 1;; i = 0)
        {
          if (i == 1)
          {
            localObject2 = j.iy((List)localObject2);
            k.g(localObject2, "mediaThumbList.first()");
            ((v.e)localObject3).Jhw = ((String)localObject2);
          }
          c.b("PostVideoWidget_initFakeVideoLogic", (d.g.a.a)new c((v.e)localObject3, this));
          localObject2 = this.raa;
          if (localObject2 == null) {
            k.aPZ("thumbIv");
          }
          ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new d((v.e)localObject3, this));
          localObject2 = this.jGG;
          if (localObject2 == null) {
            k.aPZ("rootView");
          }
          ((View)localObject2).findViewById(2131307855).setOnClickListener((View.OnClickListener)new e((v.e)localObject3, this));
          break;
          localObject2 = null;
          break label142;
        }
      }
    }
    AppMethodBeat.o(200762);
    return false;
  }
  
  private final void fXM()
  {
    AppMethodBeat.i(200763);
    Bundle localBundle = this.dow;
    if (localBundle != null)
    {
      Object localObject2 = localBundle.getString("video_before_cut_path");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.raG = ((String)localObject1);
      localObject1 = localBundle.getParcelableArrayList("VIDEO_CROP_LIST");
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof LocalVideoCropInfoParcelable))) {
            this.raF.add(((LocalVideoCropInfoParcelable)localObject2).qDR);
          } else {
            this.raF.add(null);
          }
        }
        AppMethodBeat.o(200763);
        return;
      }
      AppMethodBeat.o(200763);
      return;
    }
    AppMethodBeat.o(200763);
  }
  
  public final View ctv()
  {
    AppMethodBeat.i(168622);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168622);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getLayoutInflater().inflate(2131494091, null);
    k.g(localObject, "(context as Activity).la…_post_video_widget, null)");
    this.jGG = ((View)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306317);
    k.g(localObject, "rootView.findViewById(R.id.video_container)");
    this.hFi = ((View)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    localObject = ((View)localObject).findViewById(2131305801);
    k.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.raa = ((ImageView)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304092);
    k.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.rac = ((View)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    AppMethodBeat.o(168622);
    return localObject;
  }
  
  public final h fXI()
  {
    AppMethodBeat.i(200761);
    Object localObject3;
    Object localObject2;
    label63:
    Object localObject4;
    if (this.LlW != null)
    {
      localObject3 = new bmc();
      localObject1 = this.dow;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getStringArrayList("VIDEO_THUMB_LIST");
        if (localObject1 != null)
        {
          localObject2 = (String)j.iy((List)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label63;
          }
        }
      }
      localObject1 = "";
      localObject2 = ((bmc)localObject3).mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.h.qRq;
      localObject4 = this.LlW;
      if (localObject4 == null) {
        k.fvU();
      }
      ((LinkedList)localObject2).add(com.tencent.mm.plugin.finder.upload.h.a((dxw)localObject4, (String)localObject1, this.coverUrl));
      localObject1 = new h(true, 4, (bmc)localObject3, this.raG);
      AppMethodBeat.o(200761);
      return localObject1;
    }
    if ((this.qOO != null) && (this.qZS != null))
    {
      localObject1 = new h(true, 4, this.qZS);
      AppMethodBeat.o(200761);
      return localObject1;
    }
    Object localObject1 = (Collection)this.raE;
    int i;
    label279:
    label316:
    LinkedList localLinkedList;
    String str;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label438;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("video list ");
      localObject3 = this.raE;
      if (localObject3 == null) {
        k.fvU();
      }
      ad.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.rae.size());
      localObject1 = this.raE;
      if (localObject1 == null) {
        k.fvU();
      }
      if (((ArrayList)localObject1).size() != this.rae.size()) {
        break label433;
      }
      i = 1;
      if (i == 0) {
        break label487;
      }
      localObject2 = new bmc();
      localObject1 = this.raE;
      if (localObject1 == null) {
        k.fvU();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label457;
      }
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.fvx();
      }
      localObject4 = (String)localObject1;
      localLinkedList = ((bmc)localObject2).mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.h.qRq;
      str = bt.nullAsNil((String)this.rae.get(i));
      k.g(str, "Util.nullAsNil(thumbFileList[index])");
      if (this.raF.size() <= i) {
        break label452;
      }
    }
    label433:
    label438:
    label452:
    for (localObject1 = (bmm)this.raF.get(i);; localObject1 = null)
    {
      localLinkedList.add(com.tencent.mm.plugin.finder.upload.h.a((String)localObject4, str, (bmm)localObject1, this.coverUrl));
      i += 1;
      break label316;
      i = 0;
      break;
      i = 0;
      break label279;
      ad.i(TAG, "video list null");
      i = 0;
      break label279;
    }
    label457:
    localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
    localObject1 = new h(true, com.tencent.mm.plugin.finder.utils.i.a((bmc)localObject2), (bmc)localObject2, this.raG);
    AppMethodBeat.o(200761);
    return localObject1;
    label487:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(200761);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168624);
    Object localObject1 = this.dow;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((Bundle)localObject1).getString("VIDEO_COVER_URL");
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    this.coverUrl = ((String)localObject1);
    localObject1 = this.dow;
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getByteArray("video_composition"); localObject1 != null; localObject1 = null)
    {
      fXL();
      AppMethodBeat.o(168624);
      return;
    }
    if (this.qZS != null)
    {
      localObject1 = this.qZS;
      if (localObject1 == null) {
        k.fvU();
      }
      if (!bt.gL((List)((bmc)localObject1).mediaList))
      {
        localObject1 = this.hFi;
        if (localObject1 == null) {
          k.aPZ("container");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.rac;
        if (localObject1 == null) {
          k.aPZ("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.qZS;
        if (localObject1 == null) {
          k.fvU();
        }
        localObject1 = ((bmc)localObject1).mediaList;
        k.g(localObject1, "refFeedContent!!.mediaList");
        localObject1 = (bmd)((LinkedList)localObject1).getFirst();
        localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject2 = com.tencent.mm.plugin.finder.utils.i.fB((int)((bmd)localObject1).width, (int)((bmd)localObject1).height);
        localObject3 = this.raa;
        if (localObject3 == null) {
          k.aPZ("thumbIv");
        }
        ((ImageView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bmd)localObject1).width);
        localObject3 = this.raa;
        if (localObject3 == null) {
          k.aPZ("thumbIv");
        }
        ((ImageView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bmd)localObject1).height);
        localObject3 = this.raa;
        if (localObject3 == null) {
          k.aPZ("thumbIv");
        }
        ((ImageView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        localObject2 = this.raa;
        if (localObject2 == null) {
          k.aPZ("thumbIv");
        }
        ((ImageView)localObject2).requestLayout();
        k.g(localObject1, "mediaObj");
        localObject1 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject1, com.tencent.mm.plugin.finder.storage.h.qJZ);
        localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
        localObject2 = com.tencent.mm.plugin.finder.loader.h.cmU();
        localObject3 = this.raa;
        if (localObject3 == null) {
          k.aPZ("thumbIv");
        }
        com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
        ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
        localObject1 = this.raa;
        if (localObject1 == null) {
          k.aPZ("thumbIv");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(168624);
        return;
      }
    }
    localObject1 = this.dow;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("video_file_list");
      this.raE = ((ArrayList)localObject1);
      this.rae = new ArrayList();
      localObject3 = this.dow;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getStringArrayList("VIDEO_THUMB_LIST");
      }
      localObject2 = this.dow;
      if (localObject2 != null)
      {
        localObject3 = ((Bundle)localObject2).getString("VIDEO_COVER_URL");
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      this.coverUrl = ((String)localObject2);
      fXM();
      localObject2 = (Collection)this.raE;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label639;
      }
    }
    label639:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = this.jGG;
        if (localObject2 == null) {
          k.aPZ("rootView");
        }
        ((View)localObject2).findViewById(2131307855).setOnClickListener((View.OnClickListener)new f(this));
        localObject2 = this.hFi;
        if (localObject2 == null) {
          k.aPZ("container");
        }
        ((View)localObject2).setVisibility(0);
        b.c((Runnable)new g(this, (ArrayList)localObject1), "Finder_Post_Create_Video_Thumb");
      }
      AppMethodBeat.o(168624);
      return;
      localObject1 = null;
      break;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget$Companion;", "", "()V", "REQUEST_SELECT_COVER", "", "getREQUEST_SELECT_COVER", "()I", "RESULT_COVER_PATH", "", "getRESULT_COVER_PATH", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168618);
      f.a(this.raI);
      AppMethodBeat.o(168618);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$1"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(v.e parame, f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$2"})
  static final class d
    implements View.OnClickListener
  {
    d(v.e parame, f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200753);
      paramView = new bmc();
      Object localObject1 = paramView.mediaList;
      Object localObject2 = com.tencent.mm.plugin.finder.upload.h.qRq;
      localObject2 = jdField_this.LlW;
      if (localObject2 == null) {
        k.fvU();
      }
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.h.a((dxw)localObject2, (String)this.LlZ.Jhw, f.b(jdField_this)));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
      localObject1 = jdField_this.context;
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(200753);
        throw paramView;
      }
      localObject1 = (Activity)localObject1;
      localObject2 = (View)f.e(jdField_this);
      Object localObject3 = jdField_this.context;
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(200753);
        throw paramView;
      }
      localObject3 = ((MMActivity)localObject3).getWindow();
      k.g(localObject3, "(context as MMActivity).window");
      localObject2 = ViewAnimHelper.m((View)localObject2, ((Window)localObject3).getDecorView());
      k.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, jdField_this.qOO);
      AppMethodBeat.o(200753);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$3"})
  static final class e
    implements View.OnClickListener
  {
    e(v.e parame, f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200754);
      paramView = new bmc();
      Object localObject1 = paramView.mediaList;
      Object localObject2 = com.tencent.mm.plugin.finder.upload.h.qRq;
      localObject2 = jdField_this.LlW;
      if (localObject2 == null) {
        k.fvU();
      }
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.h.a((dxw)localObject2, (String)this.LlZ.Jhw, f.b(jdField_this)));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
      localObject1 = jdField_this.context;
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(200754);
        throw paramView;
      }
      localObject1 = (Activity)localObject1;
      localObject2 = (View)f.e(jdField_this);
      Object localObject3 = jdField_this.context;
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(200754);
        throw paramView;
      }
      localObject3 = ((MMActivity)localObject3).getWindow();
      k.g(localObject3, "(context as MMActivity).window");
      localObject2 = ViewAnimHelper.m((View)localObject2, ((Window)localObject3).getDecorView());
      k.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
      localObject3 = f.raH;
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, f.fXN());
      AppMethodBeat.o(200754);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200755);
      f.c(this.raI);
      AppMethodBeat.o(200755);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(f paramf, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(200760);
      Object localObject1 = this.raI.raE;
      if (localObject1 == null) {
        k.fvU();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      final int i = 0;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (i < 0) {
          j.fvx();
        }
        localObject1 = (String)localObject1;
        final v.a locala = new v.a();
        boolean bool;
        if (i == 0)
        {
          bool = true;
          label78:
          locala.Jhs = bool;
          if ((this.raA == null) || (this.raA.size() <= i) || (bt.isNullOrNil((String)this.raA.get(i)))) {
            break label256;
          }
          localObject1 = (String)this.raA.get(i);
        }
        for (;;)
        {
          Object localObject2;
          if ((locala.Jhs) && (!bt.isNullOrNil(f.b(this.raI))) && (com.tencent.mm.vfs.i.eK(f.b(this.raI))))
          {
            localObject2 = com.tencent.mm.sdk.platformtools.f.decodeFile(f.b(this.raI));
            if (localObject2 != null)
            {
              aq.f((Runnable)new a((Bitmap)localObject2, locala, this));
              locala.Jhs = false;
            }
          }
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject1);
            if (localObject2 != null) {
              aq.f((Runnable)new b((String)localObject1, i, locala, (Bitmap)localObject2, this));
            }
          }
          i += 1;
          break;
          bool = false;
          break label78;
          label256:
          if ((this.raI.raF.size() > i) && (this.raI.raF.get(i) != null))
          {
            localObject2 = e.qQW;
            localObject2 = this.raI.raF.get(i);
            if (localObject2 == null) {
              k.fvU();
            }
            localObject2 = ((bmm)localObject2).DJW;
            k.g(localObject2, "cropInfoList[index]!!.thumbRect");
            localObject1 = e.a((String)localObject1, (dkt)localObject2);
          }
          else
          {
            localObject2 = f.raH;
            ad.w(f.access$getTAG$cp(), "no thumb & no thumbRect");
            localObject2 = e.qQW;
            localObject1 = e.ZE((String)localObject1);
          }
        }
      }
      AppMethodBeat.o(200760);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap, v.a parama, f.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(200757);
        f.a locala = f.raH;
        ad.i(f.access$getTAG$cp(), "set coverUrl");
        f.a(jdField_this.raI, this.Lmb);
        f.e(jdField_this.raI).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(200756);
            f.a(this.Lme.Lmd.raI);
            AppMethodBeat.o(200756);
          }
        });
        AppMethodBeat.o(200757);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$2$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$2"})
    static final class b
      implements Runnable
    {
      b(String paramString, int paramInt, v.a parama, Bitmap paramBitmap, f.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(200759);
        jdField_this.raI.rae.add(this.ram);
        f.a locala = f.raH;
        ad.i(f.access$getTAG$cp(), "add thumb file, index:" + i);
        if (locala.Jhs)
        {
          f.a(jdField_this.raI, this.rao);
          f.e(jdField_this.raI).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(200758);
              f.a(this.Lmf.Lmd.raI);
              AppMethodBeat.o(200758);
            }
          });
        }
        AppMethodBeat.o(200759);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.f
 * JD-Core Version:    0.7.0.1
 */