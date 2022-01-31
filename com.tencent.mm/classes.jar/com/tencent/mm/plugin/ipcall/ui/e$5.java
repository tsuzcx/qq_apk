package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.ui.tools.j;

final class e$5
  implements AdapterView.OnItemLongClickListener
{
  e$5(e parame) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = this.lup.lug;
    if (paramView.lxo == null) {
      paramView.lxo = m.bcO();
    }
    paramView = this.lup.lug.sQ(paramInt - ((ListView)paramAdapterView).getHeaderViewsCount());
    e locale = this.lup;
    int i = ((ListView)paramAdapterView).getHeaderViewsCount();
    if (paramView != null)
    {
      paramAdapterView = new j(locale.lui);
      paramAdapterView.phH = new e.8(locale);
      paramAdapterView.phI = new e.9(locale, paramView, paramInt - i);
      paramAdapterView.bJQ();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.5
 * JD-Core Version:    0.7.0.1
 */