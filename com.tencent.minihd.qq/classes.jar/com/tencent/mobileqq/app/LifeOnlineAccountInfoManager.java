package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.os.Handler;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.LifeOnlineAccountInfo;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import hkv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import msf.msgcomm.msg_comm.Msg;

public class LifeOnlineAccountInfoManager
  implements Manager
{
  public static final int a = 0;
  public static long a = 0L;
  public static final String a = "LifeOnlineAccountInfoManager";
  public static final int b = 11;
  public static final int c = 9;
  public static final int d = 3100;
  public static final int e = 3101;
  public static final int f = 3102;
  public QQAppInterface a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new hkv(this);
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap b;
  private ConcurrentHashMap c;
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  public LifeOnlineAccountInfoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
  }
  
  public int a(String paramString, long paramLong)
  {
    Object localObject = a().a(LifeOnlineAccountInfo.class, LifeOnlineAccountInfo.getTableNewName(), false, " frienduin = ? and pstate = 2 and timestamp <= ? ", new String[] { paramString, String.valueOf(paramLong) }, null, null, null, null);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LifeOnlineAccountInfoManager", 2, "res == null,unread:0");
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LifeOnlineAccountInfoManager", 2, "unread:" + ((List)localObject).size());
    }
    paramString = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LifeOnlineAccountInfo localLifeOnlineAccountInfo = (LifeOnlineAccountInfo)((Iterator)localObject).next();
      if (!paramString.contains(Long.valueOf(localLifeOnlineAccountInfo.msgid))) {
        paramString.add(Long.valueOf(localLifeOnlineAccountInfo.msgid));
      }
    }
    return paramString.size();
  }
  
  public LifeOnlineAccountInfo a(String paramString)
  {
    Object localObject = String.format("select msgid,frienduin,selfuin, isPullRoam, needNofityConversation,isProxyMsg,  objdata, timestamp, showtime,pstate,uniseq from " + LifeOnlineAccountInfo.getTableNewName() + " where pstate = 1 and msgid=? ", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("LifeOnlineAccountInfoManager", 2, "queryMessageFromDB: sqlStr=" + (String)localObject);
    }
    new LifeOnlineAccountInfo();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      LifeOnlineAccountInfo localLifeOnlineAccountInfo = (LifeOnlineAccountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localLifeOnlineAccountInfo != null) {
        return localLifeOnlineAccountInfo;
      }
      localObject = a((String)localObject, new String[] { paramString });
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LifeOnlineAccountInfoManager", 2, "queryMessageFromDB: list size =" + ((List)localObject).size());
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (LifeOnlineAccountInfo)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
          return localObject;
        }
      }
      else
      {
        return null;
      }
    }
    return null;
  }
  
  protected EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForPubAccount))
      {
        if ((this.b != null) && (this.b.containsKey(Long.valueOf(((MessageForPubAccount)localMessageRecord).pa_uuid))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "Delete pa_uuid = " + ((MessageForPubAccount)localMessageRecord).pa_uuid);
          }
          paramArrayList.remove(paramArrayList.indexOf(localMessageRecord) - 1);
          paramArrayList.remove(localMessageRecord);
        }
        if ((this.c != null) && (this.c.containsKey(Long.valueOf(((MessageForPubAccount)localMessageRecord).pa_uuid))) && (((MessageForPubAccount)localMessageRecord).pa_op == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "Update pa_uuid = " + ((MessageForPubAccount)localMessageRecord).pa_uuid);
          }
          paramArrayList.remove(paramArrayList.indexOf(localMessageRecord) - 1);
          paramArrayList.remove(localMessageRecord);
        }
      }
    }
    return paramArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((LifeOnlineAccountInfo)((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public List a(long paramLong)
  {
    long l = NetConnInfoCenter.getServerTime();
    String str = String.format("select msgid,frienduin,selfuin, isPullRoam, needNofityConversation,isProxyMsg,  objdata, timestamp, showtime,pstate,uniseq from " + LifeOnlineAccountInfo.getTableNewName() + " where pstate = ? and showtime <= ? and showtime > ?", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("LifeOnlineAccountInfoManager", 2, "queryMessageFromDB: sqlStr=" + str);
    }
    return a(str, new String[] { "1", String.valueOf(paramLong), String.valueOf(l - 604800L) });
  }
  
  public List a(String paramString, String[] paramArrayOfString)
  {
    return a().a(LifeOnlineAccountInfo.class, paramString, paramArrayOfString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeOnlineAccountInfoManager", 2, "initLifeOnlineAccountInfoCache begin");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (this.b == null) {
      this.b = new ConcurrentHashMap();
    }
    if (this.c == null) {
      this.c = new ConcurrentHashMap();
    }
    b();
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L) {
      QLog.d("LifeOnlineAccountInfoManager", 2, "------------Can not startCountDownTime!!!-------");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LifeOnlineAccountInfoManager", 2, "------------startCountDownTime------------difftime:" + paramLong);
      }
      try
      {
        ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L * paramLong);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("LifeOnlineAccountInfoManager", 2, "error: " + localException.getMessage());
  }
  
  public void a(LifeOnlineAccountInfo paramLifeOnlineAccountInfo)
  {
    jdField_a_of_type_Long = Long.valueOf(paramLifeOnlineAccountInfo.showtime).longValue();
    long l = NetConnInfoCenter.getServerTime();
    if (jdField_a_of_type_Long <= l)
    {
      jdField_a_of_type_Long = 0L;
      Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
      if ((((PublicAccountDataManager)localObject).a(Long.valueOf(paramLifeOnlineAccountInfo.getFriendUin()))) && (!((PublicAccountDataManager)localObject).b(Long.valueOf(paramLifeOnlineAccountInfo.getFriendUin()))))
      {
        localObject = new msg_comm.Msg();
        try
        {
          ((msg_comm.Msg)localObject).mergeFrom(paramLifeOnlineAccountInfo.getObjData());
          ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("c2c_processor")).a(paramLifeOnlineAccountInfo.getFriendUin(), paramLifeOnlineAccountInfo.getSelfUin(), (msg_comm.Msg)localObject, Integer.valueOf(paramLifeOnlineAccountInfo.getShowtime()).intValue());
          a(paramLifeOnlineAccountInfo, 2);
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "Presend msg excute successful!showtime: " + paramLifeOnlineAccountInfo.getShowtime() + "servertime: " + NetConnInfoCenter.getServerTime() + "servertimeMillis: " + NetConnInfoCenter.getServerTimeMillis());
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "", "", "0X8004E67", "0X8004E67", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "-------reportID:0X8004E67,preMsgID:" + paramLifeOnlineAccountInfo.getMsgid() + "-------");
          }
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("LifeOnlineAccountInfoManager", 2, "InvalidProtocolBufferMicroException:" + localException.getMessage());
            }
          }
        }
      }
      a(paramLifeOnlineAccountInfo, 2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LifeOnlineAccountInfoManager", 2, "------------startCountDownTime------------SHOW_TIME:" + jdField_a_of_type_Long + " ,servertime: " + l);
    }
    a(jdField_a_of_type_Long - l);
  }
  
  public void a(List paramList, msg_comm.Msg paramMsg)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (((localMessageRecord instanceof MessageForPubAccount)) && (((MessageForPubAccount)localMessageRecord).pa_uuid >= 0L) && (((MessageForPubAccount)localMessageRecord).pa_time > 0L))
      {
        long l1;
        long l2;
        LifeOnlineAccountInfo localLifeOnlineAccountInfo;
        try
        {
          l1 = NetConnInfoCenter.getServerTime();
          l2 = l1 - 604800L;
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "----decodeLifeOnlineAccountList-------pa_time: " + ((MessageForPubAccount)localMessageRecord).pa_time + ",ServerTime: " + l1 + ",pa_uuid: " + ((MessageForPubAccount)localMessageRecord).pa_uuid + ",pa_op: " + ((MessageForPubAccount)localMessageRecord).pa_op + ",current time : " + System.currentTimeMillis());
          }
          if (((MessageForPubAccount)localMessageRecord).pa_op == 9) {
            break label1196;
          }
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "pa_op: " + ((MessageForPubAccount)localMessageRecord).pa_op);
          }
          localLifeOnlineAccountInfo = a(String.valueOf(((MessageForPubAccount)localMessageRecord).pa_uuid));
          if (((MessageForPubAccount)localMessageRecord).pa_time > l1) {
            break label763;
          }
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "ml.pa_time <= servertime");
          }
          if (localLifeOnlineAccountInfo != null) {
            break label520;
          }
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "info == null");
          }
          if (((MessageForPubAccount)localMessageRecord).pa_op != 0) {
            break label491;
          }
          localLifeOnlineAccountInfo = new LifeOnlineAccountInfo();
          if (((MessageForPubAccount)localMessageRecord).pa_time < l2) {
            break label447;
          }
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "PRE_MSG_NORMAL! op success! PRE_MSG_DELETED !");
          }
          ((MessageForPubAccount)localMessageRecord).time = ((MessageForPubAccount)localMessageRecord).pa_time;
          localLifeOnlineAccountInfo.init(((MessageForPubAccount)localMessageRecord).pa_uuid, ((MessageForPubAccount)localMessageRecord).pa_time, localMessageRecord.selfuin, localMessageRecord.frienduin, false, false, false, paramMsg.toByteArray(), l1, 2, localMessageRecord.uniseq);
          a(localLifeOnlineAccountInfo);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.e("LifeOnlineAccountInfoManager", 2, "decodeLifeOnlineAccountList error " + localException, localException);
          continue;
          label447:
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "PRE_MSG_EXPIRED!");
          }
          paramList.remove(paramList.indexOf(localException) - 1);
          paramList.remove(localException);
          continue;
          label491:
          paramList.remove(paramList.indexOf(localException) - 1);
          paramList.remove(localException);
          continue;
          label520:
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "info != null,info.pstate:" + localLifeOnlineAccountInfo.pstate);
          }
          if (localLifeOnlineAccountInfo.pstate == 1)
          {
            if (localLifeOnlineAccountInfo.showtime >= l2)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LifeOnlineAccountInfoManager", 2, "PRE_MSG_NORMAL! op success! PRE_MSG_DELETED !");
              }
              ((MessageForPubAccount)localException).time = ((MessageForPubAccount)localException).pa_time;
              a(localLifeOnlineAccountInfo, 2);
              if (((MessageForPubAccount)localException).pa_op != 0)
              {
                if (this.c == null) {
                  this.c = new ConcurrentHashMap();
                }
                this.c.put(Long.valueOf(((MessageForPubAccount)localException).pa_uuid), paramList.get(paramList.indexOf(localException) - 1));
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("LifeOnlineAccountInfoManager", 2, "PRE_MSG_EXPIRED!");
              }
              paramList.remove(paramList.indexOf(localException) - 1);
              paramList.remove(localException);
              a(localLifeOnlineAccountInfo, 3);
            }
          }
          else
          {
            paramList.remove(paramList.indexOf(localException) - 1);
            paramList.remove(localException);
            continue;
            label763:
            paramList.remove(paramList.indexOf(localException) - 1);
            paramList.remove(localException);
            localLifeOnlineAccountInfo = new LifeOnlineAccountInfo();
            localLifeOnlineAccountInfo.init(((MessageForPubAccount)localException).pa_uuid, ((MessageForPubAccount)localException).pa_time, localException.selfuin, localException.frienduin, false, false, false, paramMsg.toByteArray(), l1, 1, localException.uniseq);
            if (((MessageForPubAccount)localException).pa_op == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LifeOnlineAccountInfoManager", 2, "Create a new alarm for CREATNEWPAM------");
              }
              if (!a(localLifeOnlineAccountInfo))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("LifeOnlineAccountInfoManager", 2, "saveLifeOnlineAccountInfo failed!!!!!!");
                }
              }
              else if (jdField_a_of_type_Long == 0L)
              {
                jdField_a_of_type_Long = Long.valueOf(localLifeOnlineAccountInfo.getShowtime()).longValue();
                a(jdField_a_of_type_Long - l1);
              }
              else if (Long.valueOf(localLifeOnlineAccountInfo.getShowtime()).longValue() < jdField_a_of_type_Long)
              {
                Long.valueOf(localLifeOnlineAccountInfo.getShowtime());
                a(jdField_a_of_type_Long - l1);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "", "", "0X8004E68", "0X8004E68", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("LifeOnlineAccountInfoManager", 2, "-------reportID:0X8004E68,preMsgID:" + ((MessageForPubAccount)localException).pa_uuid + ",preMsgOP:" + ((MessageForPubAccount)localException).pa_op + "-------");
                }
              }
            }
            else if (((MessageForPubAccount)localException).pa_op == 11)
            {
              boolean bool = a(localLifeOnlineAccountInfo, 1);
              if (QLog.isColorLevel()) {
                QLog.d("LifeOnlineAccountInfoManager", 2, "Update an alarm for UPDATEPAM-------");
              }
              if (!bool)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("LifeOnlineAccountInfoManager", 2, "updateInfo failed!!!!!!");
                }
              }
              else if (jdField_a_of_type_Long == 0L)
              {
                jdField_a_of_type_Long = Long.valueOf(localLifeOnlineAccountInfo.getShowtime()).longValue();
                a(jdField_a_of_type_Long - l1);
              }
              else if (Long.valueOf(localLifeOnlineAccountInfo.getShowtime()).longValue() < jdField_a_of_type_Long)
              {
                Long.valueOf(localLifeOnlineAccountInfo.getShowtime());
                a(jdField_a_of_type_Long - l1);
                continue;
                label1196:
                if (((MessageForPubAccount)localException).pa_time <= l1)
                {
                  if (this.b == null) {
                    this.b = new ConcurrentHashMap();
                  }
                  this.b.put(Long.valueOf(((MessageForPubAccount)localException).pa_uuid), paramList.get(paramList.indexOf(localException) - 1));
                }
                for (;;)
                {
                  paramList.remove(paramList.indexOf(localException) - 1);
                  paramList.remove(localException);
                  break;
                  if (QLog.isColorLevel()) {
                    QLog.d("LifeOnlineAccountInfoManager", 2, "Delete an alarm for DELPAM-------");
                  }
                  localLifeOnlineAccountInfo = a(String.valueOf(((MessageForPubAccount)localException).pa_uuid));
                  if (localLifeOnlineAccountInfo != null)
                  {
                    if (!a(localLifeOnlineAccountInfo, 2))
                    {
                      if (!QLog.isColorLevel()) {
                        return;
                      }
                      QLog.d("LifeOnlineAccountInfoManager", 2, "delLifeOnlineAccountInfo failed!!!!!!");
                      return;
                    }
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "", "", "0X8004E69", "0X8004E69", 0, 0, "", "", "", "");
                    if (QLog.isColorLevel()) {
                      QLog.d("LifeOnlineAccountInfoManager", 2, "-------reportID:0X8004E69,preMsgID:" + ((MessageForPubAccount)localException).pa_uuid + ",preMsgOP:" + ((MessageForPubAccount)localException).pa_op + "-------");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(LifeOnlineAccountInfo paramLifeOnlineAccountInfo)
  {
    if (paramLifeOnlineAccountInfo == null) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      paramLifeOnlineAccountInfo.setStatus(1000);
      if (a(paramLifeOnlineAccountInfo)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LifeOnlineAccountInfoManager", 2, "saveLifeOnlineAccountInfo failed because DB operation failed");
    return false;
    if (paramLifeOnlineAccountInfo.pstate == 1) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLifeOnlineAccountInfo.getMsgid(), paramLifeOnlineAccountInfo);
    }
    return true;
  }
  
  public boolean a(LifeOnlineAccountInfo paramLifeOnlineAccountInfo, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("objdata", paramLifeOnlineAccountInfo.getObjData());
    localContentValues.put("showtime", paramLifeOnlineAccountInfo.getShowtime());
    localContentValues.put("timestamp", paramLifeOnlineAccountInfo.getTimeStamp());
    localContentValues.put("isPullRoam", Boolean.valueOf(paramLifeOnlineAccountInfo.getIsPullRoam()));
    localContentValues.put("needNofityConversation", Boolean.valueOf(paramLifeOnlineAccountInfo.getNeedNofityConversation()));
    localContentValues.put("isProxyMsg", Boolean.valueOf(paramLifeOnlineAccountInfo.getIsProxyMsg()));
    localContentValues.put("pstate", Integer.valueOf(paramInt));
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(LifeOnlineAccountInfo.getTableNewName(), localContentValues, " msgid=?", new String[] { String.valueOf(paramLifeOnlineAccountInfo.getMsgid()) });
    if (bool)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label160;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LifeOnlineAccountInfoManager", 2, "Update cache fail!LifeOnlineAccountInfoCache is null!");
      }
    }
    return bool;
    label160:
    if (paramInt == 1)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramLifeOnlineAccountInfo.getMsgid());
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLifeOnlineAccountInfo.getMsgid(), paramLifeOnlineAccountInfo);
      return bool;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramLifeOnlineAccountInfo.getMsgid());
    return bool;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    long l = NetConnInfoCenter.getServerTime();
    paramString = a().a(LifeOnlineAccountInfo.class, LifeOnlineAccountInfo.getTableNewName(), false, " frienduin = ? and pstate != 1 and timestamp <= ?", new String[] { paramString, String.valueOf(l) }, null, null, null, null);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LifeOnlineAccountInfoManager", 2, "res size:" + paramString.size());
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        LifeOnlineAccountInfo localLifeOnlineAccountInfo = (LifeOnlineAccountInfo)paramString.next();
        a().b(localLifeOnlineAccountInfo);
      }
      bool = true;
    }
    return bool;
  }
  
  public List b()
  {
    return a(String.format("select msgid,frienduin,selfuin, isPullRoam, needNofityConversation,isProxyMsg,  objdata, timestamp, showtime,pstate,uniseq from " + LifeOnlineAccountInfo.getTableNewName() + " where pstate = 1 ORDER BY showtime asc ", new Object[0]), null);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeOnlineAccountInfoManager", 2, "-------initPreSend-----------");
    }
    Object localObject = b();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LifeOnlineAccountInfoManager", 2, "-------list is null!!!");
      }
      jdField_a_of_type_Long = 0L;
    }
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LifeOnlineAccountInfo localLifeOnlineAccountInfo = (LifeOnlineAccountInfo)((Iterator)localObject).next();
        if (localLifeOnlineAccountInfo.pstate != 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "info.pstate != LifeOnlineAccountInfo.PRE_MSG_NORMAL");
          }
        }
        else if (HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
          a(localLifeOnlineAccountInfo);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeOnlineAccountInfoManager", 2, "onDestroy");
    }
    jdField_a_of_type_Long = 0L;
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LifeOnlineAccountInfoManager
 * JD-Core Version:    0.7.0.1
 */