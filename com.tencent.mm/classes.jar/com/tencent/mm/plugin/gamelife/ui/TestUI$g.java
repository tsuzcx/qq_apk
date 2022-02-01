package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TestUI$g
  implements View.OnClickListener
{
  TestUI$g(TestUI paramTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203150);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    int i = 0;
    while (i <= 50)
    {
      localObject = new com.tencent.mm.plugin.gamelife.e.a();
      ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_sessionId = "test".concat(String.valueOf(i));
      ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_digest = "digest".concat(String.valueOf(i));
      ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_updateTime = System.currentTimeMillis();
      ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_talker = "talker".concat(String.valueOf(i));
      ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_selfUserName = this.Dje.DiY;
      paramView.insert((IAutoDBItem)localObject);
      i += 1;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI.g
 * JD-Core Version:    0.7.0.1
 */