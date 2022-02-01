package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  static int qrK = 3;
  int mChannels;
  int mSampleRate;
  g qrG;
  public volatile com.tencent.mm.audio.b.c qrH;
  private e qrI;
  private k qrJ;
  int qrL;
  int qrM;
  private int qrN;
  private final Object qrO;
  int qrP;
  private int qrQ;
  private int qrR;
  private long qrS;
  boolean qrT;
  public boolean qrU;
  int qrV;
  c.a qrW;
  
  public f(k paramk)
  {
    AppMethodBeat.i(90791);
    this.qrL = 1;
    this.qrM = 92;
    this.qrN = 1;
    this.qrO = new Object();
    this.qrP = 0;
    this.qrQ = 0;
    this.qrR = 1;
    this.qrS = 0L;
    this.qrT = false;
    this.qrU = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.qrV = 20;
    this.qrW = new c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int i = -1;
        AppMethodBeat.i(90789);
        for (;;)
        {
          synchronized (f.k(f.this))
          {
            if (f.a(f.this) % 50 == 0)
            {
              f.b(f.this);
              Log.v("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if ((f.c(f.this) != 2) || (!f.d(f.this).qrZ.isAvailable()))
            {
              AppMethodBeat.o(90789);
              return;
            }
            if (f.e(f.this) <= 10) {
              f.a(f.this, 92);
            }
            Object localObject2 = f.d(f.this).qrZ.qrz;
            if (localObject2 != null)
            {
              paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).fFq();
              f.a(f.this, (paramAnonymousInt + 24 + f.e(f.this) * 3) / 4);
              if (f.f(f.this) != 1) {
                break label327;
              }
              localObject2 = f.d(f.this).qrZ.qrz;
              paramAnonymousInt = i;
              if (localObject2 != null) {
                paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).fFn();
              }
              i = paramAnonymousInt;
              if (paramAnonymousInt >= f.e(f.this)) {
                i = paramAnonymousInt - f.e(f.this);
              }
              f.a(f.this, i);
              f.g(f.this);
              if (1 != f.h(f.this)) {
                break label339;
              }
              f.i(f.this);
              f.a(f.this, System.currentTimeMillis());
              Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
              localObject2 = q.qta;
              q.G(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length, f.e(f.this));
            }
          }
          paramAnonymousInt = -1;
          continue;
          label327:
          f.a(f.this, 0);
          continue;
          label339:
          long l1 = System.currentTimeMillis();
          long l2 = l1 - f.j(f.this);
          if (l2 > 1000L) {
            Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          f.a(f.this, l1);
        }
      }
    };
    this.qrI = new e();
    this.qrJ = paramk;
    this.qrG = new g();
    AppMethodBeat.o(90791);
  }
  
  public final boolean aai()
  {
    AppMethodBeat.i(90792);
    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
    if (this.qrL != 2) {
      Log.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.qrO)
    {
      if (!this.qrH.aai())
      {
        if (this.qrH.dyZ != 13) {
          this.qrP = 1;
        }
        AppMethodBeat.o(90792);
        return false;
      }
      q.qta.kM(true);
      Log.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.qrP);
      AppMethodBeat.o(90792);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f
 * JD-Core Version:    0.7.0.1
 */