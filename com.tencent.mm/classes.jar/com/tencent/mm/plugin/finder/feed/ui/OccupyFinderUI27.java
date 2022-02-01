package com.tencent.mm.plugin.finder.feed.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.pulldown.c;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@c(1)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI27;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI27
  extends MMFinderUI
{
  public static final a Btf;
  
  static
  {
    AppMethodBeat.i(365813);
    Btf = new a((byte)0);
    AppMethodBeat.o(365813);
  }
  
  private static final boolean a(OccupyFinderUI27 paramOccupyFinderUI27, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365808);
    s.u(paramOccupyFinderUI27, "this$0");
    paramOccupyFinderUI27.finish();
    AppMethodBeat.o(365808);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365835);
    super.onCreate(paramBundle);
    overridePendingTransition(e.a.slide_right_in, e.a.slide_left_out);
    setBackBtn(new OccupyFinderUI27..ExternalSyntheticLambda0(this));
    setMMTitle(getResources().getString(e.h.finder_live_income_list_title));
    AppMethodBeat.o(365835);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(365828);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(aj.class);
    AppMethodBeat.o(365828);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI27$Companion;", "", "()V", "PARAMS_DATA", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI27
 * JD-Core Version:    0.7.0.1
 */