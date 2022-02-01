package com.tencent.mm.plugin.ai.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
{
  /* Error */
  public static boolean cB(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: ldc 9
    //   8: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokestatic 21	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   15: pop
    //   16: new 23	java/util/zip/ZipInputStream
    //   19: dup
    //   20: new 25	java/io/BufferedInputStream
    //   23: dup
    //   24: aload_1
    //   25: invokestatic 29	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   61: ifnull +330 -> 391
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
    //   118: invokestatic 58	com/tencent/mm/plugin/ai/c/a/c:cC	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   258: invokestatic 108	com/tencent/mm/vfs/y:bEp	(Ljava/lang/String;)Z
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
    //   289: iconst_0
    //   290: invokestatic 112	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   293: astore_1
    //   294: aload_1
    //   295: astore 5
    //   297: aload_1
    //   298: astore 6
    //   300: aload 7
    //   302: aload 8
    //   304: invokevirtual 116	java/util/zip/ZipInputStream:read	([B)I
    //   307: istore_2
    //   308: iload_2
    //   309: iconst_m1
    //   310: if_icmpeq +58 -> 368
    //   313: aload_1
    //   314: astore 5
    //   316: aload_1
    //   317: astore 6
    //   319: aload_1
    //   320: aload 8
    //   322: iconst_0
    //   323: iload_2
    //   324: invokevirtual 120	java/io/OutputStream:write	([BII)V
    //   327: goto -33 -> 294
    //   330: astore_0
    //   331: aload 6
    //   333: astore_1
    //   334: aload 7
    //   336: astore 5
    //   338: aload 5
    //   340: ifnull +13 -> 353
    //   343: aload 5
    //   345: invokevirtual 96	java/util/zip/ZipInputStream:closeEntry	()V
    //   348: aload 5
    //   350: invokevirtual 99	java/util/zip/ZipInputStream:close	()V
    //   353: aload_1
    //   354: ifnull +7 -> 361
    //   357: aload_1
    //   358: invokevirtual 102	java/io/OutputStream:close	()V
    //   361: ldc 9
    //   363: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload_0
    //   367: athrow
    //   368: aload_1
    //   369: astore 5
    //   371: aload_1
    //   372: astore 6
    //   374: aload_1
    //   375: invokevirtual 123	java/io/OutputStream:flush	()V
    //   378: aload_1
    //   379: astore 5
    //   381: aload_1
    //   382: astore 6
    //   384: aload_1
    //   385: invokevirtual 102	java/io/OutputStream:close	()V
    //   388: goto -342 -> 46
    //   391: aload 7
    //   393: invokevirtual 96	java/util/zip/ZipInputStream:closeEntry	()V
    //   396: aload 7
    //   398: invokevirtual 99	java/util/zip/ZipInputStream:close	()V
    //   401: iload 4
    //   403: istore_3
    //   404: aload_1
    //   405: ifnull -179 -> 226
    //   408: aload_1
    //   409: invokevirtual 102	java/io/OutputStream:close	()V
    //   412: iload 4
    //   414: istore_3
    //   415: goto -189 -> 226
    //   418: astore_0
    //   419: ldc 84
    //   421: aload_0
    //   422: ldc 125
    //   424: iconst_0
    //   425: anewarray 4	java/lang/Object
    //   428: invokestatic 93	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: iload 4
    //   433: istore_3
    //   434: goto -208 -> 226
    //   437: astore_0
    //   438: ldc 84
    //   440: aload_0
    //   441: ldc 125
    //   443: iconst_0
    //   444: anewarray 4	java/lang/Object
    //   447: invokestatic 93	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   450: iconst_0
    //   451: istore_3
    //   452: goto -226 -> 226
    //   455: astore_1
    //   456: ldc 84
    //   458: aload_1
    //   459: ldc 125
    //   461: iconst_0
    //   462: anewarray 4	java/lang/Object
    //   465: invokestatic 93	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   468: goto -107 -> 361
    //   471: astore_0
    //   472: aconst_null
    //   473: astore 5
    //   475: aconst_null
    //   476: astore_1
    //   477: goto -139 -> 338
    //   480: astore_0
    //   481: aconst_null
    //   482: astore_1
    //   483: aload 7
    //   485: astore 5
    //   487: goto -149 -> 338
    //   490: astore_0
    //   491: goto -153 -> 338
    //   494: astore_0
    //   495: aconst_null
    //   496: astore 5
    //   498: aconst_null
    //   499: astore_1
    //   500: goto -318 -> 182
    //   503: astore_0
    //   504: aconst_null
    //   505: astore_1
    //   506: aload 7
    //   508: astore 5
    //   510: goto -328 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	paramString1	String
    //   0	513	1	paramString2	String
    //   307	17	2	i	int
    //   225	227	3	bool1	boolean
    //   4	428	4	bool2	boolean
    //   1	508	5	localObject	Object
    //   50	333	6	str1	String
    //   34	473	7	localZipInputStream	java.util.zip.ZipInputStream
    //   41	280	8	arrayOfByte	byte[]
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
    //   270	294	174	java/io/IOException
    //   300	308	174	java/io/IOException
    //   319	327	174	java/io/IOException
    //   374	378	174	java/io/IOException
    //   384	388	174	java/io/IOException
    //   52	59	330	finally
    //   70	77	330	finally
    //   83	93	330	finally
    //   99	109	330	finally
    //   115	121	330	finally
    //   127	135	330	finally
    //   141	171	330	finally
    //   239	264	330	finally
    //   270	294	330	finally
    //   300	308	330	finally
    //   319	327	330	finally
    //   374	378	330	finally
    //   384	388	330	finally
    //   391	401	418	java/io/IOException
    //   408	412	418	java/io/IOException
    //   206	216	437	java/io/IOException
    //   220	224	437	java/io/IOException
    //   343	353	455	java/io/IOException
    //   357	361	455	java/io/IOException
    //   16	36	471	finally
    //   36	43	480	finally
    //   182	201	490	finally
    //   16	36	494	java/io/IOException
    //   36	43	503	java/io/IOException
  }
  
  private static void cC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267457);
    paramString1 = paramString1.split("/");
    if (paramString1.length <= 1)
    {
      AppMethodBeat.o(267457);
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
    AppMethodBeat.o(267457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.c.a.c
 * JD-Core Version:    0.7.0.1
 */