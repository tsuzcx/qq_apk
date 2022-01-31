package com.tencent.mm.plugin.appbrand.jsapi.a;

import a.f.a.r;
import a.f.b.j;
import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.luggage.g.e;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.vending.g.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class c$l
  implements DialogInterface.OnClickListener
{
  c$l(v paramv, bn parambn, String paramString, boolean paramBoolean, b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(143759);
    com.tencent.luggage.g.d.i("MicroMsg.JsApiGetPhoneNumberNew", "confirm bind phone number");
    paramDialogInterface = this.hEl;
    if (paramDialogInterface != null) {}
    for (paramDialogInterface = paramDialogInterface.getContext();; paramDialogInterface = null)
    {
      Intent localIntent = new Intent(paramDialogInterface, AppBrandRedirectUI.class);
      localIntent.putExtra("key_from_scene", 0);
      v localv = this.hEl;
      paramDialogInterface = localObject;
      if (localv != null) {
        paramDialogInterface = localv.getContext();
      }
      e.at(paramDialogInterface).a(localIntent, (e.a)new e.a()
      {
        public final void b(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(143758);
          com.tencent.luggage.g.d.i("MicroMsg.JsApiGetPhoneNumberNew", "bind wechat phone number, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == -1)
          {
            paramAnonymousIntent = this.hEs.hEr;
            if (paramAnonymousIntent != null) {
              paramAnonymousIntent.dM(1L);
            }
            bn localbn = this.hEs.hEr;
            if (localbn != null)
            {
              paramAnonymousIntent = this.hEs.hEr;
              if (paramAnonymousIntent == null) {
                break label155;
              }
            }
            label155:
            for (paramAnonymousIntent = Long.valueOf(paramAnonymousIntent.Gy());; paramAnonymousIntent = null)
            {
              if (paramAnonymousIntent == null) {
                j.ebi();
              }
              localbn.dN(paramAnonymousIntent.longValue() + 1L);
              paramAnonymousIntent = this.hEs.hEl.getAppId();
              j.p(paramAnonymousIntent, "env.appId");
              new com.tencent.mm.plugin.appbrand.phonenumber.d(paramAnonymousIntent, this.hEs.hEm, this.hEs.hEn).a((r)new c.l.1.1(this));
              AppMethodBeat.o(143758);
              return;
            }
          }
          com.tencent.luggage.g.d.e("MicroMsg.JsApiGetPhoneNumberNew", "bind wechat phone number fail");
          paramAnonymousIntent = this.hEs.hEr;
          if (paramAnonymousIntent != null) {
            paramAnonymousIntent.dM(0L);
          }
          this.hEs.hEh.cK("user cancel");
          AppMethodBeat.o(143758);
        }
      });
      AppMethodBeat.o(143759);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.l
 * JD-Core Version:    0.7.0.1
 */