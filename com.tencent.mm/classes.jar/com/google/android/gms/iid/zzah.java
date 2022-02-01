package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzah
  extends BroadcastReceiver
{
  zzah(zzaf paramzzaf) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(2502);
    Log.isLoggable("InstanceID", 3);
    this.zzcx.zzh(paramIntent);
    AppMethodBeat.o(2502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.iid.zzah
 * JD-Core Version:    0.7.0.1
 */