package com.tencent.mm.libwxaudio;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxAudioNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_WXAUDIO_ERROR;
  public static int REPEAT_WXAUDIO_ERROR;
  public static String TAG = "MicroMsg.WebAudio.WxAudioNative";
  private boolean initCallBackFlag;
  volatile long mNativeInst;
  
  static
  {
    NEW_WXAUDIO_ERROR = -1000;
    REPEAT_WXAUDIO_ERROR = -1001;
  }
  
  public WxAudioNative(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(234119);
    this.mNativeInst = 0L;
    this.initCallBackFlag = false;
    new StringBuilder("WxAudioNative isolate_ptr:").append(paramLong1).append(",context_ptr:").append(paramLong2).append(",uvloop_ptr:").append(paramLong3);
    this.mNativeInst = initBindingWxAudio(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(234119);
  }
  
  private native void destroyBindingWxAudio(long paramLong);
  
  public static native void forcePauseAllPlayer(long paramLong);
  
  public static native void forceResumeAllPlayer(long paramLong);
  
  public static native void initAndroidAssetMgr(AssetManager paramAssetManager);
  
  private native long initBindingWxAudio(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, NativeCallBackInterface paramNativeCallBackInterface);
  
  public static native void registerAudioPcmCallback(long paramLong, NativeAudioPcmCallback paramNativeAudioPcmCallback);
  
  private native void testBindingWxAudio(long paramLong);
  
  public static native void unregisterAudioPcmCallback(long paramLong);
  
  private native void updateNativeInterface(long paramLong1, long paramLong2);
  
  public int InitCallBack(final NativeCallBackInterface paramNativeCallBackInterface)
  {
    AppMethodBeat.i(234134);
    if (this.mNativeInst == -1L)
    {
      i = NEW_WXAUDIO_ERROR;
      AppMethodBeat.o(234134);
      return i;
    }
    if (!this.initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, new NativeCallBackInterface()
      {
        public String getFilePath(String paramAnonymousString)
        {
          AppMethodBeat.i(234093);
          paramAnonymousString = paramNativeCallBackInterface.getFilePath(paramAnonymousString);
          AppMethodBeat.o(234093);
          return paramAnonymousString;
        }
        
        public void onCallBack(long paramAnonymousLong, String paramAnonymousString)
        {
          AppMethodBeat.i(234091);
          paramNativeCallBackInterface.onCallBack(paramAnonymousLong, paramAnonymousString);
          AppMethodBeat.o(234091);
        }
      });
      if (i == 0)
      {
        this.initCallBackFlag = true;
        AppMethodBeat.o(234134);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(234134);
      return i;
    }
    int i = REPEAT_WXAUDIO_ERROR;
    AppMethodBeat.o(234134);
    return i;
  }
  
  public void destroyWebAudioContext()
  {
    AppMethodBeat.i(234128);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(234128);
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destroyBindingWxAudio(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(234128);
  }
  
  public void forcePauseAllPlayer()
  {
    AppMethodBeat.i(234151);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(234151);
      return;
    }
    forcePauseAllPlayer(this.mNativeInst);
    AppMethodBeat.o(234151);
  }
  
  public void forceResumeAllPlayer()
  {
    AppMethodBeat.i(234159);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(234159);
      return;
    }
    forceResumeAllPlayer(this.mNativeInst);
    AppMethodBeat.o(234159);
  }
  
  public void registerAudioPcmCallback(NativeAudioPcmCallback paramNativeAudioPcmCallback)
  {
    AppMethodBeat.i(234162);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(234162);
      return;
    }
    registerAudioPcmCallback(this.mNativeInst, paramNativeAudioPcmCallback);
    AppMethodBeat.o(234162);
  }
  
  public void testBind()
  {
    AppMethodBeat.i(234146);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(234146);
      return;
    }
    testBindingWxAudio(this.mNativeInst);
    AppMethodBeat.o(234146);
  }
  
  public void unregisterAudioPcmCallback()
  {
    AppMethodBeat.i(234168);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(234168);
      return;
    }
    unregisterAudioPcmCallback(this.mNativeInst);
    AppMethodBeat.o(234168);
  }
  
  public void update(long paramLong)
  {
    AppMethodBeat.i(234139);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(234139);
      return;
    }
    updateNativeInterface(this.mNativeInst, paramLong);
    AppMethodBeat.o(234139);
  }
  
  public static abstract interface NativeAudioPcmCallback
  {
    public abstract void onPcmCallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface NativeCallBackInterface
  {
    public abstract String getFilePath(String paramString);
    
    public abstract void onCallBack(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.libwxaudio.WxAudioNative
 * JD-Core Version:    0.7.0.1
 */