package com.tencent.tmassistantbase.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver
  extends BroadcastReceiver
{
  protected static NetworkMonitorReceiver a = null;
  protected static Handler c;
  protected boolean b = false;
  ArrayList d = new ArrayList();
  
  public static NetworkMonitorReceiver a()
  {
    try
    {
      if (a == null) {
        a = new NetworkMonitorReceiver();
      }
      NetworkMonitorReceiver localNetworkMonitorReceiver = a;
      return localNetworkMonitorReceiver;
    }
    finally {}
  }
  
  public void a(b paramb)
  {
    if ((!this.d.contains(paramb)) && (paramb != null)) {
      this.d.add(paramb);
    }
  }
  
  public void b()
  {
    Context localContext = f.a().b();
    if (localContext == null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      localContext.registerReceiver(this, localIntentFilter);
      this.b = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      this.b = false;
      localThrowable.printStackTrace();
    }
  }
  
  public void b(b paramb)
  {
    if (paramb != null) {
      this.d.remove(paramb);
    }
  }
  
  public void c()
  {
    if (a == null) {}
    for (;;)
    {
      return;
      Context localContext = f.a().b();
      if (localContext != null) {
        try
        {
          if (this.b)
          {
            localContext.unregisterReceiver(this);
            this.b = false;
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    k.c("NetworkMonitorReceiver", "network changed!");
    if (c == null) {
      c = new c(this);
    }
    c.removeMessages(67);
    paramContext = Message.obtain();
    paramContext.what = 67;
    c.sendMessageDelayed(paramContext, 3500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.NetworkMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */