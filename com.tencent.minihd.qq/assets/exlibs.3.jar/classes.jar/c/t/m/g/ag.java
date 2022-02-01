package c.t.m.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ag
  extends bb
{
  private static ArrayList e;
  private static Map f;
  public ArrayList a = null;
  public String b = "";
  private int c = 0;
  private Map d = null;
  
  public final void a(az paramaz)
  {
    this.c = paramaz.a(this.c, 0, true);
    if (e == null)
    {
      e = new ArrayList();
      e.add("");
    }
    this.a = ((ArrayList)paramaz.a(e, 1, true));
    this.b = paramaz.a(2, false);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)paramaz.a(f, 3, false));
  }
  
  public final void a(ba paramba)
  {
    paramba.a(this.c, 0);
    paramba.a(this.a, 1);
    if (this.b != null) {
      paramba.a(this.b, 2);
    }
    if (this.d != null) {
      paramba.a(this.d, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.ag
 * JD-Core Version:    0.7.0.1
 */