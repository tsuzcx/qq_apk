package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

final class FTSMainUI$6
  implements View.OnClickListener
{
  FTSMainUI$6(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111966);
    com.tencent.mm.plugin.fts.ui.widget.d locald = FTSMainUI.b(this.sDB);
    paramView = (String)paramView.getTag();
    if (System.currentTimeMillis() - locald.lqi > 1000L)
    {
      locald.lqi = System.currentTimeMillis();
      if (!z.Uk(0))
      {
        ac.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
        AppMethodBeat.o(111966);
        return;
      }
      Intent localIntent = z.exm();
      localIntent.putExtra("ftsbizscene", 15);
      localIntent.putExtra("ftsQuery", paramView);
      localIntent.putExtra("title", paramView);
      localIntent.putExtra("isWebwx", paramView);
      localIntent.putExtra("ftscaneditable", false);
      Object localObject = z.f(15, false, 2);
      ((Map)localObject).put("query", paramView);
      ((Map)localObject).put("sceneActionType", "2");
      localIntent.putExtra("rawUrl", z.aV((Map)localObject));
      localObject = new nl();
      ((nl)localObject).dpR.scene = 0;
      a.GpY.l((b)localObject);
      localIntent.putExtra("ftsInitToSearch", true);
      com.tencent.mm.br.d.b(locald.sHc.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      ai.cq(15, paramView);
    }
    AppMethodBeat.o(111966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.6
 * JD-Core Version:    0.7.0.1
 */