package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class CleanChattingUI$2
  implements AdapterView.OnItemClickListener
{
  CleanChattingUI$2(CleanChattingUI paramCleanChattingUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(18779);
    paramAdapterView = CleanChattingUI.a(this.kIi).tA(paramInt);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this.kIi, CleanChattingDetailUI.class);
      paramView.putExtra("key_username", paramAdapterView.username);
      paramView.putExtra("key_pos", paramInt);
      this.kIi.startActivityForResult(paramView, 0);
      h.qsU.idkeyStat(714L, 21L, 1L, false);
    }
    AppMethodBeat.o(18779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.2
 * JD-Core Version:    0.7.0.1
 */