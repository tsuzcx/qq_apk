package midas.x;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class e7
{
  public static float a;
  
  public static int a(Context paramContext, float paramFloat)
  {
    if (a == 0.0F) {
      a = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramFloat * a + 0.5F);
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    if (a == 0.0F) {
      a = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramFloat / a + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.e7
 * JD-Core Version:    0.7.0.1
 */