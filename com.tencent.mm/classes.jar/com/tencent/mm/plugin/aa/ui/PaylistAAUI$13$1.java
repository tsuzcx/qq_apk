package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class PaylistAAUI$13$1
  implements n.c
{
  PaylistAAUI$13$1(PaylistAAUI.13 param13) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(40878);
    paraml.add(0, 1, 1, 2131302066);
    if ((!bo.isNullOrNil(PaylistAAUI.e(this.grK.grF))) && (PaylistAAUI.e(this.grK.grF).equals(r.Zn())) && (this.grK.grJ.state == a.gnj) && (this.grK.grJ.wky < this.grK.grJ.wkw)) {
      paraml.add(0, 2, 1, 2131296346);
    }
    AppMethodBeat.o(40878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.13.1
 * JD-Core Version:    0.7.0.1
 */