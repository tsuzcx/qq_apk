package com.tencent.mm.plugin.game.c;

import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.b.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadManager;", "", "()V", "TAG", "", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "cancelDownloadTask", "", "packageName", "checkResourceDownload", "appInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppInfo;", "downloadStage", "", "response", "Lcom/tencent/mm/plugin/game/autogen/download/GetGameResourceDownloadInfoResponse;", "getValidDir", "dirName", "isDownloadTaskExist", "", "downloadPath", "otherPathList", "", "loopDownload", "performNextDownload", "resetCheckTimer", "tryDownload", "appId", "ControlFlagEnum", "DownloadStageEnum", "plugin-game_release"})
public final class b
{
  private static MTimerHandler mEP;
  public static final b xvL;
  
  static
  {
    AppMethodBeat.i(204344);
    xvL = new b();
    mEP = new MTimerHandler("GameResourceDownloadManager", (MTimerHandler.CallBack)a.xvM, true);
    AppMethodBeat.o(204344);
  }
  
  private final void a(com.tencent.mm.pluginsdk.model.app.g paramg, int paramInt, com.tencent.mm.plugin.game.b.a.f paramf)
  {
    Object localObject1;
    int i;
    label117:
    Object localObject2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(204339);
        if (paramf == null) {
          break;
        }
        Log.i("MicroMsg.GameResourceDownloadManager", "response, PackageName:" + paramf.xuk + ", ControlFlag:" + paramf.xuw + ", IntervalSeconds:" + paramf.xux + ", expiredTime:" + paramf.xuy + ", downloadStage:" + paramInt);
        localObject1 = (CharSequence)paramf.xuk;
        if (localObject1 == null) {
          break label1017;
        }
        if (((CharSequence)localObject1).length() == 0)
        {
          break label1017;
          if (i != 0) {
            AppMethodBeat.o(204339);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        switch (paramf.xuw)
        {
        case 1: 
          AppMethodBeat.o(204339);
          break;
        case 0: 
          label156:
          localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
        }
      }
      finally {}
      p.g(localObject1, "MMKernel.service(IGameStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.game.api.f)localObject1).dSP();
      localObject2 = paramf.xuk;
      p.g(localObject2, "PackageName");
      label541:
      if (((d)localObject1).azw((String)localObject2) != null)
      {
        paramg = (Collection)paramf.xuv;
        if (paramg == null) {
          break label1026;
        }
        if (!paramg.isEmpty()) {
          break label1032;
        }
        break label1026;
        label242:
        if ((i != 0) && (paramInt != 2))
        {
          Log.i("MicroMsg.GameResourceDownloadManager", "packageInfoList is empty");
          paramg = paramf.xuk;
          p.g(paramg, "PackageName");
          cancelDownloadTask(paramg);
          AppMethodBeat.o(204339);
        }
        else
        {
          paramg = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
          p.g(paramg, "MMKernel.service(IGameStorage::class.java)");
          paramg = ((com.tencent.mm.plugin.game.api.f)paramg).dSP();
          localObject1 = paramf.xuk;
          p.g(localObject1, "PackageName");
          paramInt = paramf.xux;
          long l = Util.nowSecond();
          i = paramf.xuy;
          p.h(localObject1, "packageName");
          Log.i("MicroMsg.GameResourceDownloadStorage", "updateItemTime, packageName:".concat(String.valueOf(localObject1)));
          paramf = paramg.azw((String)localObject1);
          if (paramf != null)
          {
            paramf.field_checkCgiTime = l;
            paramf.field_intervalSeconds = paramInt;
            paramf.field_expiredSeconds = i;
            paramg.update((IAutoDBItem)paramf, new String[0]);
          }
          dTh();
          AppMethodBeat.o(204339);
        }
      }
      else
      {
        localObject1 = (CharSequence)paramf.xut;
        if (localObject1 == null) {
          break label1038;
        }
        if (((CharSequence)localObject1).length() != 0) {
          break label1043;
        }
        break label1038;
        label434:
        if (paramInt != 0)
        {
          Log.i("MicroMsg.GameResourceDownloadManager", "response path is null");
          AppMethodBeat.o(204339);
        }
        else
        {
          localObject1 = paramf.xut;
          p.g(localObject1, "this.Path");
          localObject2 = azt((String)localObject1);
          localObject1 = paramf.xuu;
          p.g(localObject1, "this.OtherPathList");
          if (w((String)localObject2, (List)localObject1))
          {
            AppMethodBeat.o(204339);
          }
          else
          {
            localObject1 = new com.tencent.mm.plugin.game.b.a.d();
            paramInt = 1;
            Object localObject3 = paramf.xuv;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              if (((Iterator)localObject3).hasNext())
              {
                com.tencent.mm.plugin.game.b.a.g localg = (com.tencent.mm.plugin.game.b.a.g)((Iterator)localObject3).next();
                Log.i("MicroMsg.GameResourceDownloadManager", "checkResourceDownload url:" + localg.Url + ", type:" + localg.oUv);
                Object localObject4 = (CharSequence)localg.Url;
                if (localObject4 == null) {
                  break label1048;
                }
                if (((CharSequence)localObject4).length() != 0) {
                  break label1057;
                }
                break label1048;
                label631:
                if (i != 0) {
                  break label1014;
                }
                if (!j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) }).contains(Integer.valueOf(localg.oUv))) {
                  break label1014;
                }
                localObject4 = MMApplicationContext.getResources().getString(2131761335, new Object[] { paramg.field_appName, Integer.valueOf(paramInt) });
                p.g(localObject4, "MMApplicationContext.get…nfo.field_appName, index)");
                String str1 = paramg.field_appId + "_gameres_" + paramInt;
                String str2 = (String)localObject2 + localg.xuz;
                com.tencent.mm.plugin.game.b.a.c localc = new com.tencent.mm.plugin.game.b.a.c();
                localc.xuc = localg.Url;
                localc.xui = localg.xui;
                localc.xuj = ((String)localObject4);
                localc.Md5 = localg.Md5;
                localc.jfi = str1;
                localc.xuk = paramf.xuk;
                localc.xul = str2;
                ((com.tencent.mm.plugin.game.b.a.d)localObject1).xum.add(localc);
                paramInt += 1;
                break label1054;
              }
            }
            localObject2 = (Collection)((com.tencent.mm.plugin.game.b.a.d)localObject1).xum;
            if (localObject2 == null) {
              break label1063;
            }
            if (!((Collection)localObject2).isEmpty()) {
              break label1068;
            }
            break label1063;
          }
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        Log.i("MicroMsg.GameResourceDownloadManager", "checkResourceDownload, DownloadItemList is empty");
        AppMethodBeat.o(204339);
        break label117;
      }
      localObject2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
      p.g(localObject2, "MMKernel.service(IGameStorage::class.java)");
      ((com.tencent.mm.plugin.game.api.f)localObject2).dSP();
      localObject2 = paramf.xuk;
      p.g(localObject2, "PackageName");
      paramg = paramg.field_appId;
      p.g(paramg, "appInfo.field_appId");
      d.a((String)localObject2, paramg, paramf.xux, paramf.xuy, (com.tencent.mm.plugin.game.b.a.d)localObject1);
      paramg = paramf.xuk;
      p.g(paramg, "PackageName");
      azs(paramg);
      AppMethodBeat.o(204339);
      break label117;
      paramg = paramf.xuk;
      p.g(paramg, "PackageName");
      cancelDownloadTask(paramg);
      break label156;
      AppMethodBeat.o(204339);
      break label117;
      label1014:
      break label1054;
      label1017:
      i = 1;
      break;
      break label156;
      label1026:
      i = 1;
      break label242;
      label1032:
      i = 0;
      break label242;
      label1038:
      paramInt = 1;
      break label434;
      label1043:
      paramInt = 0;
      break label434;
      label1048:
      i = 1;
      break label631;
      label1054:
      break label541;
      label1057:
      i = 0;
      break label631;
      label1063:
      paramInt = 1;
      continue;
      label1068:
      paramInt = 0;
    }
  }
  
  public static void azr(String paramString)
  {
    AppMethodBeat.i(204338);
    p.h(paramString, "appId");
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.GameResourceDownloadManager", "appId is null");
      AppMethodBeat.o(204338);
      return;
    }
    Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, appId:".concat(String.valueOf(paramString)));
    com.tencent.f.h.RTc.b((Runnable)new c(paramString), "GameResourceDownloadRequest_tryDownload");
    AppMethodBeat.o(204338);
  }
  
  public static void azs(String paramString)
  {
    AppMethodBeat.i(204340);
    p.h(paramString, "packageName");
    Object localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
    p.g(localObject1, "MMKernel.service(IGameStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.game.api.f)localObject1).dSP().azw(paramString);
    if (paramString != null)
    {
      localObject1 = new com.tencent.mm.plugin.game.b.a.d();
      try
      {
        ((com.tencent.mm.plugin.game.b.a.d)localObject1).parseFrom(paramString.field_downloadItemList);
        Object localObject2 = ((com.tencent.mm.plugin.game.b.a.d)localObject1).xum;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          long l;
          do
          {
            com.tencent.mm.plugin.game.b.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.plugin.game.b.a.c)((Iterator)localObject2).next();
            } while (localc.xuh);
            Object localObject3 = new g.a();
            ((g.a)localObject3).alj(localc.xuc);
            ((g.a)localObject3).setFileSize(localc.xui);
            ((g.a)localObject3).alo(localc.xuj);
            ((g.a)localObject3).setFileMD5(localc.Md5);
            ((g.a)localObject3).setAppId(localc.jfi);
            ((g.a)localObject3).gm(localc.xuk);
            ((g.a)localObject3).kS(false);
            ((g.a)localObject3).Fl(3);
            ((g.a)localObject3).kV(true);
            ((g.a)localObject3).cBF();
            ((g.a)localObject3).aln(localc.xul);
            localObject3 = ((g.a)localObject3).cBG();
            com.tencent.mm.plugin.downloader.model.d.alc(localc.xuc);
            l = com.tencent.mm.plugin.downloader.model.f.cBv().b((com.tencent.mm.plugin.downloader.model.g)localObject3);
            Log.i("MicroMsg.GameResourceDownloadManager", "add download task[packageName:" + localc.xuk + ", downloadUrl:" + localc.xuc + ", downloadPath:" + localc.xul + "], size:" + localc.xui + ", md5:" + localc.Md5 + ", downloadId:" + l);
            localc.xug = l;
            localc.xuh = true;
          } while (l <= 0L);
        }
        paramString.field_downloadItemList = ((com.tencent.mm.plugin.game.b.a.d)localObject1).toByteArray();
        localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
        p.g(localObject1, "MMKernel.service(IGameStorage::class.java)");
        Log.i("MicroMsg.GameResourceDownloadManager", "performNextDownload, updateRet:".concat(String.valueOf(((com.tencent.mm.plugin.game.api.f)localObject1).dSP().update((IAutoDBItem)paramString, new String[0]))));
        AppMethodBeat.o(204340);
        return;
      }
      catch (Exception paramString)
      {
        Log.i("MicroMsg.GameResourceDownloadManager", "performNextDownload, catch err:" + paramString.getMessage());
        AppMethodBeat.o(204340);
        return;
      }
    }
    AppMethodBeat.o(204340);
  }
  
  private static String azt(String paramString)
  {
    AppMethodBeat.i(204341);
    paramString = com.tencent.mm.loader.j.b.aKE() + "/" + paramString + "/";
    AppMethodBeat.o(204341);
    return paramString;
  }
  
  private static void cancelDownloadTask(String paramString)
  {
    AppMethodBeat.i(204342);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204342);
      return;
    }
    localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
    p.g(localObject1, "MMKernel.service(IGameStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.game.api.f)localObject1).dSP().azw(paramString);
    if (localObject1 != null)
    {
      localObject3 = new com.tencent.mm.plugin.game.b.a.d();
      try
      {
        ((com.tencent.mm.plugin.game.b.a.d)localObject3).parseFrom(((a)localObject1).field_downloadItemList);
        localObject1 = ((com.tencent.mm.plugin.game.b.a.d)localObject3).xum;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (com.tencent.mm.plugin.game.b.a.c)((Iterator)localObject1).next();
            i = com.tencent.mm.plugin.downloader.model.f.cBv().Cn(((com.tencent.mm.plugin.game.b.a.c)localObject3).xug);
            Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, downloadId:" + ((com.tencent.mm.plugin.game.b.a.c)localObject3).xug + " ret:" + i);
          }
        }
        localObject2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, catch err:" + localException.getMessage());
      }
    }
    p.g(localObject2, "MMKernel.service(IGameStorage::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.game.api.f)localObject2).dSP();
    p.h(paramString, "packageName");
    Object localObject3 = "delete from GameResourceDownload where packageName=\"" + paramString + '"';
    boolean bool = ((d)localObject2).execSQL("GameResourceDownload", (String)localObject3);
    Log.i("MicroMsg.GameResourceDownloadStorage", "delDownloadInfo, sql:" + (String)localObject3 + ", ret:" + bool);
    dTh();
    Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, packageName:" + paramString + ", delDownloadInfo: " + bool);
    AppMethodBeat.o(204342);
  }
  
  public static void dTh()
  {
    AppMethodBeat.i(204337);
    com.tencent.f.h.RTc.b((Runnable)b.xvN, "GameResourceDownloadRequest_resetCheckTimer");
    AppMethodBeat.o(204337);
  }
  
  private static boolean w(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(204343);
    Object localObject = s.dC(paramString, false);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        Log.i("MicroMsg.GameResourceDownloadManager", "download task exists in path:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(204343);
        return true;
      }
    }
    if (paramList != null)
    {
      paramString = ((Iterable)paramList).iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localObject = s.dC(azt(paramList), false);
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ((Iterator)localObject).next();
            Log.i("MicroMsg.GameResourceDownloadManager", "download task exists in path:".concat(String.valueOf(paramList)));
            AppMethodBeat.o(204343);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(204343);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    public static final a xvM;
    
    static
    {
      AppMethodBeat.i(204331);
      xvM = new a();
      AppMethodBeat.o(204331);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(204330);
      b localb = b.xvL;
      b.dTj();
      AppMethodBeat.o(204330);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b xvN;
    
    static
    {
      AppMethodBeat.i(204333);
      xvN = new b();
      AppMethodBeat.o(204333);
    }
    
    public final void run()
    {
      Object localObject1 = null;
      AppMethodBeat.i(204332);
      Object localObject2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
      p.g(localObject2, "MMKernel.service(IGameStorage::class.java)");
      localObject2 = ((com.tencent.mm.plugin.game.api.f)localObject2).dSP();
      String str = "select intervalSeconds - abs(" + Util.nowSecond() + " - checkCgiTime) as diffTime from GameResourceDownload order by diffTime asc";
      Log.i("MicroMsg.GameResourceDownloadStorage", "getMinCheckInterval, sql: ".concat(String.valueOf(str)));
      localObject2 = ((d)localObject2).rawQuery(str, new String[0]);
      long l;
      if (localObject2 == null)
      {
        if (localObject1 != null)
        {
          l = ((Number)localObject1).longValue();
          Log.i("MicroMsg.GameResourceDownloadManager", "resetCheckTimer, interval:".concat(String.valueOf(l)));
          localObject2 = b.xvL;
          b.dTi().stopTimer();
          if (l > 0L) {
            break label198;
          }
          localObject2 = b.xvL;
          b.dTj();
          label142:
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = b.xvL;
          b.dTi().stopTimer();
          localObject1 = x.SXb;
        }
        AppMethodBeat.o(204332);
      }
      else
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label217;
        }
      }
      label198:
      label217:
      for (localObject1 = Long.valueOf(((Cursor)localObject2).getLong(0));; localObject1 = null)
      {
        ((Cursor)localObject2).close();
        break;
        localObject2 = b.xvL;
        b.dTi().startTimer(l * 1000L);
        break label142;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(204336);
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.cX(this.kPQ, false);
      if (localObject1 != null)
      {
        Object localObject2 = (CharSequence)((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(204336);
          return;
        }
        Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, packageName:" + ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName);
        localObject2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
        p.g(localObject2, "MMKernel.service(IGameStorage::class.java)");
        localObject2 = ((com.tencent.mm.plugin.game.api.f)localObject2).dSP();
        Object localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName;
        p.g(localObject3, "field_packageName");
        p.h(localObject3, "packageName");
        Log.i("MicroMsg.GameResourceDownloadStorage", "allowCleanPkg(" + (String)localObject3 + ')');
        localObject2 = ((d)localObject2).azw((String)localObject3);
        if ((localObject2 != null) && (Math.abs(Util.nowSecond() - ((a)localObject2).field_finishDownloadTime) > ((a)localObject2).field_expiredSeconds)) {}
        for (i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, allowCleanPkg:true");
          localObject2 = b.xvL;
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName;
          p.g(localObject1, "field_packageName");
          b.azu((String)localObject1);
          AppMethodBeat.o(204336);
          return;
        }
        localObject2 = new z.f();
        ((z.f)localObject2).SYG = new e();
        ((e)((z.f)localObject2).SYG).oTJ = Build.MODEL;
        ((e)((z.f)localObject2).SYG).oUj = Build.MANUFACTURER;
        ((e)((z.f)localObject2).SYG).xun = "";
        ((e)((z.f)localObject2).SYG).xuo = com.tencent.mm.compatible.deviceinfo.q.aoK();
        ((e)((z.f)localObject2).SYG).xup = com.tencent.mm.compatible.deviceinfo.q.dr(false);
        ((e)((z.f)localObject2).SYG).xuk = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName;
        ((e)((z.f)localObject2).SYG).jfi = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId;
        ((e)((z.f)localObject2).SYG).xuq = String.valueOf(com.tencent.mm.plugin.game.e.c.aAH(((e)((z.f)localObject2).SYG).xuk));
        ((e)((z.f)localObject2).SYG).xur = com.tencent.mm.plugin.game.e.c.aAI(((e)((z.f)localObject2).SYG).xuk);
        localObject3 = (e)((z.f)localObject2).SYG;
        Object localObject4 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
        p.g(localObject4, "MMKernel.service(IGameStorage::class.java)");
        localObject4 = ((com.tencent.mm.plugin.game.api.f)localObject4).dSP();
        String str = ((e)((z.f)localObject2).SYG).xuk;
        p.g(str, "request.PackageName");
        ((e)localObject3).xus = ((d)localObject4).azx(str);
        Log.i("MicroMsg.GameResourceDownloadManager", "download stage:" + ((e)((z.f)localObject2).SYG).xus);
        localObject3 = new d.a();
        ((d.a)localObject3).MB("/cgi-bin/mmgame-bin/getgameresourcedownloadinfo");
        ((d.a)localObject3).sG(4218);
        ((d.a)localObject3).sI(0);
        ((d.a)localObject3).sJ(0);
        ((d.a)localObject3).c((com.tencent.mm.bw.a)((z.f)localObject2).SYG);
        ((d.a)localObject3).d((com.tencent.mm.bw.a)new com.tencent.mm.plugin.game.b.a.f());
        aa.a(((d.a)localObject3).aXF(), (aa.a)new a((com.tencent.mm.pluginsdk.model.app.g)localObject1, (z.f)localObject2));
        AppMethodBeat.o(204336);
        return;
      }
      AppMethodBeat.o(204336);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a
      implements aa.a
    {
      a(com.tencent.mm.pluginsdk.model.app.g paramg, z.f paramf) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.d paramd, com.tencent.mm.ak.q paramq)
      {
        AppMethodBeat.i(204335);
        Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          com.tencent.f.h.RTc.b((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(204334);
              Object localObject1 = b.xvL;
              com.tencent.mm.pluginsdk.model.app.g localg = this.xvQ.xvO;
              int i = ((e)this.xvQ.xvP.SYG).xus;
              Object localObject2 = paramd;
              p.g(localObject2, "rr");
              localObject2 = ((com.tencent.mm.ak.d)localObject2).aYK();
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.download.GetGameResourceDownloadInfoResponse");
                AppMethodBeat.o(204334);
                throw ((Throwable)localObject1);
              }
              b.a((b)localObject1, localg, i, (com.tencent.mm.plugin.game.b.a.f)localObject2);
              AppMethodBeat.o(204334);
            }
          }, "GameResourceDownloadRequest_callback");
        }
        AppMethodBeat.o(204335);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.b
 * JD-Core Version:    0.7.0.1
 */