package com.tencent.mm.msgsubscription.d;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageTaskManager;", "", "()V", "LOOP_TAG_PREFIX", "", "MANAGER_THREAD_LOOP_TAG", "TAG", "TASK_TYPE_GET_ALL_SUBSCRIBE_MSG_LIST", "", "TASK_TYPE_GET_SUBSCRIBE_MSG_LIST_FOR_DIALOG", "TASK_TYPE_GET_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_LOAD_LOCAL_SUBSCRIBE_MSG_LIST", "TASK_TYPE_SAVE_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_UPDATE_SUBSCRIBE_MSG_LIST", "loopTagMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskMap", "", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "addTask", "", "task", "finishTask", "getLoopTag", "key", "onTaskRunAfter", "onTaskRunBefore", "removeTask", "runTask", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "plugin-comm_release"})
public final class d
{
  private static final HashMap<String, List<com.tencent.mm.msgsubscription.e.a>> gVI;
  private static final HashMap<String, String> jAQ;
  public static final d jAR;
  
  static
  {
    AppMethodBeat.i(149659);
    jAR = new d();
    jAQ = new HashMap();
    gVI = new HashMap();
    AppMethodBeat.o(149659);
  }
  
  public static void a(a parama, final com.tencent.mm.msgsubscription.e.a parama1)
  {
    AppMethodBeat.i(149657);
    p.h(parama, "storageManager");
    p.h(parama1, "task");
    Log.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo runTask storageManager: %s, task className: %s, async: %b", new Object[] { Integer.valueOf(parama.hashCode()), parama1.getClass().getSimpleName(), Boolean.valueOf(parama1.jzf) });
    if (!parama1.jzf)
    {
      parama1.run();
      AppMethodBeat.o(149657);
      return;
    }
    h.RTc.b((Runnable)new b(parama, parama1), "manager_thread");
    AppMethodBeat.o(149657);
  }
  
  public static void a(com.tencent.mm.msgsubscription.e.a parama)
  {
    AppMethodBeat.i(149658);
    p.h(parama, "task");
    if (parama.jzf) {
      h.RTc.b((Runnable)new a(parama), "manager_thread");
    }
    AppMethodBeat.o(149658);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.msgsubscription.e.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(149654);
      Log.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskAfter removeTask: %s", new Object[] { Integer.valueOf(this.jAS.hashCode()) });
      d locald = d.jAR;
      d.c(this.jAS);
      AppMethodBeat.o(149654);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, com.tencent.mm.msgsubscription.e.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(149656);
      int i = this.jAT.hashCode();
      Object localObject = d.jAR;
      localObject = d.RC(String.valueOf(i));
      d locald = d.jAR;
      d.b(parama1);
      h.RTc.b((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149655);
          if (!this.jAU.jAS.cancelled)
          {
            this.jAU.jAS.run();
            AppMethodBeat.o(149655);
            return;
          }
          Log.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo task %s has cancelled", new Object[] { this.jAU.jAS.getKey() });
          AppMethodBeat.o(149655);
        }
      }, (String)localObject);
      AppMethodBeat.o(149656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.d
 * JD-Core Version:    0.7.0.1
 */