package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vending.c.a;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"askScreenStatus", "", "context", "Landroid/content/Context;", "onScreenStatusGot", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isScreenOn", "runIfDrawStatusBarLayoutPresent", "activity", "Lcom/tencent/mm/ui/MMActivity;", "function", "Lcom/tencent/mm/vending/functional/Functional;", "Ljava/lang/Void;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "plugin-appbrand-integration_release"})
public final class y
{
  public static final void a(MMActivity paramMMActivity, a<Void, com.tencent.mm.ui.statusbar.b> parama)
  {
    AppMethodBeat.i(51154);
    paramMMActivity = paramMMActivity.getSwipeBackLayout();
    if (paramMMActivity != null) {}
    for (paramMMActivity = paramMMActivity.getTargetContentView();; paramMMActivity = null)
    {
      MMActivity localMMActivity = paramMMActivity;
      if (!(paramMMActivity instanceof com.tencent.mm.ui.statusbar.b)) {
        localMMActivity = null;
      }
      paramMMActivity = (com.tencent.mm.ui.statusbar.b)localMMActivity;
      if (paramMMActivity == null) {
        break;
      }
      parama.call(paramMMActivity);
      AppMethodBeat.o(51154);
      return;
    }
    AppMethodBeat.o(51154);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(Context paramContext, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(51153);
      Object localObject = this.$context.getSystemService("power");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.os.PowerManager");
        AppMethodBeat.o(51153);
        throw ((Throwable)localObject);
      }
      boolean bool = ((PowerManager)localObject).isInteractive();
      this.qZG.invoke(Boolean.valueOf(bool));
      AppMethodBeat.o(51153);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.y
 * JD-Core Version:    0.7.0.1
 */