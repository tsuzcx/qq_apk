package com.tencent.mm.plugin.choosemsgfile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity.a;

final class ChooseMsgFileListUI$5
  implements MMActivity.a
{
  ChooseMsgFileListUI$5(a.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(123387);
    ac.i("MicroMsg.ChooseMsgFileListUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ac.d("MicroMsg.ChooseMsgFileListUI", "data:%s", new Object[] { paramIntent });
    c.a(paramInt1, paramInt2, paramIntent, this.oop);
    AppMethodBeat.o(123387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.5
 * JD-Core Version:    0.7.0.1
 */