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
  r bLZ;
  
  public s(r paramr)
  {
    this.bLZ = paramr;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(4208);
    if (this.bLZ == null)
    {
      AppMethodBeat.o(4208);
      return;
    }
    if (!this.bLZ.zzaj())
    {
      AppMethodBeat.o(4208);
      return;
    }
    FirebaseInstanceId.yg();
    FirebaseInstanceId.b(this.bLZ, 0L);
    this.bLZ.getContext().unregisterReceiver(this);
    this.bLZ = null;
    AppMethodBeat.o(4208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.iid.s
 * JD-Core Version:    0.7.0.1
 */