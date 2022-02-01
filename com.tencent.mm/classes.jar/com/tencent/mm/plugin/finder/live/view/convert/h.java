package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.j;
import com.tencent.mm.protocal.protobuf.bkz;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/PromoteRedPacketItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/IFinderLivePromoteData;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoRedPacketCover;", "data", "(Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoRedPacketCover;)V", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoRedPacketCover;", "setData", "extBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getExtBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setExtBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "hasReceived", "", "getHasReceived", "()Z", "setHasReceived", "(Z)V", "jumpId", "", "getJumpId", "()Ljava/lang/String;", "setJumpId", "(Ljava/lang/String;)V", "mPromoteId", "", "getMPromoteId", "()J", "setMPromoteId", "(J)V", "needJump", "getNeedJump", "setNeedJump", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getExBuf", "getItemId", "getItemType", "getPromoteData", "getPromoteId", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements cc, j<bkz>
{
  public long DUI;
  public b DUJ;
  public bkz DUM;
  public String DUN;
  public boolean hPp;
  
  public h(bkz parambkz)
  {
    AppMethodBeat.i(358215);
    this.DUM = parambkz;
    this.DUN = "";
    AppMethodBeat.o(358215);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(358236);
    s.u(paramk, "obj");
    AppMethodBeat.o(358236);
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
    AppMethodBeat.i(358228);
    long l = this.DUM.hashCode();
    AppMethodBeat.o(358228);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.h
 * JD-Core Version:    0.7.0.1
 */