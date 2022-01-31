package com.tencent.kinda.framework;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.p;

class WxCrossServices$6
  implements UseCaseCallback
{
  WxCrossServices$6(WxCrossServices paramWxCrossServices) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144243);
    if (WxCrossServices.access$000(this.this$0) != null)
    {
      d.d("tag_scan_qrcode_pay", "扫码支付关闭正在加载进度框。");
      WxCrossServices.access$000(this.this$0).dismiss();
      WxCrossServices.access$002(this.this$0, null);
    }
    vk localvk = new vk();
    localvk.cMA.result = paramITransmitKvData.getInt("scanQRCodeState");
    localvk.cMA.cMC = true;
    a.ymk.l(localvk);
    AppMethodBeat.o(144243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.6
 * JD-Core Version:    0.7.0.1
 */