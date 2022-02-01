package cooperation.weiyun;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class AlbumBackupInfo
{
  private static final String a = "plugin_enable_state";
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", AlbumBackupConst.a).edit().putBoolean(a(paramString, "plugin_enable_state"), paramBoolean).commit();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", AlbumBackupConst.a).getBoolean(a(paramString, "plugin_enable_state"), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.weiyun.AlbumBackupInfo
 * JD-Core Version:    0.7.0.1
 */