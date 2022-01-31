package com.google.android.gms.ads.identifier;

import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class AdvertisingIdClient$zza
  extends Thread
{
  private WeakReference<AdvertisingIdClient> zzm;
  private long zzn;
  CountDownLatch zzo;
  boolean zzp;
  
  public AdvertisingIdClient$zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
  {
    AppMethodBeat.i(115323);
    this.zzm = new WeakReference(paramAdvertisingIdClient);
    this.zzn = paramLong;
    this.zzo = new CountDownLatch(1);
    this.zzp = false;
    start();
    AppMethodBeat.o(115323);
  }
  
  private final void disconnect()
  {
    AppMethodBeat.i(115324);
    AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzm.get();
    if (localAdvertisingIdClient != null)
    {
      localAdvertisingIdClient.finish();
      this.zzp = true;
    }
    AppMethodBeat.o(115324);
  }
  
  public final void run()
  {
    AppMethodBeat.i(115325);
    try
    {
      if (!this.zzo.await(this.zzn, TimeUnit.MILLISECONDS)) {
        disconnect();
      }
      AppMethodBeat.o(115325);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      disconnect();
      AppMethodBeat.o(115325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient.zza
 * JD-Core Version:    0.7.0.1
 */