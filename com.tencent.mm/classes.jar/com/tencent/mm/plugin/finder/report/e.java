package com.tencent.mm.plugin.finder.report;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderCampaignTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isAllowExitAction", "", "()Z", "setAllowExitAction", "(Z)V", "isAllowInvisible", "setAllowInvisible", "onExit", "", "invokeSource", "", "onInvisible", "onRelease", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends am
{
  public static final a FnJ;
  private boolean FnK;
  private boolean FnL;
  
  static
  {
    AppMethodBeat.i(331356);
    FnJ = new a((byte)0);
    AppMethodBeat.o(331356);
  }
  
  public e(MMFragmentActivity paramMMFragmentActivity, bui parambui)
  {
    super(paramMMFragmentActivity, parambui);
    AppMethodBeat.i(331352);
    this.visible = false;
    this.FnK = true;
    this.FnL = true;
    AppMethodBeat.o(331352);
  }
  
  protected final void azF(String paramString)
  {
    AppMethodBeat.i(331365);
    s.u(paramString, "invokeSource");
    if (!s.p(paramString, "onRelease")) {
      super.azF(paramString);
    }
    AppMethodBeat.o(331365);
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(331370);
    if (this.visible)
    {
      super.onInvisible();
      AppMethodBeat.o(331370);
      return;
    }
    h.jXD();
    AppMethodBeat.o(331370);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(331359);
    super.onRelease();
    h.jXD();
    AppMethodBeat.o(331359);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderCampaignTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.e
 * JD-Core Version:    0.7.0.1
 */