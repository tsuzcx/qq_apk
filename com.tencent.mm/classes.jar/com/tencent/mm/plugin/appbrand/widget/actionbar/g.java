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
import com.tencent.mm.hellhoundlib.b.b;

public final class g
  extends PopupWindow
{
  private View gZU;
  private Context mContext;
  public FrameLayout mUk;
  private WindowManager windowManager;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49381);
    this.mContext = null;
    this.mContext = paramContext;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.mUk = new FrameLayout(this.mContext);
    AppMethodBeat.o(49381);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(49383);
    if (this.gZU != null)
    {
      this.windowManager.removeViewImmediate(this.gZU);
      this.gZU = null;
    }
    super.dismiss();
    AppMethodBeat.o(49383);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(49384);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.topMargin = com.tencent.mm.cc.a.ay(this.mContext, 2131165751);
    localLayoutParams.rightMargin = com.tencent.mm.cc.a.ay(this.mContext, 2131165750);
    localLayoutParams.leftMargin = com.tencent.mm.cc.a.ay(this.mContext, 2131165750);
    this.mUk.addView(paramView, localLayoutParams);
    super.setContentView(this.mUk);
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
    this.gZU = new View(this.mContext);
    this.gZU.setBackgroundColor(2130706432);
    this.gZU.setFitsSystemWindows(false);
    this.gZU.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(49379);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          g.this.dismiss();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(49379);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(49379);
        return false;
      }
    });
    this.gZU.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(49380);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
        if (paramAnonymousInt == 4)
        {
          g.this.dismiss();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(49380);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(49380);
        return false;
      }
    });
    this.windowManager.addView(this.gZU, localLayoutParams);
    super.showAsDropDown(paramView);
    AppMethodBeat.o(49382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.g
 * JD-Core Version:    0.7.0.1
 */