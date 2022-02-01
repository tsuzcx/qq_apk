package com.tencent.mm.audio.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.l;
import com.tencent.mm.am.l.a;
import com.tencent.mm.am.l.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class h
  implements l
{
  private static boolean eoc = false;
  private com.tencent.mm.compatible.util.b hqw;
  private Runnable hxA;
  private a hxk;
  private a hxl;
  private String hxm;
  private boolean hxn;
  private boolean hxo;
  private long hxp;
  private long hxq;
  public int hxr;
  private boolean hxs;
  private boolean hxt;
  private int hxu;
  private c.a hxv;
  protected l.b hxw;
  protected l.a hxx;
  private com.tencent.mm.audio.b hxy;
  private MTimerHandler hxz;
  private String mFileName;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(148336);
    this.hxk = null;
    this.hxl = null;
    this.mFileName = "";
    this.hxn = false;
    this.hxo = false;
    this.hxq = 0L;
    this.hxr = 0;
    this.hxs = false;
    this.hxt = false;
    this.hxu = 0;
    this.hxv = c.a.lQh;
    this.hxx = null;
    this.hxz = new MTimerHandler(new h.2(this), true);
    this.hqw = new com.tencent.mm.compatible.util.b(paramContext);
    this.hxt = paramBoolean;
    this.hxy = new com.tencent.mm.audio.b(new h.1(this));
    Log.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148336);
  }
  
  public final void a(l.a parama)
  {
    this.hxx = parama;
  }
  
  public final void a(l.b paramb)
  {
    this.hxw = paramb;
  }
  
  public final int aGI()
  {
    AppMethodBeat.i(148339);
    if (this.hxk == null)
    {
      AppMethodBeat.o(148339);
      return 0;
    }
    int i = this.hxk.aGI();
    AppMethodBeat.o(148339);
    return i;
  }
  
  public final int aHa()
  {
    return this.hxr;
  }
  
  public final boolean aHb()
  {
    AppMethodBeat.i(236245);
    boolean bool = jM("_USER_FOR_THROWBOTTLE_");
    AppMethodBeat.o(236245);
    return bool;
  }
  
  public final void aHc()
  {
    AppMethodBeat.i(148343);
    Log.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", new Object[] { this.mFileName });
    if (this.hxz != null)
    {
      this.hxz.stopTimer();
      this.hxz.removeCallbacksAndMessages(null);
    }
    this.hxy.aEV();
    try
    {
      Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.hxk != null)
      {
        this.hxk.aGH();
        this.hqw.aPS();
      }
      this.hxu = -1;
      AppMethodBeat.o(148343);
      return;
    }
    finally
    {
      AppMethodBeat.o(148343);
    }
  }
  
  public final long aHd()
  {
    AppMethodBeat.i(148345);
    if (this.hxq == 0L)
    {
      AppMethodBeat.o(148345);
      return 0L;
    }
    long l = Util.ticksToNow(this.hxq);
    AppMethodBeat.o(148345);
    return l;
  }
  
  public final int aHe()
  {
    if (this.hxt) {
      return 1;
    }
    if ((this.hxv == c.a.lQd) || (this.hxv == c.a.lQe)) {
      return 0;
    }
    if (this.hxv == c.a.lQf) {
      return 2;
    }
    return -1;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(148341);
    Log.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
    try
    {
      Object localObject1 = this.hxk;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
        ((a)localObject1).aGH();
        this.hqw.aPS();
      }
      this.hxy.aEV();
      s.QK(this.mFileName);
      o.bPh().run();
      if ((this.hxk != null) && (!Util.isNullOrNil(this.mFileName)) && (!this.hxt))
      {
        localObject1 = new com.tencent.mm.compatible.g.a();
        ((com.tencent.mm.compatible.g.a)localObject1).lYI = this.mFileName;
        ((com.tencent.mm.compatible.g.a)localObject1).lYJ = aHd();
        ((com.tencent.mm.compatible.g.a)localObject1).lYK = 1;
        ((com.tencent.mm.compatible.g.a)localObject1).hDx = this.hxk.aGJ();
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10513, ((com.tencent.mm.compatible.g.a)localObject1).aPQ());
      }
      this.mFileName = "";
      AppMethodBeat.o(148341);
      return true;
    }
    finally
    {
      AppMethodBeat.o(148341);
    }
  }
  
  public String getFileName()
  {
    return this.mFileName;
  }
  
  public final boolean isRecording()
  {
    AppMethodBeat.i(148338);
    if (this.hxk == null)
    {
      AppMethodBeat.o(148338);
      return false;
    }
    if (this.hxk.getStatus() == 1)
    {
      AppMethodBeat.o(148338);
      return true;
    }
    AppMethodBeat.o(148338);
    return false;
  }
  
  public final boolean jM(String paramString)
  {
    AppMethodBeat.i(148340);
    Log.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(paramString)));
    reset();
    this.hxm = paramString;
    this.hxp = Util.currentTicks();
    if (paramString == null)
    {
      Log.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      AppMethodBeat.o(148340);
      return false;
    }
    this.hxn = paramString.equals("_USER_FOR_THROWBOTTLE_");
    boolean bool;
    if (paramString.equals("medianote"))
    {
      if ((z.bAQ() & 0x4000) == 0)
      {
        bool = true;
        this.hxo = bool;
      }
    }
    else
    {
      if (this.hxt) {
        break label188;
      }
      if (!this.hxn) {
        break label168;
      }
      this.mFileName = w.QS(z.bAM());
    }
    for (;;)
    {
      if ((this.mFileName != null) && (this.mFileName.length() > 0)) {
        break label199;
      }
      Log.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[] { this.mFileName });
      AppMethodBeat.o(148340);
      return false;
      bool = false;
      break;
      label168:
      if (this.hxo) {
        this.mFileName = w.QS("medianote");
      } else {
        label188:
        this.mFileName = s.QJ(paramString);
      }
    }
    label199:
    this.hxs = false;
    this.hxy.aEU();
    AppMethodBeat.o(148340);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(148337);
    if (this.hxk != null)
    {
      this.hxk.aGH();
      this.hqw.aPS();
      Log.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.hxp = 0L;
    this.hxl = null;
    this.hxv = c.a.lQh;
    this.hxu = 0;
    this.hxq = 0L;
    AppMethodBeat.o(148337);
  }
  
  public boolean stop()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148342);
    if (this.hxz != null)
    {
      this.hxz.stopTimer();
      this.hxz.removeCallbacksAndMessages(null);
    }
    this.hxy.aEV();
    this.hxr = ((int)aHd());
    Log.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.hxr) });
    Object localObject1;
    if ((this.hxk != null) && (!Util.isNullOrNil(this.mFileName)) && (!this.hxt))
    {
      localObject1 = new com.tencent.mm.compatible.g.a();
      ((com.tencent.mm.compatible.g.a)localObject1).lYI = this.mFileName;
      ((com.tencent.mm.compatible.g.a)localObject1).lYJ = this.hxr;
      ((com.tencent.mm.compatible.g.a)localObject1).lYK = 2;
      ((com.tencent.mm.compatible.g.a)localObject1).hDx = this.hxk.aGJ();
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10513, ((com.tencent.mm.compatible.g.a)localObject1).aPQ());
    }
    for (;;)
    {
      try
      {
        if (this.hxk == null) {
          break label459;
        }
        localObject1 = this.hxk;
        Log.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, localObject1, Long.valueOf(Thread.currentThread().getId()), this });
        if (localObject1 != null)
        {
          ((a)localObject1).aGH();
          this.hqw.aPS();
        }
        if (this.hxu != 2)
        {
          s.QM(this.mFileName);
          this.mFileName = null;
          Log.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + Util.ticksToNow(this.hxp));
          bool1 = bool2;
          this.hxu = -1;
          AppMethodBeat.o(148342);
          return bool1;
        }
      }
      finally
      {
        AppMethodBeat.o(148342);
      }
      if ((this.hxr < 800L) || ((this.hxn) && (this.hxr < 1000L)))
      {
        Log.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.hxr);
        s.QM(this.mFileName);
        this.mFileName = "";
        bool1 = false;
      }
      for (;;)
      {
        this.mFileName = "";
        break;
        s.bi(this.mFileName, this.hxr);
        o.bPh().run();
        Log.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
      }
      label459:
      Object localObject3 = null;
    }
  }
  
  final class a
    implements com.tencent.threadpool.i.h
  {
    MMHandler handler;
    
    public a()
    {
      AppMethodBeat.i(148334);
      this.handler = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(148333);
          if (h.d(h.this) <= 0)
          {
            AppMethodBeat.o(148333);
            return;
          }
          paramAnonymousMessage = new StringBuilder("On Part :");
          if (h.this.hxw == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.SceneVoice.Recorder", bool);
            h.e(h.this);
            if (h.this.hxw != null) {
              h.this.hxw.bFK();
            }
            AppMethodBeat.o(148333);
            return;
          }
        }
      };
      AppMethodBeat.o(148334);
    }
    
    public final String getKey()
    {
      return "SceneVoiceRecorder_record";
    }
    
    public final void run()
    {
      AppMethodBeat.i(148335);
      MMHandlerThread.removeRunnable(h.f(h.this));
      Log.i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      for (;;)
      {
        synchronized (h.this)
        {
          Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", new Object[] { Long.valueOf(Thread.currentThread().getId()), h.this });
          if (h.g(h.this) == null)
          {
            Log.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
            AppMethodBeat.o(148335);
            return;
          }
          a locala = h.g(h.this);
          if (locala != null)
          {
            ??? = h.c(h.this);
            if (!h.h(h.this))
            {
              bool = true;
              ??? = s.af((String)???, bool);
              Log.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { ???, Boolean.valueOf(h.h(h.this)) });
              if (locala.jL((String)???)) {
                break label324;
              }
              s.QM(h.c(h.this));
              h.i(h.this);
              h.j(h.this);
              Log.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.c(h.this) + "]");
              h.a(h.this, Util.currentTicks());
              Log.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.c(h.this) + "] time:" + Util.ticksToNow(h.l(h.this)));
            }
          }
          else
          {
            this.handler.sendEmptyMessageDelayed(0, 1L);
            AppMethodBeat.o(148335);
            return;
          }
        }
        boolean bool = false;
        continue;
        label324:
        h.k(h.this).requestFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.audio.b.h
 * JD-Core Version:    0.7.0.1
 */