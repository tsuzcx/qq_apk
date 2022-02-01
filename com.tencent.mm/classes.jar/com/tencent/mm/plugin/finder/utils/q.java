package com.tencent.mm.plugin.finder.utils;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.publish.f;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderFolderClearManager;", "", "()V", "MARK_DEL_FOLDERS", "", "TAG", "fileLock", "Ljava/lang/Object;", "finderUICount", "", "lastDumpTime", "", "checkClearWhenAppInBackground", "", "clearMarkFolder", "dumpAndMark", "enterFinderUI", "exitFinderUI", "mark", "curSize", "folder", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  static final Object GbG;
  public static final q GgD;
  private static long GgE;
  public static int GgF;
  static final String TAG;
  
  static
  {
    AppMethodBeat.i(167889);
    GgD = new q();
    TAG = "Finder.FinderFolderClearManager";
    GbG = new Object();
    AppForegroundDelegate.heY.a((com.tencent.mm.app.q)new com.tencent.mm.app.q()
    {
      public final void onAppBackground(String arg1)
      {
        AppMethodBeat.i(167887);
        ??? = q.GgD;
        Log.i(q.TAG, "checkClearWhenAppInBackground");
        if (q.GgF <= 0)
        {
          Log.i(q.TAG, "clearMarkFolder");
          synchronized (q.GbG)
          {
            l = Util.currentTicks();
            localObject2 = MultiProcessMMKV.getSingleDefault();
            Set localSet = ((MultiProcessMMKV)localObject2).getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
            if (localSet != null)
            {
              Iterator localIterator = ((Iterable)localSet).iterator();
              while (localIterator.hasNext())
              {
                Object localObject3 = (String)localIterator.next();
                Log.i(q.TAG, s.X("clearMarkFolders ", localObject3));
                y.ew((String)localObject3, true);
                bm localbm = bm.GlZ;
                if (s.p(localObject3, bm.fik()))
                {
                  localObject3 = e.FNF;
                  e.bwy();
                }
              }
            }
          }
          ((MultiProcessMMKV)localObject2).putStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
          Object localObject2 = bm.GlZ;
          localObject2 = bm.fin();
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            localObject2[i].feO();
            i += 1;
          }
          long l = Util.ticksToNow(l);
          if ((localObject1 != null) && (localObject1.size() > 0)) {
            ((c)h.az(c.class)).publishStatApi().ps(l);
          }
          Log.i(q.TAG, s.X("clearMarkFolder cost:", Long.valueOf(l)));
          ah localah = ah.aiuX;
          ((c)h.az(c.class)).publishPostApi().eLa();
        }
        AppMethodBeat.o(167887);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    });
    AppMethodBeat.o(167889);
  }
  
  public static void feQ()
  {
    AppMethodBeat.i(167888);
    Log.i(TAG, "dumpAndMark");
    long l1 = cn.bDu();
    long l2 = GgE;
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (l1 - l2 < com.tencent.mm.plugin.finder.storage.d.eQJ())
    {
      AppMethodBeat.o(167888);
      return;
    }
    l2 = Util.currentTicks();
    GgE = l1;
    localObject1 = (Map)new LinkedHashMap();
    ??? = bm.GlZ;
    p[] arrayOfp = bm.fin();
    int j = arrayOfp.length;
    int i = 0;
    for (;;)
    {
      p localp;
      if (i < j)
      {
        localp = arrayOfp[i];
        l1 = ((Number)localp.feP().bsD).longValue();
        if ((!localp.GgC) || (l1 <= localp.cBA)) {}
      }
      synchronized (GbG)
      {
        Log.i(TAG, "mark: size " + l1 + ", name " + localp.name + ", path " + localp.path);
        MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
        Set localSet = localMultiProcessMMKV.getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
        s.checkNotNull(localSet);
        localSet.add(localp.path);
        localMultiProcessMMKV.putStringSet("FINDER_MARK_DEL_FOLDERS", localSet).commit();
        ((Map)localObject1).put(localp.name, Long.valueOf(l1));
        i += 1;
      }
    }
    ((c)h.az(c.class)).publishStatApi().ao(localMap);
    AppMethodBeat.o(167888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.q
 * JD-Core Version:    0.7.0.1
 */