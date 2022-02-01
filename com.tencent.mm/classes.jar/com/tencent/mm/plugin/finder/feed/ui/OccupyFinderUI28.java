package com.tencent.mm.plugin.finder.feed.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.adl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.wxpaysdk.api.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.statusbar.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI28;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI28
  extends MMFinderUI
{
  private final String TAG = "OccupyFinderUI26";
  
  private static final void t(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(365801);
    paramBundle = new adl();
    paramBundle.ihF.result = paramInt;
    paramBundle.publish();
    AppMethodBeat.o(365801);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.finder_transparent_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365829);
    setTheme(p.i.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    hideTitleView();
    d.g(getWindow());
    paramBundle = getActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    if (getIntent().getBooleanExtra("enterRealnameVerifyUI", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_jump_activity", OccupyFinderUI28.class.getName());
      localBundle.putString("realname_verify_process_jump_plugin", "finder");
      paramBundle = AppForegroundDelegate.heY.aCb();
      if (paramBundle == null)
      {
        paramBundle = null;
        ((c)h.ax(c.class)).a(paramBundle, localBundle, OccupyFinderUI28..ExternalSyntheticLambda0.INSTANCE);
      }
    }
    for (;;)
    {
      overridePendingTransition(0, 0);
      AppMethodBeat.o(365829);
      return;
      paramBundle = (Activity)paramBundle.get();
      break;
      finish();
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(365833);
    super.onNewIntent(paramIntent);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(365833);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI28
 * JD-Core Version:    0.7.0.1
 */