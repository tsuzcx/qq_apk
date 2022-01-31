package com.tencent.mm.plugin.brandservice.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizSearchResultItemContainer$2
  implements Runnable
{
  BizSearchResultItemContainer$2(BizSearchResultItemContainer paramBizSearchResultItemContainer) {}
  
  public final void run()
  {
    AppMethodBeat.i(13899);
    TextView localTextView = BizSearchResultItemContainer.e(this.jTO);
    if (BizSearchResultItemContainer.d(this.jTO).isEmpty()) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(13899);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.2
 * JD-Core Version:    0.7.0.1
 */