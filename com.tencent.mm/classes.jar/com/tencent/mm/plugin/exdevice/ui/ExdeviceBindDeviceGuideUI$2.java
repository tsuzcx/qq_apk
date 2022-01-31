package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ExdeviceBindDeviceGuideUI$2
  implements View.OnClickListener
{
  ExdeviceBindDeviceGuideUI$2(ExdeviceBindDeviceGuideUI paramExdeviceBindDeviceGuideUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.a(this.jBe));
    paramView.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.b(this.jBe));
    paramView.putExtra("device_id", ExdeviceBindDeviceGuideUI.c(this.jBe));
    paramView.putExtra("device_type", ExdeviceBindDeviceGuideUI.d(this.jBe));
    paramView.putExtra("device_title", ExdeviceBindDeviceGuideUI.e(this.jBe));
    paramView.putExtra("device_desc", ExdeviceBindDeviceGuideUI.f(this.jBe));
    paramView.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.g(this.jBe));
    paramView.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.h(this.jBe));
    paramView.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.i(this.jBe));
    paramView.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.j(this.jBe));
    paramView.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.k(this.jBe));
    paramView.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.l(this.jBe));
    paramView.putExtra("jumpToBindDevice", true);
    if ((ExdeviceBindDeviceGuideUI.m(this.jBe)) && (!ExdeviceBindDeviceGuideUI.n(this.jBe))) {
      d.b(this.jBe.mController.uMN, "exdevice", ".ui.ExdeviceBindDeviceUI", paramView);
    }
    while ((!ExdeviceBindDeviceGuideUI.n(this.jBe)) || (ExdeviceBindDeviceGuideUI.m(this.jBe))) {
      return;
    }
    paramView.putExtra("exdevice_airkiss_open_type", 2);
    d.b(this.jBe.mController.uMN, "exdevice", ".ui.ExdeviceConnectWifiUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.2
 * JD-Core Version:    0.7.0.1
 */