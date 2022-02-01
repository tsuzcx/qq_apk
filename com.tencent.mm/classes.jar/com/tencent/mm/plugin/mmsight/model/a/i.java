package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public final class i
  implements c
{
  private int audioBitrate;
  private int audioChannelCount;
  private int audioSampleRate;
  c.a wbK;
  private aq wbQ;
  private MediaRecorder wcd;
  private boolean wce;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89496);
    this.wce = false;
    this.wbQ = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89495);
        if (i.this.wbK != null)
        {
          i.this.wbK.ayu();
          i.this.wbK = null;
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
    ae.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s, audioChannelCount: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89496);
  }
  
  public final int E(int paramInt, String paramString)
  {
    AppMethodBeat.i(89497);
    ae.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.wcd = new e();
    this.wcd.setAudioSource(1);
    this.wcd.setOutputFormat(2);
    this.wcd.setAudioEncoder(3);
    this.wcd.setAudioChannels(this.audioChannelCount);
    this.wcd.setAudioEncodingBitRate(this.audioBitrate);
    this.wcd.setAudioSamplingRate(this.audioSampleRate);
    this.wcd.setOutputFile(paramString);
    try
    {
      this.wcd.prepare();
      AppMethodBeat.o(89497);
      return 0;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramString, "mediaRecorder prepare error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89497);
    }
    return -1;
  }
  
  public final int a(c.a parama)
  {
    AppMethodBeat.i(89498);
    ae.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.wbK = parama;
    try
    {
      if ((this.wcd != null) && (!this.wce)) {
        this.wcd.start();
      }
      return 0;
    }
    catch (Exception parama)
    {
      ae.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", parama, "start record aac.mp4 error:%s", new Object[] { parama.getMessage() });
      return -1;
    }
    finally
    {
      this.wbQ.sendEmptyMessage(0);
      AppMethodBeat.o(89498);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89499);
    ae.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.wcd, paramb });
    if (this.wcd == null)
    {
      if (paramb != null) {
        paramb.ayt();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    try
    {
      if (!this.wce)
      {
        this.wcd.stop();
        this.wcd.release();
      }
      this.wcd = null;
      if (paramb != null) {
        paramb.ayt();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    catch (Exception paramb)
    {
      ae.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramb, "stop record aac.mp4 error:%s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(89499);
    }
    return -1;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89500);
    try
    {
      if (this.wcd != null)
      {
        if (!this.wce)
        {
          this.wcd.stop();
          this.wcd.release();
        }
        this.wcd = null;
      }
      AppMethodBeat.o(89500);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89500);
    }
  }
  
  public final void dqg() {}
  
  public final com.tencent.mm.audio.b.c.a dqh()
  {
    return null;
  }
  
  public final void oe(int paramInt) {}
  
  public final void ox(boolean paramBoolean)
  {
    this.wce = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89501);
    if (d.lA(24)) {
      this.wcd.pause();
    }
    AppMethodBeat.o(89501);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89502);
    if (d.lA(24)) {
      this.wcd.resume();
    }
    AppMethodBeat.o(89502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */