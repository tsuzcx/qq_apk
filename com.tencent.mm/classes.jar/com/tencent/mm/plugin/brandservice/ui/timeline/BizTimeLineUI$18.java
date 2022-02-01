package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

final class BizTimeLineUI$18
  implements MenuItem.OnMenuItemClickListener
{
  BizTimeLineUI$18(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(208475);
    if (ad.WK(0))
    {
      paramMenuItem = ad.ePM();
      paramMenuItem.putExtra("title", this.ohP.getString(2131759718));
      paramMenuItem.putExtra("searchbar_tips", this.ohP.getString(2131759718));
      paramMenuItem.putExtra("KRightBtn", true);
      paramMenuItem.putExtra("ftsneedkeyboard", true);
      paramMenuItem.putExtra("publishIdPrefix", "bs");
      paramMenuItem.putExtra("ftsType", 2);
      paramMenuItem.putExtra("ftsbizscene", 11);
      Object localObject = ad.f(11, true, 2);
      String str = ad.WI(bu.aSB((String)((Map)localObject).get("scene")));
      ((Map)localObject).put("sessionId", str);
      paramMenuItem.putExtra("sessionId", str);
      paramMenuItem.putExtra("rawUrl", ad.be((Map)localObject));
      paramMenuItem.putExtra("key_load_js_without_delay", true);
      paramMenuItem.addFlags(67108864);
      localObject = af.aHl("bizAccountTopSearch");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramMenuItem.putExtra("key_search_input_hint", (String)localObject);
      }
      d.b(ak.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMenuItem);
    }
    for (;;)
    {
      AppMethodBeat.o(208475);
      return true;
      ae.e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.18
 * JD-Core Version:    0.7.0.1
 */