package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aui;

final class ExdeviceBindDeviceUI$5
  implements AdapterView.OnItemClickListener
{
  ExdeviceBindDeviceUI$5(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(19829);
    int i = ((ListView)paramAdapterView).getHeaderViewsCount();
    paramAdapterView = ExdeviceBindDeviceUI.a(this.lKV).va(paramInt - i);
    if (paramAdapterView.lLt.dCN != 0)
    {
      ExdeviceBindDeviceUI.a(this.lKV, paramAdapterView);
      AppMethodBeat.o(19829);
      return;
    }
    ExdeviceBindDeviceUI.b(this.lKV, paramAdapterView);
    AppMethodBeat.o(19829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.5
 * JD-Core Version:    0.7.0.1
 */