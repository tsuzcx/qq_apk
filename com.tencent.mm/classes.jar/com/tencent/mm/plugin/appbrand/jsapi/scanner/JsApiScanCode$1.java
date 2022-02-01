package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

final class JsApiScanCode$1
  implements e.c
{
  JsApiScanCode$1(JsApiScanCode paramJsApiScanCode, c paramc, int paramInt) {}
  
  public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(174873);
    JsApiScanCode.JG();
    if (paramInt1 != (this.lka.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(174873);
      return false;
    }
    Object localObject3;
    Object localObject1;
    switch (paramInt2)
    {
    default: 
      this.kvs.h(this.cjS, this.lka.e("fail", null));
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
        paramInt2 = e.d.aMC((String)localObject3);
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
        ((HashMap)localObject3).put("scanType", bu.nullAsNil((String)localObject2));
        this.kvs.h(this.cjS, this.lka.n("ok", (Map)localObject3));
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
        if (!az.isConnected(this.kvs.getContext())) {
          break label393;
        }
        ae.i("MicroMsg.JsApiScanCode", "online mode");
        localObject1 = new JsApiScanCode.GetA8KeyTask();
        ((JsApiScanCode.GetA8KeyTask)localObject1).lke = paramIntent;
        ((JsApiScanCode.GetA8KeyTask)localObject1).dov = paramInt2;
        ((JsApiScanCode.GetA8KeyTask)localObject1).dow = paramInt1;
        ((JsApiScanCode.GetA8KeyTask)localObject1).lkg = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174872);
            this.lkb.bix();
            if (this.lkb.actionCode == 26)
            {
              Uri localUri = Uri.parse(this.lkb.lkf);
              String str = localUri.getQueryParameter("username");
              if (JsApiScanCode.1.this.kvs.getRuntime().aXx().username.equals(str)) {
                this.lkc.put("path", URLDecoder.decode(bu.nullAsNil(localUri.getQueryParameter("path"))));
              }
            }
            JsApiScanCode.1.this.kvs.h(JsApiScanCode.1.this.cjS, JsApiScanCode.1.this.lka.n("ok", this.lkc));
            AppMethodBeat.o(174872);
          }
        };
        ((JsApiScanCode.GetA8KeyTask)localObject1).biw();
        AppBrandMainProcessService.a((MainProcessTask)localObject1);
        break;
        localObject1 = paramIntent;
        break label273;
      }
      label393:
      ae.i("MicroMsg.JsApiScanCode", "offline mode");
      this.kvs.h(this.cjS, this.lka.n("ok", (Map)localObject3));
      break;
      this.kvs.h(this.cjS, this.lka.e("cancel", null));
      break;
      paramInt1 = 0;
      paramInt2 = 0;
      paramIntent = (Intent)localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.1
 * JD-Core Version:    0.7.0.1
 */