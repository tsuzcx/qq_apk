package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;

final class WorkerProfile$27
  implements bw.b
{
  WorkerProfile$27(WorkerProfile paramWorkerProfile) {}
  
  public final String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    AppMethodBeat.i(19583);
    paramString1 = h.a(paramInt1, paramString1, paramString2, paramInt2, paramContext);
    AppMethodBeat.o(19583);
    return paramString1;
  }
  
  public final void a(ca paramca, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19582);
    h.b(paramca, paramPString1, paramPString2, paramPInt, paramBoolean);
    AppMethodBeat.o(19582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.27
 * JD-Core Version:    0.7.0.1
 */