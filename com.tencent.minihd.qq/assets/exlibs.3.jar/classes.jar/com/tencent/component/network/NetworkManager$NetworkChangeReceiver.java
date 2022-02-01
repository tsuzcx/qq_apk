package com.tencent.component.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.component.network.module.common.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class NetworkManager$NetworkChangeReceiver
  extends BroadcastReceiver
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString = "none";
  
  public NetworkManager$NetworkChangeReceiver(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected())) {
            break;
          }
          if (1 == ((NetworkInfo)localObject1).getType()) {
            return "wifi";
          }
          if (((NetworkInfo)localObject1).getExtraInfo() != null) {
            return ((NetworkInfo)localObject1).getExtraInfo().toLowerCase();
          }
          return "unknown";
        }
      }
      catch (Throwable localThrowable)
      {
        return "unknown";
      }
      Object localObject2 = null;
    }
    return "none";
  }
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
    {
      paramIntent = b();
      if ((NetworkManager.d()) && (!paramIntent.equals(this.jdField_a_of_type_JavaLangString))) {
        a.a().a();
      }
      if (!paramIntent.equals(this.jdField_a_of_type_JavaLangString)) {
        synchronized (NetworkManager.a())
        {
          Iterator localIterator = NetworkManager.a().iterator();
          while (localIterator.hasNext())
          {
            NetworkManager.NetStatusListener localNetStatusListener = (NetworkManager.NetStatusListener)((WeakReference)localIterator.next()).get();
            if (localNetStatusListener != null) {
              localNetStatusListener.a(this.jdField_a_of_type_JavaLangString, paramIntent);
            }
          }
        }
      }
      this.jdField_a_of_type_JavaLangString = paramIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager.NetworkChangeReceiver
 * JD-Core Version:    0.7.0.1
 */