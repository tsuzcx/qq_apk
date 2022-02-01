package midas.x;

public class t9
{
  public int a;
  public String b;
  public Throwable c;
  
  public t9(int paramInt, String paramString, Throwable paramThrowable)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.t9
 * JD-Core Version:    0.7.0.1
 */