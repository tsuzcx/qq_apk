package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cm;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "Lcom/tencent/mm/autogen/table/BaseFinderDraftItem;", "()V", "_finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "finderItem", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "localFlag", "getLocalFlag", "setLocalFlag", "", "localId", "getLocalId", "()J", "setLocalId", "(J)V", "objectType", "getObjectType", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "info", "", "isFinderFeed", "", "isMvFeed", "isOriginalDraft", "isPostFailed", "isPostFinish", "isPostOk", "logInfo", "prepareToSaveDb", "", "setPostFailed", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends cm
{
  public static final a FKa;
  private static final IAutoDBItem.MAutoDBInfo info;
  private FinderItem FKb;
  
  static
  {
    AppMethodBeat.i(339209);
    FKa = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cm.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(FinderDraftItem::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(339209);
  }
  
  public final FinderItem eYK()
  {
    AppMethodBeat.i(339214);
    FinderItem localFinderItem = this.FKb;
    Object localObject = localFinderItem;
    if (localFinderItem == null)
    {
      localObject = FinderItem.Companion;
      localObject = this.field_finderItem;
      s.s(localObject, "field_finderItem");
      localObject = FinderItem.a.a((bby)localObject, this.field_localId);
      this.FKb = ((FinderItem)localObject);
    }
    AppMethodBeat.o(339214);
    return localObject;
  }
  
  public final boolean eYL()
  {
    AppMethodBeat.i(339231);
    int i = this.field_dbversion;
    b.a locala = b.FNy;
    if (i == b.fap())
    {
      AppMethodBeat.o(339231);
      return true;
    }
    AppMethodBeat.o(339231);
    return false;
  }
  
  public final void eYM()
  {
    AppMethodBeat.i(339242);
    Object localObject = this.FKb;
    if (localObject != null)
    {
      FinderItem.a locala = FinderItem.Companion;
      this.field_finderItem = FinderItem.a.r((FinderItem)localObject);
    }
    localObject = b.FNy;
    this.field_dbversion = b.fao();
    AppMethodBeat.o(339242);
  }
  
  public final String eYN()
  {
    AppMethodBeat.i(339245);
    String str = "localId:" + this.field_localId + ", objectId:" + this.field_objectId + ", version:" + this.field_version + ", markDeleted:" + this.field_markDeleted;
    AppMethodBeat.o(339245);
    return str;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean isMvFeed()
  {
    return this.field_objectType == 2;
  }
  
  public final boolean isPostFailed()
  {
    return (this.field_localFlag & 0x2) != 0;
  }
  
  public final void o(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(339220);
    s.u(paramFinderItem, "value");
    this.FKb = paramFinderItem;
    AppMethodBeat.o(339220);
  }
  
  public final void setPostFailed()
  {
    this.field_localFlag |= 0x2;
    this.field_localFlag &= 0xFFFFFFFE;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "createDraftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "createFinderItem", "draftItem", "createMvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static dtf d(i parami)
    {
      AppMethodBeat.i(339138);
      s.u(parami, "draftItem");
      dtf localdtf = new dtf();
      FinderItem localFinderItem = parami.eYK();
      Object localObject1 = (dji)p.oL((List)localFinderItem.getMediaList());
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject2 = (dji)p.oL((List)localFinderItem.getMediaList());
        if (localObject2 != null) {
          break label208;
        }
        localObject2 = "";
        label70:
        localdtf.aaYL = s.X((String)localObject1, localObject2);
        localdtf.aaYK = localFinderItem.getFeedObject();
        localObject1 = localdtf.aaYK;
        if (localObject1 != null) {
          break label225;
        }
      }
      label208:
      label225:
      for (localObject1 = null;; localObject1 = ((FinderObject)localObject1).objectDesc)
      {
        if (localObject1 != null) {
          ((FinderObjectDesc)localObject1).media = new LinkedList();
        }
        localdtf.aaYM = parami.field_originMvInfo;
        localObject1 = localFinderItem.field_clipList;
        if (localObject1 == null) {
          break label233;
        }
        localObject1 = ((dje)localObject1).aaOX;
        if (localObject1 == null) {
          break label233;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bby)((Iterator)localObject1).next();
          localdtf.ZJp.add(((bby)localObject2).ABJ);
        }
        localObject1 = ((dji)localObject1).url;
        if (localObject1 == null)
        {
          localObject1 = "";
          break;
        }
        break;
        String str = ((dji)localObject2).url_token;
        localObject2 = str;
        if (str != null) {
          break label70;
        }
        localObject2 = "";
        break label70;
      }
      label233:
      localdtf.localId = parami.field_localId;
      AppMethodBeat.o(339138);
      return localdtf;
    }
    
    public static i p(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(339124);
      s.u(paramFinderItem, "finderItem");
      i locali = new i();
      locali.field_createTime = paramFinderItem.getCreateTime();
      locali.field_localFlag = 1;
      FinderItem.a locala = FinderItem.Companion;
      locali.field_finderItem = FinderItem.a.r(paramFinderItem);
      locali.field_objectType = 0;
      locali.field_localId = paramFinderItem.getLocalId();
      AppMethodBeat.o(339124);
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.i
 * JD-Core Version:    0.7.0.1
 */