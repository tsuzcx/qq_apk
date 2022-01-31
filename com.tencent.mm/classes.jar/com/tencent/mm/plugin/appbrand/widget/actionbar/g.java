package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class g
  extends PopupWindow
{
  private WindowManager bTq;
  private View jbK;
  public FrameLayout jbL;
  private Context mContext;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133660);
    this.mContext = null;
    this.mContext = paramContext;
    this.bTq = ((WindowManager)paramContext.getSystemService("window"));
    this.jbL = new FrameLayout(this.mContext);
    AppMethodBeat.o(133660);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(133662);
    if (this.jbK != null)
    {
      this.bTq.removeViewImmediate(this.jbK);
      this.jbK = null;
    }
    super.dismiss();
    AppMethodBeat.o(133662);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(133663);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.topMargin = a.ap(this.mContext, 2131427981);
    localLayoutParams.rightMargin = a.ap(this.mContext, 2131427980);
    localLayoutParams.leftMargin = a.ap(this.mContext, 2131427980);
    this.jbL.addView(paramView, localLayoutParams);
    super.setContentView(this.jbL);
    AppMethodBeat.o(133663);
  }
  
  public final void showAsDropDown(View paramView)
  {
    AppMethodBeat.i(133661);
    IBinder localIBinder = paramView.getWindowToken();
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = localIBinder;
    this.jbK = new View(this.mContext);
    this.jbK.setBackgroundColor(2130706432);
    this.jbK.setFitsSystemWindows(false);
    this.jbK.setOnTouchListener(new g.1(this));
    this.jbK.setOnKeyListener(new g.2(this));
    this.bTq.addView(this.jbK, localLayoutParams);
    super.showAsDropDown(paramView);
    AppMethodBeat.o(133661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.g
 * JD-Core Version:    0.7.0.1
 */