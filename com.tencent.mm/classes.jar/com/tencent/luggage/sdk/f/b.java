package com.tencent.luggage.sdk.f;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "", "()V", "onFinishListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "preFetchTasks", "Ljava/util/HashMap;", "", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "Lkotlin/collections/HashMap;", "getPreFetchTasks", "()Ljava/util/HashMap;", "finishAllTask", "getTask", "T", "key", "onFinish", "l", "startTask", "preFetchLaunchTask", "Companion", "luggage-wechat-full-sdk_release"})
public class b
{
  public static final a cDd;
  public final HashMap<Integer, a<?>> cDb;
  public final LinkedList<kotlin.g.a.a<x>> cDc;
  
  static
  {
    AppMethodBeat.i(237754);
    cDd = new a((byte)0);
    AppMethodBeat.o(237754);
  }
  
  public b()
  {
    AppMethodBeat.i(237753);
    this.cDb = new HashMap();
    this.cDc = new LinkedList();
    AppMethodBeat.o(237753);
  }
  
  public final void b(a<?> parama)
  {
    AppMethodBeat.i(237752);
    p.k(parama, "preFetchLaunchTask");
    ((Map)this.cDb).put(Integer.valueOf(parama.Sw()), parama);
    parama.cCU = new FutureTask((Callable)new a.b(parama));
    i locali = h.ZvG;
    parama = parama.cCU;
    if (parama == null) {
      p.bGy("futureTask");
    }
    locali.be((Runnable)parama);
    AppMethodBeat.o(237752);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection$Companion;", "", "()V", "TAG", "", "TASK_KEY_PROVIDE_WAWEBVIEW", "", "TASK_KEY_PROVIDE_WXSS", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.b
 * JD-Core Version:    0.7.0.1
 */