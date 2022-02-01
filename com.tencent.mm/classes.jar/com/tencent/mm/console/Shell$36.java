package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.resource.c;
import com.tencent.matrix.resource.processor.ManualDumpProcessor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

final class Shell$36
  implements Shell.a
{
  public final void u(Intent paramIntent)
  {
    AppMethodBeat.i(284900);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
      AppMethodBeat.o(284900);
      return;
    }
    paramIntent = (c)com.tencent.matrix.b.Vu().Y(c.class);
    if (paramIntent == null)
    {
      AppMethodBeat.o(284900);
      return;
    }
    paramIntent = paramIntent.daQ;
    if (paramIntent == null)
    {
      AppMethodBeat.o(284900);
      return;
    }
    paramIntent = paramIntent.dej;
    if (!(paramIntent instanceof ManualDumpProcessor))
    {
      AppMethodBeat.o(284900);
      return;
    }
    ((ManualDumpProcessor)paramIntent).ddS = true;
    AppMethodBeat.o(284900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.Shell.36
 * JD-Core Version:    0.7.0.1
 */