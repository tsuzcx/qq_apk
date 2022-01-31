package a.j.b.a.c.l;

import a.j.b.a.c.b.a.g;
import a.l.m;
import java.util.Iterator;
import java.util.List;

public abstract class ad
  extends az
{
  public ad()
  {
    super((byte)0);
  }
  
  public abstract ad d(g paramg);
  
  public abstract ad ss(boolean paramBoolean);
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = ecM().iterator();
    while (localIterator.hasNext())
    {
      a.j.b.a.c.b.a.c localc = (a.j.b.a.c.b.a.c)localIterator.next();
      m.a((StringBuilder)localObject, new String[] { "[", a.j.b.a.c.h.c.a(a.j.b.a.c.h.c.CtB, localc), "] " });
    }
    ((StringBuilder)localObject).append(enU());
    if (!enR().isEmpty()) {
      a.a.j.a((Iterable)enR(), (Appendable)localObject, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, null, null, 112);
    }
    if (egH()) {
      ((StringBuilder)localObject).append("?");
    }
    localObject = ((StringBuilder)localObject).toString();
    a.f.b.j.p(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.l.ad
 * JD-Core Version:    0.7.0.1
 */