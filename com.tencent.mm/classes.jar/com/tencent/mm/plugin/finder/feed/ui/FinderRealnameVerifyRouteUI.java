package com.tencent.mm.plugin.finder.feed.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ji;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.utils.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRealnameVerifyRouteUI;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRealnameVerifyRouteUI
  extends HellActivity
{
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364946);
    super.onCreate(paramBundle);
    setContentView(e.f.finder_transparent_layout);
    paramBundle = getActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    if (getIntent().getBooleanExtra("enterRealnameVerifyUI", false))
    {
      paramBundle = a.GfO;
      a.j((Activity)this, "");
    }
    for (;;)
    {
      overridePendingTransition(0, 0);
      AppMethodBeat.o(364946);
      return;
      new ji().publish();
      finish();
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(364954);
    super.onNewIntent(paramIntent);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(364954);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRealnameVerifyRouteUI
 * JD-Core Version:    0.7.0.1
 */