package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderPostClearTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "call", "", "uniqueId", "plugin-finder_release"})
public final class d
  extends g
{
  private final String id;
  
  public d(String paramString)
  {
    super(new FinderItem());
    AppMethodBeat.i(167737);
    this.id = paramString;
    AppMethodBeat.o(167737);
  }
  
  public final String acg()
  {
    return this.id;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167736);
    Object localObject3 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().cAy();
    Object localObject1 = e.rMX;
    k.h(localObject3, "unsentObjs");
    Set localSet;
    Object localObject4;
    if (e.cCt())
    {
      ac.i(e.TAG, "checkPostingFolder, unsentSize:" + ((List)localObject3).size());
      e.rMW = ce.azH();
      try
      {
        localObject1 = p.rQw;
        localObject1 = p.cDw();
        localSet = (Set)new LinkedHashSet();
        Object localObject5 = i.cZ((String)localObject1, false);
        if (localObject5 == null) {
          break label372;
        }
        localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          FileSystem.a locala = (FileSystem.a)((Iterator)localObject5).next();
          ((Collection)localObject4).add((String)localObject1 + "/" + locala.Gnx);
        }
        a(h.gLN);
      }
      catch (Throwable localThrowable)
      {
        ac.printErrStackTrace(e.TAG, localThrowable, "checkPostingFolder", new Object[0]);
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
      for (localObject2 = (Collection)localObject2;; localObject2 = (Collection)v.KTF)
      {
        localSet.addAll((Collection)localObject2);
        localObject2 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterable)((FinderItem)((Iterator)localObject2).next()).getMediaList()).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bqs)((Iterator)localObject3).next();
            localSet.remove(((bqs)localObject4).url);
            localSet.remove(((bqs)localObject4).thumbUrl);
          }
        }
      }
      localObject2 = ((Iterable)localSet).iterator();
      while (((Iterator)localObject2).hasNext()) {
        e.aes((String)((Iterator)localObject2).next());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.d
 * JD-Core Version:    0.7.0.1
 */