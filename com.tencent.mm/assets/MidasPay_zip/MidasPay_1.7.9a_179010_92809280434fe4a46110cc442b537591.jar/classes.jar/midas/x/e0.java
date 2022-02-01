package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;

public class e0
{
  public int a = 1;
  public t b;
  public ArrayList<w> c = null;
  public boolean d = true;
  
  public int a(int paramInt)
  {
    t localt = this.b;
    if (localt != null) {
      return localt.a(paramInt);
    }
    return 0;
  }
  
  public boolean a()
  {
    if (this.c != null)
    {
      int i = 0;
      while (i < this.c.size())
      {
        if (TextUtils.isEmpty(((w)this.c.get(i)).c))
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
  
  public boolean b()
  {
    t localt = this.b;
    boolean bool2 = false;
    boolean bool1;
    if (localt != null) {
      bool1 = localt.a();
    } else {
      bool1 = false;
    }
    if (this.c != null)
    {
      i = 0;
      while (i < this.c.size())
      {
        if (((w)this.c.get(i)).a())
        {
          i = 1;
          break label75;
        }
        i += 1;
      }
    }
    int i = 0;
    label75:
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
  
  public boolean c()
  {
    ArrayList localArrayList = this.c;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.e0
 * JD-Core Version:    0.7.0.1
 */