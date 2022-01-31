package c.t.m.g;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  public String a;
  public Map<String, v> b;
  
  public u(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.u
 * JD-Core Version:    0.7.0.1
 */