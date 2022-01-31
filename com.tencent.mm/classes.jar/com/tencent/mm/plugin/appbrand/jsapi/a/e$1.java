package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class e$1
  implements MMActivity.a
{
  e$1(e parame, v paramv, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130899);
    ab.i("MicroMsg.JsApiOpenRealnameAuth", "mmOnActivityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      HashMap localHashMap = new HashMap();
      if (paramInt2 == -1)
      {
        ab.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth ok");
        paramIntent = paramIntent.getStringExtra("intent_auth_token");
        if (!bo.isNullOrNil(paramIntent))
        {
          localHashMap.put("errCode", Integer.valueOf(0));
          localHashMap.put("auth_token", paramIntent);
          this.hEe.h(this.bAX, this.hEC.j("ok", localHashMap));
          ab.d("MicroMsg.JsApiOpenRealnameAuth", "authToken:%s", new Object[] { paramIntent });
          AppMethodBeat.o(130899);
          return;
        }
        this.hEe.h(this.bAX, this.hEC.j("fail", localHashMap));
        AppMethodBeat.o(130899);
        return;
      }
      if (paramInt2 == 0)
      {
        ab.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth cancel");
        this.hEe.h(this.bAX, this.hEC.j("cancel", null));
        AppMethodBeat.o(130899);
        return;
      }
      if (paramInt2 == 1)
      {
        ab.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth fail");
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getIntExtra("intent_err_code", -1);
          paramIntent = paramIntent.getStringExtra("intent_err_msg");
          localHashMap.put("errCode", Integer.valueOf(paramInt1));
          this.hEe.h(this.bAX, this.hEC.j("fail:" + bo.nullAsNil(paramIntent), localHashMap));
          ab.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), paramIntent });
          AppMethodBeat.o(130899);
          return;
        }
        this.hEe.h(this.bAX, this.hEC.j("fail", localHashMap));
      }
    }
    AppMethodBeat.o(130899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.e.1
 * JD-Core Version:    0.7.0.1
 */