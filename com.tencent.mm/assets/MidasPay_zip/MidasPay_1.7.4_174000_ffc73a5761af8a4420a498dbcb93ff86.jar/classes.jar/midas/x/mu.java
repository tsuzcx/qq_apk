package midas.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class mu
{
  public static void a(String paramString, long paramLong)
  {
    if (mg.a == null) {
      return;
    }
    SharedPreferences.Editor localEditor = mg.a.getSharedPreferences("TencentMidasIP", 0).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (mg.a == null) {
      return;
    }
    SharedPreferences.Editor localEditor = mg.a.getSharedPreferences("TencentMidasIP", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public static long b(String paramString, long paramLong)
  {
    if (mg.a == null) {
      return 0L;
    }
    return mg.a.getSharedPreferences("TencentMidasIP", 0).getLong(paramString, paramLong);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (mg.a == null) {
      return "";
    }
    return mg.a.getSharedPreferences("TencentMidasIP", 0).getString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mu
 * JD-Core Version:    0.7.0.1
 */