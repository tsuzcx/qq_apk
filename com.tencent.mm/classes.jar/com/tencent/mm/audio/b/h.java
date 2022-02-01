package com.tencent.mm.audio.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.j;
import com.tencent.mm.al.j.a;
import com.tencent.mm.al.j.b;
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
import d.z;

public class h
  implements j
{
  private static boolean clz = false;
  private com.tencent.mm.compatible.util.b dbG;
  private a dhS;
  private a dhT;
  private String dhU;
  private boolean dhV;
  private boolean dhW;
  private long dhX;
  private long dhY;
  public int dhZ;
  private boolean dia;
  private boolean dib;
  private int dic;
  private c.a did;
  protected j.b die;
  protected j.a dif;
  private com.tencent.mm.audio.b dig;
  private av dih;
  private Runnable dii;
  private String mFileName;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(148336);
    this.dhS = null;
    this.dhT = null;
    this.mFileName = "";
    this.dhV = false;
    this.dhW = false;
    this.dhY = 0L;
    this.dhZ = 0;
    this.dia = false;
    this.dib = false;
    this.dic = 0;
    this.did = c.a.fVE;
    this.dif = null;
    this.dih = new av(new h.2(this), true);
    this.dbG = new com.tencent.mm.compatible.util.b(paramContext);
    this.dib = paramBoolean;
    this.dig = new com.tencent.mm.audio.b(new d.g.a.b() {});
    ad.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148336);
  }
  
  public boolean Gv()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148342);
    if (this.dih != null)
    {
      this.dih.stopTimer();
      this.dih.removeCallbacksAndMessages(null);
    }
    this.dig.Of();
    this.dhZ = ((int)PZ());
    ad.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.dhZ) });
    if ((this.dhS != null) && (!bt.isNullOrNil(this.mFileName)) && (!this.dib))
    {
      com.tencent.mm.compatible.f.a locala = new com.tencent.mm.compatible.f.a();
      locala.gdn = this.mFileName;
      locala.gdo = this.dhZ;
      locala.gdp = 2;
      locala.dnL = this.dhS.PH();
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10513, locala.abc());
    }
    try
    {
      ad.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, this.dhS, Long.valueOf(Thread.currentThread().getId()), this });
      if (this.dhS != null)
      {
        this.dhS.PG();
        this.dbG.abe();
      }
      if (this.dic != 2)
      {
        s.HW(this.mFileName);
        this.mFileName = null;
        ad.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bt.aO(this.dhX));
        bool1 = bool2;
        this.dic = -1;
        AppMethodBeat.o(148342);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(148342);
    }
    if ((this.dhZ < 800L) || ((this.dhV) && (this.dhZ < 1000L)))
    {
      ad.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.dhZ);
      s.HW(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      s.aw(this.mFileName, this.dhZ);
      o.aNA().run();
      ad.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final int PX()
  {
    return this.dhZ;
  }
  
  public final void PY()
  {
    AppMethodBeat.i(148343);
    ad.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", new Object[] { this.mFileName });
    if (this.dih != null)
    {
      this.dih.stopTimer();
      this.dih.removeCallbacksAndMessages(null);
    }
    this.dig.Of();
    try
    {
      ad.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.dhS != null)
      {
        this.dhS.PG();
        this.dbG.abe();
      }
      this.dic = -1;
      AppMethodBeat.o(148343);
      return;
    }
    finally
    {
      AppMethodBeat.o(148343);
    }
  }
  
  public final long PZ()
  {
    AppMethodBeat.i(148345);
    if (this.dhY == 0L)
    {
      AppMethodBeat.o(148345);
      return 0L;
    }
    long l = bt.aO(this.dhY);
    AppMethodBeat.o(148345);
    return l;
  }
  
  public final int Qa()
  {
    if (this.dib) {
      return 1;
    }
    if ((this.did == c.a.fVA) || (this.did == c.a.fVB)) {
      return 0;
    }
    if (this.did == c.a.fVC) {
      return 2;
    }
    return -1;
  }
  
  public final void a(j.a parama)
  {
    this.dif = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.die = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(148341);
    ad.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
    try
    {
      ad.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.dhS != null)
      {
        this.dhS.PG();
        this.dbG.abe();
      }
      this.dig.Of();
      s.HU(this.mFileName);
      o.aNA().run();
      if ((this.dhS != null) && (!bt.isNullOrNil(this.mFileName)) && (!this.dib))
      {
        com.tencent.mm.compatible.f.a locala = new com.tencent.mm.compatible.f.a();
        locala.gdn = this.mFileName;
        locala.gdo = PZ();
        locala.gdp = 1;
        locala.dnL = this.dhS.PH();
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10513, locala.abc());
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
  
  public final boolean gA(String paramString)
  {
    AppMethodBeat.i(148340);
    ad.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(paramString)));
    reset();
    this.dhU = paramString;
    this.dhX = bt.HI();
    if (paramString == null)
    {
      ad.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      AppMethodBeat.o(148340);
      return false;
    }
    this.dhV = paramString.equals("_USER_FOR_THROWBOTTLE_");
    boolean bool;
    if (paramString.equals("medianote"))
    {
      if ((u.aAq() & 0x4000) == 0)
      {
        bool = true;
        this.dhW = bool;
      }
    }
    else
    {
      if (this.dib) {
        break label188;
      }
      if (!this.dhV) {
        break label168;
      }
      this.mFileName = w.Ic(u.aAm());
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
      if (this.dhW) {
        this.mFileName = w.Ic("medianote");
      } else {
        label188:
        this.mFileName = s.HT(paramString);
      }
    }
    label199:
    this.dia = false;
    this.dig.Oe();
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
    if (this.dhS == null)
    {
      AppMethodBeat.o(148339);
      return 0;
    }
    int i = this.dhS.getMaxAmplitude();
    AppMethodBeat.o(148339);
    return i;
  }
  
  public final boolean isRecording()
  {
    AppMethodBeat.i(148338);
    if (this.dhS == null)
    {
      AppMethodBeat.o(148338);
      return false;
    }
    if (this.dhS.getStatus() == 1)
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
    if (this.dhS != null)
    {
      this.dhS.PG();
      this.dbG.abe();
      ad.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.dhX = 0L;
    this.dhT = null;
    this.did = c.a.fVE;
    this.dic = 0;
    this.dhY = 0L;
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
          if (h.this.die == null) {}
          for (boolean bool = true;; bool = false)
          {
            ad.d("MicroMsg.SceneVoice.Recorder", bool);
            h.e(h.this);
            if (h.this.die != null) {
              h.this.die.aEI();
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
      aq.aA(h.f(h.this));
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
            Object localObject1 = s.azC();
            Object localObject3 = com.tencent.mm.b.g.getMessageDigest(h.c(h.this).getBytes());
            localObject3 = (String)localObject1 + ((String)localObject3).substring(0, 2) + '/' + ((String)localObject3).substring(2, 4) + '/';
            localObject1 = new e((String)localObject3);
            localObject3 = new e((String)localObject3);
            if ((((e)localObject1).exists()) && (!((e)localObject3).exists()))
            {
              com.tencent.mm.plugin.report.service.g.yhR.n(357L, 59L, 1L);
              a.e locale = com.tencent.mm.vfs.a.gzU().a(((e)localObject1).mUri, null);
              ad.e("DEBUG.VFS", "Resolution: " + locale.toString());
              ad.e("DEBUG.VFS", "VFS Path: " + q.B(((e)localObject1).mUri));
              ad.e("DEBUG.VFS", "VFS Real path: " + com.tencent.mm.vfs.i.k(q.B(((e)localObject1).mUri), false));
              ad.e("DEBUG.VFS", "File absolute path: " + q.B(((e)localObject3).fOK()));
            }
            localObject1 = h.c(h.this);
            if (!h.h(h.this))
            {
              bool = true;
              localObject1 = s.Y((String)localObject1, bool);
              ad.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { localObject1, Boolean.valueOf(h.h(h.this)) });
              if (h.g(h.this).gz((String)localObject1)) {
                break label573;
              }
              s.HW(h.c(h.this));
              h.i(h.this);
              h.j(h.this);
              ad.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.c(h.this) + "]");
              h.a(h.this, bt.HI());
              ad.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.c(h.this) + "] time:" + bt.aO(h.l(h.this)));
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