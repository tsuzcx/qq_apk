package c.t.m.g;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public final class z
{
  public int a = 1;
  public byte[] b = null;
  public int c = 0;
  public int d = 0;
  public HttpResponse e;
  public int f = 0;
  
  public final int a()
  {
    return this.a;
  }
  
  public final String a(String paramString)
  {
    if (this.e != null)
    {
      paramString = this.e.getFirstHeader(paramString);
      if (paramString != null) {
        return paramString.getValue();
      }
    }
    return null;
  }
  
  public final byte[] b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.z
 * JD-Core Version:    0.7.0.1
 */