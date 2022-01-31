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
    //   0: ldc 33
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 41	java/io/File
    //   8: dup
    //   9: new 43	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: getfield 21	com/tencent/map/lib/gl/JNICallback$1:a	Ljava/lang/String;
    //   20: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 50
    //   25: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_3
    //   35: aload_3
    //   36: invokevirtual 61	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_3
    //   43: invokevirtual 64	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 66	java/io/FileOutputStream
    //   50: dup
    //   51: aload_3
    //   52: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_1
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 23	com/tencent/map/lib/gl/JNICallback$1:b	[B
    //   61: invokevirtual 73	java/io/FileOutputStream:write	([B)V
    //   64: aload_1
    //   65: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   68: iconst_1
    //   69: istore_2
    //   70: iload_2
    //   71: ifeq +19 -> 90
    //   74: aload_3
    //   75: new 41	java/io/File
    //   78: dup
    //   79: aload_0
    //   80: getfield 21	com/tencent/map/lib/gl/JNICallback$1:a	Ljava/lang/String;
    //   83: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 80	java/io/File:renameTo	(Ljava/io/File;)Z
    //   89: pop
    //   90: ldc 33
    //   92: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_1
    //   98: iconst_1
    //   99: istore_2
    //   100: goto -30 -> 70
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +84 -> 191
    //   110: aload_1
    //   111: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   114: iconst_0
    //   115: istore_2
    //   116: goto -46 -> 70
    //   119: astore_1
    //   120: iconst_0
    //   121: istore_2
    //   122: goto -52 -> 70
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +62 -> 191
    //   132: aload_1
    //   133: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   136: iconst_0
    //   137: istore_2
    //   138: goto -68 -> 70
    //   141: astore_1
    //   142: iconst_0
    //   143: istore_2
    //   144: goto -74 -> 70
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +7 -> 158
    //   154: aload_3
    //   155: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   158: ldc 33
    //   160: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_1
    //   164: athrow
    //   165: astore_3
    //   166: goto -8 -> 158
    //   169: astore_3
    //   170: aload_1
    //   171: astore 4
    //   173: aload_3
    //   174: astore_1
    //   175: aload 4
    //   177: astore_3
    //   178: goto -28 -> 150
    //   181: astore 4
    //   183: goto -55 -> 128
    //   186: astore 4
    //   188: goto -82 -> 106
    //   191: iconst_0
    //   192: istore_2
    //   193: goto -123 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	1
    //   0	196	1	paramVarArgs	Void[]
    //   69	124	2	i	int
    //   34	121	3	localFile	java.io.File
    //   165	1	3	localIOException1	java.io.IOException
    //   169	5	3	localObject1	java.lang.Object
    //   177	1	3	localObject2	java.lang.Object
    //   171	5	4	arrayOfVoid	Void[]
    //   181	1	4	localIOException2	java.io.IOException
    //   186	1	4	localFileNotFoundException	java.io.FileNotFoundException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.gl.JNICallback.1
 * JD-Core Version:    0.7.0.1
 */