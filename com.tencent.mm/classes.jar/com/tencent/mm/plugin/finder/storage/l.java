package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asr;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;)V", "continueFlag", "getContinueFlag", "()Ljava/lang/Object;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "setInfo", "innerList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "getObjectList", "()Ljava/util/List;", "showLeft", "", "getShowLeft", "()Z", "setShowLeft", "(Z)V", "wording", "", "getWording", "()Ljava/lang/String;", "plugin-finder-base_release"})
public final class l
{
  public boolean Alc;
  private final List<BaseFinderFeed> Ald;
  public asr Ale;
  
  public final List<BaseFinderFeed> dYB()
  {
    AppMethodBeat.i(259431);
    Object localObject1 = this.Ale;
    Object localObject2;
    if ((localObject1 != null) && (Util.isNullOrNil(this.Ald)) && (!Util.isNullOrNil((List)((asr)localObject1).wHI)))
    {
      localObject1 = ((asr)localObject1).wHI;
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
            p.j(localObject3, "feed");
            localObject3 = FinderItem.a.b((FinderObject)localObject3, 1);
            ((Collection)localObject1).add(((b)h.ae(b.class)).a((FinderItem)localObject3));
            continue;
            localObject1 = null;
            break;
          }
        }
        localObject1 = (List)localObject1;
        localObject2 = this.Ald;
        if (localObject1 == null) {
          break label288;
        }
      }
    }
    label288:
    for (localObject1 = (Collection)localObject1;; localObject1 = (Collection)v.aaAd)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      localObject1 = this.Ald;
      AppMethodBeat.o(259431);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(259429);
    Object localObject = this.Ale;
    String str;
    if (localObject != null)
    {
      str = ((asr)localObject).wording;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      str = ((f)localObject).aHp().a(ar.a.Vzz, "");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    p.j(localObject, "info?.wording ?: (MMKern…G_STRING_SYNC, \"\") ?: \"\")");
    AppMethodBeat.o(259429);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.l
 * JD-Core Version:    0.7.0.1
 */