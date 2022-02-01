package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"})
public final class d
  extends c
{
  public static final a sVk;
  boolean sVi;
  final e sVj;
  
  static
  {
    AppMethodBeat.i(204989);
    sVk = new a((byte)0);
    AppMethodBeat.o(204989);
  }
  
  public d(e parame)
  {
    AppMethodBeat.i(204988);
    this.sVj = parame;
    AppMethodBeat.o(204988);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(204987);
    String str = this.sVj.aeW();
    AppMethodBeat.o(204987);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(204986);
    this.sVj.a((h.b)new b(this));
    AppMethodBeat.o(204986);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/action/FavActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class b
    implements h.b
  {
    public final void a(j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(204985);
      p.h(paramj, "status");
      this.sVl.sVi = paramBoolean;
      this.sVl.a(paramj);
      AppMethodBeat.o(204985);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.d
 * JD-Core Version:    0.7.0.1
 */