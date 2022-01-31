package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public final class e
{
  private static e loE = null;
  c fjE = new e.1(this);
  public ArrayList<f> loF = null;
  
  public static e bbZ()
  {
    if (loE == null) {
      loE = new e();
    }
    return loE;
  }
  
  /* Error */
  public final boolean aA(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 37	java/lang/String
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 40	java/lang/String:<init>	([B)V
    //   8: astore_1
    //   9: aload_1
    //   10: ldc 42
    //   12: invokestatic 48	com/tencent/mm/sdk/platformtools/bn:s	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +418 -> 437
    //   22: new 50	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 51	java/util/ArrayList:<init>	()V
    //   29: astore 5
    //   31: iconst_0
    //   32: istore_2
    //   33: new 53	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   40: ldc 56
    //   42: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: astore 6
    //   47: iload_2
    //   48: ifne +295 -> 343
    //   51: ldc 62
    //   53: astore_1
    //   54: aload 6
    //   56: aload_1
    //   57: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_1
    //   64: aload 4
    //   66: new 53	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   73: aload_1
    //   74: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 71
    //   79: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokeinterface 77 2 0
    //   90: checkcast 37	java/lang/String
    //   93: astore 7
    //   95: aload 7
    //   97: ifnull +310 -> 407
    //   100: new 79	com/tencent/mm/plugin/ipcall/a/g/f
    //   103: dup
    //   104: invokespecial 80	com/tencent/mm/plugin/ipcall/a/g/f:<init>	()V
    //   107: astore 6
    //   109: aload 6
    //   111: aload 7
    //   113: putfield 84	com/tencent/mm/plugin/ipcall/a/g/f:lsM	Ljava/lang/String;
    //   116: aload 6
    //   118: new 50	java/util/ArrayList
    //   121: dup
    //   122: invokespecial 51	java/util/ArrayList:<init>	()V
    //   125: putfield 87	com/tencent/mm/plugin/ipcall/a/g/f:lsN	Ljava/util/ArrayList;
    //   128: new 53	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   135: aload_1
    //   136: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 89
    //   141: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: astore 7
    //   149: iconst_0
    //   150: istore_3
    //   151: new 91	com/tencent/mm/plugin/ipcall/a/g/e
    //   154: dup
    //   155: invokespecial 92	com/tencent/mm/plugin/ipcall/a/g/e:<init>	()V
    //   158: astore 8
    //   160: new 53	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   167: aload 7
    //   169: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: astore 9
    //   174: iload_3
    //   175: ifne +176 -> 351
    //   178: ldc 62
    //   180: astore_1
    //   181: aload 9
    //   183: aload_1
    //   184: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 9
    //   192: aload 4
    //   194: aload 9
    //   196: invokeinterface 77 2 0
    //   201: checkcast 37	java/lang/String
    //   204: astore_1
    //   205: aload_1
    //   206: ifnull +153 -> 359
    //   209: aload 4
    //   211: new 53	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   218: aload 9
    //   220: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc 94
    //   225: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokeinterface 77 2 0
    //   236: checkcast 37	java/lang/String
    //   239: astore 9
    //   241: aload 9
    //   243: ifnull +116 -> 359
    //   246: iload_3
    //   247: iconst_1
    //   248: iadd
    //   249: istore_3
    //   250: aload 8
    //   252: aload 9
    //   254: putfield 97	com/tencent/mm/plugin/ipcall/a/g/e:lsK	Ljava/lang/String;
    //   257: aload 8
    //   259: aload_1
    //   260: putfield 100	com/tencent/mm/plugin/ipcall/a/g/e:lsL	Ljava/lang/String;
    //   263: aload 6
    //   265: getfield 87	com/tencent/mm/plugin/ipcall/a/g/f:lsN	Ljava/util/ArrayList;
    //   268: aload 8
    //   270: invokevirtual 104	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   273: pop
    //   274: goto -123 -> 151
    //   277: astore_1
    //   278: ldc 106
    //   280: aload_1
    //   281: ldc 62
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 112	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: ldc 106
    //   292: ldc 114
    //   294: iconst_1
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_1
    //   301: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   304: aastore
    //   305: invokestatic 121	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: iconst_0
    //   309: ireturn
    //   310: astore_1
    //   311: ldc 106
    //   313: aload_1
    //   314: ldc 62
    //   316: iconst_0
    //   317: anewarray 4	java/lang/Object
    //   320: invokestatic 112	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: ldc 106
    //   325: ldc 123
    //   327: iconst_1
    //   328: anewarray 4	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: aload_1
    //   334: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   337: aastore
    //   338: invokestatic 121	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: iconst_0
    //   342: ireturn
    //   343: iload_2
    //   344: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: astore_1
    //   348: goto -294 -> 54
    //   351: iload_3
    //   352: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: astore_1
    //   356: goto -175 -> 181
    //   359: ldc 106
    //   361: ldc 131
    //   363: iconst_2
    //   364: anewarray 4	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: aload 6
    //   371: getfield 84	com/tencent/mm/plugin/ipcall/a/g/f:lsM	Ljava/lang/String;
    //   374: aastore
    //   375: dup
    //   376: iconst_1
    //   377: aload 6
    //   379: getfield 87	com/tencent/mm/plugin/ipcall/a/g/f:lsN	Ljava/util/ArrayList;
    //   382: invokevirtual 135	java/util/ArrayList:size	()I
    //   385: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: invokestatic 138	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   392: aload 5
    //   394: aload 6
    //   396: invokevirtual 104	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   399: pop
    //   400: iload_2
    //   401: iconst_1
    //   402: iadd
    //   403: istore_2
    //   404: goto -371 -> 33
    //   407: ldc 106
    //   409: ldc 140
    //   411: iconst_1
    //   412: anewarray 4	java/lang/Object
    //   415: dup
    //   416: iconst_0
    //   417: aload 5
    //   419: invokevirtual 135	java/util/ArrayList:size	()I
    //   422: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   425: aastore
    //   426: invokestatic 143	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: aload_0
    //   430: aload 5
    //   432: putfield 21	com/tencent/mm/plugin/ipcall/a/e:loF	Ljava/util/ArrayList;
    //   435: iconst_1
    //   436: ireturn
    //   437: ldc 106
    //   439: ldc 145
    //   441: invokestatic 148	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   444: iconst_0
    //   445: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	e
    //   0	446	1	paramArrayOfByte	byte[]
    //   32	372	2	i	int
    //   150	202	3	j	int
    //   15	195	4	localMap	java.util.Map
    //   29	402	5	localArrayList	ArrayList
    //   45	350	6	localObject1	Object
    //   93	75	7	str	java.lang.String
    //   158	111	8	locale	com.tencent.mm.plugin.ipcall.a.g.e
    //   172	81	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	277	java/lang/Exception
    //   22	31	277	java/lang/Exception
    //   33	47	277	java/lang/Exception
    //   54	95	277	java/lang/Exception
    //   100	149	277	java/lang/Exception
    //   151	174	277	java/lang/Exception
    //   181	205	277	java/lang/Exception
    //   209	241	277	java/lang/Exception
    //   250	274	277	java/lang/Exception
    //   343	348	277	java/lang/Exception
    //   351	356	277	java/lang/Exception
    //   359	400	277	java/lang/Exception
    //   407	435	277	java/lang/Exception
    //   437	444	277	java/lang/Exception
    //   0	9	310	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e
 * JD-Core Version:    0.7.0.1
 */