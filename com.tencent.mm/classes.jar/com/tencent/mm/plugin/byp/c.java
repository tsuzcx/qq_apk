package com.tencent.mm.plugin.byp;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.av;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.vending.c.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/BypSyncCore;", "", "()V", "bypDispatcher", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "bysSyncHandlers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "getBysSyncHandlers", "()Ljava/util/concurrent/ConcurrentHashMap;", "newSyncEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "getNewSyncEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "serialExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "addSyncHandler", "", "bizSyncKeyType", "handler", "doSync", "selector", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "isContinue", "", "retryCount", "removeSyncHandler", "Companion", "SyncSource", "plugin-byp_release"})
public final class c
{
  public static final a sVZ;
  final ConcurrentHashMap<Integer, com.tencent.mm.plugin.byp.a.b> sVV;
  final IListener<av> sVW;
  private final i sVX;
  private final MMHandler sVY;
  
  static
  {
    AppMethodBeat.i(213550);
    sVZ = new a((byte)0);
    AppMethodBeat.o(213550);
  }
  
  public c()
  {
    AppMethodBeat.i(213549);
    this.sVV = new ConcurrentHashMap();
    this.sVW = ((IListener)new e(this));
    i locali = new i("BypSyncExecutor");
    locali.start();
    this.sVX = locali;
    this.sVY = new MMHandler("BypDispatcher", (MMHandler.Callback)new c(this));
    AppMethodBeat.o(213549);
  }
  
  public final void a(final List<Integer> paramList, final b paramb, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(213545);
    p.k(paramList, "selector");
    p.k(paramb, "source");
    boolean bool = z.bdj();
    Log.i("Byp.BypSyncCore", "[doSync] selector=" + paramList + " source=" + paramb + " isContinue=" + paramBoolean + " retryCount=" + paramInt + " isExDeviceEnv=" + bool);
    if (bool)
    {
      AppMethodBeat.o(213545);
      return;
    }
    if (paramInt >= 3)
    {
      Log.e("Byp.BypSyncCore", "[doSync] over limit retry count[" + paramInt + "] limit=3");
      com.tencent.mm.plugin.report.service.h.IzE.p(1465L, 130L, 1L);
      AppMethodBeat.o(213545);
      return;
    }
    paramList = new com.tencent.mm.loader.g.h((kotlin.g.a.b)new d(this, paramList, paramb, paramBoolean, paramInt));
    if (paramBoolean)
    {
      paramb = this.sVX;
      p.k(paramList, "task");
      Log.i("Loader.SingleTaskExecutor", "[postTask] name=" + paramb.name + " isRunningTask=" + paramb.kPW + " task=" + paramList);
      paramList.kPS = paramb.kPS;
      paramb.kPV.addFirst(paramList);
      paramb.aSd();
      AppMethodBeat.o(213545);
      return;
    }
    this.sVX.a(paramList);
    AppMethodBeat.o(213545);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/BypSyncCore$Companion;", "", "()V", "BYP_DISPATCHER", "", "BYP_SYNC_EXECUTOR", "RETRY_LIMIT_COUNT", "", "TAG", "WHAT_DISPATCH_SYNC_RESULT", "plugin-byp_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "AUTO_AUTH", "NEW_SYNC", "NOTIFY", "CONTINUE", "RETRY", "CONFIG_DELAY", "plugin-byp_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(213451);
      b localb1 = new b("DEFAULT", 0, 0);
      sWa = localb1;
      b localb2 = new b("AUTO_AUTH", 1, 1);
      sWb = localb2;
      b localb3 = new b("NEW_SYNC", 2, 2);
      sWc = localb3;
      b localb4 = new b("NOTIFY", 3, 3);
      sWd = localb4;
      b localb5 = new b("CONTINUE", 4, 4);
      sWe = localb5;
      b localb6 = new b("RETRY", 5, 5);
      sWf = localb6;
      b localb7 = new b("CONFIG_DELAY", 6, 6);
      sWg = localb7;
      sWh = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7 };
      AppMethodBeat.o(213451);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/byp/BypSyncCore$bypDispatcher$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-byp_release"})
  public static final class c
    implements MMHandler.Callback
  {
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(213560);
      p.k(paramMessage, "msg");
      if (paramMessage.what == 1)
      {
        Object localObject1 = paramMessage.obj;
        if (localObject1 == null)
        {
          paramMessage = new t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.BypSyncItem>");
          AppMethodBeat.o(213560);
          throw paramMessage;
        }
        localObject1 = (LinkedList)localObject1;
        Log.i("Byp.BypSyncCore", "[WHAT_DISPATCH_SYNC_RESULT] list=" + ((LinkedList)localObject1).size());
        Object localObject3 = new HashMap();
        Iterator localIterator = ((Iterable)localObject1).iterator();
        Object localObject2;
        while (localIterator.hasNext())
        {
          sl localsl = (sl)localIterator.next();
          localObject2 = (LinkedList)((HashMap)localObject3).get(Integer.valueOf(localsl.SbS));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new LinkedList();
            ((Map)localObject3).put(Integer.valueOf(localsl.SbS), localObject1);
          }
          p.j(localObject1, "map[it.sync_key_type] ?:…ist\n                    }");
          ((LinkedList)localObject1).add(localsl);
        }
        localObject1 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (com.tencent.mm.plugin.byp.a.b)this.sWi.sVV.get(((Map.Entry)localObject3).getKey());
          if (localObject2 != null)
          {
            localObject3 = (LinkedList)((Map.Entry)localObject3).getValue();
            if (paramMessage.arg1 == 1) {}
            for (boolean bool = true;; bool = false)
            {
              ((com.tencent.mm.plugin.byp.a.b)localObject2).b((LinkedList)localObject3, bool);
              break;
            }
          }
        }
        AppMethodBeat.o(213560);
        return true;
      }
      AppMethodBeat.o(213560);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "singleTask", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    d(c paramc, List paramList, c.b paramb, boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/byp/BypSyncCore$newSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "callback", "", "event", "plugin-byp_release"})
  public static final class e
    extends IListener<av>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c
 * JD-Core Version:    0.7.0.1
 */