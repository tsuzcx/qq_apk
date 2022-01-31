package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b
{
  private static int Ng()
  {
    String[] arrayOfString = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
    int i = bk.ZR(arrayOfString[0]);
    int j = bk.ZR(arrayOfString[1]) + i * 60 - ((int)Nh() - 8) * 60;
    if (j < 0) {
      i = j + 1440;
    }
    do
    {
      return i;
      i = j;
    } while (j < 1440);
    return j - 1440;
  }
  
  public static long Nh()
  {
    return (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
  }
  
  public static boolean O(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        int j = Ng();
        paramString = paramString.split(";");
        int i = 0;
        while (i < paramString.length)
        {
          String[] arrayOfString1 = paramString[i].split("-");
          String[] arrayOfString2 = arrayOfString1[0].split(":");
          int k = bk.ZR(arrayOfString2[0]);
          int m = bk.ZR(arrayOfString2[1]);
          arrayOfString1 = arrayOfString1[1].split(":");
          int n = bk.ZR(arrayOfString1[0]);
          boolean bool = v(m + k * 60, bk.ZR(arrayOfString1[1]) + n * 60 + paramInt, j);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
        y.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      }
    }
  }
  
  public static boolean lO(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        int j = Ng();
        paramString = paramString.split(";");
        int i = 0;
        while (i < paramString.length)
        {
          String[] arrayOfString1 = paramString[i].split("-");
          String[] arrayOfString2 = arrayOfString1[0].split(":");
          int k = bk.ZR(arrayOfString2[0]);
          int m = bk.ZR(arrayOfString2[1]);
          arrayOfString1 = arrayOfString1[1].split(":");
          int n = bk.ZR(arrayOfString1[0]);
          boolean bool = v(m + k * 60, bk.ZR(arrayOfString1[1]) + n * 60, j);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
        y.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      }
    }
  }
  
  private static boolean v(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      if ((paramInt3 >= paramInt2) || (paramInt3 < paramInt1)) {}
    }
    while (((paramInt3 <= 1440) && (paramInt3 >= paramInt1)) || ((paramInt3 < paramInt2) && (paramInt3 >= 0)))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.b
 * JD-Core Version:    0.7.0.1
 */