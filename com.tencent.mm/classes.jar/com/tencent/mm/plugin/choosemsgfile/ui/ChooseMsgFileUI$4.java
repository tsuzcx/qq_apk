package com.tencent.mm.plugin.choosemsgfile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity.a;

final class ChooseMsgFileUI$4
  implements MMActivity.a
{
  ChooseMsgFileUI$4(a.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(123425);
    ac.i("MicroMsg.ChooseMsgFileUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ac.d("MicroMsg.ChooseMsgFileUI", "data:%s", new Object[] { paramIntent });
    c.a(paramInt1, paramInt2, paramIntent, this.oop);
    AppMethodBeat.o(123425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.4
 * JD-Core Version:    0.7.0.1
 */