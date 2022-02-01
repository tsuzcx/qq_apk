package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"})
public final class i
  extends c
{
  public static final a Lap;
  boolean qRU;
  final b qRV;
  
  static
  {
    AppMethodBeat.i(199556);
    Lap = new a((byte)0);
    AppMethodBeat.o(199556);
  }
  
  public i(b paramb)
  {
    AppMethodBeat.i(199555);
    this.qRV = paramb;
    AppMethodBeat.o(199555);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(199554);
    String str = this.qRV.abi();
    AppMethodBeat.o(199554);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(199553);
    this.qRV.a((e.b)new b(this));
    AppMethodBeat.o(199553);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/action/FavActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class b
    implements e.b
  {
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(199552);
      k.h(paramh, "status");
      this.Laq.qRU = paramBoolean;
      this.Laq.a(paramh);
      AppMethodBeat.o(199552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.i
 * JD-Core Version:    0.7.0.1
 */