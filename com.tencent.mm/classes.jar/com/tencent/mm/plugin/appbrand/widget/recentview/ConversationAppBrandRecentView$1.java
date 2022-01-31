package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationAppBrandRecentView$1
  implements AppBrandRecentView.b
{
  ConversationAppBrandRecentView$1(ConversationAppBrandRecentView paramConversationAppBrandRecentView) {}
  
  public final boolean a(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    if (ConversationAppBrandRecentView.a(this.hDh) != null) {
      ConversationAppBrandRecentView.a(this.hDh).a(paramView, parama, paramFloat1, paramFloat2);
    }
    if (parama.type == 0)
    {
      ((f)g.r(f.class)).b(this.hDh.getContext(), 13, false);
      return false;
    }
    this.hDh.setLayoutFrozen(true);
    paramView = new AppBrandStatObject();
    if (this.hDh.hrp == AppBrandRecentView.f.hBY) {}
    for (int i = 1104;; i = 1089)
    {
      paramView.scene = i;
      ((d)g.r(d.class)).a(this.hDh.getContext(), parama.hqw.username, null, parama.hqw.fJy, -1, null, paramView);
      return false;
    }
  }
  
  public final boolean b(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    if (ConversationAppBrandRecentView.a(this.hDh) != null) {
      ConversationAppBrandRecentView.a(this.hDh).b(paramView, parama, paramFloat1, paramFloat2);
    }
    y.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", new Object[] { Float.valueOf(paramFloat1) });
    if (parama.type != 0) {
      new com.tencent.mm.ui.widget.b.a(this.hDh.getContext()).a(paramView, new ConversationAppBrandRecentView.1.1(this), new ConversationAppBrandRecentView.1.2(this, parama), (int)paramFloat1, (int)paramFloat2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.1
 * JD-Core Version:    0.7.0.1
 */