package midas.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class lj
{
  public static void a(String paramString, long paramLong)
  {
    if (kv.a == null) {
      return;
    }
    SharedPreferences.Editor localEditor = kv.a.getSharedPreferences("TencentMidasIP", 0).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (kv.a == null) {
      return;
    }
    SharedPreferences.Editor localEditor = kv.a.getSharedPreferences("TencentMidasIP", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public static long b(String paramString, long paramLong)
  {
    if (kv.a == null) {
      return 0L;
    }
    return kv.a.getSharedPreferences("TencentMidasIP", 0).getLong(paramString, paramLong);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (kv.a == null) {
      return "";
    }
    return kv.a.getSharedPreferences("TencentMidasIP", 0).getString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.lj
 * JD-Core Version:    0.7.0.1
 */