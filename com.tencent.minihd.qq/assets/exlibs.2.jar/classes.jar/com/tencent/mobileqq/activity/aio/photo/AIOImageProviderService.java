package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.BaseStrategy;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import fyx;
import fyy;
import fyz;
import fza;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class AIOImageProviderService
  extends IAIOImageProvider.Stub
{
  static final String jdField_a_of_type_JavaLangString = "AIOImageProviderService";
  public int a;
  private final long jdField_a_of_type_Long;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  private final boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  public AIOImageProviderService(String paramString1, String paramString2, int paramInt, MessageForPic paramMessageForPic)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    paramString1 = new ArrayList(1);
    paramString1.add(paramMessageForPic);
    this.jdField_a_of_type_Boolean = paramMessageForPic.isMultiMsg;
    this.jdField_a_of_type_Long = paramMessageForPic.msgseq;
    this.jdField_a_of_type_JavaUtilList = paramString1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private fza a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fza localfza = (fza)localIterator.next();
      if ((localfza.jdField_a_of_type_Long == paramLong) && (localfza.jdField_a_of_type_Int == paramInt)) {
        return localfza;
      }
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {
      return;
    }
    ((PicStatisticsManager)paramQQAppInterface.getManager(69)).d(paramMessageForPic);
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface.a.a(paramMessageForPic, paramMessageForPic.size);
    paramQQAppInterface.d();
  }
  
  public Intent a(long paramLong, int paramInt)
  {
    try
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (MessageForPic)((Iterator)localObject2).next();
        if ((((MessageForPic)localObject1).uniseq == paramLong) && (((MessageForPic)localObject1).subMsgId == paramInt))
        {
          localObject2 = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.b);
          localObject1 = QfavBuilder.a((Entity)localObject1).b((QQAppInterface)localObject2, (MessageRecord)localObject1).a();
          return localObject1;
        }
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      throw new IllegalArgumentException("no appRuntime", localAccountNotMatchException);
    }
    throw new IllegalArgumentException("message not find..");
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilList = null;
    this.b = null;
    this.c = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public void a(long paramLong, int paramInt)
  {
    ThreadManager.a().post(new fyz(this, paramLong, paramInt));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    MessageForPic localMessageForPic;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localMessageForPic = (MessageForPic)((Iterator)localObject1).next();
      if ((localMessageForPic.uniseq == paramLong) && (localMessageForPic.subMsgId == paramInt1))
      {
        if (paramInt2 != 4) {
          break label122;
        }
        localObject2 = a(paramLong, paramInt1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new fza(paramLong, paramInt1);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        }
        if (!paramBoolean) {
          ((fza)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (!((fza)localObject1).b) {
          break label116;
        }
      }
    }
    return;
    label116:
    ((fza)localObject1).b = true;
    label122:
    int i;
    switch (paramInt2)
    {
    case 3: 
    default: 
      return;
    case 1: 
      localObject1 = PicBusiManager.a(5, 1);
      i = 65537;
    }
    for (;;)
    {
      try
      {
        ((PicReq)localObject1).a(localMessageForPic, localMessageForPic.getPicDownloadInfo());
        localObject2 = AbsDownloader.d(URLDrawableHelper.a(localMessageForPic, i, null).toString().toString());
        ((PicReq)localObject1).a(new fyx(this, paramLong, paramInt1, paramInt2, localMessageForPic.size, (String)localObject2));
        PicBusiManager.a((PicReq)localObject1, (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.b));
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
      return;
      PicReq localPicReq = PicBusiManager.a(6, 1536, 1);
      i = 1;
      continue;
      localPicReq = PicBusiManager.a(7, 1);
      i = 131075;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "reportData,sendReportType:" + paramString + ",count:" + paramInt);
    }
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.a.getAppRuntime(this.b);
      if (paramInt == 55)
      {
        StatisticConstants.a(paramString, this.jdField_a_of_type_Int, (QQAppInterface)localAppRuntime);
        return;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(localAppRuntime, this.b, "Pic", paramString, 0, 1, null, String.valueOf(paramInt), null, null, null);
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      throw new IllegalArgumentException("no appRuntime", paramString);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null) {
      return;
    }
    ThreadManager.a().post(new fyy(this));
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    MessageForPic localMessageForPic;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageForPic = (MessageForPic)((Iterator)localObject).next();
    } while ((localMessageForPic.uniseq != paramLong) || (localMessageForPic.subMsgId != paramInt1));
    try
    {
      localObject = ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.b)).a().a(TransFileController.a(localMessageForPic.md5, localMessageForPic.uuid, 131075));
      if ((localObject instanceof C2CPicDownloadProcessor))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "destroy cancel processor:" + localObject);
        }
        ((BaseDownloadProcessor)localObject).g();
      }
      localObject = a(paramLong, paramInt1);
      if (localObject != null)
      {
        ((fza)localObject).b = false;
        ((fza)localObject).jdField_a_of_type_Boolean = false;
      }
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService
 * JD-Core Version:    0.7.0.1
 */