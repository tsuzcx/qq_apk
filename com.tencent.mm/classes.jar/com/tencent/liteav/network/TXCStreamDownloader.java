package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.util.Map;
import java.util.Vector;

public class TXCStreamDownloader
  extends com.tencent.liteav.basic.module.a
  implements com.tencent.liteav.basic.c.a, TXIStreamDownloader.a, d.a, f
{
  public static final String TAG = "TXCStreamDownloader";
  public static final int TXE_DOWNLOAD_ERROR_ALLADDRESS_FAILED = 12031;
  public static final int TXE_DOWNLOAD_ERROR_CONNECT_FAILED = 12011;
  public static final int TXE_DOWNLOAD_ERROR_DISCONNECT = 12012;
  public static final int TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL = 12030;
  public static final int TXE_DOWNLOAD_ERROR_NET_RECONNECT = 12015;
  public static final int TXE_DOWNLOAD_ERROR_READ_FAILED = 12013;
  public static final int TXE_DOWNLOAD_ERROR_WRITE_FAILED = 12014;
  public static final int TXE_DOWNLOAD_INFO_CONNECT_END = 12007;
  public static final int TXE_DOWNLOAD_INFO_CONNECT_FAILED = 12004;
  public static final int TXE_DOWNLOAD_INFO_CONNECT_SUCCESS = 12001;
  public static final int TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL = 12005;
  public static final int TXE_DOWNLOAD_INFO_PLAY_BEGIN = 12008;
  public static final int TXE_DOWNLOAD_INFO_SERVER_REFUSE = 12009;
  private g mAccUrlFetcher;
  private Context mApplicationContext;
  private int mChannelType = 0;
  private long mCurrentNalTs = 0L;
  private int mDownloadFormat = 1;
  private TXIStreamDownloader mDownloader = null;
  private boolean mDownloaderRunning = false;
  private boolean mEnableMessage = false;
  private boolean mEnableNearestIP = false;
  private Handler mHandler = null;
  protected Map<String, String> mHeaders;
  private TXCStreamDownloader.DownloadStats mLastDownloadStats = null;
  private long mLastIFramelTs = 0L;
  private long mLastTimeStamp = 0L;
  private f mListener = null;
  private byte[] mListenerLock = new byte[0];
  private com.tencent.liteav.basic.c.a mNotifyListener = null;
  private String mOriginPlayUrl = "";
  private boolean mRecvFirstNal = false;
  private Runnable mReportNetStatusRunnalbe = new TXCStreamDownloader.3(this);
  private d mStreamSwitcher = null;
  private long mSwitchStartTime = 0L;
  
  static {}
  
  public TXCStreamDownloader(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {}
    for (this.mDownloader = new TXCFLVDownloader(paramContext);; this.mDownloader = new TXCRTMPDownloader(paramContext)) {
      do
      {
        if (this.mDownloader != null)
        {
          this.mDownloader.setListener(this);
          this.mDownloader.setNotifyListener(this);
          this.mDownloader.setRestartListener(this);
        }
        this.mDownloadFormat = paramInt;
        this.mAccUrlFetcher = new g(paramContext);
        this.mApplicationContext = paramContext;
        if (this.mApplicationContext != null) {
          this.mHandler = new Handler(this.mApplicationContext.getMainLooper());
        }
        return;
      } while ((paramInt != 1) && (paramInt != 4));
    }
  }
  
  private TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    if (this.mDownloader != null) {
      return this.mDownloader.getDownloadStats();
    }
    return null;
  }
  
  private TXCStreamDownloader.a getRealTimeStreamInfo()
  {
    TXCStreamDownloader.a locala = new TXCStreamDownloader.a();
    if (this.mAccUrlFetcher != null)
    {
      locala.b = this.mAccUrlFetcher.a();
      locala.c = this.mAccUrlFetcher.b();
      locala.d = this.mAccUrlFetcher.c();
      locala.e = this.mAccUrlFetcher.d();
    }
    if (this.mDownloader != null)
    {
      locala.a = this.mDownloader.getCurrentStreamUrl();
      locala.f = this.mDownloader.isQuicChannel();
    }
    return locala;
  }
  
  private Long getSpeed(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = 0L;
    if (paramLong1 > paramLong2) {}
    for (;;)
    {
      paramLong1 = l;
      if (paramLong3 > 0L) {
        paramLong1 = 8L * paramLong2 * 1000L / (1024L * paramLong3);
      }
      return Long.valueOf(paramLong1);
      paramLong2 -= paramLong1;
    }
  }
  
  private void playStreamWithRawUrl(String paramString, boolean paramBoolean)
  {
    if (this.mDownloader != null)
    {
      if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (paramString.contains(".flv")))
      {
        int i = this.mDownloader.connectRetryLimit;
        int j = this.mDownloader.connectRetryInterval;
        this.mDownloader = null;
        this.mDownloader = new TXCFLVDownloader(this.mApplicationContext);
        this.mDownloader.setListener(this);
        this.mDownloader.setNotifyListener(this);
        this.mDownloader.setRestartListener(this);
        this.mDownloader.connectRetryLimit = i;
        this.mDownloader.connectRetryInterval = j;
        this.mDownloader.setHeaders(this.mHeaders);
      }
      setStatusValue(7112, Long.valueOf(1L));
      Vector localVector = new Vector();
      localVector.add(new e(paramString, false));
      this.mDownloader.setOriginUrl(paramString);
      this.mDownloader.startDownload(localVector, false, false, paramBoolean);
    }
  }
  
  private void reportNetStatus()
  {
    reportNetStatusInternal();
    this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
  }
  
  private void reportNetStatusInternal()
  {
    long l3 = TXCTimeUtil.getTimeTick();
    long l1 = l3 - this.mLastTimeStamp;
    TXCStreamDownloader.DownloadStats localDownloadStats = getDownloadStats();
    TXCStreamDownloader.a locala = getRealTimeStreamInfo();
    long l2;
    if (localDownloadStats != null)
    {
      if (this.mLastDownloadStats == null) {
        break label370;
      }
      l2 = getSpeed(this.mLastDownloadStats.afterParseVideoBytes, localDownloadStats.afterParseVideoBytes, l1).longValue();
      l1 = getSpeed(this.mLastDownloadStats.afterParseAudioBytes, localDownloadStats.afterParseAudioBytes, l1).longValue();
    }
    for (;;)
    {
      setStatusValue(7101, Long.valueOf(l2));
      setStatusValue(7102, Long.valueOf(l1));
      setStatusValue(7103, Long.valueOf(localDownloadStats.firstVideoTS));
      setStatusValue(7104, Long.valueOf(localDownloadStats.firstAudioTS));
      if (locala != null)
      {
        setStatusValue(7105, Long.valueOf(locala.d));
        setStatusValue(7106, locala.e);
        if (!locala.f) {
          break label365;
        }
      }
      label365:
      for (l1 = 2L;; l1 = 1L)
      {
        setStatusValue(7111, Long.valueOf(l1));
        setStatusValue(7113, locala.a);
        setStatusValue(7114, locala.b);
        setStatusValue(7115, locala.c);
        setStatusValue(7107, Long.valueOf(localDownloadStats.startTS));
        setStatusValue(7108, Long.valueOf(localDownloadStats.dnsTS));
        setStatusValue(7109, Long.valueOf(localDownloadStats.connTS));
        setStatusValue(7110, String.valueOf(localDownloadStats.serverIP));
        if (this.mDownloader != null)
        {
          int i = this.mDownloader.getConnectCountQuic();
          int j = this.mDownloader.getConnectCountTcp();
          setStatusValue(7117, Long.valueOf(i + 1));
          setStatusValue(7118, Long.valueOf(j + 1));
        }
        this.mLastTimeStamp = l3;
        this.mLastDownloadStats = localDownloadStats;
        return;
      }
      label370:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  private void tryResetRetryCount()
  {
    if (this.mDownloader != null) {
      this.mDownloader.connectRetryTimes = 0;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    int i = 3002;
    for (;;)
    {
      Bundle localBundle;
      synchronized (this.mListenerLock)
      {
        if (this.mNotifyListener != null) {
          localBundle = new Bundle();
        }
        switch (paramInt)
        {
        case 12002: 
        case 12003: 
        case 12006: 
        case 12010: 
        case 12016: 
        case 12017: 
        case 12018: 
        case 12019: 
        case 12020: 
        case 12021: 
        case 12022: 
        case 12023: 
        case 12024: 
        case 12025: 
        case 12026: 
        case 12027: 
        case 12028: 
        case 12029: 
          localBundle.putString("EVT_MSG", "UNKNOWN event = " + paramInt);
          i = paramInt;
          String str = "";
          if (paramBundle != null) {
            str = paramBundle.getString("EVT_MSG", "");
          }
          if ((str != null) && (!str.isEmpty())) {
            localBundle.putString("EVT_MSG", str);
          }
          localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          this.mNotifyListener.onNotifyEvent(i, localBundle);
          if (paramInt == 12001) {
            reportNetStatusInternal();
          }
          return;
        case 12005: 
          localBundle.putString("EVT_MSG", "RTMP服务器握手失败");
          i = 3003;
          break;
        case 12012: 
          localBundle.putString("EVT_MSG", "经多次自动重连失败，放弃连接");
          i = -2301;
          break;
        case 12011: 
          localBundle.putString("EVT_MSG", "连接服务器失败");
        }
      }
      localBundle.putString("EVT_MSG", "读数据错误，网络连接断开");
      i = 3005;
      continue;
      localBundle.putString("EVT_MSG", "写数据错误，网络连接断开");
      i = 3005;
      continue;
      localBundle.putString("EVT_MSG", "获取加速拉流地址失败");
      i = -2302;
      continue;
      localBundle.putString("EVT_MSG", "所有拉流地址尝试失败,可以放弃治疗");
      i = -2301;
      continue;
      localBundle.putString("EVT_MSG", "连接结束");
      i = paramInt;
      continue;
      localBundle.putString("EVT_MSG", "已连接服务器");
      i = 2001;
      continue;
      localBundle.putString("EVT_MSG", "连接服务器失败");
      continue;
      localBundle.putString("EVT_MSG", "启动网络重连");
      i = 2103;
      continue;
      localBundle.putString("EVT_MSG", "开始拉流");
      i = 2002;
      continue;
      localBundle.putString("EVT_MSG", "服务器拒绝连接请求");
      i = 2103;
    }
  }
  
  public void onPullAudio(com.tencent.liteav.basic.f.a parama)
  {
    tryResetRetryCount();
    synchronized (this.mListenerLock)
    {
      if (this.mListener != null) {
        this.mListener.onPullAudio(parama);
      }
      return;
    }
  }
  
  public void onPullNAL(b paramb)
  {
    tryResetRetryCount();
    if (!this.mRecvFirstNal)
    {
      reportNetStatusInternal();
      this.mRecvFirstNal = true;
    }
    synchronized (this.mListenerLock)
    {
      this.mCurrentNalTs = paramb.g;
      if (paramb.b == 0) {
        this.mLastIFramelTs = paramb.g;
      }
      if (this.mListener != null) {
        this.mListener.onPullNAL(paramb);
      }
      return;
    }
  }
  
  public void onRestartDownloader()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new TXCStreamDownloader.1(this));
    }
  }
  
  public void onSwitchFinish(TXIStreamDownloader paramTXIStreamDownloader, boolean paramBoolean)
  {
    synchronized (this.mListenerLock)
    {
      int i = (int)(System.currentTimeMillis() - this.mSwitchStartTime);
      this.mSwitchStartTime = 0L;
      Bundle localBundle = new Bundle();
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramBoolean)
      {
        this.mDownloader = paramTXIStreamDownloader;
        this.mDownloader.setListener(this);
        this.mDownloader.setNotifyListener(this);
        this.mDownloader.setRestartListener(this);
        localBundle.putInt("EVT_ID", 2015);
        localBundle.putCharSequence("EVT_MSG", "切换分辨率成功");
        if (this.mNotifyListener != null) {
          this.mNotifyListener.onNotifyEvent(2015, localBundle);
        }
        TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bs, i, "");
        this.mStreamSwitcher = null;
        return;
      }
      localBundle.putInt("EVT_ID", 2015);
      localBundle.putCharSequence("EVT_MSG", "切换分辨率失败");
      if (this.mNotifyListener != null) {
        this.mNotifyListener.onNotifyEvent(2015, localBundle);
      }
      TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bt);
    }
  }
  
  public void setHeaders(Map<String, String> paramMap)
  {
    this.mHeaders = paramMap;
    if (this.mDownloader != null) {
      this.mDownloader.setHeaders(this.mHeaders);
    }
  }
  
  public void setListener(f paramf)
  {
    synchronized (this.mListenerLock)
    {
      this.mListener = paramf;
      return;
    }
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.a parama)
  {
    synchronized (this.mListenerLock)
    {
      this.mNotifyListener = parama;
      return;
    }
  }
  
  public void setRetryInterval(int paramInt)
  {
    if (this.mDownloader != null) {
      this.mDownloader.connectRetryInterval = paramInt;
    }
  }
  
  public void setRetryTimes(int paramInt)
  {
    if (this.mDownloader != null) {
      this.mDownloader.connectRetryLimit = paramInt;
    }
  }
  
  public int start(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    boolean bool = true;
    this.mDownloaderRunning = true;
    this.mRecvFirstNal = false;
    this.mOriginPlayUrl = paramString;
    this.mEnableNearestIP = paramBoolean1;
    this.mChannelType = paramInt;
    this.mEnableMessage = paramBoolean2;
    setStatusValue(7116, Long.valueOf(0L));
    setStatusValue(7117, Long.valueOf(0L));
    setStatusValue(7118, Long.valueOf(0L));
    if (paramString.startsWith("room"))
    {
      setStatusValue(7116, Long.valueOf(1L));
      setStatusValue(7112, Long.valueOf(2L));
      if (this.mDownloader != null)
      {
        localVector = new Vector();
        localVector.add(new e(paramString, true));
        this.mDownloader.setOriginUrl(paramString);
        this.mDownloader.startDownload(localVector, false, false, paramBoolean2);
      }
      if (this.mHandler != null) {
        this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
      }
    }
    do
    {
      do
      {
        return 0;
        if ((!paramBoolean1) || (this.mDownloadFormat != 4)) {
          break;
        }
        paramInt = this.mAccUrlFetcher.a(paramString, paramInt, new TXCStreamDownloader.2(this, paramString, paramBoolean2));
      } while (paramInt == 0);
      if (paramInt == -1) {
        TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, paramInt, "invalid playUrl");
      }
      for (;;)
      {
        TXCLog.e("TXCStreamDownloader", "getAccelerateStreamPlayUrl failed, result = " + paramInt + ", play stream with raw url");
        onNotifyEvent(12030, null);
        playStreamWithRawUrl(paramString, paramBoolean2);
        if (this.mHandler == null) {
          break;
        }
        this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
        return 0;
        if (paramInt == -2) {
          TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, paramInt, "invalid streamID");
        } else if (paramInt == -3) {
          TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, paramInt, "invalid signature");
        }
      }
    } while (this.mDownloader == null);
    setStatusValue(7112, Long.valueOf(1L));
    Vector localVector = new Vector();
    localVector.add(new e(paramString, false));
    this.mDownloader.setOriginUrl(paramString);
    paramString = this.mDownloader;
    if (this.mDownloadFormat == 4) {}
    for (;;)
    {
      paramString.startDownload(localVector, bool, paramBoolean1, paramBoolean2);
      if (this.mHandler == null) {
        break;
      }
      this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
      return 0;
      bool = false;
    }
  }
  
  public void stop()
  {
    this.mDownloaderRunning = false;
    this.mRecvFirstNal = false;
    if (this.mDownloader != null) {
      this.mDownloader.stopDownload();
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.mReportNetStatusRunnalbe);
    }
    synchronized (this.mListenerLock)
    {
      if (this.mStreamSwitcher != null)
      {
        this.mStreamSwitcher.a(null);
        this.mStreamSwitcher.a();
        this.mStreamSwitcher = null;
      }
      return;
    }
  }
  
  public boolean switchStream(String paramString)
  {
    synchronized (this.mListenerLock)
    {
      if (this.mStreamSwitcher != null)
      {
        TXCLog.w("TXCStreamDownloader", "stream_switch stream is changing ignore this change");
        return false;
      }
      TXCFLVDownloader localTXCFLVDownloader = new TXCFLVDownloader(this.mApplicationContext);
      localTXCFLVDownloader.connectRetryLimit = this.mDownloader.connectRetryLimit;
      localTXCFLVDownloader.connectRetryInterval = this.mDownloader.connectRetryInterval;
      localTXCFLVDownloader.setHeaders(this.mHeaders);
      this.mStreamSwitcher = new d(this);
      this.mStreamSwitcher.a(this);
      this.mStreamSwitcher.a(this.mDownloader, localTXCFLVDownloader, this.mCurrentNalTs, this.mLastIFramelTs, paramString);
      this.mSwitchStartTime = System.currentTimeMillis();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamDownloader
 * JD-Core Version:    0.7.0.1
 */