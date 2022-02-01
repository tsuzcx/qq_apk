package sm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class r
  extends JceStruct
  implements Cloneable
{
  static n j;
  static k k;
  public String a = "";
  public int b = 0;
  public n c = null;
  public int d = 0;
  public int e = 0;
  public String f = "";
  public String g = "";
  public k h = null;
  public String i = "";
  
  static
  {
    if (!r.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      l = bool;
      return;
    }
  }
  
  public r()
  {
    a(this.a);
    a(this.b);
    a(this.c);
    b(this.d);
    c(this.e);
    b(this.f);
    c(this.g);
    a(this.h);
    d(this.i);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(k paramk)
  {
    this.h = paramk;
  }
  
  public void a(n paramn)
  {
    this.c = paramn;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
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
      while (l) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void d(String paramString)
  {
    this.i = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (r)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)) || (!JceUtil.equals(this.f, paramObject.f)) || (!JceUtil.equals(this.g, paramObject.g)) || (!JceUtil.equals(this.h, paramObject.h)) || (!JceUtil.equals(this.i, paramObject.i)));
    return true;
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
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    a(paramJceInputStream.readString(0, true));
    a(paramJceInputStream.read(this.b, 1, false));
    if (j == null) {
      j = new n();
    }
    a((n)paramJceInputStream.read(j, 2, false));
    b(paramJceInputStream.read(this.d, 3, false));
    c(paramJceInputStream.read(this.e, 4, false));
    b(paramJceInputStream.readString(5, false));
    c(paramJceInputStream.readString(6, false));
    if (k == null) {
      k = new k();
    }
    a((k)paramJceInputStream.read(k, 7, false));
    d(paramJceInputStream.readString(8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 7);
    }
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.r
 * JD-Core Version:    0.7.0.1
 */