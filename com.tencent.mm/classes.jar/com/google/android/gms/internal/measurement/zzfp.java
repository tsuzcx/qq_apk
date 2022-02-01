package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

class zzfp
  extends BroadcastReceiver
{
  @VisibleForTesting
  private static final String zzaaw;
  private boolean zzaax;
  private boolean zzaay;
  private final zzjr zzajp;
  
  static
  {
    AppMethodBeat.i(1461);
    zzaaw = zzfp.class.getName();
    AppMethodBeat.o(1461);
  }
  
  zzfp(zzjr paramzzjr)
  {
    AppMethodBeat.i(1457);
    Preconditions.checkNotNull(paramzzjr);
    this.zzajp = paramzzjr;
    AppMethodBeat.o(1457);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(1458);
    this.zzajp.zzkq();
    paramContext = paramIntent.getAction();
    this.zzajp.zzge().zzit().zzg("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = this.zzajp.zzkn().zzex();
      if (this.zzaay != bool)
      {
        this.zzaay = bool;
        this.zzajp.zzgd().zzc(new zzfq(this, bool));
      }
      AppMethodBeat.o(1458);
      return;
    }
    this.zzajp.zzge().zzip().zzg("NetworkBroadcastReceiver received unknown action", paramContext);
    AppMethodBeat.o(1458);
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(1460);
    this.zzajp.zzkq();
    this.zzajp.zzab();
    this.zzajp.zzab();
    if (!this.zzaax)
    {
      AppMethodBeat.o(1460);
      return;
    }
    this.zzajp.zzge().zzit().log("Unregistering connectivity change receiver");
    this.zzaax = false;
    this.zzaay = false;
    Context localContext = this.zzajp.getContext();
    try
    {
      localContext.unregisterReceiver(this);
      AppMethodBeat.o(1460);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.zzajp.zzge().zzim().zzg("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
      AppMethodBeat.o(1460);
    }
  }
  
  public final void zzeu()
  {
    AppMethodBeat.i(1459);
    this.zzajp.zzkq();
    this.zzajp.zzab();
    if (this.zzaax)
    {
      AppMethodBeat.o(1459);
      return;
    }
    this.zzajp.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.zzaay = this.zzajp.zzkn().zzex();
    this.zzajp.zzge().zzit().zzg("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzaay));
    this.zzaax = true;
    AppMethodBeat.o(1459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfp
 * JD-Core Version:    0.7.0.1
 */