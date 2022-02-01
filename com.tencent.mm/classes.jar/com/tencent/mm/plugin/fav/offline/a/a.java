package com.tencent.mm.plugin.fav.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static void O(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(73542);
    long l = cVv();
    g.aAh().azQ().set(ar.a.Ojw, Long.valueOf(l + (paramLong2 - paramLong1)));
    AppMethodBeat.o(73542);
  }
  
  public static void Un()
  {
    AppMethodBeat.i(73543);
    List localList = ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().cVx();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.offline.b.a locala = (com.tencent.mm.plugin.fav.offline.b.a)localIterator.next();
      if (!((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().delete(locala.systemRowid)) {
        break label154;
      }
      i += 1;
    }
    label154:
    for (;;)
    {
      break;
      s.dy(PluginFavOffline.getFavOfflinePath(), true);
      Log.i("MicroMsg.offline.FavOfflineHelp", "cleanAllCache maxSize:%s allSize:%s allNum:%s deleteResult:%s", new Object[] { Long.valueOf(cVu()), Long.valueOf(cVv()), Integer.valueOf(localList.size()), Integer.valueOf(i) });
      g.aAh().azQ().set(ar.a.Ojw, Long.valueOf(0L));
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
      ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().c(parama);
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
    long l = asf(parama.field_path);
    boolean bool = s.deleteFile(parama.field_path);
    if (bool) {
      O(l, 0L);
    }
    Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOfflineContent deleteHtml:%s", new Object[] { Boolean.valueOf(bool) });
    parama.field_size = 0L;
    parama.field_status = 0;
    bool = ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().c(parama);
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
    ba localba = new ba();
    localba.erm = parama.systemRowid;
    long l1;
    if (paramInt1 == 0)
    {
      long l2 = new o(parama.field_path).length();
      l1 = l2;
      if (!Util.isNullOrNil(parama.field_imgDirPath)) {
        l1 = l2 + asf(parama.field_imgDirPath);
      }
    }
    for (localba.ern = l1;; localba.ern = paramInt1)
    {
      localba.ero = ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().cVx().size();
      localba.erp = cVv();
      localba.erq = paramInt2;
      localba.bfK();
      AppMethodBeat.o(73550);
      return true;
    }
  }
  
  public static boolean af(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(73544);
    long l = asf(paramString2);
    boolean bool3 = s.deleteFile(paramString2);
    if (bool3) {
      O(l, 0L);
    }
    boolean bool2;
    if (!Util.isNullOrNil(paramString3))
    {
      l = asf(paramString3);
      bool2 = s.dy(paramString3, true);
      bool1 = bool2;
      if (bool2) {
        O(l, 0L);
      }
    }
    for (boolean bool1 = bool2; (bool3) && (bool1); bool1 = true)
    {
      bool1 = ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().asj(paramString1);
      AppMethodBeat.o(73544);
      return bool1;
    }
    Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOffline deleteHtml:%s deleteImg:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
    AppMethodBeat.o(73544);
    return false;
  }
  
  private static long asf(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(73547);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73547);
      return 0L;
    }
    Object localObject = new o(paramString);
    if (((o)localObject).isFile())
    {
      l = ((o)localObject).length();
      AppMethodBeat.o(73547);
      return l;
    }
    paramString = s.dC(paramString, true);
    if (paramString == null)
    {
      AppMethodBeat.o(73547);
      return 0L;
    }
    paramString = paramString.iterator();
    if (paramString.hasNext())
    {
      localObject = (com.tencent.mm.vfs.e)paramString.next();
      if (localObject == null) {
        break label113;
      }
      l = ((com.tencent.mm.vfs.e)localObject).size + l;
    }
    label113:
    for (;;)
    {
      break;
      AppMethodBeat.o(73547);
      return l;
    }
  }
  
  public static int asg(String paramString)
  {
    AppMethodBeat.i(73548);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum: url is null!");
      AppMethodBeat.o(73548);
      return -1;
    }
    com.tencent.mm.plugin.fav.offline.b.a locala = ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(paramString);
    if (locala == null)
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum: favOffline(%s) is null!", new Object[] { paramString });
      AppMethodBeat.o(73548);
      return -1;
    }
    locala.field_failNum += 1;
    Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum result:%s", new Object[] { Boolean.valueOf(((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().c(locala)) });
    if (locala.field_failNum >= 5) {
      a(locala, 0);
    }
    int i = locala.field_failNum;
    AppMethodBeat.o(73548);
    return i;
  }
  
  public static boolean cVs()
  {
    AppMethodBeat.i(73538);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sit, 0);
    Log.d("MicroMsg.offline.FavOfflineHelp", "isOpenFavOffline() open:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(73538);
      return true;
    }
    AppMethodBeat.o(73538);
    return false;
  }
  
  private static long cVt()
  {
    AppMethodBeat.i(73539);
    long l = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siu, 20971520L);
    Log.d("MicroMsg.offline.FavOfflineHelp", "getFavOfflineMaxSize() maxSize:%s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(73539);
    return l;
  }
  
  private static long cVu()
  {
    AppMethodBeat.i(73540);
    long l = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siv, 1073741824);
    AppMethodBeat.o(73540);
    return l;
  }
  
  private static long cVv()
  {
    AppMethodBeat.i(73541);
    long l = g.aAh().azQ().a(ar.a.Ojw, 0L);
    AppMethodBeat.o(73541);
    return l;
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
    Object localObject = ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(paramString1);
    if (localObject == null)
    {
      Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: favOffline(%s) is null!", new Object[] { paramString1 });
      AppMethodBeat.o(73546);
      return false;
    }
    long l1 = new o(paramString2).length();
    if (!Util.isNullOrNil(paramString3)) {
      l1 += asf(paramString3);
    }
    for (;;)
    {
      if (l1 > cVt())
      {
        Log.i("MicroMsg.offline.FavOfflineHelp", "url(%s) bytelength(%s) exceed %s", new Object[] { paramString1, Long.valueOf(l1), Long.valueOf(cVt()) });
        if (paramInt == 0) {
          a((com.tencent.mm.plugin.fav.offline.b.a)localObject, (int)l1, 0);
        }
        bool1 = af(paramString1, paramString2, paramString3);
        AppMethodBeat.o(73546);
        return bool1;
      }
      int i = ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_status;
      O(((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_size, l1);
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_path = paramString2;
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_size = l1;
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_updateTime = cl.aWy();
      if ((!Util.isNullOrNil(paramString3)) && (Util.isNullOrNil(((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_imgDirPath))) {
        ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_imgDirPath = paramString3;
      }
      ((com.tencent.mm.plugin.fav.offline.b.a)localObject).field_status = paramInt;
      boolean bool1 = ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().c((com.tencent.mm.plugin.fav.offline.b.a)localObject);
      if ((i != 1) && (paramInt == 2)) {
        a((com.tencent.mm.plugin.fav.offline.b.a)localObject, 1);
      }
      long l3 = cVv();
      if (l3 > cVu())
      {
        paramString2 = ((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().cVx();
        paramString3 = new ArrayList();
        localObject = paramString2.iterator();
        long l2 = 0L;
        com.tencent.mm.plugin.fav.offline.b.a locala;
        while (((Iterator)localObject).hasNext())
        {
          locala = (com.tencent.mm.plugin.fav.offline.b.a)((Iterator)localObject).next();
          if (l2 >= cVu() / 2L) {
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
          boolean bool2 = s.deleteFile(locala.field_path);
          long l4 = asf(locala.field_path);
          boolean bool3 = s.dy(locala.field_imgDirPath, true);
          long l5 = asf(locala.field_imgDirPath);
          if ((bool2) && (bool3))
          {
            O(l4 + l5, 0L);
            if (((PluginFavOffline)g.ah(PluginFavOffline.class)).getFavOfflineStorage().delete(locala.systemRowid)) {
              i += 1;
            }
          }
          else
          {
            if (bool2) {
              O(l4, 0L);
            }
            if (bool3) {
              O(l5, 0L);
            }
          }
        }
        Log.i("MicroMsg.offline.FavOfflineHelp", "cleanHalfCache maxSize:%s allSize:%s allNum:%s deleteSize:%s deleteNum:%s deleteResult:%s", new Object[] { Long.valueOf(cVu()), Long.valueOf(l3), Integer.valueOf(paramString2.size()), Long.valueOf(l2), Integer.valueOf(paramString3.size()), Integer.valueOf(i) });
      }
      Log.i("MicroMsg.offline.FavOfflineHelp", "allFavOffline size:%s, url(%s) status(%s) size:%s", new Object[] { Long.valueOf(cVv()), paramString1, Integer.valueOf(paramInt), Long.valueOf(l1) });
      AppMethodBeat.o(73546);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.a.a
 * JD-Core Version:    0.7.0.1
 */