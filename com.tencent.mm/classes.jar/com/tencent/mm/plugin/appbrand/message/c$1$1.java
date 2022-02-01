package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.b;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.g.b.a.ij;
import com.tencent.mm.g.b.a.ij.a;
import com.tencent.mm.g.b.a.ij.b;
import com.tencent.mm.g.b.a.ij.c;
import com.tencent.mm.g.b.a.ij.d;
import com.tencent.mm.g.b.a.ij.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.m.a;

final class c$1$1
  implements m.a
{
  c$1$1(c.1 param1) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47705);
    c localc = ((m)g.ab(m.class)).ze(this.luV.luR.ccd);
    Object localObject1 = ij.d.ekM;
    ij.e locale2 = ij.e.ekQ;
    Object localObject2 = localObject1;
    ij.e locale1 = locale2;
    label81:
    int i;
    if (localc != null)
    {
      if (localc.field_msgState == 1)
      {
        localObject1 = ij.d.ekO;
        if (localc.field_btnState != 2) {
          break label248;
        }
        locale1 = ij.e.ekS;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (paramWxaAttributes.baL() != null) {
        break label283;
      }
      i = 0;
      label90:
      localObject1 = new ij().px(this.luV.luR.appId).py(this.luV.luR.path).pz(this.luV.luR.path).pA(this.luV.luS);
      if (!this.luV.luS.toLowerCase().endsWith("@chatroom")) {
        break label294;
      }
    }
    label283:
    label294:
    for (paramWxaAttributes = ij.c.ekJ;; paramWxaAttributes = ij.c.ekK)
    {
      ((ij)localObject1).ekp = paramWxaAttributes;
      ((ij)localObject1).ekq = ij.b.ekG;
      ((ij)localObject1).dHY = 0L;
      paramWxaAttributes = ((ij)localObject1).pB("");
      paramWxaAttributes.eku = ij.a.jw(i + 1000);
      paramWxaAttributes = paramWxaAttributes.Tf();
      paramWxaAttributes.eks = localObject2;
      paramWxaAttributes.ekt = locale1;
      paramWxaAttributes.aHZ();
      AppMethodBeat.o(47705);
      return;
      if (localc.field_msgState != 0) {
        break;
      }
      localObject1 = ij.d.ekN;
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
      locale1 = ij.e.ekR;
      localObject2 = localObject1;
      break label81;
      i = paramWxaAttributes.baL().cFI;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.c.1.1
 * JD-Core Version:    0.7.0.1
 */