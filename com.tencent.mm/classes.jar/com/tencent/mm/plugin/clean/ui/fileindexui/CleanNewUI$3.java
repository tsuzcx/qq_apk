package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.a.f.a;

final class CleanNewUI$3
  implements View.OnClickListener
{
  CleanNewUI$3(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22923);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.CleanNewUI", "clean wechat cache");
    paramView = new f.a(this.pcq);
    paramView.aZq(this.pcq.getString(2131757368)).zi(true);
    paramView.c(new CleanNewUI.3.1(this)).show();
    a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(22923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.3
 * JD-Core Version:    0.7.0.1
 */