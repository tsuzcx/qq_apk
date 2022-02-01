package com.tencent.luggage.sdk.e;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "", "()V", "onFinishListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "preFetchTasks", "Ljava/util/HashMap;", "", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "Lkotlin/collections/HashMap;", "getPreFetchTasks", "()Ljava/util/HashMap;", "finishAllTask", "getTask", "T", "key", "onFinish", "l", "startTask", "preFetchLaunchTask", "Companion", "luggage-wechat-full-sdk_release"})
public class b
{
  public static final a cpE;
  public final HashMap<Integer, a<?>> cpC;
  public final LinkedList<d.g.a.a<z>> cpD;
  
  static
  {
    AppMethodBeat.i(192332);
    cpE = new a((byte)0);
    AppMethodBeat.o(192332);
  }
  
  public b()
  {
    AppMethodBeat.i(192331);
    this.cpC = new HashMap();
    this.cpD = new LinkedList();
    AppMethodBeat.o(192331);
  }
  
  public final void b(a<?> parama)
  {
    AppMethodBeat.i(192330);
    p.h(parama, "preFetchLaunchTask");
    ((Map)this.cpC).put(Integer.valueOf(parama.Fk()), parama);
    parama.cpv = new FutureTask((Callable)new a.b(parama));
    i locali = h.LTJ;
    parama = parama.cpv;
    if (parama == null) {
      p.bcb("futureTask");
    }
    locali.aR((Runnable)parama);
    AppMethodBeat.o(192330);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection$Companion;", "", "()V", "TAG", "", "TASK_KEY_PROVIDE_WAWEBVIEW", "", "TASK_KEY_PROVIDE_WXSS", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */