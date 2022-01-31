package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class i
  implements c
{
  private int audioSampleRate;
  private int eRF;
  private int fzT;
  c.a oIY;
  private ak oJc;
  private MediaRecorder oJm;
  private boolean oJn;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140131);
    this.oJn = false;
    this.oJc = new i.1(this);
    this.audioSampleRate = paramInt1;
    this.fzT = paramInt2;
    this.eRF = paramInt3;
    if (this.eRF <= 0) {
      this.eRF = 1;
    }
    ab.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s, audioChannelCount: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(140131);
  }
  
  public final int a(c.a parama)
  {
    AppMethodBeat.i(76588);
    ab.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.oIY = parama;
    try
    {
      if ((this.oJm != null) && (!this.oJn)) {
        this.oJm.start();
      }
      return 0;
    }
    catch (Exception parama)
    {
      ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", parama, "start record aac.mp4 error:%s", new Object[] { parama.getMessage() });
      return -1;
    }
    finally
    {
      this.oJc.sendEmptyMessage(0);
      AppMethodBeat.o(76588);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(76589);
    ab.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[] { this.oJm, paramb });
    if (this.oJm == null)
    {
      if (paramb != null) {
        paramb.XE();
      }
      AppMethodBeat.o(76589);
      return 0;
    }
    try
    {
      if (!this.oJn)
      {
        this.oJm.stop();
        this.oJm.release();
      }
      this.oJm = null;
      if (paramb != null) {
        paramb.XE();
      }
      AppMethodBeat.o(76589);
      return 0;
    }
    catch (Exception paramb)
    {
      ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramb, "stop record aac.mp4 error:%s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(76589);
    }
    return -1;
  }
  
  public final void bRk() {}
  
  public final com.tencent.mm.audio.b.c.a bRl()
  {
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(76590);
    try
    {
      if (this.oJm != null)
      {
        if (!this.oJn)
        {
          this.oJm.stop();
          this.oJm.release();
        }
        this.oJm = null;
      }
      AppMethodBeat.o(76590);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(76590);
    }
  }
  
  public final void jn(boolean paramBoolean)
  {
    this.oJn = paramBoolean;
  }
  
  public final int t(int paramInt, String paramString)
  {
    AppMethodBeat.i(76587);
    ab.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[] { paramString, Integer.valueOf(this.audioSampleRate) });
    this.oJm = new MediaRecorder();
    this.oJm.setAudioSource(1);
    this.oJm.setOutputFormat(2);
    this.oJm.setAudioEncoder(3);
    this.oJm.setAudioChannels(this.eRF);
    this.oJm.setAudioEncodingBitRate(this.fzT);
    this.oJm.setAudioSamplingRate(this.audioSampleRate);
    this.oJm.setOutputFile(paramString);
    try
    {
      this.oJm.prepare();
      AppMethodBeat.o(76587);
      return 0;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", paramString, "mediaRecorder prepare error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(76587);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i
 * JD-Core Version:    0.7.0.1
 */