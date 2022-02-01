package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"})
public final class d
  extends c
{
  public static final a sJX;
  boolean sJV;
  final e sJW;
  
  static
  {
    AppMethodBeat.i(204371);
    sJX = new a((byte)0);
    AppMethodBeat.o(204371);
  }
  
  public d(e parame)
  {
    AppMethodBeat.i(204370);
    this.sJW = parame;
    AppMethodBeat.o(204370);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(204369);
    String str = this.sJW.aeK();
    AppMethodBeat.o(204369);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(204368);
    this.sJW.a((h.b)new b(this));
    AppMethodBeat.o(204368);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/action/FavActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class b
    implements h.b
  {
    public final void a(j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(204367);
      p.h(paramj, "status");
      this.sJY.sJV = paramBoolean;
      this.sJY.a(paramj);
      AppMethodBeat.o(204367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.d
 * JD-Core Version:    0.7.0.1
 */