package com.tencent.mm.libwxaudio;

import android.content.res.AssetManager;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
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
  
  @Keep
  public WxAudioNative(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(199871);
    this.mNativeInst = 0L;
    this.initCallBackFlag = false;
    new StringBuilder("WxAudioNative isolate_ptr:").append(paramLong1).append(",context_ptr:").append(paramLong2).append(",uvloop_ptr:").append(paramLong3);
    this.mNativeInst = initBindingWxAudio(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(199871);
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
  
  @Keep
  public int InitCallBack(final NativeCallBackInterface paramNativeCallBackInterface)
  {
    AppMethodBeat.i(199877);
    if (this.mNativeInst == -1L)
    {
      i = NEW_WXAUDIO_ERROR;
      AppMethodBeat.o(199877);
      return i;
    }
    if (!this.initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, new NativeCallBackInterface()
      {
        public String getFilePath(String paramAnonymousString)
        {
          AppMethodBeat.i(199861);
          paramAnonymousString = paramNativeCallBackInterface.getFilePath(paramAnonymousString);
          AppMethodBeat.o(199861);
          return paramAnonymousString;
        }
        
        @Keep
        public void onCallBack(long paramAnonymousLong, String paramAnonymousString)
        {
          AppMethodBeat.i(199860);
          paramNativeCallBackInterface.onCallBack(paramAnonymousLong, paramAnonymousString);
          AppMethodBeat.o(199860);
        }
      });
      if (i == 0)
      {
        this.initCallBackFlag = true;
        AppMethodBeat.o(199877);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(199877);
      return i;
    }
    int i = REPEAT_WXAUDIO_ERROR;
    AppMethodBeat.o(199877);
    return i;
  }
  
  @Keep
  public void destroyWebAudioContext()
  {
    AppMethodBeat.i(199874);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(199874);
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destroyBindingWxAudio(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(199874);
  }
  
  @Keep
  public void forcePauseAllPlayer()
  {
    AppMethodBeat.i(199887);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(199887);
      return;
    }
    forcePauseAllPlayer(this.mNativeInst);
    AppMethodBeat.o(199887);
  }
  
  @Keep
  public void forceResumeAllPlayer()
  {
    AppMethodBeat.i(199889);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(199889);
      return;
    }
    forceResumeAllPlayer(this.mNativeInst);
    AppMethodBeat.o(199889);
  }
  
  @Keep
  public void registerAudioPcmCallback(NativeAudioPcmCallback paramNativeAudioPcmCallback)
  {
    AppMethodBeat.i(199893);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(199893);
      return;
    }
    registerAudioPcmCallback(this.mNativeInst, paramNativeAudioPcmCallback);
    AppMethodBeat.o(199893);
  }
  
  public void testBind()
  {
    AppMethodBeat.i(199881);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(199881);
      return;
    }
    testBindingWxAudio(this.mNativeInst);
    AppMethodBeat.o(199881);
  }
  
  @Keep
  public void unregisterAudioPcmCallback()
  {
    AppMethodBeat.i(199895);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(199895);
      return;
    }
    unregisterAudioPcmCallback(this.mNativeInst);
    AppMethodBeat.o(199895);
  }
  
  @Keep
  public void update(long paramLong)
  {
    AppMethodBeat.i(199878);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(199878);
      return;
    }
    updateNativeInterface(this.mNativeInst, paramLong);
    AppMethodBeat.o(199878);
  }
  
  @Keep
  public static abstract interface NativeAudioPcmCallback
  {
    @Keep
    public abstract void onPcmCallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  @Keep
  public static abstract interface NativeCallBackInterface
  {
    @Keep
    public abstract String getFilePath(String paramString);
    
    @Keep
    public abstract void onCallBack(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.libwxaudio.WxAudioNative
 * JD-Core Version:    0.7.0.1
 */