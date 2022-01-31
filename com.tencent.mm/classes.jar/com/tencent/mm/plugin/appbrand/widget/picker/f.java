package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.mm.sdk.platformtools.bk;

public final class f
{
  public static boolean nd(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 59);
  }
  
  public static boolean ne(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 23);
  }
  
  public static int[] xi(String paramString)
  {
    if (bk.bl(paramString)) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        paramString = paramString.split(":");
      } while ((paramString == null) || (paramString.length != 2));
      i = xj(paramString[0]);
      j = xj(paramString[1]);
    } while ((!ne(i)) || (!nd(j)));
    return new int[] { i, j };
  }
  
  private static int xj(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString, 10);
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.f
 * JD-Core Version:    0.7.0.1
 */