package com.tencent.mm.plugin.game.b;

import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.autogen.a.e;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadManager;", "", "()V", "TAG", "", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "cancelDownloadTask", "", "packageName", "checkResourceDownload", "appInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppInfo;", "downloadStage", "", "response", "Lcom/tencent/mm/plugin/game/autogen/download/GetGameResourceDownloadInfoResponse;", "getValidDir", "dirName", "isDownloadTaskExist", "", "downloadPath", "otherPathList", "", "loopDownload", "performNextDownload", "resetCheckTimer", "tryDownload", "appId", "ControlFlagEnum", "DownloadStageEnum", "plugin-game_release"})
public final class b
{
  public static final b CzF;
  private static MTimerHandler pEb;
  
  static
  {
    AppMethodBeat.i(195857);
    CzF = new b();
    pEb = new MTimerHandler("GameResourceDownloadManager", (MTimerHandler.CallBack)a.CzG, true);
    AppMethodBeat.o(195857);
  }
  
  private final void a(com.tencent.mm.pluginsdk.model.app.g paramg, int paramInt, com.tencent.mm.plugin.game.autogen.a.f paramf)
  {
    Object localObject1;
    int i;
    label117:
    Object localObject2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(195834);
        if (paramf == null) {
          break;
        }
        Log.i("MicroMsg.GameResourceDownloadManager", "response, PackageName:" + paramf.CqB + ", ControlFlag:" + paramf.CqN + ", IntervalSeconds:" + paramf.CqO + ", expiredTime:" + paramf.CqP + ", downloadStage:" + paramInt);
        localObject1 = (CharSequence)paramf.CqB;
        if (localObject1 == null) {
          break label1017;
        }
        if (((CharSequence)localObject1).length() == 0)
        {
          break label1017;
          if (i != 0) {
            AppMethodBeat.o(195834);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        switch (paramf.CqN)
        {
        case 1: 
          AppMethodBeat.o(195834);
          break;
        case 0: 
          label156:
          localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
        }
      }
      finally {}
      p.j(localObject1, "MMKernel.service(IGameStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.game.api.f)localObject1).evt();
      localObject2 = paramf.CqB;
      p.j(localObject2, "PackageName");
      label541:
      if (((d)localObject1).aJg((String)localObject2) != null)
      {
        paramg = (Collection)paramf.CqM;
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
          paramg = paramf.CqB;
          p.j(paramg, "PackageName");
          cancelDownloadTask(paramg);
          AppMethodBeat.o(195834);
        }
        else
        {
          paramg = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
          p.j(paramg, "MMKernel.service(IGameStorage::class.java)");
          paramg = ((com.tencent.mm.plugin.game.api.f)paramg).evt();
          localObject1 = paramf.CqB;
          p.j(localObject1, "PackageName");
          paramInt = paramf.CqO;
          long l = Util.nowSecond();
          i = paramf.CqP;
          p.k(localObject1, "packageName");
          Log.i("MicroMsg.GameResourceDownloadStorage", "updateItemTime, packageName:".concat(String.valueOf(localObject1)));
          paramf = paramg.aJg((String)localObject1);
          if (paramf != null)
          {
            paramf.field_checkCgiTime = l;
            paramf.field_intervalSeconds = paramInt;
            paramf.field_expiredSeconds = i;
            paramg.update((IAutoDBItem)paramf, new String[0]);
          }
          ewq();
          AppMethodBeat.o(195834);
        }
      }
      else
      {
        localObject1 = (CharSequence)paramf.CqK;
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
          AppMethodBeat.o(195834);
        }
        else
        {
          localObject1 = paramf.CqK;
          p.j(localObject1, "this.Path");
          localObject2 = aJd((String)localObject1);
          localObject1 = paramf.CqL;
          p.j(localObject1, "this.OtherPathList");
          if (y((String)localObject2, (List)localObject1))
          {
            AppMethodBeat.o(195834);
          }
          else
          {
            localObject1 = new com.tencent.mm.plugin.game.autogen.a.d();
            paramInt = 1;
            Object localObject3 = paramf.CqM;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              if (((Iterator)localObject3).hasNext())
              {
                com.tencent.mm.plugin.game.autogen.a.g localg = (com.tencent.mm.plugin.game.autogen.a.g)((Iterator)localObject3).next();
                Log.i("MicroMsg.GameResourceDownloadManager", "checkResourceDownload url:" + localg.Url + ", type:" + localg.rWu);
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
                if (!j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) }).contains(Integer.valueOf(localg.rWu))) {
                  break label1014;
                }
                localObject4 = MMApplicationContext.getResources().getString(g.i.CpG, new Object[] { paramg.field_appName, Integer.valueOf(paramInt) });
                p.j(localObject4, "MMApplicationContext.get…nfo.field_appName, index)");
                String str1 = paramg.field_appId + "_gameres_" + paramInt;
                String str2 = (String)localObject2 + localg.CqQ;
                com.tencent.mm.plugin.game.autogen.a.c localc = new com.tencent.mm.plugin.game.autogen.a.c();
                localc.Cqt = localg.Url;
                localc.Cqz = localg.Cqz;
                localc.CqA = ((String)localObject4);
                localc.Md5 = localg.Md5;
                localc.lVG = str1;
                localc.CqB = paramf.CqB;
                localc.CqC = str2;
                ((com.tencent.mm.plugin.game.autogen.a.d)localObject1).CqD.add(localc);
                paramInt += 1;
                break label1054;
              }
            }
            localObject2 = (Collection)((com.tencent.mm.plugin.game.autogen.a.d)localObject1).CqD;
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
        AppMethodBeat.o(195834);
        break label117;
      }
      localObject2 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
      p.j(localObject2, "MMKernel.service(IGameStorage::class.java)");
      ((com.tencent.mm.plugin.game.api.f)localObject2).evt();
      localObject2 = paramf.CqB;
      p.j(localObject2, "PackageName");
      paramg = paramg.field_appId;
      p.j(paramg, "appInfo.field_appId");
      d.a((String)localObject2, paramg, paramf.CqO, paramf.CqP, (com.tencent.mm.plugin.game.autogen.a.d)localObject1);
      paramg = paramf.CqB;
      p.j(paramg, "PackageName");
      aJc(paramg);
      AppMethodBeat.o(195834);
      break label117;
      paramg = paramf.CqB;
      p.j(paramg, "PackageName");
      cancelDownloadTask(paramg);
      break label156;
      AppMethodBeat.o(195834);
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
  
  public static void aJb(String paramString)
  {
    AppMethodBeat.i(195805);
    p.k(paramString, "appId");
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.GameResourceDownloadManager", "appId is null");
      AppMethodBeat.o(195805);
      return;
    }
    Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, appId:".concat(String.valueOf(paramString)));
    com.tencent.e.h.ZvG.d((Runnable)new c(paramString), "GameResourceDownloadRequest_tryDownload");
    AppMethodBeat.o(195805);
  }
  
  public static void aJc(String paramString)
  {
    AppMethodBeat.i(195842);
    p.k(paramString, "packageName");
    Object localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
    p.j(localObject1, "MMKernel.service(IGameStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.game.api.f)localObject1).evt().aJg(paramString);
    if (paramString != null)
    {
      localObject1 = new com.tencent.mm.plugin.game.autogen.a.d();
      try
      {
        ((com.tencent.mm.plugin.game.autogen.a.d)localObject1).parseFrom(paramString.field_downloadItemList);
        Object localObject2 = ((com.tencent.mm.plugin.game.autogen.a.d)localObject1).CqD;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          long l;
          do
          {
            com.tencent.mm.plugin.game.autogen.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.plugin.game.autogen.a.c)((Iterator)localObject2).next();
            } while (localc.Cqy);
            Object localObject3 = new g.a();
            ((g.a)localObject3).atc(localc.Cqt);
            ((g.a)localObject3).setFileSize(localc.Cqz);
            ((g.a)localObject3).ath(localc.CqA);
            ((g.a)localObject3).setFileMD5(localc.Md5);
            ((g.a)localObject3).setAppId(localc.lVG);
            ((g.a)localObject3).setPackageName(localc.CqB);
            ((g.a)localObject3).me(false);
            ((g.a)localObject3).IS(3);
            ((g.a)localObject3).mh(true);
            ((g.a)localObject3).cQj();
            ((g.a)localObject3).atg(localc.CqC);
            localObject3 = ((g.a)localObject3).cQk();
            com.tencent.mm.plugin.downloader.model.d.asV(localc.Cqt);
            l = com.tencent.mm.plugin.downloader.model.f.cPZ().b((com.tencent.mm.plugin.downloader.model.g)localObject3);
            Log.i("MicroMsg.GameResourceDownloadManager", "add download task[packageName:" + localc.CqB + ", downloadUrl:" + localc.Cqt + ", downloadPath:" + localc.CqC + "], size:" + localc.Cqz + ", md5:" + localc.Md5 + ", downloadId:" + l);
            localc.Cqx = l;
            localc.Cqy = true;
          } while (l <= 0L);
        }
        paramString.field_downloadItemList = ((com.tencent.mm.plugin.game.autogen.a.d)localObject1).toByteArray();
        localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
        p.j(localObject1, "MMKernel.service(IGameStorage::class.java)");
        Log.i("MicroMsg.GameResourceDownloadManager", "performNextDownload, updateRet:".concat(String.valueOf(((com.tencent.mm.plugin.game.api.f)localObject1).evt().update((IAutoDBItem)paramString, new String[0]))));
        AppMethodBeat.o(195842);
        return;
      }
      catch (Exception paramString)
      {
        Log.i("MicroMsg.GameResourceDownloadManager", "performNextDownload, catch err:" + paramString.getMessage());
        AppMethodBeat.o(195842);
        return;
      }
    }
    AppMethodBeat.o(195842);
  }
  
  private static String aJd(String paramString)
  {
    AppMethodBeat.i(195844);
    paramString = com.tencent.mm.loader.j.b.aSG() + "/" + paramString + "/";
    AppMethodBeat.o(195844);
    return paramString;
  }
  
  private static void cancelDownloadTask(String paramString)
  {
    AppMethodBeat.i(195851);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(195851);
      return;
    }
    localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
    p.j(localObject1, "MMKernel.service(IGameStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.game.api.f)localObject1).evt().aJg(paramString);
    if (localObject1 != null)
    {
      localObject3 = new com.tencent.mm.plugin.game.autogen.a.d();
      try
      {
        ((com.tencent.mm.plugin.game.autogen.a.d)localObject3).parseFrom(((a)localObject1).field_downloadItemList);
        localObject1 = ((com.tencent.mm.plugin.game.autogen.a.d)localObject3).CqD;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (com.tencent.mm.plugin.game.autogen.a.c)((Iterator)localObject1).next();
            i = com.tencent.mm.plugin.downloader.model.f.cPZ().Iw(((com.tencent.mm.plugin.game.autogen.a.c)localObject3).Cqx);
            Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, downloadId:" + ((com.tencent.mm.plugin.game.autogen.a.c)localObject3).Cqx + " ret:" + i);
          }
        }
        localObject2 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, catch err:" + localException.getMessage());
      }
    }
    p.j(localObject2, "MMKernel.service(IGameStorage::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.game.api.f)localObject2).evt();
    p.k(paramString, "packageName");
    Object localObject3 = "delete from GameResourceDownload where packageName=\"" + paramString + '"';
    boolean bool = ((d)localObject2).execSQL("GameResourceDownload", (String)localObject3);
    Log.i("MicroMsg.GameResourceDownloadStorage", "delDownloadInfo, sql:" + (String)localObject3 + ", ret:" + bool);
    ewq();
    Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, packageName:" + paramString + ", delDownloadInfo: " + bool);
    AppMethodBeat.o(195851);
  }
  
  public static void ewq()
  {
    AppMethodBeat.i(195802);
    com.tencent.e.h.ZvG.d((Runnable)b.CzH, "GameResourceDownloadRequest_resetCheckTimer");
    AppMethodBeat.o(195802);
  }
  
  private static boolean y(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(195855);
    Object localObject = u.dP(paramString, false);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        Log.i("MicroMsg.GameResourceDownloadManager", "download task exists in path:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(195855);
        return true;
      }
    }
    if (paramList != null)
    {
      paramString = ((Iterable)paramList).iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localObject = u.dP(aJd(paramList), false);
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ((Iterator)localObject).next();
            Log.i("MicroMsg.GameResourceDownloadManager", "download task exists in path:".concat(String.valueOf(paramList)));
            AppMethodBeat.o(195855);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(195855);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    public static final a CzG;
    
    static
    {
      AppMethodBeat.i(196485);
      CzG = new a();
      AppMethodBeat.o(196485);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(196484);
      b localb = b.CzF;
      b.ews();
      AppMethodBeat.o(196484);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b CzH;
    
    static
    {
      AppMethodBeat.i(199754);
      CzH = new b();
      AppMethodBeat.o(199754);
    }
    
    public final void run()
    {
      Object localObject1 = null;
      AppMethodBeat.i(199751);
      Object localObject2 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
      p.j(localObject2, "MMKernel.service(IGameStorage::class.java)");
      localObject2 = ((com.tencent.mm.plugin.game.api.f)localObject2).evt();
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
          localObject2 = b.CzF;
          b.ewr().stopTimer();
          if (l > 0L) {
            break label198;
          }
          localObject2 = b.CzF;
          b.ews();
          label142:
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = b.CzF;
          b.ewr().stopTimer();
          localObject1 = x.aazN;
        }
        AppMethodBeat.o(199751);
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
        localObject2 = b.CzF;
        b.ewr().startTimer(l * 1000L);
        break label142;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(194880);
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.dl(this.cBD, false);
      if (localObject1 != null)
      {
        Object localObject2 = (CharSequence)((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(194880);
          return;
        }
        Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, packageName:" + ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName);
        localObject2 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
        p.j(localObject2, "MMKernel.service(IGameStorage::class.java)");
        localObject2 = ((com.tencent.mm.plugin.game.api.f)localObject2).evt();
        Object localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName;
        p.j(localObject3, "field_packageName");
        p.k(localObject3, "packageName");
        Log.i("MicroMsg.GameResourceDownloadStorage", "allowCleanPkg(" + (String)localObject3 + ')');
        localObject2 = ((d)localObject2).aJg((String)localObject3);
        if ((localObject2 != null) && (Math.abs(Util.nowSecond() - ((a)localObject2).field_finishDownloadTime) > ((a)localObject2).field_expiredSeconds)) {}
        for (i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, allowCleanPkg:true");
          localObject2 = b.CzF;
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName;
          p.j(localObject1, "field_packageName");
          b.aJe((String)localObject1);
          AppMethodBeat.o(194880);
          return;
        }
        localObject2 = new aa.f();
        ((aa.f)localObject2).aaBC = new e();
        ((e)((aa.f)localObject2).aaBC).rVH = Build.MODEL;
        ((e)((aa.f)localObject2).aaBC).rWh = Build.MANUFACTURER;
        ((e)((aa.f)localObject2).aaBC).CqE = "";
        ((e)((aa.f)localObject2).aaBC).CqF = com.tencent.mm.compatible.deviceinfo.q.auQ();
        ((e)((aa.f)localObject2).aaBC).CqG = com.tencent.mm.compatible.deviceinfo.q.dR(false);
        ((e)((aa.f)localObject2).aaBC).CqB = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName;
        ((e)((aa.f)localObject2).aaBC).lVG = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId;
        ((e)((aa.f)localObject2).aaBC).CqH = String.valueOf(com.tencent.mm.plugin.game.d.c.aKt(((e)((aa.f)localObject2).aaBC).CqB));
        ((e)((aa.f)localObject2).aaBC).CqI = com.tencent.mm.plugin.game.d.c.aKu(((e)((aa.f)localObject2).aaBC).CqB);
        localObject3 = (e)((aa.f)localObject2).aaBC;
        Object localObject4 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class);
        p.j(localObject4, "MMKernel.service(IGameStorage::class.java)");
        localObject4 = ((com.tencent.mm.plugin.game.api.f)localObject4).evt();
        String str = ((e)((aa.f)localObject2).aaBC).CqB;
        p.j(str, "request.PackageName");
        ((e)localObject3).CqJ = ((d)localObject4).aJh(str);
        Log.i("MicroMsg.GameResourceDownloadManager", "download stage:" + ((e)((aa.f)localObject2).aaBC).CqJ);
        localObject3 = new d.a();
        ((d.a)localObject3).TW("/cgi-bin/mmgame-bin/getgameresourcedownloadinfo");
        ((d.a)localObject3).vD(4218);
        ((d.a)localObject3).vF(0);
        ((d.a)localObject3).vG(0);
        ((d.a)localObject3).c((com.tencent.mm.cd.a)((aa.f)localObject2).aaBC);
        ((d.a)localObject3).d((com.tencent.mm.cd.a)new com.tencent.mm.plugin.game.autogen.a.f());
        aa.a(((d.a)localObject3).bgN(), (aa.a)new a((com.tencent.mm.pluginsdk.model.app.g)localObject1, (aa.f)localObject2));
        AppMethodBeat.o(194880);
        return;
      }
      AppMethodBeat.o(194880);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a
      implements aa.a
    {
      a(com.tencent.mm.pluginsdk.model.app.g paramg, aa.f paramf) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
      {
        AppMethodBeat.i(208080);
        Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          com.tencent.e.h.ZvG.d((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195549);
              Object localObject1 = b.CzF;
              com.tencent.mm.pluginsdk.model.app.g localg = this.CzK.CzI;
              int i = ((e)this.CzK.CzJ.aaBC).CqJ;
              Object localObject2 = paramd;
              p.j(localObject2, "rr");
              localObject2 = ((com.tencent.mm.an.d)localObject2).bhY();
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.download.GetGameResourceDownloadInfoResponse");
                AppMethodBeat.o(195549);
                throw ((Throwable)localObject1);
              }
              b.a((b)localObject1, localg, i, (com.tencent.mm.plugin.game.autogen.a.f)localObject2);
              AppMethodBeat.o(195549);
            }
          }, "GameResourceDownloadRequest_callback");
        }
        AppMethodBeat.o(208080);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b
 * JD-Core Version:    0.7.0.1
 */