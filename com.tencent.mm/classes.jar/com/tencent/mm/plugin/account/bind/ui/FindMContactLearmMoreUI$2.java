package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.l;

final class FindMContactLearmMoreUI$2
  implements View.OnClickListener
{
  FindMContactLearmMoreUI$2(FindMContactLearmMoreUI paramFindMContactLearmMoreUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13623);
    l.dx(false);
    ((a)g.G(a.class)).syncUploadMContactStatus(true, false);
    FindMContactLearmMoreUI.b(this.gvb);
    AppMethodBeat.o(13623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.2
 * JD-Core Version:    0.7.0.1
 */