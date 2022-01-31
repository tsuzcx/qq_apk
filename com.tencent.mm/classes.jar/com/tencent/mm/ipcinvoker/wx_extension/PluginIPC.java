package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.g.1;
import com.tencent.mm.ipcinvoker.g.2;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import junit.framework.Assert;

public class PluginIPC
  extends f
  implements c
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(126208);
    ab.i("MicroMsg.PluginIPC", "execute(%s)", new Object[] { paramg.mProcessName });
    paramg = ((h)com.tencent.mm.kernel.g.RI().Rj()).bX;
    PluginIPC.1 local1 = new PluginIPC.1(this);
    Assert.assertNotNull(paramg);
    e.sContext = paramg;
    g.1 local11 = new g.1(paramg);
    local1.a(local11);
    local1.a(new g.2());
    local1.b(local11);
    b.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[] { e.PM(), Integer.valueOf(paramg.hashCode()) });
    if ((ah.dsW()) || (ah.dsX())) {
      com.tencent.mm.ipcinvoker.g.ma("com.tencent.mm");
    }
    AppMethodBeat.o(126208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC
 * JD-Core Version:    0.7.0.1
 */