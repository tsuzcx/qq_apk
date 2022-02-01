package com.tencent.mm.av.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.g;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.modelsfs.SFSInputStream;
import com.tencent.mm.modelsfs.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements com.tencent.mm.av.a.c.b
{
  private g jbF;
  
  private String a(String paramString, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130405);
    Object localObject2 = paramc.fullPath;
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
          localObject1 = (String)localObject2 + "/" + this.jbF.OX(paramString);
        }
      }
    }
    localObject2 = localObject1;
    if (paramc.jbe)
    {
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = com.tencent.mm.av.a.g.b.aLN() + "/" + this.jbF.OX(paramString);
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
  
  private String b(String paramString, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130406);
    String str1 = paramc.jbh;
    Object localObject;
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      String str2 = paramc.fullPath;
      localObject = str1;
      if (str2 != null)
      {
        localObject = str1;
        if (str2.length() > 0)
        {
          paramc = paramc.prefixPath;
          if ((paramc == null) || (paramc.length() == 0) || (!str2.startsWith(paramc)))
          {
            Log.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", new Object[] { str2 });
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
      paramc = (com.tencent.mm.av.a.a.c)localObject;
      if (((String)localObject).length() != 0) {}
    }
    else
    {
      paramc = this.jbF.OX(paramString);
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
    this.jbF = paramg;
  }
  
  /* Error */
  public final boolean a(String paramString, byte[] paramArrayOfByte, com.tencent.mm.av.a.a.c paramc)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: getfield 123	com/tencent/mm/av/a/a/c:jbw	Lcom/tencent/mm/modelsfs/SFSContext;
    //   9: astore 11
    //   11: aload 11
    //   13: ifnull +371 -> 384
    //   16: aload_0
    //   17: aload_1
    //   18: aload_3
    //   19: invokespecial 125	com/tencent/mm/av/a/b/a:b	(Ljava/lang/String;Lcom/tencent/mm/av/a/a/c;)Ljava/lang/String;
    //   22: astore 7
    //   24: aload 7
    //   26: ifnonnull +10 -> 36
    //   29: ldc 119
    //   31: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_0
    //   35: ireturn
    //   36: aconst_null
    //   37: astore 10
    //   39: aload 10
    //   41: astore 8
    //   43: aload 11
    //   45: getfield 131	com/tencent/mm/modelsfs/SFSContext:mNativePtr	J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifne +50 -> 100
    //   53: aload 10
    //   55: astore 8
    //   57: new 96	java/lang/IllegalArgumentException
    //   60: dup
    //   61: ldc 133
    //   63: invokespecial 108	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   66: astore_1
    //   67: aload 10
    //   69: astore 8
    //   71: ldc 119
    //   73: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload 10
    //   78: astore 8
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 138	java/io/OutputStream:close	()V
    //   93: ldc 119
    //   95: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload 10
    //   102: astore 8
    //   104: aload 7
    //   106: invokestatic 143	com/tencent/mm/modelsfs/e:Pv	(Ljava/lang/String;)Z
    //   109: ifeq +409 -> 518
    //   112: aload 10
    //   114: astore 8
    //   116: aload 7
    //   118: ldc 145
    //   120: invokevirtual 149	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   123: istore 4
    //   125: iload 4
    //   127: ifle +93 -> 220
    //   130: aload 10
    //   132: astore 8
    //   134: aload 7
    //   136: iload 4
    //   138: bipush 6
    //   140: iadd
    //   141: invokevirtual 112	java/lang/String:substring	(I)Ljava/lang/String;
    //   144: invokevirtual 152	java/lang/String:trim	()Ljava/lang/String;
    //   147: astore_3
    //   148: aload 10
    //   150: astore 8
    //   152: aload 7
    //   154: invokestatic 155	com/tencent/mm/modelsfs/e:Pw	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 9
    //   159: aload 10
    //   161: astore 8
    //   163: aload 11
    //   165: getfield 131	com/tencent/mm/modelsfs/SFSContext:mNativePtr	J
    //   168: lconst_0
    //   169: lcmp
    //   170: ifne +56 -> 226
    //   173: aload 10
    //   175: astore 8
    //   177: new 96	java/lang/IllegalArgumentException
    //   180: dup
    //   181: ldc 133
    //   183: invokespecial 108	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   186: astore_1
    //   187: aload 10
    //   189: astore 8
    //   191: ldc 119
    //   193: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload 10
    //   198: astore 8
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: aload 8
    //   205: ifnull +8 -> 213
    //   208: aload 8
    //   210: invokevirtual 138	java/io/OutputStream:close	()V
    //   213: ldc 119
    //   215: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_1
    //   219: athrow
    //   220: ldc 157
    //   222: astore_3
    //   223: goto -75 -> 148
    //   226: aload 10
    //   228: astore 8
    //   230: aload 11
    //   232: getfield 131	com/tencent/mm/modelsfs/SFSContext:mNativePtr	J
    //   235: aload 9
    //   237: invokestatic 161	com/tencent/mm/modelsfs/SFSContext:nativeOpenWrite	(JLjava/lang/String;)J
    //   240: lstore 5
    //   242: lload 5
    //   244: lconst_0
    //   245: lcmp
    //   246: ifne +56 -> 302
    //   249: aload 10
    //   251: astore 8
    //   253: new 116	java/io/IOException
    //   256: dup
    //   257: new 39	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   264: aload 9
    //   266: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 163
    //   271: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokestatic 166	com/tencent/mm/modelsfs/SFSContext:nativeErrorMessage	()Ljava/lang/String;
    //   277: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokespecial 167	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   286: astore_1
    //   287: aload 10
    //   289: astore 8
    //   291: ldc 119
    //   293: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aload 10
    //   298: astore 8
    //   300: aload_1
    //   301: athrow
    //   302: aload 10
    //   304: astore 8
    //   306: aload_3
    //   307: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   310: ifne +57 -> 367
    //   313: aload 10
    //   315: astore 8
    //   317: new 175	com/tencent/mm/modelsfs/d
    //   320: dup
    //   321: lload 5
    //   323: aload_3
    //   324: invokespecial 178	com/tencent/mm/modelsfs/d:<init>	(JLjava/lang/String;)V
    //   327: astore_3
    //   328: aload_3
    //   329: astore 8
    //   331: aload_3
    //   332: aload_2
    //   333: invokevirtual 182	java/io/OutputStream:write	([B)V
    //   336: aload_3
    //   337: invokevirtual 138	java/io/OutputStream:close	()V
    //   340: ldc 184
    //   342: ldc 186
    //   344: iconst_2
    //   345: anewarray 4	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload_1
    //   351: aastore
    //   352: dup
    //   353: iconst_1
    //   354: aload 7
    //   356: aastore
    //   357: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: ldc 119
    //   362: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: iconst_1
    //   366: ireturn
    //   367: aload 10
    //   369: astore 8
    //   371: new 190	com/tencent/mm/modelsfs/SFSOutputStream
    //   374: dup
    //   375: lload 5
    //   377: invokespecial 193	com/tencent/mm/modelsfs/SFSOutputStream:<init>	(J)V
    //   380: astore_3
    //   381: goto -53 -> 328
    //   384: aload_0
    //   385: aload_1
    //   386: aload_3
    //   387: invokespecial 195	com/tencent/mm/av/a/b/a:a	(Ljava/lang/String;Lcom/tencent/mm/av/a/a/c;)Ljava/lang/String;
    //   390: astore_3
    //   391: aload_3
    //   392: ifnonnull +10 -> 402
    //   395: ldc 119
    //   397: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: iconst_0
    //   401: ireturn
    //   402: new 197	com/tencent/mm/vfs/o
    //   405: dup
    //   406: aload_3
    //   407: invokespecial 198	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   410: invokevirtual 202	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   413: astore 7
    //   415: aload 7
    //   417: ifnull +17 -> 434
    //   420: aload 7
    //   422: invokevirtual 206	com/tencent/mm/vfs/o:exists	()Z
    //   425: ifne +9 -> 434
    //   428: aload 7
    //   430: invokevirtual 209	com/tencent/mm/vfs/o:mkdirs	()Z
    //   433: pop
    //   434: new 197	com/tencent/mm/vfs/o
    //   437: dup
    //   438: aload_3
    //   439: invokespecial 198	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   442: astore 7
    //   444: aload 7
    //   446: invokevirtual 206	com/tencent/mm/vfs/o:exists	()Z
    //   449: ifne +9 -> 458
    //   452: aload 7
    //   454: invokevirtual 212	com/tencent/mm/vfs/o:createNewFile	()Z
    //   457: pop
    //   458: aload_3
    //   459: astore 7
    //   461: aload_2
    //   462: ifnull -122 -> 340
    //   465: aload_3
    //   466: astore 7
    //   468: aload_3
    //   469: aload_2
    //   470: aload_2
    //   471: arraylength
    //   472: invokestatic 218	com/tencent/mm/vfs/s:f	(Ljava/lang/String;[BI)I
    //   475: ifge -135 -> 340
    //   478: ldc 119
    //   480: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   483: iconst_0
    //   484: ireturn
    //   485: astore 7
    //   487: ldc 86
    //   489: aload 7
    //   491: invokestatic 222	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   494: invokestatic 225	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -39 -> 458
    //   500: astore_2
    //   501: goto -161 -> 340
    //   504: astore_1
    //   505: goto -412 -> 93
    //   508: astore_2
    //   509: goto -296 -> 213
    //   512: astore_1
    //   513: aload_3
    //   514: astore_1
    //   515: goto -430 -> 85
    //   518: ldc 157
    //   520: astore_3
    //   521: aload 7
    //   523: astore 9
    //   525: goto -366 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	a
    //   0	528	1	paramString	String
    //   0	528	2	paramArrayOfByte	byte[]
    //   0	528	3	paramc	com.tencent.mm.av.a.a.c
    //   123	18	4	i	int
    //   240	136	5	l	long
    //   22	445	7	localObject1	Object
    //   485	37	7	localException	java.lang.Exception
    //   41	329	8	localObject2	Object
    //   157	367	9	localObject3	Object
    //   37	331	10	localObject4	Object
    //   9	222	11	localSFSContext	SFSContext
    // Exception table:
    //   from	to	target	type
    //   43	53	82	java/io/IOException
    //   57	67	82	java/io/IOException
    //   71	76	82	java/io/IOException
    //   80	82	82	java/io/IOException
    //   104	112	82	java/io/IOException
    //   116	125	82	java/io/IOException
    //   134	148	82	java/io/IOException
    //   152	159	82	java/io/IOException
    //   163	173	82	java/io/IOException
    //   177	187	82	java/io/IOException
    //   191	196	82	java/io/IOException
    //   200	202	82	java/io/IOException
    //   230	242	82	java/io/IOException
    //   253	287	82	java/io/IOException
    //   291	296	82	java/io/IOException
    //   300	302	82	java/io/IOException
    //   306	313	82	java/io/IOException
    //   317	328	82	java/io/IOException
    //   371	381	82	java/io/IOException
    //   43	53	202	finally
    //   57	67	202	finally
    //   71	76	202	finally
    //   80	82	202	finally
    //   104	112	202	finally
    //   116	125	202	finally
    //   134	148	202	finally
    //   152	159	202	finally
    //   163	173	202	finally
    //   177	187	202	finally
    //   191	196	202	finally
    //   200	202	202	finally
    //   230	242	202	finally
    //   253	287	202	finally
    //   291	296	202	finally
    //   300	302	202	finally
    //   306	313	202	finally
    //   317	328	202	finally
    //   331	336	202	finally
    //   371	381	202	finally
    //   452	458	485	java/lang/Exception
    //   336	340	500	java/io/IOException
    //   89	93	504	java/io/IOException
    //   208	213	508	java/io/IOException
    //   331	336	512	java/io/IOException
  }
  
  public final void bdw()
  {
    AppMethodBeat.i(130409);
    com.tencent.mm.av.a.g.b.bdB();
    AppMethodBeat.o(130409);
  }
  
  public final boolean c(String paramString, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130408);
    SFSContext localSFSContext = paramc.jbw;
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
      if (e.Pv(paramc))
      {
        e.Px(paramc);
        paramString = e.Pw(paramc);
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
    boolean bool = new o(paramString).delete();
    AppMethodBeat.o(130408);
    return bool;
  }
  
  public final InputStream d(String paramString, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130410);
    SFSContext localSFSContext;
    try
    {
      localSFSContext = paramc.jbw;
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
    if (e.Pv(paramString))
    {
      l1 = e.Px(paramString);
      paramString = e.Pw(paramString);
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
      paramString = s.openRead(paramString);
      AppMethodBeat.o(130410);
      return paramString;
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.a.b.a
 * JD-Core Version:    0.7.0.1
 */