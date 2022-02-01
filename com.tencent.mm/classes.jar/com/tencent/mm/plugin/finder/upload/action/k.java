package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "ICallback", "plugin-finder_release"})
public final class k
  extends c
{
  public static final a vUz;
  boolean vUd;
  final e vUe;
  
  static
  {
    AppMethodBeat.i(167829);
    vUz = new a((byte)0);
    AppMethodBeat.o(167829);
  }
  
  public k(e parame)
  {
    AppMethodBeat.i(167828);
    this.vUe = parame;
    AppMethodBeat.o(167828);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(167827);
    String str = this.vUe.auK();
    AppMethodBeat.o(167827);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167826);
    this.vUe.a((b)new c(this));
    AppMethodBeat.o(167826);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "needRetry", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(j paramj, boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/action/LikeActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class c
    implements k.b
  {
    public final void a(j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(167825);
      p.h(paramj, "status");
      this.vUA.vUd = paramBoolean;
      this.vUA.a(paramj);
      AppMethodBeat.o(167825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.k
 * JD-Core Version:    0.7.0.1
 */