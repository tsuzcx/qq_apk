package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class bc$1
  implements MMActivity.a
{
  bc$1(bc parambc, r paramr, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73153);
    bc.Pt();
    if (paramInt1 != (this.hzf.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(73153);
      return;
    }
    ab.i("MicroMsg.JsApiOpenQRCode", "onActivityResult requestCode:%d  resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt2)
    {
    default: 
      this.bAW.h(this.bAX, this.hzf.j("fail", null));
      AppMethodBeat.o(73153);
      return;
    case -1: 
      if (paramIntent == null)
      {
        ab.e("MicroMsg.JsApiOpenQRCode", "data is null, err");
        this.bAW.h(this.bAX, this.hzf.j("fail:unknown err", null));
        AppMethodBeat.o(73153);
        return;
      }
      HashMap localHashMap = new HashMap();
      String str = paramIntent.getStringExtra("key_scan_result");
      paramInt1 = paramIntent.getIntExtra("key_scan_result_type", 0);
      ab.d("MicroMsg.JsApiOpenQRCode", "result:%s, resultType:%d", new Object[] { str, Integer.valueOf(paramInt1) });
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
            ab.d("MicroMsg.JsApiOpenQRCode", "ret:%s", new Object[] { localHashMap });
            this.bAW.h(this.bAX, this.hzf.j("ok", localHashMap));
            AppMethodBeat.o(73153);
            return;
            paramIntent = "barcode";
          }
          paramIntent = paramIntent;
          ab.printErrStackTrace("MicroMsg.JsApiOpenQRCode", paramIntent, "", new Object[0]);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.JsApiOpenQRCode", localJSONException, "", new Object[0]);
          }
        }
      }
    }
    this.bAW.h(this.bAX, this.hzf.j("cancel", null));
    AppMethodBeat.o(73153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bc.1
 * JD-Core Version:    0.7.0.1
 */