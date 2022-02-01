package midas.x;

import android.util.Log;

public class ca
{
  public static u9.b a;
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = a;
    if (localObject != null)
    {
      ((u9.b)localObject).b(paramString1, paramString2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString2);
    Log.d("MidasPush-Log", ((StringBuilder)localObject).toString());
  }
  
  public static void a(u9.b paramb)
  {
    a = paramb;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = a;
    if (localObject != null)
    {
      ((u9.b)localObject).d(paramString1, paramString2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString2);
    Log.e("MidasPush-Log", ((StringBuilder)localObject).toString());
  }
  
  public static void c(String paramString1, String paramString2)
  {
    Object localObject = a;
    if (localObject != null)
    {
      ((u9.b)localObject).c(paramString1, paramString2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString2);
    Log.i("MidasPush-Log", ((StringBuilder)localObject).toString());
  }
  
  public static void d(String paramString1, String paramString2)
  {
    Object localObject = a;
    if (localObject != null)
    {
      ((u9.b)localObject).a(paramString1, paramString2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString2);
    Log.w("MidasPush-Log", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ca
 * JD-Core Version:    0.7.0.1
 */