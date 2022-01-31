package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;

public class AppBrandDesktopHalfContainer
  extends HeaderContainer
  implements View.OnTouchListener, a.a
{
  private com.tencent.mm.plugin.appbrand.widget.header.a hpI;
  private Rect hpK = new Rect();
  private GyroView hpx;
  private AppBrandDesktopHalfView hre;
  private View hrf;
  
  public AppBrandDesktopHalfContainer(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AppBrandDesktopHalfContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.hre = new AppBrandDesktopHalfView(paramContext);
    this.hre.setId(y.g.app_brand_desktop_view);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    this.hre.setLayoutParams(localLayoutParams);
    this.hrf = this.hre.findViewById(y.g.app_brand_desktop_empty_layout);
    addView(this.hre);
    this.hpx = new GyroView(paramContext);
    paramContext = new FrameLayout.LayoutParams((int)getResources().getDimension(y.e.header_gyro_width), (int)getResources().getDimension(y.e.header_gyro_height));
    paramContext.gravity = 81;
    this.hpx.setId(y.g.gyro_view);
    addView(this.hpx, paramContext);
  }
  
  public final void arr() {}
  
  public final void ars()
  {
    if (this.hre != null) {
      this.hre.ars();
    }
  }
  
  public final void art()
  {
    ars();
  }
  
  public final void aru() {}
  
  public Rect getBackUpFooterRect()
  {
    return this.hpK;
  }
  
  public View getEmptyView()
  {
    return this.hrf;
  }
  
  public GyroView getGyroView()
  {
    return this.hpx;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return this.hre;
  }
  
  public final boolean isFullScreen()
  {
    if (this.hre != null) {}
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void onPause()
  {
    super.onPause();
    if (this.hre != null) {
      this.hre.bNW = true;
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    if (this.hre != null)
    {
      AppBrandDesktopHalfView localAppBrandDesktopHalfView = this.hre;
      localAppBrandDesktopHalfView.bNW = false;
      localAppBrandDesktopHalfView.setLayoutFrozen(false);
      localAppBrandDesktopHalfView.postDelayed(new AppBrandDesktopHalfView.14(localAppBrandDesktopHalfView), 10L);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setAnimController(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.hpI = parama;
    if (this.hpI != null) {
      this.hpI.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfContainer
 * JD-Core Version:    0.7.0.1
 */