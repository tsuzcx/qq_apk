package midas.x;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.Hashtable;

public class nm
{
  private static nj a;
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Hashtable<ni, Object> paramHashtable)
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
  
  public static no a(String paramString, int paramInt1, int paramInt2, Hashtable<ni, Object> paramHashtable)
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new nj();
          }
        }
        finally {}
      }
      paramString = a.a(paramString, nh.l, paramInt1, paramInt2, paramHashtable);
      return paramString;
    }
    catch (nl paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.nm
 * JD-Core Version:    0.7.0.1
 */