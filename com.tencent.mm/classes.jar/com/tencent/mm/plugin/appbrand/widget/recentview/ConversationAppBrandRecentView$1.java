package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationAppBrandRecentView$1
  implements AppBrandRecentView.b
{
  ConversationAppBrandRecentView$1(ConversationAppBrandRecentView paramConversationAppBrandRecentView) {}
  
  public final boolean a(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134358);
    if (ConversationAppBrandRecentView.a(this.jvI) != null) {
      ConversationAppBrandRecentView.a(this.jvI).a(paramView, parama, paramFloat1, paramFloat2);
    }
    if (parama.type == 0)
    {
      ((l)g.E(l.class)).c(this.jvI.getContext(), 13, false);
      AppMethodBeat.o(134358);
      return false;
    }
    this.jvI.setLayoutFrozen(true);
    paramView = new AppBrandStatObject();
    if (this.jvI.jhO == AppBrandRecentView.f.jur) {}
    for (int i = 1104;; i = 1089)
    {
      paramView.scene = i;
      ((j)g.E(j.class)).a(this.jvI.getContext(), parama.jfk.username, null, parama.jfk.hcr, -1, null, paramView);
      break;
    }
  }
  
  public final boolean b(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134359);
    if (ConversationAppBrandRecentView.a(this.jvI) != null) {
      ConversationAppBrandRecentView.a(this.jvI).b(paramView, parama, paramFloat1, paramFloat2);
    }
    ab.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", new Object[] { Float.valueOf(paramFloat1) });
    if (parama.type != 0) {
      new com.tencent.mm.ui.widget.c.a(this.jvI.getContext()).a(paramView, new ConversationAppBrandRecentView.1.1(this), new ConversationAppBrandRecentView.1.2(this, parama), (int)paramFloat1, (int)paramFloat2);
    }
    AppMethodBeat.o(134359);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.1
 * JD-Core Version:    0.7.0.1
 */