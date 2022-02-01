package com.tencent.mapsdk.engine.jni;

import android.os.AsyncTask;

final class JNICallback$a
  extends AsyncTask<Void, Void, Void>
{
  private String a;
  private byte[] b;
  
  JNICallback$a(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
  }
  
  /* Error */
  private Void a()
  {
    // Byte code:
    //   0: ldc 27
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 35	java/io/File
    //   8: dup
    //   9: new 37	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: getfield 18	com/tencent/mapsdk/engine/jni/JNICallback$a:a	Ljava/lang/String;
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 44
    //   25: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_3
    //   35: aload_3
    //   36: invokevirtual 55	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_3
    //   43: invokestatic 60	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;)Z
    //   46: pop
    //   47: new 62	java/io/FileOutputStream
    //   50: dup
    //   51: aload_3
    //   52: invokespecial 65	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_2
    //   56: aload_2
    //   57: aload_0
    //   58: getfield 20	com/tencent/mapsdk/engine/jni/JNICallback$a:b	[B
    //   61: invokevirtual 69	java/io/FileOutputStream:write	([B)V
    //   64: aload_2
    //   65: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   68: iconst_1
    //   69: istore_1
    //   70: iload_1
    //   71: ifeq +19 -> 90
    //   74: aload_3
    //   75: new 35	java/io/File
    //   78: dup
    //   79: aload_0
    //   80: getfield 18	com/tencent/mapsdk/engine/jni/JNICallback$a:a	Ljava/lang/String;
    //   83: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 75	java/io/File:renameTo	(Ljava/io/File;)Z
    //   89: pop
    //   90: ldc 27
    //   92: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_2
    //   98: iconst_1
    //   99: istore_1
    //   100: goto -30 -> 70
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +84 -> 191
    //   110: aload_2
    //   111: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   114: iconst_0
    //   115: istore_1
    //   116: goto -46 -> 70
    //   119: astore_2
    //   120: iconst_0
    //   121: istore_1
    //   122: goto -52 -> 70
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: ifnull +62 -> 191
    //   132: aload_2
    //   133: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   136: iconst_0
    //   137: istore_1
    //   138: goto -68 -> 70
    //   141: astore_2
    //   142: iconst_0
    //   143: istore_1
    //   144: goto -74 -> 70
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +7 -> 158
    //   154: aload_3
    //   155: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   158: ldc 27
    //   160: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_2
    //   164: athrow
    //   165: astore_3
    //   166: goto -8 -> 158
    //   169: astore_3
    //   170: aload_2
    //   171: astore 4
    //   173: aload_3
    //   174: astore_2
    //   175: aload 4
    //   177: astore_3
    //   178: goto -28 -> 150
    //   181: astore 4
    //   183: goto -55 -> 128
    //   186: astore 4
    //   188: goto -82 -> 106
    //   191: iconst_0
    //   192: istore_1
    //   193: goto -123 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	a
    //   69	124	1	i	int
    //   55	10	2	localFileOutputStream	java.io.FileOutputStream
    //   97	1	2	localIOException1	java.io.IOException
    //   103	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   105	6	2	localObject1	java.lang.Object
    //   119	1	2	localIOException2	java.io.IOException
    //   125	1	2	localIOException3	java.io.IOException
    //   127	6	2	localObject2	java.lang.Object
    //   141	1	2	localIOException4	java.io.IOException
    //   147	24	2	localObject3	java.lang.Object
    //   174	1	2	localObject4	java.lang.Object
    //   34	121	3	localFile	java.io.File
    //   165	1	3	localIOException5	java.io.IOException
    //   169	5	3	localObject5	java.lang.Object
    //   177	1	3	localObject6	java.lang.Object
    //   171	5	4	localObject7	java.lang.Object
    //   181	1	4	localIOException6	java.io.IOException
    //   186	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   64	68	97	java/io/IOException
    //   35	47	103	java/io/FileNotFoundException
    //   47	56	103	java/io/FileNotFoundException
    //   110	114	119	java/io/IOException
    //   35	47	125	java/io/IOException
    //   47	56	125	java/io/IOException
    //   132	136	141	java/io/IOException
    //   35	47	147	finally
    //   47	56	147	finally
    //   154	158	165	java/io/IOException
    //   56	64	169	finally
    //   56	64	181	java/io/IOException
    //   56	64	186	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.engine.jni.JNICallback.a
 * JD-Core Version:    0.7.0.1
 */