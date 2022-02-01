package com.tencent.mm.plugin.fts.ui.widget;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.ui.al;
import java.util.Map;

public final class d$3
  implements Runnable
{
  public d$3(d paramd, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(112334);
    if (System.currentTimeMillis() - d.j(this.tEM) <= 1000L)
    {
      AppMethodBeat.o(112334);
      return;
    }
    d.b(this.tEM, System.currentTimeMillis());
    if (!com.tencent.mm.plugin.websearch.api.ad.Wd(0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
      AppMethodBeat.o(112334);
      return;
    }
    Object localObject1 = af.aFQ("searchID");
    am.L(this.val$type, 14, (String)localObject1);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusSearchLogic", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[] { Integer.valueOf(this.val$type), localObject1 });
    d.d(this.tEM).hideVKB();
    Intent localIntent = com.tencent.mm.plugin.websearch.api.ad.eMd();
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsbizscene", 14);
    localIntent.putExtra("ftsType", this.val$type);
    localIntent.putExtra("key_change_search_icon", true);
    localObject1 = com.tencent.mm.plugin.websearch.api.ad.f(14, false, this.val$type);
    ((Map)localObject1).put("sessionId", String.valueOf(e.ttw));
    ((Map)localObject1).put("subSessionId", String.valueOf(e.ttw));
    localIntent.putExtra("sessionId", String.valueOf(e.ttw));
    localIntent.putExtra("subSessionId", String.valueOf(e.ttw));
    localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.ad.aY((Map)localObject1));
    localIntent.putExtra("key_load_js_without_delay", true);
    Object localObject2 = null;
    localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!al.isDarkMode()) {
        localObject1 = ActivityOptions.makeSceneTransitionAnimation(d.d(this.tEM), new Pair[0]).toBundle();
      }
    }
    if (this.val$type != 64)
    {
      com.tencent.mm.bs.d.a(d.d(this.tEM), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject1);
      AppMethodBeat.o(112334);
      return;
    }
    ((h)g.ab(h.class)).a(d.d(this.tEM), 14, "", "");
    AppMethodBeat.o(112334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d.3
 * JD-Core Version:    0.7.0.1
 */