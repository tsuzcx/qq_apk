package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;

public class ad
{
  public int a = 1;
  public s b;
  public ArrayList<v> c = null;
  private boolean d = true;
  
  public int a(int paramInt)
  {
    if (this.b != null) {
      return this.b.a(paramInt);
    }
    return 0;
  }
  
  public boolean a()
  {
    s locals = this.b;
    boolean bool2 = false;
    boolean bool1;
    if (locals != null) {
      bool1 = this.b.b();
    } else {
      bool1 = false;
    }
    if (this.c != null)
    {
      i = 0;
      while (i < this.c.size())
      {
        if (((v)this.c.get(i)).a())
        {
          i = 1;
          break label77;
        }
        i += 1;
      }
    }
    int i = 0;
    label77:
    if (!bool1)
    {
      bool1 = bool2;
      if (i == 0) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean b()
  {
    if (this.c != null)
    {
      int i = 0;
      while (i < this.c.size())
      {
        if (TextUtils.isEmpty(((v)this.c.get(i)).c))
        {
          this.d = false;
          break;
        }
        i += 1;
      }
    }
    this.d = false;
    return this.d;
  }
  
  public boolean c()
  {
    return (this.c != null) && (this.c.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ad
 * JD-Core Version:    0.7.0.1
 */