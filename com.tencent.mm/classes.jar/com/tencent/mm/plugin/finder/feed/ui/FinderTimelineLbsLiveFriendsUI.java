package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ad;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineLbsLiveFriendsUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getReportType", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTimelineLbsLiveFriendsUI
  extends MMFinderUI
{
  private static final void a(FinderTimelineLbsLiveFriendsUI paramFinderTimelineLbsLiveFriendsUI)
  {
    AppMethodBeat.i(364440);
    s.u(paramFinderTimelineLbsLiveFriendsUI, "this$0");
    AppMethodBeat.o(364440);
  }
  
  private static final boolean a(FinderTimelineLbsLiveFriendsUI paramFinderTimelineLbsLiveFriendsUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364435);
    s.u(paramFinderTimelineLbsLiveFriendsUI, "this$0");
    paramFinderTimelineLbsLiveFriendsUI.finish();
    AppMethodBeat.o(364435);
    return true;
  }
  
  private static final void b(FinderTimelineLbsLiveFriendsUI paramFinderTimelineLbsLiveFriendsUI)
  {
    AppMethodBeat.i(364449);
    s.u(paramFinderTimelineLbsLiveFriendsUI, "this$0");
    AppMethodBeat.o(364449);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 3;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return (Set)ad.aivA;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364479);
    super.onCreate(paramBundle);
    setBackBtn(new FinderTimelineLbsLiveFriendsUI..ExternalSyntheticLambda0(this));
    setTitleBarClickListener(new FinderTimelineLbsLiveFriendsUI..ExternalSyntheticLambda1(this), new FinderTimelineLbsLiveFriendsUI..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(364479);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsLiveFriendsUI
 * JD-Core Version:    0.7.0.1
 */