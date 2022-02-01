package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.am;

public final class f
  implements com.tencent.mm.ak.f
{
  public static int djH;
  private static final String iAO;
  private static final String iAP;
  com.tencent.mm.audio.b.c dhw;
  private com.tencent.mm.audio.b.c.a dij;
  aq handler;
  public int iAK;
  public int iAQ;
  int iAR;
  boolean iAS;
  private int iAT;
  public boolean iAU;
  b iAV;
  com.tencent.mm.audio.e.a iAW;
  com.tencent.qqpinyin.voicerecoapi.c iAX;
  private a iAY;
  
  static
  {
    AppMethodBeat.i(148545);
    iAO = am.IKh + "tmp_voiceaddr.spx";
    iAP = am.IKh + "tmp_voiceaddr.amr";
    djH = 100;
    AppMethodBeat.o(148545);
  }
  
  public f(b paramb, int paramInt)
  {
    AppMethodBeat.i(148538);
    this.iAK = 1;
    this.iAQ = 0;
    this.iAR = 0;
    this.iAS = false;
    this.iAT = 500000;
    this.iAU = false;
    this.iAV = null;
    this.iAX = null;
    this.iAY = null;
    this.dij = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148535);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.qqpinyin.voicerecoapi.c.a locala = new com.tencent.qqpinyin.voicerecoapi.c.a();
        short[] arrayOfShort = new short[paramAnonymousInt / 2];
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          arrayOfShort[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        if (f.this.iAX != null) {
          f.this.iAX.a(arrayOfShort, paramAnonymousInt / 2, locala);
        }
        f.a(f.this, arrayOfShort, paramAnonymousInt / 2);
        if (f.this.iAW != null) {}
        for (paramAnonymousInt = f.this.iAW.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            f.a(f.this);
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            AppMethodBeat.o(148535);
            return;
          }
          paramAnonymousArrayOfByte = f.this;
          paramAnonymousArrayOfByte.iAR = (paramAnonymousInt + paramAnonymousArrayOfByte.iAR);
          if ((f.this.iAR > 3300) && (!f.this.iAS))
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            f.this.handler.sendEmptyMessage(0);
            f.this.iAS = true;
          }
          if ((locala.Mij == 2) || (locala.Mij == 3))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.Mij);
            f.a(f.this);
          }
          AppMethodBeat.o(148535);
          return;
        }
      }
    };
    this.handler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148536);
        if (paramAnonymousMessage.what == 2)
        {
          if (f.this.iAV != null)
          {
            f.this.iAV.aOo();
            AppMethodBeat.o(148536);
          }
        }
        else
        {
          if (paramAnonymousMessage.what == 0)
          {
            if (f.b(f.this) == 0)
            {
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
              g.ajj().a(349, f.this);
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
              g.ajj().a(f.e(f.this), 0);
              AppMethodBeat.o(148536);
              return;
              g.ajj().a(206, f.this);
              break;
              label158:
              f.a(f.this, new e(f.d(f.this), 1));
              continue;
              label184:
              f.a(f.this, new d(f.d(f.this), f.b(f.this)));
            }
          }
          if ((paramAnonymousMessage.what == 3) && (f.this.iAV != null)) {
            f.this.iAV.a(new String[0], -1L);
          }
        }
        AppMethodBeat.o(148536);
      }
    };
    this.iAV = paramb;
    this.iAK = paramInt;
    if (this.iAK == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.iAT = paramInt;
      AppMethodBeat.o(148538);
      return;
    }
  }
  
  private void finish()
  {
    AppMethodBeat.i(148540);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoiceAddr", "finish");
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.iAY != null) {
      this.iAY.aOf();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.iAS) {
      this.handler.sendEmptyMessage(3);
    }
    reset();
    AppMethodBeat.o(148540);
  }
  
  private void reset()
  {
    AppMethodBeat.i(148542);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoiceAddr", "reset");
    try
    {
      if (this.dhw != null)
      {
        this.dhw.PF();
        this.dhw = null;
      }
      if (this.iAW != null)
      {
        this.iAW.Rx();
        this.iAW = null;
      }
      if (this.iAX != null) {
        this.iAX.stop();
      }
      this.iAX = null;
      if (this.iAY != null)
      {
        this.iAY.aOf();
        this.iAY = null;
      }
      this.iAR = 0;
      this.iAS = false;
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
    this.iAV = null;
    finish();
    AppMethodBeat.o(148541);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(148539);
    long l;
    if (this.iAK == 0)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      g.ajj().b(349, this);
      paramString = ((a)paramn).aOg();
      l = ((a)paramn).aOh();
      if (paramString != null) {
        break label135;
      }
    }
    label135:
    for (int i = -1;; i = paramString.length)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.iAV == null) {
        break label154;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label142;
      }
      this.iAV.aOn();
      cancel();
      AppMethodBeat.o(148539);
      return;
      g.ajj().b(206, this);
      break;
    }
    label142:
    this.iAV.a(paramString, l);
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
          try
          {
            new com.tencent.mm.vfs.k(f.d(f.this)).delete();
            if (f.c(f.this))
            {
              i = 8000;
              f.this.dhw = new com.tencent.mm.audio.b.c(i, 1, 3);
              f.this.dhw.dhY = -19;
              f.this.dhw.cu(false);
              if (!f.c(f.this))
              {
                f.this.iAW = new com.tencent.mm.audio.e.d();
                if (!f.this.iAW.gI(f.d(f.this)))
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                  f.this.iAW.Rx();
                  f.this.iAW = null;
                }
              }
              if ((f.c(f.this)) || (com.tencent.mm.compatible.deviceinfo.ae.geX.gbo <= 0)) {
                break label332;
              }
              f.this.dhw.t(com.tencent.mm.compatible.deviceinfo.ae.geX.gbo, true);
              f.this.dhw.cv(false);
              f.this.iAX = new com.tencent.qqpinyin.voicerecoapi.c(f.f(f.this));
              i = f.this.iAX.fYh();
              if (i == 0) {
                break label347;
              }
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :".concat(String.valueOf(i)));
              f.g(f.this);
              AppMethodBeat.o(148537);
              return;
            }
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + f.d(f.this), new Object[] { localException });
            continue;
          }
        }
        int i = 16000;
        continue;
        label332:
        f.this.dhw.t(5, false);
        continue;
        label347:
        f.this.dhw.dij = f.h(f.this);
        if (!f.this.dhw.PO())
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoiceAddr", "start record failed");
          f.g(f.this);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String[] paramArrayOfString, long paramLong);
    
    public abstract void aOn();
    
    public abstract void aOo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */