package a.j.b.a.c.i;

import a.f.b.j;
import a.j.b.a.c.b.b;

public abstract class h
  extends i
{
  protected abstract void a(b paramb1, b paramb2);
  
  public final void b(b paramb1, b paramb2)
  {
    j.q(paramb1, "fromSuper");
    j.q(paramb2, "fromCurrent");
    a(paramb1, paramb2);
  }
  
  public final void c(b paramb1, b paramb2)
  {
    j.q(paramb1, "first");
    j.q(paramb2, "second");
    a(paramb1, paramb2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.i.h
 * JD-Core Version:    0.7.0.1
 */