package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzo;

public final class e
{
  /* Error */
  public static java.util.LinkedList<dzo> fPU()
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 17	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 21	java/util/LinkedList:<init>	()V
    //   12: astore 6
    //   14: lconst_0
    //   15: lstore_1
    //   16: invokestatic 27	com/tencent/mm/kernel/b:aZP	()I
    //   19: i2l
    //   20: ldc2_w 28
    //   23: land
    //   24: lstore_3
    //   25: lload_3
    //   26: lstore_1
    //   27: ldc 31
    //   29: ldc 33
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: lload_3
    //   38: invokestatic 39	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   41: invokestatic 45	com/tencent/mm/sdk/platformtools/Util:secPrint	(Ljava/lang/String;)Ljava/lang/String;
    //   44: aastore
    //   45: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: lload_3
    //   49: lstore_1
    //   50: aload 6
    //   52: ldc 52
    //   54: getstatic 58	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   57: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   60: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   63: pop
    //   64: aload 6
    //   66: ldc 68
    //   68: getstatic 71	com/tencent/mm/sdk/platformtools/BuildInfo:REV	Ljava/lang/String;
    //   71: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   74: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 6
    //   80: ldc 73
    //   82: getstatic 79	android/os/Build$VERSION:SDK_INT	I
    //   85: invokestatic 82	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   88: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   91: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: aload 6
    //   97: ldc 84
    //   99: getstatic 89	com/tencent/mm/protocal/d:Yxd	Ljava/lang/String;
    //   102: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   105: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   108: pop
    //   109: aload 6
    //   111: ldc 91
    //   113: getstatic 94	com/tencent/mm/protocal/d:Yxa	Ljava/lang/String;
    //   116: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   119: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload 6
    //   125: ldc 96
    //   127: getstatic 99	com/tencent/mm/protocal/d:Yxf	Ljava/lang/String;
    //   130: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   133: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   136: pop
    //   137: getstatic 105	android/os/Build:SUPPORTED_64_BIT_ABIS	[Ljava/lang/String;
    //   140: arraylength
    //   141: ifle +258 -> 399
    //   144: ldc 107
    //   146: astore 5
    //   148: aload 6
    //   150: ldc 109
    //   152: aload 5
    //   154: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   157: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: invokestatic 115	com/tencent/mm/compatible/deviceinfo/q:awm	()Z
    //   164: ifeq +242 -> 406
    //   167: ldc 107
    //   169: astore 5
    //   171: aload 6
    //   173: ldc 117
    //   175: aload 5
    //   177: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   180: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   183: pop
    //   184: aload 6
    //   186: ldc 119
    //   188: lload_1
    //   189: invokestatic 39	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   192: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   195: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   198: pop
    //   199: aload 6
    //   201: ldc 121
    //   203: ldc 123
    //   205: invokestatic 129	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   208: checkcast 123	com/tencent/mm/plugin/expt/b/c
    //   211: getstatic 135	com/tencent/mm/plugin/expt/b/c$a:yPx	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   214: iconst_0
    //   215: invokeinterface 139 3 0
    //   220: invokestatic 82	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   223: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   226: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: invokestatic 145	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   233: invokestatic 151	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   236: ifeq +177 -> 413
    //   239: iconst_3
    //   240: istore_0
    //   241: aload 6
    //   243: ldc 153
    //   245: iload_0
    //   246: invokestatic 82	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   249: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   252: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: aload 6
    //   258: ldc 155
    //   260: getstatic 158	com/tencent/mm/protocal/d:Yxb	Ljava/lang/String;
    //   263: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   266: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   269: pop
    //   270: ldc 160
    //   272: invokestatic 129	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   275: checkcast 160	com/tencent/mm/plugin/boots/a/c
    //   278: astore 5
    //   280: aload 5
    //   282: ifnull +91 -> 373
    //   285: aload 5
    //   287: invokeinterface 164 1 0
    //   292: astore 5
    //   294: aload 5
    //   296: ifnull +77 -> 373
    //   299: aload 5
    //   301: invokeinterface 170 1 0
    //   306: astore 5
    //   308: aload 5
    //   310: invokeinterface 175 1 0
    //   315: ifeq +58 -> 373
    //   318: aload 5
    //   320: invokeinterface 179 1 0
    //   325: checkcast 181	com/tencent/mm/plugin/boots/a/a
    //   328: astore 7
    //   330: aload 6
    //   332: aload 7
    //   334: getfield 184	com/tencent/mm/plugin/boots/a/a:field_key	I
    //   337: invokestatic 189	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   340: aload 7
    //   342: getfield 192	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   345: invokestatic 82	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   348: invokestatic 62	com/tencent/mm/plugin/hp/net/e:jE	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dzo;
    //   351: invokevirtual 66	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   354: pop
    //   355: goto -47 -> 308
    //   358: astore 5
    //   360: ldc 31
    //   362: aload 5
    //   364: ldc 194
    //   366: iconst_0
    //   367: anewarray 4	java/lang/Object
    //   370: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: ldc 9
    //   375: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload 6
    //   380: areturn
    //   381: astore 5
    //   383: ldc 31
    //   385: aload 5
    //   387: ldc 203
    //   389: iconst_0
    //   390: anewarray 4	java/lang/Object
    //   393: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: goto -346 -> 50
    //   399: ldc 205
    //   401: astore 5
    //   403: goto -255 -> 148
    //   406: ldc 205
    //   408: astore 5
    //   410: goto -239 -> 171
    //   413: iconst_2
    //   414: istore_0
    //   415: goto -174 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   240	175	0	i	int
    //   15	174	1	l1	long
    //   24	25	3	l2	long
    //   146	173	5	localObject	Object
    //   358	5	5	localThrowable	java.lang.Throwable
    //   381	5	5	localException	java.lang.Exception
    //   401	8	5	str	String
    //   12	367	6	localLinkedList	java.util.LinkedList
    //   328	13	7	locala	com.tencent.mm.plugin.boots.a.a
    // Exception table:
    //   from	to	target	type
    //   50	144	358	finally
    //   148	167	358	finally
    //   171	239	358	finally
    //   241	280	358	finally
    //   285	294	358	finally
    //   299	308	358	finally
    //   308	355	358	finally
    //   16	25	381	java/lang/Exception
    //   27	48	381	java/lang/Exception
  }
  
  public static dzo jE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261834);
    dzo localdzo = new dzo();
    localdzo.key = paramString1;
    localdzo.value = paramString2;
    AppMethodBeat.o(261834);
    return localdzo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.e
 * JD-Core Version:    0.7.0.1
 */