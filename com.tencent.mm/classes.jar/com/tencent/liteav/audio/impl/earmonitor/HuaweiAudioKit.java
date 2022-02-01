package com.tencent.liteav.audio.impl.earmonitor;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huawei.a.a.b.a.c;
import com.huawei.a.a.b.a.c.a;
import com.huawei.a.a.b.a.d;
import com.huawei.a.a.b.a.d.a;
import com.huawei.a.a.b.a.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.j;
import com.tencent.liteav.basic.util.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public class HuaweiAudioKit
  implements e, TXSystemAudioKit, j.a
{
  private static final int BACKGROUND_CHECK_INTERVAL;
  private static final String TAG = "HuaweiAudioKit";
  private a mAudioKitCallback;
  private j mBackgroundCheckTimer;
  private d mHwAudioKit;
  private boolean mIsAudioKitIniting;
  private boolean mIsBackgroundWhenLastCheck;
  private boolean mIsEarMonitoringEnabled;
  private c mKaraokeKit;
  private final Handler mUiHandler;
  
  static
  {
    AppMethodBeat.i(246760);
    BACKGROUND_CHECK_INTERVAL = (int)TimeUnit.SECONDS.toMillis(1L);
    AppMethodBeat.o(246760);
  }
  
  public HuaweiAudioKit()
  {
    AppMethodBeat.i(246729);
    this.mUiHandler = new Handler(Looper.getMainLooper());
    this.mIsAudioKitIniting = false;
    this.mIsEarMonitoringEnabled = false;
    this.mIsBackgroundWhenLastCheck = false;
    AppMethodBeat.o(246729);
  }
  
  private void dealWithAudioKitResultInternal(int paramInt)
  {
    AppMethodBeat.i(246747);
    TXCLog.i("HuaweiAudioKit", "on audio kit callback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      this.mIsAudioKitIniting = false;
      if (this.mAudioKitCallback != null) {
        this.mAudioKitCallback.onAudioKitInitFinished(this, true);
      }
      if (this.mHwAudioKit.a(d.a.chO))
      {
        this.mKaraokeKit = ((c)this.mHwAudioKit.b(d.a.chO));
        AppMethodBeat.o(246747);
        return;
      }
      if (this.mAudioKitCallback != null)
      {
        this.mAudioKitCallback.onEarMonitoringInitialized(this, false);
        AppMethodBeat.o(246747);
      }
    }
    else if (paramInt == 1000)
    {
      if (this.mAudioKitCallback != null)
      {
        this.mAudioKitCallback.onEarMonitoringInitialized(this, true);
        AppMethodBeat.o(246747);
      }
    }
    else if ((paramInt != 1805) && (this.mAudioKitCallback != null))
    {
      if (this.mIsAudioKitIniting)
      {
        this.mAudioKitCallback.onAudioKitInitFinished(this, false);
        this.mIsAudioKitIniting = false;
        AppMethodBeat.o(246747);
        return;
      }
      this.mAudioKitCallback.onAudioKitError(this);
    }
    AppMethodBeat.o(246747);
  }
  
  private boolean isAppInBackground()
  {
    AppMethodBeat.i(246750);
    try
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if (localRunningAppProcessInfo.importance != 100)
      {
        AppMethodBeat.o(246750);
        return true;
      }
      AppMethodBeat.o(246750);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(246750);
    }
    return false;
  }
  
  private void setSystemEarMonitoringVolumeInternal(int paramInt)
  {
    AppMethodBeat.i(246743);
    TXCLog.i("HuaweiAudioKit", "setSystemEarMonitoringVolumeInternal: %d, kit: %s", new Object[] { Integer.valueOf(paramInt), this.mKaraokeKit });
    if (this.mKaraokeKit != null)
    {
      paramInt = this.mKaraokeKit.a(c.a.chH, paramInt);
      if ((paramInt == 1806) || (paramInt == -2)) {
        dealWithAudioKitResultInternal(-2);
      }
    }
    AppMethodBeat.o(246743);
  }
  
  private void startSystemEarMonitoringInternal()
  {
    AppMethodBeat.i(246735);
    TXCLog.i("HuaweiAudioKit", "startSystemEarMonitoring kit: %s", new Object[] { this.mKaraokeKit });
    if (this.mKaraokeKit == null)
    {
      AppMethodBeat.o(246735);
      return;
    }
    int i = this.mKaraokeKit.bV(true);
    if ((i != 0) && (i != 1805))
    {
      dealWithAudioKitResultInternal(1003);
      AppMethodBeat.o(246735);
      return;
    }
    this.mIsEarMonitoringEnabled = true;
    AppMethodBeat.o(246735);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(246733);
    if (this.mBackgroundCheckTimer != null)
    {
      AppMethodBeat.o(246733);
      return;
    }
    TXCLog.i("HuaweiAudioKit", "start background checking timer");
    this.mBackgroundCheckTimer = new j(Looper.getMainLooper(), this);
    this.mBackgroundCheckTimer.a(0, BACKGROUND_CHECK_INTERVAL);
    AppMethodBeat.o(246733);
  }
  
  private void stopSystemEarMonitoringInternal()
  {
    AppMethodBeat.i(246740);
    TXCLog.i("HuaweiAudioKit", "stopSystemEarMonitoring");
    if (this.mKaraokeKit != null)
    {
      this.mKaraokeKit.bV(false);
      this.mIsEarMonitoringEnabled = false;
    }
    AppMethodBeat.o(246740);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(246739);
    if (this.mBackgroundCheckTimer != null)
    {
      TXCLog.i("HuaweiAudioKit", "stop background checking timer");
      this.mBackgroundCheckTimer.a();
      this.mBackgroundCheckTimer = null;
    }
    AppMethodBeat.o(246739);
  }
  
  public void initialize(final Context paramContext, final a parama)
  {
    AppMethodBeat.i(246730);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(246712);
        if (HuaweiAudioKit.this.mHwAudioKit != null)
        {
          TXCLog.e("HuaweiAudioKit", "it's already initialized.");
          AppMethodBeat.o(246712);
          return;
        }
        TXCLog.i("HuaweiAudioKit", "start initialize audio kit");
        HuaweiAudioKit.access$102(HuaweiAudioKit.this, true);
        HuaweiAudioKit.access$202(HuaweiAudioKit.this, parama);
        HuaweiAudioKit.access$002(HuaweiAudioKit.this, new d(paramContext.getApplicationContext(), HuaweiAudioKit.this));
        HuaweiAudioKit.this.mHwAudioKit.initialize();
        AppMethodBeat.o(246712);
      }
    });
    AppMethodBeat.o(246730);
  }
  
  public void onResult(final int paramInt)
  {
    AppMethodBeat.i(246744);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(246789);
        HuaweiAudioKit.access$900(HuaweiAudioKit.this, paramInt);
        AppMethodBeat.o(246789);
      }
    });
    AppMethodBeat.o(246744);
  }
  
  public void onTimeout()
  {
    AppMethodBeat.i(246748);
    boolean bool = isAppInBackground();
    if ((this.mIsEarMonitoringEnabled) && (this.mIsBackgroundWhenLastCheck) && (!bool))
    {
      stopSystemEarMonitoringInternal();
      startSystemEarMonitoringInternal();
    }
    for (;;)
    {
      this.mIsBackgroundWhenLastCheck = bool;
      AppMethodBeat.o(246748);
      return;
      if ((bool) && (!this.mIsBackgroundWhenLastCheck)) {
        TXCLog.i("HuaweiAudioKit", "app has gone to background.");
      }
    }
  }
  
  public void setSystemEarMonitoringVolume(final int paramInt)
  {
    AppMethodBeat.i(246741);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(246702);
        HuaweiAudioKit.access$800(HuaweiAudioKit.this, paramInt);
        AppMethodBeat.o(246702);
      }
    });
    AppMethodBeat.o(246741);
  }
  
  public void startSystemEarMonitoring()
  {
    AppMethodBeat.i(246732);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(246867);
        HuaweiAudioKit.access$400(HuaweiAudioKit.this);
        HuaweiAudioKit.access$500(HuaweiAudioKit.this);
        AppMethodBeat.o(246867);
      }
    });
    AppMethodBeat.o(246732);
  }
  
  public void stopSystemEarMonitoring()
  {
    AppMethodBeat.i(246736);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(246823);
        HuaweiAudioKit.access$600(HuaweiAudioKit.this);
        HuaweiAudioKit.access$700(HuaweiAudioKit.this);
        AppMethodBeat.o(246823);
      }
    });
    AppMethodBeat.o(246736);
  }
  
  public void uninitialize()
  {
    AppMethodBeat.i(246731);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(246883);
        TXCLog.i("HuaweiAudioKit", "uninitialize");
        if (HuaweiAudioKit.this.mKaraokeKit != null)
        {
          HuaweiAudioKit.this.mKaraokeKit.destroy();
          HuaweiAudioKit.access$302(HuaweiAudioKit.this, null);
        }
        if (HuaweiAudioKit.this.mHwAudioKit != null)
        {
          HuaweiAudioKit.this.mHwAudioKit.destroy();
          HuaweiAudioKit.access$002(HuaweiAudioKit.this, null);
        }
        HuaweiAudioKit.access$102(HuaweiAudioKit.this, false);
        AppMethodBeat.o(246883);
      }
    });
    AppMethodBeat.o(246731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit
 * JD-Core Version:    0.7.0.1
 */