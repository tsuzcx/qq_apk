package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.app.o.a;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaStarAndHistoryPushingReceiver;", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "()V", "TAG", "", "THREAD_TAG", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "forcePendingUpdateHistoryAndStar", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasPendingFetchHistoryAndStarTask", "", "isAppBackground", "fetchStartAndHistory", "", "onDeleteMsg", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "parseWxaInfo", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaInfo;", "values", "", "prefix", "process", "xml", "processPendingFetching", "register", "unregister", "plugin-appbrand-integration_release"})
public final class ar
  implements cj.a
{
  public static final o.a appForegroundListener;
  private static final String kWD;
  private static volatile boolean kWE;
  private static volatile boolean kWF;
  private static AtomicBoolean kWG;
  public static final ar kWH;
  
  static
  {
    AppMethodBeat.i(228147);
    ar localar = new ar();
    kWH = localar;
    kWD = String.valueOf(localar.hashCode());
    kWE = true;
    kWG = new AtomicBoolean(true);
    appForegroundListener = (o.a)new a();
    AppMethodBeat.o(228147);
  }
  
  public static void byx()
  {
    AppMethodBeat.i(228143);
    if (kWF)
    {
      kWF = false;
      d.c(kWD, (a)d.kWK);
    }
    AppMethodBeat.o(228143);
  }
  
  private static void byy()
  {
    AppMethodBeat.i(228145);
    Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "fetchStartAndHistory");
    j.bxQ().a(Util.nowMilliSecond(), true, null, 4, 0);
    AppMethodBeat.o(228145);
  }
  
  private static List<aq> e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(228146);
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
    AppMethodBeat.o(228146);
    return localList;
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(228144);
    p.h(parama, "addMsgInfo");
    parama = z.a(parama.heO.KHn);
    if (Util.isNullOrNil(parama))
    {
      AppMethodBeat.o(228144);
      return;
    }
    d.c(kWD, (a)new b(parama));
    AppMethodBeat.o(228144);
  }
  
  public final void a(h.c paramc) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appusage/WxaStarAndHistoryPushingReceiver$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-appbrand-integration_release"})
  public static final class a
    extends o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(228137);
      p.h(paramString, "activity");
      Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "onAppBackground");
      paramString = ar.kWH;
      ar.gM(true);
      AppMethodBeat.o(228137);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(228136);
      p.h(paramString, "activity");
      Log.i("MicroMsg.WxaStarAndHistoryPushingReceiver", "onAppForeground");
      paramString = ar.kWH;
      ar.gM(false);
      paramString = ar.kWH;
      ar.byx();
      AppMethodBeat.o(228136);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    public static final c kWJ;
    
    static
    {
      AppMethodBeat.i(228140);
      kWJ = new c();
      AppMethodBeat.o(228140);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    public static final d kWK;
    
    static
    {
      AppMethodBeat.i(228142);
      kWK = new d();
      AppMethodBeat.o(228142);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ar
 * JD-Core Version:    0.7.0.1
 */