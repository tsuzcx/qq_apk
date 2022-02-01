package midas.x;

import android.text.TextUtils;

public class lh
  implements kl
{
  private lw a;
  private lj b;
  protected int j = -1;
  protected String k = "";
  protected String l = "";
  protected String m;
  
  public lh(lw paramlw)
  {
    this.a = paramlw;
  }
  
  public static lh a(int paramInt, String paramString)
  {
    lh locallh = new lh(null);
    locallh.j = paramInt;
    locallh.k = paramString;
    locallh.l = paramString;
    return locallh;
  }
  
  public lj S()
  {
    return this.b;
  }
  
  public int T()
  {
    return this.j;
  }
  
  public String U()
  {
    return this.k;
  }
  
  public String V()
  {
    return this.l;
  }
  
  public String W()
  {
    return this.m;
  }
  
  protected String X()
  {
    if (this.b == null) {
      return "";
    }
    ld localld = this.b.y();
    if ((localld != null) && (!TextUtils.isEmpty(localld.b))) {
      return localld.b;
    }
    return "";
  }
  
  public void a(lj paramlj)
  {
    this.b = paramlj;
  }
  
  protected boolean a(kz paramkz)
  {
    return true;
  }
  
  public void a_(kz paramkz)
  {
    if (paramkz != null)
    {
      this.m = paramkz.b;
      lk locallk = lk.a(paramkz);
      if (locallk != null)
      {
        this.k = locallk.c;
        this.j = locallk.a;
        this.l = locallk.c;
      }
    }
    boolean bool;
    if ((paramkz != null) && (paramkz.e))
    {
      bool = c(paramkz);
      if ((this.a != null) && (bool)) {
        this.a.c(this);
      }
    }
    else if ((paramkz != null) && (paramkz.d()))
    {
      bool = a(paramkz);
      if ((this.a != null) && (bool)) {
        this.a.a(this);
      }
    }
    else
    {
      bool = b(paramkz);
      if ((this.a != null) && (bool)) {
        this.a.b(this);
      }
    }
  }
  
  protected boolean b(kz paramkz)
  {
    return true;
  }
  
  protected boolean c(kz paramkz)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lh
 * JD-Core Version:    0.7.0.1
 */