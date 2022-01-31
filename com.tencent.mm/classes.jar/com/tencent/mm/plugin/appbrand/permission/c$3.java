package com.tencent.mm.plugin.appbrand.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  implements Runnable
{
  c$3(c paramc, com.tencent.mm.plugin.appbrand.i parami, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if ((this.fAy == null) || (this.fAy.Zz() == null)) {
      return;
    }
    b localb = new b(this.fAy.Zz().getContext());
    localb.setMessage(this.gWK);
    localb.a(y.j.app_brand_jsapi_user_auth_confirm, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        c.a(c.3.this.gWJ, c.3.this.gWL, 1);
        c.anJ().put(c.a(c.3.this.gWJ), c.b(c.3.this.gWJ));
        y.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", new Object[] { c.a(c.3.this.gWJ), c.b(c.3.this.gWJ) });
        c.c(c.3.this.gWJ).anL();
      }
    });
    localb.b(y.j.app_brand_jsapi_user_auth_deny, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        c.a(c.3.this.gWJ, c.3.this.gWL, 2);
        c.anJ().B(c.a(c.3.this.gWJ), c.b(c.3.this.gWJ));
        y.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user deny, appId %s, api %s", new Object[] { c.a(c.3.this.gWJ), c.b(c.3.this.gWJ) });
        c.c(c.3.this.gWJ).anM();
      }
    });
    localb.setOnCancelListener(new c.3.3(this));
    this.fAy.fys.b(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c.3
 * JD-Core Version:    0.7.0.1
 */