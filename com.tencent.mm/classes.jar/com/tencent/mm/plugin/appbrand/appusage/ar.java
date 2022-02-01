package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.app.o.a;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaStarAndHistoryPushingReceiver;", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "()V", "TAG", "", "THREAD_TAG", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "forcePendingUpdateHistoryAndStar", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasPendingFetchHistoryAndStarTask", "", "isAppBackground", "fetchStartAndHistory", "", "onDeleteMsg", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "parseWxaInfo", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaInfo;", "values", "", "prefix", "process", "xml", "processPendingFetching", "register", "unregister", "plugin-appbrand-integration_release"})
public final class ar
  implements ck.a
{
  private static final String THREAD_TAG;
  public static final o.a appForegroundListener;
  private static volatile boolean nQQ;
  private static volatile boolean nQR;
  private static AtomicBoolean nQS;
  public static final ar nQT;
  
  static
  {
    AppMethodBeat.i(268524);
    ar localar = new ar();
    nQT = localar;
    THREAD_TAG = String.valueOf(localar.hashCode());
    nQQ = true;
    nQS = new AtomicBoolean(true);
    appForegroundListener = (o.a)new a();
    AppMethodBeat.o(268524);
  }
  
  public static void bJL()
  {
    AppMethodBeat.i(268518);
    if (nQR)
    {
      nQR = false;
      d.c(THREAD_TAG, (a)d.nQW);
    }
    AppMethodBeat.o(268518);
  }
  
  private static void bJM()
  {
    AppMethodBeat.i(268522);
    Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "fetchStartAndHistory");
    j.bJf().a(Util.nowMilliSecond(), true, null, 4, 0);
    AppMethodBeat.o(268522);
  }
  
  private static List<aq> e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(268523);
    int k = Util.getInt((String)paramMap.get(paramString + ".DeleteCount"), 0);
    List localList = (List)new ArrayList();
    if (k > 0)
    {
      int i = 0;
      if (i < k)
      {
        Object localObject2 = new StringBuilder().append(paramString).append(".DeleteList.DeleteAppInfo");
        Object localObject1;
        label94:
        int m;
        if (i == 0)
        {
          localObject1 = "";
          Object localObject3 = localObject1;
          localObject1 = (String)paramMap.get((String)localObject3 + ".UserName");
          localObject2 = (String)paramMap.get((String)localObject3 + ".AppID");
          m = Util.getInt((String)paramMap.get((String)localObject3 + ".AppType"), 0);
          localObject3 = (CharSequence)localObject1;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label299;
          }
          j = 1;
          label230:
          if (j == 0)
          {
            localObject3 = (CharSequence)localObject2;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label304;
            }
          }
        }
        label299:
        label304:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            localList.add(new aq((String)localObject1, (String)localObject2, m));
          }
          i += 1;
          break;
          localObject1 = Integer.valueOf(i);
          break label94;
          j = 0;
          break label230;
        }
      }
    }
    AppMethodBeat.o(268523);
    return localList;
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(268520);
    p.k(parama, "addMsgInfo");
    parama = z.a(parama.jQG.RIF);
    if (Util.isNullOrNil(parama))
    {
      AppMethodBeat.o(268520);
      return;
    }
    d.c(THREAD_TAG, (a)new b(parama));
    AppMethodBeat.o(268520);
  }
  
  public final void a(h.c paramc) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appusage/WxaStarAndHistoryPushingReceiver$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-appbrand-integration_release"})
  public static final class a
    extends o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(268274);
      p.k(paramString, "activity");
      Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "onAppBackground");
      paramString = ar.nQT;
      ar.hx(true);
      AppMethodBeat.o(268274);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(268271);
      p.k(paramString, "activity");
      Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "onAppForeground");
      paramString = ar.nQT;
      ar.hx(false);
      paramString = ar.nQT;
      ar.bJL();
      AppMethodBeat.o(268271);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    public static final c nQV;
    
    static
    {
      AppMethodBeat.i(260110);
      nQV = new c();
      AppMethodBeat.o(260110);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    public static final d nQW;
    
    static
    {
      AppMethodBeat.i(284700);
      nQW = new d();
      AppMethodBeat.o(284700);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ar
 * JD-Core Version:    0.7.0.1
 */