package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.n;

public final class ILaunchWxaAppInfoNotify$a$2
  implements c.a
{
  public ILaunchWxaAppInfoNotify$a$2(n paramn, MMToClientEvent.c paramc) {}
  
  public final void a(String paramString, b paramb)
  {
    if (paramb == b.fFL) {
      MMToClientEvent.b(this.gKu.mAppId, this.fKO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.2
 * JD-Core Version:    0.7.0.1
 */