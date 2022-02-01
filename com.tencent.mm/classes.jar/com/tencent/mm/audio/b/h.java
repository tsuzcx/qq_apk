package com.tencent.mm.audio.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k;
import com.tencent.mm.al.k.a;
import com.tencent.mm.al.k.b;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.a.e;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import d.y;

public class h
  implements k
{
  private static boolean cel = false;
  private com.tencent.mm.compatible.util.b cST;
  private a cZg;
  private a cZh;
  private String cZi;
  private boolean cZj;
  private boolean cZk;
  private long cZl;
  private long cZm;
  public int cZn;
  private boolean cZo;
  private boolean cZp;
  private int cZq;
  private c.a cZr;
  protected k.b cZs;
  protected k.a cZt;
  private com.tencent.mm.audio.b cZu;
  private av cZv;
  private Runnable cZw;
  private String mFileName;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(148336);
    this.cZg = null;
    this.cZh = null;
    this.mFileName = "";
    this.cZj = false;
    this.cZk = false;
    this.cZm = 0L;
    this.cZn = 0;
    this.cZo = false;
    this.cZp = false;
    this.cZq = 0;
    this.cZr = c.a.fyJ;
    this.cZt = null;
    this.cZv = new av(new h.2(this), true);
    this.cST = new com.tencent.mm.compatible.util.b(paramContext);
    this.cZp = paramBoolean;
    this.cZu = new com.tencent.mm.audio.b(new d.g.a.b() {});
    ad.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148336);
  }
  
  public boolean Ft()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148342);
    if (this.cZv != null)
    {
      this.cZv.stopTimer();
      this.cZv.removeCallbacksAndMessages(null);
    }
    this.cZu.My();
    this.cZn = ((int)Ou());
    ad.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.cZn) });
    if ((this.cZg != null) && (!bt.isNullOrNil(this.mFileName)) && (!this.cZp))
    {
      com.tencent.mm.compatible.f.a locala = new com.tencent.mm.compatible.f.a();
      locala.fGf = this.mFileName;
      locala.fGg = this.cZn;
      locala.fGh = 2;
      locala.deV = this.cZg.Oc();
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10513, locala.XD());
    }
    try
    {
      ad.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, this.cZg, Long.valueOf(Thread.currentThread().getId()), this });
      if (this.cZg != null)
      {
        this.cZg.Ob();
        this.cST.XF();
      }
      if (this.cZq != 2)
      {
        s.AC(this.mFileName);
        this.mFileName = null;
        ad.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bt.aS(this.cZl));
        bool1 = bool2;
        this.cZq = -1;
        AppMethodBeat.o(148342);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(148342);
    }
    if ((this.cZn < 800L) || ((this.cZj) && (this.cZn < 1000L)))
    {
      ad.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.cZn);
      s.AC(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      s.aq(this.mFileName, this.cZn);
      o.aDA().run();
      ad.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final int Os()
  {
    return this.cZn;
  }
  
  public final void Ot()
  {
    AppMethodBeat.i(148343);
    ad.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", new Object[] { this.mFileName });
    if (this.cZv != null)
    {
      this.cZv.stopTimer();
      this.cZv.removeCallbacksAndMessages(null);
    }
    this.cZu.My();
    try
    {
      ad.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.cZg != null)
      {
        this.cZg.Ob();
        this.cST.XF();
      }
      this.cZq = -1;
      AppMethodBeat.o(148343);
      return;
    }
    finally
    {
      AppMethodBeat.o(148343);
    }
  }
  
  public final long Ou()
  {
    AppMethodBeat.i(148345);
    if (this.cZm == 0L)
    {
      AppMethodBeat.o(148345);
      return 0L;
    }
    long l = bt.aS(this.cZm);
    AppMethodBeat.o(148345);
    return l;
  }
  
  public final int Ov()
  {
    if (this.cZp) {
      return 1;
    }
    if ((this.cZr == c.a.fyF) || (this.cZr == c.a.fyG)) {
      return 0;
    }
    if (this.cZr == c.a.fyH) {
      return 2;
    }
    return -1;
  }
  
  public final void a(k.a parama)
  {
    this.cZt = parama;
  }
  
  public final void a(k.b paramb)
  {
    this.cZs = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(148341);
    ad.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
    try
    {
      ad.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.cZg != null)
      {
        this.cZg.Ob();
        this.cST.XF();
      }
      this.cZu.My();
      s.AA(this.mFileName);
      o.aDA().run();
      if ((this.cZg != null) && (!bt.isNullOrNil(this.mFileName)) && (!this.cZp))
      {
        com.tencent.mm.compatible.f.a locala = new com.tencent.mm.compatible.f.a();
        locala.fGf = this.mFileName;
        locala.fGg = Ou();
        locala.fGh = 1;
        locala.deV = this.cZg.Oc();
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10513, locala.XD());
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
  
  public final boolean fP(String paramString)
  {
    AppMethodBeat.i(148340);
    ad.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(paramString)));
    reset();
    this.cZi = paramString;
    this.cZl = bt.GC();
    if (paramString == null)
    {
      ad.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      AppMethodBeat.o(148340);
      return false;
    }
    this.cZj = paramString.equals("_USER_FOR_THROWBOTTLE_");
    boolean bool;
    if (paramString.equals("medianote"))
    {
      if ((u.aqK() & 0x4000) == 0)
      {
        bool = true;
        this.cZk = bool;
      }
    }
    else
    {
      if (this.cZp) {
        break label188;
      }
      if (!this.cZj) {
        break label168;
      }
      this.mFileName = w.AI(u.aqG());
    }
    for (;;)
    {
      if ((this.mFileName != null) && (this.mFileName.length() > 0)) {
        break label199;
      }
      ad.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[] { this.mFileName });
      AppMethodBeat.o(148340);
      return false;
      bool = false;
      break;
      label168:
      if (this.cZk) {
        this.mFileName = w.AI("medianote");
      } else {
        label188:
        this.mFileName = s.Az(paramString);
      }
    }
    label199:
    this.cZo = false;
    this.cZu.Mx();
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
    if (this.cZg == null)
    {
      AppMethodBeat.o(148339);
      return 0;
    }
    int i = this.cZg.getMaxAmplitude();
    AppMethodBeat.o(148339);
    return i;
  }
  
  public final boolean isRecording()
  {
    AppMethodBeat.i(148338);
    if (this.cZg == null)
    {
      AppMethodBeat.o(148338);
      return false;
    }
    if (this.cZg.getStatus() == 1)
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
    if (this.cZg != null)
    {
      this.cZg.Ob();
      this.cST.XF();
      ad.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.cZl = 0L;
    this.cZh = null;
    this.cZr = c.a.fyJ;
    this.cZq = 0;
    this.cZm = 0L;
    AppMethodBeat.o(148337);
  }
  
  final class a
    implements com.tencent.e.i.h
  {
    ap handler;
    
    public a()
    {
      AppMethodBeat.i(148334);
      this.handler = new ap()
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
          if (h.this.cZs == null) {}
          for (boolean bool = true;; bool = false)
          {
            ad.d("MicroMsg.SceneVoice.Recorder", bool);
            h.e(h.this);
            if (h.this.cZs != null) {
              h.this.cZs.auN();
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
      aq.az(h.f(h.this));
      ad.i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      for (;;)
      {
        synchronized (h.this)
        {
          ad.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", new Object[] { Long.valueOf(Thread.currentThread().getId()), h.this });
          if (h.g(h.this) == null)
          {
            ad.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
            AppMethodBeat.o(148335);
            return;
          }
          try
          {
            Object localObject1 = s.apY();
            Object localObject3 = g.getMessageDigest(h.c(h.this).getBytes());
            localObject3 = (String)localObject1 + ((String)localObject3).substring(0, 2) + '/' + ((String)localObject3).substring(2, 4) + '/';
            localObject1 = new e((String)localObject3);
            localObject3 = new e((String)localObject3);
            if ((((e)localObject1).exists()) && (!((e)localObject3).exists()))
            {
              com.tencent.mm.plugin.report.service.h.vKh.m(357L, 59L, 1L);
              a.e locale = com.tencent.mm.vfs.a.gap().a(((e)localObject1).mUri, null);
              ad.e("DEBUG.VFS", "Resolution: " + locale.toString());
              ad.e("DEBUG.VFS", "VFS Path: " + q.B(((e)localObject1).mUri));
              ad.e("DEBUG.VFS", "VFS Real path: " + com.tencent.mm.vfs.i.k(q.B(((e)localObject1).mUri), false));
              ad.e("DEBUG.VFS", "File absolute path: " + q.B(((e)localObject3).fhU()));
            }
            localObject1 = h.c(h.this);
            if (!h.h(h.this))
            {
              bool = true;
              localObject1 = s.X((String)localObject1, bool);
              ad.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { localObject1, Boolean.valueOf(h.h(h.this)) });
              if (h.g(h.this).fO((String)localObject1)) {
                break label573;
              }
              s.AC(h.c(h.this));
              h.i(h.this);
              h.j(h.this);
              ad.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.c(h.this) + "]");
              h.a(h.this, bt.GC());
              ad.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.c(h.this) + "] time:" + bt.aS(h.l(h.this)));
              this.handler.sendEmptyMessageDelayed(0, 1L);
              AppMethodBeat.o(148335);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            ad.printErrStackTrace("MicroMsg.SceneVoice.Recorder", localThrowable, "Failed to detect error", new Object[0]);
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