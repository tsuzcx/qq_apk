package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "backBtn", "Landroid/view/View;", "curCountDown", "", "curUrl", "nextCallback", "Lkotlin/Function0;", "", "getNextCallback", "()Lkotlin/jvm/functions/Function0;", "setNextCallback", "(Lkotlin/jvm/functions/Function0;)V", "okBtn", "Landroid/widget/Button;", "root", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "titleTv", "Landroid/widget/TextView;", "webChromeClient", "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC$webChromeClient$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC$webChromeClient$1;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "countDown", "hide", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "show", "showLicense", "url", "updateOkBtnTxt", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends UIComponent
{
  private String Bpy;
  private View CxW;
  public kotlin.g.a.a<ah> DYl;
  private final b DYm;
  private final String TAG;
  private View lBX;
  private Button nhC;
  private int njK;
  private MTimerHandler nmZ;
  private TextView titleTv;
  private MMWebView webView;
  
  public h(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356246);
    this.TAG = "Finder.FinderGameFinishUIC";
    this.njK = 6;
    this.Bpy = "";
    this.DYm = new b(this, paramAppCompatActivity);
    this.nmZ = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new a(this), true);
    AppMethodBeat.o(356246);
  }
  
  private static final void a(h paramh)
  {
    AppMethodBeat.i(356346);
    s.u(paramh, "this$0");
    paramh = paramh.lBX;
    if (paramh != null) {
      paramh.setVisibility(8);
    }
    AppMethodBeat.o(356346);
  }
  
  private static final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(356326);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    paramView = com.tencent.d.a.a.a.a.a.ahiX;
    com.tencent.d.a.a.a.a.a.aGU(1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adbA, Boolean.TRUE);
    paramh.hide();
    paramh = paramh.DYl;
    if (paramh != null) {
      paramh.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356326);
  }
  
  private final void awc(String paramString)
  {
    AppMethodBeat.i(356268);
    try
    {
      this.Bpy = paramString;
      MMWebView localMMWebView = this.webView;
      if (localMMWebView != null) {
        localMMWebView.loadUrl(paramString);
      }
      this.nmZ.stopTimer();
      this.njK = 6;
      this.nmZ.startTimer(1000L);
      paramString = this.nhC;
      if (paramString != null) {
        paramString.setEnabled(false);
      }
      AppMethodBeat.o(356268);
      return;
    }
    catch (Exception paramString)
    {
      Log.e(this.TAG, paramString.getMessage());
      AppMethodBeat.o(356268);
    }
  }
  
  private static final void b(h paramh, View paramView)
  {
    AppMethodBeat.i(356338);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    paramh.getActivity().finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356338);
  }
  
  private final void bSZ()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = null;
    AppMethodBeat.i(356289);
    Object localObject = this.lBX;
    if (localObject == null)
    {
      localObject = null;
      this.titleTv = ((TextView)localObject);
      localObject = this.lBX;
      if (localObject != null) {
        break label298;
      }
      localObject = null;
      label35:
      this.CxW = ((View)localObject);
      this.webView = MMWebView.a.b((Context)getActivity(), this.lBX, p.e.BLj);
      localObject = this.webView;
      if (localObject != null) {
        ((MMWebView)localObject).setWebChromeClient((z)this.DYm);
      }
      localObject = this.lBX;
      if (localObject != null) {
        break label309;
      }
      localObject = null;
      label92:
      this.nhC = ((Button)localObject);
      localObject = this.nhC;
      if (localObject != null) {
        break label323;
      }
      localObject = null;
      label108:
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label331;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      label120:
      if (localObject != null)
      {
        int i = bd.fromDPToPix((Context)getActivity(), 48);
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (bf.bk((Context)getActivity()) + i);
      }
      localObject = this.lBX;
      if (localObject != null) {
        break label336;
      }
      localObject = null;
      label164:
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label361;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      label176:
      if (localObject != null) {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = bf.bk((Context)getActivity());
      }
      localObject = this.nhC;
      if (localObject != null) {
        ((Button)localObject).setOnClickListener(new h..ExternalSyntheticLambda1(this));
      }
      localObject = this.CxW;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new h..ExternalSyntheticLambda0(this));
      }
      localObject = this.lBX;
      if (localObject != null) {
        break label366;
      }
      localObject = null;
    }
    for (;;)
    {
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject;
      }
      if (localMarginLayoutParams != null) {
        localMarginLayoutParams.topMargin = bf.getStatusBarHeight((Context)getActivity());
      }
      AppMethodBeat.o(356289);
      return;
      localObject = (TextView)((View)localObject).findViewById(p.e.BKJ);
      break;
      label298:
      localObject = ((View)localObject).findViewById(p.e.BKG);
      break label35;
      label309:
      localObject = (Button)((View)localObject).findViewById(p.e.BKI);
      break label92;
      label323:
      localObject = ((Button)localObject).getLayoutParams();
      break label108;
      label331:
      localObject = null;
      break label120;
      label336:
      localObject = ((View)localObject).findViewById(p.e.BKH);
      if (localObject == null)
      {
        localObject = null;
        break label164;
      }
      localObject = ((View)localObject).getLayoutParams();
      break label164;
      label361:
      localObject = null;
      break label176;
      label366:
      localObject = ((View)localObject).findViewById(p.e.BLi);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((View)localObject).getLayoutParams();
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(356519);
    Object localObject = getActivity();
    if ((localObject instanceof MMActivity)) {}
    for (localObject = (MMActivity)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((MMActivity)localObject).getController();
        if (localObject != null) {
          ((y)localObject).setStatusBarColor(getActivity().getResources().getColor(p.b.transparent));
        }
      }
      localObject = this.lBX;
      if (localObject != null)
      {
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationX(-bf.bf((Context)getActivity()).x);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).withEndAction(new h..ExternalSyntheticLambda2(this));
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).start();
            }
          }
        }
      }
      AppMethodBeat.o(356519);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356481);
    super.onCreate(paramBundle);
    this.lBX = findViewById(p.e.Cac);
    AppMethodBeat.o(356481);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(356494);
    super.onDestroy();
    this.nmZ.stopTimer();
    MMWebView localMMWebView = this.webView;
    if (localMMWebView != null) {
      localMMWebView.destroy();
    }
    AppMethodBeat.o(356494);
  }
  
  public final void show()
  {
    AppMethodBeat.i(356506);
    bSZ();
    Object localObject = getActivity();
    if ((localObject instanceof MMActivity)) {}
    for (localObject = (MMActivity)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((MMActivity)localObject).getController();
        if (localObject != null) {
          ((y)localObject).setStatusBarColor(getActivity().getResources().getColor(p.b.BW_100));
        }
      }
      localObject = this.lBX;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      awc("https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_game_agreement");
      AppMethodBeat.o(356506);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC$timerThread$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements MTimerHandler.CallBack
  {
    a(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(356134);
      Object localObject = this.DYn;
      h.a((h)localObject, h.e((h)localObject) - 1);
      h.f(this.DYn);
      if (h.e(this.DYn) <= 0)
      {
        localObject = h.g(this.DYn);
        if (localObject != null) {
          ((Button)localObject).setEnabled(true);
        }
        AppMethodBeat.o(356134);
        return false;
      }
      AppMethodBeat.o(356134);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameProtocolUIC$webChromeClient$1", "Lcom/tencent/xweb/WebChromeClient;", "onReceivedTitle", "", "view", "Lcom/tencent/xweb/WebView;", "title", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends z
  {
    b(h paramh, AppCompatActivity paramAppCompatActivity) {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(356113);
      super.d(paramWebView, paramString);
      Log.i(h.b(this.DYn), "onReceivedTitle title:" + paramString + ' ' + paramAppCompatActivity);
      paramWebView = (CharSequence)paramString;
      if ((paramWebView == null) || (paramWebView.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(356113);
        return;
      }
      if ((!s.p(h.c(this.DYn), paramString)) && (!c.agu(paramString)) && (!n.U(paramString, "about:blank", false)))
      {
        paramWebView = h.d(this.DYn);
        if (paramWebView != null) {
          paramWebView.setText((CharSequence)paramString);
        }
      }
      AppMethodBeat.o(356113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.h
 * JD-Core Version:    0.7.0.1
 */