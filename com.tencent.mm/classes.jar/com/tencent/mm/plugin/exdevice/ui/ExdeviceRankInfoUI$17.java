package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.ui.base.n.d;

final class ExdeviceRankInfoUI$17
  implements n.d
{
  ExdeviceRankInfoUI$17(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(20155);
    if (ExdeviceRankInfoUI.x(this.lPt) == null)
    {
      AppMethodBeat.o(20155);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20155);
      return;
      ExdeviceRankInfoUI.a(this.lPt, true);
      d.kS(10);
      ad.bqg();
      c.d("", ExdeviceRankInfoUI.y(this.lPt), ExdeviceRankInfoUI.x(this.lPt).field_username, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.17
 * JD-Core Version:    0.7.0.1
 */