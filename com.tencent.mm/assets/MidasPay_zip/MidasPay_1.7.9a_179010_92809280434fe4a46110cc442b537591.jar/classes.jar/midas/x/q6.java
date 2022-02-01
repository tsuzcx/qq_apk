package midas.x;

public class q6
{
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public boolean j;
  public int k;
  
  public q6()
  {
    this.a = "";
    this.b = "";
    this.c = 0;
    this.d = "";
    this.e = "";
    this.f = "100";
    this.g = "";
    this.h = "";
    this.j = false;
    this.i = 0;
  }
  
  public q6(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean, int paramInt3, String paramString8)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString8;
    this.h = paramString6;
    this.i = paramInt2;
    this.j = paramBoolean;
    this.k = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (q6)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    String str = this.a;
    if (str == null) {
      return 0;
    }
    return str.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q6
 * JD-Core Version:    0.7.0.1
 */