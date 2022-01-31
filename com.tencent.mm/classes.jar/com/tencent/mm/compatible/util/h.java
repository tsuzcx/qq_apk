package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;

public final class h
{
  private static Boolean dzT = null;
  private static Boolean dzU = null;
  private static Boolean dzV = null;
  
  public static File getDataDirectory()
  {
    if (bk.bl(q.dyn.dxx)) {
      return Environment.getDataDirectory();
    }
    return new File(q.dyn.dxx);
  }
  
  public static File getDownloadCacheDirectory()
  {
    if (bk.bl(q.dyn.dxA)) {
      return Environment.getDownloadCacheDirectory();
    }
    return new File(q.dyn.dxA);
  }
  
  public static File getExternalStorageDirectory()
  {
    if (bk.bl(q.dyn.dxv)) {
      return Environment.getExternalStorageDirectory();
    }
    return new File(q.dyn.dxv);
  }
  
  @TargetApi(8)
  public static File getExternalStoragePublicDirectory(String paramString)
  {
    if (bk.bl(q.dyn.dxw)) {
      return Environment.getExternalStoragePublicDirectory(paramString);
    }
    return new File(q.dyn.dxw);
  }
  
  public static String getExternalStorageState()
  {
    if (bk.bl(q.dyn.dxz)) {
      return Environment.getExternalStorageState();
    }
    return q.dyn.dxz;
  }
  
  public static File getRootDirectory()
  {
    if (bk.bl(q.dyn.dxy)) {
      return Environment.getRootDirectory();
    }
    return new File(q.dyn.dxy);
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean zK()
  {
    // Byte code:
    //   0: getstatic 12	com/tencent/mm/compatible/util/h:dzT	Ljava/lang/Boolean;
    //   3: ifnonnull +58 -> 61
    //   6: new 90	java/io/FileInputStream
    //   9: dup
    //   10: new 43	java/io/File
    //   13: dup
    //   14: invokestatic 83	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   17: ldc 92
    //   19: invokespecial 95	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: new 100	java/util/Properties
    //   31: dup
    //   32: invokespecial 102	java/util/Properties:<init>	()V
    //   35: astore_2
    //   36: aload_1
    //   37: astore_0
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 106	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc 108
    //   48: invokevirtual 112	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   51: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   54: putstatic 12	com/tencent/mm/compatible/util/h:dzT	Ljava/lang/Boolean;
    //   57: aload_1
    //   58: invokevirtual 121	java/io/FileInputStream:close	()V
    //   61: getstatic 12	com/tencent/mm/compatible/util/h:dzT	Ljava/lang/Boolean;
    //   64: invokevirtual 124	java/lang/Boolean:booleanValue	()Z
    //   67: ireturn
    //   68: astore_2
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: astore_0
    //   73: ldc 126
    //   75: aload_2
    //   76: ldc 128
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 134	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_1
    //   86: astore_0
    //   87: iconst_0
    //   88: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   91: putstatic 12	com/tencent/mm/compatible/util/h:dzT	Ljava/lang/Boolean;
    //   94: aload_1
    //   95: ifnull -34 -> 61
    //   98: aload_1
    //   99: invokevirtual 121	java/io/FileInputStream:close	()V
    //   102: goto -41 -> 61
    //   105: astore_0
    //   106: goto -45 -> 61
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 121	java/io/FileInputStream:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_0
    //   123: goto -62 -> 61
    //   126: astore_0
    //   127: goto -7 -> 120
    //   130: astore_1
    //   131: goto -19 -> 112
    //   134: astore_2
    //   135: goto -64 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	60	0	localFileInputStream1	java.io.FileInputStream
    //   105	1	0	localException1	java.lang.Exception
    //   111	6	0	localObject1	Object
    //   122	1	0	localException2	java.lang.Exception
    //   126	1	0	localException3	java.lang.Exception
    //   25	74	1	localFileInputStream2	java.io.FileInputStream
    //   109	12	1	localObject2	Object
    //   130	1	1	localObject3	Object
    //   35	11	2	localProperties	java.util.Properties
    //   68	8	2	localException4	java.lang.Exception
    //   134	1	2	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   6	26	68	java/lang/Exception
    //   98	102	105	java/lang/Exception
    //   6	26	109	finally
    //   57	61	122	java/lang/Exception
    //   116	120	126	java/lang/Exception
    //   28	36	130	finally
    //   38	43	130	finally
    //   45	57	130	finally
    //   73	85	130	finally
    //   87	94	130	finally
    //   28	36	134	java/lang/Exception
    //   38	43	134	java/lang/Exception
    //   45	57	134	java/lang/Exception
  }
  
  /* Error */
  public static boolean zL()
  {
    // Byte code:
    //   0: getstatic 14	com/tencent/mm/compatible/util/h:dzU	Ljava/lang/Boolean;
    //   3: ifnonnull +65 -> 68
    //   6: new 90	java/io/FileInputStream
    //   9: dup
    //   10: new 43	java/io/File
    //   13: dup
    //   14: invokestatic 83	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   17: ldc 92
    //   19: invokespecial 95	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: new 100	java/util/Properties
    //   31: dup
    //   32: invokespecial 102	java/util/Properties:<init>	()V
    //   35: astore_2
    //   36: aload_1
    //   37: astore_0
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 106	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc 108
    //   48: ldc 138
    //   50: invokevirtual 142	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   53: ldc 144
    //   55: invokevirtual 150	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   61: putstatic 14	com/tencent/mm/compatible/util/h:dzU	Ljava/lang/Boolean;
    //   64: aload_1
    //   65: invokevirtual 121	java/io/FileInputStream:close	()V
    //   68: getstatic 14	com/tencent/mm/compatible/util/h:dzU	Ljava/lang/Boolean;
    //   71: invokevirtual 124	java/lang/Boolean:booleanValue	()Z
    //   74: ireturn
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: ldc 126
    //   82: aload_2
    //   83: ldc 128
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 134	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload_1
    //   93: astore_0
    //   94: iconst_0
    //   95: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: putstatic 14	com/tencent/mm/compatible/util/h:dzU	Ljava/lang/Boolean;
    //   101: aload_1
    //   102: ifnull -34 -> 68
    //   105: aload_1
    //   106: invokevirtual 121	java/io/FileInputStream:close	()V
    //   109: goto -41 -> 68
    //   112: astore_0
    //   113: goto -45 -> 68
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 121	java/io/FileInputStream:close	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore_0
    //   130: goto -62 -> 68
    //   133: astore_0
    //   134: goto -7 -> 127
    //   137: astore_1
    //   138: goto -19 -> 119
    //   141: astore_2
    //   142: goto -64 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	67	0	localFileInputStream1	java.io.FileInputStream
    //   112	1	0	localException1	java.lang.Exception
    //   118	6	0	localObject1	Object
    //   129	1	0	localException2	java.lang.Exception
    //   133	1	0	localException3	java.lang.Exception
    //   25	81	1	localFileInputStream2	java.io.FileInputStream
    //   116	12	1	localObject2	Object
    //   137	1	1	localObject3	Object
    //   35	11	2	localProperties	java.util.Properties
    //   75	8	2	localException4	java.lang.Exception
    //   141	1	2	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   6	26	75	java/lang/Exception
    //   105	109	112	java/lang/Exception
    //   6	26	116	finally
    //   64	68	129	java/lang/Exception
    //   123	127	133	java/lang/Exception
    //   28	36	137	finally
    //   38	43	137	finally
    //   45	64	137	finally
    //   80	92	137	finally
    //   94	101	137	finally
    //   28	36	141	java/lang/Exception
    //   38	43	141	java/lang/Exception
    //   45	64	141	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.h
 * JD-Core Version:    0.7.0.1
 */