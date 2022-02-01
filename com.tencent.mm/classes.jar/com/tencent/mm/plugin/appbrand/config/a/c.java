package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsUtils;", "", "()V", "TAG", "", "collectBatchSyncVersionReqList", "", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c occ;
  
  static
  {
    AppMethodBeat.i(284028);
    occ = new c();
    AppMethodBeat.o(284028);
  }
  
  /* Error */
  public static final java.util.List<com.tencent.mm.protocal.protobuf.epy> bHZ()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 43
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 49	com/tencent/mm/plugin/appbrand/app/m:bFB	()Lcom/tencent/mm/platformtools/r$a;
    //   11: astore 6
    //   13: aload 6
    //   15: ifnonnull +17 -> 32
    //   18: getstatic 55	kotlin/a/v:aaAd	Lkotlin/a/v;
    //   21: checkcast 57	java/util/List
    //   24: astore_3
    //   25: ldc 43
    //   27: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_3
    //   31: areturn
    //   32: invokestatic 63	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   35: getstatic 69	java/util/concurrent/TimeUnit:DAYS	Ljava/util/concurrent/TimeUnit;
    //   38: ldc2_w 70
    //   41: invokevirtual 75	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   44: lsub
    //   45: lstore_1
    //   46: aload 6
    //   48: new 77	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 79
    //   54: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: lload_1
    //   58: invokevirtual 86	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: bipush 32
    //   63: invokevirtual 89	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   66: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: aconst_null
    //   70: iconst_2
    //   71: invokevirtual 99	com/tencent/mm/platformtools/r$a:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull +44 -> 120
    //   79: aload_3
    //   80: checkcast 101	java/io/Closeable
    //   83: astore 5
    //   85: aload 5
    //   87: checkcast 103	android/database/Cursor
    //   90: astore_3
    //   91: aload_3
    //   92: invokeinterface 107 1 0
    //   97: ifeq +90 -> 187
    //   100: getstatic 55	kotlin/a/v:aaAd	Lkotlin/a/v;
    //   103: checkcast 57	java/util/List
    //   106: astore_3
    //   107: aload 5
    //   109: aconst_null
    //   110: invokestatic 113	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   113: aload_3
    //   114: astore 4
    //   116: aload_3
    //   117: ifnonnull +11 -> 128
    //   120: getstatic 55	kotlin/a/v:aaAd	Lkotlin/a/v;
    //   123: checkcast 57	java/util/List
    //   126: astore 4
    //   128: aload 6
    //   130: ldc 115
    //   132: ldc 117
    //   134: iconst_1
    //   135: anewarray 119	java/lang/String
    //   138: dup
    //   139: iconst_0
    //   140: lload_1
    //   141: invokestatic 123	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   144: aastore
    //   145: invokevirtual 127	com/tencent/mm/platformtools/r$a:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   148: istore_0
    //   149: ldc 129
    //   151: new 77	java/lang/StringBuilder
    //   154: dup
    //   155: ldc 131
    //   157: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: lload_1
    //   161: invokevirtual 86	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: ldc 133
    //   166: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: iload_0
    //   170: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: ldc 43
    //   181: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload 4
    //   186: areturn
    //   187: new 146	java/util/LinkedList
    //   190: dup
    //   191: invokespecial 147	java/util/LinkedList:<init>	()V
    //   194: astore 7
    //   196: aload_3
    //   197: invokeinterface 150 1 0
    //   202: ifeq +70 -> 272
    //   205: new 152	com/tencent/mm/protocal/protobuf/epy
    //   208: dup
    //   209: invokespecial 153	com/tencent/mm/protocal/protobuf/epy:<init>	()V
    //   212: astore 8
    //   214: aload 8
    //   216: aload_3
    //   217: iconst_0
    //   218: invokeinterface 157 2 0
    //   223: putfield 161	com/tencent/mm/protocal/protobuf/epy:Txp	Ljava/lang/String;
    //   226: aload_3
    //   227: iconst_1
    //   228: invokeinterface 157 2 0
    //   233: invokestatic 167	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:afv	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   236: astore 9
    //   238: aload 9
    //   240: ifnull +41 -> 281
    //   243: aload 9
    //   245: getfield 171	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   248: istore_0
    //   249: aload 8
    //   251: iload_0
    //   252: putfield 174	com/tencent/mm/protocal/protobuf/epy:Usv	I
    //   255: aload 7
    //   257: aload 8
    //   259: invokevirtual 178	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   262: pop
    //   263: aload_3
    //   264: invokeinterface 181 1 0
    //   269: ifne -64 -> 205
    //   272: aload 7
    //   274: checkcast 57	java/util/List
    //   277: astore_3
    //   278: goto -171 -> 107
    //   281: iconst_0
    //   282: istore_0
    //   283: goto -34 -> 249
    //   286: astore 4
    //   288: ldc 43
    //   290: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload 4
    //   295: athrow
    //   296: astore_3
    //   297: aload 5
    //   299: aload 4
    //   301: invokestatic 113	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   304: ldc 43
    //   306: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_3
    //   310: athrow
    //   311: astore_3
    //   312: goto -15 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   148	135	0	i	int
    //   45	116	1	l	long
    //   24	254	3	localObject1	Object
    //   296	14	3	localObject2	Object
    //   311	1	3	localObject3	Object
    //   1	184	4	localObject4	Object
    //   286	14	4	localThrowable	java.lang.Throwable
    //   83	215	5	localCloseable	java.io.Closeable
    //   11	118	6	locala	com.tencent.mm.platformtools.r.a
    //   194	79	7	localLinkedList	java.util.LinkedList
    //   212	46	8	localepy	com.tencent.mm.protocal.protobuf.epy
    //   236	8	9	localWxaVersionInfo	com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo
    // Exception table:
    //   from	to	target	type
    //   85	107	286	java/lang/Throwable
    //   187	205	286	java/lang/Throwable
    //   205	238	286	java/lang/Throwable
    //   243	249	286	java/lang/Throwable
    //   249	272	286	java/lang/Throwable
    //   272	278	286	java/lang/Throwable
    //   288	296	296	finally
    //   85	107	311	finally
    //   187	205	311	finally
    //   205	238	311	finally
    //   243	249	311	finally
    //   249	272	311	finally
    //   272	278	311	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.c
 * JD-Core Version:    0.7.0.1
 */