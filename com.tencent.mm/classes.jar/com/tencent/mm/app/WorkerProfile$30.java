package com.tencent.mm.app;

import android.os.Process;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aah;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMAppMgr;

class WorkerProfile$30
  extends IListener<aah>
{
  WorkerProfile$30(WorkerProfile paramWorkerProfile, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(239041);
    this.__eventId = aah.class.getName().hashCode();
    AppMethodBeat.o(239041);
  }
  
  private static boolean aDK()
  {
    AppMethodBeat.i(239046);
    Log.i("MicroMsg.WorkerProfile", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    MMAppMgr.jjZ();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/app/WorkerProfile$30", "callback", "(Lcom/tencent/mm/autogen/events/SwitchAccountKillProcessEvent;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/WorkerProfile$30", "callback", "(Lcom/tencent/mm/autogen/events/SwitchAccountKillProcessEvent;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(239046);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.30
 * JD-Core Version:    0.7.0.1
 */