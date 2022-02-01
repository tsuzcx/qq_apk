package midas.x;

import java.io.File;

public class me
  extends ky
{
  private File a;
  
  public File a()
  {
    return this.a;
  }
  
  public void a(File paramFile)
  {
    this.a = paramFile;
  }
  
  public void a(String paramString)
  {
    e("actual_len", paramString);
  }
  
  public String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.k());
    localStringBuilder.append("&content=");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.me
 * JD-Core Version:    0.7.0.1
 */