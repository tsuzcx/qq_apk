package com.tencent.mm.plugin.facedetect.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static final String sRP;
  public static final String sRT;
  private com.tencent.mm.audio.b.c dyI;
  private com.tencent.mm.audio.b.c.a dzv;
  private final ArrayList<com.tencent.mm.audio.b.c.a> eN;
  private com.tencent.mm.modelvoiceaddr.a.c jwB;
  private com.tencent.mm.modelvoiceaddr.a.c.a jwC;
  private int jwf;
  private int jwg;
  private com.tencent.mm.audio.e.a jwl;
  private boolean jxb;
  b sRQ;
  private boolean sRR;
  private String sRS;
  public com.tencent.mm.audio.b.c.a sRU;
  
  static
  {
    AppMethodBeat.i(103814);
    sRP = p.cTh() + "/fdv_v_";
    sRT = g.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx";
    AppMethodBeat.o(103814);
  }
  
  public a()
  {
    AppMethodBeat.i(103811);
    this.sRQ = null;
    this.jxb = true;
    this.sRR = false;
    this.sRS = "";
    this.eN = new ArrayList(5);
    this.jwg = 0;
    this.jwf = 0;
    this.sRU = new com.tencent.mm.audio.b.c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(103803);
        synchronized (a.i(a.this))
        {
          Iterator localIterator = a.i(a.this).iterator();
          while (localIterator.hasNext())
          {
            com.tencent.mm.audio.b.c.a locala = (com.tencent.mm.audio.b.c.a)localIterator.next();
            if (locala != null) {
              locala.cj(paramAnonymousInt1, paramAnonymousInt2);
            }
          }
        }
        AppMethodBeat.o(103803);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(103802);
        synchronized (a.i(a.this))
        {
          Iterator localIterator = a.i(a.this).iterator();
          while (localIterator.hasNext())
          {
            com.tencent.mm.audio.b.c.a locala = (com.tencent.mm.audio.b.c.a)localIterator.next();
            if (locala != null) {
              locala.w(paramAnonymousArrayOfByte, paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(103802);
      }
    };
    this.dzv = new com.tencent.mm.audio.b.c.a()
    {
      short[] jwD;
      
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(103805);
        Log.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + paramAnonymousInt1 + " detailState = " + paramAnonymousInt2);
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
        Log.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i;
        if (this.jwD != null)
        {
          i = j;
          if (this.jwD.length >= paramAnonymousInt / 2) {}
        }
        else
        {
          this.jwD = new short[paramAnonymousInt / 2];
          i = j;
        }
        while (i < paramAnonymousInt / 2)
        {
          this.jwD[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        a.a(a.this, this.jwD, paramAnonymousInt / 2);
        if (a.g(a.this) != null)
        {
          a.g(a.this).e(this.jwD, paramAnonymousInt / 2);
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
            Log.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
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
          Log.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
          AppMethodBeat.o(103804);
          return;
        }
      }
    };
    this.jwC = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      public final void Yh()
      {
        AppMethodBeat.i(103809);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
        if (a.e(a.this) != null) {
          a.e(a.this).onError(11);
        }
        AppMethodBeat.o(103809);
      }
      
      public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(103806);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[] { paramAnonymousArrayOfShort, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(103806);
      }
      
      public final void bix()
      {
        AppMethodBeat.i(103807);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        AppMethodBeat.o(103807);
      }
      
      public final void biy()
      {
        AppMethodBeat.i(103808);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
        if (a.e(a.this) != null) {
          a.e(a.this).cTp();
        }
        AppMethodBeat.o(103808);
      }
    };
    AppMethodBeat.o(103811);
  }
  
  public final void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(186371);
    Log.i("MicroMsg.FaceVoiceRecordLogic", "start record");
    ThreadPool.post(new a(paramRunnable, (byte)0), "FaceVoice_record", 10);
    AppMethodBeat.o(186371);
  }
  
  public final void b(com.tencent.mm.audio.b.c.a parama)
  {
    AppMethodBeat.i(103813);
    synchronized (this.eN)
    {
      this.eN.add(parama);
      AppMethodBeat.o(103813);
      return;
    }
  }
  
  public final void c(com.tencent.mm.audio.b.c.a parama)
  {
    AppMethodBeat.i(186374);
    synchronized (this.eN)
    {
      this.eN.remove(parama);
      AppMethodBeat.o(186374);
      return;
    }
  }
  
  public final byte[] cTo()
  {
    AppMethodBeat.i(186373);
    byte[] arrayOfByte = s.aW(this.sRS, -1, -1);
    AppMethodBeat.o(186373);
    return arrayOfByte;
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(103812);
    s.deleteFile(this.sRS);
    AppMethodBeat.o(103812);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(186370);
    Log.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
    this.sRQ = null;
    AppMethodBeat.o(186370);
  }
  
  /* Error */
  public final void stopRecord()
  {
    // Byte code:
    //   0: ldc 208
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_1
    //   7: putfield 100	com/tencent/mm/plugin/facedetect/d/a:sRR	Z
    //   10: ldc 157
    //   12: ldc 210
    //   14: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 128	com/tencent/mm/plugin/facedetect/d/a:dyI	Lcom/tencent/mm/audio/b/c;
    //   23: ifnull +16 -> 39
    //   26: aload_0
    //   27: getfield 128	com/tencent/mm/plugin/facedetect/d/a:dyI	Lcom/tencent/mm/audio/b/c;
    //   30: invokevirtual 216	com/tencent/mm/audio/b/c:ZZ	()Z
    //   33: pop
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 128	com/tencent/mm/plugin/facedetect/d/a:dyI	Lcom/tencent/mm/audio/b/c;
    //   39: aload_0
    //   40: getfield 131	com/tencent/mm/plugin/facedetect/d/a:jwl	Lcom/tencent/mm/audio/e/a;
    //   43: ifnull +17 -> 60
    //   46: aload_0
    //   47: getfield 131	com/tencent/mm/plugin/facedetect/d/a:jwl	Lcom/tencent/mm/audio/e/a;
    //   50: invokeinterface 221 1 0
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 131	com/tencent/mm/plugin/facedetect/d/a:jwl	Lcom/tencent/mm/audio/e/a;
    //   60: aload_0
    //   61: getfield 134	com/tencent/mm/plugin/facedetect/d/a:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +20 -> 86
    //   69: aload_0
    //   70: getfield 134	com/tencent/mm/plugin/facedetect/d/a:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   73: invokevirtual 226	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 134	com/tencent/mm/plugin/facedetect/d/a:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 98	com/tencent/mm/plugin/facedetect/d/a:jxb	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 112	com/tencent/mm/plugin/facedetect/d/a:jwg	I
    //   91: aload_0
    //   92: monitorexit
    //   93: ldc 208
    //   95: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_1
    //   100: ldc 157
    //   102: aload_1
    //   103: ldc 228
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: goto -26 -> 86
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: ldc 208
    //   120: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	a
    //   64	2	1	localc	com.tencent.mm.modelvoiceaddr.a.c
    //   99	4	1	localException	Exception
    //   115	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	86	99	java/lang/Exception
    //   19	39	115	finally
    //   39	60	115	finally
    //   60	65	115	finally
    //   69	86	115	finally
    //   86	93	115	finally
    //   100	112	115	finally
    //   116	118	115	finally
  }
  
  final class a
    implements Runnable
  {
    private Runnable sRW = null;
    
    private a(Runnable paramRunnable)
    {
      this.sRW = paramRunnable;
    }
    
    public final void run()
    {
      AppMethodBeat.i(103810);
      for (;;)
      {
        synchronized (a.this)
        {
          if (a.b(a.this)) {
            break label572;
          }
          Log.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
          a.a(a.this, a.sRP + Util.currentTicks() + ".spx");
          Log.i("MicroMsg.FaceVoiceRecordLogic", "generateVoiceFilePath: %s", new Object[] { a.a(a.this) });
          try
          {
            s.deleteFile(a.a(a.this));
            a.a(a.this, new com.tencent.mm.audio.b.c(16000, 1, 3));
            a.c(a.this).dzk = -19;
            a.c(a.this).dc(false);
            a.a(a.this, new d());
            if (!a.d(a.this).hz(a.a(a.this)))
            {
              Log.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
              a.d(a.this).abP();
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
            Log.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", localException, "hy: delete file failed", new Object[0]);
            continue;
          }
        }
        if (ae.gKE.gGG > 0)
        {
          a.c(a.this).x(ae.gKE.gGG, true);
          a.c(a.this).jk(50);
          a.c(a.this).dd(false);
        }
        try
        {
          a.a(a.this, new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.sp.getFloat("s_n_ration", 2.5F), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_delay_time", 20), false, false));
          a.g(a.this).jxj = a.f(a.this);
          a.c(a.this).dzv = a.this.sRU;
          a.this.b(a.h(a.this));
          if (!a.c(a.this).aai())
          {
            Log.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
            if (a.e(a.this) == null) {
              continue;
            }
            a.e(a.this).onError(7);
            continue;
            a.c(a.this).x(5, false);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + localThrowable.getMessage());
            if (a.e(a.this) != null) {
              a.e(a.this).onError(6);
            }
          }
        }
        if (this.sRW != null)
        {
          this.sRW.run();
          continue;
          label572:
          Log.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cTp();
    
    public abstract void onError(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a
 * JD-Core Version:    0.7.0.1
 */