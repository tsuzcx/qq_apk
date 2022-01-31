package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallCountryCodeSelectUI$5
  implements AdapterView.OnItemClickListener
{
  IPCallCountryCodeSelectUI$5(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22116);
    paramAdapterView = new Intent();
    if (paramInt >= IPCallCountryCodeSelectUI.b(this.nSK).getHeaderViewsCount())
    {
      paramView = (a)IPCallCountryCodeSelectUI.c(this.nSK).getItem(paramInt - IPCallCountryCodeSelectUI.b(this.nSK).getHeaderViewsCount());
      paramAdapterView.putExtra("country_name", paramView.fHT);
      paramAdapterView.putExtra("couttry_code", paramView.countryCode);
      this.nSK.setResult(100, paramAdapterView);
    }
    this.nSK.finish();
    AppMethodBeat.o(22116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.5
 * JD-Core Version:    0.7.0.1
 */