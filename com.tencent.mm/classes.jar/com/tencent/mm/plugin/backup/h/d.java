package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d mZT;
  private b mZU;
  private a mZV;
  
  public static d bEP()
  {
    AppMethodBeat.i(21763);
    if (mZT == null)
    {
      locald = new d();
      mZT = locald;
      a(locald);
    }
    d locald = mZT;
    AppMethodBeat.o(21763);
    return locald;
  }
  
  public final void bCK()
  {
    mZT = null;
  }
  
  public final b bEQ()
  {
    AppMethodBeat.i(21764);
    if (this.mZU == null) {
      this.mZU = new b();
    }
    b localb = this.mZU;
    AppMethodBeat.o(21764);
    return localb;
  }
  
  public final a bER()
  {
    AppMethodBeat.i(21765);
    if (this.mZV == null) {
      this.mZV = new a();
    }
    a locala = this.mZV;
    AppMethodBeat.o(21765);
    return locala;
  }
  
  public final void bES()
  {
    AppMethodBeat.i(21766);
    ac.i(TAG, "backupInitStorage.");
    b localb = bEQ();
    az.ayM();
    String str = c.getAccPath();
    az.ayM();
    localb.cj(str, c.getUin());
    AppMethodBeat.o(21766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */