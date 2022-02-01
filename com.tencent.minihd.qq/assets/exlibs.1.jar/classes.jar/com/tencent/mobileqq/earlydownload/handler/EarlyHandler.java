package com.tencent.mobileqq.earlydownload.handler;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

public abstract class EarlyHandler
{
  public static final int a = 43200000;
  static final String jdField_a_of_type_JavaLangString = "early";
  static final String b;
  private static final String c = "actEarlyDownUse";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  protected ArrayList a;
  protected boolean a;
  protected boolean b;
  protected boolean c;
  private String d;
  
  static
  {
    jdField_b_of_type_JavaLangString = AppConstants.aG + "early";
  }
  
  public EarlyHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.d = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    int i = 0;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      i = localXmlData.Version;
    }
    return i;
  }
  
  public final XmlData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = EarlyDataFactory.a(a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  }
  
  public abstract Class a();
  
  public abstract String a();
  
  public GetResourceReqInfo a()
  {
    Object localObject = null;
    XmlData localXmlData = a();
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = localXmlData.strPkgName;
      ((GetResourceReqInfo)localObject).uiCurVer = a();
      ((GetResourceReqInfo)localObject).sResType = 512;
      ((GetResourceReqInfo)localObject).sLanType = 1;
      ((GetResourceReqInfo)localObject).sReqType = 1;
    }
    while (!QLog.isColorLevel()) {
      return localObject;
    }
    localObject = new StringBuffer("getResourceReqInfo() return null.");
    if (localXmlData == null) {
      ((StringBuffer)localObject).append("data==null");
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      return null;
      ((StringBuffer)localObject).append("resName=" + localXmlData.strResName);
      ((StringBuffer)localObject).append(".pkgName=" + localXmlData.strPkgName);
    }
  }
  
  public GetResourceReqInfoV2 a()
  {
    Object localObject = null;
    XmlData localXmlData = a();
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfoV2();
      ((GetResourceReqInfoV2)localObject).cState = 0;
      ((GetResourceReqInfoV2)localObject).sLanType = 1;
      ((GetResourceReqInfoV2)localObject).sResSubType = 1;
      ((GetResourceReqInfoV2)localObject).strPkgName = localXmlData.strPkgName;
      if (f())
      {
        l = 0L;
        ((GetResourceReqInfoV2)localObject).uiCurVer = l;
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return localObject;
        long l = a();
      }
    }
    localObject = new StringBuffer("getResourceReqInfo() return null.");
    if (localXmlData == null) {
      ((StringBuffer)localObject).append("data==null");
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      return null;
      ((StringBuffer)localObject).append("resName=" + localXmlData.strResName);
      ((StringBuffer)localObject).append(".pkgName=" + localXmlData.strPkgName);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      XmlData localXmlData = a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public void a(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if (paramEarlyDownLoadListener != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramEarlyDownLoadListener);
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    Object localObject1 = null;
    if (paramXmlData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "doOnServerResp() return respData == null.");
      }
      return;
    }
    XmlData localXmlData = a();
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "doOnServerResp() serverVer=" + paramXmlData.Version + " localVer=" + localXmlData.Version + " localState=" + localXmlData.loadState);
    }
    File localFile1 = new File(b());
    if (localFile1.exists()) {}
    for (;;)
    {
      for (;;)
      {
        File localFile2;
        Object localObject2;
        Object localObject4;
        try
        {
          String str1 = MD5FileUtil.a(localFile1);
          if ((str1 != null) && (paramXmlData.MD5 != null) && (str1.toLowerCase().equals(paramXmlData.MD5.toLowerCase())))
          {
            localObject1 = localFile1;
            localFile2 = new File(c());
            if ((localObject1 != null) || (!localXmlData.StoreBackup) || (!localFile2.exists())) {
              continue;
            }
          }
        }
        catch (Exception localException1)
        {
          try
          {
            String str2 = MD5FileUtil.a(localFile2);
            if ((str2 != null) && (paramXmlData.MD5 != null) && (str2.toLowerCase().equals(paramXmlData.MD5.toLowerCase())))
            {
              localObject1 = localFile2;
              if (localObject1 != null) {
                break label486;
              }
              if (i()) {
                break label399;
              }
              if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "user not need download.just save data and do nothing. resName=" + this.d);
              }
              localXmlData.updateServerInfo(paramXmlData);
              localXmlData.loadState = 1;
              EarlyDataFactory.a(localXmlData, new String[0]);
              return;
              localException1 = localException1;
              localException1.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed:" + localFile1.getAbsolutePath());
              }
              localObject2 = null;
              continue;
              localFile1.delete();
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            localObject4 = localObject2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed:" + localFile2.getAbsolutePath());
            localObject4 = localObject2;
            continue;
            localFile2.delete();
          }
          continue;
        }
        label399:
        if (paramXmlData.Version < localXmlData.Version) {
          break;
        }
        if (paramXmlData.Version == localXmlData.Version)
        {
          if (localXmlData.loadState == 1) {
            break;
          }
          localXmlData.updateServerInfo(paramXmlData);
          EarlyDataFactory.a(localXmlData, new String[0]);
          e();
          return;
        }
        if (paramXmlData.Version <= localXmlData.Version) {
          break;
        }
        localXmlData.updateServerInfo(paramXmlData);
        EarlyDataFactory.a(localXmlData, new String[0]);
        e();
        return;
        label486:
        localXmlData.updateServerInfo(paramXmlData);
        localXmlData.Version = paramXmlData.Version;
        localXmlData.loadState = 1;
        if ((!localFile1.exists()) && (!a())) {}
        try
        {
          for (;;)
          {
            FileUtils.a(localObject1, localFile1);
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "doOnServerResp() copy[" + localObject1.getAbsolutePath() + "] to [" + localFile1.getAbsolutePath() + "]");
            }
            label583:
            a(localObject1.getAbsolutePath());
            EarlyDataFactory.a(localXmlData, new String[0]);
            if (this.c)
            {
              localObject2 = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
              ((Intent)localObject2).putExtra("strResName", this.d);
              ((Intent)localObject2).putExtra("strPkgName", localXmlData.strPkgName);
              ((Intent)localObject2).putExtra("loadState", 1);
              ((Intent)localObject2).putExtra("totalSize", localXmlData.totalSize);
              ((Intent)localObject2).putExtra("downSize", localXmlData.downSize);
              ((Intent)localObject2).putExtra("resPath", localObject1.getAbsolutePath());
              BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp2");
              this.c = false;
              if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "set isBroadcast false. send Broadcast: resName" + this.d);
              }
            }
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_strPkgName", localXmlData.strPkgName);
            ((HashMap)localObject2).put("param_byBackup", Boolean.TRUE.toString());
            localObject4 = a();
            if ((localObject4 != null) && (((String)localObject4).length() > 0)) {
              StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject4, true, 2000L, localFile1.length(), (HashMap)localObject2, "");
            }
            if ((localFile2.exists()) || (!paramXmlData.StoreBackup)) {
              break;
            }
            try
            {
              FileUtils.a(localObject1, localFile2);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("EarlyDown", 2, "doOnServerResp() copy[" + localObject1.getAbsolutePath() + "] to [" + localFile2.getAbsolutePath() + "]");
              return;
            }
            catch (Exception paramXmlData)
            {
              return;
            }
          }
        }
        catch (Exception localException2)
        {
          break label583;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadFinish() result=" + paramBoolean + " filePath=" + paramString);
    }
    if (paramBoolean) {
      a(paramString);
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, a(), paramString);
      }
    }
    if (this.c)
    {
      localObject = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
      if (paramInt != 9037) {
        break label250;
      }
      ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_CANCEL");
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("strResName", this.d);
      ((Intent)localObject).putExtra("strPkgName", a().strPkgName);
      ((Intent)localObject).putExtra("loadState", a().loadState);
      ((Intent)localObject).putExtra("totalSize", paramXmlData.totalSize);
      ((Intent)localObject).putExtra("downSize", paramXmlData.downSize);
      ((Intent)localObject).putExtra("errCode", paramInt);
      ((Intent)localObject).putExtra("resPath", paramString);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp2");
      this.c = false;
      return;
      label250:
      ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_QUERY");
    }
  }
  
  public abstract void a(String paramString);
  
  public void a(boolean paramBoolean)
  {
    new File(b()).delete();
    XmlData localXmlData = a();
    localXmlData.Version = 0;
    localXmlData.tLoadFail = 0L;
    localXmlData.loadState = 0;
    EarlyDataFactory.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail" });
    localXmlData.isUserClick = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "restartDownload() resName=" + localXmlData.strResName + " user=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    GetResourceReqInfo localGetResourceReqInfo = a();
    if (localGetResourceReqInfo != null)
    {
      localIntent.putExtra("reqResult", true);
      ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).a(null, new GetResourceReqInfo[] { localGetResourceReqInfo });
    }
    for (;;)
    {
      if (this.c)
      {
        localIntent.setAction("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
        localIntent.putExtra("strResName", this.d);
        localIntent.putExtra("strPkgName", localXmlData.strPkgName);
        BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp2");
      }
      return;
      localIntent.putExtra("reqResult", false);
      localIntent.putExtra("resultReason", "strPkgName=" + localXmlData.strPkgName);
    }
  }
  
  public abstract boolean a();
  
  public boolean a(XmlData paramXmlData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "verifyResource() data=" + paramXmlData + ", filepath=" + paramString);
    }
    if ((paramXmlData == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (TextUtils.isEmpty(paramXmlData.MD5)) {
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "verifyResource() file[" + paramString + "] not exist..");
      }
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = MD5FileUtil.a(localFile);
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "verifyResource() data.md5=" + paramXmlData.MD5 + ", file.md5=" + paramString);
      }
      if ((paramString != null) && (paramXmlData.MD5.toLowerCase().equals(paramString.toLowerCase()))) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed");
          paramString = localObject;
        }
      }
    }
    return false;
  }
  
  public String b()
  {
    File localFile = BaseApplication.getContext().getDir("early", 0);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.d;
  }
  
  public void b()
  {
    if (!a()) {
      new File(b()).delete();
    }
  }
  
  public void b(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if ((paramEarlyDownLoadListener != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramEarlyDownLoadListener);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadBegin()");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(paramXmlData);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "setIsBroadcast() " + paramBoolean);
      }
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public String c()
  {
    File localFile = new File(jdField_b_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.d;
  }
  
  public void c()
  {
    if (a())
    {
      File localFile = new File(b());
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "doAfterFinish() deleteResouceAfterDownload==true, delete storage:" + localFile.getAbsolutePath() + " bool=" + bool);
        }
      }
    }
  }
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EarlyDown", 2, "onDownloadCancel");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).b(paramXmlData);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "setFail() resName:" + this.d);
    }
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      if (localXmlData.loadState != 1) {
        break label83;
      }
      localXmlData.loadState = 0;
      localXmlData.Version = 0;
    }
    for (;;)
    {
      EarlyDataFactory.a(localXmlData, new String[] { "loadState", "Version" });
      return;
      label83:
      if ((localXmlData.loadState == 2) && (paramBoolean)) {
        localXmlData.loadState = 0;
      }
    }
  }
  
  public boolean c()
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      if (NetworkUtil.g(BaseApplicationImpl.getContext())) {
        if (!localXmlData.loadWifi) {
          break label310;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " isWifiConn=true, " + localXmlData.strResName + ":loadWifi=" + localXmlData.loadWifi);
        bool1 = bool2;
      }
      return bool1;
      if (NetworkUtil.c(BaseApplicationImpl.getContext())) {
        if (NetworkUtil.d(BaseApplicationImpl.getContext())) {
          if (!localXmlData.load3G) {
            break label305;
          }
        }
      }
      label305:
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is3Gor4G=true, " + localXmlData.strResName + ":load3G=" + localXmlData.load3G);
        return bool2;
        if (localXmlData.load2G) {}
        for (bool2 = bool3;; bool2 = false)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is2G=true, " + localXmlData.strResName + ":load2G=" + localXmlData.load2G);
          return bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, "isNetValid2Down() return:false, no wifi and no MobileNet.");
            return false;
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "isNetValid2Download() return false, data == null");
            }
          }
          return false;
        }
      }
      label310:
      bool2 = false;
    }
  }
  
  public void d()
  {
    String str = b();
    try
    {
      new File(str).delete();
      label17:
      EarlyDataFactory.a(a());
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          i = 1;
        }
        if (i == 1)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_strResName", this.d);
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "statisticUsage() strResName=" + this.d + " inUse=" + paramBoolean);
          }
        }
        return;
      }
      finally {}
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        i = 1;
      }
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    XmlData localXmlData = a();
    boolean bool1 = bool2;
    if (localXmlData != null)
    {
      long l = System.currentTimeMillis();
      if (localXmlData.tLoadFail != 0L)
      {
        bool1 = bool2;
        if (localXmlData.tLoadFail > 0L)
        {
          bool1 = bool2;
          if (localXmlData.tLoadFail + 43200000L >= l) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "isTimeValid() " + bool1 + " tLoadFail=" + localXmlData.tLoadFail);
    }
    return bool1;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    XmlData localXmlData = a();
    boolean bool3 = c();
    boolean bool1;
    if (!d()) {
      if (NetworkUtil.g(BaseApplicationImpl.getContext())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((bool3) && (bool1))
      {
        ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73)).a(localXmlData, b());
        bool2 = true;
      }
      while (!QLog.isColorLevel())
      {
        return bool2;
        bool1 = false;
        break;
      }
      QLog.d("EarlyDown", 2, "downloadResource() return false, netValid=" + bool3 + " timeValid=" + bool1 + " strResName=" + this.d);
      return false;
      bool1 = true;
    }
  }
  
  public boolean f()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    XmlData localXmlData = a();
    if (localXmlData == null)
    {
      bool2 = bool1;
      return bool2;
    }
    System.currentTimeMillis();
    if (localXmlData.loadState == 1) {
      if (!a())
      {
        bool1 = bool2;
        if (!new File(b()).exists())
        {
          c(false);
          b();
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EarlyDown", 2, "isNeedServerInfo() need=" + bool1);
      return bool1;
      bool1 = false;
      continue;
      bool1 = bool2;
      if (localXmlData.Version != 0)
      {
        bool1 = bool2;
        if (localXmlData.loadState != 2)
        {
          localXmlData.Version = 0;
          EarlyDataFactory.a(localXmlData, new String[] { "Version" });
          bool1 = bool2;
        }
      }
    }
  }
  
  public boolean g()
  {
    XmlData localXmlData = a();
    if (localXmlData == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "enableNetChangedGoOn() return false. data == null");
      }
    }
    do
    {
      return false;
      if (NetworkUtil.g(BaseApplicationImpl.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "enableNetChangedGoOn() isWifi, return " + localXmlData.net_2_wifi + " resName=" + localXmlData.strResName);
        }
        return localXmlData.net_2_wifi;
      }
      if (NetworkUtil.c(BaseApplicationImpl.getContext()))
      {
        if (NetworkUtil.d(BaseApplicationImpl.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "enableNetChangedGoOn() is3Gor4G, return " + localXmlData.net_2_3G + " resName=" + localXmlData.strResName);
          }
          return localXmlData.net_2_3G;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "enableNetChangedGoOn() is2G, return " + localXmlData.net_2_2G + " resName=" + localXmlData.strResName);
        }
        return localXmlData.net_2_2G;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "enableNetChangedGoOn() return false. no wifi or mobile net. resName=" + localXmlData.strResName);
    return false;
  }
  
  public boolean h()
  {
    XmlData localXmlData = a();
    if (localXmlData != null) {
      return localXmlData.loadState == 1;
    }
    return false;
  }
  
  public boolean i()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.EarlyHandler
 * JD-Core Version:    0.7.0.1
 */