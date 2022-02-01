package com.tencent.mm.plugin.collect.model.voice;

import android.content.SharedPreferences.Editor;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements n.b
{
  public static final String lej;
  public static boolean phJ;
  public static float phK;
  public static float phL;
  public static final String phM;
  public static final String phN;
  private static a phT;
  private Object lock;
  public d phO;
  public c phP;
  public b phQ;
  private String phR;
  private int phS;
  public com.tencent.mm.sdk.b.c<bn> phU;
  public com.tencent.mm.sdk.b.c<ps> phV;
  private boolean phW;
  
  static
  {
    AppMethodBeat.i(63884);
    phJ = false;
    phK = 0.9F;
    phL = 10.0F;
    lej = com.tencent.mm.loader.j.b.asa() + "files/wxofflinevoicenew/";
    phM = lej + "libreadMoney.so";
    phN = lej + "woman_putonghua.pos";
    AppMethodBeat.o(63884);
  }
  
  public a()
  {
    AppMethodBeat.i(63867);
    this.lock = new Object();
    this.phS = 0;
    this.phU = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(bn paramAnonymousbn)
      {
        AppMethodBeat.i(63858);
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent callback");
        if (paramAnonymousbn.dny.dnz == 60) {}
        synchronized (a.a(a.this))
        {
          ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", new Object[] { Integer.valueOf(paramAnonymousbn.dny.dnz), Integer.valueOf(paramAnonymousbn.dny.subType), paramAnonymousbn.dny.dnC, Integer.valueOf(paramAnonymousbn.dny.dnA) });
          if (paramAnonymousbn.dny.subType == 1)
          {
            AppMethodBeat.o(63858);
            return false;
          }
          if (paramAnonymousbn.dny.subType == 3)
          {
            ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_RES");
            if (o.fB(a.phN))
            {
              ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " file exists，first delete exist file");
              o.deleteFile(a.phN);
            }
            o.mF(paramAnonymousbn.dny.filePath, a.phN);
            a.fm("0", paramAnonymousbn.dny.dnC);
          }
          if (a.phJ)
          {
            ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true, do not reInit Synthesizer");
            AppMethodBeat.o(63858);
            return false;
          }
          a.b(a.this);
          AppMethodBeat.o(63858);
          return false;
        }
      }
    };
    this.phV = new com.tencent.mm.sdk.b.c()
    {
      private boolean cbU()
      {
        AppMethodBeat.i(63860);
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
        synchronized (a.a(a.this))
        {
          com.tencent.mm.plugin.collect.a.a.cbv();
          if (com.tencent.mm.plugin.collect.a.a.cbx())
          {
            a.b(a.this);
            AppMethodBeat.o(63860);
            return false;
          }
          ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent isF2fRingToneOpen() == false");
        }
      }
    };
    this.phW = false;
    AppMethodBeat.o(63867);
  }
  
  private static String QX(String paramString)
  {
    AppMethodBeat.i(63881);
    paramString = ay.aRW("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(63881);
    return paramString;
  }
  
  private boolean aaH(String paramString)
  {
    AppMethodBeat.i(63877);
    ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", new Object[] { bu.bI(paramString, "null") });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", new Object[] { phN, o.aRh(phN) });
    if (paramString.equalsIgnoreCase(o.aRh(phN)))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 30L, 1L, false);
    cbP();
    ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes autoDownloadDefaultResNum:%s", new Object[] { Integer.valueOf(this.phS) });
    if (this.phS < 5)
    {
      this.phS += 1;
      boolean bool = cbR();
      AppMethodBeat.o(63877);
      return bool;
    }
    AppMethodBeat.o(63877);
    return false;
  }
  
  public static a cbM()
  {
    AppMethodBeat.i(63868);
    try
    {
      if (phT == null) {
        phT = new a();
      }
      a locala = phT;
      AppMethodBeat.o(63868);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(63868);
    }
  }
  
  private void cbN()
  {
    AppMethodBeat.i(63872);
    if (cbO())
    {
      phJ = true;
      ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
      AppMethodBeat.o(63872);
      return;
    }
    phJ = false;
    ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
    AppMethodBeat.o(63872);
  }
  
  private boolean cbO()
  {
    AppMethodBeat.i(63873);
    o.aZI(lej);
    this.phU.alive();
    com.tencent.mm.pluginsdk.j.a.a.b.fes();
    com.tencent.mm.pluginsdk.j.a.a.b.Zd(60);
    Object localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jau, "0");
    int i;
    if (bu.lX((String)localObject1, "0")) {
      if (cbQ())
      {
        this.phR = "woman_putonghua";
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
        i = 1;
      }
    }
    Object localObject2;
    String str;
    while (i == 0)
    {
      AppMethodBeat.o(63873);
      return false;
      this.phR = "";
      ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
      i = 0;
      continue;
      localObject2 = ay.aRW("voice_offline_res_new").getString((String)localObject1, "");
      if ((!bu.isNullOrNil((String)localObject2)) && (o.fB((String)localObject2)))
      {
        str = QX((String)localObject1);
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resMd5:%s", new Object[] { bu.bI(str, "null") });
        if (bu.isNullOrNil(str))
        {
          this.phR = ((String)localObject1);
          i = 1;
        }
        else
        {
          ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() %s md5:%s", new Object[] { localObject2, o.aRh((String)localObject2) });
          if (str.equalsIgnoreCase(o.aRh((String)localObject2)))
          {
            this.phR = ((String)localObject1);
            i = 1;
          }
          else
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 31L, 1L, false);
            o.deleteFile((String)localObject2);
            fm((String)localObject1, "");
            if (cbQ())
            {
              this.phR = "woman_putonghua";
              ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
              i = 1;
            }
            else
            {
              ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
              this.phR = "";
              i = 0;
            }
          }
        }
      }
      else
      {
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "resPath:%s %s", new Object[] { bu.bI((String)localObject2, "null"), Boolean.valueOf(o.fB((String)localObject2)) });
        if (cbQ())
        {
          this.phR = "woman_putonghua";
          ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
          i = 1;
        }
        else
        {
          this.phR = "";
          ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
          i = 0;
        }
      }
    }
    if (this.phO != null) {}
    for (;;)
    {
      try
      {
        this.phO.pij.destroy();
        this.phO = d.a.pik;
        localObject1 = this.phO;
        localObject2 = this.phQ;
        ((d)localObject1).pij.pia = ((c)localObject2);
        localObject1 = this.phO;
        localObject2 = lej;
        str = this.phR;
        i = ((d)localObject1).pij.fn((String)localObject2, str);
        if (i >= 0) {
          break;
        }
        ae.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret%s res:%s", new Object[] { Integer.valueOf(i), this.phR });
        if (bu.jB(i, -201))
        {
          if (!bu.lX(this.phR, "woman_putonghua"))
          {
            ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", new Object[] { this.phR });
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jau, "0");
            com.tencent.mm.sdk.b.a.IvT.l(new ps());
            cbN();
          }
          if (i != -101) {
            break label751;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 1L, 1L, false);
          AppMethodBeat.o(63873);
          return false;
        }
      }
      catch (Exception localException)
      {
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(63873);
        return false;
      }
      if (bu.jB(i, -207)) {
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s", new Object[] { phM });
      } else if ((i <= -2) && (i >= -9)) {
        if (bu.lX(this.phR, "woman_putonghua"))
        {
          cbP();
          if (this.phS < 5)
          {
            this.phS += 1;
            if (cbR()) {
              cbN();
            }
          }
          ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ret:%s delete %s : %s", new Object[] { Integer.valueOf(i), phN, Integer.valueOf(this.phS) });
          continue;
          label751:
          if (i == -102) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 2L, 1L, false);
          } else if (i == -103) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 3L, 1L, false);
          } else if (i == -104) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 4L, 1L, false);
          } else if (i == -201) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 5L, 1L, false);
          } else if (i == -202) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 6L, 1L, false);
          } else if (i == -203) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 7L, 1L, false);
          } else if (i == -204) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 8L, 1L, false);
          } else if (i == -205) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 9L, 1L, false);
          } else if (i == -206) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 10L, 1L, false);
          } else if (i == -207) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 11L, 1L, false);
          } else if ((i <= -2) && (i >= -9)) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 12L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 13L, 1L, false);
          }
        }
      }
    }
    this.phS = 0;
    d locald = this.phO;
    float f = phL;
    locald.pij.mVolume = f;
    locald = this.phO;
    f = phK;
    locald.pij.MU = f;
    AppMethodBeat.o(63873);
    return true;
  }
  
  private static void cbP()
  {
    AppMethodBeat.i(63874);
    o.deleteFile(phN);
    fm("0", "");
    AppMethodBeat.o(63874);
  }
  
  private boolean cbQ()
  {
    AppMethodBeat.i(63875);
    if (o.fB(phN))
    {
      boolean bool = cbS();
      AppMethodBeat.o(63875);
      return bool;
    }
    if (cbR())
    {
      AppMethodBeat.o(63875);
      return true;
    }
    AppMethodBeat.o(63875);
    return false;
  }
  
  private boolean cbR()
  {
    AppMethodBeat.i(63876);
    com.tencent.mm.pluginsdk.j.a.a.b.fes();
    String str = com.tencent.mm.pluginsdk.j.a.a.b.jq(60, 3);
    boolean bool = o.fB(str);
    ae.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", new Object[] { str });
    ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResFromCache() %s no exist, cacheExist: %s", new Object[] { phN, Boolean.valueOf(bool) });
    if (bool)
    {
      long l = o.mF(str, phN);
      fm("0", "");
      ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", new Object[] { Long.valueOf(l) });
      if (!bu.az(l, -1L))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.fes();
        str = com.tencent.mm.pluginsdk.j.a.a.b.fet();
        fm("0", str);
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", new Object[] { str });
        bool = aaH(str);
        AppMethodBeat.o(63876);
        return bool;
      }
    }
    AppMethodBeat.o(63876);
    return false;
  }
  
  private boolean cbS()
  {
    AppMethodBeat.i(63878);
    boolean bool = aaH(QX("0"));
    AppMethodBeat.o(63878);
    return bool;
  }
  
  public static void fm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63882);
    ay.aRW("voice_offline_res_new").edit().putString(paramString1 + "_md5", bu.bI(paramString2, "")).commit();
    AppMethodBeat.o(63882);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(63869);
    if (this.phW)
    {
      ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()：is already init()");
      AppMethodBeat.o(63869);
      return;
    }
    com.tencent.mm.plugin.collect.a.a.cbv();
    if (com.tencent.mm.plugin.collect.a.a.cbx())
    {
      ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
      jK(true);
      this.phW = true;
      com.tencent.mm.kernel.g.ajR().ajA().b(this);
    }
    AppMethodBeat.o(63869);
  }
  
  public final void a(cg paramcg)
  {
    AppMethodBeat.i(63879);
    paramcg = new a.a(this, paramcg);
    this.phQ.a(paramcg);
    this.phO.start(paramcg.dok);
    ae.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", new Object[] { paramcg.dok });
    AppMethodBeat.o(63879);
  }
  
  public final String cbT()
  {
    AppMethodBeat.i(63880);
    if (bu.lX(this.phR, "woman_putonghua")) {}
    for (String str = "0";; str = this.phR)
    {
      AppMethodBeat.o(63880);
      return str;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(63871);
    for (;;)
    {
      synchronized (this.lock)
      {
        if (phJ)
        {
          ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
          AppMethodBeat.o(63871);
          return;
        }
        com.tencent.mm.plugin.collect.a.a.cbv();
        if (com.tencent.mm.plugin.collect.a.a.cbx())
        {
          this.phV.alive();
          if (!cbO())
          {
            ae.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
            phJ = false;
            AppMethodBeat.o(63871);
            return;
          }
          ae.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
          phJ = true;
        }
      }
      ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "isF2fRingToneOpen() == false");
    }
  }
  
  public final void jK(boolean paramBoolean)
  {
    AppMethodBeat.i(63870);
    ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " begin initTTS()，delay：%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      h.MqF.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(63862);
          a.this.init();
          AppMethodBeat.o(63862);
        }
      }, 10000L, "initTTS");
      AppMethodBeat.o(63870);
      return;
    }
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63863);
        a.this.init();
        AppMethodBeat.o(63863);
      }
    }, "initTTS");
    AppMethodBeat.o(63870);
  }
  
  public final class b
    implements c
  {
    private a.c phY;
    private ConcurrentLinkedQueue<a.a> phZ;
    
    public b(a.c paramc)
    {
      AppMethodBeat.i(63864);
      this.phZ = new ConcurrentLinkedQueue();
      this.phY = paramc;
      AppMethodBeat.o(63864);
    }
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(63865);
      this.phZ.add(parama);
      AppMethodBeat.o(63865);
    }
    
    public final void o(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(63866);
      if (this.phY == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.F2fRcvVoiceOffLineLogic.Listener", "onGetResult() errorCode:%s (voiceLlistener == null):%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (this.phY != null)
        {
          a.a locala = (a.a)this.phZ.poll();
          this.phY.a(paramInt, locala.doh, locala.doi, locala.dok, locala.dof, a.cbM().cbT(), paramArrayOfByte);
          if (paramInt < 0) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 20L, 1L, false);
          }
        }
        AppMethodBeat.o(63866);
        return;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a
 * JD-Core Version:    0.7.0.1
 */