package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.j;
import com.tencent.mm.protocal.protobuf.bky;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/PromoteLiveWeComItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/IFinderLivePromoteData;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoListWecomContact;", "data", "(Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoListWecomContact;)V", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoListWecomContact;", "extBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getExtBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setExtBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "mPromoteId", "", "getMPromoteId", "()J", "setMPromoteId", "(J)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getExBuf", "getItemId", "getItemType", "getPromoteData", "getPromoteId", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements cc, j<bky>
{
  public long DUI;
  public b DUJ;
  public final bky DUL;
  
  public g(bky parambky)
  {
    AppMethodBeat.i(358219);
    this.DUL = parambky;
    AppMethodBeat.o(358219);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(358239);
    s.u(paramk, "obj");
    AppMethodBeat.o(358239);
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
    AppMethodBeat.i(358230);
    long l = this.DUL.hashCode();
    AppMethodBeat.o(358230);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.g
 * JD-Core Version:    0.7.0.1
 */