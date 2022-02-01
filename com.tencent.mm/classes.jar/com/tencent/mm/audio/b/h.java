package com.tencent.mm.audio.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m;
import com.tencent.mm.ak.m.a;
import com.tencent.mm.ak.m.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.g.e;
import kotlin.x;

public class h
  implements m
{
  private static boolean cxw = false;
  private a dAg;
  private a dAh;
  private String dAi;
  private boolean dAj;
  private boolean dAk;
  private long dAl;
  private long dAm;
  public int dAn;
  private boolean dAo;
  private boolean dAp;
  private int dAq;
  private c.a dAr;
  protected m.b dAs;
  protected m.a dAt;
  private com.tencent.mm.audio.b dAu;
  private MTimerHandler dAv;
  private Runnable dAw;
  private com.tencent.mm.compatible.util.b dtz;
  private String mFileName;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(148336);
    this.dAg = null;
    this.dAh = null;
    this.mFileName = "";
    this.dAj = false;
    this.dAk = false;
    this.dAm = 0L;
    this.dAn = 0;
    this.dAo = false;
    this.dAp = false;
    this.dAq = 0;
    this.dAr = c.a.gCQ;
    this.dAt = null;
    this.dAv = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(187325);
        com.tencent.mm.modelvoice.s.a(h.c(h.this), h.this);
        com.tencent.mm.modelvoice.o.bid().run();
        Log.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.c(h.this));
        AppMethodBeat.o(187325);
        return false;
      }
    }, true);
    this.dtz = new com.tencent.mm.compatible.util.b(paramContext);
    this.dAp = paramBoolean;
    this.dAu = new com.tencent.mm.audio.b(new kotlin.g.a.b() {});
    Log.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148336);
  }
  
  public boolean Qt()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148342);
    if (this.dAv != null)
    {
      this.dAv.stopTimer();
      this.dAv.removeCallbacksAndMessages(null);
    }
    this.dAu.Yp();
    this.dAn = ((int)aas());
    Log.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.dAn) });
    if ((this.dAg != null) && (!Util.isNullOrNil(this.mFileName)) && (!this.dAp))
    {
      com.tencent.mm.compatible.g.a locala = new com.tencent.mm.compatible.g.a();
      locala.gLc = this.mFileName;
      locala.gLd = this.dAn;
      locala.gLe = 2;
      locala.dGe = this.dAg.aaa();
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10513, locala.apk());
    }
    try
    {
      Log.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, this.dAg, Long.valueOf(Thread.currentThread().getId()), this });
      if (this.dAg != null)
      {
        this.dAg.ZZ();
        this.dtz.apm();
      }
      if (this.dAq != 2)
      {
        com.tencent.mm.modelvoice.s.Rk(this.mFileName);
        this.mFileName = null;
        Log.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + Util.ticksToNow(this.dAl));
        bool1 = bool2;
        this.dAq = -1;
        AppMethodBeat.o(148342);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(148342);
    }
    if ((this.dAn < 800L) || ((this.dAj) && (this.dAn < 1000L)))
    {
      Log.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.dAn);
      com.tencent.mm.modelvoice.s.Rk(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      com.tencent.mm.modelvoice.s.aB(this.mFileName, this.dAn);
      com.tencent.mm.modelvoice.o.bid().run();
      Log.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final void a(m.a parama)
  {
    this.dAt = parama;
  }
  
  public final void a(m.b paramb)
  {
    this.dAs = paramb;
  }
  
  public final int aaq()
  {
    return this.dAn;
  }
  
  public final void aar()
  {
    AppMethodBeat.i(148343);
    Log.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", new Object[] { this.mFileName });
    if (this.dAv != null)
    {
      this.dAv.stopTimer();
      this.dAv.removeCallbacksAndMessages(null);
    }
    this.dAu.Yp();
    try
    {
      Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.dAg != null)
      {
        this.dAg.ZZ();
        this.dtz.apm();
      }
      this.dAq = -1;
      AppMethodBeat.o(148343);
      return;
    }
    finally
    {
      AppMethodBeat.o(148343);
    }
  }
  
  public final long aas()
  {
    AppMethodBeat.i(148345);
    if (this.dAm == 0L)
    {
      AppMethodBeat.o(148345);
      return 0L;
    }
    long l = Util.ticksToNow(this.dAm);
    AppMethodBeat.o(148345);
    return l;
  }
  
  public final int aat()
  {
    if (this.dAp) {
      return 1;
    }
    if ((this.dAr == c.a.gCM) || (this.dAr == c.a.gCN)) {
      return 0;
    }
    if (this.dAr == c.a.gCO) {
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
      Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.dAg != null)
      {
        this.dAg.ZZ();
        this.dtz.apm();
      }
      this.dAu.Yp();
      com.tencent.mm.modelvoice.s.Ri(this.mFileName);
      com.tencent.mm.modelvoice.o.bid().run();
      if ((this.dAg != null) && (!Util.isNullOrNil(this.mFileName)) && (!this.dAp))
      {
        com.tencent.mm.compatible.g.a locala = new com.tencent.mm.compatible.g.a();
        locala.gLc = this.mFileName;
        locala.gLd = aas();
        locala.gLe = 1;
        locala.dGe = this.dAg.aaa();
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10513, locala.apk());
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
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(148339);
    if (this.dAg == null)
    {
      AppMethodBeat.o(148339);
      return 0;
    }
    int i = this.dAg.getMaxAmplitude();
    AppMethodBeat.o(148339);
    return i;
  }
  
  public final boolean hx(String paramString)
  {
    AppMethodBeat.i(148340);
    Log.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(paramString)));
    reset();
    this.dAi = paramString;
    this.dAl = Util.currentTicks();
    if (paramString == null)
    {
      Log.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      AppMethodBeat.o(148340);
      return false;
    }
    this.dAj = paramString.equals("_USER_FOR_THROWBOTTLE_");
    boolean bool;
    if (paramString.equals("medianote"))
    {
      if ((z.aUc() & 0x4000) == 0)
      {
        bool = true;
        this.dAk = bool;
      }
    }
    else
    {
      if (this.dAp) {
        break label188;
      }
      if (!this.dAj) {
        break label168;
      }
      this.mFileName = w.Rq(z.aTY());
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
      if (this.dAk) {
        this.mFileName = w.Rq("medianote");
      } else {
        label188:
        this.mFileName = com.tencent.mm.modelvoice.s.Rh(paramString);
      }
    }
    label199:
    this.dAo = false;
    this.dAu.Yo();
    AppMethodBeat.o(148340);
    return true;
  }
  
  public final boolean isRecording()
  {
    AppMethodBeat.i(148338);
    if (this.dAg == null)
    {
      AppMethodBeat.o(148338);
      return false;
    }
    if (this.dAg.getStatus() == 1)
    {
      AppMethodBeat.o(148338);
      return true;
    }
    AppMethodBeat.o(148338);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(148337);
    if (this.dAg != null)
    {
      this.dAg.ZZ();
      this.dtz.apm();
      Log.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.dAl = 0L;
    this.dAh = null;
    this.dAr = c.a.gCQ;
    this.dAq = 0;
    this.dAm = 0L;
    AppMethodBeat.o(148337);
  }
  
  final class a
    implements com.tencent.f.i.h
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
          if (h.this.dAs == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.SceneVoice.Recorder", bool);
            h.e(h.this);
            if (h.this.dAs != null) {
              h.this.dAs.aYN();
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
          try
          {
            Object localObject1 = com.tencent.mm.modelvoice.s.aTa();
            Object localObject3 = com.tencent.mm.b.g.getMessageDigest(h.c(h.this).getBytes());
            localObject3 = (String)localObject1 + ((String)localObject3).substring(0, 2) + '/' + ((String)localObject3).substring(2, 4) + '/';
            localObject1 = new com.tencent.mm.vfs.o((String)localObject3);
            localObject3 = new com.tencent.mm.vfs.o((String)localObject3);
            if ((((com.tencent.mm.vfs.o)localObject1).exists()) && (!((com.tencent.mm.vfs.o)localObject3).exists()))
            {
              com.tencent.mm.plugin.report.service.h.CyF.n(357L, 59L, 1L);
              g.e locale = com.tencent.mm.vfs.g.hRR().a(((com.tencent.mm.vfs.o)localObject1).mUri, null);
              Log.e("DEBUG.VFS", "Resolution: " + locale.toString());
              Log.e("DEBUG.VFS", "VFS Path: " + aa.z(((com.tencent.mm.vfs.o)localObject1).mUri));
              Log.e("DEBUG.VFS", "VFS Real path: " + com.tencent.mm.vfs.s.k(aa.z(((com.tencent.mm.vfs.o)localObject1).mUri), false));
              Log.e("DEBUG.VFS", "File absolute path: " + aa.z(((com.tencent.mm.vfs.o)localObject3).her()));
            }
            localObject1 = h.c(h.this);
            if (!h.h(h.this))
            {
              bool = true;
              localObject1 = com.tencent.mm.modelvoice.s.Y((String)localObject1, bool);
              Log.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { localObject1, Boolean.valueOf(h.h(h.this)) });
              if (h.g(h.this).hw((String)localObject1)) {
                break label573;
              }
              com.tencent.mm.modelvoice.s.Rk(h.c(h.this));
              h.i(h.this);
              h.j(h.this);
              Log.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.c(h.this) + "]");
              h.a(h.this, Util.currentTicks());
              Log.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.c(h.this) + "] time:" + Util.ticksToNow(h.l(h.this)));
              this.handler.sendEmptyMessageDelayed(0, 1L);
              AppMethodBeat.o(148335);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoice.Recorder", localThrowable, "Failed to detect error", new Object[0]);
            continue;
          }
        }
        boolean bool = false;
        continue;
        label573:
        h.k(h.this).requestFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.h
 * JD-Core Version:    0.7.0.1
 */