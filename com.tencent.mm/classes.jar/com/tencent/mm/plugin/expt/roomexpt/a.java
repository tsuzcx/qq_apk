package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.text.SimpleDateFormat;

public final class a
  implements c, d
{
  private static final float[] pIO = { 0.0F, 0.3F, 0.45F, 0.55F, 0.67F, 0.75F, 0.85F, 1.0F };
  private static final float[] pIP = { 0.0F, 0.0F, 0.0F, 0.0F, 0.1F, 0.2F, 0.3F, 0.4F };
  private static final float[] pIQ = { 0.0F, 0.1F, 0.2F, 0.3F, 0.4F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 1.0F };
  private static final int[] pIR = { 15, 35, 83, 140, 209, 297, 417, 599, 926, 1720 };
  private static final float[] pIS = { 0.0F, 0.3F, 0.5F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private static final float[] pIT = { 0.0F, 0.3F, 0.45F, 0.55F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private static final float[] pIU = { 0.1F, 0.2F, 0.3F, 0.4F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 1.0F };
  private static final int[] pIV = { 2400, 7500, 13000, 21500, 41000, 65000, 116000, 215000, 455000 };
  private static final float[] pIW = { 0.0F, 0.35F, 0.5F, 0.6F, 0.7F, 0.7F, 0.8F, 0.8F, 0.8F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 1.0F };
  private static a pIY;
  private SimpleDateFormat pIX;
  public b pIZ;
  private bv pJa;
  private String[] pJb;
  private boolean pJc;
  int pJd;
  private w pJe;
  
  public a()
  {
    AppMethodBeat.i(122400);
    this.pIX = null;
    this.pJc = false;
    this.pJd = 0;
    this.pJe = new a.5(this);
    AppMethodBeat.o(122400);
  }
  
  private static float a(float[] paramArrayOfFloat, int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(122409);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0))
    {
      AppMethodBeat.o(122409);
      return 0.0F;
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(122409);
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
      AppMethodBeat.o(122409);
      return f;
      i += 1;
      break;
      i = j - 1;
    }
  }
  
  private static float b(float[] paramArrayOfFloat, int paramInt)
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
  
  public static a cem()
  {
    AppMethodBeat.i(122401);
    if (pIY == null) {
      pIY = new a();
    }
    a locala = pIY;
    AppMethodBeat.o(122401);
    return locala;
  }
  
  private void cen()
  {
    AppMethodBeat.i(122402);
    if (this.pJa == null)
    {
      AppMethodBeat.o(122402);
      return;
    }
    String str = this.pJa.PV();
    g.afB().afk().set(ae.a.Ftr, str);
    ad.i("MicroMsg.ChatRoomExptService", "save expt info[%s]", new Object[] { this.pJa.PW() });
    AppMethodBeat.o(122402);
  }
  
  private static float d(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(122410);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(122410);
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
        f2 = b(pIP, paramInt1);
        f1 = f2;
        f2 = (paramFloat / paramInt1 + paramFloat / 7.0F) / 2.0F - f2;
        f1 = f2;
        ad.d("MicroMsg.ChatRoomExptService", "calc finish score result[%f] day[%d] isMute[%d] score[%f]", new Object[] { Float.valueOf(f2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat) });
        f1 = f2;
      }
      catch (Exception localException)
      {
        float f2;
        label123:
        ad.e("MicroMsg.ChatRoomExptService", "calc finish score error[%s]", new Object[] { localException.toString() });
        continue;
      }
      AppMethodBeat.o(122410);
      return f1;
      i = 0;
      break;
      f2 = b(pIO, paramInt1);
      f2 += (paramFloat / paramInt1 + paramFloat / 7.0F) / 2.0F;
    }
  }
  
  public final void a(final String paramString1, final String paramString2, final long paramLong, final int paramInt1, int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(122406);
    com.tencent.mm.plugin.expt.a.b localb = (com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class);
    b.a locala = b.a.piK;
    boolean bool;
    int i;
    if (this.pJa != null)
    {
      bool = this.pJa.dQm;
      if (localb.a(locala, bool)) {
        break label73;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label234;
      }
      AppMethodBeat.o(122406);
      return;
      bool = false;
      break;
      label73:
      h.vKh.dB(869, 1);
      long l = this.pJa.dQj;
      if (l >= 3L)
      {
        ad.d("MicroMsg.ChatRoomExptService", "room expt already finish");
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
          this.pJa.dQj = l;
          if (l < 3L) {
            break label199;
          }
          ad.d("MicroMsg.ChatRoomExptService", "user already enter mute room and unmute room, don't expt");
          h.vKh.dB(869, 2);
          cen();
          i = 0;
          break;
          i = 0;
          break label125;
        }
        label199:
        if (i != 0)
        {
          if (this.pJa.dQk <= 0L) {
            this.pJa.Qz();
          }
          cen();
        }
        i = 1;
      }
    }
    label234:
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122397);
        long l1 = bt.GC();
        long l2 = bt.aGK();
        String str1;
        boolean bool1;
        e locale;
        Object localObject;
        label102:
        int i;
        if (a.a(a.this).dQk <= 0L)
        {
          a.a(a.this).Qz();
          a.c(a.this);
          str1 = a.e(a.this);
          bool1 = a.v(paramLong, paramString1);
          locale = a.f(a.this).fE(paramInt1, str1);
          String str2 = paramInt1;
          if (locale == null) {
            break label360;
          }
          localObject = locale;
          ad.i("MicroMsg.ChatRoomExptService", "get db [%s %s] item [%s]", new Object[] { str2, str1, localObject });
          if (locale == null) {
            break label382;
          }
          locale.field_sendCount += paramString1;
          locale.field_unReadCount += paramBoolean;
          int j = locale.field_disRedDotCount;
          if (!bool1) {
            break label367;
          }
          i = 1;
          label176:
          locale.field_disRedDotCount = (i + j);
          j = locale.field_enterCount;
          if (!bool1) {
            break label372;
          }
          i = 0;
          label197:
          locale.field_enterCount = (i + j);
          locale.field_stayTime += paramLong;
          if (!paramString2) {
            break label377;
          }
          i = 1;
          label229:
          locale.field_isMute = i;
          bool1 = true;
          a.a(locale);
          if (!bool1) {
            break label505;
          }
        }
        label360:
        label367:
        label372:
        label500:
        label505:
        for (boolean bool2 = a.f(a.this).c(locale);; bool2 = a.f(a.this).b(locale))
        {
          if (!bool2) {
            h.vKh.dB(869, 32);
          }
          ad.i("MicroMsg.ChatRoomExptService", "noteroominfo isUpdate[%b] dbOpRet[%b] cost[%d] item[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(bt.aS(l1)), locale });
          AppMethodBeat.o(122397);
          return;
          if (l2 - a.a(a.this).dQk < 604800L) {
            break;
          }
          a.d(a.this);
          AppMethodBeat.o(122397);
          return;
          localObject = "null";
          break label102;
          i = 0;
          break label176;
          i = 1;
          break label197;
          label377:
          i = 0;
          break label229;
          label382:
          locale = new e();
          locale.field_chatroom = paramInt1;
          locale.field_nickname = this.pJk;
          locale.field_daySec = str1;
          locale.field_sendCount = paramString1;
          if (paramString2)
          {
            i = 1;
            locale.field_isMute = i;
            locale.field_unReadCount = paramBoolean;
            if (!bool1) {
              break label495;
            }
            i = 1;
            locale.field_disRedDotCount = i;
            if (!bool1) {
              break label500;
            }
          }
          for (i = 0;; i = 1)
          {
            locale.field_enterCount = i;
            locale.field_stayTime = paramLong;
            bool1 = false;
            break;
            i = 0;
            break label434;
            i = 0;
            break label456;
          }
        }
      }
    });
    AppMethodBeat.o(122406);
  }
  
  public final void aS(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(122405);
    ad.d("MicroMsg.ChatRoomExptService", "enter chat room [%s] isMute[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (this.pJd > 0)
    {
      this.pJd -= 1;
      g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(122395);
          a.aT(paramString, paramBoolean);
          AppMethodBeat.o(122395);
        }
      });
      AppMethodBeat.o(122405);
      return;
    }
    if ((this.pJb == null) || (this.pJb.length <= 0))
    {
      ad.d("MicroMsg.ChatRoomExptService", "roomname list is null");
      AppMethodBeat.o(122405);
      return;
    }
    if (this.pJa == null)
    {
      AppMethodBeat.o(122405);
      return;
    }
    if (this.pJa.dQj >= 5L)
    {
      ad.d("MicroMsg.ChatRoomExptService", "exptInfo is finish [%d]", new Object[] { Long.valueOf(this.pJa.dQj) });
      AppMethodBeat.o(122405);
      return;
    }
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(122396);
        com.tencent.mm.plugin.expt.a.b localb = (com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class);
        b.a locala = b.a.piK;
        if (a.a(a.this) != null) {}
        for (boolean bool = a.a(a.this).dQm; !localb.a(locala, bool); bool = false)
        {
          AppMethodBeat.o(122396);
          return;
        }
        int j = Math.min(a.b(a.this).length, 5);
        while (i < j)
        {
          if (paramString.equals(a.b(a.this)[i]))
          {
            a.aT(paramString, paramBoolean);
            a.a(a.this).dQj = 6L;
            a.a(a.this).ix("");
            a.c(a.this);
            AppMethodBeat.o(122396);
            return;
          }
          i += 1;
        }
        AppMethodBeat.o(122396);
      }
    });
    AppMethodBeat.o(122405);
  }
  
  /* Error */
  final java.util.List<c> ceo()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 495
    //   5: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 216
    //   17: ldc_w 497
    //   20: invokestatic 500	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 495
    //   26: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_0
    //   32: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   35: getfield 439	com/tencent/mm/g/b/a/bv:dQj	J
    //   38: ldc2_w 440
    //   41: lcmp
    //   42: iflt +36 -> 78
    //   45: ldc 216
    //   47: ldc_w 502
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   60: getfield 439	com/tencent/mm/g/b/a/bv:dQj	J
    //   63: invokestatic 493	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   66: aastore
    //   67: invokestatic 360	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: ldc_w 495
    //   73: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aconst_null
    //   77: areturn
    //   78: ldc_w 420
    //   81: invokestatic 424	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   84: checkcast 420	com/tencent/mm/plugin/expt/a/b
    //   87: astore 9
    //   89: getstatic 430	com/tencent/mm/plugin/expt/a/b$a:piK	Lcom/tencent/mm/plugin/expt/a/b$a;
    //   92: astore 10
    //   94: aload_0
    //   95: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   98: ifnull +42 -> 140
    //   101: aload_0
    //   102: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   105: getfield 433	com/tencent/mm/g/b/a/bv:dQm	Z
    //   108: istore 6
    //   110: aload 9
    //   112: aload 10
    //   114: iload 6
    //   116: invokeinterface 436 3 0
    //   121: ifne +25 -> 146
    //   124: ldc 216
    //   126: ldc_w 504
    //   129: invokestatic 506	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: ldc_w 495
    //   135: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aconst_null
    //   139: areturn
    //   140: iconst_0
    //   141: istore 6
    //   143: goto -33 -> 110
    //   146: aload_0
    //   147: getfield 312	com/tencent/mm/plugin/expt/roomexpt/a:pJb	[Ljava/lang/String;
    //   150: ifnull +27 -> 177
    //   153: aload_0
    //   154: getfield 312	com/tencent/mm/plugin/expt/roomexpt/a:pJb	[Ljava/lang/String;
    //   157: arraylength
    //   158: ifle +19 -> 177
    //   161: ldc 216
    //   163: ldc_w 508
    //   166: invokestatic 506	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: ldc_w 495
    //   172: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aconst_null
    //   176: areturn
    //   177: aload_0
    //   178: getfield 100	com/tencent/mm/plugin/expt/roomexpt/a:pJc	Z
    //   181: ifeq +19 -> 200
    //   184: ldc 216
    //   186: ldc_w 510
    //   189: invokestatic 446	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: ldc_w 495
    //   195: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aconst_null
    //   199: areturn
    //   200: invokestatic 513	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   203: lstore 7
    //   205: aload_0
    //   206: iconst_1
    //   207: putfield 100	com/tencent/mm/plugin/expt/roomexpt/a:pJc	Z
    //   210: getstatic 303	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   213: sipush 869
    //   216: bipush 21
    //   218: invokevirtual 307	com/tencent/mm/plugin/report/service/h:dB	(II)V
    //   221: aload_0
    //   222: getfield 412	com/tencent/mm/plugin/expt/roomexpt/a:pIZ	Lcom/tencent/mm/plugin/expt/roomexpt/b;
    //   225: invokevirtual 519	com/tencent/mm/plugin/expt/roomexpt/b:ces	()Landroid/database/Cursor;
    //   228: astore 10
    //   230: new 521	java/util/ArrayList
    //   233: dup
    //   234: invokespecial 522	java/util/ArrayList:<init>	()V
    //   237: astore 12
    //   239: aload 10
    //   241: ifnull +652 -> 893
    //   244: fconst_0
    //   245: fstore_1
    //   246: fload_1
    //   247: fstore_2
    //   248: aload 10
    //   250: invokeinterface 527 1 0
    //   255: ifeq +24 -> 279
    //   258: aload 10
    //   260: invokeinterface 531 1 0
    //   265: iconst_5
    //   266: if_icmpge +201 -> 467
    //   269: ldc 216
    //   271: ldc_w 533
    //   274: invokestatic 500	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: fload_1
    //   278: fstore_2
    //   279: aload 12
    //   281: invokestatic 539	java/util/Collections:sort	(Ljava/util/List;)V
    //   284: aload 12
    //   286: invokeinterface 544 1 0
    //   291: ifle +597 -> 888
    //   294: fload_2
    //   295: aload 12
    //   297: invokeinterface 544 1 0
    //   302: i2f
    //   303: fdiv
    //   304: fstore_1
    //   305: fload_1
    //   306: fconst_0
    //   307: invokestatic 548	java/lang/Math:max	(FF)F
    //   310: fstore_1
    //   311: new 550	com/tencent/mm/g/b/a/k
    //   314: dup
    //   315: invokespecial 551	com/tencent/mm/g/b/a/k:<init>	()V
    //   318: astore 13
    //   320: aload 12
    //   322: invokeinterface 544 1 0
    //   327: iconst_5
    //   328: invokestatic 121	java/lang/Math:min	(II)I
    //   331: istore 4
    //   333: aconst_null
    //   334: astore 9
    //   336: iload_3
    //   337: iload 4
    //   339: if_icmpge +305 -> 644
    //   342: aload 12
    //   344: iload_3
    //   345: invokeinterface 555 2 0
    //   350: checkcast 557	com/tencent/mm/plugin/expt/roomexpt/c
    //   353: astore 14
    //   355: aload 9
    //   357: astore 11
    //   359: aload 14
    //   361: getfield 560	com/tencent/mm/plugin/expt/roomexpt/c:score	F
    //   364: fload_1
    //   365: fcmpl
    //   366: ifle +532 -> 898
    //   369: aload 9
    //   371: ifnull +198 -> 569
    //   374: aload 9
    //   376: ldc_w 562
    //   379: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   382: aload 14
    //   384: getfield 565	com/tencent/mm/plugin/expt/roomexpt/c:dec	Ljava/lang/String;
    //   387: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   390: pop
    //   391: aload 13
    //   393: aload 13
    //   395: ldc 161
    //   397: aload 14
    //   399: getfield 565	com/tencent/mm/plugin/expt/roomexpt/c:dec	Ljava/lang/String;
    //   402: iconst_1
    //   403: invokevirtual 566	com/tencent/mm/g/b/a/k:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   406: putfield 567	com/tencent/mm/g/b/a/k:dHu	Ljava/lang/String;
    //   409: aload 13
    //   411: aload 13
    //   413: ldc_w 569
    //   416: new 198	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   423: aload 14
    //   425: getfield 560	com/tencent/mm/plugin/expt/roomexpt/c:score	F
    //   428: invokevirtual 203	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   431: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: iconst_1
    //   435: invokevirtual 566	com/tencent/mm/g/b/a/k:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   438: putfield 572	com/tencent/mm/g/b/a/k:dHv	Ljava/lang/String;
    //   441: aload 13
    //   443: aload_0
    //   444: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   447: getfield 439	com/tencent/mm/g/b/a/bv:dQj	J
    //   450: l2i
    //   451: putfield 575	com/tencent/mm/g/b/a/k:dHw	I
    //   454: aload 13
    //   456: invokevirtual 576	com/tencent/mm/g/b/a/k:aBj	()Z
    //   459: pop
    //   460: aload 9
    //   462: astore 11
    //   464: goto +434 -> 898
    //   467: aload 10
    //   469: iconst_0
    //   470: invokeinterface 577 2 0
    //   475: astore 9
    //   477: aload 10
    //   479: iconst_1
    //   480: invokeinterface 577 2 0
    //   485: astore 11
    //   487: aload 10
    //   489: iconst_2
    //   490: invokeinterface 581 2 0
    //   495: istore 4
    //   497: aload 10
    //   499: iconst_3
    //   500: invokeinterface 581 2 0
    //   505: istore 5
    //   507: aload 10
    //   509: iconst_4
    //   510: invokeinterface 585 2 0
    //   515: iload 5
    //   517: iload 4
    //   519: invokestatic 587	com/tencent/mm/plugin/expt/roomexpt/a:d	(FII)F
    //   522: fstore_2
    //   523: new 557	com/tencent/mm/plugin/expt/roomexpt/c
    //   526: dup
    //   527: invokespecial 588	com/tencent/mm/plugin/expt/roomexpt/c:<init>	()V
    //   530: astore 13
    //   532: aload 13
    //   534: aload 9
    //   536: putfield 565	com/tencent/mm/plugin/expt/roomexpt/c:dec	Ljava/lang/String;
    //   539: aload 13
    //   541: aload 11
    //   543: putfield 591	com/tencent/mm/plugin/expt/roomexpt/c:nickname	Ljava/lang/String;
    //   546: aload 13
    //   548: fload_2
    //   549: putfield 560	com/tencent/mm/plugin/expt/roomexpt/c:score	F
    //   552: aload 12
    //   554: aload 13
    //   556: invokeinterface 595 2 0
    //   561: pop
    //   562: fload_1
    //   563: fload_2
    //   564: fadd
    //   565: fstore_1
    //   566: goto -320 -> 246
    //   569: new 244	java/lang/StringBuffer
    //   572: dup
    //   573: invokespecial 245	java/lang/StringBuffer:<init>	()V
    //   576: astore 9
    //   578: aload 9
    //   580: aload 14
    //   582: getfield 565	com/tencent/mm/plugin/expt/roomexpt/c:dec	Ljava/lang/String;
    //   585: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   588: pop
    //   589: goto -198 -> 391
    //   592: astore 11
    //   594: aload 10
    //   596: astore 9
    //   598: aload 11
    //   600: astore 10
    //   602: ldc 216
    //   604: aload 10
    //   606: ldc_w 597
    //   609: iconst_0
    //   610: anewarray 4	java/lang/Object
    //   613: invokestatic 601	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   616: aload 9
    //   618: ifnull +10 -> 628
    //   621: aload 9
    //   623: invokeinterface 604 1 0
    //   628: ldc 216
    //   630: ldc_w 606
    //   633: invokestatic 500	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: ldc_w 495
    //   639: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   642: aconst_null
    //   643: areturn
    //   644: aload 9
    //   646: ifnull +142 -> 788
    //   649: aload_0
    //   650: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   653: aload 9
    //   655: invokevirtual 290	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   658: invokevirtual 610	com/tencent/mm/g/b/a/bv:ix	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/bv;
    //   661: pop
    //   662: aload_0
    //   663: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   666: ldc2_w 611
    //   669: putfield 439	com/tencent/mm/g/b/a/bv:dQj	J
    //   672: aload_0
    //   673: aload_0
    //   674: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   677: getfield 615	com/tencent/mm/g/b/a/bv:dQl	Ljava/lang/String;
    //   680: ldc_w 562
    //   683: invokevirtual 621	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   686: putfield 312	com/tencent/mm/plugin/expt/roomexpt/a:pJb	[Ljava/lang/String;
    //   689: getstatic 303	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   692: sipush 869
    //   695: bipush 22
    //   697: invokevirtual 307	com/tencent/mm/plugin/report/service/h:dB	(II)V
    //   700: aload_0
    //   701: invokespecial 317	com/tencent/mm/plugin/expt/roomexpt/a:cen	()V
    //   704: aload_0
    //   705: iconst_0
    //   706: putfield 100	com/tencent/mm/plugin/expt/roomexpt/a:pJc	Z
    //   709: aload_0
    //   710: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   713: invokevirtual 358	com/tencent/mm/g/b/a/bv:PW	()Ljava/lang/String;
    //   716: astore 11
    //   718: aload_0
    //   719: getfield 312	com/tencent/mm/plugin/expt/roomexpt/a:pJb	[Ljava/lang/String;
    //   722: ifnull +129 -> 851
    //   725: aload_0
    //   726: getfield 312	com/tencent/mm/plugin/expt/roomexpt/a:pJb	[Ljava/lang/String;
    //   729: invokestatic 626	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   732: astore 9
    //   734: ldc 216
    //   736: ldc_w 628
    //   739: iconst_3
    //   740: anewarray 4	java/lang/Object
    //   743: dup
    //   744: iconst_0
    //   745: aload 11
    //   747: aastore
    //   748: dup
    //   749: iconst_1
    //   750: aload 9
    //   752: aastore
    //   753: dup
    //   754: iconst_2
    //   755: lload 7
    //   757: invokestatic 631	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   760: invokestatic 493	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   763: aastore
    //   764: invokestatic 360	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   767: aload 10
    //   769: ifnull +10 -> 779
    //   772: aload 10
    //   774: invokeinterface 604 1 0
    //   779: ldc_w 495
    //   782: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   785: aload 12
    //   787: areturn
    //   788: aload_0
    //   789: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   792: ldc2_w 485
    //   795: putfield 439	com/tencent/mm/g/b/a/bv:dQj	J
    //   798: aload_0
    //   799: getfield 124	com/tencent/mm/plugin/expt/roomexpt/a:pJa	Lcom/tencent/mm/g/b/a/bv;
    //   802: ldc_w 633
    //   805: invokevirtual 610	com/tencent/mm/g/b/a/bv:ix	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/bv;
    //   808: pop
    //   809: aload_0
    //   810: aconst_null
    //   811: putfield 312	com/tencent/mm/plugin/expt/roomexpt/a:pJb	[Ljava/lang/String;
    //   814: getstatic 303	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   817: sipush 869
    //   820: bipush 23
    //   822: invokevirtual 307	com/tencent/mm/plugin/report/service/h:dB	(II)V
    //   825: goto -125 -> 700
    //   828: astore 9
    //   830: aload 10
    //   832: ifnull +10 -> 842
    //   835: aload 10
    //   837: invokeinterface 604 1 0
    //   842: ldc_w 495
    //   845: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   848: aload 9
    //   850: athrow
    //   851: ldc_w 635
    //   854: astore 9
    //   856: goto -122 -> 734
    //   859: astore 9
    //   861: aconst_null
    //   862: astore 10
    //   864: goto -34 -> 830
    //   867: astore 11
    //   869: aload 9
    //   871: astore 10
    //   873: aload 11
    //   875: astore 9
    //   877: goto -47 -> 830
    //   880: astore 10
    //   882: aconst_null
    //   883: astore 9
    //   885: goto -283 -> 602
    //   888: fconst_0
    //   889: fstore_1
    //   890: goto -585 -> 305
    //   893: fconst_0
    //   894: fstore_2
    //   895: goto -616 -> 279
    //   898: iload_3
    //   899: iconst_1
    //   900: iadd
    //   901: istore_3
    //   902: aload 11
    //   904: astore 9
    //   906: goto -570 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	909	0	this	a
    //   245	645	1	f1	float
    //   247	648	2	f2	float
    //   1	901	3	i	int
    //   331	187	4	j	int
    //   505	11	5	k	int
    //   108	34	6	bool	boolean
    //   203	553	7	l	long
    //   87	664	9	localObject1	Object
    //   828	21	9	localObject2	Object
    //   854	1	9	str1	String
    //   859	11	9	localObject3	Object
    //   875	30	9	localObject4	Object
    //   92	780	10	localObject5	Object
    //   880	1	10	localException1	Exception
    //   357	185	11	localObject6	Object
    //   592	7	11	localException2	Exception
    //   716	30	11	str2	String
    //   867	36	11	localObject7	Object
    //   237	549	12	localArrayList	java.util.ArrayList
    //   318	237	13	localObject8	Object
    //   353	228	14	localc	c
    // Exception table:
    //   from	to	target	type
    //   230	239	592	java/lang/Exception
    //   248	277	592	java/lang/Exception
    //   279	305	592	java/lang/Exception
    //   305	333	592	java/lang/Exception
    //   342	355	592	java/lang/Exception
    //   359	369	592	java/lang/Exception
    //   374	391	592	java/lang/Exception
    //   391	460	592	java/lang/Exception
    //   467	562	592	java/lang/Exception
    //   569	589	592	java/lang/Exception
    //   649	700	592	java/lang/Exception
    //   700	734	592	java/lang/Exception
    //   734	767	592	java/lang/Exception
    //   788	825	592	java/lang/Exception
    //   230	239	828	finally
    //   248	277	828	finally
    //   279	305	828	finally
    //   305	333	828	finally
    //   342	355	828	finally
    //   359	369	828	finally
    //   374	391	828	finally
    //   391	460	828	finally
    //   467	562	828	finally
    //   569	589	828	finally
    //   649	700	828	finally
    //   700	734	828	finally
    //   734	767	828	finally
    //   788	825	828	finally
    //   210	230	859	finally
    //   602	616	867	finally
    //   210	230	880	java/lang/Exception
  }
  
  protected final void cep()
  {
    AppMethodBeat.i(122412);
    b localb = this.pIZ;
    try
    {
      localb.db.delete("RoomMuteExpt", null, null);
      ceq();
      AppMethodBeat.o(122412);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ChatRoomExptStorage", localException, "deleteAll", new Object[0]);
      }
    }
  }
  
  protected final void ceq()
  {
    AppMethodBeat.i(122413);
    if (this.pJa != null)
    {
      this.pJa = new bv();
      this.pJa.dQm = true;
      cen();
    }
    this.pJb = null;
    AppMethodBeat.o(122413);
  }
  
  protected final String cer()
  {
    AppMethodBeat.i(122414);
    if (this.pJa != null)
    {
      String str = this.pJa.PW();
      AppMethodBeat.o(122414);
      return str;
    }
    AppMethodBeat.o(122414);
    return "";
  }
  
  public final void km(final boolean paramBoolean)
  {
    AppMethodBeat.i(122404);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122394);
        h localh = h.vKh;
        if (paramBoolean) {}
        for (int i = 13;; i = 12)
        {
          localh.dB(869, i);
          AppMethodBeat.o(122394);
          return;
        }
      }
    }, "click_room_mute_msg");
    AppMethodBeat.o(122404);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(122407);
    if (this.pJa == null)
    {
      paramc = (String)g.afB().afk().get(ae.a.Ftr, "");
      if (!bt.isNullOrNil(paramc)) {
        break label118;
      }
      this.pJa = new bv();
      this.pJa.dQm = false;
    }
    for (;;)
    {
      ad.i("MicroMsg.ChatRoomExptService", "load expt roomnameList[%s] info[%s]", new Object[] { this.pJb, this.pJa.PW() });
      paramc = (j)g.ab(j.class);
      if (paramc != null) {
        paramc.addSyncDoCmdCallback(this.pJe);
      }
      AppMethodBeat.o(122407);
      return;
      label118:
      this.pJa = new bv(paramc);
      if (!bt.isNullOrNil(this.pJa.dQl)) {
        this.pJb = this.pJa.dQl.split(";");
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(122408);
    this.pJa = null;
    this.pIZ = null;
    j localj = (j)g.ab(j.class);
    if (localj != null) {
      localj.removeSyncDoCmdCallback(this.pJe);
    }
    AppMethodBeat.o(122408);
  }
  
  public final void s(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(122403);
    paramIntent.setClass(paramContext, RoomExptDebugUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/expt/roomexpt/ChatRoomExptService", "showDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/expt/roomexpt/ChatRoomExptService", "showDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(122403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a
 * JD-Core Version:    0.7.0.1
 */