package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.g.1;
import com.tencent.mm.ipcinvoker.g.2;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public class PluginIPC
  extends f
  implements c
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    y.i("MicroMsg.PluginIPC", "execute(%s)", new Object[] { paramg.dIA });
    paramg = ((h)com.tencent.mm.kernel.g.DM().Dr()).bT;
    PluginIPC.1 local1 = new PluginIPC.1(this);
    Assert.assertNotNull(paramg);
    e.sContext = paramg;
    g.1 local11 = new g.1();
    local1.a(local11);
    local1.a(new g.2());
    local1.b(local11);
    b.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[] { e.BV(), Integer.valueOf(paramg.hashCode()) });
    if (ae.cqX()) {
      com.tencent.mm.ipcinvoker.g.fF("com.tencent.mm");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC
 * JD-Core Version:    0.7.0.1
 */