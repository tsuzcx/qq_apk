package com.tencent.mm.plugin.finder.upload;

import android.database.Cursor;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker;", "", "()V", "CHECK_TIME_INTV", "", "REPORT_VERSION", "", "TAG", "", "checkList", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "queuedTask", "", "check", "", "localId", "progress", "checkAndReport", "waitingList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkInfo", "printRemoveList", "removeList", "start", "CheckInfo", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "Finder.FinderPostChecker";
  private static boolean sUg = false;
  private static final List<a> sUh;
  private static final long sUi = 60000L;
  private static final int sUj = 1;
  public static final d sUk;
  
  static
  {
    AppMethodBeat.i(204949);
    sUk = new d();
    TAG = "Finder.FinderPostChecker";
    sUh = (List)new ArrayList();
    sUi = 60000L;
    sUj = 1;
    AppMethodBeat.o(204949);
  }
  
  public final void N(long paramLong, int paramInt)
  {
    AppMethodBeat.i(204948);
    label258:
    for (;;)
    {
      try
      {
        Object localObject1 = sUh.iterator();
        int i = 0;
        int j;
        if (((Iterator)localObject1).hasNext())
        {
          if (((a)((Iterator)localObject1).next()).doE == paramLong)
          {
            j = 1;
            break label258;
            if (i >= 0)
            {
              localObject1 = (a)j.F(sUh, i);
              if (localObject1 != null) {
                ((a)localObject1).progress = paramInt;
              }
              ae.i(TAG, "update check " + paramLong + ", progress:" + paramInt);
              if (!sUg)
              {
                sUg = true;
                localObject1 = new b();
                h.MqF.r((Runnable)localObject1, sUi);
              }
              localObject1 = z.Nhr;
            }
          }
          else
          {
            j = 0;
            break label258;
            i += 1;
          }
        }
        else
        {
          i = -1;
          continue;
        }
        sUh.add(new a(paramLong, paramInt, ch.aDa()));
        ae.i(TAG, "add check " + paramLong + ", progress:" + paramInt);
        continue;
        if (j == 0) {}
      }
      finally
      {
        AppMethodBeat.o(204948);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "", "localId", "", "progress", "", "startCheckTime", "(JIJ)V", "getLocalId", "()J", "getProgress", "()I", "setProgress", "(I)V", "getStartCheckTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    final long doE;
    int progress;
    final long sUl;
    
    public a(long paramLong1, int paramInt, long paramLong2)
    {
      this.doE = paramLong1;
      this.progress = paramInt;
      this.sUl = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.doE != paramObject.doE) || (this.progress != paramObject.progress) || (this.sUl != paramObject.sUl)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.doE;
      int i = (int)(l ^ l >>> 32);
      int j = this.progress;
      l = this.sUl;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204946);
      String str = "CheckInfo(localId=" + this.doE + ", progress=" + this.progress + ", startCheckTime=" + this.sUl + ")";
      AppMethodBeat.o(204946);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderPostChecker$start$task$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(204947);
      synchronized (d.sUk)
      {
        localObject3 = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage();
        ArrayList localArrayList = new ArrayList();
        localObject4 = "SELECT *,localId FROM FinderFeedItem  WHERE " + ((com.tencent.mm.plugin.finder.storage.i)localObject3).sII + " ORDER BY " + ((com.tencent.mm.plugin.finder.storage.i)localObject3).TABLE + ".localId ASC";
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
      Object localObject4 = d.sUk;
      localObject4 = ((Iterable)d.cNh()).iterator();
      d.a locala;
      Object localObject5;
      int i;
      label231:
      int j;
      if (((Iterator)localObject4).hasNext())
      {
        locala = (d.a)((Iterator)localObject4).next();
        long l = locala.doE;
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
        localObject5 = d.sUk;
        d.a((List)localObject3, locala);
        break;
        localObject3 = d.sUk;
        d.dP((List)localObject2);
        localObject3 = d.sUk;
        d.cNh().removeAll((Collection)localObject2);
        localObject2 = d.sUk;
        if (d.cNh().isEmpty())
        {
          localObject2 = d.sUk;
          d.cNj();
        }
        localObject2 = d.sUk;
        if (d.cNi())
        {
          localObject2 = h.MqF;
          localObject3 = (Runnable)this;
          localObject4 = d.sUk;
          ((com.tencent.e.i)localObject2).r((Runnable)localObject3, d.cNk());
        }
        localObject2 = z.Nhr;
        AppMethodBeat.o(204947);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.d
 * JD-Core Version:    0.7.0.1
 */