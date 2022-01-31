package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;

final class h$1
  implements AdapterView.OnItemClickListener
{
  h$1(h paramh) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)paramView.getTag();
    if (!bk.bl(paramAdapterView))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(10997, new Object[] { "15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if (this.lFQ.lFP != null) {
        this.lFQ.lFP.GE(paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h.1
 * JD-Core Version:    0.7.0.1
 */