package com.tencent.mm.audio.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.m;
import com.tencent.mm.an.m.a;
import com.tencent.mm.an.m.b;
import com.tencent.mm.b.g;
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
import com.tencent.mm.vfs.h.e;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.x;

public class h
  implements m
{
  private static boolean cwe = false;
  private com.tencent.mm.compatible.util.b fmh;
  private a fsV;
  private a fsW;
  private String fsX;
  private boolean fsY;
  private boolean fsZ;
  private long fta;
  private long ftb;
  public int ftc;
  private boolean ftd;
  private boolean fte;
  private int ftf;
  private c.a ftg;
  protected m.b fth;
  protected m.a fti;
  private com.tencent.mm.audio.b ftj;
  private MTimerHandler ftk;
  private Runnable ftl;
  private String mFileName;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(148336);
    this.fsV = null;
    this.fsW = null;
    this.mFileName = "";
    this.fsY = false;
    this.fsZ = false;
    this.ftb = 0L;
    this.ftc = 0;
    this.ftd = false;
    this.fte = false;
    this.ftf = 0;
    this.ftg = c.a.jmW;
    this.fti = null;
    this.ftk = new MTimerHandler(new h.2(this), true);
    this.fmh = new com.tencent.mm.compatible.util.b(paramContext);
    this.fte = paramBoolean;
    this.ftj = new com.tencent.mm.audio.b(new kotlin.g.a.b() {});
    Log.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148336);
  }
  
  public boolean TV()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148342);
    if (this.ftk != null)
    {
      this.ftk.stopTimer();
      this.ftk.removeCallbacksAndMessages(null);
    }
    this.ftj.acV();
    this.ftc = ((int)aff());
    Log.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.ftc) });
    if ((this.fsV != null) && (!Util.isNullOrNil(this.mFileName)) && (!this.fte))
    {
      com.tencent.mm.compatible.g.a locala = new com.tencent.mm.compatible.g.a();
      locala.jvr = this.mFileName;
      locala.jvs = this.ftc;
      locala.jvt = 2;
      locala.fyO = this.fsV.aeL();
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10513, locala.avw());
    }
    try
    {
      Log.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, this.fsV, Long.valueOf(Thread.currentThread().getId()), this });
      if (this.fsV != null)
      {
        this.fsV.aeJ();
        this.fmh.avz();
      }
      if (this.ftf != 2)
      {
        s.YH(this.mFileName);
        this.mFileName = null;
        Log.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + Util.ticksToNow(this.fta));
        bool1 = bool2;
        this.ftf = -1;
        AppMethodBeat.o(148342);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(148342);
    }
    if ((this.ftc < 800L) || ((this.fsY) && (this.ftc < 1000L)))
    {
      Log.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.ftc);
      s.YH(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      s.aU(this.mFileName, this.ftc);
      o.brB().run();
      Log.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final void a(m.a parama)
  {
    this.fti = parama;
  }
  
  public final void a(m.b paramb)
  {
    this.fth = paramb;
  }
  
  public final int aeK()
  {
    AppMethodBeat.i(148339);
    if (this.fsV == null)
    {
      AppMethodBeat.o(148339);
      return 0;
    }
    int i = this.fsV.aeK();
    AppMethodBeat.o(148339);
    return i;
  }
  
  public final int afc()
  {
    return this.ftc;
  }
  
  public final boolean afd()
  {
    AppMethodBeat.i(227359);
    boolean bool = il("_USER_FOR_THROWBOTTLE_");
    AppMethodBeat.o(227359);
    return bool;
  }
  
  public final void afe()
  {
    AppMethodBeat.i(148343);
    Log.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", new Object[] { this.mFileName });
    if (this.ftk != null)
    {
      this.ftk.stopTimer();
      this.ftk.removeCallbacksAndMessages(null);
    }
    this.ftj.acV();
    try
    {
      Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.fsV != null)
      {
        this.fsV.aeJ();
        this.fmh.avz();
      }
      this.ftf = -1;
      AppMethodBeat.o(148343);
      return;
    }
    finally
    {
      AppMethodBeat.o(148343);
    }
  }
  
  public final long aff()
  {
    AppMethodBeat.i(148345);
    if (this.ftb == 0L)
    {
      AppMethodBeat.o(148345);
      return 0L;
    }
    long l = Util.ticksToNow(this.ftb);
    AppMethodBeat.o(148345);
    return l;
  }
  
  public final int afg()
  {
    if (this.fte) {
      return 1;
    }
    if ((this.ftg == c.a.jmS) || (this.ftg == c.a.jmT)) {
      return 0;
    }
    if (this.ftg == c.a.jmU) {
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
      if (this.fsV != null)
      {
        this.fsV.aeJ();
        this.fmh.avz();
      }
      this.ftj.acV();
      s.YF(this.mFileName);
      o.brB().run();
      if ((this.fsV != null) && (!Util.isNullOrNil(this.mFileName)) && (!this.fte))
      {
        com.tencent.mm.compatible.g.a locala = new com.tencent.mm.compatible.g.a();
        locala.jvr = this.mFileName;
        locala.jvs = aff();
        locala.jvt = 1;
        locala.fyO = this.fsV.aeL();
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10513, locala.avw());
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
  
  public final boolean il(String paramString)
  {
    AppMethodBeat.i(148340);
    Log.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(paramString)));
    reset();
    this.fsX = paramString;
    this.fta = Util.currentTicks();
    if (paramString == null)
    {
      Log.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      AppMethodBeat.o(148340);
      return false;
    }
    this.fsY = paramString.equals("_USER_FOR_THROWBOTTLE_");
    boolean bool;
    if (paramString.equals("medianote"))
    {
      if ((z.bdd() & 0x4000) == 0)
      {
        bool = true;
        this.fsZ = bool;
      }
    }
    else
    {
      if (this.fte) {
        break label188;
      }
      if (!this.fsY) {
        break label168;
      }
      this.mFileName = w.YN(z.bcZ());
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
      if (this.fsZ) {
        this.mFileName = w.YN("medianote");
      } else {
        label188:
        this.mFileName = s.YE(paramString);
      }
    }
    label199:
    this.ftd = false;
    this.ftj.acU();
    AppMethodBeat.o(148340);
    return true;
  }
  
  public final boolean isRecording()
  {
    AppMethodBeat.i(148338);
    if (this.fsV == null)
    {
      AppMethodBeat.o(148338);
      return false;
    }
    if (this.fsV.getStatus() == 1)
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
    if (this.fsV != null)
    {
      this.fsV.aeJ();
      this.fmh.avz();
      Log.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.fta = 0L;
    this.fsW = null;
    this.ftg = c.a.jmW;
    this.ftf = 0;
    this.ftb = 0L;
    AppMethodBeat.o(148337);
  }
  
  final class a
    implements com.tencent.e.i.h
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
          if (h.this.fth == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.SceneVoice.Recorder", bool);
            h.e(h.this);
            if (h.this.fth != null) {
              h.this.fth.bic();
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
            Object localObject1 = s.bbY();
            Object localObject3 = g.getMessageDigest(h.c(h.this).getBytes());
            localObject3 = (String)localObject1 + ((String)localObject3).substring(0, 2) + '/' + ((String)localObject3).substring(2, 4) + '/';
            localObject1 = new q((String)localObject3);
            localObject3 = new q((String)localObject3);
            if ((((q)localObject1).ifE()) && (!((q)localObject3).ifE()))
            {
              com.tencent.mm.plugin.report.service.h.IzE.p(357L, 59L, 1L);
              h.e locale = com.tencent.mm.vfs.h.iWH().p(((q)localObject1).getUri());
              Log.e("DEBUG.VFS", "Resolution: " + locale.toString());
              Log.e("DEBUG.VFS", "VFS Path: " + ((q)localObject1).getPath());
              Log.e("DEBUG.VFS", "VFS Real path: " + u.n(((q)localObject1).getPath(), false));
              Log.e("DEBUG.VFS", "File absolute path: " + ((q)localObject3).bOF());
            }
            localObject1 = h.c(h.this);
            if (!h.h(h.this))
            {
              bool = true;
              localObject1 = s.aa((String)localObject1, bool);
              Log.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { localObject1, Boolean.valueOf(h.h(h.this)) });
              if (h.g(h.this).ik((String)localObject1)) {
                break label563;
              }
              s.YH(h.c(h.this));
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
        label563:
        h.k(h.this).avy();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.b.h
 * JD-Core Version:    0.7.0.1
 */