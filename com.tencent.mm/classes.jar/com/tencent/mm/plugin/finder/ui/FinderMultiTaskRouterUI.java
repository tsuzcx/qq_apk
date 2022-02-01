package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMultiTaskRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finishSelf", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMultiTaskRouterUI
  extends MMFinderUI
{
  public static final FinderMultiTaskRouterUI.a FSI;
  
  static
  {
    AppMethodBeat.i(347288);
    FSI = new FinderMultiTaskRouterUI.a((byte)0);
    AppMethodBeat.o(347288);
  }
  
  private final void fbD()
  {
    AppMethodBeat.i(347275);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(347275);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347300);
    supportRequestWindowFeature(1);
    setTheme(e.i.MMTheme_FullTranslucent);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_NEED_ANIM", false))
    {
      AppMethodBeat.o(347300);
      return;
    }
    fbD();
    AppMethodBeat.o(347300);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(347317);
    super.onPause();
    AppMethodBeat.o(347317);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347310);
    super.onResume();
    if (getIntent().getBooleanExtra("KEY_NEED_ANIM", false)) {
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b(this));
    }
    AppMethodBeat.o(347310);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(347324);
    super.onStop();
    if (!isFinishing()) {
      finish();
    }
    AppMethodBeat.o(347324);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderMultiTaskRouterUI paramFinderMultiTaskRouterUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMultiTaskRouterUI
 * JD-Core Version:    0.7.0.1
 */