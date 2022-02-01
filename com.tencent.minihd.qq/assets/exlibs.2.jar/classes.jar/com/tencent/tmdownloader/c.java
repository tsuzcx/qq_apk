package com.tencent.tmdownloader;

import android.os.RemoteCallbackList;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdownloader.internal.a.f;
import java.util.HashMap;
import java.util.Map;

public class c
  extends e
{
  protected c(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public int a()
  {
    k.c("TMAssistantDownloadSDKService", "returnValue: 1");
    return 1;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + this.a.mServiceDownloadTaskManager + ",fileName:" + paramString4);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      com.tencent.tmdownloader.internal.b.a.a().a(paramString1, paramString2);
      paramInt = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2, paramInt, paramString3, paramString4, paramMap);
      k.c("TMAssistantDownloadSDKService", "returnValue: " + paramInt);
      k.c("TMAssistantDownloadSDKService", "exit");
      return paramInt;
    }
    k.c("TMAssistantDownloadSDKService", "returnValue: TMAssistantDownloadErrorCode.DownloadSDK_START_FAILED_PARAMETERS_INVALID");
    k.c("TMAssistantDownloadSDKService", "exit");
    return 3;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString1 = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2);
      k.c("TMAssistantDownloadSDKService", "returnValue: " + paramString1);
      k.c("TMAssistantDownloadSDKService", "exit");
      return paramString1;
    }
    k.c("TMAssistantDownloadSDKService", "mServiceDownloadTaskManager == null");
    k.c("TMAssistantDownloadSDKService", "returnValue: null");
    k.c("TMAssistantDownloadSDKService", "exit");
    return null;
  }
  
  public void a(int paramInt)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "maxTaskNum: " + paramInt);
    f.a().a(paramInt);
    k.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public void a(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.register(parama);
      k.c("TMAssistantDownloadSDKService", "register callback");
    }
    try
    {
      this.a.mCallbackHashMap.put(parama, paramString);
      k.c("TMAssistantDownloadSDKService", "exit");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "isTaskAutoResume: " + paramBoolean);
    f.a().a(paramBoolean);
    k.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public void b(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.unregister(parama);
      k.c("TMAssistantDownloadSDKService", "unregister callback");
    }
    try
    {
      this.a.mCallbackHashMap.remove(parama);
      k.c("TMAssistantDownloadSDKService", "exit");
      return;
    }
    finally {}
  }
  
  public void b(String paramString1, String paramString2)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "clientkey:" + paramString1 + ",url:" + paramString2);
    try
    {
      if (this.a.mServiceDownloadTaskManager != null)
      {
        this.a.mServiceDownloadTaskManager.b(paramString1, paramString2);
        k.c("TMAssistantDownloadSDKService", "pauseDownload");
      }
      k.c("TMAssistantDownloadSDKService", "exit");
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        k.c("TMAssistantDownloadSDKService", "exception: ", paramString1);
        paramString1.printStackTrace();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "isDownloadWifiOnly: " + paramBoolean);
    f.a().b(paramBoolean);
    k.c("TMAssistantDownloadSDKService", "exit");
  }
  
  public boolean b()
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    boolean bool = com.tencent.tmdownloader.internal.a.a.b().e().booleanValue();
    k.c("TMAssistantDownloadSDKService", "returnValue: " + bool);
    k.c("TMAssistantDownloadSDKService", "exit");
    return bool;
  }
  
  public void c(String paramString1, String paramString2)
  {
    k.c("TMAssistantDownloadSDKService", "enter");
    k.c("TMAssistantDownloadSDKService", "clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.c(paramString1, paramString2);
      k.c("TMAssistantDownloadSDKService", "cancelDownload");
    }
    k.c("TMAssistantDownloadSDKService", "exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.c
 * JD-Core Version:    0.7.0.1
 */