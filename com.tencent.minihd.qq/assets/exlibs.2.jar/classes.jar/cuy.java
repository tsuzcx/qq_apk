import android.os.Environment;
import java.io.File;

public class cuy
{
  private static final File a = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
  
  public static File a()
  {
    return a;
  }
  
  /* Error */
  public static File a(android.content.Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +17 -> 18
    //   4: invokestatic 37	com/tencent/component/network/utils/PlatformUtil:a	()I
    //   7: bipush 8
    //   9: if_icmplt +9 -> 18
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 43	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   17: areturn
    //   18: ldc 2
    //   20: monitorenter
    //   21: new 45	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   28: aload_0
    //   29: invokevirtual 50	android/content/Context:getPackageName	()Ljava/lang/String;
    //   32: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: astore_3
    //   36: iload_2
    //   37: ifeq +69 -> 106
    //   40: ldc 56
    //   42: astore_0
    //   43: aload_3
    //   44: aload_0
    //   45: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 62	cuy:b	(Ljava/lang/String;)Ljava/io/File;
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 66	java/io/File:exists	()Z
    //   59: istore_2
    //   60: iload_2
    //   61: ifne +51 -> 112
    //   64: new 10	java/io/File
    //   67: dup
    //   68: invokestatic 68	cuy:a	()Ljava/io/File;
    //   71: ldc 70
    //   73: invokespecial 22	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: invokevirtual 73	java/io/File:createNewFile	()Z
    //   79: pop
    //   80: aload_0
    //   81: invokevirtual 76	java/io/File:mkdirs	()Z
    //   84: ifne +28 -> 112
    //   87: ldc 78
    //   89: ldc 80
    //   91: invokestatic 86	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: ldc 2
    //   97: monitorexit
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_0
    //   105: athrow
    //   106: ldc 88
    //   108: astore_0
    //   109: goto -66 -> 43
    //   112: aload_1
    //   113: ifnonnull +8 -> 121
    //   116: ldc 2
    //   118: monitorexit
    //   119: aload_0
    //   120: areturn
    //   121: new 10	java/io/File
    //   124: dup
    //   125: aload_0
    //   126: aload_1
    //   127: invokespecial 22	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 66	java/io/File:exists	()Z
    //   135: ifne +40 -> 175
    //   138: aload_0
    //   139: invokevirtual 76	java/io/File:mkdirs	()Z
    //   142: ifne +33 -> 175
    //   145: ldc 78
    //   147: new 45	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   154: ldc 90
    //   156: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 86	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   169: pop
    //   170: ldc 2
    //   172: monitorexit
    //   173: aconst_null
    //   174: areturn
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: areturn
    //   180: astore_3
    //   181: goto -101 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	android.content.Context
    //   0	184	1	paramString	String
    //   0	184	2	paramBoolean	boolean
    //   35	9	3	localStringBuilder	java.lang.StringBuilder
    //   180	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   21	36	100	finally
    //   43	60	100	finally
    //   64	80	100	finally
    //   80	98	100	finally
    //   101	104	100	finally
    //   116	119	100	finally
    //   121	173	100	finally
    //   175	178	100	finally
    //   64	80	180	java/io/IOException
  }
  
  /* Error */
  public static File a(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +16 -> 17
    //   4: invokestatic 37	com/tencent/component/network/utils/PlatformUtil:a	()I
    //   7: bipush 8
    //   9: if_icmplt +8 -> 17
    //   12: aload_0
    //   13: invokevirtual 97	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   16: areturn
    //   17: ldc 2
    //   19: monitorenter
    //   20: new 45	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   27: aload_0
    //   28: invokevirtual 50	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: astore_2
    //   35: iload_1
    //   36: ifeq +68 -> 104
    //   39: ldc 56
    //   41: astore_0
    //   42: aload_2
    //   43: aload_0
    //   44: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 99	cuy:a	(Ljava/lang/String;)Ljava/io/File;
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 66	java/io/File:exists	()Z
    //   58: istore_1
    //   59: iload_1
    //   60: ifne +62 -> 122
    //   63: new 10	java/io/File
    //   66: dup
    //   67: invokestatic 68	cuy:a	()Ljava/io/File;
    //   70: ldc 70
    //   72: invokespecial 22	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: invokevirtual 73	java/io/File:createNewFile	()Z
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 76	java/io/File:mkdirs	()Z
    //   83: ifne +39 -> 122
    //   86: ldc 78
    //   88: ldc 101
    //   90: invokestatic 107	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: ldc 2
    //   95: monitorexit
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    //   104: ldc 88
    //   106: astore_0
    //   107: goto -65 -> 42
    //   110: astore_2
    //   111: ldc 78
    //   113: ldc 88
    //   115: aload_2
    //   116: invokestatic 111	com/tencent/component/network/module/base/b:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: goto -40 -> 79
    //   122: ldc 2
    //   124: monitorexit
    //   125: aload_0
    //   126: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramContext	android.content.Context
    //   0	127	1	paramBoolean	boolean
    //   34	9	2	localStringBuilder	java.lang.StringBuilder
    //   110	6	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   20	35	98	finally
    //   42	59	98	finally
    //   63	79	98	finally
    //   79	96	98	finally
    //   99	102	98	finally
    //   111	119	98	finally
    //   122	125	98	finally
    //   63	79	110	java/io/IOException
  }
  
  public static File a(String paramString)
  {
    return new File(new File(a, paramString), "cache");
  }
  
  public static File b(String paramString)
  {
    return new File(new File(a, paramString), "files");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cuy
 * JD-Core Version:    0.7.0.1
 */