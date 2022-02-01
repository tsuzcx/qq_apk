package midas.x;

import java.io.File;

public class kt
  extends jn
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.kt
 * JD-Core Version:    0.7.0.1
 */