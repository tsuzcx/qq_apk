package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class f
  implements com.tencent.mm.al.g
{
  public static int cZR;
  private static final String hDZ;
  private static final String hEa;
  com.tencent.mm.audio.b.c cXI;
  private com.tencent.mm.audio.b.c.a cYv;
  public int hDV;
  public int hEb;
  int hEc;
  boolean hEd;
  private int hEe;
  public boolean hEf;
  b hEg;
  com.tencent.mm.audio.e.a hEh;
  com.tencent.qqpinyin.voicerecoapi.c hEi;
  private a hEj;
  ap handler;
  
  static
  {
    AppMethodBeat.i(148545);
    hDZ = com.tencent.mm.storage.ae.FfH + "tmp_voiceaddr.spx";
    hEa = com.tencent.mm.storage.ae.FfH + "tmp_voiceaddr.amr";
    cZR = 100;
    AppMethodBeat.o(148545);
  }
  
  public f(b paramb, int paramInt)
  {
    AppMethodBeat.i(148538);
    this.hDV = 1;
    this.hEb = 0;
    this.hEc = 0;
    this.hEd = false;
    this.hEe = 500000;
    this.hEf = false;
    this.hEg = null;
    this.hEi = null;
    this.hEj = null;
    this.cYv = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148535);
        ad.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.qqpinyin.voicerecoapi.c.a locala = new com.tencent.qqpinyin.voicerecoapi.c.a();
        short[] arrayOfShort = new short[paramAnonymousInt / 2];
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          arrayOfShort[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        if (f.this.hEi != null) {
          f.this.hEi.a(arrayOfShort, paramAnonymousInt / 2, locala);
        }
        f.a(f.this, arrayOfShort, paramAnonymousInt / 2);
        if (f.this.hEh != null) {}
        for (paramAnonymousInt = f.this.hEh.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            f.a(f.this);
            ad.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            AppMethodBeat.o(148535);
            return;
          }
          paramAnonymousArrayOfByte = f.this;
          paramAnonymousArrayOfByte.hEc = (paramAnonymousInt + paramAnonymousArrayOfByte.hEc);
          if ((f.this.hEc > 3300) && (!f.this.hEd))
          {
            ad.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            f.this.handler.sendEmptyMessage(0);
            f.this.hEd = true;
          }
          if ((locala.IpI == 2) || (locala.IpI == 3))
          {
            ad.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.IpI);
            f.a(f.this);
          }
          AppMethodBeat.o(148535);
          return;
        }
      }
    };
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148536);
        if (paramAnonymousMessage.what == 2)
        {
          if (f.this.hEg != null)
          {
            f.this.hEg.aDQ();
            AppMethodBeat.o(148536);
          }
        }
        else
        {
          if (paramAnonymousMessage.what == 0)
          {
            if (f.b(f.this) == 0)
            {
              ad.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
              com.tencent.mm.kernel.g.aeS().a(349, f.this);
              if (f.b(f.this) != 0) {
                break label184;
              }
              if (f.c(f.this)) {
                break label158;
              }
              f.a(f.this, new e(f.d(f.this), 0));
            }
            for (;;)
            {
              com.tencent.mm.kernel.g.aeS().a(f.e(f.this), 0);
              AppMethodBeat.o(148536);
              return;
              com.tencent.mm.kernel.g.aeS().a(206, f.this);
              break;
              label158:
              f.a(f.this, new e(f.d(f.this), 1));
              continue;
              label184:
              f.a(f.this, new d(f.d(f.this), f.b(f.this)));
            }
          }
          if ((paramAnonymousMessage.what == 3) && (f.this.hEg != null)) {
            f.this.hEg.a(new String[0], -1L);
          }
        }
        AppMethodBeat.o(148536);
      }
    };
    this.hEg = paramb;
    this.hDV = paramInt;
    if (this.hDV == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.hEe = paramInt;
      AppMethodBeat.o(148538);
      return;
    }
  }
  
  private void finish()
  {
    AppMethodBeat.i(148540);
    ad.i("MicroMsg.SceneVoiceAddr", "finish");
    ad.m("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.hEj != null) {
      this.hEj.aDH();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.hEd) {
      this.handler.sendEmptyMessage(3);
    }
    reset();
    AppMethodBeat.o(148540);
  }
  
  private void reset()
  {
    AppMethodBeat.i(148542);
    ad.i("MicroMsg.SceneVoiceAddr", "reset");
    try
    {
      if (this.cXI != null)
      {
        this.cXI.Ob();
        this.cXI = null;
      }
      if (this.hEh != null)
      {
        this.hEh.PQ();
        this.hEh = null;
      }
      if (this.hEi != null) {
        this.hEi.stop();
      }
      this.hEi = null;
      if (this.hEj != null)
      {
        this.hEj.aDH();
        this.hEj = null;
      }
      this.hEc = 0;
      this.hEd = false;
      return;
    }
    finally
    {
      AppMethodBeat.o(148542);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(148541);
    this.hEg = null;
    finish();
    AppMethodBeat.o(148541);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(148539);
    long l;
    if (this.hDV == 0)
    {
      ad.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      com.tencent.mm.kernel.g.aeS().b(349, this);
      paramString = ((a)paramn).aDI();
      l = ((a)paramn).aDJ();
      if (paramString != null) {
        break label135;
      }
    }
    label135:
    for (int i = -1;; i = paramString.length)
    {
      ad.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.hEg == null) {
        break label154;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label142;
      }
      this.hEg.aDP();
      cancel();
      AppMethodBeat.o(148539);
      return;
      com.tencent.mm.kernel.g.aeS().b(206, this);
      break;
    }
    label142:
    this.hEg.a(paramString, l);
    label154:
    AppMethodBeat.o(148539);
  }
  
  public final class a
    implements Runnable
  {
    public a() {}
    
    public final void run()
    {
      AppMethodBeat.i(148537);
      for (;;)
      {
        synchronized (f.this)
        {
          ad.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
          try
          {
            new com.tencent.mm.vfs.e(f.d(f.this)).delete();
            if (f.c(f.this))
            {
              i = 8000;
              f.this.cXI = new com.tencent.mm.audio.b.c(i, 1, 3);
              f.this.cXI.cYk = -19;
              f.this.cXI.cr(false);
              if (!f.c(f.this))
              {
                f.this.hEh = new com.tencent.mm.audio.e.d();
                if (!f.this.hEh.fR(f.d(f.this)))
                {
                  ad.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                  f.this.hEh.PQ();
                  f.this.hEh = null;
                }
              }
              if ((f.c(f.this)) || (com.tencent.mm.compatible.deviceinfo.ae.fFH.fCb <= 0)) {
                break label332;
              }
              f.this.cXI.t(com.tencent.mm.compatible.deviceinfo.ae.fFH.fCb, true);
              f.this.cXI.cs(false);
              f.this.hEi = new com.tencent.qqpinyin.voicerecoapi.c(f.f(f.this));
              i = f.this.hEi.fma();
              if (i == 0) {
                break label347;
              }
              ad.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :".concat(String.valueOf(i)));
              f.g(f.this);
              AppMethodBeat.o(148537);
              return;
            }
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + f.d(f.this), new Object[] { localException });
            continue;
          }
        }
        int i = 16000;
        continue;
        label332:
        f.this.cXI.t(5, false);
        continue;
        label347:
        f.this.cXI.cYv = f.h(f.this);
        if (!f.this.cXI.Ok())
        {
          ad.e("MicroMsg.SceneVoiceAddr", "start record failed");
          f.g(f.this);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String[] paramArrayOfString, long paramLong);
    
    public abstract void aDP();
    
    public abstract void aDQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */