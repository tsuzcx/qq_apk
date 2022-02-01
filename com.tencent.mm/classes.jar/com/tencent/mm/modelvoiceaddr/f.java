package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;

public final class f
  implements i
{
  public static int dAR;
  private static final String jwd;
  private static final String jwe;
  com.tencent.mm.audio.b.c dyI;
  private com.tencent.mm.audio.b.c.a dzv;
  MMHandler handler;
  public int jvZ;
  public int jwf;
  int jwg;
  boolean jwh;
  private int jwi;
  public boolean jwj;
  b jwk;
  com.tencent.mm.audio.e.a jwl;
  com.tencent.qqpinyin.voicerecoapi.c jwm;
  private a jwn;
  
  static
  {
    AppMethodBeat.i(148545);
    jwd = ar.NSe + "tmp_voiceaddr.spx";
    jwe = ar.NSe + "tmp_voiceaddr.amr";
    dAR = 100;
    AppMethodBeat.o(148545);
  }
  
  public f(b paramb, int paramInt)
  {
    AppMethodBeat.i(148538);
    this.jvZ = 1;
    this.jwf = 0;
    this.jwg = 0;
    this.jwh = false;
    this.jwi = 500000;
    this.jwj = false;
    this.jwk = null;
    this.jwm = null;
    this.jwn = null;
    this.dzv = new com.tencent.mm.audio.b.c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
        if (f.this.jwm != null) {
          f.this.jwm.a(arrayOfShort, paramAnonymousInt / 2, locala);
        }
        f.a(f.this, arrayOfShort, paramAnonymousInt / 2);
        if (f.this.jwl != null) {}
        for (paramAnonymousInt = f.this.jwl.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            f.a(f.this);
            Log.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            AppMethodBeat.o(148535);
            return;
          }
          paramAnonymousArrayOfByte = f.this;
          paramAnonymousArrayOfByte.jwg = (paramAnonymousInt + paramAnonymousArrayOfByte.jwg);
          if ((f.this.jwg > 3300) && (!f.this.jwh))
          {
            Log.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            f.this.handler.sendEmptyMessage(0);
            f.this.jwh = true;
          }
          if ((locala.RKK == 2) || (locala.RKK == 3))
          {
            Log.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.RKK);
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
          if (f.this.jwk != null)
          {
            f.this.jwk.biv();
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
              g.azz().a(349, f.this);
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
              g.azz().a(f.e(f.this), 0);
              AppMethodBeat.o(148536);
              return;
              g.azz().a(206, f.this);
              break;
              label158:
              f.a(f.this, new e(f.d(f.this), 1));
              continue;
              label184:
              f.a(f.this, new d(f.d(f.this), f.b(f.this)));
            }
          }
          if ((paramAnonymousMessage.what == 3) && (f.this.jwk != null)) {
            f.this.jwk.a(new String[0], -1L);
          }
        }
        AppMethodBeat.o(148536);
      }
    };
    this.jwk = paramb;
    this.jvZ = paramInt;
    if (this.jvZ == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.jwi = paramInt;
      AppMethodBeat.o(148538);
      return;
    }
  }
  
  private void finish()
  {
    AppMethodBeat.i(148540);
    Log.i("MicroMsg.SceneVoiceAddr", "finish");
    Log.printInfoStack("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.jwn != null) {
      this.jwn.bim();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.jwh) {
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
      if (this.dyI != null)
      {
        this.dyI.ZZ();
        this.dyI = null;
      }
      if (this.jwl != null)
      {
        this.jwl.abP();
        this.jwl = null;
      }
      if (this.jwm != null) {
        this.jwm.stop();
      }
      this.jwm = null;
      if (this.jwn != null)
      {
        this.jwn.bim();
        this.jwn = null;
      }
      this.jwg = 0;
      this.jwh = false;
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
    this.jwk = null;
    finish();
    AppMethodBeat.o(148541);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(148539);
    long l;
    if (this.jvZ == 0)
    {
      Log.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      g.azz().b(349, this);
      paramString = ((a)paramq).bin();
      l = ((a)paramq).bio();
      if (paramString != null) {
        break label135;
      }
    }
    label135:
    for (int i = -1;; i = paramString.length)
    {
      Log.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.jwk == null) {
        break label154;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label142;
      }
      this.jwk.biu();
      cancel();
      AppMethodBeat.o(148539);
      return;
      g.azz().b(206, this);
      break;
    }
    label142:
    this.jwk.a(paramString, l);
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
          Log.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
          try
          {
            new o(f.d(f.this)).delete();
            if (f.c(f.this))
            {
              i = 8000;
              f.this.dyI = new com.tencent.mm.audio.b.c(i, 1, 3);
              f.this.dyI.dzk = -19;
              f.this.dyI.dc(false);
              if (!f.c(f.this))
              {
                f.this.jwl = new com.tencent.mm.audio.e.d();
                if (!f.this.jwl.hz(f.d(f.this)))
                {
                  Log.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                  f.this.jwl.abP();
                  f.this.jwl = null;
                }
              }
              if ((f.c(f.this)) || (ae.gKE.gGG <= 0)) {
                break label332;
              }
              f.this.dyI.x(ae.gKE.gGG, true);
              f.this.dyI.dd(false);
              f.this.jwm = new com.tencent.qqpinyin.voicerecoapi.c(f.f(f.this));
              i = f.this.jwm.hkt();
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
        f.this.dyI.x(5, false);
        continue;
        label347:
        f.this.dyI.dzv = f.h(f.this);
        if (!f.this.dyI.aai())
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
    
    public abstract void biu();
    
    public abstract void biv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */