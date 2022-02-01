package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.ba.d;

public final class g
  extends PopupWindow
{
  private Context mContext;
  private View maskView;
  public FrameLayout uzj;
  private WindowManager windowManager;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49381);
    this.mContext = null;
    this.mContext = paramContext;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.uzj = new FrameLayout(this.mContext);
    AppMethodBeat.o(49381);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(49383);
    if (this.maskView != null)
    {
      this.windowManager.removeViewImmediate(this.maskView);
      this.maskView = null;
    }
    super.dismiss();
    AppMethodBeat.o(49383);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(49384);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.topMargin = a.bs(this.mContext, ba.d.app_brand_app_brand_popwindow_with_mask_topmargin);
    localLayoutParams.rightMargin = a.bs(this.mContext, ba.d.app_brand_app_brand_popwindow_with_mask_margin);
    localLayoutParams.leftMargin = a.bs(this.mContext, ba.d.app_brand_app_brand_popwindow_with_mask_margin);
    this.uzj.addView(paramView, localLayoutParams);
    super.setContentView(this.uzj);
    AppMethodBeat.o(49384);
  }
  
  public final void showAsDropDown(View paramView)
  {
    AppMethodBeat.i(49382);
    IBinder localIBinder = paramView.getWindowToken();
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    if (Build.VERSION.SDK_INT >= 28) {
      localLayoutParams.layoutInDisplayCutoutMode = 1;
    }
    localLayoutParams.token = localIBinder;
    this.maskView = new View(this.mContext);
    this.maskView.setBackgroundColor(2130706432);
    this.maskView.setFitsSystemWindows(false);
    this.maskView.setOnTouchListener(new g.1(this));
    this.maskView.setOnKeyListener(new g.2(this));
    this.windowManager.addView(this.maskView, localLayoutParams);
    super.showAsDropDown(paramView);
    AppMethodBeat.o(49382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.g
 * JD-Core Version:    0.7.0.1
 */