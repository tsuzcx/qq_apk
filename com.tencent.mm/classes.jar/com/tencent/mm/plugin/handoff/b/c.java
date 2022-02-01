package com.tencent.mm.plugin.handoff.b;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handOffEnable", "handOffSeq", "", "handler", "com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/plugin/handoff/service/StatusManager$handler$1;", "ids", "maxRetryCount", "", "modList", "msgQueue", "Ljava/util/LinkedList;", "networkAvailable", "queueWorking", "retryCount", "add", "", "handOff", "allList", "handOffList", "", "apply", "buildHandOffList", "opCode", "arg", "items", "checkMsgQueue", "checkNetworkAvailableMM", "clearStatus", "commit", "del", "incSeq", "init", "launchSendTask", "mod", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "retry", "sendHandOff", "msg", "uploadFail", "uploadSuccess", "uploading", "Companion", "plugin-handoff_release"})
public final class c
  implements f
{
  public static final c.a uEI;
  private int retryCount;
  private final boolean uEA;
  final Map<String, HandOff> uEB;
  final Map<String, HandOff> uEC;
  final Map<String, HandOff> uED;
  final Map<String, Boolean> uEE;
  final Map<String, String> uEF;
  private long uEG;
  private final b uEH;
  private boolean uEw;
  final LinkedList<String> uEx;
  private boolean uEy;
  private final int uEz;
  
  static
  {
    AppMethodBeat.i(10447);
    uEI = new c.a((byte)0);
    AppMethodBeat.o(10447);
  }
  
  public c()
  {
    AppMethodBeat.i(10446);
    this.uEx = new LinkedList();
    this.uEy = true;
    this.uEz = 3;
    this.uEA = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyn, false);
    this.uEB = ((Map)new LinkedHashMap());
    this.uEC = ((Map)new LinkedHashMap());
    this.uED = ((Map)new LinkedHashMap());
    this.uEE = ((Map)new LinkedHashMap());
    this.uEF = ((Map)new LinkedHashMap());
    if (Looper.myLooper() == null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      this.uEH = new b(this, localLooper);
      AppMethodBeat.o(10446);
      return;
    }
  }
  
  private static String a(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10431);
    Object localObject1 = ((Iterable)paramCollection).iterator();
    for (paramCollection = ""; ((Iterator)localObject1).hasNext(); paramCollection = paramCollection + ((HandOff)localObject2).dbO()) {
      localObject2 = (HandOff)((Iterator)localObject1).next();
    }
    localObject1 = new StringBuilder("<handofflist opcode=\"").append(paramInt).append("\" seq=\"<![CSEQ]>\" deviceid=\"").append(com.tencent.mm.compatible.deviceinfo.q.aay()).append("\" networkstatus=\"");
    Object localObject2 = ay.iR(aj.getContext());
    p.g(localObject2, "NetStatusUtil.getFormatedNetType(getContext())");
    if (localObject2 == null)
    {
      paramCollection = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(10431);
      throw paramCollection;
    }
    localObject2 = ((String)localObject2).toLowerCase();
    p.g(localObject2, "(this as java.lang.String).toLowerCase()");
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
  
  private final void anh(String paramString)
  {
    AppMethodBeat.i(10438);
    com.tencent.mm.kernel.a locala = g.ajA();
    p.g(locala, "account()");
    if (locala.aiI())
    {
      if ((bu.flY()) || (this.uEA))
      {
        paramString = d.n.n.h(paramString, "<![CSEQ]>", String.valueOf(this.uEG), false);
        ad.i("HandOff.StatusManager", "send handoff: ".concat(String.valueOf(paramString)));
        aa.bv(paramString, "HandOffMaster");
        AppMethodBeat.o(10438);
        return;
      }
      ad.i("HandOff.StatusManager", "debugger: " + bu.flY() + ", handoff enabled: " + this.uEA + ", don't send handoff: " + paramString);
      AppMethodBeat.o(10438);
      return;
    }
    ad.i("HandOff.StatusManager", "device offline, don't send handoff: ".concat(String.valueOf(paramString)));
    this.uEx.poll();
    dbT();
    AppMethodBeat.o(10438);
  }
  
  private final void dbS()
  {
    AppMethodBeat.i(10436);
    this.uEB.clear();
    this.uEC.clear();
    this.uED.clear();
    this.uEE.clear();
    this.uEF.clear();
    AppMethodBeat.o(10436);
  }
  
  private final void dbT()
  {
    AppMethodBeat.i(10441);
    if (this.uEx.isEmpty())
    {
      ad.i("HandOff.StatusManager", "message queue is empty, set queueWorking = false");
      this.uEw = false;
      AppMethodBeat.o(10441);
      return;
    }
    try
    {
      String str = (String)this.uEx.getFirst();
      p.g(str, "msg");
      anh(str);
      AppMethodBeat.o(10441);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "", new Object[0]);
      this.uEw = false;
      AppMethodBeat.o(10441);
    }
  }
  
  private final void dbV()
  {
    AppMethodBeat.i(10444);
    com.tencent.mm.al.q localq = g.aiU();
    p.g(localq, "MMKernel.getNetSceneQueue()");
    int i = localq.aEN();
    boolean bool;
    if ((i == 4) || (i == 6))
    {
      bool = true;
      if (bool) {
        break label84;
      }
      ad.i("HandOff.StatusManager", "network unavailable, clear message queue and retry after 30s");
      this.uEx.clear();
      this.uEH.sendEmptyMessageDelayed(2, 30000L);
    }
    for (;;)
    {
      this.uEy = bool;
      AppMethodBeat.o(10444);
      return;
      bool = false;
      break;
      label84:
      if (!this.uEy)
      {
        ad.i("HandOff.StatusManager", "network become available, send all list");
        a.uEf.dbK();
      }
      dbT();
    }
  }
  
  final void apply()
  {
    AppMethodBeat.i(10443);
    if (!this.uEH.hasMessages(1))
    {
      ad.d("HandOff.StatusManager", "plan commit task");
      this.uEH.sendEmptyMessageDelayed(1, 2000L);
    }
    AppMethodBeat.o(10443);
  }
  
  final void b(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10439);
    paramCollection = a(paramInt, paramCollection);
    this.uEx.add(paramCollection);
    dbU();
    AppMethodBeat.o(10439);
  }
  
  final void dbU()
  {
    AppMethodBeat.i(10442);
    if (!this.uEw)
    {
      ad.i("HandOff.StatusManager", "launch queue, set queueWorking = true");
      this.uEw = true;
      dbT();
    }
    AppMethodBeat.o(10442);
  }
  
  public final void j(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10430);
    p.h(paramCollection, "handOffList");
    try
    {
      Object localObject = g.ajC();
      p.g(localObject, "storage()");
      this.uEG = ((e)localObject).ajl().a(al.a.IFZ, 0L);
      localObject = g.ajB();
      p.g(localObject, "network()");
      ((com.tencent.mm.kernel.b)localObject).aiU().a(251, (f)this);
      b(4, paramCollection);
      AppMethodBeat.o(10430);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "restoreFromBallInfoList fail, exp:%s", new Object[] { localException });
        this.uEG = 0L;
      }
    }
  }
  
  public final void k(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10435);
    p.h(paramCollection, "handOffList");
    paramCollection = ((Iterable)paramCollection).iterator();
    while (paramCollection.hasNext()) {
      m((HandOff)paramCollection.next());
    }
    AppMethodBeat.o(10435);
  }
  
  public final void l(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10437);
    p.h(paramCollection, "handOffList");
    this.uEH.removeMessages(1);
    dbS();
    b(4, paramCollection);
    AppMethodBeat.o(10437);
  }
  
  public final void m(HandOff paramHandOff)
  {
    AppMethodBeat.i(10434);
    p.h(paramHandOff, "handOff");
    if (!this.uEE.containsKey(paramHandOff.key))
    {
      this.uEE.put(paramHandOff.key, Boolean.TRUE);
      this.uEF.put(paramHandOff.key, paramHandOff.id);
    }
    this.uEB.remove(paramHandOff.key);
    this.uEC.remove(paramHandOff.key);
    this.uED.put(paramHandOff.key, paramHandOff);
    apply();
    AppMethodBeat.o(10434);
  }
  
  public final void n(HandOff paramHandOff)
  {
    AppMethodBeat.i(10440);
    p.h(paramHandOff, "handOff");
    b(3, (Collection)j.listOf(paramHandOff));
    AppMethodBeat.o(10440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(10445);
    p.h(paramn, "scene");
    if ((paramn.getReqResp() instanceof com.tencent.mm.al.b))
    {
      paramString = paramn.getReqResp();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(10445);
        throw paramString;
      }
      if ((((com.tencent.mm.al.b)paramString).aEE() instanceof dil))
      {
        paramString = paramn.getReqResp();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((com.tencent.mm.al.b)paramString).aEE();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StatusNotifyRequest");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((dil)paramString).Hxp;
        if (paramString != null)
        {
          if (p.i(paramString.Name, "HandOffMaster"))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.uEx.poll();
              this.retryCount = 0;
              if (this.uEG == 9223372036854775807L) {
                this.uEG = 0L;
              }
              this.uEG += 1L;
              paramString = g.ajC();
              p.g(paramString, "storage()");
              paramString.ajl().set(al.a.IFZ, Long.valueOf(this.uEG));
              ad.i("HandOff.StatusManager", "send handoff succeed, check next message");
              dbT();
              AppMethodBeat.o(10445);
              return;
            }
            this.retryCount += 1;
            if (this.retryCount >= this.uEz)
            {
              this.uEx.poll();
              this.retryCount = 0;
            }
            ad.i("HandOff.StatusManager", "send handoff failed, retry: " + this.retryCount);
            dbV();
          }
          AppMethodBeat.o(10445);
          return;
        }
      }
    }
    AppMethodBeat.o(10445);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
  @SuppressLint({"HandlerLeak"})
  public static final class b
    extends ap
  {
    b(Looper paramLooper)
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
        ad.d("HandOff.StatusManager", "handle commit message");
        c.a(this.uEJ);
        AppMethodBeat.o(10429);
        return;
        ad.d("HandOff.StatusManager", "handle retry message");
        c.b(this.uEJ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.c
 * JD-Core Version:    0.7.0.1
 */