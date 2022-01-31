package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

class zzdc$zzb
  implements zzdc.zza
{
  private Handler handler = new Handler(zzdc.zza(this.zzbIr).getMainLooper(), new zzdc.zzb.1(this));
  
  private zzdc$zzb(zzdc paramzzdc) {}
  
  private Message obtainMessage()
  {
    return this.handler.obtainMessage(1, zzdc.zzRB());
  }
  
  public void cancel()
  {
    this.handler.removeMessages(1, zzdc.zzRB());
  }
  
  public void zzRC()
  {
    this.handler.removeMessages(1, zzdc.zzRB());
    this.handler.sendMessage(obtainMessage());
  }
  
  public void zzy(long paramLong)
  {
    this.handler.removeMessages(1, zzdc.zzRB());
    this.handler.sendMessageDelayed(obtainMessage(), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdc.zzb
 * JD-Core Version:    0.7.0.1
 */