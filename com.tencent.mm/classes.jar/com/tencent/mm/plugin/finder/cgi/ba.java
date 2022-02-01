package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedLikedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "likeBuffer", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
  extends com.tencent.mm.am.b<ayv>
{
  private final FinderItem feedObject;
  private final com.tencent.mm.bx.b lastBuffer;
  private final com.tencent.mm.bx.b likeBuffer;
  private final int scene;
  
  public ba(FinderItem paramFinderItem, int paramInt, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2)
  {
    AppMethodBeat.i(336170);
    this.feedObject = paramFinderItem;
    this.scene = paramInt;
    this.lastBuffer = paramb1;
    this.likeBuffer = paramb2;
    paramFinderItem = new c.a();
    paramb1 = new ayu();
    paramb1.finderUsername = this.feedObject.field_username;
    paramb1.scene = this.scene;
    paramb1.lastBuffer = this.lastBuffer;
    paramb1.hKN = this.feedObject.field_id;
    paramb1.objectNonceId = this.feedObject.getObjectNonceId();
    paramb1.likeBuffer = this.likeBuffer;
    paramb2 = bi.ABn;
    paramb1.ZEc = bi.dVu();
    paramFinderItem.otE = ((a)paramb1);
    paramb1 = new ayv();
    paramb1.setBaseResponse(new kd());
    paramb1.getBaseResponse().akjO = new etl();
    paramFinderItem.otF = ((a)paramb1);
    paramFinderItem.uri = "/cgi-bin/micromsg-bin/findergetfeedlikedlist";
    paramFinderItem.funcId = 3593;
    c(paramFinderItem.bEF());
    paramFinderItem = new StringBuilder("CgiGetFinderFeedLikedList init finderUsername=").append(this.feedObject.field_username).append(" scene=").append(this.scene).append(" lastBuffer=");
    if (this.lastBuffer != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.CgiGetFinderFeedLikedList", bool);
      AppMethodBeat.o(336170);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ba
 * JD-Core Version:    0.7.0.1
 */