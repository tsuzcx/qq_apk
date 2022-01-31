package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.xweb.x5.sdk.d;

public final class e$b
  implements MMReceivers.a
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(15843);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(15843);
      return;
    }
    ab.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
    d.reset(paramContext);
    al.p(new e.b.1(this), 5000L);
    AppMethodBeat.o(15843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.e.b
 * JD-Core Version:    0.7.0.1
 */