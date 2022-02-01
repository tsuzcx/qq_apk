package com.tencent.mm.msgsubscription.storage;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageTaskManager;", "", "()V", "LOOP_TAG_PREFIX", "", "MANAGER_THREAD_LOOP_TAG", "TAG", "TASK_TYPE_GET_ALL_SUBSCRIBE_MSG_LIST", "", "TASK_TYPE_GET_SUBSCRIBE_MSG_LIST_FOR_DIALOG", "TASK_TYPE_GET_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_LOAD_LOCAL_SUBSCRIBE_MSG_LIST", "TASK_TYPE_SAVE_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_UPDATE_SUBSCRIBE_MSG_LIST", "loopTagMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskMap", "", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "addTask", "", "task", "finishTask", "getLoopTag", "key", "onTaskRunAfter", "onTaskRunBefore", "removeTask", "runTask", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "plugin-comm_release"})
public final class g
{
  private static final HashMap<String, List<a>> giv;
  private static final HashMap<String, String> iBS;
  public static final g iBT;
  
  static
  {
    AppMethodBeat.i(149659);
    iBT = new g();
    iBS = new HashMap();
    giv = new HashMap();
    AppMethodBeat.o(149659);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(149658);
    p.h(parama, "task");
    if (parama.iBX) {
      h.LTJ.f((Runnable)new a(parama), "manager_thread");
    }
    AppMethodBeat.o(149658);
  }
  
  public static void a(d paramd, final a parama)
  {
    AppMethodBeat.i(149657);
    p.h(paramd, "storageManager");
    p.h(parama, "task");
    ad.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo runTask storageManager: %s, task className: %s, async: %b", new Object[] { Integer.valueOf(paramd.hashCode()), parama.getClass().getSimpleName(), Boolean.valueOf(parama.iBX) });
    if (!parama.iBX)
    {
      parama.run();
      AppMethodBeat.o(149657);
      return;
    }
    h.LTJ.f((Runnable)new b(paramd, parama), "manager_thread");
    AppMethodBeat.o(149657);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(149654);
      ad.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskAfter removeTask: %s", new Object[] { Integer.valueOf(this.iBU.hashCode()) });
      g localg = g.iBT;
      g.c(this.iBU);
      AppMethodBeat.o(149654);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(149656);
      int i = this.iBV.hashCode();
      Object localObject = g.iBT;
      localObject = g.Ih(String.valueOf(i));
      g localg = g.iBT;
      g.b(parama);
      h.LTJ.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149655);
          if (!this.iBW.iBU.cancelled)
          {
            this.iBW.iBU.run();
            AppMethodBeat.o(149655);
            return;
          }
          ad.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo task %s has cancelled", new Object[] { this.iBW.iBU.getKey() });
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