package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;

public final class c
{
  boolean jVu = false;
  public long kje = 0L;
  private long rMI = -1L;
  
  public final void begin()
  {
    AppMethodBeat.i(21817);
    Log.d("MicroMsg.Recoverfaster", "begin");
    if (b.cuH().cuI().kcF != null)
    {
      this.rMI = b.cuH().cuI().kcF.beginTransaction(Thread.currentThread().getId());
      this.jVu = true;
    }
    this.kje = Util.nowMilliSecond();
    AppMethodBeat.o(21817);
  }
  
  public final void end()
  {
    AppMethodBeat.i(21818);
    if ((this.jVu) && (b.cuH().cuI().kcF != null))
    {
      b.cuH().cuI().kcF.endTransaction(this.rMI);
      this.jVu = false;
    }
    AppMethodBeat.o(21818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */