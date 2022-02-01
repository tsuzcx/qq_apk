package com.tencent.mm.plugin.collect.model.voice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.cd.a;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements n.b
{
  public static final String kdE;
  public static boolean nUp;
  public static float nUq;
  public static float nUr;
  public static final String nUs;
  public static final String nUt;
  private static a nUz;
  private Object lock;
  public com.tencent.mm.sdk.b.c<bk> nUA;
  public com.tencent.mm.sdk.b.c<oy> nUB;
  private boolean nUC;
  public d nUu;
  public c nUv;
  public b nUw;
  private String nUx;
  private int nUy;
  
  static
  {
    AppMethodBeat.i(63884);
    nUp = false;
    nUq = 0.9F;
    nUr = 10.0F;
    kdE = com.tencent.mm.loader.j.b.ahY() + "files/wxofflinevoicenew/";
    nUs = kdE + "libreadMoney.so";
    nUt = kdE + "woman_putonghua.pos";
    AppMethodBeat.o(63884);
  }
  
  public a()
  {
    AppMethodBeat.i(63867);
    this.lock = new Object();
    this.nUy = 0;
    this.nUA = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(bk paramAnonymousbk)
      {
        AppMethodBeat.i(63858);
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent callback");
        if (paramAnonymousbk.ddG.ddH == 60) {}
        synchronized (a.a(a.this))
        {
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", new Object[] { Integer.valueOf(paramAnonymousbk.ddG.ddH), Integer.valueOf(paramAnonymousbk.ddG.subType), paramAnonymousbk.ddG.ddK, Integer.valueOf(paramAnonymousbk.ddG.ddI) });
          if (paramAnonymousbk.ddG.subType == 1)
          {
            AppMethodBeat.o(63858);
            return false;
          }
          if (paramAnonymousbk.ddG.subType == 3)
          {
            if (com.tencent.mm.vfs.i.eK(a.nUt)) {
              com.tencent.mm.vfs.i.deleteFile(a.nUt);
            }
            com.tencent.mm.vfs.i.lC(paramAnonymousbk.ddG.filePath, a.nUt);
            a.eL("0", paramAnonymousbk.ddG.ddK);
          }
          if (a.nUp)
          {
            ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true");
            AppMethodBeat.o(63858);
            return false;
          }
          a.b(a.this);
          AppMethodBeat.o(63858);
          return false;
        }
      }
    };
    this.nUB = new com.tencent.mm.sdk.b.c()
    {
      private boolean bOM()
      {
        AppMethodBeat.i(63860);
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
        synchronized (a.a(a.this))
        {
          com.tencent.mm.plugin.collect.a.a.bOn();
          if (com.tencent.mm.plugin.collect.a.a.bOp())
          {
            a.b(a.this);
            AppMethodBeat.o(63860);
            return false;
          }
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent isF2fRingToneOpen() == false");
        }
      }
    };
    this.nUC = false;
    AppMethodBeat.o(63867);
  }
  
  private static String IQ(String paramString)
  {
    AppMethodBeat.i(63881);
    paramString = ax.aFC("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(63881);
    return paramString;
  }
  
  private boolean RX(String paramString)
  {
    AppMethodBeat.i(63877);
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", new Object[] { bt.by(paramString, "null") });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", new Object[] { nUt, com.tencent.mm.vfs.i.aEN(nUt) });
    if (paramString.equalsIgnoreCase(com.tencent.mm.vfs.i.aEN(nUt)))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 30L, 1L, false);
    bOH();
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes autoDownloadDefaultResNum:%s", new Object[] { Integer.valueOf(this.nUy) });
    if (this.nUy < 5)
    {
      this.nUy += 1;
      boolean bool = bOJ();
      AppMethodBeat.o(63877);
      return bool;
    }
    AppMethodBeat.o(63877);
    return false;
  }
  
  public static a bOE()
  {
    AppMethodBeat.i(63868);
    try
    {
      if (nUz == null) {
        nUz = new a();
      }
      a locala = nUz;
      AppMethodBeat.o(63868);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(63868);
    }
  }
  
  private void bOF()
  {
    AppMethodBeat.i(63872);
    if (bOG())
    {
      nUp = true;
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
      AppMethodBeat.o(63872);
      return;
    }
    nUp = false;
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
    AppMethodBeat.o(63872);
  }
  
  private boolean bOG()
  {
    AppMethodBeat.i(63873);
    com.tencent.mm.vfs.i.aMF(kdE);
    this.nUA.alive();
    com.tencent.mm.pluginsdk.h.a.a.b.ewn();
    com.tencent.mm.pluginsdk.h.a.a.b.Ur(60);
    Object localObject1 = (String)g.afB().afk().get(ae.a.Fvv, "0");
    int i;
    if (bt.kU((String)localObject1, "0")) {
      if (bOI())
      {
        this.nUx = "woman_putonghua";
        i = 1;
      }
    }
    Object localObject2;
    String str;
    while (i == 0)
    {
      AppMethodBeat.o(63873);
      return false;
      this.nUx = "";
      i = 0;
      continue;
      localObject2 = ax.aFC("voice_offline_res_new").getString((String)localObject1, "");
      if ((!bt.isNullOrNil((String)localObject2)) && (com.tencent.mm.vfs.i.eK((String)localObject2)))
      {
        str = IQ((String)localObject1);
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resMd5:%s", new Object[] { bt.by(str, "null") });
        if (bt.isNullOrNil(str))
        {
          this.nUx = ((String)localObject1);
          i = 1;
        }
        else
        {
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() %s md5:%s", new Object[] { localObject2, com.tencent.mm.vfs.i.aEN((String)localObject2) });
          if (str.equalsIgnoreCase(com.tencent.mm.vfs.i.aEN((String)localObject2)))
          {
            this.nUx = ((String)localObject1);
            i = 1;
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 31L, 1L, false);
            com.tencent.mm.vfs.i.deleteFile((String)localObject2);
            eL((String)localObject1, "");
            if (bOI())
            {
              this.nUx = "woman_putonghua";
              i = 1;
            }
            else
            {
              this.nUx = "";
              i = 0;
            }
          }
        }
      }
      else
      {
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "resPath:%s %s", new Object[] { bt.by((String)localObject2, "null"), Boolean.valueOf(com.tencent.mm.vfs.i.eK((String)localObject2)) });
        if (bOI())
        {
          this.nUx = "woman_putonghua";
          i = 1;
        }
        else
        {
          this.nUx = "";
          i = 0;
        }
      }
    }
    if (this.nUu != null) {}
    for (;;)
    {
      try
      {
        this.nUu.nUO.destroy();
        this.nUu = d.a.nUP;
        localObject1 = this.nUu;
        localObject2 = this.nUw;
        ((d)localObject1).nUO.nUG = ((c)localObject2);
        localObject1 = this.nUu;
        localObject2 = kdE;
        str = this.nUx;
        i = ((d)localObject1).nUO.eM((String)localObject2, str);
        if (i >= 0) {
          break;
        }
        ad.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret%s res:%s", new Object[] { Integer.valueOf(i), this.nUx });
        if (bt.iY(i, -201))
        {
          if (!bt.kU(this.nUx, "woman_putonghua"))
          {
            ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", new Object[] { this.nUx });
            g.afB().afk().set(ae.a.Fvv, "0");
            com.tencent.mm.sdk.b.a.ESL.l(new oy());
            bOF();
          }
          if (i != -101) {
            break label703;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 1L, 1L, false);
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
      if (bt.iY(i, -207)) {
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s", new Object[] { nUs });
      } else if ((i <= -2) && (i >= -9)) {
        if (bt.kU(this.nUx, "woman_putonghua"))
        {
          bOH();
          if (this.nUy < 5)
          {
            this.nUy += 1;
            if (bOJ()) {
              bOF();
            }
          }
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ret:%s delete %s : %s", new Object[] { Integer.valueOf(i), nUt, Integer.valueOf(this.nUy) });
          continue;
          label703:
          if (i == -102) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 2L, 1L, false);
          } else if (i == -103) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 3L, 1L, false);
          } else if (i == -104) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 4L, 1L, false);
          } else if (i == -201) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 5L, 1L, false);
          } else if (i == -202) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 6L, 1L, false);
          } else if (i == -203) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 7L, 1L, false);
          } else if (i == -204) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 8L, 1L, false);
          } else if (i == -205) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 9L, 1L, false);
          } else if (i == -206) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 10L, 1L, false);
          } else if (i == -207) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 11L, 1L, false);
          } else if ((i <= -2) && (i >= -9)) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 12L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 13L, 1L, false);
          }
        }
      }
    }
    this.nUy = 0;
    d locald = this.nUu;
    float f = nUr;
    locald.nUO.mVolume = f;
    locald = this.nUu;
    f = nUq;
    locald.nUO.Kh = f;
    AppMethodBeat.o(63873);
    return true;
  }
  
  private static void bOH()
  {
    AppMethodBeat.i(63874);
    com.tencent.mm.vfs.i.deleteFile(nUt);
    eL("0", "");
    AppMethodBeat.o(63874);
  }
  
  private boolean bOI()
  {
    AppMethodBeat.i(63875);
    if (com.tencent.mm.vfs.i.eK(nUt))
    {
      boolean bool = bOK();
      AppMethodBeat.o(63875);
      return bool;
    }
    if (bOJ())
    {
      AppMethodBeat.o(63875);
      return true;
    }
    AppMethodBeat.o(63875);
    return false;
  }
  
  private boolean bOJ()
  {
    AppMethodBeat.i(63876);
    com.tencent.mm.pluginsdk.h.a.a.b.ewn();
    String str = com.tencent.mm.pluginsdk.h.a.a.b.iN(60, 3);
    boolean bool = com.tencent.mm.vfs.i.eK(str);
    ad.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", new Object[] { str });
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResFromCache() %s no exist, cacheExist: %s", new Object[] { nUt, Boolean.valueOf(bool) });
    if (bool)
    {
      long l = com.tencent.mm.vfs.i.lC(str, nUt);
      eL("0", "");
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", new Object[] { Long.valueOf(l) });
      if (!bt.aw(l, -1L))
      {
        com.tencent.mm.pluginsdk.h.a.a.b.ewn();
        str = com.tencent.mm.pluginsdk.h.a.a.b.ewo();
        eL("0", str);
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", new Object[] { str });
        bool = RX(str);
        AppMethodBeat.o(63876);
        return bool;
      }
    }
    AppMethodBeat.o(63876);
    return false;
  }
  
  private boolean bOK()
  {
    AppMethodBeat.i(63878);
    boolean bool = RX(IQ("0"));
    AppMethodBeat.o(63878);
    return bool;
  }
  
  public static void eL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63882);
    ax.aFC("voice_offline_res_new").edit().putString(paramString1 + "_md5", bt.by(paramString2, "")).commit();
    AppMethodBeat.o(63882);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(63869);
    if (this.nUC)
    {
      AppMethodBeat.o(63869);
      return;
    }
    com.tencent.mm.plugin.collect.a.a.bOn();
    if (com.tencent.mm.plugin.collect.a.a.bOp())
    {
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
      iX(true);
      this.nUC = true;
      g.afB().afk().b(this);
    }
    AppMethodBeat.o(63869);
  }
  
  public final void a(cd paramcd)
  {
    AppMethodBeat.i(63879);
    paramcd = new a(paramcd);
    this.nUw.a(paramcd);
    this.nUu.start(paramcd.deq);
    ad.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", new Object[] { paramcd.deq });
    AppMethodBeat.o(63879);
  }
  
  public final String bOL()
  {
    AppMethodBeat.i(63880);
    if (bt.kU(this.nUx, "woman_putonghua")) {}
    for (String str = "0";; str = this.nUx)
    {
      AppMethodBeat.o(63880);
      return str;
    }
  }
  
  public final void iX(boolean paramBoolean)
  {
    AppMethodBeat.i(63870);
    if (paramBoolean)
    {
      com.tencent.e.h.Iye.a(new Runnable()
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
    com.tencent.e.h.Iye.f(new Runnable()
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
  
  public final void init()
  {
    AppMethodBeat.i(63871);
    for (;;)
    {
      synchronized (this.lock)
      {
        if (nUp)
        {
          ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
          AppMethodBeat.o(63871);
          return;
        }
        com.tencent.mm.plugin.collect.a.a.bOn();
        if (com.tencent.mm.plugin.collect.a.a.bOp())
        {
          this.nUB.alive();
          if (!bOG())
          {
            ad.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
            nUp = false;
            AppMethodBeat.o(63871);
            return;
          }
          ad.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
          nUp = true;
        }
      }
      ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "isF2fRingToneOpen() == false");
    }
  }
  
  public final class a
  {
    public int del;
    public String dem;
    public String den;
    public String deo;
    public int dep;
    public String deq;
    public long ed;
    
    public a(cd paramcd)
    {
      this.del = paramcd.dek.del;
      this.dem = paramcd.dek.dem;
      this.den = paramcd.dek.den;
      this.deo = paramcd.dek.deo;
      this.ed = paramcd.dek.ed;
      this.dep = paramcd.dek.dep;
      this.deq = paramcd.dek.deq;
    }
  }
  
  public final class b
    implements c
  {
    private a.c nUE;
    private ConcurrentLinkedQueue<a.a> nUF;
    
    public b(a.c paramc)
    {
      AppMethodBeat.i(63864);
      this.nUF = new ConcurrentLinkedQueue();
      this.nUE = paramc;
      AppMethodBeat.o(63864);
    }
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(63865);
      this.nUF.add(parama);
      AppMethodBeat.o(63865);
    }
    
    public final void o(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(63866);
      if (this.nUE == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.F2fRcvVoiceOffLineLogic.Listener", "onGetResult() errorCode:%s (voiceLlistener == null):%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (this.nUE != null)
        {
          a.a locala = (a.a)this.nUF.poll();
          this.nUE.a(paramInt, locala.den, locala.deo, locala.deq, locala.del, a.bOE().bOL(), paramArrayOfByte);
          if (paramInt < 0) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1143L, 20L, 1L, false);
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