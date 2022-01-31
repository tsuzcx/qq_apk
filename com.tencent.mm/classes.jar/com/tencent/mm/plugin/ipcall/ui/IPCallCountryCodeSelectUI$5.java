package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

final class IPCallCountryCodeSelectUI$5
  implements AdapterView.OnItemClickListener
{
  IPCallCountryCodeSelectUI$5(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = new Intent();
    if (paramInt >= IPCallCountryCodeSelectUI.b(this.lvu).getHeaderViewsCount())
    {
      paramView = (a)IPCallCountryCodeSelectUI.c(this.lvu).getItem(paramInt - IPCallCountryCodeSelectUI.b(this.lvu).getHeaderViewsCount());
      paramAdapterView.putExtra("country_name", paramView.esg);
      paramAdapterView.putExtra("couttry_code", paramView.countryCode);
      this.lvu.setResult(100, paramAdapterView);
    }
    this.lvu.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.5
 * JD-Core Version:    0.7.0.1
 */