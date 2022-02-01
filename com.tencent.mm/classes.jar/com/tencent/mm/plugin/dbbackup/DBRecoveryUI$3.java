package com.tencent.mm.plugin.dbbackup;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class DBRecoveryUI$3
  implements View.OnClickListener
{
  DBRecoveryUI$3(DBRecoveryUI paramDBRecoveryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23055);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    DBRecoveryUI.e(this.xiC);
    a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(23055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.3
 * JD-Core Version:    0.7.0.1
 */