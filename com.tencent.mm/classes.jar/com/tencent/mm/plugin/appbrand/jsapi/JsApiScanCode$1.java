package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class JsApiScanCode$1
  implements MMActivity.a
{
  JsApiScanCode$1(JsApiScanCode paramJsApiScanCode, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130556);
    JsApiScanCode.Pt();
    if (paramInt1 != (this.hzE.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(130556);
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    switch (paramInt2)
    {
    default: 
      this.hxC.h(this.bAX, this.hzE.j("fail", null));
      AppMethodBeat.o(130556);
      return;
    case -1: 
      str = "";
      localObject1 = Base64.encodeToString(new byte[0], 2);
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("key_scan_result");
        localObject2 = paramIntent.getByteArrayExtra("key_scan_result_raw");
        if (localObject2 != null) {
          localObject1 = Base64.encodeToString((byte[])localObject2, 2);
        }
        paramIntent.getIntExtra("key_scan_result_type", 0);
        paramInt2 = paramIntent.getIntExtra("key_scan_result_code_type", 0);
        paramInt1 = paramIntent.getIntExtra("key_scan_result_code_version", 0);
      }
      break;
    }
    for (paramIntent = str;; paramIntent = str)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("charSet", "utf-8");
      ((HashMap)localObject2).put("rawData", localObject1);
      if ((paramInt2 != 19) && (paramInt2 != 22))
      {
        paramInt1 = paramIntent.indexOf(",");
        if ((paramInt1 > 0) && (paramInt1 + 1 < paramIntent.length()))
        {
          str = paramIntent.substring(paramInt1 + 1);
          localObject1 = paramIntent.substring(0, paramInt1);
          paramIntent = str;
        }
        for (;;)
        {
          ((HashMap)localObject2).put("result", paramIntent);
          ((HashMap)localObject2).put("scanType", localObject1);
          this.hxC.h(this.bAX, this.hzE.j("ok", (Map)localObject2));
          AppMethodBeat.o(130556);
          return;
          localObject1 = "";
        }
      }
      if (paramInt2 == 22)
      {
        localObject1 = "";
        ((HashMap)localObject2).put("result", localObject1);
        if (paramInt2 != 22) {
          break label394;
        }
      }
      label394:
      for (localObject1 = "WX_CODE";; localObject1 = "QR_CODE")
      {
        ((HashMap)localObject2).put("scanType", localObject1);
        localObject1 = new JsApiScanCode.GetA8KeyTask();
        ((JsApiScanCode.GetA8KeyTask)localObject1).hzI = paramIntent;
        ((JsApiScanCode.GetA8KeyTask)localObject1).cpE = paramInt2;
        ((JsApiScanCode.GetA8KeyTask)localObject1).cpF = paramInt1;
        ((JsApiScanCode.GetA8KeyTask)localObject1).hzK = new JsApiScanCode.1.1(this, (JsApiScanCode.GetA8KeyTask)localObject1, (HashMap)localObject2);
        ((JsApiScanCode.GetA8KeyTask)localObject1).aBj();
        AppBrandMainProcessService.a((MainProcessTask)localObject1);
        AppMethodBeat.o(130556);
        return;
        localObject1 = paramIntent;
        break;
      }
      this.hxC.h(this.bAX, this.hzE.j("cancel", null));
      AppMethodBeat.o(130556);
      return;
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.1
 * JD-Core Version:    0.7.0.1
 */