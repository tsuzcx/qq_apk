package com.tencent.mm.plugin.finder.live;

import com.tencent.c.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveNotifyReplaceManager;", "", "()V", "INTERVAL", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "hasLaunchCollectTimer", "", "newTipsIdList", "", "kotlin.jvm.PlatformType", "", "replaceableTipsIdList", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "Lkotlin/Lazy;", "doReport", "", "getTipsId", "info", "Lcom/tencent/mm/storage/MsgInfo;", "replaceNotify", "newMsgInfo", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "FinderLiveNotifyReplaceManager";
  public static final i xVA;
  private static volatile boolean xVw;
  private static final List<String> xVx;
  private static final List<String> xVy;
  private static final kotlin.f xVz;
  
  static
  {
    AppMethodBeat.i(290593);
    xVA = new i();
    TAG = "FinderLiveNotifyReplaceManager";
    xVx = Collections.synchronizedList((List)new ArrayList());
    xVy = Collections.synchronizedList((List)new ArrayList());
    xVz = g.ar((a)b.xVC);
    AppMethodBeat.o(290593);
  }
  
  public static void aE(ca paramca)
  {
    AppMethodBeat.i(290592);
    p.k(paramca, "newMsgInfo");
    com.tencent.e.h.ZvG.bg((Runnable)new a(paramca));
    AppMethodBeat.o(290592);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  private static MTimerHandler getTimeHandler()
  {
    AppMethodBeat.i(290591);
    MTimerHandler localMTimerHandler = (MTimerHandler)xVz.getValue();
    AppMethodBeat.o(290591);
    return localMTimerHandler;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ca paramca) {}
    
    public final void run()
    {
      AppMethodBeat.i(282111);
      Object localObject1 = i.xVA;
      Object localObject2;
      int i;
      if (!i.dwA())
      {
        localObject1 = i.xVA;
        Log.i(i.getTAG(), "[replaceNotify] start collect timer");
        localObject1 = i.xVA;
        i.dwB();
        localObject1 = i.xVA;
        i.dwC().startTimer(1000L);
        long l = ((b)com.tencent.mm.kernel.h.ag(b.class)).getFinderLiveNotifyExposureInfoStorage().dDP();
        localObject1 = i.xVA;
        localObject2 = i.aF(this.xVB);
        if (l == -1L) {
          break label497;
        }
        localObject1 = com.tencent.mm.kernel.h.ae(n.class);
        p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        localObject1 = ((n)localObject1).eSe().Oq(l);
        p.j(localObject1, "it");
        if ((((ca)localObject1).apG() <= 0L) || (!p.h(((ca)localObject1).apJ(), "notifymessage"))) {
          break label486;
        }
        i = 1;
        label154:
        if (i == 0) {
          break label491;
        }
        label158:
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = i.xVA;
          localObject3 = i.aF((ca)localObject1);
          Object localObject4 = i.xVA;
          Log.i(i.getTAG(), "[replaceNotify] newTipsId = " + (String)localObject2 + ",replaceTipsId = " + (String)localObject3);
          localObject4 = com.tencent.mm.kernel.h.ae(n.class);
          p.j(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          i = ((n)localObject4).eSe().Or(((ca)localObject1).apG());
          ((b)com.tencent.mm.kernel.h.ag(b.class)).getFinderLiveNotifyExposureInfoStorage().Lu(l);
          if (i > 0)
          {
            localObject1 = com.tencent.mm.kernel.h.ae(n.class);
            p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
            localObject1 = ((n)localObject1).bbR().bwx("notifymessage");
            if ((localObject1 != null) && (((az)localObject1).apz() > 0))
            {
              ((az)localObject1).pH(((az)localObject1).apz() - 1);
              localObject4 = com.tencent.mm.kernel.h.ae(n.class);
              p.j(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
              ((n)localObject4).bbR().a((az)localObject1, "notifymessage");
            }
          }
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = i.xVA;
          localObject1 = null;
        }
        label379:
        if (((CharSequence)localObject2).length() <= 0) {
          break label536;
        }
        i = 1;
        label394:
        if (i == 0) {
          break label541;
        }
        label398:
        if (localObject2 != null)
        {
          localObject3 = i.xVA;
          i.dwD().add(localObject2);
        }
        if (localObject1 == null) {
          break label558;
        }
        if (((CharSequence)localObject1).length() <= 0) {
          break label547;
        }
        i = 1;
        label439:
        if (i == 0) {
          break label552;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label558;
        }
        localObject2 = i.xVA;
        i.dwE().add(localObject1);
        AppMethodBeat.o(282111);
        return;
        localObject1 = i.xVA;
        Log.i(i.getTAG(), "[replaceNotify] collect timer already start");
        break;
        label486:
        i = 0;
        break label154;
        label491:
        localObject1 = null;
        break label158;
        label497:
        localObject1 = i.xVA;
        Log.i(i.getTAG(), "[replaceNotify] newTipsId = " + (String)localObject2 + " ,no replaceable msg");
        localObject1 = null;
        break label379;
        label536:
        i = 0;
        break label394;
        label541:
        localObject2 = null;
        break label398;
        label547:
        i = 0;
        break label439;
        label552:
        localObject1 = null;
      }
      label558:
      AppMethodBeat.o(282111);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
  static final class b
    extends q
    implements a<MTimerHandler>
  {
    public static final b xVC;
    
    static
    {
      AppMethodBeat.i(274259);
      xVC = new b();
      AppMethodBeat.o(274259);
    }
    
    b()
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
    static final class a
      implements MTimerHandler.CallBack
    {
      public static final a xVD;
      
      static
      {
        AppMethodBeat.i(279307);
        xVD = new a();
        AppMethodBeat.o(279307);
      }
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(279306);
        i locali = i.xVA;
        i.dwF();
        AppMethodBeat.o(279306);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.i
 * JD-Core Version:    0.7.0.1
 */