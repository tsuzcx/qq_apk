package com.tencent.mm.plugin.appbrand.jsapi.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.k;
import com.tencent.mm.plugin.appbrand.phonenumber.n.b;
import com.tencent.mm.vending.g.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetPhoneNumberNew$showPhoneNumberDialog$5$1$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "plugin-appbrand-integration_release"})
public final class c$r$a
  implements n.b
{
  c$r$a(c.r paramr, PhoneItem paramPhoneItem) {}
  
  public final void a(boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(143769);
    j.q(paramMap, "result");
    if (paramBoolean)
    {
      Object localObject3;
      if (this.hEA.iDs)
      {
        localObject2 = this.hEz.hEr;
        if (localObject2 != null)
        {
          localObject3 = this.hEz.hEr;
          if (localObject3 != null) {
            localObject1 = Long.valueOf(((bn)localObject3).GC());
          }
          if (localObject1 == null) {
            j.ebi();
          }
          ((bn)localObject2).dR(((Long)localObject1).longValue() + 1L);
        }
      }
      for (;;)
      {
        localObject3 = this.hEz.hEh;
        Object localObject4 = new m.a("ok", new Object[0]);
        HashMap localHashMap = new HashMap();
        localObject2 = (String)paramMap.get("encryptedData");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localHashMap.put("encryptedData", localObject1);
        localObject1 = (String)paramMap.get("iv");
        paramMap = (Map<String, String>)localObject1;
        if (localObject1 == null) {
          paramMap = "";
        }
        localHashMap.put("iv", paramMap);
        ((m.a)localObject4).u((Map)localHashMap);
        ((b)localObject3).C(new Object[] { localObject4 });
        paramMap = k.iDv;
        k.a(this.hEA);
        AppMethodBeat.o(143769);
        return;
        localObject3 = this.hEz.hEr;
        if (localObject3 != null)
        {
          localObject4 = this.hEz.hEr;
          localObject1 = localObject2;
          if (localObject4 != null) {
            localObject1 = Long.valueOf(((bn)localObject4).GD());
          }
          if (localObject1 == null) {
            j.ebi();
          }
          ((bn)localObject3).dS(((Long)localObject1).longValue() + 1L);
        }
      }
    }
    this.hEz.hEh.cK(paramMap.get("errMsg"));
    AppMethodBeat.o(143769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.r.a
 * JD-Core Version:    0.7.0.1
 */