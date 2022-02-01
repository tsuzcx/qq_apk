package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.item.booleantype.a;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostClearTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "call", "", "uniqueId", "plugin-finder_release"})
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
  
  public final String auK()
  {
    return this.id;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167736);
    Object localObject1 = f.vSz;
    Set localSet;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    if (!f.dAX())
    {
      localObject1 = c.vCb;
      if (!((Boolean)c.dtp().value()).booleanValue()) {}
    }
    else
    {
      Log.i(f.TAG, "FinderFileTrack checkPostingFolder");
      f.vSx = cl.aWy();
      try
      {
        localObject1 = al.waC;
        localObject1 = al.dEH();
        localSet = (Set)new LinkedHashSet();
        localObject4 = s.dC((String)localObject1, false);
        if (localObject4 == null) {
          break label489;
        }
        localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.vfs.e)((Iterator)localObject4).next();
          ((Collection)localObject3).add((String)localObject1 + ((com.tencent.mm.vfs.e)localObject5).name);
        }
        a(com.tencent.mm.loader.g.j.ibw);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace(f.TAG, localThrowable, "checkPostingFolder", new Object[0]);
      }
    }
    AppMethodBeat.o(167736);
    return;
    Object localObject2 = (List)localObject3;
    label195:
    if (localObject2 != null)
    {
      localObject2 = (Collection)localObject2;
      label204:
      localSet.addAll((Collection)localObject2);
      localObject2 = ((Iterable)f.vSy).iterator();
      label224:
      if (!((Iterator)localObject2).hasNext()) {
        break label455;
      }
      localObject3 = (f.a)((Iterator)localObject2).next();
      localObject5 = (Iterable)((f.a)localObject3).dAY();
      localObject4 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject5).iterator();
    }
    label277:
    label455:
    label489:
    label494:
    label497:
    for (;;)
    {
      Object localObject6;
      if (((Iterator)localObject5).hasNext())
      {
        localObject6 = ((Iterator)localObject5).next();
        String str = (String)localObject6;
        if ((str == null) || (!(p.j(str, "") ^ true))) {
          break label494;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label497;
        }
        ((Collection)localObject4).add(localObject6);
        break label277;
        localObject2 = (Collection)v.SXr;
        break label204;
        localObject4 = (List)localObject4;
        localObject5 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (String)((Iterator)localObject5).next();
          Log.i(f.TAG, "ownership, " + ((f.a)localObject3).name() + " owns:" + (String)localObject6);
        }
        af.eV((Collection)localSet).removeAll((Collection)localObject4);
        break label224;
        localObject2 = ((Iterable)localSet).iterator();
        while (((Iterator)localObject2).hasNext()) {
          f.avV((String)((Iterator)localObject2).next());
        }
        break;
        localObject2 = null;
        break label195;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.e
 * JD-Core Version:    0.7.0.1
 */