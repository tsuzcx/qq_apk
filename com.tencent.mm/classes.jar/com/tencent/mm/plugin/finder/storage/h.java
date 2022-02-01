package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ch;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "Lcom/tencent/mm/autogen/table/BaseFinderDraftItem;", "()V", "_finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "finderItem", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "localFlag", "getLocalFlag", "setLocalFlag", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "objectType", "getObjectType", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "info", "", "isFinderFeed", "", "isMvFeed", "Companion", "plugin-finder_release"})
public final class h
  extends ch
{
  public static final a AkG;
  private static final IAutoDBItem.MAutoDBInfo info;
  private FinderItem AkF;
  
  static
  {
    AppMethodBeat.i(287311);
    AkG = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ch.aoY();
    p.j(localMAutoDBInfo, "initAutoDBInfo(FinderDraftItem::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(287311);
  }
  
  public final FinderItem dYm()
  {
    AppMethodBeat.i(287310);
    FinderItem localFinderItem = this.AkF;
    Object localObject = localFinderItem;
    if (localFinderItem == null)
    {
      localObject = FinderItem.Companion;
      localObject = this.field_finderItem;
      p.j(localObject, "field_finderItem");
      localObject = FinderItem.a.a((awh)localObject, this.field_localId);
      this.AkF = ((FinderItem)localObject);
    }
    AppMethodBeat.o(287310);
    return localObject;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "createDraftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "createFinderItem", "draftItem", "createMvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "plugin-finder_release"})
  public static final class a
  {
    public static dbo a(h paramh)
    {
      AppMethodBeat.i(265369);
      p.k(paramh, "draftItem");
      dbo localdbo = new dbo();
      FinderItem localFinderItem = paramh.dYm();
      Object localObject1 = (csg)j.lp((List)localFinderItem.getMediaList());
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((csg)localObject1).url;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localdbo.TIW = ((String)localObject1);
      localdbo.TIV = localFinderItem.getFeedObject();
      localObject1 = localdbo.TIV;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null) {
          ((FinderObjectDesc)localObject1).media = new LinkedList();
        }
      }
      localdbo.TIX = paramh.field_originMvInfo;
      localObject1 = localFinderItem.field_clipList;
      if (localObject1 != null)
      {
        localObject1 = ((csc)localObject1).TzN;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (awh)((Iterator)localObject1).next();
            localdbo.SGC.add(((awh)localObject2).xcx);
          }
        }
      }
      localdbo.localId = paramh.field_localId;
      AppMethodBeat.o(265369);
      return localdbo;
    }
    
    public static h k(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(265367);
      p.k(paramFinderItem, "finderItem");
      h localh = new h();
      localh.field_createTime = paramFinderItem.getCreateTime();
      localh.field_localFlag = 1;
      FinderItem.a locala = FinderItem.Companion;
      localh.field_finderItem = FinderItem.a.m(paramFinderItem);
      localh.field_objectType = 0;
      localh.field_localId = paramFinderItem.getLocalId();
      AppMethodBeat.o(265367);
      return localh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.h
 * JD-Core Version:    0.7.0.1
 */