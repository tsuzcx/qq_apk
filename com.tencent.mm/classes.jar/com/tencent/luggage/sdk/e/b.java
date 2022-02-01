package com.tencent.luggage.sdk.e;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "", "()V", "onFinishListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "preFetchTasks", "Ljava/util/HashMap;", "", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "Lkotlin/collections/HashMap;", "getPreFetchTasks", "()Ljava/util/HashMap;", "finishAllTask", "getTask", "T", "key", "onFinish", "l", "startTask", "preFetchLaunchTask", "Companion", "luggage-wechat-full-sdk_release"})
public class b
{
  public static final a cCA;
  public final HashMap<Integer, a<?>> cCy;
  public final LinkedList<kotlin.g.a.a<x>> cCz;
  
  static
  {
    AppMethodBeat.i(230044);
    cCA = new a((byte)0);
    AppMethodBeat.o(230044);
  }
  
  public b()
  {
    AppMethodBeat.i(230043);
    this.cCy = new HashMap();
    this.cCz = new LinkedList();
    AppMethodBeat.o(230043);
  }
  
  public final void b(a<?> parama)
  {
    AppMethodBeat.i(230042);
    p.h(parama, "preFetchLaunchTask");
    ((Map)this.cCy).put(Integer.valueOf(parama.OY()), parama);
    parama.cCr = new FutureTask((Callable)new a.b(parama));
    i locali = h.RTc;
    parama = parama.cCr;
    if (parama == null) {
      p.btv("futureTask");
    }
    locali.aX((Runnable)parama);
    AppMethodBeat.o(230042);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection$Companion;", "", "()V", "TAG", "", "TASK_KEY_PROVIDE_WAWEBVIEW", "", "TASK_KEY_PROVIDE_WXSS", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */