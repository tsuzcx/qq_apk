package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$a
{
  static
  {
    AppMethodBeat.i(198752);
    KL = new a("UNKNOWN", 0);
    KM = new a("INACTIVE", 1);
    KN = new a("SEARCHING", 2);
    KO = new a("FLASH_REQUIRED", 3);
    KP = new a("CONVERGED", 4);
    KQ = new a("LOCKED", 5);
    KR = new a[] { KL, KM, KN, KO, KP, KQ };
    AppMethodBeat.o(198752);
  }
  
  private k$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.k.a
 * JD-Core Version:    0.7.0.1
 */