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
  private int audioSampleRate;
  private int gnH;
  c.a tEg;
  private ap tEl;
  private MediaRecorder tEx;
  private boolean tEy;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89496);
    this.tEy = false;
    this.tEl = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89495);
        if (i.this.tEg != null)
        {
          i.this.tEg.aoB();
          i.this.tEg = null;
        }
        AppMethodBeat.o(89495);
      }
    };
    this.audioSampleRate = paramInt1;
    this.audioBitrate = paramInt2;
    this.gnH = paramInt3;
    if (this.gnH <= 0) {
      this.gnH = 1;
    }
    ad.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s, audioChannelCount: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89496);
  }
  
  public final int D(int paramInt, String paramString)
  {
    AppMethodBeat.i(89497);
    ad.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.tEx = new e();
    this.tEx.setAudioSource(1);
    this.tEx.setOutputFormat(2);
    this.tEx.setAudioEncoder(3);
    this.tEx.setAudioChannels(this.gnH);
    this.tEx.setAudioEncodingBitRate(this.audioBitrate);
    this.tEx.setAudioSamplingRate(this.audioSampleRate);
    this.tEx.setOutputFile(paramString);
    try
    {
      this.tEx.prepare();
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
    this.tEg = parama;
    try
    {
      if ((this.tEx != null) && (!this.tEy)) {
        this.tEx.start();
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
      this.tEl.sendEmptyMessage(0);
      AppMethodBeat.o(89498);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89499);
    ad.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.tEx, paramb });
    if (this.tEx == null)
    {
      if (paramb != null) {
        paramb.aoA();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    try
    {
      if (!this.tEy)
      {
        this.tEx.stop();
        this.tEx.release();
      }
      this.tEx = null;
      if (paramb != null) {
        paramb.aoA();
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
  
  public final void cQe() {}
  
  public final com.tencent.mm.audio.b.c.a cQf()
  {
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89500);
    try
    {
      if (this.tEx != null)
      {
        if (!this.tEy)
        {
          this.tEx.stop();
          this.tEx.release();
        }
        this.tEx = null;
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
  
  public final void mO(int paramInt) {}
  
  public final void nf(boolean paramBoolean)
  {
    this.tEy = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89501);
    if (d.lf(24)) {
      this.tEx.pause();
    }
    AppMethodBeat.o(89501);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89502);
    if (d.lf(24)) {
      this.tEx.resume();
    }
    AppMethodBeat.o(89502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */