package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.td;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMAppMgr;

final class WorkerProfile$24
  extends c<td>
{
  WorkerProfile$24(WorkerProfile paramWorkerProfile)
  {
    AppMethodBeat.i(15514);
    this.__eventId = td.class.getName().hashCode();
    AppMethodBeat.o(15514);
  }
  
  private static boolean Ca()
  {
    AppMethodBeat.i(153479);
    ab.i("MicroMsg.WorkerProfile", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    MMAppMgr.dCy();
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(153479);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.24
 * JD-Core Version:    0.7.0.1
 */