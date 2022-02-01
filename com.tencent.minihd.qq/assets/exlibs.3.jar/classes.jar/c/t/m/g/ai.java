package c.t.m.g;

import java.util.HashMap;
import java.util.Map;

public final class ai
  extends bb
{
  private static Map c;
  public Map a = null;
  public int b = 0;
  
  public final void a(az paramaz)
  {
    if (c == null)
    {
      c = new HashMap();
      c.put(Integer.valueOf(0), Byte.valueOf((byte)0));
    }
    this.a = ((Map)paramaz.a(c, 0, true));
    this.b = paramaz.a(this.b, 1, true);
  }
  
  public final void a(ba paramba)
  {
    paramba.a(this.a, 0);
    paramba.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.ai
 * JD-Core Version:    0.7.0.1
 */