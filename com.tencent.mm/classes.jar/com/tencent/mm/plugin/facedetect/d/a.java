package com.tencent.mm.plugin.facedetect.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.ArrayList;

public final class a
{
  private static final String mjf;
  public static final String mjk;
  com.tencent.mm.audio.b.c ciR;
  private com.tencent.mm.audio.b.c.a cjD;
  com.tencent.mm.modelvoiceaddr.a.c gbF;
  private com.tencent.mm.modelvoiceaddr.a.c.a gbG;
  private int gbq;
  int gbr;
  com.tencent.mm.audio.e.a gbw;
  boolean gcf;
  a.b mjg;
  boolean mjh;
  String mji;
  ArrayList<com.tencent.mm.audio.b.c.a> mjj;
  public com.tencent.mm.audio.b.c.a mjl;
  
  static
  {
    AppMethodBeat.i(295);
    mjf = p.buG() + "/fdv_v_";
    mjk = h.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx";
    AppMethodBeat.o(295);
  }
  
  public a()
  {
    AppMethodBeat.i(292);
    this.mjg = null;
    this.gcf = true;
    this.mjh = false;
    this.mji = "";
    this.mjj = new ArrayList(5);
    this.gbr = 0;
    this.gbq = 0;
    this.mjl = new a.1(this);
    this.cjD = new a.2(this);
    this.gbG = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      public final void CO()
      {
        AppMethodBeat.i(290);
        ab.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
        if (a.e(a.this) != null) {
          a.e(a.this).onError(11);
        }
        AppMethodBeat.o(290);
      }
      
      public final void amM()
      {
        AppMethodBeat.i(288);
        ab.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        AppMethodBeat.o(288);
      }
      
      public final void amN()
      {
        AppMethodBeat.i(289);
        ab.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
        if (a.e(a.this) != null) {
          a.e(a.this).buM();
        }
        AppMethodBeat.o(289);
      }
      
      public final void c(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(287);
        ab.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[] { paramAnonymousArrayOfShort, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(287);
      }
    };
    AppMethodBeat.o(292);
  }
  
  public final void a(com.tencent.mm.audio.b.c.a parama)
  {
    AppMethodBeat.i(294);
    this.mjj.add(parama);
    AppMethodBeat.o(294);
  }
  
  public final void buL()
  {
    AppMethodBeat.i(293);
    e.deleteFile(this.mji);
    AppMethodBeat.o(293);
  }
  
  final class a
    implements Runnable
  {
    private Runnable mjn = null;
    
    private a(Runnable paramRunnable)
    {
      this.mjn = paramRunnable;
    }
    
    public final void run()
    {
      AppMethodBeat.i(291);
      for (;;)
      {
        synchronized (a.this)
        {
          if (a.a(a.this)) {
            break label554;
          }
          ab.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
          a.a(a.this, a.mjf + bo.yB() + ".spx");
          try
          {
            e.deleteFile(a.b(a.this));
            a.a(a.this, new com.tencent.mm.audio.b.c(16000, 1, 3));
            a.c(a.this).cjs = -19;
            a.c(a.this).bz(false);
            a.a(a.this, new d());
            if (!a.d(a.this).eN(a.b(a.this)))
            {
              ab.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
              a.d(a.this).Fb();
              a.a(a.this, null);
              if (a.e(a.this) != null) {
                a.e(a.this).onError(5);
              }
              AppMethodBeat.o(291);
              return;
            }
          }
          catch (Exception localException)
          {
            ab.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", localException, "hy: delete file failed", new Object[0]);
            continue;
          }
        }
        if (ac.erF.eoW > 0)
        {
          a.c(a.this).t(ac.erF.eoW, true);
          a.c(a.this).gA(50);
          a.c(a.this).bA(false);
        }
        try
        {
          a.a(a.this, new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.sp.getFloat("s_n_ration", 2.5F), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_delay_time", 20), false, false));
          a.g(a.this).gcn = a.f(a.this);
          a.c(a.this).cjD = a.this.mjl;
          a.this.a(a.h(a.this));
          if (!a.c(a.this).EC())
          {
            ab.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
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
            ab.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + localThrowable.getMessage());
            if (a.e(a.this) != null) {
              a.e(a.this).onError(6);
            }
          }
        }
        if (this.mjn != null)
        {
          this.mjn.run();
          continue;
          label554:
          ab.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a
 * JD-Core Version:    0.7.0.1
 */