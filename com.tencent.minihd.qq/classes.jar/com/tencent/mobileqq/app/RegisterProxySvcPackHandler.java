package com.tencent.mobileqq.app;

import IPwdPxyMQQ.RespondQueryIPwdStat;
import RegisterProxySvcPack.SvcRespParam;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class RegisterProxySvcPackHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "RegisterProxySvcPack";
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = -1L;
  private int d = 0;
  private int e = 1;
  
  RegisterProxySvcPackHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    try
    {
      int i = this.jdField_b_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long a()
  {
    try
    {
      long l = this.jdField_a_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected Class a()
  {
    return RegisterProxySvcPackObserver.class;
  }
  
  public void a()
  {
    a(a("RegPrxySvc.infoAndroid"));
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      QLog.d("RegisterProxySvcPack", 2, "setSelfPcSuppViewPcVersion:" + paramLong);
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoAndroid")) {
      QLog.d("RegisterProxySvcPack", 2, "resp of RegPrxySvc.infoAndroid");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PushParam"))
          {
            if (paramObject != null)
            {
              paramToServiceMsg = (SvcRespParam)paramObject;
              int i = paramToServiceMsg.PCstat;
              if (paramToServiceMsg.iIsSupportDataLine == 2) {
                i = 0;
              }
              a(i);
              b(paramToServiceMsg.iIsSupportDataLine);
              c(paramToServiceMsg.iIsSupportPrintable);
              d(paramToServiceMsg.iIsSupportViewPCFile);
              a(paramToServiceMsg.iPcVersion);
              b(paramToServiceMsg.uRoamFlag);
              QLog.d("RegisterProxySvcPack", 2, "online status of pc: state:" + paramToServiceMsg.PCstat + "- ram:" + paramToServiceMsg.iIsSupportC2CRoamMsg + "- supportdataline:" + paramToServiceMsg.iIsSupportDataLine + "- PcVersion:" + paramToServiceMsg.iPcVersion);
              a(1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.iIsSupportDataLine) });
              return;
            }
            QLog.d("RegisterProxySvcPack", 2, "RegPrxySvc.PushParam is null");
            return;
          }
        } while (!paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.QueryIpwdStat"));
        if (paramObject == null) {
          break;
        }
        paramToServiceMsg = (RespondQueryIPwdStat)paramObject;
      } while (paramToServiceMsg == null);
      c(paramToServiceMsg.uIsSetPwd);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("RegisterProxySvcPack", 2, "IPwdPxyMQQ.RespondQueryIPwdStat is null");
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long b()
  {
    try
    {
      long l = this.jdField_b_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(long paramLong)
  {
    int i = 2;
    label177:
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Long = paramLong;
        if ((paramLong & 1L) != 1L)
        {
          if ((paramLong & 0x2) == 2L)
          {
            break label177;
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (i != -1)) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i).commit();
            }
          }
          else
          {
            if ((paramLong & 0x8) == 8L)
            {
              i = 3;
              continue;
            }
            if ((paramLong & 0x10) == 16L) {
              continue;
            }
            i = 1;
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RegisterProxySvcPack", 2, "RegisterProxySvcPackHandler.app is null or mRoamSetting is error ,mRoamSetting = " + i);
          continue;
        }
        i = 4;
      }
      finally {}
    }
  }
  
  public long c()
  {
    try
    {
      long l = this.jdField_c_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void c(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: lload_1
    //   6: putfield 38	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_c_of_type_Long	J
    //   9: lload_1
    //   10: lconst_1
    //   11: lcmp
    //   12: ifne +75 -> 87
    //   15: iconst_1
    //   16: istore_3
    //   17: aload_0
    //   18: getfield 173	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: ifnull +79 -> 100
    //   24: iload_3
    //   25: iconst_m1
    //   26: if_icmpeq +74 -> 100
    //   29: aload_0
    //   30: getfield 173	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   36: ldc 181
    //   38: iconst_0
    //   39: invokevirtual 187	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   42: invokeinterface 193 1 0
    //   47: new 57	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   54: ldc 214
    //   56: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 173	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   66: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: iload_3
    //   73: invokeinterface 203 3 0
    //   78: invokeinterface 206 1 0
    //   83: pop
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: lload_1
    //   88: ldc2_w 169
    //   91: lcmp
    //   92: ifeq -75 -> 17
    //   95: iconst_m1
    //   96: istore_3
    //   97: goto -80 -> 17
    //   100: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq -19 -> 84
    //   106: ldc 10
    //   108: iconst_2
    //   109: new 57	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   116: ldc 216
    //   118: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_3
    //   122: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: goto -47 -> 84
    //   134: astore 4
    //   136: aload_0
    //   137: monitorexit
    //   138: aload 4
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	RegisterProxySvcPackHandler
    //   0	141	1	paramLong	long
    //   1	121	3	i	int
    //   134	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	134	finally
    //   17	24	134	finally
    //   29	84	134	finally
    //   100	131	134	finally
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.e = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int e()
  {
    try
    {
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int f()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int g()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RegisterProxySvcPackHandler
 * JD-Core Version:    0.7.0.1
 */