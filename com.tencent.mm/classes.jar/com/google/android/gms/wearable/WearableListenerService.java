package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.wearable.internal.zzas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class WearableListenerService
  extends Service
  implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private ComponentName service;
  private WearableListenerService.zzc zzad;
  private IBinder zzae;
  private Intent zzaf;
  private Looper zzag;
  private final Object zzah;
  private boolean zzai;
  private zzas zzaj;
  
  public WearableListenerService()
  {
    AppMethodBeat.i(70933);
    this.zzah = new Object();
    this.zzaj = new zzas(new WearableListenerService.zza(this, null));
    AppMethodBeat.o(70933);
  }
  
  public Looper getLooper()
  {
    AppMethodBeat.i(70937);
    if (this.zzag == null)
    {
      localObject = new HandlerThread("WearableListenerService");
      ((HandlerThread)localObject).start();
      this.zzag = ((HandlerThread)localObject).getLooper();
    }
    Object localObject = this.zzag;
    AppMethodBeat.o(70937);
    return localObject;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(70936);
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction()))
    {
      paramIntent = this.zzae;
      AppMethodBeat.o(70936);
      return paramIntent;
    }
    AppMethodBeat.o(70936);
    return null;
  }
  
  public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo) {}
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onChannelClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onChannelOpened(Channel paramChannel) {}
  
  public void onChannelOpened(ChannelClient.Channel paramChannel) {}
  
  public void onConnectedNodes(List<Node> paramList) {}
  
  public void onCreate()
  {
    AppMethodBeat.i(70934);
    super.onCreate();
    this.service = new ComponentName(this, getClass().getName());
    if (Log.isLoggable("WearableLS", 3))
    {
      String str = String.valueOf(this.service);
      new StringBuilder(String.valueOf(str).length() + 10).append("onCreate: ").append(str);
    }
    this.zzad = new WearableListenerService.zzc(this, getLooper());
    this.zzaf = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
    this.zzaf.setComponent(this.service);
    this.zzae = new WearableListenerService.zzd(this, null);
    AppMethodBeat.o(70934);
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(70935);
    if (Log.isLoggable("WearableLS", 3))
    {
      ??? = String.valueOf(this.service);
      new StringBuilder(String.valueOf(???).length() + 11).append("onDestroy: ").append((String)???);
    }
    synchronized (this.zzah)
    {
      this.zzai = true;
      if (this.zzad == null)
      {
        Object localObject2 = String.valueOf(this.service);
        localObject2 = new IllegalStateException(String.valueOf(localObject2).length() + 111 + "onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=" + (String)localObject2);
        AppMethodBeat.o(70935);
        throw ((Throwable)localObject2);
      }
    }
    this.zzad.quit();
    super.onDestroy();
    AppMethodBeat.o(70935);
  }
  
  public void onEntityUpdate(zzb paramzzb) {}
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onInputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onMessageReceived(MessageEvent paramMessageEvent) {}
  
  public void onNotificationReceived(zzd paramzzd) {}
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onOutputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onPeerConnected(Node paramNode) {}
  
  public void onPeerDisconnected(Node paramNode) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * JD-Core Version:    0.7.0.1
 */