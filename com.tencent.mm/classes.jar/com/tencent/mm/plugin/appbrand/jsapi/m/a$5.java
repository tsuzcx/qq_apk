package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;

final class a$5
  implements MMActivity.a
{
  a$5(a parama, b.b paramb) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131405);
    if (paramInt1 != (this.hWm.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(131405);
      return;
    }
    if (paramInt2 == -1)
    {
      String str = "";
      if (paramIntent != null) {
        str = bo.bf(paramIntent.getStringExtra("token"), "");
      }
      if (!TextUtils.isEmpty(str))
      {
        ab.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
        if (this.hWn != null)
        {
          this.hWn.j(true, str);
          AppMethodBeat.o(131405);
        }
      }
      else
      {
        ab.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
        if (this.hWn != null) {
          this.hWn.j(false, null);
        }
      }
      AppMethodBeat.o(131405);
      return;
    }
    if (this.hWn != null) {
      this.hWn.j(false, null);
    }
    AppMethodBeat.o(131405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.5
 * JD-Core Version:    0.7.0.1
 */