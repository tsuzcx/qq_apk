package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.api.x;
import com.tencent.mm.b.a;
import com.tencent.mm.cb.a;
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
    com.tencent.mm.api.ac.hdY = new b.a();
    AppMethodBeat.o(9276);
  }
  
  public void installed() {}
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(9277);
    paramc = a.aclp;
    Log.i("MicroMsg.MediaSecurityReport", "init");
    h.aZW().a(110, paramc);
    h.aZW().a(149, paramc);
    h.b(x.class, a.aclp);
    AppMethodBeat.o(9277);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9278);
    h.ay(x.class);
    a locala = a.aclp;
    Log.i("MicroMsg.MediaSecurityReport", "release");
    h.aZW().b(110, locala);
    h.aZW().b(149, locala);
    locala.EVH.clear();
    AppMethodBeat.o(9278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.MMPhotoEditPlugin
 * JD-Core Version:    0.7.0.1
 */