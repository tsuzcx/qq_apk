package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  static int iEt = 3;
  private long iEA = 0L;
  boolean iEB = false;
  int iEC = 20;
  c.a iED = new c.1(this);
  d iEp;
  volatile com.tencent.mm.f.b.c iEq;
  private b iEr = new b();
  private e iEs;
  int iEu = 1;
  int iEv = 92;
  private int iEw = 1;
  private final Object iEx = new Object();
  int iEy = 0;
  private int iEz = 1;
  int mChannels = 1;
  int mSampleRate = v2protocal.VOICE_SAMPLERATE;
  
  public c(e parame)
  {
    this.iEs = parame;
    this.iEp = new d();
  }
  
  public final boolean uq()
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
    if (this.iEu != 2) {
      y.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.iEx)
    {
      if (!this.iEq.uq())
      {
        if (this.iEq.bCt != 13) {
          this.iEy = 1;
        }
        return false;
      }
      y.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.iEy);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c
 * JD-Core Version:    0.7.0.1
 */