package a.f.b;

import a.f.b;
import a.j.a;
import a.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public abstract class c
  implements a, Serializable
{
  public static final Object BNj = ;
  private transient a BNh;
  protected final Object BNi;
  
  public c()
  {
    this(BNj);
  }
  
  protected c(Object paramObject)
  {
    this.BNi = paramObject;
  }
  
  public final Object X(Object... paramVarArgs)
  {
    return ebd().X(paramVarArgs);
  }
  
  public String dyz()
  {
    throw new AbstractMethodError();
  }
  
  protected abstract a eba();
  
  public final Object ebb()
  {
    return this.BNi;
  }
  
  public final a ebc()
  {
    a locala2 = this.BNh;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = eba();
      this.BNh = locala1;
    }
    return locala1;
  }
  
  protected a ebd()
  {
    a locala = ebc();
    if (locala == this) {
      throw new b();
    }
    return locala;
  }
  
  public d ebe()
  {
    throw new AbstractMethodError();
  }
  
  public String getName()
  {
    throw new AbstractMethodError();
  }
  
  static final class a
    implements Serializable
  {
    private static final a BNk;
    
    static
    {
      AppMethodBeat.i(55898);
      BNk = new a();
      AppMethodBeat.o(55898);
    }
    
    private Object readResolve()
    {
      return BNk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.c
 * JD-Core Version:    0.7.0.1
 */