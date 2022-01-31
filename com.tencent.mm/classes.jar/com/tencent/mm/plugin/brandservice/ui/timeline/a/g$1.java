package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.storage.q;

final class g$1
  implements DialogInterface.OnClickListener
{
  g$1(g paramg, q paramq) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(14264);
    bf.gw(this.jYs.field_msgId);
    this.jYt.jXV.jVS.d(this.jYs, 3);
    this.jYt.jXV.jVI.e(this.jYs);
    AppMethodBeat.o(14264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.g.1
 * JD-Core Version:    0.7.0.1
 */