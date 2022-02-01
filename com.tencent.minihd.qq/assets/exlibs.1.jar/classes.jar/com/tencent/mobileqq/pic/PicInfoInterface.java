package com.tencent.mobileqq.pic;

public class PicInfoInterface
  implements LoggerInterface
{
  public PicInfoInterface.ErrInfo a;
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      this.a = new PicInfoInterface.ErrInfo();
    }
    this.a.a = paramString1;
    this.a.b = paramString2;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public String toLogString()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicInfoInterface
 * JD-Core Version:    0.7.0.1
 */