package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class AAQueryListUI$4$2
  implements n.d
{
  AAQueryListUI$4$2(AAQueryListUI.4 param4) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(40732);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40732);
      return;
      ab.i("MicroMsg.AAQueryListUI", "go to launch list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(this.gpE.gpD)) });
      if (AAQueryListUI.e(this.gpE.gpD) == 1)
      {
        AppMethodBeat.o(40732);
        return;
      }
      AAQueryListUI.a(this.gpE.gpD, 1);
      this.gpE.gpD.setMMTitle(2131296378);
      AAQueryListUI.f(this.gpE.gpD).mode = AAQueryListUI.e(this.gpE.gpD);
      AAQueryListUI.f(this.gpE.gpD).aoX();
      AAQueryListUI.f(this.gpE.gpD).notifyDataSetChanged();
      AAQueryListUI.a(this.gpE.gpD, true, AAQueryListUI.e(this.gpE.gpD));
      AppMethodBeat.o(40732);
      return;
      ab.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(this.gpE.gpD)) });
      if (AAQueryListUI.e(this.gpE.gpD) == 2)
      {
        AppMethodBeat.o(40732);
        return;
      }
      this.gpE.gpD.setMMTitle(2131296381);
      AAQueryListUI.f(this.gpE.gpD).mode = AAQueryListUI.e(this.gpE.gpD);
      AAQueryListUI.f(this.gpE.gpD).aoX();
      AAQueryListUI.f(this.gpE.gpD).notifyDataSetChanged();
      AAQueryListUI.a(this.gpE.gpD, 2);
      AAQueryListUI.a(this.gpE.gpD, true, AAQueryListUI.e(this.gpE.gpD));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.4.2
 * JD-Core Version:    0.7.0.1
 */