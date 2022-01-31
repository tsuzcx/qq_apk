package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vending.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"runIfDrawStatusBarLayoutPresent", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "function", "Lcom/tencent/mm/vending/functional/Functional;", "Ljava/lang/Void;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "plugin-appbrand-integration_release"})
public final class p
{
  public static final void a(MMActivity paramMMActivity, a<Void, b> parama)
  {
    AppMethodBeat.i(135002);
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
      AppMethodBeat.o(135002);
      return;
    }
    AppMethodBeat.o(135002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p
 * JD-Core Version:    0.7.0.1
 */