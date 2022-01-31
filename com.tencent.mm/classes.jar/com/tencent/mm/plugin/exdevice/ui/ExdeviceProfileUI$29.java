package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class ExdeviceProfileUI$29
  implements n.d
{
  ExdeviceProfileUI$29(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(20057);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20057);
      return;
      com.tencent.mm.plugin.sport.a.d.kS(27);
      ExdeviceProfileUI.r(this.lOl);
      AppMethodBeat.o(20057);
      return;
      com.tencent.mm.plugin.sport.a.d.kS(26);
      ExdeviceProfileUI.s(this.lOl);
      AppMethodBeat.o(20057);
      return;
      ExdeviceProfileUI.t(this.lOl);
      AppMethodBeat.o(20057);
      return;
      h.a(this.lOl.getContext(), this.lOl.getString(2131299488), null, true, new ExdeviceProfileUI.29.1(this), null);
      AppMethodBeat.o(20057);
      return;
      ExdeviceProfileUI.b(this.lOl, true);
      com.tencent.mm.plugin.sport.a.d.kS(10);
      ad.bqg();
      c.d("", ExdeviceProfileUI.w(this.lOl), ExdeviceProfileUI.u(this.lOl), 3);
      AppMethodBeat.o(20057);
      return;
      com.tencent.mm.plugin.sport.a.d.kS(41);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("rawUrl", ExdeviceProfileUI.o(this.lOl));
      com.tencent.mm.bq.d.b(this.lOl, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.29
 * JD-Core Version:    0.7.0.1
 */