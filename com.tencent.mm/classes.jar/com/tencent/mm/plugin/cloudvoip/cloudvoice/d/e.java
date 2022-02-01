package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  static int oWi = 3;
  int mChannels;
  boolean mIsPlayMute;
  int mSampleRate;
  f oWe;
  public volatile com.tencent.mm.audio.b.c oWf;
  private d oWg;
  private j oWh;
  int oWj;
  int oWk;
  private int oWl;
  private final Object oWm;
  int oWn;
  private int oWo;
  private int oWp;
  private long oWq;
  public boolean oWr;
  int oWs;
  c.a oWt;
  
  public e(j paramj)
  {
    AppMethodBeat.i(90791);
    this.oWj = 1;
    this.oWk = 92;
    this.oWl = 1;
    this.oWm = new Object();
    this.oWn = 0;
    this.oWo = 0;
    this.oWp = 1;
    this.oWq = 0L;
    this.mIsPlayMute = false;
    this.oWr = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.oWs = 20;
    this.oWt = new c.a()
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
              ad.v("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if (e.c(e.this) == 2)
            {
              paramAnonymousInt = j;
              if (e.d(e.this).oWw.oVX == null) {
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
            Object localObject2 = e.d(e.this).oWw.oVX;
            if (localObject2 != null)
            {
              paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).euT();
              e.a(e.this, (paramAnonymousInt + 24 + e.e(e.this) * 3) / 4);
              if (e.f(e.this) != 1) {
                break label338;
              }
              localObject2 = e.d(e.this).oWw.oVX;
              paramAnonymousInt = i;
              if (localObject2 != null) {
                paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).euQ();
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
              localObject2 = p.oXv;
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
            ad.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          e.a(e.this, l1);
          continue;
          label404:
          if (paramAnonymousInt != 0) {}
        }
      }
    };
    this.oWg = new d();
    this.oWh = paramj;
    this.oWe = new f();
    AppMethodBeat.o(90791);
  }
  
  public final boolean PP()
  {
    AppMethodBeat.i(90792);
    ad.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
    if (this.oWj != 2) {
      ad.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.oWm)
    {
      if (!this.oWf.PP())
      {
        if (this.oWf.dgL != 13) {
          this.oWn = 1;
        }
        AppMethodBeat.o(90792);
        return false;
      }
      p.oXv.jK(true);
      ad.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.oWn);
      AppMethodBeat.o(90792);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.e
 * JD-Core Version:    0.7.0.1
 */