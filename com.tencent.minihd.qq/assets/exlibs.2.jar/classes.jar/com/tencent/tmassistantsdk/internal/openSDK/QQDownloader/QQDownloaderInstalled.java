package com.tencent.tmassistantsdk.internal.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.tmassistantbase.a.k;

public class QQDownloaderInstalled
  extends BroadcastReceiver
{
  protected static final String a = QQDownloaderInstalled.class.getSimpleName();
  protected static QQDownloaderInstalled b = null;
  protected boolean c = false;
  protected d d = null;
  
  public static QQDownloaderInstalled a()
  {
    try
    {
      if (b == null) {
        b = new QQDownloaderInstalled();
      }
      QQDownloaderInstalled localQQDownloaderInstalled = b;
      return localQQDownloaderInstalled;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    k.c(a, "context = " + paramContext);
    IntentFilter localIntentFilter;
    if (!this.c)
    {
      k.c("QQDownloaderInstalled", "registeReceiver   context" + paramContext + "  receiver:" + this);
      localIntentFilter = new IntentFilter("com.tencent.assistant.ipc.firststart.action");
    }
    try
    {
      paramContext = paramContext.registerReceiver(this, localIntentFilter);
      k.c("QQDownloaderInstalled", "" + paramContext);
      this.c = true;
      return;
    }
    catch (Throwable paramContext)
    {
      k.c("QQDownloaderInstalled", "registeReceiver exception!!!");
      this.c = false;
      paramContext.printStackTrace();
    }
  }
  
  public void a(d paramd)
  {
    k.c(a, "listener = " + paramd);
    this.d = paramd;
  }
  
  public void b()
  {
    k.c(a, "unregisteListener start");
    this.d = null;
  }
  
  public void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {
      k.c(a, "unRegisteReceiver fail! context = " + paramContext + ",mInstance = " + b);
    }
    while (!this.c) {
      return;
    }
    k.c("QQDownloaderInstalled", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
    try
    {
      paramContext.unregisterReceiver(this);
      this.c = false;
      return;
    }
    catch (Throwable paramContext)
    {
      k.c("QQDownloaderInstalled", "unRegisteReceiver exception!!!");
      this.c = false;
      paramContext.printStackTrace();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    k.c("QQDownloaderInstalled", "onReceive!");
    new c(this, paramContext).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled
 * JD-Core Version:    0.7.0.1
 */