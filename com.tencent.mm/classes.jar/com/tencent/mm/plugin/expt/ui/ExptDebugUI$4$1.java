package com.tencent.mm.plugin.expt.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class ExptDebugUI$4$1
  implements b.a
{
  ExptDebugUI$4$1(ExptDebugUI.4 param4, b paramb, String[] paramArrayOfString) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(152439);
    this.jxY.hide();
    int i = this.jxY.dPp();
    paramObject1 = this.mdq[i];
    ExptDebugUI.a(this.mdr.mdp, bo.getInt(paramObject1, 0));
    AppMethodBeat.o(152439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.4.1
 * JD-Core Version:    0.7.0.1
 */