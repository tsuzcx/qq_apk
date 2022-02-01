package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.u;

public final class f
  implements com.tencent.mm.am.h
{
  public static int hxV;
  private static final String pfs;
  private static final String pft;
  MMHandler handler;
  com.tencent.mm.audio.b.c hvI;
  private com.tencent.mm.audio.b.c.a hwy;
  com.tencent.mm.audio.e.a pfA;
  com.tencent.qqpinyin.voicerecoapi.c pfB;
  private a pfC;
  public int pfo;
  public int pfu;
  int pfv;
  boolean pfw;
  private int pfx;
  public boolean pfy;
  b pfz;
  
  static
  {
    AppMethodBeat.i(148545);
    pfs = at.acHq + "tmp_voiceaddr.spx";
    pft = at.acHq + "tmp_voiceaddr.amr";
    hxV = 100;
    AppMethodBeat.o(148545);
  }
  
  public f(b paramb, int paramInt)
  {
    AppMethodBeat.i(148538);
    this.pfo = 1;
    this.pfu = 0;
    this.pfv = 0;
    this.pfw = false;
    this.pfx = 500000;
    this.pfy = false;
    this.pfz = null;
    this.pfB = null;
    this.pfC = null;
    this.hwy = new com.tencent.mm.audio.b.c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148535);
        Log.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.qqpinyin.voicerecoapi.c.a locala = new com.tencent.qqpinyin.voicerecoapi.c.a();
        short[] arrayOfShort = new short[paramAnonymousInt / 2];
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          arrayOfShort[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        if (f.this.pfB != null) {
          f.this.pfB.a(arrayOfShort, paramAnonymousInt / 2, locala);
        }
        f.a(f.this, arrayOfShort, paramAnonymousInt / 2);
        if (f.this.pfA != null) {}
        for (paramAnonymousInt = f.this.pfA.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            f.a(f.this);
            Log.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            AppMethodBeat.o(148535);
            return;
          }
          paramAnonymousArrayOfByte = f.this;
          paramAnonymousArrayOfByte.pfv = (paramAnonymousInt + paramAnonymousArrayOfByte.pfv);
          if ((f.this.pfv > 3300) && (!f.this.pfw))
          {
            Log.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            f.this.handler.sendEmptyMessage(0);
            f.this.pfw = true;
          }
          if ((locala.ahrZ == 2) || (locala.ahrZ == 3))
          {
            Log.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.ahrZ);
            f.a(f.this);
          }
          AppMethodBeat.o(148535);
          return;
        }
      }
    };
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148536);
        if (paramAnonymousMessage.what == 2)
        {
          if (f.this.pfz != null)
          {
            f.this.pfz.bPz();
            AppMethodBeat.o(148536);
          }
        }
        else
        {
          if (paramAnonymousMessage.what == 0)
          {
            if (f.b(f.this) == 0)
            {
              Log.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
              com.tencent.mm.kernel.h.aZW().a(349, f.this);
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
              com.tencent.mm.kernel.h.aZW().a(f.e(f.this), 0);
              AppMethodBeat.o(148536);
              return;
              com.tencent.mm.kernel.h.aZW().a(206, f.this);
              break;
              label158:
              f.a(f.this, new e(f.d(f.this), 1));
              continue;
              label184:
              f.a(f.this, new d(f.d(f.this), f.b(f.this)));
            }
          }
          if ((paramAnonymousMessage.what == 3) && (f.this.pfz != null)) {
            f.this.pfz.a(new String[0], -1L);
          }
        }
        AppMethodBeat.o(148536);
      }
    };
    this.pfz = paramb;
    this.pfo = paramInt;
    if (this.pfo == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.pfx = paramInt;
      AppMethodBeat.o(148538);
      return;
    }
  }
  
  private void finish()
  {
    AppMethodBeat.i(148540);
    Log.i("MicroMsg.SceneVoiceAddr", "finish");
    Log.printInfoStack("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.pfC != null) {
      this.pfC.bPq();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.pfw) {
      this.handler.sendEmptyMessage(3);
    }
    reset();
    AppMethodBeat.o(148540);
  }
  
  private void reset()
  {
    AppMethodBeat.i(148542);
    Log.i("MicroMsg.SceneVoiceAddr", "reset");
    try
    {
      if (this.hvI != null)
      {
        this.hvI.aGH();
        this.hvI = null;
      }
      if (this.pfA != null)
      {
        this.pfA.aIz();
        this.pfA = null;
      }
      if (this.pfB != null) {
        this.pfB.stop();
      }
      this.pfB = null;
      if (this.pfC != null)
      {
        this.pfC.bPq();
        this.pfC = null;
      }
      this.pfv = 0;
      this.pfw = false;
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
    this.pfz = null;
    finish();
    AppMethodBeat.o(148541);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(148539);
    long l;
    if (this.pfo == 0)
    {
      Log.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      com.tencent.mm.kernel.h.aZW().b(349, this);
      paramString = ((a)paramp).bPr();
      l = ((a)paramp).bPs();
      if (paramString != null) {
        break label146;
      }
    }
    label146:
    for (int i = -1;; i = paramString.length)
    {
      Log.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.pfz == null) {
        break label165;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label153;
      }
      paramString = this.pfz;
      ((a)paramp).bPt();
      paramString.bPy();
      cancel();
      AppMethodBeat.o(148539);
      return;
      com.tencent.mm.kernel.h.aZW().b(206, this);
      break;
    }
    label153:
    this.pfz.a(paramString, l);
    label165:
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
          Log.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
          try
          {
            new u(f.d(f.this)).diJ();
            if (f.c(f.this))
            {
              i = 8000;
              f.this.hvI = new com.tencent.mm.audio.b.c(i, 1, 3);
              f.this.hvI.hwn = -19;
              f.this.hvI.eo(false);
              if (!f.c(f.this))
              {
                f.this.pfA = new com.tencent.mm.audio.e.d();
                if (!f.this.pfA.jO(f.d(f.this)))
                {
                  Log.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                  f.this.pfA.aIz();
                  f.this.pfA = null;
                }
              }
              if ((f.c(f.this)) || (af.lYj.lUg <= 0)) {
                break label332;
              }
              f.this.hvI.O(af.lYj.lUg, true);
              f.this.hvI.ep(false);
              f.this.pfB = new com.tencent.qqpinyin.voicerecoapi.c(f.f(f.this));
              i = f.this.pfB.jXc();
              if (i == 0) {
                break label347;
              }
              Log.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :".concat(String.valueOf(i)));
              f.g(f.this);
              AppMethodBeat.o(148537);
              return;
            }
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + f.d(f.this), new Object[] { localException });
            continue;
          }
        }
        int i = 16000;
        continue;
        label332:
        f.this.hvI.O(5, false);
        continue;
        label347:
        f.this.hvI.hwy = f.h(f.this);
        if (!f.this.hvI.aGR())
        {
          Log.e("MicroMsg.SceneVoiceAddr", "start record failed");
          f.g(f.this);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String[] paramArrayOfString, long paramLong);
    
    public abstract void bPy();
    
    public abstract void bPz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */