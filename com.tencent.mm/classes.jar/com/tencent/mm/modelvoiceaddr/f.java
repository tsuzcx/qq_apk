package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;

public final class f
  implements i
{
  public static int ftG;
  private static final String mlG;
  private static final String mlH;
  com.tencent.mm.audio.b.c frx;
  private com.tencent.mm.audio.b.c.a fsk;
  MMHandler handler;
  public int mlC;
  public int mlI;
  int mlJ;
  boolean mlK;
  private int mlL;
  public boolean mlM;
  b mlN;
  com.tencent.mm.audio.e.a mlO;
  com.tencent.qqpinyin.voicerecoapi.c mlP;
  private a mlQ;
  
  static
  {
    AppMethodBeat.i(148545);
    mlG = ar.Vgb + "tmp_voiceaddr.spx";
    mlH = ar.Vgb + "tmp_voiceaddr.amr";
    ftG = 100;
    AppMethodBeat.o(148545);
  }
  
  public f(b paramb, int paramInt)
  {
    AppMethodBeat.i(148538);
    this.mlC = 1;
    this.mlI = 0;
    this.mlJ = 0;
    this.mlK = false;
    this.mlL = 500000;
    this.mlM = false;
    this.mlN = null;
    this.mlP = null;
    this.mlQ = null;
    this.fsk = new com.tencent.mm.audio.b.c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
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
        if (f.this.mlP != null) {
          f.this.mlP.a(arrayOfShort, paramAnonymousInt / 2, locala);
        }
        f.a(f.this, arrayOfShort, paramAnonymousInt / 2);
        if (f.this.mlO != null) {}
        for (paramAnonymousInt = f.this.mlO.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            f.a(f.this);
            Log.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            AppMethodBeat.o(148535);
            return;
          }
          paramAnonymousArrayOfByte = f.this;
          paramAnonymousArrayOfByte.mlJ = (paramAnonymousInt + paramAnonymousArrayOfByte.mlJ);
          if ((f.this.mlJ > 3300) && (!f.this.mlK))
          {
            Log.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            f.this.handler.sendEmptyMessage(0);
            f.this.mlK = true;
          }
          if ((locala.Znr == 2) || (locala.Znr == 3))
          {
            Log.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.Znr);
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
          if (f.this.mlN != null)
          {
            f.this.mlN.brT();
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
              h.aGY().a(349, f.this);
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
              h.aGY().a(f.e(f.this), 0);
              AppMethodBeat.o(148536);
              return;
              h.aGY().a(206, f.this);
              break;
              label158:
              f.a(f.this, new e(f.d(f.this), 1));
              continue;
              label184:
              f.a(f.this, new d(f.d(f.this), f.b(f.this)));
            }
          }
          if ((paramAnonymousMessage.what == 3) && (f.this.mlN != null)) {
            f.this.mlN.a(new String[0], -1L);
          }
        }
        AppMethodBeat.o(148536);
      }
    };
    this.mlN = paramb;
    this.mlC = paramInt;
    if (this.mlC == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.mlL = paramInt;
      AppMethodBeat.o(148538);
      return;
    }
  }
  
  private void finish()
  {
    AppMethodBeat.i(148540);
    Log.i("MicroMsg.SceneVoiceAddr", "finish");
    Log.printInfoStack("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.mlQ != null) {
      this.mlQ.brK();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.mlK) {
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
      if (this.frx != null)
      {
        this.frx.aeJ();
        this.frx = null;
      }
      if (this.mlO != null)
      {
        this.mlO.agC();
        this.mlO = null;
      }
      if (this.mlP != null) {
        this.mlP.stop();
      }
      this.mlP = null;
      if (this.mlQ != null)
      {
        this.mlQ.brK();
        this.mlQ = null;
      }
      this.mlJ = 0;
      this.mlK = false;
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
    this.mlN = null;
    finish();
    AppMethodBeat.o(148541);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(148539);
    long l;
    if (this.mlC == 0)
    {
      Log.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      h.aGY().b(349, this);
      paramString = ((a)paramq).brL();
      l = ((a)paramq).brM();
      if (paramString != null) {
        break label146;
      }
    }
    label146:
    for (int i = -1;; i = paramString.length)
    {
      Log.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.mlN == null) {
        break label165;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label153;
      }
      paramString = this.mlN;
      ((a)paramq).brN();
      paramString.brS();
      cancel();
      AppMethodBeat.o(148539);
      return;
      h.aGY().b(206, this);
      break;
    }
    label153:
    this.mlN.a(paramString, l);
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
            new com.tencent.mm.vfs.q(f.d(f.this)).cFq();
            if (f.c(f.this))
            {
              i = 8000;
              f.this.frx = new com.tencent.mm.audio.b.c(i, 1, 3);
              f.this.frx.frZ = -19;
              f.this.frx.dC(false);
              if (!f.c(f.this))
              {
                f.this.mlO = new com.tencent.mm.audio.e.d();
                if (!f.this.mlO.in(f.d(f.this)))
                {
                  Log.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                  f.this.mlO.agC();
                  f.this.mlO = null;
                }
              }
              if ((f.c(f.this)) || (af.juS.jqS <= 0)) {
                break label332;
              }
              f.this.frx.z(af.juS.jqS, true);
              f.this.frx.dD(false);
              f.this.mlP = new com.tencent.qqpinyin.voicerecoapi.c(f.f(f.this));
              i = f.this.mlP.inR();
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
        f.this.frx.z(5, false);
        continue;
        label347:
        f.this.frx.fsk = f.h(f.this);
        if (!f.this.frx.aeU())
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
    
    public abstract void brS();
    
    public abstract void brT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */