package com.tencent.mm.plugin.finder.uniComments.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.c;
import com.tencent.mm.loader.f.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniAction;", "(Lcom/tencent/mm/plugin/finder/uniComments/action/UniAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/uniComments/action/UniAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "ICallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c
{
  public static final a Gav;
  final a Gaw;
  boolean Gax;
  
  static
  {
    AppMethodBeat.i(341609);
    Gav = new a((byte)0);
    AppMethodBeat.o(341609);
  }
  
  public e(a parama)
  {
    AppMethodBeat.i(341606);
    this.Gaw = parama;
    AppMethodBeat.o(341606);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(341620);
    String str = this.Gaw.aUE();
    AppMethodBeat.o(341620);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(341613);
    this.Gaw.a((b)new c(this));
    AppMethodBeat.o(341613);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask$ICallback;", "", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "needRetry", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(i parami, boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask$call$1", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements e.b
  {
    c(e parame) {}
    
    public final void a(i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(341588);
      s.u(parami, "status");
      this.Gay.Gax = paramBoolean;
      this.Gay.a(parami);
      AppMethodBeat.o(341588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.action.e
 * JD-Core Version:    0.7.0.1
 */