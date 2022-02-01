package midas.x;

public class t
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public String d;
  public String e;
  public int f = 0;
  
  public int a(int paramInt)
  {
    if ("1".equals(this.d))
    {
      int i = this.b;
      if (i * paramInt % 100 != 0) {
        this.f = (i * paramInt / 100 + 1);
      } else {
        this.f = (i * paramInt / 100);
      }
    }
    else if ("2".equals(this.d))
    {
      if (paramInt >= this.a) {
        this.f = this.c;
      } else {
        this.f = 0;
      }
    }
    else
    {
      this.f = 0;
    }
    return this.f;
  }
  
  public boolean a()
  {
    if (("1".equals(this.d)) && (this.b > 0)) {
      return true;
    }
    return ("2".equals(this.d)) && (this.c > 0);
  }
  
  public int b()
  {
    if ("1".equals(this.d))
    {
      int i = this.b;
      int j = this.a;
      if (i * j % 100 != 0) {
        this.f = (i * j / 100 + 1);
      } else {
        this.f = (i * j / 100);
      }
    }
    else if ("2".equals(this.d))
    {
      this.f = this.c;
    }
    else
    {
      this.f = 0;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.t
 * JD-Core Version:    0.7.0.1
 */