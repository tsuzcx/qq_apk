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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "", "()V", "onFinishListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "preFetchTasks", "Ljava/util/HashMap;", "", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "Lkotlin/collections/HashMap;", "getPreFetchTasks", "()Ljava/util/HashMap;", "finishAllTask", "getTask", "T", "key", "onFinish", "l", "startTask", "preFetchLaunchTask", "Companion", "luggage-wechat-full-sdk_release"})
public class b
{
  public static final a cfo;
  public final HashMap<Integer, a<?>> cfm;
  public final LinkedList<d.g.a.a<y>> cfn;
  
  static
  {
    AppMethodBeat.i(206200);
    cfo = new a((byte)0);
    AppMethodBeat.o(206200);
  }
  
  public b()
  {
    AppMethodBeat.i(206199);
    this.cfm = new HashMap();
    this.cfn = new LinkedList();
    AppMethodBeat.o(206199);
  }
  
  public final void b(a<?> parama)
  {
    AppMethodBeat.i(206198);
    k.h(parama, "preFetchLaunchTask");
    ((Map)this.cfm).put(Integer.valueOf(parama.DL()), parama);
    parama.cfe = new FutureTask((Callable)new a.b(parama));
    i locali = h.JZN;
    parama = parama.cfe;
    if (parama == null) {
      k.aVY("futureTask");
    }
    locali.aS((Runnable)parama);
    AppMethodBeat.o(206198);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection$Companion;", "", "()V", "TAG", "", "TASK_KEY_PROVIDE_WAWEBVIEW", "", "TASK_KEY_PROVIDE_WXSS", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */