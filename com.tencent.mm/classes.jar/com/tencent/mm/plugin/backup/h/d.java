package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d nAq;
  private b nAr;
  private a nAs;
  
  public static d bIY()
  {
    AppMethodBeat.i(21763);
    if (nAq == null)
    {
      locald = new d();
      nAq = locald;
      a(locald);
    }
    d locald = nAq;
    AppMethodBeat.o(21763);
    return locald;
  }
  
  public final void bGS()
  {
    nAq = null;
  }
  
  public final b bIZ()
  {
    AppMethodBeat.i(21764);
    if (this.nAr == null) {
      this.nAr = new b();
    }
    b localb = this.nAr;
    AppMethodBeat.o(21764);
    return localb;
  }
  
  public final a bJa()
  {
    AppMethodBeat.i(21765);
    if (this.nAs == null) {
      this.nAs = new a();
    }
    a locala = this.nAs;
    AppMethodBeat.o(21765);
    return locala;
  }
  
  public final void bJb()
  {
    AppMethodBeat.i(21766);
    ad.i(TAG, "backupInitStorage.");
    b localb = bIZ();
    ba.aBQ();
    String str = c.getAccPath();
    ba.aBQ();
    localb.cm(str, c.getUin());
    AppMethodBeat.o(21766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */