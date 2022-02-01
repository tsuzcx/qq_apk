package com.tencent.mm.msgsubscription.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageTaskManager;", "", "()V", "LOOP_TAG_PREFIX", "", "MANAGER_THREAD_LOOP_TAG", "TAG", "TASK_TYPE_GET_ALL_SUBSCRIBE_MSG_LIST", "", "TASK_TYPE_GET_SUBSCRIBE_MSG_LIST_FOR_DIALOG", "TASK_TYPE_GET_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_LOAD_LOCAL_SUBSCRIBE_MSG_LIST", "TASK_TYPE_SAVE_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_UPDATE_SUBSCRIBE_MSG_LIST", "loopTagMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskMap", "", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "addTask", "", "task", "finishTask", "getLoopTag", "key", "onTaskRunAfter", "onTaskRunBefore", "removeTask", "runTask", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final HashMap<String, List<com.tencent.mm.msgsubscription.e.a>> mgm;
  public static final d pkg;
  private static final HashMap<String, String> pkh;
  
  static
  {
    AppMethodBeat.i(149659);
    pkg = new d();
    pkh = new HashMap();
    mgm = new HashMap();
    AppMethodBeat.o(149659);
  }
  
  public static void a(a parama, com.tencent.mm.msgsubscription.e.a parama1)
  {
    AppMethodBeat.i(149657);
    s.u(parama, "storageManager");
    s.u(parama1, "task");
    Log.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo runTask storageManager: %s, task className: %s, async: %b", new Object[] { Integer.valueOf(parama.hashCode()), parama1.getClass().getSimpleName(), Boolean.valueOf(parama1.piC) });
    if (!parama1.piC)
    {
      parama1.run();
      AppMethodBeat.o(149657);
      return;
    }
    h.ahAA.g(new d..ExternalSyntheticLambda0(parama, parama1), "manager_thread");
    AppMethodBeat.o(149657);
  }
  
  public static void a(com.tencent.mm.msgsubscription.e.a parama)
  {
    AppMethodBeat.i(149658);
    s.u(parama, "task");
    if (parama.piC) {
      h.ahAA.g(new d..ExternalSyntheticLambda2(parama), "manager_thread");
    }
    AppMethodBeat.o(149658);
  }
  
  private static final void b(a parama, com.tencent.mm.msgsubscription.e.a parama1)
  {
    AppMethodBeat.i(236280);
    s.u(parama, "$storageManager");
    s.u(parama1, "$task");
    Object localObject1 = String.valueOf(parama.hashCode());
    parama = (String)pkh.get(localObject1);
    if (parama == null)
    {
      parama = s.X("SubscribeMsgTask", localObject1);
      ((Map)pkh).put(localObject1, parama);
    }
    for (;;)
    {
      Log.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskRunBefore addTask: %s", new Object[] { Integer.valueOf(parama1.hashCode()) });
      Object localObject3;
      if ((parama1.piD) && (parama1.piC))
      {
        localObject2 = (List)mgm.get(parama1.getKey());
        if (localObject2 == null) {}
        for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject2).size()))
        {
          Log.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskRunBefore oldTask size: %s", new Object[] { localObject1 });
          if (localObject2 == null) {
            break;
          }
          localObject1 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (com.tencent.mm.msgsubscription.e.a)((Iterator)localObject1).next();
            Log.v("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskRunBefore cancel old task: %s", new Object[] { Integer.valueOf(((com.tencent.mm.msgsubscription.e.a)localObject3).hashCode()) });
            ((com.tencent.mm.msgsubscription.e.a)localObject3).cancel();
          }
        }
        if (localObject2 != null) {
          ((List)localObject2).clear();
        }
      }
      localObject1 = (List)mgm.get(parama1.getKey());
      Object localObject2 = (Collection)localObject1;
      int i;
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label347;
        }
        localObject1 = (List)new ArrayList();
      }
      label347:
      for (;;)
      {
        if (localObject1 != null) {
          ((List)localObject1).add(parama1);
        }
        localObject2 = (Map)mgm;
        localObject3 = parama1.getKey();
        s.checkNotNull(localObject1);
        ((Map)localObject2).put(localObject3, localObject1);
        h.ahAA.g(new d..ExternalSyntheticLambda1(parama1), parama);
        AppMethodBeat.o(236280);
        return;
        i = 0;
        break;
      }
    }
  }
  
  private static final void b(com.tencent.mm.msgsubscription.e.a parama)
  {
    AppMethodBeat.i(236274);
    s.u(parama, "$task");
    if (!parama.cancelled)
    {
      parama.run();
      AppMethodBeat.o(236274);
      return;
    }
    Log.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo task %s has cancelled", new Object[] { parama.getKey() });
    AppMethodBeat.o(236274);
  }
  
  private static final void c(com.tencent.mm.msgsubscription.e.a parama)
  {
    AppMethodBeat.i(236285);
    s.u(parama, "$task");
    Log.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskAfter removeTask: %s", new Object[] { Integer.valueOf(parama.hashCode()) });
    List localList = (List)mgm.get(parama.getKey());
    if (localList != null) {
      localList.remove(parama);
    }
    AppMethodBeat.o(236285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.d
 * JD-Core Version:    0.7.0.1
 */