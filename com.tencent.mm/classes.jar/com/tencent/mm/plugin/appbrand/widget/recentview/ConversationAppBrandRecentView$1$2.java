package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.MenuItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class ConversationAppBrandRecentView$1$2
  implements n.d
{
  ConversationAppBrandRecentView$1$2(ConversationAppBrandRecentView.1 param1, a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (ConversationAppBrandRecentView.c(this.hDi.hDh) != null) {
      ConversationAppBrandRecentView.c(this.hDi.hDh).a(paramMenuItem, this.hrS.position, this.hrS);
    }
    if ((paramMenuItem.getItemId() == 1) && (this.hrS.position >= 0))
    {
      ConversationAppBrandRecentView.d(this.hDi.hDh);
      y.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s, mType: %s", new Object[] { Integer.valueOf(this.hrS.position), this.hDi.hDh.hrp });
      if (this.hDi.hDh.hrp != AppBrandRecentView.f.hBX) {
        break label213;
      }
      ((ag)g.r(ag.class)).as(this.hrS.hqw.username, this.hrS.hqw.fJy);
    }
    for (;;)
    {
      y.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo Delete %s, pos: %d", new Object[] { this.hrS.hqw.nickname, Integer.valueOf(this.hrS.position) });
      this.hDi.hDh.ni(this.hrS.position);
      return;
      label213:
      if (this.hDi.hDh.hrp == AppBrandRecentView.f.hBY) {
        ((af)g.r(af.class)).ar(this.hrS.hqw.username, this.hrS.hqw.fJy);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.1.2
 * JD-Core Version:    0.7.0.1
 */