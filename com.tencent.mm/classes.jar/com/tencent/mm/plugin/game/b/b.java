package com.tencent.mm.plugin.game.b;

import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.autogen.a.e;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadManager;", "", "()V", "TAG", "", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "cancelDownloadTask", "", "packageName", "checkResourceDownload", "appInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppInfo;", "downloadStage", "", "response", "Lcom/tencent/mm/plugin/game/autogen/download/GetGameResourceDownloadInfoResponse;", "getValidDir", "dirName", "isDownloadTaskExist", "", "downloadPath", "otherPathList", "", "loopDownload", "performNextDownload", "resetCheckTimer", "tryDownload", "appId", "ControlFlagEnum", "DownloadStageEnum", "plugin-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Itw;
  private static MTimerHandler sJn;
  
  static
  {
    AppMethodBeat.i(275384);
    Itw = new b();
    sJn = new MTimerHandler("GameResourceDownloadManager", b..ExternalSyntheticLambda1.INSTANCE, true);
    AppMethodBeat.o(275384);
  }
  
  private static boolean C(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(275348);
    Object localObject = y.eB(paramString, false);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        Log.i("MicroMsg.GameResourceDownloadManager", s.X("download task exists in path:", paramString));
        AppMethodBeat.o(275348);
        return true;
      }
    }
    if (paramList != null)
    {
      paramString = ((Iterable)paramList).iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localObject = y.eB(aFP(paramList), false);
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ((Iterator)localObject).next();
            Log.i("MicroMsg.GameResourceDownloadManager", s.X("download task exists in path:", paramList));
            AppMethodBeat.o(275348);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(275348);
    return false;
  }
  
  private static final int a(com.tencent.mm.pluginsdk.model.app.g paramg, ah.f paramf, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(275370);
    s.u(paramg, "$this_apply");
    s.u(paramf, "$request");
    Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      com.tencent.threadpool.h.ahAA.g(new b..ExternalSyntheticLambda2(paramg, paramf, paramc), "GameResourceDownloadRequest_callback");
    }
    AppMethodBeat.o(275370);
    return 0;
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
        AppMethodBeat.i(275332);
        if (paramf != null)
        {
          Log.i("MicroMsg.GameResourceDownloadManager", "response, PackageName:" + paramf.IcK + ", ControlFlag:" + paramf.IcW + ", IntervalSeconds:" + paramf.IcX + ", expiredTime:" + paramf.IcY + ", downloadStage:" + paramInt);
          localObject1 = (CharSequence)paramf.IcK;
          if (localObject1 == null) {
            break label976;
          }
          if (((CharSequence)localObject1).length() == 0)
          {
            break label976;
            if (i != 0) {
              AppMethodBeat.o(275332);
            }
          }
          else
          {
            i = 0;
            continue;
          }
        }
        switch (paramf.IcW)
        {
        case 1: 
          AppMethodBeat.o(275332);
          break;
        case 0: 
          label156:
          localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm();
        }
      }
      finally {}
      localObject2 = paramf.IcK;
      s.s(localObject2, "PackageName");
      label529:
      if (((d)localObject1).aFS((String)localObject2) != null)
      {
        paramg = (Collection)paramf.IcV;
        if (paramg == null) {
          break label985;
        }
        if (!paramg.isEmpty()) {
          break label991;
        }
        break label985;
        label232:
        if ((i != 0) && (paramInt != 2))
        {
          Log.i("MicroMsg.GameResourceDownloadManager", "packageInfoList is empty");
          paramg = paramf.IcK;
          s.s(paramg, "PackageName");
          cancelDownloadTask(paramg);
          AppMethodBeat.o(275332);
        }
        else
        {
          paramg = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm();
          localObject1 = paramf.IcK;
          s.s(localObject1, "PackageName");
          paramInt = paramf.IcX;
          long l = Util.nowSecond();
          i = paramf.IcY;
          s.u(localObject1, "packageName");
          Log.i("MicroMsg.GameResourceDownloadStorage", s.X("updateItemTime, packageName:", localObject1));
          paramf = paramg.aFS((String)localObject1);
          if (paramf != null)
          {
            paramf.field_checkCgiTime = l;
            paramf.field_intervalSeconds = paramInt;
            paramf.field_expiredSeconds = i;
            paramg.update((IAutoDBItem)paramf, new String[0]);
          }
          fEh();
          AppMethodBeat.o(275332);
        }
      }
      else
      {
        localObject1 = (CharSequence)paramf.IcT;
        if (localObject1 == null) {
          break label997;
        }
        if (((CharSequence)localObject1).length() != 0) {
          break label1002;
        }
        break label997;
        label419:
        if (paramInt != 0)
        {
          Log.i("MicroMsg.GameResourceDownloadManager", "response path is null");
          AppMethodBeat.o(275332);
        }
        else
        {
          localObject1 = paramf.IcT;
          s.s(localObject1, "this.Path");
          localObject2 = aFP((String)localObject1);
          localObject1 = paramf.IcU;
          s.s(localObject1, "this.OtherPathList");
          if (C((String)localObject2, (List)localObject1))
          {
            AppMethodBeat.o(275332);
          }
          else
          {
            localObject1 = new com.tencent.mm.plugin.game.autogen.a.d();
            paramInt = 1;
            Object localObject3 = paramf.IcV;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              if (((Iterator)localObject3).hasNext())
              {
                com.tencent.mm.plugin.game.autogen.a.g localg = (com.tencent.mm.plugin.game.autogen.a.g)((Iterator)localObject3).next();
                Log.i("MicroMsg.GameResourceDownloadManager", "checkResourceDownload url:" + localg.Url + ", type:" + localg.vhJ);
                Object localObject4 = (CharSequence)localg.Url;
                if (localObject4 == null) {
                  break label1007;
                }
                if (((CharSequence)localObject4).length() != 0) {
                  break label1016;
                }
                break label1007;
                label619:
                if (i != 0) {
                  break;
                }
                if (!kotlin.a.p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) }).contains(Integer.valueOf(localg.vhJ))) {
                  break;
                }
                localObject4 = MMApplicationContext.getResources().getString(h.i.IbO, new Object[] { paramg.field_appName, Integer.valueOf(paramInt) });
                s.s(localObject4, "getResources().getString…nfo.field_appName, index)");
                String str1 = paramg.field_appId + "_gameres_" + paramInt;
                String str2 = s.X((String)localObject2, localg.IcZ);
                com.tencent.mm.plugin.game.autogen.a.c localc = new com.tencent.mm.plugin.game.autogen.a.c();
                localc.IcC = localg.Url;
                localc.IcI = localg.IcI;
                localc.IcJ = ((String)localObject4);
                localc.Md5 = localg.Md5;
                localc.oOI = str1;
                localc.IcK = paramf.IcK;
                localc.IcL = str2;
                ((com.tencent.mm.plugin.game.autogen.a.d)localObject1).IcM.add(localc);
                paramInt += 1;
                break;
              }
            }
            localObject2 = (Collection)((com.tencent.mm.plugin.game.autogen.a.d)localObject1).IcM;
            if (localObject2 == null) {
              break label1022;
            }
            if (!((Collection)localObject2).isEmpty()) {
              break label1027;
            }
            break label1022;
          }
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        Log.i("MicroMsg.GameResourceDownloadManager", "checkResourceDownload, DownloadItemList is empty");
        AppMethodBeat.o(275332);
        break label117;
      }
      ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm();
      localObject2 = paramf.IcK;
      s.s(localObject2, "PackageName");
      paramg = paramg.field_appId;
      s.s(paramg, "appInfo.field_appId");
      d.a((String)localObject2, paramg, paramf.IcX, paramf.IcY, (com.tencent.mm.plugin.game.autogen.a.d)localObject1);
      paramg = paramf.IcK;
      s.s(paramg, "PackageName");
      aFO(paramg);
      AppMethodBeat.o(275332);
      break label117;
      paramg = paramf.IcK;
      s.s(paramg, "PackageName");
      cancelDownloadTask(paramg);
      break label156;
      break label1013;
      label976:
      i = 1;
      break;
      break label156;
      label985:
      i = 1;
      break label232;
      label991:
      i = 0;
      break label232;
      label997:
      paramInt = 1;
      break label419;
      label1002:
      paramInt = 0;
      break label419;
      label1007:
      i = 1;
      break label619;
      label1013:
      break label529;
      label1016:
      i = 0;
      break label619;
      label1022:
      paramInt = 1;
      continue;
      label1027:
      paramInt = 0;
    }
  }
  
  private static final void a(com.tencent.mm.pluginsdk.model.app.g paramg, ah.f paramf, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(275364);
    s.u(paramg, "$this_apply");
    s.u(paramf, "$request");
    b localb = Itw;
    int i = ((e)paramf.aqH).IcS;
    paramf = c.c.b(paramc.otC);
    if (paramf == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.download.GetGameResourceDownloadInfoResponse");
      AppMethodBeat.o(275364);
      throw paramg;
    }
    localb.a(paramg, i, (com.tencent.mm.plugin.game.autogen.a.f)paramf);
    AppMethodBeat.o(275364);
  }
  
  public static void aFN(String paramString)
  {
    AppMethodBeat.i(275326);
    s.u(paramString, "appId");
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.GameResourceDownloadManager", "appId is null");
      AppMethodBeat.o(275326);
      return;
    }
    Log.i("MicroMsg.GameResourceDownloadManager", s.X("tryDownload, appId:", paramString));
    com.tencent.threadpool.h.ahAA.g(new b..ExternalSyntheticLambda3(paramString), "GameResourceDownloadRequest_tryDownload");
    AppMethodBeat.o(275326);
  }
  
  public static void aFO(String paramString)
  {
    AppMethodBeat.i(275337);
    s.u(paramString, "packageName");
    paramString = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm().aFS(paramString);
    com.tencent.mm.plugin.game.autogen.a.d locald;
    if (paramString != null) {
      locald = new com.tencent.mm.plugin.game.autogen.a.d();
    }
    try
    {
      locald.parseFrom(paramString.field_downloadItemList);
      Object localObject1 = locald.IcM;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        long l;
        do
        {
          com.tencent.mm.plugin.game.autogen.a.c localc;
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localc = (com.tencent.mm.plugin.game.autogen.a.c)((Iterator)localObject1).next();
          } while (localc.IcH);
          Object localObject2 = new g.a();
          ((g.a)localObject2).amR(localc.IcC);
          ((g.a)localObject2).setFileSize(localc.IcI);
          ((g.a)localObject2).amW(localc.IcJ);
          ((g.a)localObject2).setFileMD5(localc.Md5);
          ((g.a)localObject2).setAppId(localc.oOI);
          ((g.a)localObject2).setPackageName(localc.IcK);
          ((g.a)localObject2).nA(false);
          ((g.a)localObject2).JA(3);
          ((g.a)localObject2).nD(true);
          ((g.a)localObject2).xoe.xnV = true;
          ((g.a)localObject2).amV(localc.IcL);
          localObject2 = ((g.a)localObject2).xoe;
          com.tencent.mm.plugin.downloader.model.d.amK(localc.IcC);
          l = com.tencent.mm.plugin.downloader.model.f.duv().b((com.tencent.mm.plugin.downloader.model.g)localObject2);
          Log.i("MicroMsg.GameResourceDownloadManager", "add download task[packageName:" + localc.IcK + ", downloadUrl:" + localc.IcC + ", downloadPath:" + localc.IcL + "], size:" + localc.IcI + ", md5:" + localc.Md5 + ", downloadId:" + l);
          localc.IcG = l;
          localc.IcH = true;
        } while (l <= 0L);
      }
      paramString.field_downloadItemList = locald.toByteArray();
      Log.i("MicroMsg.GameResourceDownloadManager", s.X("performNextDownload, updateRet:", Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm().update((IAutoDBItem)paramString, new String[0]))));
      AppMethodBeat.o(275337);
      return;
    }
    catch (Exception paramString)
    {
      Log.i("MicroMsg.GameResourceDownloadManager", s.X("performNextDownload, catch err:", paramString.getMessage()));
      AppMethodBeat.o(275337);
    }
  }
  
  private static String aFP(String paramString)
  {
    AppMethodBeat.i(275339);
    paramString = com.tencent.mm.loader.i.b.bmu() + '/' + paramString + '/';
    AppMethodBeat.o(275339);
    return paramString;
  }
  
  private static final void aFQ(String paramString)
  {
    AppMethodBeat.i(275379);
    s.u(paramString, "$appId");
    paramString = com.tencent.mm.pluginsdk.model.app.h.dV(paramString, false);
    if (paramString != null)
    {
      Object localObject1 = (CharSequence)paramString.field_packageName;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(275379);
        return;
      }
      Log.i("MicroMsg.GameResourceDownloadManager", s.X("tryDownload, packageName:", paramString.field_packageName));
      localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm();
      Object localObject2 = paramString.field_packageName;
      s.s(localObject2, "field_packageName");
      s.u(localObject2, "packageName");
      Log.i("MicroMsg.GameResourceDownloadStorage", "allowCleanPkg(" + (String)localObject2 + ')');
      localObject1 = ((d)localObject1).aFS((String)localObject2);
      if ((localObject1 != null) && (Math.abs(Util.nowSecond() - ((a)localObject1).field_finishDownloadTime) > ((a)localObject1).field_expiredSeconds)) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.GameResourceDownloadManager", s.X("tryDownload, allowCleanPkg:", Boolean.TRUE));
        paramString = paramString.field_packageName;
        s.s(paramString, "field_packageName");
        cancelDownloadTask(paramString);
        AppMethodBeat.o(275379);
        return;
      }
      localObject1 = new ah.f();
      ((ah.f)localObject1).aqH = new e();
      ((e)((ah.f)localObject1).aqH).vgX = q.aPo();
      ((e)((ah.f)localObject1).aqH).vhx = Build.MANUFACTURER;
      ((e)((ah.f)localObject1).aqH).IcN = "";
      ((e)((ah.f)localObject1).aqH).IcO = q.aPk();
      ((e)((ah.f)localObject1).aqH).IcP = q.eD(false);
      ((e)((ah.f)localObject1).aqH).IcK = paramString.field_packageName;
      ((e)((ah.f)localObject1).aqH).oOI = paramString.field_appId;
      ((e)((ah.f)localObject1).aqH).IcQ = String.valueOf(com.tencent.mm.plugin.game.d.c.aHj(((e)((ah.f)localObject1).aqH).IcK));
      ((e)((ah.f)localObject1).aqH).IcR = com.tencent.mm.plugin.game.d.c.aHk(((e)((ah.f)localObject1).aqH).IcK);
      localObject2 = (e)((ah.f)localObject1).aqH;
      d locald = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm();
      String str = ((e)((ah.f)localObject1).aqH).IcK;
      s.s(str, "request.PackageName");
      ((e)localObject2).IcS = locald.aFT(str);
      Log.i("MicroMsg.GameResourceDownloadManager", s.X("download stage:", Integer.valueOf(((e)((ah.f)localObject1).aqH).IcS)));
      localObject2 = new c.a();
      ((c.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameresourcedownloadinfo";
      ((c.a)localObject2).funcId = 4218;
      ((c.a)localObject2).otG = 0;
      ((c.a)localObject2).respCmdId = 0;
      ((c.a)localObject2).otE = ((com.tencent.mm.bx.a)((ah.f)localObject1).aqH);
      ((c.a)localObject2).otF = ((com.tencent.mm.bx.a)new com.tencent.mm.plugin.game.autogen.a.f());
      z.a(((c.a)localObject2).bEF(), new b..ExternalSyntheticLambda0(paramString, (ah.f)localObject1));
    }
    AppMethodBeat.o(275379);
  }
  
  private static void cancelDownloadTask(String paramString)
  {
    AppMethodBeat.i(275345);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(275345);
      return;
    }
    localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm().aFS(paramString);
    if (localObject1 != null)
    {
      localObject2 = new com.tencent.mm.plugin.game.autogen.a.d();
      try
      {
        ((com.tencent.mm.plugin.game.autogen.a.d)localObject2).parseFrom(((a)localObject1).field_downloadItemList);
        localObject1 = ((com.tencent.mm.plugin.game.autogen.a.d)localObject2).IcM;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.game.autogen.a.c)((Iterator)localObject1).next();
            i = com.tencent.mm.plugin.downloader.model.f.duv().kR(((com.tencent.mm.plugin.game.autogen.a.c)localObject2).IcG);
            Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, downloadId:" + ((com.tencent.mm.plugin.game.autogen.a.c)localObject2).IcG + " ret:" + i);
          }
        }
        locald = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm();
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.GameResourceDownloadManager", s.X("cancelDownloadTask, catch err:", localException.getMessage()));
      }
    }
    d locald;
    s.u(paramString, "packageName");
    Object localObject2 = "delete from GameResourceDownload where packageName=\"" + paramString + '"';
    boolean bool = locald.execSQL("GameResourceDownload", (String)localObject2);
    Log.i("MicroMsg.GameResourceDownloadStorage", "delDownloadInfo, sql:" + (String)localObject2 + ", ret:" + bool);
    fEh();
    Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, packageName:" + paramString + ", delDownloadInfo: " + bool);
    AppMethodBeat.o(275345);
  }
  
  public static void fEh()
  {
    AppMethodBeat.i(275322);
    com.tencent.threadpool.h.ahAA.g(b..ExternalSyntheticLambda4.INSTANCE, "GameResourceDownloadRequest_resetCheckTimer");
    AppMethodBeat.o(275322);
  }
  
  private static void fEi()
  {
    AppMethodBeat.i(275341);
    Object localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm().rawQuery("select * from GameResourceDownload", new String[0]);
    if (localObject2 == null) {}
    for (Object localObject1 = null; localObject1 != null; localObject1 = (List)localObject2)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        Log.i("MicroMsg.GameResourceDownloadManager", s.X("loopDownload, appId:", ((a)localObject2).field_appId));
        localObject2 = ((a)localObject2).field_appId;
        s.s(localObject2, "it.field_appId");
        aFN((String)localObject2);
      }
      localObject1 = new ArrayList();
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          localObject3 = new a();
          ((a)localObject3).convertFrom((Cursor)localObject2);
          ((ArrayList)localObject1).add(localObject3);
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
      localObject2 = new ArrayList();
      Object localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        a locala = (a)((Iterator)localObject3).next();
        if (Math.abs(Util.nowSecond() - locala.field_checkCgiTime) >= locala.field_intervalSeconds) {
          ((ArrayList)localObject2).add(locala);
        }
      }
      Log.i("MicroMsg.GameResourceDownloadStorage", "getNeedCheckItems, allItemsSize:" + ((ArrayList)localObject1).size() + ", needCheckItemsSize:" + ((ArrayList)localObject2).size());
    }
    AppMethodBeat.o(275341);
  }
  
  private static final boolean fEj()
  {
    AppMethodBeat.i(275352);
    fEi();
    AppMethodBeat.o(275352);
    return true;
  }
  
  private static final void fEk()
  {
    Object localObject2 = null;
    AppMethodBeat.i(275359);
    Object localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCm();
    Object localObject3 = "select intervalSeconds - abs(" + Util.nowSecond() + " - checkCgiTime) as diffTime from GameResourceDownload order by diffTime asc";
    Log.i("MicroMsg.GameResourceDownloadStorage", s.X("getMinCheckInterval, sql: ", localObject3));
    localObject3 = ((d)localObject1).rawQuery((String)localObject3, new String[0]);
    if (localObject3 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        if (localObject1 == null) {
          sJn.stopTimer();
        }
        AppMethodBeat.o(275359);
      }
    }
    else
    {
      if (!((Cursor)localObject3).moveToNext()) {
        break label192;
      }
    }
    label192:
    for (localObject1 = Long.valueOf(((Cursor)localObject3).getLong(0));; localObject1 = null)
    {
      ((Cursor)localObject3).close();
      break;
      long l = ((Number)localObject1).longValue();
      Log.i("MicroMsg.GameResourceDownloadManager", s.X("resetCheckTimer, interval:", Long.valueOf(l)));
      sJn.stopTimer();
      if (l <= 0L) {
        fEi();
      }
      for (;;)
      {
        break;
        sJn.startTimer(l * 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b
 * JD-Core Version:    0.7.0.1
 */