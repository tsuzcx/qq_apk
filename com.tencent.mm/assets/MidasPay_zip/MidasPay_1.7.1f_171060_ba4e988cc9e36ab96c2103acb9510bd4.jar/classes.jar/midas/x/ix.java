package midas.x;

public class ix
  extends kt
{
  public ix()
  {
    ji localji = new ji("https", "dev.api.unipay.qq.com");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/v1/r/");
    localStringBuilder.append(ed.b().f());
    localStringBuilder.append("/upload_log");
    localji.c = localStringBuilder.toString();
    a(localji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ix
 * JD-Core Version:    0.7.0.1
 */