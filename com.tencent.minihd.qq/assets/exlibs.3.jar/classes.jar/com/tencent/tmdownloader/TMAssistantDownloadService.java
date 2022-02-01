package com.tencent.tmdownloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import java.util.HashMap;

public class TMAssistantDownloadService
  extends Service
  implements com.tencent.tmdownloader.internal.a.a.a
{
  protected static final String TAG = "TMAssistantDownloadSDKService";
  protected final c downloadSDKServiceImpl = new c(this);
  protected final HashMap mCallbackHashMap = new HashMap();
  protected final RemoteCallbackList mCallbacks = new RemoteCallbackList();
  com.tencent.tmdownloader.internal.a.a.c mServiceDownloadTaskManager = null;
  
  public void OnDownloadProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "clientKey:" + paramString1 + ",receivedLen:" + paramLong1 + ",url:" + paramString2 + "; totalLen: " + paramLong2);
    for (;;)
    {
      try
      {
        int j = this.mCallbacks.beginBroadcast();
        i = 0;
        if (i >= j) {}
      }
      catch (Throwable paramString1)
      {
        int i;
        com.tencent.tmassistant.aidl.a locala;
        String str;
        k.c("TMAssistantDownloadSDKService", "exception: ", paramString1);
        continue;
      }
      try
      {
        locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
        str = (String)this.mCallbackHashMap.get(locala);
        if ((str != null) && (str.equals(paramString1) == true))
        {
          k.c("TMAssistantDownloadSDKService", "clientKey:" + paramString1 + ",receivedLen:" + paramLong1 + ",url:" + paramString2);
          locala.a(paramString1, paramString2, paramLong1, paramLong2);
          this.mCallbacks.finishBroadcast();
          k.c("TMAssistantDownloadSDKService", "exit");
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        k.c("TMAssistantDownloadSDKService", "exception: ", localRemoteException);
        i += 1;
      }
    }
  }
  
  public void OnDownloadStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "clientKey:" + paramString1 + "; url: " + paramString2 + "; state:" + paramInt1 + "; errorCode: " + paramInt2 + "; errorMsg: " + paramString3);
    for (;;)
    {
      try
      {
        int j = this.mCallbacks.beginBroadcast();
        i = 0;
        if (i >= j) {}
      }
      catch (Throwable paramString1)
      {
        int i;
        com.tencent.tmassistant.aidl.a locala;
        String str;
        k.c("TMAssistantDownloadSDKService", "exception: ", paramString1);
        continue;
      }
      try
      {
        locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
        str = (String)this.mCallbackHashMap.get(locala);
        if ((str != null) && (str.equals(paramString1) == true))
        {
          k.c("TMAssistantDownloadSDKService", "serviceCallback.OnDownloadSDKServiceTaskStateChanged");
          locala.a(paramString1, paramString2, paramInt1, paramInt2, paramString3);
          this.mCallbacks.finishBroadcast();
          k.c("TMAssistantDownloadSDKService", "exit");
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        k.c("TMAssistantDownloadSDKService", "exception: ", localRemoteException);
        i += 1;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "intent:" + paramIntent);
    k.c("TMAssistantDownloadSDKService", "returnValue: " + this.downloadSDKServiceImpl);
    k.c("TMAssistantDownloadSDKService", "exit");
    return this.downloadSDKServiceImpl;
  }
  
  public void onCreate()
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    super.onCreate();
    f.a().a(this);
    NetworkMonitorReceiver.a().b();
    this.mServiceDownloadTaskManager = new com.tencent.tmdownloader.internal.a.a.c(com.tencent.tmdownloader.internal.b.a.a().c());
    this.mServiceDownloadTaskManager.a(this);
    this.mServiceDownloadTaskManager.a();
    com.tencent.tmdownloader.internal.a.a.b().c();
    new Thread(new b(this)).start();
    k.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public void onDestroy()
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    super.onDestroy();
    com.tencent.tmdownloader.internal.a.a.b().d();
    this.mServiceDownloadTaskManager.b();
    this.mServiceDownloadTaskManager.a(null);
    this.mServiceDownloadTaskManager = null;
    NetworkMonitorReceiver.a().c();
    f.a().c();
    SystemClock.sleep(300L);
    k.c("TMAssistantDownloadSDKService", "exit");
    MobileQQCloseServiceReceiver.a().d(this);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "intent:" + paramIntent);
    boolean bool = super.onUnbind(paramIntent);
    k.c("TMAssistantDownloadSDKService", "returnValue: " + bool);
    k.c("TMAssistantDownloadSDKService", "exit");
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadService
 * JD-Core Version:    0.7.0.1
 */