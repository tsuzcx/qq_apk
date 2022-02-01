package midas.x;

public class ji
  extends me
{
  public ji()
  {
    kt localkt = new kt("https", "dev.api.unipay.qq.com");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/v1/r/");
    localStringBuilder.append(em.b().f());
    localStringBuilder.append("/upload_log");
    localkt.c = localStringBuilder.toString();
    a(localkt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ji
 * JD-Core Version:    0.7.0.1
 */