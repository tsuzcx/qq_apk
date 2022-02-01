package com.tencent.mm.plugin.finder.feed.ui;

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
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "mCurCountDown", "", "mCurUrl", "mOkBtn", "Landroid/widget/Button;", "mUrlLicense", "mUrlStandard", "mmWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "webChromeClient", "com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$webChromeClient$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$webChromeClient$1;", "getLayoutId", "initLayout", "", "licenseCountDown", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showLicense", "url", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveEndUI
  extends MMFinderUI
{
  public static final FinderLiveEndUI.a BoV;
  private MMWebView Aft;
  private Button BoW;
  private String BoX;
  private String BoY;
  private String BoZ;
  private int Bpa;
  private final c Bpb;
  private final String TAG;
  private MTimerHandler nmZ;
  
  static
  {
    AppMethodBeat.i(365866);
    BoV = new FinderLiveEndUI.a((byte)0);
    AppMethodBeat.o(365866);
  }
  
  public FinderLiveEndUI()
  {
    AppMethodBeat.i(365797);
    this.TAG = "FinderLiveEndUI";
    this.BoZ = this.BoX;
    this.Bpa = 5;
    this.Bpb = new c(this);
    this.nmZ = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new b(this), true);
    AppMethodBeat.o(365797);
  }
  
  private static final void a(FinderLiveEndUI paramFinderLiveEndUI, View paramView)
  {
    AppMethodBeat.i(365834);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveEndUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveEndUI, "this$0");
    if (n.T(paramFinderLiveEndUI.BoZ, paramFinderLiveEndUI.BoX, false))
    {
      paramFinderLiveEndUI.setMMTitle(paramFinderLiveEndUI.getResources().getString(p.h.CqH));
      localObject = paramFinderLiveEndUI.BoY;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      paramFinderLiveEndUI.awc(paramView);
      paramView = paramFinderLiveEndUI.BoW;
      if (paramView != null) {
        paramView.setText((CharSequence)paramFinderLiveEndUI.getResources().getString(p.h.CqE, new Object[] { Integer.valueOf(5) }));
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(365834);
      return;
      if (n.T(paramFinderLiveEndUI.BoZ, paramFinderLiveEndUI.BoY, false)) {
        paramFinderLiveEndUI.setResult(-1);
      }
      paramFinderLiveEndUI.finish();
    }
  }
  
  private static final boolean a(FinderLiveEndUI paramFinderLiveEndUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365823);
    s.u(paramFinderLiveEndUI, "this$0");
    paramFinderLiveEndUI.finish();
    AppMethodBeat.o(365823);
    return true;
  }
  
  private final void awc(String paramString)
  {
    AppMethodBeat.i(365806);
    try
    {
      this.BoZ = paramString;
      MMWebView localMMWebView = this.Aft;
      if (localMMWebView != null) {
        localMMWebView.loadUrl(paramString);
      }
      efi();
      AppMethodBeat.o(365806);
      return;
    }
    catch (IOException paramString)
    {
      Log.e(this.TAG, paramString.getMessage());
      AppMethodBeat.o(365806);
    }
  }
  
  private final void efi()
  {
    AppMethodBeat.i(365815);
    Button localButton = this.BoW;
    if (localButton != null) {
      localButton.setEnabled(false);
    }
    this.nmZ.stopTimer();
    this.Bpa = 5;
    localButton = this.BoW;
    if (localButton != null) {
      localButton.setText((CharSequence)getResources().getString(p.h.CqI, new Object[] { Integer.valueOf(this.Bpa) }));
    }
    this.nmZ.startTimer(1000L);
    AppMethodBeat.o(365815);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.Cfi;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365896);
    super.onCreate(paramBundle);
    this.BoX = getIntent().getStringExtra("KEY_PATH_LICENSE");
    this.BoY = getIntent().getStringExtra("KEY_PATH_STANDARD");
    paramBundle = (CharSequence)this.BoX;
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramBundle = (CharSequence)this.BoY;
        if ((paramBundle != null) && (paramBundle.length() != 0)) {
          break label133;
        }
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label138;
      }
      Log.e(this.TAG, "mUrl is empty!!!");
      paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.aD((Context)this, "url为空");
      finish();
      AppMethodBeat.o(365896);
      return;
      i = 0;
      break;
    }
    label138:
    setMMTitle(getResources().getString(p.h.CqG));
    hideActionbarLine();
    setActionbarColor(getResources().getColor(p.b.white));
    setBackGroundColorResource(p.b.white);
    setBackBtn(new FinderLiveEndUI..ExternalSyntheticLambda0(this), p.g.actionbar_icon_dark_back);
    this.Aft = MMWebView.a.b((Context)this, getContentView(), p.e.webview);
    paramBundle = this.Aft;
    if (paramBundle != null) {
      paramBundle.setWebChromeClient((z)this.Bpb);
    }
    this.BoW = ((Button)findViewById(p.e.BVX));
    paramBundle = this.BoW;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new FinderLiveEndUI..ExternalSyntheticLambda1(this));
    }
    String str = this.BoX;
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    awc(paramBundle);
    AppMethodBeat.o(365896);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365904);
    super.onDestroy();
    this.nmZ.stopTimer();
    AppMethodBeat.o(365904);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$timerThread$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MTimerHandler.CallBack
  {
    b(FinderLiveEndUI paramFinderLiveEndUI) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(365751);
      Object localObject = this.Bpc;
      FinderLiveEndUI.a((FinderLiveEndUI)localObject, FinderLiveEndUI.c((FinderLiveEndUI)localObject) - 1);
      Button localButton = FinderLiveEndUI.d(this.Bpc);
      if (localButton != null)
      {
        if (!n.T(FinderLiveEndUI.b(this.Bpc), FinderLiveEndUI.e(this.Bpc), false)) {
          break label155;
        }
        if (FinderLiveEndUI.c(this.Bpc) > 0) {
          break label121;
        }
      }
      label121:
      for (localObject = this.Bpc.getResources().getString(p.h.CqJ);; localObject = this.Bpc.getResources().getString(p.h.CqI, new Object[] { Integer.valueOf(FinderLiveEndUI.c(this.Bpc)) }))
      {
        localObject = (CharSequence)localObject;
        localButton.setText((CharSequence)localObject);
        if (FinderLiveEndUI.c(this.Bpc) > 0) {
          break;
        }
        localObject = FinderLiveEndUI.d(this.Bpc);
        if (localObject != null) {
          ((Button)localObject).setEnabled(true);
        }
        AppMethodBeat.o(365751);
        return false;
      }
      label155:
      if (FinderLiveEndUI.c(this.Bpc) <= 0) {}
      for (localObject = this.Bpc.getResources().getString(p.h.CqF);; localObject = this.Bpc.getResources().getString(p.h.CqE, new Object[] { Integer.valueOf(FinderLiveEndUI.c(this.Bpc)) }))
      {
        localObject = (CharSequence)localObject;
        break;
      }
      AppMethodBeat.o(365751);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveEndUI$webChromeClient$1", "Lcom/tencent/xweb/WebChromeClient;", "onReceivedTitle", "", "view", "Lcom/tencent/xweb/WebView;", "title", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends z
  {
    c(FinderLiveEndUI paramFinderLiveEndUI) {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(365761);
      super.d(paramWebView, paramString);
      Log.i(FinderLiveEndUI.a(this.Bpc), s.X("onReceivedTitle title:", paramString));
      paramWebView = (CharSequence)paramString;
      if ((paramWebView == null) || (paramWebView.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(365761);
        return;
      }
      if ((!s.p(FinderLiveEndUI.b(this.Bpc), paramString)) && (!c.agu(paramString)) && (!n.U(paramString, "about:blank", false))) {
        this.Bpc.setMMTitle(paramString);
      }
      AppMethodBeat.o(365761);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveEndUI
 * JD-Core Version:    0.7.0.1
 */