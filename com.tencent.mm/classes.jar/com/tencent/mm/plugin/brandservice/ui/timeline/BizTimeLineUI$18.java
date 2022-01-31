package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class BizTimeLineUI$18
  implements MenuItem.OnMenuItemClickListener
{
  BizTimeLineUI$18(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(14202);
    if (aa.Je(0))
    {
      paramMenuItem = aa.cZp();
      paramMenuItem.putExtra("title", this.jXh.getString(2131300238));
      paramMenuItem.putExtra("searchbar_tips", this.jXh.getString(2131300238));
      paramMenuItem.putExtra("KRightBtn", true);
      paramMenuItem.putExtra("ftsneedkeyboard", true);
      paramMenuItem.putExtra("publishIdPrefix", "bs");
      paramMenuItem.putExtra("ftsType", 2);
      paramMenuItem.putExtra("ftsbizscene", 11);
      Object localObject = aa.d(11, true, 2);
      String str = aa.IZ(bo.apV((String)((Map)localObject).get("scene")));
      ((Map)localObject).put("sessionId", str);
      paramMenuItem.putExtra("sessionId", str);
      paramMenuItem.putExtra("rawUrl", aa.F((Map)localObject));
      paramMenuItem.putExtra("key_load_js_without_delay", true);
      paramMenuItem.addFlags(67108864);
      localObject = ac.agx("bizAccountTopSearch");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramMenuItem.putExtra("key_search_input_hint", (String)localObject);
      }
      d.b(ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMenuItem);
    }
    for (;;)
    {
      AppMethodBeat.o(14202);
      return true;
      ab.e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.18
 * JD-Core Version:    0.7.0.1
 */