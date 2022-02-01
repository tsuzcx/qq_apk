package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.ui.tools.l;

final class e$5
  implements AdapterView.OnItemLongClickListener
{
  e$5(e parame) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25653);
    paramView = this.uPW.uPN;
    if (paramView.uSO == null) {
      paramView.uSO = m.dep();
    }
    paramView = this.uPW.uPN.IL(paramInt - ((ListView)paramAdapterView).getHeaderViewsCount());
    e locale = this.uPW;
    int i = ((ListView)paramAdapterView).getHeaderViewsCount();
    if (paramView != null)
    {
      paramAdapterView = new l(locale.uPP);
      paramAdapterView.KJy = new e.8(locale);
      paramAdapterView.KJz = new e.9(locale, paramView, paramInt - i);
      paramAdapterView.fKy();
    }
    AppMethodBeat.o(25653);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.5
 * JD-Core Version:    0.7.0.1
 */