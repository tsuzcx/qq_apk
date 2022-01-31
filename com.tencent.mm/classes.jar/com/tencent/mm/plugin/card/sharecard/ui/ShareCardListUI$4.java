package com.tencent.mm.plugin.card.sharecard.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.y;

final class ShareCardListUI$4
  implements AbsListView.OnScrollListener
{
  ShareCardListUI$4(ShareCardListUI paramShareCardListUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (!ShareCardListUI.g(this.iqI)) && (ShareCardListUI.d(this.iqI) != 4))
    {
      y.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
      ShareCardListUI.h(this.iqI);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.4
 * JD-Core Version:    0.7.0.1
 */