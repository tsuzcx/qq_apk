package com.tencent.mm.audio.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.ak.j.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.e.e;
import com.tencent.mm.vfs.k;
import d.z;

public class h
  implements j
{
  private static boolean clB = false;
  private com.tencent.mm.compatible.util.b dcI;
  private a diV;
  private a diW;
  private String diX;
  private boolean diY;
  private boolean diZ;
  private long dja;
  private long djb;
  public int djc;
  private boolean djd;
  private boolean dje;
  private int djf;
  private c.a djg;
  protected j.b djh;
  protected j.a dji;
  private com.tencent.mm.audio.b djj;
  private aw djk;
  private Runnable djl;
  private String mFileName;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(148336);
    this.diV = null;
    this.diW = null;
    this.mFileName = "";
    this.diY = false;
    this.diZ = false;
    this.djb = 0L;
    this.djc = 0;
    this.djd = false;
    this.dje = false;
    this.djf = 0;
    this.djg = c.a.fXK;
    this.dji = null;
    this.djk = new aw(new h.2(this), true);
    this.dcI = new com.tencent.mm.compatible.util.b(paramContext);
    this.dje = paramBoolean;
    this.djj = new com.tencent.mm.audio.b(new d.g.a.b() {});
    ae.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148336);
  }
  
  public boolean GB()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148342);
    if (this.djk != null)
    {
      this.djk.stopTimer();
      this.djk.removeCallbacksAndMessages(null);
    }
    this.djj.Od();
    this.djc = ((int)PY());
    ae.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.djc) });
    if ((this.diV != null) && (!bu.isNullOrNil(this.mFileName)) && (!this.dje))
    {
      com.tencent.mm.compatible.f.a locala = new com.tencent.mm.compatible.f.a();
      locala.gfv = this.mFileName;
      locala.gfw = this.djc;
      locala.gfx = 2;
      locala.doQ = this.diV.PG();
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10513, locala.abl());
    }
    try
    {
      ae.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, this.diV, Long.valueOf(Thread.currentThread().getId()), this });
      if (this.diV != null)
      {
        this.diV.PF();
        this.dcI.abn();
      }
      if (this.djf != 2)
      {
        s.Iy(this.mFileName);
        this.mFileName = null;
        ae.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bu.aO(this.dja));
        bool1 = bool2;
        this.djf = -1;
        AppMethodBeat.o(148342);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(148342);
    }
    if ((this.djc < 800L) || ((this.diY) && (this.djc < 1000L)))
    {
      ae.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.djc);
      s.Iy(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      s.ax(this.mFileName, this.djc);
      com.tencent.mm.modelvoice.o.aNY().run();
      ae.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final int PW()
  {
    return this.djc;
  }
  
  public final void PX()
  {
    AppMethodBeat.i(148343);
    ae.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", new Object[] { this.mFileName });
    if (this.djk != null)
    {
      this.djk.stopTimer();
      this.djk.removeCallbacksAndMessages(null);
    }
    this.djj.Od();
    try
    {
      ae.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.diV != null)
      {
        this.diV.PF();
        this.dcI.abn();
      }
      this.djf = -1;
      AppMethodBeat.o(148343);
      return;
    }
    finally
    {
      AppMethodBeat.o(148343);
    }
  }
  
  public final long PY()
  {
    AppMethodBeat.i(148345);
    if (this.djb == 0L)
    {
      AppMethodBeat.o(148345);
      return 0L;
    }
    long l = bu.aO(this.djb);
    AppMethodBeat.o(148345);
    return l;
  }
  
  public final int PZ()
  {
    if (this.dje) {
      return 1;
    }
    if ((this.djg == c.a.fXG) || (this.djg == c.a.fXH)) {
      return 0;
    }
    if (this.djg == c.a.fXI) {
      return 2;
    }
    return -1;
  }
  
  public final void a(j.a parama)
  {
    this.dji = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.djh = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(148341);
    ae.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
    try
    {
      ae.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.diV != null)
      {
        this.diV.PF();
        this.dcI.abn();
      }
      this.djj.Od();
      s.Iw(this.mFileName);
      com.tencent.mm.modelvoice.o.aNY().run();
      if ((this.diV != null) && (!bu.isNullOrNil(this.mFileName)) && (!this.dje))
      {
        com.tencent.mm.compatible.f.a locala = new com.tencent.mm.compatible.f.a();
        locala.gfv = this.mFileName;
        locala.gfw = PY();
        locala.gfx = 1;
        locala.doQ = this.diV.PG();
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10513, locala.abl());
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
  
  public final boolean gG(String paramString)
  {
    AppMethodBeat.i(148340);
    ae.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(paramString)));
    reset();
    this.diX = paramString;
    this.dja = bu.HQ();
    if (paramString == null)
    {
      ae.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      AppMethodBeat.o(148340);
      return false;
    }
    this.diY = paramString.equals("_USER_FOR_THROWBOTTLE_");
    boolean bool;
    if (paramString.equals("medianote"))
    {
      if ((v.aAG() & 0x4000) == 0)
      {
        bool = true;
        this.diZ = bool;
      }
    }
    else
    {
      if (this.dje) {
        break label188;
      }
      if (!this.diY) {
        break label168;
      }
      this.mFileName = com.tencent.mm.modelvoice.w.IE(v.aAC());
    }
    for (;;)
    {
      if ((this.mFileName != null) && (this.mFileName.length() > 0)) {
        break label199;
      }
      ae.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[] { this.mFileName });
      AppMethodBeat.o(148340);
      return false;
      bool = false;
      break;
      label168:
      if (this.diZ) {
        this.mFileName = com.tencent.mm.modelvoice.w.IE("medianote");
      } else {
        label188:
        this.mFileName = s.Iv(paramString);
      }
    }
    label199:
    this.djd = false;
    this.djj.Oc();
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
    if (this.diV == null)
    {
      AppMethodBeat.o(148339);
      return 0;
    }
    int i = this.diV.getMaxAmplitude();
    AppMethodBeat.o(148339);
    return i;
  }
  
  public final boolean isRecording()
  {
    AppMethodBeat.i(148338);
    if (this.diV == null)
    {
      AppMethodBeat.o(148338);
      return false;
    }
    if (this.diV.getStatus() == 1)
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
    if (this.diV != null)
    {
      this.diV.PF();
      this.dcI.abn();
      ae.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.dja = 0L;
    this.diW = null;
    this.djg = c.a.fXK;
    this.djf = 0;
    this.djb = 0L;
    AppMethodBeat.o(148337);
  }
  
  final class a
    implements com.tencent.e.i.h
  {
    aq handler;
    
    public a()
    {
      AppMethodBeat.i(148334);
      this.handler = new aq()
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
          if (h.this.djh == null) {}
          for (boolean bool = true;; bool = false)
          {
            ae.d("MicroMsg.SceneVoice.Recorder", bool);
            h.e(h.this);
            if (h.this.djh != null) {
              h.this.djh.aEY();
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
      ar.ay(h.f(h.this));
      ae.i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      for (;;)
      {
        synchronized (h.this)
        {
          ae.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", new Object[] { Long.valueOf(Thread.currentThread().getId()), h.this });
          if (h.g(h.this) == null)
          {
            ae.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
            AppMethodBeat.o(148335);
            return;
          }
          try
          {
            Object localObject1 = s.azS();
            Object localObject3 = com.tencent.mm.b.g.getMessageDigest(h.c(h.this).getBytes());
            localObject3 = (String)localObject1 + ((String)localObject3).substring(0, 2) + '/' + ((String)localObject3).substring(2, 4) + '/';
            localObject1 = new k((String)localObject3);
            localObject3 = new k((String)localObject3);
            if ((((k)localObject1).exists()) && (!((k)localObject3).exists()))
            {
              com.tencent.mm.plugin.report.service.g.yxI.n(357L, 59L, 1L);
              e.e locale = e.fSU().a(((k)localObject1).mUri, null);
              ae.e("DEBUG.VFS", "Resolution: " + locale.toString());
              ae.e("DEBUG.VFS", "VFS Path: " + com.tencent.mm.vfs.w.B(((k)localObject1).mUri));
              ae.e("DEBUG.VFS", "VFS Real path: " + com.tencent.mm.vfs.o.k(com.tencent.mm.vfs.w.B(((k)localObject1).mUri), false));
              ae.e("DEBUG.VFS", "File absolute path: " + com.tencent.mm.vfs.w.B(((k)localObject3).fTh()));
            }
            localObject1 = h.c(h.this);
            if (!h.h(h.this))
            {
              bool = true;
              localObject1 = s.Y((String)localObject1, bool);
              ae.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { localObject1, Boolean.valueOf(h.h(h.this)) });
              if (h.g(h.this).gF((String)localObject1)) {
                break label573;
              }
              s.Iy(h.c(h.this));
              h.i(h.this);
              h.j(h.this);
              ae.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.c(h.this) + "]");
              h.a(h.this, bu.HQ());
              ae.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.c(h.this) + "] time:" + bu.aO(h.l(h.this)));
              this.handler.sendEmptyMessageDelayed(0, 1L);
              AppMethodBeat.o(148335);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            ae.printErrStackTrace("MicroMsg.SceneVoice.Recorder", localThrowable, "Failed to detect error", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.h
 * JD-Core Version:    0.7.0.1
 */