package midas.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ld
{
  public static long a(String paramString, long paramLong)
  {
    Context localContext = pc.g;
    if (localContext == null) {
      return 0L;
    }
    return localContext.getSharedPreferences("TencentMidasIP", 0).getLong(paramString, paramLong);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Context localContext = pc.g;
    if (localContext == null) {
      return "";
    }
    return localContext.getSharedPreferences("TencentMidasIP", 0).getString(paramString1, paramString2);
  }
  
  public static void b(String paramString, long paramLong)
  {
    Object localObject = pc.g;
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("TencentMidasIP", 0).edit();
    ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = pc.g;
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("TencentMidasIP", 0).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ld
 * JD-Core Version:    0.7.0.1
 */