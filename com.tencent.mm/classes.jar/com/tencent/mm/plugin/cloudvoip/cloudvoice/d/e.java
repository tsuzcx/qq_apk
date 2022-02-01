package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  static int nPI = 3;
  int mChannels;
  boolean mIsPlayMute;
  int mSampleRate;
  f nPE;
  volatile com.tencent.mm.audio.b.c nPF;
  private d nPG;
  private j nPH;
  int nPJ;
  int nPK;
  private int nPL;
  private final Object nPM;
  int nPN;
  private int nPO;
  private int nPP;
  private long nPQ;
  int nPR;
  c.a nPS;
  
  public e(j paramj)
  {
    AppMethodBeat.i(90791);
    this.nPJ = 1;
    this.nPK = 92;
    this.nPL = 1;
    this.nPM = new Object();
    this.nPN = 0;
    this.nPO = 0;
    this.nPP = 1;
    this.nPQ = 0L;
    this.mIsPlayMute = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.nPR = 20;
    this.nPS = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int i = -1;
        int j = 0;
        AppMethodBeat.i(90789);
        for (;;)
        {
          synchronized (e.k(e.this))
          {
            if (e.a(e.this) % 50 == 0)
            {
              e.b(e.this);
              ad.v("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if (e.c(e.this) == 2)
            {
              paramAnonymousInt = j;
              if (e.d(e.this).nPV.nPx == null) {
                break label404;
              }
              paramAnonymousInt = 1;
              break label404;
            }
            AppMethodBeat.o(90789);
            return;
            if (e.e(e.this) <= 10) {
              e.a(e.this, 92);
            }
            Object localObject2 = e.d(e.this).nPV.nPx;
            if (localObject2 != null)
            {
              paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).dRV();
              e.a(e.this, (paramAnonymousInt + 24 + e.e(e.this) * 3) / 4);
              if (e.f(e.this) != 1) {
                break label338;
              }
              localObject2 = e.d(e.this).nPV.nPx;
              paramAnonymousInt = i;
              if (localObject2 != null) {
                paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).dRS();
              }
              i = paramAnonymousInt;
              if (paramAnonymousInt >= e.e(e.this)) {
                i = paramAnonymousInt - e.e(e.this);
              }
              e.a(e.this, i);
              e.g(e.this);
              if (1 != e.h(e.this)) {
                break label350;
              }
              e.i(e.this);
              e.a(e.this, System.currentTimeMillis());
              ad.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
              localObject2 = o.nQO;
              o.x(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length, e.e(e.this));
            }
          }
          paramAnonymousInt = -1;
          continue;
          label338:
          e.a(e.this, 0);
          continue;
          label350:
          long l1 = System.currentTimeMillis();
          long l2 = l1 - e.j(e.this);
          if (l2 > 1000L) {
            ad.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          e.a(e.this, l1);
          continue;
          label404:
          if (paramAnonymousInt != 0) {}
        }
      }
    };
    this.nPG = new d();
    this.nPH = paramj;
    this.nPE = new f();
    AppMethodBeat.o(90791);
  }
  
  public final boolean Ok()
  {
    AppMethodBeat.i(90792);
    ad.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
    if (this.nPJ != 2) {
      ad.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.nPM)
    {
      if (!this.nPF.Ok())
      {
        if (this.nPF.cXZ != 13) {
          this.nPN = 1;
        }
        AppMethodBeat.o(90792);
        return false;
      }
      ad.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.nPN);
      AppMethodBeat.o(90792);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.e
 * JD-Core Version:    0.7.0.1
 */