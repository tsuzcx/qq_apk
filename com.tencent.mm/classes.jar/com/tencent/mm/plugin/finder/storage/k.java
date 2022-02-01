package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;)V", "continueFlag", "getContinueFlag", "()Ljava/lang/Object;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "setInfo", "innerList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "getObjectList", "()Ljava/util/List;", "showLeft", "", "getShowLeft", "()Z", "setShowLeft", "(Z)V", "wording", "", "getWording", "()Ljava/lang/String;", "plugin-finder_release"})
public final class k
{
  public boolean vDG;
  private final List<BaseFinderFeed> vDH;
  public aqv vDI;
  
  public k(aqv paramaqv)
  {
    AppMethodBeat.i(251726);
    this.vDI = paramaqv;
    this.vDG = true;
    this.vDH = ((List)new ArrayList());
    AppMethodBeat.o(251726);
  }
  
  public final List<BaseFinderFeed> dxB()
  {
    AppMethodBeat.i(251725);
    Object localObject1 = this.vDI;
    Object localObject2;
    if ((localObject1 != null) && (Util.isNullOrNil(this.vDH)) && (!Util.isNullOrNil((List)((aqv)localObject1).tbD)))
    {
      localObject1 = ((aqv)localObject1).tbD;
      Object localObject3;
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = (Iterable)localObject1;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject1).iterator();
        label131:
        label134:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject1 = (FinderObject)localObject4;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).objectDesc;
            label104:
            if (localObject1 == null) {
              break label131;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label134;
            }
            ((Collection)localObject2).add(localObject4);
            break;
            localObject1 = null;
            break label104;
          }
        }
        localObject1 = (List)localObject2;
      }
      while (localObject1 != null)
      {
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject4 = FinderItem.Companion;
            p.g(localObject3, "feed");
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 1);
            localObject4 = c.vGN;
            ((Collection)localObject1).add(c.a.s((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.vDH;
        if (localObject1 == null) {
          break label283;
        }
      }
    }
    label283:
    for (localObject1 = (Collection)localObject1;; localObject1 = (Collection)v.SXr)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.vDH;
      AppMethodBeat.o(251725);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(251724);
    Object localObject = this.vDI;
    String str;
    if (localObject != null)
    {
      str = ((aqv)localObject).dQx;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      str = ((e)localObject).azQ().a(ar.a.OkE, "");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    p.g(localObject, "info?.wording ?: (MMKern…G_STRING_SYNC, \"\") ?: \"\")");
    AppMethodBeat.o(251724);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.k
 * JD-Core Version:    0.7.0.1
 */