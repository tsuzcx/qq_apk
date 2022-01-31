package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class FTSMainUI$16
  implements View.OnClickListener
{
  FTSMainUI$16(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(61886);
    FTSMainUI localFTSMainUI = this.mYi;
    paramView = (String)paramView.getTag();
    if (System.currentTimeMillis() - localFTSMainUI.iod > 1000L)
    {
      localFTSMainUI.iod = System.currentTimeMillis();
      if (!aa.Je(0))
      {
        ab.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        AppMethodBeat.o(61886);
        return;
      }
      Intent localIntent = aa.cZp();
      localIntent.putExtra("ftsbizscene", 15);
      localIntent.putExtra("ftsQuery", paramView);
      localIntent.putExtra("title", paramView);
      localIntent.putExtra("isWebwx", paramView);
      localIntent.putExtra("ftscaneditable", false);
      Object localObject = aa.d(15, false, 2);
      ((Map)localObject).put("query", paramView);
      ((Map)localObject).put("sceneActionType", "2");
      localIntent.putExtra("rawUrl", aa.F((Map)localObject));
      localObject = new lq();
      ((lq)localObject).cBH.scene = 0;
      a.ymk.l((b)localObject);
      localIntent.putExtra("ftsInitToSearch", true);
      d.b(localFTSMainUI.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      an.bz(15, paramView);
    }
    AppMethodBeat.o(61886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.16
 * JD-Core Version:    0.7.0.1
 */