package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfk;

final class ExdeviceBindDeviceUI$5
  implements AdapterView.OnItemClickListener
{
  ExdeviceBindDeviceUI$5(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23897);
    int i = ((ListView)paramAdapterView).getHeaderViewsCount();
    paramAdapterView = ExdeviceBindDeviceUI.a(this.pbF).Be(paramInt - i);
    if (paramAdapterView.pcd.eKr != 0)
    {
      ExdeviceBindDeviceUI.a(this.pbF, paramAdapterView);
      AppMethodBeat.o(23897);
      return;
    }
    ExdeviceBindDeviceUI.b(this.pbF, paramAdapterView);
    AppMethodBeat.o(23897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.5
 * JD-Core Version:    0.7.0.1
 */