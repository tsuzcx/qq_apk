package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.ui.MMFragmentActivity;

public class AppBrandDesktopHalfContainer
  extends HeaderContainer
  implements View.OnTouchListener, c.a
{
  private View GG;
  private GyroView naA;
  private c naY;
  private Rect nbc;
  private AppBrandDesktopHalfView nev;
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49724);
    this.nbc = new Rect();
    init(paramContext);
    AppMethodBeat.o(49724);
  }
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49725);
    this.nbc = new Rect();
    init(paramContext);
    AppMethodBeat.o(49725);
  }
  
  private void eg(Context paramContext)
  {
    AppMethodBeat.i(49728);
    this.naA = new GyroView(paramContext);
    paramContext = new FrameLayout.LayoutParams((int)getResources().getDimension(2131166414), (int)getResources().getDimension(2131166413));
    paramContext.gravity = 81;
    this.naA.setId(2131300673);
    this.naA.setVisibility(8);
    addView(this.naA, paramContext);
    AppMethodBeat.o(49728);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49727);
    this.nev = new AppBrandDesktopHalfView(paramContext);
    this.nev.setId(2131296711);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    this.nev.setLayoutParams(localLayoutParams);
    this.GG = this.nev.findViewById(2131296698);
    addView(this.nev);
    eg(paramContext);
    AppMethodBeat.o(49727);
  }
  
  public final void bDF() {}
  
  public final void bDR() {}
  
  public final void bDS() {}
  
  public final boolean bDs()
  {
    return false;
  }
  
  public final void g(View paramView1, View paramView2) {}
  
  public int getAnimationScrollOffset()
  {
    return 0;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.nbc;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    return null;
  }
  
  public View getBackgroundGradientView()
  {
    return null;
  }
  
  public View getEmptyView()
  {
    return this.GG;
  }
  
  public int getExtraBottomHeight()
  {
    return 0;
  }
  
  public GyroView getGyroView()
  {
    return this.naA;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return this.nev;
  }
  
  public View getMaskView()
  {
    return null;
  }
  
  public final boolean isFullScreen()
  {
    if (this.nev != null) {}
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49726);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49726);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(49733);
    super.onPause();
    if (this.nev != null) {
      this.nev.dus = true;
    }
    AppMethodBeat.o(49733);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49732);
    super.onResume();
    if (this.nev != null)
    {
      AppBrandDesktopHalfView localAppBrandDesktopHalfView = this.nev;
      localAppBrandDesktopHalfView.dus = false;
      localAppBrandDesktopHalfView.setLayoutFrozen(false);
      localAppBrandDesktopHalfView.postDelayed(new AppBrandDesktopHalfView.14(localAppBrandDesktopHalfView), 10L);
    }
    AppMethodBeat.o(49732);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(223182);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfContainer", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfContainer", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(223182);
    return false;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity) {}
  
  public void setAnimController(c paramc)
  {
    AppMethodBeat.i(49729);
    this.naY = paramc;
    if (this.naY != null) {
      this.naY.a(this);
    }
    AppMethodBeat.o(49729);
  }
  
  public void setDynamicBackgroundView(View paramView) {}
  
  public void setExtraBottomHeight(int paramInt) {}
  
  public void setFixedHeight(boolean paramBoolean) {}
  
  public final void wh(int paramInt)
  {
    AppMethodBeat.i(49730);
    if (this.nev != null) {
      this.nev.wh(paramInt);
    }
    AppMethodBeat.o(49730);
  }
  
  public final void wi(int paramInt)
  {
    AppMethodBeat.i(49731);
    wh(paramInt);
    AppMethodBeat.o(49731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfContainer
 * JD-Core Version:    0.7.0.1
 */