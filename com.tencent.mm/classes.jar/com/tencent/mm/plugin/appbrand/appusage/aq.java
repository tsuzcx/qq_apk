package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.app.q.a;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaStarAndHistoryPushingReceiver;", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "()V", "TAG", "", "THREAD_TAG", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "forcePendingUpdateHistoryAndStar", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasPendingFetchHistoryAndStarTask", "", "isAppBackground", "fetchStartAndHistory", "", "onDeleteMsg", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "parseWxaInfo", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaInfo;", "values", "", "prefix", "process", "xml", "processPendingFetching", "register", "unregister", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  implements cl.a
{
  private static final String THREAD_TAG;
  public static final q.a appForegroundListener;
  public static final aq qQD;
  private static volatile boolean qQE;
  private static volatile boolean qQF;
  private static AtomicBoolean qQG;
  
  static
  {
    AppMethodBeat.i(319364);
    aq localaq = new aq();
    qQD = localaq;
    THREAD_TAG = String.valueOf(localaq.hashCode());
    qQE = true;
    qQG = new AtomicBoolean(true);
    appForegroundListener = (q.a)new b();
    AppMethodBeat.o(319364);
  }
  
  public static void cjp()
  {
    AppMethodBeat.i(319352);
    if (qQF)
    {
      qQF = false;
      d.e(THREAD_TAG, (a)e.qQJ);
    }
    AppMethodBeat.o(319352);
  }
  
  private static void cjq()
  {
    AppMethodBeat.i(319355);
    Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "fetchStartAndHistory");
    i.ciJ().a(Util.nowMilliSecond(), true, null, 4, 0);
    AppMethodBeat.o(319355);
  }
  
  private static List<ap> g(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(319356);
    int k = Util.getInt((String)paramMap.get(s.X(paramString, ".DeleteCount")), 0);
    List localList = (List)new ArrayList();
    if ((k > 0) && (k > 0)) {}
    int j;
    label258:
    label263:
    label268:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject2 = new StringBuilder().append(paramString).append(".DeleteList.DeleteAppInfo");
      Object localObject1;
      int m;
      if (i == 0)
      {
        localObject1 = "";
        Object localObject3 = localObject1;
        localObject1 = (String)paramMap.get(s.X((String)localObject3, ".UserName"));
        localObject2 = (String)paramMap.get(s.X((String)localObject3, ".AppID"));
        m = Util.getInt((String)paramMap.get(s.X((String)localObject3, ".AppType")), 0);
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label258;
        }
        i = 1;
        label181:
        if (i == 0)
        {
          localObject3 = (CharSequence)localObject2;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label263;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          localList.add(new ap((String)localObject1, (String)localObject2, m));
        }
        if (j < k) {
          break label268;
        }
        AppMethodBeat.o(319356);
        return localList;
        localObject1 = Integer.valueOf(i);
        break;
        i = 0;
        break label181;
      }
    }
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(319366);
    s.u(parama, "addMsgInfo");
    parama = w.a(parama.mpN.YFG);
    if (Util.isNullOrNil(parama))
    {
      AppMethodBeat.o(319366);
      return;
    }
    d.e(THREAD_TAG, (a)new c(parama));
    AppMethodBeat.o(319366);
  }
  
  public final void a(g.c paramc) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appusage/WxaStarAndHistoryPushingReceiver$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends q.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(319294);
      s.u(paramString, "activity");
      Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "onAppBackground");
      paramString = aq.qQD;
      aq.io(true);
      AppMethodBeat.o(319294);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(319290);
      s.u(paramString, "activity");
      Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "onAppForeground");
      paramString = aq.qQD;
      aq.io(false);
      paramString = aq.qQD;
      aq.cjp();
      AppMethodBeat.o(319290);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    public static final d qQI;
    
    static
    {
      AppMethodBeat.i(319287);
      qQI = new d();
      AppMethodBeat.o(319287);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    public static final e qQJ;
    
    static
    {
      AppMethodBeat.i(319286);
      qQJ = new e();
      AppMethodBeat.o(319286);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aq
 * JD-Core Version:    0.7.0.1
 */