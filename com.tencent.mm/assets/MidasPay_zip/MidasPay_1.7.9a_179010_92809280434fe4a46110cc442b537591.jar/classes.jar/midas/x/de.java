package midas.x;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.Hashtable;

public class de
{
  public static ae a;
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Hashtable<zd, Object> paramHashtable)
  {
    paramHashtable = a(paramString, paramInt1, paramInt2, paramHashtable);
    if (paramHashtable == null) {
      return null;
    }
    paramString = new int[paramInt1 * paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      while (j < paramInt1)
      {
        int k;
        if (paramHashtable.a(j, i)) {
          k = paramInt3;
        } else {
          k = paramInt4;
        }
        paramString[(i * paramInt1 + j)] = k;
        j += 1;
      }
      i += 1;
    }
    paramHashtable = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramHashtable.setPixels(paramString, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    return paramHashtable;
  }
  
  public static fe a(String paramString, int paramInt1, int paramInt2, Hashtable<zd, Object> paramHashtable)
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new ae();
          }
        }
        finally {}
      }
      paramString = a.a(paramString, yd.l, paramInt1, paramInt2, paramHashtable);
      return paramString;
    }
    catch (ce paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.de
 * JD-Core Version:    0.7.0.1
 */