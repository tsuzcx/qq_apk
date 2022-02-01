package com.tencent.mm.plugin.handoff.b;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handOffEnable", "handOffSeq", "", "handler", "com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/plugin/handoff/service/StatusManager$handler$1;", "ids", "maxRetryCount", "", "modList", "msgQueue", "Ljava/util/LinkedList;", "networkAvailable", "queueWorking", "retryCount", "add", "", "handOff", "allList", "handOffList", "", "apply", "buildHandOffList", "opCode", "arg", "items", "checkMsgQueue", "checkNetworkAvailableMM", "clearStatus", "commit", "del", "incSeq", "init", "launchSendTask", "mod", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "retry", "sendHandOff", "msg", "uploadFail", "uploadSuccess", "uploading", "Companion", "plugin-handoff_release"})
public final class c
  implements com.tencent.mm.al.g
{
  public static final c.a suj;
  private int retryCount;
  private boolean stX;
  final LinkedList<String> stY;
  private boolean stZ;
  private final int sua;
  private final boolean sub;
  private final Map<String, HandOff> suc;
  private final Map<String, HandOff> sud;
  private final Map<String, HandOff> sue;
  private final Map<String, Boolean> suf;
  private final Map<String, String> sug;
  private long suh;
  private final b sui;
  
  static
  {
    AppMethodBeat.i(10447);
    suj = new c.a((byte)0);
    AppMethodBeat.o(10447);
  }
  
  public c()
  {
    AppMethodBeat.i(10446);
    this.stY = new LinkedList();
    this.stZ = true;
    this.sua = 3;
    this.sub = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppW, false);
    this.suc = ((Map)new LinkedHashMap());
    this.sud = ((Map)new LinkedHashMap());
    this.sue = ((Map)new LinkedHashMap());
    this.suf = ((Map)new LinkedHashMap());
    this.sug = ((Map)new LinkedHashMap());
    if (Looper.myLooper() == null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      this.sui = new b(this, localLooper);
      AppMethodBeat.o(10446);
      return;
    }
  }
  
  private static String a(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10431);
    Object localObject1 = ((Iterable)paramCollection).iterator();
    for (paramCollection = ""; ((Iterator)localObject1).hasNext(); paramCollection = paramCollection + ((HandOff)localObject2).cFx()) {
      localObject2 = (HandOff)((Iterator)localObject1).next();
    }
    localObject1 = new StringBuilder("<handofflist opcode=\"").append(paramInt).append("\" seq=\"<![CSEQ]>\" deviceid=\"").append(com.tencent.mm.compatible.deviceinfo.q.Xa()).append("\" networkstatus=\"");
    Object localObject2 = ay.iw(aj.getContext());
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
  
  private final void adC(String paramString)
  {
    AppMethodBeat.i(10438);
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.afz();
    k.g(locala, "account()");
    if (locala.aeG())
    {
      if ((bu.eGT()) || (this.sub))
      {
        paramString = d.n.n.h(paramString, "<![CSEQ]>", String.valueOf(this.suh), false);
        ad.i("HandOff.StatusManager", "send handoff: ".concat(String.valueOf(paramString)));
        aa.bm(paramString, "HandOffMaster");
        AppMethodBeat.o(10438);
        return;
      }
      ad.i("HandOff.StatusManager", "debugger: " + bu.eGT() + ", handoff enabled: " + this.sub + ", don't send handoff: " + paramString);
      AppMethodBeat.o(10438);
      return;
    }
    ad.i("HandOff.StatusManager", "device offline, don't send handoff: ".concat(String.valueOf(paramString)));
    this.stY.poll();
    cFC();
    AppMethodBeat.o(10438);
  }
  
  private final void apply()
  {
    AppMethodBeat.i(10443);
    if (!this.sui.hasMessages(1))
    {
      ad.d("HandOff.StatusManager", "plan commit task");
      this.sui.sendEmptyMessageDelayed(1, 2000L);
    }
    AppMethodBeat.o(10443);
  }
  
  private final void cFB()
  {
    AppMethodBeat.i(10436);
    this.suc.clear();
    this.sud.clear();
    this.sue.clear();
    this.suf.clear();
    this.sug.clear();
    AppMethodBeat.o(10436);
  }
  
  private final void cFC()
  {
    AppMethodBeat.i(10441);
    if (this.stY.isEmpty())
    {
      ad.i("HandOff.StatusManager", "message queue is empty, set queueWorking = false");
      this.stX = false;
      AppMethodBeat.o(10441);
      return;
    }
    try
    {
      String str = (String)this.stY.getFirst();
      k.g(str, "msg");
      adC(str);
      AppMethodBeat.o(10441);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "", new Object[0]);
      this.stX = false;
      AppMethodBeat.o(10441);
    }
  }
  
  private final void cFE()
  {
    AppMethodBeat.i(10444);
    com.tencent.mm.al.q localq = com.tencent.mm.kernel.g.aeS();
    k.g(localq, "MMKernel.getNetSceneQueue()");
    int i = localq.auR();
    boolean bool;
    if ((i == 4) || (i == 6))
    {
      bool = true;
      if (bool) {
        break label84;
      }
      ad.i("HandOff.StatusManager", "network unavailable, clear message queue and retry after 30s");
      this.stY.clear();
      this.sui.sendEmptyMessageDelayed(2, 30000L);
    }
    for (;;)
    {
      this.stZ = bool;
      AppMethodBeat.o(10444);
      return;
      bool = false;
      break;
      label84:
      if (!this.stZ)
      {
        ad.i("HandOff.StatusManager", "network become available, send all list");
        a.stG.cFt();
      }
      cFC();
    }
  }
  
  final void b(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10439);
    paramCollection = a(paramInt, paramCollection);
    this.stY.add(paramCollection);
    cFD();
    AppMethodBeat.o(10439);
  }
  
  final void cFD()
  {
    AppMethodBeat.i(10442);
    if (!this.stX)
    {
      ad.i("HandOff.StatusManager", "launch queue, set queueWorking = true");
      this.stX = true;
      cFC();
    }
    AppMethodBeat.o(10442);
  }
  
  public final void j(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10430);
    k.h(paramCollection, "handOffList");
    try
    {
      Object localObject = com.tencent.mm.kernel.g.afB();
      k.g(localObject, "storage()");
      this.suh = ((e)localObject).afk().a(ae.a.FvA, 0L);
      localObject = com.tencent.mm.kernel.g.afA();
      k.g(localObject, "network()");
      ((com.tencent.mm.kernel.b)localObject).aeS().a(251, (com.tencent.mm.al.g)this);
      b(4, paramCollection);
      AppMethodBeat.o(10430);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "restoreFromBallInfoList fail, exp:%s", new Object[] { localException });
        this.suh = 0L;
      }
    }
  }
  
  public final void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(10432);
    k.h(paramHandOff, "handOff");
    if (!this.suf.containsKey(paramHandOff.key)) {
      this.suf.put(paramHandOff.key, Boolean.FALSE);
    }
    this.sue.remove(paramHandOff.key);
    this.suc.put(paramHandOff.key, paramHandOff);
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
    if (!this.suf.containsKey(paramHandOff.key))
    {
      this.suf.put(paramHandOff.key, Boolean.TRUE);
      this.sug.put(paramHandOff.key, paramHandOff.id);
    }
    this.sue.remove(paramHandOff.key);
    if (this.suc.containsKey(paramHandOff.key))
    {
      Object localObject = this.suc.get(paramHandOff.key);
      if (localObject == null) {
        k.fvU();
      }
      ((HandOff)localObject).j(paramHandOff);
    }
    for (;;)
    {
      apply();
      AppMethodBeat.o(10433);
      return;
      this.sud.put(paramHandOff.key, paramHandOff);
    }
  }
  
  public final void l(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10437);
    k.h(paramCollection, "handOffList");
    this.sui.removeMessages(1);
    cFB();
    b(4, paramCollection);
    AppMethodBeat.o(10437);
  }
  
  public final void m(HandOff paramHandOff)
  {
    AppMethodBeat.i(10434);
    k.h(paramHandOff, "handOff");
    if (!this.suf.containsKey(paramHandOff.key))
    {
      this.suf.put(paramHandOff.key, Boolean.TRUE);
      this.sug.put(paramHandOff.key, paramHandOff.id);
    }
    this.suc.remove(paramHandOff.key);
    this.sud.remove(paramHandOff.key);
    this.sue.put(paramHandOff.key, paramHandOff);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(10445);
    k.h(paramn, "scene");
    if ((paramn.getReqResp() instanceof com.tencent.mm.al.b))
    {
      paramString = paramn.getReqResp();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(10445);
        throw paramString;
      }
      if ((((com.tencent.mm.al.b)paramString).auL() instanceof cxm))
      {
        paramString = paramn.getReqResp();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((com.tencent.mm.al.b)paramString).auL();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StatusNotifyRequest");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((cxm)paramString).EpC;
        if (paramString != null)
        {
          if (k.g(paramString.Name, "HandOffMaster"))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.stY.poll();
              this.retryCount = 0;
              if (this.suh == 9223372036854775807L) {
                this.suh = 0L;
              }
              this.suh += 1L;
              paramString = com.tencent.mm.kernel.g.afB();
              k.g(paramString, "storage()");
              paramString.afk().set(ae.a.FvA, Long.valueOf(this.suh));
              ad.i("HandOff.StatusManager", "send handoff succeed, check next message");
              cFC();
              AppMethodBeat.o(10445);
              return;
            }
            this.retryCount += 1;
            if (this.retryCount >= this.sua)
            {
              this.stY.poll();
              this.retryCount = 0;
            }
            ad.i("HandOff.StatusManager", "send handoff failed, retry: " + this.retryCount);
            cFE();
          }
          AppMethodBeat.o(10445);
          return;
        }
      }
    }
    AppMethodBeat.o(10445);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
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
      k.h(paramMessage, "msg");
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(10429);
        return;
        ad.d("HandOff.StatusManager", "handle commit message");
        c.a(this.suk);
        AppMethodBeat.o(10429);
        return;
        ad.d("HandOff.StatusManager", "handle retry message");
        c.b(this.suk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.c
 * JD-Core Version:    0.7.0.1
 */