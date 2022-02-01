package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

final class BizTimeLineUI$8
  implements MenuItem.OnMenuItemClickListener
{
  BizTimeLineUI$8(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(5948);
    if (aj.asX(0))
    {
      paramMenuItem = aj.ipS();
      paramMenuItem.putExtra("title", this.vIB.getString(d.i.fts_search_biz_article));
      paramMenuItem.putExtra("searchbar_tips", this.vIB.getString(d.i.fts_search_biz_article));
      paramMenuItem.putExtra("KRightBtn", true);
      paramMenuItem.putExtra("ftsneedkeyboard", true);
      paramMenuItem.putExtra("publishIdPrefix", "bs");
      paramMenuItem.putExtra("ftsType", 2);
      paramMenuItem.putExtra("ftsbizscene", 11);
      Object localObject = aj.r(11, true, 2);
      String str = aj.asV(Util.safeParseInt((String)((Map)localObject).get("scene")));
      ((Map)localObject).put("sessionId", str);
      paramMenuItem.putExtra("sessionId", str);
      paramMenuItem.putExtra("rawUrl", aj.bo((Map)localObject));
      paramMenuItem.putExtra("key_load_js_without_delay", true);
      paramMenuItem.addFlags(67108864);
      localObject = al.biz("bizAccountTopSearch");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramMenuItem.putExtra("key_search_input_hint", (String)localObject);
      }
      c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMenuItem);
    }
    for (;;)
    {
      AppMethodBeat.o(5948);
      return true;
      Log.e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.8
 * JD-Core Version:    0.7.0.1
 */