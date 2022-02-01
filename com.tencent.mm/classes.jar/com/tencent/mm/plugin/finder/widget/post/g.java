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
import com.tencent.mm.ac.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCompositionInfo", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCompositionInfo", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "container", "Landroid/view/View;", "coverQuality", "", "coverUrl", "", "cropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getCropInfoList", "()Ljava/util/ArrayList;", "setCropInfoList", "(Ljava/util/ArrayList;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Landroid/widget/ImageView;", "videoFileList", "getVideoFileList", "setVideoFileList", "videoPathBeforeCut", "adjustMargin", "", "width", "height", "checkData", "", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "initFakeVideoLogic", "initNormalVideoLogic", "jumpSelectCoverUI", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showThumb", "thumb", "Landroid/graphics/Bitmap;", "Companion", "plugin-finder_release"})
public final class g
  extends a
{
  private static final String TAG = "Finder.PostVideoWidget";
  private static final int tqk = 1001;
  private static final String tql = "RESULT_COVER_PATH";
  private static final String tqm = "RESULT_COVER_QUALITY";
  public static final a tqn;
  private String coverUrl;
  private View iBX;
  private View kFh;
  private ImageView tpC;
  private View tpD;
  ArrayList<String> tpG;
  ArrayList<String> tqf;
  ArrayList<bwj> tqg;
  aaq tqh;
  private int tqi;
  private String tqj;
  
  static
  {
    AppMethodBeat.i(168626);
    tqn = new a((byte)0);
    tqk = 1001;
    tql = "RESULT_COVER_PATH";
    tqm = "RESULT_COVER_QUALITY";
    TAG = "Finder.PostVideoWidget";
    AppMethodBeat.o(168626);
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168625);
    this.tpG = new ArrayList();
    this.tqg = new ArrayList();
    this.coverUrl = "";
    this.tqj = "";
    AppMethodBeat.o(168625);
  }
  
  private final void cRA()
  {
    AppMethodBeat.i(206440);
    Bundle localBundle = this.dyY;
    if (localBundle != null)
    {
      Object localObject2 = localBundle.getString("video_before_cut_path");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.tqj = ((String)localObject1);
      localObject1 = localBundle.getParcelableArrayList("VIDEO_CROP_LIST");
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof LocalVideoCropInfoParcelable))) {
            this.tqg.add(((LocalVideoCropInfoParcelable)localObject2).stz);
          } else {
            this.tqg.add(null);
          }
        }
        AppMethodBeat.o(206440);
        return;
      }
      AppMethodBeat.o(206440);
      return;
    }
    AppMethodBeat.o(206440);
  }
  
  private final boolean cRz()
  {
    AppMethodBeat.i(206439);
    Object localObject1 = this.dyY;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getByteArray("video_composition");
      if (localObject1 != null)
      {
        Object localObject3;
        try
        {
          ae.i(TAG, "initFakeVideoLogic");
          localObject3 = this.iBX;
          if (localObject3 == null) {
            d.g.b.p.bdF("container");
          }
          ((View)localObject3).setVisibility(0);
          localObject1 = new aaq().parseFrom((byte[])localObject1);
          if (localObject1 != null) {
            break label117;
          }
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CompositionInfo");
          AppMethodBeat.o(206439);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException)
        {
          ae.printErrStackTrace(TAG, (Throwable)localIOException, "parse error", new Object[0]);
        }
        AppMethodBeat.o(206439);
        return true;
        label117:
        this.tqh = ((aaq)localIOException);
        Object localObject2 = this.dyY;
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("VIDEO_THUMB_LIST");
          label142:
          localObject3 = new y.f();
          ((y.f)localObject3).NiY = "";
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
            localObject2 = j.jl((List)localObject2);
            d.g.b.p.g(localObject2, "mediaThumbList.first()");
            ((y.f)localObject3).NiY = ((String)localObject2);
          }
          c.b("PostVideoWidget_initFakeVideoLogic", (d.g.a.a)new b((y.f)localObject3, this));
          localObject2 = this.tpC;
          if (localObject2 == null) {
            d.g.b.p.bdF("thumbIv");
          }
          ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new c((y.f)localObject3, this));
          localObject2 = this.kFh;
          if (localObject2 == null) {
            d.g.b.p.bdF("rootView");
          }
          ((View)localObject2).findViewById(2131307963).setOnClickListener((View.OnClickListener)new d((y.f)localObject3, this));
          break;
          localObject2 = null;
          break label142;
        }
      }
    }
    AppMethodBeat.o(206439);
    return false;
  }
  
  private final void ga(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(206438);
    Object localObject1 = this.kFh;
    if (localObject1 == null) {
      d.g.b.p.bdF("rootView");
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
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if ((((Number)com.tencent.mm.plugin.finder.storage.b.cKe().value()).intValue() != 2) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt2 / paramInt1 < 1.316667F)) {
        break label272;
      }
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      if (localObject1 != null)
      {
        localObject2 = ak.getContext();
        d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099828));
      }
      localObject1 = this.kFh;
      if (localObject1 == null) {
        d.g.b.p.bdF("rootView");
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
      AppMethodBeat.o(206438);
      return;
      localObject1 = null;
      break;
      label267:
      localObject1 = null;
      break label106;
      label272:
      if (localLayoutParams != null)
      {
        localObject2 = this.kFh;
        if (localObject2 == null) {
          d.g.b.p.bdF("rootView");
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
        localObject2 = ak.getContext();
        d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100711));
      }
      localObject1 = this.kFh;
      if (localObject1 == null) {
        d.g.b.p.bdF("rootView");
      }
      localObject1 = ((View)localObject1).findViewById(2131308324);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    label402:
    AppMethodBeat.o(206438);
  }
  
  public final View cRs()
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
    this.kFh = ((View)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306317);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.video_container)");
    this.iBX = ((View)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    localObject = ((View)localObject).findViewById(2131305801);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.tpC = ((ImageView)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304092);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.tpD = ((View)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    AppMethodBeat.o(168622);
    return localObject;
  }
  
  public final h cRt()
  {
    AppMethodBeat.i(206437);
    Object localObject3;
    Object localObject2;
    label63:
    Object localObject4;
    if (this.tqh != null)
    {
      localObject3 = new bvy();
      localObject1 = this.dyY;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getStringArrayList("VIDEO_THUMB_LIST");
        if (localObject1 != null)
        {
          localObject2 = (String)j.jl((List)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label63;
          }
        }
      }
      localObject1 = "";
      localObject2 = ((bvy)localObject3).mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.i.sUG;
      localObject4 = this.tqh;
      if (localObject4 == null) {
        d.g.b.p.gkB();
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.i.a((aaq)localObject4, (String)localObject1, this.coverUrl);
      localObject4 = new apo();
      ((apo)localObject4).GGD = this.tqi;
      ((bvz)localObject1).codec_info = ((apo)localObject4);
      ae.i(TAG, "codec_info video_cover_score:" + this.tqi);
      ((LinkedList)localObject2).add(localObject1);
      localObject1 = new h(true, 4, (bvy)localObject3, this.tqj);
      AppMethodBeat.o(206437);
      return localObject1;
    }
    if ((this.tpk != null) && (this.tpl != null))
    {
      localObject1 = new h(true, 4, this.tpl);
      AppMethodBeat.o(206437);
      return localObject1;
    }
    Object localObject1 = (Collection)this.tqf;
    int i;
    label332:
    label369:
    Object localObject5;
    String str;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label545;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("video list ");
      localObject3 = this.tqf;
      if (localObject3 == null) {
        d.g.b.p.gkB();
      }
      ae.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.tpG.size());
      localObject1 = this.tqf;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (((ArrayList)localObject1).size() != this.tpG.size()) {
        break label540;
      }
      i = 1;
      if (i == 0) {
        break label594;
      }
      localObject2 = new bvy();
      localObject1 = this.tqf;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label564;
      }
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.gkd();
      }
      localObject5 = (String)localObject1;
      localObject4 = ((bvy)localObject2).mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.i.sUG;
      str = bu.nullAsNil((String)this.tpG.get(i));
      d.g.b.p.g(str, "Util.nullAsNil(thumbFileList[index])");
      if (this.tqg.size() <= i) {
        break label559;
      }
    }
    label540:
    label545:
    label559:
    for (localObject1 = (bwj)this.tqg.get(i);; localObject1 = null)
    {
      localObject1 = com.tencent.mm.plugin.finder.upload.i.a((String)localObject5, str, (bwj)localObject1, this.coverUrl);
      localObject5 = new apo();
      ((apo)localObject5).GGD = this.tqi;
      ((bvz)localObject1).codec_info = ((apo)localObject5);
      ae.i(TAG, "codec_info video_cover_score:" + this.tqi);
      ((LinkedList)localObject4).add(localObject1);
      i += 1;
      break label369;
      i = 0;
      break;
      i = 0;
      break label332;
      ae.i(TAG, "video list null");
      i = 0;
      break label332;
    }
    label564:
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    localObject1 = new h(true, com.tencent.mm.plugin.finder.utils.p.a((bvy)localObject2), (bvy)localObject2, this.tqj);
    AppMethodBeat.o(206437);
    return localObject1;
    label594:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(206437);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168624);
    Object localObject1 = this.dyY;
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
    localObject1 = this.dyY;
    if (localObject1 != null)
    {
      i = ((Bundle)localObject1).getInt("VIDEO_COVER_QUALITY", 0);
      this.tqi = i;
      localObject1 = this.dyY;
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
      cRz();
      AppMethodBeat.o(168624);
      return;
      i = 0;
      break;
    }
    label108:
    if (this.tpl != null)
    {
      localObject1 = this.tpl;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (!bu.ht((List)((bvy)localObject1).mediaList))
      {
        localObject1 = this.iBX;
        if (localObject1 == null) {
          d.g.b.p.bdF("container");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.tpD;
        if (localObject1 == null) {
          d.g.b.p.bdF("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.tpl;
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        localObject1 = ((bvy)localObject1).mediaList;
        d.g.b.p.g(localObject1, "refFeedContent!!.mediaList");
        localObject1 = (bvz)((LinkedList)localObject1).getFirst();
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.fT((int)((bvz)localObject1).width, (int)((bvz)localObject1).height);
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.bdF("thumbIv");
        }
        ((ImageView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bvz)localObject1).width);
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.bdF("thumbIv");
        }
        ((ImageView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bvz)localObject1).height);
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.bdF("thumbIv");
        }
        i = ((ImageView)localObject3).getLayoutParams().width;
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.bdF("thumbIv");
        }
        ga(i, ((ImageView)localObject3).getLayoutParams().height);
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.bdF("thumbIv");
        }
        ((ImageView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        localObject2 = this.tpC;
        if (localObject2 == null) {
          d.g.b.p.bdF("thumbIv");
        }
        ((ImageView)localObject2).requestLayout();
        d.g.b.p.g(localObject1, "mediaObj");
        localObject1 = new com.tencent.mm.plugin.finder.loader.g((bvz)localObject1, r.sJv);
        localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
        localObject2 = com.tencent.mm.plugin.finder.loader.i.cEn();
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.bdF("thumbIv");
        }
        com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
        ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
        localObject1 = this.tpC;
        if (localObject1 == null) {
          d.g.b.p.bdF("thumbIv");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new g(this));
        AppMethodBeat.o(168624);
        return;
      }
    }
    localObject1 = this.dyY;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("video_file_list");
      this.tqf = ((ArrayList)localObject1);
      this.tpG = new ArrayList();
      localObject3 = this.dyY;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getStringArrayList("VIDEO_THUMB_LIST");
      }
      localObject2 = this.dyY;
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
      localObject2 = this.dyY;
      if (localObject2 == null) {
        break label746;
      }
      i = ((Bundle)localObject2).getInt("VIDEO_COVER_QUALITY", 0);
      label624:
      this.tqi = i;
      cRA();
      localObject2 = (Collection)this.tqf;
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
        localObject2 = this.kFh;
        if (localObject2 == null) {
          d.g.b.p.bdF("rootView");
        }
        ((View)localObject2).findViewById(2131307963).setOnClickListener((View.OnClickListener)new e(this));
        localObject2 = this.iBX;
        if (localObject2 == null) {
          d.g.b.p.bdF("container");
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget$Companion;", "", "()V", "REQUEST_SELECT_COVER", "", "getREQUEST_SELECT_COVER", "()I", "RESULT_COVER_PATH", "", "getRESULT_COVER_PATH", "()Ljava/lang/String;", "RESULT_COVER_QUALITY", "getRESULT_COVER_QUALITY", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(y.f paramf, g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$2"})
  static final class c
    implements View.OnClickListener
  {
    c(y.f paramf, g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206429);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = new bvy();
      localObject1 = paramView.mediaList;
      Object localObject2 = com.tencent.mm.plugin.finder.upload.i.sUG;
      localObject2 = jdField_this.tqh;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.a((aaq)localObject2, (String)this.tqo.NiY, g.b(jdField_this)));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
      localObject1 = jdField_this.context;
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(206429);
        throw paramView;
      }
      localObject1 = (Activity)localObject1;
      localObject2 = (View)g.c(jdField_this);
      Object localObject3 = jdField_this.context;
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(206429);
        throw paramView;
      }
      localObject3 = ((MMActivity)localObject3).getWindow();
      d.g.b.p.g(localObject3, "(context as MMActivity).window");
      localObject2 = ViewAnimHelper.o((View)localObject2, ((Window)localObject3).getDecorView());
      d.g.b.p.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, jdField_this.tpk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206429);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$3"})
  static final class d
    implements View.OnClickListener
  {
    d(y.f paramf, g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206430);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = new bvy();
      localObject1 = paramView.mediaList;
      Object localObject2 = com.tencent.mm.plugin.finder.upload.i.sUG;
      localObject2 = jdField_this.tqh;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.a((aaq)localObject2, (String)this.tqo.NiY, g.b(jdField_this)));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
      localObject1 = jdField_this.context;
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(206430);
        throw paramView;
      }
      localObject1 = (Activity)localObject1;
      localObject2 = (View)g.c(jdField_this);
      Object localObject3 = jdField_this.context;
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(206430);
        throw paramView;
      }
      localObject3 = ((MMActivity)localObject3).getWindow();
      d.g.b.p.g(localObject3, "(context as MMActivity).window");
      localObject2 = ViewAnimHelper.o((View)localObject2, ((Window)localObject3).getDecorView());
      d.g.b.p.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
      localObject3 = g.tqn;
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, g.cRB());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206430);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206431);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      g.d(this.tqp);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206431);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(g paramg, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(206436);
      Object localObject1 = this.tqp.tqf;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      final int i = 0;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (i < 0) {
          j.gkd();
        }
        localObject1 = (String)localObject1;
        final y.a locala = new y.a();
        boolean bool;
        if (i == 0)
        {
          bool = true;
          label78:
          locala.NiT = bool;
          if ((this.tqd == null) || (this.tqd.size() <= i) || (bu.isNullOrNil((String)this.tqd.get(i)))) {
            break label256;
          }
          localObject1 = (String)this.tqd.get(i);
        }
        for (;;)
        {
          if ((locala.NiT) && (!bu.isNullOrNil(g.b(this.tqp))) && (o.fB(g.b(this.tqp))))
          {
            localObject2 = com.tencent.mm.sdk.platformtools.h.decodeFile(g.b(this.tqp));
            if (localObject2 != null)
            {
              ar.f((Runnable)new a((Bitmap)localObject2, locala, this));
              locala.NiT = false;
            }
          }
          if (!bu.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject1);
            if (localObject2 != null) {
              ar.f((Runnable)new b((String)localObject1, i, locala, (Bitmap)localObject2, this));
            }
          }
          i += 1;
          break;
          bool = false;
          break label78;
          label256:
          if ((this.tqp.tqg.size() > i) && (this.tqp.tqg.get(i) != null))
          {
            localObject2 = this.tqp.tqg.get(i);
            if (localObject2 == null) {
              d.g.b.p.gkB();
            }
            if (((bwj)localObject2).Hjp != null)
            {
              localObject2 = f.sUp;
              localObject2 = this.tqp.tqg.get(i);
              if (localObject2 == null) {
                d.g.b.p.gkB();
              }
              localObject2 = ((bwj)localObject2).Hjp;
              if (localObject2 == null) {
                d.g.b.p.gkB();
              }
              d.g.b.p.g(localObject2, "cropInfoList[index]!!.thumbRect!!");
              localObject1 = f.a((String)localObject1, (dwz)localObject2);
              continue;
            }
          }
          Object localObject2 = g.tqn;
          ae.w(g.access$getTAG$cp(), "no thumb & no thumbRect");
          localObject2 = f.sUp;
          localObject1 = f.ajH((String)localObject1);
        }
      }
      AppMethodBeat.o(206436);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap, y.a parama, g.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(206433);
        g.a locala = g.tqn;
        ae.i(g.access$getTAG$cp(), "set coverUrl");
        g.a(jdField_this.tqp, this.tqs);
        g.c(jdField_this.tqp).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(206432);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            g.a(this.tqv.tqu.tqp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(206432);
          }
        });
        AppMethodBeat.o(206433);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$2$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$2"})
    static final class b
      implements Runnable
    {
      b(String paramString, int paramInt, y.a parama, Bitmap paramBitmap, g.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(206435);
        jdField_this.tqp.tpG.add(this.tpP);
        g.a locala = g.tqn;
        ae.i(g.access$getTAG$cp(), "add thumb file, index:" + i);
        if (locala.NiT)
        {
          g.a(jdField_this.tqp, this.tpR);
          g.c(jdField_this.tqp).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(206434);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              g.a(this.tqw.tqu.tqp);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(206434);
            }
          });
        }
        AppMethodBeat.o(206435);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168618);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      g.a(this.tqp);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g
 * JD-Core Version:    0.7.0.1
 */