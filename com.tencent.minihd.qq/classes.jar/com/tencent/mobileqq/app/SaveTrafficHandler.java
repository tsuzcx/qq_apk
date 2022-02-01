package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hoz;
import hpa;
import hpb;
import hpc;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import msf.statsvc.PbSaveTraffic;

public class SaveTrafficHandler
  extends BusinessHandler
{
  static final int jdField_a_of_type_Int = 1;
  static final long jdField_a_of_type_Long = 5000L;
  public static final String a = "StatSvc.InSaveTraffic";
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  public static boolean a = false;
  static final int jdField_b_of_type_Int = 2;
  static final long jdField_b_of_type_Long = 30000L;
  public static final String b = "StatSvc.OutSaveTraffic";
  static final String c = "key_savetrafficseq";
  static final String d = "key_savetrafficmode";
  static final String e = "_attr_SaveTrafficMode";
  static final String f = "_attr_SaveTrafficSeq";
  static final String g = "_attr_max_retry_count";
  static final String h = "_attr_retry_index";
  private static final String i = "SaveTrafficHandler";
  public Handler a;
  public final ConcurrentHashMap a;
  boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  SaveTrafficHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new hoz(this, ThreadManager.b());
    this.b = false;
  }
  
  private void a(int paramInt)
  {
    hpc localhpc = (hpc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    if (localhpc != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localhpc);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int j = ((Integer)paramToServiceMsg.getAttribute("_attr_SaveTrafficSeq")).intValue();
    QLog.w("SaveTrafficHandler", 2, "<---handleTimeout seq " + j + " req:" + paramToServiceMsg + " resp:" + paramFromServiceMsg);
    a(j);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int j = ((Integer)paramToServiceMsg.getAttribute("_attr_SaveTrafficSeq")).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficHandler", 2, "<---handleTimeout seq:" + j);
    }
    int k;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(j)))
    {
      boolean bool = ((Boolean)paramToServiceMsg.getAttribute("_attr_SaveTrafficMode")).booleanValue();
      k = ((Integer)paramToServiceMsg.getAttribute("_attr_max_retry_count")).intValue();
      int m = ((Integer)paramToServiceMsg.getAttribute("_attr_retry_index")).intValue();
      if (m < k) {
        a(j, bool, m + 1);
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficHandler", 2, "<---handleTimeout seq:" + j + " has reached max count:" + k);
    }
    a(j);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = ((Integer)paramToServiceMsg.getAttribute("_attr_SaveTrafficSeq")).intValue();
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("_attr_SaveTrafficMode")).booleanValue();
    paramToServiceMsg = new PbSaveTraffic();
    try
    {
      paramToServiceMsg = (PbSaveTraffic)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.seq.has()))
      {
        int k = paramToServiceMsg.seq.get();
        if (j != k) {
          QLog.w("SaveTrafficHandler", 2, "<---handleSaveTrafficRes mode:" + bool + " seq not equal: send req:" + j + " recv req:" + k);
        }
        a(j);
        jdField_a_of_type_Boolean = bool;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      try
      {
        new hpb(this, null).execute(new Void[0]);
        if (!bool) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3, false);
        }
        return;
        paramToServiceMsg = paramToServiceMsg;
        if (QLog.isColorLevel()) {
          QLog.e("SaveTrafficHandler", 2, "<---handleSaveTrafficRes: exception occurs while parsing the pb bytes.", paramToServiceMsg);
        }
        paramToServiceMsg = null;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          QLog.d("SaveTrafficHandler", 1, "SaveTrafficPrefTask failed" + paramToServiceMsg.toString());
        }
      }
    }
  }
  
  private void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void d()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  protected Class a()
  {
    return SaveTrafficObserver.class;
  }
  
  public void a()
  {
    if (!this.b) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficHandler", 2, "enter disable...");
    }
    this.b = false;
    jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.b)
    {
      localObject = (hpc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if (localObject != null) {
        break label79;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SaveTrafficHandler", 2, "--->sendSaveTrafficReq cannot find in queue, return. seq:" + paramInt1 + " mode:" + paramBoolean + " retryIndex:" + paramInt2);
      }
    }
    return;
    label79:
    if (paramInt2 == 0)
    {
      new hpa(this, "SaveTrafficPrefThread", paramInt1).start();
      ((hpc)localObject).b = true;
    }
    int j;
    if (paramBoolean)
    {
      j = 1;
      if (QLog.isColorLevel()) {
        QLog.d("SaveTrafficHandler", 2, "--->sendSaveTrafficReq seq:" + paramInt1 + " mode:" + paramBoolean + " retryIndex:" + paramInt2);
      }
      if (!paramBoolean) {
        break label278;
      }
    }
    label278:
    for (Object localObject = "StatSvc.InSaveTraffic";; localObject = "StatSvc.OutSaveTraffic")
    {
      localObject = a((String)localObject);
      ((ToServiceMsg)localObject).addAttribute("_attr_SaveTrafficSeq", Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject).addAttribute("_attr_SaveTrafficMode", Boolean.valueOf(paramBoolean));
      ((ToServiceMsg)localObject).addAttribute("_attr_max_retry_count", Integer.valueOf(j));
      ((ToServiceMsg)localObject).addAttribute("_attr_retry_index", Integer.valueOf(paramInt2));
      PbSaveTraffic localPbSaveTraffic = new PbSaveTraffic();
      localPbSaveTraffic.seq.set(paramInt1);
      ((ToServiceMsg)localObject).putWupBuffer(localPbSaveTraffic.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      b((ToServiceMsg)localObject);
      return;
      j = 10000;
      break;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      int j;
      do
      {
        String str;
        do
        {
          return;
          str = paramToServiceMsg.getServiceCmd();
        } while ((str == null) || (str.length() == 0) || ((!"StatSvc.InSaveTraffic".equalsIgnoreCase(str)) && (!"StatSvc.OutSaveTraffic".equalsIgnoreCase(str))));
        j = ((Integer)paramToServiceMsg.getAttribute("_attr_SaveTrafficSeq")).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("SaveTrafficHandler", 2, "<---SaveTrafficHandler onReceive seq " + j + " req:" + paramToServiceMsg + " resp:" + paramFromServiceMsg + " " + paramObject);
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(j))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SaveTrafficHandler", 2, "<---SaveTrafficHandler onReceive unexpected seq " + j);
      return;
      if (!paramFromServiceMsg.isSuccess()) {
        break;
      }
      try
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SaveTrafficHandler", 2, "handleSaveTrafficRes exception ! ", paramToServiceMsg);
    return;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b)
    {
      if (paramBoolean) {
        c();
      }
    }
    else {
      return;
    }
    d();
  }
  
  public boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.b) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficHandler", 2, "enter enable...");
    }
    this.b = true;
    Object localObject;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      j = ((SharedPreferences)localObject).getInt("key_savetrafficseq", 0);
      jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("key_savetrafficmode", false);
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(j);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
      {
        localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if (QLog.isColorLevel()) {
            QLog.d("SaveTrafficHandler", 2, "init, remove not started seq:" + localEntry.getKey());
          }
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localEntry.getValue());
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) && (jdField_a_of_type_Boolean)) {
        d();
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) || (jdField_a_of_type_Boolean)) {
        break;
      }
      c();
      return;
      j = 0;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SaveTrafficHandler
 * JD-Core Version:    0.7.0.1
 */