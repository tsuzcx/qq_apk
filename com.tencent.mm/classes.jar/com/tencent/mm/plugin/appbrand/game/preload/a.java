package com.tencent.mm.plugin.appbrand.game.preload;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final String hsx;
  
  static
  {
    AppMethodBeat.i(45275);
    hsx = b.bdS();
    AppMethodBeat.o(45275);
  }
  
  public static a bdR()
  {
    return b.jSB;
  }
  
  /* Error */
  public static void cQ(String paramString1, String paramString2)
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
    //   39: invokestatic 70	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   64: ifnull +345 -> 409
    //   67: aload 6
    //   69: iconst_0
    //   70: invokestatic 90	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   73: astore_1
    //   74: aload_1
    //   75: astore_3
    //   76: sipush 1024
    //   79: newarray byte
    //   81: astore 5
    //   83: aload_1
    //   84: astore_3
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 96	java/io/InputStream:read	([B)I
    //   92: istore_2
    //   93: iload_2
    //   94: iconst_m1
    //   95: if_icmpeq +107 -> 202
    //   98: aload_1
    //   99: astore_3
    //   100: aload_1
    //   101: aload 5
    //   103: iconst_0
    //   104: iload_2
    //   105: invokevirtual 102	java/io/OutputStream:write	([BII)V
    //   108: goto -25 -> 83
    //   111: astore 5
    //   113: aload_1
    //   114: astore_3
    //   115: ldc 63
    //   117: aload 5
    //   119: ldc 104
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 111	java/io/OutputStream:close	()V
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 112	java/io/InputStream:close	()V
    //   146: new 114	com/tencent/mm/vfs/e
    //   149: dup
    //   150: aload 6
    //   152: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   155: new 114	com/tencent/mm/vfs/e
    //   158: dup
    //   159: aload_0
    //   160: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   163: invokevirtual 119	com/tencent/mm/vfs/e:ae	(Lcom/tencent/mm/vfs/e;)Z
    //   166: pop
    //   167: ldc 49
    //   169: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: return
    //   173: astore_3
    //   174: ldc 63
    //   176: ldc 121
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_1
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: aload_3
    //   189: invokevirtual 122	java/lang/Exception:toString	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 125	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aconst_null
    //   197: astore 4
    //   199: goto -137 -> 62
    //   202: aload_1
    //   203: astore_3
    //   204: aload_1
    //   205: invokevirtual 128	java/io/OutputStream:flush	()V
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 111	java/io/OutputStream:close	()V
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 112	java/io/InputStream:close	()V
    //   226: new 114	com/tencent/mm/vfs/e
    //   229: dup
    //   230: aload 6
    //   232: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   235: new 114	com/tencent/mm/vfs/e
    //   238: dup
    //   239: aload_0
    //   240: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   243: invokevirtual 119	com/tencent/mm/vfs/e:ae	(Lcom/tencent/mm/vfs/e;)Z
    //   246: pop
    //   247: ldc 49
    //   249: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: return
    //   253: astore_1
    //   254: ldc 63
    //   256: aload_1
    //   257: ldc 104
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: goto -50 -> 216
    //   269: astore_1
    //   270: ldc 63
    //   272: aload_1
    //   273: ldc 104
    //   275: iconst_0
    //   276: anewarray 4	java/lang/Object
    //   279: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: goto -56 -> 226
    //   285: astore_1
    //   286: ldc 63
    //   288: aload_1
    //   289: ldc 104
    //   291: iconst_0
    //   292: anewarray 4	java/lang/Object
    //   295: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: goto -162 -> 136
    //   301: astore_1
    //   302: ldc 63
    //   304: aload_1
    //   305: ldc 104
    //   307: iconst_0
    //   308: anewarray 4	java/lang/Object
    //   311: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: goto -168 -> 146
    //   317: astore_1
    //   318: aconst_null
    //   319: astore_3
    //   320: aload_3
    //   321: ifnull +7 -> 328
    //   324: aload_3
    //   325: invokevirtual 111	java/io/OutputStream:close	()V
    //   328: aload 4
    //   330: ifnull +8 -> 338
    //   333: aload 4
    //   335: invokevirtual 112	java/io/InputStream:close	()V
    //   338: new 114	com/tencent/mm/vfs/e
    //   341: dup
    //   342: aload 6
    //   344: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   347: new 114	com/tencent/mm/vfs/e
    //   350: dup
    //   351: aload_0
    //   352: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   355: invokevirtual 119	com/tencent/mm/vfs/e:ae	(Lcom/tencent/mm/vfs/e;)Z
    //   358: pop
    //   359: ldc 49
    //   361: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aload_1
    //   365: athrow
    //   366: astore_3
    //   367: ldc 63
    //   369: aload_3
    //   370: ldc 104
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   379: goto -51 -> 328
    //   382: astore_3
    //   383: ldc 63
    //   385: aload_3
    //   386: ldc 104
    //   388: iconst_0
    //   389: anewarray 4	java/lang/Object
    //   392: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: goto -57 -> 338
    //   398: astore_1
    //   399: goto -79 -> 320
    //   402: astore 5
    //   404: aconst_null
    //   405: astore_1
    //   406: goto -293 -> 113
    //   409: aconst_null
    //   410: astore_1
    //   411: goto -203 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	paramString1	String
    //   0	414	1	paramString2	String
    //   92	13	2	i	int
    //   75	40	3	str1	String
    //   173	16	3	localException	java.lang.Exception
    //   203	122	3	str2	String
    //   366	4	3	localIOException1	java.io.IOException
    //   382	4	3	localIOException2	java.io.IOException
    //   60	274	4	localBufferedInputStream	java.io.BufferedInputStream
    //   81	21	5	arrayOfByte	byte[]
    //   111	7	5	localIOException3	java.io.IOException
    //   402	1	5	localIOException4	java.io.IOException
    //   24	319	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   76	83	111	java/io/IOException
    //   85	93	111	java/io/IOException
    //   100	108	111	java/io/IOException
    //   204	208	111	java/io/IOException
    //   42	62	173	java/lang/Exception
    //   212	216	253	java/io/IOException
    //   221	226	269	java/io/IOException
    //   132	136	285	java/io/IOException
    //   141	146	301	java/io/IOException
    //   67	74	317	finally
    //   324	328	366	java/io/IOException
    //   333	338	382	java/io/IOException
    //   76	83	398	finally
    //   85	93	398	finally
    //   100	108	398	finally
    //   115	128	398	finally
    //   204	208	398	finally
    //   67	74	402	java/io/IOException
  }
  
  public static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap, long paramLong);
  }
  
  static final class b
  {
    static final a jSB;
    
    static
    {
      AppMethodBeat.i(45273);
      jSB = new a();
      AppMethodBeat.o(45273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.a
 * JD-Core Version:    0.7.0.1
 */