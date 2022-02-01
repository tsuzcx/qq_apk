package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedLikedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "likeBuffer", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class r
  extends com.tencent.mm.al.a<anp>
{
  private final FinderItem feedObject;
  private final b lastBuffer;
  private final b likeBuffer;
  private final int scene;
  
  public r(FinderItem paramFinderItem, int paramInt, b paramb1, b paramb2)
  {
    AppMethodBeat.i(201078);
    this.feedObject = paramFinderItem;
    this.scene = paramInt;
    this.lastBuffer = paramb1;
    this.likeBuffer = paramb2;
    paramFinderItem = new b.a();
    paramb1 = new ano();
    paramb1.rTn = this.feedObject.field_username;
    paramb1.scene = this.scene;
    paramb1.lastBuffer = this.lastBuffer;
    paramb1.rIZ = this.feedObject.field_id;
    paramb1.objectNonceId = this.feedObject.getObjectNonceId();
    paramb1.likeBuffer = this.likeBuffer;
    paramb2 = v.rIR;
    paramb1.Gle = v.cxY();
    paramFinderItem.c((com.tencent.mm.bx.a)paramb1);
    paramb1 = new anp();
    paramb1.setBaseResponse(new BaseResponse());
    paramb1.getBaseResponse().ErrMsg = new cwt();
    paramFinderItem.d((com.tencent.mm.bx.a)paramb1);
    paramFinderItem.Dl("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
    paramFinderItem.oP(3593);
    c(paramFinderItem.aDC());
    paramFinderItem = new StringBuilder("CgiGetFinderFeedLikedList init finderUsername=").append(this.feedObject.field_username).append(" scene=").append(this.scene).append(" lastBuffer=");
    if (this.lastBuffer != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("Finder.CgiGetFinderFeedLikedList", bool);
      AppMethodBeat.o(201078);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.r
 * JD-Core Version:    0.7.0.1
 */