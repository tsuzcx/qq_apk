package com.tencent.mm.plugin.finder.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderUnOpenUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderUnOpenUI
  extends MMFinderUI
{
  private static final boolean a(FinderUnOpenUI paramFinderUnOpenUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346965);
    s.u(paramFinderUnOpenUI, "this$0");
    paramFinderUnOpenUI.finish();
    AppMethodBeat.o(346965);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_unopen_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167681);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(e.b.white));
    setMMTitle("");
    setBackBtn(new FinderUnOpenUI..ExternalSyntheticLambda0(this));
    paramBundle = i.aRC().getValue("FinderFunctionUnopenTip");
    TextView localTextView = (TextView)findViewById(e.e.tip_tv);
    if (paramBundle == null) {}
    for (paramBundle = (CharSequence)getString(e.h.finder_unopen_tips);; paramBundle = (CharSequence)paramBundle)
    {
      localTextView.setText(paramBundle);
      AppMethodBeat.o(167681);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderUnOpenUI
 * JD-Core Version:    0.7.0.1
 */