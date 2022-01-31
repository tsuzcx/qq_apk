package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class zzo$zzb
  extends Handler
{
  private final ContainerHolder.ContainerAvailableListener zzbFl;
  
  public zzo$zzb(zzo paramzzo, ContainerHolder.ContainerAvailableListener paramContainerAvailableListener, Looper paramLooper)
  {
    super(paramLooper);
    this.zzbFl = paramContainerAvailableListener;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      zzbo.e("Don't know how to handle this message.");
      return;
    }
    zzgY((String)paramMessage.obj);
  }
  
  public void zzgX(String paramString)
  {
    sendMessage(obtainMessage(1, paramString));
  }
  
  protected void zzgY(String paramString)
  {
    this.zzbFl.onContainerAvailable(this.zzbFm, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzo.zzb
 * JD-Core Version:    0.7.0.1
 */