package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.collect.model.a;
import com.tencent.mm.sdk.platformtools.ab;

final class CollectBillUI$3
  implements AdapterView.OnItemClickListener
{
  CollectBillUI$3(CollectBillUI paramCollectBillUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(41213);
    if ((paramInt < 0) || (paramInt >= paramAdapterView.getAdapter().getCount()))
    {
      ab.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramAdapterView.getAdapter().getCount()) });
      AppMethodBeat.o(41213);
      return;
    }
    paramAdapterView = (a)CollectBillUI.b(this.kRi).getItemAtPosition(paramInt);
    if (paramAdapterView == null)
    {
      ab.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(41213);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("scene", 2);
    paramView.putExtra("trans_id", paramAdapterView.kMN);
    paramView.putExtra("bill_id", paramAdapterView.kMM);
    d.b(this.kRi.getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramView);
    AppMethodBeat.o(41213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.3
 * JD-Core Version:    0.7.0.1
 */