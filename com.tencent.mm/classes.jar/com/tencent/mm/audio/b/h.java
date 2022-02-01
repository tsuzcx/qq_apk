package com.tencent.mm.audio.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.a.e;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import d.y;

public class h
  implements k
{
  private static boolean cbi = false;
  private com.tencent.mm.compatible.util.b cQq;
  private a cWC;
  private a cWD;
  private String cWE;
  private boolean cWF;
  private boolean cWG;
  private long cWH;
  private long cWI;
  public int cWJ;
  private boolean cWK;
  private boolean cWL;
  private int cWM;
  private c.a cWN;
  protected k.b cWO;
  protected k.a cWP;
  private com.tencent.mm.audio.b cWQ;
  private au cWR;
  private Runnable cWS;
  private String mFileName;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(148336);
    this.cWC = null;
    this.cWD = null;
    this.mFileName = "";
    this.cWF = false;
    this.cWG = false;
    this.cWI = 0L;
    this.cWJ = 0;
    this.cWK = false;
    this.cWL = false;
    this.cWM = 0;
    this.cWN = c.a.fCq;
    this.cWP = null;
    this.cWR = new au(new h.2(this), true);
    this.cQq = new com.tencent.mm.compatible.util.b(paramContext);
    this.cWL = paramBoolean;
    this.cWQ = new com.tencent.mm.audio.b(new d.g.a.b() {});
    ac.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148336);
  }
  
  public boolean Fb()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148342);
    if (this.cWR != null)
    {
      this.cWR.stopTimer();
      this.cWR.removeCallbacksAndMessages(null);
    }
    this.cWQ.Mw();
    this.cWJ = ((int)Oq());
    ac.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.cWJ) });
    if ((this.cWC != null) && (!bs.isNullOrNil(this.mFileName)) && (!this.cWL))
    {
      com.tencent.mm.compatible.f.a locala = new com.tencent.mm.compatible.f.a();
      locala.fJM = this.mFileName;
      locala.fJN = this.cWJ;
      locala.fJO = 2;
      locala.dcp = this.cWC.NY();
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10513, locala.YA());
    }
    try
    {
      ac.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, this.cWC, Long.valueOf(Thread.currentThread().getId()), this });
      if (this.cWC != null)
      {
        this.cWC.NX();
        this.cQq.YC();
      }
      if (this.cWM != 2)
      {
        s.EH(this.mFileName);
        this.mFileName = null;
        ac.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bs.aO(this.cWH));
        bool1 = bool2;
        this.cWM = -1;
        AppMethodBeat.o(148342);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(148342);
    }
    if ((this.cWJ < 800L) || ((this.cWF) && (this.cWJ < 1000L)))
    {
      ac.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.cWJ);
      s.EH(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      s.au(this.mFileName, this.cWJ);
      o.aKr().run();
      ac.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final int Oo()
  {
    return this.cWJ;
  }
  
  public final void Op()
  {
    AppMethodBeat.i(148343);
    ac.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", new Object[] { this.mFileName });
    if (this.cWR != null)
    {
      this.cWR.stopTimer();
      this.cWR.removeCallbacksAndMessages(null);
    }
    this.cWQ.Mw();
    try
    {
      ac.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.cWC != null)
      {
        this.cWC.NX();
        this.cQq.YC();
      }
      this.cWM = -1;
      AppMethodBeat.o(148343);
      return;
    }
    finally
    {
      AppMethodBeat.o(148343);
    }
  }
  
  public final long Oq()
  {
    AppMethodBeat.i(148345);
    if (this.cWI == 0L)
    {
      AppMethodBeat.o(148345);
      return 0L;
    }
    long l = bs.aO(this.cWI);
    AppMethodBeat.o(148345);
    return l;
  }
  
  public final int Or()
  {
    if (this.cWL) {
      return 1;
    }
    if ((this.cWN == c.a.fCm) || (this.cWN == c.a.fCn)) {
      return 0;
    }
    if (this.cWN == c.a.fCo) {
      return 2;
    }
    return -1;
  }
  
  public final void a(k.a parama)
  {
    this.cWP = parama;
  }
  
  public final void a(k.b paramb)
  {
    this.cWO = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(148341);
    ac.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
    try
    {
      ac.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.cWC != null)
      {
        this.cWC.NX();
        this.cQq.YC();
      }
      this.cWQ.Mw();
      s.EF(this.mFileName);
      o.aKr().run();
      if ((this.cWC != null) && (!bs.isNullOrNil(this.mFileName)) && (!this.cWL))
      {
        com.tencent.mm.compatible.f.a locala = new com.tencent.mm.compatible.f.a();
        locala.fJM = this.mFileName;
        locala.fJN = Oq();
        locala.fJO = 1;
        locala.dcp = this.cWC.NY();
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10513, locala.YA());
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
  
  public final boolean fF(String paramString)
  {
    AppMethodBeat.i(148340);
    ac.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(paramString)));
    reset();
    this.cWE = paramString;
    this.cWH = bs.Gn();
    if (paramString == null)
    {
      ac.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      AppMethodBeat.o(148340);
      return false;
    }
    this.cWF = paramString.equals("_USER_FOR_THROWBOTTLE_");
    boolean bool;
    if (paramString.equals("medianote"))
    {
      if ((u.axA() & 0x4000) == 0)
      {
        bool = true;
        this.cWG = bool;
      }
    }
    else
    {
      if (this.cWL) {
        break label188;
      }
      if (!this.cWF) {
        break label168;
      }
      this.mFileName = w.EN(u.axw());
    }
    for (;;)
    {
      if ((this.mFileName != null) && (this.mFileName.length() > 0)) {
        break label199;
      }
      ac.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[] { this.mFileName });
      AppMethodBeat.o(148340);
      return false;
      bool = false;
      break;
      label168:
      if (this.cWG) {
        this.mFileName = w.EN("medianote");
      } else {
        label188:
        this.mFileName = s.EE(paramString);
      }
    }
    label199:
    this.cWK = false;
    this.cWQ.Mv();
    AppMethodBeat.o(148340);
    return true;
  }
  
  public String getFileName()
  {
    return this.mFileName;
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(148339);
    if (this.cWC == null)
    {
      AppMethodBeat.o(148339);
      return 0;
    }
    int i = this.cWC.getMaxAmplitude();
    AppMethodBeat.o(148339);
    return i;
  }
  
  public final boolean isRecording()
  {
    AppMethodBeat.i(148338);
    if (this.cWC == null)
    {
      AppMethodBeat.o(148338);
      return false;
    }
    if (this.cWC.getStatus() == 1)
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
    if (this.cWC != null)
    {
      this.cWC.NX();
      this.cQq.YC();
      ac.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.cWH = 0L;
    this.cWD = null;
    this.cWN = c.a.fCq;
    this.cWM = 0;
    this.cWI = 0L;
    AppMethodBeat.o(148337);
  }
  
  final class a
    implements com.tencent.e.i.h
  {
    ao handler;
    
    public a()
    {
      AppMethodBeat.i(148334);
      this.handler = new ao()
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
          if (h.this.cWO == null) {}
          for (boolean bool = true;; bool = false)
          {
            ac.d("MicroMsg.SceneVoice.Recorder", bool);
            h.e(h.this);
            if (h.this.cWO != null) {
              h.this.cWO.aBG();
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
      ap.aB(h.f(h.this));
      ac.i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      for (;;)
      {
        synchronized (h.this)
        {
          ac.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", new Object[] { Long.valueOf(Thread.currentThread().getId()), h.this });
          if (h.g(h.this) == null)
          {
            ac.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
            AppMethodBeat.o(148335);
            return;
          }
          try
          {
            Object localObject1 = s.awN();
            Object localObject3 = g.getMessageDigest(h.c(h.this).getBytes());
            localObject3 = (String)localObject1 + ((String)localObject3).substring(0, 2) + '/' + ((String)localObject3).substring(2, 4) + '/';
            localObject1 = new e((String)localObject3);
            localObject3 = new e((String)localObject3);
            if ((((e)localObject1).exists()) && (!((e)localObject3).exists()))
            {
              com.tencent.mm.plugin.report.service.h.wUl.n(357L, 59L, 1L);
              a.e locale = com.tencent.mm.vfs.a.ghk().a(((e)localObject1).mUri, null);
              ac.e("DEBUG.VFS", "Resolution: " + locale.toString());
              ac.e("DEBUG.VFS", "VFS Path: " + q.B(((e)localObject1).mUri));
              ac.e("DEBUG.VFS", "VFS Real path: " + com.tencent.mm.vfs.i.k(q.B(((e)localObject1).mUri), false));
              ac.e("DEBUG.VFS", "File absolute path: " + q.B(((e)localObject3).fxV()));
            }
            localObject1 = h.c(h.this);
            if (!h.h(h.this))
            {
              bool = true;
              localObject1 = s.Y((String)localObject1, bool);
              ac.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { localObject1, Boolean.valueOf(h.h(h.this)) });
              if (h.g(h.this).fE((String)localObject1)) {
                break label573;
              }
              s.EH(h.c(h.this));
              h.i(h.this);
              h.j(h.this);
              ac.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.c(h.this) + "]");
              h.a(h.this, bs.Gn());
              ac.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.c(h.this) + "] time:" + bs.aO(h.l(h.this)));
              this.handler.sendEmptyMessageDelayed(0, 1L);
              AppMethodBeat.o(148335);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            ac.printErrStackTrace("MicroMsg.SceneVoice.Recorder", localThrowable, "Failed to detect error", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b.h
 * JD-Core Version:    0.7.0.1
 */