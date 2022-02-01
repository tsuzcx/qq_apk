package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;

public class aa
  extends p
{
  public String d = "0";
  public int e = 0;
  
  public aa()
  {
    this.a = 0;
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
        if (TextUtils.isEmpty(((v)this.c.get(i)).c)) {
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
      if (((v)this.c.get(i)).a()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.aa
 * JD-Core Version:    0.7.0.1
 */