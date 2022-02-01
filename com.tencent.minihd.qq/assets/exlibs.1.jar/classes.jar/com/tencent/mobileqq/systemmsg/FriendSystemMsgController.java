package com.tencent.mobileqq.systemmsg;

import MessageSvcPack.UinPairReadInfo;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.FriendSystemMsgOldData;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jye;
import jyf;
import jyg;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class FriendSystemMsgController
  implements SystemMsgUiActionInterface
{
  private static FriendSystemMsgController jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController;
  private static final int jdField_b_of_type_Int = -1001;
  private static final int jdField_c_of_type_Int = 5000;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new jyf(this, Looper.getMainLooper());
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = FriendSystemMsgController.class.getName();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString = null;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
  public static FriendSystemMsgController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController == null) {
      jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController = new FriendSystemMsgController();
    }
    return jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController;
  }
  
  private int b(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_friend_system_msg", 0);
    }
    return i;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = b(paramQQAppInterface);
    }
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    structmsg.StructMsg localStructMsg = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      localStructMsg = (structmsg.StructMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
    }
    return localStructMsg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    long l = 0L;
    try
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong1))) {
        l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1))).longValue();
      }
      if (l >= paramLong2) {
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "addSystemMsgOldData " + paramLong1 + " " + paramLong2);
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      if (paramQQAppInterface == null) {
        return;
      }
    }
    finally {}
    FriendSystemMsgOldData localFriendSystemMsgOldData = new FriendSystemMsgOldData();
    localFriendSystemMsgOldData.uin = paramLong1;
    localFriendSystemMsgOldData.msgtime = paramLong2;
    paramQQAppInterface.b(localFriendSystemMsgOldData);
    paramQQAppInterface.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ((NewFriendManager)paramQQAppInterface.getManager(33)).a(new NewFriendMessage(1, 0));
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    QCallFacade localQCallFacade;
    if (localQQMessageFacade != null)
    {
      localQCallFacade = paramQQAppInterface.a();
      if (localQCallFacade == null) {
        break label66;
      }
    }
    label66:
    for (int i = localQCallFacade.a();; i = 0)
    {
      int j = localQQMessageFacade.e();
      BadgeUtils.a(paramQQAppInterface.a(), i + j);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramQQAppInterface.a(new jye(this, paramQQAppInterface, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((paramQQAppInterface != null) && (paramLong <= 0L)) {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, long paramLong)
  {
    QCallFacade localQCallFacade;
    if (this.jdField_a_of_type_Int > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "pushFriendSystemUnreadMessage|msgTabDisplay|msgTime|unreadFriendSystemMsgNum " + paramString + " " + paramLong);
      }
      paramString = new FriendSystemMessage(this.jdField_a_of_type_Int, paramString, paramLong);
      paramString.jdField_a_of_type_Boolean = paramBoolean;
      ((NewFriendManager)paramQQAppInterface.getManager(33)).a(paramString);
      paramString = paramQQAppInterface.a();
      if (paramString != null)
      {
        localQCallFacade = paramQQAppInterface.a();
        if (localQCallFacade == null) {
          break label186;
        }
      }
    }
    label186:
    for (int i = localQCallFacade.a();; i = 0)
    {
      int j = paramString.e();
      BadgeUtils.a(paramQQAppInterface.a(), i + j);
      if ((!paramBoolean) && (NewFriendManager.a(paramQQAppInterface))) {
        NewFriendManager.a(paramQQAppInterface, false);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "pushFriendSystemUnreadMessage unreadFriendSystemMsgNum = 0");
      }
      ((NewFriendManager)paramQQAppInterface.getManager(33)).a(new NewFriendMessage(1, 0, paramBoolean));
      break;
    }
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "putStructMsgToMap key=" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, paramStructMsg);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.d = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.a();
    paramQQAppInterface.a(new jyg(this, paramQQAppInterface, paramBoolean));
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(MessageHandler paramMessageHandler)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "checkHoldSystemMsg mListViewIsScroll");
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long < 5000L)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "checkHoldSystemMsg distance limit");
        }
        this.jdField_b_of_type_Boolean = true;
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(-1001))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-1001, 5000L);
        }
      }
      else
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(paramQQAppInterface.a()))) {
      this.d = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("friend_system_msg_nomore_msg", false);
    }
    return this.d;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.a(FriendSystemMsgOldData.class, false, null, null, null, null, "msgtime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FriendSystemMsgOldData localFriendSystemMsgOldData = (FriendSystemMsgOldData)((Iterator)localObject).next();
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localFriendSystemMsgOldData.uin), Long.valueOf(localFriendSystemMsgOldData.msgtime));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initSystemMsgOldData " + localFriendSystemMsgOldData.uin + " " + localFriendSystemMsgOldData.msgtime);
        }
      }
    }
    paramQQAppInterface.a();
  }
  
  public boolean b(MessageHandler paramMessageHandler)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = null;
    jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController = null;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilHashMap == null) {
        return;
      }
      localObject2 = this.jdField_b_of_type_JavaUtilHashMap.keySet();
      if (localObject2 == null) {
        return;
      }
    }
    Object localObject2 = ((Set)localObject2).iterator();
    if (localObject2 == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    while (((Iterator)localObject2).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject2).next();
      localArrayList.add(new UinPairReadInfo(localLong.longValue(), ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(localLong)).longValue(), 0L, null));
    }
    if (localArrayList.size() > 0)
    {
      ((C2CMessageProcessor)paramQQAppInterface.a().a("c2c_processor")).b(localArrayList);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "sendSystemMsgOldDataReadConfirm " + this.jdField_b_of_type_JavaUtilHashMap.toString());
      }
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(FriendSystemMsgOldData.class);
        paramQQAppInterface.a();
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.FriendSystemMsgController
 * JD-Core Version:    0.7.0.1
 */