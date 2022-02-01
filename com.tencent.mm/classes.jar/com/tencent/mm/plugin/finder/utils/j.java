package com.tencent.mm.plugin.finder.utils;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.r.a;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderFolderClearManager;", "", "()V", "MARK_DEL_FOLDERS", "", "TAG", "fileLock", "Ljava/lang/Object;", "finderUICount", "", "lastDumpTime", "", "checkClearWhenAppInBackground", "", "clearMarkFolder", "dumpAndMark", "enterFinderUI", "exitFinderUI", "mark", "curSize", "folder", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "plugin-finder_release"})
public final class j
{
  static final String TAG = "Finder.FinderFolderClearManager";
  private static long hjF;
  static final Object vSw;
  public static final j vVA;
  static int vVz;
  
  static
  {
    AppMethodBeat.i(167889);
    vVA = new j();
    TAG = "Finder.FinderFolderClearManager";
    vSw = new Object();
    AppForegroundDelegate.djR.a((com.tencent.mm.app.o)new com.tencent.mm.app.o()
    {
      public final void onAppBackground(String arg1)
      {
        AppMethodBeat.i(167887);
        ??? = j.vVA;
        Log.i(j.TAG, "checkClearWhenAppInBackground");
        if (j.vVz <= 0)
        {
          Log.i(j.TAG, "clearMarkFolder");
          synchronized (j.vSw)
          {
            l = Util.currentTicks();
            localObject3 = MultiProcessMMKV.getSingleDefault();
            Set localSet = ((MultiProcessMMKV)localObject3).getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
            if (localSet != null)
            {
              Iterator localIterator = ((Iterable)localSet).iterator();
              while (localIterator.hasNext())
              {
                Object localObject4 = (String)localIterator.next();
                Log.i(j.TAG, "clearMarkFolders ".concat(String.valueOf(localObject4)));
                s.dy((String)localObject4, true);
                al localal = al.waC;
                if (p.j(localObject4, al.dEz()))
                {
                  localObject4 = d.vGR;
                  d.bnU();
                }
              }
            }
          }
          ((MultiProcessMMKV)localObject3).putStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
          Object localObject3 = al.waC;
          localObject3 = al.dEB();
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            localObject3[i].dBE();
            i += 1;
          }
          long l = Util.ticksToNow(l);
          if ((localObject1 != null) && (localObject1.size() > 0))
          {
            localObject2 = r.a.vgH;
            r.a.Fj(l);
          }
          Log.i(j.TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
          Object localObject2 = x.SXb;
          ??? = f.vSz;
          f.dAW();
        }
        AppMethodBeat.o(167887);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    });
    AppMethodBeat.o(167889);
  }
  
  public static void dBG()
  {
    vVz += 1;
  }
  
  public static void dBH()
  {
    int i = vVz - 1;
    vVz = i;
    if (i < 0) {
      vVz = 0;
    }
  }
  
  public static void dBI()
  {
    AppMethodBeat.i(167888);
    Log.i(TAG, "dumpAndMark");
    long l1 = cl.aWy();
    long l2 = hjF;
    Object localObject1 = c.vCb;
    if (l1 - l2 < c.drh())
    {
      AppMethodBeat.o(167888);
      return;
    }
    l2 = Util.currentTicks();
    hjF = l1;
    localObject1 = (Map)new LinkedHashMap();
    ??? = al.waC;
    i[] arrayOfi = al.dEB();
    int j = arrayOfi.length;
    int i = 0;
    while (i < j)
    {
      i locali = arrayOfi[i];
      l1 = ((Number)locali.dBF().second).longValue();
      if ((locali.vVy) && (l1 > locali.maxSize)) {}
      synchronized (vSw)
      {
        Log.i(TAG, "mark: size " + l1 + ", name " + locali.name + ", path " + locali.path);
        MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
        Set localSet = localMultiProcessMMKV.getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
        if (localSet == null) {
          p.hyc();
        }
        localSet.add(locali.path);
        localMultiProcessMMKV.putStringSet("FINDER_MARK_DEL_FOLDERS", localSet).commit();
        ((Map)localObject1).put(locali.name, Long.valueOf(l1));
        i += 1;
      }
    }
    l1 = Util.ticksToNow(l2);
    ??? = r.a.vgH;
    r.a.Fk(l1);
    ??? = r.a.vgH;
    r.a.ai(localMap);
    AppMethodBeat.o(167888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.j
 * JD-Core Version:    0.7.0.1
 */