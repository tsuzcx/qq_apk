package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.a.v;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;)V", "continueFlag", "getContinueFlag", "()Ljava/lang/Object;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "setInfo", "innerList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "getObjectList", "()Ljava/util/List;", "wording", "", "getWording", "()Ljava/lang/String;", "plugin-finder_release"})
public final class h
{
  public final String dxD;
  public final com.tencent.mm.bx.b lastBuffer;
  private final Object sxO;
  private final List<BaseFinderFeed> sxP;
  public amt sxQ;
  
  public h(amt paramamt)
  {
    AppMethodBeat.i(203658);
    this.sxQ = paramamt;
    paramamt = this.sxQ;
    Object localObject;
    if (paramamt != null)
    {
      localObject = paramamt.lastBuffer;
      paramamt = (amt)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramamt = null;
    }
    this.lastBuffer = paramamt;
    paramamt = this.sxQ;
    if (paramamt != null) {}
    for (paramamt = Integer.valueOf(paramamt.continueFlag);; paramamt = Boolean.FALSE)
    {
      this.sxO = paramamt;
      paramamt = this.sxQ;
      if (paramamt != null)
      {
        localObject = paramamt.dxD;
        paramamt = (amt)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramamt = "";
      }
      this.dxD = paramamt;
      this.sxP = ((List)new ArrayList());
      AppMethodBeat.o(203658);
      return;
    }
  }
  
  public final List<BaseFinderFeed> cIr()
  {
    AppMethodBeat.i(203657);
    Object localObject1 = this.sxQ;
    Object localObject2;
    if ((localObject1 != null) && (bt.hj(this.sxP)) && (!bt.hj((List)((amt)localObject1).rtM)))
    {
      localObject1 = ((amt)localObject1).rtM;
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
            localObject4 = FinderItem.syk;
            p.g(localObject3, "feed");
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 1);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            ((Collection)localObject1).add(b.a.j((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.sxP;
        if (localObject1 == null) {
          break label283;
        }
      }
    }
    label283:
    for (localObject1 = (Collection)localObject1;; localObject1 = (Collection)v.MKE)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.sxP;
      AppMethodBeat.o(203657);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.h
 * JD-Core Version:    0.7.0.1
 */