package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$31
  implements n.d
{
  ExdeviceProfileUI$31(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(179628);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(179628);
      return;
      com.tencent.mm.plugin.sport.a.c.lI(27);
      ExdeviceProfileUI.r(this.peX);
      AppMethodBeat.o(179628);
      return;
      com.tencent.mm.plugin.sport.a.c.lI(26);
      ExdeviceProfileUI.s(this.peX);
      AppMethodBeat.o(179628);
      return;
      ExdeviceProfileUI.t(this.peX);
      AppMethodBeat.o(179628);
      return;
      h.a(this.peX.getContext(), this.peX.getString(2131758619), null, true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(179627);
          az.arV();
          paramAnonymousDialogInterface = com.tencent.mm.model.c.apM().aHY(ExdeviceProfileUI.u(ExdeviceProfileUI.31.this.peX));
          com.tencent.mm.plugin.sport.a.c.lI(37);
          w.k(paramAnonymousDialogInterface);
          ExdeviceProfileUI.v(ExdeviceProfileUI.31.this.peX).alive();
          if (ExdeviceProfileUI.d(ExdeviceProfileUI.31.this.peX) != null) {
            ExdeviceProfileUI.d(ExdeviceProfileUI.31.this.peX).show();
          }
          AppMethodBeat.o(179627);
        }
      }, null);
      AppMethodBeat.o(179628);
      return;
      ExdeviceProfileUI.b(this.peX, true);
      com.tencent.mm.plugin.sport.a.c.lI(10);
      ad.bZO();
      com.tencent.mm.plugin.exdevice.g.b.c.c("", ExdeviceProfileUI.w(this.peX), ExdeviceProfileUI.u(this.peX), 3);
      AppMethodBeat.o(179628);
      return;
      com.tencent.mm.plugin.sport.a.c.lI(41);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("rawUrl", ExdeviceProfileUI.o(this.peX));
      d.b(this.peX, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.31
 * JD-Core Version:    0.7.0.1
 */