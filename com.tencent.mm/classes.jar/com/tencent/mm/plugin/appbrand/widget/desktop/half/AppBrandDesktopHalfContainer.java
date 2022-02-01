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
  private View EP;
  private GyroView muN;
  private c mvl;
  private Rect mvp;
  private AppBrandDesktopHalfView myF;
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49724);
    this.mvp = new Rect();
    init(paramContext);
    AppMethodBeat.o(49724);
  }
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49725);
    this.mvp = new Rect();
    init(paramContext);
    AppMethodBeat.o(49725);
  }
  
  private void ec(Context paramContext)
  {
    AppMethodBeat.i(49728);
    this.muN = new GyroView(paramContext);
    paramContext = new FrameLayout.LayoutParams((int)getResources().getDimension(2131166414), (int)getResources().getDimension(2131166413));
    paramContext.gravity = 81;
    this.muN.setId(2131300673);
    this.muN.setVisibility(8);
    addView(this.muN, paramContext);
    AppMethodBeat.o(49728);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49727);
    this.myF = new AppBrandDesktopHalfView(paramContext);
    this.myF.setId(2131296711);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    this.myF.setLayoutParams(localLayoutParams);
    this.EP = this.myF.findViewById(2131296698);
    addView(this.myF);
    ec(paramContext);
    AppMethodBeat.o(49727);
  }
  
  public final void byI() {}
  
  public final void byW() {}
  
  public final void byX() {}
  
  public final boolean byv()
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
    return this.mvp;
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
    return this.EP;
  }
  
  public int getExtraBottomHeight()
  {
    return 0;
  }
  
  public GyroView getGyroView()
  {
    return this.muN;
  }
  
  public a getHeaderView()
  {
    return this.myF;
  }
  
  public View getMaskView()
  {
    return null;
  }
  
  public final boolean isFullScreen()
  {
    if (this.myF != null) {}
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
    if (this.myF != null) {
      this.myF.dhO = true;
    }
    AppMethodBeat.o(49733);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49732);
    super.onResume();
    if (this.myF != null)
    {
      AppBrandDesktopHalfView localAppBrandDesktopHalfView = this.myF;
      localAppBrandDesktopHalfView.dhO = false;
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
    this.mvl = paramc;
    if (this.mvl != null) {
      this.mvl.a(this);
    }
    AppMethodBeat.o(49729);
  }
  
  public void setDynamicBackgroundView(View paramView) {}
  
  public void setExtraBottomHeight(int paramInt) {}
  
  public void setFixedHeight(boolean paramBoolean) {}
  
  public final void vw(int paramInt)
  {
    AppMethodBeat.i(49730);
    if (this.myF != null) {
      this.myF.vw(paramInt);
    }
    AppMethodBeat.o(49730);
  }
  
  public final void vx(int paramInt)
  {
    AppMethodBeat.i(49731);
    vw(paramInt);
    AppMethodBeat.o(49731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfContainer
 * JD-Core Version:    0.7.0.1
 */