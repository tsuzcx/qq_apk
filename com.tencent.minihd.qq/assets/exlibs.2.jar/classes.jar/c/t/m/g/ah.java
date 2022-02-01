package c.t.m.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ah
  extends bb
{
  private static Map c;
  public Map a = null;
  public long b = 0L;
  
  public final void a(az paramaz)
  {
    if (c == null)
    {
      c = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("");
      c.put(Integer.valueOf(0), localArrayList);
    }
    this.a = ((Map)paramaz.a(c, 0, false));
    this.b = paramaz.a(this.b, 1, false);
  }
  
  public final void a(ba paramba)
  {
    if (this.a != null) {
      paramba.a(this.a, 0);
    }
    paramba.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.ah
 * JD-Core Version:    0.7.0.1
 */