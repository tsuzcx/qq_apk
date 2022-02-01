package com.tencent.mm.plugin.finder.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveOperationUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15;
import com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageUI;
import com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveMoreUI;
import com.tencent.mm.plugin.finder.nearby.report.b;
import com.tencent.mm.plugin.finder.nearby.trace.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter;", "", "()V", "enterFinderLbsLiveFriendsUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterFinderLiveFindPageUI", "enterFinderLiveOperationUI", "enterLiveEntranceUI", "enterNearbyLiveMoreUI", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EFh;
  
  static
  {
    AppMethodBeat.i(339610);
    EFh = new a();
    AppMethodBeat.o(339610);
  }
  
  public static void O(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(339587);
    s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
    com.tencent.mm.plugin.finder.nearby.preload.a.aA(localIntent);
    paramIntent = b.EQs;
    b.sS(true);
    paramIntent = b.EQs;
    if (!b.eGH()) {
      com.tencent.mm.plugin.finder.nearby.preload.a.EPD.a(localIntent, 88890, 0, "推荐");
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderLiveFindPageUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLiveFindPageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLiveFindPageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(339587);
      return;
    }
  }
  
  public static void P(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(339594);
    s.u(paramContext, "context");
    ((com.tencent.d.a.b.a.b.a)h.ax(com.tencent.d.a.b.a.b.a.class)).sV(true);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, OccupyFinderUI15.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterLiveEntranceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterLiveEntranceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(339594);
      return;
    }
  }
  
  public static void enterFinderLbsLiveFriendsUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(339570);
    s.u(paramContext, "context");
    Object localObject = c.ERD;
    c.eGR().gF("clickEnter");
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    paramIntent = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
    com.tencent.mm.plugin.finder.nearby.preload.a.aA((Intent)localObject);
    paramIntent = b.EQs;
    paramIntent = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    b.aj(true, com.tencent.mm.plugin.finder.nearby.abtest.a.eEi());
    paramIntent = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      com.tencent.mm.plugin.finder.nearby.preload.a.EPD.a((Intent)localObject, 88889, 0, "同城直播");
      if ((paramContext instanceof Activity)) {
        break label201;
      }
    }
    label201:
    for (paramIntent = (Intent)localObject;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      ((Intent)localObject).setClass(paramContext, NearbyUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLbsLiveFriendsUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLbsLiveFriendsUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(339570);
      return;
      paramIntent = b.EQs;
      if (b.eGH()) {
        break;
      }
      com.tencent.mm.plugin.finder.nearby.preload.a.EPD.a((Intent)localObject, 88890, 0, "推荐");
      break;
    }
  }
  
  public static void enterFinderLiveOperationUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(339600);
    s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderLiveOperationUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLiveOperationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLiveOperationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(339600);
      return;
    }
  }
  
  public static void enterNearbyLiveMoreUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(339579);
    s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, NearbyLiveMoreUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterNearbyLiveMoreUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterNearbyLiveMoreUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(339579);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.a
 * JD-Core Version:    0.7.0.1
 */