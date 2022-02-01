package com.tencent.mobileqq.pic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import jlv;
import jlw;
import jlx;
import jly;
import jlz;
import jma;
import jmb;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;

public class PicPreDownloader
  implements Manager
{
  public static final int a = 1;
  public static final int b = 2;
  private static boolean jdField_b_of_type_Boolean = true;
  public static final int c = 3;
  private static boolean jdField_c_of_type_Boolean = false;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  private static final int h = 1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public BaseStrategy a;
  private PicStatisticsManager jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager;
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map a;
  private Timer jdField_a_of_type_JavaUtilTimer;
  PriorityBlockingQueue jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public AtomicInteger a;
  boolean jdField_a_of_type_Boolean = true;
  private List jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public PriorityBlockingQueue b;
  private List jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  private List d = Collections.synchronizedList(new LinkedList());
  
  public PicPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new jmb(paramQQAppInterface.a());
    paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = new PreDownloadStrategyBeta();; localObject = new PreDownloadStrategyAlpha())
    {
      this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy = ((BaseStrategy)localObject);
      this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager = ((PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69));
      Logger.a("PIC_TAG_PRELOAD", "onInit", "Finished");
      return;
    }
  }
  
  private PicReq a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      PicReq localPicReq1;
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localPicReq1 = (PicReq)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localPicReq1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localPicReq1 = (PicReq)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localPicReq1;
        }
      }
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      i = this.jdField_c_of_type_JavaUtilList.size();
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        PicReq localPicReq2 = (PicReq)this.jdField_c_of_type_JavaUtilList.get(i - 1);
        this.jdField_c_of_type_JavaUtilList.remove(i - 1);
        return localPicReq2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        PicReq localPicReq3 = (PicReq)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localPicReq3;
      }
    }
    Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  private PicReq a(String paramString, Collection paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          PicReq localPicReq = (PicReq)localIterator.next();
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) {
            continue;
          }
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_Int == 1)
          {
            bool = true;
            int i = URLDrawableHelper.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e, bool);
            String str = TransFileController.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_JavaLangString, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localPicReq);
            this.jdField_a_of_type_JavaUtilMap.remove(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g);
            b(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
            return localPicReq;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  private Collection a(int paramInt)
  {
    Logger.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue;
    case 5: 
      return this.jdField_a_of_type_JavaUtilList;
    case 4: 
      List localList = this.jdField_b_of_type_JavaUtilList;
    case 3: 
      return this.jdField_c_of_type_JavaUtilList;
    }
    return this.d;
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    PicReq localPicReq;
    for (;;)
    {
      return;
      if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramMessageForPic);
        localPicReq = PicBusiManager.a(5, 1536, 2);
        PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
        if (localPicDownloadInfo != null) {
          localPicDownloadInfo.j = 1;
        }
        localPicReq.a(paramMessageForPic, localPicDownloadInfo);
        i = PicPreDownloadUtils.a();
        if ((jdField_b_of_type_Boolean) || (i == 0)) {
          break label153;
        }
        Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
        return;
      }
    }
    label153:
    ThreadManager.a().post(new jly(this, localPicReq));
    Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    ThreadManager.a().postDelayed(new jlw(this, paramMessageForPic, paramInt1, paramInt2), 100L);
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    int i = PicPreDownloadUtils.a();
    Logger.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + i);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).preDownNetworkType = i;
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).msgElemList.iterator();
        while (paramMessageRecord.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            ((MessageForPic)localMessageRecord).preDownNetworkType = i;
          }
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      b((MessageForPic)paramMessageRecord, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        int i = 0;
        while (i < paramMessageRecord.msgElemList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.msgElemList.get(i);
          if ((localMessageRecord instanceof MessageForPic))
          {
            MessageForPic localMessageForPic = (MessageForPic)localMessageRecord;
            if (localMessageForPic.time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, paramMessageRecord);
            }
            b(localMessageForPic, paramInt1, paramInt2);
          }
          i += 1;
        }
      }
    }
  }
  
  private boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    Logger.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label339:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (PicReq)localIterator.next();
          if (paramMessageForPic.subMsgId != ((PicReq)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i) {
            break label339;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label339;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          Logger.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      localObject1.r = localObject1.q;
      localObject1.q = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForPic.uuid, Integer.valueOf(paramInt));
      Logger.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  private void b(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramMessageForPic.hasBigFile())
    {
      Logger.a("PIC_TAG_PRELOAD", "handleBigPic", "hasBigFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
      PicPreDownloadUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "handleBigPic", " START uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority:" + paramInt);
    int i;
    PicReq localPicReq;
    Object localObject;
    List localList;
    if (PicPreDownloadUtils.a() == 0)
    {
      i = 1536;
      localPicReq = PicBusiManager.a(6, i, 2);
      localObject = paramMessageForPic.getPicDownloadInfo();
      if (localObject != null)
      {
        ((PicDownloadInfo)localObject).j = 1;
        ((PicDownloadInfo)localObject).e = "chatimg";
      }
      localPicReq.a(paramMessageForPic, (PicDownloadInfo)localObject);
      localList = null;
      localObject = "";
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramInt != 5) {
        break label403;
      }
      localList = this.jdField_a_of_type_JavaUtilList;
      localPicReq.q = 5;
      localObject = "AIORequests";
      switch (i)
      {
      default: 
        localPicReq.r = 2;
        label238:
        if (localList != null)
        {
          Logger.a("PIC_TAG_PRELOAD", "handleBigPic", "successfully to add the pic request to " + (String)localObject);
          localList.add(localPicReq);
          this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, Integer.valueOf(localPicReq.q));
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 1) {
          d();
        }
        break;
      }
    }
    for (;;)
    {
      Logger.a("PIC_TAG_PRELOAD", "handleBigPic", "END uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority: " + paramInt);
      return;
      i = 1537;
      break;
      localPicReq.r = 4;
      break label238;
      localPicReq.r = 3;
      break label238;
      label403:
      if (paramInt != 1) {
        break label238;
      }
      switch (i)
      {
      default: 
        localList = this.d;
        localPicReq.q = 2;
        localPicReq.r = localPicReq.q;
        localObject = "GroupRequests";
        break;
      case 3: 
        localList = this.jdField_b_of_type_JavaUtilList;
        localPicReq.q = 4;
        localPicReq.r = localPicReq.q;
        localObject = "C2CRequests";
        break;
      case 2: 
        localList = this.jdField_c_of_type_JavaUtilList;
        localPicReq.q = 3;
        localPicReq.r = localPicReq.q;
        localObject = "DiscussionRequests";
        break;
        Logger.a("PIC_TAG_PRELOAD", "handleBigPic", "handlingNum.get() >= MAX_HANDLING_THREADS");
      }
    }
  }
  
  private void b(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    boolean bool3 = false;
    if ((paramMessageForPic.path == null) && (paramMessageForPic.uuid == null) && (paramMessageForPic.md5 == null))
    {
      Logger.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
      b(paramMessageForPic, -3);
      return;
    }
    if (paramMessageForPic.isSendFromLocal())
    {
      Logger.a("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt2);
    if (a(paramMessageForPic, paramInt2))
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + "priority:" + paramInt2);
      return;
    }
    int i;
    if ((paramMessageForPic.isMultiMsg) && (!paramMessageForPic.isSend()))
    {
      localObject = MultiMsgManager.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
      }
    }
    int j;
    int k;
    for (;;)
    {
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject);
      j = PicPreDownloadUtils.a();
      k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
      if ((j == 0) || (k != 2)) {
        break;
      }
      Logger.a("PIC_TAG_PRELOAD", "add", "num group skip, uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + "priority:" + paramInt2);
      return;
      i = paramMessageForPic.istroop;
      localObject = paramMessageForPic.frienduin;
      continue;
      i = paramMessageForPic.istroop;
      localObject = paramMessageForPic.frienduin;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(i, j);
    boolean bool1;
    if ((localObject[0] != 0) && ((paramInt1 & 0x1) == 1))
    {
      bool1 = true;
      boolean bool2 = bool3;
      if (localObject[1] != 0)
      {
        bool2 = bool3;
        if ((paramInt1 & 0x2) == 2) {
          bool2 = true;
        }
      }
      Logger.a("PIC_TAG_PRELOAD", "add", "preDownThumb=" + bool1 + " preDownBig=" + bool2);
      if (bool1) {
        a(paramMessageForPic);
      }
      if (bool2)
      {
        if (k == 1) {
          break label541;
        }
        Logger.a("PIC_TAG_PRELOAD", "add", "The troop is not MSG_FILTER_VALUE.MSG_FILTER_OPEN");
        b(paramMessageForPic, -7);
      }
    }
    for (;;)
    {
      Logger.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt2);
      return;
      bool1 = false;
      break;
      label541:
      if (this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(paramMessageForPic)) {
        b(paramMessageForPic, paramInt2);
      } else {
        b(paramMessageForPic, -6);
      }
    }
  }
  
  private void b(MessageRecord paramMessageRecord, int paramInt)
  {
    Logger.a("PIC_TAG_PRELOAD", "setNotPredownloadReason", "Reson=" + paramInt);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).mNotPredownloadReason = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).msgElemList.iterator();
        while (paramMessageRecord.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            ((MessageForPic)localMessageRecord).mNotPredownloadReason = paramInt;
          }
        }
      }
    }
  }
  
  private void e()
  {
    Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = PicPreDownloadUtils.a();
    if ((!jdField_b_of_type_Boolean) && (i != 0))
    {
      Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    if (localIterator.hasNext())
    {
      localObject = (PicReq)localIterator.next();
      ThreadManager.a().post(new jlz(this, (PicReq)localObject));
      if (((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) {
        break label162;
      }
    }
    label162:
    for (Object localObject = "uniseq:" + ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a;; localObject = "")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject);
      break;
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public int a(MessageForPic paramMessageForPic)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null) {
      return -1;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection != null) {
      try
      {
        Iterator localIterator = localCollection.iterator();
        while (localIterator.hasNext())
        {
          PicReq localPicReq = (PicReq)localIterator.next();
          if (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i)
          {
            Logger.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new jlv(this), 60000L);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((BaseStrategy.h != 2L) && (BaseStrategy.h != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): PicAuDownTimePoint is not DOWNLOAD_POINT_AIO or DOWNLOAD_POINT_ALL");
      }
      b(paramMessageForPic, -2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): ");
    }
    a(paramMessageForPic, paramInt, 5);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy instanceof PreDownloadStrategyBeta)) {
      ((PreDownloadStrategyBeta)this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy).b(paramMessageForPic, paramLong);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    a(paramMessageRecord);
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): cannot predownload");
      }
      b(paramMessageRecord, -1);
    }
    Object localObject;
    do
    {
      return;
      if ((BaseStrategy.h != 1L) && (BaseStrategy.h != 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): PicAuDownTimePoint is not DOWNLOAD_POINT_MSG or DOWNLOAD_POINT_ALL");
        }
        b(paramMessageRecord, -2);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!((QQMessageFacade)localObject).a()) || (!((QQMessageFacade)localObject).a().equals(paramMessageRecord.frienduin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): The AIO is opening, does not need to predownload the thumb picture");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): ");
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject).getReportInfo().jdField_f_of_type_Int = PicPreDownloadUtils.a();
      ((MessageForPic)localObject).getReportInfo().a = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().e = 0;
    }
    a(paramMessageRecord, paramInt, 1);
    ChatImageDownloader.a(paramMessageRecord);
  }
  
  public void a(String paramString)
  {
    PicReq localPicReq = a(paramString, this.jdField_a_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.n);
      return;
    }
    localPicReq = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.n);
      return;
    }
    localPicReq = a(paramString, this.jdField_c_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.n);
      return;
    }
    localPicReq = a(paramString, this.d);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.n);
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131366260), "qqsetting_auto_receive_pic_key", true);
    if ((NetworkUtil.b(BaseApplication.getContext()) == 1) || (bool2)) {}
    for (int i = 1;; i = 0)
    {
      if (("1".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "UseLocalFlowSet"))) || (i != 0)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    d();
  }
  
  public void c()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): AIORequests size=" + i);
    }
    ThreadManager.b(new jlx(this, i));
  }
  
  public void d()
  {
    Logger.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Logger.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1)
    {
      Logger.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
      return;
    }
    int k = PicPreDownloadUtils.a();
    if ((!jdField_b_of_type_Boolean) && (k != 0))
    {
      Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + k);
      return;
    }
    PicReq localPicReq = a();
    int i;
    int j;
    if (localPicReq != null)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g);
      if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null)
      {
        Logger.b("PIC_TAG_PRELOAD", "consume", "picReq.downinfo == null");
        b(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -4);
        return;
      }
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c);
      j = this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, i, k);
      if (j != 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "consume", "isOverLimit, uinType=" + i + " networkType=" + k);
        b(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, j);
        return;
      }
      if ((localPicReq.n == 6) && (this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(i, k)[1] == 0))
      {
        Logger.a("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq to the waiting list, uintype:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b + ", networkType:" + k + ", uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
        return;
      }
      this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
      localPicReq.r = localPicReq.q;
      localPicReq.q = 6;
      this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, Integer.valueOf(6));
      if (localPicReq.n != 6) {
        break label629;
      }
    }
    label629:
    for (String str = " big";; str = " thumb")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq" + str, "uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + "subMsgId:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i + ",priority:" + localPicReq.q);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((localPicReq.n == 6) && (!new File(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b()).exists()))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, k);
        j = -2147483648;
        i = j;
        if (localPicReq != null)
        {
          i = j;
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
            i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.b(k, i);
      }
      ThreadManager.a().post(new jma(this, localPicReq));
      Logger.a("PIC_TAG_PRELOAD", "consume", "END");
      return;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "onDestroy, receiver:" + this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer.purge();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */