package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.collect.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CollectBillUI$3
  implements AdapterView.OnItemClickListener
{
  CollectBillUI$3(CollectBillUI paramCollectBillUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramInt >= paramAdapterView.getAdapter().getCount()))
    {
      y.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramAdapterView.getAdapter().getCount()) });
      return;
    }
    paramAdapterView = (a)CollectBillUI.b(this.iKD).getItemAtPosition(paramInt);
    if (paramAdapterView == null)
    {
      y.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramView = new Intent();
    paramView.putExtra("scene", 2);
    paramView.putExtra("trans_id", paramAdapterView.iGK);
    paramView.putExtra("bill_id", paramAdapterView.iGJ);
    d.b(this.iKD.mController.uMN, "order", ".ui.MallOrderTransactionInfoUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.3
 * JD-Core Version:    0.7.0.1
 */