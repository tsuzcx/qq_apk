package com.tencent.mm.plugin.finder.utils;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.report.o.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderFolderClearManager;", "", "()V", "MARK_DEL_FOLDERS", "", "TAG", "fileLock", "Ljava/lang/Object;", "finderUICount", "", "lastDumpTime", "", "checkClearWhenAppInBackground", "", "clearMarkFolder", "dumpAndMark", "enterFinderUI", "exitFinderUI", "mark", "curSize", "folder", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "plugin-finder_release"})
public final class g
{
  static final String TAG = "Finder.FinderFolderClearManager";
  private static long gwR;
  static final Object sUn;
  static int sWt;
  public static final g sWu;
  
  static
  {
    AppMethodBeat.i(167889);
    sWu = new g();
    TAG = "Finder.FinderFolderClearManager";
    sUn = new Object();
    AppForegroundDelegate.cTA.a((com.tencent.mm.app.o)new com.tencent.mm.app.o()
    {
      public final void onAppBackground(String arg1)
      {
        AppMethodBeat.i(167887);
        ??? = g.sWu;
        ae.i(g.TAG, "checkClearWhenAppInBackground");
        if (g.sWt <= 0)
        {
          ae.i(g.TAG, "clearMarkFolder");
          synchronized (g.sUn)
          {
            l = bu.HQ();
            localObject3 = ay.fpb();
            Set localSet = ((ay)localObject3).getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
            if (localSet != null)
            {
              Iterator localIterator = ((Iterable)localSet).iterator();
              while (localIterator.hasNext())
              {
                Object localObject4 = (String)localIterator.next();
                ae.i(g.TAG, "clearMarkFolders ".concat(String.valueOf(localObject4)));
                com.tencent.mm.vfs.o.dd((String)localObject4, true);
                r localr = r.sYn;
                if (p.i(localObject4, r.cOp()))
                {
                  localObject4 = c.sLt;
                  c.aTi();
                }
              }
            }
          }
          ((ay)localObject3).putStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
          Object localObject3 = r.sYn;
          localObject3 = r.cOr();
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            localObject3[i].cNI();
            i += 1;
          }
          long l = bu.aO(l);
          if ((localObject1 != null) && (localObject1.size() > 0))
          {
            localObject2 = o.a.szY;
            o.a.wM(l);
          }
          ae.i(g.TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
          Object localObject2 = z.Nhr;
          ??? = com.tencent.mm.plugin.finder.upload.f.sUp;
          com.tencent.mm.plugin.finder.upload.f.cNl();
        }
        AppMethodBeat.o(167887);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    });
    AppMethodBeat.o(167889);
  }
  
  public static void cNK()
  {
    sWt += 1;
  }
  
  public static void cNL()
  {
    int i = sWt - 1;
    sWt = i;
    if (i < 0) {
      sWt = 0;
    }
  }
  
  public static void cNM()
  {
    AppMethodBeat.i(167888);
    ae.i(TAG, "dumpAndMark");
    long l1 = ch.aDa();
    long l2 = gwR;
    Object localObject1 = b.sHP;
    if (l1 - l2 < b.cHw())
    {
      AppMethodBeat.o(167888);
      return;
    }
    l2 = bu.HQ();
    gwR = l1;
    localObject1 = (Map)new LinkedHashMap();
    ??? = r.sYn;
    f[] arrayOff = r.cOr();
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      f localf = arrayOff[i];
      l1 = ((Number)localf.cNJ().second).longValue();
      if ((localf.sWs) && (l1 > localf.maxSize)) {}
      synchronized (sUn)
      {
        ae.i(TAG, "mark: size " + l1 + ", name " + localf.name + ", path " + localf.path);
        ay localay = ay.fpb();
        Set localSet = localay.getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
        if (localSet == null) {
          p.gkB();
        }
        localSet.add(localf.path);
        localay.putStringSet("FINDER_MARK_DEL_FOLDERS", localSet).commit();
        ((Map)localObject1).put(localf.name, Long.valueOf(l1));
        i += 1;
      }
    }
    l1 = bu.aO(l2);
    ??? = o.a.szY;
    o.a.wN(l1);
    ??? = o.a.szY;
    o.a.af(localMap);
    AppMethodBeat.o(167888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.g
 * JD-Core Version:    0.7.0.1
 */