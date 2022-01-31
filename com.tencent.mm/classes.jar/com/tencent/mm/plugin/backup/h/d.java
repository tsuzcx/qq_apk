package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d jGz;
  private b jGA;
  private a jGB;
  
  public static d aUK()
  {
    AppMethodBeat.i(17706);
    if (jGz == null)
    {
      locald = new d();
      jGz = locald;
      a(locald);
    }
    d locald = jGz;
    AppMethodBeat.o(17706);
    return locald;
  }
  
  public final void aSG()
  {
    jGz = null;
  }
  
  public final b aUL()
  {
    AppMethodBeat.i(17707);
    if (this.jGA == null) {
      this.jGA = new b();
    }
    b localb = this.jGA;
    AppMethodBeat.o(17707);
    return localb;
  }
  
  public final a aUM()
  {
    AppMethodBeat.i(17708);
    if (this.jGB == null) {
      this.jGB = new a();
    }
    a locala = this.jGB;
    AppMethodBeat.o(17708);
    return locala;
  }
  
  public final void aUN()
  {
    AppMethodBeat.i(17709);
    ab.i(TAG, "backupInitStorage");
    b localb = aUL();
    aw.aaz();
    String str = c.getAccPath();
    aw.aaz();
    localb.bH(str, c.getUin());
    AppMethodBeat.o(17709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */