package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "", "name", "", "(Ljava/lang/String;)V", "increment", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunningTask", "", "postCallback", "com/tencent/mm/plugin/finder/utils/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "token", "", "getToken", "()I", "setToken", "(I)V", "waitingTask", "", "checkNextTask", "", "clean", "postTask", "task", "reset", "start", "stop", "Companion", "plugin-finder_release"})
public final class m
{
  public static final a qTv;
  private final String name;
  private com.tencent.mm.loader.g.d<l> qQX;
  private List<l> qTr;
  private boolean qTs;
  private final AtomicInteger qTt;
  private final b qTu;
  public int token;
  
  static
  {
    AppMethodBeat.i(167998);
    qTv = new a((byte)0);
    AppMethodBeat.o(167998);
  }
  
  public m(String paramString)
  {
    AppMethodBeat.i(178466);
    this.name = paramString;
    this.qQX = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(1), new g(1, (byte)0), 1, "SingleTaskExecutor"));
    this.qTr = ((List)new ArrayList());
    this.qTt = new AtomicInteger(0);
    this.token = this.qTt.get();
    this.qTu = new b(this);
    AppMethodBeat.o(178466);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(167995);
    k.h(paraml, "task");
    ad.i("Finder.SingleTaskExecutor", "[postTask] name=" + this.name + " isRunningTask=" + this.qTs + " task=" + paraml);
    paraml.token = this.token;
    this.qTr.add(paraml);
    csf();
    AppMethodBeat.o(167995);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(178465);
    ad.i("Finder.SingleTaskExecutor", "[clean] name=" + this.name);
    this.qTr.clear();
    AppMethodBeat.o(178465);
  }
  
  public final void csf()
  {
    try
    {
      AppMethodBeat.i(167996);
      ad.i("Finder.SingleTaskExecutor", "[checkNextTask] name=" + this.name + " isRunningTask=" + this.qTs + " waitSize=" + this.qTr.size());
      if ((!this.qTs) && (this.qTr.size() > 0))
      {
        this.qQX.b((com.tencent.mm.loader.g.c)this.qTr.remove(0));
        this.qTs = true;
      }
      AppMethodBeat.o(167996);
      return;
    }
    finally {}
  }
  
  public final void reset()
  {
    AppMethodBeat.i(199691);
    this.token = this.qTt.incrementAndGet();
    ad.i("Finder.SingleTaskExecutor", "[reset] name=" + this.name);
    this.qQX.clean();
    this.qTr.clear();
    this.qTs = false;
    AppMethodBeat.o(199691);
  }
  
  public final void start()
  {
    AppMethodBeat.i(167993);
    ad.i("Finder.SingleTaskExecutor", "[start] name=" + this.name);
    this.qQX.a((com.tencent.mm.loader.g.f)this.qTu);
    AppMethodBeat.o(167993);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(199690);
    ad.i("Finder.SingleTaskExecutor", "[stop] name=" + this.name);
    this.qQX.b((com.tencent.mm.loader.g.f)this.qTu);
    this.qQX.clean();
    this.qTr.clear();
    this.qTs = false;
    AppMethodBeat.o(199690);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/utils/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<l>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m
 * JD-Core Version:    0.7.0.1
 */