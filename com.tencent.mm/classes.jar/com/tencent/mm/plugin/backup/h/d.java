package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d mxS;
  private b mxT;
  private a mxU;
  
  public static d bxT()
  {
    AppMethodBeat.i(21763);
    if (mxS == null)
    {
      locald = new d();
      mxS = locald;
      a(locald);
    }
    d locald = mxS;
    AppMethodBeat.o(21763);
    return locald;
  }
  
  public final void bvO()
  {
    mxS = null;
  }
  
  public final b bxU()
  {
    AppMethodBeat.i(21764);
    if (this.mxT == null) {
      this.mxT = new b();
    }
    b localb = this.mxT;
    AppMethodBeat.o(21764);
    return localb;
  }
  
  public final a bxV()
  {
    AppMethodBeat.i(21765);
    if (this.mxU == null) {
      this.mxU = new a();
    }
    a locala = this.mxU;
    AppMethodBeat.o(21765);
    return locala;
  }
  
  public final void bxW()
  {
    AppMethodBeat.i(21766);
    ad.i(TAG, "backupInitStorage.");
    b localb = bxU();
    az.arV();
    String str = c.getAccPath();
    az.arV();
    localb.ce(str, c.getUin());
    AppMethodBeat.o(21766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */