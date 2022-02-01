package com.tencent.mm.plugin.fts.ui.f;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.ui.widget.f;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.webview.d;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.plugin.websearch.webview.l;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.gia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/webview/PardusJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "Lcom/tencent/mm/protocal/protobuf/WebSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;", "(Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;)V", "TAG", "", "getPardusUIComponent", "getReportType", "", "pardusAction", "", "params", "pardusReport", "renderFinish", "showFTSSearchBar", "webViewReady", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends l<gia>
{
  private final String TAG;
  
  public a(f paramf)
  {
    super((d)paramf);
    AppMethodBeat.i(265685);
    this.TAG = "MicroMsg.FTS.PardusJSApi";
    AppMethodBeat.o(265685);
  }
  
  private final f fzg()
  {
    AppMethodBeat.i(265688);
    Object localObject = this.WrO;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.widget.IPardusUIComponent");
      AppMethodBeat.o(265688);
      throw ((Throwable)localObject);
    }
    localObject = (f)localObject;
    AppMethodBeat.o(265688);
    return localObject;
  }
  
  public final int edC()
  {
    return 1;
  }
  
  @JavascriptInterface
  public final void pardusAction(String paramString)
  {
    AppMethodBeat.i(265701);
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("area", 0);
      fzg().d(i, paramString);
      AppMethodBeat.o(265701);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(265701);
    }
  }
  
  @JavascriptInterface
  public final void pardusReport(String paramString)
  {
    AppMethodBeat.i(265699);
    Log.i(this.TAG, "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("logStr", "");
      if (!Util.isNullOrNil(paramString))
      {
        eqy localeqy = new eqy();
        localeqy.abuE = paramString;
        paramString = new ae(localeqy);
        h.aZW().a((p)paramString, 0);
        AppMethodBeat.o(265699);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(265699);
    }
  }
  
  @JavascriptInterface
  public final void renderFinish(String paramString)
  {
    AppMethodBeat.i(265704);
    Log.i(this.TAG, "renderFinish %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      fzg().bj(paramString);
      AppMethodBeat.o(265704);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "pardusAction", new Object[0]);
      AppMethodBeat.o(265704);
    }
  }
  
  @JavascriptInterface
  public final void showFTSSearchBar(String paramString)
  {
    AppMethodBeat.i(265708);
    Log.i(this.TAG, "showFTSSearchBar %s", new Object[] { paramString });
    try
    {
      fzg().fzz();
      AppMethodBeat.o(265708);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "pardusAction", new Object[0]);
      AppMethodBeat.o(265708);
    }
  }
  
  @JavascriptInterface
  public final void webViewReady(String paramString)
  {
    AppMethodBeat.i(265694);
    kotlin.g.b.s.u(paramString, "params");
    Log.i(this.TAG, kotlin.g.b.s.X("webViewReady ", paramString));
    AppMethodBeat.o(265694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f.a
 * JD-Core Version:    0.7.0.1
 */