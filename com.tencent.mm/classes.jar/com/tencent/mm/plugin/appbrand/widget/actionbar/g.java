package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public final class g
  extends PopupWindow
{
  private View lRB;
  public FrameLayout lRC;
  private Context mContext;
  private WindowManager windowManager;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49381);
    this.mContext = null;
    this.mContext = paramContext;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.lRC = new FrameLayout(this.mContext);
    AppMethodBeat.o(49381);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(49383);
    if (this.lRB != null)
    {
      this.windowManager.removeViewImmediate(this.lRB);
      this.lRB = null;
    }
    super.dismiss();
    AppMethodBeat.o(49383);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(49384);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.topMargin = a.ap(this.mContext, 2131165751);
    localLayoutParams.rightMargin = a.ap(this.mContext, 2131165750);
    localLayoutParams.leftMargin = a.ap(this.mContext, 2131165750);
    this.lRC.addView(paramView, localLayoutParams);
    super.setContentView(this.lRC);
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
    this.lRB = new View(this.mContext);
    this.lRB.setBackgroundColor(2130706432);
    this.lRB.setFitsSystemWindows(false);
    this.lRB.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(49379);
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          g.this.dismiss();
          AppMethodBeat.o(49379);
          return true;
        }
        AppMethodBeat.o(49379);
        return false;
      }
    });
    this.lRB.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(49380);
        if (paramAnonymousInt == 4)
        {
          g.this.dismiss();
          AppMethodBeat.o(49380);
          return true;
        }
        AppMethodBeat.o(49380);
        return false;
      }
    });
    this.windowManager.addView(this.lRB, localLayoutParams);
    super.showAsDropDown(paramView);
    AppMethodBeat.o(49382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.g
 * JD-Core Version:    0.7.0.1
 */