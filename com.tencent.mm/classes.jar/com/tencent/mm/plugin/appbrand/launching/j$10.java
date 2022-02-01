package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.be.o;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bw.a;
import com.tencent.mm.plugin.appbrand.config.y;

final class j$10
  implements Runnable
{
  j$10(j paramj, WxaPkgWrappingInfo paramWxaPkgWrappingInfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(271839);
    Object localObject = y.afh(this.pTm.username);
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        b.bhh().SX(str);
        i += 1;
      }
    }
    if (j.bZH())
    {
      localObject = new o(12);
      h.aHF().kcd.a((q)localObject, 0);
    }
    bw.a.a(this.pTm.appId, this.pTn);
    AppMethodBeat.o(271839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j.10
 * JD-Core Version:    0.7.0.1
 */