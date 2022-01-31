package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class LaunchAAUI$10
  implements d.a
{
  LaunchAAUI$10(LaunchAAUI paramLaunchAAUI) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(40832);
    ab.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", new Object[] { paramObject });
    if (LaunchAAUI.k(this.grm) != null) {
      LaunchAAUI.k(this.grm).dismiss();
    }
    if ((paramObject != null) && ((paramObject instanceof String)) && (!paramObject.toString().equalsIgnoreCase("ok"))) {
      Toast.makeText(this.grm, paramObject.toString(), 1).show();
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13722, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(40832);
      return;
      if ((paramObject != null) && ((paramObject instanceof y))) {
        com.tencent.mm.plugin.aa.a.h.a(this.grm.getContext(), (y)paramObject);
      } else {
        Toast.makeText(this.grm, 2131301044, 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.10
 * JD-Core Version:    0.7.0.1
 */