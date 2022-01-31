package com.tencent.mm.plugin.fts.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class FTSMainUI$11
  implements Runnable
{
  FTSMainUI$11(FTSMainUI paramFTSMainUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(61878);
    if (System.currentTimeMillis() - FTSMainUI.u(this.mYi) <= 1000L)
    {
      AppMethodBeat.o(61878);
      return;
    }
    FTSMainUI.a(this.mYi, System.currentTimeMillis());
    if (!aa.Je(0))
    {
      ab.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
      AppMethodBeat.o(61878);
      return;
    }
    Object localObject = ac.agw("searchID");
    an.A(this.bHS, 14, (String)localObject);
    ab.i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[] { Integer.valueOf(this.bHS), localObject });
    this.mYi.hideVKB();
    Intent localIntent = aa.cZp();
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsbizscene", 14);
    localIntent.putExtra("ftsType", this.bHS);
    localObject = aa.d(14, true, this.bHS);
    ((Map)localObject).put("sessionId", String.valueOf(e.mRk));
    ((Map)localObject).put("subSessionId", String.valueOf(e.mRk));
    localIntent.putExtra("sessionId", String.valueOf(e.mRk));
    localIntent.putExtra("subSessionId", String.valueOf(e.mRk));
    localIntent.putExtra("rawUrl", aa.F((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localObject = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = ActivityOptions.makeSceneTransitionAnimation(this.mYi, new Pair[0]).toBundle();
    }
    if (this.bHS != 64)
    {
      d.a(this.mYi, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
      AppMethodBeat.o(61878);
      return;
    }
    ((j)g.E(j.class)).ad(this.mYi, 14);
    AppMethodBeat.o(61878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.11
 * JD-Core Version:    0.7.0.1
 */