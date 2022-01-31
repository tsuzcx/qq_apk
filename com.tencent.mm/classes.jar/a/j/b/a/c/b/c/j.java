package a.j.b.a.c.b.c;

import a.j.b.a.c.b.a.b;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.f;
import a.j.b.a.c.h.c;

public abstract class j
  extends b
  implements l
{
  protected final f BYN;
  
  public j(g paramg, f paramf)
  {
    super(paramg);
    this.BYN = paramf;
  }
  
  public static String h(l paraml)
  {
    try
    {
      String str = c.CtB.k(paraml) + "[" + paraml.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(paraml)) + "]";
      return str;
    }
    catch (Throwable localThrowable) {}
    return paraml.getClass().getSimpleName() + " " + paraml.edF();
  }
  
  public l edC()
  {
    return this;
  }
  
  public final f edF()
  {
    return this.BYN;
  }
  
  public String toString()
  {
    return h(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.c.j
 * JD-Core Version:    0.7.0.1
 */