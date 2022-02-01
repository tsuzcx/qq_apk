package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

final class FTSMainUI$6
  implements View.OnClickListener
{
  FTSMainUI$6(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111966);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    localObject1 = FTSMainUI.b(this.tLh);
    paramView = (String)paramView.getTag();
    if (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).lSe > 1000L)
    {
      ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).lSe = System.currentTimeMillis();
      if (ad.WK(0)) {
        break label104;
      }
      ae.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111966);
      return;
      label104:
      Intent localIntent = ad.ePM();
      localIntent.putExtra("ftsbizscene", 15);
      localIntent.putExtra("ftsQuery", paramView);
      localIntent.putExtra("title", paramView);
      localIntent.putExtra("isWebwx", paramView);
      localIntent.putExtra("ftscaneditable", false);
      Object localObject2 = ad.f(15, false, 2);
      ((Map)localObject2).put("query", paramView);
      ((Map)localObject2).put("sceneActionType", "2");
      localIntent.putExtra("rawUrl", ad.be((Map)localObject2));
      localObject2 = new nu();
      ((nu)localObject2).dCJ.scene = 0;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      localIntent.putExtra("ftsInitToSearch", true);
      com.tencent.mm.br.d.b(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      am.cw(15, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.6
 * JD-Core Version:    0.7.0.1
 */