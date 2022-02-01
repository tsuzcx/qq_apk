package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedLikedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ILcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class n
  extends com.tencent.mm.ak.a<ako>
{
  private final FinderItem feedObject;
  private final b lastBuffer;
  private final int scene;
  
  public n(FinderItem paramFinderItem, int paramInt, b paramb)
  {
    AppMethodBeat.i(201143);
    this.feedObject = paramFinderItem;
    this.scene = paramInt;
    this.lastBuffer = paramb;
    paramFinderItem = new b.a();
    paramb = new akn();
    paramb.rfC = this.feedObject.field_username;
    paramb.scene = this.scene;
    paramb.lastBuffer = this.lastBuffer;
    paramb.qXP = this.feedObject.field_id;
    paramb.objectNonceId = this.feedObject.getObjectNonceId();
    paramb.EDu = new aiu();
    aiu localaiu = paramb.EDu;
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    localaiu.EDy = locale.agA().getInt(ah.a.GVw, 0);
    paramFinderItem.c((com.tencent.mm.bw.a)paramb);
    paramb = new ako();
    paramb.setBaseResponse(new BaseResponse());
    paramb.getBaseResponse().ErrMsg = new crm();
    paramFinderItem.d((com.tencent.mm.bw.a)paramb);
    paramFinderItem.Am("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
    paramFinderItem.op(3593);
    c(paramFinderItem.aAz());
    paramFinderItem = new StringBuilder("CgiGetFinderFeedLikedList init finderUsername=").append(this.feedObject.field_username).append(" scene=").append(this.scene).append(" lastBuffer=");
    if (this.lastBuffer != null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("Finder.CgiGetFinderFeedLikedList", bool);
      AppMethodBeat.o(201143);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.n
 * JD-Core Version:    0.7.0.1
 */