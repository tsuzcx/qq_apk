package midas.x;

public class jn
{
  public int a;
  public String b;
  public Throwable c;
  
  public jn(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramThrowable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Response{code=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", message='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", throwable=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jn
 * JD-Core Version:    0.7.0.1
 */