package com.tencent.open.downloadnew;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.util.Iterator;
import java.util.List;
import lhp;
import lhr;

public class MyAppApi$YYBDownloadListener
  implements DownloadListener
{
  protected MyAppApi$YYBDownloadListener(MyAppApi paramMyAppApi) {}
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadPause");
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.k, paramDownloadInfo.a());
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadError");
      if ((paramDownloadInfo.k != 100) && (paramDownloadInfo.j != 4)) {
        break label46;
      }
      c(paramDownloadInfo);
    }
    label46:
    while ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog == null) || (!this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) || (!this.a.c)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.k, paramDownloadInfo.a());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
      }
      DownloadManager.a().b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.b.equals("1101070898"))
        {
          LogUtility.c("MyAppApi", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
            this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(localDownloadInfo.k, localDownloadInfo.a());
          }
        }
      }
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadWait");
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.k, paramDownloadInfo.a());
      }
    }
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    long l2;
    long l1;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadFinish");
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(100, 4);
      }
      LogUtility.c("MyAppApi", "installParam: " + this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams);
      if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null)
      {
        if (!this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean) {
          break label294;
        }
        ThreadManager.b().postDelayed(new lhp(this, paramDownloadInfo), 500L);
        this.a.jdField_a_of_type_Boolean = true;
        this.a.jdField_b_of_type_Boolean = false;
        l2 = 0L;
        this.a.b();
        l1 = l2;
        switch (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l1 = this.a.a(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Long = l1;
      this.a.jdField_b_of_type_Long = System.currentTimeMillis();
      DownloadManager.a().b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
      return;
      label294:
      if ((AppUtil.a() != 1) || (!ControlPolicyUtil.c())) {
        break;
      }
      ThreadManager.b().postDelayed(new lhr(this, paramDownloadInfo), 500L);
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_b_of_type_Boolean = false;
      break;
      this.a.e = true;
      if (this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
      {
        l1 = this.a.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.addDownloadTaskFromAuthorize(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      }
      else
      {
        LogUtility.e("MyAppApi", "CopyAndInstallTask->onPostExecute lastAuthorizeParam = null");
        l1 = l2;
        continue;
        l1 = this.a.b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        continue;
        l1 = this.a.a(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
  
  public void c(String paramString1, String paramString2) {}
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.b.equals("1101070898")))
    {
      LogUtility.c("MyAppApi", "onDownloadCancel");
      if ((this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(paramDownloadInfo.k, paramDownloadInfo.a());
      }
      DownloadManager.a().b(this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener
 * JD-Core Version:    0.7.0.1
 */