package com.tencent.mm.plugin.backup.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class BackupCore$7$4
  implements Runnable
{
  BackupCore$7$4(BackupCore.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(22153);
    Toast.makeText(MMApplicationContext.getContext(), "merge data delete", 0).show();
    AppMethodBeat.o(22153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.model.BackupCore.7.4
 * JD-Core Version:    0.7.0.1
 */