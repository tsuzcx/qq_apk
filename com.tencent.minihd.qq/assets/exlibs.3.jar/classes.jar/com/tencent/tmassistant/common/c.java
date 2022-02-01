package com.tencent.tmassistant.common;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantbase.a.h;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class c
  extends Handler
{
  protected static c a = null;
  protected static HandlerThread b = null;
  
  private c(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static c a()
  {
    try
    {
      if (a == null)
      {
        b = new HandlerThread("TMAssistantDownloadSDKMessageThread");
        b.start();
        a = new c(b.getLooper());
      }
      c localc = a;
      return localc;
    }
    finally {}
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 3;
    localMessage.obj = new h(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    localMessage.sendToTarget();
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new h(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    paramTMAssistantDownloadClient = new Bundle();
    paramTMAssistantDownloadClient.putString("url", paramString1);
    paramTMAssistantDownloadClient.putInt("state", paramInt1);
    paramTMAssistantDownloadClient.putInt("errorCode", paramInt2);
    paramTMAssistantDownloadClient.putString("errorMsg", paramString2);
    localMessage.setData(paramTMAssistantDownloadClient);
    localMessage.sendToTarget();
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener, String paramString, long paramLong1, long paramLong2)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null))
    {
      k.c("TMAssistantDownloadSDKMessageThread", "listenr:" + paramITMAssistantDownloadClientListener + " === sdkClient" + paramTMAssistantDownloadClient);
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 2;
    localMessage.obj = new h(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    paramTMAssistantDownloadClient = new Bundle();
    paramTMAssistantDownloadClient.putString("url", paramString);
    paramTMAssistantDownloadClient.putLong("receiveDataLen", paramLong1);
    paramTMAssistantDownloadClient.putLong("totalDataLen", paramLong2);
    localMessage.setData(paramTMAssistantDownloadClient);
    localMessage.sendToTarget();
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    Object localObject1;
    do
    {
      Object localObject2;
      Object localObject3;
      long l1;
      long l2;
      do
      {
        int i;
        int j;
        do
        {
          return;
          localObject2 = (h)paramMessage.obj;
          localObject1 = (TMAssistantDownloadClient)((h)localObject2).a;
          localObject2 = (ITMAssistantDownloadClientListener)((h)localObject2).b;
          localObject3 = paramMessage.getData();
          paramMessage = ((Bundle)localObject3).getString("url");
          i = ((Bundle)localObject3).getInt("state");
          j = ((Bundle)localObject3).getInt("errorCode");
          localObject3 = ((Bundle)localObject3).getString("errorMsg");
        } while (localObject2 == null);
        ((ITMAssistantDownloadClientListener)localObject2).OnDownloadSDKTaskStateChanged((TMAssistantDownloadClient)localObject1, paramMessage, i, j, (String)localObject3);
        return;
        localObject2 = (h)paramMessage.obj;
        localObject1 = (TMAssistantDownloadClient)((h)localObject2).a;
        localObject2 = (ITMAssistantDownloadClientListener)((h)localObject2).b;
        paramMessage = paramMessage.getData();
        localObject3 = paramMessage.getString("url");
        l1 = paramMessage.getLong("receiveDataLen");
        l2 = paramMessage.getLong("totalDataLen");
      } while (localObject2 == null);
      ((ITMAssistantDownloadClientListener)localObject2).OnDownloadSDKTaskProgressChanged((TMAssistantDownloadClient)localObject1, (String)localObject3, l1, l2);
      return;
      localObject1 = (h)paramMessage.obj;
      paramMessage = (TMAssistantDownloadClient)((h)localObject1).a;
      localObject1 = (ITMAssistantDownloadClientListener)((h)localObject1).b;
    } while (localObject1 == null);
    ((ITMAssistantDownloadClientListener)localObject1).OnDwonloadSDKServiceInvalid(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.c
 * JD-Core Version:    0.7.0.1
 */