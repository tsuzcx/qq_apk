package com.tencent.mm.audio.d.a;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  AudioRecord cjC;
  byte[] cjM;
  private int cjl;
  private int clr;
  int cls;
  public Runnable clt;
  public b.a clu;
  private int mAudioFormat;
  public final ExecutorService mExecutorService;
  public boolean mIsRecording;
  private int mSampleRate;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140649);
    this.cjl = 1;
    this.mSampleRate = 44100;
    this.clr = 12;
    this.mAudioFormat = 2;
    this.mExecutorService = Executors.newSingleThreadExecutor();
    this.clt = new b.1(this);
    this.mIsRecording = false;
    this.cjl = paramInt1;
    this.mSampleRate = paramInt2;
    if (paramInt3 == 2) {}
    for (this.clr = 12;; this.clr = 16)
    {
      this.mAudioFormat = 2;
      this.cls = (AudioRecord.getMinBufferSize(this.mSampleRate, this.clr, 2) * 10);
      this.cjC = new AudioRecord(this.cjl, this.mSampleRate, this.clr, this.mAudioFormat, this.cls);
      ab.i("MicroMsg.RecorderPcm", "mAudioSource:%d, mSampleRate:%d mAudioChannel:%d mAudioFormat:%d mBufferSize:%d", new Object[] { Integer.valueOf(this.cjl), Integer.valueOf(this.mSampleRate), Integer.valueOf(this.clr), Integer.valueOf(this.mAudioFormat), Integer.valueOf(this.cls) });
      AppMethodBeat.o(140649);
      return;
    }
  }
  
  public final boolean EC()
  {
    AppMethodBeat.i(140650);
    if (checkValid())
    {
      AppMethodBeat.o(140650);
      return false;
    }
    this.mIsRecording = true;
    try
    {
      this.cjC.startRecording();
      this.mExecutorService.submit(this.clt);
      AppMethodBeat.o(140650);
      return true;
    }
    catch (Exception localException)
    {
      ab.b("MicroMsg.RecorderPcm", "", new Object[] { localException });
      AppMethodBeat.o(140650);
    }
    return false;
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(140651);
    if (checkValid())
    {
      AppMethodBeat.o(140651);
      return false;
    }
    this.mIsRecording = false;
    try
    {
      this.cjC.stop();
      release();
      AppMethodBeat.o(140651);
      return true;
    }
    catch (Exception localException)
    {
      ab.b("MicroMsg.RecorderPcm", "", new Object[] { localException });
      AppMethodBeat.o(140651);
    }
    return false;
  }
  
  public final boolean checkValid()
  {
    AppMethodBeat.i(140652);
    if (this.cjC == null)
    {
      ab.e("MicroMsg.RecorderPcm", "mAudioRecord is null, return");
      AppMethodBeat.o(140652);
      return true;
    }
    AppMethodBeat.o(140652);
    return false;
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(140653);
      if (this.cjC != null)
      {
        this.cjC.setRecordPositionUpdateListener(null);
        this.cjC.release();
        this.cjC = null;
      }
      AppMethodBeat.o(140653);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.b
 * JD-Core Version:    0.7.0.1
 */