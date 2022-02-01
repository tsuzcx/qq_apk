package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class BizTimeLineUI$19
  implements MenuItem.OnMenuItemClickListener
{
  BizTimeLineUI$19(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(192984);
    if (aa.Sa(0))
    {
      paramMenuItem = aa.ehS();
      paramMenuItem.putExtra("title", this.mYt.getString(2131759718));
      paramMenuItem.putExtra("searchbar_tips", this.mYt.getString(2131759718));
      paramMenuItem.putExtra("KRightBtn", true);
      paramMenuItem.putExtra("ftsneedkeyboard", true);
      paramMenuItem.putExtra("publishIdPrefix", "bs");
      paramMenuItem.putExtra("ftsType", 2);
      paramMenuItem.putExtra("ftsbizscene", 11);
      Object localObject = aa.f(11, true, 2);
      String str = aa.RY(bt.aGh((String)((Map)localObject).get("scene")));
      ((Map)localObject).put("sessionId", str);
      paramMenuItem.putExtra("sessionId", str);
      paramMenuItem.putExtra("rawUrl", aa.aR((Map)localObject));
      paramMenuItem.putExtra("key_load_js_without_delay", true);
      paramMenuItem.addFlags(67108864);
      localObject = ac.avg("bizAccountTopSearch");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramMenuItem.putExtra("key_search_input_hint", (String)localObject);
      }
      d.b(aj.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMenuItem);
    }
    for (;;)
    {
      AppMethodBeat.o(192984);
      return true;
      ad.e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.19
 * JD-Core Version:    0.7.0.1
 */