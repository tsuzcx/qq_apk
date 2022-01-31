package a.j.b.a.c.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum e$a
{
  public final boolean Ceu;
  public final boolean Cev;
  
  static
  {
    AppMethodBeat.i(119797);
    Ceq = new a("NON_STABLE_DECLARED", 0, false, false);
    Cer = new a("STABLE_DECLARED", 1, true, false);
    Ces = new a("NON_STABLE_SYNTHESIZED", 2, false, true);
    Cet = new a("STABLE_SYNTHESIZED", 3, true, true);
    Cew = new a[] { Ceq, Cer, Ces, Cet };
    AppMethodBeat.o(119797);
  }
  
  private e$a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.Ceu = paramBoolean1;
    this.Cev = paramBoolean2;
  }
  
  public static a ar(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return Cet;
      }
      return Cer;
    }
    if (paramBoolean2) {
      return Ces;
    }
    return Ceq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.b.e.a
 * JD-Core Version:    0.7.0.1
 */