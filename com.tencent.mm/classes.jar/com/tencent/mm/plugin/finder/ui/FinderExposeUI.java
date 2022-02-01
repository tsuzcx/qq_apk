package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderExposeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderExposeUI
  extends MMFinderUI
{
  private static final boolean a(FinderExposeUI paramFinderExposeUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347127);
    s.u(paramFinderExposeUI, "this$0");
    paramFinderExposeUI.finish();
    AppMethodBeat.o(347127);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_error_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167238);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn(new FinderExposeUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(167238);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderExposeUI
 * JD-Core Version:    0.7.0.1
 */