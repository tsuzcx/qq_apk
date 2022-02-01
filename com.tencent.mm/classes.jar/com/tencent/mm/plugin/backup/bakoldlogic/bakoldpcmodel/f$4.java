package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.sdk.platformtools.ad;

final class f$4
  extends b.a
{
  f$4(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(21922);
    f localf = this.nBP;
    int i = f.bK(localf.nBI);
    ad.i("MicroMsg.RecoverPCServer", "all msg item Count : ".concat(String.valueOf(i)));
    ad.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
    h.LTJ.aU(new f.5(localf, i));
    AppMethodBeat.o(21922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.4
 * JD-Core Version:    0.7.0.1
 */