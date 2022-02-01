package com.tencent.mm.plugin.handoff.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.b;
import com.tencent.mm.protocal.protobuf.fhq;
import com.tencent.mm.protocal.protobuf.fhr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "allList", "", "delList", "exists", "", "handOffEnable", "getHandOffEnable", "()Z", "handOffSeq", "", "handler", "com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/plugin/handoff/service/StatusManager$handler$1;", "ids", "maxRetryCount", "", "modList", "msgQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "networkAvailable", "networkStatus", "nextSeq", "queueWorking", "retryCount", "add", "", "handOff", "handOffList", "apply", "checkMsgQueue", "checkNetworkAvailableMM", "clearStatus", "commit", "del", "incSeq", "init", "launchSendTask", "mod", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "retry", "sendHandOff", "opCode", "msg", "sendOpenRequest", "uploadFail", "uploadSuccess", "uploading", "Companion", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements com.tencent.mm.am.h
{
  public static final g.a Jmd;
  final Map<String, HandOff> JlC;
  final Map<String, HandOff> JlD;
  final Map<String, Boolean> JlE;
  private boolean Jme;
  final ConcurrentLinkedQueue<String> Jmf;
  private boolean Jmg;
  private String Jmh;
  private final int Jmi;
  final Map<String, HandOff> Jmj;
  final Map<String, String> Jmk;
  private Collection<? extends HandOff> Jml;
  private long Jmm;
  private long Jmn;
  private final b Jmo;
  private int retryCount;
  
  static
  {
    AppMethodBeat.i(10447);
    Jmd = new g.a((byte)0);
    AppMethodBeat.o(10447);
  }
  
  public g(final Looper paramLooper)
  {
    AppMethodBeat.i(266205);
    this.Jmf = new ConcurrentLinkedQueue();
    this.Jmg = true;
    this.Jmh = "4G";
    this.Jmi = 3;
    this.JlC = ((Map)new LinkedHashMap());
    this.Jmj = ((Map)new LinkedHashMap());
    this.JlD = ((Map)new LinkedHashMap());
    this.JlE = ((Map)new LinkedHashMap());
    this.Jmk = ((Map)new LinkedHashMap());
    this.Jmo = new b(this, paramLooper);
    AppMethodBeat.o(266205);
  }
  
  private final void aIh(String paramString)
  {
    AppMethodBeat.i(10438);
    if (!z.bBb())
    {
      if ((WeChatEnvironment.hasDebugger()) || (fKe()))
      {
        for (this.Jmn = this.Jmm; n.a((CharSequence)paramString, (CharSequence)"<![CSEQ]>", false); this.Jmn += 1L)
        {
          paramString = n.bW(paramString, "<![CSEQ]>", String.valueOf(this.Jmn));
          if (this.Jmn == 9223372036854775807L) {
            this.Jmn = 0L;
          }
        }
        Log.i("HandOff.StatusManager", kotlin.g.b.s.X("send handoff: ", paramString));
        if (!ac.bO(paramString, "HandOffMaster"))
        {
          retry();
          AppMethodBeat.o(10438);
        }
      }
      else
      {
        Log.i("HandOff.StatusManager", "debugger: " + WeChatEnvironment.hasDebugger() + ", handoff enabled: " + fKe() + ", don't send handoff: " + paramString);
        this.Jmf.poll();
        fKf();
        AppMethodBeat.o(10438);
      }
    }
    else
    {
      Log.i("HandOff.StatusManager", kotlin.g.b.s.X("device is ex device, don't send handoff: ", paramString));
      this.Jmf.poll();
      fKf();
    }
    AppMethodBeat.o(10438);
  }
  
  private final void eKT()
  {
    AppMethodBeat.i(10436);
    this.JlC.clear();
    this.Jmj.clear();
    this.JlD.clear();
    this.JlE.clear();
    this.Jmk.clear();
    AppMethodBeat.o(10436);
  }
  
  private static boolean fKe()
  {
    AppMethodBeat.i(266213);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVb, false);
    AppMethodBeat.o(266213);
    return bool;
  }
  
  private final void fKf()
  {
    AppMethodBeat.i(10441);
    if (this.Jmf.isEmpty())
    {
      Log.i("HandOff.StatusManager", "message queue is empty, set queueWorking = false");
      this.Jme = false;
      AppMethodBeat.o(10441);
      return;
    }
    try
    {
      String str = (String)kotlin.a.p.e((Iterable)this.Jmf);
      kotlin.g.b.s.s(str, "msg");
      aIh(str);
      AppMethodBeat.o(10441);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "", new Object[0]);
      this.Jme = false;
      AppMethodBeat.o(10441);
    }
  }
  
  private static boolean fzw()
  {
    AppMethodBeat.i(266240);
    int i = com.tencent.mm.kernel.h.aZW().bFQ();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(266240);
      return true;
    }
    AppMethodBeat.o(266240);
    return false;
  }
  
  private final void retry()
  {
    AppMethodBeat.i(10444);
    this.retryCount += 1;
    if (this.retryCount >= this.Jmi)
    {
      this.Jmf.poll();
      this.retryCount = 0;
    }
    Log.i("HandOff.StatusManager", kotlin.g.b.s.X("send handoff failed, retry: ", Integer.valueOf(this.retryCount)));
    boolean bool = fzw();
    if (!bool)
    {
      Log.i("HandOff.StatusManager", "network unavailable, clear message queue and retry after 30s");
      this.Jmf.clear();
      this.Jmo.sendEmptyMessageDelayed(2, 30000L);
    }
    for (;;)
    {
      this.Jmg = bool;
      AppMethodBeat.o(10444);
      return;
      if (!this.Jmg)
      {
        Log.i("HandOff.StatusManager", "network become available, send all list");
        String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        kotlin.g.b.s.s(str, "getFormatedNetType(getContext())");
        this.Jmh = str;
        e.JlJ.fJK();
      }
      fKf();
    }
  }
  
  public final void A(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10437);
    kotlin.g.b.s.u(paramCollection, "handOffList");
    eKT();
    this.Jml = paramCollection;
    apply();
    AppMethodBeat.o(10437);
  }
  
  final void a(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10439);
    paramCollection = new b(paramInt, paramCollection, 0L, 4);
    String str = q.aPg();
    kotlin.g.b.s.s(str, "getMMGUID()");
    paramCollection = paramCollection.ag(str, this.Jmh, a.fJP());
    this.Jmf.add(paramCollection);
    fKg();
    AppMethodBeat.o(10439);
  }
  
  final void apply()
  {
    AppMethodBeat.i(10443);
    if (!this.Jmo.hasMessages(1))
    {
      Log.d("HandOff.StatusManager", "plan commit task");
      this.Jmo.sendEmptyMessageDelayed(1, 3000L);
    }
    AppMethodBeat.o(10443);
  }
  
  final void fKg()
  {
    AppMethodBeat.i(10442);
    if (!this.Jme)
    {
      Log.i("HandOff.StatusManager", "launch queue, set queueWorking = true");
      this.Jme = true;
      fKf();
    }
    AppMethodBeat.o(10442);
  }
  
  public final void o(HandOff paramHandOff)
  {
    AppMethodBeat.i(10440);
    kotlin.g.b.s.u(paramHandOff, "handOff");
    a(3, (Collection)kotlin.a.p.listOf(paramHandOff));
    AppMethodBeat.o(10440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(10445);
    kotlin.g.b.s.u(paramp, "scene");
    if ((paramp.getReqResp() instanceof com.tencent.mm.am.c))
    {
      paramString = paramp.getReqResp();
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(10445);
        throw paramString;
      }
      if ((c.b.b(((com.tencent.mm.am.c)paramString).otB) instanceof fhr))
      {
        paramString = paramp.getReqResp();
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = c.b.b(((com.tencent.mm.am.c)paramString).otB);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StatusNotifyRequest");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((fhr)paramString).abIx;
        if ((paramString != null) && (kotlin.g.b.s.p(paramString.IGU, "HandOffMaster")))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            this.Jmf.poll();
            this.retryCount = 0;
            this.Jmm = this.Jmn;
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acZh, Long.valueOf(this.Jmm));
            Log.i("HandOff.StatusManager", "send handoff succeed, check next message");
            fKf();
            AppMethodBeat.o(10445);
            return;
          }
          Log.e("HandOff.StatusManager", "send handoff fail, errType:" + paramInt1 + ", errCode:" + paramInt2);
          retry();
        }
      }
    }
    AppMethodBeat.o(10445);
  }
  
  public final void z(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10430);
    kotlin.g.b.s.u(paramCollection, "handOffList");
    try
    {
      paramCollection = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
      kotlin.g.b.s.s(paramCollection, "getFormatedNetType(getContext())");
      this.Jmh = paramCollection;
      this.Jmm = com.tencent.mm.kernel.h.baE().ban().a(at.a.acZh, 0L);
      com.tencent.mm.kernel.h.baD().mCm.b(251, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.baD().mCm.a(251, (com.tencent.mm.am.h)this);
      e.JlJ.fJK();
      AppMethodBeat.o(10430);
      return;
    }
    catch (Exception paramCollection)
    {
      for (;;)
      {
        Log.printErrStackTrace("HandOff.StatusManager", (Throwable)paramCollection, "restoreFromBallInfoList fail, exp:%s", new Object[] { paramCollection });
        this.Jmm = 0L;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(g paramg, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(10429);
      kotlin.g.b.s.u(paramMessage, "msg");
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(10429);
        return;
        Log.i("HandOff.StatusManager", "handle commit message");
        g.a(this.Jmp);
        AppMethodBeat.o(10429);
        return;
        Log.i("HandOff.StatusManager", "handle retry message");
        g.b(this.Jmp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.g
 * JD-Core Version:    0.7.0.1
 */