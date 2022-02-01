package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.uj;
import com.tencent.mm.autogen.mmdata.rpt.uj.a;
import com.tencent.mm.autogen.mmdata.rpt.uj.b;
import com.tencent.mm.autogen.mmdata.rpt.uj.c;
import com.tencent.mm.autogen.mmdata.rpt.uj.d;
import com.tencent.mm.autogen.mmdata.rpt.uj.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.c.c;
import com.tencent.mm.message.c.d;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.s.a;

final class c$1$1
  implements s.a
{
  c$1$1(c.1 param1) {}
  
  public final void onGetWeAppInfo(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47705);
    d locald = ((m)h.ax(m.class)).KL(this.tlI.tlE.eoU);
    Object localObject1 = uj.d.jHh;
    uj.e locale2 = uj.e.jHl;
    Object localObject2 = localObject1;
    uj.e locale1 = locale2;
    label81:
    int i;
    if (locald != null)
    {
      if (locald.field_msgState == 1)
      {
        localObject1 = uj.d.jHj;
        if (locald.field_btnState != 2) {
          break label248;
        }
        locale1 = uj.e.jHn;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (paramWxaAttributes.cld() != null) {
        break label283;
      }
      i = 0;
      label90:
      localObject1 = new uj().Ad(this.tlI.tlE.appId).Ae(this.tlI.tlE.path).Af(this.tlI.tlE.path).Ag(this.tlI.tlF);
      if (!this.tlI.tlF.toLowerCase().endsWith("@chatroom")) {
        break label294;
      }
    }
    label283:
    label294:
    for (paramWxaAttributes = uj.c.jHe;; paramWxaAttributes = uj.c.jHf)
    {
      ((uj)localObject1).jGL = paramWxaAttributes;
      ((uj)localObject1).jGM = uj.b.jHb;
      ((uj)localObject1).iqr = 0L;
      paramWxaAttributes = ((uj)localObject1).Ah("");
      paramWxaAttributes.jGP = uj.a.pk(i + 1000);
      paramWxaAttributes = paramWxaAttributes.aJl();
      paramWxaAttributes.jGN = localObject2;
      paramWxaAttributes.jGO = locale1;
      paramWxaAttributes.bMH();
      AppMethodBeat.o(47705);
      return;
      if (locald.field_msgState != 0) {
        break;
      }
      localObject1 = uj.d.jHi;
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
      locale1 = uj.e.jHm;
      localObject2 = localObject1;
      break label81;
      i = paramWxaAttributes.cld().serviceType;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.c.1.1
 * JD-Core Version:    0.7.0.1
 */