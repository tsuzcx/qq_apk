package a.j.b.a.c.n;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public final int CEY;
  public final String uCl;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(122940);
    this.uCl = paramString;
    this.CEY = paramInt;
    AppMethodBeat.o(122940);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122943);
    if (this != paramObject)
    {
      if (!(paramObject instanceof f)) {
        break label65;
      }
      paramObject = (f)paramObject;
      if (!j.e(this.uCl, paramObject.uCl)) {
        break label65;
      }
      if (this.CEY != paramObject.CEY) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(122943);
      return true;
    }
    label65:
    AppMethodBeat.o(122943);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(122942);
    String str = this.uCl;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.CEY;
      AppMethodBeat.o(122942);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122941);
    String str = "NumberWithRadix(number=" + this.uCl + ", radix=" + this.CEY + ")";
    AppMethodBeat.o(122941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.n.f
 * JD-Core Version:    0.7.0.1
 */