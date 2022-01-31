package a.b;

import a.d.b.g;

public class a
  extends b
{
  public final void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    g.k(paramThrowable1, "cause");
    g.k(paramThrowable2, "exception");
    paramThrowable1.addSuppressed(paramThrowable2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.b.a
 * JD-Core Version:    0.7.0.1
 */