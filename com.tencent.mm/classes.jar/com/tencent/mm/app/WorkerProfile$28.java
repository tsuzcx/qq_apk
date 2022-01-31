package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;

final class WorkerProfile$28
  implements be.b
{
  WorkerProfile$28(WorkerProfile paramWorkerProfile) {}
  
  public final String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    AppMethodBeat.i(138601);
    paramString1 = h.a(paramInt1, paramString1, paramString2, paramInt2, paramContext);
    AppMethodBeat.o(138601);
    return paramString1;
  }
  
  public final void a(bi parambi, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138600);
    h.b(parambi, paramPString1, paramPString2, paramPInt, paramBoolean);
    AppMethodBeat.o(138600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.28
 * JD-Core Version:    0.7.0.1
 */