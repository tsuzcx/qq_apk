package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;

public final class zzi
  extends Binder
{
  private final zze zzbi;
  
  zzi(zze paramzze)
  {
    this.zzbi = paramzze;
  }
  
  public final void zzd(zzg paramzzg)
  {
    AppMethodBeat.i(2521);
    if (Binder.getCallingUid() != Process.myUid())
    {
      paramzzg = new SecurityException("Binding only allowed within app");
      AppMethodBeat.o(2521);
      throw paramzzg;
    }
    Log.isLoggable("EnhancedIntentService", 3);
    Log.isLoggable("EnhancedIntentService", 3);
    this.zzbi.zzax.execute(new zzj(this, paramzzg));
    AppMethodBeat.o(2521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.iid.zzi
 * JD-Core Version:    0.7.0.1
 */