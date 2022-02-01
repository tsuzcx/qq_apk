package midas.x;

public class ke
  extends Exception
{
  private static final long serialVersionUID = -1584716934177136971L;
  private final String a;
  private final int b;
  private final String c;
  
  public ke(String paramString1, int paramInt, String paramString2)
  {
    super(localStringBuilder.toString());
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
  }
  
  public String getMessage()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ke
 * JD-Core Version:    0.7.0.1
 */