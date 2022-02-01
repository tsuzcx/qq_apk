package c.t.m.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ae
  extends bb
{
  private static ArrayList k;
  private static Map l;
  private String a = "";
  private String b = "";
  private ArrayList c = null;
  private String d = "";
  private String e = "";
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private String i = "";
  private Map j = null;
  
  public ae() {}
  
  public ae(String paramString1, String paramString2, ArrayList paramArrayList, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramString5;
    this.j = null;
  }
  
  public final void a(az paramaz)
  {
    this.a = paramaz.a(0, true);
    this.b = paramaz.a(1, true);
    if (k == null)
    {
      k = new ArrayList();
      k.add("");
    }
    this.c = ((ArrayList)paramaz.a(k, 2, true));
    this.d = paramaz.a(3, false);
    this.e = paramaz.a(4, false);
    this.f = paramaz.a(this.f, 5, false);
    this.g = paramaz.a(this.g, 6, false);
    this.h = paramaz.a(this.h, 7, false);
    this.i = paramaz.a(8, false);
    if (l == null)
    {
      l = new HashMap();
      l.put("", "");
    }
    this.j = ((Map)paramaz.a(l, 9, false));
  }
  
  public final void a(ba paramba)
  {
    paramba.a(this.a, 0);
    paramba.a(this.b, 1);
    paramba.a(this.c, 2);
    if (this.d != null) {
      paramba.a(this.d, 3);
    }
    if (this.e != null) {
      paramba.a(this.e, 4);
    }
    paramba.a(this.f, 5);
    paramba.a(this.g, 6);
    paramba.a(this.h, 7);
    if (this.i != null) {
      paramba.a(this.i, 8);
    }
    if (this.j != null) {
      paramba.a(this.j, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.ae
 * JD-Core Version:    0.7.0.1
 */