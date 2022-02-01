package com.tencent.mm.plugin.collect.model.voice;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cv;
import com.tencent.mm.autogen.a.sz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;

public class a
  implements MStorageEx.IOnStorageChange
{
  public static final String smX;
  public static boolean wZn;
  public static float wZo;
  public static float wZp;
  public static final String wZq;
  public static final String wZr;
  private static a wZx;
  private Object lock;
  private boolean wZA;
  public d wZs;
  public a.c wZt;
  public a.b wZu;
  private String wZv;
  private int wZw;
  public IListener<cd> wZy;
  public IListener<sz> wZz;
  
  static
  {
    AppMethodBeat.i(63884);
    wZn = false;
    wZo = 0.9F;
    wZp = 10.0F;
    smX = com.tencent.mm.loader.i.b.bmq() + "files/wxofflinevoicenew/";
    wZq = smX + "libreadMoney.so";
    wZr = smX + "woman_putonghua.pos";
    AppMethodBeat.o(63884);
  }
  
  public a()
  {
    AppMethodBeat.i(63867);
    this.lock = new Object();
    this.wZw = 0;
    this.wZy = new F2fRcvVoiceOffLineLogic.1(this, com.tencent.mm.app.f.hfK);
    this.wZz = new F2fRcvVoiceOffLineLogic.2(this, com.tencent.mm.app.f.hfK);
    this.wZA = false;
    AppMethodBeat.o(63867);
  }
  
  public static void abl(String paramString)
  {
    AppMethodBeat.i(293588);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acZc, paramString);
    new sz().publish();
    AppMethodBeat.o(293588);
  }
  
  private static String abn(String paramString)
  {
    AppMethodBeat.i(63881);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(63881);
    return paramString;
  }
  
  public static String abo(String paramString)
  {
    AppMethodBeat.i(293583);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_version", "");
    AppMethodBeat.o(293583);
    return paramString;
  }
  
  private boolean amh(String paramString)
  {
    AppMethodBeat.i(63877);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", new Object[] { Util.nullAs(paramString, "null") });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", new Object[] { wZr, y.bub(wZr) });
    if (paramString.equalsIgnoreCase(y.bub(wZr)))
    {
      AppMethodBeat.o(63877);
      return true;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 30L, 1L, false);
    drO();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes autoDownloadDefaultResNum:%s", new Object[] { Integer.valueOf(this.wZw) });
    if (this.wZw < 5)
    {
      this.wZw += 1;
      boolean bool = drQ();
      AppMethodBeat.o(63877);
      return bool;
    }
    AppMethodBeat.o(63877);
    return false;
  }
  
  public static String cuc()
  {
    AppMethodBeat.i(293586);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZc, "0");
    AppMethodBeat.o(293586);
    return str;
  }
  
  public static a drL()
  {
    AppMethodBeat.i(63868);
    try
    {
      if (wZx == null) {
        wZx = new a();
      }
      a locala = wZx;
      AppMethodBeat.o(63868);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(63868);
    }
  }
  
  private void drM()
  {
    AppMethodBeat.i(63872);
    if (drN())
    {
      wZn = true;
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
      AppMethodBeat.o(63872);
      return;
    }
    wZn = false;
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
    AppMethodBeat.o(63872);
  }
  
  private boolean drN()
  {
    AppMethodBeat.i(63873);
    y.bDX(smX);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " checkResEnviroment() being ");
    this.wZy.alive();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(60);
    String str1 = cuc();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resId is %s", new Object[] { str1 });
    String str2 = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(str1, "");
    Object localObject1;
    Object localObject2;
    int i;
    if ((!Util.isNullOrNil(str2)) && (y.ZC(str2))) {
      if (Util.isEqual(str1, "0"))
      {
        localObject1 = abn("0-1");
        localObject2 = abo("0-1");
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resMd5:%s", new Object[] { Util.nullAs((String)localObject1, "null") });
        if (!Util.isNullOrNil((String)localObject1)) {
          break label204;
        }
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 is null :%s , resID:%s,version:%s", new Object[] { localObject1, str1, localObject2 });
        this.wZv = str1;
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label463;
      }
      AppMethodBeat.o(63873);
      return false;
      localObject1 = abn(str1);
      localObject2 = abo(str1);
      break;
      label204:
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resPath: %s md5:%s", new Object[] { str2, y.bub(str2) });
      if (((String)localObject1).equalsIgnoreCase(y.bub(str2)))
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 check success,resID:%s,version:%s", new Object[] { str1, localObject2 });
        this.wZv = str1;
        i = 1;
      }
      else
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " resMd5 check failed");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 31L, 1L, false);
        y.deleteFile(str2);
        if (Util.isEqual(str1, "0")) {
          gq("0-1", "");
        }
        for (;;)
        {
          if (!drP()) {
            break label357;
          }
          this.wZv = "woman_putonghua";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
          i = 1;
          break;
          gq(str1, "");
        }
        label357:
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
        this.wZv = "";
        i = 0;
        continue;
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "dont have this resID resource,resPath:%s %s", new Object[] { Util.nullAs(str2, "null"), Boolean.valueOf(y.ZC(str2)) });
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "try to get default res");
        if (drP())
        {
          this.wZv = "woman_putonghua";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has Default Res");
          i = 1;
        }
        else
        {
          this.wZv = "";
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " do not have Default Res");
          i = 0;
        }
      }
    }
    label463:
    if (this.wZs != null) {}
    for (;;)
    {
      try
      {
        this.wZs.wZP.destroy();
        this.wZs = d.a.wZQ;
        localObject1 = this.wZs;
        localObject2 = this.wZu;
        ((d)localObject1).wZP.wZH = ((c)localObject2);
        localObject1 = this.wZs;
        localObject2 = smX;
        str1 = this.wZv;
        i = ((d)localObject1).wZP.gr((String)localObject2, str1);
        if (i >= 0) {
          break;
        }
        Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret%s res:%s", new Object[] { Integer.valueOf(i), this.wZv });
        if (Util.isEqual(i, -201))
        {
          if (!Util.isEqual(this.wZv, "woman_putonghua"))
          {
            Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", new Object[] { this.wZv });
            abl("0");
            drM();
          }
          if (i != -101) {
            break label806;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 1L, 1L, false);
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
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s", new Object[] { wZq });
      } else if ((i <= -2) && (i >= -9)) {
        if (Util.isEqual(this.wZv, "woman_putonghua"))
        {
          drO();
          if (this.wZw < 5)
          {
            this.wZw += 1;
            if (drQ()) {
              drM();
            }
          }
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ret:%s delete %s : %s", new Object[] { Integer.valueOf(i), wZr, Integer.valueOf(this.wZw) });
          continue;
          label806:
          if (i == -102) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 2L, 1L, false);
          } else if (i == -103) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 3L, 1L, false);
          } else if (i == -104) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 4L, 1L, false);
          } else if (i == -201) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 5L, 1L, false);
          } else if (i == -202) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 6L, 1L, false);
          } else if (i == -203) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 7L, 1L, false);
          } else if (i == -204) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 8L, 1L, false);
          } else if (i == -205) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 9L, 1L, false);
          } else if (i == -206) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 10L, 1L, false);
          } else if (i == -207) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 11L, 1L, false);
          } else if ((i <= -2) && (i >= -9)) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 12L, 1L, false);
          } else {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 13L, 1L, false);
          }
        }
      }
    }
    this.wZw = 0;
    d locald = this.wZs;
    float f = wZp;
    locald.wZP.mVolume = f;
    locald = this.wZs;
    f = wZo;
    locald.wZP.dU = f;
    AppMethodBeat.o(63873);
    return true;
  }
  
  private static void drO()
  {
    AppMethodBeat.i(63874);
    y.deleteFile(wZr);
    gq("0", "");
    AppMethodBeat.o(63874);
  }
  
  private boolean drP()
  {
    AppMethodBeat.i(63875);
    if (y.ZC(wZr))
    {
      boolean bool = drR();
      AppMethodBeat.o(63875);
      return bool;
    }
    if (drQ())
    {
      AppMethodBeat.o(63875);
      return true;
    }
    AppMethodBeat.o(63875);
    return false;
  }
  
  private boolean drQ()
  {
    AppMethodBeat.i(63876);
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    String str = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(60, 3);
    boolean bool = y.ZC(str);
    Log.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", new Object[] { str });
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResFromCache() %s no exist, cacheExist: %s", new Object[] { wZr, Boolean.valueOf(bool) });
    if (bool)
    {
      long l = y.O(str, wZr, false);
      gq("0", "");
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", new Object[] { Long.valueOf(l) });
      if (!Util.isEqual(l, -1L))
      {
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
        str = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJg();
        gq("0", str);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", new Object[] { str });
        bool = amh(str);
        AppMethodBeat.o(63876);
        return bool;
      }
    }
    AppMethodBeat.o(63876);
    return false;
  }
  
  private boolean drR()
  {
    AppMethodBeat.i(63878);
    boolean bool = amh(abn("0"));
    AppMethodBeat.o(63878);
    return bool;
  }
  
  public static void gq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63882);
    MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_md5", Util.nullAs(paramString2, "")).commit();
    AppMethodBeat.o(63882);
  }
  
  public static int q(final String paramString1, String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(293594);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    final String str = smX + paramString4 + ".pos";
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
        AppMethodBeat.i(293561);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download end , cost：%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - this.pcy) });
        if ((paramAnonymousC2CDownloadResult != null) && (paramAnonymousC2CDownloadResult.cronetTaskResult != null) && (paramAnonymousC2CDownloadResult.cronetTaskResult.performance != null)) {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download end, url:%s, statusCode:%d, profile:%s", new Object[] { str, Integer.valueOf(paramAnonymousC2CDownloadResult.cronetTaskResult.statusCode), paramAnonymousC2CDownloadResult.cronetTaskResult.performance });
        }
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download result.errorCode ：%s， tempFilePath ：%s , md5：%s , file downaload md5:%s ", new Object[] { Integer.valueOf(paramAnonymousC2CDownloadResult.errorCode), paramString4, paramString1, y.bub(paramString4) });
        if (paramAnonymousC2CDownloadResult.errorCode != 0)
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download failed:%s", new Object[] { Integer.valueOf(paramAnonymousC2CDownloadResult.errorCode) });
          AppMethodBeat.o(293561);
          return;
        }
        if (!y.ZC(paramString4))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "  download File fail:%s", new Object[] { paramString4 });
          AppMethodBeat.o(293561);
          return;
        }
        if (!paramString1.equalsIgnoreCase(y.bub(paramString4)))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "download md5 check failed，md5 :%s    ,  download md5:%s", new Object[] { paramString1, y.bub(paramString4) });
          AppMethodBeat.o(293561);
          return;
        }
        y.bDX(a.smX);
        paramAnonymousString = a.smX + paramString3 + ".pos";
        if (y.ZC(paramAnonymousString))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has this voice resource before ，first delete exist file");
          y.deleteFile(paramAnonymousString);
        }
        y.O(paramString4, paramAnonymousString, false);
        y.deleteFile(paramString4);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile form %s  to   %s", new Object[] { paramString4, paramAnonymousString });
        com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d.cud().j(paramString3, paramAnonymousString, paramString1, this.wZE);
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "save config  posID： %s，voicePath：%s ， md5 ：%s , version:%s", new Object[] { paramString3, paramAnonymousString, paramString1, this.wZE });
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "currentResID %s、download ResID %s", new Object[] { a.cuc(), paramString3 });
        if (a.cuc().equals(paramString3))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "set currentResID  for new resource");
          a.abl(paramString3);
        }
        AppMethodBeat.o(293561);
      }
      
      public final void onDownloadProgressChanged(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(293594);
    return i;
  }
  
  public final void a(cv paramcv)
  {
    AppMethodBeat.i(63879);
    paramcv = new a.a(this, paramcv);
    this.wZu.a(paramcv);
    this.wZs.ami(paramcv.hCK);
    Log.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", new Object[] { paramcv.hCK });
    AppMethodBeat.o(63879);
  }
  
  public final String drS()
  {
    AppMethodBeat.i(63880);
    if (Util.isEqual(this.wZv, "woman_putonghua")) {}
    for (String str = "0";; str = this.wZv)
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
      if (wZn)
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
        AppMethodBeat.o(63871);
        return;
      }
      com.tencent.mm.plugin.collect.app.a.dru();
      com.tencent.mm.plugin.collect.app.a.drw();
      this.wZz.alive();
      if (!drN())
      {
        Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
        wZn = false;
        AppMethodBeat.o(63871);
        return;
      }
      Log.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
      wZn = true;
    }
  }
  
  public final void nu(boolean paramBoolean)
  {
    AppMethodBeat.i(63870);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " begin initTTS()，delay：%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      com.tencent.threadpool.h.ahAA.a(new Runnable()
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
    com.tencent.threadpool.h.ahAA.g(new Runnable()
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
    if (this.wZA)
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()：is already init()");
      AppMethodBeat.o(63869);
      return;
    }
    com.tencent.mm.plugin.collect.app.a.dru();
    com.tencent.mm.plugin.collect.app.a.drw();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
    nu(true);
    this.wZA = true;
    com.tencent.mm.kernel.h.baE().ban().remove(this);
    AppMethodBeat.o(63869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a
 * JD-Core Version:    0.7.0.1
 */