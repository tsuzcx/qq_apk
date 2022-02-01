package com.tencent.open.downloadnew;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import lhn;
import lho;

public class MyAppApi$QQDownloadListener
  implements ITMAssistantCallBackListener
{
  protected MyAppApi$QQDownloadListener(MyAppApi paramMyAppApi) {}
  
  public void OnDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
  {
    LogUtility.b("MyAppApi", "OnDownloadTaskProgressChanged  receiveDataLen:" + paramLong1 + ",totalDataLen:" + paramLong2);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    DownloadManager localDownloadManager = DownloadManager.a();
    DownloadInfo localDownloadInfo2 = localDownloadManager.a(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = this.a.a(paramTMAssistantCallYYBParamStruct, null);
      localDownloadManager.e(localDownloadInfo1);
    }
    localDownloadInfo1.k = i;
    localDownloadInfo1.a(2);
    localDownloadManager.a(2, localDownloadInfo1);
    LogUtility.a("MyAppApi", "OnDownloadTaskProgressChanged info state=" + localDownloadInfo1.a() + " progress=" + localDownloadInfo1.k);
  }
  
  public void OnDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    this.a.b = true;
    LogUtility.b("MyAppApi", "OnDownloadTaskStateChanged");
    ThreadManager.b().post(new lhn(this, paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString));
  }
  
  public void OnQQDownloaderInvalid()
  {
    LogUtility.b("MyAppApi", "应用宝挂了");
    ThreadManager.b().post(new lho(this));
  }
  
  public void OnServiceFree()
  {
    LogUtility.b("MyAppApi", "OnServiceFree");
    try
    {
      ((TMAssistantCallYYB_V2)this.a.a).releaseIPCConnected();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener
 * JD-Core Version:    0.7.0.1
 */