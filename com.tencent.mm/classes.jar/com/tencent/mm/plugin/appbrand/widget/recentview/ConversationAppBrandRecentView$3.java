package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class ConversationAppBrandRecentView$3
  implements Runnable
{
  ConversationAppBrandRecentView$3(ConversationAppBrandRecentView paramConversationAppBrandRecentView) {}
  
  public final void run()
  {
    Object localObject = this.hDh;
    if (((BaseAppBrandRecentView)localObject).hCI)
    {
      int i = ((BaseAppBrandRecentView)localObject).hCE.size();
      if ((i - 1 < ((BaseAppBrandRecentView)localObject).heL.size()) && ((a)((BaseAppBrandRecentView)localObject).heL.get(i - 1) != null))
      {
        y.i("MicroMsg.BaseAppBrandRecentView", "alvinluo addCacheItemAtLast pos: %d", new Object[] { Integer.valueOf(i) });
        ((BaseAppBrandRecentView)localObject).hCE.add(i, ((BaseAppBrandRecentView)localObject).heL.get(i - 1));
        ((BaseAppBrandRecentView)localObject).getAdapter().bM(i);
        ((BaseAppBrandRecentView)localObject).getAdapter().ah(i, 5);
      }
    }
    if (this.hDh.getOnDataChangedListener() != null)
    {
      localObject = this.hDh.getOnDataChangedListener();
      this.hDh.getPreviewItemList().size();
      ((AppBrandRecentView.d)localObject).arB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.3
 * JD-Core Version:    0.7.0.1
 */