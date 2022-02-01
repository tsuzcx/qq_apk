package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"})
public final class j
  extends c
{
  public static final a ACc;
  boolean ABG;
  final e ABH;
  
  static
  {
    AppMethodBeat.i(291213);
    ACc = new a((byte)0);
    AppMethodBeat.o(291213);
  }
  
  public j(e parame)
  {
    AppMethodBeat.i(291212);
    this.ABH = parame;
    AppMethodBeat.o(291212);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(291211);
    String str = this.ABH.aBG();
    AppMethodBeat.o(291211);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(291210);
    this.ABH.a((m.b)new b(this));
    AppMethodBeat.o(291210);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/action/FollowActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class b
    implements m.b
  {
    public final void a(com.tencent.mm.loader.g.j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(272711);
      p.k(paramj, "status");
      this.ACd.ABG = paramBoolean;
      this.ACd.a(paramj);
      AppMethodBeat.o(272711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.j
 * JD-Core Version:    0.7.0.1
 */