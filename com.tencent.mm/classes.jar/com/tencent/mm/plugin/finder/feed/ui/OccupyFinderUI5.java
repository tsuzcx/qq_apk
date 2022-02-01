package com.tencent.mm.plugin.finder.feed.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.io;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "plugin-finder_release"})
public final class OccupyFinderUI5
  extends HellActivity
{
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278653);
    super.onCreate(paramBundle);
    setContentView(b.g.finder_transparent_layout);
    paramBundle = getActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    if (getIntent().getBooleanExtra("enterRealnameVerifyUI", false))
    {
      paramBundle = a.ACH;
      a.g((Activity)this, "");
    }
    for (;;)
    {
      overridePendingTransition(0, 0);
      AppMethodBeat.o(278653);
      return;
      EventCenter.instance.publish((IEvent)new io());
      finish();
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(278656);
    super.onNewIntent(paramIntent);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(278656);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5
 * JD-Core Version:    0.7.0.1
 */