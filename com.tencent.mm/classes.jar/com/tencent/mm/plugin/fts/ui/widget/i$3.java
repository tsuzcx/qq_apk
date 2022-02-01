package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class i$3
  implements Runnable
{
  public i$3(i parami, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(112334);
    if (System.currentTimeMillis() - i.j(this.xgO) <= 1000L)
    {
      AppMethodBeat.o(112334);
      return;
    }
    i.b(this.xgO, System.currentTimeMillis());
    if (!ai.afs(0))
    {
      Log.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
      AppMethodBeat.o(112334);
      return;
    }
    Object localObject = ak.aXf("searchID");
    ar.N(this.val$type, 14, (String)localObject);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[] { Integer.valueOf(this.val$type), localObject });
    i.d(this.xgO).hideVKB();
    localObject = ai.fXX();
    ((Intent)localObject).putExtra("ftsneedkeyboard", true);
    ((Intent)localObject).putExtra("ftsbizscene", 14);
    ((Intent)localObject).putExtra("ftsType", this.val$type);
    ((Intent)localObject).putExtra("key_change_search_icon", true);
    Map localMap = ai.h(14, false, this.val$type);
    localMap.put("sessionId", String.valueOf(e.wVm));
    localMap.put("subSessionId", String.valueOf(e.wVm));
    ((Intent)localObject).putExtra("sessionId", String.valueOf(e.wVm));
    ((Intent)localObject).putExtra("subSessionId", String.valueOf(e.wVm));
    ((Intent)localObject).putExtra("rawUrl", ai.bd(localMap));
    ((Intent)localObject).putExtra("key_load_js_without_delay", true);
    if (this.val$type != 64)
    {
      c.b(i.d(this.xgO), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", (Intent)localObject);
      AppMethodBeat.o(112334);
      return;
    }
    ((h)g.af(h.class)).b(i.d(this.xgO), 14, "", "");
    AppMethodBeat.o(112334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.i.3
 * JD-Core Version:    0.7.0.1
 */