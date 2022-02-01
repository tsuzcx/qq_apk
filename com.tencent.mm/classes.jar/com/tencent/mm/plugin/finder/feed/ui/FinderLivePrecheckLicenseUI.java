package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "curCountDown", "", "curType", "curUrl", "mmWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "okBtn", "Landroid/widget/Button;", "standardLicenseCountDownFinish", "", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "webChromeClient", "com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$webChromeClient$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$webChromeClient$1;", "checkParamsValid", "", "getLayoutId", "gotoStandardPage", "initLayout", "licenseCountDown", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackClick", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOkBtnClick", "parseParams", "showLicense", "url", "updateOkBtnTxt", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLivePrecheckLicenseUI
  extends MMFinderUI
{
  private MMWebView Aft;
  private final b BpA;
  private String Bpx;
  private String Bpy;
  private boolean Bpz;
  private final String TAG;
  private Button nhC;
  private int njK;
  private MTimerHandler nmZ;
  
  public FinderLivePrecheckLicenseUI()
  {
    AppMethodBeat.i(364850);
    this.TAG = s.X("FinderLivePrecheckLicenseUI@", Integer.valueOf(hashCode()));
    this.Bpx = "";
    this.Bpy = "";
    this.njK = 5;
    this.BpA = new b(this);
    this.nmZ = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new a(this), true);
    AppMethodBeat.o(364850);
  }
  
  private static final void a(FinderLivePrecheckLicenseUI paramFinderLivePrecheckLicenseUI, View paramView)
  {
    AppMethodBeat.i(364890);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLivePrecheckLicenseUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLivePrecheckLicenseUI, "this$0");
    paramView = paramFinderLivePrecheckLicenseUI.Bpx;
    if (s.p(paramView, "TYPE_LICENSE"))
    {
      paramView = new Intent();
      paramView.putExtra("KEY_PATH", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_up_privacy");
      paramView.putExtra("KEY_TYPE", "TYPE_STANDARD");
      paramView.putExtra("KEY_COUNTDOWN_FINISH", paramFinderLivePrecheckLicenseUI.Bpz);
      ((f)h.ax(f.class)).b((Activity)paramFinderLivePrecheckLicenseUI, paramView, 1001);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364890);
      return;
      if (s.p(paramView, "TYPE_STANDARD"))
      {
        paramFinderLivePrecheckLicenseUI.setResult(-1);
        paramFinderLivePrecheckLicenseUI.finish();
      }
      else
      {
        paramFinderLivePrecheckLicenseUI.eft();
      }
    }
  }
  
  private static final boolean a(FinderLivePrecheckLicenseUI paramFinderLivePrecheckLicenseUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364882);
    s.u(paramFinderLivePrecheckLicenseUI, "this$0");
    paramFinderLivePrecheckLicenseUI.eft();
    AppMethodBeat.o(364882);
    return true;
  }
  
  private final void efs()
  {
    AppMethodBeat.i(364864);
    Button localButton = this.nhC;
    if (localButton != null)
    {
      if (!s.p(this.Bpx, "TYPE_LICENSE")) {
        break label88;
      }
      if (this.njK > 0) {
        break label60;
      }
    }
    label60:
    for (Object localObject = getResources().getString(p.h.CqJ);; localObject = getResources().getString(p.h.CqI, new Object[] { Integer.valueOf(this.njK) }))
    {
      localObject = (CharSequence)localObject;
      localButton.setText((CharSequence)localObject);
      AppMethodBeat.o(364864);
      return;
    }
    label88:
    if (this.njK <= 0) {}
    for (localObject = getResources().getString(p.h.CqF);; localObject = getResources().getString(p.h.CqE, new Object[] { Integer.valueOf(this.njK) }))
    {
      localObject = (CharSequence)localObject;
      break;
    }
  }
  
  private final void eft()
  {
    AppMethodBeat.i(364873);
    if ((s.p(this.Bpx, "TYPE_STANDARD")) && (this.njK <= 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("KEY_COUNTDOWN_FINISH", true);
      ah localah = ah.aiuX;
      setResult(0, localIntent);
    }
    finish();
    AppMethodBeat.o(364873);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.Cfi;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(364975);
    if (paramIntent == null) {}
    for (;;)
    {
      Log.i(this.TAG, "onActivityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2 + ", standardCountdownFinish:" + bool);
      if (paramInt1 == 1001)
      {
        if (paramInt2 == -1)
        {
          setResult(-1);
          finish();
        }
        this.Bpz = bool;
      }
      AppMethodBeat.o(364975);
      return;
      bool = paramIntent.getBooleanExtra("KEY_COUNTDOWN_FINISH", false);
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(364966);
    eft();
    AppMethodBeat.o(364966);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364947);
    Log.i(this.TAG, "onCreate");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("KEY_TYPE");
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "intent.getStringExtra(Co…heckLicenseUI.KEY_TYPE)!!");
    this.Bpx = paramBundle;
    paramBundle = getIntent().getStringExtra("KEY_PATH");
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "intent.getStringExtra(Co…heckLicenseUI.KEY_PATH)!!");
    this.Bpy = paramBundle;
    if (s.p(this.Bpx, "TYPE_STANDARD")) {
      this.Bpz = getIntent().getBooleanExtra("KEY_COUNTDOWN_FINISH", false);
    }
    Log.i(this.TAG, "parseParams curType:" + this.Bpx + ", curUrl:" + this.Bpy + ", standardLicenseCountDownFinish:" + this.Bpz);
    paramBundle = (CharSequence)this.Bpy;
    if ((paramBundle == null) || (paramBundle.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e(this.TAG, "curUrl is empty!!!");
        paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.aD((Context)this, "url为空");
        finish();
      }
      hideActionbarLine();
      setActionbarColor(getResources().getColor(p.b.white));
      setBackGroundColorResource(p.b.white);
      setBackBtn(new FinderLivePrecheckLicenseUI..ExternalSyntheticLambda0(this), p.g.actionbar_icon_dark_back);
      this.Aft = MMWebView.a.b((Context)this, getContentView(), p.e.webview);
      paramBundle = this.Aft;
      if (paramBundle != null) {
        paramBundle.setWebChromeClient((z)this.BpA);
      }
      this.nhC = ((Button)findViewById(p.e.BVX));
      paramBundle = this.nhC;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new FinderLivePrecheckLicenseUI..ExternalSyntheticLambda1(this));
      }
      efs();
      paramBundle = this.Bpy;
      try
      {
        this.Bpy = paramBundle;
        MMWebView localMMWebView = this.Aft;
        if (localMMWebView != null) {
          localMMWebView.loadUrl(paramBundle);
        }
        if ((s.p(this.Bpx, "TYPE_STANDARD")) && (this.Bpz))
        {
          this.njK = 0;
          efs();
          paramBundle = this.nhC;
          if (paramBundle != null)
          {
            paramBundle.setEnabled(true);
            AppMethodBeat.o(364947);
          }
        }
        else
        {
          this.nmZ.stopTimer();
          this.njK = 5;
          this.nmZ.startTimer(1000L);
          paramBundle = this.nhC;
          if (paramBundle != null) {
            paramBundle.setEnabled(false);
          }
        }
        AppMethodBeat.o(364947);
        return;
      }
      catch (Exception paramBundle)
      {
        Log.e(this.TAG, paramBundle.getMessage());
        AppMethodBeat.o(364947);
        return;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364957);
    Log.i(this.TAG, "onDestroy");
    super.onDestroy();
    this.nmZ.stopTimer();
    AppMethodBeat.o(364957);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$timerThread$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements MTimerHandler.CallBack
  {
    a(FinderLivePrecheckLicenseUI paramFinderLivePrecheckLicenseUI) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(365528);
      Object localObject = this.BpB;
      FinderLivePrecheckLicenseUI.a((FinderLivePrecheckLicenseUI)localObject, FinderLivePrecheckLicenseUI.c((FinderLivePrecheckLicenseUI)localObject) - 1);
      FinderLivePrecheckLicenseUI.d(this.BpB);
      if (FinderLivePrecheckLicenseUI.c(this.BpB) <= 0)
      {
        localObject = FinderLivePrecheckLicenseUI.e(this.BpB);
        if (localObject != null) {
          ((Button)localObject).setEnabled(true);
        }
        AppMethodBeat.o(365528);
        return false;
      }
      AppMethodBeat.o(365528);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLivePrecheckLicenseUI$webChromeClient$1", "Lcom/tencent/xweb/WebChromeClient;", "onReceivedTitle", "", "view", "Lcom/tencent/xweb/WebView;", "title", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends z
  {
    b(FinderLivePrecheckLicenseUI paramFinderLivePrecheckLicenseUI) {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(365537);
      super.d(paramWebView, paramString);
      Log.i(FinderLivePrecheckLicenseUI.a(this.BpB), s.X("onReceivedTitle title:", paramString));
      paramWebView = (CharSequence)paramString;
      if ((paramWebView == null) || (paramWebView.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(365537);
        return;
      }
      if ((!s.p(FinderLivePrecheckLicenseUI.b(this.BpB), paramString)) && (!c.agu(paramString)) && (!n.U(paramString, "about:blank", false))) {
        this.BpB.setMMTitle(paramString);
      }
      AppMethodBeat.o(365537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLivePrecheckLicenseUI
 * JD-Core Version:    0.7.0.1
 */