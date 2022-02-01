package midas.x;

import java.io.File;

public class nc
  extends fb
{
  public File t;
  
  public void a(File paramFile)
  {
    this.t = paramFile;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.c());
    localStringBuilder.append("&content=");
    return localStringBuilder.toString();
  }
  
  public void d(String paramString)
  {
    b("actual_len", paramString);
  }
  
  public File t()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.nc
 * JD-Core Version:    0.7.0.1
 */