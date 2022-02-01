package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedLikedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "likeBuffer", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class r
  extends com.tencent.mm.ak.a<aoc>
{
  private final FinderItem feedObject;
  private final b lastBuffer;
  private final b likeBuffer;
  private final int scene;
  
  public r(FinderItem paramFinderItem, int paramInt, b paramb1, b paramb2)
  {
    AppMethodBeat.i(201496);
    this.feedObject = paramFinderItem;
    this.scene = paramInt;
    this.lastBuffer = paramb1;
    this.likeBuffer = paramb2;
    paramFinderItem = new b.a();
    paramb1 = new aob();
    paramb1.sbR = this.feedObject.field_username;
    paramb1.scene = this.scene;
    paramb1.lastBuffer = this.lastBuffer;
    paramb1.rRn = this.feedObject.field_id;
    paramb1.objectNonceId = this.feedObject.getObjectNonceId();
    paramb1.likeBuffer = this.likeBuffer;
    paramb2 = v.rRb;
    paramb1.GEg = v.czz();
    paramFinderItem.c((com.tencent.mm.bw.a)paramb1);
    paramb1 = new aoc();
    paramb1.setBaseResponse(new BaseResponse());
    paramb1.getBaseResponse().ErrMsg = new cxn();
    paramFinderItem.d((com.tencent.mm.bw.a)paramb1);
    paramFinderItem.DN("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
    paramFinderItem.oS(3593);
    c(paramFinderItem.aDS());
    paramFinderItem = new StringBuilder("CgiGetFinderFeedLikedList init finderUsername=").append(this.feedObject.field_username).append(" scene=").append(this.scene).append(" lastBuffer=");
    if (this.lastBuffer != null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("Finder.CgiGetFinderFeedLikedList", bool);
      AppMethodBeat.o(201496);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.r
 * JD-Core Version:    0.7.0.1
 */