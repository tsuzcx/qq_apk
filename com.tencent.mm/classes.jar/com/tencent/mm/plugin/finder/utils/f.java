package com.tencent.mm.plugin.finder.utils;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.report.i.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.o;
import d.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderFolderClearManager;", "", "()V", "MARK_DEL_FOLDERS", "", "TAG", "fileLock", "Ljava/lang/Object;", "finderUICount", "", "lastDumpTime", "", "checkClearWhenAppInBackground", "", "clearMarkFolder", "dumpAndMark", "enterFinderUI", "exitFinderUI", "mark", "curSize", "folder", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "plugin-finder_release"})
public final class f
{
  static final String TAG = "Finder.FinderFolderClearManager";
  private static long gat;
  static final Object rMV;
  static int rOM;
  public static final f rON;
  
  static
  {
    AppMethodBeat.i(167889);
    rON = new f();
    TAG = "Finder.FinderFolderClearManager";
    rMV = new Object();
    AppForegroundDelegate.cHM.a((n)new n()
    {
      public final void onAppBackground(String arg1)
      {
        AppMethodBeat.i(167887);
        ??? = f.rON;
        ac.i(f.TAG, "checkClearWhenAppInBackground");
        if (f.rOM <= 0)
        {
          ac.i(f.TAG, "clearMarkFolder");
          synchronized (f.rMV)
          {
            l = bs.Gn();
            localObject3 = aw.eVz();
            Set localSet = ((aw)localObject3).getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
            if (localSet != null)
            {
              Iterator localIterator = ((Iterable)localSet).iterator();
              while (localIterator.hasNext())
              {
                Object localObject4 = (String)localIterator.next();
                ac.i(f.TAG, "clearMarkFolders ".concat(String.valueOf(localObject4)));
                i.cU((String)localObject4, true);
                p localp = p.rQw;
                if (k.g(localObject4, p.cDn()))
                {
                  localObject4 = c.rFo;
                  c.aPx();
                }
              }
            }
          }
          ((aw)localObject3).putStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
          Object localObject3 = p.rQw;
          localObject3 = p.cDp();
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            localObject3[i].cCN();
            i += 1;
          }
          long l = bs.aO(l);
          if ((localObject1 != null) && (localObject1.size() > 0))
          {
            localObject2 = i.a.ryn;
            i.a.uu(l);
          }
          ac.i(f.TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
          Object localObject2 = y.KTp;
          ??? = com.tencent.mm.plugin.finder.upload.e.rMX;
          com.tencent.mm.plugin.finder.upload.e.cCs();
        }
        AppMethodBeat.o(167887);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    });
    AppMethodBeat.o(167889);
  }
  
  public static void cCP()
  {
    rOM += 1;
  }
  
  public static void cCQ()
  {
    int i = rOM - 1;
    rOM = i;
    if (i < 0) {
      rOM = 0;
    }
  }
  
  public static void cCR()
  {
    AppMethodBeat.i(167888);
    ac.i(TAG, "dumpAndMark");
    long l1 = ce.azH();
    long l2 = gat;
    Object localObject1 = b.rCU;
    if (l1 - l2 < b.cyz())
    {
      AppMethodBeat.o(167888);
      return;
    }
    l2 = bs.Gn();
    gat = l1;
    localObject1 = (Map)new LinkedHashMap();
    ??? = p.rQw;
    e[] arrayOfe = p.cDp();
    int j = arrayOfe.length;
    int i = 0;
    while (i < j)
    {
      e locale = arrayOfe[i];
      l1 = ((Number)locale.cCO().second).longValue();
      if ((locale.rOL) && (l1 > locale.maxSize)) {}
      synchronized (rMV)
      {
        ac.i(TAG, "mark: size " + l1 + ", name " + locale.name + ", path " + locale.path);
        aw localaw = aw.eVz();
        Set localSet = localaw.getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
        if (localSet == null) {
          k.fOy();
        }
        localSet.add(locale.path);
        localaw.putStringSet("FINDER_MARK_DEL_FOLDERS", localSet).commit();
        ((Map)localObject1).put(locale.name, Long.valueOf(l1));
        i += 1;
      }
    }
    l1 = bs.aO(l2);
    ??? = i.a.ryn;
    i.a.uv(l1);
    ??? = i.a.ryn;
    i.a.W(localMap);
    AppMethodBeat.o(167888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.f
 * JD-Core Version:    0.7.0.1
 */