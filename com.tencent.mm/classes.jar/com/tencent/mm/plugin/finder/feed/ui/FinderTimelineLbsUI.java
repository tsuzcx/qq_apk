package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.az;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineLbsUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTimelineLbsUI
  extends MMFinderUI
{
  private static final void a(FinderTimelineLbsUI paramFinderTimelineLbsUI)
  {
    AppMethodBeat.i(364918);
    s.u(paramFinderTimelineLbsUI, "this$0");
    paramFinderTimelineLbsUI = (com.tencent.mm.plugin.finder.viewmodel.component.bb)paramFinderTimelineLbsUI.component(com.tencent.mm.plugin.finder.viewmodel.component.bb.class);
    com.tencent.mm.plugin.finder.feed.bb localbb = paramFinderTimelineLbsUI.GVu;
    if (localbb != null) {
      localbb.onActionbarClick(false);
    }
    paramFinderTimelineLbsUI = paramFinderTimelineLbsUI.GVv;
    if (paramFinderTimelineLbsUI != null) {
      paramFinderTimelineLbsUI.onActionbarClick(false);
    }
    AppMethodBeat.o(364918);
  }
  
  private static final boolean a(FinderTimelineLbsUI paramFinderTimelineLbsUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364912);
    s.u(paramFinderTimelineLbsUI, "this$0");
    paramFinderTimelineLbsUI.finish();
    AppMethodBeat.o(364912);
    return true;
  }
  
  private static final void b(FinderTimelineLbsUI paramFinderTimelineLbsUI)
  {
    AppMethodBeat.i(364924);
    s.u(paramFinderTimelineLbsUI, "this$0");
    ((com.tencent.mm.plugin.finder.viewmodel.component.bb)paramFinderTimelineLbsUI.component(com.tencent.mm.plugin.finder.viewmodel.component.bb.class)).eEr();
    AppMethodBeat.o(364924);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    AppMethodBeat.i(364976);
    d locald = d.FAy;
    if (((Number)d.eRZ().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(364976);
      return 3;
    }
    AppMethodBeat.o(364976);
    return 5;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(364968);
    d locald = d.FAy;
    if (((Number)d.eRZ().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(364968);
      return 15;
    }
    AppMethodBeat.o(364968);
    return 34;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364958);
    Set localSet = ar.setOf(com.tencent.mm.plugin.finder.viewmodel.component.bb.class);
    AppMethodBeat.o(364958);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364948);
    super.onCreate(paramBundle);
    setMMTitle(e.h.finder_tab_lbs);
    ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL("finder_tl_nearby_tab");
    setBackBtn(new FinderTimelineLbsUI..ExternalSyntheticLambda0(this));
    setTitleBarClickListener(new FinderTimelineLbsUI..ExternalSyntheticLambda2(this), new FinderTimelineLbsUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(364948);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI
 * JD-Core Version:    0.7.0.1
 */