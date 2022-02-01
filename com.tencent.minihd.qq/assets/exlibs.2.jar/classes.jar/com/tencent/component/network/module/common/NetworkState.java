package com.tencent.component.network.module.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.component.network.module.base.b;
import java.util.ArrayList;
import java.util.List;

public class NetworkState
  extends BroadcastReceiver
{
  public static final int a = 0;
  private static NetworkState jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkState = null;
  private static final String jdField_a_of_type_JavaLangString = NetworkState.class.getName();
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 6;
  private static int f = 0;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private String b = null;
  
  private static int a(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getType())
    {
    default: 
      f = 0;
    }
    for (;;)
    {
      return f;
      f = 1;
      continue;
      switch (paramNetworkInfo.getSubtype())
      {
      default: 
        break;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        f = 3;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        f = 2;
        break;
      case 13: 
        f = 6;
      }
    }
  }
  
  public static NetworkState a()
  {
    if (jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkState == null) {
      jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkState = new NetworkState();
    }
    return jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkState;
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      NetworkState.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkState.NetworkStateListener[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfNetworkStateListener);
      if (arrayOfNetworkStateListener != null)
      {
        int j = arrayOfNetworkStateListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfNetworkStateListener[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    int j;
    int i;
    NetworkInfo localNetworkInfo;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext == null) {
        break label53;
      }
      j = paramContext.length;
      i = 0;
    }
    catch (SecurityException paramContext)
    {
      return true;
    }
    catch (Throwable paramContext)
    {
      return false;
    }
    if (localNetworkInfo.isConnectedOrConnecting())
    {
      a(localNetworkInfo);
      return true;
    }
    label53:
    label73:
    for (;;)
    {
      return false;
      for (;;)
      {
        if (i >= j) {
          break label73;
        }
        localNetworkInfo = paramContext[i];
        if (localNetworkInfo != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return f;
  }
  
  public String a()
  {
    Object localObject1;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      localObject1 = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
    }
    try
    {
      localObject1 = ((TelephonyManager)localObject1).getSubscriberId();
      if ((localObject1 == null) || ("".equals(localObject1)))
      {
        this.b = "unknown";
        return this.b;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        if ((localObject2.startsWith("46000")) || (localObject2.startsWith("46002"))) {
          this.b = "ChinaMobile";
        } else if (localObject2.startsWith("46001")) {
          this.b = "ChinaUnicom";
        } else if (localObject2.startsWith("46003")) {
          this.b = "ChinaTelecom";
        } else {
          this.b = "unknown";
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    a(paramContext);
  }
  
  public void a(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramNetworkStateListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return true;
    }
    return a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void b(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramNetworkStateListener);
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool1;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      bool1 = true;
    }
    NetworkInfo localNetworkInfo;
    boolean bool2;
    do
    {
      return bool1;
      localNetworkInfo = ((ConnectivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return false;
      }
      bool2 = localNetworkInfo.isConnected();
      bool1 = bool2;
    } while (bool2);
    b.d(jdField_a_of_type_JavaLangString, "isNetworkEnable() : FALSE with TYPE = " + localNetworkInfo.getType());
    return bool2;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    b.d(jdField_a_of_type_JavaLangString, "NetworkStateReceiver ====== " + paramIntent.getAction());
    if (paramIntent.getAction() == null) {}
    while (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") != 0) {
      return;
    }
    a(a(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.NetworkState
 * JD-Core Version:    0.7.0.1
 */