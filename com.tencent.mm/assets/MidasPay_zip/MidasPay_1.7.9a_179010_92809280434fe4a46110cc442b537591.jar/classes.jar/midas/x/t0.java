package midas.x;

public class t0
{
  public String a = "";
  public String b = "";
  
  public boolean equals(Object paramObject)
  {
    paramObject = (t0)paramObject;
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
 * Qualified Name:     midas.x.t0
 * JD-Core Version:    0.7.0.1
 */