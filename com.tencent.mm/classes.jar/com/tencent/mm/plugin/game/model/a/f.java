package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  static void P(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41685);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41685);
      return;
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramString);
    if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.id > 0L))
    {
      long l = localFileDownloadTaskInfo.id;
      String str = localFileDownloadTaskInfo.url;
      if (localFileDownloadTaskInfo.oJj == 0L) {}
      for (int i = 0;; i = (int)(localFileDownloadTaskInfo.qJe * 100L / localFileDownloadTaskInfo.oJj))
      {
        a(paramString, l, str, i, paramInt1, paramInt2, false, false, false, false, false);
        AppMethodBeat.o(41685);
        return;
      }
    }
    a(paramString, 0L, "", 0, paramInt1, paramInt2, false, false, false, false, false);
    AppMethodBeat.o(41685);
  }
  
  /* Error */
  private static void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    // Byte code:
    //   0: ldc 60
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: invokestatic 19	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +392 -> 401
    //   12: aload_3
    //   13: ldc 62
    //   15: invokestatic 68	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 17
    //   20: aload 17
    //   22: astore_3
    //   23: new 70	java/util/HashMap
    //   26: dup
    //   27: invokespecial 74	java/util/HashMap:<init>	()V
    //   30: astore 17
    //   32: ldc 76
    //   34: invokestatic 82	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   37: checkcast 76	com/tencent/mm/plugin/game/api/f
    //   40: invokeinterface 86 1 0
    //   45: aload_0
    //   46: invokevirtual 92	com/tencent/mm/plugin/game/model/a/g:aAs	(Ljava/lang/String;)Lcom/tencent/mm/plugin/game/model/a/d;
    //   49: astore 18
    //   51: aload 18
    //   53: ifnull +21 -> 74
    //   56: aload 17
    //   58: ldc 94
    //   60: aload 18
    //   62: getfield 100	com/tencent/mm/plugin/game/model/a/d:field_forceUpdateFlag	I
    //   65: invokestatic 106	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   68: invokeinterface 112 3 0
    //   73: pop
    //   74: new 114	org/json/JSONObject
    //   77: dup
    //   78: aload 17
    //   80: invokespecial 117	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   83: invokevirtual 121	org/json/JSONObject:toString	()Ljava/lang/String;
    //   86: ldc 62
    //   88: invokestatic 68	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   91: astore 17
    //   93: ldc 123
    //   95: ldc 125
    //   97: bipush 12
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_0
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: lload_1
    //   109: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: aload_3
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: iload 4
    //   121: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: dup
    //   126: iconst_4
    //   127: iload 5
    //   129: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: dup
    //   134: iconst_5
    //   135: iload 6
    //   137: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: bipush 6
    //   144: iload 7
    //   146: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   149: aastore
    //   150: dup
    //   151: bipush 7
    //   153: iload 8
    //   155: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   158: aastore
    //   159: dup
    //   160: bipush 8
    //   162: iload 9
    //   164: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   167: aastore
    //   168: dup
    //   169: bipush 9
    //   171: iload 10
    //   173: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   176: aastore
    //   177: dup
    //   178: bipush 10
    //   180: iload 11
    //   182: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   185: aastore
    //   186: dup
    //   187: bipush 11
    //   189: aload 17
    //   191: aastore
    //   192: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iload 7
    //   197: ifeq +169 -> 366
    //   200: iconst_1
    //   201: istore 12
    //   203: iload 8
    //   205: ifeq +167 -> 372
    //   208: iconst_1
    //   209: istore 13
    //   211: iload 9
    //   213: ifeq +165 -> 378
    //   216: iconst_1
    //   217: istore 14
    //   219: iload 10
    //   221: ifeq +163 -> 384
    //   224: iconst_1
    //   225: istore 15
    //   227: iload 11
    //   229: ifeq +161 -> 390
    //   232: iconst_1
    //   233: istore 16
    //   235: bipush 12
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload_0
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: lload_1
    //   247: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   250: aastore
    //   251: dup
    //   252: iconst_2
    //   253: aload_3
    //   254: aastore
    //   255: dup
    //   256: iconst_3
    //   257: iload 4
    //   259: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: iconst_4
    //   265: iload 5
    //   267: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: dup
    //   272: iconst_5
    //   273: iload 6
    //   275: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aastore
    //   279: dup
    //   280: bipush 6
    //   282: iload 12
    //   284: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: aastore
    //   288: dup
    //   289: bipush 7
    //   291: iload 13
    //   293: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: dup
    //   298: bipush 8
    //   300: iload 14
    //   302: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: aastore
    //   306: dup
    //   307: bipush 9
    //   309: iload 15
    //   311: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   314: aastore
    //   315: dup
    //   316: bipush 10
    //   318: iload 16
    //   320: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: aastore
    //   324: dup
    //   325: bipush 11
    //   327: aload 17
    //   329: aastore
    //   330: invokestatic 149	com/tencent/mm/plugin/game/model/a/f:s	([Ljava/lang/Object;)Ljava/lang/String;
    //   333: astore_0
    //   334: getstatic 155	com/tencent/mm/game/report/api/a:hhr	Lcom/tencent/mm/game/report/api/a;
    //   337: new 157	com/tencent/mm/game/report/api/b
    //   340: dup
    //   341: sipush 15547
    //   344: aload_0
    //   345: invokespecial 160	com/tencent/mm/game/report/api/b:<init>	(ILjava/lang/String;)V
    //   348: invokevirtual 163	com/tencent/mm/game/report/api/a:a	(Lcom/tencent/mm/game/report/api/b;)V
    //   351: ldc 60
    //   353: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: return
    //   357: astore 17
    //   359: ldc 56
    //   361: astore 17
    //   363: goto -270 -> 93
    //   366: iconst_0
    //   367: istore 12
    //   369: goto -166 -> 203
    //   372: iconst_0
    //   373: istore 13
    //   375: goto -164 -> 211
    //   378: iconst_0
    //   379: istore 14
    //   381: goto -162 -> 219
    //   384: iconst_0
    //   385: istore 15
    //   387: goto -160 -> 227
    //   390: iconst_0
    //   391: istore 16
    //   393: goto -158 -> 235
    //   396: astore 17
    //   398: goto -39 -> 359
    //   401: goto -378 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramString1	String
    //   0	404	1	paramLong	long
    //   0	404	3	paramString2	String
    //   0	404	4	paramInt1	int
    //   0	404	5	paramInt2	int
    //   0	404	6	paramInt3	int
    //   0	404	7	paramBoolean1	boolean
    //   0	404	8	paramBoolean2	boolean
    //   0	404	9	paramBoolean3	boolean
    //   0	404	10	paramBoolean4	boolean
    //   0	404	11	paramBoolean5	boolean
    //   201	167	12	i	int
    //   209	165	13	j	int
    //   217	163	14	k	int
    //   225	161	15	m	int
    //   233	159	16	n	int
    //   18	310	17	localObject	Object
    //   357	1	17	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   361	1	17	str	String
    //   396	1	17	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   49	12	18	locald	d
    // Exception table:
    //   from	to	target	type
    //   5	20	357	java/io/UnsupportedEncodingException
    //   23	51	396	java/io/UnsupportedEncodingException
    //   56	74	396	java/io/UnsupportedEncodingException
    //   74	93	396	java/io/UnsupportedEncodingException
  }
  
  public static void aAr(String paramString)
  {
    AppMethodBeat.i(41683);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41683);
      return;
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramString);
    Object localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSM().aAs(paramString);
    if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.id > 0L))
    {
      if (localObject != null)
      {
        l = localFileDownloadTaskInfo.id;
        String str = localFileDownloadTaskInfo.url;
        if (localFileDownloadTaskInfo.oJj == 0L) {}
        for (i = 0;; i = (int)(localFileDownloadTaskInfo.qJe * 100L / localFileDownloadTaskInfo.oJj))
        {
          a(paramString, l, str, i, 3, 0, ((d)localObject).field_noWifi, ((d)localObject).field_noSdcard, ((d)localObject).field_noEnoughSpace, ((d)localObject).field_lowBattery, ((d)localObject).field_continueDelay);
          AppMethodBeat.o(41683);
          return;
        }
      }
      long l = localFileDownloadTaskInfo.id;
      localObject = localFileDownloadTaskInfo.url;
      if (localFileDownloadTaskInfo.oJj == 0L) {}
      for (int i = 0;; i = (int)(localFileDownloadTaskInfo.qJe * 100L / localFileDownloadTaskInfo.oJj))
      {
        a(paramString, l, (String)localObject, i, 3, 0, false, false, false, false, false);
        AppMethodBeat.o(41683);
        return;
      }
    }
    if (localObject != null)
    {
      a(paramString, 0L, "", 0, 3, 0, ((d)localObject).field_noWifi, ((d)localObject).field_noSdcard, ((d)localObject).field_noEnoughSpace, ((d)localObject).field_lowBattery, ((d)localObject).field_continueDelay);
      AppMethodBeat.o(41683);
      return;
    }
    a(paramString, 0L, "", 0, 3, 0, false, false, false, false, false);
    AppMethodBeat.o(41683);
  }
  
  static void ap(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41684);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41684);
      return;
    }
    if (((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSM().aAs(paramString) != null) {
      P(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(41684);
  }
  
  private static String s(Object... paramVarArgs)
  {
    AppMethodBeat.i(41687);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 11)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[11]));
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(41687);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.f
 * JD-Core Version:    0.7.0.1
 */