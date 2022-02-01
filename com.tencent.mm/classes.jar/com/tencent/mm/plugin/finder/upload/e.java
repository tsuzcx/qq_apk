package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.vfs.c;
import com.tencent.mm.vfs.o;
import d.a.v;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostClearTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "call", "", "uniqueId", "plugin-finder_release"})
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
  
  public final String aeW()
  {
    return this.id;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167736);
    Object localObject3 = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().cKY();
    Object localObject1 = f.sUp;
    p.h(localObject3, "unsentObjs");
    Set localSet;
    Object localObject5;
    Object localObject4;
    Object localObject6;
    if (f.cNm())
    {
      com.tencent.mm.sdk.platformtools.ae.i(f.TAG, "checkPostingFolder, unsentSize:" + ((List)localObject3).size());
      f.sUo = ch.aDa();
      try
      {
        localObject1 = r.sYn;
        localObject1 = r.cOy();
        localSet = (Set)new LinkedHashSet();
        localObject5 = o.dh((String)localObject1, false);
        if (localObject5 == null) {
          break label400;
        }
        localObject4 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject5, 10));
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (c)((Iterator)localObject5).next();
          ((Collection)localObject4).add((String)localObject1 + "/" + ((c)localObject6).Itr);
        }
        a(com.tencent.mm.loader.g.j.hiy);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(f.TAG, localThrowable, "checkPostingFolder", new Object[0]);
      }
    }
    else
    {
      AppMethodBeat.o(167736);
      return;
    }
    label400:
    for (Object localObject2 = (List)localObject4;; localObject2 = null)
    {
      if (localObject2 != null) {}
      for (localObject2 = (Collection)localObject2;; localObject2 = (Collection)v.NhH)
      {
        localSet.addAll((Collection)localObject2);
        localObject2 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterable)((FinderItem)((Iterator)localObject2).next()).getMediaList()).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bvz)((Iterator)localObject3).next();
            localObject5 = (Collection)localSet;
            localObject6 = ((bvz)localObject4).url;
            d.g.b.ae.eU(localObject5).remove(localObject6);
            localObject5 = (Collection)localSet;
            localObject4 = ((bvz)localObject4).thumbUrl;
            d.g.b.ae.eU(localObject5).remove(localObject4);
          }
        }
      }
      localObject2 = ((Iterable)localSet).iterator();
      while (((Iterator)localObject2).hasNext()) {
        f.ajJ((String)((Iterator)localObject2).next());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.e
 * JD-Core Version:    0.7.0.1
 */