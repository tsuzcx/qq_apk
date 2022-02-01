package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class i
  implements c
{
  private int audioBitrate;
  private int audioChannelCount;
  private int audioSampleRate;
  c.a vPH;
  private ap vPN;
  private MediaRecorder vPZ;
  private boolean vQa;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89496);
    this.vQa = false;
    this.vPN = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89495);
        if (i.this.vPH != null)
        {
          i.this.vPH.ayf();
          i.this.vPH = null;
        }
        AppMethodBeat.o(89495);
      }
    };
    this.audioSampleRate = paramInt1;
    this.audioBitrate = paramInt2;
    this.audioChannelCount = paramInt3;
    if (this.audioChannelCount <= 0) {
      this.audioChannelCount = 1;
    }
    ad.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s, audioChannelCount: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89496);
  }
  
  public final int E(int paramInt, String paramString)
  {
    AppMethodBeat.i(89497);
    ad.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.vPZ = new e();
    this.vPZ.setAudioSource(1);
    this.vPZ.setOutputFormat(2);
    this.vPZ.setAudioEncoder(3);
    this.vPZ.setAudioChannels(this.audioChannelCount);
    this.vPZ.setAudioEncodingBitRate(this.audioBitrate);
    this.vPZ.setAudioSamplingRate(this.audioSampleRate);
    this.vPZ.setOutputFile(paramString);
    try
    {
      this.vPZ.prepare();
      AppMethodBeat.o(89497);
      return 0;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramString, "mediaRecorder prepare error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89497);
    }
    return -1;
  }
  
  public final int a(c.a parama)
  {
    AppMethodBeat.i(89498);
    ad.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.vPH = parama;
    try
    {
      if ((this.vPZ != null) && (!this.vQa)) {
        this.vPZ.start();
      }
      return 0;
    }
    catch (Exception parama)
    {
      ad.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", parama, "start record aac.mp4 error:%s", new Object[] { parama.getMessage() });
      return -1;
    }
    finally
    {
      this.vPN.sendEmptyMessage(0);
      AppMethodBeat.o(89498);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89499);
    ad.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.vPZ, paramb });
    if (this.vPZ == null)
    {
      if (paramb != null) {
        paramb.aye();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    try
    {
      if (!this.vQa)
      {
        this.vPZ.stop();
        this.vPZ.release();
      }
      this.vPZ = null;
      if (paramb != null) {
        paramb.aye();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    catch (Exception paramb)
    {
      ad.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramb, "stop record aac.mp4 error:%s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(89499);
    }
    return -1;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89500);
    try
    {
      if (this.vPZ != null)
      {
        if (!this.vQa)
        {
          this.vPZ.stop();
          this.vPZ.release();
        }
        this.vPZ = null;
      }
      AppMethodBeat.o(89500);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89500);
    }
  }
  
  public final void dni() {}
  
  public final com.tencent.mm.audio.b.c.a dnj()
  {
    return null;
  }
  
  public final void ob(int paramInt) {}
  
  public final void os(boolean paramBoolean)
  {
    this.vQa = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89501);
    if (d.ly(24)) {
      this.vPZ.pause();
    }
    AppMethodBeat.o(89501);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89502);
    if (d.ly(24)) {
      this.vPZ.resume();
    }
    AppMethodBeat.o(89502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */