package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;

final class a$5
  implements MMActivity.a
{
  a$5(a parama, b.b paramb) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != (this.gzl.hashCode() & 0xFFFF)) {}
    label102:
    do
    {
      do
      {
        String str;
        do
        {
          return;
          if (paramInt2 != -1) {
            break label102;
          }
          str = "";
          if (paramIntent != null) {
            str = bk.aM(paramIntent.getStringExtra("token"), "");
          }
          if (TextUtils.isEmpty(str)) {
            break;
          }
          y.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
        } while (this.gzm == null);
        this.gzm.f(true, str);
        return;
        y.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
      } while (this.gzm == null);
      this.gzm.f(false, null);
      return;
    } while (this.gzm == null);
    this.gzm.f(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.5
 * JD-Core Version:    0.7.0.1
 */