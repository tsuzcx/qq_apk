package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class g
  extends c
{
  public boolean isRecording()
  {
    return TXCTraeJNI.nativeTraeIsRecording();
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte) {}
  
  public void setChangerType(int paramInt1, int paramInt2)
  {
    super.setChangerType(paramInt1, paramInt2);
    TXCTraeJNI.nativeTraeSetChangerType(paramInt1, paramInt2);
  }
  
  public void setMute(boolean paramBoolean)
  {
    super.setMute(paramBoolean);
    TXCTraeJNI.nativeTraeSetRecordMute(paramBoolean);
    this.mIsMute = paramBoolean;
  }
  
  public void setReverbType(int paramInt)
  {
    super.setReverbType(paramInt);
    TXCTraeJNI.nativeTraeSetRecordReverb(paramInt);
  }
  
  public void setVolume(float paramFloat)
  {
    super.setVolume(paramFloat);
    TXCTraeJNI.nativeTraeSetVolume(paramFloat);
  }
  
  public int startRecord(Context paramContext)
  {
    TXCLog.i("AudioCenter:TXCAudioSysRecordController", "trae startRecord");
    super.startRecord(paramContext);
    TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
    TXCTraeJNI.setTraeRecordListener(this.mWeakRecordListener);
    TXCTraeJNI.nativeTraeStartRecord(paramContext, this.mSampleRate, this.mChannels, this.mBits);
    TXCTraeJNI.nativeTraeSetChangerType(this.mVoiceKind, this.mVoiceEnvironment);
    if ((this.mWeakRecordListener != null) && (this.mWeakRecordListener.get() != null))
    {
      paramContext = "TRAE-AEC,采样率(" + this.mSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels;
      ((e)this.mWeakRecordListener.get()).a(TXEAudioDef.TXE_AUDIO_NOTIFY_AUDIO_INFO, paramContext);
    }
    return 0;
  }
  
  public int stopRecord()
  {
    TXCLog.i("AudioCenter:TXCAudioSysRecordController", "trae stopRecord");
    TXCTraeJNI.nativeTraeStopRecord(true);
    TXCTraeJNI.setTraeRecordListener(null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.g
 * JD-Core Version:    0.7.0.1
 */