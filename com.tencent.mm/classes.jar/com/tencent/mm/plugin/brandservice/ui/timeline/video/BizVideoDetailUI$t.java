package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class BizVideoDetailUI$t
  implements View.OnLongClickListener
{
  public static final t pIE;
  
  static
  {
    AppMethodBeat.i(7125);
    pIE = new t();
    AppMethodBeat.o(7125);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(195891);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initWebviewSetting$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    a.a(true, this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initWebviewSetting$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(195891);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.t
 * JD-Core Version:    0.7.0.1
 */