package a.j.b.a.c.l;

import a.j.b.a.c.b.a.g;
import a.j.b.a.c.i.e.h;
import a.v;
import java.util.List;

public abstract class bb
  extends w
{
  public bb()
  {
    super((byte)0);
  }
  
  public final g ecM()
  {
    return eoM().ecM();
  }
  
  public final h ecq()
  {
    return eoM().ecq();
  }
  
  public final boolean egH()
  {
    return eoM().egH();
  }
  
  public final List<ap> enR()
  {
    return eoM().enR();
  }
  
  public final an enU()
  {
    return eoM().enU();
  }
  
  public boolean eoD()
  {
    return true;
  }
  
  public final az eoL()
  {
    for (w localw = eoM(); (localw instanceof bb); localw = ((bb)localw).eoM()) {}
    if (localw == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }
    return (az)localw;
  }
  
  protected abstract w eoM();
  
  public String toString()
  {
    if (eoD()) {
      return eoM().toString();
    }
    return "<Not computed yet>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.l.bb
 * JD-Core Version:    0.7.0.1
 */