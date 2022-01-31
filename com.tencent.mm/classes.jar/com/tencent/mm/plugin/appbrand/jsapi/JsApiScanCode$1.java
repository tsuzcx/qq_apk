package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class JsApiScanCode$1
  implements MMActivity.a
{
  JsApiScanCode$1(JsApiScanCode paramJsApiScanCode, p paramp, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    JsApiScanCode.BF();
    if (paramInt1 != (this.ght.hashCode() & 0xFFFF)) {
      return;
    }
    Object localObject2;
    Object localObject1;
    switch (paramInt2)
    {
    default: 
      this.gbW.C(this.dIS, this.ght.h("fail", null));
      return;
    case -1: 
      localObject2 = "";
      localObject1 = Base64.encodeToString(new byte[0], 2);
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringExtra("key_scan_result");
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_scan_result_raw");
        if (arrayOfByte != null) {
          localObject1 = Base64.encodeToString(arrayOfByte, 2);
        }
        paramIntent.getIntExtra("key_scan_result_type", 0);
        paramInt2 = paramIntent.getIntExtra("key_scan_result_code_type", 0);
        paramInt1 = paramIntent.getIntExtra("key_scan_result_code_version", 0);
      }
      break;
    }
    for (paramIntent = (Intent)localObject2;; paramIntent = (Intent)localObject2)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("charSet", "utf-8");
      ((HashMap)localObject2).put("rawData", localObject1);
      if ((paramInt2 != 19) && (paramInt2 != 22))
      {
        localObject1 = paramIntent.split(",");
        if (localObject1.length > 1) {
          paramIntent = localObject1[1];
        }
        ((HashMap)localObject2).put("result", paramIntent);
        if (localObject1.length > 1) {}
        for (paramIntent = localObject1[0];; paramIntent = "")
        {
          ((HashMap)localObject2).put("scanType", paramIntent);
          this.gbW.C(this.dIS, this.ght.h("ok", (Map)localObject2));
          return;
        }
      }
      if (paramInt2 == 22)
      {
        localObject1 = "";
        ((HashMap)localObject2).put("result", localObject1);
        if (paramInt2 != 22) {
          break label360;
        }
      }
      label360:
      for (localObject1 = "WX_CODE";; localObject1 = "QR_CODE")
      {
        ((HashMap)localObject2).put("scanType", localObject1);
        localObject1 = new JsApiScanCode.GetA8KeyTask();
        ((JsApiScanCode.GetA8KeyTask)localObject1).ghx = paramIntent;
        ((JsApiScanCode.GetA8KeyTask)localObject1).bIj = paramInt2;
        ((JsApiScanCode.GetA8KeyTask)localObject1).bIk = paramInt1;
        ((JsApiScanCode.GetA8KeyTask)localObject1).ghz = new JsApiScanCode.1.1(this, (JsApiScanCode.GetA8KeyTask)localObject1, (HashMap)localObject2);
        ((JsApiScanCode.GetA8KeyTask)localObject1).ahC();
        AppBrandMainProcessService.a((MainProcessTask)localObject1);
        return;
        localObject1 = paramIntent;
        break;
      }
      this.gbW.C(this.dIS, this.ght.h("cancel", null));
      return;
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.1
 * JD-Core Version:    0.7.0.1
 */