package a.j.b.a.c.m;

import a.f.b.j;
import a.j.b.a.c.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract class l
  implements b
{
  private final String description;
  
  private l(String paramString)
  {
    this.description = paramString;
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final String i(t paramt)
  {
    j.q(paramt, "functionDescriptor");
    return b.a.a(this, paramt);
  }
  
  public static final class a
    extends l
  {
    private final int n;
    
    public a(int paramInt) {}
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(122899);
      j.q(paramt, "functionDescriptor");
      if (paramt.edu().size() >= this.n)
      {
        AppMethodBeat.o(122899);
        return true;
      }
      AppMethodBeat.o(122899);
      return false;
    }
  }
  
  public static final class b
    extends l
  {
    private final int n = 2;
    
    public b()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(122901);
      j.q(paramt, "functionDescriptor");
      if (paramt.edu().size() == this.n)
      {
        AppMethodBeat.o(122901);
        return true;
      }
      AppMethodBeat.o(122901);
      return false;
    }
  }
  
  public static final class d
    extends l
  {
    public static final d CEx;
    
    static
    {
      AppMethodBeat.i(122905);
      CEx = new d();
      AppMethodBeat.o(122905);
    }
    
    private d()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(122904);
      j.q(paramt, "functionDescriptor");
      if (paramt.edu().size() == 1)
      {
        AppMethodBeat.o(122904);
        return true;
      }
      AppMethodBeat.o(122904);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.m.l
 * JD-Core Version:    0.7.0.1
 */