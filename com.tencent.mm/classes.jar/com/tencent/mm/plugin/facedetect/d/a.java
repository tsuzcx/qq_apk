package com.tencent.mm.plugin.facedetect.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static final String rqs;
  public static final String rqw;
  com.tencent.mm.audio.b.c dhw;
  private com.tencent.mm.audio.b.c.a dij;
  ArrayList<com.tencent.mm.audio.b.c.a> eO;
  private int iAQ;
  int iAR;
  com.tencent.mm.audio.e.a iAW;
  boolean iBM;
  com.tencent.mm.modelvoiceaddr.a.c iBm;
  private com.tencent.mm.modelvoiceaddr.a.c.a iBn;
  b rqt;
  boolean rqu;
  String rqv;
  public com.tencent.mm.audio.b.c.a rqx;
  
  static
  {
    AppMethodBeat.i(103814);
    rqs = p.cuM() + "/fdv_v_";
    rqw = g.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx";
    AppMethodBeat.o(103814);
  }
  
  public a()
  {
    AppMethodBeat.i(103811);
    this.rqt = null;
    this.iBM = true;
    this.rqu = false;
    this.rqv = "";
    this.eO = new ArrayList(5);
    this.iAR = 0;
    this.iAQ = 0;
    this.rqx = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(103803);
        if (a.i(a.this) != null)
        {
          Iterator localIterator = a.i(a.this).iterator();
          while (localIterator.hasNext())
          {
            com.tencent.mm.audio.b.c.a locala = (com.tencent.mm.audio.b.c.a)localIterator.next();
            if (locala != null) {
              locala.ch(paramAnonymousInt1, paramAnonymousInt2);
            }
          }
        }
        AppMethodBeat.o(103803);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(103802);
        if (a.i(a.this) != null)
        {
          Iterator localIterator = a.i(a.this).iterator();
          while (localIterator.hasNext())
          {
            com.tencent.mm.audio.b.c.a locala = (com.tencent.mm.audio.b.c.a)localIterator.next();
            if (locala != null) {
              locala.u(paramAnonymousArrayOfByte, paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(103802);
      }
    };
    this.dij = new com.tencent.mm.audio.b.c.a()
    {
      short[] iBo;
      
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(103805);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + paramAnonymousInt1 + " detailState = " + paramAnonymousInt2);
        a.this.clearDiskCache();
        if (a.e(a.this) != null) {
          a.e(a.this).onError(2);
        }
        AppMethodBeat.o(103805);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(103804);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i;
        if (this.iBo != null)
        {
          i = j;
          if (this.iBo.length >= paramAnonymousInt / 2) {}
        }
        else
        {
          this.iBo = new short[paramAnonymousInt / 2];
          i = j;
        }
        while (i < paramAnonymousInt / 2)
        {
          this.iBo[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        a.a(a.this, this.iBo, paramAnonymousInt / 2);
        if (a.g(a.this) != null)
        {
          a.g(a.this).e(this.iBo, paramAnonymousInt / 2);
          if (a.d(a.this) == null) {
            break label270;
          }
        }
        label270:
        for (paramAnonymousInt = a.d(a.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if ((-1 == paramAnonymousInt) && (a.e(a.this) != null))
          {
            a.e(a.this).onError(3);
            a.this.clearDiskCache();
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
            AppMethodBeat.o(103804);
            return;
          }
          AppMethodBeat.o(103804);
          return;
          if (a.e(a.this) != null)
          {
            a.e(a.this).onError(1);
            a.this.clearDiskCache();
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
          AppMethodBeat.o(103804);
          return;
        }
      }
    };
    this.iBn = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      public final void NV()
      {
        AppMethodBeat.i(103809);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
        if (a.e(a.this) != null) {
          a.e(a.this).onError(11);
        }
        AppMethodBeat.o(103809);
      }
      
      public final void aOq()
      {
        AppMethodBeat.i(103807);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        AppMethodBeat.o(103807);
      }
      
      public final void aOr()
      {
        AppMethodBeat.i(103808);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
        if (a.e(a.this) != null) {
          a.e(a.this).cuT();
        }
        AppMethodBeat.o(103808);
      }
      
      public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(103806);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[] { paramAnonymousArrayOfShort, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(103806);
      }
    };
    AppMethodBeat.o(103811);
  }
  
  public final void b(com.tencent.mm.audio.b.c.a parama)
  {
    AppMethodBeat.i(103813);
    this.eO.add(parama);
    AppMethodBeat.o(103813);
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(103812);
    o.deleteFile(this.rqv);
    AppMethodBeat.o(103812);
  }
  
  final class a
    implements Runnable
  {
    private Runnable rqz = null;
    
    private a(Runnable paramRunnable)
    {
      this.rqz = paramRunnable;
    }
    
    public final void run()
    {
      AppMethodBeat.i(103810);
      for (;;)
      {
        synchronized (a.this)
        {
          if (a.a(a.this)) {
            break label551;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
          a.a(a.this, a.rqs + bu.HQ() + ".spx");
          try
          {
            o.deleteFile(a.b(a.this));
            a.a(a.this, new com.tencent.mm.audio.b.c(16000, 1, 3));
            a.c(a.this).dhY = -19;
            a.c(a.this).cu(false);
            a.a(a.this, new d());
            if (!a.d(a.this).gI(a.b(a.this)))
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
              a.d(a.this).Rx();
              a.a(a.this, null);
              if (a.e(a.this) != null) {
                a.e(a.this).onError(5);
              }
              AppMethodBeat.o(103810);
              return;
            }
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", localException, "hy: delete file failed", new Object[0]);
            continue;
          }
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbo > 0)
        {
          a.c(a.this).t(com.tencent.mm.compatible.deviceinfo.ae.geX.gbo, true);
          a.c(a.this).hQ(50);
          a.c(a.this).cv(false);
        }
        try
        {
          a.a(a.this, new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.sp.getFloat("s_n_ration", 2.5F), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_delay_time", 20), false, false));
          a.g(a.this).iBU = a.f(a.this);
          a.c(a.this).dij = a.this.rqx;
          a.this.b(a.h(a.this));
          if (!a.c(a.this).PO())
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
            if (a.e(a.this) == null) {
              continue;
            }
            a.e(a.this).onError(7);
            continue;
            a.c(a.this).t(5, false);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + localThrowable.getMessage());
            if (a.e(a.this) != null) {
              a.e(a.this).onError(6);
            }
          }
        }
        if (this.rqz != null)
        {
          this.rqz.run();
          continue;
          label551:
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cuT();
    
    public abstract void onError(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a
 * JD-Core Version:    0.7.0.1
 */