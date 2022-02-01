package com.tencent.mm.plugin.handoff.b;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handOffEnable", "handOffSeq", "", "handler", "com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/plugin/handoff/service/StatusManager$handler$1;", "ids", "maxRetryCount", "", "modList", "msgQueue", "Ljava/util/LinkedList;", "networkAvailable", "queueWorking", "retryCount", "add", "", "handOff", "allList", "handOffList", "", "apply", "buildHandOffList", "opCode", "arg", "items", "checkMsgQueue", "checkNetworkAvailableMM", "clearStatus", "commit", "del", "incSeq", "init", "launchSendTask", "mod", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "retry", "sendHandOff", "msg", "sendOpenRequest", "uploadFail", "uploadSuccess", "uploading", "Companion", "plugin-handoff_release"})
public final class d
  implements f
{
  public static final d.a uQv;
  private int retryCount;
  private boolean uQj;
  final LinkedList<String> uQk;
  private boolean uQl;
  private final int uQm;
  private final boolean uQn;
  final Map<String, HandOff> uQo;
  final Map<String, HandOff> uQp;
  final Map<String, HandOff> uQq;
  final Map<String, Boolean> uQr;
  final Map<String, String> uQs;
  private long uQt;
  private final b uQu;
  
  static
  {
    AppMethodBeat.i(10447);
    uQv = new d.a((byte)0);
    AppMethodBeat.o(10447);
  }
  
  public d()
  {
    AppMethodBeat.i(10446);
    this.uQk = new LinkedList();
    this.uQl = true;
    this.uQm = 3;
    this.uQn = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFt, false);
    this.uQo = ((Map)new LinkedHashMap());
    this.uQp = ((Map)new LinkedHashMap());
    this.uQq = ((Map)new LinkedHashMap());
    this.uQr = ((Map)new LinkedHashMap());
    this.uQs = ((Map)new LinkedHashMap());
    if (Looper.myLooper() == null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      this.uQu = new b(this, localLooper);
      AppMethodBeat.o(10446);
      return;
    }
  }
  
  private static String a(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10431);
    Object localObject1 = ((Iterable)paramCollection).iterator();
    for (paramCollection = ""; ((Iterator)localObject1).hasNext(); paramCollection = paramCollection + ((HandOff)localObject2).deF()) {
      localObject2 = (HandOff)((Iterator)localObject1).next();
    }
    localObject1 = new StringBuilder("<handofflist opcode=\"").append(paramInt).append("\" seq=\"<![CSEQ]>\" deviceid=\"").append(com.tencent.mm.compatible.deviceinfo.q.aaH()).append("\" networkstatus=\"");
    Object localObject2 = az.iW(ak.getContext());
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
  
  private final void aoj(String paramString)
  {
    AppMethodBeat.i(10438);
    com.tencent.mm.kernel.a locala = g.ajP();
    p.g(locala, "account()");
    if (locala.aiX())
    {
      if ((bv.fpT()) || (this.uQn))
      {
        paramString = d.n.n.h(paramString, "<![CSEQ]>", String.valueOf(this.uQt), false);
        ae.i("HandOff.StatusManager", "send handoff: ".concat(String.valueOf(paramString)));
        ab.bv(paramString, "HandOffMaster");
        AppMethodBeat.o(10438);
        return;
      }
      ae.i("HandOff.StatusManager", "debugger: " + bv.fpT() + ", handoff enabled: " + this.uQn + ", don't send handoff: " + paramString);
      AppMethodBeat.o(10438);
      return;
    }
    ae.i("HandOff.StatusManager", "device offline, don't send handoff: ".concat(String.valueOf(paramString)));
    this.uQk.poll();
    deL();
    AppMethodBeat.o(10438);
  }
  
  private final void deK()
  {
    AppMethodBeat.i(10436);
    this.uQo.clear();
    this.uQp.clear();
    this.uQq.clear();
    this.uQr.clear();
    this.uQs.clear();
    AppMethodBeat.o(10436);
  }
  
  private final void deL()
  {
    AppMethodBeat.i(10441);
    if (this.uQk.isEmpty())
    {
      ae.i("HandOff.StatusManager", "message queue is empty, set queueWorking = false");
      this.uQj = false;
      AppMethodBeat.o(10441);
      return;
    }
    try
    {
      String str = (String)this.uQk.getFirst();
      p.g(str, "msg");
      aoj(str);
      AppMethodBeat.o(10441);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "", new Object[0]);
      this.uQj = false;
      AppMethodBeat.o(10441);
    }
  }
  
  private final void deN()
  {
    AppMethodBeat.i(10444);
    com.tencent.mm.ak.q localq = g.ajj();
    p.g(localq, "MMKernel.getNetSceneQueue()");
    int i = localq.aFd();
    boolean bool;
    if ((i == 4) || (i == 6))
    {
      bool = true;
      if (bool) {
        break label84;
      }
      ae.i("HandOff.StatusManager", "network unavailable, clear message queue and retry after 30s");
      this.uQk.clear();
      this.uQu.sendEmptyMessageDelayed(2, 30000L);
    }
    for (;;)
    {
      this.uQl = bool;
      AppMethodBeat.o(10444);
      return;
      bool = false;
      break;
      label84:
      if (!this.uQl)
      {
        ae.i("HandOff.StatusManager", "network become available, send all list");
        a.uPL.deB();
      }
      deL();
    }
  }
  
  final void apply()
  {
    AppMethodBeat.i(10443);
    if (!this.uQu.hasMessages(1))
    {
      ae.d("HandOff.StatusManager", "plan commit task");
      this.uQu.sendEmptyMessageDelayed(1, 2000L);
    }
    AppMethodBeat.o(10443);
  }
  
  final void b(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10439);
    paramCollection = a(paramInt, paramCollection);
    this.uQk.add(paramCollection);
    deM();
    AppMethodBeat.o(10439);
  }
  
  final void deM()
  {
    AppMethodBeat.i(10442);
    if (!this.uQj)
    {
      ae.i("HandOff.StatusManager", "launch queue, set queueWorking = true");
      this.uQj = true;
      deL();
    }
    AppMethodBeat.o(10442);
  }
  
  public final void j(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10430);
    p.h(paramCollection, "handOffList");
    try
    {
      Object localObject = g.ajR();
      p.g(localObject, "storage()");
      this.uQt = ((e)localObject).ajA().a(am.a.Jaz, 0L);
      localObject = g.ajQ();
      p.g(localObject, "network()");
      ((com.tencent.mm.kernel.b)localObject).ajj().a(251, (f)this);
      b(4, paramCollection);
      AppMethodBeat.o(10430);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "restoreFromBallInfoList fail, exp:%s", new Object[] { localException });
        this.uQt = 0L;
      }
    }
  }
  
  public final void k(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10435);
    p.h(paramCollection, "handOffList");
    paramCollection = ((Iterable)paramCollection).iterator();
    while (paramCollection.hasNext()) {
      n((HandOff)paramCollection.next());
    }
    AppMethodBeat.o(10435);
  }
  
  public final void l(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10437);
    p.h(paramCollection, "handOffList");
    this.uQu.removeMessages(1);
    deK();
    b(4, paramCollection);
    AppMethodBeat.o(10437);
  }
  
  public final void n(HandOff paramHandOff)
  {
    AppMethodBeat.i(10434);
    p.h(paramHandOff, "handOff");
    if (!this.uQr.containsKey(paramHandOff.key))
    {
      this.uQr.put(paramHandOff.key, Boolean.TRUE);
      this.uQs.put(paramHandOff.key, paramHandOff.id);
    }
    this.uQo.remove(paramHandOff.key);
    this.uQp.remove(paramHandOff.key);
    this.uQq.put(paramHandOff.key, paramHandOff);
    apply();
    AppMethodBeat.o(10434);
  }
  
  public final void o(HandOff paramHandOff)
  {
    AppMethodBeat.i(10440);
    p.h(paramHandOff, "handOff");
    b(3, (Collection)j.listOf(paramHandOff));
    AppMethodBeat.o(10440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(10445);
    p.h(paramn, "scene");
    if ((paramn.getReqResp() instanceof com.tencent.mm.ak.b))
    {
      paramString = paramn.getReqResp();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(10445);
        throw paramString;
      }
      if ((((com.tencent.mm.ak.b)paramString).aEU() instanceof djg))
      {
        paramString = paramn.getReqResp();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((com.tencent.mm.ak.b)paramString).aEU();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StatusNotifyRequest");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((djg)paramString).HRa;
        if (paramString != null)
        {
          if (p.i(paramString.Name, "HandOffMaster"))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.uQk.poll();
              this.retryCount = 0;
              if (this.uQt == 9223372036854775807L) {
                this.uQt = 0L;
              }
              this.uQt += 1L;
              paramString = g.ajR();
              p.g(paramString, "storage()");
              paramString.ajA().set(am.a.Jaz, Long.valueOf(this.uQt));
              ae.i("HandOff.StatusManager", "send handoff succeed, check next message");
              deL();
              AppMethodBeat.o(10445);
              return;
            }
            this.retryCount += 1;
            if (this.retryCount >= this.uQm)
            {
              this.uQk.poll();
              this.retryCount = 0;
            }
            ae.i("HandOff.StatusManager", "send handoff failed, retry: " + this.retryCount);
            deN();
          }
          AppMethodBeat.o(10445);
          return;
        }
      }
    }
    AppMethodBeat.o(10445);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
  @SuppressLint({"HandlerLeak"})
  public static final class b
    extends aq
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
        ae.d("HandOff.StatusManager", "handle commit message");
        d.a(this.uQw);
        AppMethodBeat.o(10429);
        return;
        ae.d("HandOff.StatusManager", "handle retry message");
        d.b(this.uQw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.d
 * JD-Core Version:    0.7.0.1
 */