package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class aq$1
  implements MMActivity.a
{
  aq$1(aq paramaq, o paramo, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    aq.BF();
    if (paramInt1 != (this.ggK.hashCode() & 0xFFFF)) {
      return;
    }
    y.i("MicroMsg.JsApiOpenQRCode", "onActivityResult requestCode:%d  resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt2)
    {
    default: 
      this.gcp.C(this.dIS, this.ggK.h("fail", null));
      return;
    case -1: 
      if (paramIntent == null)
      {
        y.e("MicroMsg.JsApiOpenQRCode", "data is null, err");
        this.gcp.C(this.dIS, this.ggK.h("fail:unknown err", null));
        return;
      }
      HashMap localHashMap = new HashMap();
      String str = paramIntent.getStringExtra("key_scan_result");
      paramInt1 = paramIntent.getIntExtra("key_scan_result_type", 0);
      y.d("MicroMsg.JsApiOpenQRCode", "result:%s, resultType:%d", new Object[] { str, Integer.valueOf(paramInt1) });
      JSONObject localJSONObject = new JSONObject();
      if (paramInt1 == 1) {
        paramIntent = "qrcode";
      }
      try
      {
        localJSONObject.put("scan_type", paramIntent);
        localJSONObject.put("scan_result", str);
        paramIntent = new JSONObject();
      }
      catch (JSONException paramIntent)
      {
        try
        {
          for (;;)
          {
            paramIntent.put("scan_code", localJSONObject);
            localHashMap.put("resultStr", paramIntent.toString());
            y.d("MicroMsg.JsApiOpenQRCode", "ret:%s", new Object[] { localHashMap });
            this.gcp.C(this.dIS, this.ggK.h("ok", localHashMap));
            return;
            paramIntent = "barcode";
          }
          paramIntent = paramIntent;
          y.printErrStackTrace("MicroMsg.JsApiOpenQRCode", paramIntent, "", new Object[0]);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.JsApiOpenQRCode", localJSONException, "", new Object[0]);
          }
        }
      }
    }
    this.gcp.C(this.dIS, this.ggK.h("cancel", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aq.1
 * JD-Core Version:    0.7.0.1
 */