package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class AAQueryListUI$5
  implements d.a
{
  AAQueryListUI$5(AAQueryListUI paramAAQueryListUI) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(40734);
    ab.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[] { paramObject });
    if (AAQueryListUI.g(this.gpD) != null)
    {
      AAQueryListUI.g(this.gpD).dismiss();
      AAQueryListUI.h(this.gpD);
    }
    AAQueryListUI.i(this.gpD);
    if (AAQueryListUI.a(this.gpD).getFooterViewsCount() > 0) {
      AAQueryListUI.a(this.gpD).removeFooterView(AAQueryListUI.d(this.gpD));
    }
    if ((paramObject instanceof String))
    {
      Toast.makeText(this.gpD, paramObject.toString(), 1).show();
      AppMethodBeat.o(40734);
      return;
    }
    Toast.makeText(this.gpD, 2131300525, 1).show();
    AppMethodBeat.o(40734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.5
 * JD-Core Version:    0.7.0.1
 */