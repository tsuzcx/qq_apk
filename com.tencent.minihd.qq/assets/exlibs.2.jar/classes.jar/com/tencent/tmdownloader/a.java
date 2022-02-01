package com.tencent.tmdownloader;

import com.tencent.tmassistant.aidl.b;
import com.tencent.tmassistant.common.c;
import com.tencent.tmassistantbase.a.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class a
  extends b
{
  a(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    k.c("TMAssistantDownloadSDKClient", "clientKey:" + paramString1 + ",state:" + paramInt1 + ", errorcode" + paramInt2 + ",url:" + paramString2);
    paramString1 = this.a.mWeakListenerArrayList.iterator();
    while (paramString1.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramString1.next();
      ITMAssistantDownloadClientListener localITMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener)localWeakReference.get();
      if (localITMAssistantDownloadClientListener == null) {
        k.c("TMAssistantDownloadSDKClient", " listener = " + localITMAssistantDownloadClientListener + "   linstenerWeakReference :" + localWeakReference);
      }
      c.a().a(this.a, localITMAssistantDownloadClientListener, paramString2, paramInt1, paramInt2, paramString3);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    k.c("TMAssistantDownloadSDKClient", "clientKey:" + paramString1 + ",receivedLen:" + paramLong1 + ",totalLen:" + paramLong2 + ",url:" + paramString2);
    paramString1 = this.a.mWeakListenerArrayList.iterator();
    while (paramString1.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramString1.next();
      ITMAssistantDownloadClientListener localITMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener)localWeakReference.get();
      if (localITMAssistantDownloadClientListener == null) {
        k.c("TMAssistantDownloadSDKClient", " listener = " + localITMAssistantDownloadClientListener + "   linstenerWeakReference :" + localWeakReference);
      }
      c.a().a(this.a, localITMAssistantDownloadClientListener, paramString2, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.a
 * JD-Core Version:    0.7.0.1
 */