package a.j.b.a.c.e.b.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$a
  extends f
{
  public final String desc;
  public final String name;
  
  public f$a(String paramString1, String paramString2)
  {
    super((byte)0);
    AppMethodBeat.i(121311);
    this.name = paramString1;
    this.desc = paramString2;
    AppMethodBeat.o(121311);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121313);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!j.e(this.name, paramObject.name)) || (!j.e(this.desc, paramObject.desc))) {}
      }
    }
    else
    {
      AppMethodBeat.o(121313);
      return true;
    }
    AppMethodBeat.o(121313);
    return false;
  }
  
  public final String getDesc()
  {
    return this.desc;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(121312);
    String str = this.name;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.desc;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(121312);
      return i * 31 + j;
    }
  }
  
  public final String mk()
  {
    AppMethodBeat.i(121310);
    String str = this.name + ':' + this.desc;
    AppMethodBeat.o(121310);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.f.a
 * JD-Core Version:    0.7.0.1
 */