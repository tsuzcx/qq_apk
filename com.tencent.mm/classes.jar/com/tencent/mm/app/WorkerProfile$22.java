package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMAppMgr;

final class WorkerProfile$22
  extends IListener<xh>
{
  WorkerProfile$22(WorkerProfile paramWorkerProfile)
  {
    AppMethodBeat.i(161251);
    this.__eventId = xh.class.getName().hashCode();
    AppMethodBeat.o(161251);
  }
  
  private static boolean Xk()
  {
    AppMethodBeat.i(19568);
    Log.i("MicroMsg.WorkerProfile", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    MMAppMgr.gIU();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/app/WorkerProfile$29", "callback", "(Lcom/tencent/mm/autogen/events/SwitchAccountKillProcessEvent;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/WorkerProfile$29", "callback", "(Lcom/tencent/mm/autogen/events/SwitchAccountKillProcessEvent;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(19568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.22
 * JD-Core Version:    0.7.0.1
 */