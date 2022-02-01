package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;", "", "data", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;)V", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "sideBarLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getSideBarLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setSideBarLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "sideBarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lkotlin/collections/ArrayList;", "getSideBarList", "()Ljava/util/ArrayList;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final ArrayList<f> CDA;
  public com.tencent.mm.bx.b CDB;
  public final FinderJumpInfo CDz;
  public boolean hasMore;
  
  public b(FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(359267);
    this.CDz = paramFinderJumpInfo;
    this.CDA = new ArrayList();
    AppMethodBeat.o(359267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.b
 * JD-Core Version:    0.7.0.1
 */