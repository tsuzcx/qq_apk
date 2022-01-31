package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.f.b.t;
import a.g;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.img.MPImgLayout;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.e.b;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizImgDetailUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "()V", "TAG", "", "animationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "animationIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "Lkotlin/Lazy;", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "animationMaskView", "getAnimationMaskView", "animationMaskView$delegate", "bizImgLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/img/MPImgLayout;", "getBizImgLayout", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/img/MPImgLayout;", "bizImgLayout$delegate", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "imgHeight", "", "isInFullScreen", "", "maxHeight", "minHeight", "destroyReport", "", "destroyWebView", "finish", "getForceOrientation", "getFullscreenImpl", "init", "initActionBar", "initAnimationView", "initBaseParam", "initImgLayout", "initWriteCommentContainer", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "onBackPressed", "onDestroy", "onPause", "onResetAfterCreate", "onResetBeforeCreate", "onResume", "onStart", "postBinded", "setLayoutHeight", "view", "height", "setTouchListener", "plugin-brandservice_release"})
@com.tencent.mm.ui.base.a(6)
public class BizImgDetailUI
  extends TmplShareWebViewToolUI
{
  private final String TAG;
  private int fsr;
  private final b.a hnw;
  private final a.f kff;
  private final a.f kfg;
  private final a.f kfh;
  private final a.f kfi;
  private boolean kfj;
  private com.tencent.mm.plugin.brandservice.ui.widget.a kfk;
  private h kfl;
  private com.tencent.mm.plugin.brandservice.ui.widget.b kfm;
  private int maxHeight;
  private int minHeight;
  
  static
  {
    AppMethodBeat.i(152778);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(BizImgDetailUI.class), "bizImgLayout", "getBizImgLayout()Lcom/tencent/mm/plugin/brandservice/ui/timeline/img/MPImgLayout;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(BizImgDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(BizImgDetailUI.class), "animationMaskView", "getAnimationMaskView()Landroid/view/View;")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(BizImgDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")) };
    AppMethodBeat.o(152778);
  }
  
  public BizImgDetailUI()
  {
    AppMethodBeat.i(152793);
    this.TAG = "MicroMsg.BizImgDetailUI";
    this.kff = g.j((a.f.a.a)new d(this));
    this.kfg = g.j((a.f.a.a)new BizImgDetailUI.a(this));
    this.kfh = g.j((a.f.a.a)new BizImgDetailUI.c(this));
    this.kfi = g.j((a.f.a.a)new BizImgDetailUI.b(this));
    this.kfl = new h();
    this.kfm = ((com.tencent.mm.plugin.brandservice.ui.widget.b)new f(this));
    this.hnw = ((b.a)new e(this));
    AppMethodBeat.o(152793);
  }
  
  private static void S(View paramView, int paramInt)
  {
    AppMethodBeat.i(152784);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView = new a.v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(152784);
      throw paramView;
    }
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(152784);
  }
  
  private final MPImgLayout aZb()
  {
    AppMethodBeat.i(152779);
    MPImgLayout localMPImgLayout = (MPImgLayout)this.kff.getValue();
    AppMethodBeat.o(152779);
    return localMPImgLayout;
  }
  
  private final View aZc()
  {
    AppMethodBeat.i(152780);
    View localView = (View)this.kfi.getValue();
    AppMethodBeat.o(152780);
    return localView;
  }
  
  public final void a(el paramel)
  {
    AppMethodBeat.i(152791);
    if (paramel == null)
    {
      AppMethodBeat.o(152791);
      return;
    }
    sz(paramel.wqB);
    if ((paramel.wqF != null) && (this.jXn.aZg())) {
      this.jXn.kfA = paramel.wqF;
    }
    this.jXn.fgl = paramel.fgl;
    this.jXn.kfq = paramel.wqE;
    this.jXn.Hq(paramel.url);
    aYf().setUrl(paramel.url);
    AppMethodBeat.o(152791);
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(152783);
    super.aMf();
    if (this.igU != null)
    {
      this.jXn.kfB.kil = this.igU.nT(aYe().HD());
      this.jXn.kfB.dN(1, 0);
    }
    AppMethodBeat.o(152783);
  }
  
  public final void aYO()
  {
    AppMethodBeat.i(152781);
    super.aYO();
    com.tencent.mm.pluginsdk.f.m((MMActivity)this);
    AppMethodBeat.o(152781);
  }
  
  public final void aYm()
  {
    AppMethodBeat.i(152782);
    super.aYm();
    if (aYe().fjD == null)
    {
      finish();
      ab.w(this.TAG, "onCreate msgInfo.item is null");
      AppMethodBeat.o(152782);
      return;
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("onCreate rawUrl is ");
    Object localObject3 = aYe().fjD;
    if (localObject3 == null) {
      j.ebi();
    }
    ab.i((String)localObject1, ((com.tencent.mm.af.q)localObject3).url);
    this.jXn.a(this.hnw);
    this.kcX.a((TmplShareWebViewToolUI)this, aYe(), this.jXn);
    setActionbarColor(com.tencent.mm.cb.a.m((Context)getContext(), 2131690605));
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this), 2131230746);
    getController().n((Activity)this, -16777216);
    setMMTitle("");
    this.vec = true;
    this.jXn.kfx = getTimeLineSessionId();
    localObject1 = this.jXn;
    localObject2 = (TmplShareWebViewToolUI)this;
    int i = getScene();
    int j = getSubScene();
    localObject3 = aYe().fjD;
    if (localObject3 == null) {
      j.ebi();
    }
    ((b)localObject1).a((TmplShareWebViewToolUI)localObject2, i, j, (com.tencent.mm.af.q)localObject3, aYe(), getEnterId());
    this.jXn.aZe();
    aYf().setTimeLineSessionId(getTimeLineSessionId());
    aYf().aZJ();
    aYf().a(this.jXn.scene, this.jXn.kbN, this.jXn.fgh, this.jXn.kfv, this.jXn.url, aYe().fjD.title);
    localObject1 = this.kfl;
    localObject2 = getIntent();
    j.p(localObject2, "intent");
    localObject3 = getContext();
    j.p(localObject3, "context");
    localObject3 = (Context)localObject3;
    View localView = aZc();
    j.p(localView, "animationLayout");
    ((h)localObject1).a((Intent)localObject2, (Context)localObject3, localView, (View)this.kfh.getValue());
    localObject1 = e.kif;
    localObject1 = (ImageView)this.kfg.getValue();
    localObject2 = aYe().fjD.fjJ;
    j.p(localObject2, "msgInfo.item.cover");
    e.a((ImageView)localObject1, (String)localObject2, 1080, 760, aYe());
    this.iiW = com.tencent.mm.cb.a.gw((Context)getContext());
    this.iiX = com.tencent.mm.cb.a.gx((Context)getContext());
    this.maxHeight = ((int)(0.65D * this.iiX));
    this.minHeight = (this.iiW * 9 / 16);
    this.maxHeight = Math.max(this.maxHeight, this.minHeight);
    this.fsr = this.minHeight;
    S((View)aYg(), this.fsr);
    localObject1 = aZc();
    j.p(localObject1, "animationLayout");
    S((View)localObject1, this.fsr);
    aYg().addView((View)aZb());
    localObject2 = aZb();
    localObject1 = aYe();
    localObject3 = this.jXn;
    j.q(localObject1, "msgInfo");
    j.q(localObject3, "controller");
    ((MPImgLayout)localObject2).jXm = ((s)localObject1);
    ((MPImgLayout)localObject2).jXn = ((b)localObject3);
    localObject3 = e.kif;
    localObject2 = ((MPImgLayout)localObject2).jXo;
    localObject3 = ((s)localObject1).fjD.fjJ;
    j.p(localObject3, "msgInfo.item.cover");
    e.a((ImageView)localObject2, (String)localObject3, 1080, 760, (s)localObject1);
    dL(this.fsr, this.minHeight);
    aYf().setMinHeaderHeight(this.minHeight);
    AppMethodBeat.o(152782);
  }
  
  public final void aYn() {}
  
  public void finish()
  {
    AppMethodBeat.i(152788);
    super.finish();
    overridePendingTransition(2131034130, 2131034228);
    AppMethodBeat.o(152788);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(152792);
    if (this.kcX.onActivityResult(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(152792);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(152792);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(152790);
    if (!aYf().aZK()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(152790);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(152789);
    super.onDestroy();
    if (this.kfk != null)
    {
      com.tencent.mm.plugin.brandservice.ui.widget.a locala = this.kfk;
      if (locala == null) {
        j.ebi();
      }
      locala.b(this.kfm);
    }
    this.jXn.onDestroy();
    aYf().onDestroy();
    AppMethodBeat.o(152789);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(152787);
    super.onPause();
    AppMethodBeat.o(152787);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(152785);
    super.onResume();
    AppMethodBeat.o(152785);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(152786);
    super.onStart();
    if (aYe().fjD == null)
    {
      finish();
      ab.w(this.TAG, "onStart msgInfo.item is null");
      AppMethodBeat.o(152786);
      return;
    }
    aYd().bringToFront();
    h localh = this.kfl;
    if (!s.kr(aYe().fgk)) {}
    for (boolean bool = true;; bool = false)
    {
      localh.enable = bool;
      this.kfl.a((e.b)new BizImgDetailUI.h());
      AppMethodBeat.o(152786);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/img/MPImgLayout;", "invoke"})
  static final class d
    extends a.f.b.k
    implements a.f.a.a<MPImgLayout>
  {
    d(BizImgDetailUI paramBizImgDetailUI)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "callback"})
  static final class e
    implements b.a
  {
    e(BizImgDetailUI paramBizImgDetailUI) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb)
    {
      AppMethodBeat.i(152775);
      BizImgDetailUI.c(this.kfn).aZf();
      if (paramb == null)
      {
        AppMethodBeat.o(152775);
        return;
      }
      ab.i(BizImgDetailUI.d(this.kfn), "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", type: " + paramb.getType());
      paramString = paramb.adm();
      if (((paramString instanceof ek)) && (((ek)paramString).wqb != BizImgDetailUI.c(this.kfn).kfv))
      {
        AppMethodBeat.o(152775);
        return;
      }
      if (paramb.getType() == 1179)
      {
        BizImgDetailUI.e(this.kfn).aZP();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = paramb.adn();
          if (paramString == null)
          {
            paramString = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
            AppMethodBeat.o(152775);
            throw paramString;
          }
          paramString = (el)paramString;
          paramb = BizImgDetailUI.d(this.kfn);
          Object localObject = new StringBuilder("url_info size is ");
          LinkedList localLinkedList;
          if (paramString.wqw != null)
          {
            localLinkedList = paramString.wqw;
            if (localLinkedList == null) {
              j.ebi();
            }
          }
          for (paramInt1 = localLinkedList.size();; paramInt1 = 0)
          {
            ab.i(paramb, paramInt1);
            if ((paramString.wqx == 0) || (bo.isNullOrNil(paramString.wqy))) {
              break;
            }
            ab.i(BizImgDetailUI.d(this.kfn), "onSceneEnd redirect %s", new Object[] { paramString.wqy });
            paramb = this.kfn.getContext();
            j.p(paramb, "context");
            paramb = (Context)paramb;
            localObject = BizImgDetailUI.f(this.kfn);
            paramString = paramString.wqy;
            j.p(paramString, "resp.redirect_url");
            e.a(paramb, (s)localObject, paramString);
            al.p((Runnable)new BizImgDetailUI.e.1(this), 500L);
            AppMethodBeat.o(152775);
            return;
          }
          this.kfn.a(paramString);
          AppMethodBeat.o(152775);
          return;
        }
        this.kfn.a(null);
        AppMethodBeat.o(152775);
        return;
      }
      AppMethodBeat.o(152775);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizImgDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
  public static final class f
    extends com.tencent.mm.plugin.brandservice.ui.widget.b
  {
    public final void aDk()
    {
      AppMethodBeat.i(152776);
      BizImgDetailUI.b(this.kfn);
      AppMethodBeat.o(152776);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(BizImgDetailUI paramBizImgDetailUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(152777);
      this.kfn.hideVKB();
      this.kfn.finish();
      AppMethodBeat.o(152777);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizImgDetailUI
 * JD-Core Version:    0.7.0.1
 */