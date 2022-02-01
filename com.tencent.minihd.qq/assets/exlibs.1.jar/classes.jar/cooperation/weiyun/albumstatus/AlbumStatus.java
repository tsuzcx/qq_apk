package cooperation.weiyun.albumstatus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyBizManager;
import com.weiyun.sdk.IWyFileSystem;
import cooperation.weiyun.AlbumBackupInfo;
import cooperation.weiyun.WeiyunHelper;
import cooperation.weiyun.WeiyunProxyBroadcastReceiver;
import java.lang.reflect.Field;
import mes;
import mqq.app.AppRuntime;

public class AlbumStatus
{
  /* Error */
  private static int a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 19	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 25	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: iconst_1
    //   8: anewarray 27	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc 29
    //   15: aastore
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 35	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +36 -> 60
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: invokeinterface 41 1 0
    //   35: ifeq +25 -> 60
    //   38: aload_2
    //   39: astore_0
    //   40: aload_2
    //   41: iconst_0
    //   42: invokeinterface 45 2 0
    //   47: istore_1
    //   48: aload_2
    //   49: ifnull +9 -> 58
    //   52: aload_2
    //   53: invokeinterface 48 1 0
    //   58: iload_1
    //   59: ireturn
    //   60: aload_2
    //   61: ifnull +9 -> 70
    //   64: aload_2
    //   65: invokeinterface 48 1 0
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_3
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: astore_0
    //   77: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +30 -> 110
    //   83: aload_2
    //   84: astore_0
    //   85: ldc 55
    //   87: iconst_2
    //   88: new 57	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   95: ldc 60
    //   97: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_2
    //   111: ifnull -41 -> 70
    //   114: aload_2
    //   115: invokeinterface 48 1 0
    //   120: goto -50 -> 70
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +9 -> 136
    //   130: aload_0
    //   131: invokeinterface 48 1 0
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: goto -13 -> 126
    //   142: astore_3
    //   143: goto -68 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramContext	Context
    //   47	12	1	i	int
    //   22	93	2	localCursor	android.database.Cursor
    //   123	14	2	localObject1	Object
    //   138	1	2	localObject2	Object
    //   72	29	3	localSQLiteException1	android.database.sqlite.SQLiteException
    //   142	1	3	localSQLiteException2	android.database.sqlite.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   0	23	72	android/database/sqlite/SQLiteException
    //   0	23	123	finally
    //   29	38	138	finally
    //   40	48	138	finally
    //   77	83	138	finally
    //   85	110	138	finally
    //   29	38	142	android/database/sqlite/SQLiteException
    //   40	48	142	android/database/sqlite/SQLiteException
  }
  
  @SuppressLint({"NewApi"})
  private static long a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext, 0);
      if (Build.VERSION.SDK_INT >= 9) {
        return paramContext.firstInstallTime;
      }
      long l = PackageInfo.class.getField("firstInstallTime").getLong(paramContext);
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public static void a(Context paramContext)
  {
    if (AlbumBackupInfo.a(paramContext, BaseApplicationImpl.a().a().getAccount()))
    {
      WeiyunProxyBroadcastReceiver.a(paramContext, "com.weiyun.plugin.albumbackup.receiver.AlbumStatusBroadcastReceiver", null);
      return;
    }
    b(paramContext);
  }
  
  private static void b(Context paramContext)
  {
    int i = a(paramContext);
    long l = System.currentTimeMillis() - a(paramContext);
    WeiyunHelper.a().getBizManager().reportAlbumStatus(false, i, i, l, new mes());
    if (QLog.isColorLevel()) {
      QLog.i("Weiyun.AlbumBackup", 2, "report album status immediately: false, " + i + ", " + i + ", " + l / 1000L / 3600L + "h");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.weiyun.albumstatus.AlbumStatus
 * JD-Core Version:    0.7.0.1
 */