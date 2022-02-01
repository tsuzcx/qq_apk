package com.tencent.mm.plugin.fts.ui.e;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.fts.ui.widget.d;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.webview.b;
import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/webview/PardusJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "Lcom/tencent/mm/protocal/protobuf/WebSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;", "(Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;)V", "TAG", "", "getPardusUIComponent", "getReportType", "", "pardusAction", "", "params", "pardusReport", "renderFinish", "reportKV", "showFTSSearchBar", "webViewReady", "ui-fts_release"})
public final class a
  extends com.tencent.mm.plugin.websearch.webview.h<fll>
{
  private final String TAG;
  
  public a(d paramd)
  {
    super((c)paramd);
    AppMethodBeat.i(190812);
    this.TAG = "MicroMsg.FTS.PardusJSApi";
    AppMethodBeat.o(190812);
  }
  
  private final d esi()
  {
    AppMethodBeat.i(190783);
    Object localObject = this.PBs;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.widget.IPardusUIComponent");
      AppMethodBeat.o(190783);
      throw ((Throwable)localObject);
    }
    localObject = (d)localObject;
    AppMethodBeat.o(190783);
    return localObject;
  }
  
  public final int duR()
  {
    return 1;
  }
  
  @JavascriptInterface
  public final void pardusAction(String paramString)
  {
    AppMethodBeat.i(190800);
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("area", 0);
      esi().b(i, paramString);
      AppMethodBeat.o(190800);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(190800);
    }
  }
  
  @JavascriptInterface
  public final void pardusReport(String paramString)
  {
    AppMethodBeat.i(190792);
    Log.i(this.TAG, "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("logStr", "");
      if (!Util.isNullOrNil(paramString))
      {
        dxu localdxu = new dxu();
        localdxu.Udk = paramString;
        paramString = new ad(localdxu);
        com.tencent.mm.kernel.h.aGY().b((q)paramString);
        AppMethodBeat.o(190792);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(190792);
    }
  }
  
  @JavascriptInterface
  public final void renderFinish(String paramString)
  {
    AppMethodBeat.i(190804);
    Log.i(this.TAG, "renderFinish %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      esi().aW(paramString);
      AppMethodBeat.o(190804);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "pardusAction", new Object[0]);
      AppMethodBeat.o(190804);
    }
  }
  
  @JavascriptInterface
  public final void reportKV(String paramString)
  {
    AppMethodBeat.i(190797);
    Log.i(this.TAG, "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logid");
      paramString = paramString.optString("msg", "");
      f.Iyx.kvStat(i, paramString);
      AppMethodBeat.o(190797);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(190797);
    }
  }
  
  @JavascriptInterface
  public final void showFTSSearchBar(String paramString)
  {
    AppMethodBeat.i(190810);
    Log.i(this.TAG, "showFTSSearchBar %s", new Object[] { paramString });
    try
    {
      esi().esA();
      AppMethodBeat.o(190810);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "pardusAction", new Object[0]);
      AppMethodBeat.o(190810);
    }
  }
  
  @JavascriptInterface
  public final void webViewReady(String paramString)
  {
    AppMethodBeat.i(190787);
    p.k(paramString, "params");
    Log.i(this.TAG, "webViewReady ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(190787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.a
 * JD-Core Version:    0.7.0.1
 */