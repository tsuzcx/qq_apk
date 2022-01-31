package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  implements c
{
  private int audioSampleRate;
  private int ejM;
  c.a miT;
  private ah miV = new i.1(this);
  private MediaRecorder mjf;
  private boolean mjg = false;
  
  public i(int paramInt1, int paramInt2)
  {
    this.audioSampleRate = paramInt1;
    this.ejM = paramInt2;
    y.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final int a(c.a parama)
  {
    y.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.miT = parama;
    try
    {
      if ((this.mjf != null) && (!this.mjg)) {
        this.mjf.start();
      }
      return 0;
    }
    catch (Exception parama)
    {
      y.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", parama, "start record aac.mp4 error:%s", new Object[] { parama.getMessage() });
      return -1;
    }
    finally
    {
      this.miV.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    y.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.mjf, paramb });
    if (this.mjf == null) {
      if (paramb != null) {
        paramb.bjk();
      }
    }
    for (;;)
    {
      return 0;
      try
      {
        if (!this.mjg)
        {
          this.mjf.stop();
          this.mjf.release();
        }
        this.mjf = null;
        if (paramb != null)
        {
          paramb.bjk();
          return 0;
        }
      }
      catch (Exception paramb)
      {
        y.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramb, "stop record aac.mp4 error:%s", new Object[] { paramb.getMessage() });
      }
    }
    return -1;
  }
  
  public final int au(int paramInt, String paramString)
  {
    y.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.mjf = new MediaRecorder();
    this.mjf.setAudioSource(1);
    this.mjf.setOutputFormat(2);
    this.mjf.setAudioEncoder(3);
    this.mjf.setAudioChannels(1);
    this.mjf.setAudioEncodingBitRate(this.ejM);
    this.mjf.setAudioSamplingRate(this.audioSampleRate);
    this.mjf.setOutputFile(paramString);
    try
    {
      this.mjf.prepare();
      return 0;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramString, "mediaRecorder prepare error: %s", new Object[] { paramString.getMessage() });
    }
    return -1;
  }
  
  public final void bjh() {}
  
  public final com.tencent.mm.f.b.c.a bji()
  {
    return null;
  }
  
  public final void clear()
  {
    try
    {
      if (this.mjf != null)
      {
        if (!this.mjg)
        {
          this.mjf.stop();
          this.mjf.release();
        }
        this.mjf = null;
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void ht(boolean paramBoolean)
  {
    this.mjg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */