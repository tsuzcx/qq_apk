package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AbilityUtils;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import jpu;
import jpv;
import jpw;
import jpx;
import mqq.manager.Manager;

public class QCallFacade
  extends Observable
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = QCallFacade.class.getSimpleName();
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new jpv(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new jpu(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QCallFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
  }
  
  private long a(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface.a();
    return localBaseApplication.getSharedPreferences("voice_tab_time", 0).getLong(paramQQAppInterface, 0L);
  }
  
  private QCallRecent a(MessageForVideo paramMessageForVideo)
  {
    int i = 1;
    Object localObject = paramMessageForVideo.frienduin;
    long l = paramMessageForVideo.time;
    QCallRecent localQCallRecent = a().a((String)localObject, paramMessageForVideo.istroop);
    localQCallRecent.uin = ((String)localObject);
    localQCallRecent.type = paramMessageForVideo.istroop;
    localQCallRecent.sendFlag = paramMessageForVideo.issend;
    localQCallRecent.lastCallMsg = MsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessageForVideo.text);
    if (l > localQCallRecent.lastCallTime) {
      localQCallRecent.lastCallTime = l;
    }
    if ((localQCallRecent.type == 1000) || (localQCallRecent.type == 1020) || (localQCallRecent.type == 1004)) {
      localQCallRecent.troopUin = paramMessageForVideo.senderuin;
    }
    localQCallRecent.missedCallCount = c(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
    localObject = paramMessageForVideo.msg;
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 3)) {
        break label222;
      }
      if (!"1".equals(localObject[3])) {
        break label217;
      }
    }
    label217:
    label222:
    for (localQCallRecent.isVideo = i;; localQCallRecent.isVideo = 1)
    {
      localQCallRecent.isLastCallRealMissed = a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      return localQCallRecent;
      i = 0;
      break;
    }
  }
  
  private QCallRecord a(MessageForVideo paramMessageForVideo)
  {
    if ((paramMessageForVideo == null) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getMessageToCallRecord message is null");
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    setChanged();
    notifyObservers(Integer.valueOf(paramInt));
    if (a().a())
    {
      setChanged();
      notifyObservers(Boolean.valueOf(true));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("voice_tab_time", 0);
    if (!paramQQAppInterface.getBoolean("audio_tips_state", false)) {
      paramQQAppInterface.edit().putLong("login_success_time", paramLong).commit();
    }
  }
  
  private boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsRealMissed friendUin:" + paramString + ",uinType:" + paramInt);
    }
    paramString = a(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsRealMissed CallRecord count 0");
        bool2 = bool1;
      }
      return bool2;
    }
    paramInt = 0;
    for (;;)
    {
      bool1 = bool2;
      if (paramInt < paramString.size())
      {
        QCallRecord localQCallRecord = (QCallRecord)paramString.get(paramInt);
        if ((localQCallRecord == null) || (localQCallRecord.type != QCallRecord.TYPE_REALRECORD)) {
          break label184;
        }
        bool1 = bool2;
        if (localQCallRecord.isMissCall()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsRealMissed ret:" + bool1);
      return bool1;
      label184:
      paramInt += 1;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
  }
  
  private void b(QCallRecent paramQCallRecent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "save " + paramQCallRecent);
    }
    a().d(paramQCallRecent);
    if ((MsgProxyUtils.c(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  private int c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount friendUin:" + paramString + ",uinType:" + paramInt);
    }
    paramString = a(paramString, paramInt);
    int i;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount count 0");
      }
      i = 0;
    }
    do
    {
      return i;
      i = 0;
      int j;
      for (paramInt = 0; i < paramString.size(); paramInt = j)
      {
        QCallRecord localQCallRecord = (QCallRecord)paramString.get(i);
        j = paramInt;
        if (localQCallRecord != null)
        {
          j = paramInt;
          if (localQCallRecord.type == QCallRecord.TYPE_REALRECORD)
          {
            if (!localQCallRecord.isMissCall()) {
              break;
            }
            j = paramInt + 1;
          }
        }
        i += 1;
      }
      i = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getNewestMissCallCount count:" + paramInt);
    return paramInt;
  }
  
  private void c(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("voice_tab_time", 0).edit().putLong("merge_data_time", paramLong).commit();
  }
  
  private void c(QCallRecent paramQCallRecent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "save " + paramQCallRecent);
    }
    a().c(paramQCallRecent);
    if ((MsgProxyUtils.c(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  public int a()
  {
    Object localObject = a().a();
    if (localObject == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((List)localObject).iterator();
    int i = 0;
    long l1;
    label76:
    int j;
    if (((Iterator)localObject).hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        if (localQCallRecent.lastCallTime <= l1) {
          break label130;
        }
        if (!localQCallRecent.isMissedCall()) {
          break label123;
        }
        j = a(localQCallRecent.uin, localQCallRecent.type, l1);
        label110:
        i = j + i;
      }
    }
    label130:
    for (;;)
    {
      break;
      l1 = l2;
      break label76;
      label123:
      j = 0;
      break label110;
      return i;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = 0;
    paramString = a().b(paramString, paramInt);
    paramInt = i;
    if (paramString != null) {
      paramInt = paramString.state;
    }
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getMissCallRecordCount-->Wrong friendUin or UinType.uinType=" + paramInt + " time=" + paramLong);
      }
      return 0;
    }
    paramString = a().a(paramString, paramInt);
    paramInt = 0;
    int i = 0;
    if (paramInt < paramString.size())
    {
      QCallRecord localQCallRecord = (QCallRecord)paramString.get(paramInt);
      int j;
      if (localQCallRecord.type == QCallRecord.TYPE_DATE) {
        j = i;
      }
      for (;;)
      {
        paramInt += 1;
        i = j;
        break;
        if (!localQCallRecord.isMissCall()) {
          break label143;
        }
        j = i;
        if (localQCallRecord.time > paramLong) {
          j = i + 1;
        }
      }
    }
    label143:
    return i;
  }
  
  public QCallRecent a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public QCallProxy a()
  {
    b();
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = a().a();
    if (localObject1 == null) {
      return "";
    }
    int j = 0;
    int i = 0;
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QCallRecord localQCallRecord1 = null;
    localObject1 = ((List)localObject1).iterator();
    int k;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
      long l1;
      if (((QCallRecent)localObject2).readTime > l2) {
        l1 = ((QCallRecent)localObject2).readTime;
      }
      for (;;)
      {
        if ((((QCallRecent)localObject2).lastCallTime > l1) && (((QCallRecent)localObject2).isMissedCall()))
        {
          k = i + 1;
          if (((QCallRecent)localObject2).uin == null)
          {
            i = k;
            break;
            l1 = l2;
            continue;
          }
          localObject2 = a().a(((QCallRecent)localObject2).uin, ((QCallRecent)localObject2).type);
          int m = 0;
          i = j;
          if (m >= ((List)localObject2).size()) {
            break label456;
          }
          QCallRecord localQCallRecord2 = (QCallRecord)((List)localObject2).get(m);
          if (localQCallRecord2.type == QCallRecord.TYPE_DATE) {}
          for (;;)
          {
            label192:
            m += 1;
            break;
            if (!localQCallRecord2.isMissCall()) {
              break label456;
            }
            if (localQCallRecord2.time <= l1) {
              break label453;
            }
            if (i != 0) {
              break label450;
            }
            localQCallRecord1 = (QCallRecord)((List)localObject2).get(m);
            label238:
            i += 1;
          }
        }
      }
      k = i;
      i = j;
    }
    label450:
    label453:
    label456:
    for (j = k;; j = k)
    {
      k = j;
      j = i;
      i = k;
      break;
      localObject1 = new StringBuilder();
      if ((j == 1) || (i == 1)) {
        if (paramBoolean) {
          if (paramString != null) {
            ((StringBuilder)localObject1).append(paramString).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362794));
          }
        }
      }
      for (;;)
      {
        return ((StringBuilder)localObject1).toString();
        if (localQCallRecord1.isVideo())
        {
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362781));
        }
        else
        {
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362787));
          continue;
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362797, new Object[] { "" + i, "" + j }));
        }
      }
      break label238;
      break label192;
    }
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().a();
    if (localObject == null) {
      return localArrayList;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
      long l1;
      label84:
      int i;
      label131:
      QCallRecord localQCallRecord;
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        if ((localQCallRecent.lastCallTime <= l1) || (!localQCallRecent.isMissedCall()) || (localQCallRecent.uin == null)) {
          break label177;
        }
        List localList = a().a(localQCallRecent.uin, localQCallRecent.type);
        i = 0;
        if (i < localList.size())
        {
          localQCallRecord = (QCallRecord)localList.get(i);
          if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
            break label179;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label131;
        break;
        l1 = l2;
        break label84;
        label177:
        break;
        label179:
        if (!localQCallRecord.isMissCall()) {
          break;
        }
        if (localQCallRecord.time > l1)
        {
          if (localQCallRecent.type != 3000) {
            break label291;
          }
          localObject = MessageRecordFactory.a(-2016);
          ((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362878);
          ((MessageRecord)localObject).frienduin = localQCallRecent.troopUin;
          ((MessageRecord)localObject).msgtype = -2016;
          ((MessageRecord)localObject).senderuin = "";
          ((MessageRecord)localObject).istroop = localQCallRecent.type;
          ((MessageRecord)localObject).time = localQCallRecord.time;
          localArrayList.add(localObject);
        }
      }
      label291:
      localObject = MessageRecordFactory.a(-2009);
      ((MessageRecord)localObject).frienduin = localQCallRecent.uin;
      ((MessageRecord)localObject).msgtype = -2009;
      if (localQCallRecord.isVideo()) {}
      for (((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362876);; ((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362877))
      {
        ((MessageRecord)localObject).senderuin = localQCallRecord.senderuin;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "getMissCallMessageRecordList = list size" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public List a()
  {
    return a().a();
  }
  
  public List a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    return a().a(paramString, paramInt);
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
    if ((localList == null) || (localList.size() < 1)) {
      return;
    }
    QQMessageFacade localQQMessageFacade = (QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
    int i = 0;
    if (i < localList.size())
    {
      RecentUser localRecentUser = (RecentUser)localList.get(i);
      if (!AbilityUtils.a(localRecentUser.type)) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject = localQQMessageFacade.a(localRecentUser.uin, localRecentUser.type, new int[] { -2009 });
        if ((localObject != null) && (((List)localObject).size() >= 1) && (((MessageRecord)((List)localObject).get(0)).istroop != 1))
        {
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < ((List)localObject).size())
          {
            if ((((List)localObject).get(j) instanceof MessageForVideo))
            {
              MessageForVideo localMessageForVideo = (MessageForVideo)((List)localObject).get(j);
              localMessageForVideo.parse();
              localArrayList.add(localMessageForVideo);
              a(localMessageForVideo, false);
            }
            j += 1;
          }
          if (localArrayList.size() >= 1)
          {
            localObject = (MessageForVideo)localArrayList.get(localArrayList.size() - 1);
            if (QLog.isDevelopLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 4, String.format("handleDataMigration# add last msg from uin:%s->%s", new Object[] { localRecentUser.uin, ((MessageForVideo)localObject).toString() }));
            }
            a((MessageForVideo)localObject);
          }
        }
      }
    }
    c(System.currentTimeMillis());
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addQCallRecent issend=" + paramInt + ", discussId=" + paramLong + ", senderUin=" + paramString);
    }
    QCallRecent localQCallRecent = a().a(String.valueOf(paramLong), 3000);
    localQCallRecent.uin = String.valueOf(paramLong);
    localQCallRecent.lastCallTime = MessageCache.a();
    localQCallRecent.type = 3000;
    localQCallRecent.sendFlag = paramInt;
    localQCallRecent.troopUin = String.valueOf(paramLong);
    localQCallRecent.missedCallCount = c(String.valueOf(paramLong), 3000);
    if (paramInt == 1) {}
    for (localQCallRecent.state = 4;; localQCallRecent.state = 0)
    {
      localQCallRecent.senderUin = paramString;
      localQCallRecent.isLastCallRealMissed = a(String.valueOf(paramLong), 3000);
      b(localQCallRecent);
      return;
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateDissCall-->discussid=" + paramLong1 + " friendUin=" + paramLong2 + " b=" + paramBoolean1 + " time=" + paramLong3 + " isSend=" + paramBoolean2);
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    while ((((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(String.valueOf(paramLong1)) == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(paramLong2)))) {
      return;
    }
    QCallRecent localQCallRecent = a().a(String.valueOf(paramLong1), 3000);
    localQCallRecent.lastCallTime = MessageCache.a();
    if (paramBoolean1) {
      localQCallRecent.state = 1;
    }
    for (;;)
    {
      b(localQCallRecent);
      return;
      localQCallRecent.state = 3;
      localQCallRecent.time = paramLong3;
      if (paramLong3 > 0L)
      {
        localQCallRecord = new QCallRecord();
        localQCallRecord.friendUin = String.valueOf(paramLong1);
        localQCallRecord.isVideo = 0;
        localQCallRecord.time = MessageCache.a();
        localQCallRecord.talkTime = String.valueOf(paramLong3);
        localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
        localQCallRecord.uinType = 3000;
        if (paramBoolean2) {
          localQCallRecord.state = 4;
        }
        for (localQCallRecord.issend = 1;; localQCallRecord.issend = 0)
        {
          a().a(localQCallRecord);
          break;
          localQCallRecord.state = 3;
        }
      }
      QCallRecord localQCallRecord = new QCallRecord();
      localQCallRecord.friendUin = String.valueOf(paramLong1);
      localQCallRecord.issend = 1;
      localQCallRecord.isVideo = 0;
      localQCallRecord.time = MessageCache.a();
      localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
      localQCallRecord.state = 4;
      localQCallRecord.uinType = 3000;
      a().a(localQCallRecord);
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo)
  {
    paramMessageForVideo.parse();
    paramMessageForVideo = a(paramMessageForVideo);
    b(paramMessageForVideo);
    if ((paramMessageForVideo != null) && (paramMessageForVideo.type == 3000))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramMessageForVideo.isSend()) {}
      for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004067", "0X8004067", 0, 0, paramMessageForVideo, "", "", "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMessageForVideo.isSend()) {}
    for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_count", 0, 0, paramMessageForVideo, "", "", "");
      return;
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo, boolean paramBoolean)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord updateRecentMissedCallCount: msg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord updateRecentMissedCallCount:" + paramBoolean + ", msg :" + paramMessageForVideo.toString());
    }
    Object localObject = a(paramMessageForVideo);
    a().a((QCallRecord)localObject);
    if (paramBoolean)
    {
      localObject = a().b(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      if (localObject != null)
      {
        ((QCallRecent)localObject).missedCallCount = c(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "insertCallRecord QCallRecent update MissCallCount" + ((QCallRecent)localObject).missedCallCount);
        }
        ((QCallRecent)localObject).isLastCallRealMissed = a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        b((QCallRecent)localObject);
      }
    }
    setChanged();
    notifyObservers(a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop));
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent == null) {
      return;
    }
    a().a(paramQCallRecent);
    a(-1);
  }
  
  public void a(String paramString)
  {
    b(paramString, 0);
    b(paramString, 1000);
    b(paramString, 1020);
    b(paramString, 1004);
    b(paramString, 1024);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = a().b(paramString, paramInt);
    if (paramString == null) {
      return;
    }
    paramString.readTime = MessageCache.a();
    b(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateDoubleCallStatus ,peerUin :" + paramString + ", uintype : " + paramInt1 + ", status=" + paramInt2);
    }
    if ((paramInt1 == 1011) || (paramInt1 == -1)) {}
    do
    {
      FriendManager localFriendManager;
      do
      {
        do
        {
          return;
          if ((paramInt1 != 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
            break;
          }
          localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        } while ((localFriendManager != null) && (!localFriendManager.b(paramString)));
        if ((paramInt1 != 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      } while ((localFriendManager != null) && (!localFriendManager.b(paramString)));
    } while ((paramString == null) || ((paramInt1 == 3000) && (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString) == null)));
    paramString = a().a(paramString, paramInt1);
    paramString.lastCallTime = MessageCache.a();
    paramString.state = paramInt2;
    if (paramInt2 == 0)
    {
      b(paramString);
      return;
    }
    c(paramString);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateDoubleCallStatus ,peerUin :" + paramString1 + ", uintype : " + paramInt1 + ", status=" + paramInt4 + ", extraType =" + paramInt2 + ", bindType = " + paramInt3 + ", bindId = " + paramString2);
    }
    if ((paramInt1 == 1011) || (paramInt1 == -1)) {}
    do
    {
      FriendManager localFriendManager;
      do
      {
        return;
        if ((paramInt1 != 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      } while ((localFriendManager != null) && (!localFriendManager.b(paramString1)));
    } while ((paramString1 == null) || ((paramInt1 == 3000) && (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString1) == null)));
    paramString1 = a().a(paramString1, paramInt1);
    paramString1.lastCallTime = MessageCache.a();
    paramString1.state = paramInt4;
    paramString1.extraType = paramInt2;
    paramString1.bindId = paramString2;
    paramString1.bindType = paramInt3;
    if (paramInt4 == 0)
    {
      b(paramString1);
      return;
    }
    c(paramString1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    QCallProxy localQCallProxy = a();
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).uinType = paramInt1;
    ((QCallRecord)localObject).contactId = paramInt2;
    ((QCallRecord)localObject).friendUin = paramString;
    ((QCallRecord)localObject).time = paramLong;
    localQCallProxy.a((QCallRecord)localObject);
    localObject = localQCallProxy.a(paramString, paramInt1);
    ((QCallRecent)localObject).uin = paramString;
    ((QCallRecent)localObject).type = paramInt1;
    if (paramLong > ((QCallRecent)localObject).lastCallTime) {
      ((QCallRecent)localObject).lastCallTime = paramLong;
    }
    ((QCallRecent)localObject).contactId = paramInt2;
    ((QCallRecent)localObject).isSystemCall = 1;
    ((QCallRecent)localObject).sendFlag = 1;
    localQCallProxy.d((QCallRecent)localObject);
    notifyObservers(a(paramString, paramInt1));
    setChanged();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a().a(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateLightalkSig ,peerUin :" + paramString + ", sig = " + paramArrayOfByte);
    }
    HexUtil.a(jdField_a_of_type_JavaLangString, paramArrayOfByte);
    paramString = a().a(paramString, paramInt);
    paramString.lightalkSig = paramArrayOfByte;
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "addMissCallMsg 2 discussId=" + paramString1 + ", senderUin=" + paramString2);
      }
      Object localObject = new QCallRecord();
      ((QCallRecord)localObject).friendUin = String.valueOf(paramString1);
      ((QCallRecord)localObject).issend = 0;
      ((QCallRecord)localObject).isVideo = 0;
      ((QCallRecord)localObject).time = MessageCache.a();
      ((QCallRecord)localObject).type = QCallRecord.TYPE_REALRECORD;
      ((QCallRecord)localObject).state = 2;
      ((QCallRecord)localObject).uinType = 3000;
      a().a((QCallRecord)localObject);
      localObject = a().a(String.valueOf(paramString1), 3000);
      ((QCallRecent)localObject).uin = String.valueOf(paramString1);
      ((QCallRecent)localObject).lastCallTime = MessageCache.a();
      ((QCallRecent)localObject).type = 3000;
      ((QCallRecent)localObject).sendFlag = 0;
      ((QCallRecent)localObject).troopUin = String.valueOf(paramString1);
      ((QCallRecent)localObject).state = 2;
      ((QCallRecent)localObject).missedCallCount = c(paramString1, 3000);
      ((QCallRecent)localObject).senderUin = paramString2;
      ((QCallRecent)localObject).isLastCallRealMissed = a(paramString1, 3000);
      b((QCallRecent)localObject);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new jpw(this));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    if ((paramString1 == null) || (paramString2 == null))
    {
      if (QLog.isColorLevel())
      {
        paramString3 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("isDiscussId==null");
        if (paramString1 != null) {
          break label80;
        }
        bool1 = true;
        paramString1 = localStringBuilder.append(bool1).append(" isPeerUin==null");
        if (paramString2 != null) {
          break label86;
        }
      }
      label80:
      label86:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        QLog.e(paramString3, 2, bool1);
        return;
        bool1 = false;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addMissCallMsg discussId=" + paramString1 + ", peerUin=" + paramString2 + ", senderUin=" + paramString3);
    }
    paramString2 = new QCallRecord();
    paramString2.friendUin = String.valueOf(paramString1);
    paramString2.issend = 0;
    paramString2.isVideo = 0;
    paramString2.time = MessageCache.a();
    paramString2.type = QCallRecord.TYPE_REALRECORD;
    paramString2.state = 2;
    paramString2.uinType = 3000;
    a().a(paramString2);
    paramString2 = a().a(String.valueOf(paramString1), 3000);
    paramString2.uin = String.valueOf(paramString1);
    paramString2.lastCallTime = MessageCache.a();
    paramString2.type = 3000;
    paramString2.sendFlag = 0;
    paramString2.troopUin = String.valueOf(paramString1);
    paramString2.state = 2;
    paramString2.missedCallCount = c(paramString1, 3000);
    paramString2.senderUin = paramString3;
    paramString2.isLastCallRealMissed = a(paramString1, 3000);
    b(paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    a().a(paramBoolean);
  }
  
  public boolean a()
  {
    return a().a();
  }
  
  public int b()
  {
    Object localObject1 = a().a();
    if (localObject1 == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    long l1;
    label77:
    int j;
    int i;
    label127:
    QCallRecord localQCallRecord;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
        if (((QCallRecent)localObject2).readTime > l2)
        {
          l1 = ((QCallRecent)localObject2).readTime;
          if ((((QCallRecent)localObject2).lastCallTime <= l1) || (!((QCallRecent)localObject2).isMissedCall()) || (((QCallRecent)localObject2).uin == null)) {
            break label176;
          }
          localObject2 = a().a(((QCallRecent)localObject2).uin, ((QCallRecent)localObject2).type);
          j = 0;
          i = k;
          k = i;
          if (j >= ((List)localObject2).size()) {
            continue;
          }
          localQCallRecord = (QCallRecord)((List)localObject2).get(j);
          if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
            break label178;
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label127;
      l1 = l2;
      break label77;
      label176:
      break;
      label178:
      k = i;
      if (!localQCallRecord.isMissCall()) {
        break;
      }
      if (localQCallRecord.time > l1)
      {
        i += 1;
        continue;
        return k;
      }
    }
  }
  
  public int b(String paramString, int paramInt)
  {
    Object localObject1 = a().a();
    if (localObject1 == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    long l1;
    label99:
    int j;
    int i;
    label143:
    QCallRecord localQCallRecord;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
        if ((paramString.equals(((QCallRecent)localObject2).uin)) && (paramInt == ((QCallRecent)localObject2).type)) {
          if (((QCallRecent)localObject2).readTime > l2)
          {
            l1 = ((QCallRecent)localObject2).readTime;
            if ((((QCallRecent)localObject2).lastCallTime <= l1) || (!((QCallRecent)localObject2).isMissedCall()) || (((QCallRecent)localObject2).uin == null)) {
              break label197;
            }
            localObject2 = a().a(paramString, paramInt);
            j = 0;
            i = k;
            k = i;
            if (j >= ((List)localObject2).size()) {
              continue;
            }
            localQCallRecord = (QCallRecord)((List)localObject2).get(j);
            if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
              break label199;
            }
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label143;
      l1 = l2;
      break label99;
      label197:
      break;
      label199:
      k = i;
      if (!localQCallRecord.isMissCall()) {
        break;
      }
      if (localQCallRecord.time > l1)
      {
        i += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "getMissCallMessageRecordList someuin count" + k);
        }
        return k;
      }
    }
  }
  
  public void b(int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addQCallRecentAndCallRecord issend=" + paramInt + ", discussId=" + paramLong + ", senderUin=" + paramString);
    }
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).friendUin = String.valueOf(paramLong);
    ((QCallRecord)localObject).issend = paramInt;
    ((QCallRecord)localObject).isVideo = 0;
    ((QCallRecord)localObject).time = MessageCache.a();
    ((QCallRecord)localObject).type = QCallRecord.TYPE_REALRECORD;
    if (paramInt == 1)
    {
      ((QCallRecord)localObject).state = 4;
      ((QCallRecord)localObject).uinType = 3000;
      a().a((QCallRecord)localObject);
      localObject = a().a(String.valueOf(paramLong), 3000);
      ((QCallRecent)localObject).uin = String.valueOf(paramLong);
      ((QCallRecent)localObject).lastCallTime = MessageCache.a();
      ((QCallRecent)localObject).type = 3000;
      ((QCallRecent)localObject).sendFlag = paramInt;
      ((QCallRecent)localObject).troopUin = String.valueOf(paramLong);
      ((QCallRecent)localObject).missedCallCount = c(String.valueOf(paramLong), 3000);
      if (paramInt != 1) {
        break label250;
      }
    }
    label250:
    for (((QCallRecent)localObject).state = 4;; ((QCallRecent)localObject).state = 3)
    {
      ((QCallRecent)localObject).senderUin = paramString;
      ((QCallRecent)localObject).isLastCallRealMissed = a(String.valueOf(paramLong), 3000);
      b((QCallRecent)localObject);
      return;
      ((QCallRecord)localObject).state = 3;
      break;
    }
  }
  
  public void b(long paramLong)
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localBaseApplication.getSharedPreferences("voice_tab_time", 0).edit().putLong(str, paramLong).commit();
  }
  
  public void b(String paramString)
  {
    int k = 0;
    Object localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    int i;
    label57:
    int j;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
          break label150;
        }
        i = 1;
        if ((i == 0) || (((PhoneContact)localObject).uin.equals("0"))) {
          break label155;
        }
        j = 1;
        label77:
        if ((j != 0) && (localFriendsManager != null)) {
          break label160;
        }
        paramString = null;
        label88:
        if ((paramString == null) || (!paramString.isFriend())) {
          break label174;
        }
        j = 1;
        label101:
        if (j == 0) {
          break label179;
        }
        paramString = ((PhoneContact)localObject).uin;
        i = k;
      }
    }
    for (;;)
    {
      long l = System.currentTimeMillis() / 1000L;
      a(paramString, i, ((PhoneContact)localObject).contactID, l);
      return;
      localObject = ((PhoneContactManager)localObject).c(paramString);
      break;
      label150:
      i = 0;
      break label57;
      label155:
      j = 0;
      break label77;
      label160:
      paramString = localFriendsManager.c(((PhoneContact)localObject).uin);
      break label88;
      label174:
      j = 0;
      break label101;
      label179:
      if (i != 0)
      {
        paramString = ((PhoneContact)localObject).mobileCode;
        i = 1006;
      }
      else
      {
        paramString = ((PhoneContact)localObject).mobileNo;
        i = 56938;
      }
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return;
      localObject = a().b(paramString, paramInt);
      if (localObject != null) {
        a((QCallRecent)localObject);
      }
      c(paramString, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new jpx(this));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while ((paramString == null) || (localObject == null));
    BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString.e() + ((QCallFacade)localObject).a());
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("voice_tab_time", 0).edit().putBoolean("audio_tips_state", paramBoolean).commit();
  }
  
  public int c()
  {
    Object localObject = a().a();
    if (localObject == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((List)localObject).iterator();
    int i = 0;
    long l1;
    if (((Iterator)localObject).hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        label76:
        if ((localQCallRecent.lastCallTime <= l1) || (!localQCallRecent.isMissedCall())) {
          break label109;
        }
        i += 1;
      }
    }
    label109:
    for (;;)
    {
      break;
      l1 = l2;
      break label76;
      return i;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clearAllRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    a().a(paramString, paramInt);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallFacade
 * JD-Core Version:    0.7.0.1
 */