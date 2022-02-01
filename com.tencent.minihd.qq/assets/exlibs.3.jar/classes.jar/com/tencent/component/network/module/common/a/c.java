package com.tencent.component.network.module.common.a;

import java.text.DecimalFormat;

public class c
{
  private static final DecimalFormat a = new DecimalFormat();
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramInt)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if ((j <= 32) || (j >= 127))
      {
        localStringBuffer.append('\\');
        localStringBuffer.append(a.format(j));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((j == 34) || (j == 40) || (j == 41) || (j == 46) || (j == 59) || (j == 92) || (j == 64) || (j == 36))
        {
          localStringBuffer.append('\\');
          localStringBuffer.append((char)j);
        }
        else
        {
          localStringBuffer.append((char)j);
        }
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.c
 * JD-Core Version:    0.7.0.1
 */