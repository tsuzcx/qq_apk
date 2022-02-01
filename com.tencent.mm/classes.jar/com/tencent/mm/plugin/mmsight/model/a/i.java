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
  private int audioBitrate;
  private int audioChannelCount;
  private int audioSampleRate;
  c.a zvM;
  private MMHandler zvS;
  private MediaRecorder zwf;
  private boolean zwg;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89496);
    this.zwg = false;
    this.zvS = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89495);
        if (i.this.zvM != null)
        {
          i.this.zvM.aQY();
          i.this.zvM = null;
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
  
  public final int H(int paramInt, String paramString)
  {
    AppMethodBeat.i(89497);
    Log.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.zwf = new e();
    this.zwf.setAudioSource(1);
    this.zwf.setOutputFormat(2);
    this.zwf.setAudioEncoder(3);
    this.zwf.setAudioChannels(this.audioChannelCount);
    this.zwf.setAudioEncodingBitRate(this.audioBitrate);
    this.zwf.setAudioSamplingRate(this.audioSampleRate);
    this.zwf.setOutputFile(paramString);
    try
    {
      this.zwf.prepare();
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
    this.zvM = parama;
    try
    {
      if ((this.zwf != null) && (!this.zwg)) {
        this.zwf.start();
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
      this.zvS.sendEmptyMessage(0);
      AppMethodBeat.o(89498);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89499);
    Log.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.zwf, paramb });
    if (this.zwf == null)
    {
      if (paramb != null) {
        paramb.aQX();
      }
      AppMethodBeat.o(89499);
      return 0;
    }
    try
    {
      if (!this.zwg)
      {
        this.zwf.stop();
        this.zwf.release();
      }
      this.zwf = null;
      if (paramb != null) {
        paramb.aQX();
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
      if (this.zwf != null)
      {
        if (!this.zwg)
        {
          this.zwf.stop();
          this.zwf.release();
        }
        this.zwf = null;
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
  
  public final void ejW() {}
  
  public final com.tencent.mm.audio.b.c.a ejX()
  {
    return null;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89501);
    if (d.oD(24)) {
      this.zwf.pause();
    }
    AppMethodBeat.o(89501);
  }
  
  public final void rA(int paramInt) {}
  
  public final void rc(boolean paramBoolean)
  {
    this.zwg = paramBoolean;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89502);
    if (d.oD(24)) {
      this.zwf.resume();
    }
    AppMethodBeat.o(89502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */