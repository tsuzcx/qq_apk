package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a.b;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.g.b.a.no;
import com.tencent.mm.g.b.a.no.a;
import com.tencent.mm.g.b.a.no.b;
import com.tencent.mm.g.b.a.no.c;
import com.tencent.mm.g.b.a.no.d;
import com.tencent.mm.g.b.a.no.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.q.a;

final class c$1$1
  implements q.a
{
  c$1$1(c.1 param1) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47705);
    c localc = ((m)g.af(m.class)).Lq(this.ngn.ngj.cyr);
    Object localObject1 = no.d.fhV;
    no.e locale2 = no.e.fhZ;
    Object localObject2 = localObject1;
    no.e locale1 = locale2;
    label81:
    int i;
    if (localc != null)
    {
      if (localc.field_msgState == 1)
      {
        localObject1 = no.d.fhX;
        if (localc.field_btnState != 2) {
          break label248;
        }
        locale1 = no.e.fib;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (paramWxaAttributes.bAn() != null) {
        break label283;
      }
      i = 0;
      label90:
      localObject1 = new no().AJ(this.ngn.ngj.appId).AK(this.ngn.ngj.path).AL(this.ngn.ngj.path).AM(this.ngn.ngk);
      if (!this.ngn.ngk.toLowerCase().endsWith("@chatroom")) {
        break label294;
      }
    }
    label283:
    label294:
    for (paramWxaAttributes = no.c.fhS;; paramWxaAttributes = no.c.fhT)
    {
      ((no)localObject1).fhy = paramWxaAttributes;
      ((no)localObject1).fhz = no.b.fhP;
      ((no)localObject1).erW = 0L;
      paramWxaAttributes = ((no)localObject1).AN("");
      paramWxaAttributes.fhD = no.a.mX(i + 1000);
      paramWxaAttributes = paramWxaAttributes.ajq();
      paramWxaAttributes.fhB = localObject2;
      paramWxaAttributes.fhC = locale1;
      paramWxaAttributes.bfK();
      AppMethodBeat.o(47705);
      return;
      if (localc.field_msgState != 0) {
        break;
      }
      localObject1 = no.d.fhW;
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
      locale1 = no.e.fia;
      localObject2 = localObject1;
      break label81;
      i = paramWxaAttributes.bAn().serviceType;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.c.1.1
 * JD-Core Version:    0.7.0.1
 */