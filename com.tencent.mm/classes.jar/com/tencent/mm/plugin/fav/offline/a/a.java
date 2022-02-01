package com.tencent.mm.plugin.fav.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.bk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static void R(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(73542);
    long l = dkB();
    h.aHG().aHp().set(ar.a.VxM, Long.valueOf(l + (paramLong2 - paramLong1)));
    AppMethodBeat.o(73542);
  }
  
  public static void YF()
  {
    AppMethodBeat.i(73543);
    List localList = ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().dkD();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.offline.b.a locala = (com.tencent.mm.plugin.fav.offline.b.a)localIterator.next();
      if (!((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().delete(locala.systemRowid)) {
        break label153;
      }
      i += 1;
    }
    label153:
    for (;;)
    {
      break;
      u.deleteDir(PluginFavOffline.getFavOfflinePath());
      Log.i("MicroMsg.offline.FavOfflineHelp", "cleanAllCache maxSize:%s allSize:%s allNum:%s deleteResult:%s", new Object[] { Long.valueOf(dkA()), Long.valueOf(dkB()), Integer.valueOf(localList.size()), Integer.valueOf(i) });
      h.aHG().aHp().set(ar.a.VxM, Long.valueOf(0L));
      AppMethodBeat.o(73543);
      return;
    }
  }
  
  private static void a(com.tencent.mm.plugin.fav.offline.b.a parama, int paramInt)
  {
    AppMethodBeat.i(73549);
    if (a(parama, 0, paramInt))
    {
      parama.field_isReport = 1;
      ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().c(parama);
    }
    AppMethodBeat.o(73549);
  }
  
  public static boolean a(com.tencent.mm.plugin.fav.offline.b.a parama)
  {
    AppMethodBeat.i(73545);
    if (parama == null)
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOfflineContent favOffline is null!");
      AppMethodBeat.o(73545);
      return false;
    }
    long l = aAg(parama.field_path);
    boolean bool = u.deleteFile(parama.field_path);
    if (bool) {
      R(l, 0L);
    }
    Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOfflineContent deleteHtml:%s", new Object[] { Boolean.valueOf(bool) });
    parama.field_size = 0L;
    parama.field_status = 0;
    bool = ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().c(parama);
    AppMethodBeat.o(73545);
    return bool;
  }
  
  private static boolean a(com.tencent.mm.plugin.fav.offline.b.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73550);
    if (parama == null)
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "report: favOffline is null!");
      AppMethodBeat.o(73550);
      return false;
    }
    if (parama.field_isReport == 1)
    {
      AppMethodBeat.o(73550);
      return false;
    }
    bk localbk = new bk();
    localbk.gmJ = parama.systemRowid;
    long l1;
    if (paramInt1 == 0)
    {
      long l2 = new q(parama.field_path).length();
      l1 = l2;
      if (!Util.isNullOrNil(parama.field_imgDirPath)) {
        l1 = l2 + aAg(parama.field_imgDirPath);
      }
    }
    for (localbk.gmK = l1;; localbk.gmK = paramInt1)
    {
      localbk.gmL = ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().dkD().size();
      localbk.gmM = dkB();
      localbk.gmN = paramInt2;
      localbk.bpa();
      AppMethodBeat.o(73550);
      return true;
    }
  }
  
  private static long aAg(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(73547);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73547);
      return 0L;
    }
    Object localObject = new q(paramString);
    if (((q)localObject).ifH())
    {
      l = ((q)localObject).length();
      AppMethodBeat.o(73547);
      return l;
    }
    paramString = u.dP(paramString, true);
    if (paramString == null)
    {
      AppMethodBeat.o(73547);
      return 0L;
    }
    paramString = paramString.iterator();
    if (paramString.hasNext())
    {
      localObject = (com.tencent.mm.vfs.f)paramString.next();
      if (localObject == null) {
        break label113;
      }
      l = ((com.tencent.mm.vfs.f)localObject).size + l;
    }
    label113:
    for (;;)
    {
      break;
      AppMethodBeat.o(73547);
      return l;
    }
  }
  
  public static int aAh(String paramString)
  {
    AppMethodBeat.i(73548);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum: url is null!");
      AppMethodBeat.o(73548);
      return -1;
    }
    com.tencent.mm.plugin.fav.offline.b.a locala = ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().aAl(paramString);
    if (locala == null)
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum: favOffline(%s) is null!", new Object[] { paramString });
      AppMethodBeat.o(73548);
      return -1;
    }
    locala.field_failNum += 1;
    Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum result:%s", new Object[] { Boolean.valueOf(((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().c(locala)) });
    if (locala.field_failNum >= 5) {
      a(locala, 0);
    }
    int i = locala.field_failNum;
    AppMethodBeat.o(73548);
    return i;
  }
  
  public static boolean ac(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(73544);
    long l = aAg(paramString2);
    boolean bool3 = u.deleteFile(paramString2);
    if (bool3) {
      R(l, 0L);
    }
    boolean bool2;
    if (!Util.isNullOrNil(paramString3))
    {
      l = aAg(paramString3);
      bool2 = u.deleteDir(paramString3);
      bool1 = bool2;
      if (bool2) {
        R(l, 0L);
      }
    }
    for (boolean bool1 = bool2; (bool3) && (bool1); bool1 = true)
    {
      bool1 = ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().aAk(paramString1);
      AppMethodBeat.o(73544);
      return bool1;
    }
    Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOffline deleteHtml:%s deleteImg:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
    AppMethodBeat.o(73544);
    return false;
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(73546);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: url is null!");
      AppMethodBeat.o(73546);
      return false;
    }
    Object localObject = ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().aAl(paramString1);
    if (localObject == null)
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: favOffline(%s) is null!", new Object[] { paramString1 });
      AppMethodBeat.o(73546);
      return false;
    }
    long l1 = new q(paramString2).length();
    if (!Util.isNullOrNil(paramString3)) {
      l1 += aAg(paramString3);
    }
    for (;;)
    {
      if (l1 > dkz())
      {
        Log.i("MicroMsg.offline.FavOfflineHelp", "url(%s) bytelength(%s) exceed %s", new Object[] { paramString1, Long.valueOf(l1), Long.valueOf(dkz()) });
        if (paramInt == 0) {
          a((com.tencent.mm.plugin.fav.offline.b.a)localObject, (int)l1, 0);
        }
        bool1 = ac(paramString1, paramString2, paramString3);
        AppMethodBeat.o(73546);
        return bool1;
      }
      int i = ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_status;
      R(((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_size, l1);
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_path = paramString2;
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_size = l1;
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_updateTime = cm.bfC();
      if ((!Util.isNullOrNil(paramString3)) && (Util.isNullOrNil(((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_imgDirPath))) {
        ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_imgDirPath = paramString3;
      }
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_status = paramInt;
      boolean bool1 = ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().c((com.tencent.mm.plugin.fav.offline.b.a)localObject);
      if ((i != 1) && (paramInt == 2)) {
        a((com.tencent.mm.plugin.fav.offline.b.a)localObject, 1);
      }
      long l3 = dkB();
      if (l3 > dkA())
      {
        paramString2 = ((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().dkD();
        paramString3 = new ArrayList();
        localObject = paramString2.iterator();
        long l2 = 0L;
        com.tencent.mm.plugin.fav.offline.b.a locala;
        while (((Iterator)localObject).hasNext())
        {
          locala = (com.tencent.mm.plugin.fav.offline.b.a)((Iterator)localObject).next();
          if (l2 >= dkA() / 2L) {
            break;
          }
          l2 += locala.field_size;
          paramString3.add(locala);
        }
        localObject = paramString3.iterator();
        i = 0;
        while (((Iterator)localObject).hasNext())
        {
          locala = (com.tencent.mm.plugin.fav.offline.b.a)((Iterator)localObject).next();
          boolean bool2 = u.deleteFile(locala.field_path);
          long l4 = aAg(locala.field_path);
          boolean bool3 = u.deleteDir(locala.field_imgDirPath);
          long l5 = aAg(locala.field_imgDirPath);
          if ((bool2) && (bool3))
          {
            R(l4 + l5, 0L);
            if (((PluginFavOffline)h.ag(PluginFavOffline.class)).getFavOfflineStorage().delete(locala.systemRowid)) {
              i += 1;
            }
          }
          else
          {
            if (bool2) {
              R(l4, 0L);
            }
            if (bool3) {
              R(l5, 0L);
            }
          }
        }
        Log.i("MicroMsg.offline.FavOfflineHelp", "cleanHalfCache maxSize:%s allSize:%s allNum:%s deleteSize:%s deleteNum:%s deleteResult:%s", new Object[] { Long.valueOf(dkA()), Long.valueOf(l3), Integer.valueOf(paramString2.size()), Long.valueOf(l2), Integer.valueOf(paramString3.size()), Integer.valueOf(i) });
      }
      Log.i("MicroMsg.offline.FavOfflineHelp", "allFavOffline size:%s, url(%s) status(%s) size:%s", new Object[] { Long.valueOf(dkB()), paramString1, Integer.valueOf(paramInt), Long.valueOf(l1) });
      AppMethodBeat.o(73546);
      return bool1;
    }
  }
  
  private static long dkA()
  {
    AppMethodBeat.i(73540);
    long l = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSt, 1073741824);
    AppMethodBeat.o(73540);
    return l;
  }
  
  private static long dkB()
  {
    AppMethodBeat.i(73541);
    long l = h.aHG().aHp().a(ar.a.VxM, 0L);
    AppMethodBeat.o(73541);
    return l;
  }
  
  public static boolean dky()
  {
    AppMethodBeat.i(73538);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSr, 0);
    Log.d("MicroMsg.offline.FavOfflineHelp", "isOpenFavOffline() open:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(73538);
      return true;
    }
    AppMethodBeat.o(73538);
    return false;
  }
  
  private static long dkz()
  {
    AppMethodBeat.i(73539);
    long l = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSs, 20971520L);
    Log.d("MicroMsg.offline.FavOfflineHelp", "getFavOfflineMaxSize() maxSize:%s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(73539);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.a.a
 * JD-Core Version:    0.7.0.1
 */