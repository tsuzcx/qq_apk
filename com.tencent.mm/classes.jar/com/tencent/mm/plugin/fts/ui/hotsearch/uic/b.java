package com.tencent.mm.plugin.fts.ui.hotsearch.uic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.hotsearch.a.f;
import com.tencent.mm.plugin.fts.ui.hotsearch.a.h;
import com.tencent.mm.plugin.fts.ui.hotsearch.a.i;
import com.tencent.mm.plugin.fts.ui.hotsearch.b.d;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.WebView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSHotSearchUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSHotSearchApiUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "jsApi", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchJSApi;", "getJsApi", "()Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchJSApi;", "jsApi$delegate", "Lkotlin/Lazy;", "searchEducationLayout2", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getSearchEducationLayout2", "()Landroid/widget/LinearLayout;", "searchEducationLayout2$delegate", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchUIComponent;", "getUiComponent", "()Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchUIComponent;", "uiComponent$delegate", "webSearchData", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSRcmGuideSearchWebData;", "getWebSearchData", "()Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSRcmGuideSearchWebData;", "webSearchData$delegate", "webview", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "getWebview", "()Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "webview$delegate", "webviewContainer", "Landroid/widget/FrameLayout;", "getWebviewContainer", "()Landroid/widget/FrameLayout;", "webviewContainer$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "FTSHotSearchWebViewClient", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.mvvmbase.a
  implements a
{
  public static final b.a Hzy;
  private final kotlin.j HzA;
  private final kotlin.j HzB;
  private final kotlin.j HzC;
  private final kotlin.j HzD;
  private final kotlin.j HzE;
  private final kotlin.j Hzz;
  
  static
  {
    AppMethodBeat.i(265852);
    Hzy = new b.a((byte)0);
    AppMethodBeat.o(265852);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(265806);
    this.Hzz = k.cm((kotlin.g.a.a)new h(paramAppCompatActivity, this));
    this.HzA = k.cm((kotlin.g.a.a)new b.f(paramAppCompatActivity));
    this.HzB = k.cm((kotlin.g.a.a)new b.c(paramAppCompatActivity, this));
    this.HzC = k.cm((kotlin.g.a.a)new b.g(this));
    this.HzD = k.cm((kotlin.g.a.a)new b.i(paramAppCompatActivity));
    this.HzE = k.cm((kotlin.g.a.a)new b.e(paramAppCompatActivity));
    AppMethodBeat.o(265806);
  }
  
  private static final void a(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(265833);
    s.u(paramb, "this$0");
    ((MMActivity)paramb.getActivity()).hideVKB();
    AppMethodBeat.o(265833);
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.fts.ui.hotsearch.a.a parama)
  {
    AppMethodBeat.i(265847);
    s.u(paramb, "this$0");
    s.u(parama, "state");
    if ((com.tencent.mm.plugin.fts.ui.hotsearch.a.b)parama.checkAction(com.tencent.mm.plugin.fts.ui.hotsearch.a.b.class) != null)
    {
      paramb.fyC().addJavascriptInterface(paramb.fyD(), "ftsJSApi");
      paramb.fyH().addView((View)paramb.fyC(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      paramb.fyC().setBackgroundColor(paramb.getResources().getColor(p.a.fts_bg_color));
      paramb.fyC().loadUrl(parama.Hzr);
      Log.i("MicroMsg.FTS.FTSHotSearchUIC", s.X("load url ", parama.Hzr));
      localObject1 = paramb.fyC().getTopView();
      if (localObject1 != null)
      {
        if ((localObject1 instanceof AbsoluteLayout)) {}
        while (localObject1 != null)
        {
          localObject1 = (AbsoluteLayout)localObject1;
          Object localObject2 = paramb.fyI().getParent();
          if (localObject2 == null)
          {
            paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(265847);
            throw paramb;
            localObject1 = null;
          }
          else
          {
            ((ViewGroup)localObject2).removeView((View)paramb.fyI());
            localObject2 = new AbsoluteLayout.LayoutParams(-1, -2, 0, 0);
            ((AbsoluteLayout)localObject1).addView((View)paramb.fyI(), (ViewGroup.LayoutParams)localObject2);
            Log.i("MicroMsg.FTS.FTSHotSearchUIC", "add education view to webview");
          }
        }
      }
      paramb.fyC().a(new b..ExternalSyntheticLambda2(paramb));
    }
    Object localObject1 = (f)parama.checkAction(f.class);
    if (localObject1 != null)
    {
      if (!((f)localObject1).visible) {
        break label453;
      }
      paramb.fyH().setVisibility(0);
    }
    for (;;)
    {
      localObject1 = ((BaseState)parama).getAction();
      if ((localObject1 != null) && ((localObject1 instanceof h)))
      {
        localObject1 = ((BaseStateAction)localObject1).getResult();
        if ((localObject1 != null) && ((localObject1 instanceof i)) && (((i)localObject1).Hzx))
        {
          int i = parama.Hzs;
          float f = (com.tencent.mm.cd.a.fromDPToPix((Context)paramb.getActivity(), 16) + i) / paramb.fyC().getMMDensity();
          parama = "document.body.style.marginTop='" + f + "px';";
          Log.i("MicroMsg.FTS.FTSHotSearchUIC", s.X("setHtmlMarginTopOnWebViewReady, js:", parama));
          paramb.fyC().evaluateJavascript(parama, b..ExternalSyntheticLambda0.INSTANCE);
          paramb.fyC().setVisibility(0);
          paramb.fyC().animate().alpha(1.0F).setDuration(300L).start();
        }
      }
      AppMethodBeat.o(265847);
      return;
      label453:
      paramb.fyH().setVisibility(8);
    }
  }
  
  private static final void aEM(String paramString)
  {
    AppMethodBeat.i(265837);
    Log.i("MicroMsg.FTS.FTSHotSearchUIC", s.X("setHtmlMarginTopOnWebViewReady, result:", paramString));
    AppMethodBeat.o(265837);
  }
  
  private d fyG()
  {
    AppMethodBeat.i(265812);
    d locald = (d)this.HzC.getValue();
    AppMethodBeat.o(265812);
    return locald;
  }
  
  private FrameLayout fyH()
  {
    AppMethodBeat.i(265819);
    FrameLayout localFrameLayout = (FrameLayout)this.HzD.getValue();
    AppMethodBeat.o(265819);
    return localFrameLayout;
  }
  
  private LinearLayout fyI()
  {
    AppMethodBeat.i(265825);
    LinearLayout localLinearLayout = (LinearLayout)this.HzE.getValue();
    AppMethodBeat.o(265825);
    return localLinearLayout;
  }
  
  public final WebSearchWebView fyC()
  {
    AppMethodBeat.i(265864);
    WebSearchWebView localWebSearchWebView = (WebSearchWebView)this.Hzz.getValue();
    AppMethodBeat.o(265864);
    return localWebSearchWebView;
  }
  
  public final com.tencent.mm.plugin.fts.ui.hotsearch.b.a fyD()
  {
    AppMethodBeat.i(265874);
    com.tencent.mm.plugin.fts.ui.hotsearch.b.a locala = (com.tencent.mm.plugin.fts.ui.hotsearch.b.a)this.HzB.getValue();
    AppMethodBeat.o(265874);
    return locala;
  }
  
  public final com.tencent.mm.plugin.fts.ui.hotsearch.b.b fyF()
  {
    AppMethodBeat.i(265868);
    com.tencent.mm.plugin.fts.ui.hotsearch.b.b localb = (com.tencent.mm.plugin.fts.ui.hotsearch.b.b)this.HzA.getValue();
    AppMethodBeat.o(265868);
    return localb;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265882);
    super.onCreate(paramBundle);
    if (o.fyA())
    {
      fyD().iF("onCreate", "");
      paramBundle = getStateCenter();
      if (paramBundle != null) {
        paramBundle.process((q)getActivity(), (kotlin.g.a.b)d.HzG);
      }
      paramBundle = getStateCenter();
      if (paramBundle != null) {
        paramBundle.observe((q)getActivity(), new b..ExternalSyntheticLambda1(this));
      }
      switch (o.fyB())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(265882);
        return;
        ai.a(10000, String.valueOf(e.HrM), String.valueOf(e.HrM), false, "", 0, "", "");
        AppMethodBeat.o(265882);
        return;
        ai.a(103, String.valueOf(e.HrN), String.valueOf(e.HrM), false, "", 0, "", "");
      }
    }
    fyH().setVisibility(8);
    AppMethodBeat.o(265882);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(265895);
    if (o.fyA())
    {
      fyG().destroy();
      fyC().removeJavascriptInterface("ftsJSApi");
      fyC().destroy();
    }
    AppMethodBeat.o(265895);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(265887);
    super.onPause();
    if (o.fyA()) {
      fyD().iF("onPause", "");
    }
    AppMethodBeat.o(265887);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(265889);
    super.onResume();
    if (o.fyA()) {
      fyD().iF("onResume", "");
    }
    AppMethodBeat.o(265889);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSHotSearchUIC$FTSHotSearchWebViewClient;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchClient;", "(Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSHotSearchUIC;)V", "onPageFinished", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.websearch.webview.j
  {
    public b()
    {
      super();
      AppMethodBeat.i(265775);
      AppMethodBeat.o(265775);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(265783);
      super.b(paramWebView, paramString);
      paramWebView = this.HzF.getStateCenter();
      if (paramWebView != null) {
        paramWebView.dispatch((IStateAction)new h());
      }
      AppMethodBeat.o(265783);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(265789);
      super.b(paramWebView, paramString, paramBitmap);
      switch (o.fyB())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(265789);
        return;
        ai.a(10000, String.valueOf(e.HrM), String.valueOf(e.HrM), false, "", 0, "", false, String.valueOf(e.HrN));
        AppMethodBeat.o(265789);
        return;
        ai.a(103, String.valueOf(e.HrN), String.valueOf(e.HrM), false, "", 0, "", false, String.valueOf(e.HrN));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/FTSMainState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.fts.ui.hotsearch.a.a, ah>
  {
    public static final d HzG;
    
    static
    {
      AppMethodBeat.i(265777);
      HzG = new d();
      AppMethodBeat.o(265777);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<WebSearchWebView>
  {
    h(AppCompatActivity paramAppCompatActivity, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.uic.b
 * JD-Core Version:    0.7.0.1
 */