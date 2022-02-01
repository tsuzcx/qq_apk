package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public abstract class TXIStreamDownloader
{
  public int connectRetryInterval = 3;
  public int connectRetryLimit = 3;
  public int connectRetryTimes = 0;
  protected Context mApplicationContext = null;
  protected boolean mEnableMessage = false;
  protected boolean mEnableMetaData = false;
  protected String mFlvSessionKey = "";
  protected Map<String, String> mHeaders;
  protected boolean mIsRunning = false;
  protected h mListener = null;
  protected g mMessageNotifyListener = null;
  protected b mNotifyListener = null;
  protected String mOriginUrl = "";
  protected a mRestartListener = null;
  protected String mUserID = "";
  
  public TXIStreamDownloader(Context paramContext)
  {
    this.mApplicationContext = paramContext;
  }
  
  public void PushAudioFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2) {}
  
  public void PushVideoFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
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
  
  public long getCurrentTS()
  {
    return 0L;
  }
  
  public TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    return null;
  }
  
  public String getFlvSessionKey()
  {
    return this.mFlvSessionKey;
  }
  
  public long getLastIFrameTS()
  {
    return 0L;
  }
  
  public String getRealStreamUrl()
  {
    return null;
  }
  
  public boolean isQuicChannel()
  {
    return false;
  }
  
  public void onRecvAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    a locala;
    if (this.mListener != null)
    {
      locala = new a();
      locala.f = paramArrayOfByte;
      locala.e = paramInt1;
      if (paramInt2 == 10) {
        if (paramInt3 != 1) {
          break label99;
        }
      }
    }
    label99:
    for (locala.d = 2;; locala.d = 3)
    {
      if (locala.d == 2) {
        locala.c = 16;
      }
      if (paramInt2 == 2) {
        locala.d = 5;
      }
      locala.h = paramInt2;
      locala.g = paramInt3;
      this.mListener.onPullAudio(locala);
      return;
    }
  }
  
  public void onRecvMetaData(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0) && (this.mMessageNotifyListener != null)) {
      this.mMessageNotifyListener.onMetaDataMessage(paramHashMap);
    }
  }
  
  public void onRecvSEIData(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (this.mMessageNotifyListener != null)) {
      this.mMessageNotifyListener.onSEIMessage(paramArrayOfByte);
    }
  }
  
  public void onRecvVideoData(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (this.mListener != null)
    {
      TXSNALPacket localTXSNALPacket = new TXSNALPacket();
      localTXSNALPacket.nalData = paramArrayOfByte;
      localTXSNALPacket.nalType = paramInt1;
      localTXSNALPacket.dts = paramLong1;
      localTXSNALPacket.pts = paramLong2;
      localTXSNALPacket.codecId = paramInt2;
      this.mListener.onPullNAL(localTXSNALPacket);
    }
  }
  
  public void requestKeyFrame(String paramString) {}
  
  public void sendNotifyEvent(int paramInt)
  {
    if (this.mNotifyListener != null) {
      this.mNotifyListener.onNotifyEvent(paramInt, null);
    }
  }
  
  public void sendNotifyEvent(int paramInt, String paramString)
  {
    if (this.mNotifyListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      this.mNotifyListener.onNotifyEvent(paramInt, localBundle);
    }
  }
  
  public void setFlvSessionKey(String paramString)
  {
    this.mFlvSessionKey = paramString;
  }
  
  public void setHeaders(Map<String, String> paramMap)
  {
    this.mHeaders = paramMap;
  }
  
  public void setListener(h paramh)
  {
    this.mListener = paramh;
  }
  
  public void setMessageNotifyListener(g paramg)
  {
    this.mMessageNotifyListener = paramg;
  }
  
  public void setNotifyListener(b paramb)
  {
    this.mNotifyListener = paramb;
  }
  
  public void setOriginUrl(String paramString)
  {
    this.mOriginUrl = paramString;
  }
  
  public void setRestartListener(a parama)
  {
    this.mRestartListener = parama;
  }
  
  public void setUserID(String paramString)
  {
    this.mUserID = paramString;
  }
  
  public abstract void startDownload(Vector<f> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  public abstract void startDownload(Vector<f> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, e parame);
  
  public abstract void stopDownload();
  
  public static abstract interface a
  {
    public abstract void onOldStreamStop();
    
    public abstract void onRestartDownloader();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.network.TXIStreamDownloader
 * JD-Core Version:    0.7.0.1
 */