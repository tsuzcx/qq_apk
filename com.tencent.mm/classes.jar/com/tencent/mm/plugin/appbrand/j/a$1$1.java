package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.a;
import com.tencent.mm.af.a.b;
import com.tencent.mm.g.b.a.dd;
import com.tencent.mm.g.b.a.dd.a;
import com.tencent.mm.g.b.a.dd.b;
import com.tencent.mm.g.b.a.dd.c;
import com.tencent.mm.g.b.a.dd.d;
import com.tencent.mm.g.b.a.dd.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.i.a;

final class a$1$1
  implements i.a
{
  a$1$1(a.1 param1) {}
  
  public final void d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(132264);
    b localb = ((k)g.E(k.class)).qj(this.irv.irq.bCZ);
    Object localObject1 = dd.d.deN;
    dd.e locale2 = dd.e.deR;
    Object localObject2 = localObject1;
    dd.e locale1 = locale2;
    label81:
    int i;
    if (localb != null)
    {
      if (localb.field_msgState == 1)
      {
        localObject1 = dd.d.deP;
        if (localb.field_btnState != 2) {
          break label248;
        }
        locale1 = dd.e.deT;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (paramWxaAttributes.ayC() != null) {
        break label283;
      }
      i = 0;
      label90:
      localObject1 = new dd().iu(this.irv.irq.appId).iv(this.irv.irq.path).iw(this.irv.irq.path).ix(this.irv.irs);
      if (!this.irv.irs.toLowerCase().endsWith("@chatroom")) {
        break label294;
      }
    }
    label283:
    label294:
    for (paramWxaAttributes = dd.c.deK;; paramWxaAttributes = dd.c.deL)
    {
      ((dd)localObject1).deq = paramWxaAttributes;
      ((dd)localObject1).der = dd.b.deH;
      ((dd)localObject1).cRG = 0L;
      paramWxaAttributes = ((dd)localObject1).iy("");
      paramWxaAttributes.dev = dd.a.hn(i + 1000);
      paramWxaAttributes = paramWxaAttributes.Hl();
      paramWxaAttributes.det = localObject2;
      paramWxaAttributes.deu = locale1;
      paramWxaAttributes.ake();
      AppMethodBeat.o(132264);
      return;
      if (localb.field_msgState != 0) {
        break;
      }
      localObject1 = dd.d.deO;
      break;
      label248:
      if (localb.field_btnState != 0)
      {
        localObject2 = localObject1;
        locale1 = locale2;
        if (localb.field_btnState != 1) {
          break label81;
        }
      }
      locale1 = dd.e.deS;
      localObject2 = localObject1;
      break label81;
      i = paramWxaAttributes.ayC().fmF;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a.1.1
 * JD-Core Version:    0.7.0.1
 */