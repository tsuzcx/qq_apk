package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class a$1
  implements MMActivity.a
{
  a$1(a parama, b.a parama1) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131401);
    if (paramInt1 != (this.hWm.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(131401);
      return;
    }
    if (paramIntent != null) {}
    for (paramInt1 = paramIntent.getIntExtra("key_is_clear_failure", -1);; paramInt1 = -1)
    {
      HashMap localHashMap = new HashMap();
      if (paramInt1 == 0) {
        localHashMap.put("payStatus", "pending");
      }
      while (paramInt2 == -1)
      {
        if (this.hWl != null) {
          this.hWl.a(1, null, localHashMap);
        }
        AppMethodBeat.o(131401);
        return;
        if (paramInt1 == 1) {
          localHashMap.put("pay_status", "fail");
        }
      }
      if (paramInt2 == 5)
      {
        paramInt1 = paramIntent.getIntExtra("key_jsapi_pay_err_code", 0);
        paramIntent = bo.nullAsNil(paramIntent.getStringExtra("key_jsapi_pay_err_msg"));
        ab.e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), paramIntent });
        if (this.hWl != null) {
          this.hWl.a(2, paramIntent, localHashMap);
        }
        AppMethodBeat.o(131401);
        return;
      }
      if (this.hWl != null) {
        this.hWl.a(3, null, localHashMap);
      }
      AppMethodBeat.o(131401);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.1
 * JD-Core Version:    0.7.0.1
 */