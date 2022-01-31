package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.y.e;

public final class e
  extends PopupWindow
{
  private WindowManager fxi;
  private View hoY;
  public FrameLayout hoZ;
  private Context mContext = null;
  
  public e(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.fxi = ((WindowManager)paramContext.getSystemService("window"));
    this.hoZ = new FrameLayout(this.mContext);
  }
  
  public final void dismiss()
  {
    if (this.hoY != null)
    {
      this.fxi.removeViewImmediate(this.hoY);
      this.hoY = null;
    }
    super.dismiss();
  }
  
  public final void setContentView(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.topMargin = a.ab(this.mContext, y.e.app_brand_app_brand_popwindow_with_mask_topmargin);
    localLayoutParams.rightMargin = a.ab(this.mContext, y.e.app_brand_app_brand_popwindow_with_mask_margin);
    localLayoutParams.leftMargin = a.ab(this.mContext, y.e.app_brand_app_brand_popwindow_with_mask_margin);
    this.hoZ.addView(paramView, localLayoutParams);
    super.setContentView(this.hoZ);
  }
  
  public final void showAsDropDown(View paramView)
  {
    IBinder localIBinder = paramView.getWindowToken();
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = localIBinder;
    this.hoY = new View(this.mContext);
    this.hoY.setBackgroundColor(2130706432);
    this.hoY.setFitsSystemWindows(false);
    this.hoY.setOnTouchListener(new e.1(this));
    this.hoY.setOnKeyListener(new e.2(this));
    this.fxi.addView(this.hoY, localLayoutParams);
    super.showAsDropDown(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e
 * JD-Core Version:    0.7.0.1
 */