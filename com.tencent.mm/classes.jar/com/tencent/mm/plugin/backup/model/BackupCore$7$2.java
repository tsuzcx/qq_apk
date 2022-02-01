package com.tencent.mm.plugin.backup.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class BackupCore$7$2
  implements Runnable
{
  BackupCore$7$2(BackupCore.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(22151);
    Toast.makeText(MMApplicationContext.getContext(), "no merge data", 0).show();
    AppMethodBeat.o(22151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.model.BackupCore.7.2
 * JD-Core Version:    0.7.0.1
 */