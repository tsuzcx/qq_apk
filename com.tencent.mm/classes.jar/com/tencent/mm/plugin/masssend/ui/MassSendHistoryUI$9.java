package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MassSendHistoryUI$9
  implements AdapterView.OnItemClickListener
{
  MassSendHistoryUI$9(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22802);
    ab.v("MicroMsg.MassSendHistoryUI", "onItemClick");
    AppMethodBeat.o(22802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.9
 * JD-Core Version:    0.7.0.1
 */