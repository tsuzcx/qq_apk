package com.tencent.mm.f.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.j;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.ah.j.b;
import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class h
  implements j, f.a
{
  private static boolean bCk = false;
  private a bDA = null;
  private String bDB;
  private boolean bDC = false;
  private boolean bDD = false;
  private long bDE;
  public int bDF = 0;
  private boolean bDG = false;
  private boolean bDH = false;
  private int bDI = 0;
  private b.a bDJ = b.a.due;
  protected j.b bDK;
  protected j.a bDL = null;
  private boolean bDM = false;
  private am bDN = new am(new h.1(this), true);
  private Runnable bDO;
  private a bDy = null;
  private com.tencent.mm.compatible.util.b bDz;
  private String mFileName = "";
  private long mRecordStartTime = 0L;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    this.bDz = new com.tencent.mm.compatible.util.b(paramContext);
    this.bDH = paramBoolean;
    y.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  private void uz()
  {
    if (this.bDG)
    {
      y.i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] return mHasBeginRec is true!");
      return;
    }
    this.bDG = true;
    if (this.bDH)
    {
      this.bDJ = b.a.dud;
      this.bDy = new k();
      localObject = new h.3(this);
      if (this.bDy != null) {
        this.bDy.a((j.a)localObject);
      }
      localObject = new h.4(this);
      this.bDO = ((Runnable)localObject);
      ai.l((Runnable)localObject, 600L);
      this.bDA = new a();
      y.i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] mRecordStartRunnable has post! threadPool:%s", new Object[] { com.tencent.mm.sdk.f.e.csu().csx() });
      com.tencent.mm.sdk.f.e.post(this.bDA, "SceneVoiceRecorder_record");
      this.bDI = 1;
      this.bDN.S(3000L, 3000L);
      y.d("MicroMsg.SceneVoice.Recorder", "start end time:" + bk.cp(this.bDE));
      return;
    }
    Object localObject = ae.getContext().getSharedPreferences(ae.cqR(), 0);
    boolean bool;
    if (com.tencent.mm.compatible.e.q.dye.duV == 1)
    {
      bool = false;
      label202:
      if (!((SharedPreferences)localObject).contains("settings_voicerecorder_mode")) {
        ((SharedPreferences)localObject).edit().putBoolean("settings_voicerecorder_mode", bool).commit();
      }
      y.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", new Object[] { Integer.valueOf(com.tencent.mm.compatible.e.q.dye.duV), Boolean.valueOf(bool), Boolean.valueOf(((SharedPreferences)localObject).getBoolean("settings_voicerecorder_mode", bool)) });
      if (!((SharedPreferences)localObject).getBoolean("settings_voicerecorder_mode", bool)) {
        break label486;
      }
    }
    label486:
    for (localObject = b.a.dua;; localObject = b.a.dub)
    {
      this.bDJ = ((b.a)localObject);
      localObject = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("VoiceFormat");
      String str = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("VoiceFormatToQQ");
      if (this.bDJ == b.a.dua)
      {
        if ((4 == bk.getInt((String)localObject, 4)) && (g.b.uw())) {
          this.bDJ = b.a.duc;
        }
        if ((this.bDB != null) && (this.bDB.endsWith("@qqim"))) {
          this.bDJ = b.a.dub;
        }
      }
      if (this.bDJ == b.a.dua)
      {
        y.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
        this.bDJ = b.a.dub;
      }
      y.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", new Object[] { localObject, str, this.bDJ, Boolean.valueOf(g.b.uw()) });
      this.bDy = new t(this.bDJ);
      break;
      bool = true;
      break label202;
    }
  }
  
  public final void a(j.a parama)
  {
    this.bDL = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.bDK = paramb;
  }
  
  public final boolean cE(String paramString)
  {
    y.i("MicroMsg.SceneVoice.Recorder", "Start Record to  " + paramString);
    reset();
    this.bDB = paramString;
    this.bDE = bk.UZ();
    if (paramString == null)
    {
      y.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      return false;
    }
    this.bDC = paramString.equals("_USER_FOR_THROWBOTTLE_");
    if (paramString.equals("medianote"))
    {
      if ((com.tencent.mm.model.q.Gn() & 0x4000) == 0) {
        this.bDD = true;
      }
    }
    else
    {
      if (this.bDH) {
        break label178;
      }
      if (!this.bDC) {
        break label158;
      }
      this.mFileName = u.oI(com.tencent.mm.model.q.Gj());
    }
    for (;;)
    {
      if ((this.mFileName != null) && (this.mFileName.length() > 0)) {
        break label189;
      }
      y.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[] { this.mFileName });
      return false;
      this.bDD = false;
      break;
      label158:
      if (this.bDD) {
        this.mFileName = u.oI("medianote");
      } else {
        label178:
        this.mFileName = com.tencent.mm.modelvoice.q.oz(paramString);
      }
    }
    label189:
    f.yi().a(this);
    this.bDG = false;
    this.bDM = false;
    if ((f.yq()) && (!f.yi().yn()))
    {
      this.bDM = true;
      f.yi().yk();
      ai.l(new h.2(this), 1000L);
    }
    for (;;)
    {
      return true;
      uz();
    }
  }
  
  public final boolean cancel()
  {
    y.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
    try
    {
      y.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, new Object[] { Long.valueOf(Thread.currentThread().getId()), this });
      if (this.bDy != null)
      {
        this.bDy.uh();
        this.bDz.zE();
      }
      f.yi().b(this);
      if (this.bDM)
      {
        f.yi().yl();
        this.bDM = false;
      }
      com.tencent.mm.modelvoice.q.oA(this.mFileName);
      m.Ti().run();
      if ((this.bDy != null) && (!bk.bl(this.mFileName)) && (!this.bDH))
      {
        com.tencent.mm.compatible.h.a locala = new com.tencent.mm.compatible.h.a();
        locala.dzp = this.mFileName;
        locala.dzq = uy();
        locala.dzr = 1;
        locala.bIC = this.bDy.ui();
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10513, locala.zC());
      }
      this.mFileName = "";
      return true;
    }
    finally {}
  }
  
  public final void ew(int paramInt)
  {
    y.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :" + paramInt);
    if (paramInt == 1) {
      uz();
    }
  }
  
  public String getFileName()
  {
    return this.mFileName;
  }
  
  public final int getMaxAmplitude()
  {
    if (this.bDy == null) {
      return 0;
    }
    return this.bDy.getMaxAmplitude();
  }
  
  public final boolean isRecording()
  {
    if (this.bDy == null) {}
    while (this.bDy.getStatus() != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    if (this.bDy != null)
    {
      this.bDy.uh();
      this.bDz.zE();
      y.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.bDE = 0L;
    this.bDA = null;
    this.bDJ = b.a.due;
    this.bDI = 0;
    this.mRecordStartTime = 0L;
  }
  
  public final int uA()
  {
    if (this.bDH) {
      return 1;
    }
    if ((this.bDJ == b.a.dua) || (this.bDJ == b.a.dub)) {
      return 0;
    }
    if (this.bDJ == b.a.duc) {
      return 2;
    }
    return -1;
  }
  
  public boolean un()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.bDN != null)
    {
      this.bDN.stopTimer();
      this.bDN.removeCallbacksAndMessages(null);
    }
    f.yi().b(this);
    if (this.bDM)
    {
      f.yi().yl();
      this.bDM = false;
    }
    this.bDF = ((int)uy());
    y.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.bDF) });
    if ((this.bDy != null) && (!bk.bl(this.mFileName)) && (!this.bDH))
    {
      com.tencent.mm.compatible.h.a locala = new com.tencent.mm.compatible.h.a();
      locala.dzp = this.mFileName;
      locala.dzq = this.bDF;
      locala.dzr = 2;
      locala.bIC = this.bDy.ui();
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10513, locala.zC());
    }
    try
    {
      y.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", new Object[] { this.mFileName, this.bDy, Long.valueOf(Thread.currentThread().getId()), this });
      if (this.bDy != null)
      {
        this.bDy.uh();
        this.bDz.zE();
      }
      if (this.bDI != 2)
      {
        com.tencent.mm.modelvoice.q.oC(this.mFileName);
        this.mFileName = null;
        y.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bk.cp(this.bDE));
        bool1 = bool2;
        this.bDI = -1;
        return bool1;
      }
    }
    finally {}
    if ((this.bDF < 800L) || ((this.bDC) && (this.bDF < 1000L)))
    {
      y.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.bDF);
      com.tencent.mm.modelvoice.q.oC(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      com.tencent.mm.modelvoice.q.Z(this.mFileName, this.bDF);
      m.Ti().run();
      y.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final int ux()
  {
    return this.bDF;
  }
  
  public final long uy()
  {
    if (this.mRecordStartTime == 0L) {
      return 0L;
    }
    return bk.cp(this.mRecordStartTime);
  }
  
  private final class a
    implements Runnable
  {
    ah handler = new h.a.1(this, h.this);
    
    public a() {}
    
    public final void run()
    {
      boolean bool = true;
      ai.S(h.d(h.this));
      y.i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      synchronized (h.this)
      {
        y.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", new Object[] { Long.valueOf(Thread.currentThread().getId()), h.this });
        if (h.e(h.this) == null)
        {
          y.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
          return;
        }
        String str = h.a(h.this);
        if (!h.f(h.this)) {}
        for (;;)
        {
          str = com.tencent.mm.modelvoice.q.R(str, bool);
          y.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { str, Boolean.valueOf(h.f(h.this)) });
          if (h.e(h.this).cD(str)) {
            break;
          }
          com.tencent.mm.modelvoice.q.oC(h.a(h.this));
          h.g(h.this);
          h.h(h.this);
          y.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.a(h.this) + "]");
          h.a(h.this, bk.UZ());
          y.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.a(h.this) + "] time:" + bk.cp(h.j(h.this)));
          this.handler.sendEmptyMessageDelayed(0, 1L);
          return;
          bool = false;
        }
        h.i(h.this).requestFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.h
 * JD-Core Version:    0.7.0.1
 */