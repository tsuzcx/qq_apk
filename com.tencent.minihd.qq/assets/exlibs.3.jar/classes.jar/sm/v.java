package sm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class v
  extends JceStruct
  implements Cloneable
{
  static n s;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public int h = 0;
  public int i = 0;
  public n j = null;
  public String k = "";
  public String l = "";
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public String q = "";
  public short r = 0;
  
  static
  {
    if (!v.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      t = bool;
      return;
    }
  }
  
  public v()
  {
    a(this.a);
    b(this.b);
    c(this.c);
    d(this.d);
    e(this.e);
    f(this.f);
    g(this.g);
    a(this.h);
    b(this.i);
    a(this.j);
    h(this.k);
    i(this.l);
    c(this.m);
    d(this.n);
    e(this.o);
    f(this.p);
    j(this.q);
    a(this.r);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(n paramn)
  {
    this.j = paramn;
  }
  
  public void a(short paramShort)
  {
    this.r = paramShort;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (t) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public void e(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (v)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)) || (!JceUtil.equals(this.f, paramObject.f)) || (!JceUtil.equals(this.g, paramObject.g)) || (!JceUtil.equals(this.h, paramObject.h)) || (!JceUtil.equals(this.i, paramObject.i)) || (!JceUtil.equals(this.j, paramObject.j)) || (!JceUtil.equals(this.k, paramObject.k)) || (!JceUtil.equals(this.l, paramObject.l)) || (!JceUtil.equals(this.m, paramObject.m)) || (!JceUtil.equals(this.n, paramObject.n)) || (!JceUtil.equals(this.o, paramObject.o)) || (!JceUtil.equals(this.p, paramObject.p)) || (!JceUtil.equals(this.q, paramObject.q)) || (!JceUtil.equals(this.r, paramObject.r)));
    return true;
  }
  
  public void f(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
  
  public void h(String paramString)
  {
    this.k = paramString;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void i(String paramString)
  {
    this.l = paramString;
  }
  
  public void j(String paramString)
  {
    this.q = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    a(paramJceInputStream.readString(0, true));
    b(paramJceInputStream.readString(1, false));
    c(paramJceInputStream.readString(2, false));
    d(paramJceInputStream.readString(3, false));
    e(paramJceInputStream.readString(4, false));
    f(paramJceInputStream.readString(5, false));
    g(paramJceInputStream.readString(6, false));
    a(paramJceInputStream.read(this.h, 7, false));
    b(paramJceInputStream.read(this.i, 8, false));
    if (s == null) {
      s = new n();
    }
    a((n)paramJceInputStream.read(s, 9, false));
    h(paramJceInputStream.readString(10, false));
    i(paramJceInputStream.readString(11, false));
    c(paramJceInputStream.read(this.m, 12, false));
    d(paramJceInputStream.read(this.n, 13, false));
    e(paramJceInputStream.read(this.o, 14, false));
    f(paramJceInputStream.read(this.p, 15, false));
    j(paramJceInputStream.readString(16, false));
    a(paramJceInputStream.read(this.r, 17, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 10);
    }
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 11);
    }
    paramJceOutputStream.write(this.m, 12);
    paramJceOutputStream.write(this.n, 13);
    paramJceOutputStream.write(this.o, 14);
    paramJceOutputStream.write(this.p, 15);
    if (this.q != null) {
      paramJceOutputStream.write(this.q, 16);
    }
    paramJceOutputStream.write(this.r, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.v
 * JD-Core Version:    0.7.0.1
 */