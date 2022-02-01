package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends c
{
  public static final a Gdh;
  boolean Gax;
  final e GcO;
  
  static
  {
    AppMethodBeat.i(343359);
    Gdh = new a((byte)0);
    AppMethodBeat.o(343359);
  }
  
  public j(e parame)
  {
    AppMethodBeat.i(343350);
    this.GcO = parame;
    AppMethodBeat.o(343350);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343378);
    String str = this.GcO.aUE();
    AppMethodBeat.o(343378);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(343371);
    this.GcO.a((m.b)new j.b(this));
    AppMethodBeat.o(343371);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FollowActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.j
 * JD-Core Version:    0.7.0.1
 */