package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class f$4
  extends b.a
{
  f$4(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(17865);
    f localf = this.jHZ;
    int i = f.aQ(localf.jHS);
    ab.i("MicroMsg.RecoverPCServer", "all msg item Count : ".concat(String.valueOf(i)));
    ab.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
    d.a(new f.5(localf, i), "RecoverPCServer_recoverFromSdcard", 1).start();
    AppMethodBeat.o(17865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.4
 * JD-Core Version:    0.7.0.1
 */