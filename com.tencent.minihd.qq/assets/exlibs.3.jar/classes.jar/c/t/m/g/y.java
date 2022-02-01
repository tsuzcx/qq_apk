package c.t.m.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class y
{
  public String a = null;
  public String b = null;
  public int[] c = null;
  public String d = "";
  public String e = null;
  public boolean f = true;
  public boolean g = true;
  public Map h = new HashMap();
  public byte[] i = null;
  public int j = 32768;
  public int k = 20000;
  public int l = 30000;
  public int m = 40000;
  public int n = 3;
  public boolean o = true;
  public String p = "";
  private List q = new ArrayList();
  private volatile boolean r = false;
  
  public y(String paramString, int[] paramArrayOfInt)
  {
    this.a = paramString;
    this.c = paramArrayOfInt;
    if ((this.c != null) && (this.c[0] != -1)) {}
    for (this.d = (this.a + ":" + this.c[0]);; this.d = this.a)
    {
      this.p = ay.b(this.a);
      return;
    }
  }
  
  public final void a()
  {
    this.j = 32768;
  }
  
  public final void a(aa paramaa)
  {
    this.q.add(paramaa);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    this.h.put(paramString1, paramString2);
  }
  
  public final void b()
  {
    this.k = 20000;
  }
  
  public final void c()
  {
    this.l = 30000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.y
 * JD-Core Version:    0.7.0.1
 */