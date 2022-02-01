package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d oQI;
  private b oQJ;
  private a oQK;
  
  public static d cgP()
  {
    AppMethodBeat.i(21763);
    if (oQI == null)
    {
      locald = new d();
      oQI = locald;
      a(locald);
    }
    d locald = oQI;
    AppMethodBeat.o(21763);
    return locald;
  }
  
  public final void ceH()
  {
    oQI = null;
  }
  
  public final b cgQ()
  {
    AppMethodBeat.i(21764);
    if (this.oQJ == null) {
      this.oQJ = new b();
    }
    b localb = this.oQJ;
    AppMethodBeat.o(21764);
    return localb;
  }
  
  public final a cgR()
  {
    AppMethodBeat.i(21765);
    if (this.oQK == null) {
      this.oQK = new a();
    }
    a locala = this.oQK;
    AppMethodBeat.o(21765);
    return locala;
  }
  
  public final void cgS()
  {
    AppMethodBeat.i(21766);
    Log.i(TAG, "backupInitStorage.");
    b localb = cgQ();
    bg.aVF();
    String str = c.getAccPath();
    bg.aVF();
    localb.cx(str, c.getUin());
    AppMethodBeat.o(21766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */