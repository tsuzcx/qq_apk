package com.tencent.mm.plugin.collect.model.voice;

import android.content.SharedPreferences.Editor;
import com.tencent.f.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.ci.a;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements MStorageEx.IOnStorageChange
{
  public static final String mjC;
  public static boolean qwT;
  public static float qwU;
  public static float qwV;
  public static final String qwW;
  public static final String qwX;
  private static a qxd;
  private Object lock;
  public d qwY;
  public c qwZ;
  public b qxa;
  private String qxb;
  private int qxc;
  public IListener<bp> qxe;
  public IListener<qk> qxf;
  private boolean qxg;
  
  static
  {
    AppMethodBeat.i(63884);
    qwT = false;
    qwU = 0.9F;
    qwV = 10.0F;
    mjC = com.tencent.mm.loader.j.b.aKA() + "files/wxofflinevoicenew/";
    qwW = mjC + "libreadMoney.so";
    qwX = mjC + "woman_putonghua.pos";
    AppMethodBeat.o(63884);
  }
  
  public a()
  {
    AppMethodBeat.i(63867);
    this.lock = new Object();
    this.qxc = 0;
    this.qxe = new IListener()
    {
      private boolean a(bp paramAnonymousbp)
      {
        AppMethodBeat.i(63858);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent callback");
        if (paramAnonymousbp.dEN.dEO == 60) {}
        synchronized (a.a(a.this))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", new Object[] { Integer.valueOf(paramAnonymousbp.dEN.dEO), Integer.valueOf(paramAnonymousbp.dEN.subType), paramAnonymousbp.dEN.dER, Integer.valueOf(paramAnonymousbp.dEN.dEP) });
          if (paramAnonymousbp.dEN.subType == 1)
          {
            AppMethodBeat.o(63858);
            return false;
          }
          if (paramAnonymousbp.dEN.subType == 3)
          {
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_RES");
            if (s.YS(a.qwX))
            {
              Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " file exists，first delete exist file");
              s.deleteFile(a.qwX);
            }
            s.nw(paramAnonymousbp.dEN.filePath, a.qwX);
            a.fD("0", paramAnonymousbp.dEN.dER);
          }
          if (a.qwT)
          {
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true, do not reInit Synthesizer");
            AppMethodBeat.o(63858);
            return false;
          }
          a.b(a.this);
          AppMethodBeat.o(63858);
          return false;
        }
      }
    };
    this.qxf = new IListener()
    {
      private boolean czO()
      {
        AppMethodBeat.i(63860);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
        synchronized (a.a(a.this))
        {
          com.tencent.mm.plugin.collect.a.a.czp();
          com.tencent.mm.plugin.collect.a.a.czr();
          a.b(a.this);
          AppMethodBeat.o(63860);
          return false;
        }
      }
    };
    this.qxg = false;
    AppMethodBeat.o(63867);
  }
  
  public static void aaw(String paramString)
  {
    AppMethodBeat.i(213156);
    g.aAh().azQ().set(ar.a.Oja, paramString);
    EventCenter.instance.publish(new qk());
    AppMethodBeat.o(213156);
  }
  
  private static String aay(String paramString)
  {
    AppMethodBeat.i(63881);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(63881);
    return paramString;
  }
  
  public static String aaz(String paramString)
  {
    AppMethodBeat.i(213154);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_version", "");
    AppMethodBeat.o(213154);
    return paramString;
  }
  
  private boolean akN(String paramString)
  {
    AppMethodBeat.i(63877);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", new Object[] { Util.nullAs(paramString, "null") });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", new Object[] { qwX, s.bhK(qwX) });
    if (paramString.equalsIgnoreCase(s.bhK(qwX)))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 30L, 1L, false);
    czJ();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes autoDownloadDefaultResNum:%s", new Object[] { Integer.valueOf(this.qxc) });
    if (this.qxc < 5)
    {
      this.qxc += 1;
      boolean bool = czL();
      AppMethodBeat.o(63877);
      return bool;
    }
    AppMethodBeat.o(63877);
    return false;
  }
  
  public static String bIg()
  {
    AppMethodBeat.i(213155);
    String str = (String)g.aAh().azQ().get(ar.a.Oja, "0");
    AppMethodBeat.o(213155);
    return str;
  }
  
  public static a czG()
  {
    AppMethodBeat.i(63868);
    try
    {
      if (qxd == null) {
        qxd = new a();
      }
      a locala = qxd;
      AppMethodBeat.o(63868);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(63868);
    }
  }
  
  private void czH()
  {
    AppMethodBeat.i(63872);
    if (czI())
    {
      qwT = true;
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
      AppMethodBeat.o(63872);
      return;
    }
    qwT = false;
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
    AppMethodBeat.o(63872);
  }
  
  private boolean czI()
  {
    AppMethodBeat.i(63873);
    s.boN(mjC);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " checkResEnviroment() being ");
    this.qxe.alive();
    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
    com.tencent.mm.pluginsdk.j.a.a.b.ahP(60);
    String str1 = bIg();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resId is %s", new Object[] { str1 });
    String str2 = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(str1, "");
    Object localObject1;
    Object localObject2;
    int i;
    if ((!Util.isNullOrNil(str2)) && (s.YS(str2))) {
      if (Util.isEqual(str1, "0"))
      {
        localObject1 = aay("0-1");
        localObject2 = aaz("0-1");
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resMd5:%s", new Object[] { Util.nullAs((String)localObject1, "null") });
        if (!Util.isNullOrNil((String)localObject1)) {
          break label205;
        }
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 is null :%s , resID:%s,version:%s", new Object[] { localObject1, str1, localObject2 });
        this.qxb = str1;
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label464;
      }
      AppMethodBeat.o(63873);
      return false;
      localObject1 = aay(str1);
      localObject2 = aaz(str1);
      break;
      label205:
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resPath: %s md5:%s", new Object[] { str2, s.bhK(str2) });
      if (((String)localObject1).equalsIgnoreCase(s.bhK(str2)))
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 check success,resID:%s,version:%s", new Object[] { str1, localObject2 });
        this.qxb = str1;
        i = 1;
      }
      else
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 check failed");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 31L, 1L, false);
        s.deleteFile(str2);
        if (Util.isEqual(str1, "0")) {
          fD("0-1", "");
        }
        for (;;)
        {
          if (!czK()) {
            break label358;
          }
          this.qxb = "woman_putonghua";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
          i = 1;
          break;
          fD(str1, "");
        }
        label358:
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
        this.qxb = "";
        i = 0;
        continue;
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "dont have this resID resource,resPath:%s %s", new Object[] { Util.nullAs(str2, "null"), Boolean.valueOf(s.YS(str2)) });
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "try to get default res");
        if (czK())
        {
          this.qxb = "woman_putonghua";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
          i = 1;
        }
        else
        {
          this.qxb = "";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
          i = 0;
        }
      }
    }
    label464:
    if (this.qwY != null) {}
    for (;;)
    {
      try
      {
        this.qwY.qxv.destroy();
        this.qwY = d.a.qxw;
        localObject1 = this.qwY;
        localObject2 = this.qxa;
        ((d)localObject1).qxv.qxn = ((c)localObject2);
        localObject1 = this.qwY;
        localObject2 = mjC;
        str1 = this.qxb;
        i = ((d)localObject1).qxv.fE((String)localObject2, str1);
        if (i >= 0) {
          break;
        }
        Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret%s res:%s", new Object[] { Integer.valueOf(i), this.qxb });
        if (Util.isEqual(i, -201))
        {
          if (!Util.isEqual(this.qxb, "woman_putonghua"))
          {
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", new Object[] { this.qxb });
            aaw("0");
            czH();
          }
          if (i != -101) {
            break label807;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 1L, 1L, false);
          AppMethodBeat.o(63873);
          return false;
        }
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(63873);
        return false;
      }
      if (Util.isEqual(i, -207)) {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s", new Object[] { qwW });
      } else if ((i <= -2) && (i >= -9)) {
        if (Util.isEqual(this.qxb, "woman_putonghua"))
        {
          czJ();
          if (this.qxc < 5)
          {
            this.qxc += 1;
            if (czL()) {
              czH();
            }
          }
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ret:%s delete %s : %s", new Object[] { Integer.valueOf(i), qwX, Integer.valueOf(this.qxc) });
          continue;
          label807:
          if (i == -102) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 2L, 1L, false);
          } else if (i == -103) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 3L, 1L, false);
          } else if (i == -104) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 4L, 1L, false);
          } else if (i == -201) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 5L, 1L, false);
          } else if (i == -202) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 6L, 1L, false);
          } else if (i == -203) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 7L, 1L, false);
          } else if (i == -204) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 8L, 1L, false);
          } else if (i == -205) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 9L, 1L, false);
          } else if (i == -206) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 10L, 1L, false);
          } else if (i == -207) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 11L, 1L, false);
          } else if ((i <= -2) && (i >= -9)) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 12L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 13L, 1L, false);
          }
        }
      }
    }
    this.qxc = 0;
    d locald = this.qwY;
    float f = qwV;
    locald.qxv.mVolume = f;
    locald = this.qwY;
    f = qwU;
    locald.qxv.Ne = f;
    AppMethodBeat.o(63873);
    return true;
  }
  
  private static void czJ()
  {
    AppMethodBeat.i(63874);
    s.deleteFile(qwX);
    fD("0", "");
    AppMethodBeat.o(63874);
  }
  
  private boolean czK()
  {
    AppMethodBeat.i(63875);
    if (s.YS(qwX))
    {
      boolean bool = czM();
      AppMethodBeat.o(63875);
      return bool;
    }
    if (czL())
    {
      AppMethodBeat.o(63875);
      return true;
    }
    AppMethodBeat.o(63875);
    return false;
  }
  
  private boolean czL()
  {
    AppMethodBeat.i(63876);
    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
    String str = com.tencent.mm.pluginsdk.j.a.a.b.kC(60, 3);
    boolean bool = s.YS(str);
    Log.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", new Object[] { str });
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResFromCache() %s no exist, cacheExist: %s", new Object[] { qwX, Boolean.valueOf(bool) });
    if (bool)
    {
      long l = s.nw(str, qwX);
      fD("0", "");
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", new Object[] { Long.valueOf(l) });
      if (!Util.isEqual(l, -1L))
      {
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        str = com.tencent.mm.pluginsdk.j.a.a.b.gnD();
        fD("0", str);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", new Object[] { str });
        bool = akN(str);
        AppMethodBeat.o(63876);
        return bool;
      }
    }
    AppMethodBeat.o(63876);
    return false;
  }
  
  private boolean czM()
  {
    AppMethodBeat.i(63878);
    boolean bool = akN(aay("0"));
    AppMethodBeat.o(63878);
    return bool;
  }
  
  public static void fD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63882);
    MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_md5", Util.nullAs(paramString2, "")).commit();
    AppMethodBeat.o(63882);
  }
  
  public static int l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(213157);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    String str = mjC + paramString4 + ".pos";
    localC2CDownloadRequest.fileKey = paramString4;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.setSavePath(str);
    localC2CDownloadRequest.fileType = 101;
    localC2CDownloadRequest.taskStartTime = Util.nowMilliSecond();
    long l = localC2CDownloadRequest.taskStartTime;
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download beginTime : %s", new Object[] { Long.valueOf(localC2CDownloadRequest.taskStartTime) });
    int i = CdnLogic.startURLDownload(localC2CDownloadRequest, new a.5(l, paramString2, str, paramString4, paramString1, paramString3));
    AppMethodBeat.o(213157);
    return i;
  }
  
  public final void a(ci paramci)
  {
    AppMethodBeat.i(63879);
    paramci = new a(paramci);
    this.qxa.a(paramci);
    this.qwY.start(paramci.dFy);
    Log.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", new Object[] { paramci.dFy });
    AppMethodBeat.o(63879);
  }
  
  public final String czN()
  {
    AppMethodBeat.i(63880);
    if (Util.isEqual(this.qxb, "woman_putonghua")) {}
    for (String str = "0";; str = this.qxb)
    {
      AppMethodBeat.o(63880);
      return str;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(63871);
    synchronized (this.lock)
    {
      if (qwT)
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
        AppMethodBeat.o(63871);
        return;
      }
      com.tencent.mm.plugin.collect.a.a.czp();
      com.tencent.mm.plugin.collect.a.a.czr();
      this.qxf.alive();
      if (!czI())
      {
        Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
        qwT = false;
        AppMethodBeat.o(63871);
        return;
      }
      Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
      qwT = true;
    }
  }
  
  public final void kN(boolean paramBoolean)
  {
    AppMethodBeat.i(63870);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " begin initTTS()，delay：%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      com.tencent.f.h.RTc.a(new Runnable()
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
    com.tencent.f.h.RTc.b(new Runnable()
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
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(63869);
    if (this.qxg)
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()：is already init()");
      AppMethodBeat.o(63869);
      return;
    }
    com.tencent.mm.plugin.collect.a.a.czp();
    com.tencent.mm.plugin.collect.a.a.czr();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
    kN(true);
    this.qxg = true;
    g.aAh().azQ().remove(this);
    AppMethodBeat.o(63869);
  }
  
  public final class a
  {
    public int dFu;
    public String dFv;
    public String dFw;
    public String dFx;
    public String dFy;
    public long gY;
    public int source;
    
    public a(ci paramci)
    {
      this.dFu = paramci.dFt.dFu;
      this.dFv = paramci.dFt.dFv;
      this.dFw = paramci.dFt.dFw;
      this.dFx = paramci.dFt.dFx;
      this.gY = paramci.dFt.gY;
      this.source = paramci.dFt.source;
      this.dFy = paramci.dFt.dFy;
    }
  }
  
  public final class b
    implements c
  {
    private a.c qxl;
    private ConcurrentLinkedQueue<a.a> qxm;
    
    public b(a.c paramc)
    {
      AppMethodBeat.i(63864);
      this.qxm = new ConcurrentLinkedQueue();
      this.qxl = paramc;
      AppMethodBeat.o(63864);
    }
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(63865);
      this.qxm.add(parama);
      AppMethodBeat.o(63865);
    }
    
    public final void o(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(63866);
      if (this.qxl == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.F2fRcvVoiceOffLineLogic.Listener", "onGetResult() errorCode:%s (voiceLlistener == null):%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if (this.qxl != null)
        {
          a.a locala = (a.a)this.qxm.poll();
          this.qxl.a(paramInt, locala.dFw, locala.dFx, locala.dFy, locala.dFu, a.czG().czN(), paramArrayOfByte);
          if (paramInt < 0) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1143L, 20L, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a
 * JD-Core Version:    0.7.0.1
 */