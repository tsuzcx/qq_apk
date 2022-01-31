package a.j.b.a.c.b;

import a.f.b.j;
import a.j.b.a.c.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class aa$a
{
  final a BUp;
  final List<Integer> BWx;
  
  public aa$a(a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(119280);
    this.BUp = parama;
    this.BWx = paramList;
    AppMethodBeat.o(119280);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119283);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!j.e(this.BUp, paramObject.BUp)) || (!j.e(this.BWx, paramObject.BWx))) {}
      }
    }
    else
    {
      AppMethodBeat.o(119283);
      return true;
    }
    AppMethodBeat.o(119283);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(119282);
    Object localObject = this.BUp;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.BWx;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(119282);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119281);
    String str = "ClassRequest(classId=" + this.BUp + ", typeParametersCount=" + this.BWx + ")";
    AppMethodBeat.o(119281);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.b.aa.a
 * JD-Core Version:    0.7.0.1
 */