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
  r bLJ;
  
  public s(r paramr)
  {
    this.bLJ = paramr;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(4208);
    if (this.bLJ == null)
    {
      AppMethodBeat.o(4208);
      return;
    }
    if (!this.bLJ.zzaj())
    {
      AppMethodBeat.o(4208);
      return;
    }
    FirebaseInstanceId.xY();
    FirebaseInstanceId.b(this.bLJ, 0L);
    this.bLJ.getContext().unregisterReceiver(this);
    this.bLJ = null;
    AppMethodBeat.o(4208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.s
 * JD-Core Version:    0.7.0.1
 */