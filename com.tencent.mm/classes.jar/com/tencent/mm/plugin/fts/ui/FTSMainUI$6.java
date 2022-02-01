package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

final class FTSMainUI$6
  implements View.OnClickListener
{
  FTSMainUI$6(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111966);
    com.tencent.mm.plugin.fts.ui.widget.d locald = FTSMainUI.b(this.ruJ);
    paramView = (String)paramView.getTag();
    if (System.currentTimeMillis() - locald.kOJ > 1000L)
    {
      locald.kOJ = System.currentTimeMillis();
      if (!aa.Sa(0))
      {
        ad.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
        AppMethodBeat.o(111966);
        return;
      }
      Intent localIntent = aa.ehS();
      localIntent.putExtra("ftsbizscene", 15);
      localIntent.putExtra("ftsQuery", paramView);
      localIntent.putExtra("title", paramView);
      localIntent.putExtra("isWebwx", paramView);
      localIntent.putExtra("ftscaneditable", false);
      Object localObject = aa.f(15, false, 2);
      ((Map)localObject).put("query", paramView);
      ((Map)localObject).put("sceneActionType", "2");
      localIntent.putExtra("rawUrl", aa.aR((Map)localObject));
      localObject = new nc();
      ((nc)localObject).dsg.scene = 0;
      a.ESL.l((b)localObject);
      localIntent.putExtra("ftsInitToSearch", true);
      com.tencent.mm.bs.d.b(locald.ryk.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      ak.cn(15, paramView);
    }
    AppMethodBeat.o(111966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.6
 * JD-Core Version:    0.7.0.1
 */