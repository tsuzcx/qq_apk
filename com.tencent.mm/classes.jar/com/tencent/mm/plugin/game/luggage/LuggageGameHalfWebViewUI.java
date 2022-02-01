package com.tencent.mm.plugin.game.luggage;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationUtils;
import com.tencent.luggage.d.i;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.game.luggage.page.c;
import com.tencent.mm.plugin.game.luggage.page.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI;", "Lcom/tencent/mm/plugin/game/luggage/LuggageGameWebViewUI;", "()V", "MAX_HEIGHT", "", "getMAX_HEIGHT", "()D", "MAX_HEIGHT$delegate", "Lkotlin/Lazy;", "isAbsoluteHeight", "", "pageHeight", "", "preloadWebCore", "Lcom/tencent/luggage/container/LuggageWebCore;", "rawUrl", "", "createPage", "Lcom/tencent/mm/plugin/game/luggage/page/GameWebPage;", "params", "Landroid/os/Bundle;", "url", "getLayoutId", "onCreate", "", "savedInstanceState", "onDestroy", "setBgTransparent", "rootView", "Landroid/view/ViewGroup;", "setRootView", "view", "Landroid/view/View;", "setTranslucentStatus", "Companion", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuggageGameHalfWebViewUI
  extends LuggageGameWebViewUI
{
  public static final a ItF;
  private static final String TAG;
  private final j ItG;
  private boolean ItH;
  private String idu;
  private int rmR;
  
  static
  {
    AppMethodBeat.i(276950);
    ItF = new a((byte)0);
    TAG = "MicroMsg.LuggageGameHalfWebViewUI";
    AppMethodBeat.o(276950);
  }
  
  public LuggageGameHalfWebViewUI()
  {
    AppMethodBeat.i(276938);
    this.ItG = k.cm((kotlin.g.a.a)new b(this));
    this.ItH = true;
    AppMethodBeat.o(276938);
  }
  
  private final void L(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(276943);
    Log.d(TAG, s.X("start rootView:", paramViewGroup));
    int k = paramViewGroup.getChildCount();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        localView.setBackgroundResource(0);
        L((ViewGroup)localView);
      }
      while (j >= k)
      {
        AppMethodBeat.o(276943);
        return;
        if (!s.p(localView, findViewById(j.c.touch_outside)))
        {
          Log.d(TAG, s.X("start childView:", localView));
          localView.setBackgroundColor(0);
        }
      }
    }
  }
  
  private static final void a(LuggageGameHalfWebViewUI paramLuggageGameHalfWebViewUI, View paramView)
  {
    AppMethodBeat.i(276948);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramLuggageGameHalfWebViewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLuggageGameHalfWebViewUI, "this$0");
    paramView = ObjectAnimator.ofFloat(paramLuggageGameHalfWebViewUI.ItM.ejj, "translationY", new float[] { paramLuggageGameHalfWebViewUI.ItM.ejj.getTranslationY(), paramLuggageGameHalfWebViewUI.ItM.ejj.getTranslationY() + paramLuggageGameHalfWebViewUI.rmR }).setDuration(200L);
    paramView.addListener((Animator.AnimatorListener)new c());
    s.s(paramView, "ofFloat(mContainer.conte…         })\n            }");
    paramView.start();
    paramLuggageGameHalfWebViewUI.finish();
    paramLuggageGameHalfWebViewUI.overridePendingTransition(j.a.fast_faded_in, j.a.fast_faded_out);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(276948);
  }
  
  private final double fEn()
  {
    AppMethodBeat.i(276939);
    double d = ((Number)this.ItG.getValue()).doubleValue();
    AppMethodBeat.o(276939);
    return d;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  protected final void fEo() {}
  
  protected final GameWebPage g(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(276981);
    s.u(paramBundle, "params");
    s.u(paramString, "url");
    p localp = h.aT((Context)this, paramString);
    Object localObject = TAG;
    boolean bool;
    if (localp != null)
    {
      bool = true;
      Log.i((String)localObject, s.X("createPage, wc : ", Boolean.valueOf(bool)));
      this.idu = paramString;
      if (localp == null) {
        break label184;
      }
      localObject = (com.tencent.mm.plugin.game.luggage.page.h)localp.aoE();
      if (localObject != null) {
        break label125;
      }
      paramString = null;
    }
    for (;;)
    {
      if ((paramString instanceof ViewGroup))
      {
        paramString = ((com.tencent.mm.plugin.game.luggage.page.h)localObject).getParent();
        if (paramString == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(276981);
          throw paramBundle;
          bool = false;
          break;
          label125:
          paramString = ((com.tencent.mm.plugin.game.luggage.page.h)localObject).getParent();
          continue;
        }
        ((ViewGroup)paramString).removeView((View)localObject);
      }
    }
    paramString = this.ItM.ejq;
    s.s(paramString, "mContainer.ctrl");
    paramBundle = (GameWebPage)new c(paramString, localp, paramBundle);
    AppMethodBeat.o(276981);
    return paramBundle;
    label184:
    paramString = this.ItM.ejq;
    s.s(paramString, "mContainer.ctrl");
    paramBundle = (GameWebPage)new d(paramString, paramBundle);
    AppMethodBeat.o(276981);
    return paramBundle;
  }
  
  public final int getLayoutId()
  {
    return j.d.Iun;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(276964);
    super.onCreate(paramBundle);
    overridePendingTransition(j.a.fast_faded_in, j.a.fast_faded_out);
    float f = getIntent().getFloatExtra("KHalfScreenHeightPercent", -1.0F);
    if ((f > 0.0F) && (f <= 1.0F))
    {
      this.rmR = ((int)(f * fEn()));
      this.ItH = false;
      if (this.rmR > fEn()) {
        this.rmR = ((int)fEn());
      }
      if (aw.isDarkMode()) {
        findViewById(j.c.touch_outside).setBackgroundResource(j.b.Iuf);
      }
      findViewById(j.c.touch_outside).setOnClickListener(new LuggageGameHalfWebViewUI..ExternalSyntheticLambda0(this));
      this.ItM.ejj.setAnimation(AnimationUtils.loadAnimation((Context)this, j.a.in_from_bottom));
      ((GameRoundContainerView)findViewById(j.c.Iul)).addView(this.ItM.ejj, new ViewGroup.LayoutParams(-1, this.rmR));
      if (this.ItH) {}
    }
    for (;;)
    {
      try
      {
        if (getWindow() != null)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label359;
          }
          paramBundle = getWindow();
          s.checkNotNull(paramBundle);
          paramBundle.getDecorView().setSystemUiVisibility(1280);
          paramBundle = getWindow();
          s.checkNotNull(paramBundle);
          paramBundle.addFlags(-2147483648);
          paramBundle = getWindow();
          s.checkNotNull(paramBundle);
          paramBundle.setStatusBarColor(0);
          paramBundle = getWindow();
          s.checkNotNull(paramBundle);
          paramBundle.setFlags(134217728, 134217728);
        }
        if (getWindow() != null)
        {
          paramBundle = getWindow().getDecorView().findViewById(16908290);
          if (paramBundle != null) {
            break label378;
          }
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(276964);
          throw paramBundle;
        }
      }
      catch (Exception paramBundle) {}
      AppMethodBeat.o(276964);
      return;
      this.rmR = getIntent().getIntExtra("KHalfScreenHeight", (int)fEn());
      this.rmR = bd.fromDPToPix((Context)this, this.rmR);
      this.ItH = true;
      break;
      label359:
      paramBundle = getWindow();
      s.checkNotNull(paramBundle);
      paramBundle.addFlags(67108864);
    }
    label378:
    paramBundle = ((ViewGroup)paramBundle).getChildAt(0);
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(276964);
      throw paramBundle;
    }
    L((ViewGroup)paramBundle);
    AppMethodBeat.o(276964);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(276969);
    super.onDestroy();
    AppMethodBeat.o(276969);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$Companion;", "", "()V", "TAG", "", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Double>
  {
    b(LuggageGameHalfWebViewUI paramLuggageGameHalfWebViewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1$animator$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameHalfWebViewUI
 * JD-Core Version:    0.7.0.1
 */