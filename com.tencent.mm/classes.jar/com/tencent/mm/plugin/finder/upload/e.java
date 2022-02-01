package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.FileSystem.a;
import d.a.v;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderPostClearTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "call", "", "uniqueId", "plugin-finder_release"})
public final class e
  extends h
{
  private final String id;
  
  public e(String paramString)
  {
    super(new FinderItem());
    AppMethodBeat.i(167737);
    this.id = paramString;
    AppMethodBeat.o(167737);
  }
  
  public final String aeK()
  {
    return this.id;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167736);
    Object localObject3 = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().cIt();
    Object localObject1 = f.sJc;
    p.h(localObject3, "unsentObjs");
    Set localSet;
    Object localObject4;
    if (f.cKI())
    {
      ad.i(f.TAG, "checkPostingFolder, unsentSize:" + ((List)localObject3).size());
      f.sJb = cf.aCK();
      try
      {
        localObject1 = r.sNc;
        localObject1 = r.cLQ();
        localSet = (Set)new LinkedHashSet();
        Object localObject5 = com.tencent.mm.vfs.i.de((String)localObject1, false);
        if (localObject5 == null) {
          break label372;
        }
        localObject4 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject5, 10));
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          FileSystem.a locala = (FileSystem.a)((Iterator)localObject5).next();
          ((Collection)localObject4).add((String)localObject1 + "/" + locala.HZk);
        }
        a(com.tencent.mm.loader.g.j.hfK);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace(f.TAG, localThrowable, "checkPostingFolder", new Object[0]);
      }
    }
    else
    {
      AppMethodBeat.o(167736);
      return;
    }
    label372:
    for (Object localObject2 = (List)localObject4;; localObject2 = null)
    {
      if (localObject2 != null) {}
      for (localObject2 = (Collection)localObject2;; localObject2 = (Collection)v.MKE)
      {
        localSet.addAll((Collection)localObject2);
        localObject2 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterable)((FinderItem)((Iterator)localObject2).next()).getMediaList()).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bvf)((Iterator)localObject3).next();
            localSet.remove(((bvf)localObject4).url);
            localSet.remove(((bvf)localObject4).thumbUrl);
          }
        }
      }
      localObject2 = ((Iterable)localSet).iterator();
      while (((Iterator)localObject2).hasNext()) {
        f.aiM((String)((Iterator)localObject2).next());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.e
 * JD-Core Version:    0.7.0.1
 */