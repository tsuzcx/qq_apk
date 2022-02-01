package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.j;
import com.tencent.mm.protocal.protobuf.bkx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/PromoteLiveMpArticleItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/IFinderLivePromoteData;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoListMpArticleInfo;", "promoteBuf", "(Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoListMpArticleInfo;)V", "extBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getExtBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setExtBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "mPromoteId", "", "getMPromoteId", "()J", "setMPromoteId", "(J)V", "getPromoteBuf", "()Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoListMpArticleInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getExBuf", "getItemId", "getItemType", "getPromoteData", "getPromoteId", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements cc, j<bkx>
{
  public final bkx DUH;
  public long DUI;
  public b DUJ;
  
  public e(bkx parambkx)
  {
    AppMethodBeat.i(358198);
    this.DUH = parambkx;
    AppMethodBeat.o(358198);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(358216);
    s.u(paramk, "obj");
    AppMethodBeat.o(358216);
    return 0;
  }
  
  public final b bUA()
  {
    return this.DUJ;
  }
  
  public final long bUz()
  {
    return this.DUI;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(358209);
    long l = this.DUH.hashCode();
    AppMethodBeat.o(358209);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.e
 * JD-Core Version:    0.7.0.1
 */