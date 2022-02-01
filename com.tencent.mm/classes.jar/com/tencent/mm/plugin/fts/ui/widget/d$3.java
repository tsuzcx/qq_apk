package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public final class d$3
  implements Runnable
{
  public d$3(d paramd, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(112334);
    if (System.currentTimeMillis() - d.j(this.tPD) <= 1000L)
    {
      AppMethodBeat.o(112334);
      return;
    }
    d.b(this.tPD, System.currentTimeMillis());
    if (!ad.WK(0))
    {
      ae.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
      AppMethodBeat.o(112334);
      return;
    }
    Object localObject = af.aHk("searchID");
    am.L(this.val$type, 14, (String)localObject);
    ae.i("MicroMsg.FTS.PardusSearchLogic", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[] { Integer.valueOf(this.val$type), localObject });
    d.d(this.tPD).hideVKB();
    localObject = ad.ePM();
    ((Intent)localObject).putExtra("ftsneedkeyboard", true);
    ((Intent)localObject).putExtra("ftsbizscene", 14);
    ((Intent)localObject).putExtra("ftsType", this.val$type);
    ((Intent)localObject).putExtra("key_change_search_icon", true);
    Map localMap = ad.f(14, false, this.val$type);
    localMap.put("sessionId", String.valueOf(e.tEn));
    localMap.put("subSessionId", String.valueOf(e.tEn));
    ((Intent)localObject).putExtra("sessionId", String.valueOf(e.tEn));
    ((Intent)localObject).putExtra("subSessionId", String.valueOf(e.tEn));
    ((Intent)localObject).putExtra("rawUrl", ad.be(localMap));
    ((Intent)localObject).putExtra("key_load_js_without_delay", true);
    if (this.val$type != 64)
    {
      com.tencent.mm.br.d.b(d.d(this.tPD), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", (Intent)localObject);
      AppMethodBeat.o(112334);
      return;
    }
    ((h)g.ab(h.class)).a(d.d(this.tPD), 14, "", "");
    AppMethodBeat.o(112334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d.3
 * JD-Core Version:    0.7.0.1
 */