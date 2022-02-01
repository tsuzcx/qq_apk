package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
import java.io.IOException;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "mCurCountDown", "", "mCurUrl", "mOkBtn", "Landroid/widget/Button;", "mUrlLicense", "mUrlStandard", "mmWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "webChromeClient", "com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$webChromeClient$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$webChromeClient$1;", "getLayoutId", "initLayout", "", "licenseCountDown", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showLicense", "url", "Companion", "plugin-finder-live_release"})
public final class FinderLiveEndUI
  extends MMFinderUI
{
  public static final a xPj;
  private final String TAG;
  private HashMap _$_findViewCache;
  private MTimerHandler kKL;
  private MMWebView wIY;
  private Button xPd;
  private String xPe;
  private String xPf;
  private String xPg;
  private int xPh;
  private final e xPi;
  
  static
  {
    AppMethodBeat.i(233477);
    xPj = new a((byte)0);
    AppMethodBeat.o(233477);
  }
  
  public FinderLiveEndUI()
  {
    AppMethodBeat.i(233475);
    this.TAG = "FinderLiveEndUI";
    this.xPg = this.xPe;
    this.xPh = 5;
    this.xPi = new e(this);
    this.kKL = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new d(this), true);
    AppMethodBeat.o(233475);
  }
  
  private final void aBL(String paramString)
  {
    AppMethodBeat.i(233471);
    try
    {
      this.xPg = paramString;
      MMWebView localMMWebView = this.wIY;
      if (localMMWebView != null) {
        localMMWebView.loadUrl(paramString);
      }
      dvo();
      AppMethodBeat.o(233471);
      return;
    }
    catch (IOException paramString)
    {
      Log.e(this.TAG, paramString.getMessage());
      AppMethodBeat.o(233471);
    }
  }
  
  private final void dvo()
  {
    AppMethodBeat.i(233472);
    Button localButton = this.xPd;
    if (localButton != null) {
      localButton.setEnabled(false);
    }
    this.kKL.stopTimer();
    this.xPh = 5;
    localButton = this.xPd;
    if (localButton != null) {
      localButton.setText((CharSequence)getResources().getString(b.j.finder_live_post_precheck_license_next_countdown_tips, new Object[] { Integer.valueOf(this.xPh) }));
    }
    this.kKL.startTimer(1000L);
    AppMethodBeat.o(233472);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233485);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233485);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233483);
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
    AppMethodBeat.o(233483);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_post_precheck_license_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233468);
    super.onCreate(paramBundle);
    this.xPe = getIntent().getStringExtra("KEY_PATH_LICENSE");
    this.xPf = getIntent().getStringExtra("KEY_PATH_STANDARD");
    paramBundle = (CharSequence)this.xPe;
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramBundle = (CharSequence)this.xPf;
        if ((paramBundle != null) && (paramBundle.length() != 0)) {
          break label130;
        }
      }
    }
    label130:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label135;
      }
      Log.e(this.TAG, "mUrl is empty!!!");
      paramBundle = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.aC((Context)this, "url为空");
      finish();
      AppMethodBeat.o(233468);
      return;
      i = 0;
      break;
    }
    label135:
    setMMTitle(getResources().getString(b.j.finder_live_post_precheck_license_finder_live));
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.white));
    setBackGroundColorResource(b.c.white);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this), b.i.actionbar_icon_dark_back);
    this.wIY = MMWebView.a.a((Context)this, getContentView(), b.f.webview);
    paramBundle = this.wIY;
    if (paramBundle != null) {
      paramBundle.setWebChromeClient((x)this.xPi);
    }
    this.xPd = ((Button)findViewById(b.f.license_ok_btn));
    paramBundle = this.xPd;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    String str = this.xPe;
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    aBL(paramBundle);
    AppMethodBeat.o(233468);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233469);
    super.onDestroy();
    this.kKL.stopTimer();
    AppMethodBeat.o(233469);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$Companion;", "", "()V", "CONUNT_DOWN_INTERVAL", "", "CONUNT_DOWN_THRESHOLD", "", "KEY_PATH_LICENSE", "", "KEY_PATH_STANDARD", "plugin-finder-live_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderLiveEndUI paramFinderLiveEndUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(233283);
      this.xPk.finish();
      AppMethodBeat.o(233283);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderLiveEndUI paramFinderLiveEndUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232799);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$initLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (n.L(FinderLiveEndUI.a(this.xPk), FinderLiveEndUI.b(this.xPk), false))
      {
        this.xPk.setMMTitle(this.xPk.getResources().getString(b.j.finder_live_post_precheck_license_live_standard));
        FinderLiveEndUI localFinderLiveEndUI = this.xPk;
        localObject = FinderLiveEndUI.c(this.xPk);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        FinderLiveEndUI.a(localFinderLiveEndUI, paramView);
        paramView = FinderLiveEndUI.d(this.xPk);
        if (paramView != null) {
          paramView.setText((CharSequence)this.xPk.getResources().getString(b.j.finder_live_post_precheck_license_done_countdown_tips, new Object[] { Integer.valueOf(5) }));
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$initLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232799);
        return;
        if (n.L(FinderLiveEndUI.a(this.xPk), FinderLiveEndUI.c(this.xPk), false)) {
          this.xPk.setResult(-1);
        }
        this.xPk.finish();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$timerThread$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"})
  public static final class d
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(233926);
      Object localObject = this.xPk;
      FinderLiveEndUI.a((FinderLiveEndUI)localObject, FinderLiveEndUI.f((FinderLiveEndUI)localObject) - 1);
      Button localButton = FinderLiveEndUI.d(this.xPk);
      if (localButton != null)
      {
        if (!n.L(FinderLiveEndUI.a(this.xPk), FinderLiveEndUI.b(this.xPk), false)) {
          break label155;
        }
        if (FinderLiveEndUI.f(this.xPk) > 0) {
          break label121;
        }
      }
      label121:
      for (localObject = this.xPk.getResources().getString(b.j.finder_live_post_precheck_license_next_tips);; localObject = this.xPk.getResources().getString(b.j.finder_live_post_precheck_license_next_countdown_tips, new Object[] { Integer.valueOf(FinderLiveEndUI.f(this.xPk)) }))
      {
        localObject = (CharSequence)localObject;
        localButton.setText((CharSequence)localObject);
        if (FinderLiveEndUI.f(this.xPk) > 0) {
          break;
        }
        localObject = FinderLiveEndUI.d(this.xPk);
        if (localObject != null) {
          ((Button)localObject).setEnabled(true);
        }
        AppMethodBeat.o(233926);
        return false;
      }
      label155:
      if (FinderLiveEndUI.f(this.xPk) <= 0) {}
      for (localObject = this.xPk.getResources().getString(b.j.finder_live_post_precheck_license_done_tips);; localObject = this.xPk.getResources().getString(b.j.finder_live_post_precheck_license_done_countdown_tips, new Object[] { Integer.valueOf(FinderLiveEndUI.f(this.xPk)) }))
      {
        localObject = (CharSequence)localObject;
        break;
      }
      AppMethodBeat.o(233926);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$webChromeClient$1", "Lcom/tencent/xweb/WebChromeClient;", "onReceivedTitle", "", "view", "Lcom/tencent/xweb/WebView;", "title", "", "plugin-finder-live_release"})
  public static final class e
    extends x
  {
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(232825);
      super.d(paramWebView, paramString);
      Log.i(FinderLiveEndUI.e(this.xPk), "onReceivedTitle title:".concat(String.valueOf(paramString)));
      paramWebView = (CharSequence)paramString;
      if ((paramWebView == null) || (paramWebView.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(232825);
        return;
      }
      if (((p.h(FinderLiveEndUI.a(this.xPk), paramString) ^ true)) && (!com.tencent.mm.plugin.webview.e.b.ane(paramString)) && (!n.M(paramString, "about:blank", false))) {
        this.xPk.setMMTitle(paramString);
      }
      AppMethodBeat.o(232825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveEndUI
 * JD-Core Version:    0.7.0.1
 */