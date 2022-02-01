package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.al;

public final class f
  implements com.tencent.mm.al.f
{
  public static int diF;
  private static final String ixV;
  private static final String ixW;
  com.tencent.mm.audio.b.c dgu;
  private com.tencent.mm.audio.b.c.a dhh;
  ap handler;
  public int ixR;
  public int ixX;
  int ixY;
  boolean ixZ;
  private int iya;
  public boolean iyb;
  b iyc;
  com.tencent.mm.audio.e.a iyd;
  com.tencent.qqpinyin.voicerecoapi.c iye;
  private a iyf;
  
  static
  {
    AppMethodBeat.i(148545);
    ixV = al.IpN + "tmp_voiceaddr.spx";
    ixW = al.IpN + "tmp_voiceaddr.amr";
    diF = 100;
    AppMethodBeat.o(148545);
  }
  
  public f(b paramb, int paramInt)
  {
    AppMethodBeat.i(148538);
    this.ixR = 1;
    this.ixX = 0;
    this.ixY = 0;
    this.ixZ = false;
    this.iya = 500000;
    this.iyb = false;
    this.iyc = null;
    this.iye = null;
    this.iyf = null;
    this.dhh = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
        if (f.this.iye != null) {
          f.this.iye.a(arrayOfShort, paramAnonymousInt / 2, locala);
        }
        f.a(f.this, arrayOfShort, paramAnonymousInt / 2);
        if (f.this.iyd != null) {}
        for (paramAnonymousInt = f.this.iyd.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            f.a(f.this);
            ad.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            AppMethodBeat.o(148535);
            return;
          }
          paramAnonymousArrayOfByte = f.this;
          paramAnonymousArrayOfByte.ixY = (paramAnonymousInt + paramAnonymousArrayOfByte.ixY);
          if ((f.this.ixY > 3300) && (!f.this.ixZ))
          {
            ad.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            f.this.handler.sendEmptyMessage(0);
            f.this.ixZ = true;
          }
          if ((locala.LLk == 2) || (locala.LLk == 3))
          {
            ad.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.LLk);
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
          if (f.this.iyc != null)
          {
            f.this.iyc.aNQ();
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
              g.aiU().a(349, f.this);
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
              g.aiU().a(f.e(f.this), 0);
              AppMethodBeat.o(148536);
              return;
              g.aiU().a(206, f.this);
              break;
              label158:
              f.a(f.this, new e(f.d(f.this), 1));
              continue;
              label184:
              f.a(f.this, new d(f.d(f.this), f.b(f.this)));
            }
          }
          if ((paramAnonymousMessage.what == 3) && (f.this.iyc != null)) {
            f.this.iyc.a(new String[0], -1L);
          }
        }
        AppMethodBeat.o(148536);
      }
    };
    this.iyc = paramb;
    this.ixR = paramInt;
    if (this.ixR == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.iya = paramInt;
      AppMethodBeat.o(148538);
      return;
    }
  }
  
  private void finish()
  {
    AppMethodBeat.i(148540);
    ad.i("MicroMsg.SceneVoiceAddr", "finish");
    ad.m("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.iyf != null) {
      this.iyf.aNH();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.ixZ) {
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
      if (this.dgu != null)
      {
        this.dgu.PG();
        this.dgu = null;
      }
      if (this.iyd != null)
      {
        this.iyd.Ry();
        this.iyd = null;
      }
      if (this.iye != null) {
        this.iye.stop();
      }
      this.iye = null;
      if (this.iyf != null)
      {
        this.iyf.aNH();
        this.iyf = null;
      }
      this.ixY = 0;
      this.ixZ = false;
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
    this.iyc = null;
    finish();
    AppMethodBeat.o(148541);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(148539);
    long l;
    if (this.ixR == 0)
    {
      ad.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      g.aiU().b(349, this);
      paramString = ((a)paramn).aNI();
      l = ((a)paramn).aNJ();
      if (paramString != null) {
        break label135;
      }
    }
    label135:
    for (int i = -1;; i = paramString.length)
    {
      ad.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.iyc == null) {
        break label154;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label142;
      }
      this.iyc.aNP();
      cancel();
      AppMethodBeat.o(148539);
      return;
      g.aiU().b(206, this);
      break;
    }
    label142:
    this.iyc.a(paramString, l);
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
              f.this.dgu = new com.tencent.mm.audio.b.c(i, 1, 3);
              f.this.dgu.dgW = -19;
              f.this.dgu.cu(false);
              if (!f.c(f.this))
              {
                f.this.iyd = new com.tencent.mm.audio.e.d();
                if (!f.this.iyd.gC(f.d(f.this)))
                {
                  ad.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                  f.this.iyd.Ry();
                  f.this.iyd = null;
                }
              }
              if ((f.c(f.this)) || (ae.gcP.fZh <= 0)) {
                break label332;
              }
              f.this.dgu.t(ae.gcP.fZh, true);
              f.this.dgu.cv(false);
              f.this.iye = new com.tencent.qqpinyin.voicerecoapi.c(f.f(f.this));
              i = f.this.iye.fTH();
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
        f.this.dgu.t(5, false);
        continue;
        label347:
        f.this.dgu.dhh = f.h(f.this);
        if (!f.this.dgu.PP())
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
    
    public abstract void aNP();
    
    public abstract void aNQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */