package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.b;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.g.b.a.gr.a;
import com.tencent.mm.g.b.a.gr.b;
import com.tencent.mm.g.b.a.gr.c;
import com.tencent.mm.g.b.a.gr.d;
import com.tencent.mm.g.b.a.gr.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.m.a;

final class b$1$1
  implements m.a
{
  b$1$1(b.1 param1) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47705);
    c localc = ((m)g.ab(m.class)).uY(this.kTq.kTm.cfh);
    Object localObject1 = gr.d.eiI;
    gr.e locale2 = gr.e.eiM;
    Object localObject2 = localObject1;
    gr.e locale1 = locale2;
    label81:
    int i;
    if (localc != null)
    {
      if (localc.field_msgState == 1)
      {
        localObject1 = gr.d.eiK;
        if (localc.field_btnState != 2) {
          break label248;
        }
        locale1 = gr.e.eiO;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (paramWxaAttributes.aTN() != null) {
        break label283;
      }
      i = 0;
      label90:
      localObject1 = new gr().mr(this.kTq.kTm.appId).ms(this.kTq.kTm.path).mt(this.kTq.kTm.path).mu(this.kTq.kTn);
      if (!this.kTq.kTn.toLowerCase().endsWith("@chatroom")) {
        break label294;
      }
    }
    label283:
    label294:
    for (paramWxaAttributes = gr.c.eiF;; paramWxaAttributes = gr.c.eiG)
    {
      ((gr)localObject1).eil = paramWxaAttributes;
      ((gr)localObject1).eim = gr.b.eiC;
      ((gr)localObject1).dKe = 0L;
      paramWxaAttributes = ((gr)localObject1).mv("");
      paramWxaAttributes.eiq = gr.a.jy(i + 1000);
      paramWxaAttributes = paramWxaAttributes.Sm();
      paramWxaAttributes.eio = localObject2;
      paramWxaAttributes.eip = locale1;
      paramWxaAttributes.aBj();
      AppMethodBeat.o(47705);
      return;
      if (localc.field_msgState != 0) {
        break;
      }
      localObject1 = gr.d.eiJ;
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
      locale1 = gr.e.eiN;
      localObject2 = localObject1;
      break label81;
      i = paramWxaAttributes.aTN().cIB;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.b.1.1
 * JD-Core Version:    0.7.0.1
 */