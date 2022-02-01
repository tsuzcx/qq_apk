package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedLikedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "likeBuffer", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ag
  extends c<asc>
{
  private final FinderItem feedObject;
  private final b lastBuffer;
  private final b likeBuffer;
  private final int scene;
  
  public ag(FinderItem paramFinderItem, int paramInt, b paramb1, b paramb2)
  {
    AppMethodBeat.i(242303);
    this.feedObject = paramFinderItem;
    this.scene = paramInt;
    this.lastBuffer = paramb1;
    this.likeBuffer = paramb2;
    paramFinderItem = new d.a();
    paramb1 = new asb();
    paramb1.finderUsername = this.feedObject.field_username;
    paramb1.scene = this.scene;
    paramb1.lastBuffer = this.lastBuffer;
    paramb1.hFK = this.feedObject.field_id;
    paramb1.objectNonceId = this.feedObject.getObjectNonceId();
    paramb1.likeBuffer = this.likeBuffer;
    paramb2 = am.tuw;
    paramb1.LAI = am.cXY();
    paramFinderItem.c((a)paramb1);
    paramb1 = new asc();
    paramb1.setBaseResponse(new BaseResponse());
    paramb1.getBaseResponse().ErrMsg = new dqi();
    paramFinderItem.d((a)paramb1);
    paramFinderItem.MB("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
    paramFinderItem.sG(3593);
    c(paramFinderItem.aXF());
    paramFinderItem = new StringBuilder("CgiGetFinderFeedLikedList init finderUsername=").append(this.feedObject.field_username).append(" scene=").append(this.scene).append(" lastBuffer=");
    if (this.lastBuffer != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.CgiGetFinderFeedLikedList", bool);
      AppMethodBeat.o(242303);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ag
 * JD-Core Version:    0.7.0.1
 */