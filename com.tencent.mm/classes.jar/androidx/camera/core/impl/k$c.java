package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$c
{
  static
  {
    AppMethodBeat.i(198735);
    KX = new c("UNKNOWN", 0);
    KY = new c("INACTIVE", 1);
    KZ = new c("SCANNING", 2);
    La = new c("PASSIVE_FOCUSED", 3);
    Lb = new c("PASSIVE_NOT_FOCUSED", 4);
    Lc = new c("LOCKED_FOCUSED", 5);
    Ld = new c("LOCKED_NOT_FOCUSED", 6);
    Le = new c[] { KX, KY, KZ, La, Lb, Lc, Ld };
    AppMethodBeat.o(198735);
  }
  
  private k$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.k.c
 * JD-Core Version:    0.7.0.1
 */