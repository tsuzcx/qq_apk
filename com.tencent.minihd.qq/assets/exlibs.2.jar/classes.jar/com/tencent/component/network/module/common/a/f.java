package com.tencent.component.network.module.common.a;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.base.b;
import cvg;
import java.net.InetAddress;

public class f
{
  private static f jdField_a_of_type_ComTencentComponentNetworkModuleCommonAF = null;
  private final int jdField_a_of_type_Int = 128;
  private f.a jdField_a_of_type_ComTencentComponentNetworkModuleCommonAF$a = new f.a(this, 128);
  
  public static f a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentComponentNetworkModuleCommonAF == null) {
        jdField_a_of_type_ComTencentComponentNetworkModuleCommonAF = new f();
      }
      f localf = jdField_a_of_type_ComTencentComponentNetworkModuleCommonAF;
      return localf;
    }
    finally {}
  }
  
  public void a(String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if (b.a()) {
      b.a("dnstest", "$$$addCache[" + paramString + "]");
    }
    cvg localcvg = new cvg(this, null);
    localcvg.jdField_a_of_type_Long = paramLong;
    localcvg.jdField_a_of_type_ArrayOfJavaNetInetAddress = paramArrayOfInetAddress;
    if (NetworkManager.b()) {}
    for (paramArrayOfInetAddress = NetworkManager.a();; paramArrayOfInetAddress = NetworkManager.b())
    {
      localcvg.jdField_a_of_type_JavaLangString = paramArrayOfInetAddress;
      if (this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonAF$a.containsKey(paramString)) {
        this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonAF$a.remove(paramString);
      }
      this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonAF$a.put(paramString, localcvg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.f
 * JD-Core Version:    0.7.0.1
 */