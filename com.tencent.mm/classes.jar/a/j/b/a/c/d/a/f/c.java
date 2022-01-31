package a.j.b.a.c.d.a.f;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c<T>
{
  final g Cho;
  final T result;
  
  public c(T paramT, g paramg)
  {
    this.result = paramT;
    this.Cho = paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(120093);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!j.e(this.result, paramObject.result)) || (!j.e(this.Cho, paramObject.Cho))) {}
      }
    }
    else
    {
      AppMethodBeat.o(120093);
      return true;
    }
    AppMethodBeat.o(120093);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(120092);
    Object localObject = this.result;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Cho;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(120092);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120091);
    String str = "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.Cho + ")";
    AppMethodBeat.o(120091);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.c
 * JD-Core Version:    0.7.0.1
 */