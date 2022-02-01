package com.tencent.mm.plugin.finder.publish;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.ah.a;
import com.tencent.mm.plugin.finder.report.ah.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/publish/PublishStatApi;", "Lcom/tencent/mm/plugin/finder/publish/IPublishStatApi;", "()V", "reportCapacity", "", "folderSizeMap", "", "", "", "reportNormalFolderClearCost", "cost", "reportNormalFolderMarkCost", "reportPostFailedDeleteCount", "isLongVideo", "", "reportPostFailedDeleteLongVideoCount", "reportPostFailedStage1", "reportPostFailedStage2", "reportPostFailedStage3", "reportPostFailedStage4", "reportPostingDeleteCount", "reportPostingDeleteLongVideoCount", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements f
{
  public static final j FhS;
  
  static
  {
    AppMethodBeat.i(330552);
    FhS = new j();
    AppMethodBeat.o(330552);
  }
  
  public final void ao(Map<String, Long> paramMap)
  {
    AppMethodBeat.i(330581);
    s.u(paramMap, "folderSizeMap");
    ah.a locala = ah.a.Fts;
    ah.a.ao(paramMap);
    AppMethodBeat.o(330581);
  }
  
  public final void eLb()
  {
    AppMethodBeat.i(330563);
    ah.d locald = ah.d.Ftw;
    ah.d.eNz();
    AppMethodBeat.o(330563);
  }
  
  public final void eLc()
  {
    AppMethodBeat.i(330570);
    ah.d locald = ah.d.Ftw;
    ah.d.eNA();
    AppMethodBeat.o(330570);
  }
  
  public final void pr(long paramLong)
  {
    AppMethodBeat.i(330575);
    ah.a locala = ah.a.Fts;
    ah.a.pr(paramLong);
    AppMethodBeat.o(330575);
  }
  
  public final void ps(long paramLong)
  {
    AppMethodBeat.i(330589);
    ah.a locala = ah.a.Fts;
    ah.a.ps(paramLong);
    AppMethodBeat.o(330589);
  }
  
  public final void tl(boolean paramBoolean)
  {
    AppMethodBeat.i(330557);
    ah.d locald = ah.d.Ftw;
    ah.d.tl(paramBoolean);
    AppMethodBeat.o(330557);
  }
  
  public final void tm(boolean paramBoolean)
  {
    AppMethodBeat.i(330566);
    ah.d locald = ah.d.Ftw;
    ah.d.tm(paramBoolean);
    AppMethodBeat.o(330566);
  }
  
  public final void tn(boolean paramBoolean)
  {
    AppMethodBeat.i(330593);
    ah.d locald = ah.d.Ftw;
    ah.d.tn(paramBoolean);
    AppMethodBeat.o(330593);
  }
  
  public final void to(boolean paramBoolean)
  {
    AppMethodBeat.i(330597);
    ah.d locald = ah.d.Ftw;
    ah.d.to(paramBoolean);
    AppMethodBeat.o(330597);
  }
  
  public final void tp(boolean paramBoolean)
  {
    AppMethodBeat.i(330600);
    ah.d locald = ah.d.Ftw;
    ah.d.tp(paramBoolean);
    AppMethodBeat.o(330600);
  }
  
  public final void tq(boolean paramBoolean)
  {
    AppMethodBeat.i(330604);
    ah.d locald = ah.d.Ftw;
    ah.d.tq(paramBoolean);
    AppMethodBeat.o(330604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.publish.j
 * JD-Core Version:    0.7.0.1
 */