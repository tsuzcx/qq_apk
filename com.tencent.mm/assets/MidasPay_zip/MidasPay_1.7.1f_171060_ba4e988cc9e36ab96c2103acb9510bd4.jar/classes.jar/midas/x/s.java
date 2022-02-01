package midas.x;

public class s
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public String d;
  public String e;
  public int f = 0;
  
  public int a()
  {
    if ("1".equals(this.d))
    {
      if (this.b * this.a % 100 != 0) {
        this.f = (this.b * this.a / 100 + 1);
      } else {
        this.f = (this.b * this.a / 100);
      }
    }
    else if ("2".equals(this.d)) {
      this.f = this.c;
    } else {
      this.f = 0;
    }
    return this.f;
  }
  
  public int a(int paramInt)
  {
    if ("1".equals(this.d))
    {
      if (this.b * paramInt % 100 != 0) {
        this.f = (this.b * paramInt / 100 + 1);
      } else {
        this.f = (this.b * paramInt / 100);
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
    else {
      this.f = 0;
    }
    return this.f;
  }
  
  public boolean b()
  {
    if (("1".equals(this.d)) && (this.b > 0)) {
      return true;
    }
    return ("2".equals(this.d)) && (this.c > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.s
 * JD-Core Version:    0.7.0.1
 */