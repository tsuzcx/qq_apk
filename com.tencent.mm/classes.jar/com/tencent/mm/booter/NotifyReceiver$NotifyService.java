package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.b;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;

public class NotifyReceiver$NotifyService
  extends MMService
{
  Boolean dZm = null;
  private com.tencent.mm.kernel.api.g dZn;
  
  private static void A(Context paramContext, String paramString)
  {
    AppMethodBeat.i(57797);
    synchronized (NotifyReceiver.access$400())
    {
      if (NotifyReceiver.Iq() == null) {
        NotifyReceiver.b(new WakerLock(paramContext, "MicroMsg.NotifyReceiver"));
      }
      NotifyReceiver.Iq().lock(60000L, paramString);
      AppMethodBeat.o(57797);
      return;
    }
  }
  
  private static void by(Context paramContext)
  {
    AppMethodBeat.i(57800);
    ab.i("MicroMsg.NotifyReceiver", "dealWithLooper");
    if ((!com.tencent.mm.kernel.g.RG()) || (com.tencent.mm.kernel.a.QP()))
    {
      ab.w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + com.tencent.mm.kernel.g.RG() + " isHold:" + com.tencent.mm.kernel.a.QP());
      AppMethodBeat.o(57800);
      return;
    }
    if ((com.tencent.mm.kernel.g.Rc().foreground) || (!ac.cl(paramContext)))
    {
      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.b.class)).aio().lL(2);
      AppMethodBeat.o(57800);
      return;
    }
    com.tencent.mm.kernel.g.Rc().a(new com.tencent.mm.modelmulti.i(), 0);
    AppMethodBeat.o(57800);
  }
  
  public static void kv(String paramString)
  {
    AppMethodBeat.i(57795);
    synchronized (NotifyReceiver.Io())
    {
      if (NotifyReceiver.Ip() == null) {
        NotifyReceiver.a(new WakerLock(ah.getContext(), "MicroMsg.NotifyReceiver"));
      }
      NotifyReceiver.Ip().lock(5000L, paramString);
      AppMethodBeat.o(57795);
      return;
    }
  }
  
  private void o(Intent paramIntent)
  {
    AppMethodBeat.i(57792);
    if (paramIntent == null)
    {
      ab.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
      AppMethodBeat.o(57792);
      return;
    }
    if (!com.tencent.mm.kernel.g.RM().eIn.eIH)
    {
      ab.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", new Object[] { Integer.valueOf(0) });
      if (this.dZn != null) {
        com.tencent.mm.kernel.g.RM().b(this.dZn);
      }
      this.dZn = new NotifyReceiver.NotifyService.1(this, System.currentTimeMillis(), paramIntent);
      com.tencent.mm.kernel.g.RM().a(this.dZn);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 213L, 1L, false);
    }
    for (int i = -1;; i = 0)
    {
      if (i < 0)
      {
        ab.e("MicroMsg.NotifyReceiver", "summerboot status %s", new Object[] { Integer.valueOf(-1) });
        AppMethodBeat.o(57792);
        return;
      }
      p(paramIntent);
      AppMethodBeat.o(57792);
      return;
    }
  }
  
  private void p(Intent paramIntent)
  {
    AppMethodBeat.i(57793);
    int i = paramIntent.getIntExtra("notify_option_type", 0);
    if (i == 0)
    {
      ab.e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
      AppMethodBeat.o(57793);
      return;
    }
    if ((!com.tencent.mm.kernel.g.RG()) || (com.tencent.mm.kernel.a.QP()))
    {
      ab.e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.RG()), Boolean.valueOf(com.tencent.mm.kernel.a.QP()), Integer.valueOf(i) });
      AppMethodBeat.o(57793);
      return;
    }
    if (com.tencent.mm.kernel.g.Rc().ftA == null)
    {
      ab.w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.Rc().cO(true);
    }
    if (this.dZm == null) {
      if (!com.tencent.mm.sdk.a.b.dsf()) {
        break label213;
      }
    }
    label336:
    for (;;)
    {
      for (boolean bool = false;; bool = true)
      {
        this.dZm = Boolean.valueOf(bool);
        ab.i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", new Object[] { this.dZm, Integer.valueOf(i) });
        switch (i)
        {
        default: 
          ab.e("MicroMsg.NotifyReceiver", "invald opCode:".concat(String.valueOf(i)));
          AppMethodBeat.o(57793);
          return;
          label213:
          int j = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("AndroidOldNotifyReceiver"), 0);
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RJ();
          if (j <= com.tencent.mm.a.i.bQ(com.tencent.mm.kernel.a.getUin(), 100)) {
            break label336;
          }
        }
      }
      if (this.dZm.booleanValue()) {
        z(ah.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
      }
      by(ah.getContext());
      AppMethodBeat.o(57793);
      return;
      if (this.dZm.booleanValue())
      {
        z(ah.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
        r(paramIntent);
        AppMethodBeat.o(57793);
        return;
      }
      q(paramIntent);
      AppMethodBeat.o(57793);
      return;
    }
  }
  
  private void q(Intent paramIntent)
  {
    AppMethodBeat.i(57798);
    int k = paramIntent.getIntExtra("notify_respType", 0);
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("notify_respBuf");
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("notify_skey");
    long l = paramIntent.getLongExtra("notfiy_recv_time", -1L);
    int i;
    if (arrayOfByte1 == null)
    {
      i = -1;
      if (arrayOfByte2 != null) {
        break label166;
      }
    }
    label166:
    for (int j = -1;; j = arrayOfByte2.length)
    {
      ab.i("MicroMsg.NotifyReceiver", "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ", new Object[] { Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
      if ((!bo.ce(arrayOfByte2)) || (k == 3941)) {
        break label173;
      }
      ab.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session null and ret sessionKey:" + arrayOfByte2 + " respType:" + k);
      AppMethodBeat.o(57798);
      return;
      i = arrayOfByte1.length;
      break;
    }
    switch (k)
    {
    default: 
      ((PluginZero)com.tencent.mm.kernel.g.G(PluginZero.class)).vJa.a(this, k, arrayOfByte1, arrayOfByte2, l);
      AppMethodBeat.o(57798);
      return;
    case 268369921: 
      if ((bo.ce(arrayOfByte1)) || (arrayOfByte1.length <= 8))
      {
        ab.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
        AppMethodBeat.o(57798);
        return;
      }
      i = com.tencent.mm.a.o.r(arrayOfByte1, 0);
      j = com.tencent.mm.a.o.r(arrayOfByte1, 4);
      if (j != arrayOfByte1.length - 8)
      {
        ab.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + arrayOfByte1.length);
        AppMethodBeat.o(57798);
        return;
      }
      paramIntent = new byte[j];
      System.arraycopy(arrayOfByte1, 8, paramIntent, 0, j);
      ab.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(arrayOfByte1.length), Long.valueOf(l) });
      k.b(i, paramIntent, arrayOfByte2, l);
      AppMethodBeat.o(57798);
      return;
    case 138: 
      if (arrayOfByte1 == null)
      {
        i = 7;
        if (arrayOfByte1 != null) {
          break label511;
        }
        j = 2;
        if (arrayOfByte1 != null) {
          break label516;
        }
      }
      for (k = -1;; k = arrayOfByte1.length)
      {
        ab.i("MicroMsg.NotifyReceiver", "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.b.class)).aio().a(i, j, "");
        AppMethodBeat.o(57798);
        return;
        i = com.tencent.mm.a.o.r(arrayOfByte1, 0);
        break;
        j = 1;
        break label429;
      }
    case 2147480001: 
      ab.i("MicroMsg.NotifyReceiver", "dkpush FCM Notify");
      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.b.class)).aio().a(7L, 16, "");
      AppMethodBeat.o(57798);
      return;
    case 1000000205: 
      label173:
      label429:
      label511:
      paramIntent = new StringBuilder("oreh on newsynccheck2 notify, notify=");
      label516:
      if (arrayOfByte1 != null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.NotifyReceiver", bool);
        paramIntent = new y.b();
        ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.b.class)).aio().a(paramIntent.wiX, 1, paramIntent.dqD());
        AppMethodBeat.o(57798);
        return;
      }
    }
    com.tencent.mm.kernel.g.Rc().a(new com.tencent.mm.modelmulti.i(), 0);
    AppMethodBeat.o(57798);
  }
  
  /* Error */
  private void r(Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 429
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 331
    //   10: iconst_0
    //   11: invokevirtual 237	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   14: istore_3
    //   15: aload_1
    //   16: ldc_w 333
    //   19: invokevirtual 337	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   22: astore 8
    //   24: aload_1
    //   25: ldc_w 339
    //   28: invokevirtual 337	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   31: astore 9
    //   33: aload_1
    //   34: ldc_w 341
    //   37: ldc2_w 342
    //   40: invokevirtual 347	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   43: lstore 5
    //   45: aload 8
    //   47: ifnonnull +131 -> 178
    //   50: iconst_m1
    //   51: istore_2
    //   52: ldc 39
    //   54: ldc_w 349
    //   57: iconst_4
    //   58: anewarray 187	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: iload_3
    //   64: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: lload 5
    //   72: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   75: aastore
    //   76: dup
    //   77: iconst_2
    //   78: iload_2
    //   79: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: dup
    //   84: iconst_3
    //   85: aload 9
    //   87: invokestatic 433	com/tencent/mm/sdk/platformtools/bo:cg	([B)Ljava/lang/String;
    //   90: invokestatic 436	com/tencent/mm/sdk/platformtools/bo:aqg	(Ljava/lang/String;)Ljava/lang/String;
    //   93: aastore
    //   94: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: iload_3
    //   98: lookupswitch	default:+50->148, 39:+749->847, 138:+341->439, 268369921:+87->185, 1000000205:+538->636, 2147480001:+771->869
    //   149: aconst_null
    //   150: frem
    //   151: invokestatic 374	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   154: checkcast 370	com/tencent/mm/plugin/zero/PluginZero
    //   157: getfield 378	com/tencent/mm/plugin/zero/PluginZero:vJa	Lcom/tencent/mm/plugin/zero/PluginZero$b;
    //   160: aload_0
    //   161: iload_3
    //   162: aload 8
    //   164: aload 9
    //   166: lload 5
    //   168: invokevirtual 383	com/tencent/mm/plugin/zero/PluginZero$b:a	(Lcom/tencent/mm/booter/NotifyReceiver$NotifyService;I[B[BJ)V
    //   171: ldc_w 429
    //   174: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: aload 8
    //   180: arraylength
    //   181: istore_2
    //   182: goto -130 -> 52
    //   185: aload 9
    //   187: invokestatic 358	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   190: ifeq +26 -> 216
    //   193: ldc 39
    //   195: ldc_w 438
    //   198: aload 9
    //   200: invokestatic 441	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   203: invokevirtual 278	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokestatic 170	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: ldc_w 429
    //   212: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: return
    //   216: aload 8
    //   218: invokestatic 358	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   221: ifne +11 -> 232
    //   224: aload 8
    //   226: arraylength
    //   227: bipush 8
    //   229: if_icmpgt +18 -> 247
    //   232: ldc 39
    //   234: ldc_w 385
    //   237: invokestatic 170	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: ldc_w 429
    //   243: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: return
    //   247: aload 8
    //   249: iconst_0
    //   250: invokestatic 390	com/tencent/mm/a/o:r	([BI)I
    //   253: istore_2
    //   254: aload 8
    //   256: iconst_4
    //   257: invokestatic 390	com/tencent/mm/a/o:r	([BI)I
    //   260: istore_3
    //   261: iload_3
    //   262: aload 8
    //   264: arraylength
    //   265: bipush 8
    //   267: isub
    //   268: if_icmpeq +34 -> 302
    //   271: ldc 39
    //   273: new 87	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 392
    //   280: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload 8
    //   285: arraylength
    //   286: invokevirtual 368	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 170	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: ldc_w 429
    //   298: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: return
    //   302: iload_3
    //   303: newarray byte
    //   305: astore_1
    //   306: aload 8
    //   308: bipush 8
    //   310: aload_1
    //   311: iconst_0
    //   312: iload_3
    //   313: invokestatic 396	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   316: ldc 39
    //   318: ldc_w 398
    //   321: iconst_4
    //   322: anewarray 187	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: iload_2
    //   328: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: aastore
    //   332: dup
    //   333: iconst_1
    //   334: iload_3
    //   335: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: aastore
    //   339: dup
    //   340: iconst_2
    //   341: aload 8
    //   343: arraylength
    //   344: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: dup
    //   349: iconst_3
    //   350: lload 5
    //   352: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   355: aastore
    //   356: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   362: invokeinterface 449 1 0
    //   367: iload_2
    //   368: aload_1
    //   369: aload 9
    //   371: lload 5
    //   373: invokestatic 403	com/tencent/mm/modelmulti/k:b	(I[B[BJ)V
    //   376: invokestatic 453	com/tencent/mm/booter/NotifyReceiver:Is	()Ljava/util/Set;
    //   379: lload 5
    //   381: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   384: invokeinterface 459 2 0
    //   389: pop
    //   390: invokestatic 160	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   393: ldc_w 461
    //   396: invokestatic 463	com/tencent/mm/booter/NotifyReceiver$NotifyService:A	(Landroid/content/Context;Ljava/lang/String;)V
    //   399: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   402: invokeinterface 466 1 0
    //   407: ldc_w 429
    //   410: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: return
    //   414: astore_1
    //   415: ldc_w 429
    //   418: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    //   422: astore_1
    //   423: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   426: invokeinterface 466 1 0
    //   431: ldc_w 429
    //   434: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: aload_1
    //   438: athrow
    //   439: aload 8
    //   441: ifnonnull +147 -> 588
    //   444: bipush 7
    //   446: istore_2
    //   447: aload 8
    //   449: ifnonnull +149 -> 598
    //   452: iconst_2
    //   453: istore_3
    //   454: aload 8
    //   456: ifnonnull +147 -> 603
    //   459: iconst_m1
    //   460: istore 4
    //   462: ldc 39
    //   464: ldc_w 405
    //   467: iconst_3
    //   468: anewarray 187	java/lang/Object
    //   471: dup
    //   472: iconst_0
    //   473: iload_2
    //   474: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   477: aastore
    //   478: dup
    //   479: iconst_1
    //   480: iload_3
    //   481: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: aastore
    //   485: dup
    //   486: iconst_2
    //   487: iload 4
    //   489: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: invokestatic 469	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   499: invokeinterface 449 1 0
    //   504: ldc 126
    //   506: invokestatic 130	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   509: checkcast 126	com/tencent/mm/plugin/zero/b/b
    //   512: invokeinterface 134 1 0
    //   517: iload_2
    //   518: i2l
    //   519: iload_3
    //   520: ldc_w 407
    //   523: invokevirtual 410	com/tencent/mm/modelmulti/o:a	(JILjava/lang/String;)I
    //   526: istore_2
    //   527: iload_2
    //   528: ifle +45 -> 573
    //   531: ldc 39
    //   533: ldc_w 471
    //   536: iconst_1
    //   537: anewarray 187	java/lang/Object
    //   540: dup
    //   541: iconst_0
    //   542: iload_2
    //   543: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: invokestatic 469	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: invokestatic 453	com/tencent/mm/booter/NotifyReceiver:Is	()Ljava/util/Set;
    //   553: iload_2
    //   554: i2l
    //   555: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   558: invokeinterface 459 2 0
    //   563: pop
    //   564: invokestatic 160	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   567: ldc_w 473
    //   570: invokestatic 463	com/tencent/mm/booter/NotifyReceiver$NotifyService:A	(Landroid/content/Context;Ljava/lang/String;)V
    //   573: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   576: invokeinterface 466 1 0
    //   581: ldc_w 429
    //   584: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   587: return
    //   588: aload 8
    //   590: iconst_0
    //   591: invokestatic 390	com/tencent/mm/a/o:r	([BI)I
    //   594: istore_2
    //   595: goto -148 -> 447
    //   598: iconst_1
    //   599: istore_3
    //   600: goto -146 -> 454
    //   603: aload 8
    //   605: arraylength
    //   606: istore 4
    //   608: goto -146 -> 462
    //   611: astore_1
    //   612: ldc_w 429
    //   615: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   618: return
    //   619: astore_1
    //   620: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   623: invokeinterface 466 1 0
    //   628: ldc_w 429
    //   631: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   634: aload_1
    //   635: athrow
    //   636: new 87	java/lang/StringBuilder
    //   639: dup
    //   640: ldc_w 416
    //   643: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   646: astore_1
    //   647: aload 8
    //   649: ifnull +130 -> 779
    //   652: iconst_1
    //   653: istore 7
    //   655: ldc 39
    //   657: aload_1
    //   658: iload 7
    //   660: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   663: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 475	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: new 418	com/tencent/mm/protocal/y$b
    //   672: dup
    //   673: invokespecial 419	com/tencent/mm/protocal/y$b:<init>	()V
    //   676: astore_1
    //   677: aload_1
    //   678: aload 8
    //   680: invokevirtual 479	com/tencent/mm/protocal/y$b:fromProtoBuf	([B)I
    //   683: pop
    //   684: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   687: invokeinterface 449 1 0
    //   692: ldc 126
    //   694: invokestatic 130	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   697: checkcast 126	com/tencent/mm/plugin/zero/b/b
    //   700: invokeinterface 134 1 0
    //   705: aload_1
    //   706: getfield 423	com/tencent/mm/protocal/y$b:wiX	J
    //   709: iconst_1
    //   710: aload_1
    //   711: invokevirtual 426	com/tencent/mm/protocal/y$b:dqD	()Ljava/lang/String;
    //   714: invokevirtual 410	com/tencent/mm/modelmulti/o:a	(JILjava/lang/String;)I
    //   717: istore_2
    //   718: iload_2
    //   719: ifle +45 -> 764
    //   722: ldc 39
    //   724: ldc_w 471
    //   727: iconst_1
    //   728: anewarray 187	java/lang/Object
    //   731: dup
    //   732: iconst_0
    //   733: iload_2
    //   734: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   737: aastore
    //   738: invokestatic 469	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   741: invokestatic 453	com/tencent/mm/booter/NotifyReceiver:Is	()Ljava/util/Set;
    //   744: iload_2
    //   745: i2l
    //   746: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   749: invokeinterface 459 2 0
    //   754: pop
    //   755: invokestatic 160	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   758: ldc_w 481
    //   761: invokestatic 463	com/tencent/mm/booter/NotifyReceiver$NotifyService:A	(Landroid/content/Context;Ljava/lang/String;)V
    //   764: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   767: invokeinterface 466 1 0
    //   772: ldc_w 429
    //   775: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   778: return
    //   779: iconst_0
    //   780: istore 7
    //   782: goto -127 -> 655
    //   785: astore_1
    //   786: ldc_w 429
    //   789: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   792: return
    //   793: astore_1
    //   794: ldc 39
    //   796: aload_1
    //   797: ldc_w 407
    //   800: iconst_0
    //   801: anewarray 187	java/lang/Object
    //   804: invokestatic 485	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   807: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   810: invokeinterface 466 1 0
    //   815: ldc_w 429
    //   818: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   821: return
    //   822: astore_1
    //   823: ldc_w 429
    //   826: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   829: return
    //   830: astore_1
    //   831: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   834: invokeinterface 466 1 0
    //   839: ldc_w 429
    //   842: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   845: aload_1
    //   846: athrow
    //   847: invokestatic 112	com/tencent/mm/kernel/g:Rc	()Lcom/tencent/mm/ai/p;
    //   850: new 142	com/tencent/mm/modelmulti/i
    //   853: dup
    //   854: invokespecial 143	com/tencent/mm/modelmulti/i:<init>	()V
    //   857: iconst_0
    //   858: invokevirtual 146	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;I)Z
    //   861: pop
    //   862: ldc_w 429
    //   865: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   868: return
    //   869: ldc 39
    //   871: ldc_w 412
    //   874: invokestatic 475	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: ldc 126
    //   879: invokestatic 130	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   882: checkcast 126	com/tencent/mm/plugin/zero/b/b
    //   885: invokeinterface 134 1 0
    //   890: ldc2_w 413
    //   893: bipush 16
    //   895: ldc_w 407
    //   898: invokevirtual 410	com/tencent/mm/modelmulti/o:a	(JILjava/lang/String;)I
    //   901: istore_2
    //   902: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   905: invokeinterface 449 1 0
    //   910: iload_2
    //   911: ifle +45 -> 956
    //   914: ldc 39
    //   916: ldc_w 471
    //   919: iconst_1
    //   920: anewarray 187	java/lang/Object
    //   923: dup
    //   924: iconst_0
    //   925: iload_2
    //   926: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   929: aastore
    //   930: invokestatic 469	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   933: invokestatic 453	com/tencent/mm/booter/NotifyReceiver:Is	()Ljava/util/Set;
    //   936: iload_2
    //   937: i2l
    //   938: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   941: invokeinterface 459 2 0
    //   946: pop
    //   947: invokestatic 160	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   950: ldc_w 487
    //   953: invokestatic 463	com/tencent/mm/booter/NotifyReceiver$NotifyService:A	(Landroid/content/Context;Ljava/lang/String;)V
    //   956: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   959: invokeinterface 466 1 0
    //   964: ldc_w 429
    //   967: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   970: return
    //   971: astore_1
    //   972: ldc_w 429
    //   975: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   978: return
    //   979: astore_1
    //   980: invokestatic 445	com/tencent/mm/booter/NotifyReceiver:Ir	()Ljava/util/concurrent/locks/Lock;
    //   983: invokeinterface 466 1 0
    //   988: ldc_w 429
    //   991: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   994: aload_1
    //   995: athrow
    //   996: astore 8
    //   998: goto -10 -> 988
    //   1001: astore 8
    //   1003: goto -164 -> 839
    //   1006: astore 8
    //   1008: goto -380 -> 628
    //   1011: astore 8
    //   1013: goto -582 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1016	0	this	NotifyService
    //   0	1016	1	paramIntent	Intent
    //   51	886	2	i	int
    //   14	586	3	j	int
    //   460	147	4	k	int
    //   43	337	5	l	long
    //   653	128	7	bool	boolean
    //   22	657	8	arrayOfByte1	byte[]
    //   996	1	8	localException1	java.lang.Exception
    //   1001	1	8	localException2	java.lang.Exception
    //   1006	1	8	localException3	java.lang.Exception
    //   1011	1	8	localException4	java.lang.Exception
    //   31	339	9	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   399	407	414	java/lang/Exception
    //   359	399	422	finally
    //   573	581	611	java/lang/Exception
    //   496	527	619	finally
    //   531	573	619	finally
    //   764	772	785	java/lang/Exception
    //   677	718	793	java/lang/Exception
    //   722	764	793	java/lang/Exception
    //   807	815	822	java/lang/Exception
    //   677	718	830	finally
    //   722	764	830	finally
    //   794	807	830	finally
    //   956	964	971	java/lang/Exception
    //   902	910	979	finally
    //   914	956	979	finally
    //   980	988	996	java/lang/Exception
    //   831	839	1001	java/lang/Exception
    //   620	628	1006	java/lang/Exception
    //   423	431	1011	java/lang/Exception
  }
  
  private static void z(Context paramContext, String paramString)
  {
    AppMethodBeat.i(57796);
    synchronized (NotifyReceiver.Io())
    {
      if (NotifyReceiver.Ip() == null) {
        NotifyReceiver.a(new WakerLock(paramContext, "MicroMsg.NotifyReceiver"));
      }
      NotifyReceiver.Ip().lock(14000L, paramString);
      AppMethodBeat.o(57796);
      return;
    }
  }
  
  public final IBinder It()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.NotifyReceiver";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(57794);
    super.onCreate();
    AppMethodBeat.o(57794);
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(57790);
    o(paramIntent);
    AppMethodBeat.o(57790);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57791);
    ab.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + paramInt1 + "startId :" + paramInt2 + " intent " + paramIntent);
    o(paramIntent);
    AppMethodBeat.o(57791);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.NotifyService
 * JD-Core Version:    0.7.0.1
 */