package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
{
  static int osM = 3;
  int mChannels;
  boolean mIsPlayMute;
  int mSampleRate;
  f osI;
  volatile com.tencent.mm.audio.b.c osJ;
  private d osK;
  private j osL;
  int osN;
  int osO;
  private int osP;
  private final Object osQ;
  int osR;
  private int osS;
  private int osT;
  private long osU;
  boolean osV;
  int osW;
  c.a osX;
  
  public e(j paramj)
  {
    AppMethodBeat.i(90791);
    this.osN = 1;
    this.osO = 92;
    this.osP = 1;
    this.osQ = new Object();
    this.osR = 0;
    this.osS = 0;
    this.osT = 1;
    this.osU = 0L;
    this.mIsPlayMute = false;
    this.osV = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.osW = 20;
    this.osX = new c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
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
              ac.v("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if (e.c(e.this) == 2)
            {
              paramAnonymousInt = j;
              if (e.d(e.this).ota.osB == null) {
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
            Object localObject2 = e.d(e.this).ota.osB;
            if (localObject2 != null)
            {
              paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).ehh();
              e.a(e.this, (paramAnonymousInt + 24 + e.e(e.this) * 3) / 4);
              if (e.f(e.this) != 1) {
                break label338;
              }
              localObject2 = e.d(e.this).ota.osB;
              paramAnonymousInt = i;
              if (localObject2 != null) {
                paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).ehe();
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
              ac.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
              localObject2 = p.otZ;
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
            ac.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          e.a(e.this, l1);
          continue;
          label404:
          if (paramAnonymousInt != 0) {}
        }
      }
    };
    this.osK = new d();
    this.osL = paramj;
    this.osI = new f();
    AppMethodBeat.o(90791);
  }
  
  public final boolean Og()
  {
    AppMethodBeat.i(90792);
    ac.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
    if (this.osN != 2) {
      ac.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.osQ)
    {
      if (!this.osJ.Og())
      {
        if (this.osJ.cVv != 13) {
          this.osR = 1;
        }
        AppMethodBeat.o(90792);
        return false;
      }
      p.otZ.jz(true);
      ac.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.osR);
      AppMethodBeat.o(90792);
      return true;
    }
  }
  
  public final boolean bVp()
  {
    if (this.osJ == null) {
      return false;
    }
    return this.osV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.e
 * JD-Core Version:    0.7.0.1
 */