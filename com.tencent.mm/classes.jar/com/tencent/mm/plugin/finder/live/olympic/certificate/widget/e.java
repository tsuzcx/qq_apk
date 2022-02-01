package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.olympic.p;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "serive", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;Landroidx/lifecycle/LifecycleOwner;)V", "certificateActionSheetWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateActionSheetWidget;", "certificateBgLayout", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateBackgroundView;", "certificateBgPag", "Lorg/libpag/PAGView;", "certificateBurnTorchAnim", "certificateButton", "Landroid/widget/TextView;", "certificateButtonBg", "Landroid/widget/ImageView;", "certificateButtonLayout", "Landroid/widget/FrameLayout;", "certificateData", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData;", "certificateFaculaWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateFaculaWidget;", "certificateFrameBufferWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateFrameBufferWidget;", "certificateNegativeWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateNegativeWidget;", "certificatePositiveWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificatePositiveWidget;", "certificateSavePhoto", "certificateSettingBtn", "Landroid/widget/Button;", "certificateStateFrameBufferWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateStateFrameBufferWidget;", "certificateStatusPanel", "Landroid/widget/LinearLayout;", "certificateStatusText", "closeButton", "kotlin.jvm.PlatformType", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "moreActionButton", "getRoot", "()Landroid/view/ViewGroup;", "getSerive", "()Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;", "shadowLayout", "showMode", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout$CertificateMode;", "certificateButtonClick", "", "checkLocation", "closeOlympicCertificateLayer", "generateCertificate", "msg", "", "certificateState", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CertificateState;", "getCertificateData", "getFrameBufferView", "Landroid/view/View;", "getStateFrameBufferView", "handleBurnTorchState", "proxyBlock", "Lkotlin/Function0;", "handleLookCertificateState", "handleSelfRelayTorchState", "mount", "onBackPress", "", "onClick", "v", "onPagBgViewPlay", "onPagViewPlay", "resType", "Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$ResType;", "assestPag", "defaultTime", "", "pagEndBlock", "openCardWithAnim", "file", "Lorg/libpag/PAGFile;", "endTime", "openOlympicCertificateLayer", "state", "openShareOlympicCertificateLayer", "localCertificateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderOlympicLiveFireAuthorInfo;", "postCertificateData", "receiveLocationPermission", "isEnable", "relayOlympicTorch", "isAnim", "(Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData;Ljava/lang/Boolean;)V", "resetLayout", "savePhoto", "setAlphaAnimate", "view", "isEnter", "endBlock", "setScaleAnimate", "setVisible", "visibility", "setWxState", "shareOlympicCertificate", "showLayerAnimate", "isNegative", "isNeedShowBtn", "showMoreAction", "startCardAnimation", "positive", "negative", "onAnimateEnd", "unMount", "updateModeLayout", "updateOlympicCertificate", "updateOlympicCertificateError", "error", "Lcom/tencent/mm/plugin/finder/live/olympic/OlympicCgiException;", "CertificateMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements View.OnClickListener
{
  public static final e.b CPR;
  final com.tencent.mm.plugin.finder.live.olympic.certificate.b CPS;
  public f CPT;
  public g CPU;
  public b CPV;
  public d CPW;
  public h CPX;
  private c CPY;
  private ImageView CPZ;
  private CertificateBackgroundView CQa;
  public Button CQb;
  public FrameLayout CQc;
  private ImageView CQd;
  public TextView CQe;
  private TextView CQf;
  private PAGView CQg;
  public PAGView CQh;
  public final ImageView CQi;
  public final ImageView CQj;
  public com.tencent.mm.plugin.finder.live.olympic.certificate.data.a CQk;
  public e.a CQl;
  public LinearLayout agxk;
  private TextView agxl;
  public final ViewGroup mJe;
  private final aq mainScope;
  
  static
  {
    AppMethodBeat.i(361119);
    CPR = new e.b((byte)0);
    AppMethodBeat.o(361119);
  }
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.olympic.certificate.b paramb, q paramq)
  {
    AppMethodBeat.i(360950);
    this.mJe = paramViewGroup;
    this.CPS = paramb;
    this.CPT = new f(this.mJe, paramq);
    this.CPU = new g(this.mJe, paramq, this.CPS);
    this.CPV = new b(this.mJe, this.CPS, paramq);
    paramViewGroup = this.mJe.findViewById(p.e.BQb);
    s.s(paramViewGroup, "root.findViewById(R.id.f…cate_frame_buffer_layout)");
    this.CPW = new d((ViewGroup)paramViewGroup, paramq, this.CPS);
    paramViewGroup = this.mJe.findViewById(p.e.BQg);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ayout_state_frame_buffer)");
    this.CPX = new h((ViewGroup)paramViewGroup, paramq, this.CPS);
    this.CPY = new c(this.mJe, paramq);
    paramViewGroup = this.mJe.findViewById(p.e.BQl);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ympic_certificate_shadow)");
    this.CPZ = ((ImageView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BJF);
    s.s(paramViewGroup, "root.findViewById(R.id.finder_live_certificate_bg)");
    this.CQa = ((CertificateBackgroundView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BQk);
    s.s(paramViewGroup, "root.findViewById(R.id.f…_certificate_setting_btn)");
    this.CQb = ((Button)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BQa);
    s.s(paramViewGroup, "root.findViewById(R.id.f…c_certificate_btn_layout)");
    this.CQc = ((FrameLayout)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BPZ);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ympic_certificate_btn_bg)");
    this.CQd = ((ImageView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BPY);
    s.s(paramViewGroup, "root.findViewById(R.id.f…_olympic_certificate_btn)");
    this.CQe = ((TextView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.REf);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ificate_set_status_panel)");
    this.agxk = ((LinearLayout)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BQj);
    s.s(paramViewGroup, "root.findViewById(R.id.f…c_certificate_set_status)");
    this.CQf = ((TextView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.REe);
    s.s(paramViewGroup, "root.findViewById(R.id.f…c_certificate_save_photo)");
    this.agxl = ((TextView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BPU);
    s.s(paramViewGroup, "root.findViewById(R.id.f…live_olympic_cert_bg_pag)");
    this.CQg = ((PAGView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BPT);
    s.s(paramViewGroup, "root.findViewById(R.id.f…_olympic_burn_torch_anim)");
    this.CQh = ((PAGView)paramViewGroup);
    this.CQi = ((ImageView)this.mJe.findViewById(p.e.close_btn));
    this.CQj = ((ImageView)this.mJe.findViewById(p.e.BXZ));
    this.CQl = e.a.CQn;
    this.mainScope = ar.kBZ();
    this.mJe.setOnTouchListener(e..ExternalSyntheticLambda1.INSTANCE);
    this.CPZ.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(360894);
        ViewGroup.LayoutParams localLayoutParams = e.p(this.CQm).getLayoutParams();
        e locale = this.CQm;
        localLayoutParams.width = e.h(locale).getLayoutView().getWidth();
        localLayoutParams.height = e.h(locale).getLayoutView().getHeight();
        AppMethodBeat.o(360894);
        return true;
      }
    });
    this.CQc.setOnClickListener((View.OnClickListener)this);
    this.CQf.setOnClickListener((View.OnClickListener)this);
    this.agxl.setOnClickListener((View.OnClickListener)this);
    this.CQi.setOnClickListener((View.OnClickListener)this);
    this.CQb.setOnClickListener((View.OnClickListener)this);
    this.CQj.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.CPU;
    paramb = this.CQb;
    s.u(paramb, "btn");
    paramViewGroup.CQb = paramb;
    paramb = paramViewGroup.CQb;
    if (paramb != null) {
      paramb.setOnClickListener((View.OnClickListener)paramViewGroup);
    }
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(this.CPZ, b.j.ahpm, p.d.BzE);
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(this.CQd, b.j.ahpf, p.d.Bzz);
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    boolean bool = com.tencent.mm.plugin.finder.live.olympic.util.a.jdp();
    Log.i("OlympicCertificateLayou", s.X("isLowScreenDevice: ", Boolean.valueOf(bool)));
    if (bool) {
      paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    }
    for (int i = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(16);; i = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(64))
    {
      paramViewGroup = this.agxk.getLayoutParams();
      if (paramViewGroup != null) {
        break;
      }
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360950);
      throw paramViewGroup;
      paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    }
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    float f = i;
    paramb = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramb = this.mJe.getContext();
    s.s(paramb, "root.context");
    paramViewGroup.topMargin = ((int)(f * com.tencent.mm.plugin.finder.live.olympic.util.a.gy(paramb)));
    paramViewGroup = ((FrameLayout)this.mJe.findViewById(p.e.BQa)).getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360950);
      throw paramViewGroup;
    }
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    if (bool) {
      paramb = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    }
    for (i = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(20);; i = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(40))
    {
      paramViewGroup.topMargin = i;
      paramViewGroup = ((Button)this.mJe.findViewById(p.e.BQk)).getLayoutParams();
      if (paramViewGroup != null) {
        break;
      }
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360950);
      throw paramViewGroup;
      paramb = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    }
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    if (bool) {
      paramb = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    }
    for (i = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(20);; i = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(40))
    {
      paramViewGroup.topMargin = i;
      enU();
      tO(8);
      AppMethodBeat.o(360950);
      return;
      paramb = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    }
  }
  
  private final void Z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(360983);
    this.CQh.setVisibility(8);
    if (paramBoolean1) {}
    for (Object localObject = this.CPT.getLayoutView();; localObject = this.CPU.getLayoutView())
    {
      fU((View)localObject);
      localObject = this.CQi;
      s.s(localObject, "closeButton");
      s((View)localObject, true);
      localObject = this.CQj;
      s.s(localObject, "moreActionButton");
      s((View)localObject, true);
      s((View)this.CPZ, true);
      if (paramBoolean2)
      {
        s((View)this.CQc, true);
        s((View)this.agxk, true);
      }
      AppMethodBeat.o(360983);
      return;
    }
  }
  
  private static final void a(View paramView1, View paramView2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(371592);
    s.u(paramView1, "$negative");
    s.u(paramView2, "$positive");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramView1 = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(371592);
      throw paramView1;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramView1.setRotationY(f * 180.0F - 180.0F);
    paramView2.setRotationY(f * 180.0F);
    if (f > 0.5F)
    {
      paramView2.setVisibility(8);
      paramView1.setVisibility(0);
    }
    AppMethodBeat.o(371592);
  }
  
  private final void a(b.j paramj, String paramString, int paramInt, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(360975);
    j.a(this.mainScope, null, null, (m)new e.m(paramInt, this, paramString, parama, paramj, null), 3);
    AppMethodBeat.o(360975);
  }
  
  private static final boolean e(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  private final void enS()
  {
    AppMethodBeat.i(360968);
    j.a(this.mainScope, null, null, (m)new l(this, null), 3);
    AppMethodBeat.o(360968);
  }
  
  public static void fU(View paramView)
  {
    AppMethodBeat.i(361004);
    s.u(paramView, "view");
    paramView.setScaleX(0.2F);
    paramView.setScaleY(0.2F);
    paramView.setVisibility(0);
    paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(600L).setInterpolator((TimeInterpolator)new com.tencent.mm.plugin.finder.animate.a(0.9F)).start();
    AppMethodBeat.o(361004);
  }
  
  private static void s(View paramView, boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(360995);
    s.u(paramView, "view");
    ViewPropertyAnimator localViewPropertyAnimator;
    if (paramBoolean)
    {
      f1 = 0.0F;
      paramView.setAlpha(f1);
      paramView.setVisibility(0);
      localViewPropertyAnimator = paramView.animate();
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (float f1 = f2;; f1 = 0.0F)
    {
      localViewPropertyAnimator.alpha(f1).setDuration(300L).setListener((Animator.AnimatorListener)new e.s(paramView, paramBoolean, null)).start();
      AppMethodBeat.o(360995);
      return;
      f1 = 1.0F;
      break;
    }
  }
  
  public final void a(final View paramView1, View paramView2, final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(361184);
    s.u(paramView1, "positive");
    s.u(paramView2, "negative");
    paramView2.setRotationY(-180.0F);
    paramView1.setRotationY(0.0F);
    paramView2.setVisibility(4);
    paramView1.setVisibility(0);
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(2000L);
    localValueAnimator.setInterpolator((TimeInterpolator)new com.tencent.mm.plugin.finder.animate.a(0.4F));
    localValueAnimator.addListener((Animator.AnimatorListener)new t(paramView2, paramView1, this, parama));
    localValueAnimator.addUpdateListener(new e..ExternalSyntheticLambda0(paramView2, paramView1));
    localValueAnimator.start();
    this.CPY.setVisibility(true);
    com.tencent.mm.ae.d.a(300L, (kotlin.g.a.a)new u(this));
    AppMethodBeat.o(361184);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(361199);
    s.u(parama, "showMode");
    switch (e.c.avl[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(361199);
      return;
      this.CQc.setVisibility(0);
      this.agxk.setVisibility(0);
      this.CQj.setVisibility(0);
      this.CQb.setVisibility(8);
      AppMethodBeat.o(361199);
      return;
      this.CQc.setVisibility(4);
      this.agxk.setVisibility(4);
      this.CQj.setVisibility(8);
    }
  }
  
  public final void b(com.tencent.mm.plugin.finder.live.olympic.certificate.data.a parama)
  {
    AppMethodBeat.i(361165);
    this.CQk = parama;
    this.CPU.CPu.t(parama);
    this.CPW.CPu.t(parama);
    this.CPX.CPu.t(parama);
    this.CPV.CPu.t(parama);
    AppMethodBeat.o(361165);
  }
  
  public final void bf(final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(361170);
    this.CQa.setVisibility(8);
    enS();
    com.tencent.mm.ae.d.a(300L, (kotlin.g.a.a)new k(this, parama));
    AppMethodBeat.o(361170);
  }
  
  public final void bg(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(361176);
    this.CQa.setVisibility(8);
    this.CQh.setScaleMode(3);
    a(b.j.ahoU, "star-ignition-animation.pag", 6, (kotlin.g.a.a)new i(parama, this));
    AppMethodBeat.o(361176);
  }
  
  public final void enR()
  {
    AppMethodBeat.i(361159);
    if (this.CPT.getLayoutView().getVisibility() == 0) {}
    for (View localView = this.CPT.getLayoutView();; localView = this.CPU.getLayoutView())
    {
      ImageView localImageView = this.CQi;
      s.s(localImageView, "closeButton");
      s((View)localImageView, false);
      if (this.CQj.getVisibility() == 0)
      {
        localImageView = this.CQj;
        s.s(localImageView, "moreActionButton");
        s((View)localImageView, false);
      }
      if (this.CQc.getVisibility() == 0) {
        s((View)this.CQc, false);
      }
      if (this.agxk.getVisibility() == 0) {
        s((View)this.agxk, false);
      }
      s((View)this.CPZ, false);
      localView.setAlpha(1.0F);
      localView.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setDuration(300L).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).setListener((Animator.AnimatorListener)new d(localView, this)).start();
      AppMethodBeat.o(361159);
      return;
    }
  }
  
  public final void enT()
  {
    AppMethodBeat.i(361192);
    this.CPU.eoa();
    Object localObject1 = this.CQk;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
      if (com.tencent.mm.plugin.finder.live.olympic.util.a.eou())
      {
        localObject2 = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
        if (!com.tencent.mm.plugin.finder.live.olympic.util.a.eot())
        {
          com.tencent.mm.plugin.finder.live.olympic.certificate.b localb = this.CPS;
          localObject2 = ((com.tencent.mm.plugin.finder.live.olympic.certificate.data.a)localObject1).CPj.name;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localb.awL((String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
          com.tencent.mm.plugin.finder.live.olympic.util.a.eov();
        }
      }
    }
    AppMethodBeat.o(361192);
  }
  
  public final void enU()
  {
    AppMethodBeat.i(361206);
    this.CQl = e.a.CQn;
    a(this.CQl);
    this.CPZ.setVisibility(8);
    this.CQb.setVisibility(8);
    this.CQi.setVisibility(8);
    this.CQj.setVisibility(8);
    this.CPT.setVisibility(4);
    this.CPT.enV();
    this.CPU.setVisibility(4);
    this.CQc.setVisibility(4);
    this.agxk.setVisibility(4);
    this.CPU.a(this.CQl);
    this.CPU.reset();
    this.CPY.setVisibility(false);
    this.CQg.stop();
    this.CQg.setVisibility(8);
    this.CPU.eob();
    AppMethodBeat.o(361206);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(361211);
    this.CPX.mount();
    this.CPW.mount();
    this.CPT.mount();
    this.CPU.mount();
    this.CPV.mount();
    AppMethodBeat.o(361211);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361147);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.close_btn;
      if (paramView != null) {
        break label119;
      }
      label53:
      i = p.e.BQa;
      if (paramView != null) {
        break label134;
      }
      label61:
      i = p.e.BQj;
      if (paramView != null) {
        break label218;
      }
      label69:
      i = p.e.BXZ;
      if (paramView != null) {
        break label280;
      }
      label77:
      i = p.e.REe;
      if (paramView != null) {
        break label301;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361147);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label119:
      if (paramView.intValue() != i) {
        break label53;
      }
      enR();
      continue;
      label134:
      if (paramView.intValue() != i) {
        break label61;
      }
      if (s.p(this.CQe.getText(), this.mJe.getResources().getString(p.h.Cpu)))
      {
        paramView = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
        com.tencent.mm.plugin.finder.live.olympic.report.a.qR(true);
        this.CPS.ent();
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
        com.tencent.mm.plugin.finder.live.olympic.report.a.qS(true);
        paramView = this.CQk;
        if (paramView != null)
        {
          this.CPS.a(paramView);
          continue;
          label218:
          if (paramView.intValue() != i) {
            break label69;
          }
          this.CPS.enu();
          paramView = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
          paramView = com.tencent.mm.plugin.finder.live.olympic.report.a.eoh();
          Log.i("OlympicsCertReportUtil", s.X("reportOlympicSetStatus reportMap: ", paramView));
          ((ce)com.tencent.mm.kernel.h.ax(ce.class)).a(q.s.Dvm, (Map)paramView);
          continue;
          label280:
          if (paramView.intValue() != i) {
            break label77;
          }
          this.CPV.CPB.show();
          continue;
          label301:
          if (paramView.intValue() == i)
          {
            paramView = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
            com.tencent.mm.plugin.finder.live.olympic.report.a.a(com.tencent.mm.plugin.finder.live.olympic.report.a.b.CRQ);
            this.CPS.jdo();
          }
        }
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(361153);
    this.mJe.setVisibility(paramInt);
    com.tencent.mm.plugin.finder.live.olympic.certificate.b localb = this.CPS;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localb.qM(bool);
      AppMethodBeat.o(361153);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout$closeOlympicCertificateLayer$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(View paramView, e parame) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(360846);
      this.$view.animate().setListener(null);
      jdField_this.tO(8);
      this.$view.setScaleX(1.0F);
      this.$view.setScaleY(1.0F);
      this.$view.setAlpha(1.0F);
      e.c(jdField_this).setVisibility(8);
      e.c(jdField_this).stop();
      jdField_this.enU();
      jdField_this.CPS.env();
      AppMethodBeat.o(360846);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    public g(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    public h(e parame, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(kotlin.g.a.a<ah> parama, e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    public j(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(e parame, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    l(e parame, kotlin.d.d<? super l> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(360868);
      paramObject = (kotlin.d.d)new l(this.CQm, paramd);
      AppMethodBeat.o(360868);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(360863);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(360863);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new ah.f();
        kotlin.d.f localf = (kotlin.d.f)bg.kCi();
        m localm = (m)new k(paramObject, this.CQm)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(360916);
            paramAnonymousObject = (kotlin.d.d)new 1(this.$pair, this.CQm, paramAnonymousd);
            AppMethodBeat.o(360916);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(360913);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(360913);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            this.$pair.aqH = this.CQm.CPS.awN("room");
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(360913);
            return paramAnonymousObject;
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        if (l.a(localf, localm, locald) == localObject)
        {
          AppMethodBeat.o(360863);
          return localObject;
        }
        break;
      case 1: 
        localObject = (ah.f)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      for (;;)
      {
        if (((r)paramObject.aqH).bsC == null)
        {
          e.k(this.CQm).setVisibility(8);
          paramObject = ah.aiuX;
          AppMethodBeat.o(360863);
          return paramObject;
        }
        e.k(this.CQm).setFile((PAGFile)((r)paramObject.aqH).bsC);
        e.k(this.CQm).setVisibility(0);
        e.k(this.CQm).setRepeatCount(0);
        e.k(this.CQm).setScaleMode(3);
        e.k(this.CQm).play();
        paramObject = ah.aiuX;
        AppMethodBeat.o(360863);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout$openCardWithAnim$1", "Lcom/tencent/mm/plugin/finder/live/olympic/PAGViewListenerAdapter;", "onAnimationEnd", "", "view", "Lorg/libpag/PAGView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    extends p
  {
    n(kotlin.g.a.a<ah> parama) {}
    
    public final void onAnimationEnd(PAGView paramPAGView)
    {
      AppMethodBeat.i(360871);
      this.$block.invoke();
      AppMethodBeat.o(360871);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<ah>
  {
    p(e parame, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class q
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final q CQy;
    
    static
    {
      AppMethodBeat.i(360852);
      CQy = new q();
      AppMethodBeat.o(360852);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class r
    extends u
    implements kotlin.g.a.a<ah>
  {
    public r(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout$startCardAnimation$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class t
    extends AnimatorListenerAdapter
  {
    t(View paramView1, View paramView2, e parame, kotlin.g.a.a<ah> parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(360856);
      this.CQA.setRotationY(0.0F);
      paramView1.setRotationY(0.0F);
      e.m(jdField_this).setVisibility(false);
      e.p(jdField_this).setVisibility(0);
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(360856);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.a<ah>
  {
    u(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e
 * JD-Core Version:    0.7.0.1
 */