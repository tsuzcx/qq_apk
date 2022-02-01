package com.tencent.mm.plugin.collect.model.voice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements n.b
{
  public static final String kEr;
  public static boolean oxK;
  public static float oxL;
  public static float oxM;
  public static final String oxN;
  public static final String oxO;
  private static a oxU;
  private Object lock;
  public d oxP;
  public c oxQ;
  public b oxR;
  private String oxS;
  private int oxT;
  public com.tencent.mm.sdk.b.c<bk> oxV;
  public com.tencent.mm.sdk.b.c<ph> oxW;
  private boolean oxX;
  
  static
  {
    AppMethodBeat.i(63884);
    oxK = false;
    oxL = 0.9F;
    oxM = 10.0F;
    kEr = com.tencent.mm.loader.j.b.aoY() + "files/wxofflinevoicenew/";
    oxN = kEr + "libreadMoney.so";
    oxO = kEr + "woman_putonghua.pos";
    AppMethodBeat.o(63884);
  }
  
  public a()
  {
    AppMethodBeat.i(63867);
    this.lock = new Object();
    this.oxT = 0;
    this.oxV = new a.1(this);
    this.oxW = new com.tencent.mm.sdk.b.c()
    {
      private boolean bWc()
      {
        AppMethodBeat.i(63860);
        ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
        synchronized (a.a(a.this))
        {
          com.tencent.mm.plugin.collect.a.a.bVD();
          if (com.tencent.mm.plugin.collect.a.a.bVF())
          {
            a.b(a.this);
            AppMethodBeat.o(63860);
            return false;
          }
          ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent isF2fRingToneOpen() == false");
        }
      }
    };
    this.oxX = false;
    AppMethodBeat.o(63867);
  }
  
  private static String MR(String paramString)
  {
    AppMethodBeat.i(63881);
    paramString = aw.aKT("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(63881);
    return paramString;
  }
  
  private boolean Wj(String paramString)
  {
    AppMethodBeat.i(63877);
    ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", new Object[] { bs.bG(paramString, "null") });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", new Object[] { oxO, com.tencent.mm.vfs.i.aKe(oxO) });
    if (paramString.equalsIgnoreCase(com.tencent.mm.vfs.i.aKe(oxO)))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 30L, 1L, false);
    bVX();
    ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes autoDownloadDefaultResNum:%s", new Object[] { Integer.valueOf(this.oxT) });
    if (this.oxT < 5)
    {
      this.oxT += 1;
      boolean bool = bVZ();
      AppMethodBeat.o(63877);
      return bool;
    }
    AppMethodBeat.o(63877);
    return false;
  }
  
  public static a bVU()
  {
    AppMethodBeat.i(63868);
    try
    {
      if (oxU == null) {
        oxU = new a();
      }
      a locala = oxU;
      AppMethodBeat.o(63868);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(63868);
    }
  }
  
  private void bVV()
  {
    AppMethodBeat.i(63872);
    if (bVW())
    {
      oxK = true;
      ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
      AppMethodBeat.o(63872);
      return;
    }
    oxK = false;
    ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
    AppMethodBeat.o(63872);
  }
  
  private boolean bVW()
  {
    AppMethodBeat.i(63873);
    com.tencent.mm.vfs.i.aSh(kEr);
    this.oxV.alive();
    com.tencent.mm.pluginsdk.h.a.a.b.eLH();
    com.tencent.mm.pluginsdk.h.a.a.b.WB(60);
    Object localObject1 = (String)g.agR().agA().get(ah.a.GTp, "0");
    int i;
    if (bs.lr((String)localObject1, "0")) {
      if (bVY())
      {
        this.oxS = "woman_putonghua";
        i = 1;
      }
    }
    Object localObject2;
    String str;
    while (i == 0)
    {
      AppMethodBeat.o(63873);
      return false;
      this.oxS = "";
      i = 0;
      continue;
      localObject2 = aw.aKT("voice_offline_res_new").getString((String)localObject1, "");
      if ((!bs.isNullOrNil((String)localObject2)) && (com.tencent.mm.vfs.i.eA((String)localObject2)))
      {
        str = MR((String)localObject1);
        ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resMd5:%s", new Object[] { bs.bG(str, "null") });
        if (bs.isNullOrNil(str))
        {
          this.oxS = ((String)localObject1);
          i = 1;
        }
        else
        {
          ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() %s md5:%s", new Object[] { localObject2, com.tencent.mm.vfs.i.aKe((String)localObject2) });
          if (str.equalsIgnoreCase(com.tencent.mm.vfs.i.aKe((String)localObject2)))
          {
            this.oxS = ((String)localObject1);
            i = 1;
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 31L, 1L, false);
            com.tencent.mm.vfs.i.deleteFile((String)localObject2);
            eY((String)localObject1, "");
            if (bVY())
            {
              this.oxS = "woman_putonghua";
              i = 1;
            }
            else
            {
              this.oxS = "";
              i = 0;
            }
          }
        }
      }
      else
      {
        ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "resPath:%s %s", new Object[] { bs.bG((String)localObject2, "null"), Boolean.valueOf(com.tencent.mm.vfs.i.eA((String)localObject2)) });
        if (bVY())
        {
          this.oxS = "woman_putonghua";
          i = 1;
        }
        else
        {
          this.oxS = "";
          i = 0;
        }
      }
    }
    if (this.oxP != null) {}
    for (;;)
    {
      try
      {
        this.oxP.oyj.destroy();
        this.oxP = d.a.oyk;
        localObject1 = this.oxP;
        localObject2 = this.oxR;
        ((d)localObject1).oyj.oyb = ((c)localObject2);
        localObject1 = this.oxP;
        localObject2 = kEr;
        str = this.oxS;
        i = ((d)localObject1).oyj.eZ((String)localObject2, str);
        if (i >= 0) {
          break;
        }
        ac.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret%s res:%s", new Object[] { Integer.valueOf(i), this.oxS });
        if (bs.jl(i, -201))
        {
          if (!bs.lr(this.oxS, "woman_putonghua"))
          {
            ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", new Object[] { this.oxS });
            g.agR().agA().set(ah.a.GTp, "0");
            com.tencent.mm.sdk.b.a.GpY.l(new ph());
            bVV();
          }
          if (i != -101) {
            break label703;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 1L, 1L, false);
          AppMethodBeat.o(63873);
          return false;
        }
      }
      catch (Exception localException)
      {
        ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(63873);
        return false;
      }
      if (bs.jl(i, -207)) {
        ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s", new Object[] { oxN });
      } else if ((i <= -2) && (i >= -9)) {
        if (bs.lr(this.oxS, "woman_putonghua"))
        {
          bVX();
          if (this.oxT < 5)
          {
            this.oxT += 1;
            if (bVZ()) {
              bVV();
            }
          }
          ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ret:%s delete %s : %s", new Object[] { Integer.valueOf(i), oxO, Integer.valueOf(this.oxT) });
          continue;
          label703:
          if (i == -102) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 2L, 1L, false);
          } else if (i == -103) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 3L, 1L, false);
          } else if (i == -104) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 4L, 1L, false);
          } else if (i == -201) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 5L, 1L, false);
          } else if (i == -202) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 6L, 1L, false);
          } else if (i == -203) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 7L, 1L, false);
          } else if (i == -204) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 8L, 1L, false);
          } else if (i == -205) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 9L, 1L, false);
          } else if (i == -206) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 10L, 1L, false);
          } else if (i == -207) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 11L, 1L, false);
          } else if ((i <= -2) && (i >= -9)) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 12L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 13L, 1L, false);
          }
        }
      }
    }
    this.oxT = 0;
    d locald = this.oxP;
    float f = oxM;
    locald.oyj.mVolume = f;
    locald = this.oxP;
    f = oxL;
    locald.oyj.Lc = f;
    AppMethodBeat.o(63873);
    return true;
  }
  
  private static void bVX()
  {
    AppMethodBeat.i(63874);
    com.tencent.mm.vfs.i.deleteFile(oxO);
    eY("0", "");
    AppMethodBeat.o(63874);
  }
  
  private boolean bVY()
  {
    AppMethodBeat.i(63875);
    if (com.tencent.mm.vfs.i.eA(oxO))
    {
      boolean bool = bWa();
      AppMethodBeat.o(63875);
      return bool;
    }
    if (bVZ())
    {
      AppMethodBeat.o(63875);
      return true;
    }
    AppMethodBeat.o(63875);
    return false;
  }
  
  private boolean bVZ()
  {
    AppMethodBeat.i(63876);
    com.tencent.mm.pluginsdk.h.a.a.b.eLH();
    String str = com.tencent.mm.pluginsdk.h.a.a.b.ja(60, 3);
    boolean bool = com.tencent.mm.vfs.i.eA(str);
    ac.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", new Object[] { str });
    ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResFromCache() %s no exist, cacheExist: %s", new Object[] { oxO, Boolean.valueOf(bool) });
    if (bool)
    {
      long l = com.tencent.mm.vfs.i.lZ(str, oxO);
      eY("0", "");
      ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", new Object[] { Long.valueOf(l) });
      if (!bs.av(l, -1L))
      {
        com.tencent.mm.pluginsdk.h.a.a.b.eLH();
        str = com.tencent.mm.pluginsdk.h.a.a.b.eLI();
        eY("0", str);
        ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", new Object[] { str });
        bool = Wj(str);
        AppMethodBeat.o(63876);
        return bool;
      }
    }
    AppMethodBeat.o(63876);
    return false;
  }
  
  private boolean bWa()
  {
    AppMethodBeat.i(63878);
    boolean bool = Wj(MR("0"));
    AppMethodBeat.o(63878);
    return bool;
  }
  
  public static void eY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63882);
    aw.aKT("voice_offline_res_new").edit().putString(paramString1 + "_md5", bs.bG(paramString2, "")).commit();
    AppMethodBeat.o(63882);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(63869);
    if (this.oxX)
    {
      AppMethodBeat.o(63869);
      return;
    }
    com.tencent.mm.plugin.collect.a.a.bVD();
    if (com.tencent.mm.plugin.collect.a.a.bVF())
    {
      ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
      jA(true);
      this.oxX = true;
      g.agR().agA().b(this);
    }
    AppMethodBeat.o(63869);
  }
  
  public final void a(cd paramcd)
  {
    AppMethodBeat.i(63879);
    paramcd = new a.a(this, paramcd);
    this.oxR.a(paramcd);
    this.oxP.start(paramcd.dbM);
    ac.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", new Object[] { paramcd.dbM });
    AppMethodBeat.o(63879);
  }
  
  public final String bWb()
  {
    AppMethodBeat.i(63880);
    if (bs.lr(this.oxS, "woman_putonghua")) {}
    for (String str = "0";; str = this.oxS)
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
        if (oxK)
        {
          ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
          AppMethodBeat.o(63871);
          return;
        }
        com.tencent.mm.plugin.collect.a.a.bVD();
        if (com.tencent.mm.plugin.collect.a.a.bVF())
        {
          this.oxW.alive();
          if (!bVW())
          {
            ac.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
            oxK = false;
            AppMethodBeat.o(63871);
            return;
          }
          ac.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
          oxK = true;
        }
      }
      ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "isF2fRingToneOpen() == false");
    }
  }
  
  public final void jA(boolean paramBoolean)
  {
    AppMethodBeat.i(63870);
    if (paramBoolean)
    {
      com.tencent.e.h.JZN.a(new Runnable()
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
    com.tencent.e.h.JZN.f(new Runnable()
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
    private a.c oxZ;
    private ConcurrentLinkedQueue<a.a> oya;
    
    public b(a.c paramc)
    {
      AppMethodBeat.i(63864);
      this.oya = new ConcurrentLinkedQueue();
      this.oxZ = paramc;
      AppMethodBeat.o(63864);
    }
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(63865);
      this.oya.add(parama);
      AppMethodBeat.o(63865);
    }
    
    public final void o(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(63866);
      if (this.oxZ == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.F2fRcvVoiceOffLineLogic.Listener", "onGetResult() errorCode:%s (voiceLlistener == null):%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (this.oxZ != null)
        {
          a.a locala = (a.a)this.oya.poll();
          this.oxZ.a(paramInt, locala.dbJ, locala.dbK, locala.dbM, locala.dbH, a.bVU().bWb(), paramArrayOfByte);
          if (paramInt < 0) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1143L, 20L, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a
 * JD-Core Version:    0.7.0.1
 */