package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.ui.tools.l;

final class e$5
  implements AdapterView.OnItemLongClickListener
{
  e$5(e parame) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22037);
    paramView = this.nRH.nRy;
    if (paramView.nUB == null) {
      paramView.nUB = m.bJX();
    }
    paramView = this.nRH.nRy.xS(paramInt - ((ListView)paramAdapterView).getHeaderViewsCount());
    e locale = this.nRH;
    int i = ((ListView)paramAdapterView).getHeaderViewsCount();
    if (paramView != null)
    {
      paramAdapterView = new l(locale.nRA);
      paramAdapterView.sao = new e.8(locale);
      paramAdapterView.sap = new e.9(locale, paramView, paramInt - i);
      paramAdapterView.cwt();
    }
    AppMethodBeat.o(22037);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.5
 * JD-Core Version:    0.7.0.1
 */