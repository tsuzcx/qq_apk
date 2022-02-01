package com.tencent.mm.plugin.game.luggage;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.luggage.g.c;
import com.tencent.mm.plugin.game.luggage.g.d;
import com.tencent.mm.plugin.game.luggage.g.e;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI;", "Lcom/tencent/mm/plugin/game/luggage/LuggageGameWebViewUI;", "()V", "MAX_HEIGHT", "", "getMAX_HEIGHT", "()D", "MAX_HEIGHT$delegate", "Lkotlin/Lazy;", "isAbsoluteHeight", "", "pageHeight", "", "preloadWebCore", "Lcom/tencent/luggage/container/LuggageWebCore;", "rawUrl", "", "createPage", "Lcom/tencent/mm/plugin/game/luggage/page/GameWebPage;", "params", "Landroid/os/Bundle;", "url", "getLayoutId", "onCreate", "", "savedInstanceState", "onDestroy", "setBgTransparent", "rootView", "Landroid/view/ViewGroup;", "setRootView", "view", "Landroid/view/View;", "setTranslucentStatus", "Companion", "luggage-game_release"})
public final class LuggageGameHalfWebViewUI
  extends LuggageGameWebViewUI
{
  public static final a CzW;
  private static final String TAG = "MicroMsg.LuggageGameHalfWebViewUI";
  private final f CzU;
  private boolean CzV;
  private HashMap _$_findViewCache;
  private String fXu;
  private int ojp;
  
  static
  {
    AppMethodBeat.i(232021);
    CzW = new a((byte)0);
    TAG = "MicroMsg.LuggageGameHalfWebViewUI";
    AppMethodBeat.o(232021);
  }
  
  public LuggageGameHalfWebViewUI()
  {
    AppMethodBeat.i(232020);
    this.CzU = g.ar((kotlin.g.a.a)new b(this));
    this.CzV = true;
    AppMethodBeat.o(232020);
  }
  
  private final void B(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(232019);
    Log.d(TAG, "start rootView:".concat(String.valueOf(paramViewGroup)));
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        localView.setBackgroundResource(0);
        B((ViewGroup)localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((kotlin.g.b.p.h(localView, _$_findCachedViewById(j.c.touch_outside)) ^ true))
        {
          Log.d(TAG, "start childView:".concat(String.valueOf(localView)));
          localView.setBackgroundColor(0);
        }
      }
    }
    AppMethodBeat.o(232019);
  }
  
  private final double ewt()
  {
    AppMethodBeat.i(232014);
    double d = ((Number)this.CzU.getValue()).doubleValue();
    AppMethodBeat.o(232014);
    return d;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(232026);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(232026);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(232024);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(232024);
    return localView1;
  }
  
  protected final void ewu() {}
  
  protected final i g(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(232018);
    kotlin.g.b.p.k(paramBundle, "params");
    kotlin.g.b.p.k(paramString, "url");
    com.tencent.luggage.d.p localp = h.aR((Context)this, paramString);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("createPage, wc : ");
    boolean bool;
    if (localp != null)
    {
      bool = true;
      Log.i((String)localObject, bool);
      this.fXu = paramString;
      if (localp == null) {
        break label221;
      }
      paramString = localp.Ow();
      if (paramString == null) {
        kotlin.g.b.p.iCn();
      }
      if (!((com.tencent.mm.plugin.game.luggage.g.h)paramString).ewT()) {
        break label221;
      }
      localObject = (com.tencent.mm.plugin.game.luggage.g.h)localp.Ow();
      if (localObject == null) {
        break label158;
      }
      paramString = ((com.tencent.mm.plugin.game.luggage.g.h)localObject).getParent();
    }
    for (;;)
    {
      if ((paramString instanceof ViewGroup))
      {
        paramString = ((com.tencent.mm.plugin.game.luggage.g.h)localObject).getParent();
        if (paramString == null)
        {
          paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(232018);
          throw paramBundle;
          bool = false;
          break;
          label158:
          paramString = null;
          continue;
        }
        ((ViewGroup)paramString).removeView((View)localObject);
      }
    }
    paramString = this.CAb;
    kotlin.g.b.p.j(paramString, "mContainer");
    paramString = paramString.Oc();
    kotlin.g.b.p.j(paramString, "mContainer.ctrl");
    paramBundle = (i)new c(paramString, localp, paramBundle);
    AppMethodBeat.o(232018);
    return paramBundle;
    label221:
    paramString = this.CAb;
    kotlin.g.b.p.j(paramString, "mContainer");
    paramString = paramString.Oc();
    kotlin.g.b.p.j(paramString, "mContainer.ctrl");
    paramBundle = (i)new d(paramString, paramBundle);
    AppMethodBeat.o(232018);
    return paramBundle;
  }
  
  public final int getLayoutId()
  {
    return j.d.CAC;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232015);
    super.onCreate(paramBundle);
    overridePendingTransition(j.a.fast_faded_in, j.a.fast_faded_out);
    float f = getIntent().getFloatExtra("KHalfScreenHeightPercent", -1.0F);
    if ((f > 0.0F) && (f <= 1.0F))
    {
      this.ojp = ((int)(f * ewt()));
      this.CzV = false;
      if (this.ojp > ewt()) {
        this.ojp = ((int)ewt());
      }
      if (ar.isDarkMode()) {
        _$_findCachedViewById(j.c.touch_outside).setBackgroundResource(j.b.CAu);
      }
      _$_findCachedViewById(j.c.touch_outside).setOnClickListener((View.OnClickListener)new c(this));
      paramBundle = this.CAb;
      kotlin.g.b.p.j(paramBundle, "mContainer");
      paramBundle = paramBundle.getContentView();
      kotlin.g.b.p.j(paramBundle, "mContainer.contentView");
      paramBundle.setAnimation(AnimationUtils.loadAnimation((Context)this, j.a.in_from_bottom));
      paramBundle = (GameRoundContainerView)_$_findCachedViewById(j.c.CAA);
      e locale = this.CAb;
      kotlin.g.b.p.j(locale, "mContainer");
      paramBundle.addView(locale.getContentView(), new ViewGroup.LayoutParams(-1, this.ojp));
      if (this.CzV) {}
    }
    for (;;)
    {
      try
      {
        if (getWindow() != null)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label421;
          }
          paramBundle = getWindow();
          if (paramBundle == null) {
            kotlin.g.b.p.iCn();
          }
          paramBundle = paramBundle.getDecorView();
          kotlin.g.b.p.j(paramBundle, "window!!.decorView");
          paramBundle.setSystemUiVisibility(1280);
          paramBundle = getWindow();
          if (paramBundle == null) {
            kotlin.g.b.p.iCn();
          }
          paramBundle.addFlags(-2147483648);
          paramBundle = getWindow();
          if (paramBundle == null) {
            kotlin.g.b.p.iCn();
          }
          paramBundle.setStatusBarColor(0);
          paramBundle = getWindow();
          if (paramBundle == null) {
            kotlin.g.b.p.iCn();
          }
          paramBundle.setFlags(134217728, 134217728);
        }
        if (getWindow() != null)
        {
          paramBundle = getWindow();
          kotlin.g.b.p.j(paramBundle, "window");
          paramBundle = paramBundle.getDecorView().findViewById(16908290);
          if (paramBundle != null) {
            break label443;
          }
          paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(232015);
          throw paramBundle;
        }
      }
      catch (Exception paramBundle) {}
      AppMethodBeat.o(232015);
      return;
      this.ojp = getIntent().getIntExtra("KHalfScreenHeight", (int)ewt());
      this.ojp = aw.fromDPToPix((Context)this, this.ojp);
      this.CzV = true;
      break;
      label421:
      paramBundle = getWindow();
      if (paramBundle == null) {
        kotlin.g.b.p.iCn();
      }
      paramBundle.addFlags(67108864);
    }
    label443:
    paramBundle = ((ViewGroup)paramBundle).getChildAt(0);
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(232015);
      throw paramBundle;
    }
    B((ViewGroup)paramBundle);
    AppMethodBeat.o(232015);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232017);
    super.onDestroy();
    AppMethodBeat.o(232017);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$Companion;", "", "()V", "TAG", "", "luggage-game_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Double>
  {
    b(LuggageGameHalfWebViewUI paramLuggageGameHalfWebViewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LuggageGameHalfWebViewUI paramLuggageGameHalfWebViewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231510);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.CzX.CAb;
      kotlin.g.b.p.j(paramView, "mContainer");
      paramView = paramView.getContentView();
      localObject = this.CzX.CAb;
      kotlin.g.b.p.j(localObject, "mContainer");
      localObject = ((e)localObject).getContentView();
      kotlin.g.b.p.j(localObject, "mContainer.contentView");
      float f = ((View)localObject).getTranslationY();
      localObject = this.CzX.CAb;
      kotlin.g.b.p.j(localObject, "mContainer");
      localObject = ((e)localObject).getContentView();
      kotlin.g.b.p.j(localObject, "mContainer.contentView");
      paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { f, ((View)localObject).getTranslationY() + LuggageGameHalfWebViewUI.a(this.CzX) }).setDuration(200L);
      paramView.addListener((Animator.AnimatorListener)new a());
      kotlin.g.b.p.j(paramView, "ObjectAnimator.ofFloat(m…         })\n            }");
      paramView.start();
      this.CzX.finish();
      this.CzX.overridePendingTransition(j.a.fast_faded_in, j.a.fast_faded_out);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(231510);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1$animator$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "luggage-game_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameHalfWebViewUI
 * JD-Core Version:    0.7.0.1
 */