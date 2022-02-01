package com.tencent.mm.plugin.finder.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveOperationUI;
import com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageUI;
import com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveMoreUI;
import com.tencent.mm.plugin.finder.nearby.trace.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter;", "", "()V", "enterFinderLbsLiveFriendsUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterFinderLiveFindPageUI", "enterFinderLiveOperationUI", "enterNearbyLiveMoreUI", "plugin-finder-nearby_release"})
public final class a
{
  public static final a zCs;
  
  static
  {
    AppMethodBeat.i(199366);
    zCs = new a();
    AppMethodBeat.o(199366);
  }
  
  public static void enterFinderLbsLiveFriendsUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199356);
    p.k(paramContext, "context");
    Object localObject = c.zJD;
    c.dMD().fo("clickEnter");
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    paramIntent = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
    com.tencent.mm.plugin.finder.nearby.preload.a.al((Intent)localObject);
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = (Intent)localObject;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      ((Intent)localObject).setClass(paramContext, NearbyUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLbsLiveFriendsUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLbsLiveFriendsUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(199356);
      return;
    }
  }
  
  public static void enterFinderLiveOperationUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199364);
    p.k(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLiveOperationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLiveOperationUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(199364);
      return;
    }
  }
  
  public static void enterNearbyLiveMoreUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199360);
    p.k(paramContext, "context");
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterNearbyLiveMoreUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterNearbyLiveMoreUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(199360);
      return;
    }
  }
  
  public static void u(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199361);
    p.k(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
    com.tencent.mm.plugin.finder.nearby.preload.a.al(localIntent);
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderLiveFindPageUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLiveFindPageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/nearby/FinderNearByActivityRouter", "enterFinderLiveFindPageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(199361);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.a
 * JD-Core Version:    0.7.0.1
 */