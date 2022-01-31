package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.b;

public final class a
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  private static j mgk;
  private static o mgl;
  private static i mgm;
  private static m mgn;
  private static com.tencent.mm.plugin.facedetectaction.b.c mgo;
  private static k mgp;
  private b gnD = null;
  
  static
  {
    AppMethodBeat.i(56);
    mgk = new j();
    mgl = new o();
    mgm = new i();
    mgn = new m();
    mgo = new com.tencent.mm.plugin.facedetectaction.b.c();
    mgp = new k();
    AppMethodBeat.o(56);
  }
  
  private static void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(53);
    if (paramc == null)
    {
      ab.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
      AppMethodBeat.o(53);
      return;
    }
    if (com.tencent.mm.sdk.b.a.ymk.e(paramc))
    {
      ab.w("MicroMsg.TaskInitFace", "hy: already has listener");
      AppMethodBeat.o(53);
      return;
    }
    com.tencent.mm.sdk.b.a.ymk.c(paramc);
    AppMethodBeat.o(53);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.a
 * JD-Core Version:    0.7.0.1
 */