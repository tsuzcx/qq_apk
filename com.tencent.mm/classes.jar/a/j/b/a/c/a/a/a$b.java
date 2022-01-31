package a.j.b.a.c.a.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$b
{
  final int BNe;
  final b.b BUx;
  
  public a$b(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(119126);
    this.BUx = paramb;
    this.BNe = paramInt;
    AppMethodBeat.o(119126);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119129);
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label65;
      }
      paramObject = (b)paramObject;
      if (!j.e(this.BUx, paramObject.BUx)) {
        break label65;
      }
      if (this.BNe != paramObject.BNe) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119129);
      return true;
    }
    label65:
    AppMethodBeat.o(119129);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(119128);
    b.b localb = this.BUx;
    if (localb != null) {}
    for (int i = localb.hashCode();; i = 0)
    {
      int j = this.BNe;
      AppMethodBeat.o(119128);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119127);
    String str = "KindWithArity(kind=" + this.BUx + ", arity=" + this.BNe + ")";
    AppMethodBeat.o(119127);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */