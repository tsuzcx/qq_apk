package com.tencent.mm.plugin.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.pluginsdk.g.a.c.o;

public class PluginComm
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.comm.a.a
{
  private com.tencent.mm.sdk.b.c kSY;
  
  public PluginComm()
  {
    AppMethodBeat.i(151607);
    this.kSY = new PluginComm.2(this);
    AppMethodBeat.o(151607);
  }
  
  public static boolean isVoipStarted()
  {
    AppMethodBeat.i(151610);
    ux localux = new ux();
    localux.cLs.cut = 2;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    boolean bool = localux.cLt.cLu;
    AppMethodBeat.o(151610);
    return bool;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(79088);
    if (paramg.SD())
    {
      pin(com.tencent.mm.plugin.a.aoF());
      pin(com.tencent.mm.plugin.g.a.bfN());
      pin(com.tencent.mm.plugin.h.a.bjc());
      pin(com.tencent.mm.plugin.i.c.bIB());
      pin(com.tencent.mm.plugin.i.b.bIA());
      pin(com.tencent.mm.plugin.t.a.caK());
      pin(com.tencent.mm.plugin.m.b.bPG());
      pin(com.tencent.mm.plugin.c.a.asD());
      pin(com.tencent.mm.plugin.s.a.bZY());
      pin(com.tencent.mm.plugin.r.a.bWR());
      pin(o.vOB);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.m.a.a.class, new com.tencent.mm.plugin.m.a());
      ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(com.tencent.mm.plugin.g.a.bfN());
      com.tencent.mm.ui.f.a.a.a(new PluginComm.1(this));
    }
    AppMethodBeat.o(79088);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151608);
    com.tencent.mm.sdk.b.a.ymk.c(this.kSY);
    AppMethodBeat.o(151608);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151609);
    com.tencent.mm.sdk.b.a.ymk.d(this.kSY);
    AppMethodBeat.o(151609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.PluginComm
 * JD-Core Version:    0.7.0.1
 */