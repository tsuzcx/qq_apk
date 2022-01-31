package com.tencent.mm.plugin.fts.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class FTSMainUI$13
  implements Runnable
{
  FTSMainUI$13(FTSMainUI paramFTSMainUI, int paramInt) {}
  
  public final void run()
  {
    if (System.currentTimeMillis() - FTSMainUI.v(this.kCm) <= 1000L) {
      return;
    }
    FTSMainUI.a(this.kCm, System.currentTimeMillis());
    if (!aa.Br(0))
    {
      y.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
      return;
    }
    Object localObject = ac.Rv("searchID");
    ao.u(this.bns, 14, (String)localObject);
    y.i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[] { Integer.valueOf(this.bns), localObject });
    this.kCm.XM();
    Intent localIntent = aa.bZt();
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsbizscene", 14);
    localIntent.putExtra("ftsType", this.bns);
    localObject = aa.b(14, true, this.bns);
    ((Map)localObject).put("sessionId", e.kvx);
    ((Map)localObject).put("subSessionId", e.kvx);
    localIntent.putExtra("sessionId", e.kvx);
    localIntent.putExtra("subSessionId", e.kvx);
    localIntent.putExtra("rawUrl", aa.v((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localObject = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = ActivityOptions.makeSceneTransitionAnimation(this.kCm, new Pair[0]).toBundle();
    }
    if (this.bns != 64)
    {
      d.a(this.kCm, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
      return;
    }
    ((j)g.r(j.class)).ev(this.kCm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.13
 * JD-Core Version:    0.7.0.1
 */