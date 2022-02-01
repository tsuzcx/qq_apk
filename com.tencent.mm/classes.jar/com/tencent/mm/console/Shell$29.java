package com.tencent.mm.console;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cr.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

final class Shell$29
  implements Shell.a
{
  @SuppressLint({"VisibleForTests"})
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(231522);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
      AppMethodBeat.o(231522);
      return;
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      Log.e("MicroMsg.Shell", "extras is null");
      AppMethodBeat.o(231522);
      return;
    }
    int i = Integer.parseInt(String.valueOf(paramIntent.get("set_xid")));
    Log.i("MicroMsg.Shell", "#BRANDS_XID, set_xid = ".concat(String.valueOf(i)));
    if (i >= 0) {
      cr.d.sw(i);
    }
    AppMethodBeat.o(231522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.29
 * JD-Core Version:    0.7.0.1
 */