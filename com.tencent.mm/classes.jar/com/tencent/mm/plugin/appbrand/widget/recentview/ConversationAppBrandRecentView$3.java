package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class ConversationAppBrandRecentView$3
  implements Runnable
{
  ConversationAppBrandRecentView$3(ConversationAppBrandRecentView paramConversationAppBrandRecentView) {}
  
  public final void run()
  {
    AppMethodBeat.i(134363);
    Object localObject = this.jvI;
    if (((BaseAppBrandRecentView)localObject).jvk)
    {
      int i = ((BaseAppBrandRecentView)localObject).jvg.size();
      if ((i - 1 < ((BaseAppBrandRecentView)localObject).jfV.size()) && ((a)((BaseAppBrandRecentView)localObject).jfV.get(i - 1) != null))
      {
        ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo addCacheItemAtLast pos: %d", new Object[] { Integer.valueOf(i) });
        ((BaseAppBrandRecentView)localObject).jvg.add(i, ((BaseAppBrandRecentView)localObject).jfV.get(i - 1));
        ((BaseAppBrandRecentView)localObject).getAdapter().bS(i);
        ((BaseAppBrandRecentView)localObject).getAdapter().an(i, 5);
      }
    }
    if (this.jvI.getOnDataChangedListener() != null)
    {
      localObject = this.jvI.getOnDataChangedListener();
      this.jvI.getPreviewItemList().size();
      ((AppBrandRecentView.d)localObject).aQm();
    }
    AppMethodBeat.o(134363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.3
 * JD-Core Version:    0.7.0.1
 */