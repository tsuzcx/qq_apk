package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.protocal.c.aoq;

final class ExdeviceBindDeviceUI$5
  implements AdapterView.OnItemClickListener
{
  ExdeviceBindDeviceUI$5(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = ((ListView)paramAdapterView).getHeaderViewsCount();
    paramAdapterView = ExdeviceBindDeviceUI.a(this.jBw).qt(paramInt - i);
    if (paramAdapterView.jBU.cMX != 0)
    {
      ExdeviceBindDeviceUI.a(this.jBw, paramAdapterView);
      return;
    }
    ExdeviceBindDeviceUI.b(this.jBw, paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.5
 * JD-Core Version:    0.7.0.1
 */