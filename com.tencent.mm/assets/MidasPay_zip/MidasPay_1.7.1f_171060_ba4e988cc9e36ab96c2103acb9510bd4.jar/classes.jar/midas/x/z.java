package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;

public class z
  extends p
{
  public ArrayList<ab> d = null;
  
  public z()
  {
    this.a = 0;
    this.b = "";
    this.c = null;
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.d;
    int k = 0;
    if (localObject != null) {
      for (int i = 0;; i = j)
      {
        j = i;
        if (k >= this.d.size()) {
          break;
        }
        localObject = (ab)this.d.get(k);
        if (((ab)localObject).a.equals("2"))
        {
          j = i + ((ab)localObject).b;
        }
        else
        {
          j = i;
          if (((ab)localObject).a.equals("1"))
          {
            double d1 = paramInt;
            double d2 = ((ab)localObject).b;
            Double.isNaN(d1);
            Double.isNaN(d2);
            j = i + (int)Math.ceil(d1 * d2 / 100.0D);
          }
        }
        k += 1;
      }
    }
    int j = 0;
    return j;
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
    if (this.d == null) {
      return false;
    }
    int i = 0;
    while (i < this.d.size())
    {
      if (((ab)this.d.get(i)).b > 0) {
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
      if (((v)this.c.get(i)).a()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.z
 * JD-Core Version:    0.7.0.1
 */