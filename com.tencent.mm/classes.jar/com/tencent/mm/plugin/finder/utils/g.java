package com.tencent.mm.plugin.finder.utils;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.report.n.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.o;
import d.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderFolderClearManager;", "", "()V", "MARK_DEL_FOLDERS", "", "TAG", "fileLock", "Ljava/lang/Object;", "finderUICount", "", "lastDumpTime", "", "checkClearWhenAppInBackground", "", "clearMarkFolder", "dumpAndMark", "enterFinderUI", "exitFinderUI", "mark", "curSize", "folder", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "plugin-finder_release"})
public final class g
{
  static final String TAG = "Finder.FinderFolderClearManager";
  private static long guk;
  static final Object sJa;
  static int sLi;
  public static final g sLj;
  
  static
  {
    AppMethodBeat.i(167889);
    sLj = new g();
    TAG = "Finder.FinderFolderClearManager";
    sJa = new Object();
    AppForegroundDelegate.cSQ.a((n)new n()
    {
      public final void onAppBackground(String arg1)
      {
        AppMethodBeat.i(167887);
        ??? = g.sLj;
        ad.i(g.TAG, "checkClearWhenAppInBackground");
        if (g.sLi <= 0)
        {
          ad.i(g.TAG, "clearMarkFolder");
          synchronized (g.sJa)
          {
            l = bt.HI();
            localObject3 = ax.flg();
            Set localSet = ((ax)localObject3).getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
            if (localSet != null)
            {
              Iterator localIterator = ((Iterable)localSet).iterator();
              while (localIterator.hasNext())
              {
                Object localObject4 = (String)localIterator.next();
                ad.i(g.TAG, "clearMarkFolders ".concat(String.valueOf(localObject4)));
                i.cZ((String)localObject4, true);
                r localr = r.sNc;
                if (p.i(localObject4, r.cLH()))
                {
                  localObject4 = c.sAv;
                  c.aSJ();
                }
              }
            }
          }
          ((ax)localObject3).putStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
          Object localObject3 = r.sNc;
          localObject3 = r.cLJ();
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            localObject3[i].cLe();
            i += 1;
          }
          long l = bt.aO(l);
          if ((localObject1 != null) && (localObject1.size() > 0))
          {
            localObject2 = n.a.spN;
            n.a.wv(l);
          }
          ad.i(g.TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
          Object localObject2 = z.MKo;
          ??? = com.tencent.mm.plugin.finder.upload.f.sJc;
          com.tencent.mm.plugin.finder.upload.f.cKH();
        }
        AppMethodBeat.o(167887);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    });
    AppMethodBeat.o(167889);
  }
  
  public static void cLg()
  {
    sLi += 1;
  }
  
  public static void cLh()
  {
    int i = sLi - 1;
    sLi = i;
    if (i < 0) {
      sLi = 0;
    }
  }
  
  public static void cLi()
  {
    AppMethodBeat.i(167888);
    ad.i(TAG, "dumpAndMark");
    long l1 = cf.aCK();
    long l2 = guk;
    Object localObject1 = b.sxa;
    if (l1 - l2 < b.cFz())
    {
      AppMethodBeat.o(167888);
      return;
    }
    l2 = bt.HI();
    guk = l1;
    localObject1 = (Map)new LinkedHashMap();
    ??? = r.sNc;
    f[] arrayOff = r.cLJ();
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      f localf = arrayOff[i];
      l1 = ((Number)localf.cLf().second).longValue();
      if ((localf.sLh) && (l1 > localf.maxSize)) {}
      synchronized (sJa)
      {
        ad.i(TAG, "mark: size " + l1 + ", name " + localf.name + ", path " + localf.path);
        ax localax = ax.flg();
        Set localSet = localax.getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
        if (localSet == null) {
          p.gfZ();
        }
        localSet.add(localf.path);
        localax.putStringSet("FINDER_MARK_DEL_FOLDERS", localSet).commit();
        ((Map)localObject1).put(localf.name, Long.valueOf(l1));
        i += 1;
      }
    }
    l1 = bt.aO(l2);
    ??? = n.a.spN;
    n.a.ww(l1);
    ??? = n.a.spN;
    n.a.Z(localMap);
    AppMethodBeat.o(167888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.g
 * JD-Core Version:    0.7.0.1
 */