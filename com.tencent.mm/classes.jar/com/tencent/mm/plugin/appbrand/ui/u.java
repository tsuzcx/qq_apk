package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vending.c.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"askScreenStatus", "", "context", "Landroid/content/Context;", "onScreenStatusGot", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isScreenOn", "runIfDrawStatusBarLayoutPresent", "activity", "Lcom/tencent/mm/ui/MMActivity;", "function", "Lcom/tencent/mm/vending/functional/Functional;", "Ljava/lang/Void;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "plugin-appbrand-integration_release"})
public final class u
{
  public static final void a(MMActivity paramMMActivity, a<Void, b> parama)
  {
    AppMethodBeat.i(51154);
    paramMMActivity = paramMMActivity.getSwipeBackLayout();
    if (paramMMActivity != null) {}
    for (paramMMActivity = paramMMActivity.getTargetContentView();; paramMMActivity = null)
    {
      MMActivity localMMActivity = paramMMActivity;
      if (!(paramMMActivity instanceof b)) {
        localMMActivity = null;
      }
      paramMMActivity = (b)localMMActivity;
      if (paramMMActivity == null) {
        break;
      }
      parama.call(paramMMActivity);
      AppMethodBeat.o(51154);
      return;
    }
    AppMethodBeat.o(51154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u
 * JD-Core Version:    0.7.0.1
 */