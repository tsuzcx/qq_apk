package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class b$b
  implements Runnable
{
  private b$b(b paramb) {}
  
  private void aV(List<com.tencent.mm.plugin.h.b.a> paramList)
  {
    int j = paramList.size();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      com.tencent.mm.plugin.h.b.a locala = (com.tencent.mm.plugin.h.b.a)paramList.get(i);
      i locali2 = (i)localHashMap.get(Long.valueOf(locala.field_msgId));
      i locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i();
        localHashMap.put(Long.valueOf(locala.field_msgId), locali1);
        localArrayList.add(locali1);
      }
      locali1.iBW.add(locala);
      locali1.eHF = locala.field_msgtime;
      locali1.userName = locala.field_username;
      locali1.bHR = locala.field_msgId;
      if (!com.tencent.mm.plugin.h.a.oH(locala.field_msgSubType)) {
        locali1.size += locala.field_size;
      }
      switch (locala.field_msgSubType)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        locali1.filePath = (g.DP().dKs + locala.field_path);
        locali1.type = 3;
        continue;
        locali1.thumbPath = (g.DP().dKs + locala.field_path);
        locali1.type = 3;
        continue;
        locali1.filePath = (g.DP().dKs + locala.field_path);
        locali1.type = 1;
        continue;
        locali1.thumbPath = (g.DP().dKs + locala.field_path);
        locali1.type = 1;
        continue;
        locali1.filePath = (g.DP().dKs + locala.field_path);
        locali1.type = 1;
        continue;
        locali1.thumbPath = (g.DP().dKs + locala.field_path);
        locali1.type = 1;
        continue;
        locali1.filePath = (g.DP().dKs + locala.field_path);
        locali1.type = 4;
        continue;
        locali1.thumbPath = (g.DP().dKs + locala.field_path);
        locali1.type = 4;
        continue;
        locali1.filePath = (g.DP().dKs + locala.field_path);
        locali1.type = 4;
        continue;
        locali1.thumbPath = (g.DP().dKs + locala.field_path);
        locali1.type = 4;
      }
    }
    paramList = localArrayList.iterator();
    while (paramList.hasNext()) {
      if (((i)paramList.next()).size <= 0L) {
        paramList.remove();
      }
    }
    b.d(this.iCF).addAll(localArrayList);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: new 168	com/tencent/mm/pointers/PLong
    //   3: dup
    //   4: invokespecial 169	com/tencent/mm/pointers/PLong:<init>	()V
    //   7: astore 11
    //   9: new 168	com/tencent/mm/pointers/PLong
    //   12: dup
    //   13: invokespecial 169	com/tencent/mm/pointers/PLong:<init>	()V
    //   16: astore 12
    //   18: invokestatic 175	com/tencent/mm/plugin/h/b:ayE	()Lcom/tencent/mm/plugin/h/b;
    //   21: invokevirtual 179	com/tencent/mm/plugin/h/b:ayF	()Lcom/tencent/mm/plugin/h/b/b;
    //   24: astore 10
    //   26: aload_0
    //   27: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:iCF	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   30: invokestatic 183	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
    //   33: astore 13
    //   35: invokestatic 189	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   38: lstore_1
    //   39: new 104	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 191
    //   45: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: aload 13
    //   50: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 196
    //   55: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 14
    //   63: aconst_null
    //   64: astore 9
    //   66: aconst_null
    //   67: astore 8
    //   69: aload 10
    //   71: getfield 202	com/tencent/mm/plugin/h/b/b:dXw	Lcom/tencent/mm/sdk/e/e;
    //   74: aload 14
    //   76: aconst_null
    //   77: invokeinterface 208 3 0
    //   82: astore 10
    //   84: aload 10
    //   86: ifnull +63 -> 149
    //   89: aload 10
    //   91: astore 8
    //   93: aload 10
    //   95: astore 9
    //   97: aload 10
    //   99: invokeinterface 213 1 0
    //   104: ifeq +45 -> 149
    //   107: aload 10
    //   109: astore 8
    //   111: aload 10
    //   113: astore 9
    //   115: aload 11
    //   117: aload 10
    //   119: iconst_0
    //   120: invokeinterface 217 2 0
    //   125: putfield 220	com/tencent/mm/pointers/PLong:value	J
    //   128: aload 10
    //   130: astore 8
    //   132: aload 10
    //   134: astore 9
    //   136: aload 12
    //   138: aload 10
    //   140: iconst_1
    //   141: invokeinterface 217 2 0
    //   146: putfield 220	com/tencent/mm/pointers/PLong:value	J
    //   149: aload 10
    //   151: ifnull +10 -> 161
    //   154: aload 10
    //   156: invokeinterface 223 1 0
    //   161: ldc 225
    //   163: ldc 227
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload 13
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: lload_1
    //   177: invokestatic 231	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   180: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   183: aastore
    //   184: invokestatic 237	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: aload 12
    //   189: aload 12
    //   191: getfield 220	com/tencent/mm/pointers/PLong:value	J
    //   194: lconst_1
    //   195: lsub
    //   196: putfield 220	com/tencent/mm/pointers/PLong:value	J
    //   199: aload 11
    //   201: getfield 220	com/tencent/mm/pointers/PLong:value	J
    //   204: lstore 5
    //   206: lload 5
    //   208: ldc2_w 238
    //   211: lsub
    //   212: aload 12
    //   214: getfield 220	com/tencent/mm/pointers/PLong:value	J
    //   217: invokestatic 245	java/lang/Math:max	(JJ)J
    //   220: lstore_3
    //   221: aload_0
    //   222: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:iCF	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   225: invokestatic 248	com/tencent/mm/plugin/clean/ui/fileindexui/b:b	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Z
    //   228: istore 7
    //   230: iload 7
    //   232: ifeq +60 -> 292
    //   235: return
    //   236: astore 10
    //   238: aload 8
    //   240: astore 9
    //   242: ldc 225
    //   244: aload 10
    //   246: ldc 250
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 14
    //   256: aastore
    //   257: invokestatic 254	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 8
    //   262: ifnull -101 -> 161
    //   265: aload 8
    //   267: invokeinterface 223 1 0
    //   272: goto -111 -> 161
    //   275: astore 8
    //   277: aload 9
    //   279: ifnull +10 -> 289
    //   282: aload 9
    //   284: invokeinterface 223 1 0
    //   289: aload 8
    //   291: athrow
    //   292: lload_3
    //   293: lstore_1
    //   294: lload_3
    //   295: lload 5
    //   297: lcmp
    //   298: ifne +7 -> 305
    //   301: lload_3
    //   302: lconst_1
    //   303: lsub
    //   304: lstore_1
    //   305: aload_0
    //   306: invokestatic 175	com/tencent/mm/plugin/h/b:ayE	()Lcom/tencent/mm/plugin/h/b;
    //   309: invokevirtual 179	com/tencent/mm/plugin/h/b:ayF	()Lcom/tencent/mm/plugin/h/b/b;
    //   312: aload_0
    //   313: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:iCF	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   316: invokestatic 183	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
    //   319: lload 5
    //   321: lload_1
    //   322: invokevirtual 258	com/tencent/mm/plugin/h/b/b:k	(Ljava/lang/String;JJ)Ljava/util/List;
    //   325: invokespecial 260	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:aV	(Ljava/util/List;)V
    //   328: aload_0
    //   329: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:iCF	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   332: invokestatic 263	com/tencent/mm/plugin/clean/ui/fileindexui/b:c	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)V
    //   335: lload_1
    //   336: lstore_3
    //   337: aload_0
    //   338: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:iCF	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   341: invokestatic 248	com/tencent/mm/plugin/clean/ui/fileindexui/b:b	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Z
    //   344: ifne -109 -> 235
    //   347: lload_3
    //   348: aload 12
    //   350: getfield 220	com/tencent/mm/pointers/PLong:value	J
    //   353: lcmp
    //   354: ifle -119 -> 235
    //   357: lload_3
    //   358: ldc2_w 264
    //   361: lsub
    //   362: aload 12
    //   364: getfield 220	com/tencent/mm/pointers/PLong:value	J
    //   367: invokestatic 245	java/lang/Math:max	(JJ)J
    //   370: lstore 5
    //   372: lload 5
    //   374: lstore_1
    //   375: lload 5
    //   377: lload_3
    //   378: lcmp
    //   379: ifne +8 -> 387
    //   382: lload 5
    //   384: lconst_1
    //   385: lsub
    //   386: lstore_1
    //   387: aload_0
    //   388: invokestatic 175	com/tencent/mm/plugin/h/b:ayE	()Lcom/tencent/mm/plugin/h/b;
    //   391: invokevirtual 179	com/tencent/mm/plugin/h/b:ayF	()Lcom/tencent/mm/plugin/h/b/b;
    //   394: aload_0
    //   395: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:iCF	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   398: invokestatic 183	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
    //   401: lload_3
    //   402: lload_1
    //   403: invokevirtual 258	com/tencent/mm/plugin/h/b/b:k	(Ljava/lang/String;JJ)Ljava/util/List;
    //   406: invokespecial 260	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:aV	(Ljava/util/List;)V
    //   409: aload_0
    //   410: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:iCF	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
    //   413: invokestatic 263	com/tencent/mm/plugin/clean/ui/fileindexui/b:c	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)V
    //   416: lload_1
    //   417: lstore_3
    //   418: goto -81 -> 337
    //   421: astore 8
    //   423: ldc_w 267
    //   426: aload 8
    //   428: ldc_w 269
    //   431: iconst_0
    //   432: anewarray 4	java/lang/Object
    //   435: invokestatic 254	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	this	b
    //   38	379	1	l1	long
    //   220	198	3	l2	long
    //   204	179	5	l3	long
    //   228	3	7	bool	boolean
    //   67	199	8	localObject1	Object
    //   275	15	8	localObject2	Object
    //   421	6	8	localException1	java.lang.Exception
    //   64	219	9	localObject3	Object
    //   24	131	10	localObject4	Object
    //   236	9	10	localException2	java.lang.Exception
    //   7	193	11	localPLong1	com.tencent.mm.pointers.PLong
    //   16	347	12	localPLong2	com.tencent.mm.pointers.PLong
    //   33	139	13	str1	java.lang.String
    //   61	194	14	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   69	84	236	java/lang/Exception
    //   97	107	236	java/lang/Exception
    //   115	128	236	java/lang/Exception
    //   136	149	236	java/lang/Exception
    //   69	84	275	finally
    //   97	107	275	finally
    //   115	128	275	finally
    //   136	149	275	finally
    //   242	260	275	finally
    //   221	230	421	java/lang/Exception
    //   305	335	421	java/lang/Exception
    //   337	372	421	java/lang/Exception
    //   387	416	421	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.b
 * JD-Core Version:    0.7.0.1
 */