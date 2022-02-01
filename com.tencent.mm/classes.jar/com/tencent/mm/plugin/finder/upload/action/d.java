package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"})
public final class d
  extends c
{
  public static final a ABI;
  boolean ABG;
  final e ABH;
  
  static
  {
    AppMethodBeat.i(278979);
    ABI = new a((byte)0);
    AppMethodBeat.o(278979);
  }
  
  public d(e parame)
  {
    AppMethodBeat.i(278978);
    this.ABH = parame;
    AppMethodBeat.o(278978);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(278977);
    String str = this.ABH.aBG();
    AppMethodBeat.o(278977);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(278975);
    this.ABH.a((m.b)new b(this));
    AppMethodBeat.o(278975);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/action/FavActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class b
    implements m.b
  {
    public final void a(j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(267935);
      p.k(paramj, "status");
      this.ABJ.ABG = paramBoolean;
      this.ABJ.a(paramj);
      AppMethodBeat.o(267935);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.d
 * JD-Core Version:    0.7.0.1
 */