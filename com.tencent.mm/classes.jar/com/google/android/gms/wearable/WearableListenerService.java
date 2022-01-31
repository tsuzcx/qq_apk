package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.util.List;

public abstract class WearableListenerService
  extends Service
  implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private IBinder zzaFz;
  private ComponentName zzbTi;
  private WearableListenerService.zzb zzbTj;
  private Intent zzbTk;
  private Looper zzbTl;
  private final Object zzbTm = new Object();
  private boolean zzbTn;
  
  public Looper getLooper()
  {
    if (this.zzbTl == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
      localHandlerThread.start();
      this.zzbTl = localHandlerThread.getLooper();
    }
    return this.zzbTl;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return this.zzaFz;
    }
    return null;
  }
  
  public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo) {}
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onChannelOpened(Channel paramChannel) {}
  
  public void onConnectedNodes(List<Node> paramList) {}
  
  public void onCreate()
  {
    super.onCreate();
    this.zzbTi = new ComponentName(this, getClass().getName());
    if (Log.isLoggable("WearableLS", 3))
    {
      String str = String.valueOf(this.zzbTi);
      new StringBuilder(String.valueOf(str).length() + 10).append("onCreate: ").append(str);
    }
    this.zzbTj = new WearableListenerService.zzb(this, getLooper());
    this.zzbTk = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
    this.zzbTk.setComponent(this.zzbTi);
    this.zzaFz = new WearableListenerService.zzc(this, null);
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer) {}
  
  public void onDestroy()
  {
    if (Log.isLoggable("WearableLS", 3))
    {
      ??? = String.valueOf(this.zzbTi);
      new StringBuilder(String.valueOf(???).length() + 11).append("onDestroy: ").append((String)???);
    }
    synchronized (this.zzbTm)
    {
      this.zzbTn = true;
      if (this.zzbTj == null)
      {
        String str = String.valueOf(this.zzbTi);
        throw new IllegalStateException(String.valueOf(str).length() + 111 + "onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=" + str);
      }
    }
    this.zzbTj.quit();
    super.onDestroy();
  }
  
  public void onEntityUpdate(zzb paramzzb) {}
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onMessageReceived(MessageEvent paramMessageEvent) {}
  
  public void onNotificationReceived(zzd paramzzd) {}
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onPeerConnected(Node paramNode) {}
  
  public void onPeerDisconnected(Node paramNode) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * JD-Core Version:    0.7.0.1
 */