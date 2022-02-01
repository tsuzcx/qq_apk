package midas.x;

import android.text.TextUtils;

public class jw
  implements ja
{
  private kl a;
  private jy b;
  protected int i = -1;
  protected String j = "";
  protected String k = "";
  protected String l;
  
  public jw(kl paramkl)
  {
    this.a = paramkl;
  }
  
  public static jw a(int paramInt, String paramString)
  {
    jw localjw = new jw(null);
    localjw.i = paramInt;
    localjw.j = paramString;
    localjw.k = paramString;
    return localjw;
  }
  
  public jy Q()
  {
    return this.b;
  }
  
  public int R()
  {
    return this.i;
  }
  
  public String S()
  {
    return this.j;
  }
  
  public String T()
  {
    return this.k;
  }
  
  public String U()
  {
    return this.l;
  }
  
  protected String V()
  {
    if (this.b == null) {
      return "";
    }
    js localjs = this.b.y();
    if ((localjs != null) && (!TextUtils.isEmpty(localjs.b))) {
      return localjs.b;
    }
    return "";
  }
  
  public void a(jy paramjy)
  {
    this.b = paramjy;
  }
  
  protected boolean a(jo paramjo)
  {
    return true;
  }
  
  public void a_(jo paramjo)
  {
    if (paramjo != null)
    {
      this.l = paramjo.b;
      jz localjz = jz.a(paramjo);
      if (localjz != null)
      {
        this.j = localjz.c;
        this.i = localjz.a;
        this.k = localjz.c;
      }
    }
    boolean bool;
    if ((paramjo != null) && (paramjo.e))
    {
      bool = c(paramjo);
      if ((this.a != null) && (bool)) {
        this.a.c(this);
      }
    }
    else if ((paramjo != null) && (paramjo.d()))
    {
      bool = a(paramjo);
      if ((this.a != null) && (bool)) {
        this.a.a(this);
      }
    }
    else
    {
      bool = b(paramjo);
      if ((this.a != null) && (bool)) {
        this.a.b(this);
      }
    }
  }
  
  protected boolean b(jo paramjo)
  {
    return true;
  }
  
  protected boolean c(jo paramjo)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jw
 * JD-Core Version:    0.7.0.1
 */