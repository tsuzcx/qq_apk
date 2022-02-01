package com.tencent.mm.plugin.appbrand.game.preload;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final String lyR;
  
  static
  {
    AppMethodBeat.i(45275);
    lyR = b.bOR();
    AppMethodBeat.o(45275);
  }
  
  public static a bOQ()
  {
    return b.ooN;
  }
  
  /* Error */
  public static void ds(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 51	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 58
    //   18: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 6
    //   26: ldc 63
    //   28: ldc 65
    //   30: iconst_1
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload 6
    //   38: aastore
    //   39: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: new 72	java/io/BufferedInputStream
    //   45: dup
    //   46: new 74	java/net/URL
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 77	java/net/URL:<init>	(Ljava/lang/String;)V
    //   54: invokevirtual 81	java/net/URL:openStream	()Ljava/io/InputStream;
    //   57: invokespecial 84	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +344 -> 408
    //   67: aload 6
    //   69: invokestatic 90	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   72: astore_1
    //   73: aload_1
    //   74: astore_3
    //   75: sipush 1024
    //   78: newarray byte
    //   80: astore 5
    //   82: aload_1
    //   83: astore_3
    //   84: aload 4
    //   86: aload 5
    //   88: invokevirtual 96	java/io/InputStream:read	([B)I
    //   91: istore_2
    //   92: iload_2
    //   93: iconst_m1
    //   94: if_icmpeq +107 -> 201
    //   97: aload_1
    //   98: astore_3
    //   99: aload_1
    //   100: aload 5
    //   102: iconst_0
    //   103: iload_2
    //   104: invokevirtual 102	java/io/OutputStream:write	([BII)V
    //   107: goto -25 -> 82
    //   110: astore 5
    //   112: aload_1
    //   113: astore_3
    //   114: ldc 63
    //   116: aload 5
    //   118: ldc 104
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 111	java/io/OutputStream:close	()V
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 112	java/io/InputStream:close	()V
    //   145: new 114	com/tencent/mm/vfs/q
    //   148: dup
    //   149: aload 6
    //   151: invokespecial 115	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   154: new 114	com/tencent/mm/vfs/q
    //   157: dup
    //   158: aload_0
    //   159: invokespecial 115	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   162: invokevirtual 119	com/tencent/mm/vfs/q:aj	(Lcom/tencent/mm/vfs/q;)Z
    //   165: pop
    //   166: ldc 49
    //   168: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: return
    //   172: astore_3
    //   173: ldc 63
    //   175: ldc 121
    //   177: iconst_2
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_1
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload_3
    //   188: invokevirtual 122	java/lang/Exception:toString	()Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aconst_null
    //   196: astore 4
    //   198: goto -136 -> 62
    //   201: aload_1
    //   202: astore_3
    //   203: aload_1
    //   204: invokevirtual 128	java/io/OutputStream:flush	()V
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 111	java/io/OutputStream:close	()V
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 112	java/io/InputStream:close	()V
    //   225: new 114	com/tencent/mm/vfs/q
    //   228: dup
    //   229: aload 6
    //   231: invokespecial 115	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   234: new 114	com/tencent/mm/vfs/q
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 115	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   242: invokevirtual 119	com/tencent/mm/vfs/q:aj	(Lcom/tencent/mm/vfs/q;)Z
    //   245: pop
    //   246: ldc 49
    //   248: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_1
    //   253: ldc 63
    //   255: aload_1
    //   256: ldc 104
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: goto -50 -> 215
    //   268: astore_1
    //   269: ldc 63
    //   271: aload_1
    //   272: ldc 104
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: goto -56 -> 225
    //   284: astore_1
    //   285: ldc 63
    //   287: aload_1
    //   288: ldc 104
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: goto -162 -> 135
    //   300: astore_1
    //   301: ldc 63
    //   303: aload_1
    //   304: ldc 104
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: goto -168 -> 145
    //   316: astore_1
    //   317: aconst_null
    //   318: astore_3
    //   319: aload_3
    //   320: ifnull +7 -> 327
    //   323: aload_3
    //   324: invokevirtual 111	java/io/OutputStream:close	()V
    //   327: aload 4
    //   329: ifnull +8 -> 337
    //   332: aload 4
    //   334: invokevirtual 112	java/io/InputStream:close	()V
    //   337: new 114	com/tencent/mm/vfs/q
    //   340: dup
    //   341: aload 6
    //   343: invokespecial 115	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   346: new 114	com/tencent/mm/vfs/q
    //   349: dup
    //   350: aload_0
    //   351: invokespecial 115	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   354: invokevirtual 119	com/tencent/mm/vfs/q:aj	(Lcom/tencent/mm/vfs/q;)Z
    //   357: pop
    //   358: ldc 49
    //   360: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: aload_1
    //   364: athrow
    //   365: astore_3
    //   366: ldc 63
    //   368: aload_3
    //   369: ldc 104
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: goto -51 -> 327
    //   381: astore_3
    //   382: ldc 63
    //   384: aload_3
    //   385: ldc 104
    //   387: iconst_0
    //   388: anewarray 4	java/lang/Object
    //   391: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: goto -57 -> 337
    //   397: astore_1
    //   398: goto -79 -> 319
    //   401: astore 5
    //   403: aconst_null
    //   404: astore_1
    //   405: goto -293 -> 112
    //   408: aconst_null
    //   409: astore_1
    //   410: goto -203 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramString1	String
    //   0	413	1	paramString2	String
    //   91	13	2	i	int
    //   74	40	3	str1	String
    //   172	16	3	localException	java.lang.Exception
    //   202	122	3	str2	String
    //   365	4	3	localIOException1	java.io.IOException
    //   381	4	3	localIOException2	java.io.IOException
    //   60	273	4	localBufferedInputStream	java.io.BufferedInputStream
    //   80	21	5	arrayOfByte	byte[]
    //   110	7	5	localIOException3	java.io.IOException
    //   401	1	5	localIOException4	java.io.IOException
    //   24	318	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   75	82	110	java/io/IOException
    //   84	92	110	java/io/IOException
    //   99	107	110	java/io/IOException
    //   203	207	110	java/io/IOException
    //   42	62	172	java/lang/Exception
    //   211	215	252	java/io/IOException
    //   220	225	268	java/io/IOException
    //   131	135	284	java/io/IOException
    //   140	145	300	java/io/IOException
    //   67	73	316	finally
    //   323	327	365	java/io/IOException
    //   332	337	381	java/io/IOException
    //   75	82	397	finally
    //   84	92	397	finally
    //   99	107	397	finally
    //   114	127	397	finally
    //   203	207	397	finally
    //   67	73	401	java/io/IOException
  }
  
  public static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap, long paramLong);
  }
  
  static final class b
  {
    static final a ooN;
    
    static
    {
      AppMethodBeat.i(45273);
      ooN = new a();
      AppMethodBeat.o(45273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.a
 * JD-Core Version:    0.7.0.1
 */