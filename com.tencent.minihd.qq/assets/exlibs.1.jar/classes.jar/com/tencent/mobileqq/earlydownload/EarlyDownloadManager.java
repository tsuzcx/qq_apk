package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.JpegSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoRepairHandler;
import com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler;
import com.tencent.mobileqq.earlydownload.handler.WebpSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class EarlyDownloadManager
  extends ServerConfigObserver
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, Manager
{
  static final int jdField_a_of_type_Int = 131328;
  private static String jdField_a_of_type_JavaLangString;
  public static final Lock a;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qq.android.system.face.gif", "qq.android.qav.so55", "qq.android.qav.sorepair", "qq.android.pic.jpeg.so", "qq.android.pic.webp.so" };
  static final int jdField_b_of_type_Int = 131329;
  static final int c = 131330;
  static final int d = 131331;
  static final int e = 131332;
  static final int f = 131333;
  static final int g = 3;
  public static final int h = 60000;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public EarlyDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.b = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
  }
  
  private static final EarlyHandler a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "createHandler pkgName=" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return null;
      if ("qq.android.system.face.gif".equals(paramString)) {
        return new SystemFaceHandler(paramQQAppInterface);
      }
      if ("qq.android.qav.so55".equals(paramString)) {
        return new QavSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.qav.sorepair".equals(paramString)) {
        return new QavSoRepairHandler(paramQQAppInterface);
      }
      if ("qq.android.pic.jpeg.so".equals(paramString)) {
        return new JpegSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.pic.webp.so".equals(paramString)) {
        return new WebpSoDownloadHandler(paramQQAppInterface);
      }
    } while (!QLog.isColorLevel());
    QLog.e("EarlyDown", 2, "createHandler() can't find Handler for:" + paramString);
    return null;
  }
  
  public static String a()
  {
    Context localContext;
    if ((jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaLangString.length() == 0))
    {
      localContext = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label67;
      }
    }
    label67:
    for (int i = 4;; i = 0)
    {
      jdField_a_of_type_JavaLangString = localContext.getSharedPreferences("Last_Login", i).getString("uin", "");
      if ((jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaLangString.length() <= 0)) {
        break;
      }
      return jdField_a_of_type_JavaLangString;
    }
    return "10000";
  }
  
  private void a(GetResourceRespV2 paramGetResourceRespV2)
  {
    if (paramGetResourceRespV2 == null) {}
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      EarlyHandler localEarlyHandler;
      if (paramGetResourceRespV2.vecDeletedResInfo != null)
      {
        localObject1 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (GetResourceRespInfoV2)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ((GetResourceRespInfoV2)localObject2).strResName;
            localEarlyHandler = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
            if (localEarlyHandler != null) {
              localEarlyHandler.d();
            }
            a((String)localObject2);
          }
        }
      }
      if (paramGetResourceRespV2.vecAddedResInfo != null)
      {
        localObject1 = paramGetResourceRespV2.vecAddedResInfo.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (GetResourceRespInfoV2)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((GetResourceRespInfoV2)localObject2).iPluginType == 512))
          {
            localEarlyHandler = a(((GetResourceRespInfoV2)localObject2).strResName);
            if (localEarlyHandler != null) {
              localEarlyHandler.a(EarlyDataFactory.a(localEarlyHandler.a(), ((GetResourceRespInfoV2)localObject2).strResName, ((GetResourceRespInfoV2)localObject2).strPkgName, ((GetResourceRespInfoV2)localObject2).strResConf, ((GetResourceRespInfoV2)localObject2).uiNewVer, ((GetResourceRespInfoV2)localObject2).strResURL_big, ((GetResourceRespInfoV2)localObject2).strResURL_small));
            }
          }
        }
      }
      if (paramGetResourceRespV2.vecUpdatedResInfo != null)
      {
        paramGetResourceRespV2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
        while (paramGetResourceRespV2.hasNext())
        {
          localObject1 = (GetResourceRespInfoV2)paramGetResourceRespV2.next();
          if ((localObject1 != null) && (((GetResourceRespInfoV2)localObject1).iPluginType == 512))
          {
            localObject2 = a(((GetResourceRespInfoV2)localObject1).strResName);
            if (localObject2 != null) {
              ((EarlyHandler)localObject2).a(EarlyDataFactory.a(((EarlyHandler)localObject2).a(), ((GetResourceRespInfoV2)localObject1).strResName, ((GetResourceRespInfoV2)localObject1).strPkgName, ((GetResourceRespInfoV2)localObject1).strResConf, ((GetResourceRespInfoV2)localObject1).uiNewVer, ((GetResourceRespInfoV2)localObject1).strResURL_big, ((GetResourceRespInfoV2)localObject1).strResURL_small));
            }
          }
        }
      }
    }
  }
  
  private boolean a(XmlData paramXmlData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "verifyResource() data=" + paramXmlData.strResName + ", filepath=" + paramString);
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
      paramString = MD5FileUtil.a(localFile.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "verifyResource.data.md5=" + paramXmlData.MD5 + ", file.md5=" + paramString);
      }
      if (paramXmlData.MD5.equalsIgnoreCase(paramString)) {
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
      paramXmlData.strLog = (".md5.S:" + paramXmlData.MD5 + ".L:" + paramString + ".");
    }
    return false;
  }
  
  private void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("strResName");
    Object localObject2 = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "handleBroadcastReq() resName=" + str + " action=" + (String)localObject2);
    }
    EarlyHandler localEarlyHandler = a(str);
    Object localObject1;
    if (localEarlyHandler == null)
    {
      localObject1 = new Intent(paramIntent.getAction().replace("req.", "resp."));
      ((Intent)localObject1).putExtra("strResName", paramIntent.getStringExtra("strResName"));
      ((Intent)localObject1).putExtra("strPkgName", paramIntent.getStringExtra("strPkgName"));
      ((Intent)localObject1).putExtra("reqResult", false);
      ((Intent)localObject1).putExtra("resultReason", "resName:" + str + " is not valid.");
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.qqhead.permission.getheadresp2");
    }
    do
    {
      do
      {
        return;
        localObject1 = localEarlyHandler.a();
        if ("req.com.tencent.mobileqq.EARLY_DOWNLOAD".equals(localObject2))
        {
          if (((XmlData)localObject1).loadState == 1)
          {
            paramIntent = new Intent("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
            paramIntent.putExtra("reqResult", false);
            paramIntent.putExtra("strResName", str);
            paramIntent.putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
            paramIntent.putExtra("loadState", 1);
            paramIntent.putExtra("resultReason", "resource has been success.");
            BaseApplicationImpl.getContext().sendBroadcast(paramIntent, "com.tencent.qqhead.permission.getheadresp2");
            return;
          }
          localEarlyHandler.b(true);
          localEarlyHandler.a(paramIntent.getBooleanExtra("userClick", false));
          return;
        }
        if ("req.com.tencent.mobileqq.EARLY_QUERY".equals(localObject2))
        {
          paramIntent = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
          paramIntent.putExtra("strResName", str);
          paramIntent.putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
          paramIntent.putExtra("reqResult", true);
          paramIntent.putExtra("loadState", ((XmlData)localObject1).loadState);
          paramIntent.putExtra("totalSize", ((XmlData)localObject1).totalSize);
          paramIntent.putExtra("downSize", ((XmlData)localObject1).downSize);
          BaseApplicationImpl.getContext().sendBroadcast(paramIntent, "com.tencent.qqhead.permission.getheadresp2");
          return;
        }
        if ("req.com.tencent.mobileqq.EARLY_CANCEL".equals(localObject2))
        {
          localEarlyHandler.b(true);
          a(localEarlyHandler.a());
          return;
        }
      } while (!"req.com.tencent.mobileqq.EARLY_SET_FAIL".equals(localObject2));
      localEarlyHandler.c(false);
      localObject2 = new Intent("resp.com.tencent.mobileqq.EARLY_SET_FAIL");
      ((Intent)localObject2).putExtra("strResName", str);
      ((Intent)localObject2).putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
      ((Intent)localObject2).putExtra("reqResult", true);
      ((Intent)localObject2).putExtra("loadState", ((XmlData)localObject1).loadState);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp2");
    } while (!paramIntent.getBooleanExtra("restartDownload", false));
    localEarlyHandler.b(true);
    localEarlyHandler.a(paramIntent.getBooleanExtra("userClick", false));
  }
  
  private void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "doOnCancelDownload() name=" + paramXmlData.strResName + ",strResURL_big=" + paramXmlData.strResURL_big + ",strResURL_small=" + paramXmlData.strResURL_small + ",localVer=" + paramXmlData.Version);
    }
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    EarlyHandler localEarlyHandler;
    do
    {
      try
      {
        localObject = (NetReq)this.b.remove(paramXmlData.strResName);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localEarlyHandler = a(paramXmlData.strResName);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b((NetReq)localObject);
          paramXmlData.tStart = 0L;
          EarlyDataFactory.a(paramXmlData, new String[] { "tStart" });
          paramXmlData.loadState = 0;
          EarlyDataFactory.a(paramXmlData, new String[] { "loadState" });
          if (localEarlyHandler != null) {
            localEarlyHandler.c(paramXmlData);
          }
          return;
        }
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    } while ((localEarlyHandler == null) || (!localEarlyHandler.b()));
    Object localObject = new Intent("resp.com.tencent.mobileqq.EARLY_CANCEL");
    ((Intent)localObject).putExtra("reqResult", false);
    ((Intent)localObject).putExtra("resultReason", "resName=" + paramXmlData.strResName + " is not loading..");
    ((Intent)localObject).putExtra("strResName", paramXmlData.strResName);
    ((Intent)localObject).putExtra("strPkgName", paramXmlData.strPkgName);
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp2");
    localEarlyHandler.b(false);
  }
  
  private void b(NetResp paramNetResp)
  {
    XmlData localXmlData = (XmlData)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (localXmlData == null) {}
    for (;;)
    {
      return;
      long l3 = SystemClock.elapsedRealtime();
      long l4 = localXmlData.tStart;
      long l1 = 0L;
      try
      {
        long l2 = new File(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b).length();
        l1 = l2;
      }
      catch (Exception localException2)
      {
        label54:
        boolean bool1;
        label64:
        boolean bool2;
        break label54;
      }
      if (paramNetResp.e == 0)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          if (paramNetResp.b < 0L) {}
          bool1 = a(localXmlData, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
          if (!bool1)
          {
            paramNetResp.f = -6103066;
            paramNetResp.jdField_a_of_type_JavaLangString = ("md5_not_same.netSize:" + l1 + localXmlData.strLog);
            localXmlData.strLog = "";
          }
        }
      }
      try
      {
        FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
        label159:
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("EarlyDown", 2, "doOnResp() verifyResource=" + bool1 + " resName=" + localXmlData.strResName);
          bool2 = bool1;
        }
        int i = localXmlData.reqLoadCount;
        if (((paramNetResp.f == -6103066) || (paramNetResp.f == -9527)) && (i < 3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "retry load.resName:" + localXmlData.strResName + ".reqCount=" + localXmlData.reqLoadCount + ".errCode=" + paramNetResp.f);
          }
          a(localXmlData, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
          return;
          bool1 = false;
          break label64;
        }
        localXmlData.reqLoadCount = 0;
        EarlyHandler localEarlyHandler = a(localXmlData.strResName);
        if (bool2)
        {
          localXmlData.tLoadFail = 0L;
          localXmlData.loadState = 1;
          if ((!localXmlData.StoreBackup) || (localEarlyHandler == null)) {}
        }
        try
        {
          Object localObject = localEarlyHandler.c();
          bool1 = FileUtils.c(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b, (String)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "onDownloadFinish() copyResult=" + bool1 + " src=" + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b + " dest=" + (String)localObject);
          }
          label456:
          EarlyDataFactory.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail" });
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "doOnResp() result=" + bool2 + " errCode=" + paramNetResp.f + " name=" + localXmlData.strResName + ",strResURL_big=" + localXmlData.strResURL_big);
          }
          jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
          try
          {
            localObject = (NetReq)this.b.remove(localXmlData.strResName);
            jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
            if (localObject != null)
            {
              if (localEarlyHandler != null)
              {
                localEarlyHandler.a(localXmlData, bool2, paramNetResp.f, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
                localEarlyHandler.c();
              }
              if ((paramNetResp.f == 9366) || (paramNetResp.f == 9037) || (paramNetResp.f == 9004) || (paramNetResp.f == 9040)) {
                continue;
              }
              localObject = new HashMap();
              ((HashMap)localObject).put("param_FailCode", Integer.toString(paramNetResp.f));
              ((HashMap)localObject).put("param_strPkgName", localXmlData.strPkgName);
              ((HashMap)localObject).put("param_reqCount", Integer.toString(i));
              if (!bool2)
              {
                if (paramNetResp.jdField_a_of_type_JavaUtilHashMap != null)
                {
                  String str = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("serverip");
                  if ((str != null) && (str.length() > 0)) {
                    ((HashMap)localObject).put("param_serverIP", str);
                  }
                }
                if ((paramNetResp.jdField_a_of_type_JavaLangString != null) && (paramNetResp.jdField_a_of_type_JavaLangString.length() > 0))
                {
                  ((HashMap)localObject).put("param_desc", paramNetResp.jdField_a_of_type_JavaLangString + localXmlData.strLog);
                  localXmlData.strLog = "";
                }
              }
              if (localEarlyHandler == null) {
                continue;
              }
              paramNetResp = localEarlyHandler.a();
              if ((paramNetResp == null) || (paramNetResp.length() <= 0)) {
                continue;
              }
              return;
              if ((paramNetResp.f != 9366) && (paramNetResp.f != 9369) && (paramNetResp.f != 9367) && (paramNetResp.f != 9037) && (paramNetResp.f != 9004)) {
                localXmlData.tLoadFail = System.currentTimeMillis();
              }
              if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "set tLoadFail=" + localXmlData.tLoadFail + " strPkgName=" + localXmlData.strResName);
              }
              localEarlyHandler.c(true);
              FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
            }
          }
          finally
          {
            jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          }
          QLog.d("EarlyDown", 2, "doOnResp. netReq is null. may has been cancelled.");
          return;
        }
        catch (Exception localException3)
        {
          break label456;
        }
      }
      catch (Exception localException1)
      {
        break label159;
      }
    }
  }
  
  public EarlyHandler a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    EarlyHandler localEarlyHandler;
    do
    {
      do
      {
        return localObject;
        localEarlyHandler = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        localObject = localEarlyHandler;
      } while (localEarlyHandler != null);
      localEarlyHandler = a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = localEarlyHandler;
    } while (localEarlyHandler == null);
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localEarlyHandler);
      }
      return localEarlyHandler;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        bool = this.jdField_a_of_type_AndroidOsHandler.hasMessages(131331);
        if ((!this.jdField_a_of_type_Boolean) || (bool)) {
          break;
        }
        Message localMessage = Message.obtain();
        localMessage.what = 131330;
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(131330)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(131330);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 60000L);
      } while (!QLog.isColorLevel());
      QLog.d("EarlyDown", 2, "onNetChange() sendMsg:ACTION_NET_CHANGE, delay(ms):60000");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "onNetChanged() return, afterAppStart=" + this.jdField_a_of_type_Boolean + " hasMsg:" + bool);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramIntent;
      localMessage.what = 131333;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  void a(XmlData paramXmlData)
  {
    if (paramXmlData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "cancelDownload.name=" + paramXmlData.strResName + ",strResURL_big=" + paramXmlData.strResURL_big + ",localVer=" + paramXmlData.Version);
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131329, paramXmlData).sendToTarget();
  }
  
  public void a(XmlData paramXmlData, String paramString)
  {
    if ((paramXmlData == null) || (paramString == null) || (paramString.length() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("downloadResource() return, ");
        if (paramXmlData != null) {
          break label58;
        }
        paramXmlData = "data==null";
        QLog.d("EarlyDown", 2, paramXmlData);
      }
    }
    label58:
    do
    {
      do
      {
        return;
        paramXmlData = "storagePath=" + paramString;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "downloadResource() name=" + paramXmlData.strResName + " strResURL_big=" + paramXmlData.strResURL_big + " storagePath=" + paramString);
        }
      } while (TextUtils.isEmpty(paramXmlData.strResURL_big));
      if ((paramXmlData.reqLoadCount != 0) || (!this.b.containsKey(paramXmlData.strResName))) {
        break label233;
      }
      if (paramXmlData.loadState == 0)
      {
        paramXmlData.loadState = 2;
        EarlyDataFactory.a(paramXmlData, new String[] { "loadState" });
      }
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "downloadResource() return, already exist=" + paramXmlData.strResName);
    return;
    label233:
    paramXmlData.tStart = SystemClock.elapsedRealtime();
    paramXmlData.loadState = 2;
    EarlyDataFactory.a(paramXmlData, new String[] { "loadState" });
    Object localObject = a(paramXmlData.getStrResName());
    if ((localObject != null) && (paramXmlData.reqLoadCount == 0)) {
      ((EarlyHandler)localObject).b(paramXmlData);
    }
    paramXmlData.reqLoadCount += 1;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramXmlData.strResURL_big;
    localHttpNetReq.c = 0;
    localHttpNetReq.a(paramXmlData);
    localHttpNetReq.b = paramString;
    localHttpNetReq.d = true;
    localHttpNetReq.e = true;
    if (paramXmlData.isUserClick) {}
    for (localHttpNetReq.l = 1;; localHttpNetReq.l = 2)
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        this.b.put(paramXmlData.strResName, localHttpNetReq);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (XmlData)paramNetReq.a();
    paramNetReq.totalSize = paramLong2;
    paramNetReq.downSize = paramLong1;
    if (paramNetReq != null)
    {
      paramNetReq = a(paramNetReq.strResName);
      if (paramNetReq != null) {
        paramNetReq.a(paramLong1, paramLong2);
      }
    }
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(".start=" + localHttpNetReq.jdField_a_of_type_Long + ".written=" + paramNetResp.c);
      localHttpNetReq.jdField_a_of_type_Long += paramNetResp.c;
      paramNetResp.c = 0L;
      paramNetResp = "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-";
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
      localStringBuffer.append(".range=");
      localStringBuffer.append(paramNetResp);
    } while (!(paramNetReq.a() instanceof XmlData));
    ((XmlData)paramNetReq.a()).strLog = localStringBuffer.toString();
  }
  
  public void a(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131328, paramNetResp).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "removeHandler() strResName=" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        paramString = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (paramString == null) {
          continue;
        }
        paramString.a();
        return;
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "onServerResp() afterAppStart=true");
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 131332;
      localMessage.obj = paramGetResourceRespInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long + 7200000 > SystemClock.elapsedRealtime()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "updateConfigs() timeUpdateSuccess + delay(" + 120 + "min) > now. return.");
      }
      return;
    }
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = null;
      localObject = a((String)localObject);
      if (localObject != null) {
        localGetResourceReqInfoV2 = ((EarlyHandler)localObject).a();
      }
      if (localGetResourceReqInfoV2 != null) {
        localArrayList.add(localGetResourceReqInfoV2);
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "getPluginList: 128 reqInfoV2s.len=" + localArrayList.size());
    }
    ((ServerConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(4)).getPluginConfig(512, localReqUserInfo, localArrayList, this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b((NetResp)paramMessage.obj);
      continue;
      b((XmlData)paramMessage.obj);
      continue;
      b();
      continue;
      Object localObject = null;
      if (paramMessage.obj != null) {
        localObject = (GetResourceRespV2)paramMessage.obj;
      }
      a((GetResourceRespV2)localObject);
      continue;
      if ((paramMessage.obj instanceof GetResourceRespInfo))
      {
        paramMessage = (GetResourceRespInfo)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "doOnServerResp() iResult=" + paramMessage.iResult + " resp.strPkgName=" + paramMessage.strPkgName);
        }
        if (paramMessage.iResult == 0)
        {
          localObject = a(paramMessage.strResName);
          if (localObject != null)
          {
            ((EarlyHandler)localObject).a(EarlyDataFactory.a(((EarlyHandler)localObject).a(), paramMessage.strResName, paramMessage.strPkgName, paramMessage.strResConf, paramMessage.uiNewVer, paramMessage.strResURL_big, paramMessage.strResURL_small));
            continue;
            if ((paramMessage.obj instanceof Intent)) {
              b((Intent)paramMessage.obj);
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaLangString = null;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfString[i];
      localObject2 = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (localObject2 != null) {
        ((EarlyHandler)localObject2).a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("onGetPluginConfig() isSucc=" + paramBoolean + " iPluginType=" + paramInt);
      if (paramGetResourceRespV2 != null)
      {
        ((StringBuffer)localObject).append(" result=" + paramGetResourceRespV2.result);
        ((StringBuffer)localObject).append(" uin=" + paramGetResourceRespV2.uin);
        StringBuilder localStringBuilder = new StringBuilder().append(" add=");
        if (paramGetResourceRespV2.vecAddedResInfo != null)
        {
          i = paramGetResourceRespV2.vecAddedResInfo.size();
          ((StringBuffer)localObject).append(i);
          localStringBuilder = new StringBuilder().append(" update=");
          if (paramGetResourceRespV2.vecUpdatedResInfo == null) {
            break label328;
          }
          i = paramGetResourceRespV2.vecUpdatedResInfo.size();
          label191:
          ((StringBuffer)localObject).append(i);
          localStringBuilder = new StringBuilder().append(" delete=");
          if (paramGetResourceRespV2.vecDeletedResInfo == null) {
            break label334;
          }
          i = paramGetResourceRespV2.vecDeletedResInfo.size();
          label238:
          ((StringBuffer)localObject).append(i);
        }
      }
      else
      {
        QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
        ((StringBuffer)localObject).setLength(0);
        if ((!this.jdField_a_of_type_Boolean) && (paramInt == 512)) {
          ((StringBuffer)localObject).append("set afterAppStart=true");
        }
        ((StringBuffer)localObject).append(" send Config msg delay=60000");
        QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      }
    }
    else
    {
      if (paramInt == 512) {
        break label340;
      }
    }
    label328:
    label334:
    label340:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        i = 0;
        break label191;
        i = 0;
        break label238;
        this.jdField_a_of_type_Boolean = true;
      } while ((!paramBoolean) || (paramGetResourceRespV2 == null));
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    Object localObject = Message.obtain();
    ((Message)localObject).what = 131331;
    ((Message)localObject).obj = paramGetResourceRespV2;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDownloadManager
 * JD-Core Version:    0.7.0.1
 */