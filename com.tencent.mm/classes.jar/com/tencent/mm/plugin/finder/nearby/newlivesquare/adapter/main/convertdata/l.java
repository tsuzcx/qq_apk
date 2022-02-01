package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bna;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/RelatedLivingOfLiveConvertData;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/LiveConvertData;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "container", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "relateLiving", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "relatedExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRelatedExtInfo;", "extDesc", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderLiveRelatedExtInfo;Ljava/lang/String;)V", "getRelateLiving", "()Ljava/util/List;", "getRelatedExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRelatedExtInfo;", "overrideGetItemTypePlease", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends b
{
  public final List<FinderObject> BbK;
  public final blx BbL;
  
  public l(FinderItem paramFinderItem, bna parambna, List<? extends FinderObject> paramList, blx paramblx, String paramString)
  {
    super(paramFinderItem, parambna, paramString);
    AppMethodBeat.i(340362);
    this.BbK = paramList;
    this.BbL = paramblx;
    AppMethodBeat.o(340362);
  }
  
  public final int eFQ()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.l
 * JD-Core Version:    0.7.0.1
 */