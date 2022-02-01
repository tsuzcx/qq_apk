package com.tencent.maas.camerafun;

import android.os.Handler;
import com.facebook.jni.HybridData;
import com.tencent.maas.instamovie.MJAsyncTaskInfo;
import com.tencent.maas.instamovie.MJRecordingSettings;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.internal.NativeCallbackManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJCamFunSession
{
  private final NativeCallbackManager mCallbackManager;
  private final HybridData mHybridData;
  
  public MJCamFunSession(Handler paramHandler)
  {
    AppMethodBeat.i(216856);
    this.mCallbackManager = new NativeCallbackManager(paramHandler.getLooper());
    this.mHybridData = initHybrid(paramHandler, this.mCallbackManager);
    AppMethodBeat.o(216856);
  }
  
  private native HybridData initHybrid(Handler paramHandler, NativeCallbackManager paramNativeCallbackManager);
  
  private native MJError nativeCancelSwitching(int paramInt);
  
  private native MJError nativeConnectRenderView(String paramString);
  
  private native void nativeSendAudioFrame(MJAudioFrame paramMJAudioFrame);
  
  private native void nativeSendVideoFrame(MJVideoFrame paramMJVideoFrame);
  
  private native void nativeSetFirstFrameDidPresentFunc(int paramInt);
  
  private native void nativeSetRecordingDidFailFunc(int paramInt);
  
  private native void nativeSetRecordingTimeDidChangeFunc(int paramInt);
  
  private native MJError nativeStart(int paramInt);
  
  private native MJError nativeStartRecording(String paramString, MJRecordingSettings paramMJRecordingSettings, MJAuditCaptureSettings paramMJAuditCaptureSettings, int paramInt);
  
  private native MJAsyncTaskInfo nativeStartWithTemplate(String paramString, int paramInt1, int paramInt2);
  
  private native MJError nativeStopRecording(int paramInt);
  
  private native MJError nativeSwitchToEmptyTemplate(int paramInt);
  
  private native MJAsyncTaskInfo nativeSwitchToTemplate(String paramString, int paramInt1, int paramInt2);
  
  private native MJError nativeTeardown(int paramInt);
  
  public MJError cancelSwitching(b paramb)
  {
    AppMethodBeat.i(216944);
    if (paramb != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.CompleteCallback(this, paramb));; i = -1)
    {
      paramb = nativeCancelSwitching(i);
      AppMethodBeat.o(216944);
      return paramb;
    }
  }
  
  public MJError connectRenderView(String paramString)
  {
    AppMethodBeat.i(216919);
    paramString = nativeConnectRenderView(paramString);
    AppMethodBeat.o(216919);
    return paramString;
  }
  
  public MJCamFunSession.a convertEMFVideoOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return MJCamFunSession.a.eEW;
    case 0: 
      return MJCamFunSession.a.eEW;
    case 90: 
      return MJCamFunSession.a.eFd;
    case 180: 
      return MJCamFunSession.a.eFe;
    }
    return MJCamFunSession.a.eFf;
  }
  
  public void release()
  {
    AppMethodBeat.i(216916);
    this.mHybridData.resetNative();
    AppMethodBeat.o(216916);
  }
  
  public void sendAudioFrame(MJAudioFrame paramMJAudioFrame)
  {
    AppMethodBeat.i(216959);
    nativeSendAudioFrame(paramMJAudioFrame);
    AppMethodBeat.o(216959);
  }
  
  public void sendVideoFrame(MJVideoFrame paramMJVideoFrame)
  {
    AppMethodBeat.i(216954);
    nativeSendVideoFrame(paramMJVideoFrame);
    AppMethodBeat.o(216954);
  }
  
  public void setFirstFrameDidPresentFunc(b paramb)
  {
    AppMethodBeat.i(216986);
    if (paramb != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.CompleteCallback(this, paramb));; i = -1)
    {
      nativeSetFirstFrameDidPresentFunc(i);
      AppMethodBeat.o(216986);
      return;
    }
  }
  
  public void setRecordingDidFailFunc(b paramb)
  {
    AppMethodBeat.i(216982);
    if (paramb != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.CompleteCallback(this, paramb));; i = -1)
    {
      nativeSetRecordingDidFailFunc(i);
      AppMethodBeat.o(216982);
      return;
    }
  }
  
  public void setRecordingTimeDidChangeFunc(e parame)
  {
    AppMethodBeat.i(216976);
    if (parame != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.RecordingTimeChangeCallback(this, parame, false));; i = -1)
    {
      nativeSetRecordingTimeDidChangeFunc(i);
      AppMethodBeat.o(216976);
      return;
    }
  }
  
  public MJError start(c paramc)
  {
    AppMethodBeat.i(216925);
    if (paramc != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.OptionsCompleteCallback(this, paramc));; i = -1)
    {
      paramc = nativeStart(i);
      AppMethodBeat.o(216925);
      return paramc;
    }
  }
  
  public MJError startRecording(String paramString, MJRecordingSettings paramMJRecordingSettings, MJAuditCaptureSettings paramMJAuditCaptureSettings, b paramb)
  {
    AppMethodBeat.i(216965);
    if (paramb != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.CompleteCallback(this, paramb));; i = -1)
    {
      paramString = nativeStartRecording(paramString, paramMJRecordingSettings, paramMJAuditCaptureSettings, i);
      AppMethodBeat.o(216965);
      return paramString;
    }
  }
  
  public MJAsyncTaskInfo startWithTemplate(String paramString, MJCamFunSession.d paramd, c paramc)
  {
    AppMethodBeat.i(216931);
    paramd = this.mCallbackManager.registerProgressWithComplete(new MJCamFunSessionCallback.ProgressCallback(this, paramd, false), new MJCamFunSessionCallback.OptionsCompleteCallback(this, paramc));
    paramString = nativeStartWithTemplate(paramString, paramd[0], paramd[1]);
    AppMethodBeat.o(216931);
    return paramString;
  }
  
  public MJError stopRecording(f paramf)
  {
    AppMethodBeat.i(216970);
    if (paramf != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.StopRecordingCallback(this, paramf));; i = -1)
    {
      paramf = nativeStopRecording(i);
      AppMethodBeat.o(216970);
      return paramf;
    }
  }
  
  public MJError switchToEmptyTemplate(c paramc)
  {
    AppMethodBeat.i(216942);
    if (paramc != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.OptionsCompleteCallback(this, paramc));; i = -1)
    {
      paramc = nativeSwitchToEmptyTemplate(i);
      AppMethodBeat.o(216942);
      return paramc;
    }
  }
  
  public MJAsyncTaskInfo switchToTemplate(String paramString, MJCamFunSession.d paramd, c paramc)
  {
    AppMethodBeat.i(216935);
    paramd = this.mCallbackManager.registerProgressWithComplete(new MJCamFunSessionCallback.ProgressCallback(this, paramd, false), new MJCamFunSessionCallback.OptionsCompleteCallback(this, paramc));
    paramString = nativeSwitchToTemplate(paramString, paramd[0], paramd[1]);
    AppMethodBeat.o(216935);
    return paramString;
  }
  
  public MJError teardown(b paramb)
  {
    AppMethodBeat.i(216949);
    if (paramb != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJCamFunSessionCallback.CompleteCallback(this, paramb));; i = -1)
    {
      paramb = nativeTeardown(i);
      AppMethodBeat.o(216949);
      return paramb;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onComplete(MJError paramMJError);
  }
  
  public static abstract interface c
  {
    public abstract void onComplete(MJCaptureOptions paramMJCaptureOptions, MJError paramMJError);
  }
  
  public static abstract interface e {}
  
  public static abstract interface f
  {
    public abstract void onStopRecording(MJRecordingFinishInfo paramMJRecordingFinishInfo, MJError paramMJError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSession
 * JD-Core Version:    0.7.0.1
 */