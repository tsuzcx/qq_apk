package com.tencent.mobileqq.app.message;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.widget.WidgetConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import htj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public class QQMessageFacade
  extends Observable
  implements Manager
{
  public static final int a = 1;
  public static final String a = "dataline_manager";
  public static final boolean a = true;
  public static final int b = 2;
  public static final String b = "notification";
  public static final int c = 3;
  public static final int d = 4;
  private static final String jdField_d_of_type_JavaLangString = "table_last_clip_time";
  public static final int e = 2;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  private static final int l = 5000;
  private static final int m = 90;
  private static final int n = 8;
  public Handler a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseMessageManager jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private QQMessageFacade.Message jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public final List a;
  public final Map a;
  public final ConcurrentHashMap a;
  public final AtomicInteger a;
  private BaseMessageManager jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  public Map b;
  public final ConcurrentHashMap b;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private BaseMessageManager jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private String jdField_c_of_type_JavaLangString = null;
  private Map jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private BaseMessageManager jdField_d_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
  private final String e = "Q.msg.QQMessageFacade";
  private int k = -1;
  private volatile int o = -1;
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(paramQQAppInterface);
    a();
  }
  
  private int a(int paramInt)
  {
    int i3 = 0;
    int i1 = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    int i2 = i1;
    if (localObject != null)
    {
      if (((Set)localObject).isEmpty()) {
        i2 = i1;
      }
    }
    else {
      return i2;
    }
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("getUnreadMsgsNum type=" + paramInt + "{");; localStringBuilder = null)
    {
      localObject = ((Set)localObject).iterator();
      i1 = i3;
      while (((Iterator)localObject).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
        if ((!localConversationInfo.uin.equalsIgnoreCase(AppConstants.ap)) && (!WidgetConstants.a(localConversationInfo.uin, localConversationInfo.type)) && ((!AppConstants.as.equals(localConversationInfo.uin)) || (localConversationInfo.type != 9001)))
        {
          i2 = a(localConversationInfo.type).a(paramInt, localConversationInfo);
          if ((QLog.isColorLevel()) && (localStringBuilder != null) && (i2 > 0)) {
            localStringBuilder.append("[" + localConversationInfo.uin + "," + localConversationInfo.type + "," + i2 + "]");
          }
          i1 += i2;
        }
      }
      i2 = i1;
      if (!QLog.isColorLevel()) {
        break;
      }
      i2 = i1;
      if (localStringBuilder == null) {
        break;
      }
      i2 = i1;
      if (i1 <= 0) {
        break;
      }
      localStringBuilder.append("}");
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
      return i1;
    }
  }
  
  private int a(List paramList, QQMessageFacade.Message paramMessage)
  {
    int i2;
    if ((paramList == null) || (paramMessage == null))
    {
      i2 = -1;
      return i2;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramList.size()) {
        break label54;
      }
      i2 = i1;
      if (a((QQMessageFacade.Message)paramList.get(i1), paramMessage)) {
        break;
      }
      i1 += 1;
    }
    label54:
    return -1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l1 = 0L;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramString, paramInt);
      l1 = localMessage.shmsgseq;
      if (localMessage.isLongMsg())
      {
        paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
          l1 = Math.max(l1, ((MessageRecord)paramQQAppInterface.get(paramQQAppInterface.size() - 1)).shmsgseq);
        }
      }
    }
    else
    {
      return l1;
    }
    return l1;
  }
  
  private MsgProxy a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
  }
  
  private QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return a(paramInt).a(paramString, paramInt, paramEntityManager);
  }
  
  /* Error */
  private void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 103	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 136	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   7: invokevirtual 297	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   10: invokevirtual 302	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	()Ljava/util/List;
    //   13: invokeinterface 303 1 0
    //   18: astore 8
    //   20: iconst_0
    //   21: istore_3
    //   22: iconst_0
    //   23: istore 4
    //   25: aload 8
    //   27: invokeinterface 187 1 0
    //   32: ifeq +422 -> 454
    //   35: aload 8
    //   37: invokeinterface 191 1 0
    //   42: checkcast 305	com/tencent/mobileqq/data/RecentUser
    //   45: astore 9
    //   47: iload 4
    //   49: iconst_1
    //   50: iadd
    //   51: istore 7
    //   53: iload_3
    //   54: istore 6
    //   56: iload 7
    //   58: istore 5
    //   60: aload 9
    //   62: getfield 308	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   65: lload_1
    //   66: lcmp
    //   67: ifle +377 -> 444
    //   70: aload 9
    //   72: getfield 309	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   75: getstatic 312	com/tencent/mobileqq/app/AppConstants:aa	Ljava/lang/String;
    //   78: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +103 -> 184
    //   84: invokestatic 317	com/tencent/mobileqq/managers/TroopAssistantManager:a	()Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   87: aload_0
    //   88: getfield 103	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   91: invokevirtual 320	com/tencent/mobileqq/managers/TroopAssistantManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   94: invokeinterface 303 1 0
    //   99: astore 9
    //   101: iload 7
    //   103: iconst_1
    //   104: isub
    //   105: istore 4
    //   107: aload 9
    //   109: invokeinterface 187 1 0
    //   114: ifeq +67 -> 181
    //   117: aload 9
    //   119: invokeinterface 191 1 0
    //   124: checkcast 322	com/tencent/mobileqq/data/TroopAssistantData
    //   127: astore 10
    //   129: iload 4
    //   131: iconst_1
    //   132: iadd
    //   133: istore 5
    //   135: iload 5
    //   137: istore 4
    //   139: aload 10
    //   141: getfield 323	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
    //   144: lload_1
    //   145: lcmp
    //   146: ifle -39 -> 107
    //   149: iload_3
    //   150: iconst_1
    //   151: iadd
    //   152: istore_3
    //   153: aload_0
    //   154: getfield 75	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   157: aload 10
    //   159: getfield 326	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   162: iconst_1
    //   163: invokestatic 330	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   166: iconst_1
    //   167: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokevirtual 340	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: iload 5
    //   176: istore 4
    //   178: goto -71 -> 107
    //   181: goto -156 -> 25
    //   184: aload 9
    //   186: getfield 309	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   189: aload 9
    //   191: getfield 341	com/tencent/mobileqq/data/RecentUser:type	I
    //   194: invokestatic 344	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   197: ifeq +115 -> 312
    //   200: iload 7
    //   202: iconst_1
    //   203: isub
    //   204: istore 4
    //   206: aload_0
    //   207: aload 9
    //   209: getfield 309	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   212: aload 9
    //   214: getfield 341	com/tencent/mobileqq/data/RecentUser:type	I
    //   217: invokevirtual 274	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Ljava/util/List;
    //   220: invokeinterface 303 1 0
    //   225: astore 9
    //   227: aload 9
    //   229: invokeinterface 187 1 0
    //   234: ifeq +75 -> 309
    //   237: aload 9
    //   239: invokeinterface 191 1 0
    //   244: checkcast 276	com/tencent/mobileqq/data/MessageRecord
    //   247: astore 10
    //   249: iload 4
    //   251: iconst_1
    //   252: iadd
    //   253: istore 5
    //   255: iload 5
    //   257: istore 4
    //   259: aload 10
    //   261: getfield 347	com/tencent/mobileqq/data/MessageRecord:time	J
    //   264: lload_1
    //   265: lcmp
    //   266: ifle -39 -> 227
    //   269: iload_3
    //   270: iconst_1
    //   271: iadd
    //   272: istore_3
    //   273: aload_0
    //   274: getfield 75	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   277: aload 10
    //   279: getfield 350	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   282: aload 10
    //   284: getfield 353	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   287: invokestatic 330	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   290: aload 10
    //   292: getfield 353	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   295: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: invokevirtual 340	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: iload 5
    //   304: istore 4
    //   306: goto -79 -> 227
    //   309: goto -128 -> 181
    //   312: iload_3
    //   313: istore 4
    //   315: aload 9
    //   317: getfield 309	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   320: invokestatic 358	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   323: invokevirtual 362	java/lang/Long:longValue	()J
    //   326: ldc2_w 363
    //   329: lcmp
    //   330: ifle +46 -> 376
    //   333: iload_3
    //   334: iconst_1
    //   335: iadd
    //   336: istore_3
    //   337: iload_3
    //   338: istore 4
    //   340: aload_0
    //   341: getfield 75	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   344: aload 9
    //   346: getfield 309	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   349: aload 9
    //   351: getfield 341	com/tencent/mobileqq/data/RecentUser:type	I
    //   354: invokestatic 330	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   357: aload 9
    //   359: getfield 341	com/tencent/mobileqq/data/RecentUser:type	I
    //   362: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: invokevirtual 340	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: pop
    //   369: iload 7
    //   371: istore 4
    //   373: goto -192 -> 181
    //   376: iload 7
    //   378: iconst_1
    //   379: isub
    //   380: istore 4
    //   382: goto -9 -> 373
    //   385: astore 9
    //   387: iload 7
    //   389: iconst_1
    //   390: isub
    //   391: istore_3
    //   392: aload 9
    //   394: invokevirtual 367	java/lang/NumberFormatException:printStackTrace	()V
    //   397: iload 4
    //   399: istore 6
    //   401: iload_3
    //   402: istore 5
    //   404: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +37 -> 444
    //   410: ldc 88
    //   412: iconst_2
    //   413: new 159	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   420: ldc_w 369
    //   423: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 9
    //   428: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: iload_3
    //   438: istore 5
    //   440: iload 4
    //   442: istore 6
    //   444: iload 6
    //   446: istore_3
    //   447: iload 5
    //   449: istore 4
    //   451: goto -270 -> 181
    //   454: iload_3
    //   455: iload 4
    //   457: if_icmpne +173 -> 630
    //   460: aload_0
    //   461: getfield 75	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   464: invokevirtual 375	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   467: astore 10
    //   469: aload_0
    //   470: getfield 103	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   473: invokevirtual 378	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   476: astore 8
    //   478: aload 8
    //   480: ldc_w 380
    //   483: aconst_null
    //   484: invokevirtual 385	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   487: astore 9
    //   489: aload 9
    //   491: ifnull +140 -> 631
    //   494: aload 9
    //   496: astore 8
    //   498: aload 9
    //   500: invokeinterface 390 1 0
    //   505: ifeq +126 -> 631
    //   508: aload 9
    //   510: astore 8
    //   512: aload 9
    //   514: iconst_0
    //   515: invokeinterface 394 2 0
    //   520: invokestatic 399	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   523: astore 11
    //   525: aload 9
    //   527: astore 8
    //   529: aload 10
    //   531: aload 11
    //   533: invokeinterface 402 2 0
    //   538: ifne -44 -> 494
    //   541: aload 9
    //   543: astore 8
    //   545: aload_0
    //   546: getfield 75	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   549: aload 11
    //   551: aload 11
    //   553: invokestatic 406	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   556: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   559: invokevirtual 340	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   562: pop
    //   563: goto -69 -> 494
    //   566: astore 10
    //   568: aload 9
    //   570: astore 8
    //   572: aload 10
    //   574: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   577: aload 9
    //   579: astore 8
    //   581: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   584: ifeq +34 -> 618
    //   587: aload 9
    //   589: astore 8
    //   591: ldc 88
    //   593: iconst_2
    //   594: new 159	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 369
    //   604: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload 10
    //   609: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload 9
    //   620: ifnull +10 -> 630
    //   623: aload 9
    //   625: invokeinterface 410 1 0
    //   630: return
    //   631: aload 9
    //   633: ifnull -3 -> 630
    //   636: aload 9
    //   638: invokeinterface 410 1 0
    //   643: return
    //   644: astore 9
    //   646: aconst_null
    //   647: astore 8
    //   649: aload 8
    //   651: ifnull +10 -> 661
    //   654: aload 8
    //   656: invokeinterface 410 1 0
    //   661: aload 9
    //   663: athrow
    //   664: astore 9
    //   666: goto -17 -> 649
    //   669: astore 10
    //   671: aconst_null
    //   672: astore 9
    //   674: goto -106 -> 568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	QQMessageFacade
    //   0	677	1	paramLong	long
    //   21	437	3	i1	int
    //   23	435	4	i2	int
    //   58	390	5	i3	int
    //   54	391	6	i4	int
    //   51	340	7	i5	int
    //   18	637	8	localObject1	Object
    //   45	313	9	localObject2	Object
    //   385	42	9	localNumberFormatException	java.lang.NumberFormatException
    //   487	150	9	localCursor	Cursor
    //   644	18	9	localObject3	Object
    //   664	1	9	localObject4	Object
    //   672	1	9	localObject5	Object
    //   127	403	10	localObject6	Object
    //   566	42	10	localException1	Exception
    //   669	1	10	localException2	Exception
    //   523	29	11	str	String
    // Exception table:
    //   from	to	target	type
    //   315	333	385	java/lang/NumberFormatException
    //   340	369	385	java/lang/NumberFormatException
    //   498	508	566	java/lang/Exception
    //   512	525	566	java/lang/Exception
    //   529	541	566	java/lang/Exception
    //   545	563	566	java/lang/Exception
    //   478	489	644	finally
    //   498	508	664	finally
    //   512	525	664	finally
    //   529	541	664	finally
    //   545	563	664	finally
    //   572	577	664	finally
    //   581	587	664	finally
    //   591	618	664	finally
    //   478	489	669	java/lang/Exception
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    if (!AnonymousChatHelper.a(paramMessageRecord)) {
      paramMessageRecord.vipBubbleID = paramString.e();
    }
  }
  
  private void a(List paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("addMultiMessagesInner size = ");
      if (paramList != null) {
        break label105;
      }
    }
    label105:
    for (int i1 = 0;; i1 = paramList.size())
    {
      a(i1 + " sync = " + paramBoolean1 + " saveToDB = " + paramBoolean2 + " needUpdateUnread = " + paramBoolean3 + " needAddAIO = " + paramBoolean4, null);
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
      return;
    }
    BaseMessageManager.AddMessageContext localAddMessageContext = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l2 = paramList.size();
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      a(((MessageRecord)localObject2).istroop).a((MessageRecord)localObject2, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, localAddMessageContext);
    }
    paramEntityManager = localAddMessageContext.e.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject1 = (String)paramEntityManager.next();
      TroopBarAssistantManager.a().a((MessageRecord)localAddMessageContext.e.get(localObject1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    paramEntityManager = localAddMessageContext.f.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject1 = (String)paramEntityManager.next();
      localObject2 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
      if (localObject2 != null) {
        ((EcShopAssistantManager)localObject2).a((MessageRecord)localAddMessageContext.f.get(localObject1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    paramEntityManager = localAddMessageContext.d.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject1 = (String)paramEntityManager.next();
      PubAccountAssistantManager.a().a((MessageRecord)localAddMessageContext.d.get(localObject1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject2 = a();
    if (localObject2 != null)
    {
      int i2 = 0;
      paramEntityManager = null;
      i1 = i2;
      if (((QQMessageFacade.Message)localObject2).istroop == 1)
      {
        localObject1 = localAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(((QQMessageFacade.Message)localObject2).frienduin);
        paramEntityManager = (EntityManager)localObject1;
        i1 = i2;
        if (localObject1 != null)
        {
          paramEntityManager = (EntityManager)localObject1;
          i1 = i2;
          if (((MessageInfo)localObject1).a() == ((QQMessageFacade.Message)localObject2).shmsgseq)
          {
            i1 = 1;
            paramEntityManager = (EntityManager)localObject1;
          }
        }
      }
      if (i1 == 0) {
        break label669;
      }
    }
    label669:
    for (i1 = paramEntityManager.a();; i1 = 0)
    {
      ((QQMessageFacade.Message)localObject2).bizType = i1;
      paramEntityManager = localAddMessageContext.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (paramEntityManager.hasNext())
      {
        localObject1 = (String)paramEntityManager.next();
        localObject2 = (RecentUser)localAddMessageContext.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "addMessage saveRecentUser uin = " + ((RecentUser)localObject2).uin + " , type = " + ((RecentUser)localObject2).type + ", lastmsgtime = " + ((RecentUser)localObject2).lastmsgtime);
        }
        RecentUtil.a((RecentUser)localObject2, this);
        localAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.a((RecentUser)localAddMessageContext.jdField_a_of_type_JavaUtilMap.get(localObject1));
        localAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(((RecentUser)localObject2).uin);
      }
    }
    paramEntityManager = localAddMessageContext.jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject1 = (String)paramEntityManager.next();
      TroopAssistantManager.a().a((MessageRecord)localAddMessageContext.jdField_b_of_type_JavaUtilMap.get(localObject1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramBoolean3) {
      localAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade.a(paramList);
    }
    paramList = localAddMessageContext.jdField_c_of_type_JavaUtilMap.keySet().iterator();
    while (paramList.hasNext())
    {
      paramEntityManager = (String)paramList.next();
      paramEntityManager = (MessageRecord)localAddMessageContext.jdField_c_of_type_JavaUtilMap.get(paramEntityManager);
      paramEntityManager = a(paramEntityManager.frienduin, paramEntityManager.istroop);
      a(paramEntityManager);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "addMessage decodeMsg uin = " + paramEntityManager.frienduin + " , type = " + paramEntityManager.istroop + " ,msgType:" + paramEntityManager.msgtype + ", con = " + paramEntityManager.getLogColorContent());
      }
    }
    MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l1, l2);
  }
  
  private boolean a(QQMessageFacade.Message paramMessage1, QQMessageFacade.Message paramMessage2)
  {
    return a(paramMessage1.frienduin, paramMessage2.frienduin);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return (paramString1 == null) && (paramString2 == null);
  }
  
  private boolean a(List paramList, QQMessageFacade.Message paramMessage)
  {
    if ((paramList == null) || (paramMessage == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a((QQMessageFacade.Message)paramList.next(), paramMessage)) {
        return true;
      }
    }
    return false;
  }
  
  private MessageRecord b(String paramString, int paramInt)
  {
    paramString = MsgProxyUtils.b(a(paramInt).b(paramString, paramInt));
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (MessageRecord)paramString.get(paramString.size() - 1);
    }
    return null;
  }
  
  private String b(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  private void b(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.a(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopAssistantData)((Iterator)localObject).next()).troopUin, 1, paramEntityManager);
      }
    }
  }
  
  private void d(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.V)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = a(paramMessage.istroop).a(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          int i1 = paramMessage.unReadNum;
          paramMessage.unReadNum = (a(paramMessage.istroop).b(localMessageRecord.senderuin, localMessageRecord.istroop, 0L) + i1);
        }
        localEntityManager.a();
      }
    }
  }
  
  private void g(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(localMessageRecord.senderuin))
        {
          a().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          a(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          QQMessageFacade.Message localMessage = a(localMessageRecord.senderuin, paramInt);
          RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          RecentUser localRecentUser = localRecentUserProxy.a(localMessage.frienduin, localMessage.istroop);
          localRecentUser.lastmsgtime = localMessage.time;
          RecentUtil.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localRecentUserProxy.a(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshMsgBox uin=" + paramString + ",type=" + paramInt + ",move " + localMessageRecord.senderuin + " from box to recentlist");
          }
          setChanged();
          notifyObservers(localRecentUser);
        }
      }
    }
  }
  
  private void m()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QQMessageFacade.Message)localIterator.next()).counter = 0;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public int a()
  {
    return this.k;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, true);
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public int a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, 0, paramLong1, paramLong2, false);
  }
  
  public int a(String paramString, int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramLong, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public long a(String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString, 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i1;
    if (localList != null)
    {
      i1 = localList.size() - 1;
      localObject1 = localObject2;
      if (i1 >= 0)
      {
        localObject1 = (MessageRecord)localList.get(i1);
        if (!((MessageRecord)localObject1).senderuin.equals(paramString)) {
          break label178;
        }
        if (!QLog.isColorLevel()) {
          break label198;
        }
        QLog.i("vip", 2, "getLastC2CBubleID find in cache");
      }
    }
    label152:
    label178:
    label198:
    for (;;)
    {
      if (localObject1 == null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString, 0, 9223372036854775807L, 1, String.format("issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          paramString = (MessageRecord)paramString.get(0);
          localObject1 = paramString;
          if (QLog.isColorLevel())
          {
            QLog.d("vip", 2, "getLastC2CBubleID find in db");
            localObject1 = paramString;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          return 0L;
          i1 -= 1;
          break;
        }
        return ((MessageRecord)localObject1).vipBubbleID;
        paramString = (String)localObject1;
        break label152;
      }
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    List localList = a(paramInt).b(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty())) {
      return MessageCache.a();
    }
    if ((a()) && (a().equals(paramString)) && (a() == paramInt)) {
      return ((MessageRecord)localList.get(localList.size() - 1)).time;
    }
    paramInt = localList.size() - 1;
    while (paramInt >= 0)
    {
      if (((MessageRecord)localList.get(paramInt)).isread) {
        return ((MessageRecord)localList.get(paramInt)).time;
      }
      paramInt -= 1;
    }
    return Math.max(((MessageRecord)localList.get(0)).time - 1L, 0L);
  }
  
  public long a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString1, 0);
    int i1;
    MessageRecord localMessageRecord;
    if (paramString1 != null)
    {
      i1 = paramString1.size() - 1;
      if (i1 >= 0)
      {
        localMessageRecord = (MessageRecord)paramString1.get(i1);
        if (localMessageRecord.senderuin.equals(paramString2))
        {
          paramString1 = localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (paramString1 = localMessageRecord;; paramString1 = null)
    {
      if (paramString1 == null)
      {
        return 0L;
        i1 -= 1;
        break;
      }
      return paramString1.vipBubbleID;
    }
  }
  
  public BaseMessageManager a(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new TroopMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_b_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (paramInt == 3000)
    {
      if (this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
          this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new DiscMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.jdField_c_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
      }
    }
    if (paramInt == 7000)
    {
      if (this.d == null) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.d == null) {
          this.d = new SubMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        return this.d;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager = new C2CMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager;
    }
  }
  
  public C2CMessageManager a()
  {
    return (C2CMessageManager)a(0);
  }
  
  public ConversationFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public DatalineMessageManager a()
  {
    return (DatalineMessageManager)a("dataline_manager");
  }
  
  public DiscMessageManager a()
  {
    return (DiscMessageManager)a(3000);
  }
  
  public IMessageManager a(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilMap == null) {
      return null;
    }
    if (!this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilMap)
      {
        if (this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {
          break label89;
        }
        if (!"dataline_manager".equals(paramString)) {
          break label105;
        }
        localDatalineMessageManager = new DatalineMessageManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        if (localDatalineMessageManager == null) {
          return null;
        }
      }
      this.jdField_c_of_type_JavaUtilMap.put(paramString, localDatalineMessageManager);
      label89:
      return (IMessageManager)this.jdField_c_of_type_JavaUtilMap.get(paramString);
      label105:
      DatalineMessageManager localDatalineMessageManager = null;
    }
  }
  
  public QQMessageFacade.Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = b(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject;
    if (localMessage != null)
    {
      localObject = localMessage;
      if (localMessage.isCacheValid) {}
    }
    else
    {
      if (this.o != 0) {
        break label146;
      }
      localObject = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject).frienduin = paramString;
      ((QQMessageFacade.Message)localObject).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
      localStringBuilder.append("All-In");
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!MsgProxyUtils.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop)) {
        break;
      }
      ((QQMessageFacade.Message)localObject).istroop = MsgProxyUtils.a(((QQMessageFacade.Message)localObject).istroop);
      return localObject;
      label146:
      if (!this.jdField_b_of_type_Boolean)
      {
        localObject = localMessage;
        if (localMessage == null)
        {
          localObject = new QQMessageFacade.Message();
          ((QQMessageFacade.Message)localObject).frienduin = paramString;
          ((QQMessageFacade.Message)localObject).istroop = paramInt;
          ((QQMessageFacade.Message)localObject).isCacheValid = false;
          this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
        }
        localStringBuilder.append("Not-Finish-Yet");
      }
      else
      {
        localObject = MessageRecord.getTableName(paramString, paramInt);
        String str2 = MessageRecord.getOldTableName(paramString, paramInt);
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if ((!localEntityManager.d((String)localObject)) && (!localEntityManager.d(str2))) {
          break label279;
        }
        localObject = a(paramString, paramInt, localEntityManager);
        localStringBuilder.append("Check-DB");
        localEntityManager.a();
      }
    }
    label279:
    if (localMessage == null)
    {
      localMessage = new QQMessageFacade.Message();
      localMessage.frienduin = paramString;
      localMessage.istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localMessage);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      localObject = localMessage;
      break;
      localMessage.isCacheValid = true;
    }
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    return a(paramSessionInfo.a).a(paramSessionInfo, paramString);
  }
  
  public ChatHistorySearchData a(String paramString, int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = a(paramInt).a(paramString, paramInt, paramList);
    return localChatHistorySearchData;
  }
  
  public DraftSummaryInfo a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.longMsgIndex == 0) {}
    List localList;
    do
    {
      return paramMessageRecord;
      localList = a(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    } while ((localList == null) || (localList.isEmpty()));
    int i1 = localList.size() - 1;
    if (i1 >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i1);
      if (MsgProxyUtils.a(localMessageRecord, paramMessageRecord))
      {
        if (localMessageRecord.longMsgIndex == 0) {
          return localMessageRecord;
        }
        if (localMessageRecord.longMsgIndex < paramMessageRecord.longMsgIndex) {
          paramMessageRecord = localMessageRecord;
        }
      }
      for (;;)
      {
        i1 -= 1;
        break;
      }
    }
    return paramMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      int i1 = ((List)localObject1).size() - 1;
      Object localObject2;
      if (i1 >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i1);
        if ((((MessageRecord)localObject2).isValid) && (!MsgProxyUtils.g(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
      for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramInt).a(paramString, paramInt, null);
        }
        return localObject2;
        i1 -= 1;
        break;
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    return a(paramInt1).a(paramString1, paramInt1, paramLong1, paramString2, paramString3, paramLong2, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    MsgProxy localMsgProxy = a(paramInt);
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy)) {
      return ((TroopAndDiscMsgProxy)localMsgProxy).a(paramString, paramInt, paramMessageRecord);
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List paramList)
  {
    MsgProxy localMsgProxy = a(paramInt);
    if ((localMsgProxy instanceof TroopAndDiscMsgProxy)) {
      return ((TroopAndDiscMsgProxy)localMsgProxy).a(paramString, paramInt, paramMessageRecord, paramList);
    }
    return null;
  }
  
  public TroopMessageManager a()
  {
    return (TroopMessageManager)a(1);
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    a(localMessage);
    paramMessageRecord = new MsgSummary();
    MsgUtils.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    paramMessageRecord = paramMessageRecord.a(paramContext);
    paramContext = paramMessageRecord;
    if ((paramMessageRecord instanceof QQText)) {
      paramContext = ((QQText)paramMessageRecord).a();
    }
    return paramContext.toString();
  }
  
  public String a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List a(String paramString, int paramInt)
  {
    return a(paramInt).b(paramString, paramInt);
  }
  
  public List a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public List a(String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = a(paramInt).a(paramString, paramInt, paramBoolean);
    if (paramInt == 7100)
    {
      if (paramString == null) {}
      for (paramInt = 0;; paramInt = paramString.size())
      {
        paramInt -= 1;
        while (paramInt >= 0)
        {
          ChatMessage localChatMessage = (ChatMessage)paramString.get(paramInt);
          if ((localChatMessage != null) && (MessageUtils.a(localChatMessage.msgtype))) {
            paramString.remove(localChatMessage);
          }
          paramInt -= 1;
        }
      }
    }
    return paramString;
  }
  
  public List a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return a(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public ConcurrentHashMap a()
  {
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public msg_svc.PbMsgReadedReportReq a()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    Iterator localIterator = ((Set)localObject2).iterator();
    long l1;
    while (localIterator.hasNext())
    {
      localObject2 = (ConversationInfo)localIterator.next();
      if ((((ConversationInfo)localObject2).unreadCount > 0) && (a().b(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type))) {
        if (MsgProxyUtils.a(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type))
        {
          localObject3 = a(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
          if (localObject3 != null)
          {
            int i1 = ((List)localObject3).size();
            i1 -= 1;
            if (i1 >= 0)
            {
              MessageRecord localMessageRecord = (MessageRecord)((List)localObject3).get(i1);
              if (localMessageRecord == null) {}
              for (;;)
              {
                i1 -= 1;
                break;
                c(localMessageRecord.senderuin, localMessageRecord.istroop);
                msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
                localUinPairReadInfo.peer_uin.set(Long.valueOf(localMessageRecord.senderuin).longValue());
                localUinPairReadInfo.last_read_time.set((int)localMessageRecord.time);
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = new msg_svc.PbC2CReadedReportReq();
                }
                ((msg_svc.PbC2CReadedReportReq)localObject2).pair_info.add(localUinPairReadInfo);
                localStringBuilder.append("{MSGBOX:").append(localMessageRecord.frienduin).append("}");
                localObject1 = localObject2;
              }
            }
          }
        }
        else if (7000 == ((ConversationInfo)localObject2).type)
        {
          if (!AppConstants.W.equals(((ConversationInfo)localObject2).uin))
          {
            localObject3 = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
            if (localObject3 != null)
            {
              ((SubAccountManager)localObject3).b(((ConversationInfo)localObject2).uin);
              localObject2 = ((SubAccountManager)localObject3).a(((ConversationInfo)localObject2).uin);
              if (localObject2 != null)
              {
                localObject3 = new msg_svc.PbBindUinMsgReadedConfirmReq();
                ((msg_svc.PbBindUinMsgReadedConfirmReq)localObject3).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
                localPbMsgReadedReportReq.bind_uin_read_report.set((MessageMicro)localObject3);
                localStringBuilder.append("{SUBUIN}");
              }
            }
          }
        }
        else
        {
          if ((1006 != ((ConversationInfo)localObject2).type) && ((!MsgProxyUtils.c(((ConversationInfo)localObject2).type)) || (Long.valueOf(((ConversationInfo)localObject2).uin).longValue() <= 10000L))) {
            break label730;
          }
          c(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
          l1 = b(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
          if (l1 != -1L) {
            break label585;
          }
        }
      }
    }
    label498:
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
      if (localObject2 != null) {
        ((msg_svc.PbC2CReadedReportReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localPbMsgReadedReportReq.c2c_read_report.set((MessageMicro)localObject1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + localStringBuilder.toString());
    }
    return localPbMsgReadedReportReq;
    label585:
    Object localObject3 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    if (1006 == ((ConversationInfo)localObject2).type)
    {
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).peer_uin.set(Long.valueOf(ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject2).uin)).longValue());
      localStringBuilder.append("{C2C:").append(Long.valueOf(ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject2).uin))).append(((ConversationInfo)localObject2).type).append("}");
      label671:
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).last_read_time.set((int)l1);
      if (localObject1 != null) {
        break label944;
      }
      localObject1 = new msg_svc.PbC2CReadedReportReq();
    }
    label944:
    for (;;)
    {
      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject3);
      break;
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).peer_uin.set(Long.valueOf(((ConversationInfo)localObject2).uin).longValue());
      break label671;
      label730:
      if (3000 == ((ConversationInfo)localObject2).type)
      {
        c(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
        l1 = b(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
        if (l1 == -1L) {
          break label498;
        }
        localObject3 = new msg_svc.PbDiscussReadedReportReq();
        ((msg_svc.PbDiscussReadedReportReq)localObject3).conf_uin.set(Long.valueOf(((ConversationInfo)localObject2).uin).longValue());
        ((msg_svc.PbDiscussReadedReportReq)localObject3).last_read_seq.set(l1);
        localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject3);
        break;
      }
      if ((1 != ((ConversationInfo)localObject2).type) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type))) {
        break;
      }
      c(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      l1 = b(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      if (l1 == -1L) {
        break label498;
      }
      localObject3 = new msg_svc.PbGroupReadedReportReq();
      ((msg_svc.PbGroupReadedReportReq)localObject3).group_code.set(Long.valueOf(((ConversationInfo)localObject2).uin).longValue());
      ((msg_svc.PbGroupReadedReportReq)localObject3).last_read_seq.set(l1);
      localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject3);
      break;
    }
  }
  
  public msg_svc.PbMsgReadedReportReq a(String paramString, int paramInt)
  {
    if (MsgProxyUtils.a(paramString, paramInt))
    {
      List localList = a(paramString, paramInt);
      if (localList == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      paramInt = localList.size() - 1;
      paramString = null;
      Object localObject;
      if (paramInt >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)localList.get(paramInt);
        if (localMessageRecord == null) {}
        for (;;)
        {
          paramInt -= 1;
          break;
          c(localMessageRecord.senderuin, localMessageRecord.istroop);
          msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
          localUinPairReadInfo.peer_uin.set(Long.valueOf(localMessageRecord.senderuin).longValue());
          localUinPairReadInfo.last_read_time.set((int)localMessageRecord.time);
          localObject = paramString;
          if (paramString == null) {
            localObject = new msg_svc.PbC2CReadedReportReq();
          }
          ((msg_svc.PbC2CReadedReportReq)localObject).pair_info.add(localUinPairReadInfo);
          localStringBuilder.append("{MSGBOX:").append(localMessageRecord.frienduin).append("}");
          paramString = (String)localObject;
        }
      }
      if (paramString != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        if (localObject != null) {
          paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
        }
        localPbMsgReadedReportReq.c2c_read_report.set(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_LBS>setLbsFriendReaded: " + localStringBuilder.toString());
        }
        return localPbMsgReadedReportReq;
      }
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.a(new htj(this));
  }
  
  public void a(int paramInt)
  {
    String str = String.valueOf(AppConstants.ar);
    if (a().a(str, 4001) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      QQMessageFacade.Message localMessage = a(str, 4001);
      paramInt = a(4001).a(paramInt, localMessage);
      a().b(str, 4001, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(a(str, 4001));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1;
    if (this.o == -1)
    {
      if (localEntityManager.d(ConversationInfo.getConversationInfoTableName()))
      {
        i1 = 1;
        this.o = i1;
      }
    }
    else
    {
      localObject = ((RecentUserProxy)localObject).b();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label171;
      }
      i1 = ((List)localObject).size();
      if (paramInt <= 0) {
        break label213;
      }
      if (i1 <= paramInt) {
        break label163;
      }
      i1 = i2;
    }
    for (;;)
    {
      if (i1 < paramInt)
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(i1);
        a(localRecentUser.uin, localRecentUser.type, localEntityManager);
        if (i1 == 8)
        {
          setChanged();
          notifyObservers(new RecentUser());
        }
        i1 += 1;
        continue;
        i1 = 0;
        break;
        label163:
        paramInt = i1;
        i1 = i2;
        continue;
      }
      label171:
      if (paramBoolean) {
        b(localEntityManager);
      }
      if ((paramBoolean) || (((List)localObject).size() > 8))
      {
        setChanged();
        notifyObservers(new RecentUser());
      }
      return;
      label213:
      paramInt = i1;
      i1 = i2;
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    try
    {
      a(paramMessage.istroop).a(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        ((TransFileController)localObject2).b(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        ShortVideoUtils.a((MessageForShortVideo)localObject1);
      }
    }
    else
    {
      if (paramMessageRecord.isSendFromLocal()) {
        break label78;
      }
    }
    for (;;)
    {
      return;
      ((TransFileController)localObject2).c(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      break;
      label78:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = new ArrayList();
      Object localObject3;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        i2 = paramMessageRecord.msgElemList.size();
        i1 = 0;
        while (i1 < i2)
        {
          localObject3 = (MessageRecord)paramMessageRecord.msgElemList.get(i1);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          i1 += 1;
        }
      }
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
        int i3 = paramMessageRecord.longMsgFragmentList.size();
        i1 = 0;
        if (i1 < i3)
        {
          localObject3 = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i1);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = (MessageForMixedMsg)localObject3;
              int i4 = ((MessageForMixedMsg)localObject3).msgElemList.size();
              i2 = 0;
              while (i2 < i4)
              {
                MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(i2);
                if ((localMessageRecord instanceof MessageForPic)) {
                  ((List)localObject2).add((MessageForPic)localMessageRecord);
                }
                i2 += 1;
              }
            }
          }
        }
      }
      else
      {
        if (!(paramMessageRecord instanceof MessageForPic)) {
          continue;
        }
        ((List)localObject2).add((MessageForPic)paramMessageRecord);
      }
      int i2 = ((List)localObject2).size();
      int i1 = 0;
      while (i1 < i2)
      {
        paramMessageRecord = (MessageForPic)((List)localObject2).get(i1);
        paramMessageRecord = paramMessageRecord.frienduin + paramMessageRecord.uniseq + "_" + paramMessageRecord.subMsgId;
        localObject3 = ((TransFileController)localObject1).a(paramMessageRecord);
        if ((localObject3 != null) && ((localObject3 instanceof BaseTransProcessor)))
        {
          ((BaseTransProcessor)localObject3).h();
          ((TransFileController)localObject1).d(paramMessageRecord);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    a(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
      }
      b(paramMessageRecord, paramMessageObserver, paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramRecentUser);
    c(paramRecentUser.uin, paramRecentUser.type);
  }
  
  public void a(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.a(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramEntityManager);
      }
    }
    localObject = paramEntityManager.a(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopBarData)((Iterator)localObject).next()).mUin, 1008, paramEntityManager);
      }
    }
  }
  
  public void a(Object paramObject)
  {
    setChanged();
    notifyObservers(paramObject);
  }
  
  public void a(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (ArrayList)localEntityManager.a(TransFileInfo.class, false, "friendUin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localEntityManager.b((TransFileInfo)paramString.next());
      }
    }
    localEntityManager.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    this.k = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    a(paramInt1).a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, 32768, paramInt2);
    paramString = a(paramString, paramInt1);
    if ((paramString != null) && (paramString.uniseq == paramLong))
    {
      paramString.extraflag = 32768;
      paramString.sendFailCode = paramInt2;
      setChanged();
      notifyObservers(paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgExtraFlagByuniseq: peerUin = " + paramString + " type = " + paramInt1 + " uniseq = " + paramLong);
    }
    MessageRecord localMessageRecord = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    a(paramInt1).a(paramString, paramInt1, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " time = " + paramLong2);
    }
    MessageRecord localMessageRecord = a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
    a(paramInt).a(paramString, paramInt, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " shmsgseq = " + paramLong2 + " time = " + paramLong3);
    }
    Object localObject = a(paramInt);
    if ((localObject instanceof TroopAndDiscMsgProxy)) {}
    for (localObject = ((TroopAndDiscMsgProxy)localObject).b(paramString, paramInt, paramLong1, paramLong2, paramLong3);; localObject = null)
    {
      a(paramInt).a(paramString, paramInt, (MessageRecord)localObject, 3);
      a(paramString, paramInt, paramLong2);
      setChanged();
      notifyObservers(localObject);
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContent: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 2);
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong + " fieldName = " + paramString2 + " fieldValue = " + paramObject);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2, paramObject);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentByUniSeq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramArrayOfByte = a(paramInt).a(paramString, paramInt, paramLong, paramArrayOfByte);
    a(paramInt).a(paramString, paramInt, paramArrayOfByte, 2);
  }
  
  public void a(String paramString, int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    int i1 = 0;
    List localList = a(paramString, paramInt, false);
    if (localList == null) {}
    for (;;)
    {
      i1 = 10 - i1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "refreshMessageListHeadByAIOBreak numTroopRefresh = " + paramRefreshMessageContext.h + ", count = " + i1);
      }
      if (i1 <= 0) {
        break;
      }
      paramRefreshMessageContext.h = true;
      a(paramInt).a(paramString, paramInt, i1, paramRefreshMessageContext);
      return;
      i1 = localList.size();
    }
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.a = paramString;
    paramRefreshMessageContext.c = paramInt;
    paramRefreshMessageContext.jdField_d_of_type_Int = i1;
    a(paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).b(paramString, paramInt, paramMessageRecord);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null) && (paramString2 != null) && (paramString1 != null) && (paramString1.length() >= 5))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = paramString1;
      localDraftTextInfo.type = paramInt;
      localDraftTextInfo.text = paramString2.toString();
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDraftTextInfo);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramLong = 0L;
      }
      for (;;)
      {
        a(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.i("notification", 2, "notifyDraftUpdated| " + (System.currentTimeMillis() - l1));
        }
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle)
  {
    a(paramInt).a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    d(paramString, 1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, paramString1);
    }
  }
  
  public void a(String paramString, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      a("------------" + paramString + "--------------" + paramCollection.size(), "");
      return;
    }
    a("------------" + paramString + "-------------- is null", "");
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean, bool, true, true);
        paramString.a();
        if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        paramArrayList = MsgProxyUtils.a(paramArrayList);
        if (paramArrayList != null) {
          setChanged();
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if (paramBoolean2)
        {
          paramArrayList = MsgProxyUtils.a(paramArrayList);
          if (paramArrayList != null) {
            setChanged();
          }
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if ((paramBoolean2) || (paramBoolean3))
        {
          paramArrayList = MsgProxyUtils.a(paramArrayList);
          if (paramArrayList != null) {
            setChanged();
          }
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramList, null);
    }
  }
  
  public void a(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, true);
      paramString.a();
      paramList = MsgProxyUtils.a(paramList);
      if (paramList != null)
      {
        setChanged();
        notifyObservers(paramList);
      }
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_JavaLangString != null) && (this.k >= 0);
  }
  
  /* Error */
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +61 -> 67
    //   9: aload_0
    //   10: getfield 66	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: invokeinterface 303 1 0
    //   18: astore_3
    //   19: aload_3
    //   20: invokeinterface 187 1 0
    //   25: ifeq +42 -> 67
    //   28: aload_3
    //   29: invokeinterface 191 1 0
    //   34: checkcast 254	com/tencent/mobileqq/app/message/QQMessageFacade$Message
    //   37: astore 4
    //   39: aload_0
    //   40: aload 4
    //   42: aload_1
    //   43: invokespecial 257	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   46: ifeq -27 -> 19
    //   49: aload 4
    //   51: iconst_0
    //   52: putfield 654	com/tencent/mobileqq/app/message/QQMessageFacade$Message:counter	I
    //   55: aload_3
    //   56: invokeinterface 1323 1 0
    //   61: iconst_1
    //   62: istore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: iload_2
    //   66: ireturn
    //   67: iconst_0
    //   68: istore_2
    //   69: goto -6 -> 63
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	QQMessageFacade
    //   0	77	1	paramMessage	QQMessageFacade.Message
    //   62	7	2	bool	boolean
    //   18	38	3	localIterator	Iterator
    //   37	13	4	localMessage	QQMessageFacade.Message
    // Exception table:
    //   from	to	target	type
    //   2	19	72	finally
    //   19	61	72	finally
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop).uniseq == paramMessageRecord.uniseq;
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, 0);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = b(paramString, paramInt);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      paramString = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (MsgProxyUtils.i(paramInt2))
    {
      bool1 = bool2;
      if (MsgProxyUtils.g(paramInt2))
      {
        bool1 = bool2;
        if (a(paramInt1).c(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, List paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.QQMessageFacade", 2, "refresh C2C autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(b(paramString, paramInt), Boolean.valueOf(true));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(paramString, paramInt);
    } while ((paramString == null) || (paramString.isEmpty()));
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c();
    }
    a("refresh C2C autopull, size = " + paramString.size(), ", timestamp = " + System.currentTimeMillis());
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    paramBoolean = true;
    boolean bool = true;
    List localList = a(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty()))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    if (localList.size() == 1)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(0);
      if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid)) {
        return false;
      }
      if (localMessageRecord.shmsgseq > Math.max(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt)) + 1L) {}
      for (;;)
      {
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool + "; cacheList size = " + localList.size() + "; msgseq = " + localMessageRecord.shmsgseq + ", expiredSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString) + ", delLastSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt));
        return bool;
        bool = false;
      }
    }
    if (localList.size() > 1)
    {
      paramString = (MessageRecord)localList.get(localList.size() - 1);
      if ((paramString.msgtype == -2006) || (!paramString.isValid)) {
        return false;
      }
      paramString = MsgProxyUtils.a(localList, false);
      if (paramString.size() < 10) {}
      for (bool = paramBoolean;; bool = false)
      {
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool + "; cacheList size = " + localList.size() + "; continuedList size = " + paramString.size());
        return bool;
      }
    }
    return false;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i1 = 0; localIterator.hasNext(); i1 = ((QQMessageFacade.Message)localIterator.next()).counter + i1) {}
    return i1;
  }
  
  public long b(String paramString, int paramInt)
  {
    long l2 = -1L;
    Object localObject;
    long l1;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      l2 = ((QQMessageFacade.Message)localObject).shmsgseq;
      l1 = l2;
      if (((QQMessageFacade.Message)localObject).isLongMsg())
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (paramString.size() > 0) {
            return Math.max(l2, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
          }
        }
      }
    }
    else
    {
      l1 = l2;
      if (MsgProxyUtils.c(paramInt))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (!paramString.isEmpty())
          {
            paramInt = paramString.size() - 1;
            for (;;)
            {
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              localObject = (MessageRecord)paramString.get(paramInt);
              if (!MsgUtils.b(((MessageRecord)localObject).issend)) {
                return ((MessageRecord)localObject).time;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
    return l1;
  }
  
  public QQMessageFacade.Message b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    return null;
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public void b()
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.k = -1;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4001).b(String.valueOf(AppConstants.ar), 4001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt);
    } while (a(4001).a(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(AppConstants.ap);
    notifyObservers(localObject);
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = paramMessage;
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    b(paramMessageRecord, paramMessageObserver, false);
  }
  
  public void b(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + paramMessageRecord.istroop + " mr_msgType:" + paramMessageRecord.msgtype);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.msgtype);
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
      }
      if (paramMessageRecord.msgtype == -1000) {
        if (paramMessageRecord.istroop == 1001)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramMessageRecord.frienduin))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForText)paramMessageRecord);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
          return;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "sendMessage ERROR:" + paramMessageRecord.getMessage(), paramMessageRecord);
        return;
        if (paramMessageRecord.istroop == 1003)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForText)paramMessageRecord);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
        return;
        if ((paramMessageRecord.msgtype == -2011) || (paramMessageRecord.msgtype == -2007) || (paramMessageRecord.msgtype == -2002) || (paramMessageRecord.msgtype == -2000) || (paramMessageRecord.msgtype == -2010) || (paramMessageRecord.msgtype == -2020) || (paramMessageRecord.msgtype == -2022)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramMessageObserver, paramBoolean);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramMessageRecord.frienduin, paramMessageRecord);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("sendmsg", 2, "addSendMessage key =" + paramMessageRecord.uniseq + paramMessageRecord.frienduin + paramMessageRecord.istroop);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramMessageRecord);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {}
    do
    {
      return;
      i1 = localSQLiteDatabase.a(paramString);
    } while (i1 <= 6000);
    int i1 = Math.max(i1 - 5000, 1000);
    String str;
    if (paramInt == 0)
    {
      str = String.format("delete from %s where time in (select time from %s order by time limit %s)", new Object[] { paramString, paramString, Integer.valueOf(i1) });
      label72:
      if (paramInt != 0) {}
    }
    for (;;)
    {
      for (;;)
      {
        Cursor localCursor;
        try
        {
          localObject = new String[2];
          localObject[0] = "time";
          localObject[1] = "frienduin";
          localCursor = localSQLiteDatabase.a(paramString, (String[])localObject, null, null, localObject[0], String.valueOf(i1));
        }
        catch (Exception localException1)
        {
          Object localObject;
          long l1;
          localCursor = null;
        }
        try
        {
          for (;;)
          {
            if (localCursor.moveToLast())
            {
              l1 = localCursor.getLong(localCursor.getColumnIndex(localObject[0]));
              localObject = localCursor.getString(localCursor.getColumnIndex(localObject[1]));
              ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(86)).a((String)localObject, l1);
            }
            try
            {
              l1 = System.currentTimeMillis();
              localSQLiteDatabase.a(str);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.msg.QQMessageFacade", 2, "delete " + paramString + " " + i1 + " rows cost " + (System.currentTimeMillis() - l1));
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.QQMessageFacade", 2, "checkRecordCount " + paramString);
          return;
        }
        catch (Exception localException2)
        {
          label371:
          break label371;
        }
      }
      if ((paramInt == 1) || (paramInt == 3000))
      {
        str = String.format("delete from %s where shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString, paramString, Integer.valueOf(i1) });
        break label72;
      }
      str = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { paramString, paramString, Integer.valueOf(i1) });
      break label72;
      if (localCursor != null) {
        localCursor.close();
      }
      localException1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "checkRecordCount " + localException1);
      }
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    int i1 = 1;
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
    if (a(paramInt).c(paramString, paramInt, paramLong) == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, -1);
    }
    if (localMessageRecord != null) {
      if ((localMessageRecord instanceof MessageForLongMsg))
      {
        if (!MsgProxyUtils.a(localMessageRecord, a(localMessageRecord.frienduin, localMessageRecord.istroop))) {
          break label120;
        }
        paramInt = i1;
        if (paramInt != 0)
        {
          if (!MsgProxyUtils.p(localMessageRecord.istroop)) {
            break label125;
          }
          a(localMessageRecord.istroop).a(localMessageRecord);
        }
      }
    }
    label120:
    label125:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        paramInt = i1;
        if (!a(localMessageRecord)) {
          paramInt = 0;
        }
      }
      a(localMessageRecord.istroop).b(localMessageRecord);
      return;
    }
    QLog.w("Q.msg.QQMessageFacade", 2, "removeMsgByUniseq error: message not found. uin=" + paramString + ",type=" + paramInt + ",uniseq=" + paramLong);
  }
  
  public void b(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    d(paramString, 3000);
  }
  
  public void b(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, false);
      paramString.a();
      paramList = MsgProxyUtils.a(paramList);
      if (paramList != null)
      {
        setChanged();
        notifyObservers(paramList);
      }
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    return c(paramString, paramInt);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void c()
  {
    a(0).c();
    a(3000).c();
    a(1).c();
  }
  
  /* Error */
  public void c(QQMessageFacade.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +35 -> 41
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 66	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   14: aload_1
    //   15: invokespecial 1478	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/util/List;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   18: ifeq +26 -> 44
    //   21: aload_0
    //   22: getfield 66	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 66	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: aload_1
    //   31: invokespecial 1480	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/util/List;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)I
    //   34: aload_1
    //   35: invokeinterface 1483 3 0
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: getfield 66	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   48: aload_1
    //   49: invokeinterface 1100 2 0
    //   54: pop
    //   55: goto -14 -> 41
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	QQMessageFacade
    //   0	63	1	paramMessage	QQMessageFacade.Message
    // Exception table:
    //   from	to	target	type
    //   2	41	58	finally
    //   44	55	58	finally
  }
  
  public void c(String paramString, int paramInt)
  {
    a(paramInt).a(paramString, paramInt);
  }
  
  public void c(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    d(paramString, 0);
  }
  
  public void c(List paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, true, false, true, true);
      paramString.a();
      paramList = MsgProxyUtils.a(paramList);
      if (paramList != null)
      {
        setChanged();
        notifyObservers(paramList);
      }
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public boolean c(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public int d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    QQMessageFacade.Message localMessage;
    SubAccountManager localSubAccountManager;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localMessage = (QQMessageFacade.Message)localIterator.next();
        if (localMessage.istroop != 1008) {
          if (7000 == localMessage.istroop)
          {
            localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
            if (localSubAccountManager == null) {
              break label100;
            }
          }
        }
      }
    }
    label100:
    for (int i2 = localSubAccountManager.c(localMessage.frienduin);; i2 = 0)
    {
      i1 = i2 + i1;
      for (;;)
      {
        break;
        i1 += 1;
      }
      return i1;
    }
  }
  
  public void d()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    boolean bool;
    int i1;
    if (this.o == -1)
    {
      bool = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i1 = 1;
        this.o = i1;
      }
    }
    for (;;)
    {
      localEntityManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache start : Lazy : " + bool);
      }
      long l1 = System.currentTimeMillis();
      if (bool)
      {
        a(0, true);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache finish : TimeSpend:" + (System.currentTimeMillis() - l1));
        }
        return;
        i1 = 0;
        break;
        e();
      }
      bool = true;
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    a(paramInt).c(paramString, paramInt);
  }
  
  public boolean d(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(paramString, paramInt);
    }
    return false;
  }
  
  public int e()
  {
    int i1 = a(2);
    if ((i1 != 0) && (QLog.isColorLevel())) {
      QLog.d("Q.msg.QQMessageFacade", 2, "Recent Msg Unread=" + i1);
    }
    int i2;
    if (a().b(AppConstants.ap, 9000))
    {
      i2 = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((i2 != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent TroopNotification Unread=" + i1);
      }
      i1 += i2;
    }
    for (;;)
    {
      i2 = i1;
      if (a().b(AppConstants.ab, 4000))
      {
        i2 = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a();
        if ((i2 != 0) && (QLog.isColorLevel())) {
          QLog.d("Q.msg.QQMessageFacade", 2, "Recent NewFriendUnread Unread=" + i1);
        }
        i2 = i1 + i2;
      }
      return i2;
    }
  }
  
  public void e()
  {
    a("refreshCache", "");
    System.currentTimeMillis();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject1 = localEntityManager.a(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    int i2;
    if (localObject1 != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      boolean bool1 = localEntityManager.d(ConversationInfo.getConversationInfoTableName());
      ConversationFacade localConversationFacade = a();
      StringBuilder localStringBuilder = new StringBuilder(128);
      Iterator localIterator = ((List)localObject1).iterator();
      int i1 = 0;
      boolean bool2;
      Object localObject2;
      label589:
      do
      {
        Object localObject3;
        do
        {
          do
          {
            i2 = i1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (Sqlite)localIterator.next();
            ((Sqlite)localObject3).tbl_name = SecurityUtile.a(((Sqlite)localObject3).tbl_name);
          } while (((Sqlite)localObject3).tbl_name.equals("mr_fileManager"));
          bool2 = ((Sqlite)localObject3).tbl_name.endsWith("_New");
          localObject2 = a(MsgProxyUtils.a(((Sqlite)localObject3).tbl_name)).a(((Sqlite)localObject3).tbl_name, localEntityManager);
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 4, "getMsgProxy().queryLastMessage = " + localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
            {
              a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
              localObject2 = a(((QQMessageFacade.Message)localObject2).istroop).a(((Sqlite)localObject3).tbl_name, localEntityManager);
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject2);
                localObject1 = localObject2;
              }
            }
          }
          if (localObject1 == null) {
            break label947;
          }
        } while ((((QQMessageFacade.Message)localObject1).frienduin.equals(String.valueOf(AppConstants.Y))) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName())));
        if (((!AppConstants.af.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) == 1001)) || ((!AppConstants.au.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) == 1010)))
        {
          localObject2 = a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if ((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(((MessageRecord)localObject3).frienduin)))
              {
                ((QQMessageFacade.Message)localObject1).hasReply = true;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
                }
              }
            }
          }
        }
        a((QQMessageFacade.Message)localObject1);
        if (!bool1)
        {
          d((QQMessageFacade.Message)localObject1);
          if (localList != null)
          {
            i2 = 0;
            if (i2 < localList.size())
            {
              localObject2 = (RecentUser)localList.get(i2);
              if ((localObject2 == null) || (((RecentUser)localObject2).uin == null) || (!((RecentUser)localObject2).uin.equals(((QQMessageFacade.Message)localObject1).frienduin))) {
                break;
              }
              if ((MsgProxyUtils.p(((QQMessageFacade.Message)localObject1).istroop)) && (a().a(((QQMessageFacade.Message)localObject1).frienduin, MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop))))
              {
                if (((QQMessageFacade.Message)localObject1).istroop != 1009) {
                  a(AppConstants.V, 1009, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
                if (((QQMessageFacade.Message)localObject1).istroop != 1001) {
                  a(AppConstants.af, 1001, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
              }
            }
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append("refreshCache message uin = ").append(((QQMessageFacade.Message)localObject1).frienduin).append(", type = ").append(((QQMessageFacade.Message)localObject1).istroop).append(", unread = ").append(((QQMessageFacade.Message)localObject1).unReadNum).append(", time = ").append(((QQMessageFacade.Message)localObject1).time);
          a(localStringBuilder.toString(), "");
        }
        localObject2 = b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      } while ((!bool2) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2)));
      this.jdField_a_of_type_JavaUtilMap.put(localObject2, localObject1);
      i2 = i1 + 1;
      i1 = i2;
      if (!bool1)
      {
        localConversationFacade.a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, ((QQMessageFacade.Message)localObject1).unReadNum);
        i1 = i2;
      }
    }
    label947:
    for (;;)
    {
      break;
      i2 += 1;
      break label589;
      i2 = 0;
      localEntityManager.a();
      MsgAutoMonitorUtil.a().a("MSG_TableNum", i2 + "");
      return;
    }
  }
  
  public void e(String paramString, int paramInt)
  {
    paramString = new QQMessageFacade.MessageNotifyParam(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  public int f()
  {
    return a(6);
  }
  
  public void f()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.a((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).moveToFirst();
      int i1 = 0;
      while (i1 < ((Cursor)localObject1).getCount())
      {
        a(((Cursor)localObject1).getString(0), ((Cursor)localObject1).getInt(1), false, true);
        ((Cursor)localObject1).moveToNext();
        i1 += 1;
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      a(0).e();
      a(0).d();
      a(3000).e();
      a(3000).d();
      a(1).e();
      a(1).d();
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
  }
  
  public void f(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < 5)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) || (paramString == null) || (paramString.length() < 5)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
  }
  
  public int g()
  {
    return a(7);
  }
  
  public void g()
  {
    String str1 = new RecentUser().getTableName();
    String str2 = new TroopAssistantData().getTableName();
    String str3 = new PubAccountAssistantData().getTableName();
    String str4 = new TroopBarData().getTableName();
    String str5 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.a(str1, null, null);
    localSQLiteDatabase.a(str2, null, null);
    localSQLiteDatabase.a(str3, null, null);
    localSQLiteDatabase.a(str5, null, null);
    localSQLiteDatabase.a(str4, null, null);
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).h();
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c();
  }
  
  public int h()
  {
    return a(8);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
  }
  
  public void j()
  {
    m();
  }
  
  public void k()
  {
    g(AppConstants.V, 1009);
    g(AppConstants.af, 1001);
    g(AppConstants.au, 1010);
  }
  
  /* Error */
  public void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 103	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 1649	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: aload_0
    //   8: getfield 103	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 1132	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 1655	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: astore 4
    //   20: aload 4
    //   22: ldc 23
    //   24: lconst_0
    //   25: invokeinterface 1660 4 0
    //   30: lstore_2
    //   31: invokestatic 436	java/lang/System:currentTimeMillis	()J
    //   34: ldc2_w 1661
    //   37: ldiv
    //   38: lload_2
    //   39: lsub
    //   40: ldc2_w 1663
    //   43: lcmp
    //   44: ifge +4 -> 48
    //   47: return
    //   48: aload_0
    //   49: lload_2
    //   50: invokespecial 1666	com/tencent/mobileqq/app/message/QQMessageFacade:a	(J)V
    //   53: new 159	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 1668
    //   60: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: astore 5
    //   65: aload_0
    //   66: getfield 75	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: astore 7
    //   71: aload 7
    //   73: monitorenter
    //   74: new 72	java/util/concurrent/ConcurrentHashMap
    //   77: dup
    //   78: aload_0
    //   79: getfield 75	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   82: invokespecial 1671	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   85: astore 6
    //   87: aload_0
    //   88: getfield 75	com/tencent/mobileqq/app/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   91: invokevirtual 1672	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   94: aload 7
    //   96: monitorexit
    //   97: aload 6
    //   99: invokevirtual 375	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   102: invokeinterface 182 1 0
    //   107: astore 7
    //   109: aload 7
    //   111: invokeinterface 187 1 0
    //   116: ifeq +114 -> 230
    //   119: aload 7
    //   121: invokeinterface 191 1 0
    //   126: checkcast 203	java/lang/String
    //   129: astore 8
    //   131: aload 6
    //   133: aload 8
    //   135: invokevirtual 1673	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 332	java/lang/Integer
    //   141: invokevirtual 1676	java/lang/Integer:intValue	()I
    //   144: istore_1
    //   145: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +23 -> 171
    //   151: aload 5
    //   153: ldc_w 1678
    //   156: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 8
    //   161: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 1680
    //   167: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_0
    //   172: aload 8
    //   174: iload_1
    //   175: invokevirtual 1682	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)V
    //   178: goto -69 -> 109
    //   181: astore 4
    //   183: aload 4
    //   185: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   188: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq -144 -> 47
    //   194: ldc 88
    //   196: iconst_2
    //   197: new 159	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 1684
    //   207: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 4
    //   212: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: return
    //   222: astore 4
    //   224: aload 7
    //   226: monitorexit
    //   227: aload 4
    //   229: athrow
    //   230: aload 4
    //   232: invokeinterface 1688 1 0
    //   237: ldc 23
    //   239: invokestatic 436	java/lang/System:currentTimeMillis	()J
    //   242: ldc2_w 1661
    //   245: ldiv
    //   246: invokeinterface 1694 4 0
    //   251: invokeinterface 1697 1 0
    //   256: pop
    //   257: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq -213 -> 47
    //   263: ldc 88
    //   265: iconst_2
    //   266: aload 5
    //   268: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	QQMessageFacade
    //   144	31	1	i1	int
    //   30	20	2	l1	long
    //   18	3	4	localSharedPreferences	android.content.SharedPreferences
    //   181	30	4	localException	Exception
    //   222	9	4	localObject1	Object
    //   63	204	5	localStringBuilder	StringBuilder
    //   85	47	6	localConcurrentHashMap	ConcurrentHashMap
    //   129	44	8	str	String
    // Exception table:
    //   from	to	target	type
    //   48	53	181	java/lang/Exception
    //   74	97	222	finally
    //   224	227	222	finally
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l1 = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    MsgAutoMonitorUtil.a().c(System.currentTimeMillis() - l1);
    MsgAutoMonitorUtil.a().c();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a();
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_b_of_type_Boolean = false;
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */