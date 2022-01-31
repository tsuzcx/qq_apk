package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class MassSendHistoryUI$6
  implements MMPullDownView.c
{
  MassSendHistoryUI$6(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean aEW()
  {
    return (MassSendHistoryUI.d(this.mbC).getChildAt(MassSendHistoryUI.d(this.mbC).getChildCount() - 1).getBottom() <= MassSendHistoryUI.d(this.mbC).getHeight()) && (MassSendHistoryUI.d(this.mbC).getLastVisiblePosition() == MassSendHistoryUI.d(this.mbC).getAdapter().getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.6
 * JD-Core Version:    0.7.0.1
 */