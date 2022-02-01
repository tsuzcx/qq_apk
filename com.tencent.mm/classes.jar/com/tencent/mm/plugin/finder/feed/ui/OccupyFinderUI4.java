package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "url", "", "getLayoutId", "", "goToWebViewUI", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setWindowStyle", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI4
  extends MMFinderUI
{
  public static final a xTp;
  private HashMap _$_findViewCache;
  private String url;
  
  static
  {
    AppMethodBeat.i(269808);
    xTp = new a((byte)0);
    AppMethodBeat.o(269808);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(269810);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(269810);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(269809);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(269809);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_anchor_verify_webview_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(269806);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(269806);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(269803);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    this.url = getIntent().getStringExtra("KEY_URL");
    paramBundle = (CharSequence)this.url;
    if ((paramBundle == null) || (paramBundle.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      finish();
      AppMethodBeat.o(269803);
      return;
    }
    paramBundle = new Intent();
    paramBundle.putExtra("showShare", false);
    paramBundle.putExtra("KRightBtn", true);
    paramBundle.putExtra("rawUrl", this.url);
    c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramBundle, 20003);
    AppMethodBeat.o(269803);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4$Companion;", "", "()V", "KEY_URL", "", "REQUEST_CODE", "", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI4
 * JD-Core Version:    0.7.0.1
 */