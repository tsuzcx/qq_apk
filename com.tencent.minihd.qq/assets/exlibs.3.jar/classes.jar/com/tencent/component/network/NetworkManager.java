package com.tencent.component.network;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.component.network.module.base.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NetworkManager
{
  public static final int a = 0;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static NetworkManager.NetworkChangeReceiver jdField_a_of_type_ComTencentComponentNetworkNetworkManager$NetworkChangeReceiver;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  
  public static int a()
  {
    return a(a());
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if ((paramString.contains("cmnet")) || (paramString.contains("cmwap")) || (paramString.contains("cmcc"))) {
      return 1;
    }
    if ((paramString.contains("uninet")) || (paramString.contains("uniwap")) || (paramString.contains("unicom")) || (paramString.contains("3gnet")) || (paramString.contains("3gwap"))) {
      return 2;
    }
    if ((paramString.contains("ctwap")) || (paramString.contains("ctnet")) || (paramString.contains("cmct")) || (paramString.contains("#777"))) {
      return 3;
    }
    return b();
  }
  
  public static String a()
  {
    if (jdField_a_of_type_ComTencentComponentNetworkNetworkManager$NetworkChangeReceiver == null) {}
    while ("none" != "none") {
      return "none";
    }
    return jdField_a_of_type_ComTencentComponentNetworkNetworkManager$NetworkChangeReceiver.b();
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_AndroidContentContext != null) {
      return;
    }
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_ComTencentComponentNetworkNetworkManager$NetworkChangeReceiver = new NetworkManager.NetworkChangeReceiver(paramContext);
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(jdField_a_of_type_ComTencentComponentNetworkNetworkManager$NetworkChangeReceiver, localIntentFilter);
  }
  
  public static void a(NetworkManager.NetStatusListener arg0)
  {
    WeakReference localWeakReference = new WeakReference(???);
    if (localWeakReference != null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_a_of_type_JavaUtilList.add(localWeakReference);
        return;
      }
    }
  }
  
  public static boolean a()
  {
    String str = a();
    if (TextUtils.isEmpty(str)) {}
    while ((!str.contains("cmwap")) && (!str.contains("uniwap")) && (!str.contains("3gwap")) && (!str.contains("ctwap"))) {
      return false;
    }
    return true;
  }
  
  private static int b()
  {
    return a.c();
  }
  
  public static String b()
  {
    try
    {
      Object localObject = ((WifiManager)jdField_a_of_type_AndroidContentContext.getSystemService("wifi")).getConnectionInfo();
      if (localObject != null)
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static void b(NetworkManager.NetStatusListener paramNetStatusListener)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = new ArrayList(jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((NetworkManager.NetStatusListener)localWeakReference.get() == paramNetStatusListener) {
          jdField_a_of_type_JavaUtilList.remove(localWeakReference);
        }
      }
      return;
    }
  }
  
  public static boolean b()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)jdField_a_of_type_AndroidContentContext.getSystemService("connectivity");
        if (localObject1 == null) {
          break label49;
        }
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected())) {
          break;
        }
        int i = ((NetworkInfo)localObject1).getType();
        if (i == 0) {
          return true;
        }
      }
      catch (Throwable localThrowable) {}
      return false;
      label49:
      Object localObject2 = null;
    }
    return false;
  }
  
  public static boolean c()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)jdField_a_of_type_AndroidContentContext.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if (localObject1 == null) {
            break;
          }
          if (!((NetworkInfo)localObject1).isConnected()) {
            return false;
          }
          int i = ((NetworkInfo)localObject1).getType();
          if (1 == i)
          {
            bool = true;
            return bool;
          }
          boolean bool = false;
          continue;
        }
        Object localObject2 = null;
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
    }
    return false;
  }
  
  public static boolean d()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)jdField_a_of_type_AndroidContentContext.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          boolean bool;
          if (localObject1 != null) {
            bool = ((NetworkInfo)localObject1).isConnected();
          }
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        return true;
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager
 * JD-Core Version:    0.7.0.1
 */