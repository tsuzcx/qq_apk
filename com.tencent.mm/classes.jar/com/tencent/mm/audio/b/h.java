package com.tencent.mm.audio.b;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.ai.j.b;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.v;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public class h
  implements j, g.a
{
  private static boolean bCp = false;
  protected j.a ckA;
  private boolean ckB;
  private ap ckC;
  private Runnable ckD;
  private a ckn;
  private b cko;
  private h.a ckp;
  private String ckq;
  private boolean ckr;
  private boolean cks;
  private long ckt;
  public int cku;
  private boolean ckv;
  private boolean ckw;
  private int ckx;
  private c.a cky;
  protected j.b ckz;
  private String mFileName;
  private long mRecordStartTime;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116502);
    this.ckn = null;
    this.ckp = null;
    this.mFileName = "";
    this.ckr = false;
    this.cks = false;
    this.mRecordStartTime = 0L;
    this.cku = 0;
    this.ckv = false;
    this.ckw = false;
    this.ckx = 0;
    this.cky = c.a.elS;
    this.ckA = null;
    this.ckB = false;
    this.ckC = new ap(new h.1(this), true);
    this.cko = new b(paramContext);
    this.ckw = paramBoolean;
    ab.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(116502);
  }
  
  private void EM()
  {
    AppMethodBeat.i(116509);
    h.3 local3 = new h.3(this);
    if (this.ckn != null) {
      this.ckn.a(local3);
    }
    AppMethodBeat.o(116509);
  }
  
  private void EO()
  {
    AppMethodBeat.i(116512);
    if (this.ckv)
    {
      ab.i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] return mHasBeginRec is true!");
      AppMethodBeat.o(116512);
      return;
    }
    this.ckv = true;
    if (this.ckw) {
      this.cky = c.a.elR;
    }
    for (this.ckn = new m();; this.ckn = new v(this.cky))
    {
      EM();
      EP();
      this.ckp = new h.a(this);
      ab.i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] mRecordStartRunnable has post! threadPool:%s", new Object[] { d.ysm.dut() });
      d.post(this.ckp, "SceneVoiceRecorder_record");
      this.ckx = 1;
      this.ckC.ag(3000L, 3000L);
      ab.d("MicroMsg.SceneVoice.Recorder", "start end time:" + bo.av(this.ckt));
      AppMethodBeat.o(116512);
      return;
      ER();
    }
  }
  
  private void EP()
  {
    AppMethodBeat.i(116513);
    h.4 local4 = new h.4(this);
    this.ckD = local4;
    al.p(local4, 600L);
    AppMethodBeat.o(116513);
  }
  
  private void ER()
  {
    AppMethodBeat.i(116514);
    this.cky = c.KA();
    String str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("VoiceFormat");
    String str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("VoiceFormatToQQ");
    if (this.cky == c.a.elO)
    {
      if ((4 == bo.getInt(str1, 4)) && (g.b.EJ())) {
        this.cky = c.a.elQ;
      }
      if ((this.ckq != null) && (this.ckq.endsWith("@qqim"))) {
        this.cky = c.a.elP;
      }
    }
    if (this.cky == c.a.elO)
    {
      ab.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
      this.cky = c.a.elP;
    }
    ab.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", new Object[] { str1, str2, this.cky, Boolean.valueOf(g.b.EJ()) });
    AppMethodBeat.o(116514);
  }
  
  public final int EK()
  {
    return this.cku;
  }
  
  public final void EL()
  {
    AppMethodBeat.i(155547);
    ab.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", new Object[] { this.mFileName });
    if (this.ckC != null)
    {
      this.ckC.stopTimer();
      this.ckC.removeCallbacksAndMessages(null);
    }
    com.tencent.mm.compatible.b.g.KC().b(this);
    if (this.ckB)
    {
      com.tencent.mm.compatible.b.g.KC().KF();
      this.ckB = false;
    }
    try
    {
      ab.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.ckn != null)
      {
        this.ckn.Et();
        this.cko.Mh();
      }
      this.ckx = -1;
      AppMethodBeat.o(155547);
      return;
    }
    finally
    {
      AppMethodBeat.o(155547);
    }
  }
  
  public final long EN()
  {
    AppMethodBeat.i(116510);
    if (this.mRecordStartTime == 0L)
    {
      AppMethodBeat.o(116510);
      return 0L;
    }
    long l = bo.av(this.mRecordStartTime);
    AppMethodBeat.o(116510);
    return l;
  }
  
  public final int EQ()
  {
    if (this.ckw) {
      return 1;
    }
    if ((this.cky == c.a.elO) || (this.cky == c.a.elP)) {
      return 0;
    }
    if (this.cky == c.a.elQ) {
      return 2;
    }
    return -1;
  }
  
  public boolean Ez()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(116508);
    if (this.ckC != null)
    {
      this.ckC.stopTimer();
      this.ckC.removeCallbacksAndMessages(null);
    }
    com.tencent.mm.compatible.b.g.KC().b(this);
    if (this.ckB)
    {
      com.tencent.mm.compatible.b.g.KC().KF();
      this.ckB = false;
    }
    this.cku = ((int)EN());
    ab.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.cku) });
    if ((this.ckn != null) && (!bo.isNullOrNil(this.mFileName)) && (!this.ckw))
    {
      com.tencent.mm.compatible.h.a locala = new com.tencent.mm.compatible.h.a();
      locala.ese = this.mFileName;
      locala.esf = this.cku;
      locala.esg = 2;
      locala.cpX = this.ckn.Eu();
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10513, locala.Mf());
    }
    try
    {
      ab.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, this.ckn, Long.valueOf(Thread.currentThread().getId()), this });
      if (this.ckn != null)
      {
        this.ckn.Et();
        this.cko.Mh();
      }
      if (this.ckx != 2)
      {
        s.vP(this.mFileName);
        this.mFileName = null;
        ab.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bo.av(this.ckt));
        bool1 = bool2;
        this.ckx = -1;
        AppMethodBeat.o(116508);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(116508);
    }
    if ((this.cku < 800L) || ((this.ckr) && (this.cku < 1000L)))
    {
      ab.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.cku);
      s.vP(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      s.ah(this.mFileName, this.cku);
      o.amu().run();
      ab.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final void a(j.a parama)
  {
    this.ckA = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.ckz = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(116507);
    ab.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
    try
    {
      ab.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.ckn != null)
      {
        this.ckn.Et();
        this.cko.Mh();
      }
      com.tencent.mm.compatible.b.g.KC().b(this);
      if (this.ckB)
      {
        com.tencent.mm.compatible.b.g.KC().KF();
        this.ckB = false;
      }
      s.vN(this.mFileName);
      o.amu().run();
      if ((this.ckn != null) && (!bo.isNullOrNil(this.mFileName)) && (!this.ckw))
      {
        com.tencent.mm.compatible.h.a locala = new com.tencent.mm.compatible.h.a();
        locala.ese = this.mFileName;
        locala.esf = EN();
        locala.esg = 1;
        locala.cpX = this.ckn.Eu();
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10513, locala.Mf());
      }
      this.mFileName = "";
      AppMethodBeat.o(116507);
      return true;
    }
    finally
    {
      AppMethodBeat.o(116507);
    }
  }
  
  public final boolean eI(String paramString)
  {
    AppMethodBeat.i(116506);
    ab.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(paramString)));
    reset();
    this.ckq = paramString;
    this.ckt = bo.yB();
    if (paramString == null)
    {
      ab.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      AppMethodBeat.o(116506);
      return false;
    }
    this.ckr = paramString.equals("_USER_FOR_THROWBOTTLE_");
    if (paramString.equals("medianote"))
    {
      if ((r.Zr() & 0x4000) == 0) {
        this.cks = true;
      }
    }
    else
    {
      if (this.ckw) {
        break label189;
      }
      if (!this.ckr) {
        break label169;
      }
      this.mFileName = w.vV(r.Zn());
    }
    for (;;)
    {
      if ((this.mFileName != null) && (this.mFileName.length() > 0)) {
        break label200;
      }
      ab.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[] { this.mFileName });
      AppMethodBeat.o(116506);
      return false;
      this.cks = false;
      break;
      label169:
      if (this.cks) {
        this.mFileName = w.vV("medianote");
      } else {
        label189:
        this.mFileName = s.vM(paramString);
      }
    }
    label200:
    com.tencent.mm.compatible.b.g.KC().a(this);
    this.ckv = false;
    this.ckB = false;
    if ((com.tencent.mm.compatible.b.g.KK()) && (!com.tencent.mm.compatible.b.g.KC().elW.isBluetoothScoOn()))
    {
      this.ckB = true;
      com.tencent.mm.compatible.b.g.KC().KE();
      al.p(new h.2(this), 1000L);
    }
    for (;;)
    {
      AppMethodBeat.o(116506);
      return true;
      EO();
    }
  }
  
  public String getFileName()
  {
    return this.mFileName;
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(116505);
    if (this.ckn == null)
    {
      AppMethodBeat.o(116505);
      return 0;
    }
    int i = this.ckn.getMaxAmplitude();
    AppMethodBeat.o(116505);
    return i;
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(116511);
    ab.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(paramInt)));
    if (paramInt == 1) {
      EO();
    }
    AppMethodBeat.o(116511);
  }
  
  public final boolean isRecording()
  {
    AppMethodBeat.i(116504);
    if (this.ckn == null)
    {
      AppMethodBeat.o(116504);
      return false;
    }
    if (this.ckn.getStatus() == 1)
    {
      AppMethodBeat.o(116504);
      return true;
    }
    AppMethodBeat.o(116504);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(116503);
    if (this.ckn != null)
    {
      this.ckn.Et();
      this.cko.Mh();
      ab.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.ckt = 0L;
    this.ckp = null;
    this.cky = c.a.elS;
    this.ckx = 0;
    this.mRecordStartTime = 0L;
    AppMethodBeat.o(116503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.h
 * JD-Core Version:    0.7.0.1
 */