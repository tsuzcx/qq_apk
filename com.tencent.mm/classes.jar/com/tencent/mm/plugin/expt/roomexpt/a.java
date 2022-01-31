package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ae;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;

public final class a
  implements c, d
{
  private static a mcB;
  private static final float[] mcr = { 0.0F, 0.3F, 0.45F, 0.55F, 0.67F, 0.75F, 0.85F, 1.0F };
  private static final float[] mcs = { 0.0F, 0.0F, 0.0F, 0.0F, 0.1F, 0.2F, 0.3F, 0.4F };
  private static final float[] mct = { 0.0F, 0.1F, 0.2F, 0.3F, 0.4F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 1.0F };
  private static final int[] mcu = { 15, 35, 83, 140, 209, 297, 417, 599, 926, 1720 };
  private static final float[] mcv = { 0.0F, 0.3F, 0.5F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private static final float[] mcw = { 0.0F, 0.3F, 0.45F, 0.55F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private static final float[] mcx = { 0.1F, 0.2F, 0.3F, 0.4F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 1.0F };
  private static final int[] mcy = { 2400, 7500, 13000, 21500, 41000, 65000, 116000, 215000, 455000 };
  private static final float[] mcz = { 0.0F, 0.35F, 0.5F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private SimpleDateFormat mcA;
  public b mcC;
  private ae mcD;
  private String[] mcE;
  private boolean mcF;
  int mcG;
  private t mcH;
  
  public a()
  {
    AppMethodBeat.i(152437);
    this.mcA = null;
    this.mcF = false;
    this.mcG = 0;
    this.mcH = new a.5(this);
    AppMethodBeat.o(152437);
  }
  
  private static float a(float[] paramArrayOfFloat, int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(73571);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0))
    {
      AppMethodBeat.o(73571);
      return 0.0F;
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(73571);
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
      float f = paramArrayOfFloat[i];
      AppMethodBeat.o(73571);
      return f;
      i += 1;
      break;
      i = j - 1;
    }
  }
  
  public static a bsU()
  {
    AppMethodBeat.i(73564);
    if (mcB == null) {
      mcB = new a();
    }
    a locala = mcB;
    AppMethodBeat.o(73564);
    return locala;
  }
  
  private void bsV()
  {
    AppMethodBeat.i(73565);
    if (this.mcD == null)
    {
      AppMethodBeat.o(73565);
      return;
    }
    String str = this.mcD.Ff();
    g.RL().Ru().set(ac.a.yKg, str);
    ab.i("MicroMsg.ChatRoomExptService", "save expt info[%s]", new Object[] { this.mcD.Fg() });
    AppMethodBeat.o(73565);
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
  
  private static float d(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(73572);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(73572);
      return 0.0F;
    }
    int i;
    if (paramInt2 == 1)
    {
      i = 1;
      if (i == 0) {
        break label123;
      }
    }
    for (;;)
    {
      try
      {
        f2 = c(mcs, paramInt1);
        f1 = f2;
        f2 = (paramFloat / paramInt1 + paramFloat / 7.0F) / 2.0F - f2;
        f1 = f2;
        ab.d("MicroMsg.ChatRoomExptService", "calc finish score result[%f] day[%d] isMute[%d] score[%f]", new Object[] { Float.valueOf(f2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat) });
        f1 = f2;
      }
      catch (Exception localException)
      {
        float f2;
        label123:
        ab.e("MicroMsg.ChatRoomExptService", "calc finish score error[%s]", new Object[] { localException.toString() });
        continue;
      }
      AppMethodBeat.o(73572);
      return f1;
      i = 0;
      break;
      f2 = c(mcr, paramInt1);
      f2 += (paramFloat / paramInt1 + paramFloat / 7.0F) / 2.0F;
    }
  }
  
  public final void a(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(73569);
    com.tencent.mm.plugin.expt.a.a locala = (com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class);
    a.a locala1 = a.a.lRx;
    boolean bool;
    int i;
    if (this.mcD != null)
    {
      bool = this.mcD.cUf;
      if (locala.a(locala1, bool)) {
        break label73;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label234;
      }
      AppMethodBeat.o(73569);
      return;
      bool = false;
      break;
      label73:
      h.qsU.cT(869, 1);
      long l = this.mcD.cUc;
      if (l >= 3L)
      {
        ab.d("MicroMsg.ChatRoomExptService", "room expt already finish");
        i = 0;
      }
      else
      {
        if (l == 0L)
        {
          i = 1;
          label125:
          if (!paramBoolean) {
            break label188;
          }
        }
        label188:
        for (l = 1L | l;; l = 0x2 | l)
        {
          this.mcD.cUc = l;
          if (l < 3L) {
            break label199;
          }
          ab.d("MicroMsg.ChatRoomExptService", "user already enter mute room and unmute room, don't expt");
          h.qsU.cT(869, 2);
          bsV();
          i = 0;
          break;
          i = 0;
          break label125;
        }
        label199:
        if (i != 0)
        {
          if (this.mcD.cUd <= 0L) {
            this.mcD.Fm();
          }
          bsV();
        }
        i = 1;
      }
    }
    label234:
    g.RO().ac(new a.4(this, paramLong, paramInt2, paramString1, paramInt1, paramBoolean, paramString2));
    AppMethodBeat.o(73569);
  }
  
  public final void aK(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(73568);
    ab.d("MicroMsg.ChatRoomExptService", "enter chat room [%s] isMute[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (this.mcG > 0)
    {
      this.mcG -= 1;
      g.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73561);
          a.aL(paramString, paramBoolean);
          AppMethodBeat.o(73561);
        }
      });
      AppMethodBeat.o(73568);
      return;
    }
    if ((this.mcE == null) || (this.mcE.length <= 0))
    {
      ab.d("MicroMsg.ChatRoomExptService", "roomname list is null");
      AppMethodBeat.o(73568);
      return;
    }
    if (this.mcD == null)
    {
      AppMethodBeat.o(73568);
      return;
    }
    if (this.mcD.cUc >= 5L)
    {
      ab.d("MicroMsg.ChatRoomExptService", "exptInfo is finish [%d]", new Object[] { Long.valueOf(this.mcD.cUc) });
      AppMethodBeat.o(73568);
      return;
    }
    g.RO().ac(new a.3(this, paramString, paramBoolean));
    AppMethodBeat.o(73568);
  }
  
  /* Error */
  final java.util.List<c> bsW()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 485
    //   5: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 203
    //   17: ldc_w 487
    //   20: invokestatic 490	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 485
    //   26: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_0
    //   32: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   35: getfield 426	com/tencent/mm/g/b/a/ae:cUc	J
    //   38: ldc2_w 427
    //   41: lcmp
    //   42: iflt +36 -> 78
    //   45: ldc 203
    //   47: ldc_w 492
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   60: getfield 426	com/tencent/mm/g/b/a/ae:cUc	J
    //   63: invokestatic 481	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   66: aastore
    //   67: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: ldc_w 485
    //   73: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aconst_null
    //   77: areturn
    //   78: ldc_w 407
    //   81: invokestatic 411	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   84: checkcast 407	com/tencent/mm/plugin/expt/a/a
    //   87: astore 9
    //   89: getstatic 417	com/tencent/mm/plugin/expt/a/a$a:lRx	Lcom/tencent/mm/plugin/expt/a/a$a;
    //   92: astore 10
    //   94: aload_0
    //   95: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   98: ifnull +42 -> 140
    //   101: aload_0
    //   102: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   105: getfield 420	com/tencent/mm/g/b/a/ae:cUf	Z
    //   108: istore 6
    //   110: aload 9
    //   112: aload 10
    //   114: iload 6
    //   116: invokeinterface 423 3 0
    //   121: ifne +25 -> 146
    //   124: ldc 203
    //   126: ldc_w 494
    //   129: invokestatic 496	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: ldc_w 485
    //   135: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aconst_null
    //   139: areturn
    //   140: iconst_0
    //   141: istore 6
    //   143: goto -33 -> 110
    //   146: aload_0
    //   147: getfield 300	com/tencent/mm/plugin/expt/roomexpt/a:mcE	[Ljava/lang/String;
    //   150: ifnull +27 -> 177
    //   153: aload_0
    //   154: getfield 300	com/tencent/mm/plugin/expt/roomexpt/a:mcE	[Ljava/lang/String;
    //   157: arraylength
    //   158: ifle +19 -> 177
    //   161: ldc 203
    //   163: ldc_w 498
    //   166: invokestatic 496	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: ldc_w 485
    //   172: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aconst_null
    //   176: areturn
    //   177: aload_0
    //   178: getfield 94	com/tencent/mm/plugin/expt/roomexpt/a:mcF	Z
    //   181: ifeq +19 -> 200
    //   184: ldc 203
    //   186: ldc_w 500
    //   189: invokestatic 433	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: ldc_w 485
    //   195: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aconst_null
    //   199: areturn
    //   200: invokestatic 503	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   203: lstore 7
    //   205: aload_0
    //   206: iconst_1
    //   207: putfield 94	com/tencent/mm/plugin/expt/roomexpt/a:mcF	Z
    //   210: getstatic 290	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   213: sipush 869
    //   216: bipush 21
    //   218: invokevirtual 294	com/tencent/mm/plugin/report/service/h:cT	(II)V
    //   221: aload_0
    //   222: getfield 399	com/tencent/mm/plugin/expt/roomexpt/a:mcC	Lcom/tencent/mm/plugin/expt/roomexpt/b;
    //   225: invokevirtual 509	com/tencent/mm/plugin/expt/roomexpt/b:bta	()Landroid/database/Cursor;
    //   228: astore 10
    //   230: new 511	java/util/ArrayList
    //   233: dup
    //   234: invokespecial 512	java/util/ArrayList:<init>	()V
    //   237: astore 12
    //   239: aload 10
    //   241: ifnull +635 -> 876
    //   244: fconst_0
    //   245: fstore_1
    //   246: fload_1
    //   247: fstore_2
    //   248: aload 10
    //   250: invokeinterface 517 1 0
    //   255: ifeq +24 -> 279
    //   258: aload 10
    //   260: invokeinterface 521 1 0
    //   265: iconst_5
    //   266: if_icmpge +184 -> 450
    //   269: ldc 203
    //   271: ldc_w 523
    //   274: invokestatic 490	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: fload_1
    //   278: fstore_2
    //   279: aload 12
    //   281: invokestatic 529	java/util/Collections:sort	(Ljava/util/List;)V
    //   284: aload 12
    //   286: invokeinterface 534 1 0
    //   291: ifle +580 -> 871
    //   294: fload_2
    //   295: aload 12
    //   297: invokeinterface 534 1 0
    //   302: i2f
    //   303: fdiv
    //   304: fstore_1
    //   305: fload_1
    //   306: fconst_0
    //   307: invokestatic 538	java/lang/Math:max	(FF)F
    //   310: fstore_1
    //   311: new 540	com/tencent/mm/g/b/a/h
    //   314: dup
    //   315: invokespecial 541	com/tencent/mm/g/b/a/h:<init>	()V
    //   318: astore 13
    //   320: aload 12
    //   322: invokeinterface 534 1 0
    //   327: iconst_5
    //   328: invokestatic 115	java/lang/Math:min	(II)I
    //   331: istore 4
    //   333: aconst_null
    //   334: astore 9
    //   336: iload_3
    //   337: iload 4
    //   339: if_icmpge +288 -> 627
    //   342: aload 12
    //   344: iload_3
    //   345: invokeinterface 545 2 0
    //   350: checkcast 547	com/tencent/mm/plugin/expt/roomexpt/c
    //   353: astore 14
    //   355: aload 9
    //   357: astore 11
    //   359: aload 14
    //   361: getfield 550	com/tencent/mm/plugin/expt/roomexpt/c:mcQ	F
    //   364: fload_1
    //   365: fcmpl
    //   366: ifle +515 -> 881
    //   369: aload 9
    //   371: ifnull +181 -> 552
    //   374: aload 9
    //   376: ldc_w 552
    //   379: invokevirtual 237	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   382: aload 14
    //   384: getfield 555	com/tencent/mm/plugin/expt/roomexpt/c:cpf	Ljava/lang/String;
    //   387: invokevirtual 237	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   390: pop
    //   391: aload 13
    //   393: aload 14
    //   395: getfield 555	com/tencent/mm/plugin/expt/roomexpt/c:cpf	Ljava/lang/String;
    //   398: invokevirtual 559	com/tencent/mm/g/b/a/h:eT	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/h;
    //   401: new 185	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   408: aload 14
    //   410: getfield 550	com/tencent/mm/plugin/expt/roomexpt/c:mcQ	F
    //   413: invokevirtual 190	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   416: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokevirtual 562	com/tencent/mm/g/b/a/h:eU	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/h;
    //   422: astore 11
    //   424: aload 11
    //   426: aload_0
    //   427: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   430: getfield 426	com/tencent/mm/g/b/a/ae:cUc	J
    //   433: l2i
    //   434: putfield 565	com/tencent/mm/g/b/a/h:cQe	I
    //   437: aload 11
    //   439: invokevirtual 566	com/tencent/mm/g/b/a/h:ake	()Z
    //   442: pop
    //   443: aload 9
    //   445: astore 11
    //   447: goto +434 -> 881
    //   450: aload 10
    //   452: iconst_0
    //   453: invokeinterface 567 2 0
    //   458: astore 9
    //   460: aload 10
    //   462: iconst_1
    //   463: invokeinterface 567 2 0
    //   468: astore 11
    //   470: aload 10
    //   472: iconst_2
    //   473: invokeinterface 571 2 0
    //   478: istore 4
    //   480: aload 10
    //   482: iconst_3
    //   483: invokeinterface 571 2 0
    //   488: istore 5
    //   490: aload 10
    //   492: iconst_4
    //   493: invokeinterface 575 2 0
    //   498: iload 5
    //   500: iload 4
    //   502: invokestatic 577	com/tencent/mm/plugin/expt/roomexpt/a:d	(FII)F
    //   505: fstore_2
    //   506: new 547	com/tencent/mm/plugin/expt/roomexpt/c
    //   509: dup
    //   510: invokespecial 578	com/tencent/mm/plugin/expt/roomexpt/c:<init>	()V
    //   513: astore 13
    //   515: aload 13
    //   517: aload 9
    //   519: putfield 555	com/tencent/mm/plugin/expt/roomexpt/c:cpf	Ljava/lang/String;
    //   522: aload 13
    //   524: aload 11
    //   526: putfield 581	com/tencent/mm/plugin/expt/roomexpt/c:nickname	Ljava/lang/String;
    //   529: aload 13
    //   531: fload_2
    //   532: putfield 550	com/tencent/mm/plugin/expt/roomexpt/c:mcQ	F
    //   535: aload 12
    //   537: aload 13
    //   539: invokeinterface 585 2 0
    //   544: pop
    //   545: fload_1
    //   546: fload_2
    //   547: fadd
    //   548: fstore_1
    //   549: goto -303 -> 246
    //   552: new 231	java/lang/StringBuffer
    //   555: dup
    //   556: invokespecial 232	java/lang/StringBuffer:<init>	()V
    //   559: astore 9
    //   561: aload 9
    //   563: aload 14
    //   565: getfield 555	com/tencent/mm/plugin/expt/roomexpt/c:cpf	Ljava/lang/String;
    //   568: invokevirtual 237	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   571: pop
    //   572: goto -181 -> 391
    //   575: astore 11
    //   577: aload 10
    //   579: astore 9
    //   581: aload 11
    //   583: astore 10
    //   585: ldc 203
    //   587: aload 10
    //   589: ldc_w 587
    //   592: iconst_0
    //   593: anewarray 4	java/lang/Object
    //   596: invokestatic 591	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   599: aload 9
    //   601: ifnull +10 -> 611
    //   604: aload 9
    //   606: invokeinterface 594 1 0
    //   611: ldc 203
    //   613: ldc_w 596
    //   616: invokestatic 490	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: ldc_w 485
    //   622: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   625: aconst_null
    //   626: areturn
    //   627: aload 9
    //   629: ifnull +142 -> 771
    //   632: aload_0
    //   633: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   636: aload 9
    //   638: invokevirtual 277	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   641: invokevirtual 600	com/tencent/mm/g/b/a/ae:fz	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/ae;
    //   644: pop
    //   645: aload_0
    //   646: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   649: ldc2_w 601
    //   652: putfield 426	com/tencent/mm/g/b/a/ae:cUc	J
    //   655: aload_0
    //   656: aload_0
    //   657: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   660: getfield 605	com/tencent/mm/g/b/a/ae:cUe	Ljava/lang/String;
    //   663: ldc_w 552
    //   666: invokevirtual 611	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   669: putfield 300	com/tencent/mm/plugin/expt/roomexpt/a:mcE	[Ljava/lang/String;
    //   672: getstatic 290	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   675: sipush 869
    //   678: bipush 22
    //   680: invokevirtual 294	com/tencent/mm/plugin/report/service/h:cT	(II)V
    //   683: aload_0
    //   684: invokespecial 347	com/tencent/mm/plugin/expt/roomexpt/a:bsV	()V
    //   687: aload_0
    //   688: iconst_0
    //   689: putfield 94	com/tencent/mm/plugin/expt/roomexpt/a:mcF	Z
    //   692: aload_0
    //   693: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   696: invokevirtual 342	com/tencent/mm/g/b/a/ae:Fg	()Ljava/lang/String;
    //   699: astore 11
    //   701: aload_0
    //   702: getfield 300	com/tencent/mm/plugin/expt/roomexpt/a:mcE	[Ljava/lang/String;
    //   705: ifnull +129 -> 834
    //   708: aload_0
    //   709: getfield 300	com/tencent/mm/plugin/expt/roomexpt/a:mcE	[Ljava/lang/String;
    //   712: invokestatic 616	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   715: astore 9
    //   717: ldc 203
    //   719: ldc_w 618
    //   722: iconst_3
    //   723: anewarray 4	java/lang/Object
    //   726: dup
    //   727: iconst_0
    //   728: aload 11
    //   730: aastore
    //   731: dup
    //   732: iconst_1
    //   733: aload 9
    //   735: aastore
    //   736: dup
    //   737: iconst_2
    //   738: lload 7
    //   740: invokestatic 622	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   743: invokestatic 481	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   746: aastore
    //   747: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   750: aload 10
    //   752: ifnull +10 -> 762
    //   755: aload 10
    //   757: invokeinterface 594 1 0
    //   762: ldc_w 485
    //   765: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   768: aload 12
    //   770: areturn
    //   771: aload_0
    //   772: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   775: ldc2_w 473
    //   778: putfield 426	com/tencent/mm/g/b/a/ae:cUc	J
    //   781: aload_0
    //   782: getfield 118	com/tencent/mm/plugin/expt/roomexpt/a:mcD	Lcom/tencent/mm/g/b/a/ae;
    //   785: ldc_w 624
    //   788: invokevirtual 600	com/tencent/mm/g/b/a/ae:fz	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/ae;
    //   791: pop
    //   792: aload_0
    //   793: aconst_null
    //   794: putfield 300	com/tencent/mm/plugin/expt/roomexpt/a:mcE	[Ljava/lang/String;
    //   797: getstatic 290	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   800: sipush 869
    //   803: bipush 23
    //   805: invokevirtual 294	com/tencent/mm/plugin/report/service/h:cT	(II)V
    //   808: goto -125 -> 683
    //   811: astore 9
    //   813: aload 10
    //   815: ifnull +10 -> 825
    //   818: aload 10
    //   820: invokeinterface 594 1 0
    //   825: ldc_w 485
    //   828: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   831: aload 9
    //   833: athrow
    //   834: ldc_w 626
    //   837: astore 9
    //   839: goto -122 -> 717
    //   842: astore 9
    //   844: aconst_null
    //   845: astore 10
    //   847: goto -34 -> 813
    //   850: astore 11
    //   852: aload 9
    //   854: astore 10
    //   856: aload 11
    //   858: astore 9
    //   860: goto -47 -> 813
    //   863: astore 10
    //   865: aconst_null
    //   866: astore 9
    //   868: goto -283 -> 585
    //   871: fconst_0
    //   872: fstore_1
    //   873: goto -568 -> 305
    //   876: fconst_0
    //   877: fstore_2
    //   878: goto -599 -> 279
    //   881: iload_3
    //   882: iconst_1
    //   883: iadd
    //   884: istore_3
    //   885: aload 11
    //   887: astore 9
    //   889: goto -553 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	892	0	this	a
    //   245	628	1	f1	float
    //   247	631	2	f2	float
    //   1	884	3	i	int
    //   331	170	4	j	int
    //   488	11	5	k	int
    //   108	34	6	bool	boolean
    //   203	536	7	l	long
    //   87	647	9	localObject1	Object
    //   811	21	9	localObject2	Object
    //   837	1	9	str1	String
    //   842	11	9	localObject3	Object
    //   858	30	9	localObject4	Object
    //   92	763	10	localObject5	Object
    //   863	1	10	localException1	Exception
    //   357	168	11	localObject6	Object
    //   575	7	11	localException2	Exception
    //   699	30	11	str2	String
    //   850	36	11	localObject7	Object
    //   237	532	12	localArrayList	java.util.ArrayList
    //   318	220	13	localObject8	Object
    //   353	211	14	localc	c
    // Exception table:
    //   from	to	target	type
    //   230	239	575	java/lang/Exception
    //   248	277	575	java/lang/Exception
    //   279	305	575	java/lang/Exception
    //   305	333	575	java/lang/Exception
    //   342	355	575	java/lang/Exception
    //   359	369	575	java/lang/Exception
    //   374	391	575	java/lang/Exception
    //   391	443	575	java/lang/Exception
    //   450	545	575	java/lang/Exception
    //   552	572	575	java/lang/Exception
    //   632	683	575	java/lang/Exception
    //   683	717	575	java/lang/Exception
    //   717	750	575	java/lang/Exception
    //   771	808	575	java/lang/Exception
    //   230	239	811	finally
    //   248	277	811	finally
    //   279	305	811	finally
    //   305	333	811	finally
    //   342	355	811	finally
    //   359	369	811	finally
    //   374	391	811	finally
    //   391	443	811	finally
    //   450	545	811	finally
    //   552	572	811	finally
    //   632	683	811	finally
    //   683	717	811	finally
    //   717	750	811	finally
    //   771	808	811	finally
    //   210	230	842	finally
    //   585	599	850	finally
    //   210	230	863	java/lang/Exception
  }
  
  protected final void bsX()
  {
    AppMethodBeat.i(73574);
    b localb = this.mcC;
    try
    {
      localb.db.delete("RoomMuteExpt", null, null);
      bsY();
      AppMethodBeat.o(73574);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ChatRoomExptStorage", localException, "deleteAll", new Object[0]);
      }
    }
  }
  
  protected final void bsY()
  {
    AppMethodBeat.i(73575);
    if (this.mcD != null)
    {
      this.mcD = new ae();
      this.mcD.cUf = true;
      bsV();
    }
    this.mcE = null;
    AppMethodBeat.o(73575);
  }
  
  protected final String bsZ()
  {
    AppMethodBeat.i(73576);
    if (this.mcD != null)
    {
      String str = this.mcD.Fg();
      AppMethodBeat.o(73576);
      return str;
    }
    AppMethodBeat.o(73576);
    return "";
  }
  
  public final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(73567);
    com.tencent.mm.sdk.g.d.post(new a.1(this, paramBoolean), "click_room_mute_msg");
    AppMethodBeat.o(73567);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(73570);
    if (this.mcD == null)
    {
      paramc = (String)g.RL().Ru().get(ac.a.yKg, "");
      if (!bo.isNullOrNil(paramc)) {
        break label118;
      }
      this.mcD = new ae();
      this.mcD.cUf = false;
    }
    for (;;)
    {
      ab.i("MicroMsg.ChatRoomExptService", "load expt roomnameList[%s] info[%s]", new Object[] { this.mcE, this.mcD.Fg() });
      paramc = (i)g.E(i.class);
      if (paramc != null) {
        paramc.a(this.mcH);
      }
      AppMethodBeat.o(73570);
      return;
      label118:
      this.mcD = new ae(paramc);
      if (!bo.isNullOrNil(this.mcD.cUe)) {
        this.mcE = this.mcD.cUe.split(";");
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(152438);
    this.mcD = null;
    this.mcC = null;
    i locali = (i)g.E(i.class);
    if (locali != null) {
      locali.b(this.mcH);
    }
    AppMethodBeat.o(152438);
  }
  
  public final void t(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(73566);
    paramIntent.setClass(paramContext, RoomExptDebugUI.class);
    paramContext.startActivity(paramIntent);
    AppMethodBeat.o(73566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a
 * JD-Core Version:    0.7.0.1
 */