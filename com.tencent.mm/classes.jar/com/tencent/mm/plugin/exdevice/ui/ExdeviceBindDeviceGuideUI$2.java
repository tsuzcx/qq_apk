package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class ExdeviceBindDeviceGuideUI$2
  implements View.OnClickListener
{
  ExdeviceBindDeviceGuideUI$2(ExdeviceBindDeviceGuideUI paramExdeviceBindDeviceGuideUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(19812);
    paramView = new Intent();
    paramView.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.a(this.lKD));
    paramView.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.b(this.lKD));
    paramView.putExtra("device_id", ExdeviceBindDeviceGuideUI.c(this.lKD));
    paramView.putExtra("device_type", ExdeviceBindDeviceGuideUI.d(this.lKD));
    paramView.putExtra("device_title", ExdeviceBindDeviceGuideUI.e(this.lKD));
    paramView.putExtra("device_desc", ExdeviceBindDeviceGuideUI.f(this.lKD));
    paramView.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.g(this.lKD));
    paramView.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.h(this.lKD));
    paramView.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.i(this.lKD));
    paramView.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.j(this.lKD));
    paramView.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.k(this.lKD));
    paramView.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.l(this.lKD));
    paramView.putExtra("jumpToBindDevice", true);
    if ((ExdeviceBindDeviceGuideUI.m(this.lKD)) && (!ExdeviceBindDeviceGuideUI.n(this.lKD)))
    {
      d.b(this.lKD.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramView);
      AppMethodBeat.o(19812);
      return;
    }
    if ((ExdeviceBindDeviceGuideUI.n(this.lKD)) && (!ExdeviceBindDeviceGuideUI.m(this.lKD)))
    {
      paramView.putExtra("exdevice_airkiss_open_type", 2);
      d.b(this.lKD.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", paramView);
    }
    AppMethodBeat.o(19812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.2
 * JD-Core Version:    0.7.0.1
 */