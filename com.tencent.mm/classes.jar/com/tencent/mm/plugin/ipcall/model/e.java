package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.plugin.ipcall.model.h.f;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public final class e
{
  private static e uKp = null;
  c jhE;
  public ArrayList<f> uKq;
  
  private e()
  {
    AppMethodBeat.i(25356);
    this.uKq = null;
    this.jhE = new c() {};
    AppMethodBeat.o(25356);
  }
  
  public static e ddy()
  {
    AppMethodBeat.i(25357);
    if (uKp == null) {
      uKp = new e();
    }
    e locale = uKp;
    AppMethodBeat.o(25357);
    return locale;
  }
  
  /* Error */
  public final boolean bq(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 25358
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 46	java/lang/String
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 49	java/lang/String:<init>	([B)V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc 51
    //   18: invokestatic 57	com/tencent/mm/sdk/platformtools/bw:M	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +436 -> 461
    //   28: new 59	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 60	java/util/ArrayList:<init>	()V
    //   35: astore 5
    //   37: iconst_0
    //   38: istore_2
    //   39: new 62	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   46: ldc 65
    //   48: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: astore 6
    //   53: iload_2
    //   54: ifne +307 -> 361
    //   57: ldc 71
    //   59: astore_1
    //   60: aload 6
    //   62: aload_1
    //   63: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_1
    //   70: aload 4
    //   72: new 62	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 80
    //   85: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokeinterface 86 2 0
    //   96: checkcast 46	java/lang/String
    //   99: astore 7
    //   101: aload 7
    //   103: ifnull +322 -> 425
    //   106: new 88	com/tencent/mm/plugin/ipcall/model/h/f
    //   109: dup
    //   110: invokespecial 89	com/tencent/mm/plugin/ipcall/model/h/f:<init>	()V
    //   113: astore 6
    //   115: aload 6
    //   117: aload 7
    //   119: putfield 93	com/tencent/mm/plugin/ipcall/model/h/f:uOu	Ljava/lang/String;
    //   122: aload 6
    //   124: new 59	java/util/ArrayList
    //   127: dup
    //   128: invokespecial 60	java/util/ArrayList:<init>	()V
    //   131: putfield 96	com/tencent/mm/plugin/ipcall/model/h/f:uOv	Ljava/util/ArrayList;
    //   134: new 62	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   141: aload_1
    //   142: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 98
    //   147: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore 7
    //   155: iconst_0
    //   156: istore_3
    //   157: new 100	com/tencent/mm/plugin/ipcall/model/h/e
    //   160: dup
    //   161: invokespecial 101	com/tencent/mm/plugin/ipcall/model/h/e:<init>	()V
    //   164: astore 8
    //   166: new 62	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   173: aload 7
    //   175: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: astore 9
    //   180: iload_3
    //   181: ifne +188 -> 369
    //   184: ldc 71
    //   186: astore_1
    //   187: aload 9
    //   189: aload_1
    //   190: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: astore 9
    //   198: aload 4
    //   200: aload 9
    //   202: invokeinterface 86 2 0
    //   207: checkcast 46	java/lang/String
    //   210: astore_1
    //   211: aload_1
    //   212: ifnull +165 -> 377
    //   215: aload 4
    //   217: new 62	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   224: aload 9
    //   226: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 103
    //   231: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokeinterface 86 2 0
    //   242: checkcast 46	java/lang/String
    //   245: astore 9
    //   247: aload 9
    //   249: ifnull +128 -> 377
    //   252: iload_3
    //   253: iconst_1
    //   254: iadd
    //   255: istore_3
    //   256: aload 8
    //   258: aload 9
    //   260: putfield 106	com/tencent/mm/plugin/ipcall/model/h/e:Id	Ljava/lang/String;
    //   263: aload 8
    //   265: aload_1
    //   266: putfield 109	com/tencent/mm/plugin/ipcall/model/h/e:uOt	Ljava/lang/String;
    //   269: aload 6
    //   271: getfield 96	com/tencent/mm/plugin/ipcall/model/h/f:uOv	Ljava/util/ArrayList;
    //   274: aload 8
    //   276: invokevirtual 113	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   279: pop
    //   280: goto -123 -> 157
    //   283: astore_1
    //   284: ldc 115
    //   286: aload_1
    //   287: ldc 71
    //   289: iconst_0
    //   290: anewarray 4	java/lang/Object
    //   293: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: ldc 115
    //   298: ldc 123
    //   300: iconst_1
    //   301: anewarray 4	java/lang/Object
    //   304: dup
    //   305: iconst_0
    //   306: aload_1
    //   307: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   310: aastore
    //   311: invokestatic 130	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: sipush 25358
    //   317: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: iconst_0
    //   321: ireturn
    //   322: astore_1
    //   323: ldc 115
    //   325: aload_1
    //   326: ldc 71
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: ldc 115
    //   337: ldc 132
    //   339: iconst_1
    //   340: anewarray 4	java/lang/Object
    //   343: dup
    //   344: iconst_0
    //   345: aload_1
    //   346: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   349: aastore
    //   350: invokestatic 130	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: sipush 25358
    //   356: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: iconst_0
    //   360: ireturn
    //   361: iload_2
    //   362: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: astore_1
    //   366: goto -306 -> 60
    //   369: iload_3
    //   370: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: astore_1
    //   374: goto -187 -> 187
    //   377: ldc 115
    //   379: ldc 140
    //   381: iconst_2
    //   382: anewarray 4	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload 6
    //   389: getfield 93	com/tencent/mm/plugin/ipcall/model/h/f:uOu	Ljava/lang/String;
    //   392: aastore
    //   393: dup
    //   394: iconst_1
    //   395: aload 6
    //   397: getfield 96	com/tencent/mm/plugin/ipcall/model/h/f:uOv	Ljava/util/ArrayList;
    //   400: invokevirtual 144	java/util/ArrayList:size	()I
    //   403: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: aastore
    //   407: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: aload 5
    //   412: aload 6
    //   414: invokevirtual 113	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   417: pop
    //   418: iload_2
    //   419: iconst_1
    //   420: iadd
    //   421: istore_2
    //   422: goto -383 -> 39
    //   425: ldc 115
    //   427: ldc 149
    //   429: iconst_1
    //   430: anewarray 4	java/lang/Object
    //   433: dup
    //   434: iconst_0
    //   435: aload 5
    //   437: invokevirtual 144	java/util/ArrayList:size	()I
    //   440: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   443: aastore
    //   444: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: aload_0
    //   448: aload 5
    //   450: putfield 29	com/tencent/mm/plugin/ipcall/model/e:uKq	Ljava/util/ArrayList;
    //   453: sipush 25358
    //   456: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: iconst_1
    //   460: ireturn
    //   461: ldc 115
    //   463: ldc 153
    //   465: invokestatic 156	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: sipush 25358
    //   471: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: iconst_0
    //   475: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	e
    //   0	476	1	paramArrayOfByte	byte[]
    //   38	384	2	i	int
    //   156	214	3	j	int
    //   21	195	4	localMap	java.util.Map
    //   35	414	5	localArrayList	ArrayList
    //   51	362	6	localObject1	Object
    //   99	75	7	str	String
    //   164	111	8	locale	com.tencent.mm.plugin.ipcall.model.h.e
    //   178	81	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	23	283	java/lang/Exception
    //   28	37	283	java/lang/Exception
    //   39	53	283	java/lang/Exception
    //   60	101	283	java/lang/Exception
    //   106	155	283	java/lang/Exception
    //   157	180	283	java/lang/Exception
    //   187	211	283	java/lang/Exception
    //   215	247	283	java/lang/Exception
    //   256	280	283	java/lang/Exception
    //   361	366	283	java/lang/Exception
    //   369	374	283	java/lang/Exception
    //   377	418	283	java/lang/Exception
    //   425	453	283	java/lang/Exception
    //   461	468	283	java/lang/Exception
    //   6	15	322	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e
 * JD-Core Version:    0.7.0.1
 */