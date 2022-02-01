package com.tencent.mm.audio.b;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.autogen.a.wi;
import com.tencent.mm.bb.c.1;
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.d.a;
import com.tencent.mm.bb.d.b;
import com.tencent.mm.compatible.i.e;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public final class b
{
  private static final Object hvC;
  private static final Object hvD;
  private boolean eoc;
  private long hvA;
  private int hvB;
  private volatile boolean hvE;
  private int hvF;
  private boolean hvG;
  public MediaRecorder hvH;
  public c hvI;
  public com.tencent.mm.compatible.b.c.a hvJ;
  public b.c hvK;
  private long hvL;
  private a hvM;
  private f.a hvN;
  private int hvO;
  private int hvP;
  private c.a hvQ;
  private int hvr;
  private String hvs;
  private int hvt;
  private final Object hvu;
  private com.tencent.mm.audio.e.c hvv;
  private b hvw;
  private com.tencent.mm.bb.c hvx;
  private d.a hvy;
  private long hvz;
  private int mSampleRate;
  
  static
  {
    AppMethodBeat.i(148328);
    hvC = new Object();
    hvD = new Object();
    AppMethodBeat.o(148328);
  }
  
  public b(com.tencent.mm.compatible.b.c.a parama)
  {
    AppMethodBeat.i(148315);
    this.hvr = 0;
    this.hvs = null;
    this.hvu = new Object();
    this.hvv = null;
    this.hvx = null;
    this.hvy = null;
    this.hvz = 0L;
    this.hvA = 0L;
    this.hvB = 0;
    this.hvE = false;
    this.mSampleRate = 8000;
    this.hvF = 16000;
    this.hvG = false;
    this.hvI = null;
    this.hvL = -1L;
    this.hvM = new a();
    this.hvN = new f.a();
    this.hvO = 0;
    this.hvP = 0;
    this.hvQ = new c.a()
    {
      private static byte[] v(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = paramAnonymousInt % 4;
        int i = paramAnonymousInt;
        if (j != 0) {
          i = paramAnonymousInt - j;
        }
        if (i <= 0) {
          return null;
        }
        byte[] arrayOfByte = new byte[i / 2];
        paramAnonymousInt = 0;
        while (paramAnonymousInt < i / 2)
        {
          arrayOfByte[paramAnonymousInt] = paramAnonymousArrayOfByte[(paramAnonymousInt * 2)];
          arrayOfByte[(paramAnonymousInt + 1)] = paramAnonymousArrayOfByte[(paramAnonymousInt * 2 + 1)];
          paramAnonymousInt += 2;
        }
        return arrayOfByte;
      }
      
      private void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(236232);
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          int j = (short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8);
          if (j > b.u(b.this)) {
            b.b(b.this, j);
          }
          i += 1;
        }
        AppMethodBeat.o(236232);
      }
      
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(236234);
        Log.i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", new Object[] { Boolean.valueOf(b.e(b.this)) });
        if ((b.f(b.this) == b.c.hwa) && (!b.e(b.this)))
        {
          Log.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
          AppMethodBeat.o(236234);
          return;
        }
        if (com.tencent.mm.plugin.audio.c.a.cTW().audioManager.isMusicActive()) {
          com.tencent.mm.audio.c.b.a.ov(0);
        }
        com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
        boolean bool1 = false;
        boolean bool2 = false;
        for (;;)
        {
          synchronized (b.hvD)
          {
            boolean bool3 = b.e(b.this);
            if (bool3) {
              synchronized (b.aGO())
              {
                if (b.c(b.this) != null)
                {
                  Log.i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt) });
                  b.c(b.this).aGH();
                  b.c(b.this).hwy = null;
                  b.d(b.this);
                  bool1 = true;
                }
              }
            }
          }
          synchronized (b.hvD)
          {
            b.g(b.this);
            Log.i("MicroMsg.MMAudioRecorder", "stop finish notify");
            try
            {
              b.hvD.notifyAll();
              long l = Util.milliSecondsToNow(b.h(b.this));
              if ((b.i(b.this) > 0L) && (l > b.i(b.this)))
              {
                Log.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:".concat(String.valueOf(l)));
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(236225);
                    b.this.stop();
                    if (b.a(b.this) != null) {
                      b.a(b.this).atR();
                    }
                    AppMethodBeat.o(236225);
                  }
                });
                AppMethodBeat.o(236234);
                return;
                paramAnonymousArrayOfByte = finally;
                AppMethodBeat.o(236234);
                throw paramAnonymousArrayOfByte;
                Log.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
                bool1 = bool2;
                continue;
                paramAnonymousArrayOfByte = finally;
                AppMethodBeat.o(236234);
                throw paramAnonymousArrayOfByte;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.MMAudioRecorder", localException, "", new Object[0]);
              }
            }
          }
        }
        Log.i("MicroMsg.MMAudioRecorder", "read :" + paramAnonymousInt + " time: " + b.j(b.this).aPY() + " dataReadedCnt: " + b.k(b.this));
        if (paramAnonymousInt < 0)
        {
          if (b.f(b.this) == b.c.hwa)
          {
            Log.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
            AppMethodBeat.o(236234);
            return;
          }
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(236226);
              b.this.stop();
              if (b.a(b.this) != null) {
                b.a(b.this).atR();
              }
              AppMethodBeat.o(236226);
            }
          });
          AppMethodBeat.o(236234);
          return;
        }
        Log.i("MicroMsg.MMAudioRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        ??? = new wi();
        ((wi)???).hZW.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        ((wi)???).hZW.len = paramAnonymousInt;
        ((wi)???).publish();
        b.a(b.this, paramAnonymousInt);
        for (;;)
        {
          Object localObject2;
          Object localObject3;
          int j;
          synchronized (b.l(b.this))
          {
            if ((b.m(b.this) == null) && ((b.n(b.this) == com.tencent.mm.compatible.b.c.a.lQd) || (b.n(b.this) == com.tencent.mm.compatible.b.c.a.lQf)) && (b.o(b.this) != null) && (b.p(b.this)))
            {
              b.a(b.this, new com.tencent.mm.bb.c());
              localObject2 = b.m(b.this);
              i = b.q(b.this);
              Log.i("MicroMsg.SpeexEncoderWorker", "init ");
              ((com.tencent.mm.bb.c)localObject2).oUB.clear();
              localObject3 = new d.b();
              ((d.b)localObject3).prefix = d.getPrefix();
              ((d.b)localObject3).sampleRate = i;
              ((d.b)localObject3).oUx = 1;
              ((d.b)localObject3).audioFormat = 16;
              ((com.tencent.mm.bb.c)localObject2).mFileName = String.format("%s%d_%d_%d_%d", new Object[] { ((d.b)localObject3).prefix, Integer.valueOf(((d.b)localObject3).sampleRate), Integer.valueOf(((d.b)localObject3).oUx), Integer.valueOf(((d.b)localObject3).audioFormat), Long.valueOf(System.currentTimeMillis()) });
            }
            if (b.m(b.this) != null)
            {
              localObject2 = b.m(b.this);
              Log.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + ((com.tencent.mm.bb.c)localObject2).oUB.size());
              if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
                ((com.tencent.mm.bb.c)localObject2).oUB.add(new g.a(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length));
              }
            }
            if (b.n(b.this) != com.tencent.mm.compatible.b.c.a.lQf) {
              break;
            }
            if (b.r(b.this) == null)
            {
              b.a(b.this, new com.tencent.mm.audio.e.c(b.q(b.this), b.s(b.this)));
              b.r(b.this).jO(b.t(b.this));
            }
            w(paramAnonymousArrayOfByte, paramAnonymousInt);
            localObject2 = b.r(b.this);
            if (((com.tencent.mm.audio.e.c)localObject2).hym == null)
            {
              i = -1;
              if (paramAnonymousArrayOfByte != null) {
                break label1051;
              }
              j = -1;
              label958:
              Log.i("MicroMsg.SilkWriter", "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
              if (paramAnonymousInt <= 0) {}
            }
          }
          try
          {
            if (((com.tencent.mm.audio.e.c)localObject2).hyn) {
              Log.e("MicroMsg.SilkWriter", "already stop");
            }
            for (;;)
            {
              AppMethodBeat.o(236234);
              return;
              i = ((com.tencent.mm.audio.e.c)localObject2).hym.size();
              break;
              label1051:
              j = paramAnonymousArrayOfByte.length;
              break label958;
              if (((com.tencent.mm.audio.e.c)localObject2).hyt == null)
              {
                ((com.tencent.mm.audio.e.c)localObject2).hyt = new com.tencent.mm.audio.e.c.a((com.tencent.mm.audio.e.c)localObject2, (byte)0);
                com.tencent.threadpool.h.ahAA.bm(((com.tencent.mm.audio.e.c)localObject2).hyt);
              }
              localObject3 = ((com.tencent.mm.audio.e.c)localObject2).hym;
              if (localObject3 != null) {
                try
                {
                  ((com.tencent.mm.audio.e.c)localObject2).hym.add(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt, bool1));
                }
                catch (Exception paramAnonymousArrayOfByte)
                {
                  Log.printErrStackTrace("MicroMsg.SilkWriter", paramAnonymousArrayOfByte, "pushBuf add queue error:%s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
                }
              }
            }
            paramAnonymousArrayOfByte = finally;
            AppMethodBeat.o(236234);
            throw paramAnonymousArrayOfByte;
          }
          finally
          {
            AppMethodBeat.o(236234);
          }
        }
        ??? = paramAnonymousArrayOfByte;
        int i = paramAnonymousInt;
        if (b.q(b.this) == 16000)
        {
          ??? = v(paramAnonymousArrayOfByte, paramAnonymousInt);
          i = ???.length;
        }
        w((byte[])???, i);
        AppMethodBeat.o(236234);
      }
    };
    this.eoc = false;
    Log.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: ".concat(String.valueOf(parama)));
    this.hvJ = parama;
    if (!g.b.aGZ())
    {
      Log.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
      this.hvJ = com.tencent.mm.compatible.b.c.a.lQe;
    }
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      this.hvt = 7;
      this.hvH = new e();
    }
    for (;;)
    {
      this.hvL = -1L;
      this.hvE = false;
      AppMethodBeat.o(148315);
      return;
      aGN();
      this.hvt = 1;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(148316);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH == null)
      {
        AppMethodBeat.o(148316);
        return;
      }
      this.hvw = paramb;
      this.hvH.setOnErrorListener(new MediaRecorder.OnErrorListener()
      {
        public final void onError(MediaRecorder paramAnonymousMediaRecorder, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(148307);
          if (b.a(b.this) != null) {
            b.a(b.this).atR();
          }
          try
          {
            b.b(b.this).release();
            b.a(b.this, b.c.hvZ);
            AppMethodBeat.o(148307);
            return;
          }
          catch (Exception paramAnonymousMediaRecorder)
          {
            for (;;)
            {
              Log.e("MicroMsg.MMAudioRecorder", paramAnonymousMediaRecorder.getMessage());
            }
          }
        }
      });
      AppMethodBeat.o(148316);
      return;
    }
    if (this.hvK == b.c.hvW)
    {
      this.hvw = paramb;
      AppMethodBeat.o(148316);
      return;
    }
    Log.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
    AppMethodBeat.o(148316);
  }
  
  public final int aGI()
  {
    AppMethodBeat.i(148322);
    int i;
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH == null)
      {
        AppMethodBeat.o(148322);
        return 0;
      }
      i = this.hvH.getMaxAmplitude();
      AppMethodBeat.o(148322);
      return i;
    }
    if (this.hvK == b.c.hvY)
    {
      i = this.hvr;
      if ((this.hvL <= 0L) || (Util.ticksToNow(this.hvL) > 500L))
      {
        Log.i("MicroMsg.MMAudioRecorder", "mCurAmplitude:%s", new Object[] { Integer.valueOf(this.hvr) });
        this.hvL = Util.currentTicks();
      }
      this.hvr = 0;
      AppMethodBeat.o(148322);
      return i;
    }
    AppMethodBeat.o(148322);
    return 0;
  }
  
  public final void aGK()
  {
    AppMethodBeat.i(148319);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH != null) {
        this.hvH.setAudioEncoder(1);
      }
      AppMethodBeat.o(148319);
      return;
    }
    AppMethodBeat.o(148319);
  }
  
  public final void aGL()
  {
    AppMethodBeat.i(148320);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH == null)
      {
        AppMethodBeat.o(148320);
        return;
      }
      this.hvH.setAudioSource(1);
      AppMethodBeat.o(148320);
      return;
    }
    AppMethodBeat.o(148320);
  }
  
  public final void aGM()
  {
    AppMethodBeat.i(148321);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH == null)
      {
        AppMethodBeat.o(148321);
        return;
      }
      this.hvH.setOutputFormat(3);
      AppMethodBeat.o(148321);
      return;
    }
    AppMethodBeat.o(148321);
  }
  
  public final void aGN()
  {
    AppMethodBeat.i(148323);
    this.hvy = d.a.bMT();
    if (this.hvy != null) {
      this.hvG = this.hvy.bMS();
    }
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQf)
    {
      ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("VoiceSamplingRate");
      this.mSampleRate = Util.getInt((String)???, 16000);
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("VoiceRate");
      this.hvF = Util.getInt(str, 16000);
      Log.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", new Object[] { ???, Integer.valueOf(this.mSampleRate), str, Integer.valueOf(this.hvF) });
    }
    for (;;)
    {
      this.hvr = 0;
      this.hvs = null;
      synchronized (this.hvu)
      {
        this.hvx = null;
        this.hvv = null;
        this.hvB = 0;
      }
      try
      {
        synchronized (hvC)
        {
          this.hvI = new c(this.mSampleRate, 1, 0);
          this.hvI.eo(true);
          this.hvI.ok(120);
          this.hvI.hwy = this.hvQ;
          this.hvK = b.c.hvW;
          AppMethodBeat.o(148323);
          return;
          if (this.hvG) {}
          for (this.mSampleRate = 16000;; this.mSampleRate = 8000)
          {
            com.tencent.mm.kernel.h.baF();
            int i = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().mCE.get(27), 0);
            Log.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + i);
            if (i != 1) {
              break;
            }
            this.mSampleRate = 8000;
            break;
          }
          localObject2 = finally;
          AppMethodBeat.o(148323);
          throw localObject2;
        }
        Log.e("MicroMsg.MMAudioRecorder", localException.getMessage());
      }
      catch (Exception localException)
      {
        if (localException.getMessage() == null) {}
      }
    }
    for (;;)
    {
      this.hvK = b.c.hvZ;
      AppMethodBeat.o(148323);
      return;
      Log.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
    }
  }
  
  public final void oj(int paramInt)
  {
    AppMethodBeat.i(148318);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH != null) {
        this.hvH.setMaxDuration(paramInt);
      }
      AppMethodBeat.o(148318);
      return;
    }
    this.hvz = paramInt;
    AppMethodBeat.o(148318);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(148325);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH != null) {
        this.hvH.prepare();
      }
      AppMethodBeat.o(148325);
      return;
    }
    if ((this.hvK != b.c.hvW) || (this.hvs == null))
    {
      this.hvK = b.c.hvZ;
      release();
      AppMethodBeat.o(148325);
      return;
    }
    this.hvK = b.c.hvX;
    AppMethodBeat.o(148325);
  }
  
  public final void release()
  {
    AppMethodBeat.i(148326);
    long l = Util.currentTicks();
    Log.i("MicroMsg.MMAudioRecorder", "release curState:%s, pcmRecorder:%s", new Object[] { this.hvK, this.hvI });
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH != null) {
        this.hvH.release();
      }
      AppMethodBeat.o(148326);
      return;
    }
    if (this.hvK == b.c.hvY) {
      stop();
    }
    synchronized (hvD)
    {
      this.hvE = false;
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(236231);
          long l = Util.currentTicks();
          Log.i("MicroMsg.MMAudioRecorder", "stop try stopRecorder, pcmRecorder:%s", new Object[] { b.c(b.this) });
          synchronized (b.aGO())
          {
            if (b.c(b.this) != null)
            {
              b.c(b.this).aGH();
              b.c(b.this).hwy = null;
              b.d(b.this);
            }
            Log.i("MicroMsg.MMAudioRecorder", "stop finish stopRecorder, cost:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
            AppMethodBeat.o(236231);
            return;
          }
        }
      });
      Log.i("MicroMsg.MMAudioRecorder", "release finished cost:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(148326);
      return;
      ??? = b.c.hvX;
    }
  }
  
  public final void setOutputFile(String paramString)
  {
    AppMethodBeat.i(148317);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH == null)
      {
        AppMethodBeat.o(148317);
        return;
      }
      this.hvH.setOutputFile(paramString);
      this.hvs = paramString;
      AppMethodBeat.o(148317);
      return;
    }
    if (this.hvK == b.c.hvW)
    {
      this.hvs = paramString;
      if (this.hvI != null)
      {
        this.hvI.hwG = this.hvs;
        AppMethodBeat.o(148317);
      }
    }
    else
    {
      Log.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
      this.hvK = b.c.hvZ;
    }
    AppMethodBeat.o(148317);
  }
  
  public final void start()
  {
    AppMethodBeat.i(148324);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      if (this.hvH != null) {
        this.hvH.start();
      }
      AppMethodBeat.o(148324);
      return;
    }
    Log.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.hvK + " recMode: " + this.hvJ);
    if (this.hvK == b.c.hvX)
    {
      this.hvA = System.currentTimeMillis();
      this.hvB = 0;
      this.hvK = b.c.hvY;
      if (AccUtil.INSTANCE.isAccessibilityEnabled()) {
        this.hvM.startTimer(0L, 300L);
      }
    }
    for (;;)
    {
      synchronized (hvC)
      {
        this.hvI.aGR();
        this.hvE = false;
        AppMethodBeat.o(148324);
        return;
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().mCE.B(27, Integer.valueOf(1));
      Log.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
      this.hvK = b.c.hvZ;
    }
  }
  
  public final boolean stop()
  {
    AppMethodBeat.i(148327);
    if (this.hvJ == com.tencent.mm.compatible.b.c.a.lQe)
    {
      Log.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", new Object[] { this.hvH });
      if (this.hvH != null)
      {
        this.hvH.stop();
        this.hvH.release();
        this.hvH = null;
      }
      AppMethodBeat.o(148327);
      return true;
    }
    f.a locala = new f.a();
    Log.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.hvK);
    if (this.hvK == b.c.hvW)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(357L, 53L, 1L, true);
      if (!this.eoc) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(357L, 54L, 1L, true);
      }
      this.eoc = true;
    }
    if (this.hvK != b.c.hvY)
    {
      Log.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
      this.hvK = b.c.hvZ;
      AppMethodBeat.o(148327);
      return true;
    }
    for (;;)
    {
      long l1;
      long l2;
      synchronized (hvC)
      {
        if (this.hvI != null)
        {
          this.hvE = true;
          l1 = locala.aPY();
          this.hvK = b.c.hwa;
          l2 = locala.aPY();
          synchronized (hvD)
          {
            boolean bool = this.hvE;
            if (bool) {
              com.tencent.threadpool.h.ahAA.bm(new Runnable()
              {
                /* Error */
                public final void run()
                {
                  // Byte code:
                  //   0: ldc 25
                  //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
                  //   5: ldc 33
                  //   7: ldc 35
                  //   9: iconst_1
                  //   10: anewarray 4	java/lang/Object
                  //   13: dup
                  //   14: iconst_0
                  //   15: aload_0
                  //   16: getfield 17	com/tencent/mm/audio/b/b$4:hvR	Lcom/tencent/mm/audio/b/b;
                  //   19: invokestatic 39	com/tencent/mm/audio/b/b:e	(Lcom/tencent/mm/audio/b/b;)Z
                  //   22: invokestatic 45	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
                  //   25: aastore
                  //   26: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   29: invokestatic 54	com/tencent/mm/audio/b/b:access$600	()Ljava/lang/Object;
                  //   32: astore_1
                  //   33: aload_1
                  //   34: monitorenter
                  //   35: invokestatic 54	com/tencent/mm/audio/b/b:access$600	()Ljava/lang/Object;
                  //   38: ldc2_w 55
                  //   41: invokevirtual 60	java/lang/Object:wait	(J)V
                  //   44: aload_1
                  //   45: monitorexit
                  //   46: invokestatic 63	com/tencent/mm/audio/b/b:aGO	()Ljava/lang/Object;
                  //   49: astore_1
                  //   50: aload_1
                  //   51: monitorenter
                  //   52: ldc 33
                  //   54: ldc 65
                  //   56: iconst_1
                  //   57: anewarray 4	java/lang/Object
                  //   60: dup
                  //   61: iconst_0
                  //   62: aload_0
                  //   63: getfield 17	com/tencent/mm/audio/b/b$4:hvR	Lcom/tencent/mm/audio/b/b;
                  //   66: invokestatic 69	com/tencent/mm/audio/b/b:c	(Lcom/tencent/mm/audio/b/b;)Lcom/tencent/mm/audio/b/c;
                  //   69: aastore
                  //   70: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   73: aload_0
                  //   74: getfield 17	com/tencent/mm/audio/b/b$4:hvR	Lcom/tencent/mm/audio/b/b;
                  //   77: invokestatic 69	com/tencent/mm/audio/b/b:c	(Lcom/tencent/mm/audio/b/b;)Lcom/tencent/mm/audio/b/c;
                  //   80: astore_2
                  //   81: aload_2
                  //   82: ifnull +33 -> 115
                  //   85: aload_0
                  //   86: getfield 17	com/tencent/mm/audio/b/b$4:hvR	Lcom/tencent/mm/audio/b/b;
                  //   89: invokestatic 69	com/tencent/mm/audio/b/b:c	(Lcom/tencent/mm/audio/b/b;)Lcom/tencent/mm/audio/b/c;
                  //   92: invokevirtual 74	com/tencent/mm/audio/b/c:aGH	()Z
                  //   95: pop
                  //   96: aload_0
                  //   97: getfield 17	com/tencent/mm/audio/b/b$4:hvR	Lcom/tencent/mm/audio/b/b;
                  //   100: invokestatic 69	com/tencent/mm/audio/b/b:c	(Lcom/tencent/mm/audio/b/b;)Lcom/tencent/mm/audio/b/c;
                  //   103: aconst_null
                  //   104: putfield 78	com/tencent/mm/audio/b/c:hwy	Lcom/tencent/mm/audio/b/c$a;
                  //   107: aload_0
                  //   108: getfield 17	com/tencent/mm/audio/b/b$4:hvR	Lcom/tencent/mm/audio/b/b;
                  //   111: invokestatic 81	com/tencent/mm/audio/b/b:d	(Lcom/tencent/mm/audio/b/b;)Lcom/tencent/mm/audio/b/c;
                  //   114: pop
                  //   115: aload_1
                  //   116: monitorexit
                  //   117: ldc 33
                  //   119: ldc 83
                  //   121: iconst_1
                  //   122: anewarray 4	java/lang/Object
                  //   125: dup
                  //   126: iconst_0
                  //   127: aload_0
                  //   128: getfield 17	com/tencent/mm/audio/b/b$4:hvR	Lcom/tencent/mm/audio/b/b;
                  //   131: invokestatic 39	com/tencent/mm/audio/b/b:e	(Lcom/tencent/mm/audio/b/b;)Z
                  //   134: invokestatic 45	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
                  //   137: aastore
                  //   138: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   141: ldc 25
                  //   143: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                  //   146: return
                  //   147: astore_2
                  //   148: ldc 33
                  //   150: aload_2
                  //   151: ldc 88
                  //   153: iconst_0
                  //   154: anewarray 4	java/lang/Object
                  //   157: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   160: goto -116 -> 44
                  //   163: astore_2
                  //   164: aload_1
                  //   165: monitorexit
                  //   166: ldc 25
                  //   168: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                  //   171: aload_2
                  //   172: athrow
                  //   173: astore_2
                  //   174: ldc 33
                  //   176: aload_2
                  //   177: ldc 88
                  //   179: iconst_0
                  //   180: anewarray 4	java/lang/Object
                  //   183: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   186: goto -71 -> 115
                  //   189: astore_2
                  //   190: aload_1
                  //   191: monitorexit
                  //   192: ldc 25
                  //   194: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                  //   197: aload_2
                  //   198: athrow
                  // Local variable table:
                  //   start	length	slot	name	signature
                  //   0	199	0	this	4
                  //   80	2	2	localc	c
                  //   147	4	2	localException1	Exception
                  //   163	9	2	localObject2	Object
                  //   173	4	2	localException2	Exception
                  //   189	9	2	localObject3	Object
                  // Exception table:
                  //   from	to	target	type
                  //   35	44	147	java/lang/Exception
                  //   35	44	163	finally
                  //   44	46	163	finally
                  //   148	160	163	finally
                  //   85	115	173	java/lang/Exception
                  //   52	81	189	finally
                  //   85	115	189	finally
                  //   115	117	189	finally
                  //   174	186	189	finally
                }
              });
            }
          }
        }
      }
      synchronized (this.hvu)
      {
        if (this.hvv != null) {
          this.hvv.aIz();
        }
        if (this.hvx != null)
        {
          com.tencent.mm.bb.c localc = this.hvx;
          Log.i("MicroMsg.SpeexEncoderWorker", "stop ");
          new MMHandler(Looper.getMainLooper()).post(new c.1(localc));
        }
        long l3 = Util.milliSecondsToNow(this.hvA);
        Log.i("MicroMsg.MMAudioRecorder", "toNow " + l3 + " startTickCnt: " + this.hvA + " pcmDataReadedCnt: " + this.hvB);
        if ((l3 > 2000L) && (this.hvB == 0))
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().mCE.B(27, Integer.valueOf(1));
          Log.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        Log.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + l1 + " Read:" + l2 + " Thr:" + locala.aPY());
        AppMethodBeat.o(148327);
        return false;
        this.hvE = false;
        continue;
        localObject1 = finally;
        AppMethodBeat.o(148327);
        throw localObject1;
        localObject2 = finally;
        AppMethodBeat.o(148327);
        throw localObject2;
      }
    }
  }
  
  final class a
    extends MTimerHandler
  {
    private long hvT;
    
    public a()
    {
      super(
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(236229);
          Log.i("MicroMsg.MMAudioRecorder", "Acc try interrupt read");
          AccessibilityManager localAccessibilityManager = (AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility");
          try
          {
            localAccessibilityManager.interrupt();
            return true;
          }
          finally
          {
            AppMethodBeat.o(236229);
          }
          return false;
        }
      });
      AppMethodBeat.i(236219);
      this.hvT = 0L;
      this.hvT = 1500L;
      AppMethodBeat.o(236219);
    }
    
    public final void startTimer(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(236222);
      if ((stopped()) && (this.hvT > 0L)) {
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(236228);
            Log.i("MicroMsg.MMAudioRecorder", "auto stop Timer");
            b.a.this.stopTimer();
            AppMethodBeat.o(236228);
          }
        }, this.hvT);
      }
      super.startTimer(paramLong1, paramLong2);
      AppMethodBeat.o(236222);
    }
    
    public final void stopTimer()
    {
      AppMethodBeat.i(236224);
      super.stopTimer();
      AppMethodBeat.o(236224);
    }
  }
  
  public static abstract interface b
  {
    public abstract void atR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.audio.b.b
 * JD-Core Version:    0.7.0.1
 */