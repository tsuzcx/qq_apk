package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.api.w;
import com.tencent.mm.b.a;
import com.tencent.mm.cg.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public class MMPhotoEditPlugin
  extends f
  implements c
{
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(9276);
    com.tencent.mm.api.ab.fax = new b.a();
    AppMethodBeat.o(9276);
  }
  
  public void installed() {}
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(9277);
    paramc = a.UQg;
    Log.i("MicroMsg.MediaSecurityReport", "init");
    h.aGY().a(110, paramc);
    h.aGY().a(149, paramc);
    h.b(w.class, a.UQg);
    AppMethodBeat.o(9277);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9278);
    h.af(w.class);
    a locala = a.UQg;
    Log.i("MicroMsg.MediaSecurityReport", "release");
    h.aGY().b(110, locala);
    h.aGY().b(149, locala);
    locala.zKV.clear();
    AppMethodBeat.o(9278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.MMPhotoEditPlugin
 * JD-Core Version:    0.7.0.1
 */