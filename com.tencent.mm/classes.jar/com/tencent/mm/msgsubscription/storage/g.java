package com.tencent.mm.msgsubscription.storage;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageTaskManager;", "", "()V", "LOOP_TAG_PREFIX", "", "MANAGER_THREAD_LOOP_TAG", "TAG", "TASK_TYPE_GET_ALL_SUBSCRIBE_MSG_LIST", "", "TASK_TYPE_GET_SUBSCRIBE_MSG_LIST_FOR_DIALOG", "TASK_TYPE_GET_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_LOAD_LOCAL_SUBSCRIBE_MSG_LIST", "TASK_TYPE_SAVE_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_UPDATE_SUBSCRIBE_MSG_LIST", "loopTagMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskMap", "", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "addTask", "", "task", "finishTask", "getLoopTag", "key", "onTaskRunAfter", "onTaskRunBefore", "removeTask", "runTask", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "plugin-comm_release"})
public final class g
{
  private static final HashMap<String, List<a>> fOV;
  private static final HashMap<String, String> iiy;
  public static final g iiz;
  
  static
  {
    AppMethodBeat.i(149659);
    iiz = new g();
    iiy = new HashMap();
    fOV = new HashMap();
    AppMethodBeat.o(149659);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(149658);
    k.h(parama, "task");
    if (parama.iiD) {
      h.JZN.f((Runnable)new a(parama), "manager_thread");
    }
    AppMethodBeat.o(149658);
  }
  
  public static void a(d paramd, final a parama)
  {
    AppMethodBeat.i(149657);
    k.h(paramd, "storageManager");
    k.h(parama, "task");
    ac.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo runTask storageManager: %s, task className: %s, async: %b", new Object[] { Integer.valueOf(paramd.hashCode()), parama.getClass().getSimpleName(), Boolean.valueOf(parama.iiD) });
    if (!parama.iiD)
    {
      parama.run();
      AppMethodBeat.o(149657);
      return;
    }
    h.JZN.f((Runnable)new b(paramd, parama), "manager_thread");
    AppMethodBeat.o(149657);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(149654);
      ac.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskAfter removeTask: %s", new Object[] { Integer.valueOf(this.iiA.hashCode()) });
      g localg = g.iiz;
      g.c(this.iiA);
      AppMethodBeat.o(149654);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(149656);
      int i = this.iiB.hashCode();
      Object localObject = g.iiz;
      localObject = g.ET(String.valueOf(i));
      g localg = g.iiz;
      g.b(parama);
      h.JZN.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149655);
          if (!this.iiC.iiA.cancelled)
          {
            this.iiC.iiA.run();
            AppMethodBeat.o(149655);
            return;
          }
          ac.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo task %s has cancelled", new Object[] { this.iiC.iiA.getKey() });
          AppMethodBeat.o(149655);
        }
      }, (String)localObject);
      AppMethodBeat.o(149656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.g
 * JD-Core Version:    0.7.0.1
 */