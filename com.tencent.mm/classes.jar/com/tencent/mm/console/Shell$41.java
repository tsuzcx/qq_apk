package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.resource.f.b;
import com.tencent.matrix.resource.processor.ManualDumpProcessor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

final class Shell$41
  implements Shell.a
{
  public final void v(Intent paramIntent)
  {
    AppMethodBeat.i(231960);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
      AppMethodBeat.o(231960);
      return;
    }
    paramIntent = (com.tencent.matrix.resource.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.resource.c.class);
    if (paramIntent == null)
    {
      AppMethodBeat.o(231960);
      return;
    }
    paramIntent = paramIntent.eZq;
    if (paramIntent == null)
    {
      AppMethodBeat.o(231960);
      return;
    }
    paramIntent = paramIntent.fcU;
    if (!(paramIntent instanceof ManualDumpProcessor))
    {
      AppMethodBeat.o(231960);
      return;
    }
    ((ManualDumpProcessor)paramIntent).fcC = true;
    AppMethodBeat.o(231960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.Shell.41
 * JD-Core Version:    0.7.0.1
 */