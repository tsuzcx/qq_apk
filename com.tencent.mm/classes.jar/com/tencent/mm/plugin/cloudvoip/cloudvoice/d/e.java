package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
{
  static int pcL = 3;
  int mChannels;
  boolean mIsPlayMute;
  int mSampleRate;
  f pcH;
  public volatile com.tencent.mm.audio.b.c pcI;
  private d pcJ;
  private j pcK;
  int pcM;
  int pcN;
  private int pcO;
  private final Object pcP;
  int pcQ;
  private int pcR;
  private int pcS;
  private long pcT;
  public boolean pcU;
  int pcV;
  c.a pcW;
  
  public e(j paramj)
  {
    AppMethodBeat.i(90791);
    this.pcM = 1;
    this.pcN = 92;
    this.pcO = 1;
    this.pcP = new Object();
    this.pcQ = 0;
    this.pcR = 0;
    this.pcS = 1;
    this.pcT = 0L;
    this.mIsPlayMute = false;
    this.pcU = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.pcV = 20;
    this.pcW = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
              ae.v("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if (e.c(e.this) == 2)
            {
              paramAnonymousInt = j;
              if (e.d(e.this).pcZ.pcA == null) {
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
            Object localObject2 = e.d(e.this).pcZ.pcA;
            if (localObject2 != null)
            {
              paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).eyz();
              e.a(e.this, (paramAnonymousInt + 24 + e.e(e.this) * 3) / 4);
              if (e.f(e.this) != 1) {
                break label338;
              }
              localObject2 = e.d(e.this).pcZ.pcA;
              paramAnonymousInt = i;
              if (localObject2 != null) {
                paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).eyw();
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
              ae.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
              localObject2 = p.pdY;
              p.w(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length, e.e(e.this));
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
            ae.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          e.a(e.this, l1);
          continue;
          label404:
          if (paramAnonymousInt != 0) {}
        }
      }
    };
    this.pcJ = new d();
    this.pcK = paramj;
    this.pcH = new f();
    AppMethodBeat.o(90791);
  }
  
  public final boolean PO()
  {
    AppMethodBeat.i(90792);
    ae.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
    if (this.pcM != 2) {
      ae.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.pcP)
    {
      if (!this.pcI.PO())
      {
        if (this.pcI.dhN != 13) {
          this.pcQ = 1;
        }
        AppMethodBeat.o(90792);
        return false;
      }
      p.pdY.jJ(true);
      ae.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.pcQ);
      AppMethodBeat.o(90792);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.e
 * JD-Core Version:    0.7.0.1
 */