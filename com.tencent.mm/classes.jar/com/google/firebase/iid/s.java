package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@VisibleForTesting
final class s
  extends BroadcastReceiver
{
  @Nullable
  r bfO;
  
  public s(r paramr)
  {
    this.bfO = paramr;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(108772);
    if (this.bfO == null)
    {
      AppMethodBeat.o(108772);
      return;
    }
    if (!this.bfO.zzaj())
    {
      AppMethodBeat.o(108772);
      return;
    }
    FirebaseInstanceId.rP();
    FirebaseInstanceId.c(this.bfO, 0L);
    this.bfO.getContext().unregisterReceiver(this);
    this.bfO = null;
    AppMethodBeat.o(108772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.iid.s
 * JD-Core Version:    0.7.0.1
 */