package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;

public class b0
  extends q
{
  public String d;
  public int e;
  
  public b0()
  {
    this.a = 0;
    this.e = 0;
    this.d = "0";
    this.b = "";
    this.c = null;
  }
  
  public int a(int paramInt)
  {
    if (this.d.equals("2")) {
      return this.e;
    }
    if (this.d.equals("1"))
    {
      double d1 = paramInt;
      double d2 = this.e;
      Double.isNaN(d1);
      Double.isNaN(d2);
      return (int)Math.ceil(d1 * d2 / 100.0D);
    }
    return 0;
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.c;
    boolean bool = false;
    if (localArrayList != null)
    {
      int i = 0;
      while (i < this.c.size())
      {
        if (TextUtils.isEmpty(((w)this.c.get(i)).c)) {
          return false;
        }
        i += 1;
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    return this.e > 0;
  }
  
  public boolean c()
  {
    if (this.c == null) {
      return false;
    }
    int i = 0;
    while (i < this.c.size())
    {
      if (((w)this.c.get(i)).a()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.b0
 * JD-Core Version:    0.7.0.1
 */