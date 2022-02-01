package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class IPCallUserProfileUI$4
  implements View.OnClickListener
{
  IPCallUserProfileUI$4(IPCallUserProfileUI paramIPCallUserProfileUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25997);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    IPCallUserProfileUI.a(this.DZi, this.DZj);
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.4
 * JD-Core Version:    0.7.0.1
 */