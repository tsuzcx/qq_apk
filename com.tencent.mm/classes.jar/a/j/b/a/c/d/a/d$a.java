package a.j.b.a.c.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  private final boolean CcA;
  private final String Ccz;
  
  static
  {
    AppMethodBeat.i(119666);
    a locala1 = new a("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
    Ccv = locala1;
    a locala2 = new a("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
    Ccw = locala2;
    a locala3 = new a("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
    Ccx = locala3;
    Ccy = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(119666);
  }
  
  private d$a(String paramString, boolean paramBoolean)
  {
    this.Ccz = paramString;
    this.CcA = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.d.a
 * JD-Core Version:    0.7.0.1
 */