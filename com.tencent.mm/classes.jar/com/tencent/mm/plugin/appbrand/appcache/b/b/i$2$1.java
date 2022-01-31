package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.e.d;
import com.tencent.mm.plugin.appbrand.launching.o.c;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicBoolean;

final class i$2$1
  extends o.c
{
  i$2$1(i.2 param2, boolean paramBoolean, int paramInt, AtomicBoolean paramAtomicBoolean, com.tencent.mm.vending.g.b paramb) {}
  
  public final void a(a.a<ast> parama)
  {
    AppMethodBeat.i(129479);
    if (!com.tencent.mm.plugin.appbrand.l.a.b(parama)) {
      if (!this.gXC) {
        break label59;
      }
    }
    label59:
    for (int i = 50;; i = 49)
    {
      parama = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(this.gXD, i);
      this.gXU.set(true);
      this.gXE.resume();
      AppMethodBeat.o(129479);
      return;
    }
  }
  
  public final void a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(129480);
    com.tencent.mm.plugin.appbrand.appcache.b.d.a locala;
    int i;
    com.tencent.mm.plugin.appbrand.appcache.b.d.b localb;
    if (paramWxaPkgWrappingInfo != null)
    {
      ab.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "predownload normal pkg succeed, appId[%s], version[%d]", new Object[] { this.gXV.gXT.field_appId, Integer.valueOf(this.gXV.gXT.field_version) });
      ((d)g.w(d.class)).delete(this.gXV.gXT, new String[0]);
      locala = (com.tencent.mm.plugin.appbrand.appcache.b.d.a)g.w(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class);
      String str = this.gXV.gXT.field_appId;
      i = this.gXV.gXT.field_version;
      localb = new com.tencent.mm.plugin.appbrand.appcache.b.d.b();
      localb.field_appId = str;
      localb.field_version = i;
      boolean bool = locala.get((com.tencent.mm.sdk.e.c)localb, new String[0]);
      localb.field_source = 1;
      localb.field_hitCount = 0;
      if (bool) {
        locala.update((com.tencent.mm.sdk.e.c)localb, new String[0]);
      }
    }
    while (this.gXU.get())
    {
      AppMethodBeat.o(129480);
      return;
      locala.insert((com.tencent.mm.sdk.e.c)localb);
      continue;
      ab.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "predownload normal pkg failed, appId[%s], version[%d]", new Object[] { this.gXV.gXT.field_appId, Integer.valueOf(this.gXV.gXT.field_version) });
    }
    if (paramWxaPkgWrappingInfo != null) {
      if (this.gXC) {
        i = 52;
      }
    }
    for (;;)
    {
      paramWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(this.gXD, i);
      this.gXE.resume();
      AppMethodBeat.o(129480);
      return;
      i = 47;
      continue;
      if (this.gXC) {
        i = 53;
      } else {
        i = 48;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.i.2.1
 * JD-Core Version:    0.7.0.1
 */