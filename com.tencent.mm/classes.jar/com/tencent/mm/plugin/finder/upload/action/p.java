package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.c;
import com.tencent.mm.loader.f.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/WordingActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends c
{
  public static final p.a GdA;
  boolean Gax;
  final e GcO;
  
  static
  {
    AppMethodBeat.i(343393);
    GdA = new p.a((byte)0);
    AppMethodBeat.o(343393);
  }
  
  public p(e parame)
  {
    AppMethodBeat.i(343388);
    this.GcO = parame;
    AppMethodBeat.o(343388);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343403);
    String str = this.GcO.aUE();
    AppMethodBeat.o(343403);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(343397);
    this.GcO.a((m.b)new b(this));
    AppMethodBeat.o(343397);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/action/WordingActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements m.b
  {
    b(p paramp) {}
    
    public final void a(i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(343278);
      s.u(parami, "status");
      this.GdB.Gax = paramBoolean;
      this.GdB.a(parami);
      AppMethodBeat.o(343278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.p
 * JD-Core Version:    0.7.0.1
 */