package com.tencent.mm.aw.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.g;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.modelsfs.SFSInputStream;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements com.tencent.mm.aw.a.c.b
{
  private g hku;
  
  private String a(String paramString, com.tencent.mm.aw.a.a.c paramc)
  {
    AppMethodBeat.i(130405);
    Object localObject2 = paramc.gjt;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject2 = paramc.prefixPath;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {
          localObject1 = (String)localObject2 + "/" + this.hku.yA(paramString);
        }
      }
    }
    localObject2 = localObject1;
    if (paramc.hjT)
    {
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = com.tencent.mm.aw.a.g.b.ajj() + "/" + this.hku.yA(paramString);
      }
    }
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      AppMethodBeat.o(130405);
      return null;
    }
    AppMethodBeat.o(130405);
    return localObject2;
  }
  
  private String b(String paramString, com.tencent.mm.aw.a.a.c paramc)
  {
    AppMethodBeat.i(130406);
    String str1 = paramc.hjW;
    Object localObject;
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      String str2 = paramc.gjt;
      localObject = str1;
      if (str2 != null)
      {
        localObject = str1;
        if (str2.length() > 0)
        {
          paramc = paramc.prefixPath;
          if ((paramc == null) || (paramc.length() == 0) || (!str2.startsWith(paramc)))
          {
            ad.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", new Object[] { str2 });
            paramString = new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(130406);
            throw paramString;
          }
          paramc = str2.substring(paramc.length());
          localObject = paramc;
          if (paramc.startsWith("/")) {
            localObject = paramc.substring(1);
          }
        }
      }
    }
    if (localObject != null)
    {
      paramc = (com.tencent.mm.aw.a.a.c)localObject;
      if (((String)localObject).length() != 0) {}
    }
    else
    {
      paramc = this.hku.yA(paramString);
    }
    if ((paramc == null) || (paramc.length() == 0))
    {
      AppMethodBeat.o(130406);
      return null;
    }
    AppMethodBeat.o(130406);
    return paramc;
  }
  
  public final void a(g paramg)
  {
    this.hku = paramg;
  }
  
  /* Error */
  public final boolean a(String paramString, byte[] paramArrayOfByte, com.tencent.mm.aw.a.a.c paramc)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: getfield 123	com/tencent/mm/aw/a/a/c:hkl	Lcom/tencent/mm/modelsfs/SFSContext;
    //   9: astore 11
    //   11: aload 11
    //   13: ifnull +411 -> 424
    //   16: aload_0
    //   17: aload_1
    //   18: aload_3
    //   19: invokespecial 125	com/tencent/mm/aw/a/b/a:b	(Ljava/lang/String;Lcom/tencent/mm/aw/a/a/c;)Ljava/lang/String;
    //   22: astore 8
    //   24: aload 8
    //   26: ifnonnull +10 -> 36
    //   29: ldc 119
    //   31: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_0
    //   35: ireturn
    //   36: aconst_null
    //   37: astore 10
    //   39: aconst_null
    //   40: astore 9
    //   42: aload 9
    //   44: astore_3
    //   45: aload 10
    //   47: astore 7
    //   49: aload 11
    //   51: getfield 131	com/tencent/mm/modelsfs/SFSContext:mNativePtr	J
    //   54: lconst_0
    //   55: lcmp
    //   56: ifne +57 -> 113
    //   59: aload 9
    //   61: astore_3
    //   62: aload 10
    //   64: astore 7
    //   66: new 96	java/lang/IllegalArgumentException
    //   69: dup
    //   70: ldc 133
    //   72: invokespecial 108	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   75: astore_1
    //   76: aload 9
    //   78: astore_3
    //   79: aload 10
    //   81: astore 7
    //   83: ldc 119
    //   85: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload 9
    //   90: astore_3
    //   91: aload 10
    //   93: astore 7
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 138	java/io/OutputStream:close	()V
    //   106: ldc 119
    //   108: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 9
    //   115: astore_3
    //   116: aload 10
    //   118: astore 7
    //   120: aload 8
    //   122: invokestatic 143	com/tencent/mm/modelsfs/e:yX	(Ljava/lang/String;)Z
    //   125: ifeq +412 -> 537
    //   128: aload 9
    //   130: astore_3
    //   131: aload 10
    //   133: astore 7
    //   135: aload 8
    //   137: ldc 145
    //   139: invokevirtual 149	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   142: istore 4
    //   144: iload 4
    //   146: ifle +111 -> 257
    //   149: aload 9
    //   151: astore_3
    //   152: aload 10
    //   154: astore 7
    //   156: aload 8
    //   158: iload 4
    //   160: bipush 6
    //   162: iadd
    //   163: invokevirtual 112	java/lang/String:substring	(I)Ljava/lang/String;
    //   166: invokevirtual 152	java/lang/String:trim	()Ljava/lang/String;
    //   169: astore_1
    //   170: aload 9
    //   172: astore_3
    //   173: aload 10
    //   175: astore 7
    //   177: aload 8
    //   179: invokestatic 155	com/tencent/mm/modelsfs/e:yY	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 8
    //   184: aload 9
    //   186: astore_3
    //   187: aload 10
    //   189: astore 7
    //   191: aload 11
    //   193: getfield 131	com/tencent/mm/modelsfs/SFSContext:mNativePtr	J
    //   196: lconst_0
    //   197: lcmp
    //   198: ifne +65 -> 263
    //   201: aload 9
    //   203: astore_3
    //   204: aload 10
    //   206: astore 7
    //   208: new 96	java/lang/IllegalArgumentException
    //   211: dup
    //   212: ldc 133
    //   214: invokespecial 108	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   217: astore_1
    //   218: aload 9
    //   220: astore_3
    //   221: aload 10
    //   223: astore 7
    //   225: ldc 119
    //   227: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload 9
    //   232: astore_3
    //   233: aload 10
    //   235: astore 7
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: aload 7
    //   242: ifnull +8 -> 250
    //   245: aload 7
    //   247: invokevirtual 138	java/io/OutputStream:close	()V
    //   250: ldc 119
    //   252: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload_1
    //   256: athrow
    //   257: ldc 157
    //   259: astore_1
    //   260: goto -90 -> 170
    //   263: aload 9
    //   265: astore_3
    //   266: aload 10
    //   268: astore 7
    //   270: aload 11
    //   272: getfield 131	com/tencent/mm/modelsfs/SFSContext:mNativePtr	J
    //   275: aload 8
    //   277: invokestatic 161	com/tencent/mm/modelsfs/SFSContext:nativeOpenWrite	(JLjava/lang/String;)J
    //   280: lstore 5
    //   282: lload 5
    //   284: lconst_0
    //   285: lcmp
    //   286: ifne +65 -> 351
    //   289: aload 9
    //   291: astore_3
    //   292: aload 10
    //   294: astore 7
    //   296: new 116	java/io/IOException
    //   299: dup
    //   300: new 39	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   307: aload 8
    //   309: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc 163
    //   314: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokestatic 166	com/tencent/mm/modelsfs/SFSContext:nativeErrorMessage	()Ljava/lang/String;
    //   320: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokespecial 167	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   329: astore_1
    //   330: aload 9
    //   332: astore_3
    //   333: aload 10
    //   335: astore 7
    //   337: ldc 119
    //   339: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aload 9
    //   344: astore_3
    //   345: aload 10
    //   347: astore 7
    //   349: aload_1
    //   350: athrow
    //   351: aload 9
    //   353: astore_3
    //   354: aload 10
    //   356: astore 7
    //   358: aload_1
    //   359: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   362: ifne +42 -> 404
    //   365: aload 9
    //   367: astore_3
    //   368: aload 10
    //   370: astore 7
    //   372: new 175	com/tencent/mm/modelsfs/d
    //   375: dup
    //   376: lload 5
    //   378: aload_1
    //   379: invokespecial 178	com/tencent/mm/modelsfs/d:<init>	(JLjava/lang/String;)V
    //   382: astore_1
    //   383: aload_1
    //   384: astore_3
    //   385: aload_1
    //   386: astore 7
    //   388: aload_1
    //   389: aload_2
    //   390: invokevirtual 182	java/io/OutputStream:write	([B)V
    //   393: aload_1
    //   394: invokevirtual 138	java/io/OutputStream:close	()V
    //   397: ldc 119
    //   399: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: iconst_1
    //   403: ireturn
    //   404: aload 9
    //   406: astore_3
    //   407: aload 10
    //   409: astore 7
    //   411: new 184	com/tencent/mm/modelsfs/SFSOutputStream
    //   414: dup
    //   415: lload 5
    //   417: invokespecial 187	com/tencent/mm/modelsfs/SFSOutputStream:<init>	(J)V
    //   420: astore_1
    //   421: goto -38 -> 383
    //   424: aload_0
    //   425: aload_1
    //   426: aload_3
    //   427: invokespecial 189	com/tencent/mm/aw/a/b/a:a	(Ljava/lang/String;Lcom/tencent/mm/aw/a/a/c;)Ljava/lang/String;
    //   430: astore_1
    //   431: aload_1
    //   432: ifnonnull +10 -> 442
    //   435: ldc 119
    //   437: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: iconst_0
    //   441: ireturn
    //   442: new 191	com/tencent/mm/vfs/e
    //   445: dup
    //   446: aload_1
    //   447: invokespecial 192	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   450: invokevirtual 196	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   453: astore_3
    //   454: aload_3
    //   455: ifnull +15 -> 470
    //   458: aload_3
    //   459: invokevirtual 200	com/tencent/mm/vfs/e:exists	()Z
    //   462: ifne +8 -> 470
    //   465: aload_3
    //   466: invokevirtual 203	com/tencent/mm/vfs/e:mkdirs	()Z
    //   469: pop
    //   470: new 191	com/tencent/mm/vfs/e
    //   473: dup
    //   474: aload_1
    //   475: invokespecial 192	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   478: astore_3
    //   479: aload_3
    //   480: invokevirtual 200	com/tencent/mm/vfs/e:exists	()Z
    //   483: ifne +8 -> 491
    //   486: aload_3
    //   487: invokevirtual 206	com/tencent/mm/vfs/e:createNewFile	()Z
    //   490: pop
    //   491: aload_2
    //   492: ifnull -95 -> 397
    //   495: aload_1
    //   496: aload_2
    //   497: aload_2
    //   498: arraylength
    //   499: invokestatic 212	com/tencent/mm/vfs/i:f	(Ljava/lang/String;[BI)I
    //   502: ifge -105 -> 397
    //   505: ldc 119
    //   507: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   510: iconst_0
    //   511: ireturn
    //   512: astore_3
    //   513: ldc 86
    //   515: aload_3
    //   516: invokestatic 216	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   519: invokestatic 219	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: goto -31 -> 491
    //   525: astore_1
    //   526: goto -129 -> 397
    //   529: astore_1
    //   530: goto -424 -> 106
    //   533: astore_2
    //   534: goto -284 -> 250
    //   537: ldc 157
    //   539: astore_1
    //   540: goto -356 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	543	0	this	a
    //   0	543	1	paramString	String
    //   0	543	2	paramArrayOfByte	byte[]
    //   0	543	3	paramc	com.tencent.mm.aw.a.a.c
    //   142	21	4	i	int
    //   280	136	5	l	long
    //   47	363	7	localObject1	Object
    //   22	286	8	str	String
    //   40	365	9	localObject2	Object
    //   37	371	10	localObject3	Object
    //   9	262	11	localSFSContext	SFSContext
    // Exception table:
    //   from	to	target	type
    //   49	59	97	java/io/IOException
    //   66	76	97	java/io/IOException
    //   83	88	97	java/io/IOException
    //   95	97	97	java/io/IOException
    //   120	128	97	java/io/IOException
    //   135	144	97	java/io/IOException
    //   156	170	97	java/io/IOException
    //   177	184	97	java/io/IOException
    //   191	201	97	java/io/IOException
    //   208	218	97	java/io/IOException
    //   225	230	97	java/io/IOException
    //   237	239	97	java/io/IOException
    //   270	282	97	java/io/IOException
    //   296	330	97	java/io/IOException
    //   337	342	97	java/io/IOException
    //   349	351	97	java/io/IOException
    //   358	365	97	java/io/IOException
    //   372	383	97	java/io/IOException
    //   388	393	97	java/io/IOException
    //   411	421	97	java/io/IOException
    //   49	59	239	finally
    //   66	76	239	finally
    //   83	88	239	finally
    //   95	97	239	finally
    //   120	128	239	finally
    //   135	144	239	finally
    //   156	170	239	finally
    //   177	184	239	finally
    //   191	201	239	finally
    //   208	218	239	finally
    //   225	230	239	finally
    //   237	239	239	finally
    //   270	282	239	finally
    //   296	330	239	finally
    //   337	342	239	finally
    //   349	351	239	finally
    //   358	365	239	finally
    //   372	383	239	finally
    //   388	393	239	finally
    //   411	421	239	finally
    //   486	491	512	java/lang/Exception
    //   393	397	525	java/io/IOException
    //   102	106	529	java/io/IOException
    //   245	250	533	java/io/IOException
  }
  
  public final void azd()
  {
    AppMethodBeat.i(130409);
    com.tencent.mm.aw.a.g.b.azi();
    AppMethodBeat.o(130409);
  }
  
  public final boolean c(String paramString, com.tencent.mm.aw.a.a.c paramc)
  {
    AppMethodBeat.i(130408);
    SFSContext localSFSContext = paramc.hkl;
    if (localSFSContext != null)
    {
      paramc = b(paramString, paramc);
      if (paramc == null)
      {
        AppMethodBeat.o(130408);
        return false;
      }
      if (localSFSContext.mNativePtr == 0L)
      {
        paramString = new IllegalArgumentException("Reuse already released SFSContext.");
        AppMethodBeat.o(130408);
        throw paramString;
      }
      paramString = paramc;
      if (com.tencent.mm.modelsfs.e.yX(paramc))
      {
        com.tencent.mm.modelsfs.e.yZ(paramc);
        paramString = com.tencent.mm.modelsfs.e.yY(paramc);
      }
      bool = SFSContext.nativeUnlink(localSFSContext.mNativePtr, paramString);
      AppMethodBeat.o(130408);
      return bool;
    }
    paramString = a(paramString, paramc);
    if (paramString == null)
    {
      AppMethodBeat.o(130408);
      return false;
    }
    boolean bool = new com.tencent.mm.vfs.e(paramString).delete();
    AppMethodBeat.o(130408);
    return bool;
  }
  
  public final InputStream d(String paramString, com.tencent.mm.aw.a.a.c paramc)
  {
    AppMethodBeat.i(130410);
    SFSContext localSFSContext;
    try
    {
      localSFSContext = paramc.hkl;
      if (localSFSContext == null) {
        break label185;
      }
      paramString = b(paramString, paramc);
      if (paramString == null)
      {
        AppMethodBeat.o(130410);
        return null;
      }
      if (localSFSContext.mNativePtr == 0L)
      {
        paramString = new IllegalArgumentException("Reuse already released SFSContext.");
        AppMethodBeat.o(130410);
        throw paramString;
      }
    }
    catch (FileNotFoundException paramString)
    {
      AppMethodBeat.o(130410);
      return null;
    }
    long l1;
    if (com.tencent.mm.modelsfs.e.yX(paramString))
    {
      l1 = com.tencent.mm.modelsfs.e.yZ(paramString);
      paramString = com.tencent.mm.modelsfs.e.yY(paramString);
    }
    for (;;)
    {
      long l2 = SFSContext.nativeOpenRead(localSFSContext.mNativePtr, paramString);
      if (l2 == 0L)
      {
        paramString = new FileNotFoundException(paramString + ": " + SFSContext.nativeErrorMessage());
        AppMethodBeat.o(130410);
        throw paramString;
      }
      if (l1 != 0L)
      {
        paramString = new com.tencent.mm.modelsfs.c(l2, l1);
        AppMethodBeat.o(130410);
        return paramString;
      }
      paramString = new SFSInputStream(l2);
      AppMethodBeat.o(130410);
      return paramString;
      label185:
      paramString = a(paramString, paramc);
      if (paramString == null)
      {
        AppMethodBeat.o(130410);
        return null;
      }
      paramString = i.openRead(paramString);
      AppMethodBeat.o(130410);
      return paramString;
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aw.a.b.a
 * JD-Core Version:    0.7.0.1
 */