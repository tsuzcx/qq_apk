package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfz
  implements ServiceConnection
{
  private zzfz(zzfx paramzzfx) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(1501);
    if (paramIBinder == null)
    {
      zzfx.zza(this.zzaky).zzge().zzip().log("Install Referrer connection returned with null binder");
      AppMethodBeat.o(1501);
      return;
    }
    try
    {
      this.zzaky.zzakw = zzs.zza(paramIBinder);
      if (this.zzaky.zzakw == null)
      {
        zzfx.zza(this.zzaky).zzge().zzip().log("Install Referrer Service implementation was not found");
        AppMethodBeat.o(1501);
        return;
      }
      zzfx.zza(this.zzaky).zzge().zzir().log("Install Referrer Service connected");
      zzfx.zza(this.zzaky).zzgd().zzc(new zzga(this));
      AppMethodBeat.o(1501);
      return;
    }
    catch (Exception paramComponentName)
    {
      zzfx.zza(this.zzaky).zzge().zzip().zzg("Exception occurred while calling Install Referrer API", paramComponentName);
      AppMethodBeat.o(1501);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(1502);
    this.zzaky.zzakw = null;
    zzfx.zza(this.zzaky).zzge().zzir().log("Install Referrer Service disconnected");
    AppMethodBeat.o(1502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfz
 * JD-Core Version:    0.7.0.1
 */