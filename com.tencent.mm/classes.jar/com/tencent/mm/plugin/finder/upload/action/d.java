package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.c;
import com.tencent.mm.loader.f.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c
{
  public static final a GcN;
  boolean Gax;
  final e GcO;
  
  static
  {
    AppMethodBeat.i(343307);
    GcN = new a((byte)0);
    AppMethodBeat.o(343307);
  }
  
  public d(e parame)
  {
    AppMethodBeat.i(343301);
    this.GcO = parame;
    AppMethodBeat.o(343301);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343318);
    String str = this.GcO.aUE();
    AppMethodBeat.o(343318);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(343314);
    this.GcO.a((m.b)new b(this));
    AppMethodBeat.o(343314);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/action/FavActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements m.b
  {
    b(d paramd) {}
    
    public final void a(i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(343412);
      s.u(parami, "status");
      this.GcP.Gax = paramBoolean;
      this.GcP.a(parami);
      AppMethodBeat.o(343412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.d
 * JD-Core Version:    0.7.0.1
 */