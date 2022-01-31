package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.f.b;
import java.util.Map;
import java.util.Vector;

public abstract class TXIStreamDownloader
{
  public int connectRetryInterval = 3;
  public int connectRetryLimit = 3;
  public int connectRetryTimes = 0;
  protected Context mApplicationContext = null;
  protected boolean mEnableMessage = false;
  protected Map<String, String> mHeaders;
  protected boolean mIsRunning = false;
  protected f mListener = null;
  protected com.tencent.liteav.basic.c.a mNotifyListener = null;
  protected String mOriginUrl = "";
  protected TXIStreamDownloader.a mRestartListener = null;
  
  public TXIStreamDownloader(Context paramContext)
  {
    this.mApplicationContext = paramContext;
  }
  
  public int getConnectCountQuic()
  {
    return 0;
  }
  
  public int getConnectCountTcp()
  {
    return 0;
  }
  
  public String getCurrentStreamUrl()
  {
    return null;
  }
  
  public TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    return null;
  }
  
  public boolean isQuicChannel()
  {
    return false;
  }
  
  public void onRecvAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    com.tencent.liteav.basic.f.a locala;
    if (this.mListener != null)
    {
      locala = new com.tencent.liteav.basic.f.a();
      locala.f = paramArrayOfByte;
      locala.e = paramInt1;
      if (paramInt2 == 10) {
        if (paramInt3 != 1) {
          break label93;
        }
      }
    }
    label93:
    for (locala.d = com.tencent.liteav.basic.a.a.k;; locala.d = com.tencent.liteav.basic.a.a.l)
    {
      if (locala.d == com.tencent.liteav.basic.a.a.k) {
        locala.c = com.tencent.liteav.basic.a.a.h;
      }
      if (paramInt2 == 2) {
        locala.d = com.tencent.liteav.basic.a.a.m;
      }
      this.mListener.onPullAudio(locala);
      return;
    }
  }
  
  public void onRecvVideoData(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (this.mListener != null)
    {
      b localb = new b();
      localb.a = paramArrayOfByte;
      localb.b = paramInt1;
      localb.h = paramLong1;
      localb.g = paramLong2;
      localb.i = paramInt2;
      this.mListener.onPullNAL(localb);
    }
  }
  
  public void sendNotifyEvent(int paramInt)
  {
    if (this.mNotifyListener != null) {
      this.mNotifyListener.onNotifyEvent(paramInt, null);
    }
  }
  
  public void setHeaders(Map<String, String> paramMap)
  {
    this.mHeaders = paramMap;
  }
  
  public void setListener(f paramf)
  {
    this.mListener = paramf;
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.a parama)
  {
    this.mNotifyListener = parama;
  }
  
  public void setOriginUrl(String paramString)
  {
    this.mOriginUrl = paramString;
  }
  
  public void setRestartListener(TXIStreamDownloader.a parama)
  {
    this.mRestartListener = parama;
  }
  
  public abstract void startDownload(Vector<e> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void stopDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.TXIStreamDownloader
 * JD-Core Version:    0.7.0.1
 */