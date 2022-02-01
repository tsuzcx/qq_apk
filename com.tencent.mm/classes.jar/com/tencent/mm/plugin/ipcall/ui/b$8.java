package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.MMActivity;

final class b$8
  implements View.OnClickListener
{
  b$8(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25595);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.uPf.uON.setCursorVisible(true);
    this.uPf.fLP.hideVKB();
    this.uPf.uPc = true;
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.8
 * JD-Core Version:    0.7.0.1
 */