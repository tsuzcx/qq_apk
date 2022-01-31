package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class g
  extends c
{
  public void SetID(String paramString)
  {
    AppMethodBeat.i(146236);
    super.SetID(paramString);
    AppMethodBeat.o(146236);
  }
  
  public int getVolumeLevel()
  {
    AppMethodBeat.i(146242);
    if (this.mEnableVolumeLevel)
    {
      int i = TXCTraeJNI.nativeTraeGetVolumeLevel();
      AppMethodBeat.o(146242);
      return i;
    }
    AppMethodBeat.o(146242);
    return 0;
  }
  
  public boolean isRecording()
  {
    AppMethodBeat.i(66639);
    boolean bool = TXCTraeJNI.nativeTraeIsRecording();
    AppMethodBeat.o(66639);
    return bool;
  }
  
  public void sendCustomPCMData(a parama) {}
  
  public void sendCustomPCMData(byte[] paramArrayOfByte) {}
  
  public void setChangerType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66641);
    super.setChangerType(paramInt1, paramInt2);
    TXCTraeJNI.nativeTraeSetChangerType(paramInt1, paramInt2);
    AppMethodBeat.o(66641);
  }
  
  public void setEnableVolumeLevel(boolean paramBoolean)
  {
    AppMethodBeat.i(146241);
    super.setEnableVolumeLevel(paramBoolean);
    TXCTraeJNI.nativeTraeSetEnableVolumeLevel(paramBoolean);
    AppMethodBeat.o(146241);
  }
  
  public void setEncBitRate(int paramInt)
  {
    AppMethodBeat.i(146237);
    super.setEncBitRate(paramInt);
    TXCTraeJNI.nativeSetEncBitRate(paramInt);
    AppMethodBeat.o(146237);
  }
  
  public void setEncFrameLenMs(int paramInt)
  {
    AppMethodBeat.i(146238);
    super.setEncFrameLenMs(paramInt);
    TXCTraeJNI.nativeSetEncFrameLenMs(paramInt);
    AppMethodBeat.o(146238);
  }
  
  public void setEncInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146239);
    super.setEncInfo(paramInt1, paramInt2);
    TXCTraeJNI.nativeSetEncInfo(paramInt1, paramInt2);
    AppMethodBeat.o(146239);
  }
  
  public void setFecRatio(float paramFloat)
  {
    AppMethodBeat.i(146240);
    super.setFecRatio(paramFloat);
    TXCTraeJNI.nativeSetFecRatio(this.mFecRatio);
    AppMethodBeat.o(146240);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(66643);
    super.setMute(paramBoolean);
    TXCTraeJNI.nativeTraeSetRecordMute(paramBoolean);
    this.mIsMute = paramBoolean;
    AppMethodBeat.o(66643);
  }
  
  public void setReverbType(int paramInt)
  {
    AppMethodBeat.i(66640);
    super.setReverbType(paramInt);
    TXCTraeJNI.nativeTraeSetRecordReverb(paramInt);
    AppMethodBeat.o(66640);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(66642);
    super.setVolume(paramFloat);
    TXCTraeJNI.nativeTraeSetVolume(paramFloat);
    AppMethodBeat.o(66642);
  }
  
  public int startRecord(Context paramContext)
  {
    AppMethodBeat.i(66637);
    TXCLog.i("AudioCenter:TXCAudioTraeRecordController", "trae startRecord");
    super.startRecord(paramContext);
    TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
    TXCTraeJNI.setTraeRecordListener(this.mWeakRecordListener);
    TXCTraeJNI.nativeTraeStartRecord(paramContext, this.mSampleRate, this.mChannels, this.mBits, this.mAudioFormat, this.mFrameLenMs);
    TXCTraeJNI.nativeTraeSetChangerType(this.mVoiceKind, this.mVoiceEnvironment);
    if ((this.mWeakRecordListener != null) && (this.mWeakRecordListener.get() != null))
    {
      paramContext = "TRAE-AEC,采样率(" + this.mSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels;
      ((d)this.mWeakRecordListener.get()).a(1, paramContext);
    }
    if (this.mAudioFormat == 11) {
      TXCTraeJNI.nativeSetFecRatio(this.mFecRatio);
    }
    AppMethodBeat.o(66637);
    return 0;
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(66638);
    TXCLog.i("AudioCenter:TXCAudioTraeRecordController", "trae stopRecord");
    TXCTraeJNI.nativeTraeStopRecord(true);
    TXCTraeJNI.setTraeRecordListener(null);
    this.mFecRatio = 0.0F;
    AppMethodBeat.o(66638);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.g
 * JD-Core Version:    0.7.0.1
 */