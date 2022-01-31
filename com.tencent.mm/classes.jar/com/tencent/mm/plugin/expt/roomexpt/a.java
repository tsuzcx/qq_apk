package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.b.a.q;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;

public final class a
  implements c, d
{
  private static final float[] jIA = { 0.0F, 0.35F, 0.5F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private static a jIC;
  private static final float[] jIs = { 0.0F, 0.3F, 0.45F, 0.55F, 0.67F, 0.75F, 0.85F, 1.0F };
  private static final float[] jIt = { 0.0F, 0.0F, 0.0F, 0.0F, 0.1F, 0.2F, 0.3F, 0.4F };
  private static final float[] jIu = { 0.0F, 0.1F, 0.2F, 0.3F, 0.4F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 1.0F };
  private static final int[] jIv = { 15, 35, 83, 140, 209, 297, 417, 599, 926, 1720 };
  private static final float[] jIw = { 0.0F, 0.3F, 0.5F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private static final float[] jIx = { 0.0F, 0.3F, 0.45F, 0.55F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private static final float[] jIy = { 0.1F, 0.2F, 0.3F, 0.4F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 1.0F };
  private static final int[] jIz = { 2400, 7500, 13000, 21500, 41000, 65000, 116000, 215000, 455000 };
  private SimpleDateFormat jIB = null;
  public b jID;
  q jIE;
  private String[] jIF;
  private boolean jIG = false;
  int jIH = 0;
  
  private static float a(float[] paramArrayOfFloat, int[] paramArrayOfInt, long paramLong)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0)) {}
    while ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      return 0.0F;
    }
    int j = paramArrayOfFloat.length;
    int k = Math.min(paramArrayOfFloat.length, paramArrayOfInt.length);
    int i = 0;
    if (i < k) {
      if (paramLong >= paramArrayOfInt[i]) {}
    }
    for (;;)
    {
      return paramArrayOfFloat[i];
      i += 1;
      break;
      i = j - 1;
    }
  }
  
  public static a aNc()
  {
    if (jIC == null) {
      jIC = new a();
    }
    return jIC;
  }
  
  private void aNd()
  {
    if (this.jIE == null) {
      return;
    }
    String str = this.jIE.uI();
    g.DP().Dz().c(ac.a.uzs, str);
    y.i("MicroMsg.ChatRoomExptService", "save expt info[%s]", new Object[] { this.jIE.uJ() });
  }
  
  private static float b(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    if (paramInt1 <= 0) {
      return 0.0F;
    }
    int i;
    if (paramInt2 == 1)
    {
      i = 1;
      if (i == 0) {
        break label127;
      }
    }
    for (;;)
    {
      try
      {
        f2 = c(jIt, paramInt1);
        f1 = f2;
        f2 = (paramFloat / paramInt1 + paramFloat / 7.0F) / 2.0F - f2;
        f1 = f2;
        y.d("MicroMsg.ChatRoomExptService", "calc finish score result[%f] day[%d] isMute[%d] score[%f]", new Object[] { Float.valueOf(f2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat) });
        return f2;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.ChatRoomExptService", "calc finish score error[%s]", new Object[] { localException.toString() });
        return f1;
      }
      i = 0;
      break;
      label127:
      float f2 = c(jIs, paramInt1);
      f2 += (paramFloat / paramInt1 + paramFloat / 7.0F) / 2.0F;
    }
  }
  
  private static float c(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0)) {
      return 0.0F;
    }
    if (paramInt >= paramArrayOfFloat.length) {
      return paramArrayOfFloat[(paramArrayOfFloat.length - 1)];
    }
    if (paramInt <= 0) {
      return paramArrayOfFloat[0];
    }
    return paramArrayOfFloat[paramInt];
  }
  
  public final void a(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    com.tencent.mm.plugin.expt.a.a locala = (com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class);
    a.a locala1 = a.a.jHZ;
    boolean bool;
    int i;
    if (this.jIE != null)
    {
      bool = this.jIE.cjq;
      if (locala.a(locala1, bool)) {
        break label61;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label226;
      }
      return;
      bool = false;
      break;
      label61:
      h.nFQ.h(869L, 1L, 1L);
      long l = this.jIE.cjn;
      if (l >= 3L)
      {
        y.d("MicroMsg.ChatRoomExptService", "room expt already finish");
        i = 0;
      }
      else
      {
        if (l == 0L)
        {
          i = 1;
          label114:
          if (!paramBoolean) {
            break label180;
          }
        }
        label180:
        for (l = 1L | l;; l = 0x2 | l)
        {
          this.jIE.cjn = l;
          if (l < 3L) {
            break label191;
          }
          y.d("MicroMsg.ChatRoomExptService", "user already enter mute room and unmute room, don't expt");
          h.nFQ.h(869L, 2L, 1L);
          aNd();
          i = 0;
          break;
          i = 0;
          break label114;
        }
        label191:
        if (i != 0)
        {
          if (this.jIE.cjo <= 0L) {
            this.jIE.uP();
          }
          aNd();
        }
        i = 1;
      }
    }
    label226:
    g.DS().O(new a.4(this, paramLong, paramInt2, paramString1, paramInt1, paramBoolean, paramString2));
  }
  
  /* Error */
  final java.util.List<c> aNe()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   4: ifnonnull +13 -> 17
    //   7: ldc 179
    //   9: ldc_w 446
    //   12: invokestatic 449	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   21: getfield 411	com/tencent/mm/h/b/a/q:cjn	J
    //   24: ldc2_w 412
    //   27: lcmp
    //   28: iflt +30 -> 58
    //   31: ldc 179
    //   33: ldc_w 451
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   46: getfield 411	com/tencent/mm/h/b/a/q:cjn	J
    //   49: invokestatic 456	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: aastore
    //   53: invokestatic 230	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aconst_null
    //   57: areturn
    //   58: ldc_w 392
    //   61: invokestatic 396	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   64: checkcast 392	com/tencent/mm/plugin/expt/a/a
    //   67: astore 8
    //   69: getstatic 402	com/tencent/mm/plugin/expt/a/a$a:jHZ	Lcom/tencent/mm/plugin/expt/a/a$a;
    //   72: astore 9
    //   74: aload_0
    //   75: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   78: ifnull +36 -> 114
    //   81: aload_0
    //   82: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   85: getfield 405	com/tencent/mm/h/b/a/q:cjq	Z
    //   88: istore 5
    //   90: aload 8
    //   92: aload 9
    //   94: iload 5
    //   96: invokeinterface 408 3 0
    //   101: ifne +19 -> 120
    //   104: ldc 179
    //   106: ldc_w 458
    //   109: invokestatic 460	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aconst_null
    //   113: areturn
    //   114: iconst_0
    //   115: istore 5
    //   117: goto -27 -> 90
    //   120: aload_0
    //   121: getfield 353	com/tencent/mm/plugin/expt/roomexpt/a:jIF	[Ljava/lang/String;
    //   124: ifnull +21 -> 145
    //   127: aload_0
    //   128: getfield 353	com/tencent/mm/plugin/expt/roomexpt/a:jIF	[Ljava/lang/String;
    //   131: arraylength
    //   132: ifle +13 -> 145
    //   135: ldc 179
    //   137: ldc_w 462
    //   140: invokestatic 460	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aconst_null
    //   144: areturn
    //   145: aload_0
    //   146: getfield 83	com/tencent/mm/plugin/expt/roomexpt/a:jIG	Z
    //   149: ifeq +13 -> 162
    //   152: ldc 179
    //   154: ldc_w 464
    //   157: invokestatic 418	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aconst_null
    //   161: areturn
    //   162: invokestatic 467	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   165: lstore 6
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield 83	com/tencent/mm/plugin/expt/roomexpt/a:jIG	Z
    //   172: getstatic 314	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   175: ldc2_w 317
    //   178: ldc2_w 468
    //   181: lconst_1
    //   182: invokevirtual 321	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   185: aload_0
    //   186: getfield 385	com/tencent/mm/plugin/expt/roomexpt/a:jID	Lcom/tencent/mm/plugin/expt/roomexpt/b;
    //   189: invokevirtual 475	com/tencent/mm/plugin/expt/roomexpt/b:aNh	()Landroid/database/Cursor;
    //   192: astore 9
    //   194: fconst_0
    //   195: fstore_2
    //   196: fconst_0
    //   197: fstore_1
    //   198: new 477	java/util/ArrayList
    //   201: dup
    //   202: invokespecial 478	java/util/ArrayList:<init>	()V
    //   205: astore 11
    //   207: aload 9
    //   209: ifnull +612 -> 821
    //   212: fload_1
    //   213: fstore_2
    //   214: aload 9
    //   216: invokeinterface 483 1 0
    //   221: ifeq +600 -> 821
    //   224: aload 9
    //   226: invokeinterface 487 1 0
    //   231: iconst_5
    //   232: if_icmpge +186 -> 418
    //   235: ldc 179
    //   237: ldc_w 489
    //   240: invokestatic 449	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 11
    //   245: invokestatic 495	java/util/Collections:sort	(Ljava/util/List;)V
    //   248: fconst_0
    //   249: fstore_2
    //   250: aload 11
    //   252: invokeinterface 500 1 0
    //   257: ifle +14 -> 271
    //   260: fload_1
    //   261: aload 11
    //   263: invokeinterface 500 1 0
    //   268: i2f
    //   269: fdiv
    //   270: fstore_2
    //   271: fload_2
    //   272: fconst_0
    //   273: invokestatic 504	java/lang/Math:max	(FF)F
    //   276: fstore_1
    //   277: new 506	com/tencent/mm/h/b/a/g
    //   280: dup
    //   281: invokespecial 507	com/tencent/mm/h/b/a/g:<init>	()V
    //   284: astore 12
    //   286: aconst_null
    //   287: astore 8
    //   289: aload 11
    //   291: invokeinterface 500 1 0
    //   296: iconst_5
    //   297: invokestatic 93	java/lang/Math:min	(II)I
    //   300: istore 4
    //   302: iconst_0
    //   303: istore_3
    //   304: iload_3
    //   305: iload 4
    //   307: if_icmpge +280 -> 587
    //   310: aload 11
    //   312: iload_3
    //   313: invokeinterface 511 2 0
    //   318: checkcast 513	com/tencent/mm/plugin/expt/roomexpt/c
    //   321: astore 13
    //   323: aload 8
    //   325: astore 10
    //   327: aload 13
    //   329: getfield 516	com/tencent/mm/plugin/expt/roomexpt/c:jIO	F
    //   332: fload_1
    //   333: fcmpl
    //   334: ifle +492 -> 826
    //   337: aload 8
    //   339: ifnull +179 -> 518
    //   342: aload 8
    //   344: ldc_w 518
    //   347: invokevirtual 260	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   350: aload 13
    //   352: getfield 521	com/tencent/mm/plugin/expt/roomexpt/c:bHQ	Ljava/lang/String;
    //   355: invokevirtual 260	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   358: pop
    //   359: aload 12
    //   361: aload 13
    //   363: getfield 521	com/tencent/mm/plugin/expt/roomexpt/c:bHQ	Ljava/lang/String;
    //   366: putfield 522	com/tencent/mm/h/b/a/g:chm	Ljava/lang/String;
    //   369: aload 12
    //   371: new 161	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   378: aload 13
    //   380: getfield 516	com/tencent/mm/plugin/expt/roomexpt/c:jIO	F
    //   383: invokevirtual 166	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   386: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: putfield 525	com/tencent/mm/h/b/a/g:chn	Ljava/lang/String;
    //   392: aload 12
    //   394: aload_0
    //   395: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   398: getfield 411	com/tencent/mm/h/b/a/q:cjn	J
    //   401: l2i
    //   402: putfield 528	com/tencent/mm/h/b/a/g:cho	I
    //   405: aload 12
    //   407: invokevirtual 529	com/tencent/mm/h/b/a/g:QX	()Z
    //   410: pop
    //   411: aload 8
    //   413: astore 10
    //   415: goto +411 -> 826
    //   418: aload 9
    //   420: iconst_0
    //   421: invokeinterface 530 2 0
    //   426: astore 8
    //   428: aload 9
    //   430: iconst_1
    //   431: invokeinterface 530 2 0
    //   436: astore 10
    //   438: aload 9
    //   440: iconst_2
    //   441: invokeinterface 534 2 0
    //   446: istore_3
    //   447: aload 9
    //   449: iconst_3
    //   450: invokeinterface 534 2 0
    //   455: istore 4
    //   457: aload 9
    //   459: iconst_4
    //   460: invokeinterface 538 2 0
    //   465: iload 4
    //   467: iload_3
    //   468: invokestatic 540	com/tencent/mm/plugin/expt/roomexpt/a:b	(FII)F
    //   471: fstore_2
    //   472: new 513	com/tencent/mm/plugin/expt/roomexpt/c
    //   475: dup
    //   476: invokespecial 541	com/tencent/mm/plugin/expt/roomexpt/c:<init>	()V
    //   479: astore 12
    //   481: aload 12
    //   483: aload 8
    //   485: putfield 521	com/tencent/mm/plugin/expt/roomexpt/c:bHQ	Ljava/lang/String;
    //   488: aload 12
    //   490: aload 10
    //   492: putfield 544	com/tencent/mm/plugin/expt/roomexpt/c:nickname	Ljava/lang/String;
    //   495: aload 12
    //   497: fload_2
    //   498: putfield 516	com/tencent/mm/plugin/expt/roomexpt/c:jIO	F
    //   501: aload 11
    //   503: aload 12
    //   505: invokeinterface 548 2 0
    //   510: pop
    //   511: fload_1
    //   512: fload_2
    //   513: fadd
    //   514: fstore_1
    //   515: goto -303 -> 212
    //   518: new 254	java/lang/StringBuffer
    //   521: dup
    //   522: invokespecial 255	java/lang/StringBuffer:<init>	()V
    //   525: astore 8
    //   527: aload 8
    //   529: aload 13
    //   531: getfield 521	com/tencent/mm/plugin/expt/roomexpt/c:bHQ	Ljava/lang/String;
    //   534: invokevirtual 260	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   537: pop
    //   538: goto -179 -> 359
    //   541: astore 10
    //   543: aload 9
    //   545: astore 8
    //   547: aload 10
    //   549: astore 9
    //   551: ldc 179
    //   553: aload 9
    //   555: ldc_w 550
    //   558: iconst_0
    //   559: anewarray 4	java/lang/Object
    //   562: invokestatic 554	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   565: aload 8
    //   567: ifnull +10 -> 577
    //   570: aload 8
    //   572: invokeinterface 557 1 0
    //   577: ldc 179
    //   579: ldc_w 559
    //   582: invokestatic 449	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: aconst_null
    //   586: areturn
    //   587: aload 8
    //   589: ifnull +137 -> 726
    //   592: aload_0
    //   593: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   596: aload 8
    //   598: invokevirtual 301	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   601: putfield 562	com/tencent/mm/h/b/a/q:cjp	Ljava/lang/String;
    //   604: aload_0
    //   605: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   608: ldc2_w 563
    //   611: putfield 411	com/tencent/mm/h/b/a/q:cjn	J
    //   614: aload_0
    //   615: aload_0
    //   616: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   619: getfield 562	com/tencent/mm/h/b/a/q:cjp	Ljava/lang/String;
    //   622: ldc_w 518
    //   625: invokevirtual 570	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   628: putfield 353	com/tencent/mm/plugin/expt/roomexpt/a:jIF	[Ljava/lang/String;
    //   631: getstatic 314	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   634: ldc2_w 317
    //   637: ldc2_w 571
    //   640: lconst_1
    //   641: invokevirtual 321	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   644: aload_0
    //   645: invokespecial 356	com/tencent/mm/plugin/expt/roomexpt/a:aNd	()V
    //   648: aload_0
    //   649: iconst_0
    //   650: putfield 83	com/tencent/mm/plugin/expt/roomexpt/a:jIG	Z
    //   653: aload_0
    //   654: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   657: invokevirtual 227	com/tencent/mm/h/b/a/q:uJ	()Ljava/lang/String;
    //   660: astore 10
    //   662: aload_0
    //   663: getfield 353	com/tencent/mm/plugin/expt/roomexpt/a:jIF	[Ljava/lang/String;
    //   666: ifnull +118 -> 784
    //   669: aload_0
    //   670: getfield 353	com/tencent/mm/plugin/expt/roomexpt/a:jIF	[Ljava/lang/String;
    //   673: invokestatic 577	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   676: astore 8
    //   678: ldc 179
    //   680: ldc_w 579
    //   683: iconst_3
    //   684: anewarray 4	java/lang/Object
    //   687: dup
    //   688: iconst_0
    //   689: aload 10
    //   691: aastore
    //   692: dup
    //   693: iconst_1
    //   694: aload 8
    //   696: aastore
    //   697: dup
    //   698: iconst_2
    //   699: lload 6
    //   701: invokestatic 583	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   704: invokestatic 456	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   707: aastore
    //   708: invokestatic 230	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   711: aload 9
    //   713: ifnull +10 -> 723
    //   716: aload 9
    //   718: invokeinterface 557 1 0
    //   723: aload 11
    //   725: areturn
    //   726: aload_0
    //   727: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   730: ldc2_w 584
    //   733: putfield 411	com/tencent/mm/h/b/a/q:cjn	J
    //   736: aload_0
    //   737: getfield 96	com/tencent/mm/plugin/expt/roomexpt/a:jIE	Lcom/tencent/mm/h/b/a/q;
    //   740: ldc_w 587
    //   743: putfield 562	com/tencent/mm/h/b/a/q:cjp	Ljava/lang/String;
    //   746: aload_0
    //   747: aconst_null
    //   748: putfield 353	com/tencent/mm/plugin/expt/roomexpt/a:jIF	[Ljava/lang/String;
    //   751: getstatic 314	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   754: ldc2_w 317
    //   757: ldc2_w 588
    //   760: lconst_1
    //   761: invokevirtual 321	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   764: goto -120 -> 644
    //   767: astore 8
    //   769: aload 9
    //   771: ifnull +10 -> 781
    //   774: aload 9
    //   776: invokeinterface 557 1 0
    //   781: aload 8
    //   783: athrow
    //   784: ldc_w 591
    //   787: astore 8
    //   789: goto -111 -> 678
    //   792: astore 8
    //   794: aconst_null
    //   795: astore 9
    //   797: goto -28 -> 769
    //   800: astore 10
    //   802: aload 8
    //   804: astore 9
    //   806: aload 10
    //   808: astore 8
    //   810: goto -41 -> 769
    //   813: astore 9
    //   815: aconst_null
    //   816: astore 8
    //   818: goto -267 -> 551
    //   821: fload_2
    //   822: fstore_1
    //   823: goto -580 -> 243
    //   826: iload_3
    //   827: iconst_1
    //   828: iadd
    //   829: istore_3
    //   830: aload 10
    //   832: astore 8
    //   834: goto -530 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	this	a
    //   197	626	1	f1	float
    //   195	627	2	f2	float
    //   303	527	3	i	int
    //   300	166	4	j	int
    //   88	28	5	bool	boolean
    //   165	535	6	l	long
    //   67	628	8	localObject1	Object
    //   767	15	8	localObject2	Object
    //   787	1	8	str1	String
    //   792	11	8	localObject3	Object
    //   808	25	8	localObject4	Object
    //   72	733	9	localObject5	Object
    //   813	1	9	localException1	Exception
    //   325	166	10	localObject6	Object
    //   541	7	10	localException2	Exception
    //   660	30	10	str2	String
    //   800	31	10	localObject7	Object
    //   205	519	11	localArrayList	java.util.ArrayList
    //   284	220	12	localObject8	Object
    //   321	209	13	localc	c
    // Exception table:
    //   from	to	target	type
    //   198	207	541	java/lang/Exception
    //   214	243	541	java/lang/Exception
    //   243	248	541	java/lang/Exception
    //   250	271	541	java/lang/Exception
    //   271	286	541	java/lang/Exception
    //   289	302	541	java/lang/Exception
    //   310	323	541	java/lang/Exception
    //   327	337	541	java/lang/Exception
    //   342	359	541	java/lang/Exception
    //   359	411	541	java/lang/Exception
    //   418	511	541	java/lang/Exception
    //   518	538	541	java/lang/Exception
    //   592	644	541	java/lang/Exception
    //   644	678	541	java/lang/Exception
    //   678	711	541	java/lang/Exception
    //   726	764	541	java/lang/Exception
    //   198	207	767	finally
    //   214	243	767	finally
    //   243	248	767	finally
    //   250	271	767	finally
    //   271	286	767	finally
    //   289	302	767	finally
    //   310	323	767	finally
    //   327	337	767	finally
    //   342	359	767	finally
    //   359	411	767	finally
    //   418	511	767	finally
    //   518	538	767	finally
    //   592	644	767	finally
    //   644	678	767	finally
    //   678	711	767	finally
    //   726	764	767	finally
    //   172	194	792	finally
    //   551	565	800	finally
    //   172	194	813	java/lang/Exception
  }
  
  protected final void aNf()
  {
    b localb = this.jID;
    try
    {
      localb.dXw.delete("RoomMuteExpt", null, null);
      aNg();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ChatRoomExptStorage", localException, "deleteAll", new Object[0]);
      }
    }
  }
  
  protected final void aNg()
  {
    if (this.jIE != null)
    {
      this.jIE = new q();
      this.jIE.cjq = true;
      aNd();
    }
    this.jIF = null;
  }
  
  public final void ax(final String paramString, final boolean paramBoolean)
  {
    y.d("MicroMsg.ChatRoomExptService", "enter chat room [%s] isMute[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (this.jIH > 0)
    {
      this.jIH -= 1;
      g.DS().O(new Runnable()
      {
        public final void run()
        {
          a.ay(paramString, paramBoolean);
        }
      });
    }
    do
    {
      return;
      if ((this.jIF == null) || (this.jIF.length <= 0))
      {
        y.d("MicroMsg.ChatRoomExptService", "roomname list is null");
        return;
      }
    } while (this.jIE == null);
    if (this.jIE.cjn >= 5L)
    {
      y.d("MicroMsg.ChatRoomExptService", "exptInfo is finish [%d]", new Object[] { Long.valueOf(this.jIE.cjn) });
      return;
    }
    g.DS().O(new a.3(this, paramString, paramBoolean));
  }
  
  public final void fG(boolean paramBoolean)
  {
    com.tencent.mm.sdk.f.e.post(new a.1(this, paramBoolean), "click_room_mute_msg");
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    if (this.jIE == null)
    {
      paramc = (String)g.DP().Dz().get(ac.a.uzs, "");
      if (!bk.bl(paramc)) {
        break label82;
      }
      this.jIE = new q();
      this.jIE.cjq = false;
    }
    for (;;)
    {
      y.i("MicroMsg.ChatRoomExptService", "load expt roomnameList[%s] info[%s]", new Object[] { this.jIF, this.jIE.uJ() });
      return;
      label82:
      this.jIE = new q(paramc);
      if (!bk.bl(this.jIE.cjp)) {
        this.jIF = this.jIE.cjp.split(";");
      }
    }
  }
  
  public final void onAccountRelease()
  {
    this.jIE = null;
    this.jID = null;
  }
  
  public final void q(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, RoomExptDebugUI.class);
    paramContext.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a
 * JD-Core Version:    0.7.0.1
 */