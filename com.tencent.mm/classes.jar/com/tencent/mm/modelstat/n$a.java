package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

final class n$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(151115);
    h.ahAA.g(new n.a..ExternalSyntheticLambda0(paramIntent), "NetTypeReporter");
    AppMethodBeat.o(151115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.n.a
 * JD-Core Version:    0.7.0.1
 */