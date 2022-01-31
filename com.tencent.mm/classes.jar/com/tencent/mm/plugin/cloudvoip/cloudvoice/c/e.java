package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
{
  static int kJE = 3;
  f kJA;
  volatile c kJB;
  private d kJC;
  private j kJD;
  int kJF;
  int kJG;
  private int kJH;
  private final Object kJI;
  int kJJ;
  private int kJK;
  private int kJL;
  private long kJM;
  boolean kJN;
  int kJO;
  c.a kJP;
  int mChannels;
  int mSampleRate;
  
  public e(j paramj)
  {
    AppMethodBeat.i(135470);
    this.kJF = 1;
    this.kJG = 92;
    this.kJH = 1;
    this.kJI = new Object();
    this.kJJ = 0;
    this.kJK = 0;
    this.kJL = 1;
    this.kJM = 0L;
    this.kJN = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.kJO = 20;
    this.kJP = new e.1(this);
    this.kJC = new d();
    this.kJD = paramj;
    this.kJA = new f();
    AppMethodBeat.o(135470);
  }
  
  public final boolean EC()
  {
    AppMethodBeat.i(135471);
    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
    if (this.kJF != 2) {
      ab.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.kJI)
    {
      if (!this.kJB.EC())
      {
        if (this.kJB.cjh != 13) {
          this.kJJ = 1;
        }
        AppMethodBeat.o(135471);
        return false;
      }
      ab.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.kJJ);
      AppMethodBeat.o(135471);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e
 * JD-Core Version:    0.7.0.1
 */