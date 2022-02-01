package midas.x;

import android.util.Log;

public class ed
{
  public static tc a;
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = a;
    if (localObject != null)
    {
      ((tc)localObject).b(paramString1, paramString2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString2);
    Log.d("Midas-IPLog", ((StringBuilder)localObject).toString());
  }
  
  public static void a(tc paramtc)
  {
    a = paramtc;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = a;
    if (localObject != null)
    {
      ((tc)localObject).c(paramString1, paramString2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString2);
    Log.i("Midas-IPLog", ((StringBuilder)localObject).toString());
  }
  
  public static void c(String paramString1, String paramString2)
  {
    Object localObject = a;
    if (localObject != null)
    {
      ((tc)localObject).a(paramString1, paramString2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString2);
    Log.w("Midas-IPLog", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ed
 * JD-Core Version:    0.7.0.1
 */