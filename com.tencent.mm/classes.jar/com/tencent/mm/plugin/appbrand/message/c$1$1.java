package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.b;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.g.b.a.jq.a;
import com.tencent.mm.g.b.a.jq.b;
import com.tencent.mm.g.b.a.jq.c;
import com.tencent.mm.g.b.a.jq.d;
import com.tencent.mm.g.b.a.jq.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.o.a;

final class c$1$1
  implements o.a
{
  c$1$1(c.1 param1) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47705);
    c localc = ((m)g.ab(m.class)).CF(this.lYH.lYD.cmw);
    Object localObject1 = jq.d.eDx;
    jq.e locale2 = jq.e.eDB;
    Object localObject2 = localObject1;
    jq.e locale1 = locale2;
    label81:
    int i;
    if (localc != null)
    {
      if (localc.field_msgState == 1)
      {
        localObject1 = jq.d.eDz;
        if (localc.field_btnState != 2) {
          break label248;
        }
        locale1 = jq.e.eDD;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (paramWxaAttributes.beT() != null) {
        break label283;
      }
      i = 0;
      label90:
      localObject1 = new jq().sy(this.lYH.lYD.appId).sz(this.lYH.lYD.path).sA(this.lYH.lYD.path).sB(this.lYH.lYE);
      if (!this.lYH.lYE.toLowerCase().endsWith("@chatroom")) {
        break label294;
      }
    }
    label283:
    label294:
    for (paramWxaAttributes = jq.c.eDu;; paramWxaAttributes = jq.c.eDv)
    {
      ((jq)localObject1).eDa = paramWxaAttributes;
      ((jq)localObject1).eDb = jq.b.eDr;
      ((jq)localObject1).dWt = 0L;
      paramWxaAttributes = ((jq)localObject1).sC("");
      paramWxaAttributes.eDf = jq.a.jV(i + 1000);
      paramWxaAttributes = paramWxaAttributes.VA();
      paramWxaAttributes.eDd = localObject2;
      paramWxaAttributes.eDe = locale1;
      paramWxaAttributes.aLH();
      AppMethodBeat.o(47705);
      return;
      if (localc.field_msgState != 0) {
        break;
      }
      localObject1 = jq.d.eDy;
      break;
      label248:
      if (localc.field_btnState != 0)
      {
        localObject2 = localObject1;
        locale1 = locale2;
        if (localc.field_btnState != 1) {
          break label81;
        }
      }
      locale1 = jq.e.eDC;
      localObject2 = localObject1;
      break label81;
      i = paramWxaAttributes.beT().cRx;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.c.1.1
 * JD-Core Version:    0.7.0.1
 */