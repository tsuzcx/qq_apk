package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"})
public final class d
  extends c
{
  public static final a rNS;
  boolean rNQ;
  final e rNR;
  
  static
  {
    AppMethodBeat.i(203532);
    rNS = new a((byte)0);
    AppMethodBeat.o(203532);
  }
  
  public d(e parame)
  {
    AppMethodBeat.i(203531);
    this.rNR = parame;
    AppMethodBeat.o(203531);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(203530);
    String str = this.rNR.acg();
    AppMethodBeat.o(203530);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(203529);
    this.rNR.a((h.b)new b(this));
    AppMethodBeat.o(203529);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/upload/action/FavActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class b
    implements h.b
  {
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(203528);
      k.h(paramh, "status");
      this.rNT.rNQ = paramBoolean;
      this.rNT.a(paramh);
      AppMethodBeat.o(203528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.d
 * JD-Core Version:    0.7.0.1
 */