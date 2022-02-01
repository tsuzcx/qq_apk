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
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
    JsApiScanCode.Jy();
    if (paramInt1 != (this.lgo.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(174873);
      return false;
    }
    Object localObject3;
    Object localObject1;
    switch (paramInt2)
    {
    default: 
      this.ksc.h(this.cjQ, this.lgo.e("fail", null));
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
        paramInt2 = e.d.aLg((String)localObject3);
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
        ((HashMap)localObject3).put("scanType", bt.nullAsNil((String)localObject2));
        this.ksc.h(this.cjQ, this.lgo.m("ok", (Map)localObject3));
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
        if (!ay.isConnected(this.ksc.getContext())) {
          break label393;
        }
        ad.i("MicroMsg.JsApiScanCode", "online mode");
        localObject1 = new JsApiScanCode.GetA8KeyTask();
        ((JsApiScanCode.GetA8KeyTask)localObject1).lgs = paramIntent;
        ((JsApiScanCode.GetA8KeyTask)localObject1).dnt = paramInt2;
        ((JsApiScanCode.GetA8KeyTask)localObject1).dnu = paramInt1;
        ((JsApiScanCode.GetA8KeyTask)localObject1).lgu = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174872);
            this.lgp.bhO();
            if (this.lgp.actionCode == 26)
            {
              Uri localUri = Uri.parse(this.lgp.lgt);
              String str = localUri.getQueryParameter("username");
              if (JsApiScanCode.1.this.ksc.getRuntime().aXc().username.equals(str)) {
                this.lgq.put("path", URLDecoder.decode(bt.nullAsNil(localUri.getQueryParameter("path"))));
              }
            }
            JsApiScanCode.1.this.ksc.h(JsApiScanCode.1.this.cjQ, JsApiScanCode.1.this.lgo.m("ok", this.lgq));
            AppMethodBeat.o(174872);
          }
        };
        ((JsApiScanCode.GetA8KeyTask)localObject1).bhN();
        AppBrandMainProcessService.a((MainProcessTask)localObject1);
        break;
        localObject1 = paramIntent;
        break label273;
      }
      label393:
      ad.i("MicroMsg.JsApiScanCode", "offline mode");
      this.ksc.h(this.cjQ, this.lgo.m("ok", (Map)localObject3));
      break;
      this.ksc.h(this.cjQ, this.lgo.e("cancel", null));
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