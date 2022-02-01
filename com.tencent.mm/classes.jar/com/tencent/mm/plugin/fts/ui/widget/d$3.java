package com.tencent.mm.plugin.fts.ui.widget;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import java.util.Map;

public final class d$3
  implements Runnable
{
  public d$3(d paramd, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(112334);
    if (System.currentTimeMillis() - d.j(this.sIb) <= 1000L)
    {
      AppMethodBeat.o(112334);
      return;
    }
    d.b(this.sIb, System.currentTimeMillis());
    if (!z.Uk(0))
    {
      ac.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
      AppMethodBeat.o(112334);
      return;
    }
    Object localObject1 = ab.aAw("searchID");
    ai.J(this.val$type, 14, (String)localObject1);
    ac.i("MicroMsg.FTS.PardusSearchLogic", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[] { Integer.valueOf(this.val$type), localObject1 });
    d.d(this.sIb).hideVKB();
    Intent localIntent = z.exm();
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsbizscene", 14);
    localIntent.putExtra("ftsType", this.val$type);
    localIntent.putExtra("key_change_search_icon", true);
    localObject1 = z.f(14, false, this.val$type);
    ((Map)localObject1).put("sessionId", String.valueOf(e.swV));
    ((Map)localObject1).put("subSessionId", String.valueOf(e.swV));
    localIntent.putExtra("sessionId", String.valueOf(e.swV));
    localIntent.putExtra("subSessionId", String.valueOf(e.swV));
    localIntent.putExtra("rawUrl", z.aV((Map)localObject1));
    localIntent.putExtra("key_load_js_without_delay", true);
    Object localObject2 = null;
    localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!aj.DT()) {
        localObject1 = ActivityOptions.makeSceneTransitionAnimation(d.d(this.sIb), new Pair[0]).toBundle();
      }
    }
    if (this.val$type != 64)
    {
      com.tencent.mm.br.d.a(d.d(this.sIb), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject1);
      AppMethodBeat.o(112334);
      return;
    }
    ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(d.d(this.sIb), 14, "", "");
    AppMethodBeat.o(112334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d.3
 * JD-Core Version:    0.7.0.1
 */