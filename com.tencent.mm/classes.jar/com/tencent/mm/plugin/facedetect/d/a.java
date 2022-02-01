package com.tencent.mm.plugin.facedetect.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.File;
import java.util.ArrayList;

public final class a
{
  private static final String pPQ;
  public static final String pPV;
  com.tencent.mm.audio.b.c cXI;
  private com.tencent.mm.audio.b.c.a cYv;
  boolean hEX;
  private int hEb;
  int hEc;
  com.tencent.mm.audio.e.a hEh;
  com.tencent.mm.modelvoiceaddr.a.c hEx;
  private com.tencent.mm.modelvoiceaddr.a.c.a hEy;
  b pPR;
  boolean pPS;
  String pPT;
  ArrayList<com.tencent.mm.audio.b.c.a> pPU;
  public com.tencent.mm.audio.b.c.a pPW;
  
  static
  {
    AppMethodBeat.i(103814);
    pPQ = p.cfZ() + "/fdv_v_";
    pPV = g.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx";
    AppMethodBeat.o(103814);
  }
  
  public a()
  {
    AppMethodBeat.i(103811);
    this.pPR = null;
    this.hEX = true;
    this.pPS = false;
    this.pPT = "";
    this.pPU = new ArrayList(5);
    this.hEc = 0;
    this.hEb = 0;
    this.pPW = new a.1(this);
    this.cYv = new com.tencent.mm.audio.b.c.a()
    {
      short[] hEz;
      
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(103805);
        ad.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + paramAnonymousInt1 + " detailState = " + paramAnonymousInt2);
        a.this.clearDiskCache();
        if (a.e(a.this) != null) {
          a.e(a.this).onError(2);
        }
        AppMethodBeat.o(103805);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(103804);
        ad.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i;
        if (this.hEz != null)
        {
          i = j;
          if (this.hEz.length >= paramAnonymousInt / 2) {}
        }
        else
        {
          this.hEz = new short[paramAnonymousInt / 2];
          i = j;
        }
        while (i < paramAnonymousInt / 2)
        {
          this.hEz[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        a.a(a.this, this.hEz, paramAnonymousInt / 2);
        if (a.g(a.this) != null)
        {
          a.g(a.this).e(this.hEz, paramAnonymousInt / 2);
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
            ad.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
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
          ad.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
          AppMethodBeat.o(103804);
          return;
        }
      }
    };
    this.hEy = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      public final void Mq()
      {
        AppMethodBeat.i(103809);
        ad.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
        if (a.e(a.this) != null) {
          a.e(a.this).onError(11);
        }
        AppMethodBeat.o(103809);
      }
      
      public final void aDS()
      {
        AppMethodBeat.i(103807);
        ad.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        AppMethodBeat.o(103807);
      }
      
      public final void aDT()
      {
        AppMethodBeat.i(103808);
        ad.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
        if (a.e(a.this) != null) {
          a.e(a.this).cgg();
        }
        AppMethodBeat.o(103808);
      }
      
      public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(103806);
        ad.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[] { paramAnonymousArrayOfShort, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(103806);
      }
    };
    AppMethodBeat.o(103811);
  }
  
  public final void b(com.tencent.mm.audio.b.c.a parama)
  {
    AppMethodBeat.i(103813);
    this.pPU.add(parama);
    AppMethodBeat.o(103813);
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(103812);
    i.deleteFile(this.pPT);
    AppMethodBeat.o(103812);
  }
  
  final class a
    implements Runnable
  {
    private Runnable pPY = null;
    
    private a(Runnable paramRunnable)
    {
      this.pPY = paramRunnable;
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
          ad.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
          a.a(a.this, a.pPQ + bt.GC() + ".spx");
          try
          {
            i.deleteFile(a.b(a.this));
            a.a(a.this, new com.tencent.mm.audio.b.c(16000, 1, 3));
            a.c(a.this).cYk = -19;
            a.c(a.this).cr(false);
            a.a(a.this, new d());
            if (!a.d(a.this).fR(a.b(a.this)))
            {
              ad.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
              a.d(a.this).PQ();
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
            ad.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", localException, "hy: delete file failed", new Object[0]);
            continue;
          }
        }
        if (ae.fFH.fCb > 0)
        {
          a.c(a.this).t(ae.fFH.fCb, true);
          a.c(a.this).hX(50);
          a.c(a.this).cs(false);
        }
        try
        {
          a.a(a.this, new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.sp.getFloat("s_n_ration", 2.5F), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_delay_time", 20), false, false));
          a.g(a.this).hFf = a.f(a.this);
          a.c(a.this).cYv = a.this.pPW;
          a.this.b(a.h(a.this));
          if (!a.c(a.this).Ok())
          {
            ad.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
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
            ad.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + localThrowable.getMessage());
            if (a.e(a.this) != null) {
              a.e(a.this).onError(6);
            }
          }
        }
        if (this.pPY != null)
        {
          this.pPY.run();
          continue;
          label551:
          ad.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cgg();
    
    public abstract void onError(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a
 * JD-Core Version:    0.7.0.1
 */