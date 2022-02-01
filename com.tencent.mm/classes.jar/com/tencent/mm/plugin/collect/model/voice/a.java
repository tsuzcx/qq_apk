package com.tencent.mm.plugin.collect.model.voice;

import android.content.SharedPreferences.Editor;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.bu.a;
import com.tencent.mm.f.a.cm;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;

public class a
  implements MStorageEx.IOnStorageChange
{
  public static final String phE;
  public static boolean tVT;
  public static float tVU;
  public static float tVV;
  public static final String tVW;
  public static final String tVX;
  private static a tWd;
  private Object lock;
  public d tVY;
  public a.c tVZ;
  public a.b tWa;
  private String tWb;
  private int tWc;
  public IListener<bu> tWe;
  public IListener<rk> tWf;
  private boolean tWg;
  
  static
  {
    AppMethodBeat.i(63884);
    tVT = false;
    tVU = 0.9F;
    tVV = 10.0F;
    phE = com.tencent.mm.loader.j.b.aSC() + "files/wxofflinevoicenew/";
    tVW = phE + "libreadMoney.so";
    tVX = phE + "woman_putonghua.pos";
    AppMethodBeat.o(63884);
  }
  
  public a()
  {
    AppMethodBeat.i(63867);
    this.lock = new Object();
    this.tWc = 0;
    this.tWe = new IListener()
    {
      private boolean a(bu paramAnonymousbu)
      {
        AppMethodBeat.i(63858);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent callback");
        if (paramAnonymousbu.fxB.fxC == 60) {}
        synchronized (a.a(a.this))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", new Object[] { Integer.valueOf(paramAnonymousbu.fxB.fxC), Integer.valueOf(paramAnonymousbu.fxB.subType), paramAnonymousbu.fxB.fxF, Integer.valueOf(paramAnonymousbu.fxB.fxD) });
          if (paramAnonymousbu.fxB.subType == 1)
          {
            AppMethodBeat.o(63858);
            return false;
          }
          if (paramAnonymousbu.fxB.subType == 3)
          {
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_RES");
            if (u.agG(a.tVX))
            {
              Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " file exists，first delete exist file");
              u.deleteFile(a.tVX);
            }
            u.on(paramAnonymousbu.fxB.filePath, a.tVX);
            a.fR("0", paramAnonymousbu.fxB.fxF);
          }
          if (a.tVT)
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
    this.tWf = new IListener()
    {
      private boolean cOo()
      {
        AppMethodBeat.i(63860);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
        synchronized (a.a(a.this))
        {
          com.tencent.mm.plugin.collect.a.a.cNP();
          com.tencent.mm.plugin.collect.a.a.cNR();
          a.b(a.this);
          AppMethodBeat.o(63860);
          return false;
        }
      }
    };
    this.tWg = false;
    AppMethodBeat.o(63867);
  }
  
  public static void ain(String paramString)
  {
    AppMethodBeat.i(273452);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxq, paramString);
    EventCenter.instance.publish(new rk());
    AppMethodBeat.o(273452);
  }
  
  private static String aip(String paramString)
  {
    AppMethodBeat.i(63881);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(63881);
    return paramString;
  }
  
  public static String aiq(String paramString)
  {
    AppMethodBeat.i(273450);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_version", "");
    AppMethodBeat.o(273450);
    return paramString;
  }
  
  private boolean asC(String paramString)
  {
    AppMethodBeat.i(63877);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", new Object[] { Util.nullAs(paramString, "null") });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", new Object[] { tVX, u.buc(tVX) });
    if (paramString.equalsIgnoreCase(u.buc(tVX)))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 30L, 1L, false);
    cOj();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes autoDownloadDefaultResNum:%s", new Object[] { Integer.valueOf(this.tWc) });
    if (this.tWc < 5)
    {
      this.tWc += 1;
      boolean bool = cOl();
      AppMethodBeat.o(63877);
      return bool;
    }
    AppMethodBeat.o(63877);
    return false;
  }
  
  public static String bTP()
  {
    AppMethodBeat.i(273451);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxq, "0");
    AppMethodBeat.o(273451);
    return str;
  }
  
  public static a cOg()
  {
    AppMethodBeat.i(63868);
    try
    {
      if (tWd == null) {
        tWd = new a();
      }
      a locala = tWd;
      AppMethodBeat.o(63868);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(63868);
    }
  }
  
  private void cOh()
  {
    AppMethodBeat.i(63872);
    if (cOi())
    {
      tVT = true;
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
      AppMethodBeat.o(63872);
      return;
    }
    tVT = false;
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
    AppMethodBeat.o(63872);
  }
  
  private boolean cOi()
  {
    AppMethodBeat.i(63873);
    u.bBD(phE);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " checkResEnviroment() being ");
    this.tWe.alive();
    com.tencent.mm.pluginsdk.k.a.a.b.hii();
    com.tencent.mm.pluginsdk.k.a.a.b.apP(60);
    String str1 = bTP();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resId is %s", new Object[] { str1 });
    String str2 = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(str1, "");
    Object localObject1;
    Object localObject2;
    int i;
    if ((!Util.isNullOrNil(str2)) && (u.agG(str2))) {
      if (Util.isEqual(str1, "0"))
      {
        localObject1 = aip("0-1");
        localObject2 = aiq("0-1");
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resMd5:%s", new Object[] { Util.nullAs((String)localObject1, "null") });
        if (!Util.isNullOrNil((String)localObject1)) {
          break label205;
        }
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 is null :%s , resID:%s,version:%s", new Object[] { localObject1, str1, localObject2 });
        this.tWb = str1;
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
      localObject1 = aip(str1);
      localObject2 = aiq(str1);
      break;
      label205:
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resPath: %s md5:%s", new Object[] { str2, u.buc(str2) });
      if (((String)localObject1).equalsIgnoreCase(u.buc(str2)))
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 check success,resID:%s,version:%s", new Object[] { str1, localObject2 });
        this.tWb = str1;
        i = 1;
      }
      else
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 check failed");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 31L, 1L, false);
        u.deleteFile(str2);
        if (Util.isEqual(str1, "0")) {
          fR("0-1", "");
        }
        for (;;)
        {
          if (!cOk()) {
            break label358;
          }
          this.tWb = "woman_putonghua";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
          i = 1;
          break;
          fR(str1, "");
        }
        label358:
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
        this.tWb = "";
        i = 0;
        continue;
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "dont have this resID resource,resPath:%s %s", new Object[] { Util.nullAs(str2, "null"), Boolean.valueOf(u.agG(str2)) });
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "try to get default res");
        if (cOk())
        {
          this.tWb = "woman_putonghua";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
          i = 1;
        }
        else
        {
          this.tWb = "";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
          i = 0;
        }
      }
    }
    label464:
    if (this.tVY != null) {}
    for (;;)
    {
      try
      {
        this.tVY.tWv.destroy();
        this.tVY = d.a.tWw;
        localObject1 = this.tVY;
        localObject2 = this.tWa;
        ((d)localObject1).tWv.tWn = ((c)localObject2);
        localObject1 = this.tVY;
        localObject2 = phE;
        str1 = this.tWb;
        i = ((d)localObject1).tWv.fS((String)localObject2, str1);
        if (i >= 0) {
          break;
        }
        Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret%s res:%s", new Object[] { Integer.valueOf(i), this.tWb });
        if (Util.isEqual(i, -201))
        {
          if (!Util.isEqual(this.tWb, "woman_putonghua"))
          {
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", new Object[] { this.tWb });
            ain("0");
            cOh();
          }
          if (i != -101) {
            break label807;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 1L, 1L, false);
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
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s", new Object[] { tVW });
      } else if ((i <= -2) && (i >= -9)) {
        if (Util.isEqual(this.tWb, "woman_putonghua"))
        {
          cOj();
          if (this.tWc < 5)
          {
            this.tWc += 1;
            if (cOl()) {
              cOh();
            }
          }
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ret:%s delete %s : %s", new Object[] { Integer.valueOf(i), tVX, Integer.valueOf(this.tWc) });
          continue;
          label807:
          if (i == -102) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 2L, 1L, false);
          } else if (i == -103) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 3L, 1L, false);
          } else if (i == -104) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 4L, 1L, false);
          } else if (i == -201) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 5L, 1L, false);
          } else if (i == -202) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 6L, 1L, false);
          } else if (i == -203) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 7L, 1L, false);
          } else if (i == -204) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 8L, 1L, false);
          } else if (i == -205) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 9L, 1L, false);
          } else if (i == -206) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 10L, 1L, false);
          } else if (i == -207) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 11L, 1L, false);
          } else if ((i <= -2) && (i >= -9)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 12L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 13L, 1L, false);
          }
        }
      }
    }
    this.tWc = 0;
    d locald = this.tVY;
    float f = tVV;
    locald.tWv.mVolume = f;
    locald = this.tVY;
    f = tVU;
    locald.tWv.dU = f;
    AppMethodBeat.o(63873);
    return true;
  }
  
  private static void cOj()
  {
    AppMethodBeat.i(63874);
    u.deleteFile(tVX);
    fR("0", "");
    AppMethodBeat.o(63874);
  }
  
  private boolean cOk()
  {
    AppMethodBeat.i(63875);
    if (u.agG(tVX))
    {
      boolean bool = cOm();
      AppMethodBeat.o(63875);
      return bool;
    }
    if (cOl())
    {
      AppMethodBeat.o(63875);
      return true;
    }
    AppMethodBeat.o(63875);
    return false;
  }
  
  private boolean cOl()
  {
    AppMethodBeat.i(63876);
    com.tencent.mm.pluginsdk.k.a.a.b.hii();
    String str = com.tencent.mm.pluginsdk.k.a.a.b.lV(60, 3);
    boolean bool = u.agG(str);
    Log.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", new Object[] { str });
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResFromCache() %s no exist, cacheExist: %s", new Object[] { tVX, Boolean.valueOf(bool) });
    if (bool)
    {
      long l = u.on(str, tVX);
      fR("0", "");
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", new Object[] { Long.valueOf(l) });
      if (!Util.isEqual(l, -1L))
      {
        com.tencent.mm.pluginsdk.k.a.a.b.hii();
        str = com.tencent.mm.pluginsdk.k.a.a.b.hij();
        fR("0", str);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", new Object[] { str });
        bool = asC(str);
        AppMethodBeat.o(63876);
        return bool;
      }
    }
    AppMethodBeat.o(63876);
    return false;
  }
  
  private boolean cOm()
  {
    AppMethodBeat.i(63878);
    boolean bool = asC(aip("0"));
    AppMethodBeat.o(63878);
    return bool;
  }
  
  public static void fR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63882);
    MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_md5", Util.nullAs(paramString2, "")).commit();
    AppMethodBeat.o(63882);
  }
  
  public static int p(final String paramString1, String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(273453);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    final String str = phE + paramString4 + ".pos";
    localC2CDownloadRequest.fileKey = paramString4;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.setSavePath(str);
    localC2CDownloadRequest.fileType = 101;
    localC2CDownloadRequest.taskStartTime = Util.nowMilliSecond();
    long l = localC2CDownloadRequest.taskStartTime;
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download beginTime : %s", new Object[] { Long.valueOf(localC2CDownloadRequest.taskStartTime) });
    int i = CdnLogic.startURLDownload(localC2CDownloadRequest, new CdnLogic.DownloadCallback()
    {
      public final void onC2CDownloadCompleted(String paramAnonymousString, CdnLogic.C2CDownloadResult paramAnonymousC2CDownloadResult)
      {
        AppMethodBeat.i(276396);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download end , cost：%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - this.mjb) });
        if ((paramAnonymousC2CDownloadResult != null) && (paramAnonymousC2CDownloadResult.cronetTaskResult != null) && (paramAnonymousC2CDownloadResult.cronetTaskResult.performance != null)) {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download end, url:%s, statusCode:%d, profile:%s", new Object[] { str, Integer.valueOf(paramAnonymousC2CDownloadResult.cronetTaskResult.statusCode), paramAnonymousC2CDownloadResult.cronetTaskResult.performance });
        }
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download result.errorCode ：%s， tempFilePath ：%s , md5：%s , file downaload md5:%s ", new Object[] { Integer.valueOf(paramAnonymousC2CDownloadResult.errorCode), paramString4, paramString1, u.buc(paramString4) });
        if (paramAnonymousC2CDownloadResult.errorCode != 0)
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download failed:%s", new Object[] { Integer.valueOf(paramAnonymousC2CDownloadResult.errorCode) });
          AppMethodBeat.o(276396);
          return;
        }
        if (!u.agG(paramString4))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "  download File fail:%s", new Object[] { paramString4 });
          AppMethodBeat.o(276396);
          return;
        }
        if (!paramString1.equalsIgnoreCase(u.buc(paramString4)))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "download md5 check failed，md5 :%s    ,  download md5:%s", new Object[] { paramString1, u.buc(paramString4) });
          AppMethodBeat.o(276396);
          return;
        }
        u.bBD(a.phE);
        paramAnonymousString = a.phE + paramString3 + ".pos";
        if (u.agG(paramAnonymousString))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has this voice resource before ，first delete exist file");
          u.deleteFile(paramAnonymousString);
        }
        u.on(paramString4, paramAnonymousString);
        u.deleteFile(paramString4);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile form %s  to   %s", new Object[] { paramString4, paramAnonymousString });
        com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d.bTQ().k(paramString3, paramAnonymousString, paramString1, this.tWk);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "save config  posID： %s，voicePath：%s ， md5 ：%s , version:%s", new Object[] { paramString3, paramAnonymousString, paramString1, this.tWk });
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "currentResID %s、download ResID %s", new Object[] { a.bTP(), paramString3 });
        if (a.bTP().equals(paramString3))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "set currentResID  for new resource");
          a.ain(paramString3);
        }
        AppMethodBeat.o(276396);
      }
      
      public final void onDownloadProgressChanged(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(273453);
    return i;
  }
  
  public final void a(cm paramcm)
  {
    AppMethodBeat.i(63879);
    paramcm = new a.a(this, paramcm);
    this.tWa.a(paramcm);
    this.tVY.asD(paramcm.fyf);
    Log.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", new Object[] { paramcm.fyf });
    AppMethodBeat.o(63879);
  }
  
  public final String cOn()
  {
    AppMethodBeat.i(63880);
    if (Util.isEqual(this.tWb, "woman_putonghua")) {}
    for (String str = "0";; str = this.tWb)
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
      if (tVT)
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
        AppMethodBeat.o(63871);
        return;
      }
      com.tencent.mm.plugin.collect.a.a.cNP();
      com.tencent.mm.plugin.collect.a.a.cNR();
      this.tWf.alive();
      if (!cOi())
      {
        Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
        tVT = false;
        AppMethodBeat.o(63871);
        return;
      }
      Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
      tVT = true;
    }
  }
  
  public final void lZ(boolean paramBoolean)
  {
    AppMethodBeat.i(63870);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " begin initTTS()，delay：%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      com.tencent.e.h.ZvG.a(new Runnable()
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
    com.tencent.e.h.ZvG.d(new Runnable()
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
    if (this.tWg)
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()：is already init()");
      AppMethodBeat.o(63869);
      return;
    }
    com.tencent.mm.plugin.collect.a.a.cNP();
    com.tencent.mm.plugin.collect.a.a.cNR();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
    lZ(true);
    this.tWg = true;
    com.tencent.mm.kernel.h.aHG().aHp().remove(this);
    AppMethodBeat.o(63869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a
 * JD-Core Version:    0.7.0.1
 */