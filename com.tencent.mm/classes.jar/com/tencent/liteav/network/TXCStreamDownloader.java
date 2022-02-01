package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class TXCStreamDownloader
  extends com.tencent.liteav.basic.module.a
  implements com.tencent.liteav.basic.c.a, TXIStreamDownloader.a, d.a, f
{
  public static final String TAG = "TXCStreamDownloader";
  private g mAccUrlFetcher;
  private Context mApplicationContext;
  private int mChannelType;
  private long mCurrentNalTs;
  private int mDownloadFormat;
  private TXIStreamDownloader mDownloader;
  private boolean mDownloaderRunning;
  private boolean mEnableMessage;
  private boolean mEnableMetaData;
  private boolean mEnableNearestIP;
  private Handler mHandler;
  protected Map<String, String> mHeaders;
  private DownloadStats mLastDownloadStats;
  private long mLastIFramelTs;
  private long mLastTimeStamp;
  private f mListener;
  private byte[] mListenerLock;
  private com.tencent.liteav.basic.c.a mNotifyListener;
  private String mOriginPlayUrl;
  private boolean mRecvFirstNal;
  private Runnable mReportNetStatusRunnalbe;
  private d mStreamSwitcher;
  private long mSwitchStartTime;
  
  static
  {
    AppMethodBeat.i(15307);
    com.tencent.liteav.basic.util.f.f();
    AppMethodBeat.o(15307);
  }
  
  public TXCStreamDownloader(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(15293);
    this.mDownloader = null;
    this.mListener = null;
    this.mListenerLock = new byte[0];
    this.mNotifyListener = null;
    this.mDownloaderRunning = false;
    this.mOriginPlayUrl = "";
    this.mEnableNearestIP = false;
    this.mChannelType = 0;
    this.mEnableMessage = false;
    this.mEnableMetaData = false;
    this.mDownloadFormat = 1;
    this.mHandler = null;
    this.mLastTimeStamp = 0L;
    this.mLastDownloadStats = null;
    this.mRecvFirstNal = false;
    this.mSwitchStartTime = 0L;
    this.mCurrentNalTs = 0L;
    this.mLastIFramelTs = 0L;
    this.mStreamSwitcher = null;
    this.mReportNetStatusRunnalbe = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15407);
        TXCStreamDownloader.access$1200(TXCStreamDownloader.this);
        AppMethodBeat.o(15407);
      }
    };
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
        AppMethodBeat.o(15293);
        return;
      } while ((paramInt != 1) && (paramInt != 4));
    }
  }
  
  private DownloadStats getDownloadStats()
  {
    AppMethodBeat.i(15299);
    if (this.mDownloader != null)
    {
      DownloadStats localDownloadStats = this.mDownloader.getDownloadStats();
      AppMethodBeat.o(15299);
      return localDownloadStats;
    }
    AppMethodBeat.o(15299);
    return null;
  }
  
  private a getRealTimeStreamInfo()
  {
    AppMethodBeat.i(15300);
    a locala = new a();
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
    AppMethodBeat.o(15300);
    return locala;
  }
  
  private Long getSpeed(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = 0L;
    AppMethodBeat.i(15303);
    if (paramLong1 > paramLong2) {}
    for (;;)
    {
      paramLong1 = l;
      if (paramLong3 > 0L) {
        paramLong1 = 8L * paramLong2 * 1000L / (1024L * paramLong3);
      }
      AppMethodBeat.o(15303);
      return Long.valueOf(paramLong1);
      paramLong2 -= paramLong1;
    }
  }
  
  private void playStreamWithRawUrl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(15295);
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
        this.mDownloader.setUserID(getID());
      }
      setStatusValue(7112, Long.valueOf(1L));
      Vector localVector = new Vector();
      localVector.add(new e(paramString, false));
      this.mDownloader.setOriginUrl(paramString);
      this.mDownloader.startDownload(localVector, false, false, paramBoolean, paramBoolean);
    }
    AppMethodBeat.o(15295);
  }
  
  private void reportNetStatus()
  {
    AppMethodBeat.i(15301);
    reportNetStatusInternal();
    this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
    AppMethodBeat.o(15301);
  }
  
  private void reportNetStatusInternal()
  {
    AppMethodBeat.i(15302);
    long l3 = TXCTimeUtil.getTimeTick();
    long l4 = l3 - this.mLastTimeStamp;
    DownloadStats localDownloadStats = getDownloadStats();
    a locala = getRealTimeStreamInfo();
    long l2 = 0L;
    long l1 = 0L;
    if (localDownloadStats != null)
    {
      if (this.mLastDownloadStats != null)
      {
        l2 = getSpeed(this.mLastDownloadStats.afterParseVideoBytes, localDownloadStats.afterParseVideoBytes, l4).longValue();
        l1 = getSpeed(this.mLastDownloadStats.afterParseAudioBytes, localDownloadStats.afterParseAudioBytes, l4).longValue();
      }
      if ((l2 > 0L) || (l1 > 0L)) {
        this.mDownloader.connectRetryTimes = 0;
      }
      setStatusValue(7101, Long.valueOf(l2));
      setStatusValue(7102, Long.valueOf(l1));
      setStatusValue(7103, Long.valueOf(localDownloadStats.firstVideoTS));
      setStatusValue(7104, Long.valueOf(localDownloadStats.firstAudioTS));
      setStatusValue(7120, Long.valueOf(localDownloadStats.videoGop));
      if (locala != null)
      {
        setStatusValue(7105, Long.valueOf(locala.d));
        setStatusValue(7106, locala.e);
        if (!locala.f) {
          break label437;
        }
      }
    }
    label437:
    for (l1 = 2L;; l1 = 1L)
    {
      setStatusValue(7111, Long.valueOf(l1));
      setStatusValue(7116, locala.a);
      setStatusValue(7117, locala.b);
      setStatusValue(7118, locala.c);
      setStatusValue(7107, Long.valueOf(localDownloadStats.startTS));
      setStatusValue(7108, Long.valueOf(localDownloadStats.dnsTS));
      setStatusValue(7109, Long.valueOf(localDownloadStats.connTS));
      setStatusValue(7110, String.valueOf(localDownloadStats.serverIP));
      if (this.mDownloader != null)
      {
        int i = this.mDownloader.getConnectCountQuic();
        int j = this.mDownloader.getConnectCountTcp();
        setStatusValue(7114, Long.valueOf(i + 1));
        setStatusValue(7115, Long.valueOf(j + 1));
        setStatusValue(7119, this.mDownloader.getRealStreamUrl());
      }
      this.mLastTimeStamp = l3;
      this.mLastDownloadStats = localDownloadStats;
      AppMethodBeat.o(15302);
      return;
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
    AppMethodBeat.i(15286);
    for (;;)
    {
      synchronized (this.mListenerLock)
      {
        if (this.mNotifyListener != null) {
          localBundle = new Bundle();
        }
        Object localObject;
        switch (paramInt)
        {
        case 3003: 
          localBundle.putString("EVT_MSG", "UNKNOWN event = ".concat(String.valueOf(paramInt)));
          break label437;
          localObject = "";
          if (paramBundle != null) {
            localObject = paramBundle.getString("EVT_MSG", "");
          }
          if ((localObject != null) && (!((String)localObject).isEmpty())) {
            localBundle.putString("EVT_MSG", (String)localObject);
          }
          localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          this.mNotifyListener.onNotifyEvent(paramInt, localBundle);
          if (paramInt == 2001) {
            reportNetStatusInternal();
          }
          AppMethodBeat.o(15286);
          return;
          localBundle.putString("EVT_MSG", "RTMP服务器握手失败");
          break;
        case -2301: 
          localBundle.putString("EVT_MSG", "经多次自动重连失败，放弃连接");
          break;
        case 3010: 
          localBundle.putString("EVT_MSG", "该流地址无视频");
          break;
        case 3007: 
          localBundle.putString("EVT_MSG", "读数据错误，网络连接断开");
          break;
        case 3006: 
          localBundle.putString("EVT_MSG", "写数据错误，网络连接断开");
          break;
        case -2302: 
          localBundle.putString("EVT_MSG", "获取加速拉流地址失败");
          break;
        case 2001: 
          localBundle.putString("EVT_MSG", "已连接服务器");
          break;
        case 3002: 
          localBundle.putString("EVT_MSG", "连接服务器失败");
          break;
        case 2103: 
          localBundle.putString("EVT_MSG", "启动网络重连");
          break;
        case 2002: 
          localBundle.putString("EVT_MSG", "开始拉流");
          break;
        case -2308: 
          localBundle.putString("EVT_MSG", "服务器拒绝连接请求");
          break;
        case 2012: 
          localObject = paramBundle.getByteArray("EVT_GET_MSG");
          if ((localObject == null) || (localObject.length <= 0)) {
            break label437;
          }
          localBundle.putByteArray("EVT_GET_MSG", (byte[])localObject);
        }
      }
      continue;
      label437:
      continue;
      Bundle localBundle = paramBundle;
    }
  }
  
  public void onOldStreamStop()
  {
    AppMethodBeat.i(15290);
    synchronized (this.mListenerLock)
    {
      if (this.mStreamSwitcher != null) {
        this.mStreamSwitcher.b();
      }
      AppMethodBeat.o(15290);
      return;
    }
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(15287);
    tryResetRetryCount();
    synchronized (this.mListenerLock)
    {
      if (this.mListener != null) {
        this.mListener.onPullAudio(parama);
      }
      if (this.mDownloader != null) {
        this.mDownloader.PushAudioFrame(parama.f, parama.h, parama.e, parama.g);
      }
      AppMethodBeat.o(15287);
      return;
    }
  }
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(15288);
    tryResetRetryCount();
    if (!this.mRecvFirstNal)
    {
      reportNetStatusInternal();
      this.mRecvFirstNal = true;
    }
    synchronized (this.mListenerLock)
    {
      this.mCurrentNalTs = paramTXSNALPacket.pts;
      if (paramTXSNALPacket.nalType == 0) {
        this.mLastIFramelTs = paramTXSNALPacket.pts;
      }
      if (this.mListener != null) {
        this.mListener.onPullNAL(paramTXSNALPacket);
      }
      if (this.mDownloader != null) {
        this.mDownloader.PushVideoFrame(paramTXSNALPacket.nalData, paramTXSNALPacket.nalType, paramTXSNALPacket.dts, paramTXSNALPacket.pts, paramTXSNALPacket.codecId);
      }
      AppMethodBeat.o(15288);
      return;
    }
  }
  
  public void onRestartDownloader()
  {
    AppMethodBeat.i(15289);
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15421);
          TXCStreamDownloader.this.stop();
          TXCStreamDownloader.this.start(TXCStreamDownloader.this.mOriginPlayUrl, TXCStreamDownloader.this.mEnableNearestIP, TXCStreamDownloader.this.mChannelType, TXCStreamDownloader.this.mEnableMessage, TXCStreamDownloader.this.mEnableMetaData);
          AppMethodBeat.o(15421);
        }
      });
    }
    AppMethodBeat.o(15289);
  }
  
  public void onSwitchFinish(TXIStreamDownloader paramTXIStreamDownloader, boolean paramBoolean)
  {
    AppMethodBeat.i(15292);
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
        TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bw, i, "");
        this.mStreamSwitcher = null;
        AppMethodBeat.o(15292);
        return;
      }
      localBundle.putInt("EVT_ID", 2015);
      localBundle.putCharSequence("EVT_MSG", "切换分辨率失败");
      if (this.mNotifyListener != null) {
        this.mNotifyListener.onNotifyEvent(2015, localBundle);
      }
      TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bx);
    }
  }
  
  public void requestKeyFrame(String paramString)
  {
    AppMethodBeat.i(15298);
    if ((this.mDownloaderRunning) && (paramString != null) && (paramString.startsWith("room")) && (this.mDownloader != null)) {
      this.mDownloader.requestKeyFrame(paramString);
    }
    AppMethodBeat.o(15298);
  }
  
  public void setHeaders(Map<String, String> paramMap)
  {
    AppMethodBeat.i(15304);
    this.mHeaders = paramMap;
    if (this.mDownloader != null) {
      this.mDownloader.setHeaders(this.mHeaders);
    }
    AppMethodBeat.o(15304);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(15291);
    super.setID(paramString);
    if (this.mDownloader != null) {
      this.mDownloader.setUserID(paramString);
    }
    AppMethodBeat.o(15291);
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
  
  public int start(final String paramString, boolean paramBoolean1, int paramInt, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(15294);
    this.mDownloaderRunning = true;
    this.mRecvFirstNal = false;
    this.mOriginPlayUrl = paramString;
    this.mEnableNearestIP = paramBoolean1;
    this.mChannelType = paramInt;
    this.mEnableMessage = paramBoolean2;
    this.mEnableMetaData = paramBoolean3;
    setStatusValue(7113, Long.valueOf(0L));
    setStatusValue(7114, Long.valueOf(0L));
    setStatusValue(7115, Long.valueOf(0L));
    Vector localVector;
    if (paramString.startsWith("room"))
    {
      setStatusValue(7113, Long.valueOf(1L));
      setStatusValue(7112, Long.valueOf(2L));
      if (this.mDownloader != null)
      {
        localVector = new Vector();
        localVector.add(new e(paramString, true));
        this.mDownloader.setOriginUrl(paramString);
        this.mDownloader.setUserID(getID());
        this.mDownloader.startDownload(localVector, false, false, paramBoolean2, paramBoolean3);
      }
      if (this.mHandler != null) {
        this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
      }
      AppMethodBeat.o(15294);
      return 0;
    }
    if ((paramBoolean1) && (this.mDownloadFormat == 4))
    {
      paramInt = this.mAccUrlFetcher.a(paramString, paramInt, new g.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString, Vector<e> paramAnonymousVector)
        {
          AppMethodBeat.i(15467);
          int i;
          if ((paramAnonymousInt == 0) && (paramAnonymousVector != null) && (!paramAnonymousVector.isEmpty())) {
            if (TXCStreamDownloader.this.mDownloaderRunning) {
              if (TXCStreamDownloader.this.mDownloader != null)
              {
                paramAnonymousString = paramAnonymousVector.iterator();
                i = 0;
                if (paramAnonymousString.hasNext())
                {
                  e locale = (e)paramAnonymousString.next();
                  if ((locale == null) || (!paramBoolean2) || (paramString == null) || (paramString.length() <= 0)) {
                    break label363;
                  }
                  i += 1;
                }
              }
            }
          }
          label363:
          for (;;)
          {
            break;
            TXCStreamDownloader.this.setStatusValue(7113, Long.valueOf(i));
            TXCStreamDownloader.this.setStatusValue(7112, Long.valueOf(2L));
            TXCStreamDownloader.this.mDownloader.setOriginUrl(paramString);
            TXCStreamDownloader.this.mDownloader.startDownload(paramAnonymousVector, true, true, paramBoolean2, paramBoolean3);
            if (TXCStreamDownloader.this.mHandler != null) {
              TXCStreamDownloader.this.mHandler.postDelayed(TXCStreamDownloader.this.mReportNetStatusRunnalbe, 2000L);
            }
            paramAnonymousString = TXCStreamDownloader.this.mAccUrlFetcher.b();
            TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, paramAnonymousInt, paramAnonymousString);
            AppMethodBeat.o(15467);
            return;
            TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, -4, "livePlayer have been stopped");
            AppMethodBeat.o(15467);
            return;
            TXCStreamDownloader.this.onNotifyEvent(-2302, null);
            TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, paramAnonymousInt, paramAnonymousString);
            TXCLog.e("TXCStreamDownloader", "getAccelerateStreamPlayUrl failed, play stream with raw url");
            if (TXCStreamDownloader.this.mDownloaderRunning)
            {
              TXCStreamDownloader.access$1100(TXCStreamDownloader.this, paramString, paramBoolean2);
              if (TXCStreamDownloader.this.mHandler != null) {
                TXCStreamDownloader.this.mHandler.postDelayed(TXCStreamDownloader.this.mReportNetStatusRunnalbe, 2000L);
              }
            }
            AppMethodBeat.o(15467);
            return;
          }
        }
      });
      if (paramInt != 0)
      {
        if (paramInt != -1) {
          break label341;
        }
        TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, paramInt, "invalid playUrl");
      }
      for (;;)
      {
        TXCLog.e("TXCStreamDownloader", "getAccelerateStreamPlayUrl failed, result = " + paramInt + ", play stream with raw url");
        onNotifyEvent(-2302, null);
        playStreamWithRawUrl(paramString, paramBoolean2);
        if (this.mHandler != null) {
          this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
        }
        AppMethodBeat.o(15294);
        return 0;
        label341:
        if (paramInt == -2) {
          TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, paramInt, "invalid streamID");
        } else if (paramInt == -3) {
          TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, paramInt, "invalid signature");
        }
      }
    }
    if (this.mDownloader != null)
    {
      setStatusValue(7112, Long.valueOf(1L));
      localVector = new Vector();
      localVector.add(new e(paramString, false));
      this.mDownloader.setOriginUrl(paramString);
      paramString = this.mDownloader;
      if (this.mDownloadFormat != 4) {
        break label497;
      }
    }
    label497:
    for (boolean bool = true;; bool = false)
    {
      paramString.startDownload(localVector, bool, paramBoolean1, paramBoolean2, paramBoolean3);
      if (this.mHandler != null) {
        this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
      }
      AppMethodBeat.o(15294);
      return 0;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(15296);
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
      AppMethodBeat.o(15296);
      return;
    }
  }
  
  public boolean switchStream(String paramString)
  {
    AppMethodBeat.i(15297);
    synchronized (this.mListenerLock)
    {
      if ((this.mStreamSwitcher != null) || (this.mDownloader == null) || (!(this.mDownloader instanceof TXCFLVDownloader)))
      {
        TXCLog.w("TXCStreamDownloader", "stream_switch stream is changing ignore this change");
        AppMethodBeat.o(15297);
        return false;
      }
      TXCFLVDownloader localTXCFLVDownloader = new TXCFLVDownloader(this.mApplicationContext, (TXCFLVDownloader)this.mDownloader);
      localTXCFLVDownloader.connectRetryLimit = this.mDownloader.connectRetryLimit;
      localTXCFLVDownloader.connectRetryInterval = this.mDownloader.connectRetryInterval;
      localTXCFLVDownloader.setHeaders(this.mHeaders);
      localTXCFLVDownloader.setUserID(getID());
      this.mStreamSwitcher = new d(this);
      this.mStreamSwitcher.a(this);
      this.mStreamSwitcher.a(this.mDownloader, localTXCFLVDownloader, this.mCurrentNalTs, this.mLastIFramelTs, paramString);
      this.mSwitchStartTime = System.currentTimeMillis();
      AppMethodBeat.o(15297);
      return true;
    }
  }
  
  public static class DownloadStats
  {
    public long afterParseAudioBytes;
    public long afterParseVideoBytes;
    public long beforeParseAudioBytes;
    public long beforeParseVideoBytes;
    public long connTS;
    public long dnsTS;
    public long firstAudioTS;
    public long firstVideoTS;
    public String serverIP;
    public long startTS;
    public long videoGop;
  }
  
  public static class a
  {
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public boolean f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamDownloader
 * JD-Core Version:    0.7.0.1
 */