package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class CollectBillUI$4
  implements AdapterView.OnItemLongClickListener
{
  CollectBillUI$4(CollectBillUI paramCollectBillUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(41214);
    if ((paramInt < 0) || (paramInt >= paramAdapterView.getAdapter().getCount()))
    {
      ab.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramAdapterView.getAdapter().getCount()) });
      AppMethodBeat.o(41214);
      return false;
    }
    CollectBillUI.i(this.kRi).a(paramView, paramInt, paramLong, this.kRi, CollectBillUI.h(this.kRi));
    AppMethodBeat.o(41214);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.4
 * JD-Core Version:    0.7.0.1
 */