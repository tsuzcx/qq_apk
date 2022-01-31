package a.j.b.a.c.e.b.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class f
{
  public abstract String getDesc();
  
  public abstract String getName();
  
  public abstract String mk();
  
  public final String toString()
  {
    return mk();
  }
  
  public static final class b
    extends f
  {
    public final String desc;
    public final String name;
    
    public b(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(121315);
      this.name = paramString1;
      this.desc = paramString2;
      AppMethodBeat.o(121315);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(121317);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!j.e(this.name, paramObject.name)) || (!j.e(this.desc, paramObject.desc))) {}
        }
      }
      else
      {
        AppMethodBeat.o(121317);
        return true;
      }
      AppMethodBeat.o(121317);
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
      AppMethodBeat.i(121316);
      String str = this.name;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.desc;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(121316);
        return i * 31 + j;
      }
    }
    
    public final String mk()
    {
      AppMethodBeat.i(121314);
      String str = this.name + this.desc;
      AppMethodBeat.o(121314);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.f
 * JD-Core Version:    0.7.0.1
 */