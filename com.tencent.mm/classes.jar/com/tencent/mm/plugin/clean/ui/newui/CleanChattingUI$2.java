package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CleanChattingUI$2
  implements AdapterView.OnItemClickListener
{
  CleanChattingUI$2(CleanChattingUI paramCleanChattingUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(18875);
    paramAdapterView = new Intent(this.kJl, CleanChattingDetailUI.class);
    paramAdapterView.putExtra("key_position", paramInt);
    this.kJl.startActivityForResult(paramAdapterView, 0);
    AppMethodBeat.o(18875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI.2
 * JD-Core Version:    0.7.0.1
 */