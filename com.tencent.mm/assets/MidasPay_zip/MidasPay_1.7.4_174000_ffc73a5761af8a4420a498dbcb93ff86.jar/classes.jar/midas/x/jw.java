package midas.x;

import android.util.Log;

public class jw
{
  private static jo.a a;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.a(paramString1, paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    Log.i("MidasPush-Log", localStringBuilder.toString());
  }
  
  public static void a(jo.a parama)
  {
    a = parama;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.b(paramString1, paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    Log.d("MidasPush-Log", localStringBuilder.toString());
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.c(paramString1, paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    Log.w("MidasPush-Log", localStringBuilder.toString());
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.d(paramString1, paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    Log.e("MidasPush-Log", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jw
 * JD-Core Version:    0.7.0.1
 */