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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "", "()V", "onFinishListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "preFetchTasks", "Ljava/util/HashMap;", "", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "Lkotlin/collections/HashMap;", "getPreFetchTasks", "()Ljava/util/HashMap;", "finishAllTask", "getTask", "T", "key", "onFinish", "l", "startTask", "preFetchLaunchTask", "Companion", "luggage-wechat-full-sdk_release"})
public class b
{
  public static final a cqh;
  public final HashMap<Integer, a<?>> cqf;
  public final LinkedList<d.g.a.a<z>> cqg;
  
  static
  {
    AppMethodBeat.i(220934);
    cqh = new a((byte)0);
    AppMethodBeat.o(220934);
  }
  
  public b()
  {
    AppMethodBeat.i(220933);
    this.cqf = new HashMap();
    this.cqg = new LinkedList();
    AppMethodBeat.o(220933);
  }
  
  public final void b(a<?> parama)
  {
    AppMethodBeat.i(220932);
    p.h(parama, "preFetchLaunchTask");
    ((Map)this.cqf).put(Integer.valueOf(parama.Fp()), parama);
    parama.cpY = new FutureTask((Callable)new a.b(parama));
    i locali = h.MqF;
    parama = parama.cpY;
    if (parama == null) {
      p.bdF("futureTask");
    }
    locali.aO((Runnable)parama);
    AppMethodBeat.o(220932);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection$Companion;", "", "()V", "TAG", "", "TASK_KEY_PROVIDE_WAWEBVIEW", "", "TASK_KEY_PROVIDE_WXSS", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */