package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.om;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.ui.widget.i;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class FTSMainUI$6
  implements View.OnClickListener
{
  FTSMainUI$6(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111966);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    localObject1 = FTSMainUI.c(this.xci);
    paramView = (String)paramView.getTag();
    if (System.currentTimeMillis() - ((i)localObject1).mZq > 1000L)
    {
      ((i)localObject1).mZq = System.currentTimeMillis();
      if (ai.afs(0)) {
        break label104;
      }
      Log.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111966);
      return;
      label104:
      Intent localIntent = ai.fXX();
      localIntent.putExtra("ftsbizscene", 15);
      localIntent.putExtra("ftsQuery", paramView);
      localIntent.putExtra("title", paramView);
      localIntent.putExtra("isWebwx", paramView);
      localIntent.putExtra("ftscaneditable", false);
      Object localObject2 = ai.h(15, false, 2);
      ((Map)localObject2).put("query", paramView);
      ((Map)localObject2).put("sceneActionType", "2");
      localIntent.putExtra("rawUrl", ai.bd((Map)localObject2));
      localObject2 = new om();
      ((om)localObject2).dUz.scene = 0;
      EventCenter.instance.publish((IEvent)localObject2);
      localIntent.putExtra("ftsInitToSearch", true);
      c.b(((i)localObject1).xfV.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      ar.cO(15, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.6
 * JD-Core Version:    0.7.0.1
 */