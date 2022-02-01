package com.tencent.luggage.sdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "", "()V", "onFinishListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "preFetchTasks", "Ljava/util/HashMap;", "", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "Lkotlin/collections/HashMap;", "getPreFetchTasks", "()Ljava/util/HashMap;", "finishAllTask", "getTask", "T", "key", "onFinish", "l", "startTask", "preFetchLaunchTask", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
{
  public static final b.a evC;
  public final HashMap<Integer, a<?>> evD;
  public final LinkedList<kotlin.g.a.a<ah>> evE;
  
  static
  {
    AppMethodBeat.i(220216);
    evC = new b.a((byte)0);
    AppMethodBeat.o(220216);
  }
  
  public b()
  {
    AppMethodBeat.i(220211);
    this.evD = new HashMap();
    this.evE = new LinkedList();
    AppMethodBeat.o(220211);
  }
  
  public final void c(a<?> parama)
  {
    AppMethodBeat.i(220222);
    s.u(parama, "preFetchLaunchTask");
    ((Map)this.evD).put(Integer.valueOf(parama.asL()), parama);
    parama.asM();
    AppMethodBeat.o(220222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.b
 * JD-Core Version:    0.7.0.1
 */