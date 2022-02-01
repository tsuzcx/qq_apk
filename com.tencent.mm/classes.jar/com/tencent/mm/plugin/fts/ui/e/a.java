package com.tencent.mm.plugin.fts.ui.e;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.webview.b;
import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.plugin.websearch.webview.h;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.fas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fts/ui/webview/PardusJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "Lcom/tencent/mm/protocal/protobuf/WebSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;", "(Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;)V", "TAG", "", "getPardusUIComponent", "getReportType", "", "pardusAction", "", "params", "pardusReport", "renderFinish", "reportKV", "webViewReady", "ui-fts_release"})
public final class a
  extends h<fas>
{
  private final String TAG;
  
  public a(d paramd)
  {
    super((c)paramd);
    AppMethodBeat.i(235453);
    this.TAG = "MicroMsg.FTS.PardusJSApi";
    AppMethodBeat.o(235453);
  }
  
  private final d dPJ()
  {
    AppMethodBeat.i(235447);
    Object localObject = this.IHe;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.widget.IPardusUIComponent");
      AppMethodBeat.o(235447);
      throw ((Throwable)localObject);
    }
    localObject = (d)localObject;
    AppMethodBeat.o(235447);
    return localObject;
  }
  
  public final int ddN()
  {
    return 1;
  }
  
  @JavascriptInterface
  public final void pardusAction(String paramString)
  {
    AppMethodBeat.i(235451);
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("area", 0);
      dPJ().a(i, paramString);
      AppMethodBeat.o(235451);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(235451);
    }
  }
  
  @JavascriptInterface
  public final void pardusReport(String paramString)
  {
    AppMethodBeat.i(235449);
    Log.i(this.TAG, "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("logStr", "");
      if (!Util.isNullOrNil(paramString))
      {
        doc localdoc = new doc();
        localdoc.MRe = paramString;
        paramString = new ad(localdoc);
        g.azz().b((q)paramString);
        AppMethodBeat.o(235449);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(235449);
    }
  }
  
  @JavascriptInterface
  public final void renderFinish(String paramString)
  {
    AppMethodBeat.i(235452);
    Log.i(this.TAG, "renderFinish %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      dPJ().aQ(paramString);
      AppMethodBeat.o(235452);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "pardusAction", new Object[0]);
      AppMethodBeat.o(235452);
    }
  }
  
  @JavascriptInterface
  public final void reportKV(String paramString)
  {
    AppMethodBeat.i(235450);
    Log.i(this.TAG, "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logid");
      paramString = paramString.optString("msg", "");
      e.Cxv.kvStat(i, paramString);
      AppMethodBeat.o(235450);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(235450);
    }
  }
  
  @JavascriptInterface
  public final void webViewReady(String paramString)
  {
    AppMethodBeat.i(235448);
    p.h(paramString, "params");
    Log.i(this.TAG, "webViewReady ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(235448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.a
 * JD-Core Version:    0.7.0.1
 */