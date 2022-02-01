package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "ICallback", "plugin-finder_release"})
public final class e
  extends c
{
  public static final a qRW;
  boolean qRU;
  final b qRV;
  
  static
  {
    AppMethodBeat.i(167829);
    qRW = new a((byte)0);
    AppMethodBeat.o(167829);
  }
  
  public e(b paramb)
  {
    AppMethodBeat.i(167828);
    this.qRV = paramb;
    AppMethodBeat.o(167828);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(167827);
    String str = this.qRV.abi();
    AppMethodBeat.o(167827);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167826);
    this.qRV.a((b)new c(this));
    AppMethodBeat.o(167826);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "needRetry", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(h paramh, boolean paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/action/LikeActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
  public static final class c
    implements e.b
  {
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(167825);
      k.h(paramh, "status");
      this.qRX.qRU = paramBoolean;
      this.qRX.a(paramh);
      AppMethodBeat.o(167825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.e
 * JD-Core Version:    0.7.0.1
 */