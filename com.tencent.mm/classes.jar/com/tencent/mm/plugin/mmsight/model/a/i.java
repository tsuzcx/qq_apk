package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public final class i
  implements c
{
  private int audioBitrate;
  private int audioSampleRate;
  private int gOt;
  c.a uMB;
  private ao uMG;
  private MediaRecorder uMS;
  private boolean uMT;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89496);
    this.uMT = false;
    this.uMG = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89495);
        if (i.this.uMB != null)
        {
          i.this.uMB.avs();
          i.this.uMB = null;
        }
        AppMethodBeat.o(89495);
      }
    };
    this.audioSampleRate = paramInt1;
    this.audioBitrate = paramInt2;
    this.gOt = paramInt3;
    if (this.gOt <= 0) {
      this.gOt = 1;
    }
    ac.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s, audioChannelCount: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89496);
  }
  
  public final int E(int paramInt, String paramString)
  {
    AppMethodBeat.i(89497);
    ac.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.uMS = new e();
    this.uMS.setAudioSource(1);
    this.uMS.setOutputFormat(2);
    this.uMS.setAudioEncoder(3);
    this.uMS.setAudioChannels(this.gOt);
    this.uMS.setAudioEncodingBitRate(this.audioBitrate);
    this.uMS.setAudioSamplingRate(this.audioSampleRate);
    this.uMS.setOutputFile(paramString);
    try
    {
      this.uMS.prepare();
      AppMethodBeat.o(89497);
      return 0;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramString, "mediaRecorder prepare error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89497);
    }
    return -1;
  }
  
  public final int a(c.a parama)
  {
    AppMethodBeat.i(89498);
    ac.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.uMB = parama;
    try
    {
      if ((this.uMS != null) && (!this.uMT)) {
        this.uMS.start();
      }
      return 0;
    }
    catch (Exception parama)
    {
      ac.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", parama, "start record aac.mp4 error:%s", new Object[] { parama.getMessage() });
      return -1;
    }
    finally
    {
      this.uMG.sendEmptyMessage(0);
      AppMethodBeat.o(89498);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89499);
    ac.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.uMS, paramb });
    if (this.uMS == null)
    {
      if (paramb != null) {
        paramb.avr();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    try
    {
      if (!this.uMT)
      {
        this.uMS.stop();
        this.uMS.release();
      }
      this.uMS = null;
      if (paramb != null) {
        paramb.avr();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    catch (Exception paramb)
    {
      ac.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramb, "stop record aac.mp4 error:%s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(89499);
    }
    return -1;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89500);
    try
    {
      if (this.uMS != null)
      {
        if (!this.uMT)
        {
          this.uMS.stop();
          this.uMS.release();
        }
        this.uMS = null;
      }
      AppMethodBeat.o(89500);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89500);
    }
  }
  
  public final void ddM() {}
  
  public final com.tencent.mm.audio.b.c.a ddN()
  {
    return null;
  }
  
  public final void nC(int paramInt) {}
  
  public final void nY(boolean paramBoolean)
  {
    this.uMT = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89501);
    if (d.kZ(24)) {
      this.uMS.pause();
    }
    AppMethodBeat.o(89501);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89502);
    if (d.kZ(24)) {
      this.uMS.resume();
    }
    AppMethodBeat.o(89502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */