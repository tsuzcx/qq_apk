package com.tencent.mm.console;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cr.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

final class Shell$31
  implements Shell.a
{
  @SuppressLint({"VisibleForTests"})
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(231524);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
      AppMethodBeat.o(231524);
      return;
    }
    Log.i("MicroMsg.Shell", "#BRANDS_CLEAR");
    cr.d.clearAll();
    AppMethodBeat.o(231524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.31
 * JD-Core Version:    0.7.0.1
 */