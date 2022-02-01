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
    AppMethodBeat.i(230617);
    BACKGROUND_CHECK_INTERVAL = (int)TimeUnit.SECONDS.toMillis(1L);
    AppMethodBeat.o(230617);
  }
  
  public HuaweiAudioKit()
  {
    AppMethodBeat.i(230511);
    this.mUiHandler = new Handler(Looper.getMainLooper());
    this.mIsAudioKitIniting = false;
    this.mIsEarMonitoringEnabled = false;
    this.mIsBackgroundWhenLastCheck = false;
    AppMethodBeat.o(230511);
  }
  
  private void dealWithAudioKitResultInternal(int paramInt)
  {
    AppMethodBeat.i(230547);
    TXCLog.i("HuaweiAudioKit", "on audio kit callback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      this.mIsAudioKitIniting = false;
      if (this.mAudioKitCallback != null) {
        this.mAudioKitCallback.onAudioKitInitFinished(this, true);
      }
      if (this.mHwAudioKit.a(d.a.dXW))
      {
        this.mKaraokeKit = ((c)this.mHwAudioKit.b(d.a.dXW));
        AppMethodBeat.o(230547);
        return;
      }
      if (this.mAudioKitCallback != null)
      {
        this.mAudioKitCallback.onEarMonitoringInitialized(this, false);
        AppMethodBeat.o(230547);
      }
    }
    else if (paramInt == 1000)
    {
      if (this.mAudioKitCallback != null)
      {
        this.mAudioKitCallback.onEarMonitoringInitialized(this, true);
        AppMethodBeat.o(230547);
      }
    }
    else if ((paramInt != 1805) && (this.mAudioKitCallback != null))
    {
      if (this.mIsAudioKitIniting)
      {
        this.mAudioKitCallback.onAudioKitInitFinished(this, false);
        this.mIsAudioKitIniting = false;
        AppMethodBeat.o(230547);
        return;
      }
      this.mAudioKitCallback.onAudioKitError(this);
    }
    AppMethodBeat.o(230547);
  }
  
  private boolean isAppInBackground()
  {
    AppMethodBeat.i(230554);
    try
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if (localRunningAppProcessInfo.importance != 100)
      {
        AppMethodBeat.o(230554);
        return true;
      }
      AppMethodBeat.o(230554);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(230554);
    }
    return false;
  }
  
  private void setSystemEarMonitoringVolumeInternal(int paramInt)
  {
    AppMethodBeat.i(230539);
    TXCLog.i("HuaweiAudioKit", "setSystemEarMonitoringVolumeInternal: %d, kit: %s", new Object[] { Integer.valueOf(paramInt), this.mKaraokeKit });
    if (this.mKaraokeKit != null)
    {
      paramInt = this.mKaraokeKit.a(c.a.dXP, paramInt);
      if ((paramInt == 1806) || (paramInt == -2)) {
        dealWithAudioKitResultInternal(-2);
      }
    }
    AppMethodBeat.o(230539);
  }
  
  private void startSystemEarMonitoringInternal()
  {
    AppMethodBeat.i(230522);
    TXCLog.i("HuaweiAudioKit", "startSystemEarMonitoring kit: %s", new Object[] { this.mKaraokeKit });
    if (this.mKaraokeKit == null)
    {
      AppMethodBeat.o(230522);
      return;
    }
    int i = this.mKaraokeKit.cA(true);
    if ((i != 0) && (i != 1805))
    {
      dealWithAudioKitResultInternal(1003);
      AppMethodBeat.o(230522);
      return;
    }
    this.mIsEarMonitoringEnabled = true;
    AppMethodBeat.o(230522);
  }
  
  private void startTimer()
  {
    AppMethodBeat.i(230514);
    if (this.mBackgroundCheckTimer != null)
    {
      AppMethodBeat.o(230514);
      return;
    }
    TXCLog.i("HuaweiAudioKit", "start background checking timer");
    this.mBackgroundCheckTimer = new j(Looper.getMainLooper(), this);
    this.mBackgroundCheckTimer.a(0, BACKGROUND_CHECK_INTERVAL);
    AppMethodBeat.o(230514);
  }
  
  private void stopSystemEarMonitoringInternal()
  {
    AppMethodBeat.i(230533);
    TXCLog.i("HuaweiAudioKit", "stopSystemEarMonitoring");
    if (this.mKaraokeKit != null)
    {
      this.mKaraokeKit.cA(false);
      this.mIsEarMonitoringEnabled = false;
    }
    AppMethodBeat.o(230533);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(230526);
    if (this.mBackgroundCheckTimer != null)
    {
      TXCLog.i("HuaweiAudioKit", "stop background checking timer");
      this.mBackgroundCheckTimer.a();
      this.mBackgroundCheckTimer = null;
    }
    AppMethodBeat.o(230526);
  }
  
  public void initialize(final Context paramContext, final a parama)
  {
    AppMethodBeat.i(230624);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230494);
        if (HuaweiAudioKit.this.mHwAudioKit != null)
        {
          TXCLog.e("HuaweiAudioKit", "it's already initialized.");
          AppMethodBeat.o(230494);
          return;
        }
        TXCLog.i("HuaweiAudioKit", "start initialize audio kit");
        HuaweiAudioKit.access$102(HuaweiAudioKit.this, true);
        HuaweiAudioKit.access$202(HuaweiAudioKit.this, parama);
        HuaweiAudioKit.access$002(HuaweiAudioKit.this, new d(paramContext.getApplicationContext(), HuaweiAudioKit.this));
        HuaweiAudioKit.this.mHwAudioKit.initialize();
        AppMethodBeat.o(230494);
      }
    });
    AppMethodBeat.o(230624);
  }
  
  public void onResult(final int paramInt)
  {
    AppMethodBeat.i(230641);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230491);
        HuaweiAudioKit.access$900(HuaweiAudioKit.this, paramInt);
        AppMethodBeat.o(230491);
      }
    });
    AppMethodBeat.o(230641);
  }
  
  public void onTimeout()
  {
    AppMethodBeat.i(230644);
    boolean bool = isAppInBackground();
    if ((this.mIsEarMonitoringEnabled) && (this.mIsBackgroundWhenLastCheck) && (!bool))
    {
      stopSystemEarMonitoringInternal();
      startSystemEarMonitoringInternal();
    }
    for (;;)
    {
      this.mIsBackgroundWhenLastCheck = bool;
      AppMethodBeat.o(230644);
      return;
      if ((bool) && (!this.mIsBackgroundWhenLastCheck)) {
        TXCLog.i("HuaweiAudioKit", "app has gone to background.");
      }
    }
  }
  
  public void setSystemEarMonitoringVolume(final int paramInt)
  {
    AppMethodBeat.i(230637);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230497);
        HuaweiAudioKit.access$800(HuaweiAudioKit.this, paramInt);
        AppMethodBeat.o(230497);
      }
    });
    AppMethodBeat.o(230637);
  }
  
  public void startSystemEarMonitoring()
  {
    AppMethodBeat.i(230631);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230498);
        HuaweiAudioKit.access$400(HuaweiAudioKit.this);
        HuaweiAudioKit.access$500(HuaweiAudioKit.this);
        AppMethodBeat.o(230498);
      }
    });
    AppMethodBeat.o(230631);
  }
  
  public void stopSystemEarMonitoring()
  {
    AppMethodBeat.i(230634);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230508);
        HuaweiAudioKit.access$600(HuaweiAudioKit.this);
        HuaweiAudioKit.access$700(HuaweiAudioKit.this);
        AppMethodBeat.o(230508);
      }
    });
    AppMethodBeat.o(230634);
  }
  
  public void uninitialize()
  {
    AppMethodBeat.i(230627);
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230504);
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
        AppMethodBeat.o(230504);
      }
    });
    AppMethodBeat.o(230627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit
 * JD-Core Version:    0.7.0.1
 */