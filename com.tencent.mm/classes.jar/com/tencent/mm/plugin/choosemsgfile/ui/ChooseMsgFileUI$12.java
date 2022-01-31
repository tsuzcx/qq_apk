package com.tencent.mm.plugin.choosemsgfile.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.f;
import com.tencent.mm.ui.base.n.d;

final class ChooseMsgFileUI$12
  implements n.d
{
  ChooseMsgFileUI$12(ChooseMsgFileUI paramChooseMsgFileUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(54456);
    ChooseMsgFileUI.e(this.kGm);
    switch (paramInt)
    {
    default: 
      paramMenuItem = "all";
    }
    for (;;)
    {
      ChooseMsgFileUI.g(this.kGm).b(true, paramMenuItem, ChooseMsgFileUI.f(this.kGm));
      ChooseMsgFileUI.a(this.kGm, paramMenuItem);
      AppMethodBeat.o(54456);
      return;
      paramMenuItem = "all";
      continue;
      paramMenuItem = "image";
      continue;
      paramMenuItem = "video";
      continue;
      paramMenuItem = "file";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.12
 * JD-Core Version:    0.7.0.1
 */