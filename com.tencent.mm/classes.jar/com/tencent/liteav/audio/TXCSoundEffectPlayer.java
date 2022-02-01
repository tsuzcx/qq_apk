package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCSoundEffectPlayer
{
  private static final String TAG = "Audio:TXCSoundEffectPlayer";
  protected static WeakReference<b> mWeakSoundEffectListener;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(16342);
    d.f();
    nativeCacheClassForNative();
    AppMethodBeat.o(16342);
  }
  
  public static TXCSoundEffectPlayer getInstance()
  {
    AppMethodBeat.i(16331);
    TXCSoundEffectPlayer localTXCSoundEffectPlayer = a.a();
    AppMethodBeat.o(16331);
    return localTXCSoundEffectPlayer;
  }
  
  private static native void nativeCacheClassForNative();
  
  private native void nativePauseEffectWithId(int paramInt);
  
  private native boolean nativePlayEffectWithId(int paramInt1, String paramString, boolean paramBoolean, int paramInt2);
  
  private native void nativeResumeEffectWithId(int paramInt);
  
  private native int nativeSetEffectsVolume(double paramDouble);
  
  private native int nativeSetVolumeOfEffect(int paramInt, double paramDouble);
  
  private native boolean nativeSoundEffectIsPlaying();
  
  private native void nativeStopAllEffect();
  
  private native void nativeStopEffectWithId(int paramInt);
  
  public static void onEffectError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16341);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "onEffectError -> effect id = " + paramInt1 + ", errCode = " + paramInt2);
    if ((mWeakSoundEffectListener != null) && (mWeakSoundEffectListener.get() != null)) {
      ((b)mWeakSoundEffectListener.get()).onEffectPlayError(paramInt1, paramInt2);
    }
    AppMethodBeat.o(16341);
  }
  
  public static void onEffectFinish(int paramInt)
  {
    AppMethodBeat.i(16340);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "onEffectFinish -> effect id = ".concat(String.valueOf(paramInt)));
    if ((mWeakSoundEffectListener != null) && (mWeakSoundEffectListener.get() != null)) {
      ((b)mWeakSoundEffectListener.get()).onEffectPlayFinish(paramInt);
    }
    AppMethodBeat.o(16340);
  }
  
  public void initContext(Context paramContext)
  {
    AppMethodBeat.i(16332);
    this.mContext = paramContext.getApplicationContext();
    AppMethodBeat.o(16332);
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(16338);
    boolean bool = nativeSoundEffectIsPlaying();
    AppMethodBeat.o(16338);
    return bool;
  }
  
  public void pauseEffectWithId(int paramInt)
  {
    AppMethodBeat.i(182286);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "pauseEffectWithId -> effect id = ".concat(String.valueOf(paramInt)));
    nativePauseEffectWithId(paramInt);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "pauseEffectWithId -> effect id = " + paramInt + " finish");
    AppMethodBeat.o(182286);
  }
  
  public boolean playEffectWithId(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(16333);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "playEffectWithId -> effect id = " + paramInt1 + " path = " + paramString + " loop = " + paramInt2);
    paramBoolean = nativePlayEffectWithId(paramInt1, paramString, paramBoolean, paramInt2);
    TXCTraeJNI.traeStartPlay(this.mContext);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "playEffectWithId -> result = " + paramInt1 + " result = " + paramBoolean);
    AppMethodBeat.o(16333);
    return paramBoolean;
  }
  
  public void resumeEffectWithId(int paramInt)
  {
    AppMethodBeat.i(182287);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "resumeEffectWithId -> effect id = ".concat(String.valueOf(paramInt)));
    nativeResumeEffectWithId(paramInt);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "resumeEffectWithId -> effect id = " + paramInt + " finish");
    AppMethodBeat.o(182287);
  }
  
  public int setEffectsVolume(double paramDouble)
  {
    AppMethodBeat.i(16336);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "setEffectsVolume -> volume = ".concat(String.valueOf(paramDouble)));
    int i = nativeSetEffectsVolume(paramDouble);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "setEffectsVolume -> result = ".concat(String.valueOf(i)));
    AppMethodBeat.o(16336);
    return i;
  }
  
  public void setSoundEffectListener(b paramb)
  {
    AppMethodBeat.i(16339);
    if (paramb == null)
    {
      mWeakSoundEffectListener = null;
      AppMethodBeat.o(16339);
      return;
    }
    mWeakSoundEffectListener = new WeakReference(paramb);
    AppMethodBeat.o(16339);
  }
  
  public int setVolumeOfEffect(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(16337);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "setEffectsVolume -> effect id =" + paramInt + "volume = " + paramDouble);
    int i = nativeSetVolumeOfEffect(paramInt, paramDouble);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "setEffectsVolume -> effect id = " + paramInt + " result = " + i);
    AppMethodBeat.o(16337);
    return i;
  }
  
  public void stopAllEffect()
  {
    AppMethodBeat.i(16335);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "stopAllEffect -> ");
    nativeStopAllEffect();
    TXCTraeJNI.traeStopPlay();
    TXCLog.i("Audio:TXCSoundEffectPlayer", "stopAllEffect -> finish");
    AppMethodBeat.o(16335);
  }
  
  public void stopEffectWithId(int paramInt)
  {
    AppMethodBeat.i(16334);
    TXCLog.i("Audio:TXCSoundEffectPlayer", "stopEffectWithId -> effect id = ".concat(String.valueOf(paramInt)));
    nativeStopEffectWithId(paramInt);
    TXCTraeJNI.traeStopPlay();
    TXCLog.i("Audio:TXCSoundEffectPlayer", "stopEffectWithId -> effect id = " + paramInt + " finish");
    AppMethodBeat.o(16334);
  }
  
  static class a
  {
    private static final TXCSoundEffectPlayer a;
    
    static
    {
      AppMethodBeat.i(16298);
      a = new TXCSoundEffectPlayer();
      AppMethodBeat.o(16298);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCSoundEffectPlayer
 * JD-Core Version:    0.7.0.1
 */