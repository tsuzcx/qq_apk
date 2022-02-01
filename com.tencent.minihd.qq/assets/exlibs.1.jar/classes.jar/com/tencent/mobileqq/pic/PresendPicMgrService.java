package com.tencent.mobileqq.pic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jmf;
import mqq.app.AccountNotMatchException;

public class PresendPicMgrService
  extends IPresendPicMgr.Stub
{
  public static final long a = 209715200L;
  private static PresendPicMgrService jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  public static final String a = "presend_lastDayTime";
  public static final long b = 157286400L;
  public static final String b = "presend_FlowWaste";
  public static final long c = 73400320L;
  private static final String jdField_c_of_type_JavaLangString = "PresendPicMgrService";
  public static final long d = 52428800L;
  public static final int f = 3;
  public static final int g = 4;
  static int jdField_h_of_type_Int = 0;
  private static final int jdField_i_of_type_Int = 1;
  private static final int jdField_j_of_type_Int = 2;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long = 209715200L;
  private boolean jdField_g_of_type_Boolean = false;
  private long jdField_h_of_type_Long = 157286400L;
  private long jdField_i_of_type_Long;
  private long jdField_j_of_type_Long;
  private int k;
  private int l;
  private int m;
  private int n = 0;
  private int o = 90;
  private int p = 70;
  private int q = 50;
  private int r;
  
  public PresendPicMgrService(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.b = new ArrayList();
    this.i = 73400320L;
    this.j = 52428800L;
    this.r = paramInt;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.jdField_f_of_type_JavaLangString = paramString3;
    long l1 = PicPreDownloadUtils.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    Logger.a("PresendPicMgrService", "PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1);
    d();
    if (l2 - l1 > 86400000L)
    {
      Logger.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      StatisticConstants.a(PicPreDownloadUtils.a("presend_FlowWaste", 0L));
      PicPreDownloadUtils.a("presend_lastDayTime", l2);
      PicPreDownloadUtils.a("presend_FlowWaste", 0L);
    }
    this.jdField_f_of_type_Long = PicPreDownloadUtils.a("presend_FlowWaste", 0L);
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = this;
  }
  
  private int a()
  {
    int i1 = 0;
    int i2 = NetworkUtil.a(BaseApplication.getContext());
    switch (i2)
    {
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "getCancelPercent", " NetType = " + i2 + ", cancelpercent = " + i1);
      return i1;
      i1 = this.n;
      continue;
      i1 = this.o;
      continue;
      i1 = this.p;
      continue;
      i1 = this.q;
    }
  }
  
  private PicReq a(ArrayList paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      PicReq localPicReq = (PicReq)paramArrayList.next();
      if (localPicReq.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localPicReq;
      }
    }
    return null;
  }
  
  private PicUploadInfo a(String paramString, boolean paramBoolean)
  {
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).d(this.jdField_d_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).e(this.r);
    ((PicUploadInfo.Builder)localObject).e(this.jdField_e_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).d(1007);
    ((PicUploadInfo.Builder)localObject).i(0);
    localObject = ((PicUploadInfo.Builder)localObject).a();
    ((PicUploadInfo)localObject).jdField_c_of_type_Boolean = true;
    if (PeakUtils.a(paramString)) {
      LogTag.a();
    }
    try
    {
      ((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList = PeakUtils.a(paramString);
      if ((((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + ((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList.toString());
      }
      LogTag.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramString + ")");
      if (paramBoolean)
      {
        ((PicUploadInfo)localObject).jdField_h_of_type_Int = 1;
        Logger.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramString + "'s size is " + FileUtils.a(paramString));
        }
      }
      ((PicUploadInfo)localObject).jdField_h_of_type_Int = ((PicUploadInfo)localObject).a();
    }
    return localObject;
  }
  
  public static PresendPicMgrService a()
  {
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  }
  
  private void a(long paramLong)
  {
    this.jdField_f_of_type_Long += paramLong;
    PicPreDownloadUtils.a("presend_FlowWaste", this.jdField_f_of_type_Long);
    Logger.a("PresendPicMgrService", "PresendStatus calcWasteFlow", " wastesize = " + paramLong + ",mWastedUploadFlow = " + this.jdField_f_of_type_Long);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    Logger.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_f_of_type_JavaLangString);
      localQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        localQQAppInterface.a().d(localQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.a(paramMessageForPic.path);
      localBuilder.d(5);
      localBuilder.d(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag == 1) {
        localBuilder.c(TranDbRecord.PicDbRecord.f);
      }
      for (;;)
      {
        localBuilder.e(paramMessageForPic.senderuin);
        localBuilder.c(paramMessageForPic.selfuin);
        localBuilder.e(paramMessageForPic.istroop);
        localBuilder.j = paramMessageForPic.extLong;
        localBuilder.i = paramMessageForPic.extStr;
        PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
        localRetryInfo.a = paramMessageForPic.msgseq;
        localRetryInfo.b = paramMessageForPic.shmsgseq;
        localRetryInfo.a = paramMessageForPic.msgseq;
        localBuilder.a(localRetryInfo);
        paramMessageForPic = PicBusiManager.a(4, 5);
        paramMessageForPic.a(localBuilder.a());
        PicBusiManager.a(paramMessageForPic, localQQAppInterface);
        return;
        localBuilder.c(TranDbRecord.PicDbRecord.e);
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    Logger.a("PresendPicMgrService", "addMsg", "MessageRecord = " + paramMessageRecord);
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_f_of_type_JavaLangString);
      ((SVIPHandler)localQQAppInterface.a(12)).a(paramMessageRecord);
      if ((PicItemBuilder.g == 1) || (PicItemBuilder.g == 2))
      {
        localQQAppInterface.a().b(paramMessageRecord, localQQAppInterface.a());
        return;
      }
      localQQAppInterface.a().a(paramMessageRecord, localQQAppInterface.a());
      return;
    }
    catch (AccountNotMatchException paramMessageRecord)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
  }
  
  private void a(PicReq paramPicReq)
  {
    synchronized (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
    {
      paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_d_of_type_Boolean = true;
      if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject == null)
      {
        Logger.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
    }
    ??? = (MessageRecord)paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
    for (;;)
    {
      BaseUploadProcessor localBaseUploadProcessor;
      long l1;
      try
      {
        localBaseUploadProcessor = (BaseUploadProcessor)((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_f_of_type_JavaLangString)).a().a(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        if (localBaseUploadProcessor != null) {
          break label240;
        }
        Logger.a("PresendPicMgrService", "doCancel", " processor == null!");
        l1 = ((MessageForPic)???).mPresendTransferedSize;
        long l2 = FileUtils.a(((MessageForPic)???).path);
        Logger.a("PresendPicMgrService", "doCancel", "picSize = " + l2);
        a(l1);
        Logger.a("PresendPicMgrService", "PresendStatus", "Path:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g + ",uuid:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        return;
      }
      catch (AccountNotMatchException paramPicReq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
      return;
      label240:
      int i1 = a();
      if (localBaseUploadProcessor.d() < i1)
      {
        Logger.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + i1 + ", do cancel! ");
        localBaseUploadProcessor.g();
        l1 = localBaseUploadProcessor.b();
      }
      else
      {
        Logger.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + i1 + ", do not cancel!");
        l1 = localBaseUploadProcessor.a();
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    int i1 = NetworkUtil.a(BaseApplication.getContext());
    switch (i1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "PresendStatus isOverWasteLimit", "nettype = " + i1 + " result =  " + bool + ",mWastedUploadFlow = " + this.jdField_f_of_type_Long);
      return bool;
      if (this.jdField_f_of_type_Long <= this.jdField_g_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_f_of_type_Long <= this.j) {
        break;
      }
      continue;
      if (this.jdField_f_of_type_Long <= this.i) {
        break;
      }
      continue;
      if (this.jdField_f_of_type_Long <= this.jdField_h_of_type_Long) {
        break;
      }
    }
  }
  
  private void d()
  {
    Object localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pic_presend.name());
    Logger.a("PresendPicMgrService", "getServerConfig", "presendConfigString = " + (String)localObject1);
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      localObject2 = ((String)localObject1).split("\\|");
      if (localObject2.length >= 16)
      {
        this.jdField_c_of_type_Boolean = localObject2[4].equals("1");
        this.jdField_d_of_type_Boolean = localObject2[5].equals("1");
        this.jdField_e_of_type_Boolean = localObject2[6].equals("1");
        this.jdField_f_of_type_Boolean = localObject2[7].equals("1");
      }
    }
    try
    {
      this.jdField_g_of_type_Long = Long.valueOf(localObject2[8]).longValue();
      this.j = Long.valueOf(localObject2[9]).longValue();
      this.i = Long.valueOf(localObject2[10]).longValue();
      this.jdField_h_of_type_Long = Long.valueOf(localObject2[11]).longValue();
      this.n = Integer.parseInt(localObject2[12]);
      this.o = Integer.parseInt(localObject2[13]);
      this.p = Integer.parseInt(localObject2[14]);
      this.q = Integer.parseInt(localObject2[15]);
      Logger.a("PresendPicMgrService", "getServerConfig", "mEnablePreUpload_WIFI = " + this.jdField_c_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_d_of_type_Boolean + ",mEnablePreUpload_3G = " + this.jdField_e_of_type_Boolean + ",mEnablePreUpload_4G = " + this.jdField_f_of_type_Boolean + "mPreUpMaxWasteSizeWIFI = " + this.jdField_g_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.j + ",mPreUpMaxWasteSize3G = " + this.i + ",mPreUpMaxWasteSize4G = " + this.jdField_h_of_type_Long + ",mCancelPercentWIFI = " + this.n + ",mCancelPercent2G = " + this.o + ",mCancelPercent3G = " + this.p + ",mCancelPercent4G = " + this.q);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 7));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        try
        {
          localObject1 = PicBusiManager.a((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_f_of_type_JavaLangString));
          ((StringBuilder)localObject2).append("|").append(localObject1[0]).append("|").append(localObject1[1]).append("|").append(localObject1[2]).append("|").append(localObject1[3]);
          Logger.a("PresendPicMgrService", "getServerConfig", "compress config = " + ((StringBuilder)localObject2).toString());
          localObject1 = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT <= 10) {
            continue;
          }
          i1 = 4;
          ((Context)localObject1).getSharedPreferences("presend_config_sp", i1).edit().putString("key_presendconfig", ((StringBuilder)localObject2).toString()).commit();
          return;
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          int i1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PresendPicMgrService", 2, "no appRuntime");
        }
        localNumberFormatException = localNumberFormatException;
        localNumberFormatException.printStackTrace();
        continue;
        i1 = 0;
      }
    }
  }
  
  public List a(List paramList)
  {
    Logger.a("PresendPicMgrService", "getNomalSendList", "getNomalSendList called,selectedList = " + paramList);
    paramList = (ArrayList)paramList;
    paramList.add("SSSSS");
    return paramList;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = null;
    Logger.a("PresendPicMgrService", "cancelAll", "");
  }
  
  public void a(String paramString)
  {
    Logger.a("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + paramString);
    PicReq localPicReq = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
    if (localPicReq == null)
    {
      Logger.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localPicReq);
    a(localPicReq);
    Logger.a("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Logger.a("PresendPicMgrService", "PresendStatus presendPic", " path = " + paramString1 + ", localUUID = " + paramString2 + ",fileSize = " + FileUtils.a(paramString1));
    PicReq localPicReq = PicBusiManager.a(2, 1007);
    paramString1 = a(paramString1, paramBoolean);
    localPicReq.a(paramString1);
    localPicReq.a(paramString2);
    if (!paramString1.a())
    {
      Logger.b("PresendPicMgrService", paramString2, paramString1.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_JavaLangString, paramString1.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
      paramString1.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localPicReq);
    }
    do
    {
      return;
      localPicReq.a(new jmf(this, localPicReq));
      if ((!a()) || (b()) || (FileUtils.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g) > 512000L))
      {
        Logger.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localPicReq.a(null);
        localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
      }
      try
      {
        PicBusiManager.a(localPicReq, (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_f_of_type_JavaLangString));
        this.jdField_a_of_type_JavaUtilArrayList.add(localPicReq);
        return;
      }
      catch (AccountNotMatchException paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("PresendPicMgrService", 2, "no appRuntime");
  }
  
  boolean a()
  {
    int i1 = NetworkUtil.a(BaseApplication.getContext());
    boolean bool = false;
    switch (i1)
    {
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "isPreuploadEnable", "nettype = " + i1 + " result =  " + bool);
      return bool;
      bool = this.jdField_c_of_type_Boolean;
      continue;
      bool = this.jdField_d_of_type_Boolean;
      continue;
      bool = this.jdField_e_of_type_Boolean;
      continue;
      bool = this.jdField_f_of_type_Boolean;
    }
  }
  
  public void b()
  {
    Logger.a("PresendPicMgrService", "sendMsg", " ");
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = null;
    Object localObject4;
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_f_of_type_JavaLangString);
        ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)???).hasNext()) {
          break;
        }
        localObject4 = (PicReq)((Iterator)???).next();
        if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int == 4)
        {
          Logger.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
          continue;
        }
        synchronized (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
        {
          Object localObject6 = ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
          if (localObject6 == null) {}
          try
          {
            Logger.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
            ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_Boolean = true;
            ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.wait(3000L);
            Logger.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
            if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject == null) {
              Logger.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString);
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PresendPicMgrService", 2, "no appRuntime");
        }
        return;
      }
      ??? = (MessageRecord)((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
      a((MessageRecord)???);
      if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int == 3)
      {
        Logger.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
        a((MessageForPic)???);
      }
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      synchronized (this.b)
      {
        this.jdField_g_of_type_Boolean = true;
        localObject4 = this.b.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        ??? = (PicReq)((Iterator)localObject4).next();
        int i1 = ((PicReq)???).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int;
        localMessageRecord = (MessageRecord)((PicReq)???).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(???)) {
          break label540;
        }
        if (i1 == 1)
        {
          Logger.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
          localObject1.a().b(localMessageRecord, null);
        }
      }
      Logger.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
      a((MessageForPic)localMessageRecord);
      continue;
      label540:
      Logger.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
    }
  }
  
  public void c()
  {
    int i1 = NetworkUtil.a(BaseApplication.getContext());
    Logger.a("PresendPicMgrService", "handletWifi2Mobile", "netType = " + i1);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      Logger.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }
    for (;;)
    {
      return;
      Iterator localIterator;
      PicReq localPicReq;
      if (i1 == 2)
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localPicReq = (PicReq)localIterator.next();
          a(localPicReq);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
        }
      }
      if (((i1 == 3) || (i1 == 4)) && (b()))
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localPicReq = (PicReq)localIterator.next();
          a(localPicReq);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgrService
 * JD-Core Version:    0.7.0.1
 */