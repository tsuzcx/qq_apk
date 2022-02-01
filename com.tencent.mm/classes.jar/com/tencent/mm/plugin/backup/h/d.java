package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d vdU;
  private b vdV;
  private a vdW;
  
  public static d cWK()
  {
    AppMethodBeat.i(21763);
    if (vdU == null)
    {
      locald = new d();
      vdU = locald;
      a(locald);
    }
    d locald = vdU;
    AppMethodBeat.o(21763);
    return locald;
  }
  
  public final void cUE()
  {
    vdU = null;
  }
  
  public final b cWL()
  {
    AppMethodBeat.i(21764);
    if (this.vdV == null) {
      this.vdV = new b();
    }
    b localb = this.vdV;
    AppMethodBeat.o(21764);
    return localb;
  }
  
  public final a cWM()
  {
    AppMethodBeat.i(21765);
    if (this.vdW == null) {
      this.vdW = new a();
    }
    a locala = this.vdW;
    AppMethodBeat.o(21765);
    return locala;
  }
  
  public final void cWN()
  {
    AppMethodBeat.i(21766);
    Log.i(TAG, "backupInitStorage.");
    b localb = cWL();
    bh.bCz();
    String str = c.getAccPath();
    bh.bCz();
    localb.du(str, c.getUin());
    AppMethodBeat.o(21766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */