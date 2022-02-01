package com.tencent.mm.plugin.finder.upload;

import android.database.Cursor;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.e.e;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker;", "", "()V", "CHECK_TIME_INTV", "", "TAG", "", "checkList", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "queuedTask", "", "check", "", "localId", "progress", "", "checkAndReport", "waitingList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkInfo", "match", "it", "printRemoveList", "removeList", "start", "CheckInfo", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "Finder.FinderPostChecker";
  private static boolean sIU = false;
  private static final List<a> sIV;
  private static final long sIW = 60000L;
  public static final d sIX;
  
  static
  {
    AppMethodBeat.i(204331);
    sIX = new d();
    TAG = "Finder.FinderPostChecker";
    sIV = (List)new ArrayList();
    sIW = 60000L;
    AppMethodBeat.o(204331);
  }
  
  public final void N(long paramLong, int paramInt)
  {
    AppMethodBeat.i(204330);
    try
    {
      sIV.add(new a(paramLong, paramInt, cf.aCK()));
      if (!sIU)
      {
        sIU = true;
        localObject1 = new b();
        h.LTJ.r((Runnable)localObject1, sIW);
      }
      Object localObject1 = z.MKo;
      return;
    }
    finally
    {
      AppMethodBeat.o(204330);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "", "localId", "", "progress", "", "startCheckTime", "(JIJ)V", "getLocalId", "()J", "getProgress", "()I", "getStartCheckTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    final long dnz;
    final int progress;
    final long sIY;
    
    public a(long paramLong1, int paramInt, long paramLong2)
    {
      this.dnz = paramLong1;
      this.progress = paramInt;
      this.sIY = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.dnz != paramObject.dnz) || (this.progress != paramObject.progress) || (this.sIY != paramObject.sIY)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.dnz;
      int i = (int)(l ^ l >>> 32);
      int j = this.progress;
      l = this.sIY;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204328);
      String str = "CheckInfo(localId=" + this.dnz + ", progress=" + this.progress + ", startCheckTime=" + this.sIY + ")";
      AppMethodBeat.o(204328);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderPostChecker$start$task$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(204329);
      synchronized (d.sIX)
      {
        localObject3 = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage();
        ArrayList localArrayList = new ArrayList();
        localObject4 = "SELECT *,localId FROM FinderFeedItem  WHERE " + ((com.tencent.mm.plugin.finder.storage.i)localObject3).sxR + " ORDER BY " + ((com.tencent.mm.plugin.finder.storage.i)localObject3).TABLE + ".localId ASC";
        localObject3 = ((com.tencent.mm.plugin.finder.storage.i)localObject3).db.a((String)localObject4, null, 2);
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
      Object localObject4 = d.sIX;
      localObject4 = ((Iterable)d.cKD()).iterator();
      d.a locala;
      long l;
      Object localObject5;
      int i;
      label231:
      int j;
      if (((Iterator)localObject4).hasNext())
      {
        locala = (d.a)((Iterator)localObject4).next();
        l = locala.dnz;
        localObject5 = ((List)localObject3).iterator();
        i = 0;
        if (!((Iterator)localObject5).hasNext()) {
          break label423;
        }
        if (((FinderItem)((Iterator)localObject5).next()).getLocalId() != l) {
          break label411;
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
        localObject5 = d.sIX;
        d.a((List)localObject3, l, locala);
        break;
        localObject3 = d.sIX;
        d.dL((List)localObject2);
        localObject3 = d.sIX;
        d.cKD().removeAll((Collection)localObject2);
        localObject2 = d.sIX;
        if (d.cKD().isEmpty())
        {
          localObject2 = d.sIX;
          d.cKF();
        }
        localObject2 = d.sIX;
        if (d.cKE())
        {
          localObject2 = h.LTJ;
          localObject3 = (Runnable)this;
          localObject4 = d.sIX;
          ((com.tencent.e.i)localObject2).r((Runnable)localObject3, d.cKG());
        }
        localObject2 = z.MKo;
        AppMethodBeat.o(204329);
        return;
        for (;;)
        {
          if (j == 0) {
            break label416;
          }
          break;
          label411:
          j = 0;
        }
        label416:
        i += 1;
        break label231;
        label423:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.d
 * JD-Core Version:    0.7.0.1
 */