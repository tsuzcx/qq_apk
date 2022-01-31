package com.tencent.mm.plugin.account.bind.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class BindMContactIntroUI$18
  implements Runnable
{
  BindMContactIntroUI$18(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(13427);
    if (l.aqo())
    {
      BindMContactIntroUI.apC();
      BindMContactIntroUI.i(this.gtw).setText(this.gtw.getString(2131297578));
      BindMContactIntroUI.a(this.gtw, l.a.gxB);
      boolean bool = bo.a((Boolean)g.RL().Ru().get(12322, Boolean.FALSE), false);
      if ((BindMContactIntroUI.h(this.gtw)) && (bool)) {
        h.qsU.e(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
      }
    }
    AppMethodBeat.o(13427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.18
 * JD-Core Version:    0.7.0.1
 */