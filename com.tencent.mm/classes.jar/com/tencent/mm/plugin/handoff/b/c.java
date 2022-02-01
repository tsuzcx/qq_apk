package com.tencent.mm.plugin.handoff.b;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.protocal.protobuf.dcx;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handOffEnable", "handOffSeq", "", "handler", "com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/plugin/handoff/service/StatusManager$handler$1;", "ids", "maxRetryCount", "", "modList", "msgQueue", "Ljava/util/LinkedList;", "networkAvailable", "queueWorking", "retryCount", "add", "", "handOff", "allList", "handOffList", "", "apply", "buildHandOffList", "opCode", "arg", "items", "checkMsgQueue", "checkNetworkAvailableMM", "clearStatus", "commit", "del", "incSeq", "init", "launchSendTask", "mod", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "retry", "sendHandOff", "msg", "uploadFail", "uploadSuccess", "uploading", "Companion", "plugin-handoff_release"})
public final class c
  implements com.tencent.mm.ak.g
{
  public static final a tBZ;
  private int retryCount;
  private boolean tBN;
  final LinkedList<String> tBO;
  private boolean tBP;
  private final int tBQ;
  private final boolean tBR;
  private final Map<String, HandOff> tBS;
  private final Map<String, HandOff> tBT;
  private final Map<String, HandOff> tBU;
  private final Map<String, Boolean> tBV;
  private final Map<String, String> tBW;
  private long tBX;
  private final b tBY;
  
  static
  {
    AppMethodBeat.i(10447);
    tBZ = new a((byte)0);
    AppMethodBeat.o(10447);
  }
  
  public c()
  {
    AppMethodBeat.i(10446);
    this.tBO = new LinkedList();
    this.tBP = true;
    this.tBQ = 3;
    this.tBR = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTH, false);
    this.tBS = ((Map)new LinkedHashMap());
    this.tBT = ((Map)new LinkedHashMap());
    this.tBU = ((Map)new LinkedHashMap());
    this.tBV = ((Map)new LinkedHashMap());
    this.tBW = ((Map)new LinkedHashMap());
    if (Looper.myLooper() == null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      this.tBY = new b(this, localLooper);
      AppMethodBeat.o(10446);
      return;
    }
  }
  
  private static String a(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10431);
    Object localObject1 = ((Iterable)paramCollection).iterator();
    for (paramCollection = ""; ((Iterator)localObject1).hasNext(); paramCollection = paramCollection + ((HandOff)localObject2).cSH()) {
      localObject2 = (HandOff)((Iterator)localObject1).next();
    }
    localObject1 = new StringBuilder("<handofflist opcode=\"").append(paramInt).append("\" seq=\"<![CSEQ]>\" deviceid=\"").append(com.tencent.mm.compatible.deviceinfo.q.XX()).append("\" networkstatus=\"");
    Object localObject2 = ax.iH(ai.getContext());
    k.g(localObject2, "NetStatusUtil.getFormatedNetType(getContext())");
    if (localObject2 == null)
    {
      paramCollection = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(10431);
      throw paramCollection;
    }
    localObject2 = ((String)localObject2).toLowerCase();
    k.g(localObject2, "(this as java.lang.String).toLowerCase()");
    paramCollection = (String)localObject2 + "\">\n        " + paramCollection + "\n        </handofflist>";
    if (paramCollection == null)
    {
      paramCollection = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(10431);
      throw paramCollection;
    }
    paramCollection = d.n.n.trim((CharSequence)paramCollection).toString();
    AppMethodBeat.o(10431);
    return paramCollection;
  }
  
  private final void aiu(String paramString)
  {
    AppMethodBeat.i(10438);
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.agP();
    k.g(locala, "account()");
    if (locala.afW())
    {
      if ((bt.eWo()) || (this.tBR))
      {
        paramString = d.n.n.h(paramString, "<![CSEQ]>", String.valueOf(this.tBX), false);
        ac.i("HandOff.StatusManager", "send handoff: ".concat(String.valueOf(paramString)));
        aa.bu(paramString, "HandOffMaster");
        AppMethodBeat.o(10438);
        return;
      }
      ac.i("HandOff.StatusManager", "debugger: " + bt.eWo() + ", handoff enabled: " + this.tBR + ", don't send handoff: " + paramString);
      AppMethodBeat.o(10438);
      return;
    }
    ac.i("HandOff.StatusManager", "device offline, don't send handoff: ".concat(String.valueOf(paramString)));
    this.tBO.poll();
    cSM();
    AppMethodBeat.o(10438);
  }
  
  private final void apply()
  {
    AppMethodBeat.i(10443);
    if (!this.tBY.hasMessages(1))
    {
      ac.d("HandOff.StatusManager", "plan commit task");
      this.tBY.sendEmptyMessageDelayed(1, 2000L);
    }
    AppMethodBeat.o(10443);
  }
  
  private final void cSL()
  {
    AppMethodBeat.i(10436);
    this.tBS.clear();
    this.tBT.clear();
    this.tBU.clear();
    this.tBV.clear();
    this.tBW.clear();
    AppMethodBeat.o(10436);
  }
  
  private final void cSM()
  {
    AppMethodBeat.i(10441);
    if (this.tBO.isEmpty())
    {
      ac.i("HandOff.StatusManager", "message queue is empty, set queueWorking = false");
      this.tBN = false;
      AppMethodBeat.o(10441);
      return;
    }
    try
    {
      String str = (String)this.tBO.getFirst();
      k.g(str, "msg");
      aiu(str);
      AppMethodBeat.o(10441);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "", new Object[0]);
      this.tBN = false;
      AppMethodBeat.o(10441);
    }
  }
  
  private final void cSO()
  {
    AppMethodBeat.i(10444);
    com.tencent.mm.ak.q localq = com.tencent.mm.kernel.g.agi();
    k.g(localq, "MMKernel.getNetSceneQueue()");
    int i = localq.aBK();
    boolean bool;
    if ((i == 4) || (i == 6))
    {
      bool = true;
      if (bool) {
        break label84;
      }
      ac.i("HandOff.StatusManager", "network unavailable, clear message queue and retry after 30s");
      this.tBO.clear();
      this.tBY.sendEmptyMessageDelayed(2, 30000L);
    }
    for (;;)
    {
      this.tBP = bool;
      AppMethodBeat.o(10444);
      return;
      bool = false;
      break;
      label84:
      if (!this.tBP)
      {
        ac.i("HandOff.StatusManager", "network become available, send all list");
        a.tBw.cSD();
      }
      cSM();
    }
  }
  
  final void b(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10439);
    paramCollection = a(paramInt, paramCollection);
    this.tBO.add(paramCollection);
    cSN();
    AppMethodBeat.o(10439);
  }
  
  final void cSN()
  {
    AppMethodBeat.i(10442);
    if (!this.tBN)
    {
      ac.i("HandOff.StatusManager", "launch queue, set queueWorking = true");
      this.tBN = true;
      cSM();
    }
    AppMethodBeat.o(10442);
  }
  
  public final void j(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10430);
    k.h(paramCollection, "handOffList");
    try
    {
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "storage()");
      this.tBX = ((e)localObject).agA().a(ah.a.GTu, 0L);
      localObject = com.tencent.mm.kernel.g.agQ();
      k.g(localObject, "network()");
      ((com.tencent.mm.kernel.b)localObject).agi().a(251, (com.tencent.mm.ak.g)this);
      b(4, paramCollection);
      AppMethodBeat.o(10430);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "restoreFromBallInfoList fail, exp:%s", new Object[] { localException });
        this.tBX = 0L;
      }
    }
  }
  
  public final void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(10432);
    k.h(paramHandOff, "handOff");
    if (!this.tBV.containsKey(paramHandOff.key)) {
      this.tBV.put(paramHandOff.key, Boolean.FALSE);
    }
    this.tBU.remove(paramHandOff.key);
    this.tBS.put(paramHandOff.key, paramHandOff);
    apply();
    AppMethodBeat.o(10432);
  }
  
  public final void k(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10435);
    k.h(paramCollection, "handOffList");
    paramCollection = ((Iterable)paramCollection).iterator();
    while (paramCollection.hasNext()) {
      m((HandOff)paramCollection.next());
    }
    AppMethodBeat.o(10435);
  }
  
  public final void l(HandOff paramHandOff)
  {
    AppMethodBeat.i(10433);
    k.h(paramHandOff, "handOff");
    if (!this.tBV.containsKey(paramHandOff.key))
    {
      this.tBV.put(paramHandOff.key, Boolean.TRUE);
      this.tBW.put(paramHandOff.key, paramHandOff.id);
    }
    this.tBU.remove(paramHandOff.key);
    if (this.tBS.containsKey(paramHandOff.key))
    {
      Object localObject = this.tBS.get(paramHandOff.key);
      if (localObject == null) {
        k.fOy();
      }
      ((HandOff)localObject).j(paramHandOff);
    }
    for (;;)
    {
      apply();
      AppMethodBeat.o(10433);
      return;
      this.tBT.put(paramHandOff.key, paramHandOff);
    }
  }
  
  public final void l(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10437);
    k.h(paramCollection, "handOffList");
    this.tBY.removeMessages(1);
    cSL();
    b(4, paramCollection);
    AppMethodBeat.o(10437);
  }
  
  public final void m(HandOff paramHandOff)
  {
    AppMethodBeat.i(10434);
    k.h(paramHandOff, "handOff");
    if (!this.tBV.containsKey(paramHandOff.key))
    {
      this.tBV.put(paramHandOff.key, Boolean.TRUE);
      this.tBW.put(paramHandOff.key, paramHandOff.id);
    }
    this.tBS.remove(paramHandOff.key);
    this.tBT.remove(paramHandOff.key);
    this.tBU.put(paramHandOff.key, paramHandOff);
    apply();
    AppMethodBeat.o(10434);
  }
  
  public final void n(HandOff paramHandOff)
  {
    AppMethodBeat.i(10440);
    k.h(paramHandOff, "handOff");
    b(3, (Collection)j.listOf(paramHandOff));
    AppMethodBeat.o(10440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(10445);
    k.h(paramn, "scene");
    if ((paramn.getReqResp() instanceof com.tencent.mm.ak.b))
    {
      paramString = paramn.getReqResp();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(10445);
        throw paramString;
      }
      if ((((com.tencent.mm.ak.b)paramString).aBC() instanceof dcy))
      {
        paramString = paramn.getReqResp();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((com.tencent.mm.ak.b)paramString).aBC();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StatusNotifyRequest");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((dcy)paramString).FME;
        if (paramString != null)
        {
          if (k.g(paramString.Name, "HandOffMaster"))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.tBO.poll();
              this.retryCount = 0;
              if (this.tBX == 9223372036854775807L) {
                this.tBX = 0L;
              }
              this.tBX += 1L;
              paramString = com.tencent.mm.kernel.g.agR();
              k.g(paramString, "storage()");
              paramString.agA().set(ah.a.GTu, Long.valueOf(this.tBX));
              ac.i("HandOff.StatusManager", "send handoff succeed, check next message");
              cSM();
              AppMethodBeat.o(10445);
              return;
            }
            this.retryCount += 1;
            if (this.retryCount >= this.tBQ)
            {
              this.tBO.poll();
              this.retryCount = 0;
            }
            ac.i("HandOff.StatusManager", "send handoff failed, retry: " + this.retryCount);
            cSO();
          }
          AppMethodBeat.o(10445);
          return;
        }
      }
    }
    AppMethodBeat.o(10445);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/StatusManager$Companion;", "", "()V", "FUNC_NAME", "", "MSG_COMMIT", "", "MSG_RETRY", "SEQ_PLACEHOLDER", "SYNC_INTERVAL", "", "TAG", "plugin-handoff_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
  @SuppressLint({"HandlerLeak"})
  public static final class b
    extends ao
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(10429);
      k.h(paramMessage, "msg");
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(10429);
        return;
        ac.d("HandOff.StatusManager", "handle commit message");
        c.a(this.tCa);
        AppMethodBeat.o(10429);
        return;
        ac.d("HandOff.StatusManager", "handle retry message");
        c.b(this.tCa);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.c
 * JD-Core Version:    0.7.0.1
 */