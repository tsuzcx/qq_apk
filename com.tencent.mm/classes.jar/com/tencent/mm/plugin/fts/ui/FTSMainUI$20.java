package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.lc;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.Map;

final class FTSMainUI$20
  implements View.OnClickListener
{
  FTSMainUI$20(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    FTSMainUI localFTSMainUI = this.kCm;
    paramView = (String)paramView.getTag();
    if (System.currentTimeMillis() - localFTSMainUI.gMG > 1000L)
    {
      localFTSMainUI.gMG = System.currentTimeMillis();
      if (!aa.Br(0)) {
        y.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
      }
    }
    else
    {
      return;
    }
    Intent localIntent = aa.bZt();
    localIntent.putExtra("ftsbizscene", 15);
    localIntent.putExtra("ftsQuery", paramView);
    localIntent.putExtra("title", paramView);
    localIntent.putExtra("isWebwx", paramView);
    localIntent.putExtra("ftscaneditable", false);
    Object localObject = aa.b(15, false, 2);
    ((Map)localObject).put("query", paramView);
    ((Map)localObject).put("sceneActionType", "2");
    localIntent.putExtra("rawUrl", aa.v((Map)localObject));
    localObject = new lc();
    ((lc)localObject).bUc.scene = 0;
    a.udP.m((b)localObject);
    localIntent.putExtra("ftsInitToSearch", true);
    d.b(localFTSMainUI.mController.uMN, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
    ao.aT(15, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.20
 * JD-Core Version:    0.7.0.1
 */