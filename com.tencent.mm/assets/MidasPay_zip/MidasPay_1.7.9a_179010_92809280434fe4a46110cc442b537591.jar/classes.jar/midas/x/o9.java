package midas.x;

public class o9
  extends nc
{
  public o9()
  {
    za localza = new za("https", "dev.api.unipay.qq.com");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/v1/r/");
    localStringBuilder.append(p4.p().c());
    localStringBuilder.append("/upload_log");
    localza.c = localStringBuilder.toString();
    a(localza);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.o9
 * JD-Core Version:    0.7.0.1
 */