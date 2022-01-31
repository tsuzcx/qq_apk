package com.tencent.mm.plugin.kitchen.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import java.util.ArrayList;

final class KvInfoUI$2$1
  implements b.a
{
  KvInfoUI$2$1(KvInfoUI.2 param2, b paramb, ArrayList paramArrayList) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(141973);
    this.jxY.hide();
    int i = this.jxY.dPp();
    paramObject1 = (String)this.nXM.get(i);
    KvInfoUI.a(this.nXN.nXL, paramObject1);
    AppMethodBeat.o(141973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.2.1
 * JD-Core Version:    0.7.0.1
 */