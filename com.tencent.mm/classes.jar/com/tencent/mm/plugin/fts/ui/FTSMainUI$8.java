package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.pj;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.ui.widget.i;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class FTSMainUI$8
  implements View.OnClickListener
{
  FTSMainUI$8(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(193842);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    a.c("com/tencent/mm/plugin/fts/ui/FTSMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    localObject1 = FTSMainUI.d(this.BOi);
    paramView = (String)paramView.getTag();
    if (System.currentTimeMillis() - ((i)localObject1).pZO > 1000L)
    {
      ((i)localObject1).pZO = System.currentTimeMillis();
      if (ai.ang(0)) {
        break label104;
      }
      Log.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(193842);
      return;
      label104:
      Intent localIntent = ai.gQI();
      localIntent.putExtra("ftsbizscene", 15);
      localIntent.putExtra("ftsQuery", paramView);
      localIntent.putExtra("title", paramView);
      localIntent.putExtra("isWebwx", paramView);
      localIntent.putExtra("ftscaneditable", false);
      Object localObject2 = ai.j(15, false, 2);
      ((Map)localObject2).put("query", paramView);
      ((Map)localObject2).put("sceneActionType", "2");
      localIntent.putExtra("rawUrl", ai.aX((Map)localObject2));
      localObject2 = new pj();
      ((pj)localObject2).fOb.scene = 0;
      EventCenter.instance.publish((IEvent)localObject2);
      localIntent.putExtra("ftsInitToSearch", true);
      c.b(((i)localObject1).BSg.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      ar.cO(15, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.8
 * JD-Core Version:    0.7.0.1
 */