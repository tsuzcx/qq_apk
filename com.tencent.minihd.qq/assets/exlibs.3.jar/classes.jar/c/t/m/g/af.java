package c.t.m.g;

import java.util.HashMap;
import java.util.Map;

public final class af
  extends bb
{
  private static Map g;
  private static ah h;
  private static ad i;
  private static Map j;
  public Map a = null;
  public ah b = null;
  public ad c = null;
  private String d = "";
  private int e = 0;
  private Map f = null;
  
  public final void a(az paramaz)
  {
    this.d = paramaz.a(0, true);
    this.e = paramaz.a(this.e, 1, true);
    if (g == null)
    {
      g = new HashMap();
      ag localag = new ag();
      g.put("", localag);
    }
    this.a = ((Map)paramaz.a(g, 2, true));
    if (h == null) {
      h = new ah();
    }
    this.b = ((ah)paramaz.a(h, 3, false));
    if (i == null) {
      i = new ad();
    }
    this.c = ((ad)paramaz.a(i, 4, false));
    if (j == null)
    {
      j = new HashMap();
      j.put("", "");
    }
    this.f = ((Map)paramaz.a(j, 5, false));
  }
  
  public final void a(ba paramba)
  {
    paramba.a(this.d, 0);
    paramba.a(this.e, 1);
    paramba.a(this.a, 2);
    if (this.b != null) {
      paramba.a(this.b, 3);
    }
    if (this.c != null) {
      paramba.a(this.c, 4);
    }
    if (this.f != null) {
      paramba.a(this.f, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.af
 * JD-Core Version:    0.7.0.1
 */