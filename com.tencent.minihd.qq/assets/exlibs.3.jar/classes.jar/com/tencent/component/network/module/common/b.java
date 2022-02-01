package com.tencent.component.network.module.common;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.NetworkUtils.DNS;
import cvi;

public class b
{
  private static volatile b jdField_a_of_type_ComTencentComponentNetworkModuleCommonB;
  private final Context jdField_a_of_type_AndroidContentContext;
  private NetworkUtils.DNS jdField_a_of_type_ComTencentComponentNetworkUtilsNetworkUtils$DNS;
  
  private b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a();
  }
  
  public static b a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentComponentNetworkModuleCommonB != null) {
      return jdField_a_of_type_ComTencentComponentNetworkModuleCommonB;
    }
    try
    {
      if (jdField_a_of_type_ComTencentComponentNetworkModuleCommonB != null)
      {
        paramContext = jdField_a_of_type_ComTencentComponentNetworkModuleCommonB;
        return paramContext;
      }
    }
    finally {}
    paramContext = new b(paramContext);
    jdField_a_of_type_ComTencentComponentNetworkModuleCommonB = paramContext;
    return paramContext;
  }
  
  private void a()
  {
    b();
    cvi localcvi = new cvi(this);
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(localcvi, localIntentFilter);
  }
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsNetworkUtils$DNS = NetworkUtils.a(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public NetworkUtils.DNS a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkUtilsNetworkUtils$DNS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.b
 * JD-Core Version:    0.7.0.1
 */