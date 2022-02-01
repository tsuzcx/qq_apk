package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "Lcom/tencent/mm/autogen/table/BaseFinderDraftItem;", "()V", "_finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "finderItem", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "localFlag", "getLocalFlag", "setLocalFlag", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "objectType", "getObjectType", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "info", "", "isFinderFeed", "", "isMvFeed", "Companion", "plugin-finder_release"})
public final class g
  extends cg
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a vDm;
  private FinderItem vDl;
  
  static
  {
    AppMethodBeat.i(251715);
    vDm = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cg.ajs();
    p.g(localMAutoDBInfo, "initAutoDBInfo(FinderDraftItem::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(251715);
  }
  
  public final FinderItem dxn()
  {
    AppMethodBeat.i(251714);
    FinderItem localFinderItem = this.vDl;
    Object localObject = localFinderItem;
    if (localFinderItem == null)
    {
      localObject = FinderItem.Companion;
      localObject = this.field_finderItem;
      p.g(localObject, "field_finderItem");
      localObject = FinderItem.a.a((aud)localObject, this.field_localId);
      this.vDl = ((FinderItem)localObject);
    }
    AppMethodBeat.o(251714);
    return localObject;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "createDraftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "createFinderItem", "draftItem", "createMvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "plugin-finder_release"})
  public static final class a
  {
    public static csp a(g paramg)
    {
      AppMethodBeat.i(251713);
      p.h(paramg, "draftItem");
      csp localcsp = new csp();
      FinderItem localFinderItem = paramg.dxn();
      Object localObject1 = (cjl)j.kt((List)localFinderItem.getMediaList());
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((cjl)localObject1).url;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localcsp.MxF = ((String)localObject1);
      localcsp.MxE = localFinderItem.getFeedObject();
      localObject1 = localcsp.MxE;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null) {
          ((FinderObjectDesc)localObject1).media = new LinkedList();
        }
      }
      localObject1 = localFinderItem.field_clipList;
      if (localObject1 != null)
      {
        localObject1 = ((cjh)localObject1).MoH;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aud)((Iterator)localObject1).next();
            localcsp.LDi.add(((aud)localObject2).tuO);
          }
        }
      }
      localcsp.localId = paramg.field_localId;
      localcsp.MxG = paramg.field_originMvInfo;
      AppMethodBeat.o(251713);
      return localcsp;
    }
    
    public static g j(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(251712);
      p.h(paramFinderItem, "finderItem");
      g localg = new g();
      localg.field_createTime = paramFinderItem.getCreateTime();
      localg.field_localFlag = 1;
      FinderItem.a locala = FinderItem.Companion;
      localg.field_finderItem = FinderItem.a.l(paramFinderItem);
      localg.field_objectType = 0;
      localg.field_localId = paramFinderItem.getLocalId();
      AppMethodBeat.o(251712);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.g
 * JD-Core Version:    0.7.0.1
 */