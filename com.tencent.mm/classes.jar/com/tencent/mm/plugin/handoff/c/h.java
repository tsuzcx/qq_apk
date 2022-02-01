package com.tencent.mm.plugin.handoff.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.protocal.protobuf.ecs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handOffEnable", "getHandOffEnable", "()Z", "handOffSeq", "", "handler", "com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/plugin/handoff/service/StatusManager$handler$1;", "ids", "maxRetryCount", "", "modList", "msgQueue", "Ljava/util/LinkedList;", "networkAvailable", "networkStatus", "nextSeq", "queueWorking", "retryCount", "add", "", "handOff", "allList", "handOffList", "", "apply", "checkMsgQueue", "checkNetworkAvailableMM", "clearStatus", "commit", "del", "incSeq", "init", "launchSendTask", "mod", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "retry", "sendHandOff", "opCode", "msg", "sendOpenRequest", "uploadFail", "uploadSuccess", "uploading", "Companion", "plugin-handoff_release"})
public final class h
  implements i
{
  public static final h.a yiX;
  private int retryCount;
  private final Map<String, HandOff> yhU;
  private final Map<String, HandOff> yhV;
  private final Map<String, Boolean> yhW;
  private boolean yiN;
  final LinkedList<String> yiO;
  private boolean yiP;
  private String yiQ;
  private final int yiR;
  private final Map<String, HandOff> yiS;
  private final Map<String, String> yiT;
  private long yiU;
  private long yiV;
  private final b yiW;
  
  static
  {
    AppMethodBeat.i(10447);
    yiX = new h.a((byte)0);
    AppMethodBeat.o(10447);
  }
  
  public h(final Looper paramLooper)
  {
    AppMethodBeat.i(199227);
    this.yiO = new LinkedList();
    this.yiP = true;
    this.yiQ = "4G";
    this.yiR = 3;
    this.yhU = ((Map)new LinkedHashMap());
    this.yiS = ((Map)new LinkedHashMap());
    this.yhV = ((Map)new LinkedHashMap());
    this.yhW = ((Map)new LinkedHashMap());
    this.yiT = ((Map)new LinkedHashMap());
    this.yiW = new b(this, paramLooper, paramLooper);
    AppMethodBeat.o(199227);
  }
  
  private final void aBC(String paramString)
  {
    AppMethodBeat.i(10438);
    com.tencent.mm.kernel.a locala = g.aAf();
    p.g(locala, "account()");
    if (locala.azn())
    {
      if ((WeChatEnvironment.hasDebugger()) || (dYD()))
      {
        for (this.yiV = this.yiU; n.a((CharSequence)paramString, (CharSequence)"<![CSEQ]>", false); this.yiV += 1L)
        {
          paramString = n.by(paramString, "<![CSEQ]>", String.valueOf(this.yiV));
          if (this.yiV == 9223372036854775807L) {
            this.yiV = 0L;
          }
        }
        Log.i("HandOff.StatusManager", "send handoff: ".concat(String.valueOf(paramString)));
        if (!ab.bz(paramString, "HandOffMaster"))
        {
          dYH();
          AppMethodBeat.o(10438);
        }
      }
      else
      {
        Log.i("HandOff.StatusManager", "debugger: " + WeChatEnvironment.hasDebugger() + ", handoff enabled: " + dYD() + ", don't send handoff: " + paramString);
        this.yiO.poll();
        dYF();
        AppMethodBeat.o(10438);
      }
    }
    else
    {
      Log.i("HandOff.StatusManager", "device offline, don't send handoff: ".concat(String.valueOf(paramString)));
      this.yiO.poll();
      dYF();
    }
    AppMethodBeat.o(10438);
  }
  
  private static boolean dPY()
  {
    AppMethodBeat.i(199226);
    com.tencent.mm.ak.t localt = g.azz();
    p.g(localt, "MMKernel.getNetSceneQueue()");
    int i = localt.aYS();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(199226);
      return true;
    }
    AppMethodBeat.o(199226);
    return false;
  }
  
  private static boolean dYD()
  {
    AppMethodBeat.i(199225);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYF, false);
    AppMethodBeat.o(199225);
    return bool;
  }
  
  private final void dYE()
  {
    AppMethodBeat.i(10436);
    this.yhU.clear();
    this.yiS.clear();
    this.yhV.clear();
    this.yhW.clear();
    this.yiT.clear();
    AppMethodBeat.o(10436);
  }
  
  private final void dYF()
  {
    AppMethodBeat.i(10441);
    if (this.yiO.isEmpty())
    {
      Log.i("HandOff.StatusManager", "message queue is empty, set queueWorking = false");
      this.yiN = false;
      AppMethodBeat.o(10441);
      return;
    }
    try
    {
      String str = (String)this.yiO.getFirst();
      p.g(str, "msg");
      aBC(str);
      AppMethodBeat.o(10441);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "", new Object[0]);
      this.yiN = false;
      AppMethodBeat.o(10441);
    }
  }
  
  private final void dYH()
  {
    AppMethodBeat.i(10444);
    this.retryCount += 1;
    if (this.retryCount >= this.yiR)
    {
      this.yiO.poll();
      this.retryCount = 0;
    }
    Log.i("HandOff.StatusManager", "send handoff failed, retry: " + this.retryCount);
    boolean bool = dPY();
    if (!bool)
    {
      Log.i("HandOff.StatusManager", "network unavailable, clear message queue and retry after 30s");
      this.yiO.clear();
      this.yiW.sendEmptyMessageDelayed(2, 30000L);
    }
    for (;;)
    {
      this.yiP = bool;
      AppMethodBeat.o(10444);
      return;
      if (!this.yiP)
      {
        Log.i("HandOff.StatusManager", "network become available, send all list");
        String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        p.g(str, "NetStatusUtil.getFormatedNetType(getContext())");
        this.yiQ = str;
        e.yim.dYk();
      }
      dYF();
    }
  }
  
  final void a(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10439);
    paramCollection = new com.tencent.mm.plugin.handoff.model.b(paramInt, paramCollection, 0L, 4);
    String str = com.tencent.mm.compatible.deviceinfo.q.aoG();
    p.g(str, "DeviceInfo.getMMGUID()");
    paramCollection = paramCollection.V(str, this.yiQ, a.dYp());
    this.yiO.add(paramCollection);
    dYG();
    AppMethodBeat.o(10439);
  }
  
  final void apply()
  {
    AppMethodBeat.i(10443);
    if (!this.yiW.hasMessages(1))
    {
      Log.d("HandOff.StatusManager", "plan commit task");
      this.yiW.sendEmptyMessageDelayed(1, 2000L);
    }
    AppMethodBeat.o(10443);
  }
  
  final void dYG()
  {
    AppMethodBeat.i(10442);
    if (!this.yiN)
    {
      Log.i("HandOff.StatusManager", "launch queue, set queueWorking = true");
      this.yiN = true;
      dYF();
    }
    AppMethodBeat.o(10442);
  }
  
  public final void l(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10430);
    p.h(paramCollection, "handOffList");
    try
    {
      Object localObject = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
      p.g(localObject, "NetStatusUtil.getFormatedNetType(getContext())");
      this.yiQ = ((String)localObject);
      localObject = g.aAh();
      p.g(localObject, "storage()");
      this.yiU = ((com.tencent.mm.kernel.e)localObject).azQ().a(ar.a.Ojf, 0L);
      localObject = g.aAg();
      p.g(localObject, "network()");
      ((com.tencent.mm.kernel.b)localObject).azz().a(251, (i)this);
      a(4, paramCollection);
      AppMethodBeat.o(10430);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "restoreFromBallInfoList fail, exp:%s", new Object[] { localException });
        this.yiU = 0L;
      }
    }
  }
  
  public final void m(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10435);
    p.h(paramCollection, "handOffList");
    paramCollection = ((Iterable)paramCollection).iterator();
    while (paramCollection.hasNext()) {
      n((HandOff)paramCollection.next());
    }
    AppMethodBeat.o(10435);
  }
  
  public final void n(HandOff paramHandOff)
  {
    AppMethodBeat.i(10434);
    p.h(paramHandOff, "handOff");
    apply();
    AppMethodBeat.o(10434);
  }
  
  public final void n(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10437);
    p.h(paramCollection, "handOffList");
    this.yiW.removeMessages(1);
    dYE();
    a(4, paramCollection);
    AppMethodBeat.o(10437);
  }
  
  public final void o(HandOff paramHandOff)
  {
    AppMethodBeat.i(10440);
    p.h(paramHandOff, "handOff");
    a(3, (Collection)j.listOf(paramHandOff));
    AppMethodBeat.o(10440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(10445);
    p.h(paramq, "scene");
    if ((paramq.getReqResp() instanceof d))
    {
      paramString = paramq.getReqResp();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(10445);
        throw paramString;
      }
      if ((((d)paramString).aYJ() instanceof ecs))
      {
        paramString = paramq.getReqResp();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((d)paramString).aYJ();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StatusNotifyRequest");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((ecs)paramString).Ndb;
        if (paramString != null)
        {
          if (p.j(paramString.Name, "HandOffMaster"))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.yiO.poll();
              this.retryCount = 0;
              this.yiU = this.yiV;
              paramString = g.aAh();
              p.g(paramString, "storage()");
              paramString.azQ().set(ar.a.Ojf, Long.valueOf(this.yiU));
              Log.i("HandOff.StatusManager", "send handoff succeed, check next message");
              dYF();
              AppMethodBeat.o(10445);
              return;
            }
            Log.e("HandOff.StatusManager", "send handoff fail, errType:" + paramInt1 + ", errCode:" + paramInt2);
            dYH();
          }
          AppMethodBeat.o(10445);
          return;
        }
      }
    }
    AppMethodBeat.o(10445);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
  public static final class b
    extends MMHandler
  {
    b(Looper paramLooper1, Looper paramLooper2)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(10429);
      p.h(paramMessage, "msg");
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(10429);
        return;
        Log.d("HandOff.StatusManager", "handle commit message");
        e.yim.dYk();
        AppMethodBeat.o(10429);
        return;
        Log.d("HandOff.StatusManager", "handle retry message");
        h.a(this.yiY);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.h
 * JD-Core Version:    0.7.0.1
 */