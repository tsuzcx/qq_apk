package com.tencent.mm.plugin.finder.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ar.a;
import com.tencent.mm.plugin.finder.feed.ar.b;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectActivityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "selectPresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "getLayoutId", "", "initContentView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSelectActivityUI
  extends MMFinderUI
{
  private ar.b AYE;
  private final ar.a FcK;
  
  public FinderSelectActivityUI()
  {
    AppMethodBeat.i(347485);
    this.FcK = new ar.a();
    AppMethodBeat.o(347485);
  }
  
  private static final boolean a(FinderSelectActivityUI paramFinderSelectActivityUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347492);
    s.u(paramFinderSelectActivityUI, "this$0");
    if (!paramFinderSelectActivityUI.isFinishing()) {
      paramFinderSelectActivityUI.finish();
    }
    AppMethodBeat.o(347492);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_select_activity_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(347499);
    super.onCreate(paramBundle);
    setMMTitle(getResources().getString(e.h.finder_activity_select_title));
    setBackBtn(new FinderSelectActivityUI..ExternalSyntheticLambda0(this));
    paramBundle = (MMActivity)this;
    Object localObject2 = getContentView();
    s.s(localObject2, "contentView");
    this.AYE = new ar.b(paramBundle, (View)localObject2, this.FcK, true);
    ar.a locala = this.FcK;
    localObject2 = this.AYE;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewCallback");
      paramBundle = null;
    }
    locala.a(paramBundle);
    paramBundle = this.AYE;
    if (paramBundle == null)
    {
      s.bIx("viewCallback");
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle.initView();
      AppMethodBeat.o(347499);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347503);
    super.onDestroy();
    this.FcK.onDetach();
    AppMethodBeat.o(347503);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectActivityUI
 * JD-Core Version:    0.7.0.1
 */