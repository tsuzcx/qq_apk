package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.t;
import com.tencent.mm.bz.a;
import com.tencent.mm.c.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.ConcurrentHashMap;

public class MMPhotoEditPlugin
  extends f
  implements c
{
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(9276);
    com.tencent.mm.api.y.cSw = new c.a();
    AppMethodBeat.o(9276);
  }
  
  public void installed() {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(9277);
    paramc = a.Ipg;
    ae.i("MicroMsg.MediaSecurityReport", "init");
    com.tencent.mm.kernel.g.ajj().a(110, paramc);
    com.tencent.mm.kernel.g.ajj().a(149, paramc);
    com.tencent.mm.kernel.g.b(t.class, a.Ipg);
    AppMethodBeat.o(9277);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9278);
    com.tencent.mm.kernel.g.ac(t.class);
    a locala = a.Ipg;
    ae.i("MicroMsg.MediaSecurityReport", "release");
    com.tencent.mm.kernel.g.ajj().b(110, locala);
    com.tencent.mm.kernel.g.ajj().b(149, locala);
    locala.wYT.clear();
    AppMethodBeat.o(9278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.MMPhotoEditPlugin
 * JD-Core Version:    0.7.0.1
 */