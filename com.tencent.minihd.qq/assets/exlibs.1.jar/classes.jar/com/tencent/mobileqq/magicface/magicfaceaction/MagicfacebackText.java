package com.tencent.mobileqq.magicface.magicfaceaction;

import java.math.BigDecimal;

public class MagicfacebackText
{
  public String a;
  public String b;
  public String c;
  
  public String a(int paramInt, float paramFloat)
  {
    String str = null;
    if (this.c != null)
    {
      str = this.c.replaceFirst("%param%", "" + paramInt);
      paramFloat = new BigDecimal(paramFloat).setScale(1, 4).floatValue();
      str = str.replaceFirst("%param%", "" + paramFloat);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.MagicfacebackText
 * JD-Core Version:    0.7.0.1
 */