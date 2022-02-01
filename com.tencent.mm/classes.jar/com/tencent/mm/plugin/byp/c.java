package com.tencent.mm.plugin.byp;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/BypSyncCore;", "", "()V", "bypDispatcher", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "bysSyncHandlers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "getBysSyncHandlers", "()Ljava/util/concurrent/ConcurrentHashMap;", "newSyncEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "getNewSyncEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "serialExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "addSyncHandler", "", "bizSyncKeyType", "handler", "doSync", "selector", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "isContinue", "", "retryCount", "removeSyncHandler", "Companion", "SyncSource", "plugin-byp_release"})
public final class c
{
  public static final a oBq;
  final ConcurrentHashMap<Integer, com.tencent.mm.plugin.byp.a.b> oBm;
  final com.tencent.mm.sdk.b.c<ar> oBn;
  private final i oBo;
  private final aq oBp;
  
  static
  {
    AppMethodBeat.i(218323);
    oBq = new a((byte)0);
    AppMethodBeat.o(218323);
  }
  
  public c()
  {
    AppMethodBeat.i(218322);
    this.oBm = new ConcurrentHashMap();
    this.oBn = ((com.tencent.mm.sdk.b.c)new e(this));
    i locali = new i("BypSyncExecutor");
    locali.start();
    this.oBo = locali;
    this.oBp = new aq("BypDispatcher", (aq.a)new c(this));
    AppMethodBeat.o(218322);
  }
  
  public final void a(final List<Integer> paramList, final b paramb, boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(218320);
    p.h(paramList, "selector");
    p.h(paramb, "source");
    ae.i("Byp.BypSyncCore", "[doSync] selector=" + paramList + " source=" + paramb + " isContinue=" + paramBoolean + " retryCount=" + paramInt);
    if (paramInt >= 3)
    {
      ae.e("Byp.BypSyncCore", "[doSync] over limit retry count[" + paramInt + "] limit=3");
      g.yxI.n(1465L, 130L, 1L);
      AppMethodBeat.o(218320);
      return;
    }
    paramList = new h((d.g.a.b)new d(this, paramList, paramb, paramInt));
    if (paramBoolean)
    {
      paramb = this.oBo;
      p.h(paramList, "task");
      ae.i("Loader.SingleTaskExecutor", "[postTask] name=" + paramb.name + " isRunningTask=" + paramb.hir + " task=" + paramList);
      paramList.token = paramb.token;
      paramb.hiq.addFirst(paramList);
      paramb.arD();
      AppMethodBeat.o(218320);
      return;
    }
    this.oBo.a(paramList);
    AppMethodBeat.o(218320);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/BypSyncCore$Companion;", "", "()V", "BYP_DISPATCHER", "", "BYP_SYNC_EXECUTOR", "RETRY_LIMIT_COUNT", "", "TAG", "WHAT_DISPATCH_SYNC_RESULT", "plugin-byp_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "AUTO_AUTH", "NEW_SYNC", "NOTIFY", "CONTINUE", "RETRY", "plugin-byp_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(218312);
      b localb1 = new b("DEFAULT", 0, 0);
      oBr = localb1;
      b localb2 = new b("AUTO_AUTH", 1, 1);
      oBs = localb2;
      b localb3 = new b("NEW_SYNC", 2, 2);
      oBt = localb3;
      b localb4 = new b("NOTIFY", 3, 3);
      oBu = localb4;
      b localb5 = new b("CONTINUE", 4, 4);
      oBv = localb5;
      b localb6 = new b("RETRY", 5, 5);
      oBw = localb6;
      oBx = new b[] { localb1, localb2, localb3, localb4, localb5, localb6 };
      AppMethodBeat.o(218312);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/byp/BypSyncCore$bypDispatcher$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-byp_release"})
  public static final class c
    implements aq.a
  {
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(218315);
      p.h(paramMessage, "msg");
      if (paramMessage.what == 1)
      {
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramMessage = new v("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.BypSyncItem>");
          AppMethodBeat.o(218315);
          throw paramMessage;
        }
        paramMessage = (LinkedList)paramMessage;
        ae.i("Byp.BypSyncCore", "[WHAT_DISPATCH_SYNC_RESULT] list=" + paramMessage.size());
        Object localObject2 = new HashMap();
        Iterator localIterator = ((Iterable)paramMessage).iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          rp localrp = (rp)localIterator.next();
          localObject1 = (LinkedList)((HashMap)localObject2).get(Integer.valueOf(localrp.Ggg));
          paramMessage = (Message)localObject1;
          if (localObject1 == null)
          {
            paramMessage = new LinkedList();
            ((Map)localObject2).put(Integer.valueOf(localrp.Ggg), paramMessage);
          }
          p.g(paramMessage, "map[it.sync_key_type] ?:…ist\n                    }");
          paramMessage.add(localrp);
        }
        paramMessage = ((Map)localObject2).entrySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (Map.Entry)paramMessage.next();
          localObject2 = (com.tencent.mm.plugin.byp.a.b)this.oBy.oBm.get(((Map.Entry)localObject1).getKey());
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.byp.a.b)localObject2).M((LinkedList)((Map.Entry)localObject1).getValue());
          }
        }
        AppMethodBeat.o(218315);
        return true;
      }
      AppMethodBeat.o(218315);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "singleTask", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<h, z>
  {
    d(c paramc, List paramList, c.b paramb, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/byp/BypSyncCore$newSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "callback", "", "event", "plugin-byp_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<ar>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c
 * JD-Core Version:    0.7.0.1
 */