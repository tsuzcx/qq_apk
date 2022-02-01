package com.tencent.mm.plugin.byp;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.at;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.ss;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/BypSyncCore;", "", "()V", "bypDispatcher", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "bysSyncHandlers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "getBysSyncHandlers", "()Ljava/util/concurrent/ConcurrentHashMap;", "newSyncEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "getNewSyncEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "serialExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "addSyncHandler", "", "bizSyncKeyType", "handler", "doSync", "selector", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "isContinue", "", "retryCount", "removeSyncHandler", "Companion", "SyncSource", "plugin-byp_release"})
public final class c
{
  public static final a pPb;
  final ConcurrentHashMap<Integer, com.tencent.mm.plugin.byp.a.b> pOX;
  final IListener<at> pOY;
  private final i pOZ;
  private final MMHandler pPa;
  
  static
  {
    AppMethodBeat.i(199097);
    pPb = new a((byte)0);
    AppMethodBeat.o(199097);
  }
  
  public c()
  {
    AppMethodBeat.i(199096);
    this.pOX = new ConcurrentHashMap();
    this.pOY = ((IListener)new e(this));
    i locali = new i("BypSyncExecutor");
    locali.start();
    this.pOZ = locali;
    this.pPa = new MMHandler("BypDispatcher", (MMHandler.Callback)new c(this));
    AppMethodBeat.o(199096);
  }
  
  public final void a(final List<Integer> paramList, final b paramb, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(199094);
    p.h(paramList, "selector");
    p.h(paramb, "source");
    boolean bool = z.aUh();
    Log.i("Byp.BypSyncCore", "[doSync] selector=" + paramList + " source=" + paramb + " isContinue=" + paramBoolean + " retryCount=" + paramInt + " isExDeviceEnv=" + bool);
    if (bool)
    {
      AppMethodBeat.o(199094);
      return;
    }
    if (paramInt >= 3)
    {
      Log.e("Byp.BypSyncCore", "[doSync] over limit retry count[" + paramInt + "] limit=3");
      com.tencent.mm.plugin.report.service.h.CyF.n(1465L, 130L, 1L);
      AppMethodBeat.o(199094);
      return;
    }
    paramList = new com.tencent.mm.loader.g.h((kotlin.g.a.b)new d(this, paramList, paramb, paramBoolean, paramInt));
    if (paramBoolean)
    {
      paramb = this.pOZ;
      p.h(paramList, "task");
      Log.i("Loader.SingleTaskExecutor", "[postTask] name=" + paramb.name + " isRunningTask=" + paramb.ibp + " task=" + paramList);
      paramList.token = paramb.token;
      paramb.ibo.addFirst(paramList);
      paramb.aKc();
      AppMethodBeat.o(199094);
      return;
    }
    this.pOZ.a(paramList);
    AppMethodBeat.o(199094);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/BypSyncCore$Companion;", "", "()V", "BYP_DISPATCHER", "", "BYP_SYNC_EXECUTOR", "RETRY_LIMIT_COUNT", "", "TAG", "WHAT_DISPATCH_SYNC_RESULT", "plugin-byp_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "AUTO_AUTH", "NEW_SYNC", "NOTIFY", "CONTINUE", "RETRY", "plugin-byp_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(199087);
      b localb1 = new b("DEFAULT", 0, 0);
      pPc = localb1;
      b localb2 = new b("AUTO_AUTH", 1, 1);
      pPd = localb2;
      b localb3 = new b("NEW_SYNC", 2, 2);
      pPe = localb3;
      b localb4 = new b("NOTIFY", 3, 3);
      pPf = localb4;
      b localb5 = new b("CONTINUE", 4, 4);
      pPg = localb5;
      b localb6 = new b("RETRY", 5, 5);
      pPh = localb6;
      pPi = new b[] { localb1, localb2, localb3, localb4, localb5, localb6 };
      AppMethodBeat.o(199087);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/byp/BypSyncCore$bypDispatcher$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-byp_release"})
  public static final class c
    implements MMHandler.Callback
  {
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(199090);
      p.h(paramMessage, "msg");
      if (paramMessage.what == 1)
      {
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramMessage = new t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.BypSyncItem>");
          AppMethodBeat.o(199090);
          throw paramMessage;
        }
        paramMessage = (LinkedList)paramMessage;
        Log.i("Byp.BypSyncCore", "[WHAT_DISPATCH_SYNC_RESULT] list=" + paramMessage.size());
        Object localObject2 = new HashMap();
        Iterator localIterator = ((Iterable)paramMessage).iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          ss localss = (ss)localIterator.next();
          localObject1 = (LinkedList)((HashMap)localObject2).get(Integer.valueOf(localss.LaJ));
          paramMessage = (Message)localObject1;
          if (localObject1 == null)
          {
            paramMessage = new LinkedList();
            ((Map)localObject2).put(Integer.valueOf(localss.LaJ), paramMessage);
          }
          p.g(paramMessage, "map[it.sync_key_type] ?:…ist\n                    }");
          paramMessage.add(localss);
        }
        paramMessage = ((Map)localObject2).entrySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (Map.Entry)paramMessage.next();
          localObject2 = (com.tencent.mm.plugin.byp.a.b)this.pPj.pOX.get(((Map.Entry)localObject1).getKey());
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.byp.a.b)localObject2).O((LinkedList)((Map.Entry)localObject1).getValue());
          }
        }
        AppMethodBeat.o(199090);
        return true;
      }
      AppMethodBeat.o(199090);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "singleTask", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    d(c paramc, List paramList, c.b paramb, boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/byp/BypSyncCore$newSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "callback", "", "event", "plugin-byp_release"})
  public static final class e
    extends IListener<at>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c
 * JD-Core Version:    0.7.0.1
 */