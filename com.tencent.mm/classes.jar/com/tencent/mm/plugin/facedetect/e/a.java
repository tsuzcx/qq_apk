package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.api.b.a;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public class a
{
  private static final String wAA;
  public static final String wAB;
  private static final String wAC;
  private static volatile a wAm;
  public com.tencent.mm.remoteservice.d jGJ;
  private String mFilePath;
  private final Object mLock;
  private com.tencent.mm.plugin.mmsight.model.a.d nqS;
  private boolean qoc;
  private d.b wAD;
  private d.a wAE;
  public MMHandler wAn;
  private final int wAo;
  private final int wAp;
  private final int wAq;
  private a wAr;
  private int wAs;
  private int wAt;
  public boolean wAu;
  private b wAv;
  private int wAw;
  private int wAx;
  private String wAy;
  public b wAz;
  
  static
  {
    AppMethodBeat.i(104090);
    wAm = null;
    wAA = p.dim() + '/' + "fdv_";
    wAB = p.dim() + '/' + "video_temp_test.mp4";
    wAC = p.dim() + '/' + "fdv_t_";
    AppMethodBeat.o(104090);
  }
  
  private a()
  {
    AppMethodBeat.i(104078);
    this.mLock = new Object();
    this.wAn = null;
    this.wAo = 960;
    this.wAp = 540;
    this.wAq = 15;
    this.wAr = a.wAW;
    this.wAs = 0;
    this.qoc = false;
    this.wAt = 0;
    this.wAu = false;
    this.wAv = null;
    this.wAw = -1;
    this.wAx = -1;
    this.mFilePath = "";
    this.wAy = "";
    this.jGJ = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    this.wAz = b.EYA.bBv();
    this.wAD = new d.b()
    {
      public final void bQ(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104073);
        a.this.bR(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104073);
      }
      
      public final com.tencent.mm.memory.a<byte[]> dhW()
      {
        return j.FbH;
      }
    };
    this.wAE = new d.a()
    {
      public final void bBE()
      {
        AppMethodBeat.i(104063);
        Log.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", new Object[] { Integer.valueOf(1) });
        a.s(a.this).postToWorker(new Runnable()
        {
          /* Error */
          public final void run()
          {
            // Byte code:
            //   0: ldc 28
            //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: aload_0
            //   6: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:wAQ	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   9: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:wAN	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   12: invokestatic 44	com/tencent/mm/plugin/facedetect/e/a:g	(Lcom/tencent/mm/plugin/facedetect/e/a;)Lcom/tencent/mm/plugin/mmsight/model/a/d;
            //   15: ifnull +18 -> 33
            //   18: aload_0
            //   19: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:wAQ	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   22: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:wAN	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   25: invokestatic 44	com/tencent/mm/plugin/facedetect/e/a:g	(Lcom/tencent/mm/plugin/facedetect/e/a;)Lcom/tencent/mm/plugin/mmsight/model/a/d;
            //   28: invokeinterface 49 1 0
            //   33: aload_0
            //   34: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:wAQ	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   37: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:wAN	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   40: invokestatic 53	com/tencent/mm/plugin/facedetect/e/a:d	(Lcom/tencent/mm/plugin/facedetect/e/a;)V
            //   43: aload_0
            //   44: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:wAQ	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   47: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:wAN	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   50: invokestatic 57	com/tencent/mm/plugin/facedetect/e/a:a	(Lcom/tencent/mm/plugin/facedetect/e/a;)Ljava/lang/Object;
            //   53: astore_1
            //   54: aload_1
            //   55: monitorenter
            //   56: aload_0
            //   57: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:wAQ	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   60: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:wAN	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   63: getstatic 63	com/tencent/mm/plugin/facedetect/e/a$a:wAX	Lcom/tencent/mm/plugin/facedetect/e/a$a;
            //   66: invokestatic 66	com/tencent/mm/plugin/facedetect/e/a:a	(Lcom/tencent/mm/plugin/facedetect/e/a;Lcom/tencent/mm/plugin/facedetect/e/a$a;)Lcom/tencent/mm/plugin/facedetect/e/a$a;
            //   69: pop
            //   70: aload_1
            //   71: monitorexit
            //   72: invokestatic 72	com/tencent/mm/plugin/facedetect/model/FaceContextData:dhX	()Lcom/tencent/mm/plugin/facedetect/model/FaceContextData;
            //   75: ifnull +17 -> 92
            //   78: invokestatic 72	com/tencent/mm/plugin/facedetect/model/FaceContextData:dhX	()Lcom/tencent/mm/plugin/facedetect/model/FaceContextData;
            //   81: getfield 76	com/tencent/mm/plugin/facedetect/model/FaceContextData:wwE	J
            //   84: iconst_2
            //   85: aload_0
            //   86: getfield 21	com/tencent/mm/plugin/facedetect/e/a$2$1:njO	I
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
            //   114: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
            //   117: aload_0
            //   118: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:wAQ	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   121: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:wAN	Lcom/tencent/mm/plugin/facedetect/e/a;
            //   124: invokestatic 53	com/tencent/mm/plugin/facedetect/e/a:d	(Lcom/tencent/mm/plugin/facedetect/e/a;)V
            //   127: goto -84 -> 43
            //   130: astore_1
            //   131: aload_0
            //   132: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:wAQ	Lcom/tencent/mm/plugin/facedetect/e/a$2;
            //   135: getfield 38	com/tencent/mm/plugin/facedetect/e/a$2:wAN	Lcom/tencent/mm/plugin/facedetect/e/a;
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
          }
        });
        AppMethodBeat.o(104063);
      }
    };
    this.wAn = new MMHandler("face_video_handler");
    AppMethodBeat.o(104078);
  }
  
  private VideoTransPara bOY()
  {
    AppMethodBeat.i(104086);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.lJx = true;
    localVideoTransPara.width = this.wAw;
    localVideoTransPara.height = this.wAx;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 1200000;
    localVideoTransPara.kXt = 10;
    localVideoTransPara.audioBitrate = 64000;
    localVideoTransPara.lJm = 2;
    localVideoTransPara.lJn = 1;
    localVideoTransPara.audioSampleRate = 16000;
    localVideoTransPara.duration = 15;
    AppMethodBeat.o(104086);
    return localVideoTransPara;
  }
  
  public static a diK()
  {
    AppMethodBeat.i(104079);
    if (wAm == null) {
      try
      {
        if (wAm == null) {
          wAm = new a();
        }
        a locala1 = wAm;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(104079);
      }
    }
    a locala2 = wAm;
    AppMethodBeat.o(104079);
    return locala2;
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(104084);
    Log.e("MicroMsg.FaceVideoRecorder", "carson: stop Record Video");
    this.wAn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104072);
        synchronized (a.a(a.this))
        {
          a.a(a.this, paramb);
          if (a.n(a.this) == a.a.wAW)
          {
            Log.e("MicroMsg.FaceVideoRecorder", "hy: not initialized. should not happen");
            a.d(a.this);
            if (a.r(a.this) != null)
            {
              a.r(a.this).azE(null);
              a.a(a.this, null);
            }
            AppMethodBeat.o(104072);
            return;
          }
          if ((a.n(a.this) == a.a.wBb) || (a.n(a.this) == a.a.wAX))
          {
            Log.w("MicroMsg.FaceVideoRecorder", "hy: cancelled or not started capturing.");
            a.d(a.this);
            if (a.r(a.this) != null)
            {
              a.r(a.this).azE(null);
              a.a(a.this, null);
            }
            AppMethodBeat.o(104072);
            return;
          }
          if (a.n(a.this) == a.a.wBa)
          {
            Log.i("MicroMsg.FaceVideoRecorder", "hy: already stopped");
            if (a.r(a.this) != null)
            {
              a.r(a.this).azE(a.g(a.this).getFilePath());
              a.a(a.this, null);
            }
            AppMethodBeat.o(104072);
            return;
          }
          if (a.n(a.this) == a.a.wAZ)
          {
            Log.i("MicroMsg.FaceVideoRecorder", "hy: stopping. wait");
            AppMethodBeat.o(104072);
            return;
          }
          Log.i("MicroMsg.FaceVideoRecorder", "hy: stop record and release" + Thread.currentThread().getName());
          com.tencent.mm.plugin.facedetect.model.d.dhV().b(a.o(a.this));
          a.a(a.this, a.a.wAZ);
          a.g(a.this).E(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104071);
              synchronized (a.a(a.this))
              {
                Log.i("MicroMsg.FaceVideoRecorder", "carson: begin to stop" + a.g(a.this).getFilePath());
                a.a(a.this, a.a.wBa);
                u.deleteFile(a.h(a.this));
                if (a.r(a.this) != null)
                {
                  a.r(a.this).azE(a.g(a.this).getFilePath());
                  a.a(a.this, null);
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
    Log.i("MicroMsg.FaceVideoRecorder", "hy: init record");
    Log.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, acceptVoiceFromOutside: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.FALSE, Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    VideoTransPara localVideoTransPara = bOY();
    this.wAz.a(this.jGJ, localVideoTransPara);
    this.wAn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104061);
        if ((paramInt1 == 90) || (paramInt1 == 270))
        {
          Log.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
          a.a(a.this, paramInt3);
          a.b(a.this, paramInt2);
        }
        for (;;)
        {
          synchronized (a.a(a.this))
          {
            a.c(a.this, paramInt1);
            a.a(a.this, this.wAI);
            a.d(a.this, this.wAJ);
            a.b(a.this);
            a.c(a.this);
            a.d(a.this);
            if (!MMApplicationContext.isMainProcess()) {
              break;
            }
          }
          synchronized (a.a(a.this))
          {
            long l = Util.currentTicks();
            a.a(a.this, a.e(a.this).bBu());
            a.g(a.this).setFilePath(a.f(a.this));
            a.g(a.this).ON(a.h(a.this));
            a.g(a.this).fU(paramBoolean);
            a.g(a.this).u(a.i(a.this), a.j(a.this), paramInt4, paramInt5);
            a.g(a.this).uw(a.k(a.this));
            a.g(a.this).a(a.l(a.this));
            a.a(a.this, a.a.wAX);
            Log.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
            AppMethodBeat.o(104061);
            return;
            a.a(a.this, paramInt2);
            a.b(a.this, paramInt3);
            continue;
            localObject2 = finally;
            AppMethodBeat.o(104061);
            throw localObject2;
          }
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104060);
            final long l = Util.currentTicks();
            a.m(a.this).connect(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(104059);
                synchronized (a.a(a.this))
                {
                  Log.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
                  long l = Util.currentTicks();
                  a.a(a.this, a.e(a.this).bBu());
                  a.g(a.this).setFilePath(a.f(a.this));
                  a.g(a.this).ON(a.h(a.this));
                  a.g(a.this).fU(a.1.this.wAK);
                  a.g(a.this).u(a.i(a.this), a.j(a.this), a.1.this.wAL, a.1.this.wAM);
                  a.g(a.this).uw(a.k(a.this));
                  a.g(a.this).a(a.l(a.this));
                  a.a(a.this, a.a.wAX);
                  Log.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
                  AppMethodBeat.o(104059);
                  return;
                }
              }
            });
            AppMethodBeat.o(104060);
          }
        });
        AppMethodBeat.o(104061);
      }
    });
    AppMethodBeat.o(104080);
    return true;
  }
  
  public final boolean aeU()
  {
    AppMethodBeat.i(104082);
    Log.e("MicroMsg.FaceVideoRecorder", "carson: start Record Video");
    this.wAn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104069);
        synchronized (a.a(a.this))
        {
          if (a.n(a.this) == a.a.wAW)
          {
            Log.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
            a.d(a.this);
            AppMethodBeat.o(104069);
            return;
          }
          if (a.n(a.this) == a.a.wAY)
          {
            Log.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
            AppMethodBeat.o(104069);
            return;
          }
          Log.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
          com.tencent.mm.plugin.facedetect.model.d.dhV().clear();
          com.tencent.mm.plugin.facedetect.model.d.dhV().a(a.o(a.this));
          a.g(a.this).b(a.k(a.this), a.p(a.this), a.q(a.this));
          a.a(a.this, a.a.wAY);
          AppMethodBeat.o(104069);
          return;
        }
      }
    });
    AppMethodBeat.o(104082);
    return true;
  }
  
  public final void bR(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104085);
    this.wAn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104074);
        SightVideoJNI.mirrorCameraData(paramArrayOfByte, a.i(a.this), a.j(a.this), false);
        if (a.g(a.this).getFrameDataCallback() != null) {
          a.g(a.this).getFrameDataCallback().ar(paramArrayOfByte);
        }
        AppMethodBeat.o(104074);
      }
    });
    AppMethodBeat.o(104085);
  }
  
  public final c.a diL()
  {
    AppMethodBeat.i(104081);
    if (this.nqS != null)
    {
      c.a locala = this.nqS.aZK();
      AppMethodBeat.o(104081);
      return locala;
    }
    Log.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
    AppMethodBeat.o(104081);
    return null;
  }
  
  public final void diM()
  {
    AppMethodBeat.i(104083);
    Log.e("MicroMsg.FaceVideoRecorder", "carson: cancel Record Video");
    this.wAn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104070);
        synchronized (a.a(a.this))
        {
          if (a.n(a.this) == a.a.wAW)
          {
            Log.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
            a.d(a.this);
            AppMethodBeat.o(104070);
            return;
          }
          Log.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
          a.g(a.this).cancel();
          a.d(a.this);
          com.tencent.mm.plugin.facedetect.model.d.dhV().b(a.o(a.this));
          a.a(a.this, a.a.wBb);
          a.m(a.this).release();
          AppMethodBeat.o(104070);
          return;
        }
      }
    });
    AppMethodBeat.o(104083);
  }
  
  public final a diN()
  {
    synchronized (this.mLock)
    {
      a locala = this.wAr;
      return locala;
    }
  }
  
  public final boolean isStarted()
  {
    synchronized (this.mLock)
    {
      if (this.wAr == a.wAY)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(104077);
      wAW = new a("UNINITIALIZED", 0);
      wAX = new a("INITIALIZED", 1);
      wAY = new a("STARTED", 2);
      wAZ = new a("STOPPING", 3);
      wBa = new a("STOPPED", 4);
      wBb = new a("CANCELLED", 5);
      wBc = new a[] { wAW, wAX, wAY, wAZ, wBa, wBb };
      AppMethodBeat.o(104077);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void azE(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a
 * JD-Core Version:    0.7.0.1
 */