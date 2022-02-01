package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class k$h
  extends r<aoe>
{
  final aod qXr;
  
  k$h()
  {
    AppMethodBeat.i(201120);
    this.qXr = new aod();
    k.a((k)localObject1, this.qXr);
    k.b((k)localObject1, this.qXr);
    k.c((k)localObject1, this.qXr);
    k.d((k)localObject1, this.qXr);
    Object localObject2 = new b.a();
    ((b.a)localObject2).c((a)this.qXr);
    ((b.a)localObject2).d((a)k.csg());
    ((b.a)localObject2).Am("/cgi-bin/micromsg-bin/finderstream");
    ((b.a)localObject2).op(3901);
    localObject2 = ((b.a)localObject2).aAz();
    StringBuilder localStringBuilder = new StringBuilder("[CgiFetchFinderTimeline#init] tabType=").append(k.c((k)localObject1)).append(" pullType=").append(k.d((k)localObject1)).append(" lastBuffer=").append(this.qXr.lastBuffer.size()).append(", ");
    if (this.qXr.lastBuffer == null)
    {
      localObject1 = "null";
      ac.i("Finder.FinderStream", (String)localObject1 + " longitude=" + this.qXr.doB + " latitude=" + this.qXr.dmL);
      c((com.tencent.mm.ak.b)localObject2);
      AppMethodBeat.o(201120);
      return;
    }
    Object localObject1 = this.qXr.lastBuffer;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).getBytes();; localObject1 = null)
    {
      localObject1 = ah.B((byte[])localObject1);
      break;
    }
  }
  
  public final boolean csf()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k.h
 * JD-Core Version:    0.7.0.1
 */