package com.tencent.beacon.a;

import android.content.Context;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static i c = null;
  private Context a = null;
  private Map<String, FileChannel> b = null;
  
  private i(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap(5);
  }
  
  public static i a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new i(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private java.io.File b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 37	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 22	com/tencent/beacon/a/i:a	Landroid/content/Context;
    //   10: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: new 45	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 47
    //   19: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 56
    //   28: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_1
    //   38: aload_1
    //   39: astore_2
    //   40: aload_1
    //   41: invokevirtual 67	java/io/File:exists	()Z
    //   44: ifne +26 -> 70
    //   47: ldc 69
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: invokevirtual 72	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 77	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_1
    //   64: invokevirtual 80	java/io/File:createNewFile	()Z
    //   67: pop
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_2
    //   78: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   81: aload_1
    //   82: astore_2
    //   83: goto -13 -> 70
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: goto -15 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	i
    //   0	95	1	paramString	String
    //   39	34	2	str1	String
    //   74	4	2	localIOException1	java.io.IOException
    //   82	1	2	str2	String
    //   91	1	2	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	38	74	java/io/IOException
    //   2	38	86	finally
    //   40	68	86	finally
    //   77	81	86	finally
    //   40	68	91	java/io/IOException
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +15 -> 18
    //   6: aload_1
    //   7: invokevirtual 91	java/lang/String:trim	()Ljava/lang/String;
    //   10: invokevirtual 95	java/lang/String:length	()I
    //   13: istore_2
    //   14: iload_2
    //   15: ifgt +9 -> 24
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_3
    //   23: ireturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 97	com/tencent/beacon/a/i:b	(Ljava/lang/String;)Ljava/io/File;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnonnull +8 -> 41
    //   36: iconst_1
    //   37: istore_3
    //   38: goto -18 -> 20
    //   41: aload_0
    //   42: getfield 24	com/tencent/beacon/a/i:b	Ljava/util/Map;
    //   45: aload_1
    //   46: invokeinterface 103 2 0
    //   51: checkcast 105	java/nio/channels/FileChannel
    //   54: astore 5
    //   56: aload 5
    //   58: ifnull +15 -> 73
    //   61: aload 5
    //   63: astore 4
    //   65: aload 5
    //   67: invokevirtual 108	java/nio/channels/FileChannel:isOpen	()Z
    //   70: ifne +43 -> 113
    //   73: ldc 110
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_1
    //   82: aastore
    //   83: invokestatic 77	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: new 112	java/io/FileOutputStream
    //   89: dup
    //   90: aload 6
    //   92: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: invokevirtual 119	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   98: astore 4
    //   100: aload_0
    //   101: getfield 24	com/tencent/beacon/a/i:b	Ljava/util/Map;
    //   104: aload_1
    //   105: aload 4
    //   107: invokeinterface 123 3 0
    //   112: pop
    //   113: aload 4
    //   115: invokevirtual 127	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull +22 -> 142
    //   123: aload_1
    //   124: invokevirtual 132	java/nio/channels/FileLock:isValid	()Z
    //   127: istore_3
    //   128: iload_3
    //   129: ifeq +13 -> 142
    //   132: iconst_1
    //   133: istore_3
    //   134: goto -114 -> 20
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   142: iconst_0
    //   143: istore_3
    //   144: goto -124 -> 20
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	i
    //   0	152	1	paramString	String
    //   13	2	2	i	int
    //   19	125	3	bool	boolean
    //   63	51	4	localFileChannel1	FileChannel
    //   54	12	5	localFileChannel2	FileChannel
    //   29	62	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   41	56	137	java/lang/Throwable
    //   65	73	137	java/lang/Throwable
    //   73	113	137	java/lang/Throwable
    //   113	119	137	java/lang/Throwable
    //   123	128	137	java/lang/Throwable
    //   6	14	147	finally
    //   24	31	147	finally
    //   41	56	147	finally
    //   65	73	147	finally
    //   73	113	147	finally
    //   113	119	147	finally
    //   123	128	147	finally
    //   138	142	147	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.i
 * JD-Core Version:    0.7.0.1
 */