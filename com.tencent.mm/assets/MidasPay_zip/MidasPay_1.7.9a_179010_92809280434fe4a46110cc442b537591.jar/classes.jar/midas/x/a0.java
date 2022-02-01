package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;

public class a0
  extends q
{
  public ArrayList<c0> d = null;
  
  public a0()
  {
    this.a = 0;
    this.b = "";
    this.c = null;
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.d;
    int j = 0;
    if (localObject != null) {
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= this.d.size()) {
          break;
        }
        localObject = (c0)this.d.get(j);
        if (((c0)localObject).a.equals("2")) {}
        double d1;
        double d2;
        for (k = ((c0)localObject).b;; k = (int)Math.ceil(d1 * d2 / 100.0D))
        {
          k = i + k;
          break;
          k = i;
          if (!((c0)localObject).a.equals("1")) {
            break;
          }
          d1 = paramInt;
          d2 = ((c0)localObject).b;
          Double.isNaN(d1);
          Double.isNaN(d2);
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
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
    if (this.d == null) {
      return false;
    }
    int i = 0;
    while (i < this.d.size())
    {
      if (((c0)this.d.get(i)).b > 0) {
        return true;
      }
      i += 1;
    }
    return false;
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
 * Qualified Name:     midas.x.a0
 * JD-Core Version:    0.7.0.1
 */