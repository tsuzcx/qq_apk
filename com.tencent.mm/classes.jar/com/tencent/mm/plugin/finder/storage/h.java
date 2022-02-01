package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.a.j;
import d.a.v;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;)V", "continueFlag", "getContinueFlag", "()Ljava/lang/Object;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "setInfo", "innerList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "getObjectList", "()Ljava/util/List;", "wording", "", "getWording", "()Ljava/lang/String;", "plugin-finder_release"})
public final class h
{
  private final List<BaseFinderFeed> sIG;
  public anf sIH;
  
  public h(anf paramanf)
  {
    AppMethodBeat.i(204225);
    this.sIH = paramanf;
    this.sIG = ((List)new ArrayList());
    AppMethodBeat.o(204225);
  }
  
  public final List<BaseFinderFeed> cKW()
  {
    AppMethodBeat.i(204224);
    Object localObject1 = this.sIH;
    Object localObject2;
    if ((localObject1 != null) && (bu.ht(this.sIG)) && (!bu.ht((List)((anf)localObject1).rBY)))
    {
      localObject1 = ((anf)localObject1).rBY;
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
            localObject4 = FinderItem.sJb;
            p.g(localObject3, "feed");
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 1);
            localObject4 = b.sLq;
            ((Collection)localObject1).add(b.a.j((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.sIG;
        if (localObject1 == null) {
          break label283;
        }
      }
    }
    label283:
    for (localObject1 = (Collection)localObject1;; localObject1 = (Collection)v.NhH)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.sIG;
      AppMethodBeat.o(204224);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(204223);
    Object localObject = this.sIH;
    String str;
    if (localObject != null)
    {
      str = ((anf)localObject).dyI;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      str = ((e)localObject).ajA().a(am.a.JbE, "");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    p.g(localObject, "info?.wording ?: (MMKern…G_STRING_SYNC, \"\") ?: \"\")");
    AppMethodBeat.o(204223);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.h
 * JD-Core Version:    0.7.0.1
 */