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
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.c;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.ui.MMFragmentActivity;

public class AppBrandDesktopHalfContainer
  extends HeaderContainer
  implements View.OnTouchListener, c.a
{
  private View DR;
  private GyroView lSL;
  private c lTj;
  private Rect lTn;
  private AppBrandDesktopHalfView lWD;
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49724);
    this.lTn = new Rect();
    init(paramContext);
    AppMethodBeat.o(49724);
  }
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49725);
    this.lTn = new Rect();
    init(paramContext);
    AppMethodBeat.o(49725);
  }
  
  private void dU(Context paramContext)
  {
    AppMethodBeat.i(49728);
    this.lSL = new GyroView(paramContext);
    paramContext = new FrameLayout.LayoutParams((int)getResources().getDimension(2131166414), (int)getResources().getDimension(2131166413));
    paramContext.gravity = 81;
    this.lSL.setId(2131300673);
    this.lSL.setVisibility(8);
    addView(this.lSL, paramContext);
    AppMethodBeat.o(49728);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49727);
    this.lWD = new AppBrandDesktopHalfView(paramContext);
    this.lWD.setId(2131296711);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    this.lWD.setLayoutParams(localLayoutParams);
    this.DR = this.lWD.findViewById(2131296698);
    addView(this.lWD);
    dU(paramContext);
    AppMethodBeat.o(49727);
  }
  
  public final void brI() {}
  
  public final void brW() {}
  
  public final void brX() {}
  
  public final boolean brv()
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
    return this.lTn;
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
    return this.DR;
  }
  
  public int getExtraBottomHeight()
  {
    return 0;
  }
  
  public GyroView getGyroView()
  {
    return this.lSL;
  }
  
  public a getHeaderView()
  {
    return this.lWD;
  }
  
  public View getMaskView()
  {
    return null;
  }
  
  public final boolean isFullScreen()
  {
    if (this.lWD != null) {}
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
    if (this.lWD != null) {
      this.lWD.dkt = true;
    }
    AppMethodBeat.o(49733);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49732);
    super.onResume();
    if (this.lWD != null)
    {
      AppBrandDesktopHalfView localAppBrandDesktopHalfView = this.lWD;
      localAppBrandDesktopHalfView.dkt = false;
      localAppBrandDesktopHalfView.setLayoutFrozen(false);
      localAppBrandDesktopHalfView.postDelayed(new AppBrandDesktopHalfView.14(localAppBrandDesktopHalfView), 10L);
    }
    AppMethodBeat.o(49732);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity) {}
  
  public void setAnimController(c paramc)
  {
    AppMethodBeat.i(49729);
    this.lTj = paramc;
    if (this.lTj != null) {
      this.lTj.a(this);
    }
    AppMethodBeat.o(49729);
  }
  
  public void setDynamicBackgroundView(View paramView) {}
  
  public void setExtraBottomHeight(int paramInt) {}
  
  public void setFixedHeight(boolean paramBoolean) {}
  
  public final void uF(int paramInt)
  {
    AppMethodBeat.i(49730);
    if (this.lWD != null) {
      this.lWD.uF(paramInt);
    }
    AppMethodBeat.o(49730);
  }
  
  public final void uG(int paramInt)
  {
    AppMethodBeat.i(49731);
    uF(paramInt);
    AppMethodBeat.o(49731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfContainer
 * JD-Core Version:    0.7.0.1
 */