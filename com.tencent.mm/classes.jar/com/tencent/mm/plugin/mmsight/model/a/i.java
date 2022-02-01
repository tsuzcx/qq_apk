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
  private MediaRecorder FbE;
  private boolean FbF;
  c.a Fbl;
  private MMHandler Fbr;
  private int audioBitrate;
  private int audioChannelCount;
  private int audioSampleRate;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89496);
    this.FbF = false;
    this.Fbr = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89495);
        if (i.this.Fbl != null)
        {
          i.this.Fbl.aZS();
          i.this.Fbl = null;
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
  
  public final int J(int paramInt, String paramString)
  {
    AppMethodBeat.i(89497);
    Log.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.FbE = new e();
    this.FbE.setAudioSource(1);
    this.FbE.setOutputFormat(2);
    this.FbE.setAudioEncoder(3);
    this.FbE.setAudioChannels(this.audioChannelCount);
    this.FbE.setAudioEncodingBitRate(this.audioBitrate);
    this.FbE.setAudioSamplingRate(this.audioSampleRate);
    this.FbE.setOutputFile(paramString);
    try
    {
      this.FbE.prepare();
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
    this.Fbl = parama;
    try
    {
      if ((this.FbE != null) && (!this.FbF)) {
        this.FbE.start();
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
      this.Fbr.sendEmptyMessage(0);
      AppMethodBeat.o(89498);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89499);
    Log.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.FbE, paramb });
    if (this.FbE == null)
    {
      if (paramb != null) {
        paramb.aZQ();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    try
    {
      if (!this.FbF)
      {
        this.FbE.stop();
        this.FbE.release();
      }
      this.FbE = null;
      if (paramb != null) {
        paramb.aZQ();
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
      if (this.FbE != null)
      {
        if (!this.FbF)
        {
          this.FbE.stop();
          this.FbE.release();
        }
        this.FbE = null;
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
  
  public final void eTD() {}
  
  public final com.tencent.mm.audio.b.c.a eTE()
  {
    return null;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89501);
    if (d.qV(24)) {
      this.FbE.pause();
    }
    AppMethodBeat.o(89501);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89502);
    if (d.qV(24)) {
      this.FbE.resume();
    }
    AppMethodBeat.o(89502);
  }
  
  public final void uf(boolean paramBoolean)
  {
    this.FbF = paramBoolean;
  }
  
  public final void uu(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */