package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ah;

public final class f
  implements com.tencent.mm.ak.g
{
  public static int cXn;
  private static final String ieB;
  private static final String ieC;
  private com.tencent.mm.audio.b.c.a cVR;
  com.tencent.mm.audio.b.c cVe;
  ao handler;
  public int ieD;
  int ieE;
  boolean ieF;
  private int ieG;
  public boolean ieH;
  b ieI;
  com.tencent.mm.audio.e.a ieJ;
  com.tencent.qqpinyin.voicerecoapi.c ieK;
  private a ieL;
  public int iex;
  
  static
  {
    AppMethodBeat.i(148545);
    ieB = ah.GDu + "tmp_voiceaddr.spx";
    ieC = ah.GDu + "tmp_voiceaddr.amr";
    cXn = 100;
    AppMethodBeat.o(148545);
  }
  
  public f(b paramb, int paramInt)
  {
    AppMethodBeat.i(148538);
    this.iex = 1;
    this.ieD = 0;
    this.ieE = 0;
    this.ieF = false;
    this.ieG = 500000;
    this.ieH = false;
    this.ieI = null;
    this.ieK = null;
    this.ieL = null;
    this.cVR = new com.tencent.mm.audio.b.c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148535);
        ac.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.qqpinyin.voicerecoapi.c.a locala = new com.tencent.qqpinyin.voicerecoapi.c.a();
        short[] arrayOfShort = new short[paramAnonymousInt / 2];
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          arrayOfShort[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        if (f.this.ieK != null) {
          f.this.ieK.a(arrayOfShort, paramAnonymousInt / 2, locala);
        }
        f.a(f.this, arrayOfShort, paramAnonymousInt / 2);
        if (f.this.ieJ != null) {}
        for (paramAnonymousInt = f.this.ieJ.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            f.a(f.this);
            ac.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            AppMethodBeat.o(148535);
            return;
          }
          paramAnonymousArrayOfByte = f.this;
          paramAnonymousArrayOfByte.ieE = (paramAnonymousInt + paramAnonymousArrayOfByte.ieE);
          if ((f.this.ieE > 3300) && (!f.this.ieF))
          {
            ac.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            f.this.handler.sendEmptyMessage(0);
            f.this.ieF = true;
          }
          if ((locala.JRs == 2) || (locala.JRs == 3))
          {
            ac.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.JRs);
            f.a(f.this);
          }
          AppMethodBeat.o(148535);
          return;
        }
      }
    };
    this.handler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148536);
        if (paramAnonymousMessage.what == 2)
        {
          if (f.this.ieI != null)
          {
            f.this.ieI.aKH();
            AppMethodBeat.o(148536);
          }
        }
        else
        {
          if (paramAnonymousMessage.what == 0)
          {
            if (f.b(f.this) == 0)
            {
              ac.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
              com.tencent.mm.kernel.g.agi().a(349, f.this);
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
              com.tencent.mm.kernel.g.agi().a(f.e(f.this), 0);
              AppMethodBeat.o(148536);
              return;
              com.tencent.mm.kernel.g.agi().a(206, f.this);
              break;
              label158:
              f.a(f.this, new e(f.d(f.this), 1));
              continue;
              label184:
              f.a(f.this, new d(f.d(f.this), f.b(f.this)));
            }
          }
          if ((paramAnonymousMessage.what == 3) && (f.this.ieI != null)) {
            f.this.ieI.a(new String[0], -1L);
          }
        }
        AppMethodBeat.o(148536);
      }
    };
    this.ieI = paramb;
    this.iex = paramInt;
    if (this.iex == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.ieG = paramInt;
      AppMethodBeat.o(148538);
      return;
    }
  }
  
  private void finish()
  {
    AppMethodBeat.i(148540);
    ac.i("MicroMsg.SceneVoiceAddr", "finish");
    ac.m("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.ieL != null) {
      this.ieL.aKy();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.ieF) {
      this.handler.sendEmptyMessage(3);
    }
    reset();
    AppMethodBeat.o(148540);
  }
  
  private void reset()
  {
    AppMethodBeat.i(148542);
    ac.i("MicroMsg.SceneVoiceAddr", "reset");
    try
    {
      if (this.cVe != null)
      {
        this.cVe.NX();
        this.cVe = null;
      }
      if (this.ieJ != null)
      {
        this.ieJ.PM();
        this.ieJ = null;
      }
      if (this.ieK != null) {
        this.ieK.stop();
      }
      this.ieK = null;
      if (this.ieL != null)
      {
        this.ieL.aKy();
        this.ieL = null;
      }
      this.ieE = 0;
      this.ieF = false;
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
    this.ieI = null;
    finish();
    AppMethodBeat.o(148541);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(148539);
    long l;
    if (this.iex == 0)
    {
      ac.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      com.tencent.mm.kernel.g.agi().b(349, this);
      paramString = ((a)paramn).aKz();
      l = ((a)paramn).aKA();
      if (paramString != null) {
        break label135;
      }
    }
    label135:
    for (int i = -1;; i = paramString.length)
    {
      ac.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.ieI == null) {
        break label154;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label142;
      }
      this.ieI.aKG();
      cancel();
      AppMethodBeat.o(148539);
      return;
      com.tencent.mm.kernel.g.agi().b(206, this);
      break;
    }
    label142:
    this.ieI.a(paramString, l);
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
          ac.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
          try
          {
            new com.tencent.mm.vfs.e(f.d(f.this)).delete();
            if (f.c(f.this))
            {
              i = 8000;
              f.this.cVe = new com.tencent.mm.audio.b.c(i, 1, 3);
              f.this.cVe.cVG = -19;
              f.this.cVe.cs(false);
              if (!f.c(f.this))
              {
                f.this.ieJ = new com.tencent.mm.audio.e.d();
                if (!f.this.ieJ.fH(f.d(f.this)))
                {
                  ac.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                  f.this.ieJ.PM();
                  f.this.ieJ = null;
                }
              }
              if ((f.c(f.this)) || (ae.fJo.fFI <= 0)) {
                break label332;
              }
              f.this.cVe.t(ae.fJo.fFI, true);
              f.this.cVe.ct(false);
              f.this.ieK = new com.tencent.qqpinyin.voicerecoapi.c(f.f(f.this));
              i = f.this.ieK.fCr();
              if (i == 0) {
                break label347;
              }
              ac.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :".concat(String.valueOf(i)));
              f.g(f.this);
              AppMethodBeat.o(148537);
              return;
            }
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + f.d(f.this), new Object[] { localException });
            continue;
          }
        }
        int i = 16000;
        continue;
        label332:
        f.this.cVe.t(5, false);
        continue;
        label347:
        f.this.cVe.cVR = f.h(f.this);
        if (!f.this.cVe.Og())
        {
          ac.e("MicroMsg.SceneVoiceAddr", "start record failed");
          f.g(f.this);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String[] paramArrayOfString, long paramLong);
    
    public abstract void aKG();
    
    public abstract void aKH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */