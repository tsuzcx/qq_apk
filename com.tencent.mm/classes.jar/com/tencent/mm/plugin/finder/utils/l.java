package com.tencent.mm.plugin.finder.utils;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.report.v.a;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderFolderClearManager;", "", "()V", "MARK_DEL_FOLDERS", "", "TAG", "fileLock", "Ljava/lang/Object;", "finderUICount", "", "lastDumpTime", "", "checkClearWhenAppInBackground", "", "clearMarkFolder", "dumpAndMark", "enterFinderUI", "exitFinderUI", "mark", "curSize", "folder", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "plugin-finder_release"})
public final class l
{
  static int ADt = 0;
  public static final l ADu;
  static final Object AzW;
  static final String TAG = "Finder.FinderFolderClearManager";
  private static long jVv;
  
  static
  {
    AppMethodBeat.i(167889);
    ADu = new l();
    TAG = "Finder.FinderFolderClearManager";
    AzW = new Object();
    AppForegroundDelegate.fby.a((com.tencent.mm.app.o)new com.tencent.mm.app.o()
    {
      public final void onAppBackground(String arg1)
      {
        AppMethodBeat.i(167887);
        ??? = l.ADu;
        Log.i(l.TAG, "checkClearWhenAppInBackground");
        if (l.ADt <= 0)
        {
          Log.i(l.TAG, "clearMarkFolder");
          synchronized (l.AzW)
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
                Log.i(l.TAG, "clearMarkFolders ".concat(String.valueOf(localObject4)));
                u.dK((String)localObject4, true);
                av localav = av.AJz;
                if (p.h(localObject4, av.egm()))
                {
                  localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
                  com.tencent.mm.plugin.finder.storage.logic.d.byd();
                }
              }
            }
          }
          ((MultiProcessMMKV)localObject3).putStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
          Object localObject3 = av.AJz;
          localObject3 = av.ego();
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            localObject3[i].ecR();
            i += 1;
          }
          long l = Util.ticksToNow(l);
          if ((localObject1 != null) && (localObject1.size() > 0))
          {
            localObject2 = v.a.zXP;
            v.a.Ms(l);
          }
          Log.i(l.TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
          Object localObject2 = x.aazN;
          ??? = f.AzZ;
          f.ecf();
        }
        AppMethodBeat.o(167887);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    });
    AppMethodBeat.o(167889);
  }
  
  public static void ecT()
  {
    ADt += 1;
  }
  
  public static void ecU()
  {
    int i = ADt - 1;
    ADt = i;
    if (i < 0) {
      ADt = 0;
    }
  }
  
  public static void ecV()
  {
    AppMethodBeat.i(167888);
    Log.i(TAG, "dumpAndMark");
    long l1 = cm.bfC();
    long l2 = jVv;
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (l1 - l2 < com.tencent.mm.plugin.finder.storage.d.dSv())
    {
      AppMethodBeat.o(167888);
      return;
    }
    l2 = Util.currentTicks();
    jVv = l1;
    localObject1 = (Map)new LinkedHashMap();
    ??? = av.AJz;
    k[] arrayOfk = av.ego();
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      k localk = arrayOfk[i];
      l1 = ((Number)localk.ecS().My).longValue();
      if ((localk.ADs) && (l1 > localk.aFQ)) {}
      synchronized (AzW)
      {
        Log.i(TAG, "mark: size " + l1 + ", name " + localk.name + ", path " + localk.path);
        MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
        Set localSet = localMultiProcessMMKV.getStringSet("FINDER_MARK_DEL_FOLDERS", (Set)new HashSet());
        if (localSet == null) {
          p.iCn();
        }
        localSet.add(localk.path);
        localMultiProcessMMKV.putStringSet("FINDER_MARK_DEL_FOLDERS", localSet).commit();
        ((Map)localObject1).put(localk.name, Long.valueOf(l1));
        i += 1;
      }
    }
    l1 = Util.ticksToNow(l2);
    ??? = v.a.zXP;
    v.a.Mt(l1);
    ??? = v.a.zXP;
    v.a.ab(localMap);
    AppMethodBeat.o(167888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.l
 * JD-Core Version:    0.7.0.1
 */