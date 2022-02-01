package com.tencent.mm.plugin.finder.utils;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.upload.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.l;
import d.o;
import d.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderFolderClearManager;", "", "()V", "MARK_DEL_FOLDERS", "", "TAG", "fileLock", "Ljava/lang/Object;", "finderUICount", "", "lastDumpTime", "", "checkClearWhenAppInBackground", "", "clearMarkFolder", "dumpAndMark", "enterFinderUI", "exitFinderUI", "mark", "curSize", "folder", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "plugin-finder_release"})
public final class d
{
  static final String TAG = "Finder.FinderFolderClearManager";
  private static long hQz;
  static final Object qQU;
  static int qSn;
  public static final d qSo;
  
  static
  {
    AppMethodBeat.i(167889);
    qSo = new d();
    TAG = "Finder.FinderFolderClearManager";
    qQU = new Object();
    AppForegroundDelegate.cKE.a((n)new n()
    {
      public final void onAppBackground(String arg1)
      {
        AppMethodBeat.i(167887);
        ??? = d.qSo;
        ad.i(d.TAG, "checkClearWhenAppInBackground");
        if (d.qSn <= 0)
        {
          ad.i(d.TAG, "clearMarkFolder");
          synchronized (d.qQU)
          {
            l = bt.GC();
            localObject3 = ax.eGe();
            Set localSet = ((ax)localObject3).getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
            if (localSet != null)
            {
              Iterator localIterator = ((Iterable)localSet).iterator();
              while (localIterator.hasNext())
              {
                Object localObject4 = (String)localIterator.next();
                ad.i(d.TAG, "clearMarkFolders ".concat(String.valueOf(localObject4)));
                i.cO((String)localObject4, true);
                k localk = k.qTp;
                if (d.g.b.k.g(localObject4, k.crW()))
                {
                  localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
                  com.tencent.mm.plugin.finder.storage.logic.c.aIG();
                }
              }
            }
          }
          ((ax)localObject3).putStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
          Object localObject3 = k.qTp;
          localObject3 = k.crY();
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            localObject3[i].crM();
            i += 1;
          }
          long l = bt.aS(l);
          if ((localObject1 != null) && (localObject1.size() > 0))
          {
            localObject2 = e.a.qFu;
            e.a.qj(l);
          }
          ad.i(d.TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
          Object localObject2 = y.JfV;
          ??? = e.qQW;
          e.cry();
        }
        AppMethodBeat.o(167887);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    });
    AppMethodBeat.o(167889);
  }
  
  public static void crO()
  {
    qSn += 1;
  }
  
  public static void crP()
  {
    int i = qSn - 1;
    qSn = i;
    if (i < 0) {
      qSn = 0;
    }
  }
  
  public static void crQ()
  {
    AppMethodBeat.i(167888);
    ad.i(TAG, "dumpAndMark");
    long l1 = ce.asQ();
    long l2 = hQz;
    Object localObject1 = b.qJA;
    if (l1 - l2 < b.cpc())
    {
      AppMethodBeat.o(167888);
      return;
    }
    l2 = bt.GC();
    hQz = l1;
    localObject1 = (Map)new LinkedHashMap();
    ??? = k.qTp;
    c[] arrayOfc = k.crY();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      l1 = ((Number)localc.crN().second).longValue();
      if ((localc.qSm) && (l1 > localc.maxSize)) {}
      synchronized (qQU)
      {
        ad.i(TAG, "mark: size " + l1 + ", name " + localc.name + ", path " + localc.path);
        ax localax = ax.eGe();
        Set localSet = localax.getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
        if (localSet == null) {
          d.g.b.k.fvU();
        }
        localSet.add(localc.path);
        localax.putStringSet("FINDER_MARK_DEL_FOLDERS", localSet).commit();
        ((Map)localObject1).put(localc.name, Long.valueOf(l1));
        i += 1;
      }
    }
    l1 = bt.aS(l2);
    ??? = e.a.qFu;
    e.a.qk(l1);
    ??? = e.a.qFu;
    e.a.V(localMap);
    AppMethodBeat.o(167888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.d
 * JD-Core Version:    0.7.0.1
 */