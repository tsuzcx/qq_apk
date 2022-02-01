package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.chz;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CaptureContainer$8
  implements View.OnClickListener
{
  CaptureContainer$8(CaptureContainer paramCaptureContainer, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(581);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = CaptureContainer.j(this.rte);
    if (paramView != null)
    {
      paramView = paramView.LVe;
      if (paramView != null)
      {
        localObject = Class.forName("com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI");
        p.g(localObject, "Class.forName(\"com.tence….EmojiStoreV2DesignerUI\")");
        localObject = new Intent(this.$context, (Class)localObject);
        ((Intent)localObject).putExtra("uin", paramView.DesignerUin);
        ((Intent)localObject).putExtra("name", paramView.Name);
        ((Intent)localObject).putExtra("headurl", paramView.HeadUrl);
        paramView = this.$context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.8
 * JD-Core Version:    0.7.0.1
 */