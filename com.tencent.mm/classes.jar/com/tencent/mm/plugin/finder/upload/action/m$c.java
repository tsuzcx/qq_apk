package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/action/LikeActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$c
  implements m.b
{
  m$c(m paramm) {}
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(167825);
    s.u(parami, "status");
    this.Gdo.Gax = paramBoolean;
    this.Gdo.a(parami);
    AppMethodBeat.o(167825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.m.c
 * JD-Core Version:    0.7.0.1
 */