package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/BaseWindow;", "Landroid/view/View$OnKeyListener;", "()V", "TAG", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "isDarkWindow", "", "()Z", "setDarkWindow", "(Z)V", "isHiding", "setHiding", "powerManager", "Landroid/os/PowerManager;", "getPowerManager", "()Landroid/os/PowerManager;", "powerManager$delegate", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "shown", "getShown", "setShown", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "findViewById", "T", "id", "", "(I)Landroid/view/View;", "getLayoutId", "hide", "", "onHideWindow", "onInflateView", "onScrollUpHide", "onShowWindow", "playPopupAnimation", "show", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements View.OnKeyListener
{
  private final j ATU = k.cm((kotlin.g.a.a)a.a.HoE);
  final j Fzi = k.cm((kotlin.g.a.a)new b(this));
  private boolean HoC;
  private boolean HoD;
  private final String TAG = "ForceNotify.BaseWindow";
  private final j rfk = k.cm((kotlin.g.a.a)new c(this));
  private View rootView;
  
  private static final void a(a parama)
  {
    s.u(parama, "this$0");
    Object localObject;
    int i;
    if (!parama.HoC)
    {
      parama.HoD = aw.isDarkMode();
      parama.rootView = af.mU(parama.getContext()).inflate(parama.getLayoutId(), null);
      localObject = parama.rootView;
      s.checkNotNull(localObject);
      parama.hq((View)localObject);
      localObject = new WindowManager.LayoutParams();
      if (!d.rb(26)) {
        break label178;
      }
      i = 2038;
    }
    for (;;)
    {
      ((WindowManager.LayoutParams)localObject).type = i;
      ((WindowManager.LayoutParams)localObject).format = -2;
      ((WindowManager.LayoutParams)localObject).packageName = parama.getContext().getPackageName();
      ((WindowManager.LayoutParams)localObject).gravity = 48;
      ((WindowManager.LayoutParams)localObject).flags = 1064;
      ((WindowManager.LayoutParams)localObject).horizontalMargin = parama.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.forcenotify.a.c.Edge_A);
      ((WindowManager.LayoutParams)localObject).width = -1;
      ((WindowManager.LayoutParams)localObject).height = -2;
      View localView = parama.rootView;
      if (localView != null) {
        localView.setVisibility(0);
      }
      try
      {
        parama.getWindowManager().addView(parama.rootView, (ViewGroup.LayoutParams)localObject);
        parama.fwS();
        parama.HoC = true;
        return;
        label178:
        i = 2002;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(parama.TAG, "attach to window failed!");
        }
      }
    }
  }
  
  private static final void b(a parama)
  {
    s.u(parama, "this$0");
    if (parama.HoC)
    {
      parama.HoC = false;
      View localView = parama.rootView;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    try
    {
      parama.getWindowManager().removeView(parama.rootView);
      parama.fwT();
      parama.rootView = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(parama.TAG, "detach from window failed");
      }
    }
  }
  
  private WindowManager getWindowManager()
  {
    return (WindowManager)this.rfk.getValue();
  }
  
  protected final <T extends View> T findViewById(int paramInt)
  {
    View localView = this.rootView;
    if (localView == null) {
      return null;
    }
    return localView.findViewById(paramInt);
  }
  
  protected final boolean fwR()
  {
    return this.HoD;
  }
  
  public void fwS()
  {
    View localView = this.rootView;
    if (localView != null) {
      localView.setFocusableInTouchMode(true);
    }
    localView = this.rootView;
    if (localView != null) {
      localView.setOnKeyListener((View.OnKeyListener)this);
    }
  }
  
  public void fwT() {}
  
  protected final Context getContext()
  {
    Object localObject = this.ATU.getValue();
    s.s(localObject, "<get-context>(...)");
    return (Context)localObject;
  }
  
  public abstract int getLayoutId();
  
  public final void hide()
  {
    h.ahAA.bk(new a..ExternalSyntheticLambda1(this));
  }
  
  public abstract void hq(View paramView);
  
  public final void show()
  {
    com.tencent.mm.plugin.forcenotify.e.a locala = com.tencent.mm.plugin.forcenotify.e.a.HpI;
    if (!com.tencent.mm.plugin.forcenotify.e.a.hE(getContext())) {
      return;
    }
    h.ahAA.bk(new a..ExternalSyntheticLambda0(this));
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/os/PowerManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<PowerManager>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/WindowManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<WindowManager>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.a
 * JD-Core Version:    0.7.0.1
 */