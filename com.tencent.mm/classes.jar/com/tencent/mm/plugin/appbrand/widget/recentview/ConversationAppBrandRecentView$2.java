package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.sdk.platformtools.y;

final class ConversationAppBrandRecentView$2
  implements e.a
{
  ConversationAppBrandRecentView$2(ConversationAppBrandRecentView paramConversationAppBrandRecentView) {}
  
  public final void G(int paramInt, boolean paramBoolean)
  {
    if (ConversationAppBrandRecentView.f(this.hDh) != null) {
      ConversationAppBrandRecentView.f(this.hDh).G(paramInt, paramBoolean);
    }
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (ConversationAppBrandRecentView.f(this.hDh) != null) {
      ConversationAppBrandRecentView.f(this.hDh).d(paramRecyclerView, paramInt1, paramInt2);
    }
  }
  
  public final void e(RecyclerView paramRecyclerView, int paramInt)
  {
    y.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hDh.getCurrentPage()) });
    ConversationAppBrandRecentView.e(this.hDh);
    if (ConversationAppBrandRecentView.f(this.hDh) != null) {
      ConversationAppBrandRecentView.f(this.hDh).e(paramRecyclerView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.2
 * JD-Core Version:    0.7.0.1
 */