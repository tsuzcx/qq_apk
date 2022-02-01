package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhf;

public final class e
{
  /* Error */
  public static java.util.LinkedList<dhf> eIb()
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 19	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 23	java/util/LinkedList:<init>	()V
    //   12: astore 6
    //   14: lconst_0
    //   15: lstore_1
    //   16: invokestatic 29	com/tencent/mm/kernel/b:aGP	()I
    //   19: i2l
    //   20: ldc2_w 30
    //   23: land
    //   24: lstore_3
    //   25: lload_3
    //   26: lstore_1
    //   27: ldc 33
    //   29: ldc 35
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: lload_3
    //   38: invokestatic 41	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   41: invokestatic 47	com/tencent/mm/sdk/platformtools/Util:secPrint	(Ljava/lang/String;)Ljava/lang/String;
    //   44: aastore
    //   45: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: lload_3
    //   49: lstore_1
    //   50: aload 6
    //   52: ldc 54
    //   54: getstatic 60	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   57: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   60: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   63: pop
    //   64: aload 6
    //   66: ldc 70
    //   68: getstatic 73	com/tencent/mm/sdk/platformtools/BuildInfo:REV	Ljava/lang/String;
    //   71: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   74: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 6
    //   80: ldc 75
    //   82: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   85: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   88: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   91: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: aload 6
    //   97: ldc 86
    //   99: getstatic 91	com/tencent/mm/protocal/d:RAz	Ljava/lang/String;
    //   102: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   105: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   108: pop
    //   109: aload 6
    //   111: ldc 93
    //   113: getstatic 96	com/tencent/mm/protocal/d:RAw	Ljava/lang/String;
    //   116: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   119: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload 6
    //   125: ldc 98
    //   127: getstatic 101	com/tencent/mm/protocal/d:RAB	Ljava/lang/String;
    //   130: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   133: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   136: pop
    //   137: getstatic 107	android/os/Build:SUPPORTED_64_BIT_ABIS	[Ljava/lang/String;
    //   140: arraylength
    //   141: ifle +258 -> 399
    //   144: ldc 109
    //   146: astore 5
    //   148: aload 6
    //   150: ldc 111
    //   152: aload 5
    //   154: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   157: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: invokestatic 117	com/tencent/mm/compatible/deviceinfo/q:is64BitRuntime	()Z
    //   164: ifeq +242 -> 406
    //   167: ldc 109
    //   169: astore 5
    //   171: aload 6
    //   173: ldc 119
    //   175: aload 5
    //   177: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   180: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   183: pop
    //   184: aload 6
    //   186: ldc 121
    //   188: lload_1
    //   189: invokestatic 41	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   192: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   195: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   198: pop
    //   199: aload 6
    //   201: ldc 123
    //   203: ldc 125
    //   205: invokestatic 131	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   208: checkcast 125	com/tencent/mm/plugin/expt/b/b
    //   211: getstatic 137	com/tencent/mm/plugin/expt/b/b$a:vBw	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   214: iconst_0
    //   215: invokeinterface 141 3 0
    //   220: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   223: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   226: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: invokestatic 147	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   233: invokestatic 153	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   236: ifeq +177 -> 413
    //   239: iconst_3
    //   240: istore_0
    //   241: aload 6
    //   243: ldc 155
    //   245: iload_0
    //   246: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   249: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   252: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: aload 6
    //   258: ldc 157
    //   260: getstatic 160	com/tencent/mm/protocal/d:RAx	Ljava/lang/String;
    //   263: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   266: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   269: pop
    //   270: ldc 162
    //   272: invokestatic 131	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   275: checkcast 162	com/tencent/mm/plugin/boots/a/c
    //   278: astore 5
    //   280: aload 5
    //   282: ifnull +91 -> 373
    //   285: aload 5
    //   287: invokeinterface 166 1 0
    //   292: astore 5
    //   294: aload 5
    //   296: ifnull +77 -> 373
    //   299: aload 5
    //   301: invokeinterface 172 1 0
    //   306: astore 5
    //   308: aload 5
    //   310: invokeinterface 177 1 0
    //   315: ifeq +58 -> 373
    //   318: aload 5
    //   320: invokeinterface 181 1 0
    //   325: checkcast 183	com/tencent/mm/plugin/boots/a/a
    //   328: astore 7
    //   330: aload 6
    //   332: aload 7
    //   334: getfield 186	com/tencent/mm/plugin/boots/a/a:field_key	I
    //   337: invokestatic 191	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   340: aload 7
    //   342: getfield 194	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   345: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   348: invokestatic 64	com/tencent/mm/plugin/hp/net/e:iu	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dhf;
    //   351: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   354: pop
    //   355: goto -47 -> 308
    //   358: astore 5
    //   360: ldc 33
    //   362: aload 5
    //   364: ldc 196
    //   366: iconst_0
    //   367: anewarray 4	java/lang/Object
    //   370: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: ldc 11
    //   375: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload 6
    //   380: areturn
    //   381: astore 5
    //   383: ldc 33
    //   385: aload 5
    //   387: ldc 205
    //   389: iconst_0
    //   390: anewarray 4	java/lang/Object
    //   393: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: goto -346 -> 50
    //   399: ldc 207
    //   401: astore 5
    //   403: goto -255 -> 148
    //   406: ldc 207
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
    //   50	144	358	java/lang/Throwable
    //   148	167	358	java/lang/Throwable
    //   171	239	358	java/lang/Throwable
    //   241	280	358	java/lang/Throwable
    //   285	294	358	java/lang/Throwable
    //   299	308	358	java/lang/Throwable
    //   308	355	358	java/lang/Throwable
    //   16	25	381	java/lang/Exception
    //   27	48	381	java/lang/Exception
  }
  
  public static dhf iu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195797);
    dhf localdhf = new dhf();
    localdhf.key = paramString1;
    localdhf.value = paramString2;
    AppMethodBeat.o(195797);
    return localdhf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.e
 * JD-Core Version:    0.7.0.1
 */