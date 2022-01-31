package a.j.b.a.c.l;

import a.j.b.a.c.b.a.a;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.l.a.m;
import java.util.List;

public abstract class w
  implements a
{
  public abstract h ecq();
  
  public abstract boolean egH();
  
  public abstract List<ap> enR();
  
  public abstract an enU();
  
  public abstract az eoL();
  
  public final boolean equals(Object paramObject)
  {
    if ((w)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof w)) {
      return false;
    }
    return (egH() == ((w)paramObject).egH()) && (m.CCs.a(eoL(), ((w)paramObject).eoL()));
  }
  
  public final int hashCode()
  {
    if (y.an(this)) {
      return super.hashCode();
    }
    int j = enU().hashCode();
    int k = enR().hashCode();
    if (egH()) {}
    for (int i = 1;; i = 0) {
      return i + (j * 31 + k) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.l.w
 * JD-Core Version:    0.7.0.1
 */