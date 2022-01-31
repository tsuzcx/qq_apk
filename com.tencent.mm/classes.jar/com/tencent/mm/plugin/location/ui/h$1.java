package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class h$1
  implements AdapterView.OnItemClickListener
{
  h$1(h paramh) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(113492);
    paramAdapterView = (String)paramView.getTag();
    if (!bo.isNullOrNil(paramAdapterView))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { "15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if (this.odd.odc != null) {
        this.odd.odc.Sh(paramAdapterView);
      }
    }
    AppMethodBeat.o(113492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h.1
 * JD-Core Version:    0.7.0.1
 */