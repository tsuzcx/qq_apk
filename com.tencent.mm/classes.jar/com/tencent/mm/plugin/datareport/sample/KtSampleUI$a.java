package com.tencent.mm.plugin.datareport.sample;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/datareport/sample/KtSampleUI$onCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-data-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KtSampleUI$a
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(262900);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/datareport/sample/KtSampleUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    localObject = (Map)new HashMap();
    ((Map)localObject).put("visible_item", "6");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("dr_click1", paramView, (Map)localObject, 24184);
    a.a(this, "com/tencent/mm/plugin/datareport/sample/KtSampleUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.sample.KtSampleUI.a
 * JD-Core Version:    0.7.0.1
 */