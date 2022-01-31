package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class ConversationAppBrandRecentView$1$2
  implements n.d
{
  ConversationAppBrandRecentView$1$2(ConversationAppBrandRecentView.1 param1, a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(134357);
    if (ConversationAppBrandRecentView.c(this.jvJ.jvI) != null) {
      ConversationAppBrandRecentView.c(this.jvJ.jvI).a(paramMenuItem, this.jio.position, this.jio);
    }
    if ((paramMenuItem.getItemId() == 1) && (this.jio.position >= 0))
    {
      ConversationAppBrandRecentView.d(this.jvJ.jvI);
      ab.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s, mType: %s", new Object[] { Integer.valueOf(this.jio.position), this.jvJ.jvI.jhO });
      if (this.jvJ.jvI.jhO != AppBrandRecentView.f.juq) {
        break label223;
      }
      ((ag)g.E(ag.class)).aF(this.jio.jfk.username, this.jio.jfk.hcr);
    }
    for (;;)
    {
      ab.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo Delete %s, pos: %d", new Object[] { this.jio.jfk.nickname, Integer.valueOf(this.jio.position) });
      this.jvJ.jvI.qP(this.jio.position);
      AppMethodBeat.o(134357);
      return;
      label223:
      if (this.jvJ.jvI.jhO == AppBrandRecentView.f.jur) {
        ((af)g.E(af.class)).aE(this.jio.jfk.username, this.jio.jfk.hcr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.1.2
 * JD-Core Version:    0.7.0.1
 */