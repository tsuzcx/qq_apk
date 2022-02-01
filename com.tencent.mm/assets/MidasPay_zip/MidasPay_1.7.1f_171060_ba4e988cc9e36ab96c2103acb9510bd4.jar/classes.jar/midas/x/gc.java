package midas.x;

public class gc
{
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public int j;
  public boolean k;
  public int l;
  
  public gc()
  {
    this.a = "";
    this.b = "";
    this.c = 0;
    this.d = "";
    this.e = "";
    this.f = "100";
    this.g = "";
    this.h = "";
    this.k = false;
    this.j = 0;
  }
  
  public gc(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean, int paramInt3, String paramString8)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString8;
    this.h = paramString6;
    this.j = paramInt2;
    this.i = paramString7;
    this.k = paramBoolean;
    this.l = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (gc)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.gc
 * JD-Core Version:    0.7.0.1
 */