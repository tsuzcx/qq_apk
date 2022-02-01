package com.tencent.mm.plugin.fts.ui.hotsearch.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.e.a;
import com.tencent.mm.plugin.websearch.webview.n;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSHotSearchUIComponent;", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/FTSMainState;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryData;", "getWebSearchJSApi", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryJSApi;", "getWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "onSearchInputChange", "", "query", "", "inputChange", "", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements e<com.tencent.mm.plugin.fts.ui.hotsearch.a.a>
{
  private final Activity activity;
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(265799);
    this.activity = paramActivity;
    AppMethodBeat.o(265799);
  }
  
  public final void cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265832);
    s.u(paramString, "query");
    paramString = (Throwable)new q("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(265832);
    throw paramString;
  }
  
  public final n<com.tencent.mm.plugin.fts.ui.hotsearch.a.a> fyE()
  {
    AppMethodBeat.i(265818);
    if (com.tencent.mm.plugin.fts.ui.o.fyA())
    {
      Object localObject = k.aeZF;
      localObject = ((com.tencent.mm.plugin.fts.ui.hotsearch.uic.a)k.nq((Context)this.activity).cq(com.tencent.mm.plugin.fts.ui.hotsearch.uic.a.class)).fyE();
      AppMethodBeat.o(265818);
      return localObject;
    }
    AppMethodBeat.o(265818);
    return null;
  }
  
  public final com.tencent.mm.plugin.websearch.webview.o<com.tencent.mm.plugin.fts.ui.hotsearch.a.a> fyP()
  {
    AppMethodBeat.i(265824);
    Object localObject = k.aeZF;
    localObject = (com.tencent.mm.plugin.websearch.webview.o)((com.tencent.mm.plugin.fts.ui.hotsearch.uic.a)k.nq((Context)this.activity).cq(com.tencent.mm.plugin.fts.ui.hotsearch.uic.a.class)).fyD();
    AppMethodBeat.o(265824);
    return localObject;
  }
  
  public final Context getActivityContext()
  {
    return (Context)this.activity;
  }
  
  public final WebSearchWebView getWebView()
  {
    AppMethodBeat.i(265805);
    if (com.tencent.mm.plugin.fts.ui.o.fyA())
    {
      Object localObject = k.aeZF;
      localObject = ((com.tencent.mm.plugin.fts.ui.hotsearch.uic.a)k.nq((Context)this.activity).cq(com.tencent.mm.plugin.fts.ui.hotsearch.uic.a.class)).fyC();
      AppMethodBeat.o(265805);
      return localObject;
    }
    AppMethodBeat.o(265805);
    return null;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(265836);
    e.a.a((e)this);
    AppMethodBeat.o(265836);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(265839);
    e.a.b((e)this);
    AppMethodBeat.o(265839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.b.b
 * JD-Core Version:    0.7.0.1
 */