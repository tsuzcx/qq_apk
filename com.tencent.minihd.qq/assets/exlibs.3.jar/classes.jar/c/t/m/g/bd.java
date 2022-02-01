package c.t.m.g;

import java.util.HashMap;
import java.util.Map;

public final class bd
  extends bb
{
  private static byte[] k = null;
  private static Map l = null;
  public short a = 3;
  public int b = 0;
  public String c = null;
  public String d = null;
  public byte[] e;
  private byte f = 0;
  private int g = 0;
  private int h = 0;
  private Map i;
  private Map j;
  
  public final void a(az paramaz)
  {
    try
    {
      this.a = paramaz.a(this.a, 1, true);
      this.f = paramaz.a(this.f, 2, true);
      this.g = paramaz.a(this.g, 3, true);
      this.b = paramaz.a(this.b, 4, true);
      this.c = paramaz.a(5, true);
      this.d = paramaz.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      Object localObject = k;
      this.e = ((byte[])paramaz.b(7, true));
      this.h = paramaz.a(this.h, 8, true);
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.i = ((Map)paramaz.a(l, 9, true));
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.j = ((Map)paramaz.a(l, 10, true));
      return;
    }
    catch (Exception paramaz)
    {
      paramaz.printStackTrace();
      throw new RuntimeException(paramaz);
    }
  }
  
  public final void a(ba paramba)
  {
    paramba.a(this.a, 1);
    paramba.a(this.f, 2);
    paramba.a(this.g, 3);
    paramba.a(this.b, 4);
    paramba.a(this.c, 5);
    paramba.a(this.d, 6);
    paramba.a(this.e, 7);
    paramba.a(this.h, 8);
    paramba.a(this.i, 9);
    paramba.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bd
 * JD-Core Version:    0.7.0.1
 */