package com.tencent.mm.msgsubscription.storage;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageTaskManager;", "", "()V", "LOOP_TAG_PREFIX", "", "MANAGER_THREAD_LOOP_TAG", "TAG", "TASK_TYPE_GET_ALL_SUBSCRIBE_MSG_LIST", "", "TASK_TYPE_GET_SUBSCRIBE_MSG_LIST_FOR_DIALOG", "TASK_TYPE_GET_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_LOAD_LOCAL_SUBSCRIBE_MSG_LIST", "TASK_TYPE_SAVE_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_UPDATE_SUBSCRIBE_MSG_LIST", "loopTagMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskMap", "", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "addTask", "", "task", "finishTask", "getLoopTag", "key", "onTaskRunAfter", "onTaskRunBefore", "removeTask", "runTask", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "plugin-comm_release"})
public final class g
{
  private static final HashMap<String, List<a>> fLj;
  private static final HashMap<String, String> hHW;
  public static final g hHX;
  
  static
  {
    AppMethodBeat.i(149659);
    hHX = new g();
    hHW = new HashMap();
    fLj = new HashMap();
    AppMethodBeat.o(149659);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(149658);
    k.h(parama, "task");
    if (parama.hIb) {
      h.Iye.f((Runnable)new a(parama), "manager_thread");
    }
    AppMethodBeat.o(149658);
  }
  
  public static void a(d paramd, final a parama)
  {
    AppMethodBeat.i(149657);
    k.h(paramd, "storageManager");
    k.h(parama, "task");
    ad.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo runTask storageManager: %s, task className: %s, async: %b", new Object[] { Integer.valueOf(paramd.hashCode()), parama.getClass().getSimpleName(), Boolean.valueOf(parama.hIb) });
    if (!parama.hIb)
    {
      parama.run();
      AppMethodBeat.o(149657);
      return;
    }
    h.Iye.f((Runnable)new b(paramd, parama), "manager_thread");
    AppMethodBeat.o(149657);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(149654);
      ad.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskAfter removeTask: %s", new Object[] { Integer.valueOf(this.hHY.hashCode()) });
      g localg = g.hHX;
      g.c(this.hHY);
      AppMethodBeat.o(149654);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(149656);
      int i = this.hHZ.hashCode();
      Object localObject = g.hHX;
      localObject = g.AO(String.valueOf(i));
      g localg = g.hHX;
      g.b(parama);
      h.Iye.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149655);
          if (!this.hIa.hHY.cancelled)
          {
            this.hIa.hHY.run();
            AppMethodBeat.o(149655);
            return;
          }
          ad.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo task %s has cancelled", new Object[] { this.hIa.hHY.getKey() });
          AppMethodBeat.o(149655);
        }
      }, (String)localObject);
      AppMethodBeat.o(149656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.g
 * JD-Core Version:    0.7.0.1
 */