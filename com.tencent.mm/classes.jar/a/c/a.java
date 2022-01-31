package a.c;

import a.b.b;
import a.b.c;
import a.d.b.g;
import java.io.Closeable;

public final class a
{
  public static final void a(Closeable paramCloseable, Throwable paramThrowable)
  {
    if (paramCloseable != null)
    {
      if (paramThrowable == null) {
        paramCloseable.close();
      }
    }
    else {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable)
    {
      g.k(paramThrowable, "$receiver");
      g.k(paramCloseable, "exception");
      c.xom.a(paramThrowable, paramCloseable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.c.a
 * JD-Core Version:    0.7.0.1
 */