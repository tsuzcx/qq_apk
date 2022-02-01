package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.m;
import com.tencent.mm.plugin.finder.live.viewmodel.n;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorRoleUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "getReportTag", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveVisitorRoleUI
  extends MMFinderUI
{
  private final String TAG = "FinderLiveVisitorRoleUI";
  
  private static final boolean a(FinderLiveVisitorRoleUI paramFinderLiveVisitorRoleUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364933);
    s.u(paramFinderLiveVisitorRoleUI, "this$0");
    paramFinderLiveVisitorRoleUI.onBackPressed();
    AppMethodBeat.o(364933);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return this.TAG;
  }
  
  public final int getLayoutId()
  {
    return p.f.Cge;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364964);
    Set localSet = ar.setOf(new Class[] { n.class, m.class });
    AppMethodBeat.o(364964);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364982);
    super.onCreate(paramBundle);
    setMMTitle(p.h.CtO);
    setBackBtn(new FinderLiveVisitorRoleUI..ExternalSyntheticLambda0(this), p.g.icons_filled_close);
    AppMethodBeat.o(364982);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorRoleUI
 * JD-Core Version:    0.7.0.1
 */