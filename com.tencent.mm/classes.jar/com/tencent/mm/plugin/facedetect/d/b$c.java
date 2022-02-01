package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b$c
{
  private static String TAG = "MicroMsg.IFaceMotion.Factory";
  
  public static b a(h.a parama)
  {
    AppMethodBeat.i(103815);
    if (parama == null)
    {
      AppMethodBeat.o(103815);
      return null;
    }
    if (parama.type == 4)
    {
      ae.i(TAG, "hy: is read number");
      parama = new d(parama.rpA);
      AppMethodBeat.o(103815);
      return parama;
    }
    ae.i(TAG, "hy: is normal");
    parama = new c(parama.jvz, parama.rpx);
    AppMethodBeat.o(103815);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.b.c
 * JD-Core Version:    0.7.0.1
 */