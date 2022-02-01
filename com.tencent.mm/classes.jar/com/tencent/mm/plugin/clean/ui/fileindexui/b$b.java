package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.calcwx.b.a;
import com.tencent.mm.plugin.clean.c.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class b$b
  implements Runnable
{
  private b$b(b paramb) {}
  
  private void eV(List<a> paramList)
  {
    AppMethodBeat.i(22863);
    int j = paramList.size();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      a locala = (a)paramList.get(i);
      c localc2 = (c)localHashMap.get(Long.valueOf(locala.field_msgId));
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c();
        localHashMap.put(Long.valueOf(locala.field_msgId), localc1);
        localArrayList.add(localc1);
      }
      localc1.wRI.add(locala);
      localc1.pba = locala.field_msgtime;
      localc1.userName = locala.field_username;
      localc1.hCz = locala.field_msgId;
      localc1.size += locala.field_size;
      localc1.msgType = locala.field_msgType;
      switch (locala.field_msgSubType)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localc1.filePath = (h.baE().mCI + locala.field_path);
        localc1.type = 3;
        continue;
        if (locala.field_msgType == 486539313) {}
        for (localc1.thumbPath = locala.field_path;; localc1.thumbPath = (h.baE().mCI + locala.field_path))
        {
          localc1.type = 3;
          break;
        }
        localc1.filePath = (h.baE().mCI + locala.field_path);
        localc1.type = 1;
        continue;
        localc1.thumbPath = (h.baE().mCI + locala.field_path);
        localc1.type = 1;
        continue;
        localc1.filePath = (h.baE().mCI + locala.field_path);
        localc1.type = 4;
        continue;
        localc1.thumbPath = (h.baE().mCI + locala.field_path);
        localc1.type = 4;
      }
    }
    paramList = localArrayList.iterator();
    while (paramList.hasNext()) {
      if (((c)paramList.next()).size <= 0L) {
        paramList.remove();
      }
    }
    b.d(this.wSn).addAll(localArrayList);
    AppMethodBeat.o(22863);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 22862
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 178	com/tencent/mm/pointers/PLong
    //   9: dup
    //   10: invokespecial 179	com/tencent/mm/pointers/PLong:<init>	()V
    //   13: astore 11
    //   15: new 178	com/tencent/mm/pointers/PLong
    //   18: dup
    //   19: invokespecial 179	com/tencent/mm/pointers/PLong:<init>	()V
    //   22: astore 12
    //   24: invokestatic 185	com/tencent/mm/plugin/calcwx/a:diz	()Lcom/tencent/mm/plugin/calcwx/a;
    //   27: invokevirtual 189	com/tencent/mm/plugin/calcwx/a:diA	()Lcom/tencent/mm/plugin/calcwx/b/b;
    //   30: astore 10
    //   32: aload_0
    //   33: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:wSn	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   36: invokestatic 193	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
    //   39: astore 13
    //   41: invokestatic 199	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   44: lstore_1
    //   45: new 110	java/lang/StringBuilder
    //   48: dup
    //   49: ldc 201
    //   51: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload 13
    //   56: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 206
    //   61: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 14
    //   69: aconst_null
    //   70: astore 9
    //   72: aconst_null
    //   73: astore 8
    //   75: aload 10
    //   77: getfield 212	com/tencent/mm/plugin/calcwx/b/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   80: aload 14
    //   82: aconst_null
    //   83: invokeinterface 218 3 0
    //   88: astore 10
    //   90: aload 10
    //   92: ifnull +63 -> 155
    //   95: aload 10
    //   97: astore 8
    //   99: aload 10
    //   101: astore 9
    //   103: aload 10
    //   105: invokeinterface 223 1 0
    //   110: ifeq +45 -> 155
    //   113: aload 10
    //   115: astore 8
    //   117: aload 10
    //   119: astore 9
    //   121: aload 11
    //   123: aload 10
    //   125: iconst_0
    //   126: invokeinterface 227 2 0
    //   131: putfield 230	com/tencent/mm/pointers/PLong:value	J
    //   134: aload 10
    //   136: astore 8
    //   138: aload 10
    //   140: astore 9
    //   142: aload 12
    //   144: aload 10
    //   146: iconst_1
    //   147: invokeinterface 227 2 0
    //   152: putfield 230	com/tencent/mm/pointers/PLong:value	J
    //   155: aload 10
    //   157: ifnull +10 -> 167
    //   160: aload 10
    //   162: invokeinterface 233 1 0
    //   167: ldc 235
    //   169: ldc 237
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload 13
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: lload_1
    //   183: invokestatic 241	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   186: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: invokestatic 246	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload 12
    //   195: aload 12
    //   197: getfield 230	com/tencent/mm/pointers/PLong:value	J
    //   200: lconst_1
    //   201: lsub
    //   202: putfield 230	com/tencent/mm/pointers/PLong:value	J
    //   205: aload 11
    //   207: getfield 230	com/tencent/mm/pointers/PLong:value	J
    //   210: lstore 5
    //   212: lload 5
    //   214: ldc2_w 247
    //   217: lsub
    //   218: aload 12
    //   220: getfield 230	com/tencent/mm/pointers/PLong:value	J
    //   223: invokestatic 254	java/lang/Math:max	(JJ)J
    //   226: lstore_3
    //   227: aload_0
    //   228: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:wSn	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   231: invokestatic 257	com/tencent/mm/plugin/clean/ui/fileindexui/b:b	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Z
    //   234: istore 7
    //   236: iload 7
    //   238: ifeq +73 -> 311
    //   241: sipush 22862
    //   244: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: return
    //   248: astore 10
    //   250: aload 8
    //   252: astore 9
    //   254: ldc 235
    //   256: aload 10
    //   258: ldc_w 259
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload 14
    //   269: aastore
    //   270: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload 8
    //   275: ifnull -108 -> 167
    //   278: aload 8
    //   280: invokeinterface 233 1 0
    //   285: goto -118 -> 167
    //   288: astore 8
    //   290: aload 9
    //   292: ifnull +10 -> 302
    //   295: aload 9
    //   297: invokeinterface 233 1 0
    //   302: sipush 22862
    //   305: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload 8
    //   310: athrow
    //   311: lload_3
    //   312: lstore_1
    //   313: lload_3
    //   314: lload 5
    //   316: lcmp
    //   317: ifne +7 -> 324
    //   320: lload_3
    //   321: lconst_1
    //   322: lsub
    //   323: lstore_1
    //   324: aload_0
    //   325: invokestatic 185	com/tencent/mm/plugin/calcwx/a:diz	()Lcom/tencent/mm/plugin/calcwx/a;
    //   328: invokevirtual 189	com/tencent/mm/plugin/calcwx/a:diA	()Lcom/tencent/mm/plugin/calcwx/b/b;
    //   331: aload_0
    //   332: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:wSn	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   335: invokestatic 193	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
    //   338: lload 5
    //   340: lload_1
    //   341: invokevirtual 267	com/tencent/mm/plugin/calcwx/b/b:y	(Ljava/lang/String;JJ)Ljava/util/List;
    //   344: invokespecial 269	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:eV	(Ljava/util/List;)V
    //   347: aload_0
    //   348: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:wSn	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   351: invokestatic 272	com/tencent/mm/plugin/clean/ui/fileindexui/b:c	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)V
    //   354: lload_1
    //   355: lstore_3
    //   356: aload_0
    //   357: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:wSn	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   360: invokestatic 257	com/tencent/mm/plugin/clean/ui/fileindexui/b:b	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Z
    //   363: ifne +77 -> 440
    //   366: lload_3
    //   367: aload 12
    //   369: getfield 230	com/tencent/mm/pointers/PLong:value	J
    //   372: lcmp
    //   373: ifle +67 -> 440
    //   376: lload_3
    //   377: ldc2_w 273
    //   380: lsub
    //   381: aload 12
    //   383: getfield 230	com/tencent/mm/pointers/PLong:value	J
    //   386: invokestatic 254	java/lang/Math:max	(JJ)J
    //   389: lstore 5
    //   391: lload 5
    //   393: lstore_1
    //   394: lload 5
    //   396: lload_3
    //   397: lcmp
    //   398: ifne +8 -> 406
    //   401: lload 5
    //   403: lconst_1
    //   404: lsub
    //   405: lstore_1
    //   406: aload_0
    //   407: invokestatic 185	com/tencent/mm/plugin/calcwx/a:diz	()Lcom/tencent/mm/plugin/calcwx/a;
    //   410: invokevirtual 189	com/tencent/mm/plugin/calcwx/a:diA	()Lcom/tencent/mm/plugin/calcwx/b/b;
    //   413: aload_0
    //   414: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:wSn	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   417: invokestatic 193	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
    //   420: lload_3
    //   421: lload_1
    //   422: invokevirtual 267	com/tencent/mm/plugin/calcwx/b/b:y	(Ljava/lang/String;JJ)Ljava/util/List;
    //   425: invokespecial 269	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:eV	(Ljava/util/List;)V
    //   428: aload_0
    //   429: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:wSn	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   432: invokestatic 272	com/tencent/mm/plugin/clean/ui/fileindexui/b:c	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)V
    //   435: lload_1
    //   436: lstore_3
    //   437: goto -81 -> 356
    //   440: sipush 22862
    //   443: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: return
    //   447: astore 8
    //   449: ldc_w 276
    //   452: aload 8
    //   454: ldc_w 278
    //   457: iconst_0
    //   458: anewarray 4	java/lang/Object
    //   461: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: sipush 22862
    //   467: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   470: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	b
    //   44	392	1	l1	long
    //   226	211	3	l2	long
    //   210	192	5	l3	long
    //   234	3	7	bool	boolean
    //   73	206	8	localObject1	Object
    //   288	21	8	localObject2	Object
    //   447	6	8	localException1	java.lang.Exception
    //   70	226	9	localObject3	Object
    //   30	131	10	localObject4	Object
    //   248	9	10	localException2	java.lang.Exception
    //   13	193	11	localPLong1	com.tencent.mm.pointers.PLong
    //   22	360	12	localPLong2	com.tencent.mm.pointers.PLong
    //   39	139	13	str1	java.lang.String
    //   67	201	14	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   75	90	248	java/lang/Exception
    //   103	113	248	java/lang/Exception
    //   121	134	248	java/lang/Exception
    //   142	155	248	java/lang/Exception
    //   75	90	288	finally
    //   103	113	288	finally
    //   121	134	288	finally
    //   142	155	288	finally
    //   254	273	288	finally
    //   227	236	447	java/lang/Exception
    //   324	354	447	java/lang/Exception
    //   356	391	447	java/lang/Exception
    //   406	435	447	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.b
 * JD-Core Version:    0.7.0.1
 */