package com.tencent.mm.plugin.collect.model.voice;

import android.content.SharedPreferences.Editor;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.cg.a;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements n.b
{
  public static final String laB;
  public static boolean pbf;
  public static float pbg;
  public static float pbh;
  public static final String pbi;
  public static final String pbj;
  private static a pbp;
  private Object lock;
  public d pbk;
  public c pbl;
  public b pbm;
  private String pbn;
  private int pbo;
  public com.tencent.mm.sdk.b.c<bn> pbq;
  public com.tencent.mm.sdk.b.c<pr> pbr;
  private boolean pbs;
  
  static
  {
    AppMethodBeat.i(63884);
    pbf = false;
    pbg = 0.9F;
    pbh = 10.0F;
    laB = com.tencent.mm.loader.j.b.arL() + "files/wxofflinevoicenew/";
    pbi = laB + "libreadMoney.so";
    pbj = laB + "woman_putonghua.pos";
    AppMethodBeat.o(63884);
  }
  
  public a()
  {
    AppMethodBeat.i(63867);
    this.lock = new Object();
    this.pbo = 0;
    this.pbq = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(bn paramAnonymousbn)
      {
        AppMethodBeat.i(63858);
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent callback");
        if (paramAnonymousbn.dmw.dmx == 60) {}
        synchronized (a.a(a.this))
        {
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", new Object[] { Integer.valueOf(paramAnonymousbn.dmw.dmx), Integer.valueOf(paramAnonymousbn.dmw.subType), paramAnonymousbn.dmw.dmA, Integer.valueOf(paramAnonymousbn.dmw.dmy) });
          if (paramAnonymousbn.dmw.subType == 1)
          {
            AppMethodBeat.o(63858);
            return false;
          }
          if (paramAnonymousbn.dmw.subType == 3)
          {
            ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_RES");
            if (com.tencent.mm.vfs.i.fv(a.pbj))
            {
              ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " file exists，first delete exist file");
              com.tencent.mm.vfs.i.deleteFile(a.pbj);
            }
            com.tencent.mm.vfs.i.mz(paramAnonymousbn.dmw.filePath, a.pbj);
            a.fi("0", paramAnonymousbn.dmw.dmA);
          }
          if (a.pbf)
          {
            ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true, do not reInit Synthesizer");
            AppMethodBeat.o(63858);
            return false;
          }
          a.b(a.this);
          AppMethodBeat.o(63858);
          return false;
        }
      }
    };
    this.pbr = new com.tencent.mm.sdk.b.c()
    {
      private boolean caF()
      {
        AppMethodBeat.i(63860);
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
        synchronized (a.a(a.this))
        {
          com.tencent.mm.plugin.collect.a.a.cag();
          if (com.tencent.mm.plugin.collect.a.a.cai())
          {
            a.b(a.this);
            AppMethodBeat.o(63860);
            return false;
          }
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent isF2fRingToneOpen() == false");
        }
      }
    };
    this.pbs = false;
    AppMethodBeat.o(63867);
  }
  
  private static String Qo(String paramString)
  {
    AppMethodBeat.i(63881);
    paramString = ax.aQz("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(63881);
    return paramString;
  }
  
  private boolean ZQ(String paramString)
  {
    AppMethodBeat.i(63877);
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", new Object[] { bt.bI(paramString, "null") });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", new Object[] { pbj, com.tencent.mm.vfs.i.aPK(pbj) });
    if (paramString.equalsIgnoreCase(com.tencent.mm.vfs.i.aPK(pbj)))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 30L, 1L, false);
    caA();
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes autoDownloadDefaultResNum:%s", new Object[] { Integer.valueOf(this.pbo) });
    if (this.pbo < 5)
    {
      this.pbo += 1;
      boolean bool = caC();
      AppMethodBeat.o(63877);
      return bool;
    }
    AppMethodBeat.o(63877);
    return false;
  }
  
  private static void caA()
  {
    AppMethodBeat.i(63874);
    com.tencent.mm.vfs.i.deleteFile(pbj);
    fi("0", "");
    AppMethodBeat.o(63874);
  }
  
  private boolean caB()
  {
    AppMethodBeat.i(63875);
    if (com.tencent.mm.vfs.i.fv(pbj))
    {
      boolean bool = caD();
      AppMethodBeat.o(63875);
      return bool;
    }
    if (caC())
    {
      AppMethodBeat.o(63875);
      return true;
    }
    AppMethodBeat.o(63875);
    return false;
  }
  
  private boolean caC()
  {
    AppMethodBeat.i(63876);
    com.tencent.mm.pluginsdk.j.a.a.b.faE();
    String str = com.tencent.mm.pluginsdk.j.a.a.b.jm(60, 3);
    boolean bool = com.tencent.mm.vfs.i.fv(str);
    ad.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", new Object[] { str });
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResFromCache() %s no exist, cacheExist: %s", new Object[] { pbj, Boolean.valueOf(bool) });
    if (bool)
    {
      long l = com.tencent.mm.vfs.i.mz(str, pbj);
      fi("0", "");
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", new Object[] { Long.valueOf(l) });
      if (!bt.aA(l, -1L))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.faE();
        str = com.tencent.mm.pluginsdk.j.a.a.b.faF();
        fi("0", str);
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", new Object[] { str });
        bool = ZQ(str);
        AppMethodBeat.o(63876);
        return bool;
      }
    }
    AppMethodBeat.o(63876);
    return false;
  }
  
  private boolean caD()
  {
    AppMethodBeat.i(63878);
    boolean bool = ZQ(Qo("0"));
    AppMethodBeat.o(63878);
    return bool;
  }
  
  public static a cax()
  {
    AppMethodBeat.i(63868);
    try
    {
      if (pbp == null) {
        pbp = new a();
      }
      a locala = pbp;
      AppMethodBeat.o(63868);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(63868);
    }
  }
  
  private void cay()
  {
    AppMethodBeat.i(63872);
    if (caz())
    {
      pbf = true;
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
      AppMethodBeat.o(63872);
      return;
    }
    pbf = false;
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
    AppMethodBeat.o(63872);
  }
  
  private boolean caz()
  {
    AppMethodBeat.i(63873);
    com.tencent.mm.vfs.i.aYg(laB);
    this.pbq.alive();
    com.tencent.mm.pluginsdk.j.a.a.b.faE();
    com.tencent.mm.pluginsdk.j.a.a.b.Yx(60);
    Object localObject1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFU, "0");
    int i;
    if (bt.lQ((String)localObject1, "0")) {
      if (caB())
      {
        this.pbn = "woman_putonghua";
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
        i = 1;
      }
    }
    Object localObject2;
    String str;
    while (i == 0)
    {
      AppMethodBeat.o(63873);
      return false;
      this.pbn = "";
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
      i = 0;
      continue;
      localObject2 = ax.aQz("voice_offline_res_new").getString((String)localObject1, "");
      if ((!bt.isNullOrNil((String)localObject2)) && (com.tencent.mm.vfs.i.fv((String)localObject2)))
      {
        str = Qo((String)localObject1);
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resMd5:%s", new Object[] { bt.bI(str, "null") });
        if (bt.isNullOrNil(str))
        {
          this.pbn = ((String)localObject1);
          i = 1;
        }
        else
        {
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() %s md5:%s", new Object[] { localObject2, com.tencent.mm.vfs.i.aPK((String)localObject2) });
          if (str.equalsIgnoreCase(com.tencent.mm.vfs.i.aPK((String)localObject2)))
          {
            this.pbn = ((String)localObject1);
            i = 1;
          }
          else
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 31L, 1L, false);
            com.tencent.mm.vfs.i.deleteFile((String)localObject2);
            fi((String)localObject1, "");
            if (caB())
            {
              this.pbn = "woman_putonghua";
              ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
              i = 1;
            }
            else
            {
              ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
              this.pbn = "";
              i = 0;
            }
          }
        }
      }
      else
      {
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "resPath:%s %s", new Object[] { bt.bI((String)localObject2, "null"), Boolean.valueOf(com.tencent.mm.vfs.i.fv((String)localObject2)) });
        if (caB())
        {
          this.pbn = "woman_putonghua";
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
          i = 1;
        }
        else
        {
          this.pbn = "";
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
          i = 0;
        }
      }
    }
    if (this.pbk != null) {}
    for (;;)
    {
      try
      {
        this.pbk.pbE.destroy();
        this.pbk = d.a.pbF;
        localObject1 = this.pbk;
        localObject2 = this.pbm;
        ((d)localObject1).pbE.pbw = ((c)localObject2);
        localObject1 = this.pbk;
        localObject2 = laB;
        str = this.pbn;
        i = ((d)localObject1).pbE.fj((String)localObject2, str);
        if (i >= 0) {
          break;
        }
        ad.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret%s res:%s", new Object[] { Integer.valueOf(i), this.pbn });
        if (bt.jx(i, -201))
        {
          if (!bt.lQ(this.pbn, "woman_putonghua"))
          {
            ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", new Object[] { this.pbn });
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFU, "0");
            com.tencent.mm.sdk.b.a.IbL.l(new pr());
            cay();
          }
          if (i != -101) {
            break label752;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 1L, 1L, false);
          AppMethodBeat.o(63873);
          return false;
        }
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(63873);
        return false;
      }
      if (bt.jx(i, -207)) {
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s", new Object[] { pbi });
      } else if ((i <= -2) && (i >= -9)) {
        if (bt.lQ(this.pbn, "woman_putonghua"))
        {
          caA();
          if (this.pbo < 5)
          {
            this.pbo += 1;
            if (caC()) {
              cay();
            }
          }
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ret:%s delete %s : %s", new Object[] { Integer.valueOf(i), pbj, Integer.valueOf(this.pbo) });
          continue;
          label752:
          if (i == -102) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 2L, 1L, false);
          } else if (i == -103) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 3L, 1L, false);
          } else if (i == -104) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 4L, 1L, false);
          } else if (i == -201) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 5L, 1L, false);
          } else if (i == -202) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 6L, 1L, false);
          } else if (i == -203) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 7L, 1L, false);
          } else if (i == -204) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 8L, 1L, false);
          } else if (i == -205) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 9L, 1L, false);
          } else if (i == -206) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 10L, 1L, false);
          } else if (i == -207) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 11L, 1L, false);
          } else if ((i <= -2) && (i >= -9)) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 12L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 13L, 1L, false);
          }
        }
      }
    }
    this.pbo = 0;
    d locald = this.pbk;
    float f = pbh;
    locald.pbE.mVolume = f;
    locald = this.pbk;
    f = pbg;
    locald.pbE.MU = f;
    AppMethodBeat.o(63873);
    return true;
  }
  
  public static void fi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63882);
    ax.aQz("voice_offline_res_new").edit().putString(paramString1 + "_md5", bt.bI(paramString2, "")).commit();
    AppMethodBeat.o(63882);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(63869);
    if (this.pbs)
    {
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()：is already init()");
      AppMethodBeat.o(63869);
      return;
    }
    com.tencent.mm.plugin.collect.a.a.cag();
    if (com.tencent.mm.plugin.collect.a.a.cai())
    {
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
      jL(true);
      this.pbs = true;
      com.tencent.mm.kernel.g.ajC().ajl().b(this);
    }
    AppMethodBeat.o(63869);
  }
  
  public final void a(cg paramcg)
  {
    AppMethodBeat.i(63879);
    paramcg = new a(paramcg);
    this.pbm.a(paramcg);
    this.pbk.start(paramcg.dni);
    ad.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", new Object[] { paramcg.dni });
    AppMethodBeat.o(63879);
  }
  
  public final String caE()
  {
    AppMethodBeat.i(63880);
    if (bt.lQ(this.pbn, "woman_putonghua")) {}
    for (String str = "0";; str = this.pbn)
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
        if (pbf)
        {
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
          AppMethodBeat.o(63871);
          return;
        }
        com.tencent.mm.plugin.collect.a.a.cag();
        if (com.tencent.mm.plugin.collect.a.a.cai())
        {
          this.pbr.alive();
          if (!caz())
          {
            ad.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
            pbf = false;
            AppMethodBeat.o(63871);
            return;
          }
          ad.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
          pbf = true;
        }
      }
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "isF2fRingToneOpen() == false");
    }
  }
  
  public final void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(63870);
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " begin initTTS()，delay：%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      h.LTJ.a(new Runnable()
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
    h.LTJ.f(new Runnable()
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
  
  public final class a
  {
    public int dnd;
    public String dne;
    public String dnf;
    public String dng;
    public int dnh;
    public String dni;
    public long gW;
    
    public a(cg paramcg)
    {
      this.dnd = paramcg.dnc.dnd;
      this.dne = paramcg.dnc.dne;
      this.dnf = paramcg.dnc.dnf;
      this.dng = paramcg.dnc.dng;
      this.gW = paramcg.dnc.gW;
      this.dnh = paramcg.dnc.dnh;
      this.dni = paramcg.dnc.dni;
    }
  }
  
  public final class b
    implements c
  {
    private a.c pbu;
    private ConcurrentLinkedQueue<a.a> pbv;
    
    public b(a.c paramc)
    {
      AppMethodBeat.i(63864);
      this.pbv = new ConcurrentLinkedQueue();
      this.pbu = paramc;
      AppMethodBeat.o(63864);
    }
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(63865);
      this.pbv.add(parama);
      AppMethodBeat.o(63865);
    }
    
    public final void o(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(63866);
      if (this.pbu == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.F2fRcvVoiceOffLineLogic.Listener", "onGetResult() errorCode:%s (voiceLlistener == null):%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (this.pbu != null)
        {
          a.a locala = (a.a)this.pbv.poll();
          this.pbu.a(paramInt, locala.dnf, locala.dng, locala.dni, locala.dnd, a.cax().caE(), paramArrayOfByte);
          if (paramInt < 0) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1143L, 20L, 1L, false);
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