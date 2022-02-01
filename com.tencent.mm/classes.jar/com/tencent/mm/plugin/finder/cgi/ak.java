package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dyr;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedLikedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ILcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ak
  extends com.tencent.mm.al.a<dys>
{
  private final FinderItem feedObject;
  private final b lastBuffer;
  private final int scene;
  
  public ak(FinderItem paramFinderItem, int paramInt, b paramb)
  {
    AppMethodBeat.i(197266);
    this.feedObject = paramFinderItem;
    this.scene = paramInt;
    this.lastBuffer = paramb;
    paramFinderItem = new b.a();
    paramb = new dyr();
    paramb.finderUsername = this.feedObject.field_username;
    paramb.scene = this.scene;
    paramb.lastBuffer = this.lastBuffer;
    paramb.objectId = this.feedObject.field_id;
    paramb.objectNonceId = this.feedObject.getObjectNonceId();
    paramb.DlF = new aht();
    aht localaht = paramb.DlF;
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    localaht.Dko = locale.afk().getInt(ae.a.Fxg, 0);
    paramFinderItem.c((com.tencent.mm.bx.a)paramb);
    paramb = new dys();
    paramb.setBaseResponse(new BaseResponse());
    paramb.getBaseResponse().ErrMsg = new cmf();
    paramFinderItem.d((com.tencent.mm.bx.a)paramb);
    paramFinderItem.wg("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
    paramFinderItem.nB(3593);
    c(paramFinderItem.atI());
    paramFinderItem = new StringBuilder("CgiGetFinderFeedLikedList init finderUsername=").append(this.feedObject.field_username).append(" scene=").append(this.scene).append(" lastBuffer=");
    if (this.lastBuffer != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("Finder.CgiGetFinderFeedLikedList", bool);
      AppMethodBeat.o(197266);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ak
 * JD-Core Version:    0.7.0.1
 */