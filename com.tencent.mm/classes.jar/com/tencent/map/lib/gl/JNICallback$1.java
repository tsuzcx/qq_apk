package com.tencent.map.lib.gl;

import com.tencent.map.lib.thread.AsyncTask;

class JNICallback$1
  extends AsyncTask<Void, Void, Void>
{
  JNICallback$1(JNICallback paramJNICallback, String paramString, byte[] paramArrayOfByte) {}
  
  /* Error */
  protected Void a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: new 34	java/io/File
    //   3: dup
    //   4: new 36	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: getfield 21	com/tencent/map/lib/gl/JNICallback$1:a	Ljava/lang/String;
    //   15: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 43
    //   20: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 54	java/io/File:exists	()Z
    //   34: ifne +8 -> 42
    //   37: aload_3
    //   38: invokevirtual 57	java/io/File:createNewFile	()Z
    //   41: pop
    //   42: new 59	java/io/FileOutputStream
    //   45: dup
    //   46: aload_3
    //   47: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: getfield 23	com/tencent/map/lib/gl/JNICallback$1:b	[B
    //   56: invokevirtual 66	java/io/FileOutputStream:write	([B)V
    //   59: aload_1
    //   60: invokevirtual 69	java/io/FileOutputStream:close	()V
    //   63: iconst_1
    //   64: istore_2
    //   65: iload_2
    //   66: ifeq +19 -> 85
    //   69: aload_3
    //   70: new 34	java/io/File
    //   73: dup
    //   74: aload_0
    //   75: getfield 21	com/tencent/map/lib/gl/JNICallback$1:a	Ljava/lang/String;
    //   78: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 73	java/io/File:renameTo	(Ljava/io/File;)Z
    //   84: pop
    //   85: aconst_null
    //   86: areturn
    //   87: astore_1
    //   88: iconst_1
    //   89: istore_2
    //   90: goto -25 -> 65
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +79 -> 176
    //   100: aload_1
    //   101: invokevirtual 69	java/io/FileOutputStream:close	()V
    //   104: iconst_0
    //   105: istore_2
    //   106: goto -41 -> 65
    //   109: astore_1
    //   110: iconst_0
    //   111: istore_2
    //   112: goto -47 -> 65
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull +57 -> 176
    //   122: aload_1
    //   123: invokevirtual 69	java/io/FileOutputStream:close	()V
    //   126: iconst_0
    //   127: istore_2
    //   128: goto -63 -> 65
    //   131: astore_1
    //   132: iconst_0
    //   133: istore_2
    //   134: goto -69 -> 65
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 69	java/io/FileOutputStream:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_3
    //   151: goto -3 -> 148
    //   154: astore_3
    //   155: aload_1
    //   156: astore 4
    //   158: aload_3
    //   159: astore_1
    //   160: aload 4
    //   162: astore_3
    //   163: goto -23 -> 140
    //   166: astore 4
    //   168: goto -50 -> 118
    //   171: astore 4
    //   173: goto -77 -> 96
    //   176: iconst_0
    //   177: istore_2
    //   178: goto -113 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	1
    //   0	181	1	paramVarArgs	Void[]
    //   64	114	2	i	int
    //   29	116	3	localFile	java.io.File
    //   150	1	3	localIOException1	java.io.IOException
    //   154	5	3	localObject1	java.lang.Object
    //   162	1	3	localObject2	java.lang.Object
    //   156	5	4	arrayOfVoid	Void[]
    //   166	1	4	localIOException2	java.io.IOException
    //   171	1	4	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   59	63	87	java/io/IOException
    //   30	42	93	java/io/FileNotFoundException
    //   42	51	93	java/io/FileNotFoundException
    //   100	104	109	java/io/IOException
    //   30	42	115	java/io/IOException
    //   42	51	115	java/io/IOException
    //   122	126	131	java/io/IOException
    //   30	42	137	finally
    //   42	51	137	finally
    //   144	148	150	java/io/IOException
    //   51	59	154	finally
    //   51	59	166	java/io/IOException
    //   51	59	171	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.gl.JNICallback.1
 * JD-Core Version:    0.7.0.1
 */