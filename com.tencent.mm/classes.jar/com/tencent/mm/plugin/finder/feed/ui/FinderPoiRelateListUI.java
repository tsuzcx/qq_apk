package com.tencent.mm.plugin.finder.feed.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.ap;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiRelateListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPoiRelateListUI
  extends MMFinderUI
{
  private static final boolean a(FinderPoiRelateListUI paramFinderPoiRelateListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365064);
    s.u(paramFinderPoiRelateListUI, "this$0");
    paramFinderPoiRelateListUI.finish();
    AppMethodBeat.o(365064);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getCommentScene()
  {
    return 124;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365079);
    Set localSet = ar.setOf(ap.class);
    AppMethodBeat.o(365079);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365088);
    super.onCreate(paramBundle);
    setBackBtn(new FinderPoiRelateListUI..ExternalSyntheticLambda0(this));
    setActionbarColor(getResources().getColor(e.b.BG_2));
    setMMTitle(getResources().getString(e.h.finder_poi_add_guide_title));
    hideActionbarLine();
    AppMethodBeat.o(365088);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPoiRelateListUI
 * JD-Core Version:    0.7.0.1
 */