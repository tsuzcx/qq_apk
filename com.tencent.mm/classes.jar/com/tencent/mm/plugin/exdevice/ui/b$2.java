package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20094);
    ab.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.lOF.vg(i);
    b.a(this.lOF).LV(paramView.lRp.field_username);
    AppMethodBeat.o(20094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b.2
 * JD-Core Version:    0.7.0.1
 */