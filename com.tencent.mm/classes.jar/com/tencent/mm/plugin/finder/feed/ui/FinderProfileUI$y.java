package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.ui.base.n.d;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class FinderProfileUI$y
  implements n.d
{
  FinderProfileUI$y(FinderProfileUI paramFinderProfileUI, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(198535);
    Intent localIntent = new Intent();
    k.g(paramMenuItem, "menuItem");
    if (paramMenuItem.getItemId() == FinderProfileUI.i(this.qAW)) {
      localIntent.putExtra("key_finder_post_router", 2);
    }
    for (;;)
    {
      localIntent.putExtra("key_finder_post_from", 1);
      localIntent.putExtra("key_finder_post_id", this.KSK);
      paramMenuItem = a.qSb;
      paramMenuItem = this.qAW.getContext();
      k.g(paramMenuItem, "context");
      a.v((Context)paramMenuItem, localIntent);
      AppMethodBeat.o(198535);
      return;
      if (paramMenuItem.getItemId() == FinderProfileUI.j(this.qAW)) {
        localIntent.putExtra("key_finder_post_router", 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI.y
 * JD-Core Version:    0.7.0.1
 */