package a.j.b.a.c.e.b.a;

import a.a.aj;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class m
{
  private final String CqA;
  private final LinkedHashMap<String, String> Cqy;
  final Set<String> Cqz;
  
  public m(String paramString)
  {
    AppMethodBeat.i(121347);
    this.CqA = paramString;
    this.Cqy = new LinkedHashMap();
    this.Cqz = ((Set)new LinkedHashSet());
    AppMethodBeat.o(121347);
  }
  
  public final Set<String> elY()
  {
    AppMethodBeat.i(121342);
    Set localSet = this.Cqy.keySet();
    j.p(localSet, "packageParts.keys");
    AppMethodBeat.o(121342);
    return localSet;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121344);
    if (((paramObject instanceof m)) && (j.e(((m)paramObject).CqA, this.CqA)) && (j.e(((m)paramObject).Cqy, this.Cqy)) && (j.e(((m)paramObject).Cqz, this.Cqz)))
    {
      AppMethodBeat.o(121344);
      return true;
    }
    AppMethodBeat.o(121344);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(121345);
    int i = this.CqA.hashCode();
    int j = this.Cqy.hashCode();
    int k = this.Cqz.hashCode();
    AppMethodBeat.o(121345);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void jt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121343);
    j.q(paramString1, "partInternalName");
    ((Map)this.Cqy).put(paramString1, paramString2);
    AppMethodBeat.o(121343);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121346);
    String str = aj.a(elY(), (Iterable)this.Cqz).toString();
    AppMethodBeat.o(121346);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.m
 * JD-Core Version:    0.7.0.1
 */