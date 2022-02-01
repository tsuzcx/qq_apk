package cooperation.weiyun;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;

public final class AlbumBackupConst
{
  @SuppressLint({"InlinedApi"})
  public static final int a;
  public static final String a = "Weiyun.AlbumBackup";
  public static final String b = "weiyun.pref.plugin.albumbackup.options";
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      a = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.weiyun.AlbumBackupConst
 * JD-Core Version:    0.7.0.1
 */