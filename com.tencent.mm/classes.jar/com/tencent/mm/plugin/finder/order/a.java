package com.tencent.mm.plugin.finder.order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI25;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/FinderLiveOrderUtil;", "", "()V", "enterFinderLiveOrderUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ESd;
  
  static
  {
    AppMethodBeat.i(332291);
    ESd = new a();
    AppMethodBeat.o(332291);
  }
  
  public static void Q(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(332283);
    s.u(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, OccupyFinderUI25.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/order/FinderLiveOrderUtil", "enterFinderLiveOrderUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/order/FinderLiveOrderUtil", "enterFinderLiveOrderUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(332283);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.a
 * JD-Core Version:    0.7.0.1
 */