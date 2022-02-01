package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.tencent.luggage.h.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

final class JsApiScanCode$1
  implements f.c
{
  JsApiScanCode$1(JsApiScanCode paramJsApiScanCode, c paramc, int paramInt) {}
  
  public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(174873);
    JsApiScanCode.TT();
    if (paramInt1 != (this.mpI.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(174873);
      return false;
    }
    Object localObject3;
    Object localObject1;
    switch (paramInt2)
    {
    default: 
      this.lzl.i(this.cvP, this.mpI.h("fail", null));
      AppMethodBeat.o(174873);
      return true;
    case -1: 
      localObject3 = "";
      localObject1 = Base64.encodeToString(new byte[0], 2);
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringExtra("key_scan_result");
        localObject3 = paramIntent.getByteArrayExtra("key_scan_result_raw");
        if (localObject3 != null) {
          localObject1 = Base64.encodeToString((byte[])localObject3, 2);
        }
        localObject3 = paramIntent.getStringExtra("key_scan_result_code_name");
        paramInt2 = e.d.bcV((String)localObject3);
        paramInt1 = paramIntent.getIntExtra("key_scan_result_code_version", 0);
        paramIntent = (Intent)localObject2;
        localObject2 = localObject3;
      }
      break;
    }
    for (;;)
    {
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("charSet", "utf-8");
      ((HashMap)localObject3).put("rawData", localObject1);
      ((HashMap)localObject3).put("codeVersion", Integer.valueOf(paramInt1));
      if ((paramInt2 != 19) && (paramInt2 != 22))
      {
        ((HashMap)localObject3).put("result", paramIntent);
        ((HashMap)localObject3).put("scanType", Util.nullAsNil((String)localObject2));
        this.lzl.i(this.cvP, this.mpI.n("ok", (Map)localObject3));
        AppMethodBeat.o(174873);
        return true;
      }
      if (paramInt2 == 22)
      {
        localObject1 = "";
        label273:
        ((HashMap)localObject3).put("result", localObject1);
        if (paramInt2 != 22) {
          break label386;
        }
      }
      label386:
      for (localObject1 = "WX_CODE";; localObject1 = "QR_CODE")
      {
        ((HashMap)localObject3).put("scanType", localObject1);
        if (!NetStatusUtil.isConnected(this.lzl.getContext())) {
          break label393;
        }
        Log.i("MicroMsg.JsApiScanCode", "online mode");
        localObject1 = new JsApiScanCode.GetA8KeyTask();
        ((JsApiScanCode.GetA8KeyTask)localObject1).mpM = paramIntent;
        ((JsApiScanCode.GetA8KeyTask)localObject1).dFL = paramInt2;
        ((JsApiScanCode.GetA8KeyTask)localObject1).dFM = paramInt1;
        ((JsApiScanCode.GetA8KeyTask)localObject1).mpO = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174872);
            this.mpJ.bDK();
            if (this.mpJ.actionCode == 26)
            {
              Uri localUri = Uri.parse(this.mpJ.mpN);
              String str = localUri.getQueryParameter("username");
              if (JsApiScanCode.1.this.lzl.getRuntime().bsC().username.equals(str)) {
                this.mpK.put("path", URLDecoder.decode(Util.nullAsNil(localUri.getQueryParameter("path"))));
              }
            }
            JsApiScanCode.1.this.lzl.i(JsApiScanCode.1.this.cvP, JsApiScanCode.1.this.mpI.n("ok", this.mpK));
            AppMethodBeat.o(174872);
          }
        };
        ((JsApiScanCode.GetA8KeyTask)localObject1).bDJ();
        AppBrandMainProcessService.a((MainProcessTask)localObject1);
        break;
        localObject1 = paramIntent;
        break label273;
      }
      label393:
      Log.i("MicroMsg.JsApiScanCode", "offline mode");
      this.lzl.i(this.cvP, this.mpI.n("ok", (Map)localObject3));
      break;
      this.lzl.i(this.cvP, this.mpI.h("cancel", null));
      break;
      paramInt1 = 0;
      paramInt2 = 0;
      paramIntent = (Intent)localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.1
 * JD-Core Version:    0.7.0.1
 */