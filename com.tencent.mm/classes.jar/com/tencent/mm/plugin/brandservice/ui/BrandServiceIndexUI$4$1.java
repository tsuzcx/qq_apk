package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class BrandServiceIndexUI$4$1
  implements Runnable
{
  BrandServiceIndexUI$4$1(BrandServiceIndexUI.4 param4) {}
  
  public final void run()
  {
    Intent localIntent = aa.bZt();
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsType", 1);
    localIntent.putExtra("ftsbizscene", 6);
    Map localMap = aa.b(6, true, 0);
    String str = aa.Bm(bk.ZR((String)localMap.get("scene")));
    localMap.put("sessionId", str);
    localMap.put("subSessionId", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("rawUrl", aa.v(localMap));
    d.b(ae.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.4.1
 * JD-Core Version:    0.7.0.1
 */