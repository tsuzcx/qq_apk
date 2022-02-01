package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class i
  implements c
{
  c.a KWU;
  private MMHandler KXa;
  private MediaRecorder KXn;
  private boolean KXo;
  private int audioBitrate;
  private int audioChannelCount;
  private int audioSampleRate;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89496);
    this.KXo = false;
    this.KXa = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89495);
        if (i.this.KWU != null)
        {
          i.this.KWU.buO();
          i.this.KWU = null;
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
    Log.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s, audioChannelCount: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89496);
  }
  
  public final int L(int paramInt, String paramString)
  {
    AppMethodBeat.i(89497);
    Log.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.KXn = new e();
    this.KXn.setAudioSource(1);
    this.KXn.setOutputFormat(2);
    this.KXn.setAudioEncoder(3);
    this.KXn.setAudioChannels(this.audioChannelCount);
    this.KXn.setAudioEncodingBitRate(this.audioBitrate);
    this.KXn.setAudioSamplingRate(this.audioSampleRate);
    this.KXn.setOutputFile(paramString);
    try
    {
      this.KXn.prepare();
      AppMethodBeat.o(89497);
      return 0;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramString, "mediaRecorder prepare error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89497);
    }
    return -1;
  }
  
  public final int a(c.a parama)
  {
    AppMethodBeat.i(89498);
    Log.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.KWU = parama;
    try
    {
      if ((this.KXn != null) && (!this.KXo)) {
        this.KXn.start();
      }
      return 0;
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", parama, "start record aac.mp4 error:%s", new Object[] { parama.getMessage() });
      return -1;
    }
    finally
    {
      this.KXa.sendEmptyMessage(0);
      AppMethodBeat.o(89498);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89499);
    Log.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.KXn, paramb });
    if (this.KXn == null)
    {
      if (paramb != null) {
        paramb.buN();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    try
    {
      if (!this.KXo)
      {
        this.KXn.stop();
        this.KXn.release();
      }
      this.KXn = null;
      if (paramb != null) {
        paramb.buN();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramb, "stop record aac.mp4 error:%s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(89499);
    }
    return -1;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89500);
    try
    {
      if (this.KXn != null)
      {
        if (!this.KXo)
        {
          this.KXn.stop();
          this.KXn.release();
        }
        this.KXn = null;
      }
      AppMethodBeat.o(89500);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89500);
    }
  }
  
  public final void gcw() {}
  
  public final com.tencent.mm.audio.b.c.a gcx()
  {
    return null;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89501);
    if (d.rb(24)) {
      this.KXn.pause();
    }
    AppMethodBeat.o(89501);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89502);
    if (d.rb(24)) {
      this.KXn.resume();
    }
    AppMethodBeat.o(89502);
  }
  
  public final void uu(int paramInt) {}
  
  public final void yt(boolean paramBoolean)
  {
    this.KXo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */