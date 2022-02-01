package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import htx;
import hty;
import htz;
import hua;
import hub;
import huc;
import hud;
import hue;
import huf;
import hug;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class DataLineMsgProxy
  extends BaseProxy
{
  private static final int jdField_a_of_type_Int = 15;
  private static final int jdField_b_of_type_Int = 256;
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
  private String jdField_a_of_type_JavaLangString;
  private Date jdField_a_of_type_JavaUtilDate;
  private List jdField_a_of_type_JavaUtilList;
  private DataLineMsgSetList jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSetList;
  
  public DataLineMsgProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private String a(long paramLong, int paramInt)
  {
    String str = DataLineMsgRecord.tableName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select " + str + ".*, case when groupId=0 or groupId is null then msgId else groupId end as msgKey from " + str + " ").append("join ").append("(select * from ").append("(select case when groupId=0 or groupId is null then msgId else groupId end as msgKey2, ").append("max(msgId) AS rorder ").append("from " + str + " ");
    if (paramLong != -1L) {
      localStringBuilder.append("where " + str + ".msgId < ? ");
    }
    localStringBuilder.append("group by msgKey2) ").append("order by rorder desc ").append("limit " + paramInt + " ) b ").append("on  msgKey=msgKey2 ");
    if (paramLong != -1L) {
      localStringBuilder.append("order by " + str + ".msgId desc");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("order by " + str + ".msgId asc");
    }
  }
  
  public static boolean a(ProxyManager paramProxyManager, String paramString)
  {
    paramProxyManager = ((Vector)paramProxyManager.a().clone()).iterator();
    while (paramProxyManager.hasNext())
    {
      MsgQueueItem localMsgQueueItem = (MsgQueueItem)paramProxyManager.next();
      if ((String.valueOf(0).equals(localMsgQueueItem.jdField_a_of_type_JavaLangString)) && (localMsgQueueItem.h == 0) && (localMsgQueueItem.b.equals(paramString)) && ((localMsgQueueItem.i == 1) || (localMsgQueueItem.i == 2) || (localMsgQueueItem.i == 0))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool3 = false;
    label117:
    label122:
    label124:
    for (;;)
    {
      try
      {
        a();
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList == null) {
          break label117;
        }
        bool1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.remove(paramDataLineMsgSet);
        bool2 = bool1;
        if (this.b != null)
        {
          if (this.b.remove(paramDataLineMsgSet)) {
            break label122;
          }
          bool2 = bool3;
          if (!bool1) {
            break label124;
          }
          break label122;
        }
        if (bool2)
        {
          paramDataLineMsgSet = paramDataLineMsgSet.values().iterator();
          if (paramDataLineMsgSet.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramDataLineMsgSet.next();
            this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(localDataLineMsgRecord.sessionid));
            continue;
          }
        }
      }
      finally {}
      return bool2;
      boolean bool1 = false;
      continue;
      boolean bool2 = true;
    }
  }
  
  /* Error */
  private long c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 141	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:a	()V
    //   6: aload_1
    //   7: aload_0
    //   8: getfield 143	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   11: invokevirtual 178	com/tencent/mobileqq/data/DataLineMsgSetList:getLastId	()J
    //   14: lconst_1
    //   15: ladd
    //   16: putfield 181	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   19: aload_0
    //   20: getfield 143	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   23: aload_1
    //   24: invokevirtual 185	com/tencent/mobileqq/data/DataLineMsgSetList:appendToList	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;)Lcom/tencent/mobileqq/data/DataLineMsgSet;
    //   27: astore 4
    //   29: aload_0
    //   30: invokespecial 188	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:g	()V
    //   33: aload_0
    //   34: getfield 150	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:b	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   37: ifnull +17 -> 54
    //   40: aload 4
    //   42: ifnonnull +21 -> 63
    //   45: aload_0
    //   46: getfield 150	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:b	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   49: aload_1
    //   50: invokevirtual 185	com/tencent/mobileqq/data/DataLineMsgSetList:appendToList	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;)Lcom/tencent/mobileqq/data/DataLineMsgSet;
    //   53: pop
    //   54: aload_1
    //   55: getfield 181	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   58: lstore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: lload_2
    //   62: lreturn
    //   63: aload_0
    //   64: getfield 150	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:b	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   67: aload 4
    //   69: invokevirtual 191	com/tencent/mobileqq/data/DataLineMsgSetList:appendToList	(Lcom/tencent/mobileqq/data/DataLineMsgSet;)V
    //   72: goto -18 -> 54
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	DataLineMsgProxy
    //   0	80	1	paramDataLineMsgRecord	DataLineMsgRecord
    //   58	4	2	l	long
    //   27	41	4	localDataLineMsgSet	DataLineMsgSet
    // Exception table:
    //   from	to	target	type
    //   2	40	75	finally
    //   45	54	75	finally
    //   54	59	75	finally
    //   63	72	75	finally
  }
  
  private void d(long paramLong)
  {
    DataLineMsgRecord localDataLineMsgRecord = a(paramLong);
    if (localDataLineMsgRecord != null)
    {
      ContentValues localContentValues = new ContentValues();
      localDataLineMsgRecord.doPrewrite();
      localContentValues.put("msgData", localDataLineMsgRecord.msgData);
      a(DataLineMsgRecord.tableName(), localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
  
  private void e(long paramLong)
  {
    DataLineMsgRecord localDataLineMsgRecord = a(paramLong);
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("issuc", Boolean.valueOf(true));
    ((ContentValues)localObject).put("progress", Float.valueOf(1.0F));
    if (localDataLineMsgRecord != null)
    {
      localDataLineMsgRecord.issuc = true;
      localDataLineMsgRecord.progress = 1.0F;
      a(DataLineMsgRecord.tableName(), (ContentValues)localObject, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
      if (localDataLineMsgRecord.path != null) {
        break label85;
      }
    }
    label85:
    do
    {
      do
      {
        return;
      } while (localDataLineMsgRecord.strMoloKey != null);
      localObject = new File(localDataLineMsgRecord.path);
      if (localObject != null) {
        ((File)localObject).setLastModified(System.currentTimeMillis());
      }
      if (localDataLineMsgRecord.entityID == 0L) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localDataLineMsgRecord.entityID);
      if (localObject == null) {
        break label244;
      }
    } while (!((FileManagerEntity)localObject).bDelInFM);
    for (;;)
    {
      localObject = FileManagerUtil.a(localDataLineMsgRecord);
      if ((((FileManagerEntity)localObject).cloudType == 6) && (((FileManagerEntity)localObject).strFilePath != null) && (new File(((FileManagerEntity)localObject).strFilePath).exists())) {
        ((FileManagerEntity)localObject).cloudType = 3;
      }
      a(localDataLineMsgRecord.msgId);
      ((FileManagerEntity)localObject).bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((FileManagerEntity)localObject);
      return;
      label244:
      localDataLineMsgRecord.entityID = 0L;
    }
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        a();
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() <= 15) {
          break;
        }
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(0);
        if ((localDataLineMsgSet.getGroupType() == -2334) || (localDataLineMsgSet.getGroupType() == -1000))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.remove(0);
          continue;
        }
        if (!localObject.isAllCompleted()) {
          break;
        }
      }
      finally {}
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.remove(0).values().iterator();
      while (localIterator.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
        if (this.jdField_a_of_type_JavaUtilList.size() > 256) {
          this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
  }
  
  private void h()
  {
    Iterator localIterator2;
    DataLineMsgRecord localDataLineMsgRecord;
    try
    {
      a();
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
      if (localObject1 == null) {}
      do
      {
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localIterator2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
          while (localIterator2.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
            if (!localDataLineMsgRecord.isread) {
              localDataLineMsgRecord.isread = true;
            }
          }
        }
      } while (this.b == null);
    }
    finally {}
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext())
      {
        localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
        if (!localDataLineMsgRecord.isread) {
          localDataLineMsgRecord.isread = true;
        }
      }
    }
  }
  
  public int a()
  {
    try
    {
      a();
      int i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.clear();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.b != null) {
        this.b.clear();
      }
      a(DataLineMsgRecord.tableName(), null, null, null);
      return i;
    }
    finally {}
  }
  
  public int a(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.b != null)
    {
      l1 = l2;
      if (!this.b.isEmpty()) {
        l1 = this.b.getFirstId();
      }
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager, DataLineMsgRecord.tableName())) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(localEntityManager);
    }
    Object localObject = localEntityManager.a(DataLineMsgRecord.class, a(l1, paramInt), new String[] { String.valueOf(l1) });
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      paramInt = 0;
      i = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break label155;
      }
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
      if (!this.b.insertFrontToList(localDataLineMsgRecord)) {
        break label162;
      }
      paramInt += 1;
    }
    label155:
    label162:
    for (;;)
    {
      break;
      i = 0;
      localEntityManager.a();
      return i;
    }
  }
  
  public int a(DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramDataLineMsgSet == null) {
      return -1;
    }
    b(paramDataLineMsgSet);
    paramDataLineMsgSet = paramDataLineMsgSet.values().iterator();
    while (paramDataLineMsgSet.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramDataLineMsgSet.next();
      a(DataLineMsgRecord.tableName(), "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
    return 1;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      return c(paramDataLineMsgRecord);
    }
    new Handler(localLooper).post(new hub(this, paramDataLineMsgRecord, localWaitEvent));
    localWaitEvent.a(-1L);
    return 0L;
  }
  
  /* Error */
  public DataLineMsgRecord a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 141	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:a	()V
    //   6: aload_0
    //   7: getfield 143	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: getfield 143	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   25: aload_0
    //   26: getfield 143	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   29: invokevirtual 309	com/tencent/mobileqq/data/DataLineMsgSetList:size	()I
    //   32: iconst_1
    //   33: isub
    //   34: invokevirtual 313	com/tencent/mobileqq/data/DataLineMsgSetList:get	(I)Lcom/tencent/mobileqq/data/DataLineMsgSet;
    //   37: invokevirtual 419	com/tencent/mobileqq/data/DataLineMsgSet:getLastItem	()Lcom/tencent/mobileqq/data/DataLineMsgRecord;
    //   40: astore_1
    //   41: goto -24 -> 17
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	DataLineMsgProxy
    //   10	31	1	localObject1	Object
    //   44	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	44	finally
    //   21	41	44	finally
  }
  
  public DataLineMsgRecord a(long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        a();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject4 == null) {
          return localObject3;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        Iterator localIterator;
        if (((Iterator)localObject4).hasNext())
        {
          localIterator = ((DataLineMsgSet)((Iterator)localObject4).next()).values().iterator();
          if (localIterator.hasNext())
          {
            localObject3 = (DataLineMsgRecord)localIterator.next();
            if (((DataLineMsgRecord)localObject3).msgId == paramLong) {
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (this.b != null)
            {
              localObject4 = this.b.iterator();
              localObject3 = localObject1;
              if (((Iterator)localObject4).hasNext())
              {
                localIterator = ((DataLineMsgSet)((Iterator)localObject4).next()).values().iterator();
                if (localIterator.hasNext())
                {
                  localObject3 = (DataLineMsgRecord)localIterator.next();
                  long l = ((DataLineMsgRecord)localObject3).msgId;
                  if (l == paramLong) {
                    localObject1 = localObject3;
                  }
                }
                else {}
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public DataLineMsgSet a(int paramInt)
  {
    DataLineMsgSet localDataLineMsgSet2 = null;
    try
    {
      a();
      DataLineMsgSet localDataLineMsgSet1;
      if (paramInt == 0) {
        localDataLineMsgSet1 = null;
      }
      for (;;)
      {
        return localDataLineMsgSet1;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        do
        {
          localDataLineMsgSet1 = localDataLineMsgSet2;
          if (!localIterator.hasNext()) {
            break;
          }
          localDataLineMsgSet1 = (DataLineMsgSet)localIterator.next();
        } while ((localDataLineMsgSet1.isSingle()) || (localDataLineMsgSet1.getGroupId() != paramInt));
        if ((localDataLineMsgSet1 == null) && (this.b != null))
        {
          localIterator = this.b.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localDataLineMsgSet2 = (DataLineMsgSet)localIterator.next();
              if (!localDataLineMsgSet2.isSingle())
              {
                int i = localDataLineMsgSet2.getGroupId();
                if (i == paramInt)
                {
                  localDataLineMsgSet1 = localDataLineMsgSet2;
                  break;
                }
              }
            }
          }
        }
      }
    }
    finally {}
  }
  
  public DataLineMsgSet a(long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        a();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject4 == null) {
          return localObject3;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        Iterator localIterator;
        if (((Iterator)localObject4).hasNext())
        {
          localObject3 = (DataLineMsgSet)((Iterator)localObject4).next();
          localIterator = ((DataLineMsgSet)localObject3).values().iterator();
          if (localIterator.hasNext()) {
            if (((DataLineMsgRecord)localIterator.next()).sessionid == paramLong) {
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (this.b != null)
            {
              localObject4 = this.b.iterator();
              localObject3 = localObject1;
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (DataLineMsgSet)((Iterator)localObject4).next();
                localIterator = ((DataLineMsgSet)localObject3).values().iterator();
                if (localIterator.hasNext())
                {
                  long l = ((DataLineMsgRecord)localIterator.next()).sessionid;
                  if (l == paramLong) {
                    localObject1 = localObject3;
                  }
                }
                else {}
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public DataLineMsgSetList a()
  {
    try
    {
      a();
      DataLineMsgSetList localDataLineMsgSetList = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
      return localDataLineMsgSetList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DataLineMsgSetList a(boolean paramBoolean)
  {
    try
    {
      a();
      if ((this.b == null) && (paramBoolean)) {
        this.b = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.clone();
      }
      DataLineMsgSetList localDataLineMsgSetList = this.b;
      return localDataLineMsgSetList;
    }
    finally {}
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public Date a()
  {
    if (this.jdField_a_of_type_JavaUtilDate != null) {
      return this.jdField_a_of_type_JavaUtilDate;
    }
    return null;
  }
  
  public List a()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager, DataLineMsgRecord.tableName())) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(localEntityManager);
    }
    return localEntityManager.a(DataLineMsgRecord.class, " select * from " + DataLineMsgRecord.tableName() + " where (((issuc = 1 OR progress = 1.0) OR issend = 1 ) AND msgtype = " + -2000 + "  ) order by _id asc", null);
  }
  
  public List a(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      Iterator localIterator1;
      Iterator localIterator2;
      DataLineMsgRecord localDataLineMsgRecord;
      try
      {
        a();
        if (paramString == null)
        {
          paramString = null;
          return paramString;
        }
        localArrayList = new ArrayList();
        localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        if (localIterator1.hasNext())
        {
          localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
          if (!localIterator2.hasNext()) {
            continue;
          }
          localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
          if ((localDataLineMsgRecord.strMoloKey == null) || (!localDataLineMsgRecord.strMoloKey.equals(paramString))) {
            continue;
          }
          localArrayList.add(localDataLineMsgRecord);
          continue;
        }
        if (localArrayList.size() != 0) {
          break label227;
        }
      }
      finally {}
      if (this.b != null)
      {
        localIterator1 = this.b.iterator();
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label227;
          }
          localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
          if (localIterator2.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
            if ((localDataLineMsgRecord.strMoloKey == null) || (!localDataLineMsgRecord.strMoloKey.equals(paramString))) {
              break;
            }
            localArrayList.add(localDataLineMsgRecord);
          }
        }
      }
      label227:
      int i = localArrayList.size();
      if (i == 0) {
        paramString = null;
      } else {
        paramString = localArrayList;
      }
    }
  }
  
  protected void a()
  {
    for (;;)
    {
      EntityManager localEntityManager;
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject1 != null) {
          return;
        }
        localObject1 = DataLineMsgRecord.tableName();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localEntityManager.b("create index if not exists " + (String)localObject1 + "_index ON " + (String)localObject1 + "(groupId, msgId)");
        Object localObject3 = localEntityManager.a(DataLineMsgRecord.class, a(-1L, 15), null);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new ArrayList();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (DataLineMsgRecord)((Iterator)localObject1).next();
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.appendToList((DataLineMsgRecord)localObject3);
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label173;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      label173:
      localEntityManager.a();
    }
  }
  
  public void a(long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      d(paramLong);
      return;
    }
    new Handler(localLooper).post(new huf(this, paramLong));
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      localObject = a(paramLong);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("path", paramString);
      if (localObject != null) {
        a(DataLineMsgRecord.tableName(), localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
      return;
    }
    new Handler((Looper)localObject).post(new hud(this, paramLong, paramString));
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      localObject = a(paramLong);
      ContentValues localContentValues = new ContentValues();
      if (!TextUtils.isEmpty(paramString)) {
        localContentValues.put("serverPath", paramString);
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localContentValues.put("md5", paramArrayOfByte);
      }
      if (localObject != null) {
        a(DataLineMsgRecord.tableName(), localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
      return;
    }
    new Handler((Looper)localObject).post(new hue(this, paramLong, paramString, paramArrayOfByte));
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      paramEntity = ((DataLineMsgRecord)paramEntity).clone();
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, DataLineMsgRecord.tableName(), paramEntity, 0, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new htx(this, paramEntity, paramProxyListener, localWaitEvent));
    localWaitEvent.a(-1L);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new htz(this, paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener));
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new hua(this, paramString1, paramString2, paramArrayOfString, paramProxyListener));
  }
  
  public void a(Date paramDate)
  {
    this.jdField_a_of_type_JavaUtilDate = paramDate;
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 161	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +9 -> 19
    //   13: iconst_0
    //   14: istore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 161	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   23: lload_1
    //   24: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   27: invokeinterface 516 2 0
    //   32: istore_3
    //   33: goto -18 -> 15
    //   36: astore 4
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 4
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	DataLineMsgProxy
    //   0	43	1	paramLong	long
    //   14	19	3	bool	boolean
    //   6	3	4	localList	List
    //   36	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	36	finally
    //   19	33	36	finally
  }
  
  public boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.remove(paramDataLineMsgSet);; bool = false)
    {
      if (bool)
      {
        paramDataLineMsgSet = paramDataLineMsgSet.values().iterator();
        while (paramDataLineMsgSet.hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramDataLineMsgSet.next();
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(localDataLineMsgRecord.sessionid));
        }
      }
      return bool;
    }
  }
  
  public long b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      long l = c(paramDataLineMsgRecord);
      a(paramDataLineMsgRecord, null);
      return l;
    }
    new Handler(localLooper).post(new huc(this, paramDataLineMsgRecord, localWaitEvent));
    localWaitEvent.a(-1L);
    return 0L;
  }
  
  public DataLineMsgRecord b(long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        a();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject4 == null) {
          return localObject3;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        Iterator localIterator;
        if (((Iterator)localObject4).hasNext())
        {
          localIterator = ((DataLineMsgSet)((Iterator)localObject4).next()).values().iterator();
          if (localIterator.hasNext())
          {
            localObject3 = (DataLineMsgRecord)localIterator.next();
            if (((DataLineMsgRecord)localObject3).sessionid == paramLong) {
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (this.b != null)
            {
              localObject4 = this.b.iterator();
              localObject3 = localObject1;
              if (((Iterator)localObject4).hasNext())
              {
                localIterator = ((DataLineMsgSet)((Iterator)localObject4).next()).values().iterator();
                if (localIterator.hasNext())
                {
                  localObject3 = (DataLineMsgRecord)localIterator.next();
                  long l = ((DataLineMsgRecord)localObject3).sessionid;
                  if (l == paramLong) {
                    localObject1 = localObject3;
                  }
                }
                else {}
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public DataLineMsgSet b(long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        a();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject4 == null) {
          return localObject3;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        Iterator localIterator;
        if (((Iterator)localObject4).hasNext())
        {
          localObject3 = (DataLineMsgSet)((Iterator)localObject4).next();
          localIterator = ((DataLineMsgSet)localObject3).values().iterator();
          if (localIterator.hasNext()) {
            if (((DataLineMsgRecord)localIterator.next()).msgId == paramLong) {
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (this.b != null)
            {
              localObject4 = this.b.iterator();
              localObject3 = localObject1;
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (DataLineMsgSet)((Iterator)localObject4).next();
                localIterator = ((DataLineMsgSet)localObject3).values().iterator();
                if (localIterator.hasNext())
                {
                  long l = ((DataLineMsgRecord)localIterator.next()).msgId;
                  if (l == paramLong) {
                    localObject1 = localObject3;
                  }
                }
                else {}
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  protected void b() {}
  
  public void b(long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      e(paramLong);
      return;
    }
    new Handler(localLooper).post(new hug(this, paramLong));
  }
  
  public void c()
  {
    try
    {
      if (this.b != null) {
        this.b.clear();
      }
      this.b = null;
      return;
    }
    finally {}
  }
  
  public void c(long paramLong)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      localObject = a(paramLong);
      if (localObject != null)
      {
        ((DataLineMsgRecord)localObject).issuc = false;
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("issuc", Boolean.valueOf(false));
        a(DataLineMsgRecord.tableName(), localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
      return;
    }
    new Handler((Looper)localObject).post(new hty(this, paramLong));
  }
  
  public void d()
  {
    try
    {
      g();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    h();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    a(DataLineMsgRecord.tableName(), localContentValues, "isread=?", new String[] { "0" }, null);
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy
 * JD-Core Version:    0.7.0.1
 */