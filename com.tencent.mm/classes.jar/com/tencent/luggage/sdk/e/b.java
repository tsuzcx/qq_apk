package com.tencent.luggage.sdk.e;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "", "()V", "onFinishListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "preFetchTasks", "Ljava/util/HashMap;", "", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "Lkotlin/collections/HashMap;", "getPreFetchTasks", "()Ljava/util/HashMap;", "finishAllTask", "getTask", "T", "key", "onFinish", "l", "startTask", "preFetchLaunchTask", "Companion", "luggage-wechat-full-sdk_release"})
public class b
{
  public static final a cis;
  public final HashMap<Integer, a<?>> ciq;
  public final LinkedList<d.g.a.a<y>> cir;
  
  static
  {
    AppMethodBeat.i(186846);
    cis = new a((byte)0);
    AppMethodBeat.o(186846);
  }
  
  public b()
  {
    AppMethodBeat.i(186845);
    this.ciq = new HashMap();
    this.cir = new LinkedList();
    AppMethodBeat.o(186845);
  }
  
  public final void b(a<?> parama)
  {
    AppMethodBeat.i(186844);
    k.h(parama, "preFetchLaunchTask");
    ((Map)this.ciq).put(Integer.valueOf(parama.Ei()), parama);
    parama.cij = new FutureTask((Callable)new a.b(parama));
    i locali = h.Iye;
    parama = parama.cij;
    if (parama == null) {
      k.aPZ("futureTask");
    }
    locali.aP((Runnable)parama);
    AppMethodBeat.o(186844);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection$Companion;", "", "()V", "TAG", "", "TASK_KEY_PROVIDE_WAWEBVIEW", "", "TASK_KEY_PROVIDE_WXSS", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */