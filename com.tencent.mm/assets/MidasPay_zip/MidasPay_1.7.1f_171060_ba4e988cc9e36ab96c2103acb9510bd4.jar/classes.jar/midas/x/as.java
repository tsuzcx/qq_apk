package midas.x;

public class as
{
  public String a = "";
  public String b = "";
  
  public boolean equals(Object paramObject)
  {
    paramObject = (as)paramObject;
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
 * Qualified Name:     midas.x.as
 * JD-Core Version:    0.7.0.1
 */