package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  static int wTJ = 3;
  int mChannels;
  int mSampleRate;
  g wTF;
  public volatile com.tencent.mm.audio.b.c wTG;
  private e wTH;
  private k wTI;
  int wTK;
  int wTL;
  private int wTM;
  private final Object wTN;
  int wTO;
  private int wTP;
  private int wTQ;
  private long wTR;
  boolean wTS;
  public boolean wTT;
  int wTU;
  c.a wTV;
  
  public f(k paramk)
  {
    AppMethodBeat.i(90791);
    this.wTK = 1;
    this.wTL = 92;
    this.wTM = 1;
    this.wTN = new Object();
    this.wTO = 0;
    this.wTP = 0;
    this.wTQ = 1;
    this.wTR = 0L;
    this.wTS = false;
    this.wTT = false;
    this.mSampleRate = 16000;
    this.mChannels = 1;
    this.wTU = 30;
    this.wTV = new c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int i = -1;
        AppMethodBeat.i(90789);
        for (;;)
        {
          Object localObject2;
          synchronized (f.k(f.this))
          {
            if (f.a(f.this) % 50 == 0)
            {
              f.b(f.this);
              Log.v("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if ((f.c(f.this) != 2) || (!f.d(f.this).wTY.isAvailable()))
            {
              AppMethodBeat.o(90789);
              return;
            }
            if (f.e(f.this) <= 10) {
              f.a(f.this, 92);
            }
            localObject2 = f.d(f.this).wTY.wTy;
            if (localObject2 == null)
            {
              paramAnonymousInt = -1;
              f.a(f.this, (paramAnonymousInt + 24 + f.e(f.this) * 3) / 4);
              if (f.f(f.this) != 1) {
                break label330;
              }
              localObject2 = f.d(f.this).wTY.wTy;
              if (localObject2 != null) {
                break label321;
              }
              paramAnonymousInt = i;
              i = paramAnonymousInt;
              if (paramAnonymousInt >= f.e(f.this)) {
                i = paramAnonymousInt - f.e(f.this);
              }
              f.a(f.this, i);
              f.g(f.this);
              if (1 != f.h(f.this)) {
                break label342;
              }
              f.i(f.this);
              f.a(f.this, System.currentTimeMillis());
              Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
              localObject2 = q.wVc;
              q.G(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length, f.e(f.this));
            }
          }
          paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).hVE();
          continue;
          label321:
          paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).hVB();
          continue;
          label330:
          f.a(f.this, 0);
          continue;
          label342:
          long l1 = System.currentTimeMillis();
          long l2 = l1 - f.j(f.this);
          if (l2 > 1000L) {
            Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          f.a(f.this, l1);
        }
      }
    };
    this.wTH = new e();
    this.wTI = paramk;
    this.wTF = new g();
    AppMethodBeat.o(90791);
  }
  
  public final boolean aGR()
  {
    AppMethodBeat.i(90792);
    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
    if (this.wTK != 2) {
      Log.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.wTN)
    {
      if (!this.wTG.aGR())
      {
        if (this.wTG.hwc != 13) {
          this.wTO = 1;
        }
        AppMethodBeat.o(90792);
        return false;
      }
      q.wVc.nt(true);
      Log.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.wTO);
      AppMethodBeat.o(90792);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.f
 * JD-Core Version:    0.7.0.1
 */