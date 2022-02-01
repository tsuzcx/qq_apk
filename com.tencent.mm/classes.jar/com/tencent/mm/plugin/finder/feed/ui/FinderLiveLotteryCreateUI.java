package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.ag;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveLotteryCreateUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "mBackBtnListener", "Landroid/view/MenuItem$OnMenuItemClickListener;", "getForceOrientation", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveLotteryCreateUI
  extends MMFinderUI
{
  private final MenuItem.OnMenuItemClickListener Bpg;
  
  public FinderLiveLotteryCreateUI()
  {
    AppMethodBeat.i(365208);
    this.Bpg = new FinderLiveLotteryCreateUI..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(365208);
  }
  
  private static final boolean a(FinderLiveLotteryCreateUI paramFinderLiveLotteryCreateUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365215);
    s.u(paramFinderLiveLotteryCreateUI, "this$0");
    paramFinderLiveLotteryCreateUI.hideVKB();
    paramFinderLiveLotteryCreateUI.finish();
    AppMethodBeat.o(365215);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365232);
    Set localSet = ar.setOf(ag.class);
    AppMethodBeat.o(365232);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365228);
    super.onCreate(paramBundle);
    setMMTitle(p.h.CjG);
    setBackBtn(this.Bpg, p.g.icons_filled_close);
    AppMethodBeat.o(365228);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryCreateUI
 * JD-Core Version:    0.7.0.1
 */