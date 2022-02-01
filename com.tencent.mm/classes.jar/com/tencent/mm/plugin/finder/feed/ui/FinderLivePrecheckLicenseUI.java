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
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "curCountDown", "", "curType", "curUrl", "mmWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "okBtn", "Landroid/widget/Button;", "standardLicenseCountDownFinish", "", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "webChromeClient", "com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$webChromeClient$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$webChromeClient$1;", "checkParamsValid", "", "getLayoutId", "gotoStandardPage", "initLayout", "licenseCountDown", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackClick", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOkBtnClick", "parseParams", "showLicense", "url", "updateOkBtnTxt", "plugin-finder-live_release"})
public final class FinderLivePrecheckLicenseUI
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private Button kEt;
  private int kGP;
  private MTimerHandler kKL;
  private MMWebView wIY;
  private String xPK;
  private String xPL;
  private boolean xPM;
  private final d xPN;
  
  public FinderLivePrecheckLicenseUI()
  {
    AppMethodBeat.i(233541);
    this.TAG = ("FinderLivePrecheckLicenseUI@" + hashCode());
    this.xPK = "";
    this.xPL = "";
    this.kGP = 5;
    this.xPN = new d(this);
    this.kKL = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new c(this), true);
    AppMethodBeat.o(233541);
  }
  
  private final void dvy()
  {
    AppMethodBeat.i(233537);
    Button localButton = this.kEt;
    if (localButton != null)
    {
      if (p.h(this.xPK, "TYPE_LICENSE"))
      {
        if (this.kGP <= 0) {}
        for (localObject = getResources().getString(b.j.finder_live_post_precheck_license_next_tips);; localObject = getResources().getString(b.j.finder_live_post_precheck_license_next_countdown_tips, new Object[] { Integer.valueOf(this.kGP) }))
        {
          localObject = (CharSequence)localObject;
          localButton.setText((CharSequence)localObject);
          AppMethodBeat.o(233537);
          return;
        }
      }
      if (this.kGP <= 0) {}
      for (Object localObject = getResources().getString(b.j.finder_live_post_precheck_license_done_tips);; localObject = getResources().getString(b.j.finder_live_post_precheck_license_done_countdown_tips, new Object[] { Integer.valueOf(this.kGP) }))
      {
        localObject = (CharSequence)localObject;
        break;
      }
    }
    AppMethodBeat.o(233537);
  }
  
  private final void dvz()
  {
    AppMethodBeat.i(233539);
    if ((p.h(this.xPK, "TYPE_STANDARD")) && (this.kGP <= 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("KEY_COUNTDOWN_FINISH", true);
      setResult(0, localIntent);
    }
    finish();
    AppMethodBeat.o(233539);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233552);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233552);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233551);
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
    AppMethodBeat.o(233551);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_post_precheck_license_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(233536);
    if (paramIntent != null) {
      bool = paramIntent.getBooleanExtra("KEY_COUNTDOWN_FINISH", false);
    }
    Log.i(this.TAG, "onActivityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2 + ", standardCountdownFinish:" + bool);
    if (paramInt1 == 1001)
    {
      if (paramInt2 == -1)
      {
        setResult(-1);
        finish();
      }
      this.xPM = bool;
    }
    AppMethodBeat.o(233536);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(233533);
    dvz();
    AppMethodBeat.o(233533);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233528);
    Log.i(this.TAG, "onCreate");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("KEY_TYPE");
    p.j(paramBundle, "intent.getStringExtra(Co…echeckLicenseUI.KEY_TYPE)");
    this.xPK = paramBundle;
    paramBundle = getIntent().getStringExtra("KEY_PATH");
    p.j(paramBundle, "intent.getStringExtra(Co…echeckLicenseUI.KEY_PATH)");
    this.xPL = paramBundle;
    if (p.h(this.xPK, "TYPE_STANDARD")) {
      this.xPM = getIntent().getBooleanExtra("KEY_COUNTDOWN_FINISH", false);
    }
    Log.i(this.TAG, "parseParams curType:" + this.xPK + ", curUrl:" + this.xPL + ", standardLicenseCountDownFinish:" + this.xPM);
    paramBundle = (CharSequence)this.xPL;
    if ((paramBundle == null) || (paramBundle.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e(this.TAG, "curUrl is empty!!!");
        paramBundle = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.aC((Context)this, "url为空");
        finish();
      }
      hideActionbarLine();
      setActionbarColor(getResources().getColor(b.c.white));
      setBackGroundColorResource(b.c.white);
      setBackBtn((MenuItem.OnMenuItemClickListener)new a(this), b.i.actionbar_icon_dark_back);
      this.wIY = MMWebView.a.a((Context)this, getContentView(), b.f.webview);
      paramBundle = this.wIY;
      if (paramBundle != null) {
        paramBundle.setWebChromeClient((x)this.xPN);
      }
      this.kEt = ((Button)findViewById(b.f.license_ok_btn));
      paramBundle = this.kEt;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      dvy();
      paramBundle = this.xPL;
      try
      {
        this.xPL = paramBundle;
        MMWebView localMMWebView = this.wIY;
        if (localMMWebView != null) {
          localMMWebView.loadUrl(paramBundle);
        }
        if ((p.h(this.xPK, "TYPE_STANDARD")) && (this.xPM))
        {
          this.kGP = 0;
          dvy();
          paramBundle = this.kEt;
          if (paramBundle != null)
          {
            paramBundle.setEnabled(true);
            AppMethodBeat.o(233528);
            return;
          }
          AppMethodBeat.o(233528);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        Log.e(this.TAG, paramBundle.getMessage());
        AppMethodBeat.o(233528);
        return;
      }
      this.kKL.stopTimer();
      this.kGP = 5;
      this.kKL.startTimer(1000L);
      paramBundle = this.kEt;
      if (paramBundle != null)
      {
        paramBundle.setEnabled(false);
        AppMethodBeat.o(233528);
        return;
      }
      AppMethodBeat.o(233528);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233530);
    Log.i(this.TAG, "onDestroy");
    super.onDestroy();
    this.kKL.stopTimer();
    AppMethodBeat.o(233530);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderLivePrecheckLicenseUI paramFinderLivePrecheckLicenseUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(233434);
      FinderLivePrecheckLicenseUI.a(this.xPO);
      AppMethodBeat.o(233434);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderLivePrecheckLicenseUI paramFinderLivePrecheckLicenseUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(233578);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$initLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderLivePrecheckLicenseUI.b(this.xPO);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$initLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233578);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$timerThread$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"})
  public static final class c
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(233561);
      Object localObject = this.xPO;
      FinderLivePrecheckLicenseUI.a((FinderLivePrecheckLicenseUI)localObject, FinderLivePrecheckLicenseUI.e((FinderLivePrecheckLicenseUI)localObject) - 1);
      FinderLivePrecheckLicenseUI.f(this.xPO);
      if (FinderLivePrecheckLicenseUI.e(this.xPO) <= 0)
      {
        localObject = FinderLivePrecheckLicenseUI.g(this.xPO);
        if (localObject != null) {
          ((Button)localObject).setEnabled(true);
        }
        AppMethodBeat.o(233561);
        return false;
      }
      AppMethodBeat.o(233561);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$webChromeClient$1", "Lcom/tencent/xweb/WebChromeClient;", "onReceivedTitle", "", "view", "Lcom/tencent/xweb/WebView;", "title", "", "plugin-finder-live_release"})
  public static final class d
    extends x
  {
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(233629);
      super.d(paramWebView, paramString);
      Log.i(FinderLivePrecheckLicenseUI.c(this.xPO), "onReceivedTitle title:".concat(String.valueOf(paramString)));
      paramWebView = (CharSequence)paramString;
      if ((paramWebView == null) || (paramWebView.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(233629);
        return;
      }
      if (((p.h(FinderLivePrecheckLicenseUI.d(this.xPO), paramString) ^ true)) && (!com.tencent.mm.plugin.webview.e.b.ane(paramString)) && (!n.M(paramString, "about:blank", false))) {
        this.xPO.setMMTitle(paramString);
      }
      AppMethodBeat.o(233629);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLivePrecheckLicenseUI
 * JD-Core Version:    0.7.0.1
 */