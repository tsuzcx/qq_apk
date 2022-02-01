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
  private c mVS;
  private Rect mVW;
  private GyroView mVu;
  private AppBrandDesktopHalfView mZn;
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49724);
    this.mVW = new Rect();
    init(paramContext);
    AppMethodBeat.o(49724);
  }
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49725);
    this.mVW = new Rect();
    init(paramContext);
    AppMethodBeat.o(49725);
  }
  
  private void ec(Context paramContext)
  {
    AppMethodBeat.i(49728);
    this.mVu = new GyroView(paramContext);
    paramContext = new FrameLayout.LayoutParams((int)getResources().getDimension(2131166414), (int)getResources().getDimension(2131166413));
    paramContext.gravity = 81;
    this.mVu.setId(2131300673);
    this.mVu.setVisibility(8);
    addView(this.mVu, paramContext);
    AppMethodBeat.o(49728);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49727);
    this.mZn = new AppBrandDesktopHalfView(paramContext);
    this.mZn.setId(2131296711);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    this.mZn.setLayoutParams(localLayoutParams);
    this.GG = this.mZn.findViewById(2131296698);
    addView(this.mZn);
    ec(paramContext);
    AppMethodBeat.o(49727);
  }
  
  public final boolean bCA()
  {
    return false;
  }
  
  public final void bCN() {}
  
  public final void bCZ() {}
  
  public final void bDa() {}
  
  public final void g(View paramView1, View paramView2) {}
  
  public int getAnimationScrollOffset()
  {
    return 0;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.mVW;
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
    return this.mVu;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return this.mZn;
  }
  
  public View getMaskView()
  {
    return null;
  }
  
  public final boolean isFullScreen()
  {
    if (this.mZn != null) {}
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
    if (this.mZn != null) {
      this.mZn.dtm = true;
    }
    AppMethodBeat.o(49733);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49732);
    super.onResume();
    if (this.mZn != null)
    {
      AppBrandDesktopHalfView localAppBrandDesktopHalfView = this.mZn;
      localAppBrandDesktopHalfView.dtm = false;
      localAppBrandDesktopHalfView.setLayoutFrozen(false);
      localAppBrandDesktopHalfView.postDelayed(new AppBrandDesktopHalfView.14(localAppBrandDesktopHalfView), 10L);
    }
    AppMethodBeat.o(49732);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(188949);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfContainer", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfContainer", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(188949);
    return false;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity) {}
  
  public void setAnimController(c paramc)
  {
    AppMethodBeat.i(49729);
    this.mVS = paramc;
    if (this.mVS != null) {
      this.mVS.a(this);
    }
    AppMethodBeat.o(49729);
  }
  
  public void setDynamicBackgroundView(View paramView) {}
  
  public void setExtraBottomHeight(int paramInt) {}
  
  public void setFixedHeight(boolean paramBoolean) {}
  
  public final void wc(int paramInt)
  {
    AppMethodBeat.i(49730);
    if (this.mZn != null) {
      this.mZn.wc(paramInt);
    }
    AppMethodBeat.o(49730);
  }
  
  public final void wd(int paramInt)
  {
    AppMethodBeat.i(49731);
    wc(paramInt);
    AppMethodBeat.o(49731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfContainer
 * JD-Core Version:    0.7.0.1
 */