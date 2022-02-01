package com.tencent.mm.plugin.finder.feed.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.finder.utils.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "plugin-finder_release"})
public final class OccupyFinderUI5
  extends HellActivity
{
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245741);
    super.onCreate(paramBundle);
    setContentView(2131494665);
    paramBundle = getActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    if (getIntent().getBooleanExtra("enterRealnameVerifyUI", false))
    {
      paramBundle = a.vUU;
      a.g((Activity)this, "");
    }
    for (;;)
    {
      overridePendingTransition(0, 0);
      AppMethodBeat.o(245741);
      return;
      finish();
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(245742);
    super.onNewIntent(paramIntent);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(245742);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5
 * JD-Core Version:    0.7.0.1
 */