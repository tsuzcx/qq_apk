package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "", "name", "", "(Ljava/lang/String;)V", "increment", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunningTask", "", "postCallback", "com/tencent/mm/plugin/finder/utils/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "token", "", "getToken", "()I", "setToken", "(I)V", "waitingTask", "", "checkNextTask", "", "clean", "postTask", "task", "reset", "start", "stop", "Companion", "plugin-finder_release"})
public final class r
{
  public static final r.a rQC;
  private final String name;
  private com.tencent.mm.loader.g.d<q> rMY;
  private final AtomicInteger rQA;
  private final b rQB;
  private List<q> rQy;
  private boolean rQz;
  public int token;
  
  static
  {
    AppMethodBeat.i(167998);
    rQC = new r.a((byte)0);
    AppMethodBeat.o(167998);
  }
  
  public r(String paramString)
  {
    AppMethodBeat.i(178466);
    this.name = paramString;
    this.rMY = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(1), new g(1, (byte)0), 1, "SingleTaskExecutor"));
    this.rQy = ((List)new ArrayList());
    this.rQA = new AtomicInteger(0);
    this.token = this.rQA.get();
    this.rQB = new b(this);
    AppMethodBeat.o(178466);
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(167995);
    k.h(paramq, "task");
    ac.i("Finder.SingleTaskExecutor", "[postTask] name=" + this.name + " isRunningTask=" + this.rQz + " task=" + paramq);
    paramq.token = this.token;
    this.rQy.add(paramq);
    cDy();
    AppMethodBeat.o(167995);
  }
  
  public final void cDy()
  {
    try
    {
      AppMethodBeat.i(167996);
      ac.i("Finder.SingleTaskExecutor", "[checkNextTask] name=" + this.name + " isRunningTask=" + this.rQz + " waitSize=" + this.rQy.size());
      if ((!this.rQz) && (this.rQy.size() > 0))
      {
        this.rMY.b((com.tencent.mm.loader.g.c)this.rQy.remove(0));
        this.rQz = true;
      }
      AppMethodBeat.o(167996);
      return;
    }
    finally {}
  }
  
  public final void clean()
  {
    AppMethodBeat.i(178465);
    ac.i("Finder.SingleTaskExecutor", "[clean] name=" + this.name);
    this.rQy.clear();
    AppMethodBeat.o(178465);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(203676);
    this.token = this.rQA.incrementAndGet();
    ac.i("Finder.SingleTaskExecutor", "[reset] name=" + this.name);
    this.rMY.clean();
    this.rQy.clear();
    this.rQz = false;
    AppMethodBeat.o(203676);
  }
  
  public final void start()
  {
    AppMethodBeat.i(167993);
    ac.i("Finder.SingleTaskExecutor", "[start] name=" + this.name);
    this.rMY.a((com.tencent.mm.loader.g.f)this.rQB);
    AppMethodBeat.o(167993);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(203675);
    ac.i("Finder.SingleTaskExecutor", "[stop] name=" + this.name);
    this.rMY.b((com.tencent.mm.loader.g.f)this.rQB);
    this.rMY.clean();
    this.rQy.clear();
    this.rQz = false;
    AppMethodBeat.o(203675);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/utils/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<q>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.r
 * JD-Core Version:    0.7.0.1
 */