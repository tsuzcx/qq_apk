package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CollectBillListUI$7
  implements AdapterView.OnItemClickListener
{
  CollectBillListUI$7(CollectBillListUI paramCollectBillListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt < 0) || (paramInt >= paramAdapterView.getAdapter().getCount())) {
      return;
    }
    paramView = new Intent(this.iKn.mController.uMN, CollectBillUI.class);
    paramAdapterView = (com.tencent.mm.plugin.collect.b.h)paramAdapterView.getItemAtPosition(paramInt);
    if (paramAdapterView == null)
    {
      y.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramView.putExtra("key_type", paramAdapterView.type);
    paramView.putExtra("key_timestamp", paramAdapterView.iHh);
    paramView.putExtra("key_from_scene", 2);
    this.iKn.startActivity(paramView);
    com.tencent.mm.plugin.report.service.h.nFQ.f(13944, new Object[] { Integer.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.7
 * JD-Core Version:    0.7.0.1
 */