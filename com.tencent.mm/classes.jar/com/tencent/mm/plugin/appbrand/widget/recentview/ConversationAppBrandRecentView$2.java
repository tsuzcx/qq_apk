package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class ConversationAppBrandRecentView$2
  implements e.a
{
  ConversationAppBrandRecentView$2(ConversationAppBrandRecentView paramConversationAppBrandRecentView) {}
  
  public final void M(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(49981);
    if (ConversationAppBrandRecentView.f(this.mlU) != null) {
      ConversationAppBrandRecentView.f(this.mlU).M(paramInt, paramBoolean);
    }
    AppMethodBeat.o(49981);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(49980);
    ad.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mlU.getCurrentPage()) });
    ConversationAppBrandRecentView.e(this.mlU);
    if (ConversationAppBrandRecentView.f(this.mlU) != null) {
      ConversationAppBrandRecentView.f(this.mlU).d(paramRecyclerView, paramInt);
    }
    AppMethodBeat.o(49980);
  }
  
  public final void h(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49982);
    if (ConversationAppBrandRecentView.f(this.mlU) != null) {
      ConversationAppBrandRecentView.f(this.mlU).h(paramRecyclerView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(49982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.2
 * JD-Core Version:    0.7.0.1
 */