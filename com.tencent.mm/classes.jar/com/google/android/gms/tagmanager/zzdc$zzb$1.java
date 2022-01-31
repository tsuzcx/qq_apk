package com.google.android.gms.tagmanager;

import android.os.Handler.Callback;
import android.os.Message;

class zzdc$zzb$1
  implements Handler.Callback
{
  zzdc$zzb$1(zzdc.zzb paramzzb) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((1 == paramMessage.what) && (zzdc.zzRB().equals(paramMessage.obj)))
    {
      this.zzbIs.zzbIr.dispatch();
      if (!zzdc.zzb(this.zzbIs.zzbIr)) {
        this.zzbIs.zzy(zzdc.zzc(this.zzbIs.zzbIr));
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdc.zzb.1
 * JD-Core Version:    0.7.0.1
 */