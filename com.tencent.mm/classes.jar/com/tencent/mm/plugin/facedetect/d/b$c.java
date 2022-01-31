package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b$c
{
  private static String TAG = "MicroMsg.IFaceMotion.Factory";
  
  public static b a(h.a parama)
  {
    AppMethodBeat.i(296);
    if (parama == null)
    {
      AppMethodBeat.o(296);
      return null;
    }
    if (parama.type == 4)
    {
      ab.i(TAG, "hy: is read number");
      parama = new d(parama.mik);
      AppMethodBeat.o(296);
      return parama;
    }
    ab.i(TAG, "hy: is normal");
    parama = new c(parama.gLL, parama.mih);
    AppMethodBeat.o(296);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.b.c
 * JD-Core Version:    0.7.0.1
 */