package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b.c;
import com.tencent.mm.aj.b.d;
import com.tencent.mm.f.b.a.qo;
import com.tencent.mm.f.b.a.qo.a;
import com.tencent.mm.f.b.a.qo.b;
import com.tencent.mm.f.b.a.qo.c;
import com.tencent.mm.f.b.a.qo.d;
import com.tencent.mm.f.b.a.qo.e;
import com.tencent.mm.kernel.h;
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
    d locald = ((m)h.ae(m.class)).SJ(this.qgX.qgT.cwU);
    Object localObject1 = qo.d.hlg;
    qo.e locale2 = qo.e.hlk;
    Object localObject2 = localObject1;
    qo.e locale1 = locale2;
    label81:
    int i;
    if (locald != null)
    {
      if (locald.field_msgState == 1)
      {
        localObject1 = qo.d.hli;
        if (locald.field_btnState != 2) {
          break label248;
        }
        locale1 = qo.e.hlm;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (paramWxaAttributes.bLF() != null) {
        break label283;
      }
      i = 0;
      label90:
      localObject1 = new qo().Hv(this.qgX.qgT.appId).Hw(this.qgX.qgT.path).Hx(this.qgX.qgT.path).Hy(this.qgX.qgU);
      if (!this.qgX.qgU.toLowerCase().endsWith("@chatroom")) {
        break label294;
      }
    }
    label283:
    label294:
    for (paramWxaAttributes = qo.c.hld;; paramWxaAttributes = qo.c.hle)
    {
      ((qo)localObject1).hkJ = paramWxaAttributes;
      ((qo)localObject1).hkK = qo.b.hla;
      ((qo)localObject1).gnP = 0L;
      paramWxaAttributes = ((qo)localObject1).Hz("");
      paramWxaAttributes.hkO = qo.a.pj(i + 1000);
      paramWxaAttributes = paramWxaAttributes.aoX();
      paramWxaAttributes.hkM = localObject2;
      paramWxaAttributes.hkN = locale1;
      paramWxaAttributes.bpa();
      AppMethodBeat.o(47705);
      return;
      if (locald.field_msgState != 0) {
        break;
      }
      localObject1 = qo.d.hlh;
      break;
      label248:
      if (locald.field_btnState != 0)
      {
        localObject2 = localObject1;
        locale1 = locale2;
        if (locald.field_btnState != 1) {
          break label81;
        }
      }
      locale1 = qo.e.hll;
      localObject2 = localObject1;
      break label81;
      i = paramWxaAttributes.bLF().serviceType;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.c.1.1
 * JD-Core Version:    0.7.0.1
 */