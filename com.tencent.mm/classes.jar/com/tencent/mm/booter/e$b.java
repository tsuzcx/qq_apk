package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.xweb.x5.sdk.d;

public final class e$b
  implements MMReceivers.a
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19877);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(19877);
      return;
    }
    ac.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
    d.reset(paramContext);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19876);
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(19876);
      }
    }, 5000L);
    AppMethodBeat.o(19877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.e.b
 * JD-Core Version:    0.7.0.1
 */