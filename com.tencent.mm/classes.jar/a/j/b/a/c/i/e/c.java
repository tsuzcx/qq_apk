package a.j.b.a.c.i.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c
{
  public abstract int enZ();
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public static final class a
    extends c
  {
    private static final int Cxk;
    public static final a Cxl;
    
    static
    {
      AppMethodBeat.i(122176);
      Cxl = new a();
      d.a locala = d.CxM;
      int i = d.eoh();
      locala = d.CxM;
      int j = d.eof();
      locala = d.CxM;
      Cxk = i & ((j | d.eog()) ^ 0xFFFFFFFF);
      AppMethodBeat.o(122176);
    }
    
    public final int enZ()
    {
      return Cxk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.i.e.c
 * JD-Core Version:    0.7.0.1
 */