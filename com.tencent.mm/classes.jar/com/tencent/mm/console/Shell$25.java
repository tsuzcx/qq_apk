package com.tencent.mm.console;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class Shell$25
  implements Shell.a
{
  boolean gMK = false;
  
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(231518);
    if (this.gMK)
    {
      Toast.makeText(MMApplicationContext.getContext(), "xlog had moved.", 0).show();
      AppMethodBeat.o(231518);
      return;
    }
    Log.i("MicroMsg.Shell", "action: wechat.shell.PULL_XLOG");
    Toast.makeText(MMApplicationContext.getContext(), "start to move xlog.", 0).show();
    Log.moveLogsFromCacheDirToLogDir();
    Toast.makeText(MMApplicationContext.getContext(), "xlog move success", 0).show();
    this.gMK = true;
    AppMethodBeat.o(231518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.25
 * JD-Core Version:    0.7.0.1
 */