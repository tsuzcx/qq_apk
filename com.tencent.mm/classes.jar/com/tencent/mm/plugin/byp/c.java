package com.tencent.mm.plugin.byp;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.vending.c.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/BypSyncCore;", "", "()V", "bypDispatcher", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "bysSyncHandlers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "getBysSyncHandlers", "()Ljava/util/concurrent/ConcurrentHashMap;", "newSyncEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "getNewSyncEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "serialExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "addSyncHandler", "", "bizSyncKeyType", "handler", "doSync", "selector", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "isContinue", "", "retryCount", "removeSyncHandler", "Companion", "SyncSource", "plugin-byp_release"})
public final class c
{
  public static final a ouQ;
  final ConcurrentHashMap<Integer, com.tencent.mm.plugin.byp.a.b> ouM;
  final com.tencent.mm.sdk.b.c<ar> ouN;
  private final i ouO;
  private final ap ouP;
  
  static
  {
    AppMethodBeat.i(219208);
    ouQ = new a((byte)0);
    AppMethodBeat.o(219208);
  }
  
  public c()
  {
    AppMethodBeat.i(219207);
    this.ouM = new ConcurrentHashMap();
    this.ouN = ((com.tencent.mm.sdk.b.c)new e(this));
    i locali = new i("BypSyncExecutor");
    locali.start();
    this.ouO = locali;
    this.ouP = new ap("BypDispatcher", (ap.a)new c(this));
    AppMethodBeat.o(219207);
  }
  
  public final void a(final List<Integer> paramList, final b paramb, boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(219205);
    p.h(paramList, "selector");
    p.h(paramb, "source");
    ad.i("Byp.BypSyncCore", "[doSync] selector=" + paramList + " source=" + paramb + " isContinue=" + paramBoolean + " retryCount=" + paramInt);
    if (paramInt >= 3)
    {
      ad.e("Byp.BypSyncCore", "[doSync] over limit retry count[" + paramInt + "] limit=3");
      g.yhR.n(1465L, 130L, 1L);
      AppMethodBeat.o(219205);
      return;
    }
    paramList = new h((d.g.a.b)new d(this, paramList, paramb, paramInt));
    if (paramBoolean)
    {
      paramb = this.ouO;
      p.h(paramList, "task");
      ad.i("Loader.SingleTaskExecutor", "[postTask] name=" + paramb.name + " isRunningTask=" + paramb.hfD + " task=" + paramList);
      paramList.token = paramb.token;
      paramb.hfC.addFirst(paramList);
      paramb.aro();
      AppMethodBeat.o(219205);
      return;
    }
    this.ouO.a(paramList);
    AppMethodBeat.o(219205);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/BypSyncCore$Companion;", "", "()V", "BYP_DISPATCHER", "", "BYP_SYNC_EXECUTOR", "RETRY_LIMIT_COUNT", "", "TAG", "WHAT_DISPATCH_SYNC_RESULT", "plugin-byp_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "AUTO_AUTH", "NEW_SYNC", "NOTIFY", "CONTINUE", "RETRY", "plugin-byp_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(219197);
      b localb1 = new b("DEFAULT", 0, 0);
      ouR = localb1;
      b localb2 = new b("AUTO_AUTH", 1, 1);
      ouS = localb2;
      b localb3 = new b("NEW_SYNC", 2, 2);
      ouT = localb3;
      b localb4 = new b("NOTIFY", 3, 3);
      ouU = localb4;
      b localb5 = new b("CONTINUE", 4, 4);
      ouV = localb5;
      b localb6 = new b("RETRY", 5, 5);
      ouW = localb6;
      ouX = new b[] { localb1, localb2, localb3, localb4, localb5, localb6 };
      AppMethodBeat.o(219197);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/byp/BypSyncCore$bypDispatcher$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-byp_release"})
  public static final class c
    implements ap.a
  {
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(219200);
      p.h(paramMessage, "msg");
      if (paramMessage.what == 1)
      {
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramMessage = new v("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.BypSyncItem>");
          AppMethodBeat.o(219200);
          throw paramMessage;
        }
        paramMessage = (LinkedList)paramMessage;
        ad.i("Byp.BypSyncCore", "[WHAT_DISPATCH_SYNC_RESULT] list=" + paramMessage.size());
        Object localObject2 = new HashMap();
        Iterator localIterator = ((Iterable)paramMessage).iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          rn localrn = (rn)localIterator.next();
          localObject1 = (LinkedList)((HashMap)localObject2).get(Integer.valueOf(localrn.FNH));
          paramMessage = (Message)localObject1;
          if (localObject1 == null)
          {
            paramMessage = new LinkedList();
            ((Map)localObject2).put(Integer.valueOf(localrn.FNH), paramMessage);
          }
          p.g(paramMessage, "map[it.sync_key_type] ?:…ist\n                    }");
          paramMessage.add(localrn);
        }
        paramMessage = ((Map)localObject2).entrySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (Map.Entry)paramMessage.next();
          localObject2 = (com.tencent.mm.plugin.byp.a.b)this.ouY.ouM.get(((Map.Entry)localObject1).getKey());
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.byp.a.b)localObject2).M((LinkedList)((Map.Entry)localObject1).getValue());
          }
        }
        AppMethodBeat.o(219200);
        return true;
      }
      AppMethodBeat.o(219200);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "singleTask", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<h, z>
  {
    d(c paramc, List paramList, c.b paramb, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/byp/BypSyncCore$newSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "callback", "", "event", "plugin-byp_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<ar>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c
 * JD-Core Version:    0.7.0.1
 */