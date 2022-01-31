package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class zzaaf$zza<R extends Result>
  extends Handler
{
  public zzaaf$zza()
  {
    this(Looper.getMainLooper());
  }
  
  public zzaaf$zza(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      Log.wtf("BasePendingResult", 45 + "Don't know how to handle message: " + i, new Exception());
      return;
    case 1: 
      paramMessage = (Pair)paramMessage.obj;
      zzb((ResultCallback)paramMessage.first, (Result)paramMessage.second);
      return;
    }
    ((zzaaf)paramMessage.obj).zzC(Status.zzazA);
  }
  
  public void zza(ResultCallback<? super R> paramResultCallback, R paramR)
  {
    sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
  }
  
  public void zza(zzaaf<R> paramzzaaf, long paramLong)
  {
    sendMessageDelayed(obtainMessage(2, paramzzaaf), paramLong);
  }
  
  protected void zzb(ResultCallback<? super R> paramResultCallback, R paramR)
  {
    try
    {
      paramResultCallback.onResult(paramR);
      return;
    }
    catch (RuntimeException paramResultCallback)
    {
      zzaaf.zzd(paramR);
      throw paramResultCallback;
    }
  }
  
  public void zzvK()
  {
    removeMessages(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzaaf.zza
 * JD-Core Version:    0.7.0.1
 */