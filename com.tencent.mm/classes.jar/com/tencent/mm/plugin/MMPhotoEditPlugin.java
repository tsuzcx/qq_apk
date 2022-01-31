package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.ai.p;
import com.tencent.mm.api.o;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public class MMPhotoEditPlugin
  extends f
  implements c
{
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116300);
    com.tencent.mm.api.s.bWe = new a.a();
    AppMethodBeat.o(116300);
  }
  
  public void installed() {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116301);
    paramc = a.yix;
    ab.i("MicroMsg.MediaSecurityReport", "init");
    com.tencent.mm.kernel.g.Rc().a(110, paramc);
    com.tencent.mm.kernel.g.Rc().a(149, paramc);
    com.tencent.mm.kernel.g.b(o.class, a.yix);
    AppMethodBeat.o(116301);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116302);
    com.tencent.mm.kernel.g.F(o.class);
    a locala = a.yix;
    ab.i("MicroMsg.MediaSecurityReport", "release");
    com.tencent.mm.kernel.g.Rc().b(110, locala);
    com.tencent.mm.kernel.g.Rc().b(149, locala);
    locala.yiy.clear();
    AppMethodBeat.o(116302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.MMPhotoEditPlugin
 * JD-Core Version:    0.7.0.1
 */