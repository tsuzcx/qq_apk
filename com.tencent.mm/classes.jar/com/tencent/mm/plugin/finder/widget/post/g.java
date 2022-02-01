package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mm.ad.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.a.j;
import d.g.b.q;
import d.g.b.y.a;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCompositionInfo", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCompositionInfo", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "container", "Landroid/view/View;", "coverQuality", "", "coverUrl", "", "cropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getCropInfoList", "()Ljava/util/ArrayList;", "setCropInfoList", "(Ljava/util/ArrayList;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Landroid/widget/ImageView;", "videoFileList", "getVideoFileList", "setVideoFileList", "videoPathBeforeCut", "adjustMargin", "", "width", "height", "checkData", "", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "initFakeVideoLogic", "initNormalVideoLogic", "jumpSelectCoverUI", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showThumb", "thumb", "Landroid/graphics/Bitmap;", "Companion", "plugin-finder_release"})
public final class g
  extends a
{
  private static final String TAG = "Finder.PostVideoWidget";
  private static final int tfr = 1001;
  private static final String tfs = "RESULT_COVER_PATH";
  private static final String tft = "RESULT_COVER_QUALITY";
  public static final a tfu;
  private String coverUrl;
  private View ize;
  private View kBS;
  private ImageView teJ;
  private View teK;
  ArrayList<String> teN;
  ArrayList<String> tfm;
  ArrayList<bvp> tfn;
  aan tfo;
  private int tfp;
  private String tfq;
  
  static
  {
    AppMethodBeat.i(168626);
    tfu = new a((byte)0);
    tfr = 1001;
    tfs = "RESULT_COVER_PATH";
    tft = "RESULT_COVER_QUALITY";
    TAG = "Finder.PostVideoWidget";
    AppMethodBeat.o(168626);
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168625);
    this.teN = new ArrayList();
    this.tfn = new ArrayList();
    this.coverUrl = "";
    this.tfq = "";
    AppMethodBeat.o(168625);
  }
  
  private final boolean cOU()
  {
    AppMethodBeat.i(205825);
    Object localObject1 = this.dxT;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getByteArray("video_composition");
      if (localObject1 != null)
      {
        Object localObject3;
        try
        {
          ad.i(TAG, "initFakeVideoLogic");
          localObject3 = this.ize;
          if (localObject3 == null) {
            d.g.b.p.bcb("container");
          }
          ((View)localObject3).setVisibility(0);
          localObject1 = new aan().parseFrom((byte[])localObject1);
          if (localObject1 != null) {
            break label117;
          }
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CompositionInfo");
          AppMethodBeat.o(205825);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace(TAG, (Throwable)localIOException, "parse error", new Object[0]);
        }
        AppMethodBeat.o(205825);
        return true;
        label117:
        this.tfo = ((aan)localIOException);
        Object localObject2 = this.dxT;
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("VIDEO_THUMB_LIST");
          label142:
          localObject3 = new y.f();
          ((y.f)localObject3).MLV = "";
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
            localObject2 = j.jc((List)localObject2);
            d.g.b.p.g(localObject2, "mediaThumbList.first()");
            ((y.f)localObject3).MLV = ((String)localObject2);
          }
          c.b("PostVideoWidget_initFakeVideoLogic", (d.g.a.a)new b((y.f)localObject3, this));
          localObject2 = this.teJ;
          if (localObject2 == null) {
            d.g.b.p.bcb("thumbIv");
          }
          ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new c((y.f)localObject3, this));
          localObject2 = this.kBS;
          if (localObject2 == null) {
            d.g.b.p.bcb("rootView");
          }
          ((View)localObject2).findViewById(2131307963).setOnClickListener((View.OnClickListener)new d((y.f)localObject3, this));
          break;
          localObject2 = null;
          break label142;
        }
      }
    }
    AppMethodBeat.o(205825);
    return false;
  }
  
  private final void cOV()
  {
    AppMethodBeat.i(205826);
    Bundle localBundle = this.dxT;
    if (localBundle != null)
    {
      Object localObject2 = localBundle.getString("video_before_cut_path");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.tfq = ((String)localObject1);
      localObject1 = localBundle.getParcelableArrayList("VIDEO_CROP_LIST");
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof LocalVideoCropInfoParcelable))) {
            this.tfn.add(((LocalVideoCropInfoParcelable)localObject2).skC);
          } else {
            this.tfn.add(null);
          }
        }
        AppMethodBeat.o(205826);
        return;
      }
      AppMethodBeat.o(205826);
      return;
    }
    AppMethodBeat.o(205826);
  }
  
  private final void ga(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(205824);
    Object localObject1 = this.kBS;
    if (localObject1 == null) {
      d.g.b.p.bcb("rootView");
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
        break label267;
      }
      localObject1 = localLinearLayout.getRootView();
      if (localObject1 == null) {
        break label267;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131303369);
      label106:
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if ((((Number)com.tencent.mm.plugin.finder.storage.b.cIi().value()).intValue() != 2) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt2 / paramInt1 < 1.316667F)) {
        break label272;
      }
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      if (localObject1 != null)
      {
        localObject2 = aj.getContext();
        d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099828));
      }
      localObject1 = this.kBS;
      if (localObject1 == null) {
        d.g.b.p.bcb("rootView");
      }
      localObject1 = ((View)localObject1).findViewById(2131308324);
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
        break label402;
      }
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(205824);
      return;
      localObject1 = null;
      break;
      label267:
      localObject1 = null;
      break label106;
      label272:
      if (localLayoutParams != null)
      {
        localObject2 = this.kBS;
        if (localObject2 == null) {
          d.g.b.p.bcb("rootView");
        }
        Resources localResources = ((View)localObject2).getResources();
        localObject2 = localObject3;
        if (localResources != null) {
          localObject2 = Integer.valueOf((int)localResources.getDimension(2131165295));
        }
        localLayoutParams.topMargin = ((Integer)localObject2).intValue();
      }
      if (localObject1 != null)
      {
        localObject2 = aj.getContext();
        d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100711));
      }
      localObject1 = this.kBS;
      if (localObject1 == null) {
        d.g.b.p.bcb("rootView");
      }
      localObject1 = ((View)localObject1).findViewById(2131308324);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    label402:
    AppMethodBeat.o(205824);
  }
  
  public final View cON()
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
    d.g.b.p.g(localObject, "(context as Activity).la…_post_video_widget, null)");
    this.kBS = ((View)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306317);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.video_container)");
    this.ize = ((View)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    localObject = ((View)localObject).findViewById(2131305801);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.teJ = ((ImageView)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304092);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.teK = ((View)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    AppMethodBeat.o(168622);
    return localObject;
  }
  
  public final h cOO()
  {
    AppMethodBeat.i(205823);
    Object localObject3;
    Object localObject2;
    label63:
    Object localObject4;
    if (this.tfo != null)
    {
      localObject3 = new bve();
      localObject1 = this.dxT;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getStringArrayList("VIDEO_THUMB_LIST");
        if (localObject1 != null)
        {
          localObject2 = (String)j.jc((List)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label63;
          }
        }
      }
      localObject1 = "";
      localObject2 = ((bve)localObject3).mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.i.sJt;
      localObject4 = this.tfo;
      if (localObject4 == null) {
        d.g.b.p.gfZ();
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.i.a((aan)localObject4, (String)localObject1, this.coverUrl);
      ((bvf)localObject1).codec_info = new apb();
      ((bvf)localObject1).codec_info.Gnx = this.tfp;
      ad.i(TAG, "codec_info video_cover_score:" + this.tfp);
      ((LinkedList)localObject2).add(localObject1);
      localObject1 = new h(true, 4, (bve)localObject3, this.tfq);
      AppMethodBeat.o(205823);
      return localObject1;
    }
    if ((this.ter != null) && (this.tes != null))
    {
      localObject1 = new h(true, 4, this.tes);
      AppMethodBeat.o(205823);
      return localObject1;
    }
    Object localObject1 = (Collection)this.tfm;
    int i;
    label330:
    label367:
    String str1;
    String str2;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label541;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("video list ");
      localObject3 = this.tfm;
      if (localObject3 == null) {
        d.g.b.p.gfZ();
      }
      ad.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.teN.size());
      localObject1 = this.tfm;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      if (((ArrayList)localObject1).size() != this.teN.size()) {
        break label536;
      }
      i = 1;
      if (i == 0) {
        break label590;
      }
      localObject2 = new bve();
      localObject1 = this.tfm;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label560;
      }
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.gfB();
      }
      str1 = (String)localObject1;
      localObject4 = ((bve)localObject2).mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.i.sJt;
      str2 = bt.nullAsNil((String)this.teN.get(i));
      d.g.b.p.g(str2, "Util.nullAsNil(thumbFileList[index])");
      if (this.tfn.size() <= i) {
        break label555;
      }
    }
    label536:
    label541:
    label555:
    for (localObject1 = (bvp)this.tfn.get(i);; localObject1 = null)
    {
      localObject1 = com.tencent.mm.plugin.finder.upload.i.a(str1, str2, (bvp)localObject1, this.coverUrl);
      ((bvf)localObject1).codec_info = new apb();
      ((bvf)localObject1).codec_info.Gnx = this.tfp;
      ad.i(TAG, "codec_info video_cover_score:" + this.tfp);
      ((LinkedList)localObject4).add(localObject1);
      i += 1;
      break label367;
      i = 0;
      break;
      i = 0;
      break label330;
      ad.i(TAG, "video list null");
      i = 0;
      break label330;
    }
    label560:
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    localObject1 = new h(true, com.tencent.mm.plugin.finder.utils.p.a((bve)localObject2), (bve)localObject2, this.tfq);
    AppMethodBeat.o(205823);
    return localObject1;
    label590:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(205823);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168624);
    Object localObject1 = this.dxT;
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
    localObject1 = this.dxT;
    if (localObject1 != null)
    {
      i = ((Bundle)localObject1).getInt("VIDEO_COVER_QUALITY", 0);
      this.tfp = i;
      localObject1 = this.dxT;
      if (localObject1 == null) {
        break label103;
      }
    }
    label103:
    for (localObject1 = ((Bundle)localObject1).getByteArray("video_composition");; localObject1 = null)
    {
      if (localObject1 == null) {
        break label108;
      }
      cOU();
      AppMethodBeat.o(168624);
      return;
      i = 0;
      break;
    }
    label108:
    if (this.tes != null)
    {
      localObject1 = this.tes;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      if (!bt.hj((List)((bve)localObject1).mediaList))
      {
        localObject1 = this.ize;
        if (localObject1 == null) {
          d.g.b.p.bcb("container");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.teK;
        if (localObject1 == null) {
          d.g.b.p.bcb("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.tes;
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        localObject1 = ((bve)localObject1).mediaList;
        d.g.b.p.g(localObject1, "refFeedContent!!.mediaList");
        localObject1 = (bvf)((LinkedList)localObject1).getFirst();
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.fT((int)((bvf)localObject1).width, (int)((bvf)localObject1).height);
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.bcb("thumbIv");
        }
        ((ImageView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bvf)localObject1).width);
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.bcb("thumbIv");
        }
        ((ImageView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bvf)localObject1).height);
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.bcb("thumbIv");
        }
        i = ((ImageView)localObject3).getLayoutParams().width;
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.bcb("thumbIv");
        }
        ga(i, ((ImageView)localObject3).getLayoutParams().height);
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.bcb("thumbIv");
        }
        ((ImageView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        localObject2 = this.teJ;
        if (localObject2 == null) {
          d.g.b.p.bcb("thumbIv");
        }
        ((ImageView)localObject2).requestLayout();
        d.g.b.p.g(localObject1, "mediaObj");
        localObject1 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject1, r.syE);
        localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
        localObject2 = com.tencent.mm.plugin.finder.loader.i.cCB();
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.bcb("thumbIv");
        }
        com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
        ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjb));
        localObject1 = this.teJ;
        if (localObject1 == null) {
          d.g.b.p.bcb("thumbIv");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new g(this));
        AppMethodBeat.o(168624);
        return;
      }
    }
    localObject1 = this.dxT;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("video_file_list");
      this.tfm = ((ArrayList)localObject1);
      this.teN = new ArrayList();
      localObject3 = this.dxT;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getStringArrayList("VIDEO_THUMB_LIST");
      }
      localObject2 = this.dxT;
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
      localObject2 = this.dxT;
      if (localObject2 == null) {
        break label746;
      }
      i = ((Bundle)localObject2).getInt("VIDEO_COVER_QUALITY", 0);
      label624:
      this.tfp = i;
      cOV();
      localObject2 = (Collection)this.tfm;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label751;
      }
    }
    label746:
    label751:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = this.kBS;
        if (localObject2 == null) {
          d.g.b.p.bcb("rootView");
        }
        ((View)localObject2).findViewById(2131307963).setOnClickListener((View.OnClickListener)new e(this));
        localObject2 = this.ize;
        if (localObject2 == null) {
          d.g.b.p.bcb("container");
        }
        ((View)localObject2).setVisibility(0);
        com.tencent.mm.sdk.g.b.c((Runnable)new f(this, (ArrayList)localObject1), "Finder_Post_Create_Video_Thumb");
      }
      AppMethodBeat.o(168624);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label624;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget$Companion;", "", "()V", "REQUEST_SELECT_COVER", "", "getREQUEST_SELECT_COVER", "()I", "RESULT_COVER_PATH", "", "getRESULT_COVER_PATH", "()Ljava/lang/String;", "RESULT_COVER_QUALITY", "getRESULT_COVER_QUALITY", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(y.f paramf, g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$2"})
  static final class c
    implements View.OnClickListener
  {
    c(y.f paramf, g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205815);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      paramView = new bve();
      localObject1 = paramView.mediaList;
      Object localObject2 = com.tencent.mm.plugin.finder.upload.i.sJt;
      localObject2 = jdField_this.tfo;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.a((aan)localObject2, (String)this.tfv.MLV, g.b(jdField_this)));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
      localObject1 = jdField_this.context;
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(205815);
        throw paramView;
      }
      localObject1 = (Activity)localObject1;
      localObject2 = (View)g.c(jdField_this);
      Object localObject3 = jdField_this.context;
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(205815);
        throw paramView;
      }
      localObject3 = ((MMActivity)localObject3).getWindow();
      d.g.b.p.g(localObject3, "(context as MMActivity).window");
      localObject2 = ViewAnimHelper.o((View)localObject2, ((Window)localObject3).getDecorView());
      d.g.b.p.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, jdField_this.ter);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205815);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$3"})
  static final class d
    implements View.OnClickListener
  {
    d(y.f paramf, g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205816);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      paramView = new bve();
      localObject1 = paramView.mediaList;
      Object localObject2 = com.tencent.mm.plugin.finder.upload.i.sJt;
      localObject2 = jdField_this.tfo;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.a((aan)localObject2, (String)this.tfv.MLV, g.b(jdField_this)));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
      localObject1 = jdField_this.context;
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(205816);
        throw paramView;
      }
      localObject1 = (Activity)localObject1;
      localObject2 = (View)g.c(jdField_this);
      Object localObject3 = jdField_this.context;
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(205816);
        throw paramView;
      }
      localObject3 = ((MMActivity)localObject3).getWindow();
      d.g.b.p.g(localObject3, "(context as MMActivity).window");
      localObject2 = ViewAnimHelper.o((View)localObject2, ((Window)localObject3).getDecorView());
      d.g.b.p.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
      localObject3 = g.tfu;
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, g.cOW());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205816);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205817);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      g.d(this.tfw);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205817);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(g paramg, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(205822);
      Object localObject1 = this.tfw.tfm;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      final int i = 0;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (i < 0) {
          j.gfB();
        }
        localObject1 = (String)localObject1;
        final y.a locala = new y.a();
        boolean bool;
        if (i == 0)
        {
          bool = true;
          label78:
          locala.MLQ = bool;
          if ((this.tfk == null) || (this.tfk.size() <= i) || (bt.isNullOrNil((String)this.tfk.get(i)))) {
            break label256;
          }
          localObject1 = (String)this.tfk.get(i);
        }
        for (;;)
        {
          Object localObject2;
          if ((locala.MLQ) && (!bt.isNullOrNil(g.b(this.tfw))) && (com.tencent.mm.vfs.i.fv(g.b(this.tfw))))
          {
            localObject2 = com.tencent.mm.sdk.platformtools.g.decodeFile(g.b(this.tfw));
            if (localObject2 != null)
            {
              aq.f((Runnable)new a((Bitmap)localObject2, locala, this));
              locala.MLQ = false;
            }
          }
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject1);
            if (localObject2 != null) {
              aq.f((Runnable)new b((String)localObject1, i, locala, (Bitmap)localObject2, this));
            }
          }
          i += 1;
          break;
          bool = false;
          break label78;
          label256:
          if ((this.tfw.tfn.size() > i) && (this.tfw.tfn.get(i) != null))
          {
            localObject2 = f.sJc;
            localObject2 = this.tfw.tfn.get(i);
            if (localObject2 == null) {
              d.g.b.p.gfZ();
            }
            localObject2 = ((bvp)localObject2).GPN;
            d.g.b.p.g(localObject2, "cropInfoList[index]!!.thumbRect");
            localObject1 = f.a((String)localObject1, (dwe)localObject2);
          }
          else
          {
            localObject2 = g.tfu;
            ad.w(g.access$getTAG$cp(), "no thumb & no thumbRect");
            localObject2 = f.sJc;
            localObject1 = f.aiK((String)localObject1);
          }
        }
      }
      AppMethodBeat.o(205822);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap, y.a parama, g.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(205819);
        g.a locala = g.tfu;
        ad.i(g.access$getTAG$cp(), "set coverUrl");
        g.a(jdField_this.tfw, this.tfz);
        g.c(jdField_this.tfw).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(205818);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            g.a(this.tfC.tfB.tfw);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(205818);
          }
        });
        AppMethodBeat.o(205819);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$2$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$2"})
    static final class b
      implements Runnable
    {
      b(String paramString, int paramInt, y.a parama, Bitmap paramBitmap, g.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(205821);
        jdField_this.tfw.teN.add(this.teW);
        g.a locala = g.tfu;
        ad.i(g.access$getTAG$cp(), "add thumb file, index:" + i);
        if (locala.MLQ)
        {
          g.a(jdField_this.tfw, this.teY);
          g.c(jdField_this.tfw).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(205820);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              g.a(this.tfD.tfB.tfw);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(205820);
            }
          });
        }
        AppMethodBeat.o(205821);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168618);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      g.a(this.tfw);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g
 * JD-Core Version:    0.7.0.1
 */