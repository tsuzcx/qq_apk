package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"})
public final class d
  extends c
{
  public static final a vUf;
  boolean vUd;
  final e vUe;
  
  static
  {
    AppMethodBeat.i(253195);
    vUf = new a((byte)0);
    AppMethodBeat.o(253195);
  }
  
  public d(e parame)
  {
    AppMethodBeat.i(253194);
    this.vUe = parame;
    AppMethodBeat.o(253194);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(253193);
    String str = this.vUe.auK();
    AppMethodBeat.o(253193);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(253192);
    this.vUe.a((k.b)new b(this));
    AppMethodBeat.o(253192);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/action/FavActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class b
    implements k.b
  {
    public final void a(j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(253191);
      p.h(paramj, "status");
      this.vUg.vUd = paramBoolean;
      this.vUg.a(paramj);
      AppMethodBeat.o(253191);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.d
 * JD-Core Version:    0.7.0.1
 */