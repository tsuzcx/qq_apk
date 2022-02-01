package com.tencent.mm.plugin.finder.upload;

import android.content.Context;
import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.voip.f;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker;", "", "()V", "CHECK_TIME_INTV", "", "REPORT_VERSION", "", "TAG", "", "checkList", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "queuedTask", "", "cameraCheck", "context", "Landroid/content/Context;", "check", "", "localId", "progress", "checkAndReport", "waitingList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkInfo", "printRemoveList", "removeList", "start", "CheckInfo", "plugin-finder_release"})
public final class d
{
  static boolean AzP = false;
  static final List<a> AzQ;
  static final long AzR = 60000L;
  private static final int AzS = 1;
  public static final d AzT;
  static final String TAG = "Finder.FinderPostChecker";
  
  static
  {
    AppMethodBeat.i(287533);
    AzT = new d();
    TAG = "Finder.FinderPostChecker";
    AzQ = (List)new ArrayList();
    AzR = 60000L;
    AzS = 1;
    AppMethodBeat.o(287533);
  }
  
  public static boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(287532);
    p.k(paramContext, "context");
    if ((f.iE(paramContext)) || (f.cy(paramContext)) || (e.cw(paramContext)) || (a.cA(paramContext)))
    {
      Log.i(TAG, "camera check false");
      AppMethodBeat.o(287532);
      return false;
    }
    AppMethodBeat.o(287532);
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "", "localId", "", "progress", "", "startCheckTime", "(JIJ)V", "getLocalId", "()J", "getProgress", "()I", "setProgress", "(I)V", "getStartCheckTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    final long AzU;
    final long localId;
    int progress;
    
    public a(long paramLong1, int paramInt, long paramLong2)
    {
      this.localId = paramLong1;
      this.progress = paramInt;
      this.AzU = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.localId != paramObject.localId) || (this.progress != paramObject.progress) || (this.AzU != paramObject.AzU)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.localId;
      int i = (int)(l ^ l >>> 32);
      int j = this.progress;
      l = this.AzU;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(289714);
      String str = "CheckInfo(localId=" + this.localId + ", progress=" + this.progress + ", startCheckTime=" + this.AzU + ")";
      AppMethodBeat.o(289714);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostChecker$start$task$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(282961);
      synchronized (d.AzT)
      {
        localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage();
        ArrayList localArrayList = new ArrayList();
        localObject4 = "SELECT * FROM FinderFeedItem  WHERE " + ((m)localObject3).Alg + " ORDER BY " + ((m)localObject3).Alf + ".localId ASC";
        localObject3 = ((m)localObject3).db.rawQuery((String)localObject4, null, 2);
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = new FinderItem();
          p.j(localObject3, "cr");
          ((FinderItem)localObject4).convertFrom((Cursor)localObject3);
          localArrayList.add(localObject4);
        }
      }
      ((Cursor)localObject3).close();
      Object localObject3 = (List)localObject1;
      Object localObject2 = (List)new ArrayList();
      Object localObject4 = d.AzT;
      localObject4 = ((Iterable)d.ecb()).iterator();
      d.a locala;
      Object localObject5;
      int i;
      label231:
      int j;
      if (((Iterator)localObject4).hasNext())
      {
        locala = (d.a)((Iterator)localObject4).next();
        long l = locala.localId;
        localObject5 = ((List)localObject3).iterator();
        i = 0;
        if (!((Iterator)localObject5).hasNext()) {
          break label422;
        }
        if (((FinderItem)((Iterator)localObject5).next()).getLocalId() != l) {
          break label410;
        }
        j = 1;
      }
      for (;;)
      {
        if (i < 0)
        {
          ((List)localObject2).add(locala);
          break;
        }
        localObject5 = d.AzT;
        d.a((List)localObject3, locala);
        break;
        localObject3 = d.AzT;
        d.eT((List)localObject2);
        localObject3 = d.AzT;
        d.ecb().removeAll((Collection)localObject2);
        localObject2 = d.AzT;
        if (d.ecb().isEmpty())
        {
          localObject2 = d.AzT;
          d.ecd();
        }
        localObject2 = d.AzT;
        if (d.ecc())
        {
          localObject2 = com.tencent.e.h.ZvG;
          localObject3 = (Runnable)this;
          localObject4 = d.AzT;
          ((i)localObject2).o((Runnable)localObject3, d.ece());
        }
        localObject2 = x.aazN;
        AppMethodBeat.o(282961);
        return;
        for (;;)
        {
          if (j == 0) {
            break label415;
          }
          break;
          label410:
          j = 0;
        }
        label415:
        i += 1;
        break label231;
        label422:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.d
 * JD-Core Version:    0.7.0.1
 */