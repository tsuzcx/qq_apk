package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
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
    Log.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
    d.reset(paramContext);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19876);
        com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/booter/MMProcessReceivers$SandBoxProcessReceiverImpl$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/booter/MMProcessReceivers$SandBoxProcessReceiverImpl$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(19876);
      }
    }, 5000L);
    AppMethodBeat.o(19877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.e.b
 * JD-Core Version:    0.7.0.1
 */