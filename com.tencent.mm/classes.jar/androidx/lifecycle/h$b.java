package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$b
{
  static
  {
    AppMethodBeat.i(213361);
    ZO = new b("DESTROYED", 0);
    ZP = new b("INITIALIZED", 1);
    ZQ = new b("CREATED", 2);
    ZR = new b("STARTED", 3);
    ZS = new b("RESUMED", 4);
    ZT = new b[] { ZO, ZP, ZQ, ZR, ZS };
    AppMethodBeat.o(213361);
  }
  
  private h$b() {}
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(213359);
    if (compareTo(paramb) >= 0)
    {
      AppMethodBeat.o(213359);
      return true;
    }
    AppMethodBeat.o(213359);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.h.b
 * JD-Core Version:    0.7.0.1
 */