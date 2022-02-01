package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.n.f;
import com.tencent.mm.network.af;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.b;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;
import com.tencent.mm.service.ProcessService.MMProcessService;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver
  extends BroadcastReceiver
{
  private static WakerLock glE;
  private static Set<Long> glF;
  private static Lock glG;
  private static byte[] glH;
  private static byte[] glI;
  private static a glJ;
  private static boolean glK;
  private static final long[] glL;
  private static final int[] glM;
  private static final int[] glN;
  private static WakerLock gll;
  
  static
  {
    AppMethodBeat.i(131927);
    gll = null;
    glE = null;
    glF = new HashSet();
    glG = new ReentrantLock(false);
    glH = new byte[0];
    glI = new byte[0];
    glK = true;
    glL = new long[] { 0L, 1L, 2L, 4L, 6L, 8L, 10L, 20L, 50L, 100L, 200L, 500L, 1000L, 2000L, 3000L, 4000L, 5000L, 7000L, 10000L, 20000L, 30000L };
    glM = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
    glN = new int[] { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 };
    AppMethodBeat.o(131927);
  }
  
  private static void a(Context paramContext, Intent paramIntent, boolean paramBoolean, ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(131925);
    if (paramIntent == null)
    {
      AppMethodBeat.o(131925);
      return;
    }
    if (com.tencent.mm.kernel.l.cK(paramContext))
    {
      Log.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
      AppMethodBeat.o(131925);
      return;
    }
    long l4 = paramIntent.getLongExtra("notfiy_recv_time", -1L);
    long l1 = paramIntent.getLongExtra("notfiy_sync_num", 0L);
    long l2 = Util.nowMilliSecond() - l4;
    long l3 = CoreService.yK(l1);
    if (l3 < 1L)
    {
      if (l3 == 0L)
      {
        l4 = MultiProcessMMKV.getMMKV("msg_receive_report").getLong("use_time", 0L);
        long l5 = l2 - l4;
        Log.i("MicroMsg.NotifyReceiver", "handleIntent syncNum:%s has handled(result:%s fromBroadcast:%s diff:%s newUseTime:%s oldUseTime:%s)", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Boolean.valueOf(paramBoolean), Long.valueOf(l5), Long.valueOf(l2), Long.valueOf(l4) });
        int i = glL.length - 1;
        while (i >= 0)
        {
          if (l5 > glL[i])
          {
            paramContext = new IDKey();
            paramContext.SetID(1042);
            if (paramBoolean) {
              paramContext.SetKey(glN[i]);
            }
            for (;;)
            {
              paramContext.SetValue(1L);
              paramArrayList.add(paramContext);
              AppMethodBeat.o(131925);
              return;
              paramContext.SetKey(glM[i]);
            }
          }
          i -= 1;
        }
        AppMethodBeat.o(131925);
        return;
      }
      Log.i("MicroMsg.NotifyReceiver", "handleIntent syncNum:%s has handled(result:%s fromBroadcast:%s useTime:%s)", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Boolean.valueOf(paramBoolean), Long.valueOf(l2) });
      paramContext = new IDKey();
      paramContext.SetID(1042);
      if (paramBoolean) {
        paramContext.SetKey(59);
      }
      for (;;)
      {
        paramContext.SetValue(1L);
        paramArrayList.add(paramContext);
        AppMethodBeat.o(131925);
        return;
        paramContext.SetKey(29);
      }
    }
    MultiProcessMMKV.getMMKV("msg_receive_report").edit().putLong("use_time", l2);
    paramContext = new Intent(paramContext, NotifyService.class);
    if (paramIntent.getBooleanExtra("intent_from_shoot_key", false)) {
      paramContext.putExtra("notify_option_type", 3);
    }
    paramContext.putExtras(paramIntent);
    com.tencent.mm.service.c.a(paramContext, "mm", true, new Intent(MMApplicationContext.getContext(), ProcessService.MMProcessService.class));
    com.tencent.mm.ap.a.B(paramIntent.getIntExtra("notify_respType", -1), paramIntent.getLongExtra("notfiy_sync_num", 0L));
    Log.i("MicroMsg.NotifyReceiver", "syncNum:%s fromBroadcast:%s diff:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(paramBoolean), Long.valueOf(Util.nowMilliSecond() - l4) });
    AppMethodBeat.o(131925);
  }
  
  public static void akD()
  {
    AppMethodBeat.i(131921);
    akE();
    AppMethodBeat.o(131921);
  }
  
  public static void akE()
  {
    AppMethodBeat.i(131922);
    Log.i("MicroMsg.NotifyReceiver", "quitLightPushMode");
    glK = false;
    af.bke().edit().putBoolean("is_in_notify_mode", false).commit();
    AppMethodBeat.o(131922);
  }
  
  public static void akF()
  {
    AppMethodBeat.i(131923);
    com.tencent.mm.kernel.g.azz().b(138, glJ);
    com.tencent.mm.kernel.g.azz().b(39, glJ);
    com.tencent.mm.kernel.g.azz().b(268369922, glJ);
    if (glJ == null) {
      glJ = new a();
    }
    com.tencent.mm.kernel.g.azz().a(138, glJ);
    com.tencent.mm.kernel.g.azz().a(39, glJ);
    com.tencent.mm.kernel.g.azz().a(268369922, glJ);
    AppMethodBeat.o(131923);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131924);
    Log.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", new Object[] { paramIntent });
    final ArrayList localArrayList = new ArrayList();
    a(paramContext, paramIntent, true, localArrayList);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196981);
        IDKey localIDKey = new IDKey();
        localIDKey.SetID(1042);
        localIDKey.SetKey(61);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
        com.tencent.mm.plugin.report.e.Cxv.b(localArrayList, false);
        AppMethodBeat.o(196981);
      }
    }, "MicroMsg.NotifyReceiver");
    AppMethodBeat.o(131924);
  }
  
  public static class NotifyReceiverService
    extends MMService
  {
    public final void onCreate()
    {
      AppMethodBeat.i(131904);
      super.onCreate();
      Log.i("MicroMsg.NotifyReceiverService", "onCreate()");
      AppMethodBeat.o(131904);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(131906);
      super.onDestroy();
      AppMethodBeat.o(131906);
    }
    
    public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(131905);
      ArrayList localArrayList = new ArrayList();
      NotifyReceiver.a(MMApplicationContext.getContext(), paramIntent, localArrayList);
      com.tencent.f.h.RTc.b(new NotifyReceiver.NotifyReceiverService.1(this, localArrayList), "MicroMsg.NotifyReceiverService");
      Log.i("MicroMsg.NotifyReceiverService", "onStartCommand()");
      AppMethodBeat.o(131905);
      return 1;
    }
  }
  
  public static class NotifyService
    extends MMService
  {
    Boolean glS = null;
    private com.tencent.mm.kernel.api.g glT;
    
    public static void CP(String paramString)
    {
      AppMethodBeat.i(131914);
      synchronized (NotifyReceiver.glH)
      {
        if (NotifyReceiver.akG() == null) {
          NotifyReceiver.a(new WakerLock(MMApplicationContext.getContext(), "MicroMsg.NotifyReceiver"));
        }
        NotifyReceiver.akG().lock(5000L, paramString);
        AppMethodBeat.o(131914);
        return;
      }
    }
    
    private static void cl(Context paramContext)
    {
      AppMethodBeat.i(131919);
      Log.i("MicroMsg.NotifyReceiver", "dealWithLooper");
      if ((!com.tencent.mm.kernel.g.aAc()) || (com.tencent.mm.kernel.a.azj()))
      {
        Log.w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + com.tencent.mm.kernel.g.aAc() + " isHold:" + com.tencent.mm.kernel.a.azj());
        AppMethodBeat.o(131919);
        return;
      }
      if ((com.tencent.mm.kernel.g.azz().foreground) || (!ag.dl(paramContext)))
      {
        ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.b.class)).bdS().tE(2);
        AppMethodBeat.o(131919);
        return;
      }
      com.tencent.mm.kernel.g.azz().a(new j(), 0);
      AppMethodBeat.o(131919);
    }
    
    private void o(Intent paramIntent)
    {
      AppMethodBeat.i(131911);
      if (paramIntent == null)
      {
        Log.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
        AppMethodBeat.o(131911);
        return;
      }
      if (!com.tencent.mm.kernel.g.aAi().hrh.hrB)
      {
        Log.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", new Object[] { Integer.valueOf(0) });
        if (this.glT != null) {
          com.tencent.mm.kernel.g.aAi().b(this.glT);
        }
        this.glT = new com.tencent.mm.kernel.api.g()
        {
          public final void WY()
          {
            AppMethodBeat.i(131908);
            com.tencent.mm.kernel.g.aAi().b(this);
            NotifyReceiver.NotifyService.a(NotifyReceiver.NotifyService.this);
            long l = System.currentTimeMillis() - this.cBb;
            Log.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.aAi().hrh.hrB), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            com.tencent.mm.plugin.report.e.Cxv.a(11098, new Object[] { Integer.valueOf(3600), Long.valueOf(l) });
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 214L, 1L, false);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131907);
                Log.i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
                NotifyReceiver.NotifyService.a(NotifyReceiver.NotifyService.this, NotifyReceiver.NotifyService.1.this.glU);
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 215L, 1L, false);
                AppMethodBeat.o(131907);
              }
            }, 500L);
            AppMethodBeat.o(131908);
          }
          
          public final void cQ(boolean paramAnonymousBoolean) {}
        };
        com.tencent.mm.kernel.g.aAi().a(this.glT);
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 213L, 1L, false);
      }
      for (int i = -1;; i = 0)
      {
        if (i < 0)
        {
          Log.e("MicroMsg.NotifyReceiver", "summerboot status %s", new Object[] { Integer.valueOf(-1) });
          AppMethodBeat.o(131911);
          return;
        }
        p(paramIntent);
        AppMethodBeat.o(131911);
        return;
      }
    }
    
    private void p(Intent paramIntent)
    {
      AppMethodBeat.i(131912);
      int i = paramIntent.getIntExtra("notify_option_type", 0);
      if (i == 0)
      {
        Log.e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
        AppMethodBeat.o(131912);
        return;
      }
      if ((!com.tencent.mm.kernel.g.aAc()) || (com.tencent.mm.kernel.a.azj()))
      {
        Log.e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.aAc()), Boolean.valueOf(com.tencent.mm.kernel.a.azj()), Integer.valueOf(i) });
        AppMethodBeat.o(131912);
        return;
      }
      if (com.tencent.mm.kernel.g.azz().iMw == null)
      {
        Log.w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.kernel.g.azz().fx(true);
      }
      if (this.glS == null) {
        if (!CrashReportFactory.hasDebuger()) {
          break label213;
        }
      }
      label336:
      for (;;)
      {
        for (boolean bool = false;; bool = true)
        {
          this.glS = Boolean.valueOf(bool);
          Log.i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", new Object[] { this.glS, Integer.valueOf(i) });
          switch (i)
          {
          default: 
            Log.e("MicroMsg.NotifyReceiver", "invald opCode:".concat(String.valueOf(i)));
            AppMethodBeat.o(131912);
            return;
            label213:
            int j = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("AndroidOldNotifyReceiver"), 0);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAf();
            if (j <= com.tencent.mm.b.i.ch(com.tencent.mm.kernel.a.getUin(), 100)) {
              break label336;
            }
          }
        }
        if (this.glS.booleanValue()) {
          x(MMApplicationContext.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
        }
        cl(MMApplicationContext.getContext());
        AppMethodBeat.o(131912);
        return;
        if (this.glS.booleanValue())
        {
          x(MMApplicationContext.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
          r(paramIntent);
          AppMethodBeat.o(131912);
          return;
        }
        q(paramIntent);
        AppMethodBeat.o(131912);
        return;
      }
    }
    
    private void q(Intent paramIntent)
    {
      AppMethodBeat.i(131917);
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
        Log.i("MicroMsg.NotifyReceiver", "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ", new Object[] { Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
        if ((!Util.isNullOrNil(arrayOfByte2)) || (k == 3941)) {
          break label173;
        }
        Log.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session null and ret sessionKey:" + arrayOfByte2 + " respType:" + k);
        AppMethodBeat.o(131917);
        return;
        i = arrayOfByte1.length;
        break;
      }
      switch (k)
      {
      default: 
        ((PluginZero)com.tencent.mm.kernel.g.ah(PluginZero.class)).UtS.a(this, k, arrayOfByte1, arrayOfByte2, l);
        AppMethodBeat.o(131917);
        return;
      case 268369921: 
        if ((Util.isNullOrNil(arrayOfByte1)) || (arrayOfByte1.length <= 8))
        {
          Log.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
          AppMethodBeat.o(131917);
          return;
        }
        i = o.v(arrayOfByte1, 0);
        j = o.v(arrayOfByte1, 4);
        if (j != arrayOfByte1.length - 8)
        {
          Log.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + arrayOfByte1.length);
          AppMethodBeat.o(131917);
          return;
        }
        paramIntent = new byte[j];
        System.arraycopy(arrayOfByte1, 8, paramIntent, 0, j);
        Log.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(arrayOfByte1.length), Long.valueOf(l) });
        com.tencent.mm.modelmulti.l.b(i, paramIntent, arrayOfByte2, l);
        AppMethodBeat.o(131917);
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
          Log.i("MicroMsg.NotifyReceiver", "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
          ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.b.class)).bdS().a(i, j, "");
          AppMethodBeat.o(131917);
          return;
          i = o.v(arrayOfByte1, 0);
          break;
          j = 1;
          break label429;
        }
      case 2147480001: 
        Log.i("MicroMsg.NotifyReceiver", "dkpush FCM Notify");
        ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.b.class)).bdS().a(7L, 16, "");
        AppMethodBeat.o(131917);
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
          Log.i("MicroMsg.NotifyReceiver", bool);
          paramIntent = new aa.b();
          ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.b.class)).bdS().a(paramIntent.KAs, 1, paramIntent.gtP());
          AppMethodBeat.o(131917);
          return;
        }
      }
      com.tencent.mm.kernel.g.azz().a(new j(), 0);
      AppMethodBeat.o(131917);
    }
    
    /* Error */
    private void r(Intent paramIntent)
    {
      // Byte code:
      //   0: ldc_w 420
      //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_1
      //   7: ldc_w 321
      //   10: iconst_0
      //   11: invokevirtual 227	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
      //   14: istore_3
      //   15: aload_1
      //   16: ldc_w 323
      //   19: invokevirtual 327	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
      //   22: astore 8
      //   24: aload_1
      //   25: ldc_w 329
      //   28: invokevirtual 327	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
      //   31: astore 9
      //   33: aload_1
      //   34: ldc_w 331
      //   37: ldc2_w 332
      //   40: invokevirtual 337	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
      //   43: lstore 5
      //   45: aload 8
      //   47: ifnonnull +131 -> 178
      //   50: iconst_m1
      //   51: istore_2
      //   52: ldc 49
      //   54: ldc_w 339
      //   57: iconst_4
      //   58: anewarray 178	java/lang/Object
      //   61: dup
      //   62: iconst_0
      //   63: iload_3
      //   64: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   67: aastore
      //   68: dup
      //   69: iconst_1
      //   70: lload 5
      //   72: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   75: aastore
      //   76: dup
      //   77: iconst_2
      //   78: iload_2
      //   79: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   82: aastore
      //   83: dup
      //   84: iconst_3
      //   85: aload 9
      //   87: invokestatic 424	com/tencent/mm/sdk/platformtools/Util:encodeHexString	([B)Ljava/lang/String;
      //   90: invokestatic 427	com/tencent/mm/sdk/platformtools/Util:secPrint	(Ljava/lang/String;)Ljava/lang/String;
      //   93: aastore
      //   94: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   97: iload_3
      //   98: lookupswitch	default:+50->148, 39:+749->847, 138:+341->439, 268369921:+87->185, 1000000205:+538->636, 2147480001:+771->869
      //   149: aconst_null
      //   150: imul
      //   151: invokestatic 364	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   154: checkcast 360	com/tencent/mm/plugin/zero/PluginZero
      //   157: getfield 368	com/tencent/mm/plugin/zero/PluginZero:UtS	Lcom/tencent/mm/plugin/zero/PluginZero$b;
      //   160: aload_0
      //   161: iload_3
      //   162: aload 8
      //   164: aload 9
      //   166: lload 5
      //   168: invokevirtual 373	com/tencent/mm/plugin/zero/PluginZero$b:a	(Lcom/tencent/mm/booter/NotifyReceiver$NotifyService;I[B[BJ)V
      //   171: ldc_w 420
      //   174: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: return
      //   178: aload 8
      //   180: arraylength
      //   181: istore_2
      //   182: goto -130 -> 52
      //   185: aload 9
      //   187: invokestatic 348	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
      //   190: ifeq +26 -> 216
      //   193: ldc 49
      //   195: ldc_w 429
      //   198: aload 9
      //   200: invokestatic 432	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   203: invokevirtual 268	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   206: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   209: ldc_w 420
      //   212: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   215: return
      //   216: aload 8
      //   218: invokestatic 348	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
      //   221: ifne +11 -> 232
      //   224: aload 8
      //   226: arraylength
      //   227: bipush 8
      //   229: if_icmpgt +18 -> 247
      //   232: ldc 49
      //   234: ldc_w 375
      //   237: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   240: ldc_w 420
      //   243: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   246: return
      //   247: aload 8
      //   249: iconst_0
      //   250: invokestatic 381	com/tencent/mm/b/o:v	([BI)I
      //   253: istore_2
      //   254: aload 8
      //   256: iconst_4
      //   257: invokestatic 381	com/tencent/mm/b/o:v	([BI)I
      //   260: istore_3
      //   261: iload_3
      //   262: aload 8
      //   264: arraylength
      //   265: bipush 8
      //   267: isub
      //   268: if_icmpeq +34 -> 302
      //   271: ldc 49
      //   273: new 97	java/lang/StringBuilder
      //   276: dup
      //   277: ldc_w 383
      //   280: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   283: aload 8
      //   285: arraylength
      //   286: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   289: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   292: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   295: ldc_w 420
      //   298: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   301: return
      //   302: iload_3
      //   303: newarray byte
      //   305: astore_1
      //   306: aload 8
      //   308: bipush 8
      //   310: aload_1
      //   311: iconst_0
      //   312: iload_3
      //   313: invokestatic 387	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   316: ldc 49
      //   318: ldc_w 389
      //   321: iconst_4
      //   322: anewarray 178	java/lang/Object
      //   325: dup
      //   326: iconst_0
      //   327: iload_2
      //   328: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   331: aastore
      //   332: dup
      //   333: iconst_1
      //   334: iload_3
      //   335: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   338: aastore
      //   339: dup
      //   340: iconst_2
      //   341: aload 8
      //   343: arraylength
      //   344: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   347: aastore
      //   348: dup
      //   349: iconst_3
      //   350: lload 5
      //   352: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   355: aastore
      //   356: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   359: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   362: invokeinterface 440 1 0
      //   367: iload_2
      //   368: aload_1
      //   369: aload 9
      //   371: lload 5
      //   373: invokestatic 394	com/tencent/mm/modelmulti/l:b	(I[B[BJ)V
      //   376: invokestatic 444	com/tencent/mm/booter/NotifyReceiver:akK	()Ljava/util/Set;
      //   379: lload 5
      //   381: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   384: invokeinterface 450 2 0
      //   389: pop
      //   390: invokestatic 47	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   393: ldc_w 452
      //   396: invokestatic 455	com/tencent/mm/booter/NotifyReceiver$NotifyService:y	(Landroid/content/Context;Ljava/lang/String;)V
      //   399: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   402: invokeinterface 458 1 0
      //   407: ldc_w 420
      //   410: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   413: return
      //   414: astore_1
      //   415: ldc_w 420
      //   418: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   421: return
      //   422: astore_1
      //   423: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   426: invokeinterface 458 1 0
      //   431: ldc_w 420
      //   434: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   462: ldc 49
      //   464: ldc_w 396
      //   467: iconst_3
      //   468: anewarray 178	java/lang/Object
      //   471: dup
      //   472: iconst_0
      //   473: iload_2
      //   474: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   477: aastore
      //   478: dup
      //   479: iconst_1
      //   480: iload_3
      //   481: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   484: aastore
      //   485: dup
      //   486: iconst_2
      //   487: iload 4
      //   489: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   492: aastore
      //   493: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   496: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   499: invokeinterface 440 1 0
      //   504: ldc 135
      //   506: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   509: checkcast 135	com/tencent/mm/plugin/zero/b/b
      //   512: invokeinterface 143 1 0
      //   517: iload_2
      //   518: i2l
      //   519: iload_3
      //   520: ldc_w 398
      //   523: invokevirtual 401	com/tencent/mm/modelmulti/q:a	(JILjava/lang/String;)I
      //   526: istore_2
      //   527: iload_2
      //   528: ifle +45 -> 573
      //   531: ldc 49
      //   533: ldc_w 463
      //   536: iconst_1
      //   537: anewarray 178	java/lang/Object
      //   540: dup
      //   541: iconst_0
      //   542: iload_2
      //   543: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   546: aastore
      //   547: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   550: invokestatic 444	com/tencent/mm/booter/NotifyReceiver:akK	()Ljava/util/Set;
      //   553: iload_2
      //   554: i2l
      //   555: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   558: invokeinterface 450 2 0
      //   563: pop
      //   564: invokestatic 47	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   567: ldc_w 465
      //   570: invokestatic 455	com/tencent/mm/booter/NotifyReceiver$NotifyService:y	(Landroid/content/Context;Ljava/lang/String;)V
      //   573: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   576: invokeinterface 458 1 0
      //   581: ldc_w 420
      //   584: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   587: return
      //   588: aload 8
      //   590: iconst_0
      //   591: invokestatic 381	com/tencent/mm/b/o:v	([BI)I
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
      //   612: ldc_w 420
      //   615: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   618: return
      //   619: astore_1
      //   620: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   623: invokeinterface 458 1 0
      //   628: ldc_w 420
      //   631: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   634: aload_1
      //   635: athrow
      //   636: new 97	java/lang/StringBuilder
      //   639: dup
      //   640: ldc_w 407
      //   643: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   646: astore_1
      //   647: aload 8
      //   649: ifnull +130 -> 779
      //   652: iconst_1
      //   653: istore 7
      //   655: ldc 49
      //   657: aload_1
      //   658: iload 7
      //   660: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   663: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   666: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   669: new 409	com/tencent/mm/protocal/aa$b
      //   672: dup
      //   673: invokespecial 410	com/tencent/mm/protocal/aa$b:<init>	()V
      //   676: astore_1
      //   677: aload_1
      //   678: aload 8
      //   680: invokevirtual 471	com/tencent/mm/protocal/aa$b:fromProtoBuf	([B)I
      //   683: pop
      //   684: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   687: invokeinterface 440 1 0
      //   692: ldc 135
      //   694: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   697: checkcast 135	com/tencent/mm/plugin/zero/b/b
      //   700: invokeinterface 143 1 0
      //   705: aload_1
      //   706: getfield 414	com/tencent/mm/protocal/aa$b:KAs	J
      //   709: iconst_1
      //   710: aload_1
      //   711: invokevirtual 417	com/tencent/mm/protocal/aa$b:gtP	()Ljava/lang/String;
      //   714: invokevirtual 401	com/tencent/mm/modelmulti/q:a	(JILjava/lang/String;)I
      //   717: istore_2
      //   718: iload_2
      //   719: ifle +45 -> 764
      //   722: ldc 49
      //   724: ldc_w 463
      //   727: iconst_1
      //   728: anewarray 178	java/lang/Object
      //   731: dup
      //   732: iconst_0
      //   733: iload_2
      //   734: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   737: aastore
      //   738: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   741: invokestatic 444	com/tencent/mm/booter/NotifyReceiver:akK	()Ljava/util/Set;
      //   744: iload_2
      //   745: i2l
      //   746: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   749: invokeinterface 450 2 0
      //   754: pop
      //   755: invokestatic 47	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   758: ldc_w 473
      //   761: invokestatic 455	com/tencent/mm/booter/NotifyReceiver$NotifyService:y	(Landroid/content/Context;Ljava/lang/String;)V
      //   764: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   767: invokeinterface 458 1 0
      //   772: ldc_w 420
      //   775: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   778: return
      //   779: iconst_0
      //   780: istore 7
      //   782: goto -127 -> 655
      //   785: astore_1
      //   786: ldc_w 420
      //   789: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   792: return
      //   793: astore_1
      //   794: ldc 49
      //   796: aload_1
      //   797: ldc_w 398
      //   800: iconst_0
      //   801: anewarray 178	java/lang/Object
      //   804: invokestatic 477	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   807: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   810: invokeinterface 458 1 0
      //   815: ldc_w 420
      //   818: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   821: return
      //   822: astore_1
      //   823: ldc_w 420
      //   826: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   829: return
      //   830: astore_1
      //   831: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   834: invokeinterface 458 1 0
      //   839: ldc_w 420
      //   842: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   845: aload_1
      //   846: athrow
      //   847: invokestatic 121	com/tencent/mm/kernel/g:azz	()Lcom/tencent/mm/ak/t;
      //   850: new 151	com/tencent/mm/modelmulti/j
      //   853: dup
      //   854: invokespecial 152	com/tencent/mm/modelmulti/j:<init>	()V
      //   857: iconst_0
      //   858: invokevirtual 155	com/tencent/mm/ak/t:a	(Lcom/tencent/mm/ak/q;I)Z
      //   861: pop
      //   862: ldc_w 420
      //   865: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   868: return
      //   869: ldc 49
      //   871: ldc_w 403
      //   874: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   877: ldc 135
      //   879: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   882: checkcast 135	com/tencent/mm/plugin/zero/b/b
      //   885: invokeinterface 143 1 0
      //   890: ldc2_w 404
      //   893: bipush 16
      //   895: ldc_w 398
      //   898: invokevirtual 401	com/tencent/mm/modelmulti/q:a	(JILjava/lang/String;)I
      //   901: istore_2
      //   902: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   905: invokeinterface 440 1 0
      //   910: iload_2
      //   911: ifle +45 -> 956
      //   914: ldc 49
      //   916: ldc_w 463
      //   919: iconst_1
      //   920: anewarray 178	java/lang/Object
      //   923: dup
      //   924: iconst_0
      //   925: iload_2
      //   926: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   929: aastore
      //   930: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   933: invokestatic 444	com/tencent/mm/booter/NotifyReceiver:akK	()Ljava/util/Set;
      //   936: iload_2
      //   937: i2l
      //   938: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   941: invokeinterface 450 2 0
      //   946: pop
      //   947: invokestatic 47	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   950: ldc_w 479
      //   953: invokestatic 455	com/tencent/mm/booter/NotifyReceiver$NotifyService:y	(Landroid/content/Context;Ljava/lang/String;)V
      //   956: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   959: invokeinterface 458 1 0
      //   964: ldc_w 420
      //   967: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   970: return
      //   971: astore_1
      //   972: ldc_w 420
      //   975: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   978: return
      //   979: astore_1
      //   980: invokestatic 436	com/tencent/mm/booter/NotifyReceiver:akJ	()Ljava/util/concurrent/locks/Lock;
      //   983: invokeinterface 458 1 0
      //   988: ldc_w 420
      //   991: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   996	1	8	localException1	Exception
      //   1001	1	8	localException2	Exception
      //   1006	1	8	localException3	Exception
      //   1011	1	8	localException4	Exception
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
    
    private static void x(Context paramContext, String paramString)
    {
      AppMethodBeat.i(131915);
      synchronized (NotifyReceiver.glH)
      {
        if (NotifyReceiver.akG() == null) {
          NotifyReceiver.a(new WakerLock(paramContext, "MicroMsg.NotifyReceiver"));
        }
        NotifyReceiver.akG().lock(14000L, paramString);
        AppMethodBeat.o(131915);
        return;
      }
    }
    
    private static void y(Context paramContext, String paramString)
    {
      AppMethodBeat.i(131916);
      synchronized (NotifyReceiver.akH())
      {
        if (NotifyReceiver.akI() == null) {
          NotifyReceiver.b(new WakerLock(paramContext, "MicroMsg.NotifyReceiver"));
        }
        NotifyReceiver.akI().lock(60000L, paramString);
        AppMethodBeat.o(131916);
        return;
      }
    }
    
    public final IBinder akL()
    {
      return null;
    }
    
    public final String getTag()
    {
      return "MicroMsg.NotifyReceiver";
    }
    
    public final void onCreate()
    {
      AppMethodBeat.i(131913);
      super.onCreate();
      AppMethodBeat.o(131913);
    }
    
    public final void onStart(Intent paramIntent, int paramInt)
    {
      AppMethodBeat.i(131909);
      o(paramIntent);
      AppMethodBeat.o(131909);
    }
    
    public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(131910);
      Log.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + paramInt1 + "startId :" + paramInt2 + " intent " + paramIntent);
      o(paramIntent);
      AppMethodBeat.o(131910);
      return 2;
    }
  }
  
  public static final class a
    implements com.tencent.mm.ak.i
  {
    private static long glP = 0L;
    
    private void yL(long paramLong)
    {
      AppMethodBeat.i(131901);
      if (!af.bke().getBoolean("is_in_notify_mode", false))
      {
        AppMethodBeat.o(131901);
        return;
      }
      new MMHandler(Looper.myLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131897);
          Log.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", new Object[] { Boolean.valueOf(NotifyReceiver.aau()) });
          synchronized (NotifyReceiver.glH)
          {
            if (NotifyReceiver.akG() != null) {
              NotifyReceiver.akG().unLock();
            }
            NotifyReceiver.a(null);
            if (NotifyReceiver.aau())
            {
              ??? = (PluginZero)com.tencent.mm.kernel.g.ah(PluginZero.class);
              if (((PluginZero)???).UtR != null) {
                ((PluginZero)???).UtR.ckp();
              }
              Log.appenderFlushSync();
              ??? = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject2 = new Object();
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)???).axQ(), "com/tencent/mm/booter/NotifyReceiver$NotifyIOnSceneEnd$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)???).pG(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/booter/NotifyReceiver$NotifyIOnSceneEnd$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
            AppMethodBeat.o(131897);
            return;
          }
        }
      }, paramLong);
      AppMethodBeat.o(131901);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(131900);
      long l = paramq.hashCode();
      if (paramq.getType() == 268369922) {
        l = ((com.tencent.mm.modelmulti.g)paramq).jcg;
      }
      for (;;)
      {
        try
        {
          NotifyReceiver.akJ().lock();
        }
        finally
        {
          try
          {
            int i;
            boolean bool2;
            boolean bool1;
            NotifyReceiver.akJ().unlock();
            try
            {
              NotifyReceiver.akJ().lock();
              if (!NotifyReceiver.akK().isEmpty()) {
                continue;
              }
              synchronized (NotifyReceiver.akH())
              {
                if (NotifyReceiver.akI() == null) {
                  continue;
                }
                NotifyReceiver.akI().unLock();
                Log.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
              }
            }
            finally
            {
              try
              {
                NotifyReceiver.akJ().unlock();
                switch (paramq.getType())
                {
                default: 
                  yL(7000L);
                  AppMethodBeat.o(131900);
                  return;
                  bool1 = false;
                  continue;
                  paramq = finally;
                  AppMethodBeat.o(131900);
                  throw paramq;
                  ??? = finally;
                }
              }
              catch (Exception ???)
              {
                try
                {
                  NotifyReceiver.akJ().unlock();
                  AppMethodBeat.o(131900);
                  throw ???;
                  paramq = finally;
                  AppMethodBeat.o(131900);
                  throw paramq;
                  ??? = finally;
                  try
                  {
                    NotifyReceiver.akJ().unlock();
                    AppMethodBeat.o(131900);
                    throw ???;
                    Log.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", new Object[] { Integer.valueOf(NotifyReceiver.akK().size()) });
                    continue;
                    if (!com.tencent.mm.kernel.g.aAf().azp()) {
                      continue;
                    }
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
                    {
                      public final boolean queueIdle()
                      {
                        AppMethodBeat.i(131896);
                        NotifyReceiver.a.a(NotifyReceiver.a.this);
                        AppMethodBeat.o(131896);
                        return false;
                      }
                    });
                    if ((paramInt1 != 0) || (paramInt2 != 0) || (!com.tencent.mm.model.a.aSG())) {
                      continue;
                    }
                    try
                    {
                      com.tencent.mm.kernel.g.aAi();
                      ??? = com.tencent.mm.kernel.g.aAf().hpN;
                      if (???.iBm > -1L) {
                        ???.iBm += 1L;
                      }
                      Log.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", new Object[] { Long.valueOf(???.iBm) });
                      if ((???.iBm != 2L) && (???.iBm != 5L)) {
                        continue;
                      }
                      paramq = com.tencent.mm.plugin.report.e.Cxv;
                      if (???.iBm != 2L) {
                        continue;
                      }
                      l = 37L;
                      paramq.idkeyStat(226L, l, 1L, false);
                      com.tencent.mm.plugin.report.e.Cxv.a(11098, new Object[] { Integer.valueOf(2001), Long.valueOf(???.iBm) });
                    }
                    catch (Throwable ???)
                    {
                      Log.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { Util.stackTraceToString(???) });
                    }
                    continue;
                    l = 38L;
                    continue;
                  }
                  catch (Exception paramq)
                  {
                    continue;
                  }
                  ??? = ???;
                }
                catch (Exception paramq)
                {
                  continue;
                }
              }
            }
          }
          catch (Exception ???)
          {
            continue;
          }
        }
        synchronized (NotifyReceiver.akH())
        {
          i = paramq.getType();
          bool2 = NotifyReceiver.akK().contains(Long.valueOf(l));
          if (NotifyReceiver.akI() != null)
          {
            bool1 = NotifyReceiver.akI().isLocking();
            Log.i("MicroMsg.NotifyReceiver", "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b", new Object[] { Integer.valueOf(i), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            NotifyReceiver.akK().remove(Long.valueOf(l));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */