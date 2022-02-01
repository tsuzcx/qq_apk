package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzas;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzen;
import com.google.android.gms.wearable.internal.zzfe;
import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.internal.zzhp;
import com.google.android.gms.wearable.internal.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class WearableListenerService
  extends Service
  implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private ComponentName service;
  private zzc zzad;
  private IBinder zzae;
  private Intent zzaf;
  private Looper zzag;
  private final Object zzah;
  private boolean zzai;
  private zzas zzaj;
  
  public WearableListenerService()
  {
    AppMethodBeat.i(100916);
    this.zzah = new Object();
    this.zzaj = new zzas(new zza(null));
    AppMethodBeat.o(100916);
  }
  
  public Looper getLooper()
  {
    AppMethodBeat.i(100920);
    if (this.zzag == null)
    {
      localObject = new HandlerThread("WearableListenerService");
      ((HandlerThread)localObject).start();
      this.zzag = ((HandlerThread)localObject).getLooper();
    }
    Object localObject = this.zzag;
    AppMethodBeat.o(100920);
    return localObject;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(100919);
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction()))
    {
      paramIntent = this.zzae;
      AppMethodBeat.o(100919);
      return paramIntent;
    }
    AppMethodBeat.o(100919);
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
    AppMethodBeat.i(100917);
    super.onCreate();
    this.service = new ComponentName(this, getClass().getName());
    if (Log.isLoggable("WearableLS", 3))
    {
      String str = String.valueOf(this.service);
      new StringBuilder(String.valueOf(str).length() + 10).append("onCreate: ").append(str);
    }
    this.zzad = new zzc(getLooper());
    this.zzaf = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
    this.zzaf.setComponent(this.service);
    this.zzae = new zzd(null);
    AppMethodBeat.o(100917);
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(100918);
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
        AppMethodBeat.o(100918);
        throw ((Throwable)localObject2);
      }
    }
    this.zzad.quit();
    super.onDestroy();
    AppMethodBeat.o(100918);
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
  
  final class zza
    extends ChannelClient.ChannelCallback
  {
    private zza() {}
    
    public final void onChannelClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100898);
      WearableListenerService.this.onChannelClosed(paramChannel, paramInt1, paramInt2);
      AppMethodBeat.o(100898);
    }
    
    public final void onChannelOpened(ChannelClient.Channel paramChannel)
    {
      AppMethodBeat.i(100897);
      WearableListenerService.this.onChannelOpened(paramChannel);
      AppMethodBeat.o(100897);
    }
    
    public final void onInputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100899);
      WearableListenerService.this.onInputClosed(paramChannel, paramInt1, paramInt2);
      AppMethodBeat.o(100899);
    }
    
    public final void onOutputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100900);
      WearableListenerService.this.onOutputClosed(paramChannel, paramInt1, paramInt2);
      AppMethodBeat.o(100900);
    }
  }
  
  final class zzb
    implements ServiceConnection
  {
    private zzb() {}
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  final class zzc
    extends Handler
  {
    private boolean started;
    private final WearableListenerService.zzb zzal;
    
    zzc(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(100901);
      this.zzal = new WearableListenerService.zzb(WearableListenerService.this, null);
      AppMethodBeat.o(100901);
    }
    
    /* Error */
    @android.annotation.SuppressLint({"UntrackedBindService"})
    private final void zzb()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 44
      //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 46	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
      //   11: ifeq +11 -> 22
      //   14: ldc 44
      //   16: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: ldc 48
      //   24: iconst_2
      //   25: invokestatic 54	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
      //   28: ifeq +41 -> 69
      //   31: aload_0
      //   32: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
      //   35: invokestatic 58	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
      //   38: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   41: astore_1
      //   42: new 66	java/lang/StringBuilder
      //   45: dup
      //   46: aload_1
      //   47: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   50: invokevirtual 70	java/lang/String:length	()I
      //   53: bipush 13
      //   55: iadd
      //   56: invokespecial 72	java/lang/StringBuilder:<init>	(I)V
      //   59: ldc 74
      //   61: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   64: aload_1
      //   65: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   68: pop
      //   69: aload_0
      //   70: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
      //   73: aload_0
      //   74: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
      //   77: invokestatic 81	com/google/android/gms/wearable/WearableListenerService:zzb	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/Intent;
      //   80: aload_0
      //   81: getfield 34	com/google/android/gms/wearable/WearableListenerService$zzc:zzal	Lcom/google/android/gms/wearable/WearableListenerService$zzb;
      //   84: iconst_1
      //   85: invokevirtual 85	com/google/android/gms/wearable/WearableListenerService:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   88: pop
      //   89: aload_0
      //   90: iconst_1
      //   91: putfield 46	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
      //   94: ldc 44
      //   96: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   99: goto -80 -> 19
      //   102: astore_1
      //   103: aload_0
      //   104: monitorexit
      //   105: aload_1
      //   106: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	107	0	this	zzc
      //   41	24	1	str	String
      //   102	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	102	finally
      //   22	69	102	finally
      //   69	99	102	finally
    }
    
    /* Error */
    @android.annotation.SuppressLint({"UntrackedBindService"})
    private final void zzb(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 90
      //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 46	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
      //   11: ifne +11 -> 22
      //   14: ldc 90
      //   16: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: ldc 48
      //   24: iconst_2
      //   25: invokestatic 54	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
      //   28: ifeq +58 -> 86
      //   31: aload_0
      //   32: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
      //   35: invokestatic 58	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
      //   38: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   41: astore_2
      //   42: new 66	java/lang/StringBuilder
      //   45: dup
      //   46: aload_1
      //   47: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   50: invokevirtual 70	java/lang/String:length	()I
      //   53: bipush 17
      //   55: iadd
      //   56: aload_2
      //   57: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   60: invokevirtual 70	java/lang/String:length	()I
      //   63: iadd
      //   64: invokespecial 72	java/lang/StringBuilder:<init>	(I)V
      //   67: ldc 92
      //   69: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: aload_1
      //   73: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: ldc 94
      //   78: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: aload_2
      //   82: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: pop
      //   86: aload_0
      //   87: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
      //   90: aload_0
      //   91: getfield 34	com/google/android/gms/wearable/WearableListenerService$zzc:zzal	Lcom/google/android/gms/wearable/WearableListenerService$zzb;
      //   94: invokevirtual 98	com/google/android/gms/wearable/WearableListenerService:unbindService	(Landroid/content/ServiceConnection;)V
      //   97: aload_0
      //   98: iconst_0
      //   99: putfield 46	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
      //   102: ldc 90
      //   104: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   107: goto -88 -> 19
      //   110: astore_1
      //   111: aload_0
      //   112: monitorexit
      //   113: aload_1
      //   114: athrow
      //   115: astore_1
      //   116: goto -19 -> 97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	zzc
      //   0	119	1	paramString	String
      //   41	41	2	str	String
      // Exception table:
      //   from	to	target	type
      //   2	19	110	finally
      //   22	86	110	finally
      //   86	97	110	finally
      //   97	107	110	finally
      //   86	97	115	java/lang/RuntimeException
    }
    
    public final void dispatchMessage(Message paramMessage)
    {
      AppMethodBeat.i(100902);
      zzb();
      try
      {
        super.dispatchMessage(paramMessage);
        return;
      }
      finally
      {
        if (!hasMessages(0)) {
          zzb("dispatch");
        }
        AppMethodBeat.o(100902);
      }
      AppMethodBeat.o(100902);
    }
    
    final void quit()
    {
      AppMethodBeat.i(100903);
      getLooper().quit();
      zzb("quit");
      AppMethodBeat.o(100903);
    }
  }
  
  final class zzd
    extends zzen
  {
    private volatile int zzam = -1;
    
    private zzd() {}
    
    private final boolean zza(Runnable paramRunnable, String arg2, Object paramObject)
    {
      AppMethodBeat.i(100915);
      if (Log.isLoggable("WearableLS", 3)) {
        String.format("%s: %s %s", new Object[] { ???, WearableListenerService.zza(WearableListenerService.this).toString(), paramObject });
      }
      int i = Binder.getCallingUid();
      if (i == this.zzam) {
        i = 1;
      }
      while (i == 0)
      {
        AppMethodBeat.o(100915);
        return false;
        if ((zzhp.zza(WearableListenerService.this).zze("com.google.android.wearable.app.cn")) && (UidVerifier.uidHasPackageName(WearableListenerService.this, i, "com.google.android.wearable.app.cn")))
        {
          this.zzam = i;
          i = 1;
        }
        else if (UidVerifier.isGooglePlayServicesUid(WearableListenerService.this, i))
        {
          this.zzam = i;
          i = 1;
        }
        else
        {
          new StringBuilder(57).append("Caller is not GooglePlayServices; caller UID: ").append(i);
          i = 0;
        }
      }
      synchronized (WearableListenerService.zzd(WearableListenerService.this))
      {
        if (WearableListenerService.zze(WearableListenerService.this))
        {
          AppMethodBeat.o(100915);
          return false;
        }
        WearableListenerService.zzf(WearableListenerService.this).post(paramRunnable);
        AppMethodBeat.o(100915);
        return true;
      }
    }
    
    public final void onConnectedNodes(List<zzfo> paramList)
    {
      AppMethodBeat.i(100910);
      zza(new zzp(this, paramList), "onConnectedNodes", paramList);
      AppMethodBeat.o(100910);
    }
    
    public final void zza(DataHolder paramDataHolder)
    {
      AppMethodBeat.i(100906);
      zzl localzzl = new zzl(this, paramDataHolder);
      try
      {
        String str = String.valueOf(paramDataHolder);
        int i = paramDataHolder.getCount();
        boolean bool = zza(localzzl, "onDataItemChanged", String.valueOf(str).length() + 18 + str + ", rows=" + i);
        if (!bool) {
          return;
        }
      }
      finally
      {
        paramDataHolder.close();
        AppMethodBeat.o(100906);
      }
      AppMethodBeat.o(100906);
    }
    
    public final void zza(zzah paramzzah)
    {
      AppMethodBeat.i(100911);
      zza(new zzq(this, paramzzah), "onConnectedCapabilityChanged", paramzzah);
      AppMethodBeat.o(100911);
    }
    
    public final void zza(zzaw paramzzaw)
    {
      AppMethodBeat.i(100914);
      zza(new zzt(this, paramzzaw), "onChannelEvent", paramzzaw);
      AppMethodBeat.o(100914);
    }
    
    public final void zza(zzfe paramzzfe)
    {
      AppMethodBeat.i(100907);
      zza(new zzm(this, paramzzfe), "onMessageReceived", paramzzfe);
      AppMethodBeat.o(100907);
    }
    
    public final void zza(zzfo paramzzfo)
    {
      AppMethodBeat.i(100908);
      zza(new zzn(this, paramzzfo), "onPeerConnected", paramzzfo);
      AppMethodBeat.o(100908);
    }
    
    public final void zza(zzi paramzzi)
    {
      AppMethodBeat.i(100913);
      zza(new zzs(this, paramzzi), "onEntityUpdate", paramzzi);
      AppMethodBeat.o(100913);
    }
    
    public final void zza(com.google.android.gms.wearable.internal.zzl paramzzl)
    {
      AppMethodBeat.i(100912);
      zza(new zzr(this, paramzzl), "onNotificationReceived", paramzzl);
      AppMethodBeat.o(100912);
    }
    
    public final void zzb(zzfo paramzzfo)
    {
      AppMethodBeat.i(100909);
      zza(new zzo(this, paramzzfo), "onPeerDisconnected", paramzzfo);
      AppMethodBeat.o(100909);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * JD-Core Version:    0.7.0.1
 */