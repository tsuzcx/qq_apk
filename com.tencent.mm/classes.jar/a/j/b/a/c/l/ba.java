package a.j.b.a.c.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ba
{
  private final boolean CCb;
  public final boolean CCc;
  private final int CCd;
  public final String label;
  
  static
  {
    AppMethodBeat.i(122707);
    ba localba1 = new ba("INVARIANT", 0, "", true, true, 0);
    CBX = localba1;
    ba localba2 = new ba("IN_VARIANCE", 1, "in", true, false, -1);
    CBY = localba2;
    ba localba3 = new ba("OUT_VARIANCE", 2, "out", false, true, 1);
    CBZ = localba3;
    CCa = new ba[] { localba1, localba2, localba3 };
    AppMethodBeat.o(122707);
  }
  
  private ba(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(122708);
    this.label = paramString;
    this.CCb = paramBoolean1;
    this.CCc = paramBoolean2;
    this.CCd = paramInt;
    AppMethodBeat.o(122708);
  }
  
  public final String toString()
  {
    return this.label;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.l.ba
 * JD-Core Version:    0.7.0.1
 */