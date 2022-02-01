package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedLikedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "likeBuffer", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ah
  extends c<aud>
{
  private final FinderItem feedObject;
  private final b lastBuffer;
  private final b likeBuffer;
  private final int scene;
  
  public ah(FinderItem paramFinderItem, int paramInt, b paramb1, b paramb2)
  {
    AppMethodBeat.i(269112);
    this.feedObject = paramFinderItem;
    this.scene = paramInt;
    this.lastBuffer = paramb1;
    this.likeBuffer = paramb2;
    paramFinderItem = new d.a();
    paramb1 = new auc();
    paramb1.finderUsername = this.feedObject.field_username;
    paramb1.scene = this.scene;
    paramb1.lastBuffer = this.lastBuffer;
    paramb1.xbk = this.feedObject.field_id;
    paramb1.objectNonceId = this.feedObject.getObjectNonceId();
    paramb1.likeBuffer = this.likeBuffer;
    paramb2 = ao.xcj;
    paramb1.SDi = ao.dnO();
    paramFinderItem.c((a)paramb1);
    paramb1 = new aud();
    paramb1.setBaseResponse(new jh());
    paramb1.getBaseResponse().Tef = new eaf();
    paramFinderItem.d((a)paramb1);
    paramFinderItem.TW("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
    paramFinderItem.vD(3593);
    c(paramFinderItem.bgN());
    paramFinderItem = new StringBuilder("CgiGetFinderFeedLikedList init finderUsername=").append(this.feedObject.field_username).append(" scene=").append(this.scene).append(" lastBuffer=");
    if (this.lastBuffer != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.CgiGetFinderFeedLikedList", bool);
      AppMethodBeat.o(269112);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ah
 * JD-Core Version:    0.7.0.1
 */