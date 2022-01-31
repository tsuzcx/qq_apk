package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class f$4
  extends b.a
{
  f$4(f paramf) {}
  
  public final void run()
  {
    f localf = this.hOx;
    int i = f.aG(localf.hOq);
    y.i("MicroMsg.RecoverPCServer", "all msg item Count : " + i);
    y.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
    e.c(new f.5(localf, i), "RecoverPCServer_recoverFromSdcard", 1).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.4
 * JD-Core Version:    0.7.0.1
 */