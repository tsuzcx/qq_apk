package com.tencent.tmassistantsdk.internal.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.assistant.sdk.remote.BaseService;
import com.tencent.assistant.sdk.remote.BaseService.Stub;
import com.tencent.assistant.sdk.remote.SDKActionCallback;
import com.tencent.tmassistantbase.a.e;
import com.tencent.tmassistantbase.a.k;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  extends com.tencent.tmassistant.c
{
  ArrayList a = new ArrayList();
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    this.g = new c(this);
  }
  
  protected void a()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.a();
        }
      }
    }
  }
  
  protected void a(IBinder paramIBinder)
  {
    this.f = BaseService.Stub.asInterface(paramIBinder);
  }
  
  public void a(a parama)
  {
    k.c("TMAssistantDownloadOpenSDKClient", "addAssistantOnActionListener");
    if ((parama != null) && (!this.a.contains(parama))) {
      this.a.add(parama);
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(this.c))
    {
      BaseService localBaseService = (BaseService)super.g();
      if (localBaseService != null) {
        return localBaseService.sendSyncData(this.c, paramArrayOfByte);
      }
      super.e();
      k.c("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK");
    }
    return null;
  }
  
  protected void b()
  {
    Object localObject = String.valueOf(System.currentTimeMillis()).getBytes();
    localObject = com.tencent.tmassistantbase.a.a.b(new e().b((byte[])localObject, this.c.getBytes()), 0);
    int i = ((BaseService)this.f).registerActionCallback(this.c, (String)localObject, (SDKActionCallback)this.g);
    k.c("TMAssistantDownloadOpenSDKClient", "onServiceConnected,registerActionCallback:" + this.c + ",tokenString:" + (String)localObject + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.g + ",registed result:" + i);
    if (i == 2) {
      a();
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    k.c("TMAssistantDownloadOpenSDKClient", "sendAsyncData");
    if (!TextUtils.isEmpty(this.c))
    {
      BaseService localBaseService = (BaseService)super.g();
      k.c("TMAssistantDownloadOpenSDKClient", "sendAsyncData baseService:" + localBaseService);
      if (localBaseService != null)
      {
        k.c("TMAssistantDownloadOpenSDKClient", "baseService sendAsyncData");
        localBaseService.sendAsyncData(this.c, paramArrayOfByte);
      }
    }
    else
    {
      return;
    }
    super.e();
    k.c("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK");
  }
  
  protected Intent c()
  {
    return new Intent(this.d).setClassName("com.tencent.android.qqdownloader", "com.tencent.assistant.sdk.SDKSupportService");
  }
  
  protected void d()
  {
    if (((BaseService)this.f).unregisterActionCallback((SDKActionCallback)this.g) == 2) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.b.b
 * JD-Core Version:    0.7.0.1
 */