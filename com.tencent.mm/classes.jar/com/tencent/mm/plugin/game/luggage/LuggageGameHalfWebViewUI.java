package com.tencent.mm.plugin.game.luggage;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.luggage.g.c;
import com.tencent.mm.plugin.game.luggage.g.d;
import com.tencent.mm.plugin.game.luggage.g.e;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI;", "Lcom/tencent/mm/plugin/game/luggage/LuggageGameWebViewUI;", "()V", "MAX_HEIGHT", "", "getMAX_HEIGHT", "()D", "MAX_HEIGHT$delegate", "Lkotlin/Lazy;", "pageHeight", "", "preloadWebCore", "Lcom/tencent/luggage/container/LuggageWebCore;", "rawUrl", "", "createPage", "Lcom/tencent/mm/plugin/game/luggage/page/GameWebPage;", "params", "Landroid/os/Bundle;", "url", "getLayoutId", "onCreate", "", "savedInstanceState", "onDestroy", "setRootView", "view", "Landroid/view/View;", "Companion", "luggage-game_release"})
public final class LuggageGameHalfWebViewUI
  extends LuggageGameWebViewUI
{
  private static final String TAG = "MicroMsg.LuggageGameHalfWebViewUI";
  public static final a xwb;
  private HashMap _$_findViewCache;
  private String edo;
  private int loF;
  private final f xwa;
  
  static
  {
    AppMethodBeat.i(187033);
    xwb = new a((byte)0);
    TAG = "MicroMsg.LuggageGameHalfWebViewUI";
    AppMethodBeat.o(187033);
  }
  
  public LuggageGameHalfWebViewUI()
  {
    AppMethodBeat.i(187032);
    this.xwa = g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(187032);
  }
  
  private final double dTk()
  {
    AppMethodBeat.i(187028);
    double d = ((Number)this.xwa.getValue()).doubleValue();
    AppMethodBeat.o(187028);
    return d;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(187035);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(187035);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(187034);
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
    AppMethodBeat.o(187034);
    return localView1;
  }
  
  protected final void dTl() {}
  
  protected final i g(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(187031);
    kotlin.g.b.p.h(paramBundle, "params");
    kotlin.g.b.p.h(paramString, "url");
    com.tencent.luggage.d.p localp = h.aI((Context)this, paramString);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("createPage, wc : ");
    boolean bool;
    if (localp != null)
    {
      bool = true;
      Log.i((String)localObject, bool);
      this.edo = paramString;
      if (localp == null) {
        break label218;
      }
      paramString = localp.LG();
      if (paramString == null) {
        kotlin.g.b.p.hyc();
      }
      if (!((com.tencent.mm.plugin.game.luggage.g.h)paramString).dTL()) {
        break label218;
      }
      localObject = (com.tencent.mm.plugin.game.luggage.g.h)localp.LG();
      if (localObject == null) {
        break label157;
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
          AppMethodBeat.o(187031);
          throw paramBundle;
          bool = false;
          break;
          label157:
          paramString = null;
          continue;
        }
        ((ViewGroup)paramString).removeView((View)localObject);
      }
    }
    paramString = this.xwg;
    kotlin.g.b.p.g(paramString, "mContainer");
    paramString = paramString.Lm();
    kotlin.g.b.p.g(paramString, "mContainer.ctrl");
    paramBundle = (i)new c(paramString, localp, paramBundle);
    AppMethodBeat.o(187031);
    return paramBundle;
    label218:
    paramString = this.xwg;
    kotlin.g.b.p.g(paramString, "mContainer");
    paramString = paramString.Lm();
    kotlin.g.b.p.g(paramString, "mContainer.ctrl");
    paramBundle = (i)new d(paramString, paramBundle);
    AppMethodBeat.o(187031);
    return paramBundle;
  }
  
  public final int getLayoutId()
  {
    return 2131494880;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187029);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772059, 2130772060);
    this.loF = getIntent().getIntExtra("KHalfScreenHeight", (int)dTk());
    this.loF = at.fromDPToPix((Context)this, this.loF);
    if (this.loF > dTk()) {
      this.loF = ((int)dTk());
    }
    if (ao.isDarkMode()) {
      _$_findCachedViewById(2131309368).setBackgroundResource(2131100587);
    }
    _$_findCachedViewById(2131309368).setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = this.xwg;
    kotlin.g.b.p.g(paramBundle, "mContainer");
    paramBundle = paramBundle.getContentView();
    kotlin.g.b.p.g(paramBundle, "mContainer.contentView");
    paramBundle.setAnimation(AnimationUtils.loadAnimation((Context)this, 2130772076));
    paramBundle = (GameRoundContainerView)_$_findCachedViewById(2131310628);
    e locale = this.xwg;
    kotlin.g.b.p.g(locale, "mContainer");
    paramBundle.addView(locale.getContentView(), new ViewGroup.LayoutParams(-1, this.loF));
    AppMethodBeat.o(187029);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(187030);
    super.onDestroy();
    AppMethodBeat.o(187030);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$Companion;", "", "()V", "TAG", "", "luggage-game_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Double>
  {
    b(LuggageGameHalfWebViewUI paramLuggageGameHalfWebViewUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LuggageGameHalfWebViewUI paramLuggageGameHalfWebViewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(187027);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.xwc.xwg;
      kotlin.g.b.p.g(paramView, "mContainer");
      paramView = paramView.getContentView();
      localObject = this.xwc.xwg;
      kotlin.g.b.p.g(localObject, "mContainer");
      localObject = ((e)localObject).getContentView();
      kotlin.g.b.p.g(localObject, "mContainer.contentView");
      float f = ((View)localObject).getTranslationY();
      localObject = this.xwc.xwg;
      kotlin.g.b.p.g(localObject, "mContainer");
      localObject = ((e)localObject).getContentView();
      kotlin.g.b.p.g(localObject, "mContainer.contentView");
      paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { f, ((View)localObject).getTranslationY() + LuggageGameHalfWebViewUI.a(this.xwc) }).setDuration(200L);
      paramView.addListener((Animator.AnimatorListener)new a());
      kotlin.g.b.p.g(paramView, "ObjectAnimator.ofFloat(m…         })\n            }");
      paramView.start();
      this.xwc.finish();
      this.xwc.overridePendingTransition(2130772059, 2130772060);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(187027);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1$animator$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "luggage-game_release"})
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