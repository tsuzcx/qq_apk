package com.tencent.mm.plugin.finder.live.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorFansClubWidget$Companion;", "", "()V", "TAG", "", "report", "", "actionResult", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
{
  public static void report(String paramString)
  {
    AppMethodBeat.i(361221);
    s.u(paramString, "actionResult");
    Object localObject = aj.CGT;
    localObject = (e)aj.business(e.class);
    if ((localObject != null) && (((e)localObject).isLiveStarted() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      j.Dob.a(q.c.DrO, paramString);
      AppMethodBeat.o(361221);
      return;
    }
    j.Dob.C(q.a.Dra.mwI, paramString);
    AppMethodBeat.o(361221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.g.a
 * JD-Core Version:    0.7.0.1
 */