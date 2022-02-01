package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAnchorVerifyWebviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "url", "", "getLayoutId", "", "goToWebViewUI", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setWindowStyle", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAnchorVerifyWebviewUI
  extends MMFinderUI
{
  public static final a Blo;
  private String url;
  
  static
  {
    AppMethodBeat.i(364620);
    Blo = new a((byte)0);
    AppMethodBeat.o(364620);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.Cdc;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(364648);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(364648);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364635);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    this.url = getIntent().getStringExtra("KEY_URL");
    paramBundle = (CharSequence)this.url;
    if ((paramBundle == null) || (paramBundle.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      finish();
      AppMethodBeat.o(364635);
      return;
    }
    paramBundle = new Intent();
    paramBundle.putExtra("showShare", false);
    paramBundle.putExtra("KRightBtn", true);
    paramBundle.putExtra("rawUrl", this.url);
    c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramBundle, 20003);
    AppMethodBeat.o(364635);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAnchorVerifyWebviewUI$Companion;", "", "()V", "KEY_URL", "", "REQUEST_CODE", "", "TAG", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAnchorVerifyWebviewUI
 * JD-Core Version:    0.7.0.1
 */