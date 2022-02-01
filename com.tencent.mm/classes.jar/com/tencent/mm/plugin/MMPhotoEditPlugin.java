package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.w;
import com.tencent.mm.b.a;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public class MMPhotoEditPlugin
  extends f
  implements c
{
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(9276);
    com.tencent.mm.api.ab.diQ = new b.a();
    AppMethodBeat.o(9276);
  }
  
  public void installed() {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(9277);
    paramc = a.NCE;
    Log.i("MicroMsg.MediaSecurityReport", "init");
    com.tencent.mm.kernel.g.azz().a(110, paramc);
    com.tencent.mm.kernel.g.azz().a(149, paramc);
    com.tencent.mm.kernel.g.b(w.class, a.NCE);
    AppMethodBeat.o(9277);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9278);
    com.tencent.mm.kernel.g.ag(w.class);
    a locala = a.NCE;
    Log.i("MicroMsg.MediaSecurityReport", "release");
    com.tencent.mm.kernel.g.azz().b(110, locala);
    com.tencent.mm.kernel.g.azz().b(149, locala);
    locala.uUF.clear();
    AppMethodBeat.o(9278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.MMPhotoEditPlugin
 * JD-Core Version:    0.7.0.1
 */