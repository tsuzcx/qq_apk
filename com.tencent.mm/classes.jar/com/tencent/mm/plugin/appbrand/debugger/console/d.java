package com.tencent.mm.plugin.appbrand.debugger.console;

import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanelFloatWindow;", "", "onShown", "Lkotlin/Function0;", "", "onHidden", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "isShown", "", "layoutParams", "Landroid/view/WindowManager$LayoutParams;", "getLayoutParams", "()Landroid/view/WindowManager$LayoutParams;", "layoutParams$delegate", "Lkotlin/Lazy;", "getOnHidden", "()Lkotlin/jvm/functions/Function0;", "setOnHidden", "(Lkotlin/jvm/functions/Function0;)V", "getOnShown", "setOnShown", "printPanel", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel;", "getPrintPanel", "()Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel;", "printPanel$delegate", "printer", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintView;", "getPrinter", "()Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintView;", "printer$delegate", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view$delegate", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "hide", "show", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a rfA;
  boolean elb;
  private final j rfB;
  private final j rfC;
  private final j rfk;
  private final j rfn;
  final j rfo;
  kotlin.g.a.a<ah> rfw;
  kotlin.g.a.a<ah> rfx;
  
  static
  {
    AppMethodBeat.i(319808);
    rfA = new d.a((byte)0);
    AppMethodBeat.o(319808);
  }
  
  private d()
  {
    AppMethodBeat.i(319786);
    this.rfw = null;
    this.rfx = null;
    this.rfk = k.cm((kotlin.g.a.a)d.f.rfF);
    this.rfB = k.cm((kotlin.g.a.a)new c(this));
    this.rfn = k.cm((kotlin.g.a.a)new e(this));
    this.rfo = k.cm((kotlin.g.a.a)d.b.rfD);
    this.rfC = k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(319786);
  }
  
  final c cme()
  {
    AppMethodBeat.i(319823);
    c localc = (c)this.rfB.getValue();
    AppMethodBeat.o(319823);
    return localc;
  }
  
  public final e getPrinter()
  {
    AppMethodBeat.i(319836);
    e locale = (e)this.rfC.getValue();
    AppMethodBeat.o(319836);
    return locale;
  }
  
  final View getView()
  {
    AppMethodBeat.i(319830);
    View localView = (View)this.rfn.getValue();
    AppMethodBeat.o(319830);
    return localView;
  }
  
  final WindowManager getWindowManager()
  {
    AppMethodBeat.i(319818);
    WindowManager localWindowManager = (WindowManager)this.rfk.getValue();
    AppMethodBeat.o(319818);
    return localWindowManager;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(319842);
    Log.i("MicroMsg.AppBrand.ConsolePrintPanelFloatWindow", s.X("hide, isShown: ", Boolean.valueOf(this.elb)));
    if (!this.elb)
    {
      AppMethodBeat.o(319842);
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
        AppMethodBeat.o(319842);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.ConsolePrintPanelFloatWindow", s.X("hide, removeView fail since ", localException));
      AppMethodBeat.o(319842);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanel;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<c>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<e>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    e(d paramd)
    {
      super();
    }
    
    private static final void c(c paramc, View paramView)
    {
      AppMethodBeat.i(319797);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanelFloatWindow$view$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "$realPanel");
      Log.i("MicroMsg.AppBrand.ConsolePrintPanelFloatWindow", "onClick#realPanelContainer");
      paramc.hide();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanelFloatWindow$view$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(319797);
    }
    
    private static final void du(View paramView)
    {
      AppMethodBeat.i(319785);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanelFloatWindow$view$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      Log.i("MicroMsg.AppBrand.ConsolePrintPanelFloatWindow", "onClick#realPanel");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanelFloatWindow$view$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(319785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.d
 * JD-Core Version:    0.7.0.1
 */