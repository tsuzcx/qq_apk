package com.tencent.tmassistantbase.network;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class c
  extends Handler
{
  private WeakReference a;
  
  public c(NetworkMonitorReceiver paramNetworkMonitorReceiver)
  {
    this.a = new WeakReference(paramNetworkMonitorReceiver);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NetworkMonitorReceiver localNetworkMonitorReceiver = (NetworkMonitorReceiver)this.a.get();
    if ((paramMessage.what == 67) && (localNetworkMonitorReceiver != null)) {
      localNetworkMonitorReceiver.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.c
 * JD-Core Version:    0.7.0.1
 */