package com.tencent.tmdatasourcesdk;

import android.content.Context;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdatasourcesdk.internal.a.a;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppDetailParam;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantGetAppDetailTool
  implements ITMAssistantExchangeURLListenner
{
  protected static final String TAG = "TMAssistantDownloadSDKExchangeURL";
  protected static TMAssistantGetAppDetailTool mInstance = null;
  protected a engine = null;
  protected ITMAssistantExchangeURLListenner mListener = null;
  
  private TMAssistantGetAppDetailTool(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner, Context paramContext)
  {
    k.c("TMAssistantDownloadSDKExchangeURL", "listener = " + paramITMAssistantExchangeURLListenner + ",context = " + paramContext);
    if ((paramITMAssistantExchangeURLListenner != null) && (paramContext != null))
    {
      this.mListener = paramITMAssistantExchangeURLListenner;
      this.engine = new a(this);
      f.a().a(paramContext);
      return;
    }
    k.e("TMAssistantDownloadSDKExchangeURL", "ITMAssistantExchangeURLListenner listener shouldn't be null!");
  }
  
  public static TMAssistantGetAppDetailTool getInstance(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner, Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMAssistantGetAppDetailTool(paramITMAssistantExchangeURLListenner, paramContext);
      }
      paramITMAssistantExchangeURLListenner = mInstance;
      return paramITMAssistantExchangeURLListenner;
    }
    finally {}
  }
  
  public void exchangeUrlsFromPackageNames(ArrayList paramArrayList)
  {
    Object localObject2 = new StringBuilder().append("paramStrs size = ");
    if (paramArrayList == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramArrayList.size()))
    {
      k.c("TMAssistantDownloadSDKExchangeURL", localObject1);
      if (paramArrayList == null) {
        break label159;
      }
      localObject1 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = ((String)paramArrayList.next()).split(";");
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          AppDetailParam localAppDetailParam = new AppDetailParam();
          localAppDetailParam.packageName = localObject2[0];
          if (localObject2.length > 1) {
            localAppDetailParam.channelId = localObject2[1];
          }
          ((ArrayList)localObject1).add(localAppDetailParam);
        }
      }
    }
    if ((((ArrayList)localObject1).size() > 0) && (this.engine != null)) {
      this.engine.a((ArrayList)localObject1);
    }
    return;
    label159:
    k.e("TMAssistantDownloadSDKExchangeURL", "packageNames is null!");
  }
  
  public void onExchangedURLSucceed(ArrayList paramArrayList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("appDetails size = ");
    if (paramArrayList == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      k.c("TMAssistantDownloadSDKExchangeURL", localObject + ",isSuccess = " + paramBoolean);
      if (this.mListener == null) {
        break;
      }
      this.mListener.onExchangedURLSucceed(paramArrayList, paramBoolean);
      return;
    }
    k.e("TMAssistantDownloadSDKExchangeURL", "mListener is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool
 * JD-Core Version:    0.7.0.1
 */