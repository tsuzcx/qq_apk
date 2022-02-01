package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandSinglePageModeFooter;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "listener", "Landroid/view/View$OnClickListener;", "doAniToHighlightState", "", "doAniToNormalState", "doCornerRadiusAni", "isHighlightToNormalAni", "", "aniDuration", "", "aniEndCallBack", "Lkotlin/Function0;", "doFlicker", "doSetAppInfo", "isNormalState", "iconUrl", "", "name", "debugTypeDesc", "isGame", "isOriginalGame", "setAppInfoHighlightState", "setAppInfoNormalState", "setJumpBtnOnClickListener", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends RelativeLayout
{
  private static final j<Integer> tyB;
  private static final j<Integer> tyC;
  private static final j<Float> tyD;
  private static final j<Integer> tyE;
  private static final j<Float> tyF;
  public static final a tyz;
  private View.OnClickListener tyA;
  
  static
  {
    AppMethodBeat.i(325285);
    tyz = new a((byte)0);
    tyB = k.cm((kotlin.g.a.a)am.f.tyK);
    tyC = k.cm((kotlin.g.a.a)am.d.tyI);
    tyD = k.cm((kotlin.g.a.a)b.tyG);
    tyE = k.cm((kotlin.g.a.a)am.e.tyJ);
    tyF = k.cm((kotlin.g.a.a)am.c.tyH);
    AppMethodBeat.o(325285);
  }
  
  public am(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(180353);
    LayoutInflater.from(paramContext).inflate(ba.g.app_brand_single_page_mode_footer, (ViewGroup)this);
    AppMethodBeat.o(180353);
  }
  
  private static final void a(GradientDrawable paramGradientDrawable, am paramam, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(325258);
    s.u(paramGradientDrawable, "$bgDrawable");
    s.u(paramam, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramGradientDrawable = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(325258);
      throw paramGradientDrawable;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramGradientDrawable.setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
    ((RelativeLayout)paramam.findViewById(ba.f.singlePageFooterHighlightStateRoot)).setBackground((Drawable)paramGradientDrawable);
    AppMethodBeat.o(325258);
  }
  
  private static final void a(am paramam, View paramView)
  {
    AppMethodBeat.i(325243);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramam);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandSinglePageModeFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramam, "this$0");
    paramam = paramam.tyA;
    if (paramam != null) {
      paramam.onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/page/AppBrandSinglePageModeFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(325243);
  }
  
  private final void a(boolean paramBoolean, long paramLong, final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(325238);
    float f1;
    if (paramBoolean)
    {
      f1 = a.cFH();
      if (!paramBoolean) {
        break label69;
      }
    }
    label69:
    for (float f2 = 0.0F;; f2 = a.cFH())
    {
      localObject = ((RelativeLayout)findViewById(ba.f.singlePageFooterHighlightStateRoot)).getBackground();
      if (localObject != null) {
        break label77;
      }
      parama = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
      AppMethodBeat.o(325238);
      throw parama;
      f1 = 0.0F;
      break;
    }
    label77:
    Object localObject = (GradientDrawable)localObject;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f1, f2 });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    localValueAnimator.addUpdateListener(new am..ExternalSyntheticLambda0((GradientDrawable)localObject, this));
    localValueAnimator.addListener((Animator.AnimatorListener)new i((GradientDrawable)localObject, this, parama));
    localValueAnimator.start();
    AppMethodBeat.o(325238);
  }
  
  private static final void b(am paramam, View paramView)
  {
    AppMethodBeat.i(325248);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramam);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/page/AppBrandSinglePageModeFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramam, "this$0");
    paramam = paramam.tyA;
    if (paramam != null) {
      paramam.onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/page/AppBrandSinglePageModeFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(325248);
  }
  
  private final void cFw()
  {
    AppMethodBeat.i(325228);
    Object localObject = ((LinearLayout)findViewById(ba.f.singlePageFooterNormalStateRoot)).getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(325228);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (a.cFE() - a.cFD() - a.cFG());
    ((LinearLayout)findViewById(ba.f.singlePageFooterNormalStateRoot)).setVisibility(0);
    ((ConstraintLayout)findViewById(ba.f.singlePageFooterHighlightStateRootContentLl)).setVisibility(4);
    localObject = (RelativeLayout)findViewById(ba.f.singlePageFooterHighlightStateRoot);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, a.cFF(), 1.0F, aw.dQ(0.5F), a.cFE());
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setInterpolator((Interpolator)new AccelerateInterpolator());
    ah localah = ah.aiuX;
    ((RelativeLayout)localObject).startAnimation((Animation)localScaleAnimation);
    a(false, 150L, (kotlin.g.a.a)new g(this));
    AppMethodBeat.o(325228);
  }
  
  private final void cFx()
  {
    AppMethodBeat.i(325233);
    Object localObject = ((LinearLayout)findViewById(ba.f.singlePageFooterNormalStateRoot)).getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(325233);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (a.cFE() - a.cFD() - a.cFG());
    ((ConstraintLayout)findViewById(ba.f.singlePageFooterHighlightStateRootContentLl)).setVisibility(8);
    localObject = (RelativeLayout)findViewById(ba.f.singlePageFooterHighlightStateRoot);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, a.cFF(), aw.dQ(0.5F), a.cFE());
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
    ah localah = ah.aiuX;
    ((RelativeLayout)localObject).startAnimation((Animation)localScaleAnimation);
    a(true, 200L, (kotlin.g.a.a)new h(this));
    AppMethodBeat.o(325233);
  }
  
  public final void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(325328);
    int i;
    int j;
    label36:
    Object localObject;
    int k;
    label55:
    label87:
    label110:
    TextView localTextView1;
    label126:
    TextView localTextView2;
    label142:
    ImageView localImageView;
    if ((paramBoolean1) && (((RelativeLayout)findViewById(ba.f.singlePageFooterHighlightStateRoot)).getVisibility() == 0))
    {
      i = 1;
      if (paramBoolean1) {
        break label309;
      }
      j = 1;
      localObject = (LinearLayout)findViewById(ba.f.singlePageFooterNormalStateRoot);
      if (!paramBoolean1) {
        break label315;
      }
      k = 0;
      ((LinearLayout)localObject).setVisibility(k);
      localObject = (RelativeLayout)findViewById(ba.f.singlePageFooterHighlightStateRoot);
      if ((!paramBoolean1) || (i != 0)) {
        break label322;
      }
      k = 8;
      ((RelativeLayout)localObject).setVisibility(k);
      if (!paramBoolean1) {
        break label328;
      }
      localObject = (ImageView)findViewById(ba.f.singlePageFooterNormalStateIconIv);
      if (!paramBoolean1) {
        break label343;
      }
      localTextView1 = (TextView)findViewById(ba.f.singlePageFooterNormalStateNameTv);
      if (!paramBoolean1) {
        break label358;
      }
      localTextView2 = (TextView)findViewById(ba.f.singlePageFooterNormalStateDebugTypeDescTv);
      if (!paramBoolean1) {
        break label373;
      }
      localImageView = (ImageView)findViewById(ba.f.singlePageFooterNormalStateOriginalIv);
      label158:
      com.tencent.mm.modelappbrand.a.b.bEY().a((ImageView)localObject, paramString1, com.tencent.mm.modelappbrand.a.a.bEX(), (b.h)g.org);
      localTextView1.setText((CharSequence)paramString2);
      paramString1 = (CharSequence)paramString3;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label388;
      }
      k = 1;
      label208:
      if (k == 0) {
        break label401;
      }
      localTextView2.setVisibility(8);
      if (!paramBoolean3) {
        break label394;
      }
      k = 0;
      label228:
      localImageView.setVisibility(k);
      label235:
      if (!paramBoolean1) {
        break label435;
      }
      ((TextView)findViewById(ba.f.singlePageFooterNormalStateJumpTitleTv)).setOnClickListener(new am..ExternalSyntheticLambda2(this));
      paramString1 = (TextView)findViewById(ba.f.singlePageFooterNormalStateJumpTitleTv);
      if (!paramBoolean2) {
        break label427;
      }
      k = ba.i.appbrand_single_page_mode_footer_jump_btn_title_game;
      label281:
      paramString1.setText(k);
    }
    for (;;)
    {
      if (j == 0) {
        break label459;
      }
      cFw();
      AppMethodBeat.o(325328);
      return;
      i = 0;
      break;
      label309:
      j = 0;
      break label36;
      label315:
      k = 8;
      break label55;
      label322:
      k = 0;
      break label87;
      label328:
      localObject = (ImageView)findViewById(ba.f.singlePageFooterHighlightStateIconIv);
      break label110;
      label343:
      localTextView1 = (TextView)findViewById(ba.f.singlePageFooterHighlightStateNameTv);
      break label126;
      label358:
      localTextView2 = (TextView)findViewById(ba.f.singlePageFooterHighlightStateDebugTypeDescTv);
      break label142;
      label373:
      localImageView = (ImageView)findViewById(ba.f.singlePageFooterHighlightStateOriginalIv);
      break label158;
      label388:
      k = 0;
      break label208;
      label394:
      k = 8;
      break label228;
      label401:
      localTextView2.setText((CharSequence)paramString3);
      localTextView2.setVisibility(0);
      localImageView.setVisibility(8);
      break label235;
      label427:
      k = ba.i.appbrand_single_page_mode_footer_jump_btn_title;
      break label281;
      label435:
      ((RelativeLayout)findViewById(ba.f.singlePageFooterHighlightStateRoot)).setOnClickListener(new am..ExternalSyntheticLambda1(this));
    }
    label459:
    if (i != 0) {
      cFx();
    }
    AppMethodBeat.o(325328);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(325311);
    s.u(paramString1, "iconUrl");
    s.u(paramString2, "name");
    s.u(paramString3, "debugTypeDesc");
    a(true, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(325311);
  }
  
  public final void setJumpBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(180354);
    s.u(paramOnClickListener, "listener");
    this.tyA = paramOnClickListener;
    AppMethodBeat.o(180354);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandSinglePageModeFooter$Companion;", "", "()V", "normalByHighlightScale", "", "getNormalByHighlightScale", "()F", "normalByHighlightScale$delegate", "Lkotlin/Lazy;", "singlePageFooterHighlightStateCornerRadius", "getSinglePageFooterHighlightStateCornerRadius", "singlePageFooterHighlightStateCornerRadius$delegate", "singlePageFooterHighlightStateRootHeight", "", "getSinglePageFooterHighlightStateRootHeight", "()I", "singlePageFooterHighlightStateRootHeight$delegate", "singlePageFooterNormalStateCornerSize", "getSinglePageFooterNormalStateCornerSize", "singlePageFooterNormalStateCornerSize$delegate", "singlePageFooterNormalStateRootHeight", "getSinglePageFooterNormalStateRootHeight", "singlePageFooterNormalStateRootHeight$delegate", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static int cFD()
    {
      AppMethodBeat.i(324857);
      int i = ((Number)am.cFy().getValue()).intValue();
      AppMethodBeat.o(324857);
      return i;
    }
    
    static int cFE()
    {
      AppMethodBeat.i(324860);
      int i = ((Number)am.cFz().getValue()).intValue();
      AppMethodBeat.o(324860);
      return i;
    }
    
    static float cFF()
    {
      AppMethodBeat.i(324861);
      float f = ((Number)am.cFA().getValue()).floatValue();
      AppMethodBeat.o(324861);
      return f;
    }
    
    static int cFG()
    {
      AppMethodBeat.i(324863);
      int i = ((Number)am.cFB().getValue()).intValue();
      AppMethodBeat.o(324863);
      return i;
    }
    
    static float cFH()
    {
      AppMethodBeat.i(324867);
      float f = ((Number)am.cFC().getValue()).floatValue();
      AppMethodBeat.o(324867);
      return f;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Float>
  {
    public static final b tyG;
    
    static
    {
      AppMethodBeat.i(324856);
      tyG = new b();
      AppMethodBeat.o(324856);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(am paramam)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(am paramam)
    {
      super();
    }
    
    private static final void a(am paramam)
    {
      AppMethodBeat.i(324834);
      s.u(paramam, "this$0");
      ViewGroup.LayoutParams localLayoutParams = ((LinearLayout)paramam.findViewById(ba.f.singlePageFooterNormalStateRoot)).getLayoutParams();
      if (localLayoutParams == null)
      {
        paramam = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(324834);
        throw paramam;
      }
      ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin = 0;
      paramam.requestLayout();
      AppMethodBeat.o(324834);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/page/AppBrandSinglePageModeFooter$doCornerRadiusAni$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends AnimatorListenerAdapter
  {
    i(GradientDrawable paramGradientDrawable, am paramam, kotlin.g.a.a<ah> parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(324838);
      paramAnimator = am.tyz;
      float f = am.a.cFH();
      this.tyM.setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      ((RelativeLayout)jdField_this.findViewById(ba.f.singlePageFooterHighlightStateRoot)).setBackground((Drawable)this.tyM);
      parama.invoke();
      AppMethodBeat.o(324838);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/page/AppBrandSinglePageModeFooter$doFlicker$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements Animation.AnimationListener
  {
    public j(am paramam) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(324839);
      this.tyL.findViewById(ba.f.singlePageFooterHighlightStateRootHighlightMask).setVisibility(8);
      AppMethodBeat.o(324839);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am
 * JD-Core Version:    0.7.0.1
 */