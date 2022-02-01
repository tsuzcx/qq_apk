package com.tencent.mm.plugin.ai.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
{
  /* Error */
  public static boolean cl(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: ldc 9
    //   8: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokestatic 21	com/tencent/mm/vfs/u:bBD	(Ljava/lang/String;)Z
    //   15: pop
    //   16: new 23	java/util/zip/ZipInputStream
    //   19: dup
    //   20: new 25	java/io/BufferedInputStream
    //   23: dup
    //   24: aload_1
    //   25: invokestatic 29	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: invokespecial 33	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: invokespecial 34	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore 7
    //   36: sipush 2048
    //   39: newarray byte
    //   41: astore 8
    //   43: aload 5
    //   45: astore_1
    //   46: aload_1
    //   47: astore 5
    //   49: aload_1
    //   50: astore 6
    //   52: aload 7
    //   54: invokevirtual 38	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   57: astore 9
    //   59: aload 9
    //   61: ifnull +329 -> 390
    //   64: aload_1
    //   65: astore 5
    //   67: aload_1
    //   68: astore 6
    //   70: aload 9
    //   72: invokevirtual 44	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   75: astore 10
    //   77: aload_1
    //   78: astore 5
    //   80: aload_1
    //   81: astore 6
    //   83: aload 10
    //   85: ldc 46
    //   87: invokevirtual 52	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifne -44 -> 46
    //   93: aload_1
    //   94: astore 5
    //   96: aload_1
    //   97: astore 6
    //   99: aload 10
    //   101: ldc 54
    //   103: invokevirtual 52	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   106: ifne -60 -> 46
    //   109: aload_1
    //   110: astore 5
    //   112: aload_1
    //   113: astore 6
    //   115: aload 10
    //   117: aload_0
    //   118: invokestatic 58	com/tencent/mm/plugin/ai/d/a/c:cm	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_1
    //   122: astore 5
    //   124: aload_1
    //   125: astore 6
    //   127: aload 9
    //   129: invokevirtual 62	java/util/zip/ZipEntry:isDirectory	()Z
    //   132: ifeq +101 -> 233
    //   135: aload_1
    //   136: astore 5
    //   138: aload_1
    //   139: astore 6
    //   141: new 64	java/io/File
    //   144: dup
    //   145: new 66	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   152: aload_0
    //   153: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 10
    //   158: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: invokevirtual 82	java/io/File:mkdirs	()Z
    //   170: pop
    //   171: goto -125 -> 46
    //   174: astore_0
    //   175: aload 5
    //   177: astore_1
    //   178: aload 7
    //   180: astore 5
    //   182: ldc 84
    //   184: aload_0
    //   185: ldc 86
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload_0
    //   194: invokevirtual 87	java/io/IOException:toString	()Ljava/lang/String;
    //   197: aastore
    //   198: invokestatic 93	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 5
    //   203: ifnull +13 -> 216
    //   206: aload 5
    //   208: invokevirtual 96	java/util/zip/ZipInputStream:closeEntry	()V
    //   211: aload 5
    //   213: invokevirtual 99	java/util/zip/ZipInputStream:close	()V
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 102	java/io/OutputStream:close	()V
    //   224: iconst_0
    //   225: istore_3
    //   226: ldc 9
    //   228: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: iload_3
    //   232: ireturn
    //   233: aload_1
    //   234: astore 5
    //   236: aload_1
    //   237: astore 6
    //   239: new 66	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   246: aload_0
    //   247: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 10
    //   252: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 108	com/tencent/mm/vfs/u:bBV	(Ljava/lang/String;)Z
    //   261: ifeq -215 -> 46
    //   264: aload_1
    //   265: astore 5
    //   267: aload_1
    //   268: astore 6
    //   270: new 66	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   277: aload_0
    //   278: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload 10
    //   283: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 112	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   292: astore_1
    //   293: aload_1
    //   294: astore 5
    //   296: aload_1
    //   297: astore 6
    //   299: aload 7
    //   301: aload 8
    //   303: invokevirtual 116	java/util/zip/ZipInputStream:read	([B)I
    //   306: istore_2
    //   307: iload_2
    //   308: iconst_m1
    //   309: if_icmpeq +58 -> 367
    //   312: aload_1
    //   313: astore 5
    //   315: aload_1
    //   316: astore 6
    //   318: aload_1
    //   319: aload 8
    //   321: iconst_0
    //   322: iload_2
    //   323: invokevirtual 120	java/io/OutputStream:write	([BII)V
    //   326: goto -33 -> 293
    //   329: astore_0
    //   330: aload 6
    //   332: astore_1
    //   333: aload 7
    //   335: astore 5
    //   337: aload 5
    //   339: ifnull +13 -> 352
    //   342: aload 5
    //   344: invokevirtual 96	java/util/zip/ZipInputStream:closeEntry	()V
    //   347: aload 5
    //   349: invokevirtual 99	java/util/zip/ZipInputStream:close	()V
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 102	java/io/OutputStream:close	()V
    //   360: ldc 9
    //   362: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: aload_0
    //   366: athrow
    //   367: aload_1
    //   368: astore 5
    //   370: aload_1
    //   371: astore 6
    //   373: aload_1
    //   374: invokevirtual 123	java/io/OutputStream:flush	()V
    //   377: aload_1
    //   378: astore 5
    //   380: aload_1
    //   381: astore 6
    //   383: aload_1
    //   384: invokevirtual 102	java/io/OutputStream:close	()V
    //   387: goto -341 -> 46
    //   390: aload 7
    //   392: invokevirtual 96	java/util/zip/ZipInputStream:closeEntry	()V
    //   395: aload 7
    //   397: invokevirtual 99	java/util/zip/ZipInputStream:close	()V
    //   400: iload 4
    //   402: istore_3
    //   403: aload_1
    //   404: ifnull -178 -> 226
    //   407: aload_1
    //   408: invokevirtual 102	java/io/OutputStream:close	()V
    //   411: iload 4
    //   413: istore_3
    //   414: goto -188 -> 226
    //   417: astore_0
    //   418: ldc 84
    //   420: aload_0
    //   421: ldc 125
    //   423: iconst_0
    //   424: anewarray 4	java/lang/Object
    //   427: invokestatic 93	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: iload 4
    //   432: istore_3
    //   433: goto -207 -> 226
    //   436: astore_0
    //   437: ldc 84
    //   439: aload_0
    //   440: ldc 125
    //   442: iconst_0
    //   443: anewarray 4	java/lang/Object
    //   446: invokestatic 93	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: iconst_0
    //   450: istore_3
    //   451: goto -225 -> 226
    //   454: astore_1
    //   455: ldc 84
    //   457: aload_1
    //   458: ldc 125
    //   460: iconst_0
    //   461: anewarray 4	java/lang/Object
    //   464: invokestatic 93	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: goto -107 -> 360
    //   470: astore_0
    //   471: aconst_null
    //   472: astore 5
    //   474: aconst_null
    //   475: astore_1
    //   476: goto -139 -> 337
    //   479: astore_0
    //   480: aconst_null
    //   481: astore_1
    //   482: aload 7
    //   484: astore 5
    //   486: goto -149 -> 337
    //   489: astore_0
    //   490: goto -153 -> 337
    //   493: astore_0
    //   494: aconst_null
    //   495: astore 5
    //   497: aconst_null
    //   498: astore_1
    //   499: goto -317 -> 182
    //   502: astore_0
    //   503: aconst_null
    //   504: astore_1
    //   505: aload 7
    //   507: astore 5
    //   509: goto -327 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	paramString1	String
    //   0	512	1	paramString2	String
    //   306	17	2	i	int
    //   225	226	3	bool1	boolean
    //   4	427	4	bool2	boolean
    //   1	507	5	localObject	Object
    //   50	332	6	str1	String
    //   34	472	7	localZipInputStream	java.util.zip.ZipInputStream
    //   41	279	8	arrayOfByte	byte[]
    //   57	71	9	localZipEntry	java.util.zip.ZipEntry
    //   75	207	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   52	59	174	java/io/IOException
    //   70	77	174	java/io/IOException
    //   83	93	174	java/io/IOException
    //   99	109	174	java/io/IOException
    //   115	121	174	java/io/IOException
    //   127	135	174	java/io/IOException
    //   141	171	174	java/io/IOException
    //   239	264	174	java/io/IOException
    //   270	293	174	java/io/IOException
    //   299	307	174	java/io/IOException
    //   318	326	174	java/io/IOException
    //   373	377	174	java/io/IOException
    //   383	387	174	java/io/IOException
    //   52	59	329	finally
    //   70	77	329	finally
    //   83	93	329	finally
    //   99	109	329	finally
    //   115	121	329	finally
    //   127	135	329	finally
    //   141	171	329	finally
    //   239	264	329	finally
    //   270	293	329	finally
    //   299	307	329	finally
    //   318	326	329	finally
    //   373	377	329	finally
    //   383	387	329	finally
    //   390	400	417	java/io/IOException
    //   407	411	417	java/io/IOException
    //   206	216	436	java/io/IOException
    //   220	224	436	java/io/IOException
    //   342	352	454	java/io/IOException
    //   356	360	454	java/io/IOException
    //   16	36	470	finally
    //   36	43	479	finally
    //   182	201	489	finally
    //   16	36	493	java/io/IOException
    //   36	43	502	java/io/IOException
  }
  
  private static void cm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(240266);
    paramString1 = paramString1.split("/");
    if (paramString1.length <= 1)
    {
      AppMethodBeat.o(240266);
      return;
    }
    int i = 0;
    while (i < paramString1.length - 1)
    {
      paramString2 = paramString2 + paramString1[i] + "/";
      File localFile = new File(paramString2);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      i += 1;
    }
    AppMethodBeat.o(240266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.a.c
 * JD-Core Version:    0.7.0.1
 */