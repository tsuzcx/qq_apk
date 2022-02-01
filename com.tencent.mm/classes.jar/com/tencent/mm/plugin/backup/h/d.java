package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d rSF;
  private b rSG;
  private a rSH;
  
  public static d cua()
  {
    AppMethodBeat.i(21763);
    if (rSF == null)
    {
      locald = new d();
      rSF = locald;
      a(locald);
    }
    d locald = rSF;
    AppMethodBeat.o(21763);
    return locald;
  }
  
  public final void crU()
  {
    rSF = null;
  }
  
  public final b cub()
  {
    AppMethodBeat.i(21764);
    if (this.rSG == null) {
      this.rSG = new b();
    }
    b localb = this.rSG;
    AppMethodBeat.o(21764);
    return localb;
  }
  
  public final a cuc()
  {
    AppMethodBeat.i(21765);
    if (this.rSH == null) {
      this.rSH = new a();
    }
    a locala = this.rSH;
    AppMethodBeat.o(21765);
    return locala;
  }
  
  public final void cud()
  {
    AppMethodBeat.i(21766);
    Log.i(TAG, "backupInitStorage.");
    b localb = cub();
    bh.beI();
    String str = c.getAccPath();
    bh.beI();
    localb.cS(str, c.getUin());
    AppMethodBeat.o(21766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */