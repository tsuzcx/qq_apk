package com.tencent.tmassistantsdk.internal.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.e;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.GetDownloadProgressResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.GetDownloadStateResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCDownloadParam;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCQueryDownloadInfo;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.URIActionRequest;
import java.util.ArrayList;
import java.util.UUID;

public class d
  implements com.tencent.tmassistantsdk.internal.b.a
{
  protected static d a = null;
  protected com.tencent.tmassistantsdk.internal.b.b b = null;
  protected ITMAssistantCallBackListener c = null;
  String d = UUID.randomUUID().toString();
  
  public d() {}
  
  private d(Context paramContext)
  {
    if (paramContext != null) {
      b(paramContext);
    }
  }
  
  private TMAssistantCallYYBParamStruct a(IPCBaseParam paramIPCBaseParam)
  {
    if (paramIPCBaseParam == null) {
      return null;
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
    localTMAssistantCallYYBParamStruct.SNGAppId = paramIPCBaseParam.hostAppId;
    localTMAssistantCallYYBParamStruct.taskAppId = paramIPCBaseParam.taskAppId;
    localTMAssistantCallYYBParamStruct.taskPackageName = paramIPCBaseParam.taskPackageName;
    try
    {
      localTMAssistantCallYYBParamStruct.taskVersion = Integer.valueOf(paramIPCBaseParam.taskVersion).intValue();
      localTMAssistantCallYYBParamStruct.uin = paramIPCBaseParam.uin;
      localTMAssistantCallYYBParamStruct.uinType = paramIPCBaseParam.uinType;
      localTMAssistantCallYYBParamStruct.via = paramIPCBaseParam.via;
      localTMAssistantCallYYBParamStruct.channelId = paramIPCBaseParam.channelId;
      return localTMAssistantCallYYBParamStruct;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        k.c("QQDownloaderOpenSDKDataProcessor", "baseParam2QQParam Integer.valueOf(baseParam.taskVersion) NumberFormatException occur");
      }
    }
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static byte[] a(JceStruct paramJceStruct, String paramString)
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "jceStruct = " + paramJceStruct);
    paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct, paramString);
    if (paramJceStruct != null)
    {
      paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0))
      {
        k.c("QQDownloaderOpenSDKDataProcessor", "return sendData length = " + paramJceStruct.length);
        return paramJceStruct;
      }
      k.c("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
      return null;
    }
    k.c("QQDownloaderOpenSDKDataProcessor", "handleUriAction IPCRequest = null");
    return null;
  }
  
  public static BatchDownloadActionRequest b(int paramInt, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("batchRequestType = ").append(paramInt).append(",appList size = ");
    if (paramArrayList == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      k.c("QQDownloaderOpenSDKDataProcessor", localObject + ",via = " + paramString1 + ",uin = " + paramString2 + ",uinType = " + paramString3);
      localObject = new BatchDownloadActionRequest();
      ((BatchDownloadActionRequest)localObject).batchRequestType = paramInt;
      if (paramString1 != null) {
        ((BatchDownloadActionRequest)localObject).via = paramString1;
      }
      if (paramString2 != null) {
        ((BatchDownloadActionRequest)localObject).uin = paramString2;
      }
      if (paramString3 != null) {
        ((BatchDownloadActionRequest)localObject).uinType = paramString3;
      }
      ((BatchDownloadActionRequest)localObject).batchData = new ArrayList();
      paramString2 = "appList {";
      if (paramArrayList == null) {
        break;
      }
      paramString1 = "appList {" + "appList.size=" + paramArrayList.size() + "\n";
      paramInt = 0;
      for (;;)
      {
        paramString2 = paramString1;
        if (paramInt >= paramArrayList.size()) {
          break;
        }
        paramString2 = b((TMAssistantCallYYBParamStruct)paramArrayList.get(paramInt));
        paramString3 = new IPCDownloadParam();
        paramString3.baseParam = paramString2;
        ((BatchDownloadActionRequest)localObject).batchData.add(paramString3);
        paramString1 = paramString1 + "element:" + paramInt + "IPCDownloadParam {IPCBaseParam {hostAppId:" + paramString3.baseParam.hostAppId + "|taskAppId:" + paramString3.baseParam.taskAppId + "|taskPackageName:" + paramString3.baseParam.taskPackageName + "|taskVersion:" + paramString3.baseParam.taskVersion + "}" + "|actionFlag:" + paramString3.actionFlag + "|verifyType:" + paramString3.verifyType + "}\n";
        paramInt += 1;
      }
    }
    k.c("QQDownloaderOpenSDKDataProcessor", paramString2 + "}");
    return localObject;
  }
  
  private static IPCBaseParam b(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    if (paramTMAssistantCallYYBParamStruct == null) {
      return null;
    }
    IPCBaseParam localIPCBaseParam = new IPCBaseParam();
    localIPCBaseParam.hostAppId = paramTMAssistantCallYYBParamStruct.SNGAppId;
    localIPCBaseParam.taskAppId = paramTMAssistantCallYYBParamStruct.taskAppId;
    localIPCBaseParam.taskPackageName = paramTMAssistantCallYYBParamStruct.taskPackageName;
    localIPCBaseParam.taskVersion = String.valueOf(paramTMAssistantCallYYBParamStruct.taskVersion);
    localIPCBaseParam.uin = paramTMAssistantCallYYBParamStruct.uin;
    localIPCBaseParam.uinType = paramTMAssistantCallYYBParamStruct.uinType;
    localIPCBaseParam.via = paramTMAssistantCallYYBParamStruct.via;
    localIPCBaseParam.channelId = paramTMAssistantCallYYBParamStruct.channelId;
    return localIPCBaseParam;
  }
  
  public TMAssistantCallYYBTaskInfo a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "getDownloadTask param.sngAppid:" + paramTMAssistantCallYYBParamStruct.SNGAppId + "|param.appid:" + paramTMAssistantCallYYBParamStruct.taskAppId + "| param.taskPackageName:" + paramTMAssistantCallYYBParamStruct.taskPackageName + "|param.taskVersion:" + paramTMAssistantCallYYBParamStruct.taskVersion);
    paramTMAssistantCallYYBParamStruct = b(paramTMAssistantCallYYBParamStruct);
    QueryDownloadTaskRequest localQueryDownloadTaskRequest = new QueryDownloadTaskRequest();
    localQueryDownloadTaskRequest.baseParam = paramTMAssistantCallYYBParamStruct;
    paramTMAssistantCallYYBParamStruct = a(localQueryDownloadTaskRequest, "");
    if ((paramTMAssistantCallYYBParamStruct != null) && (paramTMAssistantCallYYBParamStruct.length > 0)) {}
    for (;;)
    {
      try
      {
        b(f.a().b());
        if (this.b == null) {
          break label232;
        }
        paramTMAssistantCallYYBParamStruct = this.b.a(paramTMAssistantCallYYBParamStruct);
        paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramTMAssistantCallYYBParamStruct);
        if (paramTMAssistantCallYYBParamStruct == null) {
          break;
        }
        paramTMAssistantCallYYBParamStruct = (QueryDownloadTaskResponse)com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramTMAssistantCallYYBParamStruct);
        k.c("QQDownloaderOpenSDKDataProcessor", "QueryDownloadTaskResponse downloadTask state:" + paramTMAssistantCallYYBParamStruct.state);
        int i = f.a(paramTMAssistantCallYYBParamStruct.state);
        if (paramTMAssistantCallYYBParamStruct == null) {
          break label245;
        }
        return new TMAssistantCallYYBTaskInfo(paramTMAssistantCallYYBParamStruct.url, paramTMAssistantCallYYBParamStruct.savePath, i, paramTMAssistantCallYYBParamStruct.receivedLen, paramTMAssistantCallYYBParamStruct.totalLen, "application/vnd.android.package-archive");
      }
      catch (Throwable paramTMAssistantCallYYBParamStruct)
      {
        paramTMAssistantCallYYBParamStruct.printStackTrace();
        k.c("QQDownloaderOpenSDKDataProcessor", "getDownloadTask Exception,return null", paramTMAssistantCallYYBParamStruct);
        return null;
      }
      k.c("QQDownloaderOpenSDKDataProcessor", "getDownloadTask sendData = null");
      label232:
      paramTMAssistantCallYYBParamStruct = null;
    }
    k.c("QQDownloaderOpenSDKDataProcessor", "getDownloadTask IPCResponse = null");
    label245:
    k.c("QQDownloaderOpenSDKDataProcessor", "getDownloadTask return null");
    return null;
  }
  
  public ArrayList a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if (paramArrayList == null)
    {
      k.c("QQDownloaderOpenSDKDataProcessor", "appList = null,return null");
      return null;
    }
    k.c("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos appList.size:" + paramArrayList.size() + ",via = " + paramString1 + ",uin = " + paramString2 + ",uinType = " + paramString3);
    paramString1 = a(b(3, paramArrayList, paramString1, paramString2, paramString3), "");
    paramArrayList = null;
    if ((paramString1 != null) && (paramString1.length > 0)) {}
    for (;;)
    {
      try
      {
        b(f.a().b());
        if (this.b != null) {
          paramArrayList = this.b.a(paramString1);
        }
        paramString1 = null;
        paramArrayList = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayList);
        if (paramArrayList == null) {
          break label365;
        }
        paramString2 = (BatchDownloadActionResponse)com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayList);
        if (paramString2 == null) {
          break label355;
        }
        paramArrayList = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + paramString2.batchRequestType;
        if (paramString2.batchData == null) {
          break label331;
        }
        paramArrayList = paramArrayList + "response.batchData.size:" + paramString2.batchData.size();
        paramString1 = new ArrayList();
        int i = 0;
        if (i >= paramString2.batchData.size()) {
          break;
        }
        paramString3 = (IPCQueryDownloadInfo)paramString2.batchData.get(i);
        int j = f.a(paramString3.state);
        if (paramString3 != null) {
          paramString1.add(new TMAssistantCallYYBTaskInfo(paramString3.url, paramString3.savePath, j, paramString3.receivedLen, paramString3.totalLen, "application/vnd.android.package-archive"));
        }
        i += 1;
        continue;
        k.c("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos sendData = null or length = 0");
      }
      catch (Throwable paramArrayList)
      {
        paramArrayList.printStackTrace();
        return null;
      }
    }
    for (;;)
    {
      k.c("QQDownloaderOpenSDKDataProcessor", paramArrayList);
      return paramString1;
      label331:
      paramArrayList = paramArrayList + "response.batchData = null";
    }
    label355:
    k.c("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos BatchDownloadActionResponse response = null");
    return null;
    label365:
    k.c("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos IPCResponse resp = null");
    return null;
  }
  
  public void a()
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "onDownloadSDKServiceInvalid callback = " + this.c);
    if (this.c != null) {
      this.c.OnQQDownloaderInvalid();
    }
    Context localContext = f.a().b();
    if (localContext != null) {
      e.a(localContext).b(this.d);
    }
    this.b = null;
  }
  
  public void a(ITMAssistantCallBackListener paramITMAssistantCallBackListener)
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "listener = " + paramITMAssistantCallBackListener);
    this.c = paramITMAssistantCallBackListener;
  }
  
  void a(GetDownloadProgressResponse paramGetDownloadProgressResponse)
  {
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramGetDownloadProgressResponse.requestParam);
    if ((localTMAssistantCallYYBParamStruct != null) && (this.c != null))
    {
      k.c("QQDownloaderOpenSDKDataProcessor", "进度回调：GetDownloadProgressResponse response.receivedLen:" + paramGetDownloadProgressResponse.receivedLen + ",response.totalLen" + paramGetDownloadProgressResponse.totalLen);
      this.c.OnDownloadTaskProgressChanged(localTMAssistantCallYYBParamStruct, paramGetDownloadProgressResponse.receivedLen, paramGetDownloadProgressResponse.totalLen);
    }
  }
  
  void a(GetDownloadStateResponse paramGetDownloadStateResponse)
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "onServiceFreed response = " + paramGetDownloadStateResponse);
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramGetDownloadStateResponse.requestParam);
    if ((localTMAssistantCallYYBParamStruct != null) && (this.c != null))
    {
      k.c("QQDownloaderOpenSDKDataProcessor", "状态回调：GetDownloadStateResponse param.taskAppId:" + localTMAssistantCallYYBParamStruct.taskAppId + ",param.taskPackageName:" + localTMAssistantCallYYBParamStruct.taskPackageName + ",state:" + paramGetDownloadStateResponse.state + ",response.errorCode" + paramGetDownloadStateResponse.errorCode);
      this.c.OnDownloadTaskStateChanged(localTMAssistantCallYYBParamStruct, f.a(paramGetDownloadStateResponse.state), f.b(paramGetDownloadStateResponse.errorCode), paramGetDownloadStateResponse.errorMsg);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      JceStruct localJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      k.c("QQDownloaderOpenSDKDataProcessor", "response.head.cmdId = " + paramArrayOfByte.head.cmdId);
      switch (paramArrayOfByte.head.cmdId)
      {
      default: 
      case 2: 
      case 3: 
        do
        {
          do
          {
            return;
          } while (localJceStruct == null);
          a((GetDownloadStateResponse)localJceStruct);
          return;
        } while (localJceStruct == null);
        a((GetDownloadProgressResponse)localJceStruct);
        return;
      }
      d();
      return;
    }
    k.c("QQDownloaderOpenSDKDataProcessor", "onActionResult reponseData = null");
  }
  
  public boolean a(int paramInt, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction batchRequestType:" + paramInt + "|appList:" + paramArrayList);
    paramString2 = b(paramInt, paramArrayList, paramString1, paramString2, paramString3);
    paramArrayList = UUID.randomUUID().toString();
    paramString2 = a(paramString2, paramArrayList);
    if ((paramString2 != null) && (paramString2.length > 0)) {
      try
      {
        b(f.a().b());
        if (this.b != null)
        {
          this.b.b(paramString2);
          k.c("QQDownloaderOpenSDKDataProcessor", "result is true");
          paramArrayList = com.tencent.tmassistantsdk.internal.c.b.h().a(paramString1, paramArrayList, "V2_handleBatchRequestAction_" + paramInt);
          com.tencent.tmassistantsdk.internal.c.b.h().a(paramArrayList);
          return true;
        }
        k.c("QQDownloaderOpenSDKDataProcessor", "result is false,openSDKClient is null");
        return false;
      }
      catch (Throwable paramArrayList)
      {
        paramArrayList.printStackTrace();
        k.c("QQDownloaderOpenSDKDataProcessor", "result is false");
        return false;
      }
    }
    k.c("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction sendData = null or length = 0");
    return false;
  }
  
  public boolean a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask requestType:" + paramInt + "  param.sngAppid:" + paramTMAssistantCallYYBParamStruct.SNGAppId + "|param.appid:" + paramTMAssistantCallYYBParamStruct.taskAppId + "| param.taskPackageName:" + paramTMAssistantCallYYBParamStruct.taskPackageName + "|param.taskVersion:" + paramTMAssistantCallYYBParamStruct.taskVersion + "| param.actionFlag:" + paramString2 + " | verifyType:" + paramString3);
    OperateDownloadTaskRequest localOperateDownloadTaskRequest = new OperateDownloadTaskRequest();
    IPCBaseParam localIPCBaseParam = b(paramTMAssistantCallYYBParamStruct);
    localOperateDownloadTaskRequest.requestType = paramInt;
    localOperateDownloadTaskRequest.baseParam = localIPCBaseParam;
    localOperateDownloadTaskRequest.actionFlag = paramString2;
    localOperateDownloadTaskRequest.verifyType = paramString3;
    localOperateDownloadTaskRequest.opList = paramString1;
    paramString1 = UUID.randomUUID().toString();
    paramString2 = a(localOperateDownloadTaskRequest, paramString1);
    if ((paramString2 != null) && (paramString2.length > 0)) {
      try
      {
        b(f.a().b());
        if (this.b != null)
        {
          this.b.b(paramString2);
          k.c("QQDownloaderOpenSDKDataProcessor", "return true");
          paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), paramString1, "V2_handleDownloadTask_" + paramInt);
          com.tencent.tmassistantsdk.internal.c.b.h().a(paramTMAssistantCallYYBParamStruct);
          return true;
        }
        k.c("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask openSDKClient = null,return false");
        return false;
      }
      catch (Throwable paramTMAssistantCallYYBParamStruct)
      {
        k.a("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask Exception,return false", paramTMAssistantCallYYBParamStruct);
        paramTMAssistantCallYYBParamStruct.printStackTrace();
        return false;
      }
    }
    k.c("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask sendData = null,return false");
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      k.c("QQDownloaderOpenSDKDataProcessor", "uri = null,return false");
      return false;
    }
    k.c("QQDownloaderOpenSDKDataProcessor", "uri = " + paramString);
    Object localObject = new URIActionRequest(paramString);
    String str = UUID.randomUUID().toString();
    localObject = a((JceStruct)localObject, str);
    if ((localObject != null) && (localObject.length > 0)) {
      try
      {
        b(f.a().b());
        if (this.b != null) {
          this.b.b((byte[])localObject);
        }
        paramString = com.tencent.tmassistantsdk.internal.c.b.h().a(paramString, str, "V2_handleUriAction");
        com.tencent.tmassistantsdk.internal.c.b.h().a(paramString);
        return false;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        k.a("QQDownloaderOpenSDKDataProcessor", "handleUriAction Exception,return false", paramString);
        return false;
      }
    }
    k.c("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
    return false;
  }
  
  public void b()
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "unregisterIQQDownloaderOpenSDKListener start");
    this.c = null;
    Context localContext = f.a().b();
    if (localContext != null) {
      e.a(localContext).b(this.d);
    }
    this.b = null;
  }
  
  public void b(Context paramContext)
  {
    try
    {
      if ((this.b == null) && (paramContext != null))
      {
        this.b = e.a(paramContext).a(this.d);
        if (this.b != null) {
          this.b.a(this);
        }
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "releaseIPCClient openSDKClient = " + this.b);
    if (this.b != null)
    {
      Context localContext = f.a().b();
      if (localContext != null) {
        e.a(localContext).b(this.d);
      }
      this.b = null;
    }
  }
  
  void d()
  {
    k.c("QQDownloaderOpenSDKDataProcessor", "onServiceFreed callback = " + this.c);
    if (this.c != null) {
      this.c.OnServiceFree();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.d
 * JD-Core Version:    0.7.0.1
 */