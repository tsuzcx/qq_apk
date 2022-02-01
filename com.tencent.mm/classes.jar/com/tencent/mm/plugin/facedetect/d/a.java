package com.tencent.mm.plugin.facedetect.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.File;
import java.util.ArrayList;

public final class a
{
  public static final String qyD;
  private static final String qyy;
  private com.tencent.mm.audio.b.c.a cVR;
  com.tencent.mm.audio.b.c cVe;
  private int ieD;
  int ieE;
  com.tencent.mm.audio.e.a ieJ;
  com.tencent.mm.modelvoiceaddr.a.c ieZ;
  private com.tencent.mm.modelvoiceaddr.a.c.a ifa;
  boolean ifz;
  boolean qyA;
  String qyB;
  ArrayList<com.tencent.mm.audio.b.c.a> qyC;
  public com.tencent.mm.audio.b.c.a qyE;
  b qyz;
  
  static
  {
    AppMethodBeat.i(103814);
    qyy = p.cnG() + "/fdv_v_";
    qyD = g.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx";
    AppMethodBeat.o(103814);
  }
  
  public a()
  {
    AppMethodBeat.i(103811);
    this.qyz = null;
    this.ifz = true;
    this.qyA = false;
    this.qyB = "";
    this.qyC = new ArrayList(5);
    this.ieE = 0;
    this.ieD = 0;
    this.qyE = new a.1(this);
    this.cVR = new com.tencent.mm.audio.b.c.a()
    {
      short[] ifb;
      
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(103805);
        ac.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + paramAnonymousInt1 + " detailState = " + paramAnonymousInt2);
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
        ac.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i;
        if (this.ifb != null)
        {
          i = j;
          if (this.ifb.length >= paramAnonymousInt / 2) {}
        }
        else
        {
          this.ifb = new short[paramAnonymousInt / 2];
          i = j;
        }
        while (i < paramAnonymousInt / 2)
        {
          this.ifb[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        a.a(a.this, this.ifb, paramAnonymousInt / 2);
        if (a.g(a.this) != null)
        {
          a.g(a.this).e(this.ifb, paramAnonymousInt / 2);
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
            ac.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
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
          ac.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
          AppMethodBeat.o(103804);
          return;
        }
      }
    };
    this.ifa = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      public final void Mo()
      {
        AppMethodBeat.i(103809);
        ac.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
        if (a.e(a.this) != null) {
          a.e(a.this).onError(11);
        }
        AppMethodBeat.o(103809);
      }
      
      public final void aKJ()
      {
        AppMethodBeat.i(103807);
        ac.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        AppMethodBeat.o(103807);
      }
      
      public final void aKK()
      {
        AppMethodBeat.i(103808);
        ac.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
        if (a.e(a.this) != null) {
          a.e(a.this).cnN();
        }
        AppMethodBeat.o(103808);
      }
      
      public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(103806);
        ac.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[] { paramAnonymousArrayOfShort, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(103806);
      }
    };
    AppMethodBeat.o(103811);
  }
  
  public final void b(com.tencent.mm.audio.b.c.a parama)
  {
    AppMethodBeat.i(103813);
    this.qyC.add(parama);
    AppMethodBeat.o(103813);
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(103812);
    i.deleteFile(this.qyB);
    AppMethodBeat.o(103812);
  }
  
  final class a
    implements Runnable
  {
    private Runnable qyG = null;
    
    private a(Runnable paramRunnable)
    {
      this.qyG = paramRunnable;
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
          ac.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
          a.a(a.this, a.qyy + bs.Gn() + ".spx");
          try
          {
            i.deleteFile(a.b(a.this));
            a.a(a.this, new com.tencent.mm.audio.b.c(16000, 1, 3));
            a.c(a.this).cVG = -19;
            a.c(a.this).cs(false);
            a.a(a.this, new d());
            if (!a.d(a.this).fH(a.b(a.this)))
            {
              ac.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
              a.d(a.this).PM();
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
            ac.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", localException, "hy: delete file failed", new Object[0]);
            continue;
          }
        }
        if (ae.fJo.fFI > 0)
        {
          a.c(a.this).t(ae.fJo.fFI, true);
          a.c(a.this).hH(50);
          a.c(a.this).ct(false);
        }
        try
        {
          a.a(a.this, new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.sp.getFloat("s_n_ration", 2.5F), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_delay_time", 20), false, false));
          a.g(a.this).ifH = a.f(a.this);
          a.c(a.this).cVR = a.this.qyE;
          a.this.b(a.h(a.this));
          if (!a.c(a.this).Og())
          {
            ac.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
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
            ac.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + localThrowable.getMessage());
            if (a.e(a.this) != null) {
              a.e(a.this).onError(6);
            }
          }
        }
        if (this.qyG != null)
        {
          this.qyG.run();
          continue;
          label551:
          ac.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cnN();
    
    public abstract void onError(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a
 * JD-Core Version:    0.7.0.1
 */