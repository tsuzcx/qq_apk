package midas.x;

import android.util.Log;

public class lc
{
  private static kw.d a;
  
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
    Log.i("Midas-IPLog", localStringBuilder.toString());
  }
  
  public static void a(kw.d paramd)
  {
    a = paramd;
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
    Log.d("Midas-IPLog", localStringBuilder.toString());
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
    Log.w("Midas-IPLog", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.lc
 * JD-Core Version:    0.7.0.1
 */