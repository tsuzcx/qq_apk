package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class CollectBillUI$4
  implements AdapterView.OnItemLongClickListener
{
  CollectBillUI$4(CollectBillUI paramCollectBillUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramInt >= paramAdapterView.getAdapter().getCount()))
    {
      y.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramAdapterView.getAdapter().getCount()) });
      return false;
    }
    CollectBillUI.i(this.iKD).a(paramView, paramInt, paramLong, this.iKD, CollectBillUI.h(this.iKD));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.4
 * JD-Core Version:    0.7.0.1
 */