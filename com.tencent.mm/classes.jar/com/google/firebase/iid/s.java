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
  r bDN;
  
  public s(r paramr)
  {
    this.bDN = paramr;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(4208);
    if (this.bDN == null)
    {
      AppMethodBeat.o(4208);
      return;
    }
    if (!this.bDN.zzaj())
    {
      AppMethodBeat.o(4208);
      return;
    }
    FirebaseInstanceId.wO();
    FirebaseInstanceId.b(this.bDN, 0L);
    this.bDN.getContext().unregisterReceiver(this);
    this.bDN = null;
    AppMethodBeat.o(4208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.s
 * JD-Core Version:    0.7.0.1
 */