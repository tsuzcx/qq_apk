package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d nFL;
  private b nFM;
  private a nFN;
  
  public static d bJW()
  {
    AppMethodBeat.i(21763);
    if (nFL == null)
    {
      locald = new d();
      nFL = locald;
      a(locald);
    }
    d locald = nFL;
    AppMethodBeat.o(21763);
    return locald;
  }
  
  public final void bHQ()
  {
    nFL = null;
  }
  
  public final b bJX()
  {
    AppMethodBeat.i(21764);
    if (this.nFM == null) {
      this.nFM = new b();
    }
    b localb = this.nFM;
    AppMethodBeat.o(21764);
    return localb;
  }
  
  public final a bJY()
  {
    AppMethodBeat.i(21765);
    if (this.nFN == null) {
      this.nFN = new a();
    }
    a locala = this.nFN;
    AppMethodBeat.o(21765);
    return locala;
  }
  
  public final void bJZ()
  {
    AppMethodBeat.i(21766);
    ae.i(TAG, "backupInitStorage.");
    b localb = bJX();
    bc.aCg();
    String str = c.getAccPath();
    bc.aCg();
    localb.cq(str, c.getUin());
    AppMethodBeat.o(21766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */