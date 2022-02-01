package com.tencent.liteav.device;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXDeviceManagerImpl
  implements TXDeviceManager
{
  public static final int AUDIO_ROUTE_EARPIECE = 1;
  public static final int AUDIO_ROUTE_SPEAKER = 0;
  public static final int SystemVolumeTypeAuto = 0;
  public static final int SystemVolumeTypeMedia = 1;
  public static final int SystemVolumeTypeVOIP = 2;
  public static final String TAG = "TXDeviceManagerImpl";
  protected d mCaptureAndEnc;
  private TXDeviceManagerListener mDeviceManagerListener;
  private boolean mIsFrontCamera;
  protected Handler mSDKHandler;
  
  public TXDeviceManagerImpl(Handler paramHandler)
  {
    this.mSDKHandler = paramHandler;
  }
  
  protected void apiLog(String paramString)
  {
    AppMethodBeat.i(245708);
    TXCLog.i("TXDeviceManagerImpl", "trtc_api TXDeviceManager:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(245708);
  }
  
  protected void apiOnlineLog(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(245709);
    Monitor.a(1, String.format(paramString, paramVarArgs), "", 0, "trtc_api TXDeviceManager:");
    AppMethodBeat.o(245709);
  }
  
  public int enableCameraAutoFocus(final boolean paramBoolean)
  {
    AppMethodBeat.i(245713);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(245510);
        TXDeviceManagerImpl.this.apiLog("enableCameraAutoFocus " + paramBoolean);
        g localg = TXDeviceManagerImpl.this.mCaptureAndEnc.c();
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          localg.L = bool;
          TXDeviceManagerImpl.this.mCaptureAndEnc.a(localg);
          if (TXDeviceManagerImpl.this.mDeviceManagerListener != null) {
            TXDeviceManagerImpl.this.mDeviceManagerListener.onSwitchAutoFocus(paramBoolean);
          }
          AppMethodBeat.o(245510);
          return;
        }
      }
    });
    AppMethodBeat.o(245713);
    return 0;
  }
  
  public boolean enableCameraTorch(boolean paramBoolean)
  {
    AppMethodBeat.i(245715);
    apiLog("enableCameraTorch ".concat(String.valueOf(paramBoolean)));
    paramBoolean = this.mCaptureAndEnc.f(paramBoolean);
    AppMethodBeat.o(245715);
    return paramBoolean;
  }
  
  public float getCameraZoomMaxRatio()
  {
    AppMethodBeat.i(245711);
    float f = this.mCaptureAndEnc.r();
    AppMethodBeat.o(245711);
    return f;
  }
  
  public boolean isAutoFocusEnabled()
  {
    AppMethodBeat.i(245714);
    if (!this.mCaptureAndEnc.c().L)
    {
      AppMethodBeat.o(245714);
      return true;
    }
    AppMethodBeat.o(245714);
    return false;
  }
  
  public boolean isFrontCamera()
  {
    return this.mIsFrontCamera;
  }
  
  protected void runOnSDKThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(245707);
    if (this.mSDKHandler != null)
    {
      if (Looper.myLooper() != this.mSDKHandler.getLooper())
      {
        this.mSDKHandler.post(paramRunnable);
        AppMethodBeat.o(245707);
        return;
      }
      paramRunnable.run();
    }
    AppMethodBeat.o(245707);
  }
  
  public int setAudioRoute(final TXDeviceManager.TXAudioRoute paramTXAudioRoute)
  {
    AppMethodBeat.i(245718);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(245631);
        TXDeviceManagerImpl localTXDeviceManagerImpl = TXDeviceManagerImpl.this;
        StringBuilder localStringBuilder = new StringBuilder("setAudioRoute route:");
        String str;
        if (paramTXAudioRoute == TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece)
        {
          str = "earpiece";
          localTXDeviceManagerImpl.apiOnlineLog(str, new Object[0]);
          switch (TXDeviceManagerImpl.7.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXAudioRoute[paramTXAudioRoute.ordinal()])
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(245631);
          return;
          str = "speakerphone";
          break;
          TXCAudioEngine.setAudioRoute(0);
          AppMethodBeat.o(245631);
          return;
          TXCAudioEngine.setAudioRoute(1);
        }
      }
    });
    AppMethodBeat.o(245718);
    return 0;
  }
  
  public int setCameraFocusPosition(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(245717);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(245600);
        TXDeviceManagerImpl.this.apiLog("setCameraFocusPosition x:" + paramInt1 + "y:" + paramInt2);
        TXDeviceManagerImpl.this.mCaptureAndEnc.b(paramInt1, paramInt2);
        AppMethodBeat.o(245600);
      }
    });
    AppMethodBeat.o(245717);
    return 0;
  }
  
  public int setCameraZoomRatio(final float paramFloat)
  {
    AppMethodBeat.i(245712);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(245476);
        TXDeviceManagerImpl.this.apiLog("setCameraZoomRatio " + paramFloat);
        TXDeviceManagerImpl.this.mCaptureAndEnc.i((int)paramFloat);
        AppMethodBeat.o(245476);
      }
    });
    AppMethodBeat.o(245712);
    return 0;
  }
  
  public void setCaptureAndEnc(d paramd)
  {
    this.mCaptureAndEnc = paramd;
  }
  
  public void setDeviceManagerListener(TXDeviceManagerListener paramTXDeviceManagerListener)
  {
    this.mDeviceManagerListener = paramTXDeviceManagerListener;
  }
  
  public void setFrontCamera(boolean paramBoolean)
  {
    this.mIsFrontCamera = paramBoolean;
  }
  
  public int setSystemVolumeType(final TXDeviceManager.TXSystemVolumeType paramTXSystemVolumeType)
  {
    AppMethodBeat.i(245719);
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(245651);
        TXDeviceManagerImpl.this.apiOnlineLog("setSystemVolumeType type:%s,  auto(0),media(1),VOIP(2)", new Object[] { paramTXSystemVolumeType.name() });
        switch (TXDeviceManagerImpl.7.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType[paramTXSystemVolumeType.ordinal()])
        {
        }
        for (;;)
        {
          if (TXDeviceManagerImpl.this.mDeviceManagerListener != null) {
            TXDeviceManagerImpl.this.mDeviceManagerListener.onSwitchSystemVolumeType(paramTXSystemVolumeType);
          }
          AppMethodBeat.o(245651);
          return;
          TXCAudioEngine.setSystemVolumeType(0);
          continue;
          TXCAudioEngine.setSystemVolumeType(2);
          continue;
          TXCAudioEngine.setSystemVolumeType(1);
        }
      }
    });
    AppMethodBeat.o(245719);
    return 0;
  }
  
  public int switchCamera(final boolean paramBoolean)
  {
    AppMethodBeat.i(245710);
    final boolean bool = this.mIsFrontCamera;
    this.mIsFrontCamera = paramBoolean;
    runOnSDKThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(245576);
        if (bool != paramBoolean)
        {
          TXDeviceManagerImpl.this.mCaptureAndEnc.l();
          if (TXDeviceManagerImpl.this.mDeviceManagerListener != null) {
            TXDeviceManagerImpl.this.mDeviceManagerListener.onSwitchCamera(paramBoolean);
          }
        }
        AppMethodBeat.o(245576);
      }
    });
    AppMethodBeat.o(245710);
    return 0;
  }
  
  public static abstract interface TXDeviceManagerListener
  {
    public abstract void onSwitchAutoFocus(boolean paramBoolean);
    
    public abstract void onSwitchCamera(boolean paramBoolean);
    
    public abstract void onSwitchSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramTXSystemVolumeType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManagerImpl
 * JD-Core Version:    0.7.0.1
 */