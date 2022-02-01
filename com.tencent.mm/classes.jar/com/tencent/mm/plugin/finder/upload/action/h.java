package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "ICallback", "plugin-finder_release"})
public final class h
  extends c
{
  public static final a sVy;
  boolean sVi;
  final e sVj;
  
  static
  {
    AppMethodBeat.i(167829);
    sVy = new a((byte)0);
    AppMethodBeat.o(167829);
  }
  
  public h(e parame)
  {
    AppMethodBeat.i(167828);
    this.sVj = parame;
    AppMethodBeat.o(167828);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(167827);
    String str = this.sVj.aeW();
    AppMethodBeat.o(167827);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167826);
    this.sVj.a((b)new c(this));
    AppMethodBeat.o(167826);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "needRetry", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(j paramj, boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/action/LikeActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class c
    implements h.b
  {
    public final void a(j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(167825);
      p.h(paramj, "status");
      this.sVz.sVi = paramBoolean;
      this.sVz.a(paramj);
      AppMethodBeat.o(167825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.h
 * JD-Core Version:    0.7.0.1
 */