package com.tencent.mm.plugin.handoff.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.protocal.protobuf.ems;
import com.tencent.mm.protocal.protobuf.emt;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handOffEnable", "getHandOffEnable", "()Z", "handOffSeq", "", "handler", "com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/plugin/handoff/service/StatusManager$handler$1;", "ids", "maxRetryCount", "", "modList", "msgQueue", "Ljava/util/LinkedList;", "networkAvailable", "networkStatus", "nextSeq", "queueWorking", "retryCount", "add", "", "handOff", "allList", "handOffList", "", "apply", "checkMsgQueue", "checkNetworkAvailableMM", "clearStatus", "commit", "del", "incSeq", "init", "launchSendTask", "mod", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "retry", "sendHandOff", "opCode", "msg", "sendOpenRequest", "uploadFail", "uploadSuccess", "uploading", "Companion", "plugin-handoff_release"})
public final class h
  implements i
{
  public static final h.a DsZ;
  private final Map<String, HandOff> DrW;
  private final Map<String, HandOff> DrX;
  private final Map<String, Boolean> DrY;
  private boolean DsP;
  final LinkedList<String> DsQ;
  private boolean DsR;
  private String DsS;
  private final int DsT;
  private final Map<String, HandOff> DsU;
  private final Map<String, String> DsV;
  private long DsW;
  private long DsX;
  private final b DsY;
  private int retryCount;
  
  static
  {
    AppMethodBeat.i(10447);
    DsZ = new h.a((byte)0);
    AppMethodBeat.o(10447);
  }
  
  public h(final Looper paramLooper)
  {
    AppMethodBeat.i(248224);
    this.DsQ = new LinkedList();
    this.DsR = true;
    this.DsS = "4G";
    this.DsT = 3;
    this.DrW = ((Map)new LinkedHashMap());
    this.DsU = ((Map)new LinkedHashMap());
    this.DrX = ((Map)new LinkedHashMap());
    this.DrY = ((Map)new LinkedHashMap());
    this.DsV = ((Map)new LinkedHashMap());
    this.DsY = new b(this, paramLooper, paramLooper);
    AppMethodBeat.o(248224);
  }
  
  private final void aLq(String paramString)
  {
    AppMethodBeat.i(10438);
    if ((WeChatEnvironment.hasDebugger()) || (eCb()))
    {
      for (this.DsX = this.DsW; n.a((CharSequence)paramString, (CharSequence)"<![CSEQ]>", false); this.DsX += 1L)
      {
        paramString = n.bx(paramString, "<![CSEQ]>", String.valueOf(this.DsX));
        if (this.DsX == 9223372036854775807L) {
          this.DsX = 0L;
        }
      }
      Log.i("HandOff.StatusManager", "send handoff: ".concat(String.valueOf(paramString)));
      if (!ab.bC(paramString, "HandOffMaster"))
      {
        eCf();
        AppMethodBeat.o(10438);
      }
    }
    else
    {
      Log.i("HandOff.StatusManager", "debugger: " + WeChatEnvironment.hasDebugger() + ", handoff enabled: " + eCb() + ", don't send handoff: " + paramString);
      this.DsQ.poll();
      eCd();
    }
    AppMethodBeat.o(10438);
  }
  
  private static boolean eCb()
  {
    AppMethodBeat.i(248210);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFC, false);
    AppMethodBeat.o(248210);
    return bool;
  }
  
  private final void eCc()
  {
    AppMethodBeat.i(10436);
    this.DrW.clear();
    this.DsU.clear();
    this.DrX.clear();
    this.DrY.clear();
    this.DsV.clear();
    AppMethodBeat.o(10436);
  }
  
  private final void eCd()
  {
    AppMethodBeat.i(10441);
    if (this.DsQ.isEmpty())
    {
      Log.i("HandOff.StatusManager", "message queue is empty, set queueWorking = false");
      this.DsP = false;
      AppMethodBeat.o(10441);
      return;
    }
    try
    {
      String str = (String)this.DsQ.getFirst();
      p.j(str, "msg");
      aLq(str);
      AppMethodBeat.o(10441);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "", new Object[0]);
      this.DsP = false;
      AppMethodBeat.o(10441);
    }
  }
  
  private final void eCf()
  {
    AppMethodBeat.i(10444);
    this.retryCount += 1;
    if (this.retryCount >= this.DsT)
    {
      this.DsQ.poll();
      this.retryCount = 0;
    }
    Log.i("HandOff.StatusManager", "send handoff failed, retry: " + this.retryCount);
    boolean bool = esx();
    if (!bool)
    {
      Log.i("HandOff.StatusManager", "network unavailable, clear message queue and retry after 30s");
      this.DsQ.clear();
      this.DsY.sendEmptyMessageDelayed(2, 30000L);
    }
    for (;;)
    {
      this.DsR = bool;
      AppMethodBeat.o(10444);
      return;
      if (!this.DsR)
      {
        Log.i("HandOff.StatusManager", "network become available, send all list");
        String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        p.j(str, "NetStatusUtil.getFormatedNetType(getContext())");
        this.DsS = str;
        e.Dso.eBI();
      }
      eCd();
    }
  }
  
  private static boolean esx()
  {
    AppMethodBeat.i(248219);
    com.tencent.mm.an.t localt = com.tencent.mm.kernel.h.aGY();
    p.j(localt, "MMKernel.getNetSceneQueue()");
    int i = localt.bih();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(248219);
      return true;
    }
    AppMethodBeat.o(248219);
    return false;
  }
  
  final void a(int paramInt, Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10439);
    paramCollection = new com.tencent.mm.plugin.handoff.model.b(paramInt, paramCollection, 0L, 4);
    String str = com.tencent.mm.compatible.deviceinfo.q.auM();
    p.j(str, "DeviceInfo.getMMGUID()");
    paramCollection = paramCollection.Z(str, this.DsS, a.eBN());
    this.DsQ.add(paramCollection);
    eCe();
    AppMethodBeat.o(10439);
  }
  
  final void apply()
  {
    AppMethodBeat.i(10443);
    if (!this.DsY.hasMessages(1))
    {
      Log.d("HandOff.StatusManager", "plan commit task");
      this.DsY.sendEmptyMessageDelayed(1, 2000L);
    }
    AppMethodBeat.o(10443);
  }
  
  final void eCe()
  {
    AppMethodBeat.i(10442);
    if (!this.DsP)
    {
      Log.i("HandOff.StatusManager", "launch queue, set queueWorking = true");
      this.DsP = true;
      eCd();
    }
    AppMethodBeat.o(10442);
  }
  
  public final void k(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10430);
    p.k(paramCollection, "handOffList");
    try
    {
      Object localObject = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
      p.j(localObject, "NetStatusUtil.getFormatedNetType(getContext())");
      this.DsS = ((String)localObject);
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "storage()");
      this.DsW = ((f)localObject).aHp().a(ar.a.Vxv, 0L);
      localObject = com.tencent.mm.kernel.h.aHF();
      p.j(localObject, "network()");
      ((c)localObject).aGY().a(251, (i)this);
      a(4, paramCollection);
      AppMethodBeat.o(10430);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("HandOff.StatusManager", (Throwable)localException, "restoreFromBallInfoList fail, exp:%s", new Object[] { localException });
        this.DsW = 0L;
      }
    }
  }
  
  public final void l(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10435);
    p.k(paramCollection, "handOffList");
    paramCollection = ((Iterable)paramCollection).iterator();
    while (paramCollection.hasNext()) {
      n((HandOff)paramCollection.next());
    }
    AppMethodBeat.o(10435);
  }
  
  public final void m(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(10437);
    p.k(paramCollection, "handOffList");
    this.DsY.removeMessages(1);
    eCc();
    a(4, paramCollection);
    AppMethodBeat.o(10437);
  }
  
  public final void n(HandOff paramHandOff)
  {
    AppMethodBeat.i(10434);
    p.k(paramHandOff, "handOff");
    apply();
    AppMethodBeat.o(10434);
  }
  
  public final void o(HandOff paramHandOff)
  {
    AppMethodBeat.i(10440);
    p.k(paramHandOff, "handOff");
    a(3, (Collection)j.listOf(paramHandOff));
    AppMethodBeat.o(10440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(10445);
    p.k(paramq, "scene");
    if ((paramq.getReqResp() instanceof d))
    {
      paramString = paramq.getReqResp();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(10445);
        throw paramString;
      }
      if ((((d)paramString).bhX() instanceof emt))
      {
        paramString = paramq.getReqResp();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((d)paramString).bhX();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StatusNotifyRequest");
          AppMethodBeat.o(10445);
          throw paramString;
        }
        paramString = ((emt)paramString).Upy;
        if (paramString != null)
        {
          if (p.h(paramString.CMP, "HandOffMaster"))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.DsQ.poll();
              this.retryCount = 0;
              this.DsW = this.DsX;
              paramString = com.tencent.mm.kernel.h.aHG();
              p.j(paramString, "storage()");
              paramString.aHp().set(ar.a.Vxv, Long.valueOf(this.DsW));
              Log.i("HandOff.StatusManager", "send handoff succeed, check next message");
              eCd();
              AppMethodBeat.o(10445);
              return;
            }
            Log.e("HandOff.StatusManager", "send handoff fail, errType:" + paramInt1 + ", errCode:" + paramInt2);
            eCf();
          }
          AppMethodBeat.o(10445);
          return;
        }
      }
    }
    AppMethodBeat.o(10445);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/handoff/service/StatusManager$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
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
      p.k(paramMessage, "msg");
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(10429);
        return;
        Log.d("HandOff.StatusManager", "handle commit message");
        e.Dso.eBI();
        AppMethodBeat.o(10429);
        return;
        Log.d("HandOff.StatusManager", "handle retry message");
        h.a(this.Dta);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.h
 * JD-Core Version:    0.7.0.1
 */