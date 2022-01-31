package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
final class d$a
  implements ao.b.a
{
  d$a(d paramd, ProfileResult paramProfileResult, p paramp, int paramInt) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134706);
    if (d.a(this.hXo) == null)
    {
      ab.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
      this.hXp.bpE = 0;
      d.a(this.hXo, (AppBrandProxyUIProcessTask.ProcessResult)this.hXp);
      AppMethodBeat.o(134706);
      return;
    }
    Object localObject = this.hXq;
    if (localObject != null) {
      ((p)localObject).dismiss();
    }
    localObject = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().arw(paramString);
    if ((localObject == null) || (((ad)localObject).Od() <= 0))
    {
      a locala = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(locala, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.j)locala).YA().ars(paramString);
      paramBoolean = false;
    }
    while (!paramBoolean)
    {
      ab.w("ProfileTask", "handleRequest, getNow callback fail");
      this.hXp.bpE = 0;
      d.a(this.hXo, (AppBrandProxyUIProcessTask.ProcessResult)this.hXp);
      AppMethodBeat.o(134706);
      return;
      paramString = ((ad)localObject).getUsername();
    }
    b.U(paramString, 3);
    o.adi().qU(paramString);
    if (localObject == null) {
      a.f.b.j.ebi();
    }
    if (((ad)localObject).dwz())
    {
      h.qsU.kvStat(10298, ((ad)localObject).getUsername() + "," + this.hXi);
      this.hXp.hXn |= 0x1;
    }
    if (((ad)localObject).NT()) {
      this.hXp.hXn |= 0x2;
    }
    this.hXp.bpE = 1;
    d.a(this.hXo, (AppBrandProxyUIProcessTask.ProcessResult)this.hXp);
    AppMethodBeat.o(134706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d.a
 * JD-Core Version:    0.7.0.1
 */