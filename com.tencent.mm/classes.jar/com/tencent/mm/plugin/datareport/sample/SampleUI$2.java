package com.tencent.mm.plugin.datareport.sample;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import java.util.HashMap;
import java.util.Map;

final class SampleUI$2
  implements View.OnClickListener
{
  SampleUI$2(SampleUI paramSampleUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(262923);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/datareport/sample/SampleUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    localObject = new HashMap();
    ((Map)localObject).put("btn4_custom_params", "btn4_custom_params");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("btn4_click", paramView, (Map)localObject, 24184);
    a.a(this, "com/tencent/mm/plugin/datareport/sample/SampleUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.sample.SampleUI.2
 * JD-Core Version:    0.7.0.1
 */