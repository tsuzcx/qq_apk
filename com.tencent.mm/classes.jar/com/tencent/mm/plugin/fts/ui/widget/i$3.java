package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class i$3
  implements Runnable
{
  public i$3(i parami, int paramInt, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    boolean bool = false;
    AppMethodBeat.i(112334);
    if (System.currentTimeMillis() - i.j(this.BSZ) <= 1000L)
    {
      AppMethodBeat.o(112334);
      return;
    }
    i.b(this.BSZ, System.currentTimeMillis());
    if (!ai.ang(0))
    {
      Log.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
      AppMethodBeat.o(112334);
      return;
    }
    Object localObject = ak.biQ("searchID");
    ar.b(this.val$type, 14, (String)localObject, e.eqP(), this.BTa);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[] { Integer.valueOf(this.val$type), localObject });
    i.d(this.BSZ).hideVKB();
    localObject = ai.gQI();
    ((Intent)localObject).putExtra("ftsneedkeyboard", true);
    ((Intent)localObject).putExtra("ftsbizscene", 14);
    ((Intent)localObject).putExtra("ftsType", this.val$type);
    ((Intent)localObject).putExtra("key_change_search_icon", true);
    Map localMap = ai.j(14, false, this.val$type);
    localMap.put("sessionId", String.valueOf(e.BHi));
    localMap.put("subSessionId", String.valueOf(e.BHi));
    ((Intent)localObject).putExtra("sessionId", String.valueOf(e.BHi));
    ((Intent)localObject).putExtra("subSessionId", String.valueOf(e.BHi));
    ((Intent)localObject).putExtra("rawUrl", ai.aX(localMap));
    ((Intent)localObject).putExtra("key_load_js_without_delay", true);
    if (!this.BTb) {
      bool = true;
    }
    ((Intent)localObject).putExtra("ftsneedkeyboard", bool);
    if (this.val$type != 64)
    {
      ((Intent)localObject).putExtra("key_search_icon_and_hint_fix_default", true);
      c.b(i.d(this.BSZ), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", (Intent)localObject);
      AppMethodBeat.o(112334);
      return;
    }
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).b(i.d(this.BSZ), 14, "", "");
    AppMethodBeat.o(112334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.i.3
 * JD-Core Version:    0.7.0.1
 */