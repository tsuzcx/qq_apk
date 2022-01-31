package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.base.h;

final class RegByQQAuthUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RegByQQAuthUI$1(RegByQQAuthUI paramRegByQQAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(125499);
    RegByQQAuthUI.a(this.gJn, RegByQQAuthUI.a(this.gJn).getText().toString().trim());
    if (RegByQQAuthUI.b(this.gJn).equals(""))
    {
      h.h(this.gJn, 2131304491, 2131296924);
      AppMethodBeat.o(125499);
      return true;
    }
    paramMenuItem = new u("", RegByQQAuthUI.c(this.gJn), RegByQQAuthUI.b(this.gJn), RegByQQAuthUI.d(this.gJn), "", "", RegByQQAuthUI.e(this.gJn), 2);
    g.Rc().a(paramMenuItem, 0);
    RegByQQAuthUI localRegByQQAuthUI1 = this.gJn;
    RegByQQAuthUI localRegByQQAuthUI2 = this.gJn;
    this.gJn.getString(2131297087);
    RegByQQAuthUI.a(localRegByQQAuthUI1, h.b(localRegByQQAuthUI2, this.gJn.getString(2131302482), true, new RegByQQAuthUI.1.1(this, paramMenuItem)));
    AppMethodBeat.o(125499);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI.1
 * JD-Core Version:    0.7.0.1
 */