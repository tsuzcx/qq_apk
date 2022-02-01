package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vending.c.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"askScreenStatus", "", "context", "Landroid/content/Context;", "onScreenStatusGot", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isScreenOn", "runIfDrawStatusBarLayoutPresent", "activity", "Lcom/tencent/mm/ui/MMActivity;", "function", "Lcom/tencent/mm/vending/functional/Functional;", "Ljava/lang/Void;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class af
{
  public static final void a(MMActivity paramMMActivity, a<Void, com.tencent.mm.ui.statusbar.b> parama)
  {
    AppMethodBeat.i(51154);
    paramMMActivity = paramMMActivity.getSwipeBackLayout();
    if (paramMMActivity == null)
    {
      paramMMActivity = null;
      if (!(paramMMActivity instanceof com.tencent.mm.ui.statusbar.b)) {
        break label54;
      }
    }
    label54:
    for (paramMMActivity = (com.tencent.mm.ui.statusbar.b)paramMMActivity;; paramMMActivity = null)
    {
      if (paramMMActivity != null) {
        parama.call(paramMMActivity);
      }
      AppMethodBeat.o(51154);
      return;
      paramMMActivity = paramMMActivity.getTargetContentView();
      break;
    }
  }
  
  public static final void c(Context paramContext, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(322043);
    s.u(paramContext, "context");
    s.u(paramb, "onScreenStatusGot");
    MMHandlerThread.postToMainThread(new af..ExternalSyntheticLambda0(paramContext, paramb));
    AppMethodBeat.o(322043);
  }
  
  private static final void d(Context paramContext, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(322050);
    s.u(paramContext, "$context");
    s.u(paramb, "$onScreenStatusGot");
    paramContext = paramContext.getSystemService("power");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(322050);
      throw paramContext;
    }
    paramb.invoke(Boolean.valueOf(((PowerManager)paramContext).isInteractive()));
    AppMethodBeat.o(322050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.af
 * JD-Core Version:    0.7.0.1
 */