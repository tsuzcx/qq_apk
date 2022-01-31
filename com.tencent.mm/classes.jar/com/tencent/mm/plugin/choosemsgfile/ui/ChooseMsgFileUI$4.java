package com.tencent.mm.plugin.choosemsgfile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

final class ChooseMsgFileUI$4
  implements MMActivity.a
{
  ChooseMsgFileUI$4(a.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(54447);
    ab.i("MicroMsg.ChooseMsgFileUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ab.d("MicroMsg.ChooseMsgFileUI", "data:%s", new Object[] { paramIntent });
    b.a(paramInt1, paramInt2, paramIntent, this.kEq);
    AppMethodBeat.o(54447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.4
 * JD-Core Version:    0.7.0.1
 */