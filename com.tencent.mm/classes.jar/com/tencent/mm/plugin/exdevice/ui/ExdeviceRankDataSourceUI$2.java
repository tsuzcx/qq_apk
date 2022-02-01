package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ExdeviceRankDataSourceUI$2
  implements View.OnClickListener
{
  ExdeviceRankDataSourceUI$2(ExdeviceRankDataSourceUI paramExdeviceRankDataSourceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24187);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent(this.vpR.getContext(), ExdeviceAddDataSourceUI.class);
    this.vpR.startActivityForResult(paramView, 1);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(24187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.2
 * JD-Core Version:    0.7.0.1
 */