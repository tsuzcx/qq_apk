package a.d.b;

import a.d.b;
import a.f.c;
import java.io.Serializable;

public abstract class a
  implements a.f.a, Serializable
{
  public static final Object xop = ;
  private transient a.f.a xon;
  protected final Object xoo;
  
  public a()
  {
    this(xop);
  }
  
  private a(Object paramObject)
  {
    this.xoo = paramObject;
  }
  
  public final Object E(Object... paramVarArgs)
  {
    return cUg().E(paramVarArgs);
  }
  
  protected abstract a.f.a cUd();
  
  public final Object cUe()
  {
    return this.xoo;
  }
  
  public final a.f.a cUf()
  {
    a.f.a locala2 = this.xon;
    a.f.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = cUd();
      this.xon = locala1;
    }
    return locala1;
  }
  
  protected a.f.a cUg()
  {
    a.f.a locala = cUf();
    if (locala == this) {
      throw new b();
    }
    return locala;
  }
  
  public c cUh()
  {
    throw new AbstractMethodError();
  }
  
  public String getName()
  {
    throw new AbstractMethodError();
  }
  
  public String getSignature()
  {
    throw new AbstractMethodError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.d.b.a
 * JD-Core Version:    0.7.0.1
 */