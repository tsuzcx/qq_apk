package midas.x;

import android.text.TextUtils;

public class ob
  implements ra
{
  public int a = -1;
  public String b = "";
  public String c = "";
  public String d;
  public fc e;
  public qb f;
  
  public ob(fc paramfc)
  {
    this.e = paramfc;
  }
  
  public static ob a(int paramInt, String paramString)
  {
    ob localob = new ob(null);
    localob.a = paramInt;
    localob.b = paramString;
    localob.c = paramString;
    return localob;
  }
  
  public qb a()
  {
    return this.f;
  }
  
  public void a(gb paramgb)
  {
    if (paramgb != null)
    {
      this.d = paramgb.b;
      rb localrb = rb.c(paramgb);
      if (localrb != null)
      {
        String str = localrb.b;
        this.b = str;
        this.a = localrb.a;
        this.c = str;
      }
    }
    boolean bool;
    if ((paramgb != null) && (paramgb.f))
    {
      bool = c(paramgb);
      paramgb = this.e;
      if ((paramgb != null) && (bool)) {
        paramgb.c(this);
      }
    }
    else if ((paramgb != null) && (paramgb.f()))
    {
      bool = d(paramgb);
      paramgb = this.e;
      if ((paramgb != null) && (bool)) {
        paramgb.a(this);
      }
    }
    else
    {
      bool = b(paramgb);
      paramgb = this.e;
      if ((paramgb != null) && (bool)) {
        paramgb.b(this);
      }
    }
  }
  
  public void a(qb paramqb)
  {
    this.f = paramqb;
  }
  
  public String b()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return "";
    }
    localObject = ((qb)localObject).u();
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((kb)localObject).b)) {
        return "";
      }
      return ((kb)localObject).b;
    }
    return "";
  }
  
  public boolean b(gb paramgb)
  {
    return true;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean c(gb paramgb)
  {
    return true;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public boolean d(gb paramgb)
  {
    return true;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public String f()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ob
 * JD-Core Version:    0.7.0.1
 */