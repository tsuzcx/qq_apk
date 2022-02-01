package com.tencent.tencentmap.mapsdk.a;

public class i
{
  public static e a(String paramString1, String paramString2)
    throws Exception
  {
    return a(true, paramString1, paramString2, null);
  }
  
  public static e a(boolean paramBoolean, String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws Exception
  {
    return a(paramBoolean, paramString1, paramString2, paramArrayOfByte, false);
  }
  
  public static e a(boolean paramBoolean1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2)
    throws Exception
  {
    return a(paramBoolean1, paramString1, paramString2, paramArrayOfByte, paramBoolean2, false);
  }
  
  public static e a(boolean paramBoolean1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, boolean paramBoolean3)
    throws Exception
  {
    if (paramBoolean3) {
      try
      {
        e locale = h.a(paramBoolean1, paramString1, paramString2, null, paramArrayOfByte, paramBoolean2, false);
        return locale;
      }
      catch (g paramString1)
      {
        throw paramString1;
      }
      catch (j paramString1)
      {
        throw paramString1;
      }
      catch (Exception localException) {}
    }
    try
    {
      Thread.sleep(b.b());
      return h.a(paramBoolean1, paramString1, paramString2, null, paramArrayOfByte, paramBoolean2, true);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.i
 * JD-Core Version:    0.7.0.1
 */