package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationAppBrandRecentView$2
  implements e.a
{
  ConversationAppBrandRecentView$2(ConversationAppBrandRecentView paramConversationAppBrandRecentView) {}
  
  public final void L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134361);
    if (ConversationAppBrandRecentView.f(this.jvI) != null) {
      ConversationAppBrandRecentView.f(this.jvI).L(paramInt, paramBoolean);
    }
    AppMethodBeat.o(134361);
  }
  
  public final void e(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(134360);
    ab.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jvI.getCurrentPage()) });
    ConversationAppBrandRecentView.e(this.jvI);
    if (ConversationAppBrandRecentView.f(this.jvI) != null) {
      ConversationAppBrandRecentView.f(this.jvI).e(paramRecyclerView, paramInt);
    }
    AppMethodBeat.o(134360);
  }
  
  public final void h(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134362);
    if (ConversationAppBrandRecentView.f(this.jvI) != null) {
      ConversationAppBrandRecentView.f(this.jvI).h(paramRecyclerView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(134362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.2
 * JD-Core Version:    0.7.0.1
 */