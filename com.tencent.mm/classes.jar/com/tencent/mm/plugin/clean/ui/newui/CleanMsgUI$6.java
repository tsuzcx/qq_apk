package com.tencent.mm.plugin.clean.ui.newui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

final class CleanMsgUI$6
  implements h.d
{
  CleanMsgUI$6(CleanMsgUI paramCleanMsgUI) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18893);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18893);
      return;
      long l = CleanMsgUI.bhi();
      if (l > 0L)
      {
        h.d(this.kJo, this.kJo.getString(2131298399, new Object[] { bo.hk(l) }), "", this.kJo.getString(2131298944), this.kJo.getString(2131297837), new CleanMsgUI.6.1(this), null);
        AppMethodBeat.o(18893);
        return;
      }
      Toast.makeText(this.kJo, 2131301868, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.6
 * JD-Core Version:    0.7.0.1
 */