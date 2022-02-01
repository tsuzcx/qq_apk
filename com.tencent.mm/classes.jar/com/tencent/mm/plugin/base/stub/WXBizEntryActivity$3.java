package com.tencent.mm.plugin.base.stub;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class WXBizEntryActivity$3
  implements Runnable
{
  WXBizEntryActivity$3(WXBizEntryActivity paramWXBizEntryActivity, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(269048);
    View localView = this.vru.findViewById(R.h.fOj);
    if (localView != null) {
      if (!this.txz) {
        break label40;
      }
    }
    label40:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(269048);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.3
 * JD-Core Version:    0.7.0.1
 */