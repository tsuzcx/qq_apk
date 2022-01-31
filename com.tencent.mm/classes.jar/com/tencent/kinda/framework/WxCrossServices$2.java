package com.tencent.kinda.framework;

import android.content.Intent;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

class WxCrossServices$2
  implements UseCaseCallback
{
  WxCrossServices$2(WxCrossServices paramWxCrossServices, KindaJSEvent paramKindaJSEvent, MMActivity.a parama, int paramInt) {}
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    int i = 0;
    AppMethodBeat.i(144240);
    String str2 = "get_brand_wcpay_request:cancel";
    String str1 = str2;
    if (paramITransmitKvData != null)
    {
      str1 = str2;
      if (paramITransmitKvData.getString("result").length() > 0) {
        str1 = paramITransmitKvData.getString("result");
      }
    }
    paramITransmitKvData = new Intent();
    if (str1.endsWith("ok")) {
      if (this.val$jsEvent.shouldClosePage())
      {
        i = 1;
        paramITransmitKvData.putExtra("key_jsapi_close_page_after_pay", i);
        i = -1;
      }
    }
    for (;;)
    {
      if (this.val$onActivityResult != null) {
        this.val$onActivityResult.c(this.val$requestCode, i, paramITransmitKvData);
      }
      AppMethodBeat.o(144240);
      return;
      i = 0;
      break;
      if (str1.endsWith("fail"))
      {
        i = 5;
        paramITransmitKvData.putExtra("key_jsapi_pay_err_code", (String)this.val$jsEvent.mExtraInfo.get("err_code"));
        paramITransmitKvData.putExtra("key_jsapi_pay_err_msg", (String)this.val$jsEvent.mExtraInfo.get("err_desc"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.2
 * JD-Core Version:    0.7.0.1
 */