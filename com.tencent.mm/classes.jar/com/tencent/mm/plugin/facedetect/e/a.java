package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.api.b.a;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class a
{
  private static final String rmB;
  public static final String rmC;
  private static final String rmD;
  private static volatile a rmm;
  public com.tencent.mm.remoteservice.d giA;
  private com.tencent.mm.plugin.mmsight.model.a.d juo;
  private String mFilePath;
  private final Object mLock;
  public b rmA;
  private d.b rmE;
  private d.a rmF;
  public ap rmn;
  private final int rmo;
  private final int rmp;
  private final int rmq;
  private a rmr;
  private int rms;
  private boolean rmt;
  private int rmu;
  public boolean rmv;
  private b rmw;
  private int rmx;
  private int rmy;
  private String rmz;
  
  static
  {
    AppMethodBeat.i(104090);
    rmm = null;
    rmB = p.ctl() + '/' + "fdv_";
    rmC = p.ctl() + '/' + "video_temp_test.mp4";
    rmD = p.ctl() + '/' + "fdv_t_";
    AppMethodBeat.o(104090);
  }
  
  private a()
  {
    AppMethodBeat.i(104078);
    this.mLock = new Object();
    this.rmn = null;
    this.rmo = 960;
    this.rmp = 540;
    this.rmq = 15;
    this.rmr = a.rmX;
    this.rms = 0;
    this.rmt = false;
    this.rmu = 0;
    this.rmv = false;
    this.rmw = null;
    this.rmx = -1;
    this.rmy = -1;
    this.mFilePath = "";
    this.rmz = "";
    this.giA = new com.tencent.mm.remoteservice.d(aj.getContext());
    this.rmA = b.vMU.aVk();
    this.rmE = new d.b()
    {
      public final void bm(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104073);
        a.this.bn(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104073);
      }
      
      public final com.tencent.mm.memory.a<byte[]> csP()
      {
        return k.vQc;
      }
    };
    this.rmF = new d.a()
    {
      public final void aVt()
      {
        AppMethodBeat.i(104063);
        ad.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", new Object[] { Integer.valueOf(1) });
        a.s(a.this).postToWorker(new Runnable()
        {
          /* Error */
          public final void run()
          {
            // Byte code:
            //   0: ldc 28
            //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: aload_0
            //   6: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:rmR	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   9: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:rmO	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   12: invokestatic 44	com/tencent/mm/plugin/facedetect/e/a:g	(Lcom/tencent/mm/plugin/facedetect/e/a;)Lcom/tencent/mm/plugin/mmsight/model/a/d;
            //   15: ifnull +18 -> 33
            //   18: aload_0
            //   19: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:rmR	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   22: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:rmO	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   25: invokestatic 44	com/tencent/mm/plugin/facedetect/e/a:g	(Lcom/tencent/mm/plugin/facedetect/e/a;)Lcom/tencent/mm/plugin/mmsight/model/a/d;
            //   28: invokeinterface 49 1 0
            //   33: aload_0
            //   34: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:rmR	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   37: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:rmO	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   40: invokestatic 53	com/tencent/mm/plugin/facedetect/e/a:d	(Lcom/tencent/mm/plugin/facedetect/e/a;)V
            //   43: aload_0
            //   44: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:rmR	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   47: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:rmO	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   50: invokestatic 57	com/tencent/mm/plugin/facedetect/e/a:a	(Lcom/tencent/mm/plugin/facedetect/e/a;)Ljava/lang/Object;
            //   53: astore_1
            //   54: aload_1
            //   55: monitorenter
            //   56: aload_0
            //   57: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:rmR	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   60: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:rmO	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   63: getstatic 63	com/tencent/mm/plugin/facedetect/e/a$a:rmY	Lcom/tencent/mm/plugin/facedetect/e/a$a;
            //   66: invokestatic 66	com/tencent/mm/plugin/facedetect/e/a:a	(Lcom/tencent/mm/plugin/facedetect/e/a;Lcom/tencent/mm/plugin/facedetect/e/a$a;)Lcom/tencent/mm/plugin/facedetect/e/a$a;
            //   69: pop
            //   70: aload_1
            //   71: monitorexit
            //   72: invokestatic 72	com/tencent/mm/plugin/facedetect/model/FaceContextData:csQ	()Lcom/tencent/mm/plugin/facedetect/model/FaceContextData;
            //   75: ifnull +17 -> 92
            //   78: invokestatic 72	com/tencent/mm/plugin/facedetect/model/FaceContextData:csQ	()Lcom/tencent/mm/plugin/facedetect/model/FaceContextData;
            //   81: getfield 76	com/tencent/mm/plugin/facedetect/model/FaceContextData:rhg	J
            //   84: iconst_2
            //   85: aload_0
            //   86: getfield 21	com/tencent/mm/plugin/facedetect/e/a$2$1:jqX	I
            //   89: invokestatic 82	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:h	(JII)V
            //   92: ldc 28
            //   94: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   97: return
            //   98: astore_1
            //   99: ldc 87
            //   101: ldc 89
            //   103: iconst_1
            //   104: anewarray 4	java/lang/Object
            //   107: dup
            //   108: iconst_0
            //   109: aload_1
            //   110: invokevirtual 93	java/lang/Exception:getMessage	()Ljava/lang/String;
            //   113: aastore
            //   114: invokestatic 99	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
            //   117: aload_0
            //   118: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:rmR	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   121: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:rmO	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   124: invokestatic 53	com/tencent/mm/plugin/facedetect/e/a:d	(Lcom/tencent/mm/plugin/facedetect/e/a;)V
            //   127: goto -84 -> 43
            //   130: astore_1
            //   131: aload_0
            //   132: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:rmR	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   135: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:rmO	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   138: invokestatic 53	com/tencent/mm/plugin/facedetect/e/a:d	(Lcom/tencent/mm/plugin/facedetect/e/a;)V
            //   141: ldc 28
            //   143: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   146: aload_1
            //   147: athrow
            //   148: astore_2
            //   149: aload_1
            //   150: monitorexit
            //   151: ldc 28
            //   153: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   156: aload_2
            //   157: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	158	0	this	1
            //   98	12	1	localException	java.lang.Exception
            //   130	20	1	localObject2	Object
            //   148	9	2	localObject3	Object
            // Exception table:
            //   from	to	target	type
            //   5	33	98	java/lang/Exception
            //   5	33	130	finally
            //   99	117	130	finally
            //   56	72	148	finally
            //   149	151	148	finally
          }
        });
        AppMethodBeat.o(104063);
      }
    };
    this.rmn = new ap("face_video_handler");
    AppMethodBeat.o(104078);
  }
  
  private VideoTransPara bhD()
  {
    AppMethodBeat.i(104086);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = this.rmx;
    localVideoTransPara.height = this.rmy;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 1200000;
    localVideoTransPara.hmx = 10;
    localVideoTransPara.audioBitrate = 64000;
    localVideoTransPara.hVe = 2;
    localVideoTransPara.hVf = 1;
    localVideoTransPara.audioSampleRate = 16000;
    localVideoTransPara.duration = 15;
    AppMethodBeat.o(104086);
    return localVideoTransPara;
  }
  
  public static a ctV()
  {
    AppMethodBeat.i(104079);
    if (rmm == null) {
      try
      {
        if (rmm == null) {
          rmm = new a();
        }
        a locala1 = rmm;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(104079);
      }
    }
    a locala2 = rmm;
    AppMethodBeat.o(104079);
    return locala2;
  }
  
  public final boolean PP()
  {
    AppMethodBeat.i(104082);
    ad.e("MicroMsg.FaceVideoRecorder", "carson: start Record Video");
    this.rmn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104069);
        synchronized (a.a(a.this))
        {
          if (a.n(a.this) == a.a.rmX)
          {
            ad.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
            a.d(a.this);
            AppMethodBeat.o(104069);
            return;
          }
          if (a.n(a.this) == a.a.rmZ)
          {
            ad.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
            AppMethodBeat.o(104069);
            return;
          }
          ad.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
          com.tencent.mm.plugin.facedetect.model.d.csO().a(a.o(a.this));
          a.g(a.this).b(a.k(a.this), a.p(a.this), a.q(a.this));
          a.a(a.this, a.a.rmZ);
          AppMethodBeat.o(104069);
          return;
        }
      }
    });
    AppMethodBeat.o(104082);
    return true;
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(104084);
    ad.e("MicroMsg.FaceVideoRecorder", "carson: stop Record Video");
    this.rmn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104072);
        synchronized (a.a(a.this))
        {
          a.a(a.this, paramb);
          if (a.n(a.this) == a.a.rmX)
          {
            ad.e("MicroMsg.FaceVideoRecorder", "hy: not initialized. should not happen");
            a.d(a.this);
            if (a.r(a.this) != null) {
              a.r(a.this).afY(null);
            }
            AppMethodBeat.o(104072);
            return;
          }
          if ((a.n(a.this) == a.a.rnc) || (a.n(a.this) == a.a.rmY))
          {
            ad.w("MicroMsg.FaceVideoRecorder", "hy: cancelled or not started capturing.");
            a.d(a.this);
            if (a.r(a.this) != null) {
              a.r(a.this).afY(null);
            }
            AppMethodBeat.o(104072);
            return;
          }
          if (a.n(a.this) == a.a.rnb)
          {
            ad.i("MicroMsg.FaceVideoRecorder", "hy: already stopped");
            if (a.r(a.this) != null) {
              a.r(a.this).afY(a.g(a.this).getFilePath());
            }
            AppMethodBeat.o(104072);
            return;
          }
          if (a.n(a.this) == a.a.rna)
          {
            ad.i("MicroMsg.FaceVideoRecorder", "hy: stopping. wait");
            AppMethodBeat.o(104072);
            return;
          }
          ad.i("MicroMsg.FaceVideoRecorder", "hy: stop record and release" + Thread.currentThread().getName());
          com.tencent.mm.plugin.facedetect.model.d.csO().b(a.o(a.this));
          a.a(a.this, a.a.rna);
          a.g(a.this).D(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104071);
              synchronized (a.a(a.this))
              {
                ad.i("MicroMsg.FaceVideoRecorder", "carson: begin to stop" + a.g(a.this).getFilePath());
                a.a(a.this, a.a.rnb);
                i.deleteFile(a.h(a.this));
                if (a.r(a.this) != null) {
                  a.r(a.this).afY(a.g(a.this).getFilePath());
                }
                AppMethodBeat.o(104071);
                return;
              }
            }
          });
          AppMethodBeat.o(104072);
          return;
        }
      }
    });
    AppMethodBeat.o(104084);
  }
  
  public final boolean a(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final boolean paramBoolean)
  {
    AppMethodBeat.i(104080);
    ad.i("MicroMsg.FaceVideoRecorder", "hy: init record");
    ad.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, acceptVoiceFromOutside: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.FALSE, Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    VideoTransPara localVideoTransPara = bhD();
    this.rmA.a(this.giA, localVideoTransPara);
    this.rmn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104061);
        if ((paramInt1 == 90) || (paramInt1 == 270))
        {
          ad.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
          a.a(a.this, paramInt3);
          a.b(a.this, paramInt2);
        }
        synchronized (a.a(a.this))
        {
          a.c(a.this, paramInt1);
          a.a(a.this, this.rmJ);
          a.d(a.this, this.rmK);
          a.b(a.this);
          a.c(a.this);
          a.d(a.this);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104060);
              final long l = bt.HI();
              a.m(a.this).connect(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(104059);
                  synchronized (a.a(a.this))
                  {
                    ad.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", new Object[] { Long.valueOf(bt.aO(l)) });
                    long l = bt.HI();
                    a.a(a.this, a.e(a.this).aVj());
                    a.g(a.this).setFilePath(a.f(a.this));
                    a.g(a.this).yo(a.h(a.this));
                    a.g(a.this).es(a.1.this.rmL);
                    a.g(a.this).s(a.i(a.this), a.j(a.this), a.1.this.rmM, a.1.this.rmN);
                    a.g(a.this).od(a.k(a.this));
                    a.g(a.this).a(a.l(a.this));
                    a.a(a.this, a.a.rmY);
                    ad.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[] { Long.valueOf(bt.aO(l)) });
                    AppMethodBeat.o(104059);
                    return;
                  }
                }
              });
              AppMethodBeat.o(104060);
            }
          });
          AppMethodBeat.o(104061);
          return;
          a.a(a.this, paramInt2);
          a.b(a.this, paramInt3);
        }
      }
    });
    AppMethodBeat.o(104080);
    return true;
  }
  
  public final void bn(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104085);
    this.rmn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104074);
        SightVideoJNI.mirrorCameraData(paramArrayOfByte, a.i(a.this), a.j(a.this), false);
        if (a.g(a.this).getFrameDataCallback() != null) {
          a.g(a.this).getFrameDataCallback().U(paramArrayOfByte);
        }
        AppMethodBeat.o(104074);
      }
    });
    AppMethodBeat.o(104085);
  }
  
  public final c.a ctW()
  {
    AppMethodBeat.i(104081);
    if (this.juo != null)
    {
      c.a locala = this.juo.axZ();
      AppMethodBeat.o(104081);
      return locala;
    }
    ad.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
    AppMethodBeat.o(104081);
    return null;
  }
  
  public final void ctX()
  {
    AppMethodBeat.i(104083);
    ad.e("MicroMsg.FaceVideoRecorder", "carson: cancel Record Video");
    this.rmn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104070);
        synchronized (a.a(a.this))
        {
          if (a.n(a.this) == a.a.rmX)
          {
            ad.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
            a.d(a.this);
            AppMethodBeat.o(104070);
            return;
          }
          ad.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
          a.g(a.this).cancel();
          a.d(a.this);
          com.tencent.mm.plugin.facedetect.model.d.csO().b(a.o(a.this));
          a.a(a.this, a.a.rnc);
          a.m(a.this).release();
          AppMethodBeat.o(104070);
          return;
        }
      }
    });
    AppMethodBeat.o(104083);
  }
  
  public final a ctY()
  {
    synchronized (this.mLock)
    {
      a locala = this.rmr;
      return locala;
    }
  }
  
  public final boolean isStarted()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.rmr == a.rmZ)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(104077);
      rmX = new a("UNINITIALIZED", 0);
      rmY = new a("INITIALIZED", 1);
      rmZ = new a("STARTED", 2);
      rna = new a("STOPPING", 3);
      rnb = new a("STOPPED", 4);
      rnc = new a("CANCELLED", 5);
      rnd = new a[] { rmX, rmY, rmZ, rna, rnb, rnc };
      AppMethodBeat.o(104077);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void afY(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a
 * JD-Core Version:    0.7.0.1
 */