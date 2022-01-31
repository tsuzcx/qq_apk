package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.y;

public class AppBrandDesktopContainer
  extends HeaderContainer
  implements View.OnTouchListener
{
  private com.tencent.mm.plugin.appbrand.widget.header.a hpI;
  private AppBrandDesktopView hpJ;
  private Rect hpK = new Rect();
  private GyroView hpx;
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.hpJ = new AppBrandDesktopView(paramContext);
    this.hpJ.setHeaderContainer(this);
    this.hpJ.setId(y.g.app_brand_desktop_view);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    int i = this.hpJ.getLeftRightMargin();
    y.i("MicroMsg.MyAppBrandHeaderContainer", "alvinluo desktop view marginLeftRight: %d", new Object[] { Integer.valueOf(i) });
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    addView(this.hpJ, localLayoutParams);
    this.hpx = new GyroView(paramContext);
    paramContext = new FrameLayout.LayoutParams((int)getResources().getDimension(y.e.header_gyro_width), (int)getResources().getDimension(y.e.header_gyro_height));
    paramContext.gravity = 81;
    this.hpx.setId(y.g.gyro_view);
    addView(this.hpx, paramContext);
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.hpK;
  }
  
  public View getEmptyView()
  {
    return null;
  }
  
  public GyroView getGyroView()
  {
    return this.hpx;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return null;
  }
  
  public final boolean isFullScreen()
  {
    return AppBrandDesktopView.arq();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = ((ViewGroup)getParent()).getMeasuredHeight() - (int)getResources().getDimension(y.e.header_up_helper);
    int i = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
    this.hpJ.getLayoutParams().height = paramInt2;
    super.onMeasure(paramInt1, i);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.hpI != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.hpI.onTouch(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public void setAnimController(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.hpI = parama;
    if ((this.hpJ != null) && (this.hpI != null)) {
      this.hpI.a(this.hpJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer
 * JD-Core Version:    0.7.0.1
 */