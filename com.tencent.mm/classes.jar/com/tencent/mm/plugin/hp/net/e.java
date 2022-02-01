package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgt;

public final class e
{
  /* Error */
  public static java.util.LinkedList<cgt> dcs()
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
    //   16: invokestatic 29	com/tencent/mm/kernel/a:aiN	()I
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
    //   41: invokestatic 47	com/tencent/mm/sdk/platformtools/bt:aRp	(Ljava/lang/String;)Ljava/lang/String;
    //   44: aastore
    //   45: invokestatic 52	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: lload_3
    //   49: lstore_1
    //   50: aload 6
    //   52: ldc 54
    //   54: getstatic 60	com/tencent/mm/sdk/platformtools/i:hgG	Ljava/lang/String;
    //   57: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   60: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   63: pop
    //   64: aload 6
    //   66: ldc 70
    //   68: getstatic 73	com/tencent/mm/sdk/platformtools/i:REV	Ljava/lang/String;
    //   71: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   74: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 6
    //   80: ldc 75
    //   82: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   85: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   88: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   91: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: aload 6
    //   97: ldc 86
    //   99: getstatic 91	com/tencent/mm/protocal/d:Fng	Ljava/lang/String;
    //   102: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   105: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   108: pop
    //   109: aload 6
    //   111: ldc 93
    //   113: getstatic 96	com/tencent/mm/protocal/d:Fnd	Ljava/lang/String;
    //   116: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   119: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload 6
    //   125: ldc 98
    //   127: getstatic 101	com/tencent/mm/protocal/d:DEVICE_NAME	Ljava/lang/String;
    //   130: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   133: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   136: pop
    //   137: getstatic 107	android/os/Build:SUPPORTED_64_BIT_ABIS	[Ljava/lang/String;
    //   140: arraylength
    //   141: ifle +213 -> 354
    //   144: ldc 109
    //   146: astore 5
    //   148: aload 6
    //   150: ldc 111
    //   152: aload 5
    //   154: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   157: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: invokestatic 117	com/tencent/mm/compatible/deviceinfo/q:is64BitRuntime	()Z
    //   164: ifeq +197 -> 361
    //   167: ldc 109
    //   169: astore 5
    //   171: aload 6
    //   173: ldc 119
    //   175: aload 5
    //   177: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   180: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   183: pop
    //   184: aload 6
    //   186: ldc 121
    //   188: lload_1
    //   189: invokestatic 41	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   192: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   195: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   198: pop
    //   199: invokestatic 127	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   202: invokestatic 133	com/tencent/mm/sdk/platformtools/ay:isWifi	(Landroid/content/Context;)Z
    //   205: ifeq +163 -> 368
    //   208: iconst_3
    //   209: istore_0
    //   210: aload 6
    //   212: ldc 135
    //   214: iload_0
    //   215: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   218: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   221: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: ldc 137
    //   227: invokestatic 143	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   230: checkcast 137	com/tencent/mm/plugin/boots/a/c
    //   233: astore 5
    //   235: aload 5
    //   237: ifnull +91 -> 328
    //   240: aload 5
    //   242: invokeinterface 147 1 0
    //   247: astore 5
    //   249: aload 5
    //   251: ifnull +77 -> 328
    //   254: aload 5
    //   256: invokeinterface 153 1 0
    //   261: astore 5
    //   263: aload 5
    //   265: invokeinterface 158 1 0
    //   270: ifeq +58 -> 328
    //   273: aload 5
    //   275: invokeinterface 162 1 0
    //   280: checkcast 164	com/tencent/mm/plugin/boots/a/a
    //   283: astore 7
    //   285: aload 6
    //   287: aload 7
    //   289: getfield 167	com/tencent/mm/plugin/boots/a/a:field_key	I
    //   292: invokestatic 172	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   295: aload 7
    //   297: getfield 175	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   300: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   303: invokestatic 64	com/tencent/mm/plugin/hp/net/e:hs	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cgt;
    //   306: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   309: pop
    //   310: goto -47 -> 263
    //   313: astore 5
    //   315: ldc 33
    //   317: aload 5
    //   319: ldc 177
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: ldc 11
    //   330: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: aload 6
    //   335: areturn
    //   336: astore 5
    //   338: ldc 33
    //   340: aload 5
    //   342: ldc 186
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: goto -301 -> 50
    //   354: ldc 188
    //   356: astore 5
    //   358: goto -210 -> 148
    //   361: ldc 188
    //   363: astore 5
    //   365: goto -194 -> 171
    //   368: iconst_2
    //   369: istore_0
    //   370: goto -160 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   209	161	0	i	int
    //   15	174	1	l1	long
    //   24	25	3	l2	long
    //   146	128	5	localObject	Object
    //   313	5	5	localThrowable	java.lang.Throwable
    //   336	5	5	localException	java.lang.Exception
    //   356	8	5	str	String
    //   12	322	6	localLinkedList	java.util.LinkedList
    //   283	13	7	locala	com.tencent.mm.plugin.boots.a.a
    // Exception table:
    //   from	to	target	type
    //   225	235	313	java/lang/Throwable
    //   240	249	313	java/lang/Throwable
    //   254	263	313	java/lang/Throwable
    //   263	310	313	java/lang/Throwable
    //   16	25	336	java/lang/Exception
    //   27	48	336	java/lang/Exception
  }
  
  private static cgt hs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218907);
    cgt localcgt = new cgt();
    localcgt.key = paramString1;
    localcgt.value = paramString2;
    AppMethodBeat.o(218907);
    return localcgt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.e
 * JD-Core Version:    0.7.0.1
 */