package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class AdvertisingIdClient$zza
  extends Thread
{
  private WeakReference<AdvertisingIdClient> zzsh;
  private long zzsi;
  CountDownLatch zzsj;
  boolean zzsk;
  
  public AdvertisingIdClient$zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
  {
    this.zzsh = new WeakReference(paramAdvertisingIdClient);
    this.zzsi = paramLong;
    this.zzsj = new CountDownLatch(1);
    this.zzsk = false;
    start();
  }
  
  private void disconnect()
  {
    AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzsh.get();
    if (localAdvertisingIdClient != null)
    {
      localAdvertisingIdClient.finish();
      this.zzsk = true;
    }
  }
  
  public void cancel()
  {
    this.zzsj.countDown();
  }
  
  public void run()
  {
    try
    {
      if (!this.zzsj.await(this.zzsi, TimeUnit.MILLISECONDS)) {
        disconnect();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      disconnect();
    }
  }
  
  public boolean zzbx()
  {
    return this.zzsk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient.zza
 * JD-Core Version:    0.7.0.1
 */