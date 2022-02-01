package com.tencent.mm.plugin.fav.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static void JW()
  {
    AppMethodBeat.i(73543);
    List localList = ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().cvS();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.offline.b.a locala = (com.tencent.mm.plugin.fav.offline.b.a)localIterator.next();
      if (!((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().delete(locala.systemRowid)) {
        break label154;
      }
      i += 1;
    }
    label154:
    for (;;)
    {
      break;
      i.cZ(PluginFavOffline.getFavOfflinePath(), true);
      ad.i("MicroMsg.offline.FavOfflineHelp", "cleanAllCache maxSize:%s allSize:%s allNum:%s deleteResult:%s", new Object[] { Long.valueOf(cvP()), Long.valueOf(cvQ()), Integer.valueOf(localList.size()), Integer.valueOf(i) });
      g.ajC().ajl().set(al.a.IGp, Long.valueOf(0L));
      AppMethodBeat.o(73543);
      return;
    }
  }
  
  private static void L(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(73542);
    long l = cvQ();
    g.ajC().ajl().set(al.a.IGp, Long.valueOf(l + (paramLong2 - paramLong1)));
    AppMethodBeat.o(73542);
  }
  
  public static boolean Z(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(73544);
    long l = agA(paramString2);
    boolean bool3 = i.deleteFile(paramString2);
    if (bool3) {
      L(l, 0L);
    }
    boolean bool2;
    if (!bt.isNullOrNil(paramString3))
    {
      l = agA(paramString3);
      bool2 = i.cZ(paramString3, true);
      bool1 = bool2;
      if (bool2) {
        L(l, 0L);
      }
    }
    for (boolean bool1 = bool2; (bool3) && (bool1); bool1 = true)
    {
      bool1 = ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().agE(paramString1);
      AppMethodBeat.o(73544);
      return bool1;
    }
    ad.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOffline deleteHtml:%s deleteImg:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
    AppMethodBeat.o(73544);
    return false;
  }
  
  private static void a(com.tencent.mm.plugin.fav.offline.b.a parama, int paramInt)
  {
    AppMethodBeat.i(73549);
    if (a(parama, 0, paramInt))
    {
      parama.field_isReport = 1;
      ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().c(parama);
    }
    AppMethodBeat.o(73549);
  }
  
  public static boolean a(com.tencent.mm.plugin.fav.offline.b.a parama)
  {
    AppMethodBeat.i(73545);
    if (parama == null)
    {
      ad.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOfflineContent favOffline is null!");
      AppMethodBeat.o(73545);
      return false;
    }
    long l = agA(parama.field_path);
    boolean bool = i.deleteFile(parama.field_path);
    if (bool) {
      L(l, 0L);
    }
    ad.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOfflineContent deleteHtml:%s", new Object[] { Boolean.valueOf(bool) });
    parama.field_size = 0L;
    parama.field_status = 0;
    bool = ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().c(parama);
    AppMethodBeat.o(73545);
    return bool;
  }
  
  private static boolean a(com.tencent.mm.plugin.fav.offline.b.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73550);
    if (parama == null)
    {
      ad.i("MicroMsg.offline.FavOfflineHelp", "report: favOffline is null!");
      AppMethodBeat.o(73550);
      return false;
    }
    if (parama.field_isReport == 1)
    {
      AppMethodBeat.o(73550);
      return false;
    }
    ac localac = new ac();
    localac.dUM = parama.systemRowid;
    long l1;
    if (paramInt1 == 0)
    {
      long l2 = new com.tencent.mm.vfs.e(parama.field_path).length();
      l1 = l2;
      if (!bt.isNullOrNil(parama.field_imgDirPath)) {
        l1 = l2 + agA(parama.field_imgDirPath);
      }
    }
    for (localac.dUN = l1;; localac.dUN = paramInt1)
    {
      localac.dUO = ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().cvS().size();
      localac.dUP = cvQ();
      localac.dUQ = paramInt2;
      localac.aLk();
      AppMethodBeat.o(73550);
      return true;
    }
  }
  
  private static long agA(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(73547);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73547);
      return 0L;
    }
    Object localObject = new com.tencent.mm.vfs.e(paramString);
    if (((com.tencent.mm.vfs.e)localObject).isFile())
    {
      l = ((com.tencent.mm.vfs.e)localObject).length();
      AppMethodBeat.o(73547);
      return l;
    }
    paramString = i.de(paramString, true);
    if (paramString == null)
    {
      AppMethodBeat.o(73547);
      return 0L;
    }
    paramString = paramString.iterator();
    if (paramString.hasNext())
    {
      localObject = (FileSystem.a)paramString.next();
      if (localObject == null) {
        break label113;
      }
      l = ((FileSystem.a)localObject).size + l;
    }
    label113:
    for (;;)
    {
      break;
      AppMethodBeat.o(73547);
      return l;
    }
  }
  
  public static int agB(String paramString)
  {
    AppMethodBeat.i(73548);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum: url is null!");
      AppMethodBeat.o(73548);
      return -1;
    }
    com.tencent.mm.plugin.fav.offline.b.a locala = ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().agF(paramString);
    if (locala == null)
    {
      ad.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum: favOffline(%s) is null!", new Object[] { paramString });
      AppMethodBeat.o(73548);
      return -1;
    }
    locala.field_failNum += 1;
    ad.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum result:%s", new Object[] { Boolean.valueOf(((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().c(locala)) });
    if (locala.field_failNum >= 5) {
      a(locala, 0);
    }
    int i = locala.field_failNum;
    AppMethodBeat.o(73548);
    return i;
  }
  
  public static boolean cvN()
  {
    AppMethodBeat.i(73538);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEv, 0);
    ad.d("MicroMsg.offline.FavOfflineHelp", "isOpenFavOffline() open:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(73538);
      return true;
    }
    AppMethodBeat.o(73538);
    return false;
  }
  
  private static long cvO()
  {
    AppMethodBeat.i(73539);
    long l = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEw, 20971520L);
    ad.d("MicroMsg.offline.FavOfflineHelp", "getFavOfflineMaxSize() maxSize:%s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(73539);
    return l;
  }
  
  private static long cvP()
  {
    AppMethodBeat.i(73540);
    long l = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEx, 1073741824);
    AppMethodBeat.o(73540);
    return l;
  }
  
  private static long cvQ()
  {
    AppMethodBeat.i(73541);
    long l = g.ajC().ajl().a(al.a.IGp, 0L);
    AppMethodBeat.o(73541);
    return l;
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(73546);
    if (bt.isNullOrNil(paramString1))
    {
      ad.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: url is null!");
      AppMethodBeat.o(73546);
      return false;
    }
    Object localObject = ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().agF(paramString1);
    if (localObject == null)
    {
      ad.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: favOffline(%s) is null!", new Object[] { paramString1 });
      AppMethodBeat.o(73546);
      return false;
    }
    long l1 = new com.tencent.mm.vfs.e(paramString2).length();
    if (!bt.isNullOrNil(paramString3)) {
      l1 += agA(paramString3);
    }
    for (;;)
    {
      if (l1 > cvO())
      {
        ad.i("MicroMsg.offline.FavOfflineHelp", "url(%s) bytelength(%s) exceed %s", new Object[] { paramString1, Long.valueOf(l1), Long.valueOf(cvO()) });
        if (paramInt == 0) {
          a((com.tencent.mm.plugin.fav.offline.b.a)localObject, (int)l1, 0);
        }
        bool1 = Z(paramString1, paramString2, paramString3);
        AppMethodBeat.o(73546);
        return bool1;
      }
      int i = ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_status;
      L(((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_size, l1);
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_path = paramString2;
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_size = l1;
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_updateTime = cf.aCK();
      if ((!bt.isNullOrNil(paramString3)) && (bt.isNullOrNil(((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_imgDirPath))) {
        ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_imgDirPath = paramString3;
      }
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_status = paramInt;
      boolean bool1 = ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().c((com.tencent.mm.plugin.fav.offline.b.a)localObject);
      if ((i != 1) && (paramInt == 2)) {
        a((com.tencent.mm.plugin.fav.offline.b.a)localObject, 1);
      }
      long l3 = cvQ();
      if (l3 > cvP())
      {
        paramString2 = ((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().cvS();
        paramString3 = new ArrayList();
        localObject = paramString2.iterator();
        long l2 = 0L;
        com.tencent.mm.plugin.fav.offline.b.a locala;
        while (((Iterator)localObject).hasNext())
        {
          locala = (com.tencent.mm.plugin.fav.offline.b.a)((Iterator)localObject).next();
          if (l2 >= cvP() / 2L) {
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
          boolean bool2 = i.deleteFile(locala.field_path);
          long l4 = agA(locala.field_path);
          boolean bool3 = i.cZ(locala.field_imgDirPath, true);
          long l5 = agA(locala.field_imgDirPath);
          if ((bool2) && (bool3))
          {
            L(l4 + l5, 0L);
            if (((PluginFavOffline)g.ad(PluginFavOffline.class)).getFavOfflineStorage().delete(locala.systemRowid)) {
              i += 1;
            }
          }
          else
          {
            if (bool2) {
              L(l4, 0L);
            }
            if (bool3) {
              L(l5, 0L);
            }
          }
        }
        ad.i("MicroMsg.offline.FavOfflineHelp", "cleanHalfCache maxSize:%s allSize:%s allNum:%s deleteSize:%s deleteNum:%s deleteResult:%s", new Object[] { Long.valueOf(cvP()), Long.valueOf(l3), Integer.valueOf(paramString2.size()), Long.valueOf(l2), Integer.valueOf(paramString3.size()), Integer.valueOf(i) });
      }
      ad.i("MicroMsg.offline.FavOfflineHelp", "allFavOffline size:%s, url(%s) status(%s) size:%s", new Object[] { Long.valueOf(cvQ()), paramString1, Integer.valueOf(paramInt), Long.valueOf(l1) });
      AppMethodBeat.o(73546);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.a.a
 * JD-Core Version:    0.7.0.1
 */