package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;

final class PaylistAAUI$13$2
  implements n.d
{
  PaylistAAUI$13$2(PaylistAAUI.13 param13) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 3;
    AppMethodBeat.i(40880);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40880);
      return;
      if (!bo.isNullOrNil(PaylistAAUI.a(this.grK.grF)))
      {
        paramMenuItem = new Intent(this.grK.grF.getContext(), LaunchAAUI.class);
        paramMenuItem.putExtra("enter_scene", 3);
        paramMenuItem.putExtra("chatroom_name", PaylistAAUI.a(this.grK.grF));
        this.grK.grF.startActivity(paramMenuItem);
      }
      if (this.grK.grJ.wkh == a.gnn) {
        paramInt = 1;
      }
      for (;;)
      {
        ab.d("MicroMsg.PaylistAAUI", "test");
        com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(7), Integer.valueOf(paramInt) });
        AppMethodBeat.o(40880);
        return;
        if (this.grK.grJ.wkh == a.gnm) {
          paramInt = 2;
        }
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(5) });
      com.tencent.mm.ui.base.h.a(this.grK.grF, 2131296345, -1, 2131296349, 2131296888, new PaylistAAUI.13.2.1(this), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.13.2
 * JD-Core Version:    0.7.0.1
 */