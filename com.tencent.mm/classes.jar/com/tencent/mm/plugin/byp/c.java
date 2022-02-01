package com.tencent.mm.plugin.byp;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ba;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/BypSyncCore;", "", "()V", "bypDispatcher", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "bysSyncHandlers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "getBysSyncHandlers", "()Ljava/util/concurrent/ConcurrentHashMap;", "newSyncEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "getNewSyncEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "serialExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "addSyncHandler", "", "bizSyncKeyType", "handler", "doSync", "selector", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "isContinue", "", "retryCount", "removeSyncHandler", "Companion", "SyncSource", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a wah;
  final ConcurrentHashMap<Integer, com.tencent.mm.plugin.byp.a.b> wai;
  final IListener<ba> waj;
  private final com.tencent.mm.loader.f.h wak;
  private final MMHandler wal;
  
  static
  {
    AppMethodBeat.i(272008);
    wah = new a((byte)0);
    AppMethodBeat.o(272008);
  }
  
  public c()
  {
    AppMethodBeat.i(271992);
    this.wai = new ConcurrentHashMap();
    this.waj = ((IListener)new BypSyncCore.newSyncEventListener.1(this, f.hfK));
    com.tencent.mm.loader.f.h localh = new com.tencent.mm.loader.f.h("BypSyncExecutor");
    localh.start();
    ah localah = ah.aiuX;
    this.wak = localh;
    this.wal = new MMHandler("BypDispatcher", (MMHandler.Callback)new c(this));
    AppMethodBeat.o(271992);
  }
  
  public final void a(List<Integer> paramList, final b paramb, boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(272019);
    s.u(paramList, "selector");
    s.u(paramb, "source");
    Log.i("Byp.BypSyncCore", "[doSync] selector=" + paramList + " source=" + paramb + " isContinue=" + paramBoolean + " retryCount=" + paramInt);
    if (paramInt >= 3)
    {
      Log.e("Byp.BypSyncCore", "[doSync] over limit retry count[" + paramInt + "] limit=3");
      com.tencent.mm.plugin.report.service.h.OAn.p(1465L, 130L, 1L);
      AppMethodBeat.o(272019);
      return;
    }
    paramList = new g((kotlin.g.a.b)new d(paramList, paramb, this, paramInt));
    if (paramBoolean)
    {
      paramb = this.wak;
      s.u(paramList, "task");
      Log.i("Loader.SingleTaskExecutor", "[postTask] name=" + paramb.name + " isRunningTask=" + paramb.nrA + " task=" + paramList);
      paramList.nrw = paramb.nrw;
      paramb.nrz.addFirst(paramList);
      paramb.blS();
      AppMethodBeat.o(272019);
      return;
    }
    this.wak.a(paramList);
    AppMethodBeat.o(272019);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/BypSyncCore$Companion;", "", "()V", "BYP_DISPATCHER", "", "BYP_SYNC_EXECUTOR", "RETRY_LIMIT_COUNT", "", "TAG", "WHAT_DISPATCH_SYNC_RESULT", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "AUTO_AUTH", "NEW_SYNC", "NOTIFY", "CONTINUE", "RETRY", "CONFIG_DELAY", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(271961);
      wam = new b("DEFAULT", 0, 0);
      wan = new b("AUTO_AUTH", 1, 1);
      wao = new b("NEW_SYNC", 2, 2);
      wap = new b("NOTIFY", 3, 3);
      waq = new b("CONTINUE", 4, 4);
      war = new b("RETRY", 5, 5);
      was = new b("CONFIG_DELAY", 6, 6);
      wat = new b[] { wam, wan, wao, wap, waq, war, was };
      AppMethodBeat.o(271961);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/byp/BypSyncCore$bypDispatcher$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements MMHandler.Callback
  {
    c(c paramc) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(271959);
      s.u(paramMessage, "msg");
      if (paramMessage.what == 1)
      {
        Object localObject1 = paramMessage.obj;
        if (localObject1 == null)
        {
          paramMessage = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.BypSyncItem>");
          AppMethodBeat.o(271959);
          throw paramMessage;
        }
        localObject1 = (LinkedList)localObject1;
        Log.i("Byp.BypSyncCore", s.X("[WHAT_DISPATCH_SYNC_RESULT] list=", Integer.valueOf(((LinkedList)localObject1).size())));
        Object localObject3 = new HashMap();
        Object localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          ub localub = (ub)((Iterator)localObject4).next();
          localObject2 = (LinkedList)((HashMap)localObject3).get(Integer.valueOf(localub.YZL));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new LinkedList();
            ((Map)localObject3).put(Integer.valueOf(localub.YZL), localObject1);
          }
          ((LinkedList)localObject1).add(localub);
        }
        Object localObject2 = (Map)localObject3;
        localObject1 = this.wau;
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = (com.tencent.mm.plugin.byp.a.b)((c)localObject1).wai.get(((Map.Entry)localObject4).getKey());
          if (localObject3 != null)
          {
            localObject4 = (LinkedList)((Map.Entry)localObject4).getValue();
            if (paramMessage.arg1 == 1) {}
            for (boolean bool = true;; bool = false)
            {
              ((com.tencent.mm.plugin.byp.a.b)localObject3).b((LinkedList)localObject4, bool);
              break;
            }
          }
        }
        AppMethodBeat.o(271959);
        return true;
      }
      AppMethodBeat.o(271959);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "singleTask", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<g, ah>
  {
    d(List<Integer> paramList, c.b paramb, c paramc, int paramInt)
    {
      super();
    }
    
    private static final ah a(c paramc, List paramList, int paramInt, g paramg, b.a parama)
    {
      AppMethodBeat.i(271963);
      s.u(paramc, "this$0");
      s.u(paramList, "$selector");
      s.u(paramg, "$singleTask");
      for (;;)
      {
        try
        {
          if ((parama.errType == 0) && (parama.errCode == 0))
          {
            paramList = ((uf)parama.ott).YZR;
            s.s(paramList, "it.resp.resp_continue_flag");
            if (!((Collection)paramList).isEmpty())
            {
              paramInt = 1;
              if (paramInt != 0)
              {
                paramList = ((uf)parama.ott).YZR;
                s.s(paramList, "it.resp.resp_continue_flag");
                c.a(paramc, (List)paramList, c.b.waq, true, 8);
              }
              paramc = c.a(paramc).obtainMessage(1, ((uf)parama.ott).YZm);
              paramList = ((uf)parama.ott).YZR;
              s.s(paramList, "it.resp.resp_continue_flag");
              if (!((Collection)paramList).isEmpty())
              {
                paramInt = 1;
                break label361;
                paramc.arg1 = paramInt;
                paramc.sendToTarget();
                paramg.a(i.nrG);
                paramc = ah.aiuX;
                AppMethodBeat.o(271963);
                return paramc;
              }
            }
            else
            {
              paramInt = 0;
              continue;
            }
            paramInt = 0;
            break label361;
            paramInt = 0;
            continue;
          }
          else
          {
            if (parama.errType != 3) {
              paramc.a(paramList, c.b.war, false, paramInt + 1);
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(20845, new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(1), parama.errType + ':' + parama.errCode + ':' + parama.errMsg, Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.OAn.p(1465L, 100L, 1L);
            com.tencent.mm.plugin.report.service.h.OAn.p(1465L, 100L + parama.errType, 1L);
            continue;
          }
          if (paramInt == 0) {
            continue;
          }
        }
        finally
        {
          paramg.a(i.nrG);
          AppMethodBeat.o(271963);
        }
        label361:
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c
 * JD-Core Version:    0.7.0.1
 */