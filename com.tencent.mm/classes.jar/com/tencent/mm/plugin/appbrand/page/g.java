package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragmentActivity.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView;", "Lme/imid/swipebacklayout/lib/SwipeBackLayout;", "Landroid/content/DialogInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "appearAnimation", "Landroid/view/animation/Animation;", "dismissAnimation", "drawStatusBarLayout", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "iconImageView", "Landroid/widget/ImageView;", "negativeButton", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeButton", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeButton", "(Landroid/content/DialogInterface$OnClickListener;)V", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "positiveButton", "getPositiveButton", "setPositiveButton", "cancel", "", "cleanup", "dismiss", "dismissWithoutAnimation", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "resetStyle", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "show", "endAction", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
public final class g
  extends SwipeBackLayout
  implements DialogInterface
{
  private com.tencent.mm.ui.statusbar.b ivA;
  com.tencent.mm.plugin.appbrand.widget.actionbar.b ivB;
  ImageView ivC;
  private DialogInterface.OnClickListener ivv;
  private DialogInterface.OnClickListener ivw;
  private Animation ivx;
  Animation ivy;
  r ivz;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(134774);
    bi.cv((View)this);
    a((SwipeBackLayout.a)new g.1(this));
    Object localObject1 = new com.tencent.mm.ui.statusbar.b(paramContext);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setClickable(true);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setBackgroundColor(-1);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setWillNotDraw(false);
    ((com.tencent.mm.ui.statusbar.b)localObject1).rq(false);
    ((com.tencent.mm.ui.statusbar.b)localObject1).K(0, true);
    this.ivA = ((com.tencent.mm.ui.statusbar.b)localObject1);
    addView((View)this.ivA, new ViewGroup.LayoutParams(-1, -1));
    setContentView((View)this.ivA);
    localObject1 = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(paramContext);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setFullscreenMode(false);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setBackButtonClickListener((View.OnClickListener)new g.a(this, paramContext));
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setCloseButtonClickListener((View.OnClickListener)new g.b(this, paramContext));
    Object localObject2 = this.ivA;
    if (localObject2 == null) {
      j.ebi();
    }
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.di(paramContext)));
    this.ivB = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1);
    localObject1 = LayoutInflater.from(paramContext).inflate(2130968698, (ViewGroup)this.ivA, false);
    ((TextView)((View)localObject1).findViewById(2131821130)).setText(2131296735);
    ((TextView)((View)localObject1).findViewById(2131821200)).setText(2131296734);
    localObject2 = this.ivA;
    if (localObject2 == null) {
      j.ebi();
    }
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1);
    j.p(localObject1, "this");
    localObject2 = ((View)localObject1).getLayoutParams();
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    if (localObject1 != null) {
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.plugin.appbrand.widget.b.di(paramContext);
    }
    this.ivC = ((ImageView)findViewById(2131821129));
    findViewById(2131821200).setOnClickListener((View.OnClickListener)new g.2(this));
    AppMethodBeat.o(134774);
  }
  
  public final void aIM()
  {
    AppMethodBeat.i(134769);
    setVisibility(8);
    cleanup();
    AppMethodBeat.o(134769);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(134770);
    dismiss();
    DialogInterface.OnClickListener localOnClickListener = this.ivw;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick((DialogInterface)this, -2);
      AppMethodBeat.o(134770);
      return;
    }
    AppMethodBeat.o(134770);
  }
  
  public final void cleanup()
  {
    Object localObject1 = null;
    AppMethodBeat.i(134767);
    Object localObject2 = getAnimation();
    if (localObject2 != null) {
      ((Animation)localObject2).cancel();
    }
    localObject2 = getAnimation();
    if (localObject2 != null) {
      ((Animation)localObject2).setAnimationListener(null);
    }
    localObject2 = getParent();
    if (!(localObject2 instanceof ViewGroup)) {}
    for (;;)
    {
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 != null)
      {
        ((ViewGroup)localObject1).removeView((View)this);
        AppMethodBeat.o(134767);
        return;
      }
      AppMethodBeat.o(134767);
      return;
      localObject1 = localObject2;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(134768);
    Animation localAnimation = this.ivx;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    this.ivx = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.zca);
    localAnimation = this.ivx;
    if (localAnimation == null) {
      j.ebi();
    }
    localAnimation.setAnimationListener((Animation.AnimationListener)new g.c(this));
    localAnimation = this.ivx;
    if (localAnimation == null) {
      j.ebi();
    }
    startAnimation(localAnimation);
    AppMethodBeat.o(134768);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(134773);
    if ((this.ivx != null) || (this.ivy != null))
    {
      AppMethodBeat.o(134773);
      return true;
    }
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      f.av(getContext());
      dismiss();
      AppMethodBeat.o(134773);
      return true;
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(134773);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(134772);
    if ((this.ivx != null) || (this.ivy != null))
    {
      AppMethodBeat.o(134772);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(134772);
    return bool;
  }
  
  public final DialogInterface.OnClickListener getNegativeButton()
  {
    return this.ivw;
  }
  
  public final DialogInterface.OnClickListener getPositiveButton()
  {
    return this.ivv;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(134771);
    super.onDetachedFromWindow();
    this.ivv = null;
    this.ivw = null;
    this.ivx = null;
    this.ivy = null;
    this.ivz = null;
    AppMethodBeat.o(134771);
  }
  
  public final void setNegativeButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.ivw = paramOnClickListener;
  }
  
  public final void setPositiveButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.ivv = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g
 * JD-Core Version:    0.7.0.1
 */