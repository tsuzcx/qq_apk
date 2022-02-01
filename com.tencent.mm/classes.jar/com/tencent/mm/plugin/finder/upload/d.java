package com.tencent.mm.plugin.finder.upload;

import android.content.Context;
import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.voip.f;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker;", "", "()V", "CHECK_TIME_INTV", "", "REPORT_VERSION", "", "TAG", "", "checkList", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "queuedTask", "", "cameraCheck", "context", "Landroid/content/Context;", "check", "", "localId", "progress", "checkAndReport", "waitingList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkInfo", "printRemoveList", "removeList", "start", "CheckInfo", "plugin-finder_release"})
public final class d
{
  static final String TAG = "Finder.FinderPostChecker";
  static boolean vSp = false;
  static final List<a> vSq;
  static final long vSr = 60000L;
  private static final int vSs = 1;
  public static final d vSt;
  
  static
  {
    AppMethodBeat.i(253067);
    vSt = new d();
    TAG = "Finder.FinderPostChecker";
    vSq = (List)new ArrayList();
    vSr = 60000L;
    vSs = 1;
    AppMethodBeat.o(253067);
  }
  
  public static boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(253066);
    p.h(paramContext, "context");
    if ((f.hy(paramContext)) || (f.cC(paramContext)) || (e.cA(paramContext)) || (a.cD(paramContext)))
    {
      Log.i(TAG, "camera check false");
      AppMethodBeat.o(253066);
      return false;
    }
    AppMethodBeat.o(253066);
    return true;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "", "localId", "", "progress", "", "startCheckTime", "(JIJ)V", "getLocalId", "()J", "getProgress", "()I", "setProgress", "(I)V", "getStartCheckTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    final long localId;
    int progress;
    final long vSu;
    
    public a(long paramLong1, int paramInt, long paramLong2)
    {
      this.localId = paramLong1;
      this.progress = paramInt;
      this.vSu = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.localId != paramObject.localId) || (this.progress != paramObject.progress) || (this.vSu != paramObject.vSu)) {}
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
      l = this.vSu;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(253064);
      String str = "CheckInfo(localId=" + this.localId + ", progress=" + this.progress + ", startCheckTime=" + this.vSu + ")";
      AppMethodBeat.o(253064);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostChecker$start$task$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(253065);
      synchronized (d.vSt)
      {
        localObject3 = ((PluginFinder)g.ah(PluginFinder.class)).getFeedStorage();
        ArrayList localArrayList = new ArrayList();
        localObject4 = "SELECT * FROM FinderFeedItem  WHERE " + ((com.tencent.mm.plugin.finder.storage.l)localObject3).vDJ + " ORDER BY " + ((com.tencent.mm.plugin.finder.storage.l)localObject3).TABLE + ".localId ASC";
        localObject3 = ((com.tencent.mm.plugin.finder.storage.l)localObject3).db.rawQuery((String)localObject4, null, 2);
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = new FinderItem();
          p.g(localObject3, "cr");
          ((FinderItem)localObject4).convertFrom((Cursor)localObject3);
          localArrayList.add(localObject4);
        }
      }
      ((Cursor)localObject3).close();
      Object localObject3 = (List)localObject1;
      Object localObject2 = (List)new ArrayList();
      Object localObject4 = d.vSt;
      localObject4 = ((Iterable)d.dAS()).iterator();
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
        localObject5 = d.vSt;
        d.a((List)localObject3, locala);
        break;
        localObject3 = d.vSt;
        d.ey((List)localObject2);
        localObject3 = d.vSt;
        d.dAS().removeAll((Collection)localObject2);
        localObject2 = d.vSt;
        if (d.dAS().isEmpty())
        {
          localObject2 = d.vSt;
          d.dAU();
        }
        localObject2 = d.vSt;
        if (d.dAT())
        {
          localObject2 = h.RTc;
          localObject3 = (Runnable)this;
          localObject4 = d.vSt;
          ((i)localObject2).o((Runnable)localObject3, d.dAV());
        }
        localObject2 = x.SXb;
        AppMethodBeat.o(253065);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.d
 * JD-Core Version:    0.7.0.1
 */