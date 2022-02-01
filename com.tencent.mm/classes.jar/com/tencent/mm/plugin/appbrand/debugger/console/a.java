package com.tencent.mm.plugin.appbrand.debugger.console;

import android.graphics.Point;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintControlFloatWindow;", "", "onClick", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "isShown", "", "layoutParams", "Landroid/view/WindowManager$LayoutParams;", "getLayoutParams", "()Landroid/view/WindowManager$LayoutParams;", "layoutParams$delegate", "Lkotlin/Lazy;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "screenSize", "Landroid/graphics/Point;", "getScreenSize", "()Landroid/graphics/Point;", "screenSize$delegate", "topBottomSafeGuard", "", "getTopBottomSafeGuard", "()I", "topBottomSafeGuard$delegate", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view$delegate", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "hide", "show", "updatePosition", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final boolean DEBUG = false;
  public static final a.a rfj;
  private boolean elb;
  kotlin.g.a.a<ah> meC;
  private final j rfk;
  private final j rfl;
  private final j rfm;
  private final j rfn;
  private final j rfo;
  
  static
  {
    AppMethodBeat.i(319859);
    rfj = new a.a((byte)0);
    AppMethodBeat.o(319859);
  }
  
  private a()
  {
    AppMethodBeat.i(319789);
    this.meC = null;
    this.rfk = kotlin.k.cm((kotlin.g.a.a)a.f.rfu);
    this.rfl = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.rfm = kotlin.k.cm((kotlin.g.a.a)a.d.rfq);
    this.rfn = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.rfo = kotlin.k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(319789);
  }
  
  private final WindowManager.LayoutParams cmd()
  {
    AppMethodBeat.i(319820);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.rfo.getValue();
    AppMethodBeat.o(319820);
    return localLayoutParams;
  }
  
  private final View getView()
  {
    AppMethodBeat.i(319811);
    View localView = (View)this.rfn.getValue();
    AppMethodBeat.o(319811);
    return localView;
  }
  
  private final WindowManager getWindowManager()
  {
    AppMethodBeat.i(319802);
    WindowManager localWindowManager = (WindowManager)this.rfk.getValue();
    AppMethodBeat.o(319802);
    return localWindowManager;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(319865);
    Log.i("MicroMsg.AppBrand.ConsolePrintControlFloatWindow", s.X("hide, isShown: ", Boolean.valueOf(this.elb)));
    if (!this.elb)
    {
      AppMethodBeat.o(319865);
      return;
    }
    try
    {
      Object localObject = getWindowManager();
      if (localObject != null)
      {
        ((WindowManager)localObject).removeView(getView());
        localObject = ah.aiuX;
        this.elb = false;
        AppMethodBeat.o(319865);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.ConsolePrintControlFloatWindow", s.X("hide, removeView fail since ", localException));
      AppMethodBeat.o(319865);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(319862);
    Log.i("MicroMsg.AppBrand.ConsolePrintControlFloatWindow", s.X("show, isShown: ", Boolean.valueOf(this.elb)));
    if (this.elb)
    {
      AppMethodBeat.o(319862);
      return;
    }
    try
    {
      Object localObject = getWindowManager();
      if (localObject != null)
      {
        ((WindowManager)localObject).addView(getView(), (ViewGroup.LayoutParams)cmd());
        localObject = ah.aiuX;
        this.elb = true;
        AppMethodBeat.o(319862);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.ConsolePrintControlFloatWindow", s.X("show, addView fail since ", localException));
      AppMethodBeat.o(319862);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/WindowManager$LayoutParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<WindowManager.LayoutParams>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Point;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Point>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintControlView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<b>
  {
    e(a parama)
    {
      super();
    }
    
    private static final void a(a parama, View paramView)
    {
      AppMethodBeat.i(319734);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintControlFloatWindow$view$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      parama = parama.meC;
      if (parama != null) {
        parama.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintControlFloatWindow$view$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(319734);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintControlFloatWindow$view$2$1$2", "Landroid/view/View$OnTouchListener;", "isDragging", "", "positionOnDown", "Landroid/graphics/PointF;", "scaledTouchSlop", "", "hasMove", "event", "Landroid/view/MotionEvent;", "moveOnTouch", "", "onTouch", "v", "Landroid/view/View;", "recordPositionOnDown", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements View.OnTouchListener
    {
      private boolean mlX;
      private final int rfr;
      private final PointF rfs;
      
      a(b paramb, a parama)
      {
        AppMethodBeat.i(319784);
        this.rfr = ViewConfiguration.get(this.rft.getContext()).getScaledTouchSlop();
        this.rfs = new PointF();
        AppMethodBeat.o(319784);
      }
      
      private final boolean y(MotionEvent paramMotionEvent)
      {
        AppMethodBeat.i(319790);
        if ((Math.abs(paramMotionEvent.getRawX() - this.rfs.x) > this.rfr) || (Math.abs(paramMotionEvent.getRawY() - this.rfs.y) > this.rfr))
        {
          AppMethodBeat.o(319790);
          return true;
        }
        AppMethodBeat.o(319790);
        return false;
      }
      
      public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
      {
        AppMethodBeat.i(319804);
        if (paramMotionEvent == null)
        {
          AppMethodBeat.o(319804);
          return true;
        }
        switch (paramMotionEvent.getAction())
        {
        }
        do
        {
          for (;;)
          {
            AppMethodBeat.o(319804);
            return false;
            this.mlX = false;
            this.rfs.x = paramMotionEvent.getRawX();
            this.rfs.y = paramMotionEvent.getRawY();
            continue;
            if ((!this.mlX) && (y(paramMotionEvent))) {
              this.mlX = true;
            }
            if (this.mlX)
            {
              paramView = a.b(this.rfp);
              if (a.access$getDEBUG$cp()) {
                Log.d("MicroMsg.AppBrand.ConsolePrintControlFloatWindow", "moveOnTouch, before, view: [" + paramView.x + ", " + paramView.y + ']');
              }
              paramView.x = ((int)kotlin.k.k.bu(kotlin.k.k.bt(paramMotionEvent.getRawX() - this.rft.getWidth() / 2, 0.0F), a.c(this.rfp).x));
              paramView.y = ((int)kotlin.k.k.bu(kotlin.k.k.bt(paramMotionEvent.getRawY() - this.rft.getHeight() / 2, a.d(this.rfp)), a.c(this.rfp).y - a.d(this.rfp)));
              a.e(this.rfp);
              if (a.access$getDEBUG$cp()) {
                Log.d("MicroMsg.AppBrand.ConsolePrintControlFloatWindow", "moveOnTouch, after, view: [" + paramView.x + ", " + paramView.y + ']');
              }
            }
          }
        } while ((!this.mlX) && (!y(paramMotionEvent)));
        this.mlX = false;
        AppMethodBeat.o(319804);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.a
 * JD-Core Version:    0.7.0.1
 */